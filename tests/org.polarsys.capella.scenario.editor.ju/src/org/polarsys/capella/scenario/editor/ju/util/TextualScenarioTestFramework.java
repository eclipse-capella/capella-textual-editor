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
package org.polarsys.capella.scenario.editor.ju.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.polarsys.capella.test.diagram.common.ju.context.DiagramContext;
import org.polarsys.capella.test.diagram.common.ju.step.crud.OpenDiagramStep;
import org.polarsys.capella.test.framework.api.NonDirtyTestCase;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.capella.common.data.modellingcore.AbstractType;
import org.polarsys.capella.common.helpers.EObjectLabelProviderHelper;
import org.polarsys.capella.core.data.information.AbstractInstance;
import org.polarsys.capella.core.data.interaction.InstanceRole;
import org.polarsys.capella.core.data.interaction.SequenceMessage;
import org.polarsys.capella.scenario.editor.embeddededitor.actions.RefreshAction;
import org.polarsys.capella.scenario.editor.embeddededitor.actions.SaveAction;
import org.polarsys.capella.scenario.editor.embeddededitor.helper.XtextEditorHelper;
import org.polarsys.capella.scenario.editor.embeddededitor.views.EmbeddedEditorView;
import org.polarsys.capella.scenario.editor.helper.EmbeddedEditorInstanceHelper;

public abstract class TextualScenarioTestFramework extends NonDirtyTestCase {
  public static final String simpleDiagramName = "[IS] CapabilityRealization 1 (Simple)";
  public static final String simpleFileContentExpected = "[IS]_CapabilityRealization_1_Simple";
  protected String invalidContentErrMsg = "Invalid content in diagram {0}.\n Text expected in editor:\n{1}\nFound:\n{2}";

  protected String modelName = "TextualEditor";
  protected Session session;
  protected SessionContext context;

  protected void init() {
    session = getSession(modelName);
    context = new SessionContext(session);
  }

  /**
   * test function, it checks the text editor associated to the diagram diagramName is updated and contains the correct
   * data
   * 
   * @param diagramName
   *          : the name of the diagram that is checked
   * @param fileContentExpected
   *          : the path to a file that contains the content that is expected to be found also in the text editor
   *          associated to diagramName
   * @return
   *
   */
  protected void testLoadDiagram(String diagramName, String fileContentExpected) {
    openDiagram(diagramName);

    reloadDataFromDiagram();

    String expectedContent = readFile(fileContentExpected);
    // check the content of the text editor
    checkValidContent(diagramName, expectedContent);

    // switch to a simple diagram to test that the editor is updated
    DiagramContext simpleDiagram = new OpenDiagramStep(context, simpleDiagramName).run();
    assertTrue(simpleDiagram != null);

    String simpleExpectedContent = readFile(simpleFileContentExpected);
    // check the content of the text editor
    checkValidContent(simpleDiagramName, simpleExpectedContent);
  }

