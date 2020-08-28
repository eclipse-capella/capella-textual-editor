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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Function;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ParticipantDeactivation;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.TextualScenarioPackage;
import org.polarsys.capella.scenario.editor.dsl.validation.AbstractTextualScenarioValidator;
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
      String _plus_1 = (_plus + "\' could not be used in this diagram");
      this.error(_plus_1, 
        TextualScenarioPackage.Literals.PARTICIPANT__KEYWORD);
    }
  }
  
  @Check
  public void checkMessagesExist(final SequenceMessage message) {
    if ((EmbeddedEditorInstanceHelper.getScenarioType().equals("INTERFACE") && 
      (!EmbeddedEditorInstanceHelper.getExchangeNames(message.getSource(), message.getTarget()).contains(
        message.getName())))) {
      this.error("Message does not exist", TextualScenarioPackage.Literals.MESSAGE__NAME);
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
            "Multiple participants with the same name", 
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
              "Multiple messages with the same name", 
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
    String _keyword = fragment.getKeyword();
    boolean _tripleEquals_1 = (_keyword == null);
    if (_tripleEquals_1) {
      this.error(String.format("Insert \"state\", \"mode\" or \"function\""), TextualScenarioPackage.Literals.STATE_FRAGMENT__KEYWORD);
      return;
    }
    String _name = fragment.getName();
    boolean _tripleEquals_2 = (_name == null);
    if (_tripleEquals_2) {
      String _keyword_1 = fragment.getKeyword();
      String _plus = ("Insert the " + _keyword_1);
      String _plus_1 = (_plus + " name");
      this.error(String.format(_plus_1), TextualScenarioPackage.Literals.STATE_FRAGMENT__NAME);
      return;
    }
    List<String> availableStateFragments = EmbeddedEditorInstanceHelper.getAvailableStateFragments(fragment.getKeyword(), fragment.getTimeline());
    boolean _contains = availableStateFragments.contains(fragment.getName());
    boolean _not = (!_contains);
    if (_not) {
      String _keyword_2 = fragment.getKeyword();
      String _plus_2 = ("This " + _keyword_2);
      String _plus_3 = (_plus_2 + " does not exist or it\'s not available for ");
      String _timeline_1 = fragment.getTimeline();
      String _plus_4 = (_plus_3 + _timeline_1);
      this.error(String.format(_plus_4), TextualScenarioPackage.Literals.STATE_FRAGMENT__NAME);
    }
    boolean _checkValidTimeline = EmbeddedEditorInstanceHelper.checkValidTimeline(fragment.getTimeline());
    boolean _not_1 = (!_checkValidTimeline);
    if (_not_1) {
      this.error(String.format("This timeline does not exist", fragment.getKeyword()), TextualScenarioPackage.Literals.STATE_FRAGMENT__TIMELINE);
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
