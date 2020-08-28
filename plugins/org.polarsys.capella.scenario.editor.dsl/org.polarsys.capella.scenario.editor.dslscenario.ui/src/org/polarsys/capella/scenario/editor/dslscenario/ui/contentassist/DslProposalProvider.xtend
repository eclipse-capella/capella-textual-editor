/*-------------------------------------------------------------------------------
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
 *  
 *  This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License 2.0 which is available at
 *   http://www.eclipse.org/legal/epl-2.0
 *   
 *   SPDX-License-Identifier: EPL-2.0
 *   
 *   Contributors:
 *      Thales - initial API and implementation
 *-------------------------------------------------------------------------------*/
/*
 * generated by Xtext 2.18.0.M3
 */
package org.polarsys.capella.scenario.editor.dslscenario.ui.contentassist

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.eclipse.xtext.Assignment
import org.polarsys.capella.scenario.editor.dslscenario.dsl.Model
import org.polarsys.capella.scenario.editor.dslscenario.dsl.SequenceMessage
import org.polarsys.capella.scenario.editor.dslscenario.dsl.Participant
import org.polarsys.capella.scenario.editor.helper.EmbeddedEditorInstanceHelper
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal

/**
 * This class is used to display auto-complete proposals when pressing ctrl+space
 */
class DslProposalProvider extends AbstractDslProposalProvider {
	/*
	 * filter the proposed keywords based on the context in which we edit the text scenario;
	 * check the context of the Capella Diagram - layer (OA, SA, LA, PA), type of scenario (IS, ES FS)
	 */
	override completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext,
		ICompletionProposalAcceptor acceptor) {
		if (EmbeddedEditorInstanceHelper.checkValidKeyword(keyword.getValue())) {
			super.completeKeyword(keyword, contentAssistContext, acceptor)
		}
	}

	override completeActor_Name(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		getExistingParticipants("actor", context, acceptor)
	}

	override completeComponent_Name(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		getExistingParticipants("component", context, acceptor)
	}

	override completeConfigurationItem_Name(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		getExistingParticipants("configuration_item", context, acceptor)
	}

	override completeFunction_Name(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		getExistingParticipants("function", context, acceptor)
	}

	override completeActivity_Name(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		getExistingParticipants("activity", context, acceptor)
	}

	override completeEntity_Name(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		getExistingParticipants("entity", context, acceptor)
	}

	override completeRole_Name(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		getExistingParticipants("role", context, acceptor)
	}

	/*
	 * propose a list with the participants (parts that can be created
	 * if we have duplicated names in the list we can chose based on the id
	 */
	def getExistingParticipants(
		String keyword,
		ContentAssistContext context,
		ICompletionProposalAcceptor acceptor
	) {
		for (el : EmbeddedEditorInstanceHelper.getAvailableElements(keyword)) {
			// create the proposal
			var proposal = createCompletionProposal("\"" + EmbeddedEditorInstanceHelper.getName(el) + "\"",
				EmbeddedEditorInstanceHelper.getName(el), null, context) as ConfigurableCompletionProposal
			acceptor.accept(proposal);
		}
	}

	override completeSequenceMessage_Source(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		for (EObject el : variablesDefinedBefore2(model as Model)) {
			acceptor.accept(
				createCompletionProposal("\"" + (el as Participant).name + "\"",
					(el as Participant).name,
					null, context))
		}
	}

	override completeSequenceMessage_Target(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		for (EObject el : variablesDefinedBefore3(model as SequenceMessage)) {
			acceptor.accept(
				createCompletionProposal("\"" + (el as Participant).name + "\"", 
					(el as Participant).name,
					null, context))
		}
	}
	
	override completeSequenceMessage_Name(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		for (String el : messagesDefinedBefore(model as SequenceMessage)) {
			acceptor.accept(createCompletionProposal("\"" + el + "\"", "\"" + el + "\"", null, context))

		}
	}

	def messagesDefinedBefore(SequenceMessage message) {
		return EmbeddedEditorInstanceHelper.getExchangeNames(message.getSource, message.getTarget)
	}

	def variablesDefinedBefore(Participant sc) {
		return sc

	}

	def variablesDefinedBefore2(Model m) {
		return m.participants

	}

	def variablesDefinedBefore3(SequenceMessage seq) {
		return (seq.eContainer as Model).participants
	}
}
