/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.scenario.editor.embeddededitor.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.sequence.SequenceDDiagram;
import org.eclipse.sirius.diagram.sequence.business.internal.operation.SynchronizeGraphicalOrderingOperation;
import org.eclipse.sirius.diagram.ui.business.internal.operation.AbstractModelChangeOperation;
import org.eclipse.sirius.viewpoint.description.AnnotationEntry;
import org.eclipse.xtext.resource.XtextResource;
import org.polarsys.capella.common.data.modellingcore.AbstractNamedElement;
import org.polarsys.capella.common.data.modellingcore.AbstractType;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.epbs.ConfigurationItem;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.helpers.interaction.services.ExecutionEndExt;
import org.polarsys.capella.core.data.information.AbstractEventOperation;
import org.polarsys.capella.core.data.information.AbstractInstance;
import org.polarsys.capella.core.data.interaction.EventReceiptOperation;
import org.polarsys.capella.core.data.interaction.EventSentOperation;
import org.polarsys.capella.core.data.interaction.Execution;
import org.polarsys.capella.core.data.interaction.ExecutionEnd;
import org.polarsys.capella.core.data.interaction.ExecutionEvent;
import org.polarsys.capella.core.data.interaction.InstanceRole;
import org.polarsys.capella.core.data.interaction.InteractionFactory;
import org.polarsys.capella.core.data.interaction.InteractionFragment;
import org.polarsys.capella.core.data.interaction.MessageEnd;
import org.polarsys.capella.core.data.interaction.MessageKind;
import org.polarsys.capella.core.data.interaction.Scenario;
import org.polarsys.capella.core.data.interaction.SequenceMessage;
import org.polarsys.capella.core.data.interaction.properties.dialogs.sequenceMessage.model.SelectInvokedOperationModelForSharedDataAndEvent;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.core.data.oa.OperationalActivity;
import org.polarsys.capella.core.data.oa.Role;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.sirius.analysis.SequenceDiagramServices;
import org.polarsys.capella.scenario.editor.EmbeddedEditorInstance;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ParticipantDeactivation;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.TextualScenarioFactory;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.impl.TextualScenarioFactoryImpl;
import org.polarsys.capella.scenario.editor.dsl.ui.provider.TextualScenarioProvider;
import org.polarsys.capella.scenario.editor.embeddededitor.views.EmbeddedEditorView;
import org.polarsys.capella.scenario.editor.helper.DslConstants;
import org.polarsys.capella.scenario.editor.helper.EmbeddedEditorInstanceHelper;

public class XtextEditorCommands {
  public static void xtextToDiagram(Scenario scenario, EmbeddedEditorView embeddedEditorViewPart) {
    if (embeddedEditorViewPart != null) {
      TextualScenarioProvider p = embeddedEditorViewPart.getProvider();
      XtextResource resource = p.getResource();
      EList<EObject> content = resource.getContents();

      Model domainModel = (Model) content.get(0);
      // get participants
      EList<Participant> participants = domainModel.getParticipants();

      // get messages
      EList<EObject> messages = domainModel.getMessagesOrReferences();

      // Project project;
      BlockArchitecture blockArchitecture = BlockArchitectureExt.getRootBlockArchitecture(scenario);

      doEditingOnParticipants(scenario, blockArchitecture, participants);

      doEditingOnMessages(scenario, blockArchitecture, messages);
    }
  }

  private static void doEditingOnParticipants(Scenario scenario, BlockArchitecture blockArchitecture,
      EList<Participant> participants) {
    // Make sure your element is attached to a resource, otherwise this will return null
    TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(scenario);
    domain.getCommandStack().execute(new RecordingCommand(domain) {

      @Override
      protected void doExecute() {
        InstanceRole instanceRole;
        EList<InstanceRole> instanceRoles = scenario.getOwnedInstanceRoles();

        for (Iterator<Participant> iterator = participants.iterator(); iterator.hasNext();) {
          EObject participant = iterator.next();

          String instanceName = ((Participant) participant).getName();
          // if the participant doesn't exist, create it
          if (instanceRoles.stream().filter(ir -> ir.getName().equals(instanceName)).collect(Collectors.toList())
              .size() == 0) {
            instanceRole = InteractionFactory.eINSTANCE.createInstanceRole();
            instanceRole.setName(instanceName);

            String keyword = ((Participant) participant).getKeyword();

            EObject capellaParticipant = null;

            List<? extends EObject> capellaParticipants = EmbeddedEditorInstanceHelper.getAvailableElements(keyword)
                .stream().filter(f -> ((AbstractInstance) f).getName().equals(instanceName))
                .collect(Collectors.toList());
            if (capellaParticipants.size() > 0) {
              capellaParticipant = capellaParticipants.get(0);
            }

            instanceRole.setRepresentedInstance((AbstractInstance) capellaParticipant);
            instanceRoles.add(instanceRole);
          }
        }

        removeParticipantsFromDiagram(instanceRoles, participants);

        if (reorderParticipants(instanceRoles, participants)) {
          syncGraphicalOrdering();
        }
      }
    });
  }

