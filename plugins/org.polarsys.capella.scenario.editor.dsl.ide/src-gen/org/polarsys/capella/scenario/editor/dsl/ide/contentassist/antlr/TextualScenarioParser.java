/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
 *  
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License 2.0 which is available at
 *  http://www.eclipse.org/legal/epl-2.0
 *  
 *  SPDX-License-Identifier: EPL-2.0
 *  
 *  Contributors:
 *     Thales - initial API and implementation
 ******************************************************************************/
/*
 * generated by Xtext 2.18.0.M3
 */
package org.polarsys.capella.scenario.editor.dsl.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.polarsys.capella.scenario.editor.dsl.ide.contentassist.antlr.internal.InternalTextualScenarioParser;
import org.polarsys.capella.scenario.editor.dsl.services.TextualScenarioGrammarAccess;

public class TextualScenarioParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(TextualScenarioGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, TextualScenarioGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getModelAccess().getAlternatives_3(), "rule__Model__Alternatives_3");
			builder.put(grammarAccess.getModelAccess().getMessagesOrReferencesAlternatives_3_0_0(), "rule__Model__MessagesOrReferencesAlternatives_3_0_0");
			builder.put(grammarAccess.getParticipantAccess().getAlternatives(), "rule__Participant__Alternatives");
			builder.put(grammarAccess.getGenericComponentAccess().getAlternatives(), "rule__GenericComponent__Alternatives");
			builder.put(grammarAccess.getGenericFunctionAccess().getAlternatives(), "rule__GenericFunction__Alternatives");
			builder.put(grammarAccess.getComponentAccess().getNatureAlternatives_2_0(), "rule__Component__NatureAlternatives_2_0");
			builder.put(grammarAccess.getMessageAccess().getAlternatives(), "rule__Message__Alternatives");
			builder.put(grammarAccess.getSequenceMessageTypeAccess().getAlternatives(), "rule__SequenceMessageType__Alternatives");
			builder.put(grammarAccess.getBlockAccess().getAlternatives_1(), "rule__Block__Alternatives_1");
			builder.put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
			builder.put(grammarAccess.getActorAccess().getGroup(), "rule__Actor__Group__0");
			builder.put(grammarAccess.getComponentAccess().getGroup(), "rule__Component__Group__0");
			builder.put(grammarAccess.getConfigurationItemAccess().getGroup(), "rule__ConfigurationItem__Group__0");
			builder.put(grammarAccess.getFunctionAccess().getGroup(), "rule__Function__Group__0");
			builder.put(grammarAccess.getActivityAccess().getGroup(), "rule__Activity__Group__0");
			builder.put(grammarAccess.getEntityAccess().getGroup(), "rule__Entity__Group__0");
			builder.put(grammarAccess.getRoleAccess().getGroup(), "rule__Role__Group__0");
			builder.put(grammarAccess.getSequenceMessageAccess().getGroup(), "rule__SequenceMessage__Group__0");
			builder.put(grammarAccess.getCreateMessageAccess().getGroup(), "rule__CreateMessage__Group__0");
			builder.put(grammarAccess.getDeleteMessageAccess().getGroup(), "rule__DeleteMessage__Group__0");
			builder.put(grammarAccess.getArmTimerMessageAccess().getGroup(), "rule__ArmTimerMessage__Group__0");
			builder.put(grammarAccess.getParticipantDeactivationAccess().getGroup(), "rule__ParticipantDeactivation__Group__0");
			builder.put(grammarAccess.getReferenceAccess().getGroup(), "rule__Reference__Group__0");
			builder.put(grammarAccess.getAltAccess().getGroup(), "rule__Alt__Group__0");
			builder.put(grammarAccess.getElseBlockAccess().getGroup(), "rule__ElseBlock__Group__0");
			builder.put(grammarAccess.getBlockAccess().getGroup(), "rule__Block__Group__0");
			builder.put(grammarAccess.getModelAccess().getBeginAssignment_1(), "rule__Model__BeginAssignment_1");
			builder.put(grammarAccess.getModelAccess().getParticipantsAssignment_2(), "rule__Model__ParticipantsAssignment_2");
			builder.put(grammarAccess.getModelAccess().getMessagesOrReferencesAssignment_3_0(), "rule__Model__MessagesOrReferencesAssignment_3_0");
			builder.put(grammarAccess.getModelAccess().getConditionsAssignment_3_1(), "rule__Model__ConditionsAssignment_3_1");
			builder.put(grammarAccess.getModelAccess().getEndAssignment_4(), "rule__Model__EndAssignment_4");
			builder.put(grammarAccess.getActorAccess().getKeywordAssignment_0(), "rule__Actor__KeywordAssignment_0");
			builder.put(grammarAccess.getActorAccess().getNameAssignment_1(), "rule__Actor__NameAssignment_1");
			builder.put(grammarAccess.getComponentAccess().getKeywordAssignment_0(), "rule__Component__KeywordAssignment_0");
			builder.put(grammarAccess.getComponentAccess().getNameAssignment_1(), "rule__Component__NameAssignment_1");
			builder.put(grammarAccess.getComponentAccess().getNatureAssignment_2(), "rule__Component__NatureAssignment_2");
			builder.put(grammarAccess.getConfigurationItemAccess().getKeywordAssignment_0(), "rule__ConfigurationItem__KeywordAssignment_0");
			builder.put(grammarAccess.getConfigurationItemAccess().getNameAssignment_1(), "rule__ConfigurationItem__NameAssignment_1");
			builder.put(grammarAccess.getFunctionAccess().getKeywordAssignment_0(), "rule__Function__KeywordAssignment_0");
			builder.put(grammarAccess.getFunctionAccess().getNameAssignment_1(), "rule__Function__NameAssignment_1");
			builder.put(grammarAccess.getActivityAccess().getKeywordAssignment_0(), "rule__Activity__KeywordAssignment_0");
			builder.put(grammarAccess.getActivityAccess().getNameAssignment_1(), "rule__Activity__NameAssignment_1");
			builder.put(grammarAccess.getEntityAccess().getKeywordAssignment_0(), "rule__Entity__KeywordAssignment_0");
			builder.put(grammarAccess.getEntityAccess().getNameAssignment_1(), "rule__Entity__NameAssignment_1");
			builder.put(grammarAccess.getRoleAccess().getKeywordAssignment_0(), "rule__Role__KeywordAssignment_0");
			builder.put(grammarAccess.getRoleAccess().getNameAssignment_1(), "rule__Role__NameAssignment_1");
			builder.put(grammarAccess.getSequenceMessageAccess().getSourceAssignment_0(), "rule__SequenceMessage__SourceAssignment_0");
			builder.put(grammarAccess.getSequenceMessageAccess().getTargetAssignment_2(), "rule__SequenceMessage__TargetAssignment_2");
			builder.put(grammarAccess.getSequenceMessageAccess().getExecutionAssignment_3(), "rule__SequenceMessage__ExecutionAssignment_3");
			builder.put(grammarAccess.getSequenceMessageAccess().getReturnAssignment_4(), "rule__SequenceMessage__ReturnAssignment_4");
			builder.put(grammarAccess.getSequenceMessageAccess().getNameAssignment_6(), "rule__SequenceMessage__NameAssignment_6");
			builder.put(grammarAccess.getCreateMessageAccess().getSourceAssignment_0(), "rule__CreateMessage__SourceAssignment_0");
			builder.put(grammarAccess.getCreateMessageAccess().getTargetAssignment_2(), "rule__CreateMessage__TargetAssignment_2");
			builder.put(grammarAccess.getCreateMessageAccess().getNameAssignment_4(), "rule__CreateMessage__NameAssignment_4");
			builder.put(grammarAccess.getDeleteMessageAccess().getSourceAssignment_0(), "rule__DeleteMessage__SourceAssignment_0");
			builder.put(grammarAccess.getDeleteMessageAccess().getTargetAssignment_2(), "rule__DeleteMessage__TargetAssignment_2");
			builder.put(grammarAccess.getDeleteMessageAccess().getNameAssignment_4(), "rule__DeleteMessage__NameAssignment_4");
			builder.put(grammarAccess.getArmTimerMessageAccess().getParticipantAssignment_1(), "rule__ArmTimerMessage__ParticipantAssignment_1");
			builder.put(grammarAccess.getArmTimerMessageAccess().getNameAssignment_3(), "rule__ArmTimerMessage__NameAssignment_3");
			builder.put(grammarAccess.getParticipantDeactivationAccess().getKeywordAssignment_0(), "rule__ParticipantDeactivation__KeywordAssignment_0");
			builder.put(grammarAccess.getParticipantDeactivationAccess().getNameAssignment_1(), "rule__ParticipantDeactivation__NameAssignment_1");
			builder.put(grammarAccess.getReferenceAccess().getKeywordAssignment_0(), "rule__Reference__KeywordAssignment_0");
			builder.put(grammarAccess.getReferenceAccess().getTimelinesAssignment_2(), "rule__Reference__TimelinesAssignment_2");
			builder.put(grammarAccess.getReferenceAccess().getNameAssignment_3(), "rule__Reference__NameAssignment_3");
			builder.put(grammarAccess.getAltAccess().getKeywordAssignment_0(), "rule__Alt__KeywordAssignment_0");
			builder.put(grammarAccess.getAltAccess().getConditionAssignment_1(), "rule__Alt__ConditionAssignment_1");
			builder.put(grammarAccess.getAltAccess().getTimelinesAssignment_3(), "rule__Alt__TimelinesAssignment_3");
			builder.put(grammarAccess.getAltAccess().getBlockAssignment_4(), "rule__Alt__BlockAssignment_4");
			builder.put(grammarAccess.getAltAccess().getElseBlocksAssignment_5(), "rule__Alt__ElseBlocksAssignment_5");
			builder.put(grammarAccess.getElseBlockAccess().getConditionAssignment_1(), "rule__ElseBlock__ConditionAssignment_1");
			builder.put(grammarAccess.getElseBlockAccess().getBlockAssignment_2(), "rule__ElseBlock__BlockAssignment_2");
			builder.put(grammarAccess.getBlockAccess().getBeginAssignment_0(), "rule__Block__BeginAssignment_0");
			builder.put(grammarAccess.getBlockAccess().getMessagesAssignment_1_0(), "rule__Block__MessagesAssignment_1_0");
			builder.put(grammarAccess.getBlockAccess().getReferencesAssignment_1_1(), "rule__Block__ReferencesAssignment_1_1");
			builder.put(grammarAccess.getBlockAccess().getConditionsAssignment_1_2(), "rule__Block__ConditionsAssignment_1_2");
			builder.put(grammarAccess.getBlockAccess().getEndAssignment_2(), "rule__Block__EndAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private TextualScenarioGrammarAccess grammarAccess;

	@Override
	protected InternalTextualScenarioParser createParser() {
		InternalTextualScenarioParser result = new InternalTextualScenarioParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public TextualScenarioGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(TextualScenarioGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
