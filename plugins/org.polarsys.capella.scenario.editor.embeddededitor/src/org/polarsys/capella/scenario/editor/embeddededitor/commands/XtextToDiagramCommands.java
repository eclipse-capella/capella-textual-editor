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
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.sequence.SequenceDDiagram;
import org.eclipse.sirius.diagram.sequence.business.internal.operation.SynchronizeGraphicalOrderingOperation;
import org.eclipse.sirius.diagram.ui.business.internal.operation.AbstractModelChangeOperation;
import org.eclipse.sirius.viewpoint.description.AnnotationEntry;
import org.eclipse.xtext.resource.XtextResource;
import org.polarsys.capella.common.menu.dynamic.CreationHelper;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.CapellacoreFactory;
import org.polarsys.capella.core.data.capellacore.Constraint;
import org.polarsys.capella.core.data.cs.ExchangeItemAllocation;
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
import org.polarsys.capella.core.data.interaction.MessageEnd;
import org.polarsys.capella.core.data.interaction.MessageKind;
import org.polarsys.capella.core.data.interaction.Scenario;
import org.polarsys.capella.core.data.interaction.SequenceMessage;
import org.polarsys.capella.core.data.interaction.TimeLapse;
import org.polarsys.capella.core.data.interaction.properties.dialogs.sequenceMessage.model.SelectInvokedOperationModelForSharedDataAndEvent;
import org.polarsys.capella.core.model.helpers.AbstractFragmentExt;
import org.polarsys.capella.core.model.helpers.ConstraintExt;
import org.polarsys.capella.core.model.helpers.ScenarioExt;
import org.polarsys.capella.scenario.editor.EmbeddedEditorInstance;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Block;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Operand;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Model;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.Participant;
import org.polarsys.capella.scenario.editor.dsl.textualScenario.ParticipantDeactivation;
import org.polarsys.capella.scenario.editor.dsl.ui.provider.TextualScenarioProvider;
import org.polarsys.capella.scenario.editor.embeddededitor.helper.XtextEditorHelper;
import org.polarsys.capella.scenario.editor.embeddededitor.views.EmbeddedEditorView;
import org.polarsys.capella.scenario.editor.helper.EmbeddedEditorInstanceHelper;

