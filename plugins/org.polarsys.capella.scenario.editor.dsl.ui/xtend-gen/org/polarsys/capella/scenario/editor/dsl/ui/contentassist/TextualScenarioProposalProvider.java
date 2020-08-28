/**
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
 */
package org.polarsys.capella.scenario.editor.dsl.ui.contentassist;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.polarsys.capella.core.model.helpers.CapellaElementExt;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage;
import org.polarsys.capella.scenario.editor.dsl.ui.contentassist.AbstractTextualScenarioProposalProvider;
import org.polarsys.capella.scenario.editor.helper.EmbeddedEditorInstanceHelper;

/**
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist
 * on how to customize the content assistant.
 */
@SuppressWarnings("all")
public class TextualScenarioProposalProvider extends AbstractTextualScenarioProposalProvider {
  /**
   * filter the proposed keywords based on the context in which we edit the text scenario;
   * check the context of the Capella Diagram - layer (OA, SA, LA, PA), type of scenario (IS, ES FS)
   */
  @Override
  public void completeKeyword(final Keyword keyword, final ContentAssistContext contentAssistContext, final ICompletionProposalAcceptor acceptor) {
    boolean _checkValidKeyword = EmbeddedEditorInstanceHelper.checkValidKeyword(keyword.getValue());
    if (_checkValidKeyword) {
      super.completeKeyword(keyword, contentAssistContext, acceptor);
    }
  }
  
  @Override
  public void completeActor_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    this.getExistingParticipants("actor", context, acceptor);
  }
  
  @Override
  public void completeComponent_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    this.getExistingParticipants("component", context, acceptor);
  }
  
  @Override
  public void completeConfigurationItem_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    this.getExistingParticipants("configuration_item", context, acceptor);
  }
  
  @Override
  public void completeFunction_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    this.getExistingParticipants("function", context, acceptor);
  }
  
  @Override
  public void completeActivity_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    this.getExistingParticipants("activity", context, acceptor);
  }
  
  @Override
  public void completeEntity_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    this.getExistingParticipants("entity", context, acceptor);
  }
  
  @Override
  public void completeRole_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    this.getExistingParticipants("role", context, acceptor);
  }
  
  /**
   * propose a list with the participants (parts that can be created
   * if we have duplicated names in the list we can chose based on the id
   */
  public void getExistingParticipants(final String keyword, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    Collection<? extends EObject> _availableElements = EmbeddedEditorInstanceHelper.getAvailableElements(keyword);
    for (final EObject el : _availableElements) {
      {
        String elementName = CapellaElementExt.getName(el);
        EObject _rootModel = context.getRootModel();
        boolean _participantAlreadyInserted = this.participantAlreadyInserted(((Model) _rootModel), elementName, keyword);
        boolean _not = (!_participantAlreadyInserted);
        if (_not) {
          ICompletionProposal _createCompletionProposal = this.createCompletionProposal((("\"" + elementName) + "\""), elementName, null, context);
          ConfigurableCompletionProposal proposal = ((ConfigurableCompletionProposal) _createCompletionProposal);
          acceptor.accept(proposal);
        }
      }
    }
  }
  
  /**
   * check if a participant is already used in the text
   */
  public boolean participantAlreadyInserted(final Model model, final String name, final String keyword) {
    EList<Participant> _participants = model.getParticipants();
    for (final Participant participant : _participants) {
      if ((Objects.equal(participant.getKeyword(), keyword) && Objects.equal(participant.getName(), name))) {
        return true;
      }
    }
    return false;
  }
  
  @Override
  public void completeSequenceMessage_Source(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    EList<Participant> _variablesDefinedBefore2 = this.variablesDefinedBefore2(((Model) model));
    for (final EObject el : _variablesDefinedBefore2) {
      String _name = ((Participant) el).getName();
      String _plus = ("\"" + _name);
      String _plus_1 = (_plus + "\"");
      acceptor.accept(
        this.createCompletionProposal(_plus_1, ((Participant) el).getName(), null, context));
    }
  }
  
  @Override
  public void completeSequenceMessage_Target(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    EList<Participant> _variablesDefinedBefore3 = this.variablesDefinedBefore3(((SequenceMessage) model));
    for (final EObject el : _variablesDefinedBefore3) {
      String _name = ((Participant) el).getName();
      String _plus = ("\"" + _name);
      String _plus_1 = (_plus + "\"");
      acceptor.accept(
        this.createCompletionProposal(_plus_1, ((Participant) el).getName(), null, context));
    }
  }
  
  @Override
  public void completeSequenceMessage_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    SequenceMessage sequenceMessage = ((SequenceMessage) model);
    List<String> _messagesDefinedBefore = this.messagesDefinedBefore(((SequenceMessage) model));
    for (final String el : _messagesDefinedBefore) {
      {
        EObject _rootModel = context.getRootModel();
        ((Model) _rootModel).getElements();
        EObject _rootModel_1 = context.getRootModel();
        boolean _messageAlreadyInserted = this.messageAlreadyInserted(((Model) _rootModel_1), sequenceMessage.getSource(), sequenceMessage.getTarget(), el);
        boolean _not = (!_messageAlreadyInserted);
        if (_not) {
          acceptor.accept(this.createCompletionProposal((("\"" + el) + "\""), (("\"" + el) + "\""), null, context));
        }
      }
    }
  }
  
  @Override
  public void completeStateFragment_Keyword(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    ArrayList<String> keywords = CollectionLiterals.<String>newArrayList("state", "mode", "function");
    for (final String keyword : keywords) {
      acceptor.accept(this.createCompletionProposal(keyword, keyword, null, context));
    }
  }
  
  /**
   * check if a message is already used in the text
   */
  public boolean messageAlreadyInserted(final Model model, final String source, final String target, final String name) {
    EList<EObject> _elements = model.getElements();
    for (final EObject element : _elements) {
      if ((element instanceof SequenceMessage)) {
        SequenceMessage message = ((SequenceMessage) element);
        if (((Objects.equal(message.getName(), name) && Objects.equal(message.getSource(), source)) && Objects.equal(message.getTarget(), target))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public List<String> messagesDefinedBefore(final SequenceMessage message) {
    return EmbeddedEditorInstanceHelper.getExchangeNames(message.getSource(), message.getTarget());
  }
  
  public Participant variablesDefinedBefore(final Participant sc) {
    return sc;
  }
  
  public EList<Participant> variablesDefinedBefore2(final Model m) {
    return m.getParticipants();
  }
  
  public EList<Participant> variablesDefinedBefore3(final SequenceMessage seq) {
    EObject _eContainer = seq.eContainer();
    return ((Model) _eContainer).getParticipants();
  }
}
