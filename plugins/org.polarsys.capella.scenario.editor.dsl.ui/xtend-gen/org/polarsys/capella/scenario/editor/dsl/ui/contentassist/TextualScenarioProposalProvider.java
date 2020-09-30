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
import java.util.Collections;
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
import org.polarsys.capella.core.data.cs.ExchangeItemAllocation;
import org.polarsys.capella.core.data.epbs.EPBSArchitecture;
import org.polarsys.capella.core.data.information.AbstractEventOperation;
import org.polarsys.capella.core.model.helpers.CapellaElementExt;
import org.polarsys.capella.scenario.editor.dsl.helpers.TextualScenarioHelper;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.CreateMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.DeleteMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment;
import org.polarsys.capella.scenario.editor.dsl.ui.contentassist.AbstractTextualScenarioProposalProvider;
import org.polarsys.capella.scenario.editor.helper.DslConstants;
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
    boolean _isParticipantKeyword = TextualScenarioHelper.isParticipantKeyword(keyword.getValue());
    if (_isParticipantKeyword) {
      boolean _checkValidKeyword = EmbeddedEditorInstanceHelper.checkValidKeyword(keyword.getValue());
      if (_checkValidKeyword) {
        super.completeKeyword(keyword, contentAssistContext, acceptor);
      }
    } else {
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
   * propose a list with the timelines (for adding states, modes or allocated functions)
   */
  public void getExistingTimelines(final String keyword, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    Collection<? extends EObject> _availableElements = EmbeddedEditorInstanceHelper.getAvailableElements(keyword);
    for (final EObject el : _availableElements) {
      {
        String elementName = CapellaElementExt.getName(el);
        ICompletionProposal _createCompletionProposal = this.createCompletionProposal((("\"" + elementName) + "\""), elementName, null, context);
        ConfigurableCompletionProposal proposal = ((ConfigurableCompletionProposal) _createCompletionProposal);
        acceptor.accept(proposal);
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
    EList<Participant> _participantsDefinedBefore = TextualScenarioHelper.participantsDefinedBefore(model);
    for (final EObject el : _participantsDefinedBefore) {
      String _name = ((Participant) el).getName();
      String _plus = ("\"" + _name);
      String _plus_1 = (_plus + "\"");
      acceptor.accept(
        this.createCompletionProposal(_plus_1, ((Participant) el).getName(), null, context));
    }
  }
  
  @Override
  public void completeSequenceMessage_Arrow(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    acceptor.accept(this.createCompletionProposal("->", "-> : Sequence Message", null, context));
  }
  
  @Override
  public void completeSequenceMessage_Target(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    EList<Participant> _participantsDefinedBefore = TextualScenarioHelper.participantsDefinedBefore(model);
    for (final EObject el : _participantsDefinedBefore) {
      String _name = ((Participant) el).getName();
      String _plus = ("\"" + _name);
      String _plus_1 = (_plus + "\"");
      acceptor.accept(
        this.createCompletionProposal(_plus_1, ((Participant) el).getName(), null, context));
    }
  }
  
  @Override
  public void completeSequenceMessage_DoubleDot(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    acceptor.accept(this.createCompletionProposal(":", ":", null, context));
  }
  
  @Override
  public void completeSequenceMessage_Name(final EObject messageObj, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    EObject _rootModel = context.getRootModel();
    Object scenarioExchangesType = TextualScenarioHelper.getScenarioAllowedExchangesType(((Model) _rootModel).getElements());
    SequenceMessage message = ((SequenceMessage) messageObj);
    List<AbstractEventOperation> exchangesAvailable = EmbeddedEditorInstanceHelper.getExchangeMessages(message.getSource(), message.getTarget());
    String elementName = new String();
    for (final EObject element : exchangesAvailable) {
      {
        EObject _rootModel_1 = context.getRootModel();
        ((Model) _rootModel_1).getElements();
        boolean _isInterfaceScenario = EmbeddedEditorInstanceHelper.isInterfaceScenario();
        if (_isInterfaceScenario) {
          elementName = CapellaElementExt.getName(((ExchangeItemAllocation) element).getAllocatedItem());
        } else {
          elementName = CapellaElementExt.getName(element);
        }
        EObject _rootModel_2 = context.getRootModel();
        boolean _messageAlreadyInserted = this.messageAlreadyInserted(((Model) _rootModel_2), message.getSource(), message.getTarget(), elementName);
        boolean _not = (!_messageAlreadyInserted);
        if (_not) {
          String exchangeType = TextualScenarioHelper.getExchangeType(element);
          if ((Objects.equal(scenarioExchangesType, null) || scenarioExchangesType.equals(exchangeType))) {
            acceptor.accept(
              this.createCompletionProposal((("\"" + elementName) + "\""), (("\"" + elementName) + "\""), null, context));
          }
        }
      }
    }
  }
  
  @Override
  public void completeCreateMessage_Arrow(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    if (((!EmbeddedEditorInstanceHelper.isFSScenario()) && (!EmbeddedEditorInstanceHelper.isESScenario()))) {
      acceptor.accept(this.createCompletionProposal("->+", "->+ : Create Message", null, context));
    }
    if ((EmbeddedEditorInstanceHelper.isInteractionScenario() && (!EmbeddedEditorInstanceHelper.isFSScenario()))) {
      acceptor.accept(this.createCompletionProposal("->+", "->+ : Create Message", null, context));
    }
  }
  
  @Override
  public void completeCreateMessage_Target(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    String source = ((CreateMessage) model).getSource();
    EList<Participant> _participantsDefinedBefore = TextualScenarioHelper.participantsDefinedBefore(model);
    for (final EObject el : _participantsDefinedBefore) {
      boolean _equals = ((Participant) el).getName().equals(source);
      boolean _not = (!_equals);
      if (_not) {
        String _name = ((Participant) el).getName();
        String _plus = ("\"" + _name);
        String _plus_1 = (_plus + "\"");
        acceptor.accept(
          this.createCompletionProposal(_plus_1, ((Participant) el).getName(), null, context));
      }
    }
  }
  
  @Override
  public void completeCreateMessage_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    this.completeCreateDeleteMessageName(model, context, acceptor);
  }
  
  @Override
  public void completeCreateMessage_DoubleDot(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    acceptor.accept(this.createCompletionProposal(":", ":", null, context));
  }
  
  @Override
  public void completeDeleteMessage_Arrow(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    if (((!EmbeddedEditorInstanceHelper.isFSScenario()) && (!EmbeddedEditorInstanceHelper.isESScenario()))) {
      acceptor.accept(this.createCompletionProposal("->x", "->x : Delete Message", null, context));
    }
    if ((EmbeddedEditorInstanceHelper.isInteractionScenario() && (!EmbeddedEditorInstanceHelper.isFSScenario()))) {
      acceptor.accept(this.createCompletionProposal("->x", "->x : Delete Message", null, context));
    }
  }
  
  @Override
  public void completeDeleteMessage_Target(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    String source = ((DeleteMessage) model).getSource();
    EList<Participant> _participantsDefinedBefore = TextualScenarioHelper.participantsDefinedBefore(model);
    for (final EObject el : _participantsDefinedBefore) {
      boolean _equals = ((Participant) el).getName().equals(source);
      boolean _not = (!_equals);
      if (_not) {
        String _name = ((Participant) el).getName();
        String _plus = ("\"" + _name);
        String _plus_1 = (_plus + "\"");
        acceptor.accept(
          this.createCompletionProposal(_plus_1, ((Participant) el).getName(), null, context));
      }
    }
  }
  
  @Override
  public void completeDeleteMessage_DoubleDot(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    acceptor.accept(this.createCompletionProposal(":", ":", null, context));
  }
  
  @Override
  public void completeDeleteMessage_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    this.completeCreateDeleteMessageName(model, context, acceptor);
  }
  
  @Override
  public void completeArmTimerMessage_Arrow(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    boolean _isFSScenario = EmbeddedEditorInstanceHelper.isFSScenario();
    boolean _not = (!_isFSScenario);
    if (_not) {
      acceptor.accept(this.createCompletionProposal("->>", "->> : Arm Timer", null, context));
    }
  }
  
  @Override
  public void completeArmTimerMessage_Participant(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    EList<Participant> _participantsDefinedBefore = TextualScenarioHelper.participantsDefinedBefore(model);
    for (final EObject el : _participantsDefinedBefore) {
      String _name = ((Participant) el).getName();
      String _plus = ("\"" + _name);
      String _plus_1 = (_plus + "\"");
      acceptor.accept(
        this.createCompletionProposal(_plus_1, ((Participant) el).getName(), null, context));
    }
  }
  
  @Override
  public void completeArmTimerMessage_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    acceptor.accept(this.createCompletionProposal("\"Arm Timer\"", "\"Arm Timer\"", null, context));
  }
  
  @Override
  public void completeArmTimerMessage_DoubleDot(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    acceptor.accept(this.createCompletionProposal(":", ":", null, context));
  }
  
  @Override
  public void completeStateFragment_On(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    acceptor.accept(this.createCompletionProposal(DslConstants.ON, DslConstants.ON, null, context));
  }
  
  @Override
  public void completeStateFragment_Timeline(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    List<String> keywords = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(DslConstants.ACTOR, DslConstants.ACTIVITY, DslConstants.FUNCTION, DslConstants.ROLE, DslConstants.ENTITY, DslConstants.ROLE, DslConstants.COMPONENT, DslConstants.CONFIGURATION_ITEM));
    for (final String keyword : keywords) {
      boolean _checkValidKeyword = EmbeddedEditorInstanceHelper.checkValidKeyword(keyword);
      if (_checkValidKeyword) {
        this.getExistingTimelines(keyword, context, acceptor);
      }
    }
  }
  
  @Override
  public void completeStateFragment_Keyword(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    ArrayList<String> keywords = CollectionLiterals.<String>newArrayList(DslConstants.STATE, DslConstants.MODE);
    String scenarioType = EmbeddedEditorInstanceHelper.getScenarioType();
    EObject scenarioLevel = EmbeddedEditorInstanceHelper.getScenarioLevel();
    if (((!scenarioType.equals(DslConstants.FUNCTIONAL)) && (!(scenarioLevel instanceof EPBSArchitecture)))) {
      keywords.add(DslConstants.FUNCTION);
    }
    for (final String keyword : keywords) {
      acceptor.accept(this.createCompletionProposal(keyword, keyword, null, context));
    }
  }
  
  @Override
  public void completeStateFragment_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    List<String> _availableStateFragments = EmbeddedEditorInstanceHelper.getAvailableStateFragments(
      ((StateFragment) model).getKeyword(), ((StateFragment) model).getTimeline());
    for (final String stateFragment : _availableStateFragments) {
      acceptor.accept(
        this.createCompletionProposal((("\"" + stateFragment) + "\""), (("\"" + stateFragment) + "\""), null, context));
    }
  }
  
  @Override
  public void completeCombinedFragment_Timelines(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    EList<Participant> _participantsDefinedBefore = TextualScenarioHelper.participantsDefinedBefore(model);
    for (final EObject el : _participantsDefinedBefore) {
      boolean _contains = ((CombinedFragment) model).getTimelines().contains(((Participant) el).getName());
      boolean _not = (!_contains);
      if (_not) {
        String _name = ((Participant) el).getName();
        String _plus = ("\"" + _name);
        String _plus_1 = (_plus + "\"");
        acceptor.accept(
          this.createCompletionProposal(_plus_1, ((Participant) el).getName(), null, context));
      }
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
  
  public void completeCreateDeleteMessageName(final EObject model, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    SequenceMessageType message = ((SequenceMessageType) model);
    List<AbstractEventOperation> exchangesAvailable = EmbeddedEditorInstanceHelper.getExchangeMessages(message.getSource(), message.getTarget());
    String elementName = new String();
    for (final EObject element : exchangesAvailable) {
      {
        boolean _isInterfaceScenario = EmbeddedEditorInstanceHelper.isInterfaceScenario();
        if (_isInterfaceScenario) {
          elementName = CapellaElementExt.getName(((ExchangeItemAllocation) element).getAllocatedItem());
        } else {
          elementName = CapellaElementExt.getName(element);
        }
        if ((elementName != null)) {
          acceptor.accept(
            this.createCompletionProposal((("\"" + elementName) + "\""), (("\"" + elementName) + "\""), null, context));
        }
      }
    }
  }
}
