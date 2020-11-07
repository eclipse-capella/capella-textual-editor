package org.polarsys.capella.scenario.editor.ju.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.scenario.editor.ju.util.TextualScenarioTestFramework;

public class ExchangesAndInstanceRolesXtextToDiagramTestCase extends TextualScenarioTestFramework {

  public static final String exchangesInstanceRolesDiagramName = "[IS] Capability 1 Exchanges Instance Roles";
  public static final String exchangesInstanceRolesFileContentExpected = "[IS]_Capability_1_Exchanges_Instance_Roles";
  
  @Override
  public void test() throws Exception {
    init();
    List<String> elementsNew = new ArrayList<String>(Arrays.asList("System Component:SA 3", "SA 2 -> SA 3 : m1"));
    
    testUpdateDiagram(exchangesInstanceRolesDiagramName, exchangesInstanceRolesFileContentExpected, 
        "[IS]_Capability_1_Exchanges_Instance_Roles_New", elementsNew);
  }

}
