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
package org.polarsys.capella.scenario.editor.dslscenario.formatting2;

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
import org.polarsys.capella.scenario.editor.dslscenario.dsl.DslPackage;
import org.polarsys.capella.scenario.editor.dslscenario.dsl.Message;
import org.polarsys.capella.scenario.editor.dslscenario.dsl.Model;
import org.polarsys.capella.scenario.editor.dslscenario.dsl.Participant;
import org.polarsys.capella.scenario.editor.dslscenario.services.DslGrammarAccess;

@SuppressWarnings("all")
public class DslFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private DslGrammarAccess _dslGrammarAccess;
  
  protected void _format(final Model model, @Extension final IFormattableDocument document) {
    final ISemanticRegion begin = this.textRegionExtensions.regionFor(model).feature(DslPackage.Literals.MODEL__BEGIN);
    final ISemanticRegion end = this.textRegionExtensions.regionFor(model).feature(DslPackage.Literals.MODEL__END);
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
  }
  
  protected void _format(final Message message, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(this.textRegionExtensions.regionFor(message).feature(DslPackage.Literals.MESSAGE__NAME), _function);
  }
  
  protected void _format(final Participant participant, @Extension final IFormattableDocument document) {
    final ISemanticRegion p = this.textRegionExtensions.regionFor(participant).feature(DslPackage.Literals.PARTICIPANT__NAME);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(this.textRegionExtensions.regionFor(participant).feature(DslPackage.Literals.PARTICIPANT__NAME), _function);
  }
  
  public void format(final Object message, final IFormattableDocument document) {
    if (message instanceof XtextResource) {
      _format((XtextResource)message, document);
      return;
    } else if (message instanceof Message) {
      _format((Message)message, document);
      return;
    } else if (message instanceof Model) {
      _format((Model)message, document);
      return;
    } else if (message instanceof Participant) {
      _format((Participant)message, document);
      return;
    } else if (message instanceof EObject) {
      _format((EObject)message, document);
      return;
    } else if (message == null) {
      _format((Void)null, document);
      return;
    } else if (message != null) {
      _format(message, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(message, document).toString());
    }
  }
}
