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
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.helpers.interaction.services.ExecutionEndExt;
import org.polarsys.capella.core.data.information.AbstractEventOperation;
import org.polarsys.capella.core.data.information.AbstractInstance;
import org.polarsys.capella.core.data.interaction.Event;
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
import org.polarsys.capella.core.data.interaction.TimeLapse;
import org.polarsys.capella.core.data.interaction.properties.dialogs.sequenceMessage.model.SelectInvokedOperationModelForSharedDataAndEvent;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.sirius.analysis.CapellaServices;
import org.polarsys.capella.scenario.editor.EmbeddedEditorInstance;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ParticipantDeactivation;
import org.polarsys.capella.scenario.editor.dsl.ui.provider.TextualScenarioProvider;
import org.polarsys.capella.scenario.editor.embeddededitor.views.EmbeddedEditorView;
import org.polarsys.capella.scenario.editor.helper.EmbeddedEditorInstanceHelper;

public class XtextToDiagramCommands {
  public static void process(Scenario scenario, EmbeddedEditorView embeddedEditorViewPart) {
    if (embeddedEditorViewPart != null) {
      TextualScenarioProvider p = embeddedEditorViewPart.getProvider();
      XtextResource resource = p.getResource();
      EList<EObject> content = resource.getContents();

      Model domainModel = (Model) content.get(0);
      // get participants
      EList<Participant> participants = domainModel.getParticipants();

      // get messages
      EList<EObject> messages = domainModel.getMessagesOrReferences();

      doEditingOnParticipants(scenario, participants);

      doEditingOnMessages(scenario, messages);
    }
  }

