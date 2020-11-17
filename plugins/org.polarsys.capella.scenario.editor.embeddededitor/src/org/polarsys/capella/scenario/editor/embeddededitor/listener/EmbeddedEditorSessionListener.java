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
package org.polarsys.capella.scenario.editor.embeddededitor.listener;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.sequence.SequenceDDiagram;
import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.polarsys.capella.core.data.interaction.Scenario;
import org.polarsys.capella.scenario.editor.EmbeddedEditorInstance;
import org.polarsys.capella.scenario.editor.embeddededitor.commands.HelperCommands;
import org.polarsys.capella.scenario.editor.embeddededitor.helper.XtextEditorHelper;
import org.polarsys.capella.scenario.editor.embeddededitor.views.EmbeddedEditorView;

/*
 * Listener to session change events, to control when the embedded editor is displayed and linked to a diagram
 */
public class EmbeddedEditorSessionListener implements SessionManagerListener {
  private static ISelectionListener selectionListener;

  @Override
  public void notify(Session session, int notification) {
  }

  public static ISelectionListener getSelectionListener() {
    if (selectionListener == null) {
      selectionListener = createSelectionListener();
    }
    return selectionListener;
  }

  protected static ISelectionListener createSelectionListener() {
    return (part, selection) -> {

      if (part instanceof IWorkbenchPart) {
        DDiagram diagram = null;
        // first case is when we navigate between the opened diagrams
        if (part instanceof DDiagramEditor) {
          // set the diagram
          DDiagramEditor dEditor = (DDiagramEditor) part;
          if (dEditor.getRepresentation() instanceof DDiagram) {
            diagram = (DDiagram) dEditor.getRepresentation();
          }
        }
        
        /*
         * when we switch to another scenario diagram, we use the class EmbeddedEditorInstance to save the current
         * diagram and we update the content of the embedded xtext editor
         */
        if (diagram instanceof SequenceDDiagram && ((SequenceDDiagram) diagram).getTarget() instanceof Scenario) {
          DDiagram currentDiagram = EmbeddedEditorInstance.getDDiagram();
          if (currentDiagram == null || !currentDiagram.equals(diagram)) {
            // update the current selected diagram
            EmbeddedEditorInstance.setDDiagram(diagram);

            EmbeddedEditorView eeView = XtextEditorHelper.getActiveEmbeddedEditorView();
            if (eeView != null) {
              // refresh the text editor if the textual embedded editor is opened
              HelperCommands.refreshTextEditor(eeView);
            }
          }
        }
      }
    };
  }

  @Override
  public void notifyAddSession(Session newSession) {
  }

  @Override
  public void notifyRemoveSession(Session removedSession) {
  }

  @Override
  public void viewpointSelected(Viewpoint selectedSirius) {
  }

  @Override
  public void viewpointDeselected(Viewpoint deselectedSirius) {
  }

}
