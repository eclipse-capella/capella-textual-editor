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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.polarsys.capella.scenario.editor.dsl.helpers.TextualScenarioHelper;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ArmTimerMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Block;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.CreateMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.DeleteMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Function;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Message;
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
  
  public static final String DUPLICATED_NAME = "duplicatedName";
  
  public static final String DUPLICATED_MESSAGES_NAME = "duplicatedMessageName";
  
  @Check
  public void checkPartExists(final Participant participant) {
    boolean _contains = EmbeddedEditorInstanceHelper.getAvailablePartNames(participant.getKeyword()).contains(participant.getName());
    boolean _not = (!_contains);
    if (_not) {
      if ((participant instanceof Function)) {
        this.error("Function does not exist!", TextualScenarioPackage.Literals.PARTICIPANT__NAME, TextualScenarioValidator.INVALID_NAME);
      } else {
        this.error("Represented part does not exist!", TextualScenarioPackage.Literals.PARTICIPANT__NAME, 
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
      String _plus_1 = (_plus + "\' can not be used in this diagram!");
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
      this.error("Message does not exist!", TextualScenarioPackage.Literals.MESSAGE__NAME);
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
        "Source participant not defined in text editor!", 
        TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__SOURCE);
    }
    boolean _contains_1 = participantsDefined.contains(message.getTarget());
    boolean _not_1 = (!_contains_1);
    if (_not_1) {
      this.error(
        "Target participant not defined in text editor!", 
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
      if ((model != null)) {
        Object scenarioExchangesType = TextualScenarioHelper.getScenarioAllowedExchangesType(((Model) model).getElements());
        String exchangeType = TextualScenarioHelper.getMessageExchangeType(message);
        if (((scenarioExchangesType != null) && (!scenarioExchangesType.equals(exchangeType)))) {
          this.error((("Exchange type can not be used, expected " + scenarioExchangesType) + "!"), 
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
            "Duplicated participant!", 
            TextualScenarioPackage.Literals.MODEL__PARTICIPANTS, index, 
            TextualScenarioValidator.DUPLICATED_NAME);
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
  public boolean checkDuplicatedSequenceMessageNames(final SequenceMessage message) {
    boolean _xblockexpression = false;
    {
      Object model = TextualScenarioHelper.getModelContainer(message);
      _xblockexpression = this.checkDuplicated(message, ((Model) model), CollectionLiterals.<String>newHashSet());
    }
    return _xblockexpression;
  }
  
  @Check
  public boolean checkDuplicatedArmTimerMessageNames(final ArmTimerMessage message) {
    boolean _xblockexpression = false;
    {
      Object model = TextualScenarioHelper.getModelContainer(message);
      _xblockexpression = this.checkDuplicated(message, ((Model) model), CollectionLiterals.<String>newHashSet());
    }
    return _xblockexpression;
  }
  
  public boolean checkDuplicated(final Message message, final EObject model, final HashSet<String> names) {
    EList<EObject> elements = TextualScenarioHelper.getElements(model);
    for (final EObject element : elements) {
      {
        if (((element instanceof SequenceMessageType) || (element instanceof ArmTimerMessage))) {
          if (((!names.add(this.getMessagesMapKey(element))) && element.equals(message))) {
            this.error("Duplicated message! The same message is already defined.", 
              TextualScenarioPackage.Literals.MESSAGE__NAME);
            return true;
          }
        }
        if (((element instanceof CombinedFragment) || (element instanceof Operand))) {
          Object _checkDuplicated = this.checkDuplicated(message, element, names);
          boolean _equals = Objects.equal(_checkDuplicated, Boolean.valueOf(true));
          if (_equals) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  @Check
  public void checkDeactivateMessagesModel(final Model model) {
    this.checkDeactivateMessages(model);
  }
  
  @Check
  public void checkDeactivateMessagesBlock(final Block block) {
    this.checkDeactivateMessages(block);
  }
  
  /**
   * Checks on deactivation keyword
   * If we encounter a deactivation on a target, check that we have a corresponding sequence message that can be deactivated
   */
  public void checkDeactivateMessages(final EObject model) {
    int index = 0;
    LinkedList<String> messageTargets = CollectionLiterals.<String>newLinkedList();
    EList<EObject> elements = TextualScenarioHelper.getElements(model);
    for (final EObject obj : elements) {
      {
        if (((obj instanceof SequenceMessage) && (((SequenceMessage) obj).getExecution() != null))) {
          messageTargets.add(((SequenceMessage) obj).getTarget());
        }
        if (((obj instanceof ArmTimerMessage) && (((ArmTimerMessage) obj).getExecution() != null))) {
          messageTargets.add(((ArmTimerMessage) obj).getParticipant());
        }
        if ((obj instanceof ParticipantDeactivation)) {
          ParticipantDeactivation deactivation = ((ParticipantDeactivation) obj);
          boolean removed = messageTargets.remove(deactivation.getName());
          if ((!removed)) {
            if ((model instanceof Model)) {
              this.error(
                "Deactivation keyword not expected!", 
                TextualScenarioPackage.Literals.MODEL__ELEMENTS, index);
            } else {
              if ((model instanceof Block)) {
                this.error(
                  "Deactivation keyword not expected!", 
                  TextualScenarioPackage.Literals.BLOCK__BLOCK_ELEMENTS, index);
              }
            }
          }
        }
        index++;
      }
    }
  }
  
  @Check
  public void checkTimelinesMessages(final SequenceMessageType message) {
    ArrayList<String> participantsNames = TextualScenarioHelper.participantsDefinedBeforeNames(message);
    boolean _contains = participantsNames.contains(message.getSource());
    boolean _not = (!_contains);
    if (_not) {
      this.error(String.format("Timeline not defined in text editor!"), TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__SOURCE);
      return;
    }
    boolean _contains_1 = participantsNames.contains(message.getTarget());
    boolean _not_1 = (!_contains_1);
    if (_not_1) {
      this.error(String.format("Timeline not defined in text editor!"), TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET);
      return;
    }
  }
  
  /**
   * check if a timeline involved in a combined fragment was used after a delete message was already defined
   * on the previous lines on the same timeline
   */
  @Check
  public void checkTimelineUsedAfterDeleteMessage(final CombinedFragment combinedFragment) {
    Object model = TextualScenarioHelper.getModelContainer(combinedFragment);
    int index = 0;
    EList<String> _timelines = combinedFragment.getTimelines();
    for (final String timeline : _timelines) {
      int _plusPlus = index++;
      this.checkElementAfterDelete(((Model) model), combinedFragment, timeline, 
        TextualScenarioPackage.Literals.COMBINED_FRAGMENT__TIMELINES, _plusPlus);
    }
  }
  
  /**
   * check if the timeline involved in a state fragment was used after a delete message was already defined
   * on the previous lines on the same timeline
   */
  @Check
  public boolean checkTimelineUsedAfterDeleteMessage(final StateFragment fragment) {
    boolean _xblockexpression = false;
    {
      Object model = TextualScenarioHelper.getModelContainer(fragment);
      _xblockexpression = this.checkElementAfterDelete(((Model) model), fragment, fragment.getTimeline(), 
        TextualScenarioPackage.Literals.STATE_FRAGMENT__TIMELINE, 0);
    }
    return _xblockexpression;
  }
  
  /**
   * check if a participant involved in arm timer was used after a delete message was already defined
   * on the previous lines on the same timeline
   */
  @Check
  public boolean checkParticipantUsedAfterDeleteMessage(final ArmTimerMessage armTimer) {
    boolean _xblockexpression = false;
    {
      Object model = TextualScenarioHelper.getModelContainer(armTimer);
      _xblockexpression = this.checkElementAfterDelete(((Model) model), armTimer, armTimer.getParticipant(), 
        TextualScenarioPackage.Literals.ARM_TIMER_MESSAGE__PARTICIPANT, 0);
    }
    return _xblockexpression;
  }
  
  /**
   * check if a sequence message source element was used after a delete message was already defined
   * on the previous lines on the same timeline
   */
  @Check
  public boolean checkMessageSourceUsedAfterDeleteMessage(final SequenceMessageType message) {
    boolean _xblockexpression = false;
    {
      Object model = TextualScenarioHelper.getModelContainer(message);
      _xblockexpression = this.checkElementAfterDelete(((Model) model), message, message.getSource(), 
        TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__SOURCE, 0);
    }
    return _xblockexpression;
  }
  
  /**
   * check if a sequence message target element was used after a delete message was already defined
   * on the previous lines on the same timeline
   */
  @Check
  public boolean checkMessageTargetUsedAfterDeleteMessage(final SequenceMessageType message) {
    boolean _xblockexpression = false;
    {
      Object model = TextualScenarioHelper.getModelContainer(message);
      _xblockexpression = this.checkElementAfterDelete(((Model) model), message, message.getTarget(), 
        TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET, 0);
    }
    return _xblockexpression;
  }
  
  public boolean checkElementAfterDelete(final EObject model, final EObject checkedElement, final String target, final EAttribute checkedAttribute, final int index) {
    EList<EObject> elements = TextualScenarioHelper.getElements(model);
    for (final EObject element : elements) {
      {
        boolean _equals = element.equals(checkedElement);
        if (_equals) {
          return true;
        }
        if ((element instanceof DeleteMessage)) {
          boolean _equals_1 = ((DeleteMessage) element).getTarget().equals(target);
          if (_equals_1) {
            this.error(
              String.format(
                (("Element \"" + target) + 
                  "\" can not be used at this point! A delete message was already defined on this timeline.")), checkedAttribute, index);
            return true;
          }
        }
        if (((element instanceof CombinedFragment) || (element instanceof Operand))) {
          boolean _checkElementAfterDelete = this.checkElementAfterDelete(element, checkedElement, target, checkedAttribute, index);
          if (_checkElementAfterDelete) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  /**
   * check if create message could be used
   */
  @Check
  public void checkCreateMessage(final CreateMessage createMessage) {
    Object model = TextualScenarioHelper.getModelContainer(createMessage);
    boolean _checkCreateMessageValid = this.checkCreateMessageValid(((Model) model), createMessage);
    boolean _not = (!_checkCreateMessageValid);
    if (_not) {
      this.errorCreateMessage(createMessage.getTarget());
    }
  }
  
  public boolean checkCreateMessageValid(final EObject model, final CreateMessage createMessage) {
    String target = createMessage.getTarget();
    EList<EObject> elements = TextualScenarioHelper.getElements(model);
    for (final EObject element : elements) {
      {
        if ((element instanceof SequenceMessageType)) {
          boolean _equals = ((SequenceMessageType)element).equals(createMessage);
          if (_equals) {
            return true;
          }
          if ((((SequenceMessageType) element).getTarget().equals(target) || 
            ((SequenceMessageType) element).getSource().equals(target))) {
            return false;
          }
        }
        if ((element instanceof ArmTimerMessage)) {
          boolean _equals_1 = ((ArmTimerMessage) element).getParticipant().equals(target);
          if (_equals_1) {
            return false;
          }
        }
        if ((element instanceof CombinedFragment)) {
          boolean _contains = ((CombinedFragment) element).getTimelines().contains(target);
          if (_contains) {
            return false;
          } else {
            boolean _checkCreateMessageValid = this.checkCreateMessageValid(element, createMessage);
            boolean _not = (!(((Boolean) Boolean.valueOf(_checkCreateMessageValid))).booleanValue());
            if (_not) {
              return false;
            }
          }
        }
        if ((element instanceof Operand)) {
          boolean _checkCreateMessageValid_1 = this.checkCreateMessageValid(element, createMessage);
          boolean _not_1 = (!(((Boolean) Boolean.valueOf(_checkCreateMessageValid_1))).booleanValue());
          if (_not_1) {
            return false;
          }
        }
        if ((element instanceof StateFragment)) {
          boolean _equals_2 = ((StateFragment) element).getTimeline().equals(target);
          if (_equals_2) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public void errorCreateMessage(final String target) {
    this.error(String.format((("Target \"" + target) + "\" can not be used in a create message at this point! Other operations were already defined on this timeline.")), 
      TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET);
  }
  
  /**
   * Validate a State Fragment
   */
  @Check
  public void checkStateFragment(final StateFragment fragment) {
    boolean _checkValidTimeline = EmbeddedEditorInstanceHelper.checkValidTimeline(fragment.getTimeline());
    boolean _not = (!_checkValidTimeline);
    if (_not) {
      this.error(String.format("Timeline not present in diagram", fragment.getKeyword()), 
        TextualScenarioPackage.Literals.STATE_FRAGMENT__TIMELINE);
      return;
    }
    String scenarioType = EmbeddedEditorInstanceHelper.getScenarioType();
    if ((fragment.getKeyword().equals(DslConstants.FUNCTION) && scenarioType.equals(DslConstants.FUNCTIONAL))) {
      this.error(String.format("\'function\' can not be used in this diagram!"), 
        TextualScenarioPackage.Literals.STATE_FRAGMENT__KEYWORD);
      return;
    }
    List<String> availableStateFragments = EmbeddedEditorInstanceHelper.getAvailableStateFragments(fragment.getKeyword(), 
      fragment.getTimeline());
    boolean _contains = availableStateFragments.contains(fragment.getName());
    boolean _not_1 = (!_contains);
    if (_not_1) {
      String _keyword = fragment.getKeyword();
      String _plus = ("This " + _keyword);
      String _plus_1 = (_plus + " does not exist or is not available for \"");
      String _timeline = fragment.getTimeline();
      String _plus_2 = (_plus_1 + _timeline);
      String _plus_3 = (_plus_2 + "\"!");
      this.error(
        String.format(_plus_3), TextualScenarioPackage.Literals.STATE_FRAGMENT__NAME);
    }
  }
  
  /**
   * Check that each withExecution message is closed by deactivation (on the proper target)
   */
  @Check
  public void checkWithExecutionHasDeactivateModel(final Model model) {
    this.checkWithExecutionHasDeactivate(model);
  }
  
  @Check
  public void checkWithExecutionHasDeactivateBlock(final Block block) {
    this.checkWithExecutionHasDeactivate(block);
  }
  
  public void checkWithExecutionHasDeactivate(final EObject model) {
    LinkedList<String> messageWithExecutionTargets = CollectionLiterals.<String>newLinkedList();
    LinkedList<Integer> messageWithExecutionTargetsIndex = CollectionLiterals.<Integer>newLinkedList();
    int index = 0;
    EList<EObject> elements = TextualScenarioHelper.getElements(model);
    for (final EObject obj : elements) {
      {
        if (((obj instanceof SequenceMessage) && (((SequenceMessage) obj).getExecution() != null))) {
          messageWithExecutionTargets.add(((SequenceMessage) obj).getTarget());
          messageWithExecutionTargetsIndex.add(Integer.valueOf(index));
        }
        if (((obj instanceof ArmTimerMessage) && (((ArmTimerMessage) obj).getExecution() != null))) {
          messageWithExecutionTargets.add(((ArmTimerMessage) obj).getParticipant());
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
      if ((model instanceof Model)) {
        this.error(
          "Deactivation keyword expected for a withExecution message!", 
          TextualScenarioPackage.Literals.MODEL__ELEMENTS, 
          (messageWithExecutionTargetsIndex.get(i)).intValue());
      } else {
        this.error(
          "Deactivation keyword expected for a withExecution message!", 
          TextualScenarioPackage.Literals.BLOCK__BLOCK_ELEMENTS, 
          messageWithExecutionTargets.get(i));
      }
    }
  }
  
  /**
   * Expression shall not be empty
   */
  @Check
  public void checkCombinedFragmentEmptyExpression(final CombinedFragment combinedFragment) {
    if (((combinedFragment.getExpression() == null) || combinedFragment.getExpression().isEmpty())) {
      this.error(
        "Expression can not be empty!", 
        TextualScenarioPackage.Literals.COMBINED_FRAGMENT__EXPRESSION);
    }
  }
  
  /**
   * Expression shall not be empty
   */
  @Check
  public void checkOperandEmptyExpression(final Operand operand) {
    if (((operand.getExpression() == null) || operand.getExpression().isEmpty())) {
      this.error(
        "Expression can not be empty!", 
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
            "Expected \'else\' keyword!", 
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
        if (((operand.getKeyword() != null) || (!operand.getKeyword().isEmpty()))) {
          this.error(
            "Unexpected keyword!", 
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
    ArrayList<String> participantsDefined = TextualScenarioHelper.participantsDefinedBeforeNames(combinedFragment);
    int index = 0;
    EList<String> _timelines = combinedFragment.getTimelines();
    for (final String timeline : _timelines) {
      {
        boolean _contains = participantsDefined.contains(timeline);
        boolean _not = (!_contains);
        if (_not) {
          this.error("Timeline not defined in text edior!", 
            TextualScenarioPackage.Literals.COMBINED_FRAGMENT__TIMELINES, index);
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
  
  public String getMessagesMapKey(final EObject message) {
    if ((message instanceof SequenceMessageType)) {
      String _name = ((SequenceMessageType)message).getName();
      String _plus = (_name + ":");
      String _source = ((SequenceMessageType)message).getSource();
      String _plus_1 = (_plus + _source);
      String _plus_2 = (_plus_1 + ":");
      String _target = ((SequenceMessageType)message).getTarget();
      return (_plus_2 + _target);
    }
    if ((message instanceof ArmTimerMessage)) {
      String _participant = ((ArmTimerMessage)message).getParticipant();
      String _plus_3 = (_participant + ":");
      String _name_1 = ((ArmTimerMessage)message).getName();
      return (_plus_3 + _name_1);
    }
    return null;
  }
}