  /**
   * If a participant is in diagram, but not in editor, delete it
   * 
   * @param instanceRoles
   *          Instance roles from diagram
   * @param participants
   *          Participants from editor
   */
  private static void removeParticipantsFromDiagram(List<InstanceRole> instanceRoles, EList<Participant> participants) {
    List<InstanceRole> irToRemove = new ArrayList<InstanceRole>();
    for (InstanceRole ir : instanceRoles) {
      List<String> participantsName = participants.stream().map(x -> x.getName()).collect(Collectors.toList());
      if (!participantsName.contains(ir.getName())) {
        irToRemove.add(ir);
      }
    }
    for (InstanceRole ir : irToRemove) {
      instanceRoles.remove(ir);
    }
  }

  /**
   * Switch participants in diagram if they are not in the same order as they are in editor
   * 
   * @param instanceRoles
   *          Instance roles from diagram
   * @param participants
   *          Participant from editor
   * @return true if the order was changed, false if not
   */
  private static boolean reorderParticipants(List<InstanceRole> instanceRoles, EList<Participant> participants) {
    boolean updateNeeded = false;
    for (int i = 0; i < instanceRoles.size(); i++) {
      if (!instanceRoles.get(i).getName().equals(participants.get(i).getName())) {
        for (int j = 0; j < participants.size(); j++) {
          if (instanceRoles.get(i).getName().equals(participants.get(j).getName())) {
            ((EList<InstanceRole>) instanceRoles).move(j, instanceRoles.get(i));
            updateNeeded = true;
          }
        }
      }
    }
    return updateNeeded;
  }

  /**
   * Synchronize graphical ordering in diagram
   */
  private static void syncGraphicalOrdering() {
    DDiagram dDiagram = EmbeddedEditorInstance.getDDiagram();
    ((SequenceDDiagram) dDiagram).getTarget();
    EList<AnnotationEntry> ownedAnnotationEntries = dDiagram.getOwnedAnnotationEntries();
    EObject data = null;
    for (AnnotationEntry annotationEntry : ownedAnnotationEntries) {
      if ((annotationEntry != null) && (annotationEntry.getData() instanceof Diagram)) {
        data = annotationEntry.getData();
      }
    }
    AbstractModelChangeOperation<Boolean> synchronizeGraphicalOrderingOperation = new SynchronizeGraphicalOrderingOperation(
        (Diagram) data, true);
    synchronizeGraphicalOrderingOperation.execute();
  }

