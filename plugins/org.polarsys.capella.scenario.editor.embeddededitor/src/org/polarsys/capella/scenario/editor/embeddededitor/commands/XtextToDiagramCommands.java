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
package org.polarsys.capella.scenario.editor.embeddededitor.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.sequence.SequenceDDiagram;
import org.eclipse.sirius.diagram.sequence.business.internal.layout.flag.SequenceEventAbsoluteBoundsFlagger;
import org.eclipse.sirius.diagram.sequence.business.internal.operation.SynchronizeGraphicalOrderingOperation;
import org.eclipse.sirius.diagram.ui.business.internal.operation.AbstractModelChangeOperation;
import org.eclipse.sirius.viewpoint.description.AnnotationEntry;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.XtextResource;
import org.polarsys.capella.common.menu.dynamic.CreationHelper;
import org.polarsys.capella.core.data.capellacommon.AbstractState;
import org.polarsys.capella.core.data.capellacore.CapellacoreFactory;
import org.polarsys.capella.core.data.capellacore.Constraint;
import org.polarsys.capella.core.data.cs.ExchangeItemAllocation;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.helpers.interaction.services.ExecutionEndExt;
import org.polarsys.capella.core.data.helpers.interaction.services.SequenceMessageExt;
import org.polarsys.capella.core.data.information.AbstractEventOperation;
import org.polarsys.capella.core.data.information.AbstractInstance;
import org.polarsys.capella.core.data.information.datavalue.DatavalueFactory;
import org.polarsys.capella.core.data.information.datavalue.OpaqueExpression;
import org.polarsys.capella.core.data.interaction.CombinedFragment;
import org.polarsys.capella.core.data.interaction.Event;
import org.polarsys.capella.core.data.interaction.EventReceiptOperation;
import org.polarsys.capella.core.data.interaction.EventSentOperation;
import org.polarsys.capella.core.data.interaction.Execution;
import org.polarsys.capella.core.data.interaction.ExecutionEnd;
import org.polarsys.capella.core.data.interaction.ExecutionEvent;
import org.polarsys.capella.core.data.interaction.FragmentEnd;
import org.polarsys.capella.core.data.interaction.InstanceRole;
import org.polarsys.capella.core.data.interaction.InteractionFactory;
import org.polarsys.capella.core.data.interaction.InteractionFragment;
import org.polarsys.capella.core.data.interaction.InteractionOperand;
import org.polarsys.capella.core.data.interaction.InteractionOperatorKind;
import org.polarsys.capella.core.data.interaction.InteractionState;
import org.polarsys.capella.core.data.interaction.MessageEnd;
import org.polarsys.capella.core.data.interaction.MessageKind;
import org.polarsys.capella.core.data.interaction.Scenario;
import org.polarsys.capella.core.data.interaction.SequenceMessage;
import org.polarsys.capella.core.data.interaction.StateFragment;
import org.polarsys.capella.core.data.interaction.TimeLapse;
import org.polarsys.capella.core.model.helpers.AbstractFragmentExt;
import org.polarsys.capella.core.model.helpers.ConstraintExt;
import org.polarsys.capella.core.model.helpers.ScenarioExt;
import org.polarsys.capella.scenario.editor.EmbeddedEditorInstance;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Block;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.CreateMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.DeleteMessage;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Operand;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ParticipantDeactivation;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType;
import org.polarsys.capella.scenario.editor.dsl.provider.TextualScenarioProvider;
import org.polarsys.capella.scenario.editor.embeddededitor.helper.XtextEditorHelper;
import org.polarsys.capella.scenario.editor.embeddededitor.views.EmbeddedEditorView;
import org.polarsys.capella.scenario.editor.helper.DslConstants;
import org.polarsys.capella.scenario.editor.helper.EmbeddedEditorInstanceHelper;

public class XtextToDiagramCommands {
  public static void process(Scenario scenario, EmbeddedEditorView embeddedEditorViewPart) {
    if (embeddedEditorViewPart != null) {
      TextualScenarioProvider p = embeddedEditorViewPart.getProvider();
      XtextResource resource = p.getResource();

      if (HelperCommands.isValidTextResource(resource)) {
        EList<EObject> content = resource.getContents();
        Model domainModel = (Model) content.get(0);

        // get participants
        EList<Participant> participants = domainModel.getParticipants();

        // get messages
        EList<EObject> messages = domainModel.getElements();

        doEditingOnParticipants(scenario, participants, messages);

        doEditingOnElements(scenario, messages);

        // do refresh - when the messages associated with the removed actors are deleted too,
        // a refresh is needed to update also the editor
        EmbeddedEditorView eeView = XtextEditorHelper.getActiveEmbeddedEditorView();
        Scenario scenarioDiagram = EmbeddedEditorInstance.getAssociatedScenarioDiagram();
        DiagramToXtextCommands.process(scenarioDiagram, eeView);
      } else {
        MessageDialog.openError(Display.getCurrent().getActiveShell(), "Invalid data",
            "Please fix the errors in the textual editor!");
      }
    }
  }

  private static void doEditingOnParticipants(Scenario scenario, EList<Participant> participants,
      EList<EObject> messages) {
    // Make sure your element is attached to a resource, otherwise this will return null
    TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(scenario);
    domain.getCommandStack().execute(new RecordingCommand(domain) {

      @Override
      protected void doExecute() {
        InstanceRole instanceRole;
        EList<InstanceRole> instanceRoles = scenario.getOwnedInstanceRoles();

        for (Iterator<Participant> iterator = participants.iterator(); iterator.hasNext();) {
          EObject participant = iterator.next();

          String instanceName = ((Participant) participant).getName();
          // if the participant doesn't exist, create it
          if (instanceRoles.stream().filter(ir -> ir.getName().equals(instanceName)).collect(Collectors.toList())
              .size() == 0) {
            instanceRole = InteractionFactory.eINSTANCE.createInstanceRole();
            instanceRole.setName(instanceName);

            String keyword = ((Participant) participant).getKeyword();

            EObject capellaParticipant = null;

            List<? extends EObject> capellaParticipants = EmbeddedEditorInstanceHelper.getAvailableElements(keyword)
                .stream().filter(f -> ((AbstractInstance) f).getName().equals(instanceName))
                .collect(Collectors.toList());
            if (capellaParticipants.size() > 0) {
              capellaParticipant = capellaParticipants.get(0);
            }

            instanceRole.setRepresentedInstance((AbstractInstance) capellaParticipant);
            instanceRoles.add(instanceRole);
          }
        }

        // remove all instance roles from diagram that do not exist in editor
        List<InstanceRole> removedIR = removeParticipantsFromDiagram(instanceRoles, participants);

        // for each removed instance role, delete the messages containing it.
        for (InstanceRole ir : removedIR) {
          removeEditorMessages(messages, ir.getName());
        }
        // do instance roles reorder if they do not match the order of the editor participants
        reorderParticipants(instanceRoles, participants);
      }
    });
  }

  /**
   * Remove all instance roles that are in the diagram, but not in the editor
   * 
   * @param instanceRoles
   *          Instance roles from diagram
   * @param participants
   *          Participants from editor
   * @return Return the list of the removed participants
   */
  private static List<InstanceRole> removeParticipantsFromDiagram(List<InstanceRole> instanceRoles,
      EList<Participant> participants) {
    List<InstanceRole> irToRemove = new ArrayList<InstanceRole>();
    for (InstanceRole ir : instanceRoles) {
      List<String> participantsName = participants.stream().map(x -> x.getName()).collect(Collectors.toList());
      if (!participantsName.contains(ir.getName())) {
        irToRemove.add(ir);
      }
    }
    for (InstanceRole ir : irToRemove) {
      instanceRoles.remove(ir);
    }
    return irToRemove;
  }

