package org.polarsys.capella.scenario.editor.ju.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.scenario.editor.ju.util.TextualScenarioTestFramework;

public class ArmTimerMessagesFromXtextToDiagramTestCase extends TextualScenarioTestFramework {

  public static final String armTimerMessageDiagramName = "[IS] Capability 1 Arm Timer";
  public static final String armTimerMessageFileContentExpected = "[IS]_Capability_1_Arm_Timer";
  
  @Override
  public void test() throws Exception {
    init();
    List<String> elementsNew = new ArrayList<String>(Arrays.asList("->> SA 2 : Arm Timer",
      "->> SA 3 : Arm Timer"));
    
    testUpdateDiagram(armTimerMessageDiagramName, armTimerMessageFileContentExpected, 
        "[IS]_Capability_1_Arm_Timer_New", elementsNew);
  }

}
