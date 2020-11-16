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
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.polarsys.capella.core.data.interaction.Scenario;
import org.polarsys.capella.scenario.editor.EmbeddedEditorInstance;
import org.polarsys.capella.scenario.editor.embeddededitor.commands.HelperCommands;
import org.polarsys.capella.scenario.editor.embeddededitor.commands.XtextToDiagramCommands;
import org.polarsys.capella.scenario.editor.embeddededitor.helper.XtextEditorHelper;
import org.polarsys.capella.scenario.editor.embeddededitor.views.EmbeddedEditorView;
import org.polarsys.capella.scenario.editor.helper.EmbeddedEditorInstanceHelper;

public class SaveAction extends Action {
  public SaveAction() {
    setToolTipText("Save text changes to diagram");
    setImageDescriptor(
        PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVE_EDIT));
  }

  @Override
  public void run() {
    EmbeddedEditorView eeView = XtextEditorHelper.getActiveEmbeddedEditorView();
    Scenario scenarioDiagram = EmbeddedEditorInstance.getAssociatedScenarioDiagram();

    if (EmbeddedEditorInstanceHelper.isSelectedRepresentation()) {
      XtextToDiagramCommands.process(scenarioDiagram, eeView);
    } else {
      HelperCommands.showDialogTextualEditor(HelperCommands.DIALOG_TITLE_UNABLE_TO_SAVE,
          HelperCommands.DIALOG_MESSAGE_ERROR_SAVE + " The associated diagram is not selected!");
    }
  }
}