  private static void doEditingOnMessages(Scenario scenario, BlockArchitecture blockArchitecture,
      EList<EObject> messages) {
    // Make sure your element is attached to a resource, otherwise this will return null
    TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(scenario);
    domain.getCommandStack().execute(new RecordingCommand(domain) {

      @Override
      protected void doExecute() {
        // Implement your write operations here,
        // for example: set a new name
        // element.eSet(element.eClass().getEStructuralFeature("name"), "aNewName");

        SequenceMessage sequenceMessage;
        EList<SequenceMessage> sequenceMessages = scenario.getOwnedMessages();
        ArrayList<InteractionFragment> executionEndsToProcess = new ArrayList<InteractionFragment>();

        for (Iterator<EObject> iterator = messages.iterator(); iterator.hasNext();) {
          EObject messageFromXtext = iterator.next();

          if (messageFromXtext instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) {

            org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage seqMessage = (org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) messageFromXtext;
            InstanceRole source = EmbeddedEditorInstanceHelper.getInstanceRole(seqMessage.getSource());
            InstanceRole target = EmbeddedEditorInstanceHelper.getInstanceRole(seqMessage.getTarget());
            if (source != null && target != null) {
              // create Capella SequenceMessage
              sequenceMessage = InteractionFactory.eINSTANCE.createSequenceMessage();
              sequenceMessage.setName(seqMessage.getName());
              sequenceMessage.setKind(MessageKind.ASYNCHRONOUS_CALL);

              // sending end
              MessageEnd sendingEnd = InteractionFactory.eINSTANCE.createMessageEnd();
              sendingEnd.getCoveredInstanceRoles().add(source);
              sequenceMessage.setSendingEnd(sendingEnd);
              scenario.getOwnedInteractionFragments().add(sendingEnd);

              // receiving end
              MessageEnd receivingEnd = InteractionFactory.eINSTANCE.createMessageEnd();
              receivingEnd.getCoveredInstanceRoles().add(target);
              sequenceMessage.setReceivingEnd(receivingEnd);
              scenario.getOwnedInteractionFragments().add(receivingEnd);

              // execution end
              ExecutionEnd executionEnd = InteractionFactory.eINSTANCE.createExecutionEnd();
              scenario.getOwnedInteractionFragments().add(executionEnd);
              executionEnd.getCoveredInstanceRoles().add(receivingEnd.getCoveredInstanceRoles().get(0));
              // Adding this execution end to executionEndsToProcess list.
              // We want to keep the order between interaction fragments consistent with the order in xtext scenario.
              // To achieve this, the execution end will be processed when a corresponding "deactivate" message
              // will be encountered in the xtext scenario.
              // At that point, the execution end will be moved at its proper place in the ownedInteractionFragments
              // list
              // of the Capella scenario.
              executionEndsToProcess.add(executionEnd);

              // execution
              Execution execution = InteractionFactory.eINSTANCE.createExecution();
              execution.setFinish(executionEnd);
              execution.setStart(receivingEnd);
              scenario.getOwnedTimeLapses().add(execution);

              // EventSentOperation
              EventSentOperation eventSentOperation = InteractionFactory.eINSTANCE.createEventSentOperation();
              scenario.getOwnedEvents().add(eventSentOperation);
              sendingEnd.setEvent(eventSentOperation);

              // EventReceiptOperation
              EventReceiptOperation eventRecvOperation = InteractionFactory.eINSTANCE.createEventReceiptOperation();
              scenario.getOwnedEvents().add(eventRecvOperation);
              receivingEnd.setEvent(eventRecvOperation);

              // execution event
              ExecutionEvent executionEvent = InteractionFactory.eINSTANCE.createExecutionEvent();
              executionEnd.setEvent(executionEvent);
              scenario.getOwnedEvents().add(executionEvent);

              // get operation by name from the list of available exchanges
              List<CapellaElement> exchanges = SelectInvokedOperationModelForSharedDataAndEvent
                  .getAvailableExchangeItems(source, target, false);
              exchanges.stream().filter(ex -> ((AbstractNamedElement) ex).getName().equals(seqMessage.getName()));
              if (!exchanges.isEmpty()) {
                eventRecvOperation.setOperation((AbstractEventOperation) exchanges.get(0));
                eventSentOperation.setOperation((AbstractEventOperation) exchanges.get(0));
              }

              if (seqMessage.getExecution() == null) {
                doDeactivationSequenceMessage(scenario, target, executionEndsToProcess);
              }
              sequenceMessages.add(sequenceMessage);
            }
          } else {
            // This is a ParticipantDeactivationMessage, this means that the execution on the corresponding timeline
            // finished.
            // We must move the interaction fragment representing the execution end on the correct position in the
            // ownedInteractionFragments ordered list
            ParticipantDeactivation participantDeactivationMessage = (ParticipantDeactivation) messageFromXtext;

            // find the timeline (instance role) of the execution that has to end. Search by participant name
            InstanceRole instanceRole = EmbeddedEditorInstanceHelper
                .getInstanceRole(participantDeactivationMessage.getName());

            doDeactivationSequenceMessage(scenario, instanceRole, executionEndsToProcess);
          }
        }
      }
    });
  }

