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

public class DeleteStateFragmentFromXtextToDiagramTestCase extends TextualScenarioTestFramework {

  public static final String deleteStateFragmentSimpleDiagramName = "[FS] Capability 1 (Simple)";
  public static final String deleteStateFragmentSimpleFileContentExpected = "[FS]_Capability_1_(Simple)";
  public static final String deleteStateFragmentESDiagramName = "[ES] Capability 1 (Simple)";
  public static final String deleteStateFragmentESFileContentExpected = "[ES]_Capability_1_(Simple)";

  @Override
  public void test() throws Exception {
    init();
    List<String> elementsNew1 = new ArrayList<String>(Arrays.asList("on SystemFunction 2 state State 1"));
    List<String> elementsNew2 = new ArrayList<String>(Arrays.asList("on SA 2 function SystemFunction 1"));

    testUpdateDiagram(deleteStateFragmentSimpleDiagramName, deleteStateFragmentSimpleFileContentExpected,
        "[FS]_Capability_1_(Simple)_New", elementsNew1);
    testUpdateDiagram(deleteStateFragmentESDiagramName, deleteStateFragmentESFileContentExpected,
        "[ES]_Capability_1_(Simple)_New", elementsNew2);

  }

}
