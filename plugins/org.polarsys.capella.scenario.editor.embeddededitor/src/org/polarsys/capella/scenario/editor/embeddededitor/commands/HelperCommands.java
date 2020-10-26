package org.polarsys.capella.scenario.editor.embeddededitor.commands;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.polarsys.capella.core.data.capellacore.Constraint;
import org.polarsys.capella.core.data.information.datavalue.OpaqueExpression;
import org.polarsys.capella.core.data.interaction.InteractionOperand;
import org.polarsys.capella.scenario.editor.dsl.provider.TextualScenarioProvider;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.embeddededitor.views.EmbeddedEditorView;
import org.polarsys.capella.scenario.editor.helper.EmbeddedEditorInstanceHelper;

public class HelperCommands {
  public static String getExpressionText(InteractionOperand operand) {
    Constraint guard = operand.getGuard();
    if (guard != null) {
      OpaqueExpression expression = (OpaqueExpression) guard.getOwnedSpecification();
      return expression.getBodies().isEmpty() ? "" : expression.getBodies().get(0);
    }
    return "";
  }
  
  public static boolean isValidTextResource(XtextResource resource) {
    IResourceValidator validator = resource.getResourceServiceProvider().getResourceValidator();
    List<Issue> issues = validator.validate(resource, CheckMode.ALL, null);
    return issues.isEmpty();
  }
  
  /**
   * get the xtext model
   * 
   * @param embeddedEditorViewPart
   *          - this is the embedded editor xtext object
   * @return - Model the xtext model embedded in this editor view
   */
  public static Model getModel(EmbeddedEditorView embeddedEditorViewPart) {
    TextualScenarioProvider p = embeddedEditorViewPart.getProvider();
    XtextResource resource = p.getResource();
    EList<EObject> content = resource.getContents();
    Model domainModel = null;
    if (!content.isEmpty() && content.get(0) instanceof Model) {
      domainModel = (Model) resource.getContents().get(0);
    } else {
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
  }

}