  /**
   * test function, it checks the text editor associated to the diagram diagramName is updated and contains the correct
   * data and that after updating the text content and saving the data, the diagram is updated according to the text
   * commands
   * 
   * @param diagramName
   *          : the name of the diagram that is checked
   * @param fileContent
   *          : the path to a file that contains the current content in the text editor associated to diagramName
   * @param fileNewContent
   *          : the path to a file that contains the new content that is expected in the text editor after we update it
   * @param expectedElements
   *          : a list of expected elements that shall be created in diagram after updating and saving the model
   * @return
   *
   */
  protected void testUpdateDiagram(String diagramName, String fileContent, String fileNewContent,
      List<String> expectedElements) {
    DiagramContext diagram = openDiagram(diagramName);

    // get the diagram elements before saving
    EList<DDiagramElement> elementsBeforeUpdate = diagram.getDiagram().getDiagramElements();

    String contentBeforeUpdate = readFile(fileContent);
    String newContent = readFile(fileNewContent);

    // update data in text editor
    EmbeddedEditorInstanceHelper.updateModel(newContent);
    // if not save, data is not yet updated
    reloadDataFromDiagram();
    checkValidContent(diagramName, contentBeforeUpdate);

    // do the change again, update the text view
    EmbeddedEditorInstanceHelper.updateModel(newContent);
    // save data to diagram
    saveDataToDiagram();
    reloadDataFromDiagram();
    checkValidContent(diagramName, newContent);

    // get the elements in diagram and check that new ones have been inserted
    List<DDiagramElement> afterUpdateElements = new ArrayList<DDiagramElement>();
    afterUpdateElements.addAll(diagram.getDiagram().getDiagramElements());
    afterUpdateElements.removeAll(elementsBeforeUpdate);
    Set<String> newElements = new HashSet<String>();
    afterUpdateElements.forEach(x -> {
      EObject target = x.getTarget();
      if (target instanceof InstanceRole) {
        if (((InstanceRole) target).getRepresentedInstance().getAbstractType() != null) {
          AbstractType type = ((InstanceRole) target).getRepresentedInstance().getAbstractType();
          newElements.add(EObjectLabelProviderHelper.getMetaclassLabel(type, false) + ":"
              + EObjectLabelProviderHelper.getText(type));
        } else {
          AbstractInstance instance = ((InstanceRole) target).getRepresentedInstance();
          newElements.add(EObjectLabelProviderHelper.getMetaclassLabel(instance, false) + ":"
              + EObjectLabelProviderHelper.getText(instance));
        }
      } else if (target instanceof SequenceMessage) {
        SequenceMessage message = (SequenceMessage) target;
        InstanceRole sourceIr = message.getSendingEnd().getCovered();
        InstanceRole targetIr = message.getReceivingEnd().getCovered();
        newElements.add(sourceIr.getName() + " -> " + targetIr.getName() + " : " + message.getName());
      }
    });

    expectedElements.removeAll(newElements);
    StringBuilder sb = new StringBuilder();
    for (String data : expectedElements) {
      sb.append(data);
      sb.append("\n");
    }

    assertTrue("The following elements were not created:\n" + sb, sb.length() == 0);
    resetContent(diagramName, contentBeforeUpdate);
  }
  
  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList(modelName);
  }

  public void reloadDataFromDiagram() {
    RefreshAction action = new RefreshAction();
    action.run();
  }

  public void saveDataToDiagram() {
    SaveAction action = new SaveAction();
    action.run();
  }

  /**
   * reads the content of a file in the input folder; the input folder contains files with content of the text editor
   * that are checked
   * 
   * @param fileName
   *          : the name a file in the input folder
   * @return String : the content of the file as strings
   *
   */
  protected String readFile(String fileName) {
    String fileAsString = "";
    try {
      URL resolvedUrl = FileLocator.toFileURL(getClass().getResource("input/" + fileName));
      InputStream is = new FileInputStream(resolvedUrl.getPath());
      BufferedReader buffer = new BufferedReader(new InputStreamReader(is));

      String line = buffer.readLine();
      StringBuilder sb = new StringBuilder();

      while (line != null) {
        sb.append(line).append("\r\n");
        line = buffer.readLine();
      }
      sb.setLength(sb.length() - 2);
      fileAsString = sb.toString();
      buffer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return fileAsString;
  }

  /**
   * opens a diagram using the given diagram name
   * 
   * @param diagramName
   *          : the name of the diagram that is checked
   * @return
   *
   */
  protected DiagramContext openDiagram(String diagramName) {
    DiagramContext diagram = new OpenDiagramStep(context, diagramName).run();
    assertTrue(diagram != null);
    EmbeddedEditorView textEditorView = XtextEditorHelper.getActiveEmbeddedEditorView();
    assertTrue(textEditorView != null);

    return diagram;
  }

  /**
   * test function, it checks the text editor content contains the expectedContent
   * 
   * @param diagramName
   *          : the name of the diagram that is checked
   * @param expectedContent
   *          : the expected content of the text editor
   * @return
   *
   */
  protected void checkValidContent(String diagramName, String expectedContent) {
    String textEditorContent = EmbeddedEditorInstanceHelper.getModelContent();
    assertTrue(NLS.bind(invalidContentErrMsg, new String[] { diagramName, expectedContent, textEditorContent }),
        expectedContent.equals(textEditorContent));
  }
  
  /**
   * Reset text content to an initial value (content)
   * 
   * @param diagramName
   *          : the name of the diagram that is checked
   * @param content
   *          : the initial content
   * @return
   *
   */
  protected void resetContent(String diagramName, String content) {
    // redo the changes
    EmbeddedEditorInstanceHelper.updateModel(content);
    saveDataToDiagram();
    reloadDataFromDiagram();
    checkValidContent(diagramName, content);
  }

}
