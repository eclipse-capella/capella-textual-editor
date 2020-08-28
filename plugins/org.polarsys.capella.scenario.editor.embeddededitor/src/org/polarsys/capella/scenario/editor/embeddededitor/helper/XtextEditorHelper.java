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
package org.polarsys.capella.scenario.editor.embeddededitor.helper;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.polarsys.capella.scenario.editor.embeddededitor.views.EmbeddedEditorView;

public class XtextEditorHelper {

  public static EmbeddedEditorView getActiveEmbeddedEditorView() {
    IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    EmbeddedEditorView eeView = (EmbeddedEditorView) activePage.findView(EmbeddedEditorView.ID);
    return eeView;
  }
}