  private static void doDeactivationSequenceMessage(Scenario scenario, InstanceRole instanceRole,
      ArrayList<InteractionFragment> executionEndsToProcess) {
    // search in the executionEndsToProcess list the last execution started on this timeline (instance role)
    EList<InteractionFragment> fragments = scenario.getOwnedInteractionFragments();
    InteractionFragment executionEnd = executionEndsToProcess.stream()
        .filter(e -> e.getCoveredInstanceRoles().get(0).getName().equals(instanceRole.getName()))
        .reduce((first, second) -> second).orElse(null);

    // move execution end at the end of the interaction fragments list, then remove it from the processing list
    if (executionEnd != null) {
      fragments.move(fragments.size() - 1, executionEnd);
      executionEndsToProcess.remove(executionEnd);
    }
  }

  /**
   * updates the xtext editor with data from the Capella model
   * 
   * @param scenario
   * @param embeddedEditorViewPart
   * @return
   */
  public static void diagramToXtext(Scenario scenario, EmbeddedEditorView embeddedEditorViewPart) {
    if (embeddedEditorViewPart != null) {
      TextualScenarioProvider textualScenarioProvider = embeddedEditorViewPart.getProvider();
      XtextResource resource = textualScenarioProvider.getResource();
      EList<EObject> content = resource.getContents();

      TextualScenarioFactory factory = new TextualScenarioFactoryImpl();
      Model domainModel = getModel(embeddedEditorViewPart);
      if (domainModel != null) {
        clearModel(domainModel);

        // Generate Participants
        generateActors(domainModel, scenario, factory);

        // Generate Sequence Messages
        generateSequenceMessages(domainModel, scenario, factory);

        content.add(domainModel);

        String serialized = ((XtextResource) domainModel.eResource()).getSerializer().serialize(domainModel);
        EmbeddedEditorInstance.geteEditor().getDocument().set(serialized);
      }
    }
  }

  private static void generateActors(Model domainModel, Scenario scenario, TextualScenarioFactory factory) {
    // get all instance roles (actors) from diagram
    EList<InstanceRole> instanceRoleList = scenario.getOwnedInstanceRoles();

    // get all participants/actors from editor
    EList<Participant> participants = domainModel.getParticipants();

    // remove all participants
    participants.clear();

    // recreate the list of participants
    for (InstanceRole a : instanceRoleList) {
      String id = a.getId();
      AbstractType irType = a.getRepresentedInstance().getAbstractType();

      if (irType != null) {
        if (irType instanceof Entity) {
          if (((Entity) irType).isActor()) {
            addActor(a.getName(), id, participants, factory);
          } else {
            addEntity(a.getName(), id, participants, factory);
          }
        } else if (irType instanceof ConfigurationItem) {
          addConfigItem(a.getName(), id, participants, factory);
        } else if (irType instanceof Component) {
          if (((Component) irType).isActor()) {
            addActor(a.getName(), id, participants, factory);
          } else {
            addComponent(a.getName(), id, participants, factory);
          }
        }
      } else {
        if (a.getRepresentedInstance() instanceof OperationalActivity) {
          addActivity(a.getName(), id, participants, factory);
        } else if (a.getRepresentedInstance() instanceof Role) {
          addRole(a.getName(), id, participants, factory);
        } else if (a.getRepresentedInstance() instanceof AbstractFunction) {
          addFunction(a.getName(), id, participants, factory);
        }
      }
    }

  }

  private static void addActor(String name, String id, EList<Participant> participants,
      TextualScenarioFactory factory) {
    org.polarsys.capella.scenario.editor.dsl.textualScenario.Actor actor = factory.createActor();
    actor.setName(name);
    actor.setKeyword(DslConstants.ACTOR);
    participants.add(actor);
  }

  private static void addActivity(String name, String id, EList<Participant> participants,
      TextualScenarioFactory factory) {
    org.polarsys.capella.scenario.editor.dsl.textualScenario.Activity activity = factory.createActivity();
    activity.setName(name);
    activity.setKeyword(DslConstants.ACTIVITY);
    participants.add(activity);
  }

  private static void addComponent(String name, String id, EList<Participant> participants,
      TextualScenarioFactory factory) {
    org.polarsys.capella.scenario.editor.dsl.textualScenario.Component component = factory.createComponent();
    component.setName(name);
    component.setKeyword(DslConstants.COMPONENT);
    participants.add(component);
  }

