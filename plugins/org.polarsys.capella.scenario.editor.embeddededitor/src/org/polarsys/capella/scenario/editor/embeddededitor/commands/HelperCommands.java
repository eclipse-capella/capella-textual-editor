package org.polarsys.capella.scenario.editor.embeddededitor.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.polarsys.capella.core.data.capellacore.Constraint;
import org.polarsys.capella.core.data.information.datavalue.OpaqueExpression;
import org.polarsys.capella.core.data.interaction.InteractionOperand;
import org.polarsys.capella.core.data.interaction.Scenario;
import org.polarsys.capella.scenario.editor.EmbeddedEditorInstance;
import org.polarsys.capella.scenario.editor.dsl.provider.TextualScenarioProvider;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.embeddededitor.views.EmbeddedEditorView;
import org.polarsys.capella.scenario.editor.helper.EmbeddedEditorInstanceHelper;

public class HelperCommands {
  public static final String DIALOG_TITLE_UNABLE_TO_REFRESH = "Unable to refresh";
  public static final String DIALOG_MESSAGE_ERROR_REFRESH = "Error on refreshing data to Textual Editor!";
  public static final String DIALOG_TITLE_UNABLE_TO_SAVE = "Unable to save";
  public static final String DIALOG_MESSAGE_ERROR_SAVE = "Error on saving data to diagram!";

  public static String getExpressionText(InteractionOperand operand) {
    Constraint guard = operand.getGuard();
    if (guard != null) {
      OpaqueExpression expression = (OpaqueExpression) guard.getOwnedSpecification();
      return expression.getBodies().isEmpty() ? null : expression.getBodies().get(0);
    }
    return null;
  }
  
  public static List<Issue> getValidationIsuesTextResource(XtextResource resource) {
    IResourceValidator validator = resource.getResourceServiceProvider().getResourceValidator();
    if(validator != null) {
    	return validator.validate(resource, CheckMode.ALL, null);
    }
    return new ArrayList<>();
  }
  
  public static String getFormattedIssues(List<Issue> issues) {
    StringBuilder sb = new StringBuilder();
    String newLine = "\r\n";
    int maxDisplay = 3;
    sb.append(newLine + newLine + "Found " + issues.size() + " issues:" + newLine);
    for (int i = 0; i < maxDisplay && i < issues.size(); i++) {
      Issue issue = issues.get(i);
      sb.append(
          issue.getMessage() + " (line : " + issue.getLineNumber() + " column : " + issue.getColumn() + ")" + newLine);
    }
    if (issues.size() > maxDisplay) {
      sb.append(newLine + "... " + (issues.size() - maxDisplay) + " more!" + newLine);
    }
    return sb.toString();
  }
  
  /**
   * get the xtext model object (clear the model if content already exist in it)
   * 
   * @param embeddedEditorViewPart
   *          - this is the embedded editor xtext object
   * @return - Model the xtext model embedded in this editor view
   */
  public static Model getModel(EmbeddedEditorView embeddedEditorViewPart) {
    TextualScenarioProvider p = embeddedEditorViewPart.getProvider();
    XtextResource resource = p.getResource();
    Model domainModel = null;
    if (resource != null) {
      EmbeddedEditorInstanceHelper.updateModel("scenario {}");
      EList<EObject> content1 = resource.getContents();
      if (!content1.isEmpty() && content1.get(0) instanceof Model) {
        domainModel = (Model) resource.getContents().get(0);
      }
    }
    return domainModel;
  }

  /**
   * clear the elements and participants in the xtext model
   * 
   * @param domainModel
   */
  public static void clearModel(Model domainModel) {
    if (domainModel != null && domainModel.getParticipants() != null) {
      domainModel.getParticipants().clear();
    }
    if (domainModel != null && domainModel.getElements() != null) {
      domainModel.getElements().clear();
    }
    if (domainModel != null) {
      domainModel.setBegin("{");
      domainModel.setEnd("}");
    }
  }

  public static void showDialogTextualEditor(String title, String message) {
    MessageDialog.openError(Display.getCurrent().getActiveShell(), title, message);
  }
  
  /*
   * refresh the text editor with the content from diagram
   */
  public static void refreshTextEditor(EmbeddedEditorView eeView) {
    DDiagram diagram = EmbeddedEditorInstance.getDDiagram();
    if(diagram != null) {
      Scenario scenario= EmbeddedEditorInstance.getAssociatedScenarioDiagram();
      if(scenario != null) {
        // refresh the text editor
        DiagramToXtextCommands.process(scenario, eeView); // update the embedded editor text view
        eeView.refreshTitleBar(scenario.getName()); 
      }
    } else {
    	eeView.refreshTitleBar("Textual Editor"); 
    	EmbeddedEditorInstanceHelper.cleanUpModel();
    }
  }
}
