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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polarsys.capella.scenario.editor.dsl.helpers.TextualScenarioHelper;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ArmTimerMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Block;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.CreateMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.DeleteMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Element;
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
  
  public static final String DUPLICATED_NAME = "duplicatedName";
  
  public static final String DUPLICATED_MESSAGES_NAME = "duplicatedMessageName";
  
  public static final String SAME_SOURCE_AND_TARGET_ERROR = "Invalid element! Source and target must be different!";
  
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
  public void checkMessagesExist(final SequenceMessageType message) {
    boolean _contains = EmbeddedEditorInstanceHelper.getExchangeNames(message.getSource(), message.getTarget()).contains(
      message.getName());
    boolean _not = (!_contains);
    if (_not) {
      String _source = message.getSource();
      String _plus = ("Exchange does not exist between \"" + _source);
      String _plus_1 = (_plus + "\" and \"");
      String _target = message.getTarget();
      String _plus_2 = (_plus_1 + _target);
      String _plus_3 = (_plus_2 + "\"!");
      this.error(_plus_3, TextualScenarioPackage.Literals.MESSAGE__NAME);
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
      EObject model = TextualScenarioHelper.getModelContainer(message);
      if ((model instanceof Model)) {
        String scenarioExchangesType = TextualScenarioHelper.getScenarioAllowedExchangesType(((Model) model).getElements());
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
      EObject model = TextualScenarioHelper.getModelContainer(message);
      boolean _xifexpression = false;
      if ((model instanceof Model)) {
        _xifexpression = this.checkDuplicated(message, ((Model) model), CollectionLiterals.<String>newHashSet());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Check
  public boolean checkDuplicatedArmTimerMessageNames(final ArmTimerMessage message) {
    boolean _xblockexpression = false;
    {
      EObject model = TextualScenarioHelper.getModelContainer(message);
      boolean _xifexpression = false;
      if ((model instanceof Model)) {
        _xifexpression = this.checkDuplicated(message, ((Model) model), CollectionLiterals.<String>newHashSet());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public boolean checkDuplicated(final EObject elementToCheck, final EObject model, final HashSet<String> names) {
    List<Element> elements = TextualScenarioHelper.getElements(model);
    for (final Element element : elements) {
      {
        if ((((element instanceof SequenceMessageType) || (element instanceof ArmTimerMessage)) || 
          (element instanceof CombinedFragment))) {
          if (((!names.add(this.getElementMapKey(element))) && element.equals(elementToCheck))) {
            return true;
          }
        }
        if ((element instanceof CombinedFragment)) {
          boolean _checkDuplicated = this.checkDuplicated(elementToCheck, element, names);
          boolean _equals = (_checkDuplicated == true);
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
    List<Element> elements = TextualScenarioHelper.getElements(model);
    for (final Element obj : elements) {
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
  
  /**
   * check that the messages we define are valid
   * if the message is inside a combined fragment, the messages must be between the defined timelines of the combined fragment
   */
  @Check
  public void checkDefinedTimelinesMessages(final SequenceMessageType message) {
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
  
  @Check
  public void checkContainedTimelinesMessages(final SequenceMessageType message) {
    EObject container = TextualScenarioHelper.getDirectContainer(message);
    if ((container instanceof CombinedFragment)) {
      EObject upContainer = this.getUpperContainerCombinedFragmentTimelines(message, ((CombinedFragment)container));
      if (((upContainer != null) && (upContainer instanceof CombinedFragment))) {
        this.checkTimelinesMessages(message, ((CombinedFragment) upContainer));
      }
    }
  }
  
  public EObject getUpperContainerCombinedFragmentTimelines(final SequenceMessageType message, final CombinedFragment container) {
    if ((container.getTimelines().contains(message.getSource()) || container.getTimelines().contains(message.getTarget()))) {
      return container;
    } else {
      EObject upperContainer = TextualScenarioHelper.getDirectContainer(container);
      if ((upperContainer instanceof CombinedFragment)) {
        return this.getUpperContainerCombinedFragmentTimelines(message, ((CombinedFragment) upperContainer));
      }
    }
    return null;
  }
  
  public void checkTimelinesMessages(final SequenceMessageType message, final CombinedFragment container) {
    String _keyword = container.getKeyword();
    String _plus = ("Timeline not covered by this " + _keyword);
    String _plus_1 = (_plus + "!");
    String _plus_2 = (_plus_1 + 
      " Expected values in : ");
    EList<String> _timelines = container.getTimelines();
    String _plus_3 = (_plus_2 + _timelines);
    String msg = String.format(_plus_3);
    boolean _contains = container.getTimelines().contains(message.getSource());
    boolean _not = (!_contains);
    if (_not) {
      this.error(msg, 
        TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__SOURCE);
    }
    boolean _contains_1 = container.getTimelines().contains(message.getTarget());
    boolean _not_1 = (!_contains_1);
    if (_not_1) {
      this.error(msg, 
        TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET);
    }
  }
  
  @Check
  public void checkDeleteMessage(final DeleteMessage deleteMessage) {
    this.checkCreateOrDeleteCouldBeUsed();
    this.checkSameSourceAndTarget(deleteMessage);
  }
  
  public void checkCreateOrDeleteCouldBeUsed() {
    if ((EmbeddedEditorInstanceHelper.isFSScenario() || (EmbeddedEditorInstanceHelper.isESScenario() && (!EmbeddedEditorInstanceHelper.isInteractionScenario())))) {
      this.error("Create or delete message can not be used in this diagram!", 
        TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__ARROW);
    }
  }
  
  @Check
  public void checkArmTimer(final ArmTimerMessage armTimer) {
    boolean _isFSScenario = EmbeddedEditorInstanceHelper.isFSScenario();
    if (_isFSScenario) {
      this.error("Arm Timer can not be used in this diagram!", 
        TextualScenarioPackage.Literals.ARM_TIMER_MESSAGE__ARROW);
    }
    boolean _contains = TextualScenarioHelper.participantsDefinedBeforeNames(armTimer).contains(armTimer.getParticipant());
    boolean _not = (!_contains);
    if (_not) {
      this.error("Timeline not defined in text editor!", 
        TextualScenarioPackage.Literals.ARM_TIMER_MESSAGE__PARTICIPANT);
    }
  }
  
  public void checkSameSourceAndTarget(final SequenceMessageType message) {
    boolean _equals = message.getSource().equals(message.getTarget());
    if (_equals) {
      this.error(TextualScenarioValidator.SAME_SOURCE_AND_TARGET_ERROR, 
        TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET);
      this.error(TextualScenarioValidator.SAME_SOURCE_AND_TARGET_ERROR, 
        TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__SOURCE);
    }
  }
  
  @Check
  public boolean checkDuplicatedCombinedFragment(final CombinedFragment combinedFragment) {
    boolean _xblockexpression = false;
    {
      EObject model = TextualScenarioHelper.getModelContainer(combinedFragment);
      boolean _xifexpression = false;
      if ((model instanceof Model)) {
        _xifexpression = this.checkDuplicated(combinedFragment, model, CollectionLiterals.<String>newHashSet());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * check if a timeline involved in a combined fragment was used after a delete message was already defined
   * on the previous lines on the same timeline
   */
  @Check
  public void checkTimelineUsedAfterDeleteMessage(final CombinedFragment combinedFragment) {
    EObject model = TextualScenarioHelper.getModelContainer(combinedFragment);
    if ((model instanceof Model)) {
      int index = 0;
      EList<String> _timelines = combinedFragment.getTimelines();
      for (final String timeline : _timelines) {
        int _plusPlus = index++;
        this.checkElementAfterDelete(((Model) model), combinedFragment, timeline, 
          TextualScenarioPackage.Literals.COMBINED_FRAGMENT__TIMELINES, _plusPlus);
      }
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
      EObject model = TextualScenarioHelper.getModelContainer(fragment);
      boolean _xifexpression = false;
      if ((model instanceof Model)) {
        _xifexpression = this.checkElementAfterDelete(((Model) model), fragment, fragment.getTimeline(), 
          TextualScenarioPackage.Literals.STATE_FRAGMENT__TIMELINE, 0);
      }
      _xblockexpression = _xifexpression;
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
      EObject model = TextualScenarioHelper.getModelContainer(armTimer);
      boolean _xifexpression = false;
      if ((model instanceof Model)) {
        _xifexpression = this.checkElementAfterDelete(((Model) model), armTimer, armTimer.getParticipant(), 
          TextualScenarioPackage.Literals.ARM_TIMER_MESSAGE__PARTICIPANT, 0);
      }
      _xblockexpression = _xifexpression;
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
      EObject model = TextualScenarioHelper.getModelContainer(message);
      boolean _xifexpression = false;
      if ((model instanceof Model)) {
        _xifexpression = this.checkElementAfterDelete(((Model) model), message, message.getSource(), 
          TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__SOURCE, 0);
      }
      _xblockexpression = _xifexpression;
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
      EObject model = TextualScenarioHelper.getModelContainer(message);
      boolean _xifexpression = false;
      if ((model instanceof Model)) {
        _xifexpression = this.checkElementAfterDelete(((Model) model), message, message.getTarget(), 
          TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET, 0);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public boolean checkElementAfterDelete(final EObject model, final EObject checkedElement, final String target, final EAttribute checkedAttribute, final int index) {
    List<Element> elements = TextualScenarioHelper.getElements(model);
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
        if ((element instanceof CombinedFragment)) {
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
    this.checkCreateOrDeleteCouldBeUsed();
    this.checkSameSourceAndTarget(createMessage);
    EObject model = TextualScenarioHelper.getModelContainer(createMessage);
    if (((model instanceof Model) && (!this.checkCreateMessageValid(((Model) model), createMessage)))) {
      this.errorCreateMessage(createMessage.getTarget());
    }
  }
  
  public boolean checkCreateMessageValid(final EObject model, final CreateMessage createMessage) {
    String target = createMessage.getTarget();
    List<Element> elements = TextualScenarioHelper.getElements(model);
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
    boolean _contains = TextualScenarioHelper.participantsDefinedBeforeNames(fragment).contains(fragment.getTimeline());
    boolean _not = (!_contains);
    if (_not) {
      this.error(String.format("Timeline not defined in text editor!", fragment.getKeyword()), 
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
    boolean _contains_1 = availableStateFragments.contains(fragment.getName());
    boolean _not_1 = (!_contains_1);
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
    List<Element> elements = TextualScenarioHelper.getElements(model);
    for (final Element obj : elements) {
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
          this.error("Timeline not defined in text editor!", 
            TextualScenarioPackage.Literals.COMBINED_FRAGMENT__TIMELINES, index);
        }
        index++;
      }
    }
  }
  
  /**
   * Check that a inner combine fragment has timelines over a subset in the parent combined fragment
   */
  @Check
  public void checkContainedCombinedFragment(final CombinedFragment combinedFragment) {
    EObject container = TextualScenarioHelper.getDirectContainer(combinedFragment);
    if ((container instanceof CombinedFragment)) {
      EObject upperContainer = this.getContainerCombinedFragmentTimelines(combinedFragment, ((CombinedFragment)container));
      if (((upperContainer != null) && (upperContainer instanceof CombinedFragment))) {
        String _keyword = combinedFragment.getKeyword();
        String _plus = ("Timelines covered by this " + _keyword);
        String _plus_1 = (_plus + 
          " must be a subset of the parent covered timelines ");
        EList<String> _timelines = ((CombinedFragment) upperContainer).getTimelines();
        String _plus_2 = (_plus_1 + _timelines);
        String _plus_3 = (_plus_2 + "!");
        this.error(_plus_3, 
          TextualScenarioPackage.Literals.COMBINED_FRAGMENT__TIMELINES);
      }
    }
  }
  
  public EObject getContainerCombinedFragmentTimelines(final CombinedFragment combinedFragment, final CombinedFragment container) {
    if ((this.innerCombinedFragment(combinedFragment, container) && 
      (!this.isASubset(combinedFragment.getTimelines(), ((CombinedFragment) container).getTimelines())))) {
      return container;
    } else {
      EObject upperContainer = TextualScenarioHelper.getDirectContainer(container);
      if ((upperContainer instanceof CombinedFragment)) {
        return this.getContainerCombinedFragmentTimelines(combinedFragment, ((CombinedFragment) upperContainer));
      }
    }
    return null;
  }
  
  /**
   * check if the smallList is a subset in the containerList
   */
  public boolean isASubset(final List<String> smallList, final List<String> containerList) {
    for (final String element : smallList) {
      boolean _contains = containerList.contains(element);
      boolean _not = (!_contains);
      if (_not) {
        return false;
      }
    }
    return true;
  }
  
  /**
   * check if the smallList is a sublist in the containerList
   */
  public boolean isASublist(final List<String> smallList, final List<String> containerList) {
    for (int i = 0; (i < containerList.size()); i++) {
      if (((i < containerList.size()) && ((i + smallList.size()) <= containerList.size()))) {
        int _size = smallList.size();
        int _plus = (i + _size);
        List<String> subset = containerList.subList(i, _plus);
        if (((subset != null) && smallList.equals(subset))) {
          return true;
        }
      }
    }
    return false;
  }
  
  /**
   * we consider that it is a inner combined fragment if it has some same timelines as the parent
   * added this due to the limitation that a paralel combined fragment in diagram, is represented inside the text
   */
  public boolean innerCombinedFragment(final CombinedFragment combinedFragment, final CombinedFragment container) {
    EList<String> _timelines = combinedFragment.getTimelines();
    for (final String timeline : _timelines) {
      boolean _contains = container.getTimelines().contains(timeline);
      if (_contains) {
        return true;
      }
    }
    return false;
  }
  
  public String getParticipantsMapKey(final Participant p) {
    String _name = p.getName();
    String _plus = (_name + ":");
    String _keyword = p.getKeyword();
    return (_plus + _keyword);
  }
  
  public String getElementMapKey(final EObject element) {
    if ((element instanceof CombinedFragment)) {
      String _keyword = ((CombinedFragment)element).getKeyword();
      String _expression = ((CombinedFragment)element).getExpression();
      String key = (_keyword + _expression);
      List<String> _sort = IterableExtensions.<String>sort(IterableExtensions.<String>toSet(((CombinedFragment)element).getTimelines()));
      for (final String timeline : _sort) {
        key = ((key + ":") + timeline);
      }
      return key;
    }
    if ((element instanceof SequenceMessageType)) {
      String _name = ((SequenceMessageType)element).getName();
      String _plus = (_name + ":");
      String _arrow = ((SequenceMessageType)element).getArrow();
      String _plus_1 = (_plus + _arrow);
      String _plus_2 = (_plus_1 + ":");
      String _source = ((SequenceMessageType)element).getSource();
      String _plus_3 = (_plus_2 + _source);
      String _plus_4 = (_plus_3 + ":");
      String _target = ((SequenceMessageType)element).getTarget();
      return (_plus_4 + _target);
    }
    if ((element instanceof ArmTimerMessage)) {
      String _participant = ((ArmTimerMessage)element).getParticipant();
      String _plus_5 = (_participant + ":");
      String _name_1 = ((ArmTimerMessage)element).getName();
      return (_plus_5 + _name_1);
    }
    return null;
  }
}
