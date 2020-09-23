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

import org.polarsys.capella.scenario.editor.ju.util.TextualScenarioTestFramework;
import org.polarsys.capella.test.diagram.common.ju.context.DiagramContext;
import org.polarsys.capella.test.diagram.common.ju.step.crud.OpenDiagramStep;

public class ReloadDataFromDiagramToTextTestCase extends TextualScenarioTestFramework {
  @Override
  public void test() throws Exception {
    init();
    testLoadDiagram("[IS] CapabilityRealization 1 (Complex)", "[IS]_CapabilityRealization_1_Complex");
  }
}
