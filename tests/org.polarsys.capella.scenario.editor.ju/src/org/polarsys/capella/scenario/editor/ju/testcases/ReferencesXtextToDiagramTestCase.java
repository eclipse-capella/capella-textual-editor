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

public class ReferencesXtextToDiagramTestCase extends TextualScenarioTestFramework {

  public static final String referencesDiagramName = "[ES] Capability 1 References";
  public static final String referencesFileContentExpected = "[ES]_Capability_1_References";
  
  @Override
  public void test() throws Exception {
    init();
    List<String> elementsNew = new ArrayList<String>();
    
    testUpdateDiagram(referencesDiagramName, referencesFileContentExpected, 
        "[ES]_Capability_1_References_New", elementsNew);
  }

}
