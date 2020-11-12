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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.polarsys.capella.scenario.editor.dsl.textualScenario.FoundMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Function;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.LostFoundMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.LostMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Message;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Operand;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ParticipantDeactivation;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Reference;
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
  public final static String INVALID_NAME = "invalidName";
  
  public final static String DUPLICATED_NAME = "duplicatedName";
  
  public final static String DUPLICATED_MESSAGES_NAME = "duplicatedMessageName";
  
  public final static String SAME_SOURCE_AND_TARGET_ERROR = "Invalid element! Source and target must be different!";
  
  @Check
  public void checkPartExists(final Participant participant) {
    String _keyword = participant.getKeyword();
    List<String> _availablePartNames = EmbeddedEditorInstanceHelper.getAvailablePartNames(_keyword);
    String _name = participant.getName();
    boolean _contains = _availablePartNames.contains(_name);
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
    String _keyword = participant.getKeyword();
    boolean _checkValidKeyword = EmbeddedEditorInstanceHelper.checkValidKeyword(_keyword);
    boolean _not = (!_checkValidKeyword);
    if (_not) {
      String _keyword_1 = participant.getKeyword();
      String _plus = ("\'" + _keyword_1);
      String _plus_1 = (_plus + "\' can not be used in this diagram!");
      this.error(_plus_1, 
        TextualScenarioPackage.Literals.PARTICIPANT__KEYWORD);
    }
  }
  
  @Check
  public void checkMessagesExist(final SequenceMessage message) {
    String _source = message.getSource();
    String _target = message.getTarget();
    List<String> _exchangeNames = EmbeddedEditorInstanceHelper.getExchangeNames(_source, _target);
    String _name = message.getName();
    boolean _contains = _exchangeNames.contains(_name);
    boolean _not = (!_contains);
    if (_not) {
      String _source_1 = message.getSource();
      String _plus = ("Exchange does not exist between \"" + _source_1);
      String _plus_1 = (_plus + "\" and \"");
      String _target_1 = message.getTarget();
      String _plus_2 = (_plus_1 + _target_1);
      String _plus_3 = (_plus_2 + "\"!");
      this.error(_plus_3, TextualScenarioPackage.Literals.MESSAGE__NAME);
    }
  }
  
  @Check
  public void checkMessagesExist(final LostMessage message) {
    String _source = message.getSource();
    List<String> _exchangeNames = EmbeddedEditorInstanceHelper.getExchangeNames(_source, null);
    String _name = message.getName();
    boolean _contains = _exchangeNames.contains(_name);
    boolean _not = (!_contains);
    if (_not) {
      String _source_1 = message.getSource();
      String _plus = ("Exchange does not exist from \"" + _source_1);
      String _plus_1 = (_plus + "\"!");
      this.error(_plus_1, TextualScenarioPackage.Literals.MESSAGE__NAME);
    }
  }
  
  @Check
  public void checkMessagesExist(final FoundMessage message) {
    String _target = message.getTarget();
    List<String> _exchangeNames = EmbeddedEditorInstanceHelper.getExchangeNames(null, _target);
    String _name = message.getName();
    boolean _contains = _exchangeNames.contains(_name);
    boolean _not = (!_contains);
    if (_not) {
      String _target_1 = message.getTarget();
      String _plus = ("Exchange does not exist to \"" + _target_1);
      String _plus_1 = (_plus + "\"!");
      this.error(_plus_1, TextualScenarioPackage.Literals.MESSAGE__NAME);
    }
  }
  
  @Check
  public void checkSequenceMessagesExchangeType(final SequenceMessage sequenceMessage) {
    this.checkMessagesExchangeType(sequenceMessage);
  }
  
  @Check
  public void checkSequenceMessagesExchangeType(final LostFoundMessage lostFoundMessage) {
    this.checkMessagesExchangeType(lostFoundMessage);
  }
  
  /**
   * check that a CE (component exchange) and an FE (functional exchange) are not used in the same place
   */
  public void checkMessagesExchangeType(final Message message) {
    boolean _isESScenario = EmbeddedEditorInstanceHelper.isESScenario();
    if (_isESScenario) {
      EObject model = TextualScenarioHelper.getModelContainer(message);
      if ((model instanceof Model)) {
        EList<Element> _elements = ((Model) model).getElements();
        Object scenarioExchangesType = TextualScenarioHelper.getScenarioAllowedExchangesType(_elements);
        Set _allMessageExchangeType = TextualScenarioHelper.getAllMessageExchangeType(message);
        Set exchangeTypes = ((Set) _allMessageExchangeType);
        if (((scenarioExchangesType != null) && (!exchangeTypes.contains(scenarioExchangesType)))) {
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
        String _participantsMapKey = this.getParticipantsMapKey(p);
        boolean _add = names.add(_participantsMapKey);
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
  
  @Check
  public void checkDeactivateMessagesModel(final Model model) {
    LinkedList<String> _newLinkedList = CollectionLiterals.<String>newLinkedList();
    EList<Element> _elements = model.getElements();
    this.checkDeactivateMessages(model, _newLinkedList, _elements);
  }
  
  /**
   * Checks on deactivation keyword
   * If we encounter a deactivation on a target, check that we have a corresponding sequence message that can be deactivated
   */
  public void checkDeactivateMessages(final EObject container, final LinkedList<String> messageTargets, final List<Element> elements) {
    int index = 0;
    for (final Element obj : elements) {
      {
        if (((obj instanceof SequenceMessage) && (((SequenceMessage) obj).getExecution() != null))) {
          String _target = ((SequenceMessage) obj).getTarget();
          messageTargets.add(_target);
        }
        if (((obj instanceof ArmTimerMessage) && (((ArmTimerMessage) obj).getExecution() != null))) {
          String _participant = ((ArmTimerMessage) obj).getParticipant();
          messageTargets.add(_participant);
        }
        if (((obj instanceof FoundMessage) && (((FoundMessage) obj).getExecution() != null))) {
          String _target_1 = ((FoundMessage) obj).getTarget();
          messageTargets.add(_target_1);
        }
        if ((obj instanceof CombinedFragment)) {
          CombinedFragment cf = ((CombinedFragment) obj);
          Block _block = cf.getBlock();
          Block _block_1 = cf.getBlock();
          EList<Element> _blockElements = _block_1.getBlockElements();
          this.checkDeactivateMessages(_block, messageTargets, _blockElements);
          EList<Operand> _operands = cf.getOperands();
          final Consumer<Operand> _function = (Operand operand) -> {
            Block _block_2 = operand.getBlock();
            Block _block_3 = operand.getBlock();
            EList<Element> _blockElements_1 = _block_3.getBlockElements();
            this.checkDeactivateMessages(_block_2, messageTargets, _blockElements_1);
          };
          _operands.forEach(_function);
        }
        if ((obj instanceof ParticipantDeactivation)) {
          EReference refFeature = TextualScenarioPackage.Literals.MODEL__ELEMENTS;
          if ((container instanceof Block)) {
            refFeature = TextualScenarioPackage.Literals.BLOCK__BLOCK_ELEMENTS;
          }
          this.showErrorDeactivateMessages(
            ((ParticipantDeactivation) obj), container, messageTargets, refFeature, index);
        }
        index++;
      }
    }
  }
  
  public String showErrorDeactivateMessages(final ParticipantDeactivation deactivation, final EObject container, final LinkedList<String> messageTargets, final EReference refFeature, final int index) {
    String _xblockexpression = null;
    {
      String _name = deactivation.getName();
      int indexOfTarget = messageTargets.lastIndexOf(_name);
      String _xifexpression = null;
      if ((indexOfTarget < 0)) {
        this.error(
          "Deactivation keyword not expected!", container, refFeature, index);
      } else {
        _xifexpression = messageTargets.remove(indexOfTarget);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * check that the messages we define are valid
   * if the message is inside a combined fragment, the messages must be between the defined timelines of the combined fragment
   */
  @Check
  public void checkDefinedTimelinesMessages(final SequenceMessageType message) {
    ArrayList<String> participantsNames = TextualScenarioHelper.participantsDefinedBeforeNames(message);
    String _source = message.getSource();
    boolean _contains = participantsNames.contains(_source);
    boolean _not = (!_contains);
    if (_not) {
      String _format = String.format("Timeline not defined in text editor!");
      this.error(_format, TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__SOURCE);
      return;
    }
    String _target = message.getTarget();
    boolean _contains_1 = participantsNames.contains(_target);
    boolean _not_1 = (!_contains_1);
    if (_not_1) {
      String _format_1 = String.format("Timeline not defined in text editor!");
      this.error(_format_1, TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET);
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
    EList<String> _timelines_1 = container.getTimelines();
    String _source = message.getSource();
    boolean _contains = _timelines_1.contains(_source);
    boolean _not = (!_contains);
    if (_not) {
      this.error(msg, 
        TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__SOURCE);
    }
    EList<String> _timelines_2 = container.getTimelines();
    String _target = message.getTarget();
    boolean _contains_1 = _timelines_2.contains(_target);
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
    ArrayList<String> _participantsDefinedBeforeNames = TextualScenarioHelper.participantsDefinedBeforeNames(armTimer);
    String _participant = armTimer.getParticipant();
    boolean _contains = _participantsDefinedBeforeNames.contains(_participant);
    boolean _not = (!_contains);
    if (_not) {
      this.error("Timeline not defined in text editor!", 
        TextualScenarioPackage.Literals.ARM_TIMER_MESSAGE__PARTICIPANT);
    }
  }
  
  @Check
  public void checkLostMessage(final LostMessage message) {
    boolean _isESScenario = EmbeddedEditorInstanceHelper.isESScenario();
    boolean _not = (!_isESScenario);
    if (_not) {
      this.error("Lost message can not be used in this diagram!", 
        TextualScenarioPackage.Literals.LOST_FOUND_MESSAGE__ARROW);
    }
    ArrayList<String> _participantsDefinedBeforeNames = TextualScenarioHelper.participantsDefinedBeforeNames(message);
    String _source = message.getSource();
    boolean _contains = _participantsDefinedBeforeNames.contains(_source);
    boolean _not_1 = (!_contains);
    if (_not_1) {
      this.error("Timeline not defined in text editor!", 
        TextualScenarioPackage.Literals.LOST_MESSAGE__SOURCE);
    }
  }
  
  @Check
  public void checkFoundMessage(final FoundMessage message) {
    boolean _isESScenario = EmbeddedEditorInstanceHelper.isESScenario();
    boolean _not = (!_isESScenario);
    if (_not) {
      this.error("Found message can not be used in this diagram!", 
        TextualScenarioPackage.Literals.LOST_FOUND_MESSAGE__ARROW);
    }
    ArrayList<String> _participantsDefinedBeforeNames = TextualScenarioHelper.participantsDefinedBeforeNames(message);
    String _target = message.getTarget();
    boolean _contains = _participantsDefinedBeforeNames.contains(_target);
    boolean _not_1 = (!_contains);
    if (_not_1) {
      this.error("Timeline not defined in text editor!", 
        TextualScenarioPackage.Literals.FOUND_MESSAGE__TARGET);
    }
  }
  
  public void checkSameSourceAndTarget(final SequenceMessageType message) {
    String _source = message.getSource();
    String _target = message.getTarget();
    boolean _equals = _source.equals(_target);
    if (_equals) {
      this.error(TextualScenarioValidator.SAME_SOURCE_AND_TARGET_ERROR, 
        TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET);
      this.error(TextualScenarioValidator.SAME_SOURCE_AND_TARGET_ERROR, 
        TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__SOURCE);
    }
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
        String _timeline = fragment.getTimeline();
        _xifexpression = this.checkElementAfterDelete(((Model) model), fragment, _timeline, 
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
        String _participant = armTimer.getParticipant();
        _xifexpression = this.checkElementAfterDelete(((Model) model), armTimer, _participant, 
          TextualScenarioPackage.Literals.ARM_TIMER_MESSAGE__PARTICIPANT, 0);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * check if a participant involved in a lost message was used after a delete message was already defined
   * on the previous lines on the same timeline
   */
  @Check
  public boolean checkParticipantUsedAfterLostMessage(final LostMessage message) {
    boolean _xblockexpression = false;
    {
      EObject model = TextualScenarioHelper.getModelContainer(message);
      boolean _xifexpression = false;
      if ((model instanceof Model)) {
        String _source = message.getSource();
        _xifexpression = this.checkElementAfterDelete(((Model) model), message, _source, 
          TextualScenarioPackage.Literals.LOST_MESSAGE__SOURCE, 0);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * check if a participant involved in a lost message was used after a delete message was already defined
   * on the previous lines on the same timeline
   */
  @Check
  public boolean checkParticipantUsedAfterFoundMessage(final FoundMessage message) {
    boolean _xblockexpression = false;
    {
      EObject model = TextualScenarioHelper.getModelContainer(message);
      boolean _xifexpression = false;
      if ((model instanceof Model)) {
        String _target = message.getTarget();
        _xifexpression = this.checkElementAfterDelete(((Model) model), message, _target, 
          TextualScenarioPackage.Literals.FOUND_MESSAGE__TARGET, 0);
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
        String _source = message.getSource();
        _xifexpression = this.checkElementAfterDelete(((Model) model), message, _source, 
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
        String _target = message.getTarget();
        _xifexpression = this.checkElementAfterDelete(((Model) model), message, _target, 
          TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET, 0);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public boolean checkElementAfterDelete(final EObject model, final EObject checkedElement, final String target, final EAttribute checkedAttribute, final int index) {
    List<Element> elements = TextualScenarioHelper.getContainerElements(model);
    for (final EObject element : elements) {
      {
        boolean _equals = element.equals(checkedElement);
        if (_equals) {
          return true;
        }
        if ((element instanceof DeleteMessage)) {
          String _target = ((DeleteMessage) element).getTarget();
          boolean _equals_1 = _target.equals(target);
          if (_equals_1) {
            String _format = String.format(
              (("Element \"" + target) + 
                "\" can not be used at this point! A delete message was already defined on this timeline."));
            this.error(_format, checkedAttribute, index);
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
      String _target = createMessage.getTarget();
      this.errorCreateMessage(_target);
    }
  }
  
  public boolean checkCreateMessageValid(final EObject model, final CreateMessage createMessage) {
    String target = createMessage.getTarget();
    List<Element> elements = TextualScenarioHelper.getContainerElements(model);
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
          String _participant = ((ArmTimerMessage) element).getParticipant();
          boolean _equals_1 = _participant.equals(target);
          if (_equals_1) {
            return false;
          }
        }
        if ((element instanceof LostMessage)) {
          String _source = ((LostMessage) element).getSource();
          boolean _equals_2 = _source.equals(target);
          if (_equals_2) {
            return false;
          }
        }
        if ((element instanceof FoundMessage)) {
          String _target = ((FoundMessage) element).getTarget();
          boolean _equals_3 = _target.equals(target);
          if (_equals_3) {
            return false;
          }
        }
        if ((element instanceof CombinedFragment)) {
          EList<String> _timelines = ((CombinedFragment) element).getTimelines();
          boolean _contains = _timelines.contains(target);
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
          String _timeline = ((StateFragment) element).getTimeline();
          boolean _equals_4 = _timeline.equals(target);
          if (_equals_4) {
            return false;
          }
        }
        if ((element instanceof Reference)) {
          EList<String> _timelines_1 = ((Reference) element).getTimelines();
          boolean _contains_1 = _timelines_1.contains(target);
          if (_contains_1) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public void errorCreateMessage(final String target) {
    String _format = String.format((("Target \"" + target) + "\" can not be used in a create message at this point! Other operations were already defined on this timeline."));
    this.error(_format, 
      TextualScenarioPackage.Literals.SEQUENCE_MESSAGE_TYPE__TARGET);
  }
  
  /**
   * Validate a State Fragment
   */
  @Check
  public void checkStateFragment(final StateFragment fragment) {
    ArrayList<String> _participantsDefinedBeforeNames = TextualScenarioHelper.participantsDefinedBeforeNames(fragment);
    String _timeline = fragment.getTimeline();
    boolean _contains = _participantsDefinedBeforeNames.contains(_timeline);
    boolean _not = (!_contains);
    if (_not) {
      String _keyword = fragment.getKeyword();
      String _format = String.format("Timeline not defined in text editor!", _keyword);
      this.error(_format, 
        TextualScenarioPackage.Literals.STATE_FRAGMENT__TIMELINE);
      return;
    }
    String scenarioType = EmbeddedEditorInstanceHelper.getScenarioType();
    if ((fragment.getKeyword().equals(DslConstants.FUNCTION) && scenarioType.equals(DslConstants.FUNCTIONAL))) {
      String _format_1 = String.format("\'function\' can not be used in this diagram!");
      this.error(_format_1, 
        TextualScenarioPackage.Literals.STATE_FRAGMENT__KEYWORD);
      return;
    }
    String _keyword_1 = fragment.getKeyword();
    String _timeline_1 = fragment.getTimeline();
    List<String> availableStateFragments = EmbeddedEditorInstanceHelper.getAvailableStateFragments(_keyword_1, _timeline_1);
    String _name = fragment.getName();
    boolean _contains_1 = availableStateFragments.contains(_name);
    boolean _not_1 = (!_contains_1);
    if (_not_1) {
      String _keyword_2 = fragment.getKeyword();
      String _plus = ("This " + _keyword_2);
      String _plus_1 = (_plus + " does not exist or is not available for \"");
      String _timeline_2 = fragment.getTimeline();
      String _plus_2 = (_plus_1 + _timeline_2);
      String _plus_3 = (_plus_2 + "\"!");
      String _format_2 = String.format(_plus_3);
      this.error(_format_2, TextualScenarioPackage.Literals.STATE_FRAGMENT__NAME);
    }
  }
  
  /**
   * Check that each withExecution message is closed by deactivation (on the proper target)
   */
  @Check
  public void checkWithExecutionHasDeactivateModel(final Model model) {
    LinkedList<String> messageWithExecutionTargets = CollectionLiterals.<String>newLinkedList();
    LinkedList<Integer> messageWithExecutionTargetsIndex = CollectionLiterals.<Integer>newLinkedList();
    LinkedList<EObject> messageWithExecutionTargetsContainer = CollectionLiterals.<EObject>newLinkedList();
    EList<Element> _elements = model.getElements();
    this.checkWithExecutionHasDeactivate(model, messageWithExecutionTargets, messageWithExecutionTargetsIndex, messageWithExecutionTargetsContainer, _elements);
    this.showErrorWithExecutionHasDeactivate(messageWithExecutionTargets, messageWithExecutionTargetsIndex, messageWithExecutionTargetsContainer);
  }
  
  public void showErrorWithExecutionHasDeactivate(final LinkedList<String> messageWithExecutionTargets, final LinkedList<Integer> messageWithExecutionTargetsIndex, final LinkedList<EObject> messageWithExecutionTargetsContainer) {
    for (int i = 0; (i < messageWithExecutionTargets.size()); i++) {
      {
        EObject container = messageWithExecutionTargetsContainer.get(i);
        if ((container instanceof Model)) {
          Integer _get = messageWithExecutionTargetsIndex.get(i);
          this.error(
            "Deactivation keyword expected for a withExecution message!", container, 
            TextualScenarioPackage.Literals.MODEL__ELEMENTS, (_get).intValue());
        } else {
          if ((container instanceof Block)) {
            String _get_1 = messageWithExecutionTargets.get(i);
            this.error(
              "Deactivation keyword expected for a withExecution message!", container, 
              TextualScenarioPackage.Literals.BLOCK__BLOCK_ELEMENTS, _get_1);
          }
        }
      }
    }
  }
  
  public void checkWithExecutionHasDeactivate(final EObject container, final LinkedList<String> messageWithExecutionTargets, final LinkedList<Integer> messageWithExecutionTargetsIndex, final LinkedList<EObject> messageWithExecutionTargetsContainer, final List<Element> elements) {
    int index = 0;
    for (final Element obj : elements) {
      {
        if (((obj instanceof SequenceMessage) && (((SequenceMessage) obj).getExecution() != null))) {
          String _target = ((SequenceMessage) obj).getTarget();
          messageWithExecutionTargets.add(_target);
          messageWithExecutionTargetsIndex.add(Integer.valueOf(index));
          messageWithExecutionTargetsContainer.add(container);
        }
        if (((obj instanceof ArmTimerMessage) && (((ArmTimerMessage) obj).getExecution() != null))) {
          String _participant = ((ArmTimerMessage) obj).getParticipant();
          messageWithExecutionTargets.add(_participant);
          messageWithExecutionTargetsIndex.add(Integer.valueOf(index));
          messageWithExecutionTargetsContainer.add(container);
        }
        if (((obj instanceof FoundMessage) && (((FoundMessage) obj).getExecution() != null))) {
          String _target_1 = ((FoundMessage) obj).getTarget();
          messageWithExecutionTargets.add(_target_1);
          messageWithExecutionTargetsIndex.add(Integer.valueOf(index));
          messageWithExecutionTargetsContainer.add(container);
        }
        if ((obj instanceof CombinedFragment)) {
          CombinedFragment cf = ((CombinedFragment) obj);
          Block _block = cf.getBlock();
          Block _block_1 = cf.getBlock();
          EList<Element> _blockElements = _block_1.getBlockElements();
          this.checkWithExecutionHasDeactivate(_block, messageWithExecutionTargets, messageWithExecutionTargetsIndex, messageWithExecutionTargetsContainer, _blockElements);
          EList<Operand> _operands = cf.getOperands();
          final Consumer<Operand> _function = (Operand operand) -> {
            Block _block_2 = operand.getBlock();
            Block _block_3 = operand.getBlock();
            EList<Element> _blockElements_1 = _block_3.getBlockElements();
            this.checkWithExecutionHasDeactivate(_block_2, messageWithExecutionTargets, messageWithExecutionTargetsIndex, messageWithExecutionTargetsContainer, _blockElements_1);
          };
          _operands.forEach(_function);
        }
        if ((obj instanceof ParticipantDeactivation)) {
          String targetName = ((ParticipantDeactivation) obj).getName();
          int indexOfTarget = messageWithExecutionTargets.lastIndexOf(targetName);
          if ((indexOfTarget >= 0)) {
            messageWithExecutionTargets.remove(indexOfTarget);
            messageWithExecutionTargetsIndex.remove(indexOfTarget);
            messageWithExecutionTargetsContainer.remove(indexOfTarget);
          }
        }
        index++;
      }
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
      EList<String> _timelines = combinedFragment.getTimelines();
      EObject upperContainer = this.getContainerCombinedFragmentTimelines(_timelines, ((CombinedFragment)container));
      if (((upperContainer != null) && (upperContainer instanceof CombinedFragment))) {
        String _keyword = combinedFragment.getKeyword();
        String _plus = ("Timelines covered by this " + _keyword);
        String _plus_1 = (_plus + 
          " must be a subset of the parent covered timelines ");
        EList<String> _timelines_1 = ((CombinedFragment) upperContainer).getTimelines();
        String _plus_2 = (_plus_1 + _timelines_1);
        String _plus_3 = (_plus_2 + "!");
        this.error(_plus_3, 
          TextualScenarioPackage.Literals.COMBINED_FRAGMENT__TIMELINES);
      }
    }
  }
  
  @Check
  public void checkReference(final Reference reference) {
    HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
    int index = 0;
    EList<String> _timelines = reference.getTimelines();
    for (final String timeline : _timelines) {
      {
        Integer _get = hashMap.get(timeline);
        boolean _equals = Objects.equal(_get, null);
        if (_equals) {
          hashMap.put(timeline, Integer.valueOf(1));
        } else {
          this.error("Duplicated timeline!", 
            TextualScenarioPackage.Literals.REFERENCE__TIMELINES, index);
        }
        index++;
      }
    }
    ArrayList<String> participantsDefined = TextualScenarioHelper.participantsDefinedBeforeNames(reference);
    index = 0;
    EList<String> _timelines_1 = reference.getTimelines();
    for (final String timeline_1 : _timelines_1) {
      {
        boolean _contains = participantsDefined.contains(timeline_1);
        boolean _not = (!_contains);
        if (_not) {
          this.error("Timeline not defined in text editor!", 
            TextualScenarioPackage.Literals.REFERENCE__TIMELINES, index);
        }
        index++;
      }
    }
    List<String> _referencedScenariosName = EmbeddedEditorInstanceHelper.getReferencedScenariosName();
    String _name = reference.getName();
    boolean _contains = _referencedScenariosName.contains(_name);
    boolean _not = (!_contains);
    if (_not) {
      this.error("Referenced scenario does not exist!", 
        TextualScenarioPackage.Literals.REFERENCE__NAME);
    }
    EObject container = TextualScenarioHelper.getDirectContainer(reference);
    if ((container instanceof CombinedFragment)) {
      EList<String> _timelines_2 = reference.getTimelines();
      EObject upperContainer = this.getContainerCombinedFragmentTimelines(_timelines_2, ((CombinedFragment)container));
      if (((upperContainer != null) && (upperContainer instanceof CombinedFragment))) {
        EList<String> _timelines_3 = ((CombinedFragment) upperContainer).getTimelines();
        String _plus = ("Timelines covered by this reference must be a subset of the parent covered timelines " + _timelines_3);
        String _plus_1 = (_plus + "!");
        this.error(_plus_1, 
          TextualScenarioPackage.Literals.REFERENCE__TIMELINES);
      }
    }
    EObject model = TextualScenarioHelper.getModelContainer(reference);
    if ((model instanceof Model)) {
      index = 0;
      EList<String> _timelines_4 = reference.getTimelines();
      for (final String timeline_2 : _timelines_4) {
        int _plusPlus = index++;
        this.checkElementAfterDelete(((Model) model), reference, timeline_2, 
          TextualScenarioPackage.Literals.REFERENCE__TIMELINES, _plusPlus);
      }
    }
  }
  
  public EObject getContainerCombinedFragmentTimelines(final List<String> timelines, final CombinedFragment container) {
    if ((this.innerCombinedFragment(timelines, container) && 
      (!this.isASubset(timelines, ((CombinedFragment) container).getTimelines())))) {
      return container;
    } else {
      EObject upperContainer = TextualScenarioHelper.getDirectContainer(container);
      if ((upperContainer instanceof CombinedFragment)) {
        return this.getContainerCombinedFragmentTimelines(timelines, ((CombinedFragment) upperContainer));
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
  public boolean innerCombinedFragment(final List<String> timelines, final CombinedFragment container) {
    for (final String timeline : timelines) {
      EList<String> _timelines = container.getTimelines();
      boolean _contains = _timelines.contains(timeline);
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
      EList<String> _timelines = ((CombinedFragment)element).getTimelines();
      Set<String> _set = IterableExtensions.<String>toSet(_timelines);
      List<String> _sort = IterableExtensions.<String>sort(_set);
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
