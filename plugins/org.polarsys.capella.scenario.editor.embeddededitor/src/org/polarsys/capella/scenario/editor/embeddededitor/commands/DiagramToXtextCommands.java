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
import org.polarsys.capella.core.data.capellacommon.AbstractState;
import org.polarsys.capella.core.data.capellacommon.Mode;
import org.polarsys.capella.core.data.capellacommon.State;
import org.polarsys.capella.core.data.capellacore.Constraint;
import org.polarsys.capella.core.data.cs.Component;
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
import org.polarsys.capella.core.data.interaction.InteractionOperatorKind;
import org.polarsys.capella.core.data.interaction.InteractionState;
import org.polarsys.capella.core.data.interaction.MessageEnd;
import org.polarsys.capella.core.data.interaction.MessageKind;
import org.polarsys.capella.core.data.interaction.Scenario;
import org.polarsys.capella.core.data.interaction.SequenceMessage;
import org.polarsys.capella.core.data.interaction.TimeLapse;
import org.polarsys.capella.core.data.interaction.impl.StateFragmentImpl;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.core.data.oa.OperationalActivity;
import org.polarsys.capella.core.data.oa.Role;
import org.polarsys.capella.core.model.helpers.AbstractFragmentExt;
import org.polarsys.capella.core.model.helpers.ScenarioExt;
import org.polarsys.capella.core.sirius.analysis.SequenceDiagramServices;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Block;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Message;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Operand;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ParticipantDeactivation;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment;
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
        generateElements(domainModel, scenario, factory);

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

  private static void generateElements(Model domainModel, Scenario scenario, TextualScenarioFactory factory) {
    EList<EObject> elements = domainModel.getElements();

    List<InteractionFragment> fragments = SequenceDiagramServices.getOrderedInteractionFragments(scenario);
    Object[] ends = fragments.toArray();

    EList<TimeLapse> timeLapses = scenario.getOwnedTimeLapses();

    // The list of fragments contains both ends of each sequence message (sender and receiver)
    // and only one end of each execution (the one where execution ends). This means that we should skip
    // the receiving end for each message, so that we don't duplicate the generated xtext message.
    Stack<org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage> messagesToDeactivate = new Stack();

    Stack<CombinedFragment> combinedFragments = new Stack();
    Stack<Block> blockOperands = new Stack();

    int i = 0;
    while (i < ends.length) {
      if (ends[i] instanceof MessageEnd) {
        i = generateMessages(ends, i, messagesToDeactivate, combinedFragments, blockOperands, elements, factory);
      } else if (ends[i] instanceof ExecutionEnd) {
        generateDeactivatioOnMessages((ExecutionEnd) ends[i], messagesToDeactivate, blockOperands, elements, factory);
        i++;
      } else if (ends[i] instanceof FragmentEnd) {
        i = processCombinedFragments(ends, i, combinedFragments, blockOperands, elements, scenario, factory);
      } else if (ends[i] instanceof InteractionOperand) {
        generateOperandsOnCombinedFragment((InteractionOperand) ends[i], combinedFragments, blockOperands, factory);
        i++;
      } else if (ends[i] instanceof InteractionState) {
        generateStateFragment((InteractionState) ends[i], timeLapses, blockOperands, elements, factory);
        i++;
      } else {
        i = i + 1;
      }
    }
  }

  private static int processCombinedFragments(Object[] ends, int i, Stack<CombinedFragment> combinedFragments,
      Stack<Block> blockOperands, EList<EObject> elements, Scenario scenario, TextualScenarioFactory factory) {
    if (((FragmentEnd) ends[i])
        .getAbstractFragment() instanceof org.polarsys.capella.core.data.interaction.CombinedFragment) {
      // obtain the combined fragment
      org.polarsys.capella.core.data.interaction.CombinedFragment capellaCombinedFragment = (org.polarsys.capella.core.data.interaction.CombinedFragment) ((FragmentEnd) ends[i])
          .getAbstractFragment();
      // get the operands for the combined fragment and if the next element, on i+1 is an InteractionOperand and
      // belongs to the combined fragment, then create a new Combined fragment structure, otherwise, the Fragment end
      // is the end of a previous message
      List<InteractionOperand> operands = AbstractFragmentExt.getOwnedOperands(capellaCombinedFragment, scenario);
      if (ends.length > i + 1 && ends[i + 1] instanceof InteractionOperand && operands.contains(ends[i + 1])) {
        generateCombinedFragments((InteractionOperand) ends[i + 1], capellaCombinedFragment, combinedFragments,
            blockOperands, elements, factory);
        i++;
      } else {
        // here is the end of the combined fragment sequence, extract the last processed combined fragment and its
        // last block
        if (!combinedFragments.empty())
          combinedFragments.pop();
        if (!blockOperands.empty())
          blockOperands.pop();
      }
    }
    i++;
    return i;
  }

  private static void generateCombinedFragments(InteractionOperand interactionOperand,
      org.polarsys.capella.core.data.interaction.CombinedFragment capellaCombinedFragment,
      Stack<CombinedFragment> combinedFragments, Stack<Block> blockOperands, EList<EObject> elements,
      TextualScenarioFactory factory) {
    // when we encounter a combination of FragmentEnd + Interaction operand, generate combined fragment sequence
    CombinedFragment combinedFragment = createCombinedFragment(factory, interactionOperand,
        capellaCombinedFragment.getOperator());
    combinedFragments.push(combinedFragment);

    // add the new encountered combined fragment, to the model, or to a block
    if (blockOperands.isEmpty()) {
      elements.add(combinedFragment);
    } else {
      blockOperands.peek().getBlockElements().add(combinedFragment);
    }

    Block block = createBlock(factory);
    blockOperands.push(block);
    combinedFragment.setBlock(block);

  }

  private static void generateStateFragment(InteractionState interactionState, EList<TimeLapse> timeLapses,
      Stack<Block> blockOperands, EList<EObject> elements, TextualScenarioFactory factory) {
    for (EObject timeLapse : timeLapses) {
      if (timeLapse instanceof org.polarsys.capella.core.data.interaction.StateFragment) {
        if (((org.polarsys.capella.core.data.interaction.StateFragment) timeLapse).getStart()
            .equals(interactionState)) {
          String timelineName = interactionState.getCovered().getName();
          StateFragment stateFragment = createStateFragment(factory, timeLapse, timelineName);
          if (blockOperands.isEmpty()) {
            elements.add(stateFragment);
          } else {
            blockOperands.peek().getBlockElements().add((StateFragment) stateFragment);
          }
        }
      }
    }
  }

  private static void generateOperandsOnCombinedFragment(InteractionOperand operand,
      Stack<CombinedFragment> combinedFragments, Stack<Block> blockOperands, TextualScenarioFactory factory) {
    // the previous operation block is ended, extract it from the stack, we are done with it
    if (!blockOperands.empty())
      blockOperands.pop();

    // generate a new branch for combined fragment (else sequence)
    Block block = addOperandBlock(factory, combinedFragments.peek(), operand);

    blockOperands.push(block);
  }

  private static void generateDeactivatioOnMessages(ExecutionEnd executionEnd,
      Stack<org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage> messagesToDeactivate,
      Stack<Block> blockOperands, EList<EObject> elements, TextualScenarioFactory factory) {
    EObject participantDeactivateMsg = getParticipantDeactivationMsgFromExecutionEnd(executionEnd, factory);

    // add the deactivation, to the model, or to a block
    if (blockOperands.isEmpty()) {
      elements.add(participantDeactivateMsg);
    } else {
      blockOperands.peek().getBlockElements().add((Message) participantDeactivateMsg);
    }

    updateMessagesToDeactivate(messagesToDeactivate);
  }

  private static int generateMessages(Object[] ends, int i,
      Stack<org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage> messagesToDeactivate,
      Stack<CombinedFragment> combinedFragments, Stack<Block> blockOperands, EList<EObject> elements,
      TextualScenarioFactory factory) {

    SequenceMessage currentSequenceMessage = ((MessageEnd) ends[i]).getMessage();
    if (currentSequenceMessage != null) {
      if (currentSequenceMessage.getKind() == MessageKind.REPLY) {
        // this is the reply message for currentSequenceMessage, at the end of the current execution
        EObject participantDeactivateMsg = getParticipantDeactivationMsgFromMessageEnd(ends[i], factory);

        // add the deactivation, to the model, or to a block
        if (blockOperands.isEmpty()) {
          elements.add(participantDeactivateMsg);
        } else {
          blockOperands.peek().getBlockElements().add((Message) participantDeactivateMsg);
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
        if (blockOperands.isEmpty()) {
          elements.add(message);
        } else {
          blockOperands.peek().getBlockElements().add((Message) message);
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
      return i;
    }
    return i+1;
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

  private static CombinedFragment createCombinedFragment(TextualScenarioFactory factory, InteractionOperand operand,
      InteractionOperatorKind operatorKind) {
    CombinedFragment combinedFragment = factory.createCombinedFragment();
    combinedFragment.setKeyword(operatorKind.toString().toLowerCase());
    combinedFragment.setOver(DslConstants.OVER);
    EList<InstanceRole> coveredInstanceRoles = operand.getCoveredInstanceRoles();
    for (InstanceRole ir : coveredInstanceRoles) {
      combinedFragment.getTimelines().add(ir.getName());
    }
    combinedFragment.setExpression(HelperCommands.getExpressionText(operand));
    return combinedFragment;
  }

  private static Block addOperandBlock(TextualScenarioFactory factory, CombinedFragment combinedFragment,
      InteractionOperand operand) {
    Operand operandBlock = factory.createOperand();
    operandBlock.setExpression(HelperCommands.getExpressionText(operand));
    combinedFragment.getOperands().add(operandBlock);

    Block block = createBlock(factory);
    operandBlock.setBlock(block);

    return block;
  }

  private static Block createBlock(TextualScenarioFactory factory) {
    Block block = factory.createBlock();
    block.setBegin("{");
    block.setEnd("}");

    return block;
  }

  /**
   * Create a new StateFragment object and set the name, keyword, timeline
   * 
   * @param factory
   *          - this is the factory to create StateFragment
   * @param fragment
   *          - the state fragment from diagram
   * @param timelineName
   *          - the name of the timeline
   * @return - StateFragment the new created StateFragment
   */
  private static StateFragment createStateFragment(TextualScenarioFactory factory, Object fragment,
      String timelineName) {
    StateFragment stateFragment = factory.createStateFragment();

    AbstractState stateMode = ((org.polarsys.capella.core.data.interaction.StateFragment) fragment)
        .getRelatedAbstractState();
    if (stateMode != null) {
      if (stateMode instanceof Mode) {
        stateFragment.setKeyword(DslConstants.MODE);
      } else if (stateMode instanceof State) {
        stateFragment.setKeyword(DslConstants.STATE);
      }
      stateFragment.setName(stateMode.getName());
    } else {
      AbstractFunction function = ((org.polarsys.capella.core.data.interaction.StateFragment) fragment)
          .getRelatedAbstractFunction();
      if (function != null) {
        stateFragment.setKeyword(DslConstants.FUNCTION);
        stateFragment.setName(function.getName());
      }
    }

    stateFragment.setOn(DslConstants.ON);
    stateFragment.setTimeline(timelineName);

    return stateFragment;
  }
}
