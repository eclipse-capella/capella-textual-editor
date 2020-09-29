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
package org.polarsys.capella.scenario.editor;

import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.sequence.SequenceDDiagram;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.polarsys.capella.core.data.interaction.Scenario;

/*
 * EmbeddedEditorInstance class keeps references to both the current embedded editor and the Capella scenario diagram
 */
public class EmbeddedEditorInstance {
  private static EmbeddedEditor embeddedEditor;
  private static DDiagram diagram;

  private static EmbeddedEditorInstance eINSTANCE;

  private EmbeddedEditorInstance() {
  }

  public EmbeddedEditorInstance getInstance() {
    if (eINSTANCE == null) {
      eINSTANCE = new EmbeddedEditorInstance();
    }
    return eINSTANCE;
  }

  public static EmbeddedEditor getEmbeddedEditor() {
    return embeddedEditor;
  }

  public static void setEmbeddedEditor(EmbeddedEditor eEditor) {
    EmbeddedEditorInstance.embeddedEditor = eEditor;
  }

  public static Scenario getAssociatedScenarioDiagram() {
    return (Scenario) ((SequenceDDiagram) diagram).getTarget();
  }

  public static DDiagram getDDiagram() {
    return diagram;
  }

  public static void setDDiagram(DDiagram ddiagram) {
    EmbeddedEditorInstance.diagram = ddiagram;
  }

}
