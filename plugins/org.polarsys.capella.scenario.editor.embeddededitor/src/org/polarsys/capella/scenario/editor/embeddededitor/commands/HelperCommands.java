package org.polarsys.capella.scenario.editor.embeddededitor.commands;

import java.util.List;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.polarsys.capella.core.data.capellacore.Constraint;
import org.polarsys.capella.core.data.information.datavalue.OpaqueExpression;
import org.polarsys.capella.core.data.interaction.InteractionOperand;

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
}
