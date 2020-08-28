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
package org.polarsys.capella.scenario.editor.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.behavior.AbstractEvent;
import org.polarsys.capella.common.data.modellingcore.AbstractNamedElement;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.ExchangeItemAllocation;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.ctx.SystemAnalysis;
import org.polarsys.capella.core.data.epbs.EPBSArchitecture;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.interaction.InstanceRole;
import org.polarsys.capella.core.data.interaction.Scenario;
import org.polarsys.capella.core.data.interaction.ScenarioKind;
import org.polarsys.capella.core.data.interaction.properties.controllers.DataFlowHelper;
import org.polarsys.capella.core.data.interaction.properties.dialogs.sequenceMessage.model.SelectInvokedOperationModelForSharedDataAndEvent;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.oa.Role;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.ScenarioExt;
import org.polarsys.capella.core.sirius.analysis.FaServices;
import org.polarsys.capella.core.sirius.analysis.InteractionServices;
import org.polarsys.capella.core.sirius.analysis.OAServices;
import org.polarsys.capella.scenario.editor.EmbeddedEditorInstance;

public class EmbeddedEditorInstanceHelper {
  public static EList<InstanceRole> getAvailableInstanceRoles() {
    Scenario currentScenario = EmbeddedEditorInstance.getAssociatedScenarioDiagram();
    return currentScenario.getOwnedInstanceRoles();
  }

  public static String getName(EObject element) {
    String name = "";
    if (element instanceof AbstractNamedElement) {
      name = ((AbstractNamedElement) element).getName();
    }
    return name;
  }

  /**
   * get the names of the available exchanges
   * 
   * @param source
   *          - the name of the source element
   * @param target
   *          - the name of the target element
   * @return list of exchanges
   *
   */
  public static List<String> getExchangeNames(String source, String target) {
    List<String> messages = new ArrayList<String>();

    List<AbstractEvent> exchanges = getAvailableExchanges(source, target);
    for (AbstractEvent exchange : exchanges) {
      messages.add(exchange.getName());
    }

    return messages;
  }

  /**
   * returns the list of available exchanges possible to be inserted between source and target
   * 
   * @param source
   *          - the name of the source element
   * @param target
   *          - the name of the target element
   * @return list of exchanges
   *
   */
  public static List<AbstractEvent> getAvailableExchanges(String source, String target) {
    List<AbstractEvent> exchangesAvailable = new ArrayList();
    InstanceRole sourceIr = EmbeddedEditorInstanceHelper.getInstanceRole(source);
    InstanceRole targetIr = EmbeddedEditorInstanceHelper.getInstanceRole(target);
    Scenario currentScenario = EmbeddedEditorInstance.getAssociatedScenarioDiagram();

    switch (currentScenario.getKind()) {
    case DATA_FLOW:
      exchangesAvailable = (List<AbstractEvent>) DataFlowHelper.getAvailableComponentExchanges(sourceIr, targetIr);
      if (exchangesAvailable.isEmpty())
        exchangesAvailable = DataFlowHelper.getAvailableFonctionalExchanges(sourceIr, targetIr).stream()
            .filter(x -> x instanceof AbstractEvent).collect(Collectors.toList());
      break;
    case FUNCTIONAL:
      exchangesAvailable = DataFlowHelper.getAvailableFonctionalExchangesFromFunctions(sourceIr, targetIr).stream()
          .filter(x -> x instanceof AbstractEvent).collect(Collectors.toList());
      break;
    case INTERFACE:
      List<CapellaElement> exchanges = SelectInvokedOperationModelForSharedDataAndEvent
          .getAvailableExchangeItems(sourceIr, targetIr, false);
      for (CapellaElement message : exchanges) {
        if (message instanceof ExchangeItemAllocation) {
          ExchangeItemAllocation allocation = (ExchangeItemAllocation) message;
          if (allocation.getAllocatedItem() instanceof ExchangeItem) {
            ExchangeItem item = allocation.getAllocatedItem();
            exchangesAvailable.add(item);
          }
        }
      }
      break;
    case INTERACTION:
      if (ScenarioExt.isFunctionalScenario(currentScenario)) {
        exchangesAvailable = DataFlowHelper.getAvailableFonctionalExchangesFromFunctions(sourceIr, targetIr).stream()
            .filter(x -> x instanceof AbstractEvent).collect(Collectors.toList());
      } else {
        exchangesAvailable = DataFlowHelper.getAvailableFonctionalExchanges(sourceIr, targetIr).stream()
            .filter(x -> x instanceof AbstractEvent).collect(Collectors.toList());

        // communication means
        if (exchangesAvailable.isEmpty()) {
          exchangesAvailable = (List<AbstractEvent>) DataFlowHelper.getAvailableComponentExchanges(sourceIr, targetIr)
              .stream().filter(x -> x instanceof AbstractEvent).collect(Collectors.toList());
        }
      }
      break;
    default:
      break;
    }
    return exchangesAvailable;
  }

  /**
   * returns the list of available elements as names that could be inserted
   * 
   * @param keyword
   * @return boolean
   *
   */
  public static List<String> getAvailablePartNames(String keyword) {
    List<String> partNames = new ArrayList<String>();

    Collection<? extends EObject> elements = getAvailableElements(keyword);
    for (EObject element : elements) {
      if (element instanceof AbstractNamedElement) {
        partNames.add(((AbstractNamedElement) element).getName());
      }
    }
    return partNames;
  }

