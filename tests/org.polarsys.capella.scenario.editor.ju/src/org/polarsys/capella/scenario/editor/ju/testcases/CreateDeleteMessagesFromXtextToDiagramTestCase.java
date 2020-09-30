package org.polarsys.capella.scenario.editor.ju.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.scenario.editor.ju.util.TextualScenarioTestFramework;

public class CreateDeleteMessagesFromXtextToDiagramTestCase extends TextualScenarioTestFramework {

  public static final String createDeleteMessageDiagramName = "[IS] Capability 1 Create Delete";
  public static final String createDeleteMessageFileContentExpected = "[IS]_Capability_1_Create_Delete";
  
  @Override
  public void test() throws Exception {
    init();
    List<String> elementsNew = new ArrayList<String>(Arrays.asList("System ->+ SA 3 : create1", 
        "SA 3 ->+ SA 2 : create2", "SA 2 ->x SA 3 : delete", "System ->x SA 2 : delete2"));
    
    testUpdateDiagram(createDeleteMessageDiagramName, createDeleteMessageFileContentExpected, 
        "[IS]_Capability_1_Create_Delete_New", elementsNew);
  }

}
