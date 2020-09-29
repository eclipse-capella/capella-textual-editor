package org.polarsys.capella.scenario.editor.embeddededitor.commands;

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
}
