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
import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.scenario.editor.ju.util.TextualScenarioTestFramework;

public class SaveDataFromXtextToDiagramTestCase extends TextualScenarioTestFramework {
  @Override
  public void test() throws Exception {
    init();
    List<String> elementsNew1 = new ArrayList<String>(Arrays.asList("Logical Component:LC 4", "Logical Component:LA 8",
        "Logical Component:LC 5", "Logical Component:LA 7"));
    List<String> elementsNew2 = new ArrayList<String>(Arrays.asList("Logical Component:LA 6", "Logical Component:LA 5",
        "Logical Component:LA 4", "Logical Component:LA 8", "Logical Component:LC 5", "LA 4 -> LA 5 : ex3",
        "LA 5 -> LA 4 : ex3", "LA 4 -> LA 6 : ex4"));

    testUpdateDiagram(simpleDiagramName, simpleFileContentExpected, "[IS]_CapabilityRealization_1_Simple_New1", elementsNew1);
    testUpdateDiagram(simpleDiagramName, simpleFileContentExpected, "[IS]_CapabilityRealization_1_Simple_New2", elementsNew2);
  }
}
