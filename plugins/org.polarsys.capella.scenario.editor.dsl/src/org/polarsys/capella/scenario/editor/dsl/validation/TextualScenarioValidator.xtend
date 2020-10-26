/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
 *  
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 *  
 *  Contributors:
 *     Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.scenario.editor.dsl.validation

import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant
import org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType
import org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ParticipantDeactivation
import org.polarsys.capella.scenario.editor.dsl.textualScenario.TextualScenarioPackage
import org.eclipse.xtext.validation.Check
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model
import org.polarsys.capella.scenario.editor.helper.EmbeddedEditorInstanceHelper
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Function
import org.polarsys.capella.scenario.editor.dsl.helpers.TextualScenarioHelper
import org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment
import org.eclipse.emf.ecore.EObject
import org.polarsys.capella.scenario.editor.dsl.textualScenario.DeleteMessage
import org.polarsys.capella.scenario.editor.dsl.textualScenario.CreateMessage
import org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment
import org.polarsys.capella.scenario.editor.helper.DslConstants
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Operand
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Block
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ArmTimerMessage
import java.util.HashSet
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Message
import org.eclipse.emf.ecore.EAttribute

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class TextualScenarioValidator extends AbstractTextualScenarioValidator {
	public static val INVALID_NAME = 'invalidName'
	public static val DUPLICATED_NAME = 'duplicatedName'
	public static val DUPLICATED_MESSAGES_NAME = 'duplicatedMessageName'
	
	@Check
	def checkPartExists(Participant participant) {
		if (!EmbeddedEditorInstanceHelper.getAvailablePartNames(participant.keyword).contains(participant.name)) {
			if (participant instanceof Function) {
				error('Function does not exist!', TextualScenarioPackage.Literals.PARTICIPANT__NAME, INVALID_NAME)
			} else {
				error('Represented part does not exist!', TextualScenarioPackage.Literals.PARTICIPANT__NAME,
					INVALID_NAME)
			}
		}
	}

	@Check
	def checkParticipantKeywordIsValid(Participant participant) {
		if (!EmbeddedEditorInstanceHelper.checkValidKeyword(participant.keyword)) {
			error('\'' + participant.keyword + '\' can not be used in this diagram!',
				TextualScenarioPackage.Literals.PARTICIPANT__KEYWORD)
		}
	}

	@Check
	def checkMessagesExist(SequenceMessage message) {
		if (!EmbeddedEditorInstanceHelper.getExchangeNames(message.getSource, message.getTarget).contains(
				message.name)) {
			error('Message does not exist!', TextualScenarioPackage.Literals.MESSAGE__NAME)
		}
	}
	
		
	/*
	 * Check that the source and the target of the sequence messages type are defined in text, before using them in the message 
	 */
	@Check
	def checkParticipantsInvolvedExist(SequenceMessageType message) {
		var participantsDefined = TextualScenarioHelper.participantsDefinedBeforeNames(message);
		if (!participantsDefined.contains(message.source)) {
			error(
				'Source participant not defined in text editor!',
				TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__SOURCE
			)
		}
		if (!participantsDefined.contains(message.target)) {
			error(
				'Target participant not defined in text editor!',
				TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET
			)
		}
	}
	
	/*
	 * check that a CE (component exchange) and an FE (functional exchange) are not used in the same place
	 */
	@Check
	def checkMessagesExchangeType(SequenceMessage message) {
		if (EmbeddedEditorInstanceHelper.isESScenario()) {
			var model = TextualScenarioHelper.getModelContainer(message)
			if (model !== null) {
				var scenarioExchangesType = TextualScenarioHelper.
					getScenarioAllowedExchangesType((model as Model).elements)
				var exchangeType = TextualScenarioHelper.getMessageExchangeType(message)
				if (scenarioExchangesType !== null && !scenarioExchangesType.equals(exchangeType)) {
					error('Exchange type can not be used, expected ' + scenarioExchangesType + "!",
						TextualScenarioPackage.Literals.MESSAGE__NAME)
				}
			}
		}
	}
	
	/*
	 * Do not allow duplicated names, we have a combination of unique keyword + name
	 * ex: not allowed: actor "A1", actor "A1"
	 * ex: allowed: actor "A1", component "A1"
	 */
	@Check
	def checkDuplicatedParticipantsNames(Model model) {
		var index = 0
		val names = newHashSet
		for (p : model.participants) {
			if (!names.add(getParticipantsMapKey(p))) {
				error(
					'Duplicated participant!',
					TextualScenarioPackage.Literals.MODEL__PARTICIPANTS,
					index,
					DUPLICATED_NAME
				)
			}
			index++
		}
	}

	/*
	 * Do not allow duplicated messages between name source, target
	 * ex: not allowed: "A1" -> "A2" : "MSG1", "A1" -> "A2" : "MSG1"
	 * ex: allowed: "A1" -> "A2" : "MSG1", "A2" -> "A3" : "MSG1"
	 */
	
	@Check
	def checkDuplicatedSequenceMessageNames(SequenceMessage message) {
		var model = TextualScenarioHelper.getModelContainer(message) 
		checkDuplicated(message, model as Model, newHashSet)	
	}
	
	@Check
	def checkDuplicatedArmTimerMessageNames(ArmTimerMessage message) {
		var model = TextualScenarioHelper.getModelContainer(message) 
		checkDuplicated(message, model as Model, newHashSet)	
	}
	
	def checkDuplicated(Message message, EObject model, HashSet<String> names) {
		var elements = TextualScenarioHelper.getElements(model)
		for (element : elements) {

			if (element instanceof SequenceMessageType || element instanceof ArmTimerMessage) {
				if (!names.add(getMessagesMapKey(element)) && element.equals(message)) {
						error('Duplicated message! The same message is already defined.',
							TextualScenarioPackage.Literals.MESSAGE__NAME)
						return true
					}
			}

			if (element instanceof CombinedFragment || element instanceof Operand) {
				if (checkDuplicated(message, element, names) == true) {
					return true
				}
			}
		}
		return false
	}
	
	@Check
	def checkDeactivateMessagesModel(Model model) {
		checkDeactivateMessages(model)	
	}
	
	@Check
	def checkDeactivateMessagesBlock(Block block) {
		checkDeactivateMessages(block)
	}
	
	
	/*
	 * Checks on deactivation keyword
	 * If we encounter a deactivation on a target, check that we have a corresponding sequence message that can be deactivated
	 */
	def checkDeactivateMessages(EObject model) {
		var index = 0
		// a message shall occur before a deactivation
		// keep this array with the targets of each encountered message to check that the message happens before deactivation
		var messageTargets = newLinkedList
		var elements = TextualScenarioHelper.getElements(model)
		for (obj : elements) {
			if (obj instanceof SequenceMessage && (obj as SequenceMessage).execution !== null) {
				// add the already encountered messages to the list
				messageTargets.add((obj as SequenceMessage).target)
			}
			
			if (obj instanceof ArmTimerMessage && (obj as ArmTimerMessage).execution !== null) {
				// add the already encountered messages to the list
				messageTargets.add((obj as ArmTimerMessage).participant)
			}
			
			
			if (obj instanceof ParticipantDeactivation) {
				var deactivation = obj as ParticipantDeactivation

				// if we already encountered a message with target ad deactivation.name, 
				// we will remove the message from the messages list, because this message is matched with a deactivation
				var removed = messageTargets.remove(deactivation.name)
				if (!removed) {
					// if the deactivation is not matched in a previous message, display an error
					if (model instanceof Model) {
						error(
							'Deactivation keyword not expected!',
							TextualScenarioPackage.Literals.MODEL__ELEMENTS,
							index
						)
					} else if (model instanceof Block) {
						error(
							'Deactivation keyword not expected!',
							TextualScenarioPackage.Literals.BLOCK__BLOCK_ELEMENTS,
							index
						)
					}
				}
			}
			index++
		}
	}

	@Check
	def checkTimelinesMessages(SequenceMessageType message) {
		var participantsNames = TextualScenarioHelper.participantsDefinedBeforeNames(message)
		if (!participantsNames.contains(message.source)) {
			error(String.format("Timeline not defined in text editor!"), TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__SOURCE)
			return
		}

		if (!participantsNames.contains(message.target)) {
			error(String.format("Timeline not defined in text editor!"), TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET)
			return
		}
	}
	
	/*
	 * check if a timeline involved in a combined fragment was used after a delete message was already defined 
	 * on the previous lines on the same timeline
	 */
	@Check
	def checkTimelineUsedAfterDeleteMessage(CombinedFragment combinedFragment) {
		var model = TextualScenarioHelper.getModelContainer(combinedFragment)
		var index = 0
		for (timeline : combinedFragment.timelines) {
			checkElementAfterDelete(model as Model, combinedFragment, timeline,
				TextualScenarioPackage.Literals.COMBINED_FRAGMENT__TIMELINES, index++)
		}
	}

	/*
	 * check if the timeline involved in a state fragment was used after a delete message was already defined 
	 * on the previous lines on the same timeline
	 */
	@Check
	def checkTimelineUsedAfterDeleteMessage(StateFragment fragment) {
		var model = TextualScenarioHelper.getModelContainer(fragment)
		checkElementAfterDelete(model as Model, fragment, fragment.timeline,
			TextualScenarioPackage.Literals.STATE_FRAGMENT__TIMELINE, 0)
	}

	/*
	 * check if a participant involved in arm timer was used after a delete message was already defined 
	 * on the previous lines on the same timeline
	 */
	@Check
	def checkParticipantUsedAfterDeleteMessage(ArmTimerMessage armTimer) {
		var model = TextualScenarioHelper.getModelContainer(armTimer)
		checkElementAfterDelete(model as Model, armTimer, armTimer.participant,
			TextualScenarioPackage.Literals.ARM_TIMER_MESSAGE__PARTICIPANT, 0)
	}

	/*
	 * check if a sequence message source element was used after a delete message was already defined 
	 * on the previous lines on the same timeline
	 */
	@Check
	def checkMessageSourceUsedAfterDeleteMessage(SequenceMessageType message) {
		var model = TextualScenarioHelper.getModelContainer(message)
		checkElementAfterDelete(model as Model, message, message.source,
			TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__SOURCE, 0)
	}
	
	/*
	 * check if a sequence message target element was used after a delete message was already defined 
	 * on the previous lines on the same timeline
	 */
	@Check
	def checkMessageTargetUsedAfterDeleteMessage(SequenceMessageType message) {
		var model = TextualScenarioHelper.getModelContainer(message)
		checkElementAfterDelete(model as Model, message, message.target,
			TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET, 0)
	}
	

	def boolean checkElementAfterDelete(EObject model, EObject checkedElement, String target,
		EAttribute checkedAttribute, int index) {
		var elements = TextualScenarioHelper.getElements(model)

		for (EObject element : elements) {
			if (element.equals(checkedElement)) {
				return true
			}

			if (element instanceof DeleteMessage) {
				if ((element as DeleteMessage).target.equals(target)) {
					error(String.format(
						"Element \"" + target +
							"\" can not be used at this point! A delete message was already defined on this timeline."
					), checkedAttribute, index)
					return true
				}
			}

			if (element instanceof CombinedFragment || element instanceof Operand) {
				if(checkElementAfterDelete(element, checkedElement, target, checkedAttribute, index)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/*
	 * check if create message could be used 
	 */
	@Check
	def checkCreateMessage(CreateMessage createMessage) {
		var model = TextualScenarioHelper.getModelContainer(createMessage)
		if (!checkCreateMessageValid(model as Model, createMessage)) {
			errorCreateMessage(createMessage.target)
		}
	}
	
	def boolean checkCreateMessageValid(EObject model, CreateMessage createMessage) {
		var target = createMessage.target
		var elements = TextualScenarioHelper.getElements(model)
		
		for (EObject element : elements) {
			if (element instanceof SequenceMessageType) {
				if (element.equals(createMessage)) {
					return true
				}

				if ((element as SequenceMessageType).target.equals(target) ||
				(element as SequenceMessageType).source.equals(target)) {
					return false
				}
			}
			
			if (element instanceof ArmTimerMessage) {
				if ((element as ArmTimerMessage).participant.equals(target)) {
					 return false
				}
			}

			if (element instanceof CombinedFragment) {
				if ((element as CombinedFragment).timelines.contains(target)) {
					return false
				} else {
					if (!(checkCreateMessageValid(element, createMessage) as Boolean)) {
						return false
					}
				}
			}
			
			if (element instanceof Operand) {
				if (!(checkCreateMessageValid(element, createMessage) as Boolean)) {
						return false
					}
			}

			if (element instanceof StateFragment) {
				if ((element as StateFragment).timeline.equals(target)) {
					return false
				} 
			}
		}
		return true
	}
	
	def errorCreateMessage(String target) {
		error(String.format("Target \"" + target +"\" can not be used in a create message at this point! Other operations were already defined on this timeline."),
							TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET)
	}
	
	
	/*
	 * Validate a State Fragment
	 */
	@Check
	def checkStateFragment(StateFragment fragment) {
		if (!EmbeddedEditorInstanceHelper.checkValidTimeline(fragment.timeline)) {
			error(String.format("Timeline not present in diagram", fragment.keyword),
				TextualScenarioPackage.Literals.STATE_FRAGMENT__TIMELINE)
			return
		}

		var scenarioType = EmbeddedEditorInstanceHelper.getScenarioType();
		if (fragment.keyword.equals(DslConstants.FUNCTION) && scenarioType.equals(DslConstants.FUNCTIONAL)) {
			error(String.format("\'function\' can not be used in this diagram!"),
				TextualScenarioPackage.Literals.STATE_FRAGMENT__KEYWORD)
			return
		}

		var availableStateFragments = EmbeddedEditorInstanceHelper.getAvailableStateFragments(fragment.keyword,
			fragment.timeline)
		if (!availableStateFragments.contains(fragment.name)) {
			error(
				String.format("This " + fragment.keyword + " does not exist or is not available for \"" +
					fragment.timeline +"\"!"), TextualScenarioPackage.Literals.STATE_FRAGMENT__NAME)
		}

	}
	
	/*
	 * Check that each withExecution message is closed by deactivation (on the proper target)
	 */
	@Check
	def checkWithExecutionHasDeactivateModel(Model model) {
		 checkWithExecutionHasDeactivate(model)
	}
	
	@Check
	def checkWithExecutionHasDeactivateBlock(Block block) {
		checkWithExecutionHasDeactivate(block)
	}
		
	def checkWithExecutionHasDeactivate(EObject model) {
		// keep a list with the target of the messages that contains the withExecution keyword
		// keep also a list with the index on which withExecution message is found, to know on which line to show an error
		var messageWithExecutionTargets = newLinkedList
		var messageWithExecutionTargetsIndex = newLinkedList
		var index = 0
		var elements = TextualScenarioHelper.getElements(model)
		for (obj : elements) {
			if (obj instanceof SequenceMessage && (obj as SequenceMessage).execution !== null) {
				// add the SequenceMessage with execution to a list
				messageWithExecutionTargets.add((obj as SequenceMessage).target)
				messageWithExecutionTargetsIndex.add(index)
			}
			
			if (obj instanceof ArmTimerMessage && (obj as ArmTimerMessage).execution !== null) {
				messageWithExecutionTargets.add((obj as ArmTimerMessage).participant)
				messageWithExecutionTargetsIndex.add(index)
			}
			
			if (obj instanceof ParticipantDeactivation) {
				var targetName = (obj as ParticipantDeactivation).name
				var indexOfTarget = messageWithExecutionTargets.indexOf(targetName)

				if (indexOfTarget >= 0) {
					messageWithExecutionTargets.remove(indexOfTarget)
					messageWithExecutionTargetsIndex.remove(indexOfTarget)
				}
			}
			index++
		}
		// if not all withExecution messages were matched with a deactivation, show an error
		// use the index list to know on which message to display the error
		for (var i = 0; i < messageWithExecutionTargets.size; i++) {
			if (model instanceof Model) {
				error(
					'Deactivation keyword expected for a withExecution message!',
					TextualScenarioPackage.Literals.MODEL__ELEMENTS,
					messageWithExecutionTargetsIndex.get(i)
				)
			} else {
				error(
					'Deactivation keyword expected for a withExecution message!',
					TextualScenarioPackage.Literals.BLOCK__BLOCK_ELEMENTS,
					messageWithExecutionTargets.get(i)
				)
			}
		}
	}
	
	/*
	 * Expression shall not be empty
	 */
	@Check
	def checkCombinedFragmentEmptyExpression(CombinedFragment combinedFragment) {
		if (combinedFragment.expression === null || combinedFragment.expression.isEmpty) {
			error(
				'Expression can not be empty!',
				TextualScenarioPackage.Literals.COMBINED_FRAGMENT__EXPRESSION
			)
		}
	}

	/*
	 * Expression shall not be empty
	 */
	@Check
	def checkOperandEmptyExpression(Operand operand) {
		if (operand.expression === null || operand.expression.isEmpty) {
			error(
				'Expression can not be empty!',
				TextualScenarioPackage.Literals.OPERAND__EXPRESSION
			)
		}
	}

	/*
	 * Else keyword shall be put on a combined fragment that is ALT
	 */
	@Check
	def checkElseKeyworkAvailable(Operand operand) {
		if (operand.eContainer instanceof CombinedFragment) {
			var combinedFragment = operand.eContainer as CombinedFragment
			if (combinedFragment.keyword == 'alt' && !combinedFragment.operands.isEmpty) {
				if (operand.keyword != 'else') {
					error(
						'Expected \'else\' keyword!',
						TextualScenarioPackage.Literals.OPERAND__KEYWORD
					)
				}
			}
		}
	}

	/*
	 * No keyword shall be put on a combined fragment that is not ALT
	 */
	@Check
	def checkKeyworkNotAvailable(Operand operand) {
		if (operand.eContainer instanceof CombinedFragment) {
			var combinedFragment = operand.eContainer as CombinedFragment
			if (combinedFragment.keyword != 'alt' && !combinedFragment.operands.isEmpty) {
				if (operand.keyword !== null || !operand.keyword.isEmpty) {
					error(
						'Unexpected keyword!',
						TextualScenarioPackage.Literals.OPERAND__KEYWORD
					)
				}
			}
		}
	}

	/*
	 * Check that the combine fragments is allocated on valid timelines
	 */
	@Check
	def checkCombinedFragmentOnValidTimelines(CombinedFragment combinedFragment) {
		var participantsDefined = TextualScenarioHelper.participantsDefinedBeforeNames(combinedFragment);
		var index = 0
		for (timeline : combinedFragment.timelines) {
			if (!participantsDefined.contains(timeline)) {
				error('Timeline not defined in text edior!',
				TextualScenarioPackage.Literals.COMBINED_FRAGMENT__TIMELINES, index)
			}
			index++
		}
	}


	def getParticipantsMapKey(Participant p) {
		p.name + ":" + p.keyword
	}

	def getMessagesMapKey(EObject message) {
		if (message instanceof SequenceMessageType) {
			return message.name + ":" + message.source + ":" + message.target
		} 
		
		if (message instanceof ArmTimerMessage) {
			return message.participant + ":" + message.name
		}
	}
}
