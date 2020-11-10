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

public class DeleteCombinedFragmentFromXtextToDiagramTestCase extends TextualScenarioTestFramework {

  public static final String deleteCombinedFragmentSimpleDiagramName = "[FS] Capability 1 Combined Fragments";
  public static final String deleteCombinedFragmentSimpleFileContentExpected = "[FS]_Capability_1_Combined_Fragments";
  public static final String deleteCombinedFragmentESDiagramName = "[ES] Capability 1 Combined Fragments";
  public static final String deleteCombinedFragmentESFileContentExpected = "[ES]_Capability_1_Combined_Fragments";

  @Override
  public void test() throws Exception {
    init();
    List<String> elementsNew = new ArrayList<String>();

    testUpdateDiagram(deleteCombinedFragmentSimpleDiagramName, deleteCombinedFragmentSimpleFileContentExpected,
        "[FS]_Capability_1_Combined_Fragments_New", elementsNew);
    testUpdateDiagram(deleteCombinedFragmentESDiagramName, deleteCombinedFragmentESFileContentExpected,
        "[ES]_Capability_1_Combined_Fragments_New", elementsNew);
  }

}