public class XtextToDiagramCommands {
  public static void process(Scenario scenario, EmbeddedEditorView embeddedEditorViewPart) {
    if (embeddedEditorViewPart != null) {
      TextualScenarioProvider p = embeddedEditorViewPart.getProvider();
      XtextResource resource = p.getResource();
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
      if (message instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) {
        String source = ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) message)
            .getSource();
        String target = ((org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) message)
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
        // remove messages that appear in diagram and do not appear in text
        cleanUpMessages(scenario, elements);

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

          if (elementFromXtext instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) {
            reorderCapellaSequenceMessages(scenario,
                (org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) elementFromXtext,
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

              List<InteractionOperand> orderedCapellaOperands = getOrderedCapellaInteractionOperands(scenario,
                  textCombinedFragment, capellaCombinedFragment);

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

      private void reorderCapellaSequenceMessages(Scenario scenario,
          org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage textSequenceMessage,
          List<InteractionFragment> interactionFragments, List<SequenceMessage> capellaSequenceMessages,
          List<InteractionFragment> executionEndsToProcess) {
        // This is a sequence message, it can be with execution and/or with return
        InstanceRole source = EmbeddedEditorInstanceHelper.getInstanceRole(textSequenceMessage.getSource());
        InstanceRole target = EmbeddedEditorInstanceHelper.getInstanceRole(textSequenceMessage.getTarget());

        if (source != null && target != null) {
          SequenceMessage capellaSequenceMessage = getCorrespondingCapellaSequenceMessage(scenario,
              textSequenceMessage);

          // insert message ends in interaction fragments list
          interactionFragments.add(capellaSequenceMessage.getSendingEnd());
          interactionFragments.add(capellaSequenceMessage.getReceivingEnd());

          Execution execution = getExecutionForSequenceMessage(scenario, capellaSequenceMessage);
          capellaSequenceMessages.add(capellaSequenceMessage);

          // For simple messages, execution end will be added here, if no return branch
          if (textSequenceMessage.getExecution() == null) {
            if (textSequenceMessage.getReturn() == null) {
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
    });
  }

  private static void editElements(Scenario scenario, EList<EObject> elements) {
    EList<SequenceMessage> sequenceMessages = scenario.getOwnedMessages();
    for (Iterator<EObject> iterator = elements.iterator(); iterator.hasNext();) {
      EObject xtextElement = iterator.next();

      if (xtextElement instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) {
        // This is a sequence message, it can be with execution and/or with return
        org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage seqMessage = (org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) xtextElement;
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
            if (seqMessage.getReturn() != null) {
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
            (org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment)xtextElement);
        if (capellaFragment == null) {      
          InteractionFragment lastInteractionFragment = null;
          if (!sequenceMessages.isEmpty()) {
            SequenceMessage lastSequenceMessage = sequenceMessages.get(sequenceMessages.size() - 1);
            lastInteractionFragment = lastSequenceMessage.getReceivingEnd();
          }
          createCapellaCombinedFragmentBlock(scenario,
              (org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment) xtextElement,
              lastInteractionFragment);
        }
      }
    }
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
      org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage seqMessage) {
    EList<SequenceMessage> sequenceMessages = scenario.getOwnedMessages();

    for (SequenceMessage sm : sequenceMessages) {
      if (isSameMessage(seqMessage, sm)) {
        return sm;
      }
    }
    return null;
  }

  private static InteractionOperand getCapellaInteractionOperand(Scenario scenario,
      org.polarsys.capella.scenario.editor.dsl.textualScenario.Operand textOperandBlock,
      CombinedFragment capellaCombinedFragment) {
    List<InteractionOperand> combinedFragmentOperands = AbstractFragmentExt.getOwnedOperands(capellaCombinedFragment,
        scenario);

    for (InteractionOperand operand : combinedFragmentOperands) {
      // go trough each text operand and check that
      if (textOperandBlock.getExpression().equals(HelperCommands.getExpressionText(operand))) {
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

    for (Operand textOperandBlock : textCombinedFragment.getOperands()) {
      orderedOperands.add(getCapellaInteractionOperand(scenario, textOperandBlock, capellaCombinedFragment));
    }

    return orderedOperands;
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
          List<InteractionOperand> ownedOperands = candidateCombinedFragment.getReferencedOperands();
          if (ownedOperands.size() == textCombinedFragment.getOperands().size() + 1) {
            // todo check each thing
            return candidateCombinedFragment;
          }
        }
      }
    }
    return null;
  }

  private static void cleanUpMessages(Scenario scenario, EList<EObject> messages) {
    // Delete all diagram messages that don't appear in the xtext scenario

    EList<SequenceMessage> sequenceMessages = scenario.getOwnedMessages();
    List<EObject> allXtextSequenceMessages = getAllXtextSequenceMessages(messages);
    List<SequenceMessage> messagesToBeDeleted = sequenceMessages.stream()
        .filter(capellaSequenceMessage -> capellaSequenceMessage.getKind() != MessageKind.REPLY && !foundCapellaMessageInXText(capellaSequenceMessage, allXtextSequenceMessages))
        .collect(Collectors.toList());

    for (SequenceMessage sequenceMessage : messagesToBeDeleted) {
      // Remove message from Capella scenario, together with execution, interaction fragments and events related to this
      // message
      removeMessageFromScenario(scenario, sequenceMessage);
    }
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
  
  private static boolean foundCapellaMessageInXText(SequenceMessage capellaSequenceMessage,
      List<EObject> allXtextSequenceMessages) {
    for (EObject message : allXtextSequenceMessages) {
      if (isSameMessage(message, capellaSequenceMessage)) {
        return true;
      }
    }
    return false;
  }

  private static List<EObject> getAllXtextSequenceMessages(EList<EObject> textMessages) {
    ArrayList<EObject> xtextSequenceMessages = new ArrayList<EObject>();
    for (EObject element : textMessages) {
      // SequenceMessage -> add it
      if (element instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) {
        xtextSequenceMessages.add(element);
      }
      // CombinedFragment -> go inside and find all sequence messages at all levels
      if (element instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment) {
        org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment combinedFragmentElement = 
            (org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment) element;
        
        //get sequence messages from the first operand (first block, actually)
        xtextSequenceMessages.addAll(getAllXtextSequenceMessages(combinedFragmentElement.getBlock().getBlockElements()));
  
        //get sequence messages from the rest of the operands
        for (EObject operand : combinedFragmentElement.getOperands()) {
          xtextSequenceMessages.addAll(getAllXtextSequenceMessages(((Operand) operand).getBlock().getBlockElements()));
        }
      }      
    }
    
    return xtextSequenceMessages;
  }

  private static boolean isSameMessage(EObject m, SequenceMessage seqMessage) {
    if (!(m instanceof org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage)) {
      return false;
    }
    org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage message = (org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage) m;
    if (!seqMessage.getSendingEnd().getCoveredInstanceRoles().isEmpty()
        && message.getSource().equals(seqMessage.getSendingEnd().getCoveredInstanceRoles().get(0).getName())
        && !seqMessage.getReceivingEnd().getCoveredInstanceRoles().isEmpty()
        && message.getTarget().equals(seqMessage.getReceivingEnd().getCoveredInstanceRoles().get(0).getName())
        && message.getName().equals(seqMessage.getName())) {
      return true;
    }
    return false;
  }

  private static SequenceMessage createCapellaSequenceMessage(Scenario scenario, InstanceRole target,
      InstanceRole source, org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage seqMessage) {
    return createCapellaSequenceMessage(scenario, target, source, seqMessage, false);
  }

  /*
   * Create a capella sequence message (and set all data needed by a capella sequence message : sending end, receiving
   * end, execution etc
   */
  private static SequenceMessage createCapellaSequenceMessage(Scenario scenario, InstanceRole source,
      InstanceRole target, org.polarsys.capella.scenario.editor.dsl.textualScenario.SequenceMessage seqMessage,
      boolean isReplyMessage) {
    // create Capella SequenceMessage
    SequenceMessage sequenceMessage = InteractionFactory.eINSTANCE.createSequenceMessage();
    sequenceMessage.setName(seqMessage.getName());
    sequenceMessage.setKind(isReplyMessage ? MessageKind.REPLY
        : seqMessage.getReturn() != null ? MessageKind.SYNCHRONOUS_CALL : MessageKind.ASYNCHRONOUS_CALL);

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

    // execution end
    if (!isReplyMessage) {
      ExecutionEnd executionEnd = InteractionFactory.eINSTANCE.createExecutionEnd();
      if (seqMessage.getReturn() == null) {
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
    List<CapellaElement> exchanges = null;
    if (isReplyMessage) {
      exchanges = SelectInvokedOperationModelForSharedDataAndEvent.getAvailableExchangeItems(target, source, false);
    } else {
      exchanges = SelectInvokedOperationModelForSharedDataAndEvent.getAvailableExchangeItems(source, target, false);
    }
    exchanges = exchanges.stream()
        .filter(ex -> ((ExchangeItemAllocation) ex).getAllocatedItem().getName().equals(seqMessage.getName()))
        .collect(Collectors.toList());
    if (!exchanges.isEmpty()) {
      eventRecvOperation.setOperation((AbstractEventOperation) exchanges.get(0));
      eventSentOperation.setOperation((AbstractEventOperation) exchanges.get(0));
    }

    return sequenceMessage;
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
        oppositeSequenceMessage = SequenceMessageExt.getOppositeSequenceMessage(sequenceMessage);
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
      org.polarsys.capella.scenario.editor.dsl.textualScenario.CombinedFragment condition,
      InteractionFragment lastInteractionFragment) {

    TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(scenario);
    domain.getCommandStack().execute(new RecordingCommand(domain) {

      @Override
      protected void doExecute() {
        // generate CombinedFragment, FramentEnd, FragmentEnd, IntreationOperands from alt
        FragmentEnd start = InteractionFactory.eINSTANCE.createFragmentEnd();
        FragmentEnd finish = InteractionFactory.eINSTANCE.createFragmentEnd();

        condition.getTimelines().forEach(timeline -> {
          InstanceRole instanceRole = EmbeddedEditorInstanceHelper.getInstanceRole(timeline);
          start.getCoveredInstanceRoles().add(instanceRole);
          finish.getCoveredInstanceRoles().add(instanceRole);
        });

        start.setName("start");
        finish.setName("end");

        scenario.getOwnedInteractionFragments().add(start);
        scenario.getOwnedInteractionFragments().add(finish);

        if (lastInteractionFragment != null)
          ScenarioExt.moveEndOnBeginingOfScenario(lastInteractionFragment);
        else
          ScenarioExt.moveEndOnBeginingOfScenario(start);

        CombinedFragment combinedFragment = addCombinedFragment(start, finish, InteractionOperatorKind.ALT);
        scenario.getOwnedTimeLapses().add(combinedFragment);

        Block firstBlock = condition.getBlock();
        if (firstBlock != null) {
          InteractionOperand operand = addInteractionOperand(start.getCoveredInstanceRoles(),
              condition.getExpression());
          combinedFragment.getReferencedOperands().add(operand);
          scenario.getOwnedInteractionFragments().add(operand);
          ScenarioExt.moveEndOnScenario(operand, start);

          editElements(scenario, firstBlock.getBlockElements());

          InteractionOperand prevEnd = operand;
          for (Operand operandBlock : condition.getOperands()) {
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
    });
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
}
