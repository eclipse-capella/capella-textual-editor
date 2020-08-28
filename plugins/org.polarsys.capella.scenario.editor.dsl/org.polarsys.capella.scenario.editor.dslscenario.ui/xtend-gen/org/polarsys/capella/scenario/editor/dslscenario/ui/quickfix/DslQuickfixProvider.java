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
package org.polarsys.capella.scenario.editor.dslscenario.ui.quickfix;

import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.polarsys.capella.scenario.editor.dslscenario.validation.DslValidator;

/**
 * Custom quickfixes.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
@SuppressWarnings("all")
public class DslQuickfixProvider extends DefaultQuickfixProvider {
  @Fix(DslValidator.INVALID_NAME)
  public void capitalizeName(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final IModification _function = (IModificationContext context) -> {
      final IXtextDocument xtextDocument = context.getXtextDocument();
      final String firstLetter = xtextDocument.get((issue.getOffset()).intValue(), 1);
      xtextDocument.replace((issue.getOffset()).intValue(), 1, firstLetter);
    };
    acceptor.accept(issue, "Create element (todo)", "Choose an id", "upcase.png", _function);
  }
  
  @Fix(DslValidator.DUPILCATED_NAME)
  public void duplicatedName(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final IModification _function = (IModificationContext context) -> {
      final IXtextDocument xtextDocument = context.getXtextDocument();
      final String firstLetter = xtextDocument.get((issue.getOffset()).intValue(), 1);
      xtextDocument.replace((issue.getOffset()).intValue(), 1, firstLetter);
    };
    acceptor.accept(issue, "Duplicated name (todo)", "Choose an id", "upcase.png", _function);
  }
}
