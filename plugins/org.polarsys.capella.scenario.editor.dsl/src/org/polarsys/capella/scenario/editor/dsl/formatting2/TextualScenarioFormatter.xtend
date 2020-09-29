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
package org.polarsys.capella.scenario.editor.dsl.formatting2

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.polarsys.capella.scenario.editor.dsl.services.TextualScenarioGrammarAccess
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model
import org.polarsys.capella.scenario.editor.dsl.textualScenario.TextualScenarioPackage
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Message
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Block
import org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment
import org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Operand

class TextualScenarioFormatter extends AbstractFormatter2 {
	
	@Inject extension TextualScenarioGrammarAccess

	def dispatch void format(Model model, extension IFormattableDocument document) {
		val begin = model.regionFor.feature(TextualScenarioPackage.Literals.MODEL__BEGIN)
		val end = model.regionFor.feature(TextualScenarioPackage.Literals.MODEL__END)
		begin.prepend[noSpace]
		begin.append[newLine]
		interior(begin, end)[indent]
		
		// call formatting function for each participant and message or references
		model.participants.forEach[ element | element.format ]
		model.elements.forEach[ element | element.format ]
	}

	def dispatch void format(Message message, extension IFormattableDocument document) {
		// each messages definition on a separate line
		message.regionFor.feature(TextualScenarioPackage.Literals.MESSAGE__NAME).append[newLine]
	}

	def dispatch void format(Participant participant, extension IFormattableDocument document) {
		// each participant definition on a separate line
		val p = participant.regionFor.feature(TextualScenarioPackage.Literals.PARTICIPANT__NAME)
		participant.regionFor.feature(TextualScenarioPackage.Literals.PARTICIPANT__NAME).append[newLine]
	}
	
	def dispatch void format(CombinedFragment fragment, extension IFormattableDocument document) {
		format(fragment.block, document)
		fragment.operands.forEach[ element | element.format ]
		fragment.append[newLine]
	}
	
	def dispatch void format(Operand operand, extension IFormattableDocument document) {
		format(operand.block, document)
	}
	
	def dispatch void format(Block block, extension IFormattableDocument document) {
		val begin = block.regionFor.feature(TextualScenarioPackage.Literals.BLOCK__BEGIN)
		val end = block.regionFor.feature(TextualScenarioPackage.Literals.BLOCK__END)
		
		begin.append[newLine]
		interior(begin, end)[indent]
		
		block.blockElements.forEach[ element | element.format ]
	}
	
	def dispatch void format(StateFragment stateFragment, extension IFormattableDocument document) {
		stateFragment.regionFor.feature(TextualScenarioPackage.Literals.STATE_FRAGMENT__NAME).append[newLine]
	}
}
