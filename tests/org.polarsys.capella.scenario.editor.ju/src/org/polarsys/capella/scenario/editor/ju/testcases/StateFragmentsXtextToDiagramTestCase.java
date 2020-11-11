/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
 *  
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 *  
 *  Contributors:
 *     Thales - initial API and implementation
 ******************************************************************************/
package org.polarsys.capella.scenario.editor.ju.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.scenario.editor.ju.util.TextualScenarioTestFramework;

public class StateFragmentsXtextToDiagramTestCase extends TextualScenarioTestFramework {

  public static final String stateFragmentsFunctionsDiagramName = "[ES] Capability 1 State Fragments";
  public static final String stateFragmentsFunctionsContentExpected = "[ES]_Capability_1_State_Fragments";
  public static final String stateFragmentsDiagramName = "[FS] Capability 1 State Fragments";
  public static final String stateFragmentsContentExpected = "[FS]_Capability_1_State_Fragments";
  
  @Override
  public void test() throws Exception {
    init();
    List<String> elementsNew = new ArrayList<String>(Arrays.asList("on SA 2 function SystemFunction 1",
        "on SA 3 function SystemFunction 2"));
    List<String> elementsNew2 = new ArrayList<String>(Arrays.asList("on SystemFunction 1 state State 2"));
    
    testUpdateDiagram(stateFragmentsFunctionsDiagramName, stateFragmentsFunctionsContentExpected, 
        "[ES]_Capability_1_State_Fragments_New", elementsNew);
    testUpdateDiagram(stateFragmentsDiagramName, stateFragmentsContentExpected, 
        "[FS]_Capability_1_State_Fragments_New", elementsNew2);
  }
}
