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
import org.polarsys.capella.common.data.modellingcore.ValueSpecification;
import org.polarsys.capella.core.data.capellacore.Constraint;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.ctx.Actor;
import org.polarsys.capella.core.data.epbs.ConfigurationItem;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.helpers.interaction.services.ExecutionEndExt;
import org.polarsys.capella.core.data.helpers.interaction.services.SequenceMessageExt;
import org.polarsys.capella.core.data.information.datavalue.OpaqueExpression;
import org.polarsys.capella.core.data.interaction.ExecutionEnd;
import org.polarsys.capella.core.data.interaction.FragmentEnd;
import org.polarsys.capella.core.data.interaction.InstanceRole;
import org.polarsys.capella.core.data.interaction.InteractionFragment;
import org.polarsys.capella.core.data.interaction.InteractionOperand;
import org.polarsys.capella.core.data.interaction.MessageEnd;
import org.polarsys.capella.core.data.interaction.MessageKind;
import org.polarsys.capella.core.data.interaction.Scenario;
import org.polarsys.capella.core.data.interaction.SequenceMessage;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.core.data.oa.OperationalActivity;
import org.polarsys.capella.core.data.oa.OperationalActor;
import org.polarsys.capella.core.data.oa.Role;
import org.polarsys.capella.core.model.helpers.ScenarioExt;
import org.polarsys.capella.core.sirius.analysis.SequenceDiagramServices;
import org.polarsys.capella.scenario.editor.EmbeddedEditorInstance;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Alt;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Block;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ElseBlock;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Message;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ParticipantDeactivation;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.TextualScenarioFactory;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.impl.TextualScenarioFactoryImpl;
import org.polarsys.capella.scenario.editor.dsl.ui.provider.TextualScenarioProvider;
import org.polarsys.capella.scenario.editor.embeddededitor.views.EmbeddedEditorView;
import org.polarsys.capella.scenario.editor.helper.DslConstants;
import org.polarsys.capella.scenario.editor.helper.EmbeddedEditorInstanceHelper;

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
        EmbeddedEditorInstanceHelper.updateModel(serialized);
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
        if (irType instanceof OperationalActor) {
          addActor(a.getName(), id, participants, factory);
        } else if (irType instanceof Entity) {
          addEntity(a.getName(), id, participants, factory);
        } else if (irType instanceof ConfigurationItem) {
          addConfigItem(a.getName(), id, participants, factory);
        } else if (irType instanceof Component) {
          addComponent(a.getName(), id, participants, factory);
        } else if (irType instanceof Actor) {
          addActor(a.getName(), id, participants, factory);
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
    EList<EObject> messagesOrReferences = domainModel.getElements();

    List<InteractionFragment> fragments = SequenceDiagramServices.getOrderedInteractionFragments(scenario);
    Object[] ends = fragments.toArray();

    // The list of fragments contains both ends of each sequence message (sender and receiver)
    // and only one end of each execution (the one where execution ends). This means that we should skip
    // the receiving end for each message, so that we don't duplicate the generated xtext message.
    int i = 0;
    Stack<org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage> messagesToDeactivate = new Stack();
    Stack<Alt> conditions = new Stack();
    Stack<Block> blockConditons = new Stack();

    while (i < ends.length) {
      if (ends[i] instanceof MessageEnd) {
        SequenceMessage currentSequenceMessage = ((MessageEnd) ends[i]).getMessage();

        if (currentSequenceMessage.getKind() == MessageKind.REPLY) {
          // this is the reply message for currentSequenceMessage, at the end of the current execution
          EObject participantDeactivateMsg = getParticipantDeactivationMsgFromMessageEnd(ends[i], factory);

          // add the deactivation, to the model, or to a block
          if (blockConditons.isEmpty()) {
            messagesOrReferences.add(participantDeactivateMsg);
          } else {
            blockConditons.peek().getBlockElements().add((Message) participantDeactivateMsg);
          }
          updateMessagesToDeactivate(messagesToDeactivate);

          // skip another end, because it will be the corresponding receiving end of the REPLY message
          i = i + 2;
        } else {
          // this is a sequence message without return branch OR the first part of a sequence message with return branch
          EObject message = copyMessageFromMsgEnd(ends[i], factory);

          // if this sequence message has return branch, add return to the xtext message
          currentSequenceMessage = ((MessageEnd) ends[i]).getMessage();
          if (ScenarioExt.hasReply(currentSequenceMessage)) {
            ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) message)
                .setReturn(DslConstants.WITH_RETURN);
          }

          // add the sequence message, to the model, or to a block
          if (blockConditons.isEmpty()) {
            messagesOrReferences.add(message);
          } else {
            blockConditons.peek().getBlockElements().add((Message) message);
          }

          // skip the next MessageEnd (the receiving end), as it will generate the same xtext message
          i = i + 2;

          // check to see if this is a simple message (in this case, the next fragment will be its own execution end
          // or its own reply message)
          if (i < ends.length && ends[i] instanceof ExecutionEnd) {
            // check if end is its own execution end
            SequenceMessage seqMessFromMessageEnd = ((MessageEnd) ends[i - 2]).getMessage();
            SequenceMessage seqMessFromExecutionEnd = ExecutionEndExt.getMessage((ExecutionEnd) ends[i]);

            if (seqMessFromMessageEnd.equals(seqMessFromExecutionEnd)) {
              // nothing to do, skip this execution end
              i = i + 1;
            } else {
              addMessageToDeactivate(messagesToDeactivate, message);
            }
          } else if (i < ends.length && ends[i] instanceof MessageEnd) {
            // check if end is its own reply message
            SequenceMessage seqMessFromMessageEnd = ((MessageEnd) ends[i - 2]).getMessage();
            SequenceMessage seqMessFromNextMessageEnd = ((MessageEnd) ends[i]).getMessage();
            SequenceMessage replyMessage = seqMessFromNextMessageEnd != null
                && seqMessFromNextMessageEnd.getKind() == MessageKind.REPLY
                    ? SequenceMessageExt.getOppositeSequenceMessage(seqMessFromMessageEnd)
                    : null;

            if (replyMessage != null && replyMessage.equals(seqMessFromNextMessageEnd)) {
              // nothing to do, skip this message end and the next one, they belong to the same message
              i = i + 2;
            } else {
              addMessageToDeactivate(messagesToDeactivate, message);
            }
          } else {
            addMessageToDeactivate(messagesToDeactivate, message);
          }
        }
      } else if (ends[i] instanceof ExecutionEnd) {
        EObject participantDeactivateMsg = getParticipantDeactivationMsgFromExecutionEnd(ends[i], factory);

        // add the deactivation, to the model, or to a block
        if (blockConditons.isEmpty()) {
          messagesOrReferences.add(participantDeactivateMsg);
        } else {
          blockConditons.peek().getBlockElements().add((Message) participantDeactivateMsg);
        }

        updateMessagesToDeactivate(messagesToDeactivate);
        i = i + 1;
      } else if (ends[i] instanceof FragmentEnd) {
        if (ends.length > i + 1 && ends[i + 1] instanceof InteractionOperand) {
          // when we encounter a combination of FragmentEnd + Interaction operand, generate alt sequence
          Alt alt = createAlt(factory, (InteractionOperand) ends[i + 1]);
          conditions.push(alt);

          // add the new encountered alt, to the model, or to a block
          if (blockConditons.isEmpty()) {
            domainModel.getElements().add(alt);
          } else {
            blockConditons.peek().getBlockElements().add(alt);
          }

          Block altBlock = createBlock(factory);
          blockConditons.push(altBlock);
          alt.setBlock(altBlock);

          i++;
        } else {
          // here is the end of the alt sequence, extract the last processed alt and its last block
          if (!conditions.empty())
            conditions.pop();
          if (!blockConditons.empty())
            blockConditons.pop();
        }
        i++;
      } else if (ends[i] instanceof InteractionOperand) {
        // the previous operation block is ended, extract it from the stack, we are done with it
        if (!blockConditons.empty())
          blockConditons.pop();

        // generate a new branch for alt (else sequence)
        Block altBlock = addAltBlock(factory, conditions.peek(), (InteractionOperand) ends[i]);

        blockConditons.push(altBlock);

        i++;
      } else {
        i = i + 1;
      }
    }
  }

  private static void addMessageToDeactivate(
      Stack<org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage> messagesToDeactivate,
      EObject message) {
    if (message instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) {
      messagesToDeactivate.push((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) message);
    }
  }

  private static void updateMessagesToDeactivate(
      Stack<org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage> messagesToDeactivate) {
    if (!messagesToDeactivate.isEmpty()) {
      org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage currentSequenceMessage = messagesToDeactivate
          .pop();
      currentSequenceMessage.setExecution(DslConstants.WITH_EXECUTION);
    }
  }

  /**
   * generates the ParticipantDeactivation message with input from the MessageEnd in the Capella diagram
   * 
   * @param object
   *          - this is the MessageEnd
   * @param factory
   *          - this is the factory to create ParticipantDeactivation type of message
   * @return - EObject containing the ParticipantDeactivation message
   */
  private static EObject getParticipantDeactivationMsgFromMessageEnd(Object object, TextualScenarioFactory factory) {
    MessageEnd end = (MessageEnd) object;
    SequenceMessage seqMessage = end.getMessage();
    String timeLineToDeactivate = null;
    if (seqMessage.getKind() == MessageKind.REPLY) {
      timeLineToDeactivate = seqMessage.getSendingEnd().getCoveredInstanceRoles().get(0).getName();
    } else {
      timeLineToDeactivate = seqMessage.getReceivingEnd().getCoveredInstanceRoles().get(0).getName();
    }
    ParticipantDeactivation participantDeactivationMsg = createDeactivationMessage(factory, timeLineToDeactivate);
    return participantDeactivationMsg;
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
    ParticipantDeactivation participantDeactivationMsg = createDeactivationMessage(factory, seqMessage);
    return participantDeactivationMsg;
  }

  private static ParticipantDeactivation createDeactivationMessage(TextualScenarioFactory factory,
      SequenceMessage seqMessage) {
    String timelineToDeactivate = seqMessage.getReceivingEnd().getCoveredInstanceRoles().get(0).getName();

    return createDeactivationMessage(factory, timelineToDeactivate);
  }

  private static ParticipantDeactivation createDeactivationMessage(TextualScenarioFactory factory,
      String timelineToDeactivate) {
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
      // seqMessage = factory.createReturnMessage();
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
      EmbeddedEditorInstanceHelper.updateModel("scenario {}");
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
    if (domainModel != null && domainModel.getElements() != null) {
      domainModel.getElements().clear();
    }
  }

  private static Alt createAlt(TextualScenarioFactory factory, InteractionOperand operand) {
    Alt alt = factory.createAlt();
    alt.setKeyword(DslConstants.ALT);
    EList<InstanceRole> coveredInstanceRoles = operand.getCoveredInstanceRoles();
    for (InstanceRole ir : coveredInstanceRoles) {
      alt.getTimelines().add(ir.getName());
    }
    alt.setCondition(getConditionText(operand));
    return alt;
  }

  private static Block addAltBlock(TextualScenarioFactory factory, Alt alt, InteractionOperand operand) {
    ElseBlock elseBlock = factory.createElseBlock();
    elseBlock.setCondition(getConditionText(operand));
    alt.getElseBlocks().add(elseBlock);

    Block altBlock = createBlock(factory);
    elseBlock.setBlock(altBlock);

    return altBlock;
  }

  private static Block createBlock(TextualScenarioFactory factory) {
    Block block = factory.createBlock();
    block.setBegin("{");
    block.setEnd("}");

    return block;
  }

  private static String getConditionText(InteractionOperand operand) {
    Constraint guard = operand.getGuard();
    if (guard != null) {
      OpaqueExpression expression = (OpaqueExpression) guard.getOwnedSpecification();
      return expression.getBodies().isEmpty() ? "" : expression.getBodies().get(0);
    }
    return "";
  }
}