  private static void addEntity(String name, String id, EList<Participant> participants,
      TextualScenarioFactory factory) {
    org.polarsys.capella.scenario.editor.dsl.textualScenario.Entity entity = factory.createEntity();
    entity.setName(name);
    entity.setKeyword(DslConstants.ENTITY);
    participants.add(entity);
  }

  private static void addConfigItem(String name, String id, EList<Participant> participants,
      TextualScenarioFactory factory) {
    org.polarsys.capella.scenario.editor.dsl.textualScenario.ConfigurationItem configItem = factory
        .createConfigurationItem();
    configItem.setName(name);
    configItem.setKeyword(DslConstants.CONFIGURATION_ITEM);
    participants.add(configItem);
  }

  private static void addFunction(String name, String id, EList<Participant> participants,
      TextualScenarioFactory factory) {
    org.polarsys.capella.scenario.editor.dsl.textualScenario.Function function = factory.createFunction();
    function.setName(name);
    function.setKeyword(DslConstants.FUNCTION);
    participants.add(function);
  }

  private static void addRole(String name, String id, EList<Participant> participants, TextualScenarioFactory factory) {
    org.polarsys.capella.scenario.editor.dsl.textualScenario.Role role = factory.createRole();
    role.setName(name);
    role.setKeyword(DslConstants.ROLE);
    participants.add(role);
  }

  private static void generateSequenceMessages(Model domainModel, Scenario scenario, TextualScenarioFactory factory) {
    EList<EObject> messagesOrReferences = domainModel.getMessagesOrReferences();

    List<InteractionFragment> fragments = SequenceDiagramServices.getOrderedInteractionFragments(scenario);
    Object[] ends = fragments.toArray();

    // The list of fragments contains both ends of each sequence message (sender and receiver)
    // and only one end of each execution (the one where execution ends). This means that we should skip
    // the receiving end for each message, so that we don't duplicate the generated xtext message.
    int i = 0;
    Stack<org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage> messagesToDeactivate = new Stack();
    while (i < ends.length) {
      if (ends[i] instanceof MessageEnd) {
        EObject message = copyMessageFromMsgEnd(ends[i], factory);
        messagesOrReferences.add(message);
        // skip the next MessageEnd (the receiving end), as it will generate the same xtext message
        i = i + 2;
        if (ends[i] instanceof ExecutionEnd) {
          // sikp generating deactivate keyword if we have a simple message
          i = i + 1;
        } else if (message instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) {
          messagesToDeactivate.push((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) message);
        }
      } else {
        EObject participantDeactivateMsg = getParticipantDeactivationMsgFromExecutionEnd(ends[i], factory);
        messagesOrReferences.add(participantDeactivateMsg);

        if (!messagesToDeactivate.isEmpty()) {
          org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage currentSequenceMessage = messagesToDeactivate
              .pop();
          currentSequenceMessage.setExecution(DslConstants.WITH_EXECUTION);
        }
        i = i + 1;
      }
    }
  }

  /**
   * generates the ParticipantDeactivation message with input from the ExecutionEnd in the Capella diagram
   * 
   * @param object
   *          - this is the ExecutionEnd
   * @param factory
   *          - this is the factory to create ParticipantDeactivation type of message
   * @return - EObject containing the ParticipantDeactivation message
   */
  private static EObject getParticipantDeactivationMsgFromExecutionEnd(Object object, TextualScenarioFactory factory) {
    ExecutionEnd end = (ExecutionEnd) object;
    SequenceMessage seqMessage = ExecutionEndExt.getMessage(end);
    String timelineToDeactivate = seqMessage.getReceivingEnd().getCoveredInstanceRoles().get(0).getName();

    ParticipantDeactivation participantDeactivationMsg = (ParticipantDeactivation) factory
        .createParticipantDeactivation();
    participantDeactivationMsg.setName(timelineToDeactivate);

    participantDeactivationMsg.setKeyword(DslConstants.DEACTIVATE);
    return participantDeactivationMsg;
  }

