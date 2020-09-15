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

import java.util.List;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.polarsys.capella.common.data.modellingcore.AbstractType;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.epbs.ConfigurationItem;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.helpers.interaction.services.ExecutionEndExt;
import org.polarsys.capella.core.data.interaction.ExecutionEnd;
import org.polarsys.capella.core.data.interaction.InstanceRole;
import org.polarsys.capella.core.data.interaction.InteractionFragment;
import org.polarsys.capella.core.data.interaction.MessageEnd;
import org.polarsys.capella.core.data.interaction.Scenario;
import org.polarsys.capella.core.data.interaction.SequenceMessage;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.core.data.oa.OperationalActivity;
import org.polarsys.capella.core.data.oa.Role;
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

public class DiagramToXtextCommands {
  /**
   * updates the xtext editor with data from the Capella model
   * 
   * @param scenario
   * @param embeddedEditorViewPart
   * @return
   */
  public static void process(Scenario scenario, EmbeddedEditorView embeddedEditorViewPart) {
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
        EmbeddedEditorInstance.getEmbeddedEditor().getDocument().set(serialized);
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
        
        if (i < ends.length && ends[i] instanceof ExecutionEnd) {
          SequenceMessage seqMessFromMessageEnd = ((MessageEnd) ends[i - 2]).getMessage();
          SequenceMessage seqMessFromExecutionEnd = ExecutionEndExt.getMessage((ExecutionEnd) ends[i]);
            
          if (seqMessFromMessageEnd.equals(seqMessFromExecutionEnd)) {
            //nothing to do, skip this execution end
            i = i + 1;
          } else {
            if (message instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) {
              messagesToDeactivate.push((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) message);
            }
          }
        } else {
          if (message instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) {
            messagesToDeactivate.push((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) message);
          }
        }
      } else if (ends[i] instanceof ExecutionEnd) {
        EObject participantDeactivateMsg = getParticipantDeactivationMsgFromExecutionEnd(ends[i], factory);
        messagesOrReferences.add(participantDeactivateMsg);

        if (!messagesToDeactivate.isEmpty()) {
          org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage currentSequenceMessage = messagesToDeactivate
              .pop();
          currentSequenceMessage.setExecution(DslConstants.WITH_EXECUTION);
        }
        i = i + 1;
      } else {
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
    EObject seqMessage = null;
    MessageEnd end = (MessageEnd) object;
    SequenceMessage sequenceMessage = end.getMessage();

    switch (sequenceMessage.getKind()) {
    case ASYNCHRONOUS_CALL:
    case SYNCHRONOUS_CALL:
      seqMessage = factory.createSequenceMessage();
      break;
    case CREATE:
      seqMessage = factory.createCreateMessage();
      break;
    case DELETE:
      seqMessage = factory.createDeleteMessage();
      break;
    case REPLY:
      //seqMessage = factory.createReturnMessage();
      break;
    case TIMER:
      seqMessage = factory.createArmTimerMessage();
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.ArmTimerMessage) seqMessage)
          .setName(sequenceMessage.getName());
      if (sequenceMessage.getSendingEnd() != null
          && !sequenceMessage.getSendingEnd().getCoveredInstanceRoles().isEmpty())
        ((org.polarsys.capella.scenario.editor.dsl.textualScenario.ArmTimerMessage) seqMessage)
            .setParticipant(sequenceMessage.getSendingEnd().getCoveredInstanceRoles().get(0).getName());
      return seqMessage;
    default:
      seqMessage = factory.createSequenceMessage();
      break;
    }
    if (seqMessage != null) {
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) seqMessage)
          .setName(sequenceMessage.getName());
      if (sequenceMessage.getSendingEnd() != null
          && !sequenceMessage.getSendingEnd().getCoveredInstanceRoles().isEmpty())
        ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) seqMessage)
            .setSource(sequenceMessage.getSendingEnd().getCoveredInstanceRoles().get(0).getName());
      if (sequenceMessage.getReceivingEnd() != null
          && !sequenceMessage.getReceivingEnd().getCoveredInstanceRoles().isEmpty())
        ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) seqMessage)
            .setTarget(sequenceMessage.getReceivingEnd().getCoveredInstanceRoles().get(0).getName());
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
      EmbeddedEditorInstance.getEmbeddedEditor().getDocument().set("scenario {}");
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
