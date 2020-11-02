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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.XtextResource;
import org.polarsys.capella.common.data.modellingcore.AbstractType;
import org.polarsys.capella.core.data.capellacommon.AbstractState;
import org.polarsys.capella.core.data.capellacommon.Mode;
import org.polarsys.capella.core.data.capellacommon.State;
import org.polarsys.capella.core.data.cs.AbstractActor;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.ctx.Actor;
import org.polarsys.capella.core.data.epbs.ConfigurationItem;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.helpers.interaction.services.ExecutionEndExt;
import org.polarsys.capella.core.data.helpers.interaction.services.SequenceMessageExt;
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
import org.polarsys.capella.core.data.interaction.StateFragment;
import org.polarsys.capella.core.data.interaction.CombinedFragment;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.core.data.oa.OperationalActivity;
import org.polarsys.capella.core.data.oa.OperationalActor;
import org.polarsys.capella.core.data.oa.Role;
import org.polarsys.capella.core.model.helpers.AbstractFragmentExt;
import org.polarsys.capella.core.model.helpers.ScenarioExt;
import org.polarsys.capella.core.sirius.analysis.SequenceDiagramServices;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ArmTimerMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Block;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Element;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Operand;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ParticipantDeactivation;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.TextualScenarioFactory;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.impl.TextualScenarioFactoryImpl;
import org.polarsys.capella.scenario.editor.dsl.provider.TextualScenarioProvider;
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
      Model domainModel = HelperCommands.getModel(embeddedEditorViewPart);
      if (domainModel != null && scenario != null) {
        HelperCommands.clearModel(domainModel);

        // Generate Participants
        generateParticipants(domainModel, scenario, factory);

        // Generate Sequence Messages
        generateElements(domainModel, scenario, factory);

        content.add(domainModel);

        try {
          String serialized = ((XtextResource) domainModel.eResource()).getSerializer().serialize(domainModel);
          EmbeddedEditorInstanceHelper.updateModel(serialized);
        } catch (Exception e) {
        	showDialogUnableToRefresh();
			System.err.println("Error refreshing diagram from Textual Editor");
        }
      }
      else {
    	  showDialogUnableToRefresh();
      }
    }
  }
  
  private static void showDialogUnableToRefresh() {
	  MessageDialog.openError(Display.getCurrent().getActiveShell(), "Unable to refresh", "Error on refreshing data to Textual Editor!");
  }

  /**
   * generate the participants objects (actors, functions, components etc) that will be written in the xtext scenario
   * 
   * @param domaninModel
   *  - the xtext model 
   * @param scenario
   *  - the current selected scenario
   * @param factory
   */
  private static void generateParticipants(Model domainModel, Scenario scenario, TextualScenarioFactory factory) {
    // get all instance roles (actors) from diagram
    EList<InstanceRole> instanceRoleList = scenario.getOwnedInstanceRoles();

    // get all participants/actors from editor
    EList<Participant> participants = domainModel.getParticipants();

    // remove all participants
    participants.clear();

    // recreate the list of participants
    for (InstanceRole instanceRole : instanceRoleList) {
      AbstractType irType = instanceRole.getRepresentedInstance().getAbstractType();
      if (irType != null) {
        createParticipantComponent(irType, instanceRole, participants, factory);
      } else {
        createParticipantFunction(instanceRole, participants, factory);
      }
    }
  }
  
  /**
   * create the xtext component type object
   * 
   * @param irType 
   *  - Capella AbstractType
   * @param instanceRole
   *  - the Capella instanceRole 
   * @param participants
   * @param factory
   */
	private static void createParticipantComponent(AbstractType irType, InstanceRole instanceRole,
			EList<Participant> participants, TextualScenarioFactory factory) {
		if (irType instanceof OperationalActor) {
			addActor(instanceRole.getName(), participants, factory);
		} else if (irType instanceof Entity) {
			addEntity(instanceRole.getName(), participants, factory);
		} else if (irType instanceof ConfigurationItem) {
			addConfigItem(instanceRole.getName(), participants, factory);
		} else if (irType instanceof AbstractActor) {
			addActor(instanceRole.getName(), participants, factory);
		} else if (irType instanceof Component) {
			addComponent(instanceRole.getName(), participants, factory);
		}
	}
  
  /**
   * create the xtext function type object
   * 
   * @param instanceRole
   *  - the Capella instanceRole 
   * @param participants
   * @param factory
   */
  private static void createParticipantFunction(InstanceRole instanceRole,
      EList<Participant> participants, TextualScenarioFactory factory) {
    if (instanceRole.getRepresentedInstance() instanceof OperationalActivity) {
      addActivity(instanceRole.getName(), participants, factory);
    } else if (instanceRole.getRepresentedInstance() instanceof Role) {
      addRole(instanceRole.getName(), participants, factory);
    } else if (instanceRole.getRepresentedInstance() instanceof AbstractFunction) {
      addFunction(instanceRole.getName(), participants, factory);
    }
  }

  /**
   * create an an xtext actor object using the TextualScenarioFactory object
   * 
   * @param name
   *  - the name of the xtext actor 
   * @param participants
   *  - the current list of xtext participants (actors, components, functions) in which we add the new element
   * @param factory
   */  
  private static void addActor(String name, EList<Participant> participants,
      TextualScenarioFactory factory) {
    org.polarsys.capella.scenario.editor.dsl.textualScenario.Actor actor = factory.createActor();
    actor.setName(name);
    actor.setKeyword(DslConstants.ACTOR);
    participants.add(actor);
  }

  /**
   * create an an xtext activity object using the TextualScenarioFactory object
   * 
   * @param name
   *  - the name of the xtext activity 
   * @param participants
   *  - the current list of xtext participants (actors, components, functions) in which we add the new element
   * @param factory
   */ 
  private static void addActivity(String name, EList<Participant> participants,
      TextualScenarioFactory factory) {
    org.polarsys.capella.scenario.editor.dsl.textualScenario.Activity activity = factory.createActivity();
    activity.setName(name);
    activity.setKeyword(DslConstants.ACTIVITY);
    participants.add(activity);
  }

  /**
   * create an an xtext component object using the TextualScenarioFactory object
   * 
   * @param name
   *  - the name of the xtext component 
   * @param participants
   *  - the current list of xtext participants (actors, components, functions) in which we add the new element
   * @param factory
   */ 
  private static void addComponent(String name, EList<Participant> participants,
      TextualScenarioFactory factory) {
    org.polarsys.capella.scenario.editor.dsl.textualScenario.Component component = factory.createComponent();
    component.setName(name);
    component.setKeyword(DslConstants.COMPONENT);
    participants.add(component);
  }

  /**
   * create an an xtext entity object using the TextualScenarioFactory object
   * 
   * @param name
   *  - the name of the xtext entity 
   * @param participants
   *  - the current list of xtext participants (actors, components, functions) in which we add the new element
   * @param factory
   */ 
  private static void addEntity(String name, EList<Participant> participants,
      TextualScenarioFactory factory) {
    org.polarsys.capella.scenario.editor.dsl.textualScenario.Entity entity = factory.createEntity();
    entity.setName(name);
    entity.setKeyword(DslConstants.ENTITY);
    participants.add(entity);
  }

  /**
   * create an an xtext configuration_item object using the TextualScenarioFactory object
   * 
   * @param name
   *  - the name of the xtext configuration_item 
   * @param participants
   *  - the current list of xtext participants (actors, components, functions) in which we add the new element
   * @param factory
   */ 
  private static void addConfigItem(String name, EList<Participant> participants,
      TextualScenarioFactory factory) {
    org.polarsys.capella.scenario.editor.dsl.textualScenario.ConfigurationItem configItem = factory
        .createConfigurationItem();
    configItem.setName(name);
    configItem.setKeyword(DslConstants.CONFIGURATION_ITEM);
    participants.add(configItem);
  }

  /**
   * create an an xtext function object using the TextualScenarioFactory object
   * 
   * @param name
   *  - the name of the xtext function 
   * @param participants
   *  - the current list of xtext participants (actors, components, functions) in which we add the new element
   * @param factory
   */ 
  private static void addFunction(String name, EList<Participant> participants,
      TextualScenarioFactory factory) {
    org.polarsys.capella.scenario.editor.dsl.textualScenario.Function function = factory.createFunction();
    function.setName(name);
    function.setKeyword(DslConstants.FUNCTION);
    participants.add(function);
  }

  /**
   * create an an xtext role object using the TextualScenarioFactory object
   * 
   * @param name
   *  - the name of the xtext role 
   * @param participants
   *  - the current list of xtext participants (actors, components, functions) in which we add the new element
   * @param factory
   */ 
  private static void addRole(String name, EList<Participant> participants, TextualScenarioFactory factory) {
    org.polarsys.capella.scenario.editor.dsl.textualScenario.Role role = factory.createRole();
    role.setName(name);
    role.setKeyword(DslConstants.ROLE);
    participants.add(role);
  }

  /**
   * generate xtext elements (messages, combined fragments, state-modes);
   * elements are all the other elements that we can add in a scenario diagram and are not participants (instance roles)
   * 
   * @param domain model
   *  - the xtext model object in which we add the elements found in diagram
   * @param factory
   *  - the factory object is used to create xtext elements
   */ 
  private static void generateElements(Model domainModel, Scenario scenario, TextualScenarioFactory factory) {
    EList<Element> elements = domainModel.getElements();

    List<InteractionFragment> fragments = SequenceDiagramServices.getOrderedInteractionFragments(scenario);
    // ends contains the interaction fragments from the scenario diagram
    // we will go trough this array and based on its content, we generate xtext elements
    Object[] ends = fragments.toArray();

    EList<TimeLapse> timeLapses = scenario.getOwnedTimeLapses();

    // The list of fragments contains both ends of each sequence message (sender and receiver)
    // and only one end of each execution (the one where execution ends). This means that we should skip
    // the receiving end for each message, so that we don't duplicate the generated xtext message.
    Deque<org.polarsys.capella.scenario.editor.dsl.textualScenario.Message> messagesToDeactivate = new ArrayDeque();

    // we need to save the combined fragments and blocks on a stack because this 
    // elements may contain other inner elements and we need to know when to close a combined fragment
    Deque<org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment> combinedFragments = new ArrayDeque();
    Deque<Block> blockOperands = new ArrayDeque();

    int i = 0;
    while (i < ends.length) {
      if (ends[i] instanceof MessageEnd) {
        if (isTimerReceivingEnd((MessageEnd) ends[i])) {
          //skip TIMER receiving ends, as the sending end will give the message to put in xtext
          i = i + 1;
        } else {
          i = generateMessages(ends, i, messagesToDeactivate, combinedFragments, blockOperands, elements, factory);
        }
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

  private static boolean isTimerReceivingEnd(MessageEnd messageEnd) {
    SequenceMessage currentSequenceMessage = messageEnd.getMessage();
    return currentSequenceMessage != null &&
        currentSequenceMessage.getKind() == MessageKind.TIMER &&
        currentSequenceMessage.getReceivingEnd().equals(messageEnd);
  }

  /**
   * process those ends in the ends array that are related to a combined fragment structure
   * 
   * @param ends
   *  - the array of interaction fragments found in the Capella Scenario Diagram
   * @param index
   *  - the index used to access elements from ends array
   * @param combinedFraments
   *  - the stack of currently encountered and unclosed combined fragments, we use this stack, pop from it to close a combined fragment
   * @param blockOperands
   *  - the stack of currently encountered and unclosed operands (contained in a combined fragment)
   * @param factory
   *  - the Textual Scenario Factory that we use to create xtext objects and add them to the model 
   */ 
  private static int processCombinedFragments(Object[] ends, int index,
      Deque<org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment> combinedFragments,
      Deque<Block> blockOperands,
      EList<Element> elements,
      Scenario scenario,
      TextualScenarioFactory factory) {
    if (((FragmentEnd) ends[index])
        .getAbstractFragment() instanceof CombinedFragment) {
      // obtain the combined fragment
      CombinedFragment capellaCombinedFragment = (CombinedFragment) ((FragmentEnd) ends[index])
          .getAbstractFragment();
      // get the operands for the combined fragment and if the next element, on i+1 is an InteractionOperand and
      // belongs to the combined fragment, then create a new Combined fragment structure, otherwise, the Fragment end
      // is the end of a previous message
      List<InteractionOperand> operands = AbstractFragmentExt.getOwnedOperands(capellaCombinedFragment, scenario);
      if (ends.length > index + 1 && ends[index + 1] instanceof InteractionOperand && operands.contains(ends[index + 1])) {
        generateCombinedFragments((InteractionOperand) ends[index + 1], capellaCombinedFragment, combinedFragments,
            blockOperands, elements, factory);
        index++;
      } else {
        // here is the end of the combined fragment sequence, extract the last processed combined fragment and its
        // last block
        if (!combinedFragments.isEmpty())
          combinedFragments.pop();
        if (!blockOperands.isEmpty())
          blockOperands.pop();
      }
    }
    index++;
    return index;
  }
  
  /**
   * create a full xtext combined fragment (with its operands)
   * 
   * @param interactionOperand
   *  - the interactionOperand Capella element encountered in the Interaction Fragments ends array
   * @param capellaCombinedFragment
   * @param combinedFraments
   *  - the stack of currently encountered and unclosed combined fragments, we use this stack, pop from it to close a combined fragment
   * @param blockOperands
   *  - the stack of currently encountered and unclosed operands (contained in a combined fragment)
   * @param elements
   *  - the elements (messages, combined fragments, states) that are directly in the model object (not the ones encountered in a combined fragment)
   * @param factory
   *  - the Textual Scenario Factory that we use to create xtext objects and add them to the model 
   */ 
  private static void generateCombinedFragments(InteractionOperand interactionOperand,
      CombinedFragment capellaCombinedFragment,
      Deque<org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment> combinedFragments,
      Deque<Block> blockOperands,
      EList<Element> elements,
      TextualScenarioFactory factory) {
    // when we encounter a combination of FragmentEnd + Interaction operand, generate combined fragment sequence
    org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment xtextCombinedFragment = createCombinedFragment(factory, interactionOperand,
        capellaCombinedFragment.getOperator());
    combinedFragments.push(xtextCombinedFragment);

    // add the new encountered combined fragment, to the model, or to a block
    if (blockOperands.isEmpty()) {
      elements.add(xtextCombinedFragment);
    } else {
      blockOperands.peek().getBlockElements().add(xtextCombinedFragment);
    }

    // create the other operands belonging to a combined fragment
    Block block = createBlock(factory);
    blockOperands.push(block);
    xtextCombinedFragment.setBlock(block);

  }

  /**
   * create an xtext operand that is contained in a combined fragment
   * 
   * @param interactionOperand
   *  - the interactionOperand Capella element encountered in the Interaction Fragments ends array
   * @param combinedFraments
   *  - the stack of currently encountered and unclosed combined fragments, we use this stack, pop from it to close a combined fragment
   * @param blockOperands
   *  - the stack of currently encountered and unclosed operands (contained in a combined fragment)
   * @param factory
   *  - the Textual Scenario Factory that we use to create xtext objects and add them to the model 
   */ 
  private static void generateOperandsOnCombinedFragment(InteractionOperand operand,
      Deque<org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment> combinedFragments,
      Deque<Block> blockOperands, TextualScenarioFactory factory) {
    // the previous operation block is ended, extract it from the stack, we are done with it
    if (!blockOperands.isEmpty())
      blockOperands.pop();

    if (!combinedFragments.isEmpty()) {
      // generate a new branch for combined fragment (else sequence)
      Block block = addOperandBlock(factory, combinedFragments.peek(), operand);

      blockOperands.push(block);
    }
  }
  
  /**
   * create an xtext deactivation object that will close a previousely encountered message with execution
   * 
   * @param executionEnd
   *  - the executionEnd Capella element encountered in the Interaction Fragments ends array
   * @param messagesToDeactivate
   *  - the stack of currently encountered and unclosed messages with execution;
   *  - we use pop from it to close a previously encountered message with execution
   * @param blockOperands
   *  - the stack of currently encountered and unclosed operands (contained in a combined fragment)
   *  - we use this variable here, because a deactivation messages can be contained in an operand
   *  - the deactivation message can be contained directly in the elements array from the model or in an operand
   *  @param elements
   *  - the elements (messages, combined fragments, states) that are directly in the model object (not the ones encountered in a combined fragment)
   * @param factory
   *  - the Textual Scenario Factory that we use to create xtext objects and add them to the model 
   */
  private static void generateDeactivatioOnMessages(ExecutionEnd executionEnd,
      Deque<org.polarsys.capella.scenario.editor.dsl.textualScenario.Message> messagesToDeactivate,
      Deque<Block> blockOperands, EList<Element> elements, TextualScenarioFactory factory) {
    SequenceMessage capellaSequenceMessage = ExecutionEndExt.getMessage(executionEnd);
    ParticipantDeactivation participantDeactivationMsg = createDeactivationMessage(factory, capellaSequenceMessage);

    // add the deactivation, to the model, or to a block
    if (blockOperands.isEmpty()) {
      elements.add(participantDeactivationMsg);
    } else {
      blockOperands.peek().getBlockElements().add((org.polarsys.capella.scenario.editor.dsl.textualScenario.Message) participantDeactivationMsg);
    }

    setWithExecutionOnMessageToDeactivate(messagesToDeactivate);
  }

  /**
   * generates the xtext messages that will be displayed in the text exitor, it uses at input the array of message ends from Capella (the ends array)
   * 
   * @param ends
   *          - array of Interaction Fragments found in the Capella Scenario Diagram
   * @param index
   *          - the index we use to know at wich Message End we are (from the ends array)
   * @param messagesToDeactivate
   *          - we keep in a stack the messages that we need to deactivate
   * @param combinedFragments
   *           - the stack of combined fragments
   * @param blockOperands 
   *           - the stack of currently encountered operands in a combined fragment   
   * @param elements
   *            - the elements (messages, combined fragments, states) that are directly in the model object (not the ones encountered in a combined fragment)
   * @param factory          
   * @return - the index from the message ends array until where we parsed the messages
   */
  private static int generateMessages(Object[] ends, int index,
      Deque<org.polarsys.capella.scenario.editor.dsl.textualScenario.Message> messagesToDeactivate,
      Deque<org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment> combinedFragments,
      Deque<Block> blockOperands, EList<Element> elements,
      TextualScenarioFactory factory) {

    SequenceMessage currentSequenceMessage = ((MessageEnd) ends[index]).getMessage();
    if (currentSequenceMessage != null) {
      if (currentSequenceMessage.getKind() == MessageKind.REPLY) {
        // this is the reply message for currentSequenceMessage, at the end of the current execution
        EObject participantDeactivateMsg = getParticipantDeactivationMsgFromMessageEnd(ends[index], factory);

        // add the deactivation, to the model, or to a block
        if (blockOperands.isEmpty()) {
          elements.add((Element) participantDeactivateMsg);
        } else {
          blockOperands.peek().getBlockElements().add((org.polarsys.capella.scenario.editor.dsl.textualScenario.Message) participantDeactivateMsg);
        }
        setWithExecutionOnMessageToDeactivate(messagesToDeactivate);

        // skip another end, because it will be the corresponding receiving end of the REPLY message
        index = index + 2;
      } else {
        // this is a sequence message without return branch OR the first part of a sequence message with return branch
        EObject message = createMessage(ends[index], factory);

        // if this sequence message has return branch, add return to the xtext message
        currentSequenceMessage = ((MessageEnd) ends[index]).getMessage();
        if (message instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage &&
            ScenarioExt.hasReply(currentSequenceMessage)) {
          ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) message)
              .setReturn(DslConstants.WITH_RETURN);
        }

        // add the sequence message, to the model, or to a block
        if (blockOperands.isEmpty()) {
          elements.add((Element) message);
        } else {
          blockOperands.peek().getBlockElements().add((org.polarsys.capella.scenario.editor.dsl.textualScenario.Message) message);
        }

        // skip the next MessageEnd (the receiving end), as it will generate the same xtext message
        index = index + 2;

        boolean isSimpleMessage = false;
        // check to see if this is a simple message (in this case, the next fragment will be its own execution end
        // or its own reply message)
        if (index < ends.length && ends[index] instanceof ExecutionEnd) {
          // check if end is its own execution end
          SequenceMessage seqMessFromMessageEnd = ((MessageEnd) ends[index - 2]).getMessage();
          SequenceMessage seqMessFromExecutionEnd = ExecutionEndExt.getMessage((ExecutionEnd) ends[index]);

          if (seqMessFromMessageEnd.equals(seqMessFromExecutionEnd)) {
            // nothing to do, skip this execution end
            index = index + 1;
            isSimpleMessage = true;
          } else {
            addMessageToDeactivate(messagesToDeactivate, message);
          }
        } else if (index < ends.length && ends[index] instanceof MessageEnd) {
          // check if end is its own reply message
          SequenceMessage seqMessFromMessageEnd = ((MessageEnd) ends[index - 2]).getMessage();
          SequenceMessage seqMessFromNextMessageEnd = ((MessageEnd) ends[index]).getMessage();
          SequenceMessage replyMessage = seqMessFromNextMessageEnd != null
              && seqMessFromNextMessageEnd.getKind() == MessageKind.REPLY
                  ? SequenceMessageExt.getOppositeSequenceMessage(seqMessFromMessageEnd)
                  : null;

          if (replyMessage != null && replyMessage.equals(seqMessFromNextMessageEnd)) {
            // nothing to do, skip this message end and the next one, they belong to the same message
            index = index + 2;
            isSimpleMessage = true;
          } else {
            addMessageToDeactivate(messagesToDeactivate, message);
          }
        } else {
          addMessageToDeactivate(messagesToDeactivate, message);
        }

        // don't skip the next end, if it belongs to the same TIMER message
        if (currentSequenceMessage.getKind() == MessageKind.TIMER && index < ends.length && !isSimpleMessage
            && doSkipNextFragment((InteractionFragment) ends[index], currentSequenceMessage)) {
          // only for withExecution messages
          index = index - 1;
        }
      }
      return index;
    }
    return index+1;
  }

  /**
   * check if we need to skip this interaction fragment
   * 
   * @param fragment
   * @param currentSequenceMessage
   * @return boolean
   */
  private static boolean doSkipNextFragment(InteractionFragment fragment, SequenceMessage currentSequenceMessage) {
    if (fragment instanceof ExecutionEnd) {
      // don't skip the next ExecutionEnd, as it might belong to another message
      return !currentSequenceMessage.equals(ExecutionEndExt.getMessage((ExecutionEnd) fragment));
    }
    if (fragment instanceof MessageEnd) {
      // don't skip the next MessageEnd, as it might belong to another message
      return !currentSequenceMessage.equals(((MessageEnd) fragment).getMessage()); 
    }
    return false;
  }


  /**
   * add elements to the messagesToDeactivate stack;
   * this stack contains all the messages that we need to deactivate (can be sequence messages or arm timer)
   * 
   * @param messagesToDeactivate
   *          - this is a stack with messages with execution that need to be closed by a deactivate
   *          - the first element from this stack is extracted and the withExecution field is set
   * @param message
   *          - the xtext message that will be added to the messagesToDeactivate stack         
   */
  private static void addMessageToDeactivate(
      Deque<org.polarsys.capella.scenario.editor.dsl.textualScenario.Message> messagesToDeactivate,
      EObject message) {
    if (message instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage ||
        message instanceof ArmTimerMessage) {
      messagesToDeactivate.push((org.polarsys.capella.scenario.editor.dsl.textualScenario.Message) message);
    }
  }

  /**
   * set the withExecution field on an xtext Message
   * 
   * @param messagesToDeactivate
   *          - this is a stack with messages with execution that need to be closed by a deactivate
   *          - the first element from this stack is extracted and the withExecution field is set
   */
  private static void setWithExecutionOnMessageToDeactivate(
      Deque<org.polarsys.capella.scenario.editor.dsl.textualScenario.Message> messagesToDeactivate) {
    if (!messagesToDeactivate.isEmpty()) {
      org.polarsys.capella.scenario.editor.dsl.textualScenario.Message currentSequenceMessage = messagesToDeactivate
          .pop();
      if (currentSequenceMessage instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) {
        ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) currentSequenceMessage).setExecution(DslConstants.WITH_EXECUTION);
      } else {
        ((org.polarsys.capella.scenario.editor.dsl.textualScenario.ArmTimerMessage) currentSequenceMessage).setExecution(DslConstants.WITH_EXECUTION);
      }
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
    return createDeactivationMessage(factory, timeLineToDeactivate);
  }

  /**
   * create the ParticipantDeactivation message with input from a Capella sequence message
   * 
   * @param factory
   *          - this is the factory to create ParticipantDeactivation type of message
   * @param  capellaSequenceMessage        
   * @return - ParticipantDeactivation the xtext Participant deactivation message
   */
  private static ParticipantDeactivation createDeactivationMessage(TextualScenarioFactory factory,
      SequenceMessage capellaSequenceMessage) {
    String timelineToDeactivate = capellaSequenceMessage.getReceivingEnd().getCoveredInstanceRoles().get(0).getName();

    return createDeactivationMessage(factory, timelineToDeactivate);
  }

  /**
   * create the ParticipantDeactivation message that will deactivate the given timeline
   * 
   * @param factory
   *          - this is the factory to create ParticipantDeactivation type of message
   * @param  timelineToDeactivate        
   * @return ParticipantDeactivation
   * - the xtext Participant deactivation message
   */
  private static ParticipantDeactivation createDeactivationMessage(TextualScenarioFactory factory,
      String timelineToDeactivate) {
    ParticipantDeactivation participantDeactivationMsg = factory.createParticipantDeactivation();
    participantDeactivationMsg.setName(timelineToDeactivate);

    participantDeactivationMsg.setKeyword(DslConstants.DEACTIVATE);
    return participantDeactivationMsg;
  }

  /**
   * create an xtext message using as input a message end encountered in the Capella Scenario Diagram
   * 
   * @param object
   *          - this is the MessageEnd
   * @param factory
   *          - this is the factory to create the xtext message
   * @return - EObject the xtext message object created in this method
   */
  private static EObject createMessage(Object object, TextualScenarioFactory factory) {
    EObject xtextSequenceMessage = null;
    MessageEnd end = (MessageEnd) object;
    SequenceMessage capellaSequenceMessage = end.getMessage();

    switch (capellaSequenceMessage.getKind()) {
    case CREATE:
      xtextSequenceMessage = factory.createCreateMessage();
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) xtextSequenceMessage).setArrow("->+");
      break;
    case DELETE:
      xtextSequenceMessage = factory.createDeleteMessage();
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) xtextSequenceMessage).setArrow("->x");
      break;
    case REPLY:
      break;
    case TIMER:
      xtextSequenceMessage = factory.createArmTimerMessage();
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.ArmTimerMessage) xtextSequenceMessage).setArrow("->>");
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.ArmTimerMessage) xtextSequenceMessage)
          .setName(capellaSequenceMessage.getName());
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.ArmTimerMessage) xtextSequenceMessage).setDoubleDot(":");
      if (capellaSequenceMessage.getSendingEnd() != null
          && !capellaSequenceMessage.getSendingEnd().getCoveredInstanceRoles().isEmpty())
        ((org.polarsys.capella.scenario.editor.dsl.textualScenario.ArmTimerMessage) xtextSequenceMessage)
            .setParticipant(capellaSequenceMessage.getSendingEnd().getCoveredInstanceRoles().get(0).getName());
      return xtextSequenceMessage;
    case ASYNCHRONOUS_CALL:
    case SYNCHRONOUS_CALL:
    default:
      xtextSequenceMessage = factory.createSequenceMessage();
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) xtextSequenceMessage).setArrow("->");
      break;
    }
    if (xtextSequenceMessage != null) {
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) xtextSequenceMessage)
          .setName(capellaSequenceMessage.getName());
      if (capellaSequenceMessage.getSendingEnd() != null
          && !capellaSequenceMessage.getSendingEnd().getCoveredInstanceRoles().isEmpty())
        ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) xtextSequenceMessage)
            .setSource(capellaSequenceMessage.getSendingEnd().getCoveredInstanceRoles().get(0).getName());
      if (capellaSequenceMessage.getReceivingEnd() != null
          && !capellaSequenceMessage.getReceivingEnd().getCoveredInstanceRoles().isEmpty())
        ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) xtextSequenceMessage)
            .setTarget(capellaSequenceMessage.getReceivingEnd().getCoveredInstanceRoles().get(0).getName());
      ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) xtextSequenceMessage).setDoubleDot(":");
    }
    return xtextSequenceMessage;
  }
  
  /**
   * create an xtext combined fragment
   * 
   * @param factory
   *          - this is the factory to create the xtext message
   * @param operand
   *          - the first operand in a combined fragment
   * @param operatorKind
   *          - can be alt, loop, par etc
   * @return org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment
   */
  private static org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment createCombinedFragment(TextualScenarioFactory factory,
      InteractionOperand operand,
      InteractionOperatorKind operatorKind) {
    org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment xtextCombinedFragment = factory.createCombinedFragment();
    xtextCombinedFragment.setKeyword(operatorKind.toString().toLowerCase());
    xtextCombinedFragment.setOver(DslConstants.OVER);
    EList<InstanceRole> coveredInstanceRoles = operand.getCoveredInstanceRoles();
    for (InstanceRole ir : coveredInstanceRoles) {
      xtextCombinedFragment.getTimelines().add(ir.getName());
    }
    xtextCombinedFragment.setExpression(HelperCommands.getExpressionText(operand));
    return xtextCombinedFragment;
  }

  /**
   * create an xtext block object that belongs to an xtext combined fragment
   * 
   * @param factory
   *          - this is the factory to create the xtext message
   * @param xtextCombinedFragment
   *          - the xtext combined fragment that is the container of this block         
   * @param operand
   *          - the first operand in a combined fragment
   * @return Block
   */
  private static Block addOperandBlock(TextualScenarioFactory factory,
      org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment xtextCombinedFragment,
      InteractionOperand operand) {
    Operand operandBlock = factory.createOperand();
    operandBlock.setExpression(HelperCommands.getExpressionText(operand));
    if(xtextCombinedFragment.getKeyword().equals(DslConstants.ALT)) {
      operandBlock.setKeyword("else");
    }
    xtextCombinedFragment.getOperands().add(operandBlock);

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
   * process those ends in the ends array that are related to a state/mode structure
   * 
   * @param interactionState
   *  - the InteractionState Capella object processed from the ends Interaction Fragments array
   * @param timelapses
   *  - the Capella Timelapses over which this state is displayed 
   * @param blockOperands
   *  - the stack of currently encountered and unclosed operands (contained in a combined fragment)
   *  - we pass this stack when generating the xtext states because we may encounter a state object in an operand of a combined fragment
   * @param elements
   *  - the elements (messages, combined fragments, states) that are directly in the model object (not the ones encountered in a combined fragment)
   * @param factory
   *  - the Textual Scenario Factory that we use to create xtext objects and add them to the model 
   * @param factory
   */ 
  private static void generateStateFragment(InteractionState interactionState, EList<TimeLapse> timeLapses,
      Deque<Block> blockOperands, EList<Element> elements, TextualScenarioFactory factory) {
    for (EObject timeLapse : timeLapses) {
      if (timeLapse instanceof StateFragment && interactionState != null &&
          interactionState.equals(((StateFragment) timeLapse).getStart())) {
        String timelineName = interactionState.getCovered().getName();
        org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment xtextStateFragment = createStateFragment(
            factory, timeLapse, timelineName);
        if (blockOperands.isEmpty()) {
          elements.add(xtextStateFragment);
        } else {
          blockOperands.peek().getBlockElements()
              .add((org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment) xtextStateFragment);
        }
      }
    }
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
  private static org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment createStateFragment(TextualScenarioFactory factory, Object fragment,
      String timelineName) {
    org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment xtextStateFragment = factory.createStateFragment();

    AbstractState stateMode = ((StateFragment) fragment)
        .getRelatedAbstractState();
    if (stateMode != null) {
      if (stateMode instanceof Mode) {
        xtextStateFragment.setKeyword(DslConstants.MODE);
      } else if (stateMode instanceof State) {
        xtextStateFragment.setKeyword(DslConstants.STATE);
      }
      xtextStateFragment.setName(stateMode.getName());
    } else {
      AbstractFunction function = ((StateFragment) fragment)
          .getRelatedAbstractFunction();
      if (function != null) {
        xtextStateFragment.setKeyword(DslConstants.FUNCTION);
        xtextStateFragment.setName(function.getName());
      }
    }

    xtextStateFragment.setOn(DslConstants.ON);
    xtextStateFragment.setTimeline(timelineName);

    return xtextStateFragment;
  }
}