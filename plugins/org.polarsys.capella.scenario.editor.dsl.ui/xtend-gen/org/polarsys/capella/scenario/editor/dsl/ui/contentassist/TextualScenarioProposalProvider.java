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
 ******************************************************************************/
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
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.polarsys.capella.core.data.cs.ExchangeItemAllocation;
import org.polarsys.capella.core.data.epbs.EPBSArchitecture;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.AbstractEventOperation;
import org.polarsys.capella.core.model.helpers.CapellaElementExt;
import org.polarsys.capella.scenario.editor.dsl.helpers.TextualScenarioHelper;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ArmTimerMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.CreateMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.DeleteMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Element;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.FoundMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.LostMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Operand;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ParticipantDeactivation;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Reference;
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
      final String[] messageKeywords = { "->", "->x", "->+", "->>", "->o", "o->" };
      boolean _contains = ((List<String>)Conversions.doWrapArray(messageKeywords)).contains(keyword.getValue());
      boolean _not = (!_contains);
      if (_not) {
        super.completeKeyword(keyword, contentAssistContext, acceptor);
      }
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
    this.proposeParticipants(context, acceptor);
  }
  
  @Override
  public void completeSequenceMessage_Arrow(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    acceptor.accept(this.createCompletionProposal("->", "-> : Sequence Message", null, context));
  }
  
  @Override
  public void completeSequenceMessage_Target(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    this.proposeParticipants(context, acceptor);
  }
  
  @Override
  public void completeSequenceMessage_Name(final EObject messageObj, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    SequenceMessage message = ((SequenceMessage) messageObj);
    this.createMessageProposal(message.getSource(), message.getTarget(), context, acceptor);
  }
  
  public void createMessageProposal(final String source, final String target, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    EObject _rootModel = context.getRootModel();
    Object scenarioExchangesType = TextualScenarioHelper.getScenarioAllowedExchangesType(((Model) _rootModel).getElements());
    List<AbstractEventOperation> exchangesAvailable = EmbeddedEditorInstanceHelper.getExchangeMessages(source, target);
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
        String exchangeType = TextualScenarioHelper.getExchangeType(element);
        if (((scenarioExchangesType == null) || scenarioExchangesType.equals(exchangeType))) {
          String message = (("\"" + elementName) + "\"");
          if ((EmbeddedEditorInstanceHelper.isESScenario() && (element instanceof FunctionalExchange))) {
            String _sourceFunctionNameOfExchange = EmbeddedEditorInstanceHelper.getSourceFunctionNameOfExchange(((FunctionalExchange) element));
            String _plus = ((message + " : FE [ ") + _sourceFunctionNameOfExchange);
            String _plus_1 = (_plus + 
              " ,");
            String _targetFunctionNameOfExchange = EmbeddedEditorInstanceHelper.getTargetFunctionNameOfExchange(((FunctionalExchange) element));
            String _plus_2 = (_plus_1 + _targetFunctionNameOfExchange);
            String _plus_3 = (_plus_2 + " ]");
            message = _plus_3;
          }
          acceptor.accept(
            this.createCompletionProposal((("\"" + elementName) + "\""), message, null, context));
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
    EObject _rootModel = context.getRootModel();
    EList<Participant> _participantsDefinedBefore = TextualScenarioHelper.participantsDefinedBefore(((Model) _rootModel));
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
    EObject _rootModel = context.getRootModel();
    EList<Participant> _participantsDefinedBefore = TextualScenarioHelper.participantsDefinedBefore(((Model) _rootModel));
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
  public void completeParticipantDeactivation_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    EObject modelContainer = TextualScenarioHelper.getModelContainer(((ParticipantDeactivation) model));
    HashMap<String, Integer> timelinesToPropose = new HashMap<String, Integer>();
    this.createTimelinesHashMapToProposeForDeactivation(((ParticipantDeactivation) model), ((Model) modelContainer), timelinesToPropose);
    Set<String> _keySet = timelinesToPropose.keySet();
    for (final String timelineToPropose : _keySet) {
      Integer _get = timelinesToPropose.get(timelineToPropose);
      boolean _greaterEqualsThan = ((_get).intValue() >= 1);
      if (_greaterEqualsThan) {
        acceptor.accept(
          this.createCompletionProposal((("\"" + timelineToPropose) + "\""), timelineToPropose, null, context));
      }
    }
  }
  
  public HashMap<String, Integer> createTimelinesHashMapToProposeForDeactivation(final ParticipantDeactivation participantDeactivation, final EObject modelContainer, final HashMap<String, Integer> timelinesToPropose) {
    List<Element> elements = TextualScenarioHelper.getElements(modelContainer);
    for (int i = 0; (i < elements.size()); i++) {
      {
        boolean _equals = elements.get(i).equals(participantDeactivation);
        if (_equals) {
          for (int j = 0; (j <= i); j++) {
            this.updateHashMap(timelinesToPropose, elements.get(j), participantDeactivation);
          }
          return timelinesToPropose;
        }
        Element _get = elements.get(i);
        if ((_get instanceof CombinedFragment)) {
          Element _get_1 = elements.get(i);
          this.createTimelinesHashMapToProposeForDeactivation(participantDeactivation, ((CombinedFragment) _get_1), timelinesToPropose);
        }
        Element _get_2 = elements.get(i);
        if ((_get_2 instanceof Operand)) {
          Element _get_3 = elements.get(i);
          this.createTimelinesHashMapToProposeForDeactivation(participantDeactivation, ((Operand) _get_3), timelinesToPropose);
        }
      }
    }
    return timelinesToPropose;
  }
  
  public Integer updateHashMap(final HashMap<String, Integer> timelinesToPropose, final EObject element, final ParticipantDeactivation participantDeactivation) {
    Integer _xblockexpression = null;
    {
      if ((element instanceof SequenceMessage)) {
        this.updateHashMapWithSequenceMessage(timelinesToPropose, ((SequenceMessage) element));
      }
      if ((element instanceof ArmTimerMessage)) {
        this.updateHashMapWithArmTimerMessage(timelinesToPropose, ((ArmTimerMessage) element));
      }
      Integer _xifexpression = null;
      if ((element instanceof ParticipantDeactivation)) {
        _xifexpression = this.updateHashMapWithParticipantDeactivation(timelinesToPropose, ((ParticipantDeactivation) element));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public Integer updateHashMapWithSequenceMessage(final HashMap<String, Integer> timelinesToPropose, final SequenceMessage sequenceMessage) {
    Integer _xifexpression = null;
    String _execution = sequenceMessage.getExecution();
    boolean _tripleNotEquals = (_execution != null);
    if (_tripleNotEquals) {
      Integer _xifexpression_1 = null;
      boolean _containsKey = timelinesToPropose.containsKey(sequenceMessage.getTarget());
      if (_containsKey) {
        Integer _xblockexpression = null;
        {
          Integer value = timelinesToPropose.get(sequenceMessage.getTarget());
          _xblockexpression = timelinesToPropose.put(sequenceMessage.getTarget(), Integer.valueOf(((((Integer) value)).intValue() + 1)));
        }
        _xifexpression_1 = _xblockexpression;
      } else {
        _xifexpression_1 = timelinesToPropose.put(sequenceMessage.getTarget(), Integer.valueOf(1));
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public Integer updateHashMapWithArmTimerMessage(final HashMap<String, Integer> timelinesToPropose, final ArmTimerMessage armTimer) {
    Integer _xifexpression = null;
    String _execution = armTimer.getExecution();
    boolean _tripleNotEquals = (_execution != null);
    if (_tripleNotEquals) {
      Integer _xifexpression_1 = null;
      boolean _containsKey = timelinesToPropose.containsKey(armTimer.getParticipant());
      if (_containsKey) {
        Integer _xblockexpression = null;
        {
          Integer value = timelinesToPropose.get(armTimer.getParticipant());
          _xblockexpression = value = Integer.valueOf(((((Integer) value)).intValue() + 1));
        }
        _xifexpression_1 = _xblockexpression;
      } else {
        _xifexpression_1 = timelinesToPropose.put(armTimer.getParticipant(), Integer.valueOf(1));
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public Integer updateHashMapWithParticipantDeactivation(final HashMap<String, Integer> timelinesToPropose, final ParticipantDeactivation participantDeactivation) {
    Integer _xifexpression = null;
    boolean _containsKey = timelinesToPropose.containsKey(participantDeactivation.getName());
    if (_containsKey) {
      Integer _xblockexpression = null;
      {
        Integer value = timelinesToPropose.get(participantDeactivation.getName());
        _xblockexpression = timelinesToPropose.put(participantDeactivation.getName(), Integer.valueOf(((((Integer) value)).intValue() - 1)));
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
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
    this.proposeParticipants(context, acceptor);
  }
  
  @Override
  public void completeArmTimerMessage_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    acceptor.accept(this.createCompletionProposal("\"Arm Timer\"", "\"Arm Timer\"", null, context));
  }
  
  @Override
  public void completeLostMessage_Arrow(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    boolean _isESScenario = EmbeddedEditorInstanceHelper.isESScenario();
    if (_isESScenario) {
      acceptor.accept(this.createCompletionProposal("->o", "->o : Lost Message", null, context));
    }
  }
  
  @Override
  public void completeLostMessage_Source(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    this.proposeParticipants(context, acceptor);
  }
  
  @Override
  public void completeLostMessage_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    LostMessage message = ((LostMessage) model);
    this.createMessageProposal(message.getSource(), null, context, acceptor);
  }
  
  @Override
  public void completeFoundMessage_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    FoundMessage message = ((FoundMessage) model);
    this.createMessageProposal(null, message.getTarget(), context, acceptor);
  }
  
  @Override
  public void completeFoundMessage_Arrow(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    boolean _isESScenario = EmbeddedEditorInstanceHelper.isESScenario();
    if (_isESScenario) {
      acceptor.accept(this.createCompletionProposal("o->", "o-> : Found Message", null, context));
    }
  }
  
  @Override
  public void completeFoundMessage_Target(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    this.proposeParticipants(context, acceptor);
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
    EObject _rootModel = context.getRootModel();
    EList<Participant> _participantsDefinedBefore = TextualScenarioHelper.participantsDefinedBefore(((Model) _rootModel));
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
  
  @Override
  public void completeReference_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    List<String> referencedScenarios = EmbeddedEditorInstanceHelper.getReferencedScenariosName();
    for (final String referencedScenario : referencedScenarios) {
      acceptor.accept(this.createCompletionProposal((("\"" + referencedScenario) + "\""), referencedScenario, null, context));
    }
  }
  
  @Override
  public void completeReference_Timelines(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    EObject _rootModel = context.getRootModel();
    EList<Participant> _participantsDefinedBefore = TextualScenarioHelper.participantsDefinedBefore(((Model) _rootModel));
    for (final EObject el : _participantsDefinedBefore) {
      boolean _contains = ((Reference) model).getTimelines().contains(((Participant) el).getName());
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
    EList<Element> _elements = model.getElements();
    for (final Element element : _elements) {
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
  
  public void proposeParticipants(final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    EObject _rootModel = context.getRootModel();
    EList<Participant> _participantsDefinedBefore = TextualScenarioHelper.participantsDefinedBefore(((Model) _rootModel));
    for (final EObject el : _participantsDefinedBefore) {
      String _name = ((Participant) el).getName();
      String _plus = ("\"" + _name);
      String _plus_1 = (_plus + "\"");
      acceptor.accept(
        this.createCompletionProposal(_plus_1, ((Participant) el).getName(), null, context));
    }
  }
}