  /**
   * returns the list of available elements that could be inserted for the given keyword (which can be actor, component,
   * function, entity, role, activity, configuration_item)
   * 
   * @param keyword
   * @return boolean
   *
   */
  public static Collection<? extends EObject> getAvailableElements(String keyword) {
    List<? extends EObject> elementsForKeyword = new ArrayList();

    Collection<? extends EObject> elements = getAvailableElements();

    switch (keyword) {
    case DslConstants.ACTIVITY:
    case DslConstants.FUNCTION:
      elementsForKeyword = elements.stream().filter(x -> x instanceof AbstractFunction).collect(Collectors.toList());
      break;
    case DslConstants.ROLE:
      elementsForKeyword = elements.stream().filter(x -> x instanceof Role).collect(Collectors.toList());
      break;
    case DslConstants.ACTOR:
      elementsForKeyword = elements.stream().filter(x -> x instanceof Part
          && ((Part) x).getAbstractType() instanceof Component && ((Component) ((Part) x).getAbstractType()).isActor())
          .collect(Collectors.toList());
      break;
    default:
      // gets all the components (non actors)
      elementsForKeyword = elements.stream().filter(x -> x instanceof Part
          && ((Part) x).getAbstractType() instanceof Component && !((Component) ((Part) x).getAbstractType()).isActor())
          .collect(Collectors.toList());
      break;
    }
    return elementsForKeyword;
  }

  /**
   * returns instance role associated to the source (source is the name of the instance role)
   * 
   * @param soruce
   *          (name of the instance role)
   * @return InstanceRole
   *
   */
  public static InstanceRole getInstanceRole(String source) {
    EList<InstanceRole> instanceRoles = getAvailableInstanceRoles();
    InstanceRole instanceRole = null;
    for (Iterator<InstanceRole> iterator = instanceRoles.iterator(); iterator.hasNext();) {
      InstanceRole role = iterator.next();
      if (role.getName().equals(source)) {
        instanceRole = role;
        break;
      }
    }
    return instanceRole;
  }

  /**
   * returns the list of available elements that could be inserted on the current scenario
   * 
   * @return collection of elements
   *
   */
  public static Collection<? extends EObject> getAvailableElements() {
    Collection<? extends EObject> elements = new ArrayList();
    Scenario currentScenario = EmbeddedEditorInstance.getAssociatedScenarioDiagram();
    switch (currentScenario.getKind()) {
    case INTERACTION:
      Collection<EObject> elements1 = OAServices.getService().getOESScopeInsertEntitiesRoles(currentScenario);
      Collection<AbstractFunction> elements2 = FaServices.getFaServices()
          .getAllAbstractFunctions(BlockArchitectureExt.getRootBlockArchitecture(currentScenario));
      elements1.addAll(elements2);
      elements = elements1;
      break;
    case DATA_FLOW:
    case INTERFACE:
      List<Part> elements3 = (new InteractionServices()).getESScopeInsertComponents(currentScenario);
      List<Part> elements4 = (new InteractionServices()).getESScopeInsertActors(currentScenario);
      elements3.addAll(elements4);
      elements = elements3;
      break;
    case FUNCTIONAL:
      elements = FaServices.getFaServices()
          .getAllAbstractFunctions(BlockArchitectureExt.getRootBlockArchitecture(currentScenario));
      break;
    default:
      break;
    }
    return elements;
  }

  /**
   * helper function that validates that a keyword typed in a text scenario is valid, based on scenario type and
   * architecture level
   * 
   * @param keyword
   * @return boolean
   *
   */
  public static boolean checkValidKeyword(String keyword) {
    Scenario currentScenario = EmbeddedEditorInstance.getAssociatedScenarioDiagram();
    BlockArchitecture blockArchitecture = BlockArchitectureExt.getRootBlockArchitecture(currentScenario);

    if (currentScenario.getKind() == ScenarioKind.INTERACTION) {
      if (ScenarioExt.isFunctionalScenario(currentScenario)) {
        return keyword.equals(DslConstants.ACTIVITY);
      } else {
        return keyword.equals(DslConstants.ENTITY) || keyword.equals(DslConstants.ACTOR)
            || keyword.equals(DslConstants.ROLE);
      }
    }
    // IS and ES
    if (currentScenario.getKind() == ScenarioKind.INTERFACE || currentScenario.getKind() == ScenarioKind.DATA_FLOW) {
      if (blockArchitecture instanceof SystemAnalysis) {
        return keyword.equals(DslConstants.ACTOR);
      }
      if (blockArchitecture instanceof LogicalArchitecture || blockArchitecture instanceof PhysicalArchitecture) {
        return keyword.equals(DslConstants.ACTOR) || keyword.equals(DslConstants.COMPONENT);
      }
      if (blockArchitecture instanceof EPBSArchitecture) {
        return keyword.equals(DslConstants.CONFIGURATION_ITEM);
      }
    }
    // FS Scenarios
    if (currentScenario.getKind() == ScenarioKind.FUNCTIONAL) {
      if (blockArchitecture instanceof SystemAnalysis || blockArchitecture instanceof LogicalArchitecture
          || blockArchitecture instanceof PhysicalArchitecture) {
        return keyword.equals(DslConstants.FUNCTION);
      }
    }
    return false;
  }
}
