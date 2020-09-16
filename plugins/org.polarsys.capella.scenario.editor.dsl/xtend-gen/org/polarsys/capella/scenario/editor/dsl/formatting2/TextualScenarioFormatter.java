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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.polarsys.capella.scenario.editor.dsl.services.TextualScenarioGrammarAccess;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Alt;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Block;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ElseBlock;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Message;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Reference;
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
    final Consumer<EObject> _function_4 = (EObject element) -> {
      document.<EObject>format(element);
    };
    model.getMessagesOrReferences().forEach(_function_4);
    final Consumer<Alt> _function_5 = (Alt element) -> {
      document.<Alt>format(element);
    };
    model.getConditions().forEach(_function_5);
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
  
  protected void _format(final Alt condition, @Extension final IFormattableDocument document) {
    this.format(condition.getBlock(), document);
    final Consumer<ElseBlock> _function = (ElseBlock element) -> {
      document.<ElseBlock>format(element);
    };
    condition.getElseBlocks().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.<Alt>append(condition, _function_1);
  }
  
  protected void _format(final ElseBlock elseBlock, @Extension final IFormattableDocument document) {
    this.format(elseBlock.getBlock(), document);
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
    final Consumer<Message> _function_2 = (Message element) -> {
      document.<Message>format(element);
    };
    block.getMessages().forEach(_function_2);
    final Consumer<Reference> _function_3 = (Reference element) -> {
      document.<Reference>format(element);
    };
    block.getReferences().forEach(_function_3);
    final Consumer<Alt> _function_4 = (Alt element) -> {
      document.<Alt>format(element);
    };
    block.getConditions().forEach(_function_4);
  }
  
  public void format(final Object condition, final IFormattableDocument document) {
    if (condition instanceof XtextResource) {
      _format((XtextResource)condition, document);
      return;
    } else if (condition instanceof Alt) {
      _format((Alt)condition, document);
      return;
    } else if (condition instanceof Block) {
      _format((Block)condition, document);
      return;
    } else if (condition instanceof ElseBlock) {
      _format((ElseBlock)condition, document);
      return;
    } else if (condition instanceof Message) {
      _format((Message)condition, document);
      return;
    } else if (condition instanceof Model) {
      _format((Model)condition, document);
      return;
    } else if (condition instanceof Participant) {
      _format((Participant)condition, document);
      return;
    } else if (condition instanceof EObject) {
      _format((EObject)condition, document);
      return;
    } else if (condition == null) {
      _format((Void)null, document);
      return;
    } else if (condition != null) {
      _format(condition, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(condition, document).toString());
    }
  }
}
