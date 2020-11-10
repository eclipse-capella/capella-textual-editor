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

public class LostAndFoundXtextToDiagramTestCase extends TextualScenarioTestFramework {

  public static final String lostAndFoundDiagramName = "[ES] Capability 1 Lost And Found";
  public static final String lostAndFoundFileContentExpected = "[ES]_Capability_1_Lost_And_Found";
  
  @Override
  public void test() throws Exception {
    init();
    List<String> elementsNew = new ArrayList<String>(Arrays.asList("o-> SA 3 : fe1", "SA 2 ->o : fe1"));
    
    testUpdateDiagram(lostAndFoundDiagramName, lostAndFoundFileContentExpected, 
        "[ES]_Capability_1_Lost_And_Found_New", elementsNew);
  }

}
