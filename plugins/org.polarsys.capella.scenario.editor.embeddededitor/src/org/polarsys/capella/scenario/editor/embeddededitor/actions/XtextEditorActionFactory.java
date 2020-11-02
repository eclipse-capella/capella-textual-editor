/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.scenario.editor.embeddededitor.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;
import org.polarsys.capella.scenario.editor.embeddededitor.views.EmbeddedEditorView;

public class XtextEditorActionFactory {

  public void createSaveAction(EmbeddedEditorView embeddedEditorViewPart) {
    Action saveAction = new SaveAction();
    getToolBarManager(embeddedEditorViewPart).add(saveAction);
  }

  public void createRefreshAction(EmbeddedEditorView embeddedEditorViewPart) {
    Action refreshAction = new RefreshAction();
    getToolBarManager(embeddedEditorViewPart).add(refreshAction);
  }

  private IToolBarManager getToolBarManager(EmbeddedEditorView semanticBrowserViewPart) {
    IViewSite viewSite = semanticBrowserViewPart.getViewSite();
    IActionBars actionBars = viewSite.getActionBars();
    return actionBars.getToolBarManager();
  }
}
