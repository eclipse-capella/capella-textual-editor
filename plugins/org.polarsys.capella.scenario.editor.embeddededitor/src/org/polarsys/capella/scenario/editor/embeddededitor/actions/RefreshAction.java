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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.polarsys.capella.core.data.interaction.Scenario;
import org.polarsys.capella.scenario.editor.EmbeddedEditorInstance;
import org.polarsys.capella.scenario.editor.embeddededitor.commands.XtextEditorCommands;
import org.polarsys.capella.scenario.editor.embeddededitor.helper.XtextEditorHelper;
import org.polarsys.capella.scenario.editor.embeddededitor.views.EmbeddedEditorView;

public class RefreshAction extends Action {
  public static final String IMG_REFRESH = "icons/refresh.gif";
  public static final String PLUGIN_ID = "org.polarsys.capella.scenario.editor.embeddededitor";

  public RefreshAction() {
    setToolTipText("Refresh scenario text from diagram");
    ImageDescriptor imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, IMG_REFRESH);
    setImageDescriptor(imageDescriptor);
  }

  @Override
  public void run() {
    EmbeddedEditorView eeView = XtextEditorHelper.getActiveEmbeddedEditorView();
    Scenario scenarioDiagram = EmbeddedEditorInstance.getAssociatedScenarioDiagram();

    XtextEditorCommands.diagramToXtext(scenarioDiagram, eeView);
  }
}