  /**
   * Switch participants in diagram if they are not in the same order as they are in editor
   * 
   * @param instanceRoles
   *          Instance roles from diagram
   * @param participants
   *          Participant from editor
   * @return true if the order was changed, false if not
   */
  private static boolean reorderParticipants(List<InstanceRole> instanceRoles, EList<Participant> participants) {
    boolean updateNeeded = false;
    for (int i = 0; i < instanceRoles.size(); i++) {
      if (!instanceRoles.get(i).getName().equals(participants.get(i).getName())) {
        for (int j = 0; j < participants.size(); j++) {
          if (instanceRoles.get(i).getName().equals(participants.get(j).getName())) {
            ((EList<InstanceRole>) instanceRoles).move(j, instanceRoles.get(i));
            updateNeeded = true;
          }
        }
      }
    }
    return updateNeeded;
  }

  /**
   * Remove from xtext model all messages containing the participant that has just been deleted
   * 
   * @param messagesOrReferences
   *          All messages and references from textual editor
   * @param participantName
   *          The participant that has just been deleted
   */
  private static void removeEditorMessages(EList<EObject> messagesOrReferences, String participantName) {
    List<EObject> messagesToRemove = new ArrayList<EObject>();
    for (EObject message : messagesOrReferences) {
      if (message instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) {
        String source = ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) message)
            .getSource();
        String target = ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) message)
            .getTarget();
        if (source.equals(participantName) || target.equals(participantName)) {
          messagesToRemove.add(message);
        }
      }
    }
    messagesOrReferences.removeAll(messagesToRemove);
  }

  /**
   * Synchronize graphical ordering in diagram
   */
  private static void syncGraphicalOrdering() {
    DDiagram dDiagram = EmbeddedEditorInstance.getDDiagram();
    ((SequenceDDiagram) dDiagram).getTarget();
    EList<AnnotationEntry> ownedAnnotationEntries = dDiagram.getOwnedAnnotationEntries();
    EObject data = null;
    for (AnnotationEntry annotationEntry : ownedAnnotationEntries) {
      if ((annotationEntry != null) && (annotationEntry.getData() instanceof Diagram)) {
        data = annotationEntry.getData();
      }
    }
    AbstractModelChangeOperation<Boolean> synchronizeGraphicalOrderingOperation = new SynchronizeGraphicalOrderingOperation(
        (Diagram) data, true);
    synchronizeGraphicalOrderingOperation.execute();
  }

  private static void doEditingOnElements(Scenario scenario, EList<EObject> elements) {
    // Make sure your element is attached to a resource, otherwise this will return null
    TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(scenario);
    domain.getCommandStack().execute(new RecordingCommand(domain) {

      @Override
      protected void doExecute() {
        // remove messages and state fragments that appear in diagram and do not appear in text
        cleanUpMessages(scenario, elements);
        cleanUpStateFragments(scenario, elements);
        cleanUpCombinedFragments(scenario, elements);

        editElements(scenario, elements);

        // fix this
        // Reorder scenario, this means reordering the interaction fragments and sequence messages lists
        reorderCapellaScenario(scenario, elements);
        // refresh visual editor
        syncGraphicalOrdering();
      }

      /**
       * Reorders interaction fragments and messages (their start, end and execution end) according to the xtext
       * scenario
       * 
       * @param scenario
       * @param textElements
       */
      private void reorderCapellaScenario(Scenario scenario, EList<EObject> textElements) {
        // compose new lists of sequence messages and interaction fragments, ordered based on xtext messages
        List<SequenceMessage> capellaSequenceMessages = new ArrayList<SequenceMessage>();
        List<InteractionFragment> interactionFragments = new ArrayList<InteractionFragment>();

        List<InteractionFragment> executionEndsToProcess = new ArrayList<InteractionFragment>();
        reorderCapellaFragments(scenario, textElements, capellaSequenceMessages, interactionFragments,
            executionEndsToProcess);

        // Replace sequence message list and interaction fragments list in the real scenario with the newly computed
        // lists
        scenario.getOwnedInteractionFragments().clear();
        scenario.getOwnedInteractionFragments().addAll(interactionFragments);

        scenario.getOwnedMessages().clear();
        scenario.getOwnedMessages().addAll(capellaSequenceMessages);
      }

      private void reorderCapellaFragments(Scenario scenario, EList<EObject> textElements,
          List<SequenceMessage> capellaSequenceMessages, List<InteractionFragment> interactionFragments,
          List<InteractionFragment> executionEndsToProcess) {

        for (Iterator<EObject> iterator = textElements.iterator(); iterator.hasNext();) {
          EObject elementFromXtext = iterator.next();

          if (elementFromXtext instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) {
            reorderCapellaSequenceMessages(scenario,
                (org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) elementFromXtext,
                interactionFragments, capellaSequenceMessages, executionEndsToProcess);
          } else if (elementFromXtext instanceof ParticipantDeactivation) {
            reorderCapellaDeactivationMessages(scenario, (ParticipantDeactivation) elementFromXtext,
                interactionFragments, capellaSequenceMessages, executionEndsToProcess);
          } else if (elementFromXtext instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment) {
            org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment textCombinedFragment = (org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment) elementFromXtext;
            CombinedFragment capellaCombinedFragment = getCorrespondingCapellaCombinedFragment(scenario,
                textCombinedFragment);
            if (capellaCombinedFragment != null) {
              // start the Combined Fragment Block
              interactionFragments.add(capellaCombinedFragment.getStart());

              List<InteractionOperand> orderedCapellaOperands = 
                  getOrderedCapellaInteractionOperands(scenario, textCombinedFragment, capellaCombinedFragment);
              
              // add content in the first operand of the Combined Fragment Block
              interactionFragments.add(orderedCapellaOperands.get(0));
              reorderCapellaFragments(scenario, textCombinedFragment.getBlock().getBlockElements(),
                  capellaSequenceMessages, interactionFragments, executionEndsToProcess);

              // reorder the other operands
              EList<Operand> textOperands = textCombinedFragment.getOperands();
              for (int i = 0; i < textOperands.size(); i++) {
                InteractionOperand operand = orderedCapellaOperands.get(i + 1);
                // add content in the first operand of the Combined Fragment Block
                interactionFragments.add(operand);
                reorderCapellaFragments(scenario, textOperands.get(i).getBlock().getBlockElements(),
                    capellaSequenceMessages, interactionFragments, executionEndsToProcess);
              }

              // finish the Combined Fragment Block
              interactionFragments.add(capellaCombinedFragment.getFinish());
            }
          } else if (elementFromXtext instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment) {

            StateFragment stateFragment = getCorrespondingCapellaStateFragment(scenario, interactionFragments,
                (org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment) elementFromXtext);
            if (stateFragment != null) {
              interactionFragments.add(stateFragment.getStart());
              interactionFragments.add(stateFragment.getFinish());
            }
          }
        }
      }

      private void reorderCapellaDeactivationMessages(Scenario scenario,
          ParticipantDeactivation participantDeactivationMessage, List<InteractionFragment> interactionFragments,
          List<SequenceMessage> capellaSequenceMessages, List<InteractionFragment> executionEndsToProcess) {
        // This is a ParticipantDeactivationMessage, so the execution on the corresponding timeline finished.
        // We must move the interaction fragment representing the execution end on the correct position in the
        // ownedInteractionFragments ordered list

        // find the timeline (instance role) of the execution that has to end. Search by participant name
        InstanceRole instanceRole = EmbeddedEditorInstanceHelper
            .getInstanceRole(participantDeactivationMessage.getName());

        doDeactivationSequenceMessageForReorder(interactionFragments, instanceRole, executionEndsToProcess,
            capellaSequenceMessages);
      }

      private void reorderCapellaSequenceMessages(Scenario scenario, SequenceMessageType elementFromXtext,
          List<InteractionFragment> interactionFragments, List<SequenceMessage> capellaSequenceMessages,
          List<InteractionFragment> executionEndsToProcess) {
        // This is a sequence message, it can be with execution and/or with return
        InstanceRole source = EmbeddedEditorInstanceHelper.getInstanceRole(elementFromXtext.getSource());
        InstanceRole target = EmbeddedEditorInstanceHelper.getInstanceRole(elementFromXtext.getTarget());

        if (source != null && target != null) {
          SequenceMessage capellaSequenceMessage = getCorrespondingCapellaSequenceMessage(scenario,
              elementFromXtext);
          capellaSequenceMessages.add(capellaSequenceMessage);

          // insert message ends in interaction fragments list
          interactionFragments.add(capellaSequenceMessage.getSendingEnd());
          interactionFragments.add(capellaSequenceMessage.getReceivingEnd());

          if (!(capellaSequenceMessage.getKind().equals(MessageKind.CREATE) || 
              capellaSequenceMessage.getKind().equals(MessageKind.DELETE))) {
         
            Execution execution = getExecutionForSequenceMessage(scenario, capellaSequenceMessage);
            
            // For simple messages, execution end will be added here, if no return branch
            if (!hasExecution(elementFromXtext)) {
              if (!hasReturn(elementFromXtext)) {
                interactionFragments.add(execution.getFinish());
              } else {
                // Simple message has return branch, add the return sequence message here
                SequenceMessage capellaReturnSequenceMessage = SequenceMessageExt
                    .getOppositeSequenceMessage(capellaSequenceMessage);
                if (capellaReturnSequenceMessage == null) {
                  capellaReturnSequenceMessage = SequenceMessageExt.findReplySequenceMessage(capellaSequenceMessage);
                }
                interactionFragments.add(capellaReturnSequenceMessage.getSendingEnd());
                interactionFragments.add(capellaReturnSequenceMessage.getReceivingEnd());
                capellaSequenceMessages.add(capellaReturnSequenceMessage);
              }
            } else {
              // For withExecution messages, execution end will be added when deactivate message will be found.
              // At that point, the return message will be moved in order, too, if this is the case
              executionEndsToProcess.add(execution.getFinish());
            }
          }
        }
      }
    });
  }

  private static void editElements(Scenario scenario, EList<EObject> elements) {
    EList<SequenceMessage> sequenceMessages = scenario.getOwnedMessages();
    List<EObject> previousStateFragments = new ArrayList<EObject>();
    for (Iterator<EObject> iterator = elements.iterator(); iterator.hasNext();) {
      EObject xtextElement = iterator.next();

      if (xtextElement instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) {
        // This is a sequence message, it can be with execution and/or with return
        org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType seqMessage = 
            (org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) xtextElement;
        InstanceRole source = EmbeddedEditorInstanceHelper.getInstanceRole(seqMessage.getSource());
        InstanceRole target = EmbeddedEditorInstanceHelper.getInstanceRole(seqMessage.getTarget());

        List<SequenceMessage> msgsFilteredByNameTargetSource = sequenceMessages.stream()
            .filter(x -> x.getName().equals(seqMessage.getName()))
            .filter(x -> x.getSendingEnd().getCoveredInstanceRoles().get(0).getName().equals(source.getName()))
            .filter(x -> x.getReceivingEnd().getCoveredInstanceRoles().get(0).getName().equals(target.getName()))
            .collect(Collectors.toList());

        if (msgsFilteredByNameTargetSource.isEmpty()) {
          if (source != null && target != null) {
            SequenceMessage sequenceMessage = createCapellaSequenceMessage(scenario, source, target, seqMessage);
            sequenceMessages.add(sequenceMessage);
            
            // if message has return branch, create corresponding Capella return message
            if (hasReturn(seqMessage)) {
              SequenceMessage opposingSequenceMessage = createCapellaSequenceMessage(scenario, target, source,
                  seqMessage, true);
              Execution execution = getExecutionForSequenceMessage(scenario, sequenceMessage);
              execution.setFinish(opposingSequenceMessage.getSendingEnd());
              sequenceMessages.add(opposingSequenceMessage);
            }

          }
        }
      } else if (xtextElement instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment) {
        // Check if we need to create CombinedFragment

        CombinedFragment capellaFragment = getCorrespondingCapellaCombinedFragment(scenario,
            (org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment) xtextElement);
        if (capellaFragment == null) {
          InteractionFragment lastInteractionFragment = null;
          
          if (!sequenceMessages.isEmpty()) {
            SequenceMessage lastSequenceMessage = sequenceMessages.get(sequenceMessages.size() - 1);
            lastInteractionFragment = lastSequenceMessage.getReceivingEnd();
          }
          createCapellaCombinedFragmentBlock(scenario,
              (org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment) xtextElement,
              lastInteractionFragment);
        } else {
          // combined fragment found, check its contents
          editElements(scenario,
              ((org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment) xtextElement).getBlock()
                  .getBlockElements());
          for (Operand operand : ((org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment) xtextElement)
              .getOperands()) {
            editElements(scenario, operand.getBlock().getBlockElements());
          }
        }
      } else if (xtextElement instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment) {
        previousStateFragments.add(xtextElement);
        editStateFragment(scenario,
            (org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment) xtextElement,
            previousStateFragments);
      }
    }
  }

  private static boolean hasReturn(SequenceMessageType seqMessage) {
    if (seqMessage instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage)
      return ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) seqMessage).getReturn() != null;
    return false;
  }
  
  protected static boolean hasExecution(SequenceMessageType elementFromXtext) {
    if (elementFromXtext instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) {
      return ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) elementFromXtext).getExecution() != null;
    }
    return false;
  }

  private static void editStateFragment(Scenario scenario,
      org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment xtextElement,
      List<EObject> previousEditorStateFragments) {

    InstanceRole instanceRole = EmbeddedEditorInstanceHelper.getInstanceRole(xtextElement.getTimeline());
    EList<TimeLapse> ownedTimeLapses = scenario.getOwnedTimeLapses();

    List<EObject> simillarStateFragments = previousEditorStateFragments.stream()
        .filter(x -> ((org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment) x).getTimeline()
            .equals(xtextElement.getTimeline())
            && ((org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment) x).getName()
                .equals(xtextElement.getName())
            && ((org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment) x).getKeyword()
                .equals(xtextElement.getKeyword()))
        .collect(Collectors.toList());

    EObject relatedElement = getRelatedElement(scenario, instanceRole, xtextElement);

    if (relatedElement == null)
      return;

    List<TimeLapse> capellaStateFragments = getStateFragmentsWithGivenInstanceRoleAndRelatedElement(scenario,
        instanceRole, xtextElement, relatedElement);

    if (capellaStateFragments.isEmpty() || capellaStateFragments.size() < simillarStateFragments.size()) {
      InteractionState interactionStateStart = createInteractionState(DslConstants.START, relatedElement, instanceRole);
      InteractionState interactionStateEnd = createInteractionState(DslConstants.FINISH, relatedElement, instanceRole);

      scenario.getOwnedInteractionFragments().add(interactionStateStart);
      scenario.getOwnedInteractionFragments().add(interactionStateEnd);

      StateFragment stateFragment = createStateFragment(interactionStateStart, interactionStateEnd, relatedElement,
          xtextElement.getName());

      ownedTimeLapses.add(stateFragment);
    }
  }

  private static List<TimeLapse> getStateFragmentsWithGivenInstanceRoleAndRelatedElement(Scenario scenario,
      InstanceRole instanceRole, org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment xtextElement,
      EObject relatedElement) {

    if (xtextElement.getKeyword().equals(DslConstants.FUNCTION))
      return scenario.getOwnedTimeLapses().stream()
          .filter(
              x -> x instanceof StateFragment && ((StateFragment) x).getRelatedAbstractFunction().equals(relatedElement)
                  && ((StateFragment) x).getStart().getCoveredInstanceRoles().get(0).equals(instanceRole))
          .collect(Collectors.toList());

    return scenario.getOwnedTimeLapses().stream()
        .filter(x -> x instanceof StateFragment && ((StateFragment) x).getRelatedAbstractState().equals(relatedElement)
            && ((StateFragment) x).getStart().getCoveredInstanceRoles().get(0).equals(instanceRole))
        .collect(Collectors.toList());
  }

  private static EObject getRelatedElement(Scenario scenario, InstanceRole instanceRole,
      org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment stateFragment) {

    if (stateFragment.getKeyword().equals(DslConstants.FUNCTION)) {
      return getCorrespondingCapellaAbstractFunction(scenario, instanceRole, stateFragment.getName());
    }
    return getCorrespondingCapellaAbstractState(scenario, instanceRole, stateFragment.getName(),
        stateFragment.getKeyword());
  }

  private static StateFragment createStateFragment(InteractionState interactionStateStart,
      InteractionState interactionStateEnd, EObject relatedElement, String name) {

    StateFragment stateFragment = InteractionFactory.eINSTANCE.createStateFragment();
    stateFragment.setStart(interactionStateStart);
    stateFragment.setFinish(interactionStateEnd);

    if (relatedElement instanceof AbstractFunction) {
      stateFragment.setRelatedAbstractFunction((AbstractFunction) relatedElement);
    } else
      stateFragment.setRelatedAbstractState((AbstractState) relatedElement);

    return stateFragment;
  }

  private static InteractionState createInteractionState(String name, EObject relatedElement, InstanceRole element) {

    InteractionState interactionState = InteractionFactory.eINSTANCE.createInteractionState();
    interactionState.setName(name);
    interactionState.getCoveredInstanceRoles().add(element);

    if (relatedElement instanceof AbstractFunction) {
      interactionState.setRelatedAbstractFunction((AbstractFunction) relatedElement);
    } else {
      interactionState.setRelatedAbstractState((AbstractState) relatedElement);
    }

    return interactionState;
  }

  private static AbstractFunction getCorrespondingCapellaAbstractFunction(Scenario scenario, InstanceRole element,
      String name) {
    List<AbstractFunction> availableFunctions = EmbeddedEditorInstanceHelper.getAllocatedFunctions(element);

    for (AbstractFunction availableFunction : availableFunctions) {
      if (availableFunction.getName().equals(name))
        return availableFunction;
    }
    return null;
  }

  private static AbstractState getCorrespondingCapellaAbstractState(Scenario scenario, InstanceRole element,
      String name, String keyword) {
    List<AbstractState> availableStates = new ArrayList<AbstractState>();

    if (keyword.equals(DslConstants.STATE)) {
      availableStates = EmbeddedEditorInstanceHelper.getStates(element);
    } else {
      availableStates = EmbeddedEditorInstanceHelper.getModes(element);
    }

    for (AbstractState availableState : availableStates) {
      if (availableState.getName().equals(name))
        return availableState;
    }
    return null;
  }

  private static Execution getExecutionForSequenceMessage(Scenario scenario, SequenceMessage sequenceMessage) {
    Execution execution = null;
    MessageEnd receivingEnd = sequenceMessage.getReceivingEnd();
    for (TimeLapse timeLapse : scenario.getOwnedTimeLapses()) {
      if (timeLapse instanceof Execution) {
        Execution exec = (Execution) timeLapse;
        if (exec.getStart() != null && exec.getStart().equals(receivingEnd)) {
          execution = exec;
        }
      }
    }
    return execution;
  }

  private static SequenceMessage getCorrespondingCapellaSequenceMessage(Scenario scenario,
      SequenceMessageType elementFromXtext) {
    EList<SequenceMessage> sequenceMessages = scenario.getOwnedMessages();

    for (SequenceMessage sm : sequenceMessages) {
      if (isSameMessage(elementFromXtext, sm)) {
        return sm;
      }
    }
    return null;
  }

  private static InteractionOperand getCapellaInteractionOperand(Scenario scenario,
      org.polarsys.capella.scenario.editor.dsl.textualScenario.Operand textOperandBlock,
      CombinedFragment capellaCombinedFragment, List<InteractionOperand> processedOperands) {
    List<InteractionOperand> combinedFragmentOperands = AbstractFragmentExt.getOwnedOperands(capellaCombinedFragment,
        scenario);
    combinedFragmentOperands.removeAll(processedOperands);
    for (InteractionOperand operand : combinedFragmentOperands) {
      // go trough each text operand and check that
      if (textOperandBlock.getExpression().equals(HelperCommands.getExpressionText(operand))) {
        processedOperands.add(operand);
        return operand;
      }
    }
    return null;
  }

  private static InteractionOperand getFirstCapellaInteractionOperand(Scenario scenario,
      org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment textCombinedFragment,
      CombinedFragment capellaCombinedFragment) {
    List<InteractionOperand> combinedFragmentOperands = AbstractFragmentExt.getOwnedOperands(capellaCombinedFragment,
        scenario);

    for (InteractionOperand operand : combinedFragmentOperands) {
      // go trough each text operand and check that
      if (textCombinedFragment.getExpression().equals(HelperCommands.getExpressionText(operand))) {
        return operand;
      }
    }
    return null;
  }

  private static List<InteractionOperand> getOrderedCapellaInteractionOperands(Scenario scenario,
      org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment textCombinedFragment,
      CombinedFragment capellaCombinedFragment) {
    List<InteractionOperand> orderedOperands = new ArrayList<InteractionOperand>(
        1 + textCombinedFragment.getOperands().size());

    orderedOperands.add(getFirstCapellaInteractionOperand(scenario, textCombinedFragment, capellaCombinedFragment));

    List<InteractionOperand> processedOperands = new ArrayList<InteractionOperand>();
    processedOperands.add(orderedOperands.get(0));
    
    for (Operand textOperandBlock : textCombinedFragment.getOperands()) {
      orderedOperands.add(getCapellaInteractionOperand(scenario, textOperandBlock, capellaCombinedFragment, processedOperands));
    }

    return orderedOperands;
  }

  private static StateFragment getCorrespondingCapellaStateFragment(Scenario scenario,
      List<InteractionFragment> interactionFragments,
      org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment stateFragment) {

    InstanceRole instanceRole = EmbeddedEditorInstanceHelper.getInstanceRole(stateFragment.getTimeline());

    List<TimeLapse> filteredTimeLapses = new ArrayList<TimeLapse>();
    if (stateFragment.getKeyword().equals(DslConstants.FUNCTION)) {
      filteredTimeLapses = scenario.getOwnedTimeLapses().stream()
          .filter(x -> x instanceof StateFragment
              && ((StateFragment) x).getRelatedAbstractFunction().getName().equals(stateFragment.getName())
              && x.getStart().getCoveredInstanceRoles().get(0).equals(instanceRole)
              && !interactionFragments.contains(((StateFragment) x).getStart()))
          .collect(Collectors.toList());
    } else {
      filteredTimeLapses = scenario.getOwnedTimeLapses().stream()
          .filter(x -> x instanceof StateFragment
              && ((StateFragment) x).getRelatedAbstractState().getName().equals(stateFragment.getName())
              && x.getStart().getCoveredInstanceRoles().get(0).equals(instanceRole)
              && !interactionFragments.contains(((StateFragment) x).getStart()))
          .collect(Collectors.toList());
    }

    if (!filteredTimeLapses.isEmpty()) {
      return (StateFragment) filteredTimeLapses.get(0);
    }
    return null;
  }

  private static CombinedFragment getCorrespondingCapellaCombinedFragment(Scenario scenario,
      org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment textCombinedFragment) {
    EList<InteractionFragment> fragments = scenario.getOwnedInteractionFragments();

    for (Iterator<InteractionFragment> iterator = fragments.iterator(); iterator.hasNext();) {
      InteractionFragment element = iterator.next();
      if (element instanceof FragmentEnd) {
        CombinedFragment candidateCombinedFragment = (CombinedFragment) ((FragmentEnd) element).getAbstractFragment();
        if (candidateCombinedFragment.getOperator().toString().toLowerCase()
            .equals(textCombinedFragment.getKeyword())) {          
          //check timelines
          if (haveSameTimelines(textCombinedFragment, candidateCombinedFragment)) {
            List<InteractionOperand> capellaOperands = candidateCombinedFragment.getReferencedOperands();
            if (capellaOperands.size() == textCombinedFragment.getOperands().size() + 1) {
              if (operandsHaveSameExpressions(textCombinedFragment, capellaOperands)) {
                return candidateCombinedFragment;
              }
            }  
          }
        }
      }
    }
    return null;
  }

  private static boolean haveSameTimelines(
      org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment textCombinedFragment,
      CombinedFragment candidateCombinedFragment) {
    
    EList<String> xtextTimelines = textCombinedFragment.getTimelines();    
    List<String> capellaTimelines = candidateCombinedFragment.getStart().getCoveredInstanceRoles().stream()
        .map(role -> role.getName()).collect(Collectors.toList());
    
    xtextTimelines.sort(Comparator.naturalOrder());
    capellaTimelines.sort(Comparator.naturalOrder());
    return xtextTimelines.equals(capellaTimelines);
  }

  private static boolean operandsHaveSameExpressions(
      org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment textCombinedFragment,
      List<InteractionOperand> capellaOperands) {
    
    //check expression on first operand
    InteractionOperand capellaOperand = capellaOperands.get(0);
    Operand xtextOperand;
    boolean operandsHaveSameExpressions = true;
    if (!HelperCommands.getExpressionText(capellaOperand).equals(textCombinedFragment.getExpression())) {
      operandsHaveSameExpressions = false;
    }
    
    //check expression on the rest of the operands           
    int i = 1;
    while (i < capellaOperands.size() && operandsHaveSameExpressions) {
      capellaOperand = capellaOperands.get(i);
      xtextOperand = textCombinedFragment.getOperands().get(i - 1);
      if (!HelperCommands.getExpressionText(capellaOperand).equals(xtextOperand.getExpression())) {
        operandsHaveSameExpressions = false;
      }
      i++;
    }
    return operandsHaveSameExpressions;
  }

  private static void cleanUpMessages(Scenario scenario, EList<EObject> messages) {
    // Delete all diagram messages that don't appear in the xtext scenario

    EList<SequenceMessage> sequenceMessages = scenario.getOwnedMessages();
    List<EObject> allXtextSequenceMessages = getAllXtextSequenceMessages(messages);
    List<SequenceMessage> messagesToBeDeleted = sequenceMessages.stream()
        .filter(capellaSequenceMessage -> capellaSequenceMessage.getKind() != MessageKind.REPLY
            && !foundCapellaMessageInXText(capellaSequenceMessage, allXtextSequenceMessages))
        .collect(Collectors.toList());

    for (SequenceMessage sequenceMessage : messagesToBeDeleted) {
      // Remove message from Capella scenario, together with execution, interaction fragments and events related to this
      // message
      removeMessageFromScenario(scenario, sequenceMessage);
    }
  }
  
  private static void cleanUpStateFragments(Scenario scenario, EList<EObject> xTextElements) {
    // Delete all diagram state fragments that don't appear in the xtext scenario
    List<EObject> allXtextStateFragments =  xTextElements.stream()
        .filter(element -> element instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment)
        .collect(Collectors.toList());

    List<TimeLapse> stateFragmentsToBeDeleted = getCapellaStateFragmentsToBeDeleted(scenario, allXtextStateFragments);
    
    for (TimeLapse timeLapse : stateFragmentsToBeDeleted) {
      removeStateFragmentFromScenario(scenario, timeLapse);
    }
  }

  private static void cleanUpCombinedFragments(Scenario scenario, EList<EObject> xTextElements) {
    // Delete all diagram combined fragments that don't appear in the xtext scenario
    List<EObject> allXtextCombinedFragments =  xTextElements.stream()
        .filter(element -> element instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment)
        .collect(Collectors.toList());

    List<TimeLapse> combinedFragmentsToBeDeleted = getCapellaCombinedFragmentsToBeDeleted(scenario, allXtextCombinedFragments);
    
    for (TimeLapse timeLapse : combinedFragmentsToBeDeleted) {
      removeCombinedFragmentFromScenario(scenario, timeLapse);
    }
  }

  private static List<TimeLapse> getCapellaCombinedFragmentsToBeDeleted(Scenario scenario,
      List<EObject> allXtextCombinedFragments) {
    // We mark for deletion all combined fragments in scenario that don't have corresponding xtext fragments
    List<TimeLapse> capellaCombinedFragments = scenario.getOwnedTimeLapses().stream()
        .filter(timelapse -> timelapse instanceof CombinedFragment).collect(Collectors.toList());
    
    List<org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment> processedXtextCombinedFragments = 
        new ArrayList<org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment>();
    List<TimeLapse> combinedFragmentsToBeDeleted = new ArrayList<TimeLapse>();
    
    for (TimeLapse timeLapse : capellaCombinedFragments) {
      if (!foundCapellaCombinedFragmentInXText(timeLapse, allXtextCombinedFragments, processedXtextCombinedFragments)) {
        combinedFragmentsToBeDeleted.add(timeLapse);
      }
    }
    
    return combinedFragmentsToBeDeleted;
  }

  private static boolean foundCapellaCombinedFragmentInXText(TimeLapse timeLapse,
      List<EObject> allXtextCombinedFragments,
      List<org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment> processedXtextCombinedFragments) {
    for (EObject xtextCombinedFragment : allXtextCombinedFragments) {
      if (!processedXtextCombinedFragments.contains(xtextCombinedFragment) 
          && isSameCombinedFragment(xtextCombinedFragment, timeLapse)) {
        processedXtextCombinedFragments.add((org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment) xtextCombinedFragment);
        return true;
      }
    }
    return false;
  }

  private static boolean isSameCombinedFragment(EObject fragment, TimeLapse timeLapse) {
    if (!(fragment instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment)) {
      return false;
    }
    org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment xtextCombinedFragment = 
        (org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment) fragment;   
    CombinedFragment correspondingCapellaFragment = getCorrespondingCapellaCombinedFragment((Scenario) timeLapse.eContainer(), xtextCombinedFragment);
    
    if (timeLapse.equals(correspondingCapellaFragment)) {
      return true;
    }
    return false;
  }

  private static List<TimeLapse> getCapellaStateFragmentsToBeDeleted(Scenario scenario,
      List<EObject> allXtextStateFragments) {
    // We mark for deletion all state fragments in scenario that don't have corresponding xtext fragments
    List<TimeLapse> capellaStateFragments = scenario.getOwnedTimeLapses().stream()
        .filter(timelapse -> timelapse instanceof StateFragment).collect(Collectors.toList());
    
    List<org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment> processedXtextStateFragments = 
        new ArrayList<org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment>();
    List<TimeLapse> stateFragmentsToBeDeleted = new ArrayList<TimeLapse>();
    
    for (TimeLapse timeLapse : capellaStateFragments) {
      if (!foundCapellaStateFragmentInXText(timeLapse, allXtextStateFragments, processedXtextStateFragments)) {
        stateFragmentsToBeDeleted.add(timeLapse);
      }
    }
    
    return stateFragmentsToBeDeleted;
  }

  private static void removeMessageFromScenario(Scenario scenario, SequenceMessage sequenceMessage) {
    // Remove execution - time lapse
    // Execution execution = getExecutionForSequenceMessage(scenario, sequenceMessage);
    Execution execution = null;
    MessageEnd re = sequenceMessage.getReceivingEnd();
    for (TimeLapse tl : scenario.getOwnedTimeLapses()) {
      if (tl instanceof Execution) {
        Execution exec = (Execution) tl;
        if (exec.getStart() != null && exec.getStart().equals(re)) {
          execution = exec;
        }
      }
    }
    scenario.getOwnedTimeLapses().remove(execution);

    // Remove interaction fragments for sending end, receiving end and execution end
    MessageEnd sendingEnd = sequenceMessage.getSendingEnd();
    MessageEnd receivingEnd = sequenceMessage.getReceivingEnd();
    InteractionFragment executionEnd = execution != null ? execution.getFinish() : null;
    scenario.getOwnedInteractionFragments().remove(sendingEnd);
    scenario.getOwnedInteractionFragments().remove(receivingEnd);
    scenario.getOwnedInteractionFragments().remove(executionEnd);

    // Remove events
    Event eventSendOp = sendingEnd.getEvent();
    Event eventReveivOp = receivingEnd.getEvent();
    scenario.getOwnedEvents().remove(eventSendOp);
    scenario.getOwnedEvents().remove(eventReveivOp);

    if (sequenceMessage.getKind() != MessageKind.REPLY && !ScenarioExt.hasReply(sequenceMessage)) {
      // Remove execution event for normal sequence message
      Event executionEvent = executionEnd instanceof ExecutionEnd
          ? (Event) ExecutionEndExt.getOperation((ExecutionEnd) executionEnd)
          : null;
      scenario.getOwnedEvents().remove(executionEvent);
    }

    // Remove sequence message
    scenario.getOwnedMessages().remove(sequenceMessage);
  }
  
  private static void removeStateFragmentFromScenario(Scenario scenario, TimeLapse timeLapse) {    
    StateFragment stateFragment = (StateFragment) timeLapse;
    
    // Remove state fragment
    scenario.getOwnedTimeLapses().remove(timeLapse);
    
    // Remove interaction fragments
    scenario.getOwnedInteractionFragments().removeAll(Arrays.asList(stateFragment.getStart(), stateFragment.getFinish()));
  }

  
  private static void removeCombinedFragmentFromScenario(Scenario scenario, TimeLapse timeLapse) {
    CombinedFragment combinedFragment = (CombinedFragment) timeLapse;
    
    // Remove combined fragment
    scenario.getOwnedTimeLapses().remove(timeLapse);
    
    // Remove interaction fragments (start, finish, operands)
    scenario.getOwnedInteractionFragments().removeAll(Arrays.asList(combinedFragment.getStart(), combinedFragment.getFinish(), 
        combinedFragment.getReferencedOperands()));
  }

  private static boolean foundCapellaMessageInXText(SequenceMessage capellaSequenceMessage,
      List<EObject> allXtextSequenceMessages) {
    for (EObject message : allXtextSequenceMessages) {
      if (isSameMessage(message, capellaSequenceMessage)) {
        return true;
      }
    }
    return false;
  }

  
  private static boolean foundCapellaStateFragmentInXText(TimeLapse timelapse,
      List<EObject> allXtextStateFragments, List<org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment> processedXtextStateFragments) {
    for (EObject stateFragment : allXtextStateFragments) {
      if (!processedXtextStateFragments.contains(stateFragment) 
          && isSameStateFragment(stateFragment, timelapse)) {
        processedXtextStateFragments.add((org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment) stateFragment);
        return true;
      }
    }
    return false;
  }

  private static List<EObject> getAllXtextSequenceMessages(EList<EObject> textMessages) {
    ArrayList<EObject> xtextSequenceMessages = new ArrayList<EObject>();
    for (EObject element : textMessages) {
      // SequenceMessage -> add it
      if (element instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) {
        xtextSequenceMessages.add(element);
      }
      // CombinedFragment -> go inside and find all sequence messages at all levels
      if (element instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment) {
        org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment combinedFragmentElement = (org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment) element;

        // get sequence messages from the first operand (first block, actually)
        xtextSequenceMessages
            .addAll(getAllXtextSequenceMessages(combinedFragmentElement.getBlock().getBlockElements()));

        // get sequence messages from the rest of the operands
        for (EObject operand : combinedFragmentElement.getOperands()) {
          xtextSequenceMessages.addAll(getAllXtextSequenceMessages(((Operand) operand).getBlock().getBlockElements()));
        }
      }
    }

    return xtextSequenceMessages;
  }

  private static boolean isSameMessage(EObject m, SequenceMessage seqMessage) {
    if (!(m instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType)) {
      return false;
    }
    org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType message = 
        (org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType) m;
    if (!seqMessage.getSendingEnd().getCoveredInstanceRoles().isEmpty()
        && message.getSource().equals(seqMessage.getSendingEnd().getCoveredInstanceRoles().get(0).getName())
        && !seqMessage.getReceivingEnd().getCoveredInstanceRoles().isEmpty()
        && message.getTarget().equals(seqMessage.getReceivingEnd().getCoveredInstanceRoles().get(0).getName())
        && message.getName().equals(seqMessage.getName())) {
      return true;
    }
    return false;
  }

  private static boolean isSameStateFragment(EObject fragment, TimeLapse timelapse) {
    if (!(fragment instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment)) {
      return false;
    }
    org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment stateFragment = 
        (org.polarsys.capella.scenario.editor.dsl.textualScenario.StateFragment) fragment;
    StateFragment capellaStateFragment = (StateFragment) timelapse;
       
    if (stateFragment.getTimeline().equals(capellaStateFragment.getStart().getCoveredInstanceRoles().get(0).getName())
        && stateFragment.getKeyword().equals(EmbeddedEditorInstanceHelper.getStateFragmentType(capellaStateFragment))
        && stateFragment.getName().equals(EmbeddedEditorInstanceHelper.getStateFragmentName(capellaStateFragment))) {
      return true;
    }
    return false;
  }

  private static SequenceMessage createCapellaSequenceMessage(Scenario scenario, InstanceRole target,
      InstanceRole source, org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType seqMessage) {
    return createCapellaSequenceMessage(scenario, target, source, seqMessage, false);
  }

  /*
   * Create a capella sequence message (and set all data needed by a capella sequence message : sending end, receiving
   * end, execution etc
   */
  private static SequenceMessage createCapellaSequenceMessage(Scenario scenario, InstanceRole source,
      InstanceRole target, org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessageType seqMessage,
      boolean isReplyMessage) {
    // create Capella SequenceMessage
    SequenceMessage sequenceMessage = InteractionFactory.eINSTANCE.createSequenceMessage();
    sequenceMessage.setName(seqMessage.getName());
    sequenceMessage.setKind(getSequenceMessageKind(seqMessage, isReplyMessage));

    // sending end
    MessageEnd sendingEnd = InteractionFactory.eINSTANCE.createMessageEnd();
    sendingEnd.getCoveredInstanceRoles().add(source);
    sequenceMessage.setSendingEnd(sendingEnd);
    scenario.getOwnedInteractionFragments().add(sendingEnd);

    // receiving end
    MessageEnd receivingEnd = InteractionFactory.eINSTANCE.createMessageEnd();
    receivingEnd.getCoveredInstanceRoles().add(target);
    sequenceMessage.setReceivingEnd(receivingEnd);
    scenario.getOwnedInteractionFragments().add(receivingEnd);

    // execution end - CREATE and DELETE messages don't have an execution
    if (!isReplyMessage && seqMessage instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) {
      ExecutionEnd executionEnd = InteractionFactory.eINSTANCE.createExecutionEnd();
      if (((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) seqMessage).getReturn() == null) {
        // do not add this execution end to the interaction fragments list, as we will add the sending end of the reply
        // message
        scenario.getOwnedInteractionFragments().add(executionEnd);
      }
      executionEnd.getCoveredInstanceRoles().add(receivingEnd.getCoveredInstanceRoles().get(0));

      // execution
      Execution execution = InteractionFactory.eINSTANCE.createExecution();
      execution.setFinish(executionEnd);
      execution.setStart(receivingEnd);
      scenario.getOwnedTimeLapses().add(execution);

      // execution event
      ExecutionEvent executionEvent = InteractionFactory.eINSTANCE.createExecutionEvent();
      executionEnd.setEvent(executionEvent);
      scenario.getOwnedEvents().add(executionEvent);
    }

    // EventSentOperation
    EventSentOperation eventSentOperation = InteractionFactory.eINSTANCE.createEventSentOperation();
    scenario.getOwnedEvents().add(eventSentOperation);
    sendingEnd.setEvent(eventSentOperation);

    // EventReceiptOperation
    EventReceiptOperation eventRecvOperation = InteractionFactory.eINSTANCE.createEventReceiptOperation();
    scenario.getOwnedEvents().add(eventRecvOperation);
    receivingEnd.setEvent(eventRecvOperation);

    // get operation by name from the list of available exchanges
    List<AbstractEventOperation> exchanges = null;
    if (isReplyMessage) {
      exchanges = EmbeddedEditorInstanceHelper.getExchangeMessages(target.getName(), source.getName());
    } else {
      exchanges = EmbeddedEditorInstanceHelper.getExchangeMessages(source.getName(), target.getName());
    }
    
    if (EmbeddedEditorInstanceHelper.isInterfaceScenario()) {
      exchanges = exchanges.stream()
          .filter(ex -> ((ExchangeItemAllocation) ex).getAllocatedItem().getName().equals(seqMessage.getName()))
          .collect(Collectors.toList());
    } else {
      exchanges = exchanges.stream().filter(ex -> ex.getName().equals(seqMessage.getName()))
          .collect(Collectors.toList());
    }
    if (!exchanges.isEmpty()) {
      eventRecvOperation.setOperation((AbstractEventOperation) exchanges.get(0));
      eventSentOperation.setOperation((AbstractEventOperation) exchanges.get(0));
    }

    return sequenceMessage;
  }

  private static MessageKind getSequenceMessageKind(SequenceMessageType seqMessage, boolean isReplyMessage) {
    if (seqMessage instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) {
      return isReplyMessage ? MessageKind.REPLY
          : ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) seqMessage).getReturn() != null ? 
              MessageKind.SYNCHRONOUS_CALL : MessageKind.ASYNCHRONOUS_CALL; 
    }
    if (seqMessage instanceof CreateMessage) {
      return MessageKind.CREATE;
    } 
    if (seqMessage instanceof DeleteMessage) {
      return MessageKind.DELETE;
    }
    return MessageKind.UNSET;
  }

  private static void doDeactivationSequenceMessageForReorder(List<InteractionFragment> fragments,
      InstanceRole instanceRole, List<InteractionFragment> executionEndsToProcess,
      List<SequenceMessage> sequenceMessages) {
    InteractionFragment executionEnd = getLatestExecutionEndOnTimeline(instanceRole, executionEndsToProcess);

    SequenceMessage sequenceMessage = null;
    SequenceMessage oppositeSequenceMessage = null;
    if (executionEnd != null) {
      if (executionEnd instanceof ExecutionEnd) {
        sequenceMessage = ExecutionEndExt.getMessage((ExecutionEnd) executionEnd);
      } else {
        sequenceMessage = ((MessageEnd) executionEnd).getMessage();
        oppositeSequenceMessage = getOppositeSequenceMessage(sequenceMessage, fragments);
      }

      if (oppositeSequenceMessage != null) {
        // This message has return branch, so instead of execution end we must add the sending and receiving end of its
        // reply message
        fragments.add(sequenceMessage.getSendingEnd());
        fragments.add(sequenceMessage.getReceivingEnd());
        sequenceMessages.add(sequenceMessage);
      } else if (executionEnd != null) {
        fragments.add(executionEnd);
      }
    }

    // remove executionEnd from the processing list
    executionEndsToProcess.remove(executionEnd);
  }

  private static InteractionFragment getLatestExecutionEndOnTimeline(InstanceRole instanceRole,
      List<InteractionFragment> executionEndsToProcess) {
    InteractionFragment executionEnd = executionEndsToProcess.stream()
        .filter(e -> e.getCoveredInstanceRoles().get(0).getName().equals(instanceRole.getName()))
        .reduce((first, second) -> second).orElse(null);
    return executionEnd;
  }

  /*
   * Display in diagram, the elements of an alt sequence
   */
  private static void createCapellaCombinedFragmentBlock(Scenario scenario,
      org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment xtextCombinedFragment,
      InteractionFragment lastInteractionFragment) {

    // generate CombinedFragment, FramentEnd, FragmentEnd, IntreationOperands from xtext combined fragment
    FragmentEnd start = InteractionFactory.eINSTANCE.createFragmentEnd();
    FragmentEnd finish = InteractionFactory.eINSTANCE.createFragmentEnd();

    xtextCombinedFragment.getTimelines().forEach(timeline -> {
      InstanceRole instanceRole = EmbeddedEditorInstanceHelper.getInstanceRole(timeline);
      start.getCoveredInstanceRoles().add(instanceRole);
      finish.getCoveredInstanceRoles().add(instanceRole);
    });

    start.setName("start");
    finish.setName("end");

    scenario.getOwnedInteractionFragments().add(start);
    scenario.getOwnedInteractionFragments().add(finish);

    if (lastInteractionFragment != null)
      ScenarioExt.moveEndOnScenario(start, lastInteractionFragment);
    else
      ScenarioExt.moveEndOnBeginingOfScenario(start);

    CombinedFragment combinedFragment = addCombinedFragment(start, finish, InteractionOperatorKind.getByName(xtextCombinedFragment.getKeyword().toUpperCase()));
    scenario.getOwnedTimeLapses().add(combinedFragment);

    Block firstBlock = xtextCombinedFragment.getBlock();
    if (firstBlock != null) {
      InteractionOperand operand = addInteractionOperand(start.getCoveredInstanceRoles(), xtextCombinedFragment.getExpression());
      combinedFragment.getReferencedOperands().add(operand);
      scenario.getOwnedInteractionFragments().add(operand);
      ScenarioExt.moveEndOnScenario(operand, start);

      editElements(scenario, firstBlock.getBlockElements());

      InteractionOperand prevEnd = operand;
      for (Operand operandBlock : xtextCombinedFragment.getOperands()) {
        InteractionOperand operand2 = addInteractionOperand(start.getCoveredInstanceRoles(),
            operandBlock.getExpression());
        combinedFragment.getReferencedOperands().add(operand2);
        scenario.getOwnedInteractionFragments().add(operand2);
        ScenarioExt.moveEndOnScenario(operand2, prevEnd);
        prevEnd = operand2;

        editElements(scenario, operandBlock.getBlock().getBlockElements());
      }
    }
  }

  private static InteractionOperand addInteractionOperand(EList<InstanceRole> coveredInstanceRoles, String condition) {
    InteractionOperand operand = InteractionFactory.eINSTANCE.createInteractionOperand();
    operand.setName("operand");
    operand.getCoveredInstanceRoles().addAll(coveredInstanceRoles);

    Constraint constraint = CapellacoreFactory.eINSTANCE.createConstraint();
    OpaqueExpression expression = DatavalueFactory.eINSTANCE.createOpaqueExpression();

    constraint.setOwnedSpecification(expression);
    operand.getOwnedConstraints().add(constraint);
    CreationHelper.performContributionCommands(constraint, operand);

    expression.getLanguages().add(ConstraintExt.OPAQUE_EXPRESSION_LINKED_TEXT);
    expression.getBodies().add(condition);

    operand.setGuard(constraint);
    return operand;
  }

  private static CombinedFragment addCombinedFragment(InteractionFragment start, InteractionFragment finish,
      InteractionOperatorKind kind) {
    CombinedFragment combinedFragment = InteractionFactory.eINSTANCE.createCombinedFragment();
    combinedFragment.setOperator(kind);
    combinedFragment.setStart(start);
    combinedFragment.setFinish(finish);
    combinedFragment.setName("combined fragment");

    return combinedFragment;
  }

  /**
   * Returns the 'calling' or 'reply' branch related to the given sequence message.
   * 
   * @param sequenceMessage
   * @return
   */
  public static SequenceMessage getOppositeSequenceMessage(SequenceMessage sequenceMessage,
      List<InteractionFragment> fragments) {

    boolean flag = false;
    List<SequenceMessage> setPortionMessage = new ArrayList<>();
    Stack<SequenceMessage> stack = new Stack<>();

    if (sequenceMessage != null) {
      /** On messages of type 'destroy' there is no processing */
      if (!sequenceMessage.getKind().equals(MessageKind.CREATE) && !sequenceMessage.getKind().equals(MessageKind.DELETE)
          && !sequenceMessage.getKind().equals(MessageKind.ASYNCHRONOUS_CALL)) {
        List<MessageEnd> ownedMsgEnd = new ArrayList<>();

        for (InteractionFragment abs : fragments) {
          if (abs instanceof MessageEnd) {
            ownedMsgEnd.add((MessageEnd) abs);
          }
        }

        if (ownedMsgEnd != null) {
          if (sequenceMessage.getKind().equals(MessageKind.REPLY)) {
            /** If this is a REPLY message => the CALLING branch is present in the upper portion of the messages */
            flag = false;
            for (Iterator<MessageEnd> it = ownedMsgEnd.iterator(); it.hasNext() && !flag;) {
              MessageEnd msgEnd = it.next();
              if (msgEnd != null) {
                SequenceMessage msg = msgEnd.getMessage();
                if (msg != null) {
                  if (!msg.equals(sequenceMessage)) {
                    setPortionMessage.add(msg);
                  } else
                    flag = true;
                }
              }
            }
            /** Invert sequence messages order */
            setPortionMessage = SequenceMessageExt.reverse(setPortionMessage);
          } else {
            /** If this is a CALLING message => The REPLY branch is present in the upper portion of the messages */
            flag = false;
            for (Iterator<MessageEnd> it = ownedMsgEnd.iterator(); it.hasNext();) {
              MessageEnd msgEnd = it.next();
              if (msgEnd != null) {
                SequenceMessage msg = msgEnd.getMessage();
                if (msg != null) {
                  if (flag) {
                    setPortionMessage.add(msg);
                  } else if (msg.equals(sequenceMessage)) {
                    flag = true;
                  }
                }
              }
            }
          }

          for (SequenceMessage msg : setPortionMessage) {
            if (!msg.getKind().equals(MessageKind.CREATE) && !msg.getKind().equals(MessageKind.DELETE)
                && !msg.getKind().equals(MessageKind.ASYNCHRONOUS_CALL)) {
              if (sequenceMessage.getKind().equals(MessageKind.REPLY)) {
                /**
                 * Treatment: research branch 'toGo' If current message type return: Pushes current message else if
                 * stack empty: branch the found 'toGo' else pops the last message and return.
                 */
                if (msg.getKind().equals(MessageKind.REPLY)) {
                  stack.push(msg);
                } else {
                  if (stack.isEmpty()) {
                    return msg;
                  }
                  stack.pop();
                }
              } else {
                /**
                 * Treatment: research branch 'toGo' If current message type is return and empty stack: Branch return
                 * found.  * If current message type is return and non-empty stack: Pops last message 'toGo' else the
                 * current message is stacked
                 */
                if (msg.getKind().equals(MessageKind.REPLY)) {
                  if (stack.isEmpty()) {
                    return msg;
                  }
                  stack.pop();
                } else {
                  stack.push(msg);
                }
              }
            }
          }
        }
      }
    }

    return null;
  }

}
