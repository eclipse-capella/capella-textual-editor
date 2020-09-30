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
package org.polarsys.capella.scenario.editor.dsl.validation;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.polarsys.capella.scenario.editor.dsl.helpers.TextualScenarioHelper;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Function;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Operand;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ParticipantDeactivation;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.TextualScenarioPackage;
import org.polarsys.capella.scenario.editor.dsl.validation.AbstractTextualScenarioValidator;
import org.polarsys.capella.scenario.editor.helper.DslConstants;
import org.polarsys.capella.scenario.editor.helper.EmbeddedEditorInstanceHelper;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class TextualScenarioValidator extends AbstractTextualScenarioValidator {
  public static final String INVALID_NAME = "invalidName";
  
  public static final String DUPILCATED_NAME = "duplicatedName";
  
  public static final String DUPILCATED_MESSAGES_NAME = "duplicatedMessageName";
  
  @Check
  public void checkPartExists(final Participant participant) {
    boolean _contains = EmbeddedEditorInstanceHelper.getAvailablePartNames(participant.getKeyword()).contains(participant.getName());
    boolean _not = (!_contains);
    if (_not) {
      if ((participant instanceof Function)) {
        this.error("Function does not exist", TextualScenarioPackage.Literals.PARTICIPANT__NAME, TextualScenarioValidator.INVALID_NAME);
      } else {
        this.error("Represented part does not exist", TextualScenarioPackage.Literals.PARTICIPANT__NAME, 
          TextualScenarioValidator.INVALID_NAME);
      }
    }
  }
  
  @Check
  public void checkParticipantKeywordIsValid(final Participant participant) {
    boolean _checkValidKeyword = EmbeddedEditorInstanceHelper.checkValidKeyword(participant.getKeyword());
    boolean _not = (!_checkValidKeyword);
    if (_not) {
      String _keyword = participant.getKeyword();
      String _plus = ("\'" + _keyword);
      String _plus_1 = (_plus + "\' can not be used in this diagram");
      this.error(_plus_1, 
        TextualScenarioPackage.Literals.PARTICIPANT__KEYWORD);
    }
  }
  
  @Check
  public void checkMessagesExist(final SequenceMessage message) {
    boolean _contains = EmbeddedEditorInstanceHelper.getExchangeNames(message.getSource(), message.getTarget()).contains(
      message.getName());
    boolean _not = (!_contains);
    if (_not) {
      this.error("Message does not exist", TextualScenarioPackage.Literals.MESSAGE__NAME);
    }
  }
  
  /**
   * Check that the source and the target of the sequence messages type are defined in text, before using them in the message
   */
  @Check
  public void checkParticipantsInvolvedExist(final SequenceMessageType message) {
    ArrayList<String> participantsDefined = TextualScenarioHelper.participantsDefinedBeforeNames(message);
    boolean _contains = participantsDefined.contains(message.getSource());
    boolean _not = (!_contains);
    if (_not) {
      this.error(
        "Source participant not defined in text", 
        TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__SOURCE);
    }
    boolean _contains_1 = participantsDefined.contains(message.getTarget());
    boolean _not_1 = (!_contains_1);
    if (_not_1) {
      this.error(
        "Target participant not defined in text", 
        TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET);
    }
  }
  
  /**
   * check that a CE (component exchange) and an FE (functional exchange) are not used in the same place
   */
  @Check
  public void checkMessagesExchangeType(final SequenceMessage message) {
    boolean _isESScenario = EmbeddedEditorInstanceHelper.isESScenario();
    if (_isESScenario) {
      Object model = TextualScenarioHelper.getModelContainer(message);
      boolean _notEquals = (!Objects.equal(model, null));
      if (_notEquals) {
        Object scenarioExchangesType = TextualScenarioHelper.getScenarioAllowedExchangesType(((Model) model).getElements());
        String exchangeType = TextualScenarioHelper.getMessageExchangeType(message);
        if (((!Objects.equal(scenarioExchangesType, null)) && (!scenarioExchangesType.equals(exchangeType)))) {
          this.error(("Exchange type can not be used, expected " + scenarioExchangesType), 
            TextualScenarioPackage.Literals.MESSAGE__NAME);
        }
      }
    }
  }
  
  /**
   * Do not allow duplicated names, we have a combination of unique keyword + name
   * ex: not allowed: actor "A1", actor "A1"
   * ex: allowed: actor "A1", component "A1"
   */
  @Check
  public void checkDuplicatedParticipantsNames(final Model model) {
    int index = 0;
    final HashSet<String> names = CollectionLiterals.<String>newHashSet();
    EList<Participant> _participants = model.getParticipants();
    for (final Participant p : _participants) {
      {
        boolean _add = names.add(this.getParticipantsMapKey(p));
        boolean _not = (!_add);
        if (_not) {
          this.error(
            "Duplicated participant", 
            TextualScenarioPackage.Literals.MODEL__PARTICIPANTS, index, 
            TextualScenarioValidator.DUPILCATED_NAME);
        }
        index++;
      }
    }
  }
  
  /**
   * Do not allow duplicated messages between name source, target
   * ex: not allowed: "A1" -> "A2" : "MSG1", "A1" -> "A2" : "MSG1"
   * ex: allowed: "A1" -> "A2" : "MSG1", "A2" -> "A3" : "MSG1"
   */
  @Check
  public void checkDuplicatedMessagesNames(final Model model) {
    int index = 0;
    final HashSet<String> names = CollectionLiterals.<String>newHashSet();
    EList<EObject> _elements = model.getElements();
    for (final EObject p : _elements) {
      {
        if ((p instanceof SequenceMessageType)) {
          boolean _add = names.add(this.getMessagesMapKey(((SequenceMessageType)p)));
          boolean _not = (!_add);
          if (_not) {
            this.error(
              "Duplicated message! Another message with same source, target, exchange already defined", 
              TextualScenarioPackage.Literals.MODEL__ELEMENTS, index, 
              TextualScenarioValidator.DUPILCATED_MESSAGES_NAME);
          }
        }
        index++;
      }
    }
  }
  
  /**
   * Checks on deactivation keyword
   * If we encounter a deactivation on a target, check that we have a corresponding sequence message that can be deactivated
   */
  @Check
  public void checkDeactivateMessages(final Model model) {
    int index = 0;
    LinkedList<String> messageTargets = CollectionLiterals.<String>newLinkedList();
    EList<EObject> _elements = model.getElements();
    for (final EObject obj : _elements) {
      {
        if ((obj instanceof SequenceMessage)) {
          messageTargets.add(((SequenceMessage) obj).getTarget());
        }
        if ((obj instanceof ParticipantDeactivation)) {
          ParticipantDeactivation deactivation = ((ParticipantDeactivation) obj);
          boolean removed = messageTargets.remove(deactivation.getName());
          if ((!removed)) {
            this.error(
              "Deactivation keyword not expected", 
              TextualScenarioPackage.Literals.MODEL__ELEMENTS, index);
          }
        }
        index++;
      }
    }
  }
  
  /**
   * Check that the state fragment exists
   */
  @Check
  public void checkStateFragment(final StateFragment fragment) {
    String _timeline = fragment.getTimeline();
    boolean _tripleEquals = (_timeline == null);
    if (_tripleEquals) {
      this.error(String.format("Insert timeline"), TextualScenarioPackage.Literals.STATE_FRAGMENT__TIMELINE);
      return;
    }
    boolean _checkValidTimeline = EmbeddedEditorInstanceHelper.checkValidTimeline(fragment.getTimeline());
    boolean _not = (!_checkValidTimeline);
    if (_not) {
      this.error(String.format("Timeline not present in diagram", fragment.getKeyword()), 
        TextualScenarioPackage.Literals.STATE_FRAGMENT__TIMELINE);
      return;
    }
    String _keyword = fragment.getKeyword();
    boolean _tripleEquals_1 = (_keyword == null);
    if (_tripleEquals_1) {
      this.error(String.format("Insert \'state\', \'mode\' or \'function\'"), 
        TextualScenarioPackage.Literals.STATE_FRAGMENT__KEYWORD);
      return;
    }
    String scenarioType = EmbeddedEditorInstanceHelper.getScenarioType();
    if ((fragment.getKeyword().equals(DslConstants.FUNCTION) && scenarioType.equals(DslConstants.FUNCTIONAL))) {
      this.error(String.format("\'function\' can not be used in this diagram"), 
        TextualScenarioPackage.Literals.STATE_FRAGMENT__KEYWORD);
      return;
    }
    String _name = fragment.getName();
    boolean _tripleEquals_2 = (_name == null);
    if (_tripleEquals_2) {
      String _keyword_1 = fragment.getKeyword();
      String _plus = ("Insert the " + _keyword_1);
      String _plus_1 = (_plus + " name");
      this.error(String.format(_plus_1), 
        TextualScenarioPackage.Literals.STATE_FRAGMENT__NAME);
      return;
    }
    List<String> availableStateFragments = EmbeddedEditorInstanceHelper.getAvailableStateFragments(fragment.getKeyword(), 
      fragment.getTimeline());
    boolean _contains = availableStateFragments.contains(fragment.getName());
    boolean _not_1 = (!_contains);
    if (_not_1) {
      String _keyword_2 = fragment.getKeyword();
      String _plus_2 = ("This " + _keyword_2);
      String _plus_3 = (_plus_2 + " does not exist or it\'s not available for ");
      String _timeline_1 = fragment.getTimeline();
      String _plus_4 = (_plus_3 + _timeline_1);
      this.error(
        String.format(_plus_4), TextualScenarioPackage.Literals.STATE_FRAGMENT__NAME);
    }
  }
  
  /**
   * Check that each withExecution message is closed by deactivation (on the proper target)
   */
  @Check
  public void checkWithExecutionHasDeactivate(final Model model) {
    LinkedList<String> messageWithExecutionTargets = CollectionLiterals.<String>newLinkedList();
    LinkedList<Integer> messageWithExecutionTargetsIndex = CollectionLiterals.<Integer>newLinkedList();
    int index = 0;
    EList<EObject> _elements = model.getElements();
    for (final EObject obj : _elements) {
      {
        if (((obj instanceof SequenceMessage) && (((SequenceMessage) obj).getExecution() != null))) {
          messageWithExecutionTargets.add(((SequenceMessage) obj).getTarget());
          messageWithExecutionTargetsIndex.add(Integer.valueOf(index));
        }
        if ((obj instanceof ParticipantDeactivation)) {
          String targetName = ((ParticipantDeactivation) obj).getName();
          int indexOfTarget = messageWithExecutionTargets.indexOf(targetName);
          if ((indexOfTarget >= 0)) {
            messageWithExecutionTargets.remove(indexOfTarget);
            messageWithExecutionTargetsIndex.remove(indexOfTarget);
          }
        }
        index++;
      }
    }
    for (int i = 0; (i < messageWithExecutionTargets.size()); i++) {
      this.error(
        "Deactivation keyword expected for a withExecution message", 
        TextualScenarioPackage.Literals.MODEL__ELEMENTS, 
        (messageWithExecutionTargetsIndex.get(i)).intValue());
    }
  }
  
  /**
   * Expression shall not be empty
   */
  @Check
  public void checkCombinedFragmentEmptyExpression(final CombinedFragment combinedFragment) {
    if ((Objects.equal(combinedFragment.getExpression(), null) || combinedFragment.getExpression().isEmpty())) {
      this.error(
        "Expression can not be empty", 
        TextualScenarioPackage.Literals.COMBINED_FRAGMENT__EXPRESSION);
    }
  }
  
  /**
   * Expression shall not be empty
   */
  @Check
  public void checkOperandEmptyExpression(final Operand operand) {
    if ((Objects.equal(operand.getExpression(), null) || operand.getExpression().isEmpty())) {
      this.error(
        "Expression can not be empty", 
        TextualScenarioPackage.Literals.OPERAND__EXPRESSION);
    }
  }
  
  /**
   * Else keyword shall be put on a combined fragment that is ALT
   */
  @Check
  public void checkElseKeyworkAvailable(final Operand operand) {
    EObject _eContainer = operand.eContainer();
    if ((_eContainer instanceof CombinedFragment)) {
      EObject _eContainer_1 = operand.eContainer();
      CombinedFragment combinedFragment = ((CombinedFragment) _eContainer_1);
      if ((Objects.equal(combinedFragment.getKeyword(), "alt") && (!combinedFragment.getOperands().isEmpty()))) {
        String _keyword = operand.getKeyword();
        boolean _notEquals = (!Objects.equal(_keyword, "else"));
        if (_notEquals) {
          this.error(
            "Expected \'else\' keyword", 
            TextualScenarioPackage.Literals.OPERAND__KEYWORD);
        }
      }
    }
  }
  
  /**
   * No keyword shall be put on a combined fragment that is not ALT
   */
  @Check
  public void checkKeyworkNotAvailable(final Operand operand) {
    EObject _eContainer = operand.eContainer();
    if ((_eContainer instanceof CombinedFragment)) {
      EObject _eContainer_1 = operand.eContainer();
      CombinedFragment combinedFragment = ((CombinedFragment) _eContainer_1);
      if (((!Objects.equal(combinedFragment.getKeyword(), "alt")) && (!combinedFragment.getOperands().isEmpty()))) {
        if (((!Objects.equal(operand.getKeyword(), null)) || (!operand.getKeyword().isEmpty()))) {
          this.error(
            "Unexpected keyword", 
            TextualScenarioPackage.Literals.OPERAND__KEYWORD);
        }
      }
    }
  }
  
  /**
   * Check that the combine fragments is allocated on valid timelines
   */
  @Check
  public void checkCombinedFragmentOnValidTimelines(final CombinedFragment combinedFragment) {
    String undefinedTimelines = "";
    String unexistingTimelines = "";
    ArrayList<String> participantsDefined = TextualScenarioHelper.participantsDefinedBeforeNames(combinedFragment);
    EList<String> _timelines = combinedFragment.getTimelines();
    for (final String timeline : _timelines) {
      {
        boolean _checkValidTimeline = EmbeddedEditorInstanceHelper.checkValidTimeline(timeline);
        boolean _not = (!_checkValidTimeline);
        if (_not) {
          String _unexistingTimelines = unexistingTimelines;
          unexistingTimelines = (_unexistingTimelines + (" " + timeline));
        }
        boolean _contains = participantsDefined.contains(timeline);
        boolean _not_1 = (!_contains);
        if (_not_1) {
          String _undefinedTimelines = undefinedTimelines;
          undefinedTimelines = (_undefinedTimelines + (" " + timeline));
        }
      }
    }
    boolean _isEmpty = unexistingTimelines.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.error(("Timelines not present in diagram:" + unexistingTimelines), 
        TextualScenarioPackage.eINSTANCE.getCombinedFragment_Timelines());
    }
    boolean _isEmpty_1 = undefinedTimelines.isEmpty();
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      this.error(("Timelines not defined in text:" + undefinedTimelines), 
        TextualScenarioPackage.eINSTANCE.getCombinedFragment_Timelines());
    }
  }
  
  public String getParticipantsMapKey(final Participant p) {
    String _name = p.getName();
    String _plus = (_name + ":");
    String _keyword = p.getKeyword();
    return (_plus + _keyword);
  }
  
  public String getMessagesMapKey(final SequenceMessageType m) {
    String _name = m.getName();
    String _plus = (_name + ":");
    String _source = m.getSource();
    String _plus_1 = (_plus + _source);
    String _plus_2 = (_plus_1 + ":");
    String _target = m.getTarget();
    return (_plus_2 + _target);
  }
}