  private static void doEditingOnParticipants(Scenario scenario, EList<Participant> participants) {
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

  private static void doEditingOnMessages(Scenario scenario, EList<EObject> messages) {
    // Make sure your element is attached to a resource, otherwise this will return null
    TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(scenario);
    domain.getCommandStack().execute(new RecordingCommand(domain) {

      @Override
      protected void doExecute() {
        cleanUpMessages(scenario, messages);

        EList<SequenceMessage> sequenceMessages = scenario.getOwnedMessages();
        ArrayList<InteractionFragment> executionEndsToProcess = new ArrayList<InteractionFragment>();
        for (Iterator<EObject> iterator = messages.iterator(); iterator.hasNext();) {
          EObject messageFromXtext = iterator.next();

          if (messageFromXtext instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) {
            
            org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage seqMessage = (org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) messageFromXtext;
            InstanceRole source = EmbeddedEditorInstanceHelper.getInstanceRole(seqMessage.getSource());
            InstanceRole target = EmbeddedEditorInstanceHelper.getInstanceRole(seqMessage.getTarget());
            List<SequenceMessage> msgsFilteredByNameTargetSource = sequenceMessages.stream()
                .filter(x -> x.getName().equals(seqMessage.getName()))
                .filter(x -> x.getSendingEnd().getCoveredInstanceRoles().get(0).getName().equals(source.getName()))
                .filter(x -> x.getReceivingEnd().getCoveredInstanceRoles().get(0).getName().equals(target.getName()))
                .collect(Collectors.toList());
            if (msgsFilteredByNameTargetSource.isEmpty()) {
              if (source != null && target != null) {
                SequenceMessage sequenceMessage = createCapellaSequenceMessage(scenario, source, target, seqMessage,
                    executionEndsToProcess);

                sequenceMessages.add(sequenceMessage);
              }
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

            doDeactivationSequenceMessage(scenario.getOwnedInteractionFragments(), instanceRole, executionEndsToProcess);
          }
        }
        
        //Reorder scenario, this means reordering the interaction fragments and sequence messages lists
        reorderCapellaScenario(scenario, messages);
        // refresh visual editor
        syncGraphicalOrdering();
      }

      /**
       * Reorders sequence messages (their start, end and execution end) according to the 
       *   xtext scenario
       * @param scenario
       * @param messages
       */
      private void reorderCapellaScenario(Scenario scenario, EList<EObject> messages) {
        //compose new lists of sequence messages and interaction fragments, ordered based on xtext messages
        ArrayList<SequenceMessage> sequenceMessages = new ArrayList<SequenceMessage>();
        ArrayList<InteractionFragment> interactionFragments = new ArrayList<InteractionFragment>();
        
        ArrayList<InteractionFragment> executionEndsToProcess = new ArrayList<InteractionFragment>();
        for (Iterator<EObject> iterator = messages.iterator(); iterator.hasNext();) {
          EObject messageFromXtext = iterator.next();

          if (messageFromXtext instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) {           
            org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage seqMessage = 
                (org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) messageFromXtext;
            InstanceRole source = EmbeddedEditorInstanceHelper.getInstanceRole(seqMessage.getSource());
            InstanceRole target = EmbeddedEditorInstanceHelper.getInstanceRole(seqMessage.getTarget());

            if (source != null && target != null) {
              SequenceMessage capellaSequenceMessage = getCorrespondingCapellaSequenceMessage(scenario, seqMessage);
              
              // insert message ends in interaction fragments list
              interactionFragments.add(capellaSequenceMessage.getSendingEnd());
              interactionFragments.add(capellaSequenceMessage.getReceivingEnd());
              
              Execution execution = getExecutionForSequenceMessage(scenario, capellaSequenceMessage);
              // For withExecution messages, execution end will be added when deactivate message will be found.
              // For simple messages, execution end will be added here.
              if (seqMessage.getExecution() == null) {      
                interactionFragments.add(execution.getFinish());
              } else {
                executionEndsToProcess.add(execution.getFinish());
              }

              sequenceMessages.add(capellaSequenceMessage);
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

            doDeactivationSequenceMessageForReorder(interactionFragments, instanceRole, executionEndsToProcess);
          }
        }
        
        // Replace sequence message list and interaction fragments list in the real scenario with the newly computed lists
        scenario.getOwnedInteractionFragments().clear();
        scenario.getOwnedInteractionFragments().addAll(interactionFragments);
        
        scenario.getOwnedMessages().clear();
        scenario.getOwnedMessages().addAll(sequenceMessages);
      }
      
    });
  }
  
  private static Execution getExecutionForSequenceMessage(Scenario scenario, SequenceMessage sequenceMessage) {
    Execution execution = null;
    MessageEnd receivingEnd = sequenceMessage.getReceivingEnd();
    for (TimeLapse timeLapse : scenario.getOwnedTimeLapses()) {
      if (timeLapse instanceof Execution) {
        Execution exec = (Execution) timeLapse;
        if (exec.getStart() != null && exec.getStart().equals(receivingEnd)) {
          execution = exec;
        }
      }
    }
    return execution;
  }
  
  private static SequenceMessage getCorrespondingCapellaSequenceMessage(Scenario scenario, 
      org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage seqMessage) {
    EList<SequenceMessage> sequenceMessages = scenario.getOwnedMessages();
    
    for (SequenceMessage sm : sequenceMessages) {
      if (isSameMessage(seqMessage, sm)) {
        return sm;
      }
    }
    return null;
  }
  
  private static void cleanUpMessages(Scenario scenario, EList<EObject> messages) {
    // Delete all diagram messages that don't appear in the xtext scenario

    EList<SequenceMessage> sequenceMessages = scenario.getOwnedMessages();
    List<SequenceMessage> messagesToBeDeleted = 
        sequenceMessages.stream().filter(sm -> !foundMsgInXText(sm, messages)).collect(Collectors.toList());
    
    for (SequenceMessage sequenceMessage : messagesToBeDeleted) {
      // Remove message from Capella scenario, together with execution, interaction fragments and events related to this message
      removeMessageFromScenario(scenario, sequenceMessage);
    }
  }

  private static void removeMessageFromScenario(Scenario scenario, SequenceMessage sequenceMessage) {
    // Remove execution - time lapse
    Execution execution = null;
    MessageEnd re = sequenceMessage.getReceivingEnd();
    for (TimeLapse tl : scenario.getOwnedTimeLapses()) {
      if (tl instanceof Execution) {
        Execution exec = (Execution) tl;
        if (exec.getStart() != null && exec.getStart().equals(re)) {
          execution = exec;
        }
      }
    }
    scenario.getOwnedTimeLapses().remove(execution);
    
    // Remove interaction fragments for sending end, receiving end and execution end
    MessageEnd sendingEnd = sequenceMessage.getSendingEnd();
    MessageEnd receivingEnd = sequenceMessage.getReceivingEnd();
    InteractionFragment executionEnd = execution.getFinish();
    scenario.getOwnedInteractionFragments().remove(sendingEnd);
    scenario.getOwnedInteractionFragments().remove(receivingEnd);
    scenario.getOwnedInteractionFragments().remove(executionEnd);
    
    // Remove events: send, receive, execution
    Event executionEvent = (Event) ExecutionEndExt.getOperation((ExecutionEnd) executionEnd);
    Event eventSendOp = sendingEnd.getEvent();
    Event eventReveivOp = receivingEnd.getEvent();
    scenario.getOwnedEvents().remove(executionEvent);
    scenario.getOwnedEvents().remove(eventSendOp);
    scenario.getOwnedEvents().remove(eventReveivOp);
    
    // Remove sequence message
    scenario.getOwnedMessages().remove(sequenceMessage);
  }

  private static boolean foundMsgInXText(SequenceMessage sm, EList<EObject> messages) {
    for (EObject message : messages) {
      if (isSameMessage(message, sm)) {
        return true;
      }
    }
    return false;
  }

  private static boolean isSameMessage(EObject m, SequenceMessage seqMessage) {
    if (!(m instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage)) {
      return false;
    }
    org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage message = 
        (org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) m;
    if (message.getSource().equals(seqMessage.getSendingEnd().getCoveredInstanceRoles().get(0).getName()) &&
      message.getTarget().equals(seqMessage.getReceivingEnd().getCoveredInstanceRoles().get(0).getName()) &&
      message.getName().equals(seqMessage.getName())) {
      return true;
    }
    return false;
  }

  /*
   * Create a capella sequence message (and set all data needed by a capella sequence message : sending end, receiving
   * end, execution etc
   */
  private static SequenceMessage createCapellaSequenceMessage(Scenario scenario, InstanceRole source,
      InstanceRole target, org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage seqMessage,
      ArrayList<InteractionFragment> executionEndsToProcess) {
    // create Capella SequenceMessage
    SequenceMessage sequenceMessage = InteractionFactory.eINSTANCE.createSequenceMessage();
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
    // Execution end has to be processed only for withExecution messages. Nothing to do for simple messages.
    if (seqMessage.getExecution() != null) {
      executionEndsToProcess.add(executionEnd);
    }

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
    List<CapellaElement> exchanges = SelectInvokedOperationModelForSharedDataAndEvent.getAvailableExchangeItems(source,
        target, false);
    exchanges.stream().filter(ex -> ((AbstractNamedElement) ex).getName().equals(seqMessage.getName()));
    if (!exchanges.isEmpty()) {
      eventRecvOperation.setOperation((AbstractEventOperation) exchanges.get(0));
      eventSentOperation.setOperation((AbstractEventOperation) exchanges.get(0));
    }

    return sequenceMessage;
  }

  private static void doDeactivationSequenceMessage(EList<InteractionFragment> fragments, InstanceRole instanceRole,
      ArrayList<InteractionFragment> executionEndsToProcess) {
    // search in the executionEndsToProcess list the last execution started on this timeline (instance role)
    InteractionFragment executionEnd = getLatestExecutionEndOnTimeline(instanceRole, executionEndsToProcess);

    // move execution end at the end of the interaction fragments list, then remove it from the processing list
    if (executionEnd != null) {
      fragments.move(fragments.size() - 1, executionEnd);
      executionEndsToProcess.remove(executionEnd);
    }
  }
  
  private static void doDeactivationSequenceMessageForReorder(ArrayList<InteractionFragment> fragments,
      InstanceRole instanceRole, ArrayList<InteractionFragment> executionEndsToProcess) {
    InteractionFragment executionEnd = getLatestExecutionEndOnTimeline(instanceRole, executionEndsToProcess);

    // add execution end to the interaction fragments list, then remove it from the processing list
    if (executionEnd != null) {
      fragments.add(executionEnd);
      executionEndsToProcess.remove(executionEnd);
    }
  }
  
  private static InteractionFragment getLatestExecutionEndOnTimeline(InstanceRole instanceRole,
      ArrayList<InteractionFragment> executionEndsToProcess) {
    InteractionFragment executionEnd = executionEndsToProcess.stream()
        .filter(e -> e.getCoveredInstanceRoles().get(0).getName().equals(instanceRole.getName()))
        .reduce((first, second) -> second).orElse(null);
    return executionEnd;
  }
}
