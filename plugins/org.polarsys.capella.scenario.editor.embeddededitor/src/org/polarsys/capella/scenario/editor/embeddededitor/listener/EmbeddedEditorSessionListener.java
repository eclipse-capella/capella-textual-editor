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
import org.eclipse.sirius.diagram.sequence.description.SequenceDiagramDescription;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.polarsys.capella.core.data.interaction.Scenario;
import org.polarsys.capella.core.model.handler.helpers.CapellaAdapterHelper;
import org.polarsys.capella.scenario.editor.EmbeddedEditorInstance;
import org.polarsys.capella.scenario.editor.embeddededitor.commands.DiagramToXtextCommands;
import org.polarsys.capella.scenario.editor.embeddededitor.helper.XtextEditorHelper;
import org.polarsys.capella.scenario.editor.embeddededitor.views.EmbeddedEditorView;
import org.polarsys.capella.scenario.editor.helper.EmbeddedEditorInstanceHelper;

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
    Object result = null;
    
    if (selection != null && !selection.isEmpty() &&
        (!(part instanceof EmbeddedEditorView)) &&
        (selection instanceof IStructuredSelection)) {
      
        IStructuredSelection selectionStructure = (IStructuredSelection) selection;
        Object firstElement = selectionStructure.getFirstElement();
        result = CapellaAdapterHelper.resolveDescriptorOrBusinessObject(firstElement);
    }
    
    return result;
  }

  protected static ISelectionListener createSelectionListener() {
    return (part, selection) -> {

      if (part instanceof IWorkbenchPart) {
        Object newInput = handleSelection(part, selection);

        /*
         * when a new diagram of type scenario is opened, we use the class EmbeddedEditorInstance to save the current
         * scenario and we update the content of the embedded xtext editor
         */
        if (newInput instanceof DRepresentationDescriptor) {
          if (((DRepresentationDescriptor) newInput).getDescription() instanceof SequenceDiagramDescription) {

            DRepresentationDescriptor descriptor = (DRepresentationDescriptor) newInput;
            if (descriptor.getTarget() instanceof Scenario) {

              DDiagram currentDiagram = EmbeddedEditorInstance.getDDiagram();
              Scenario sc = (Scenario) descriptor.getTarget();
              if (currentDiagram == null || !newInput.equals(currentDiagram)) {
                EmbeddedEditorView eeView = XtextEditorHelper.getActiveEmbeddedEditorView();
                DRepresentation representation = descriptor.getRepresentation();
                if (eeView != null && representation instanceof DDiagram) {
                  // set the diagram
                  EmbeddedEditorInstance.setDDiagram((DDiagram) representation);

                  // refresh the text editor
                  DiagramToXtextCommands.process(sc, eeView); // update the embedded editor text view
                  eeView.refreshTitleBar(sc.getName());
                }
              }
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
