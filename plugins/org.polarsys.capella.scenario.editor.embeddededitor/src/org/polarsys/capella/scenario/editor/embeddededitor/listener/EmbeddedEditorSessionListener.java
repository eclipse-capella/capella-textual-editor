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

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.polarsys.capella.core.data.interaction.Scenario;
import org.polarsys.capella.core.model.handler.helpers.CapellaAdapterHelper;
import org.polarsys.capella.scenario.editor.EmbeddedEditorInstance;
import org.polarsys.capella.scenario.editor.embeddededitor.commands.DiagramToXtextCommands;
import org.polarsys.capella.scenario.editor.embeddededitor.helper.XtextEditorHelper;
import org.polarsys.capella.scenario.editor.embeddededitor.views.EmbeddedEditorView;

/*
 * Listener to session change events, to control when the embedded editor is displayed and linked to a diagram
 */
public class EmbeddedEditorSessionListener implements SessionManagerListener {
  private static ISelectionListener selectionListener;
  static Object currentSelected;

  @Override
  public void notify(Session session, int notification) {
    if (PlatformUI.getWorkbench() != null && PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null) {
      IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
      if (activePage != null)
        activePage.addSelectionListener(getSelectionListener());
    }
  }

  public static ISelectionListener getSelectionListener() {
    if (selectionListener == null) {
      selectionListener = createSelectionListener();
    }
    return selectionListener;
  }

  public static Object handleSelection(IWorkbenchPart part, ISelection selection) {
	DialectEditor dEditor = (DialectEditor) part;
    DDiagram diagram = (DDiagram) dEditor.getRepresentation();
    EmbeddedEditorInstance.setDDiagram(diagram);
    Object result = null;
    if (selection != null && !selection.isEmpty() && (!(part instanceof EmbeddedEditorView))) {
      if (selection instanceof IStructuredSelection) {
        IStructuredSelection selectionStructure = (IStructuredSelection) selection;
        Object firstElement = selectionStructure.getFirstElement();
        result = CapellaAdapterHelper.resolveDescriptorOrBusinessObject(firstElement);
      }
    }
    return result;
  }

  protected static ISelectionListener createSelectionListener() {
    return (part, selection) -> {
      if (part instanceof DDiagramEditor) {
        Object newInput = handleSelection(part, selection);

        /*
         * when a new diagram of type scenario is opened, we use the class EmbeddedEditorInstance to save the current
         * scenario and we update the content of the embedded xtext editor
         */
        if (newInput instanceof DRepresentationDescriptor) {
          if (currentSelected == null || !newInput.equals(currentSelected)) {
            currentSelected = newInput;
            DRepresentationDescriptor desc = (DRepresentationDescriptor) currentSelected;
            if (desc.getTarget() instanceof Scenario) {
              Scenario sc = (Scenario) desc.getTarget();
              IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
              EmbeddedEditorView eeView = XtextEditorHelper.getActiveEmbeddedEditorView();
              if (eeView == null) {
                // Show it if not found.
                try {
                  eeView = (EmbeddedEditorView) activePage.showView(EmbeddedEditorView.ID);
                } catch (PartInitException e) {
                  System.err.println("Cannot open Textual Editor View");
                }
                activePage.activate(eeView);
              }
              eeView.refreshTitleBar(sc.getName());
              DiagramToXtextCommands.process(sc, eeView); // update the embedded editor text view
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
