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
package org.polarsys.capella.scenario.editor.dsl.formatting2;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.polarsys.capella.scenario.editor.dsl.services.TextualScenarioGrammarAccess;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Block;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Element;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Message;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Operand;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Reference;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.TextualScenarioPackage;

@SuppressWarnings("all")
public class TextualScenarioFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private TextualScenarioGrammarAccess _textualScenarioGrammarAccess;
  
  protected void _format(final Model model, @Extension final IFormattableDocument document) {
    final ISemanticRegion begin = this.textRegionExtensions.regionFor(model).feature(TextualScenarioPackage.Literals.MODEL__BEGIN);
    final ISemanticRegion end = this.textRegionExtensions.regionFor(model).feature(TextualScenarioPackage.Literals.MODEL__END);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(begin, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(begin, _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(begin, end, _function_2);
    final Consumer<Participant> _function_3 = (Participant element) -> {
      document.<Participant>format(element);
    };
    model.getParticipants().forEach(_function_3);
    final Consumer<Element> _function_4 = (Element element) -> {
      document.<Element>format(element);
    };
    model.getElements().forEach(_function_4);
  }
  
  protected void _format(final Message message, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(this.textRegionExtensions.regionFor(message).feature(TextualScenarioPackage.Literals.MESSAGE__NAME), _function);
  }
  
  protected void _format(final Participant participant, @Extension final IFormattableDocument document) {
    final ISemanticRegion p = this.textRegionExtensions.regionFor(participant).feature(TextualScenarioPackage.Literals.PARTICIPANT__NAME);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(this.textRegionExtensions.regionFor(participant).feature(TextualScenarioPackage.Literals.PARTICIPANT__NAME), _function);
  }
  
  protected void _format(final CombinedFragment fragment, @Extension final IFormattableDocument document) {
    this.format(fragment.getBlock(), document);
    final Consumer<Operand> _function = (Operand element) -> {
      document.<Operand>format(element);
    };
    fragment.getOperands().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.<CombinedFragment>append(fragment, _function_1);
  }
  
  protected void _format(final Operand operand, @Extension final IFormattableDocument document) {
    this.format(operand.getBlock(), document);
  }
  
  protected void _format(final Block block, @Extension final IFormattableDocument document) {
    final ISemanticRegion begin = this.textRegionExtensions.regionFor(block).feature(TextualScenarioPackage.Literals.BLOCK__BEGIN);
    final ISemanticRegion end = this.textRegionExtensions.regionFor(block).feature(TextualScenarioPackage.Literals.BLOCK__END);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(begin, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(begin, end, _function_1);
    final Consumer<Element> _function_2 = (Element element) -> {
      document.<Element>format(element);
    };
    block.getBlockElements().forEach(_function_2);
  }
  
  protected void _format(final StateFragment stateFragment, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(this.textRegionExtensions.regionFor(stateFragment).feature(TextualScenarioPackage.Literals.STATE_FRAGMENT__NAME), _function);
  }
  
  protected void _format(final Reference reference, @Extension final IFormattableDocument document) {
    final List<ISemanticRegion> features = this.textRegionExtensions.regionFor(reference).features(TextualScenarioPackage.Literals.REFERENCE__TIMELINES);
    int _size = features.size();
    int _minus = (_size - 1);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(features.get(_minus), _function);
  }
  
  public void format(final Object fragment, final IFormattableDocument document) {
    if (fragment instanceof XtextResource) {
      _format((XtextResource)fragment, document);
      return;
    } else if (fragment instanceof CombinedFragment) {
      _format((CombinedFragment)fragment, document);
      return;
    } else if (fragment instanceof Message) {
      _format((Message)fragment, document);
      return;
    } else if (fragment instanceof Reference) {
      _format((Reference)fragment, document);
      return;
    } else if (fragment instanceof StateFragment) {
      _format((StateFragment)fragment, document);
      return;
    } else if (fragment instanceof Block) {
      _format((Block)fragment, document);
      return;
    } else if (fragment instanceof Model) {
      _format((Model)fragment, document);
      return;
    } else if (fragment instanceof Operand) {
      _format((Operand)fragment, document);
      return;
    } else if (fragment instanceof Participant) {
      _format((Participant)fragment, document);
      return;
    } else if (fragment instanceof EObject) {
      _format((EObject)fragment, document);
      return;
    } else if (fragment == null) {
      _format((Void)null, document);
      return;
    } else if (fragment != null) {
      _format(fragment, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(fragment, document).toString());
    }
  }
}
