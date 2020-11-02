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
package org.polarsys.capella.scenario.editor.dsl.formatting2;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
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
import org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.TextualScenarioPackage;

@SuppressWarnings("all")
public class TextualScenarioFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private TextualScenarioGrammarAccess _textualScenarioGrammarAccess;
  
  protected void _format(final Model model, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(model);
    final ISemanticRegion begin = _regionFor.feature(TextualScenarioPackage.Literals.MODEL__BEGIN);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(model);
    final ISemanticRegion end = _regionFor_1.feature(TextualScenarioPackage.Literals.MODEL__END);
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
    EList<Participant> _participants = model.getParticipants();
    final Consumer<Participant> _function_3 = (Participant element) -> {
      document.<Participant>format(element);
    };
    _participants.forEach(_function_3);
    EList<Element> _elements = model.getElements();
    final Consumer<Element> _function_4 = (Element element) -> {
      document.<Element>format(element);
    };
    _elements.forEach(_function_4);
  }
  
  protected void _format(final Message message, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(message);
    ISemanticRegion _feature = _regionFor.feature(TextualScenarioPackage.Literals.MESSAGE__NAME);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_feature, _function);
  }
  
  protected void _format(final Participant participant, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(participant);
    final ISemanticRegion p = _regionFor.feature(TextualScenarioPackage.Literals.PARTICIPANT__NAME);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(participant);
    ISemanticRegion _feature = _regionFor_1.feature(TextualScenarioPackage.Literals.PARTICIPANT__NAME);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_feature, _function);
  }
  
  protected void _format(final CombinedFragment fragment, @Extension final IFormattableDocument document) {
    Block _block = fragment.getBlock();
    this.format(_block, document);
    EList<Operand> _operands = fragment.getOperands();
    final Consumer<Operand> _function = (Operand element) -> {
      document.<Operand>format(element);
    };
    _operands.forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.<CombinedFragment>append(fragment, _function_1);
  }
  
  protected void _format(final Operand operand, @Extension final IFormattableDocument document) {
    Block _block = operand.getBlock();
    this.format(_block, document);
  }
  
  protected void _format(final Block block, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(block);
    final ISemanticRegion begin = _regionFor.feature(TextualScenarioPackage.Literals.BLOCK__BEGIN);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(block);
    final ISemanticRegion end = _regionFor_1.feature(TextualScenarioPackage.Literals.BLOCK__END);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(begin, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(begin, end, _function_1);
    EList<Element> _blockElements = block.getBlockElements();
    final Consumer<Element> _function_2 = (Element element) -> {
      document.<Element>format(element);
    };
    _blockElements.forEach(_function_2);
  }
  
  protected void _format(final StateFragment stateFragment, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(stateFragment);
    ISemanticRegion _feature = _regionFor.feature(TextualScenarioPackage.Literals.STATE_FRAGMENT__NAME);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_feature, _function);
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
