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
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
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

  public static String getScenarioType() {
    Scenario currentScenario = EmbeddedEditorInstance.getAssociatedScenarioDiagram();
    return currentScenario.getKind().toString();
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
   * returns the list of available abstract functions that could be inserted on the current scenario
   * 
   * @return collection of elements
   *
   */
  public static Collection<? extends EObject> getAvailableAbstractFunctions() {
    Collection<? extends EObject> elements = FaServices.getFaServices().getAllAbstractFunctions(
        BlockArchitectureExt.getRootBlockArchitecture(EmbeddedEditorInstance.getAssociatedScenarioDiagram()));
    return elements;
  }

  /**
   * returns the list of available components that could be inserted on the current scenario
   * 
   * @return collection of elements
   *
   */
  public static Collection<? extends EObject> getAvailableComponents() {
    Collection<? extends EObject> elements = (new InteractionServices())
        .getESScopeInsertComponents(EmbeddedEditorInstance.getAssociatedScenarioDiagram());
    return elements;
  }

  /**
   * returns the list of available actors that could be inserted on the current scenario
   * 
   * @return collection of elements
   *
   */
  public static Collection<? extends EObject> getAvailableActors() {
    Collection<? extends EObject> elements = (new InteractionServices())
        .getESScopeInsertActors(EmbeddedEditorInstance.getAssociatedScenarioDiagram());
    return elements;
  }

  /**
   * returns the list of available roles that could be inserted on the current scenario
   * 
   * @return collection of elements
   *
   */
  public static Collection<? extends EObject> getAvailableRoles() {
    Collection<? extends EObject> elements = OAServices.getService()
        .getOESScopeInsertEntitiesRoles(EmbeddedEditorInstance.getAssociatedScenarioDiagram()).stream()
        .filter(x -> x instanceof Role).collect(Collectors.toList());
    ;
    return elements;
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
    switch (keyword) {
    case DslConstants.ACTIVITY:
    case DslConstants.FUNCTION:
      return getAvailableAbstractFunctions();
    case DslConstants.ROLE:
      return getAvailableRoles();
    case DslConstants.ACTOR:
      return getAvailableActors();
    default:
      // gets all the components (non actors)
      return getAvailableComponents();
    }
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

    if (keyword.equals("withExecution") || keyword.equals("deactivate")) {
      return true;
    }
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
      if (blockArchitecture instanceof SystemAnalysis || blockArchitecture instanceof LogicalArchitecture
          || blockArchitecture instanceof PhysicalArchitecture) {
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
  
  public static void updateModel(String content) {
    XtextDocument document = EmbeddedEditorInstance.getEmbeddedEditor().getDocument();
    document.set(content);
    document.readOnly(new IUnitOfWork.Void<XtextResource>() {
      @Override
      public void process(XtextResource state) throws Exception {
      }
    });
  }
  
  public static String getModelContent() {
    XtextDocument document = EmbeddedEditorInstance.getEmbeddedEditor().getDocument();
    return document.get();
  }
}
