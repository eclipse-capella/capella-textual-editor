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
package org.polarsys.capella.scenario.editor.dsl.helpers;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.AbstractEventOperation;
import org.polarsys.capella.core.model.helpers.CapellaElementExt;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage;
import org.polarsys.capella.scenario.editor.helper.EmbeddedEditorInstanceHelper;

/**
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist
 * on how to customize the content assistant.
 */
@SuppressWarnings("all")
public class TextualScenarioHelper {
  private static final String TYPE_FE = "FE";
  
  private static final String TYPE_CE = "CE";
  
  /**
   * calculate the type of exchanges allowed to be declared in the text
   */
  public static Object getScenarioAllowedExchangesType(final EList<EObject> elements) {
    boolean _isESScenario = EmbeddedEditorInstanceHelper.isESScenario();
    if (_isESScenario) {
      boolean _isCEScenario = EmbeddedEditorInstanceHelper.isCEScenario();
      if (_isCEScenario) {
        return TextualScenarioHelper.TYPE_CE;
      }
      boolean _isFEScenario = EmbeddedEditorInstanceHelper.isFEScenario();
      if (_isFEScenario) {
        return TextualScenarioHelper.TYPE_FE;
      }
      for (final EObject element : elements) {
        {
          if ((element instanceof SequenceMessage)) {
            SequenceMessage message = ((SequenceMessage) element);
            return TextualScenarioHelper.getMessageExchangeType(message);
          }
          if ((element instanceof CombinedFragment)) {
            CombinedFragment combinedFragment = ((CombinedFragment) element);
            return TextualScenarioHelper.getScenarioAllowedExchangesType(combinedFragment.getBlock().getBlockElements());
          }
        }
      }
    }
    return null;
  }
  
  public static String getMessageExchangeType(final SequenceMessage message) {
    List<AbstractEventOperation> exchangesAvailable = EmbeddedEditorInstanceHelper.getExchangeMessages(message.getSource(), message.getTarget());
    for (final AbstractEventOperation exchange : exchangesAvailable) {
      if (((!Objects.equal(message.getName(), null)) && message.getName().equals(CapellaElementExt.getName(exchange)))) {
        return TextualScenarioHelper.getExchangeType(exchange);
      }
    }
    return null;
  }
  
  public static String getExchangeType(final EObject exchangeElement) {
    if ((exchangeElement instanceof ComponentExchange)) {
      return TextualScenarioHelper.TYPE_CE;
    } else {
      if ((exchangeElement instanceof FunctionalExchange)) {
        return TextualScenarioHelper.TYPE_FE;
      }
    }
    return null;
  }
  
  public static Object getModelContainer(final EObject object) {
    Object _xblockexpression = null;
    {
      if ((object instanceof Model)) {
        return ((Model) object);
      }
      _xblockexpression = TextualScenarioHelper.getModelContainer(object.eContainer());
    }
    return _xblockexpression;
  }
  
  public static EList<Participant> participantsDefinedBefore(final EObject element) {
    if ((element instanceof Model)) {
      return ((Model) element).getParticipants();
    } else {
      Object _modelContainer = TextualScenarioHelper.getModelContainer(element);
      Model model = ((Model) _modelContainer);
      return model.getParticipants();
    }
  }
  
  public static ArrayList<String> participantsDefinedBeforeNames(final EObject element) {
    EList<Participant> participants = TextualScenarioHelper.participantsDefinedBefore(element);
    ArrayList<String> participantsNames = CollectionLiterals.<String>newArrayList();
    for (final Participant participant : participants) {
      participantsNames.add(participant.getName());
    }
    return participantsNames;
  }
  
  public static boolean isParticipantKeyword(final String keywordValue) {
    ArrayList<String> participantsKeywords = CollectionLiterals.<String>newArrayList("actor", "entity", "role", "activity", "component", 
      "configuration_item", "function");
    return participantsKeywords.contains(keywordValue);
  }
}