  private static EObject copyMessageFromMsgEnd(Object object, TextualScenarioFactory factory) {
    EObject seqMessage;
    MessageEnd end = (MessageEnd) object;
    SequenceMessage sequenceMessage = end.getMessage();

    switch (sequenceMessage.getKind()) {
    case ASYNCHRONOUS_CALL:
      seqMessage = factory.createSequenceMessage();
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) seqMessage)
          .setName(sequenceMessage.getName());
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) seqMessage)
          .setSource(sequenceMessage.getSendingEnd().getCoveredInstanceRoles().get(0).getName());
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) seqMessage)
          .setTarget(sequenceMessage.getReceivingEnd().getCoveredInstanceRoles().get(0).getName());
      break;
    case SYNCHRONOUS_CALL:
      seqMessage = factory.createSequenceMessage();
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) seqMessage)
          .setName(sequenceMessage.getName());
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) seqMessage)
          .setSource(sequenceMessage.getSendingEnd().getCoveredInstanceRoles().get(0).getName());
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) seqMessage)
          .setTarget(sequenceMessage.getReceivingEnd().getCoveredInstanceRoles().get(0).getName());
      break;
    case CREATE:
      seqMessage = factory.createCreateMessage();
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.CreateMessage) seqMessage)
          .setName(sequenceMessage.getName());
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.CreateMessage) seqMessage)
          .setSource(sequenceMessage.getSendingEnd().getCoveredInstanceRoles().get(0).getName());
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.CreateMessage) seqMessage)
          .setTarget(sequenceMessage.getReceivingEnd().getCoveredInstanceRoles().get(0).getName());
      break;
    case DELETE:
      seqMessage = factory.createDeleteMessage();
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.DeleteMessage) seqMessage)
          .setName(sequenceMessage.getName());
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.DeleteMessage) seqMessage)
          .setSource(sequenceMessage.getSendingEnd().getCoveredInstanceRoles().get(0).getName());
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.DeleteMessage) seqMessage)
          .setTarget(sequenceMessage.getReceivingEnd().getCoveredInstanceRoles().get(0).getName());
      break;
    case REPLY:
      seqMessage = factory.createReturnMessage();
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.ReturnMessage) seqMessage)
          .setName(sequenceMessage.getName());
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.ReturnMessage) seqMessage)
          .setSource(sequenceMessage.getSendingEnd().getCoveredInstanceRoles().get(0).getName());
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.ReturnMessage) seqMessage)
          .setTarget(sequenceMessage.getReceivingEnd().getCoveredInstanceRoles().get(0).getName());
      break;
    case TIMER:
      seqMessage = factory.createArmTimerMessage();
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.ArmTimerMessage) seqMessage)
          .setName(sequenceMessage.getName());
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.ArmTimerMessage) seqMessage)
          .setParticipant(sequenceMessage.getSendingEnd().getCoveredInstanceRoles().get(0).getName());
      break;
    default:
      seqMessage = factory.createSequenceMessage();
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) seqMessage)
          .setName(sequenceMessage.getName());
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) seqMessage)
          .setSource(sequenceMessage.getSendingEnd().getCoveredInstanceRoles().get(0).getName());
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) seqMessage)
          .setTarget(sequenceMessage.getReceivingEnd().getCoveredInstanceRoles().get(0).getName());
      break;
    }
    return seqMessage;
  }

  private static Model getModel(EmbeddedEditorView embeddedEditorViewPart) {
    TextualScenarioProvider p = embeddedEditorViewPart.getProvider();
    XtextResource resource = p.getResource();
    EList<EObject> content = resource.getContents();
    Model domainModel = null;
    if (!content.isEmpty() && content.get(0) instanceof Model) {
      domainModel = (Model) resource.getContents().get(0);
    } else {
      EmbeddedEditorInstance.geteEditor().getDocument().set("scenario {}");
      EList<EObject> content1 = resource.getContents();
      if (!content1.isEmpty() && content1.get(0) instanceof Model) {
        domainModel = (Model) resource.getContents().get(0);
      }
    }
    return domainModel;
  }

  private static void clearModel(Model domainModel) {
    if (domainModel != null && domainModel.getParticipants() != null) {
      domainModel.getParticipants().clear();
    }
    if (domainModel != null && domainModel.getMessagesOrReferences() != null) {
      domainModel.getMessagesOrReferences().clear();
    }
  }
}
