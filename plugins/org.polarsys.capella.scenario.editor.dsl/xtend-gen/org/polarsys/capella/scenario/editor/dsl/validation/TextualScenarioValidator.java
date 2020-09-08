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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
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
        this.error("Represented part does not exist", TextualScenarioPackage.Literals.PARTICIPANT__NAME, TextualScenarioValidator.INVALID_NAME);
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
    EList<EObject> _messagesOrReferences = model.getMessagesOrReferences();
    for (final EObject p : _messagesOrReferences) {
      {
        if ((p instanceof SequenceMessageType)) {
          boolean _add = names.add(this.getMessagesMapKey(((SequenceMessageType)p)));
          boolean _not = (!_add);
          if (_not) {
            this.error(
              "Multiple messages with the same name", 
              TextualScenarioPackage.Literals.MODEL__MESSAGES_OR_REFERENCES, index, 
              TextualScenarioValidator.DUPILCATED_MESSAGES_NAME);
          }
        }
        index++;
      }
    }
  }
  
  /**
   * Checks on deactivation keyword, check that we do not have dangling deactivations;
   * If we encounter a deactivation on a target, check that we have a corresponding sequence message that can be deactivated
   */
  @Check
  public void checkDeactivateMessages(final Model model) {
    int index = 0;
    Stack<SequenceMessage> messages = new Stack<SequenceMessage>();
    EList<EObject> _messagesOrReferences = model.getMessagesOrReferences();
    for (final EObject obj : _messagesOrReferences) {
      {
        if ((obj instanceof SequenceMessage)) {
          messages.push(((SequenceMessage)obj));
        }
        if ((obj instanceof ParticipantDeactivation)) {
          ParticipantDeactivation deactivation = ((ParticipantDeactivation) obj);
          while (((!messages.isEmpty()) && (!((SequenceMessage) messages.peek()).getTarget().equals(deactivation.getName())))) {
            messages.pop();
          }
          boolean _isEmpty = messages.isEmpty();
          if (_isEmpty) {
            this.error(
              "Deactivation keyword not expected", 
              TextualScenarioPackage.Literals.MODEL__MESSAGES_OR_REFERENCES, index);
            return;
          }
          messages.pop();
        }
        index++;
      }
    }
  }
  
  /**
   * Check that each withExecution message is closed by deactivation (on the proper target)
   */
  @Check
  public void checkWithExecutionHasDeactivate(final Model model) {
    Stack<EObject> messages = new Stack<EObject>();
    ArrayList<ParticipantDeactivation> unmatchedDeactivations = new ArrayList<ParticipantDeactivation>();
    int index = 0;
    EList<EObject> _messagesOrReferences = model.getMessagesOrReferences();
    for (final EObject obj : _messagesOrReferences) {
      {
        if (((obj instanceof SequenceMessage) && (((SequenceMessage) obj).getExecution() != null))) {
          messages.push(obj);
        }
        if ((obj instanceof ParticipantDeactivation)) {
          ParticipantDeactivation deactivation = ((ParticipantDeactivation) obj);
          boolean _isEmpty = messages.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            EObject _peek = messages.peek();
            boolean _equals = ((SequenceMessage) _peek).getTarget().equals(deactivation.getName());
            if (_equals) {
              messages.pop();
            } else {
              unmatchedDeactivations.add(deactivation);
            }
          }
        }
        index++;
      }
    }
    while ((!messages.isEmpty())) {
      {
        EObject _pop = messages.pop();
        SequenceMessage message = ((SequenceMessage) _pop);
        int indexDeactivation = this.checkMatchingDeactivation(message, unmatchedDeactivations);
        if ((indexDeactivation < 0)) {
          this.error(
            "Deactivation keyword expected for a withExecution message", 
            TextualScenarioPackage.Literals.MODEL__MESSAGES_OR_REFERENCES, 
            model.getMessagesOrReferences().indexOf(message));
        } else {
          unmatchedDeactivations.remove(indexDeactivation);
        }
      }
    }
  }
  
  /**
   * returns >= 0 if a message is matched by a deactivation in the given list
   */
  public int checkMatchingDeactivation(final SequenceMessage message, final ArrayList<ParticipantDeactivation> deactivations) {
    int index = 0;
    for (final ParticipantDeactivation deactivation : deactivations) {
      {
        boolean _equals = deactivation.getName().equals(message.getTarget());
        if (_equals) {
          return index;
        }
        index++;
      }
    }
    return (-1);
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
