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
import org.eclipse.emf.ecore.EAttribute
import java.util.List
import java.util.Set
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Reference
import java.util.HashMap
import java.util.LinkedList
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Element
import org.eclipse.emf.ecore.EReference
import org.polarsys.capella.scenario.editor.dsl.textualScenario.LostMessage
import org.polarsys.capella.scenario.editor.dsl.textualScenario.FoundMessage
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Message
import org.polarsys.capella.scenario.editor.dsl.textualScenario.LostFoundMessage

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class TextualScenarioValidator extends AbstractTextualScenarioValidator {
	public static val INVALID_NAME = 'invalidName'
	public static val DUPLICATED_NAME = 'duplicatedName'
	public static val DUPLICATED_MESSAGES_NAME = 'duplicatedMessageName'
	public static val SAME_SOURCE_AND_TARGET_ERROR = 'Invalid element! Source and target must be different!'
	
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
			error('Exchange does not exist between \"' + message.source + "\" and \"" + message.target +"\"!"
				, TextualScenarioPackage.Literals.MESSAGE__NAME
			)
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
	
	@Check
	def checkSequenceMessagesExchangeType(SequenceMessage sequenceMessage) {
		checkMessagesExchangeType(sequenceMessage)
	}
	
	@Check
	def checkSequenceMessagesExchangeType(LostFoundMessage lostFoundMessage) {
		checkMessagesExchangeType(lostFoundMessage)
	}
	
	/*
	 * check that a CE (component exchange) and an FE (functional exchange) are not used in the same place
	 */
	def checkMessagesExchangeType(Message message) {
		if (EmbeddedEditorInstanceHelper.isESScenario()) {
			var model = TextualScenarioHelper.getModelContainer(message)
			if (model instanceof Model) {
				var scenarioExchangesType = TextualScenarioHelper.
					getScenarioAllowedExchangesType((model as Model).elements)
				var exchangeTypes = TextualScenarioHelper.getAllMessageExchangeType(message) as Set
				if (scenarioExchangesType !== null && !exchangeTypes.contains(scenarioExchangesType)) {
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

	@Check
	def checkDeactivateMessagesModel(Model model) {
		checkDeactivateMessages(model, newLinkedList, model.elements)
	}
	
	/*
	 * Checks on deactivation keyword
	 * If we encounter a deactivation on a target, check that we have a corresponding sequence message that can be deactivated
	 */
	def void checkDeactivateMessages(EObject container,
		LinkedList<String> messageTargets,
		List<Element> elements) {
		var index = 0
		// a message shall occur before a deactivation
		// keep this array with the targets of each encountered message to check that the message happens before deactivation
		for (obj : elements) {
			if (obj instanceof SequenceMessage && (obj as SequenceMessage).execution !== null) {
				// add the already encountered messages to the list
				messageTargets.add((obj as SequenceMessage).target)
			}
			
			if (obj instanceof ArmTimerMessage && (obj as ArmTimerMessage).execution !== null) {
				// add the already encountered messages to the list
				messageTargets.add((obj as ArmTimerMessage).participant)
			}
			
			if (obj instanceof FoundMessage && (obj as FoundMessage).execution !== null) {
				// add the already encountered messages to the list
				messageTargets.add((obj as FoundMessage).target)
			}
			
			if (obj instanceof CombinedFragment) {
				var cf = obj as CombinedFragment
				checkDeactivateMessages(cf.block,
					messageTargets,
					cf.block.blockElements
				)
				cf.operands.forEach[operand | 
					checkDeactivateMessages(operand.block,
						messageTargets,
						operand.block.blockElements
					)
				]
			}
			
			if (obj instanceof ParticipantDeactivation) {
				var refFeature = TextualScenarioPackage.Literals.MODEL__ELEMENTS
				if (container instanceof Block) {
					refFeature = TextualScenarioPackage.Literals.BLOCK__BLOCK_ELEMENTS
				}
				showErrorDeactivateMessages(
					obj as ParticipantDeactivation,
					container,
					messageTargets,
					refFeature,
					index
				)
			}
			index++
		}
	}
	
	def showErrorDeactivateMessages(
		ParticipantDeactivation deactivation,
		EObject container,
		LinkedList<String> messageTargets,
		EReference refFeature,
		int index
	) {
		// if we already encountered a message with target ad deactivation.name, 
		// we will remove the message from the messages list, because this message is matched with a deactivation
		var indexOfTarget = messageTargets.lastIndexOf(deactivation.name)
		if (indexOfTarget < 0) {
			error(
				'Deactivation keyword not expected!',
				container,
				refFeature,
				index
			)
		} else {
			messageTargets.remove(indexOfTarget)
		}
	}
	
	/*
	 * check that the messages we define are valid
	 * if the message is inside a combined fragment, the messages must be between the defined timelines of the combined fragment
	 */
	@Check
	def checkDefinedTimelinesMessages(SequenceMessageType message) {
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
	
	@Check
	def checkContainedTimelinesMessages(SequenceMessageType message) {
		// if the message is inside a combined fragment, check that source and target are covered by it
		var container = TextualScenarioHelper.getDirectContainer(message) 
		if (container instanceof CombinedFragment) {
			var upContainer = getUpperContainerCombinedFragmentTimelines(message, container)
			if(upContainer !== null && upContainer instanceof CombinedFragment) {
				checkTimelinesMessages(message, upContainer as CombinedFragment)
			}
		}
	}
	
	def EObject getUpperContainerCombinedFragmentTimelines(SequenceMessageType message, CombinedFragment container) {
		if (container.timelines.contains(message.source) || container.timelines.contains(message.target)) {
			return container
		} else {
			var upperContainer = TextualScenarioHelper.getDirectContainer(container)
			if (upperContainer instanceof CombinedFragment) {
				return getUpperContainerCombinedFragmentTimelines(message, upperContainer as CombinedFragment);
			}
		}
		return null
	}
	
	def checkTimelinesMessages(SequenceMessageType message, CombinedFragment container) {
		var msg = String.format("Timeline not covered by this " + container.keyword + "!" +
				" Expected values in : " + container.timelines
			)
		if (!container.timelines.contains(message.source)) {
			error(msg,
				TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__SOURCE)
		}

		if (!container.timelines.contains(message.target)) {
			error(msg,
				TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET)
		}
	}
	
	
	@Check
	def checkDeleteMessage(DeleteMessage deleteMessage) {
		checkCreateOrDeleteCouldBeUsed()
		checkSameSourceAndTarget(deleteMessage)
	}
	
	// check that in opened diagram create or delete messages could be used 
	def checkCreateOrDeleteCouldBeUsed() {
		if (EmbeddedEditorInstanceHelper.isFSScenario() ||
			(EmbeddedEditorInstanceHelper.isESScenario() && !EmbeddedEditorInstanceHelper.isInteractionScenario)
		) {
			error("Create or delete message can not be used in this diagram!",
							TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__ARROW)
		}
	}
	
	@Check
	def checkArmTimer(ArmTimerMessage armTimer) {
		// check arm timer could be used in opened diagram
		if (EmbeddedEditorInstanceHelper.isFSScenario()) {
			error("Arm Timer can not be used in this diagram!",
							TextualScenarioPackage.Literals.ARM_TIMER_MESSAGE__ARROW)
		}
		
		// check timeline exist
		if (!TextualScenarioHelper.participantsDefinedBeforeNames(armTimer).contains(armTimer.participant)) {
			error("Timeline not defined in text editor!",
							TextualScenarioPackage.Literals.ARM_TIMER_MESSAGE__PARTICIPANT)
		}
	}
	
	@Check
	def checkLostMessage(LostMessage message) {
		// check lost message could be used in opened diagram
		if (!EmbeddedEditorInstanceHelper.isESScenario()) {
			error("Lost message can not be used in this diagram!",
							TextualScenarioPackage.Literals.LOST_FOUND_MESSAGE__ARROW)
		}
		
		// check timeline exist
		if (!TextualScenarioHelper.participantsDefinedBeforeNames(message).contains(message.source)) {
			error("Timeline not defined in text editor!",
							TextualScenarioPackage.Literals.LOST_MESSAGE__SOURCE)
		}
	}
		
	@Check
	def checkFoundMessage(FoundMessage message) {
		// check found message could be used in opened diagram
		if (!EmbeddedEditorInstanceHelper.isESScenario()) {
			error("Found message can not be used in this diagram!",
							TextualScenarioPackage.Literals.LOST_FOUND_MESSAGE__ARROW)
		}
		
		// check timeline exist
		if (!TextualScenarioHelper.participantsDefinedBeforeNames(message).contains(message.target)) {
			error("Timeline not defined in text editor!",
							TextualScenarioPackage.Literals.FOUND_MESSAGE__TARGET)
		}
	}
	
	def checkSameSourceAndTarget(SequenceMessageType message) {
		if (message.source.equals(message.target)) {
			error(SAME_SOURCE_AND_TARGET_ERROR,
							TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET)
			error(SAME_SOURCE_AND_TARGET_ERROR,
							TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__SOURCE)
		}
	}
	
	/*
	 * check if a timeline involved in a combined fragment was used after a delete message was already defined 
	 * on the previous lines on the same timeline
	 */
	@Check
	def checkTimelineUsedAfterDeleteMessage(CombinedFragment combinedFragment) {
		var model = TextualScenarioHelper.getModelContainer(combinedFragment)
		if (model instanceof Model) {
			var index = 0
			for (timeline : combinedFragment.timelines) {
				checkElementAfterDelete(model as Model, combinedFragment, timeline,
					TextualScenarioPackage.Literals.COMBINED_FRAGMENT__TIMELINES, index++)
			}
		}
	}

	/*
	 * check if the timeline involved in a state fragment was used after a delete message was already defined 
	 * on the previous lines on the same timeline
	 */
	@Check
	def checkTimelineUsedAfterDeleteMessage(StateFragment fragment) {
		var model = TextualScenarioHelper.getModelContainer(fragment)
		if (model instanceof Model)
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
		if (model instanceof Model)
			checkElementAfterDelete(model as Model, armTimer, armTimer.participant,
				TextualScenarioPackage.Literals.ARM_TIMER_MESSAGE__PARTICIPANT, 0)
	}
	
	/*
	 * check if a participant involved in a lost message was used after a delete message was already defined 
	 * on the previous lines on the same timeline
	 */
	@Check
	def checkParticipantUsedAfterLostMessage(LostMessage message) {
		var model = TextualScenarioHelper.getModelContainer(message)
		if (model instanceof Model)
			checkElementAfterDelete(model as Model, message, message.source,
				TextualScenarioPackage.Literals.LOST_MESSAGE__SOURCE, 0)
	}
	
	/*
	 * check if a participant involved in a lost message was used after a delete message was already defined 
	 * on the previous lines on the same timeline
	 */
	@Check
	def checkParticipantUsedAfterFoundMessage(FoundMessage message) {
		var model = TextualScenarioHelper.getModelContainer(message)
		if (model instanceof Model)
			checkElementAfterDelete(model as Model, message, message.target,
				TextualScenarioPackage.Literals.FOUND_MESSAGE__TARGET, 0)
	}

	/*
	 * check if a sequence message source element was used after a delete message was already defined 
	 * on the previous lines on the same timeline
	 */
	@Check
	def checkMessageSourceUsedAfterDeleteMessage(SequenceMessageType message) {
		var model = TextualScenarioHelper.getModelContainer(message)
		if (model instanceof Model)
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
		if (model instanceof Model)
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

			if (element instanceof CombinedFragment) {
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
		// check if create message could be used in opened diagram
		checkCreateOrDeleteCouldBeUsed()
		
		// check if source and target are the same
		checkSameSourceAndTarget(createMessage)
		var model = TextualScenarioHelper.getModelContainer(createMessage)
		if (model instanceof Model && !checkCreateMessageValid(model as Model, createMessage)) {
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
			
			if (element instanceof LostMessage) {
				if ((element as LostMessage).source.equals(target)) {
					 return false
				}
			}
			
			if (element instanceof FoundMessage) {
				if ((element as FoundMessage).target.equals(target)) {
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
			
			if (element instanceof StateFragment) {
				if ((element as StateFragment).timeline.equals(target)) {
					return false
				} 
			}
			
			if (element instanceof Reference) {
				if ((element as Reference).timelines.contains(target)) {
					return false;
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
		if (!TextualScenarioHelper.participantsDefinedBeforeNames(fragment).contains(fragment.timeline)) {
			error(String.format("Timeline not defined in text editor!", fragment.keyword),
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
		var messageWithExecutionTargets = newLinkedList
		var messageWithExecutionTargetsIndex = newLinkedList
		var messageWithExecutionTargetsContainer = newLinkedList
		checkWithExecutionHasDeactivate(model,
			messageWithExecutionTargets,
			messageWithExecutionTargetsIndex,
			messageWithExecutionTargetsContainer,
			model.elements
		)
		
		showErrorWithExecutionHasDeactivate(messageWithExecutionTargets, messageWithExecutionTargetsIndex, messageWithExecutionTargetsContainer)
	}
	
	def void showErrorWithExecutionHasDeactivate(
		LinkedList<String> messageWithExecutionTargets,
		LinkedList<Integer> messageWithExecutionTargetsIndex,
		LinkedList<EObject> messageWithExecutionTargetsContainer
	) {
		// if not all withExecution messages were matched with a deactivation, show an error
		// use the index list to know on which message to display the error
		for (var i = 0; i < messageWithExecutionTargets.size; i++) {
			var container = messageWithExecutionTargetsContainer.get(i)
			if (container instanceof Model) {
				error(
					'Deactivation keyword expected for a withExecution message!',
					container,
					TextualScenarioPackage.Literals.MODEL__ELEMENTS,
					messageWithExecutionTargetsIndex.get(i)
				)
			} else if (container instanceof Block) {
				error(
					'Deactivation keyword expected for a withExecution message!',
					container,
					TextualScenarioPackage.Literals.BLOCK__BLOCK_ELEMENTS,
					messageWithExecutionTargets.get(i)
				)
			}
		}
	}
		
	def void checkWithExecutionHasDeactivate(EObject container,
		LinkedList<String> messageWithExecutionTargets,
		LinkedList<Integer> messageWithExecutionTargetsIndex,
		LinkedList<EObject> messageWithExecutionTargetsContainer,
		List<Element> elements
	) {
		// keep a list with the target of the messages that contains the withExecution keyword
		// keep also a list with the index on which withExecution message is found, to know on which line to show an error
		var index = 0
		for (obj : elements) {
			if (obj instanceof SequenceMessage && (obj as SequenceMessage).execution !== null) {
				// add the SequenceMessage with execution to a list
				messageWithExecutionTargets.add((obj as SequenceMessage).target)
				messageWithExecutionTargetsIndex.add(index)
				messageWithExecutionTargetsContainer.add(container)
			}
			
			if (obj instanceof ArmTimerMessage && (obj as ArmTimerMessage).execution !== null) {
				messageWithExecutionTargets.add((obj as ArmTimerMessage).participant)
				messageWithExecutionTargetsIndex.add(index)
				messageWithExecutionTargetsContainer.add(container)
			}
			
			if (obj instanceof FoundMessage && (obj as FoundMessage).execution !== null) {
				messageWithExecutionTargets.add((obj as FoundMessage).target)
				messageWithExecutionTargetsIndex.add(index)
				messageWithExecutionTargetsContainer.add(container)
			}
			
			if (obj instanceof CombinedFragment) {
				var cf = obj as CombinedFragment
				checkWithExecutionHasDeactivate(cf.block, messageWithExecutionTargets,
					messageWithExecutionTargetsIndex,
					messageWithExecutionTargetsContainer,
					cf.block.blockElements
				)
				cf.operands.forEach[operand | 
					checkWithExecutionHasDeactivate(operand.block,
						messageWithExecutionTargets,
						messageWithExecutionTargetsIndex,
						messageWithExecutionTargetsContainer,
						operand.block.blockElements
					)
				]
			}
			
			if (obj instanceof ParticipantDeactivation) {
				var targetName = (obj as ParticipantDeactivation).name
				var indexOfTarget = messageWithExecutionTargets.lastIndexOf(targetName)

				if (indexOfTarget >= 0) {
					messageWithExecutionTargets.remove(indexOfTarget)
					messageWithExecutionTargetsIndex.remove(indexOfTarget)
					messageWithExecutionTargetsContainer.remove(indexOfTarget)
				}
			}
			index++
		}
	}
	
	/*
	 * Expression shall not be empty
	 */
	//	@Check
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
//	@Check
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
				error('Timeline not defined in text editor!',
				TextualScenarioPackage.Literals.COMBINED_FRAGMENT__TIMELINES, index)
			}
			index++
		}
	}

	/*
	 * Check that a inner combine fragment has timelines over a subset in the parent combined fragment
	 */
	@Check
	def checkContainedCombinedFragment(CombinedFragment combinedFragment) {
		var container = TextualScenarioHelper.getDirectContainer(combinedFragment)
		if (container instanceof CombinedFragment) {
			var upperContainer = getContainerCombinedFragmentTimelines(combinedFragment.timelines, container)
			if (upperContainer !== null && upperContainer instanceof CombinedFragment) {
				error(
					'Timelines covered by this ' + combinedFragment.keyword +
						' must be a subset of the parent covered timelines ' +
						(upperContainer as CombinedFragment).timelines + "!",
					TextualScenarioPackage.Literals.COMBINED_FRAGMENT__TIMELINES
				)
			}
		}
	}
	
	@Check
	def checkReference(Reference reference) {
		// check duplicated timelines
		var hashMap = new HashMap<String, Integer>()
		var index = 0;
		for (timeline : reference.timelines) {
			if (hashMap.get(timeline) == null) {
				hashMap.put(timeline, 1)
			} else {
				error('Duplicated timeline!',
				TextualScenarioPackage.Literals.REFERENCE__TIMELINES, index)
			}
			index++
		}
		
		// check valid timeline (participant exists in xtext)
		var participantsDefined = TextualScenarioHelper.participantsDefinedBeforeNames(reference);
		index = 0
		for (timeline : reference.timelines) {
			if (!participantsDefined.contains(timeline)) {
				error('Timeline not defined in text editor!',
				TextualScenarioPackage.Literals.REFERENCE__TIMELINES, index)
			}
			index++
		}
		
		// check reference exists
		if (!EmbeddedEditorInstanceHelper.referencedScenariosName.contains(reference.name)) {
			error('Referenced scenario does not exist!',
				TextualScenarioPackage.Literals.REFERENCE__NAME)
		}
		
		// check that timelines are a subset of combined fragment timelines
		var container = TextualScenarioHelper.getDirectContainer(reference)
		if (container instanceof CombinedFragment) {
			var upperContainer = getContainerCombinedFragmentTimelines(reference.timelines, container)
			if (upperContainer !== null && upperContainer instanceof CombinedFragment) {
				error(
					'Timelines covered by this reference must be a subset of the parent covered timelines ' +
						(upperContainer as CombinedFragment).timelines + "!",
					TextualScenarioPackage.Literals.REFERENCE__TIMELINES
				)
			}
		}
		// check timeline used after delete message
		var model = TextualScenarioHelper.getModelContainer(reference)
		if (model instanceof Model) {
			index = 0
			for (timeline : reference.timelines) {
				checkElementAfterDelete(model as Model, reference, timeline,
					TextualScenarioPackage.Literals.REFERENCE__TIMELINES, index++)
			}
		}
	}
	
	def EObject getContainerCombinedFragmentTimelines(List<String> timelines, CombinedFragment container) {
		// timeline must be a subset of the parent timeline
		if (innerCombinedFragment(timelines, container) &&
			!isASubset(timelines, (container as CombinedFragment).timelines)) {
			return container
		} else {
			var upperContainer = TextualScenarioHelper.getDirectContainer(container)
			if (upperContainer instanceof CombinedFragment) {
				return getContainerCombinedFragmentTimelines(timelines, upperContainer as CombinedFragment);
			}
		}
		return null
	}
	
	/*
	 * check if the smallList is a subset in the containerList
	 */
	def boolean isASubset(List<String> smallList, List<String> containerList) {
		for (element : smallList) {
			if(!containerList.contains(element)) {
				return false
			}
		}
		return true
	}
	
	/*
	 * check if the smallList is a sublist in the containerList
	 */
	def boolean isASublist(List<String> smallList, List<String> containerList) {
		for (var i = 0; i < containerList.size; i++) {
			if (i < containerList.size &&  (i + smallList.size) <= containerList.size) {
				var subset = containerList.subList(i, i + smallList.size)
				if (subset !== null && smallList.equals(subset))
					return true
			}
		}
		return false
	}
	/*
	 * we consider that it is a inner combined fragment if it has some same timelines as the parent
	 * added this due to the limitation that a paralel combined fragment in diagram, is represented inside the text
	 */
	def boolean innerCombinedFragment(List<String> timelines, CombinedFragment container) {
		for (timeline : timelines) {
			if (container.timelines.contains(timeline))
				return true
		}
		return false
	}

	def getParticipantsMapKey(Participant p) {
		p.name + ":" + p.keyword
	}

	def getElementMapKey(EObject element) {
		
		if (element instanceof CombinedFragment) {
			var key = element.keyword + element.expression
			for (String timeline : element.timelines.toSet.sort) {
				key = key + ":" + timeline
			}
			return key
			
		}
		if (element instanceof SequenceMessageType) {
			return element.name + ":" + element.arrow + ":" + element.source + ":" + element.target
		} 
		
		if (element instanceof ArmTimerMessage) {
			return element.participant + ":" + element.name
		}
	}
}
