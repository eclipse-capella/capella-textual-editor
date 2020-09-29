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
import org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment
import org.polarsys.capella.scenario.editor.EmbeddedEditorInstance

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class TextualScenarioValidator extends AbstractTextualScenarioValidator {

	public static val INVALID_NAME = 'invalidName'
	public static val DUPILCATED_NAME = 'duplicatedName'
	public static val DUPILCATED_MESSAGES_NAME = 'duplicatedMessageName'

	@Check
	def checkPartExists(Participant participant) {
		if (!EmbeddedEditorInstanceHelper.getAvailablePartNames(participant.keyword).contains(participant.name)) {
			if (participant instanceof Function) {
				error('Function does not exist', TextualScenarioPackage.Literals.PARTICIPANT__NAME, INVALID_NAME)
			} else {
				error('Represented part does not exist', TextualScenarioPackage.Literals.PARTICIPANT__NAME,
					INVALID_NAME)
			}
		}
	}

	@Check
	def checkParticipantKeywordIsValid(Participant participant) {
		if (!EmbeddedEditorInstanceHelper.checkValidKeyword(participant.keyword)) {
			error('\'' + participant.keyword + '\' could not be used in this diagram',
				TextualScenarioPackage.Literals.PARTICIPANT__KEYWORD)
		}
	}

	@Check
	def checkMessagesExist(SequenceMessage message) {
		if (EmbeddedEditorInstanceHelper.getScenarioType().equals("INTERFACE") &&
			!EmbeddedEditorInstanceHelper.getExchangeNames(message.getSource, message.getTarget).contains(
				message.name)) {
			error('Message does not exist', TextualScenarioPackage.Literals.MESSAGE__NAME)
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
					'Multiple participants with the same name',
					TextualScenarioPackage.Literals.MODEL__PARTICIPANTS,
					index,
					DUPILCATED_NAME
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
	def checkDuplicatedMessagesNames(Model model) {
		var index = 0
		val names = newHashSet
		for (p : model.elements) {
			if (p instanceof SequenceMessageType) {
				if (!names.add(getMessagesMapKey(p))) {
					error(
						'Multiple messages with the same name',
						TextualScenarioPackage.Literals.MODEL__ELEMENTS,
						index,
						DUPILCATED_MESSAGES_NAME
					)
				}
			}
			index++
		}
	}

	/*
	 * Checks on deactivation keyword
	 * If we encounter a deactivation on a target, check that we have a corresponding sequence message that can be deactivated
	 */
	@Check
	def checkDeactivateMessages(Model model) {
		var index = 0
		// a message shall occur before a deactivation
		// keep this array with the targets of each encountered message to check that the message happens before deactivation
		var messageTargets = newLinkedList
		for (obj : model.elements) {
			if (obj instanceof SequenceMessage) {
				// add the already encountered messages to the list
				messageTargets.add((obj as SequenceMessage).target)
			}
			if (obj instanceof ParticipantDeactivation) {
				var deactivation = obj as ParticipantDeactivation

				// if we already encountered a message with target ad deactivation.name, 
				// we will remove the message from the messages list, because this message is matched with a deactivation
				var removed = messageTargets.remove(deactivation.name)
				if (!removed) {
					// if the deactivation is not matched in a previous message, display an error
					error(
						'Deactivation keyword not expected',
						TextualScenarioPackage.Literals.MODEL__ELEMENTS,
						index
					)
				}
			}
			index++
		}
	}
	/*
	 * Check that the state fragment exists
	 */
	@Check
	def checkStateFragment(StateFragment fragment) {
		if (fragment.timeline === null) {
			error(String.format("Insert timeline"), TextualScenarioPackage.Literals.STATE_FRAGMENT__TIMELINE)
			return
		}
		if (fragment.keyword === null) {
			error(String.format("Insert \"state\", \"mode\" or \"function\""), TextualScenarioPackage.Literals.STATE_FRAGMENT__KEYWORD)
			return
		}
		
		if (fragment.name === null ) {
			error(String.format("Insert the " + fragment.keyword + " name"), TextualScenarioPackage.Literals.STATE_FRAGMENT__NAME)
			return
		}
		
		var availableStateFragments = EmbeddedEditorInstanceHelper.getAvailableStateFragments(fragment.keyword, fragment.timeline)
		if (!availableStateFragments.contains(fragment.name) ) {
			error(String.format("This " + fragment.keyword + " does not exist or it's not available for " + fragment.timeline), TextualScenarioPackage.Literals.STATE_FRAGMENT__NAME)
		}
		
		if (!EmbeddedEditorInstanceHelper.checkValidTimeline(fragment.timeline)){
			error(String.format("This timeline does not exist", fragment.keyword), TextualScenarioPackage.Literals.STATE_FRAGMENT__TIMELINE)
		}
	}

	/*
	 * Check that each withExecution message is closed by deactivation (on the proper target)
	 */
	@Check
	def checkWithExecutionHasDeactivate(Model model) {
		// keep a list with the target of the messages that contains the withExecution keyword
		// keep also a list with the index on which withExecution message is found, to know on which line to show an error
		var messageWithExecutionTargets = newLinkedList
		var messageWithExecutionTargetsIndex = newLinkedList
		var index = 0
		for (obj : model.elements) {
			if (obj instanceof SequenceMessage && (obj as SequenceMessage).execution !== null) {
				// add the SequenceMessage with execution to a list
				messageWithExecutionTargets.add((obj as SequenceMessage).target)
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
			error(
				'Deactivation keyword expected for a withExecution message',
				TextualScenarioPackage.Literals.MODEL__ELEMENTS,
				messageWithExecutionTargetsIndex.get(i)
			)
		}
	}

	def getParticipantsMapKey(Participant p) {
		p.name + ":" + p.keyword
	}

	def getMessagesMapKey(SequenceMessageType m) {
		m.name + ":" + m.source + ":" + m.target
	}
}
