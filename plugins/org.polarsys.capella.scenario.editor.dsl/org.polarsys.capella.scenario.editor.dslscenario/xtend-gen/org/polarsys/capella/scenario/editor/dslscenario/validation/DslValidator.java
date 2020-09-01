/**
 * -------------------------------------------------------------------------------
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
 * -------------------------------------------------------------------------------
 */
package org.polarsys.capella.scenario.editor.dslscenario.validation;

import java.util.HashSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.polarsys.capella.scenario.editor.dslscenario.dsl.DslPackage;
import org.polarsys.capella.scenario.editor.dslscenario.dsl.Function;
import org.polarsys.capella.scenario.editor.dslscenario.dsl.Model;
import org.polarsys.capella.scenario.editor.dslscenario.dsl.Participant;
import org.polarsys.capella.scenario.editor.dslscenario.dsl.SequenceMessage;
import org.polarsys.capella.scenario.editor.dslscenario.dsl.SequenceMessageType;
import org.polarsys.capella.scenario.editor.dslscenario.validation.AbstractDslValidator;
import org.polarsys.capella.scenario.editor.helper.EmbeddedEditorInstanceHelper;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class DslValidator extends AbstractDslValidator {
  public static final String INVALID_NAME = "invalidName";
  
  public static final String DUPILCATED_NAME = "duplicatedName";
  
  public static final String DUPILCATED_MESSAGES_NAME = "duplicatedMessageName";
  
  @Check
  public void checkPartExists(final Participant participant) {
    boolean _contains = EmbeddedEditorInstanceHelper.getAvailablePartNames(participant.getKeyword()).contains(participant.getName());
    boolean _not = (!_contains);
    if (_not) {
      if ((participant instanceof Function)) {
        this.error("Function does not exist", DslPackage.Literals.PARTICIPANT__NAME, DslValidator.INVALID_NAME);
      } else {
        this.error("Represented part does not exist", DslPackage.Literals.PARTICIPANT__NAME, DslValidator.INVALID_NAME);
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
        DslPackage.Literals.PARTICIPANT__KEYWORD);
    }
  }
  
  @Check
  public void checkMessagesExist(final SequenceMessage message) {
    if ((EmbeddedEditorInstanceHelper.getScenarioType().equals("INTERFACE") && 
      (!EmbeddedEditorInstanceHelper.getExchangeNames(message.getSource(), message.getTarget()).contains(
        message.getName())))) {
      this.error("Message does not exist", DslPackage.Literals.MESSAGE__NAME);
    }
  }
  
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
            DslPackage.Literals.MODEL__PARTICIPANTS, index, 
            DslValidator.DUPILCATED_NAME);
        }
        index++;
      }
    }
  }
  
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
              DslPackage.Literals.MODEL__MESSAGES_OR_REFERENCES, index, 
              DslValidator.DUPILCATED_MESSAGES_NAME);
          }
        }
        index++;
      }
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
