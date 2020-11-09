package org.polarsys.capella.scenario.editor.ju.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.scenario.editor.ju.util.TextualScenarioTestFramework;

public class RolesXtextToDiagramTestCase extends TextualScenarioTestFramework {

  public static final String rolesDiagramName = "[OES] OperationalCapability 1 Roles";
  public static final String rolesFileContentExpected = "[OES]_OperationalCapability_1_Roles";
  
  @Override
  public void test() throws Exception {
    init();
    List<String> elementsNew = new ArrayList<String>(Arrays.asList("Role 1 -> Role 2 : i2"));
    
    testUpdateDiagram(rolesDiagramName, rolesFileContentExpected, 
        "[OES]_OperationalCapability_1_Roles_New", elementsNew);
  }

}
