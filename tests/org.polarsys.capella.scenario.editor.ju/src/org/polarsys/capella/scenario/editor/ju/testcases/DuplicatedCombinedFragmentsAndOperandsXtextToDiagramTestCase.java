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
package org.polarsys.capella.scenario.editor.ju.testcases;

import java.util.ArrayList;
import java.util.List;

import org.polarsys.capella.scenario.editor.ju.util.TextualScenarioTestFramework;

public class DuplicatedCombinedFragmentsAndOperandsXtextToDiagramTestCase extends TextualScenarioTestFramework {

  public static final String duplicatedCFAndOperandsDiagramName = "[IS] Capability 1 Duplicated CF and Operands";
  public static final String duplicatedCFAndOperandsFileContentExpected = "[IS]_Capability_1_Duplicated_CF_And_Operands";

  @Override
  public void test() throws Exception {
    init();
    List<String> elementsNew = new ArrayList<String>();

    testUpdateDiagram(duplicatedCFAndOperandsDiagramName, duplicatedCFAndOperandsFileContentExpected,
        "[IS]_Capability_1_Duplicated_CF_And_Operands_New", elementsNew);
  }

}
