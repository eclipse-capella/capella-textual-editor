package org.polarsys.capella.scenario.editor.ju.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.scenario.editor.ju.util.TextualScenarioTestFramework;

public class DuplicatedMessagesFromXtextToDiagramTestCase extends TextualScenarioTestFramework {

  public static final String duplicatedMessagesDiagramName = "[IS] Capability 1 Duplicated Messages";
  public static final String duplicatedMessagesFileContentExpected = "[IS]_Capability_1_Duplicated_Messages";
  
  @Override
  public void test() throws Exception {
    init();
    List<String> elementsNew = new ArrayList<String>(Arrays.asList("SA 2 -> SA 3 : m1", "SA 2 -> SA 3 : m1"));
    
    testUpdateDiagram(duplicatedMessagesDiagramName, duplicatedMessagesFileContentExpected, 
        "[IS]_Capability_1_Duplicated_Messages_New", elementsNew);
  }

}
