/*
 * generated by Xtext 2.18.0.M3
 */
grammar InternalTextualScenario;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.polarsys.capella.scenario.editor.dsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.polarsys.capella.scenario.editor.dsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.polarsys.capella.scenario.editor.dsl.services.TextualScenarioGrammarAccess;

}

@parser::members {

 	private TextualScenarioGrammarAccess grammarAccess;

    public InternalTextualScenarioParser(TokenStream input, TextualScenarioGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
   	}

   	@Override
   	protected TextualScenarioGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	iv_ruleModel=ruleModel
	{ $current=$iv_ruleModel.current; }
	EOF;

// Rule Model
ruleModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='scenario'
		{
			newLeafNode(otherlv_0, grammarAccess.getModelAccess().getScenarioKeyword_0());
		}
		(
			(
				lv_begin_1_0='{'
				{
					newLeafNode(lv_begin_1_0, grammarAccess.getModelAccess().getBeginLeftCurlyBracketKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getModelRule());
					}
					setWithLastConsumed($current, "begin", lv_begin_1_0, "{");
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getParticipantsParticipantParserRuleCall_2_0());
				}
				lv_participants_2_0=ruleParticipant
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"participants",
						lv_participants_2_0,
						"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Participant");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getModelAccess().getMessagesOrReferencesMessageParserRuleCall_3_0_0_0());
						}
						lv_messagesOrReferences_3_1=ruleMessage
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getModelRule());
							}
							add(
								$current,
								"messagesOrReferences",
								lv_messagesOrReferences_3_1,
								"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Message");
							afterParserOrEnumRuleCall();
						}
						    |
						{
							newCompositeNode(grammarAccess.getModelAccess().getMessagesOrReferencesReferenceParserRuleCall_3_0_0_1());
						}
						lv_messagesOrReferences_3_2=ruleReference
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getModelRule());
							}
							add(
								$current,
								"messagesOrReferences",
								lv_messagesOrReferences_3_2,
								"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Reference");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getModelAccess().getConditionsAltParserRuleCall_3_1_0());
					}
					lv_conditions_4_0=ruleAlt
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getModelRule());
						}
						add(
							$current,
							"conditions",
							lv_conditions_4_0,
							"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Alt");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		(
			(
				lv_end_5_0='}'
				{
					newLeafNode(lv_end_5_0, grammarAccess.getModelAccess().getEndRightCurlyBracketKeyword_4_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getModelRule());
					}
					setWithLastConsumed($current, "end", lv_end_5_0, "}");
				}
			)
		)
	)
;

// Entry rule entryRuleParticipant
entryRuleParticipant returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getParticipantRule()); }
	iv_ruleParticipant=ruleParticipant
	{ $current=$iv_ruleParticipant.current; }
	EOF;

// Rule Participant
ruleParticipant returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getParticipantAccess().getGenericComponentParserRuleCall_0());
		}
		this_GenericComponent_0=ruleGenericComponent
		{
			$current = $this_GenericComponent_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getParticipantAccess().getGenericFunctionParserRuleCall_1());
		}
		this_GenericFunction_1=ruleGenericFunction
		{
			$current = $this_GenericFunction_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleGenericComponent
entryRuleGenericComponent returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getGenericComponentRule()); }
	iv_ruleGenericComponent=ruleGenericComponent
	{ $current=$iv_ruleGenericComponent.current; }
	EOF;

// Rule GenericComponent
ruleGenericComponent returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getGenericComponentAccess().getEntityParserRuleCall_0());
		}
		this_Entity_0=ruleEntity
		{
			$current = $this_Entity_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getGenericComponentAccess().getActorParserRuleCall_1());
		}
		this_Actor_1=ruleActor
		{
			$current = $this_Actor_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getGenericComponentAccess().getComponentParserRuleCall_2());
		}
		this_Component_2=ruleComponent
		{
			$current = $this_Component_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getGenericComponentAccess().getConfigurationItemParserRuleCall_3());
		}
		this_ConfigurationItem_3=ruleConfigurationItem
		{
			$current = $this_ConfigurationItem_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getGenericComponentAccess().getRoleParserRuleCall_4());
		}
		this_Role_4=ruleRole
		{
			$current = $this_Role_4.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleGenericFunction
entryRuleGenericFunction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getGenericFunctionRule()); }
	iv_ruleGenericFunction=ruleGenericFunction
	{ $current=$iv_ruleGenericFunction.current; }
	EOF;

// Rule GenericFunction
ruleGenericFunction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getGenericFunctionAccess().getFunctionParserRuleCall_0());
		}
		this_Function_0=ruleFunction
		{
			$current = $this_Function_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getGenericFunctionAccess().getActivityParserRuleCall_1());
		}
		this_Activity_1=ruleActivity
		{
			$current = $this_Activity_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleActor
entryRuleActor returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getActorRule()); }
	iv_ruleActor=ruleActor
	{ $current=$iv_ruleActor.current; }
	EOF;

// Rule Actor
ruleActor returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_keyword_0_0='actor'
				{
					newLeafNode(lv_keyword_0_0, grammarAccess.getActorAccess().getKeywordActorKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getActorRule());
					}
					setWithLastConsumed($current, "keyword", lv_keyword_0_0, "actor");
				}
			)
		)
		(
			(
				lv_name_1_0=RULE_STRING
				{
					newLeafNode(lv_name_1_0, grammarAccess.getActorAccess().getNameSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getActorRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleComponent
entryRuleComponent returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComponentRule()); }
	iv_ruleComponent=ruleComponent
	{ $current=$iv_ruleComponent.current; }
	EOF;

// Rule Component
ruleComponent returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_keyword_0_0='component'
				{
					newLeafNode(lv_keyword_0_0, grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getComponentRule());
					}
					setWithLastConsumed($current, "keyword", lv_keyword_0_0, "component");
				}
			)
		)
		(
			(
				lv_name_1_0=RULE_STRING
				{
					newLeafNode(lv_name_1_0, grammarAccess.getComponentAccess().getNameSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getComponentRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		(
			(
				(
					lv_nature_2_1='unset'
					{
						newLeafNode(lv_nature_2_1, grammarAccess.getComponentAccess().getNatureUnsetKeyword_2_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getComponentRule());
						}
						setWithLastConsumed($current, "nature", lv_nature_2_1, null);
					}
					    |
					lv_nature_2_2='behavior'
					{
						newLeafNode(lv_nature_2_2, grammarAccess.getComponentAccess().getNatureBehaviorKeyword_2_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getComponentRule());
						}
						setWithLastConsumed($current, "nature", lv_nature_2_2, null);
					}
					    |
					lv_nature_2_3='node'
					{
						newLeafNode(lv_nature_2_3, grammarAccess.getComponentAccess().getNatureNodeKeyword_2_0_2());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getComponentRule());
						}
						setWithLastConsumed($current, "nature", lv_nature_2_3, null);
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleConfigurationItem
entryRuleConfigurationItem returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConfigurationItemRule()); }
	iv_ruleConfigurationItem=ruleConfigurationItem
	{ $current=$iv_ruleConfigurationItem.current; }
	EOF;

// Rule ConfigurationItem
ruleConfigurationItem returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_keyword_0_0='configuration_item'
				{
					newLeafNode(lv_keyword_0_0, grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConfigurationItemRule());
					}
					setWithLastConsumed($current, "keyword", lv_keyword_0_0, "configuration_item");
				}
			)
		)
		(
			(
				lv_name_1_0=RULE_STRING
				{
					newLeafNode(lv_name_1_0, grammarAccess.getConfigurationItemAccess().getNameSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConfigurationItemRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleFunction
entryRuleFunction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFunctionRule()); }
	iv_ruleFunction=ruleFunction
	{ $current=$iv_ruleFunction.current; }
	EOF;

// Rule Function
ruleFunction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_keyword_0_0='function'
				{
					newLeafNode(lv_keyword_0_0, grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFunctionRule());
					}
					setWithLastConsumed($current, "keyword", lv_keyword_0_0, "function");
				}
			)
		)
		(
			(
				lv_name_1_0=RULE_STRING
				{
					newLeafNode(lv_name_1_0, grammarAccess.getFunctionAccess().getNameSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFunctionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleActivity
entryRuleActivity returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getActivityRule()); }
	iv_ruleActivity=ruleActivity
	{ $current=$iv_ruleActivity.current; }
	EOF;

// Rule Activity
ruleActivity returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_keyword_0_0='activity'
				{
					newLeafNode(lv_keyword_0_0, grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getActivityRule());
					}
					setWithLastConsumed($current, "keyword", lv_keyword_0_0, "activity");
				}
			)
		)
		(
			(
				lv_name_1_0=RULE_STRING
				{
					newLeafNode(lv_name_1_0, grammarAccess.getActivityAccess().getNameSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getActivityRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleEntity
entryRuleEntity returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntityRule()); }
	iv_ruleEntity=ruleEntity
	{ $current=$iv_ruleEntity.current; }
	EOF;

// Rule Entity
ruleEntity returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_keyword_0_0='entity'
				{
					newLeafNode(lv_keyword_0_0, grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityRule());
					}
					setWithLastConsumed($current, "keyword", lv_keyword_0_0, "entity");
				}
			)
		)
		(
			(
				lv_name_1_0=RULE_STRING
				{
					newLeafNode(lv_name_1_0, grammarAccess.getEntityAccess().getNameSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleRole
entryRuleRole returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRoleRule()); }
	iv_ruleRole=ruleRole
	{ $current=$iv_ruleRole.current; }
	EOF;

// Rule Role
ruleRole returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_keyword_0_0='role'
				{
					newLeafNode(lv_keyword_0_0, grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRoleRule());
					}
					setWithLastConsumed($current, "keyword", lv_keyword_0_0, "role");
				}
			)
		)
		(
			(
				lv_name_1_0=RULE_STRING
				{
					newLeafNode(lv_name_1_0, grammarAccess.getRoleAccess().getNameSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRoleRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleMessage
entryRuleMessage returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMessageRule()); }
	iv_ruleMessage=ruleMessage
	{ $current=$iv_ruleMessage.current; }
	EOF;

// Rule Message
ruleMessage returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getMessageAccess().getSequenceMessageTypeParserRuleCall_0());
		}
		this_SequenceMessageType_0=ruleSequenceMessageType
		{
			$current = $this_SequenceMessageType_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getMessageAccess().getArmTimerMessageParserRuleCall_1());
		}
		this_ArmTimerMessage_1=ruleArmTimerMessage
		{
			$current = $this_ArmTimerMessage_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getMessageAccess().getParticipantDeactivationParserRuleCall_2());
		}
		this_ParticipantDeactivation_2=ruleParticipantDeactivation
		{
			$current = $this_ParticipantDeactivation_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleSequenceMessageType
entryRuleSequenceMessageType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSequenceMessageTypeRule()); }
	iv_ruleSequenceMessageType=ruleSequenceMessageType
	{ $current=$iv_ruleSequenceMessageType.current; }
	EOF;

// Rule SequenceMessageType
ruleSequenceMessageType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getSequenceMessageTypeAccess().getSequenceMessageParserRuleCall_0());
		}
		this_SequenceMessage_0=ruleSequenceMessage
		{
			$current = $this_SequenceMessage_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getSequenceMessageTypeAccess().getCreateMessageParserRuleCall_1());
		}
		this_CreateMessage_1=ruleCreateMessage
		{
			$current = $this_CreateMessage_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getSequenceMessageTypeAccess().getDeleteMessageParserRuleCall_2());
		}
		this_DeleteMessage_2=ruleDeleteMessage
		{
			$current = $this_DeleteMessage_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleSequenceMessage
entryRuleSequenceMessage returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSequenceMessageRule()); }
	iv_ruleSequenceMessage=ruleSequenceMessage
	{ $current=$iv_ruleSequenceMessage.current; }
	EOF;

// Rule SequenceMessage
ruleSequenceMessage returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_source_0_0=RULE_STRING
				{
					newLeafNode(lv_source_0_0, grammarAccess.getSequenceMessageAccess().getSourceSTRINGTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSequenceMessageRule());
					}
					setWithLastConsumed(
						$current,
						"source",
						lv_source_0_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		otherlv_1='->'
		{
			newLeafNode(otherlv_1, grammarAccess.getSequenceMessageAccess().getHyphenMinusGreaterThanSignKeyword_1());
		}
		(
			(
				lv_target_2_0=RULE_STRING
				{
					newLeafNode(lv_target_2_0, grammarAccess.getSequenceMessageAccess().getTargetSTRINGTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSequenceMessageRule());
					}
					setWithLastConsumed(
						$current,
						"target",
						lv_target_2_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		(
			(
				lv_execution_3_0='withExecution'
				{
					newLeafNode(lv_execution_3_0, grammarAccess.getSequenceMessageAccess().getExecutionWithExecutionKeyword_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSequenceMessageRule());
					}
					setWithLastConsumed($current, "execution", lv_execution_3_0, "withExecution");
				}
			)
		)?
		(
			(
				lv_return_4_0='withReturn'
				{
					newLeafNode(lv_return_4_0, grammarAccess.getSequenceMessageAccess().getReturnWithReturnKeyword_4_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSequenceMessageRule());
					}
					setWithLastConsumed($current, "return", lv_return_4_0, "withReturn");
				}
			)
		)?
		otherlv_5=':'
		{
			newLeafNode(otherlv_5, grammarAccess.getSequenceMessageAccess().getColonKeyword_5());
		}
		(
			(
				lv_name_6_0=RULE_STRING
				{
					newLeafNode(lv_name_6_0, grammarAccess.getSequenceMessageAccess().getNameSTRINGTerminalRuleCall_6_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSequenceMessageRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_6_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleCreateMessage
entryRuleCreateMessage returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCreateMessageRule()); }
	iv_ruleCreateMessage=ruleCreateMessage
	{ $current=$iv_ruleCreateMessage.current; }
	EOF;

// Rule CreateMessage
ruleCreateMessage returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_source_0_0=RULE_STRING
				{
					newLeafNode(lv_source_0_0, grammarAccess.getCreateMessageAccess().getSourceSTRINGTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getCreateMessageRule());
					}
					setWithLastConsumed(
						$current,
						"source",
						lv_source_0_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		otherlv_1='->+'
		{
			newLeafNode(otherlv_1, grammarAccess.getCreateMessageAccess().getHyphenMinusGreaterThanSignPlusSignKeyword_1());
		}
		(
			(
				lv_target_2_0=RULE_STRING
				{
					newLeafNode(lv_target_2_0, grammarAccess.getCreateMessageAccess().getTargetSTRINGTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getCreateMessageRule());
					}
					setWithLastConsumed(
						$current,
						"target",
						lv_target_2_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		otherlv_3=':'
		{
			newLeafNode(otherlv_3, grammarAccess.getCreateMessageAccess().getColonKeyword_3());
		}
		(
			(
				lv_name_4_0=RULE_STRING
				{
					newLeafNode(lv_name_4_0, grammarAccess.getCreateMessageAccess().getNameSTRINGTerminalRuleCall_4_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getCreateMessageRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_4_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleDeleteMessage
entryRuleDeleteMessage returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDeleteMessageRule()); }
	iv_ruleDeleteMessage=ruleDeleteMessage
	{ $current=$iv_ruleDeleteMessage.current; }
	EOF;

// Rule DeleteMessage
ruleDeleteMessage returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_source_0_0=RULE_STRING
				{
					newLeafNode(lv_source_0_0, grammarAccess.getDeleteMessageAccess().getSourceSTRINGTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDeleteMessageRule());
					}
					setWithLastConsumed(
						$current,
						"source",
						lv_source_0_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		otherlv_1='->x'
		{
			newLeafNode(otherlv_1, grammarAccess.getDeleteMessageAccess().getXKeyword_1());
		}
		(
			(
				lv_target_2_0=RULE_STRING
				{
					newLeafNode(lv_target_2_0, grammarAccess.getDeleteMessageAccess().getTargetSTRINGTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDeleteMessageRule());
					}
					setWithLastConsumed(
						$current,
						"target",
						lv_target_2_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		otherlv_3=':'
		{
			newLeafNode(otherlv_3, grammarAccess.getDeleteMessageAccess().getColonKeyword_3());
		}
		(
			(
				lv_name_4_0=RULE_STRING
				{
					newLeafNode(lv_name_4_0, grammarAccess.getDeleteMessageAccess().getNameSTRINGTerminalRuleCall_4_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDeleteMessageRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_4_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleArmTimerMessage
entryRuleArmTimerMessage returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getArmTimerMessageRule()); }
	iv_ruleArmTimerMessage=ruleArmTimerMessage
	{ $current=$iv_ruleArmTimerMessage.current; }
	EOF;

// Rule ArmTimerMessage
ruleArmTimerMessage returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='->>'
		{
			newLeafNode(otherlv_0, grammarAccess.getArmTimerMessageAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_0());
		}
		(
			(
				lv_participant_1_0=RULE_STRING
				{
					newLeafNode(lv_participant_1_0, grammarAccess.getArmTimerMessageAccess().getParticipantSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getArmTimerMessageRule());
					}
					setWithLastConsumed(
						$current,
						"participant",
						lv_participant_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		otherlv_2=':'
		{
			newLeafNode(otherlv_2, grammarAccess.getArmTimerMessageAccess().getColonKeyword_2());
		}
		(
			(
				lv_name_3_0=RULE_STRING
				{
					newLeafNode(lv_name_3_0, grammarAccess.getArmTimerMessageAccess().getNameSTRINGTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getArmTimerMessageRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleParticipantDeactivation
entryRuleParticipantDeactivation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getParticipantDeactivationRule()); }
	iv_ruleParticipantDeactivation=ruleParticipantDeactivation
	{ $current=$iv_ruleParticipantDeactivation.current; }
	EOF;

// Rule ParticipantDeactivation
ruleParticipantDeactivation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_keyword_0_0='deactivate'
				{
					newLeafNode(lv_keyword_0_0, grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getParticipantDeactivationRule());
					}
					setWithLastConsumed($current, "keyword", lv_keyword_0_0, "deactivate");
				}
			)
		)
		(
			(
				lv_name_1_0=RULE_STRING
				{
					newLeafNode(lv_name_1_0, grammarAccess.getParticipantDeactivationAccess().getNameSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getParticipantDeactivationRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleReference
entryRuleReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getReferenceRule()); }
	iv_ruleReference=ruleReference
	{ $current=$iv_ruleReference.current; }
	EOF;

// Rule Reference
ruleReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_keyword_0_0='ref'
				{
					newLeafNode(lv_keyword_0_0, grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReferenceRule());
					}
					setWithLastConsumed($current, "keyword", lv_keyword_0_0, "ref");
				}
			)
		)
		otherlv_1='over'
		{
			newLeafNode(otherlv_1, grammarAccess.getReferenceAccess().getOverKeyword_1());
		}
		(
			(
				lv_timelines_2_0=RULE_STRING
				{
					newLeafNode(lv_timelines_2_0, grammarAccess.getReferenceAccess().getTimelinesSTRINGTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReferenceRule());
					}
					addWithLastConsumed(
						$current,
						"timelines",
						lv_timelines_2_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)+
		(
			(
				lv_name_3_0=RULE_STRING
				{
					newLeafNode(lv_name_3_0, grammarAccess.getReferenceAccess().getNameSTRINGTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReferenceRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleAlt
entryRuleAlt returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAltRule()); }
	iv_ruleAlt=ruleAlt
	{ $current=$iv_ruleAlt.current; }
	EOF;

// Rule Alt
ruleAlt returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_keyword_0_0='alt'
				{
					newLeafNode(lv_keyword_0_0, grammarAccess.getAltAccess().getKeywordAltKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAltRule());
					}
					setWithLastConsumed($current, "keyword", lv_keyword_0_0, "alt");
				}
			)
		)
		(
			(
				lv_condition_1_0=RULE_STRING
				{
					newLeafNode(lv_condition_1_0, grammarAccess.getAltAccess().getConditionSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAltRule());
					}
					setWithLastConsumed(
						$current,
						"condition",
						lv_condition_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		otherlv_2='over'
		{
			newLeafNode(otherlv_2, grammarAccess.getAltAccess().getOverKeyword_2());
		}
		(
			(
				lv_timelines_3_0=RULE_STRING
				{
					newLeafNode(lv_timelines_3_0, grammarAccess.getAltAccess().getTimelinesSTRINGTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAltRule());
					}
					addWithLastConsumed(
						$current,
						"timelines",
						lv_timelines_3_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)+
		(
			(
				{
					newCompositeNode(grammarAccess.getAltAccess().getBlockBlockParserRuleCall_4_0());
				}
				lv_block_4_0=ruleBlock
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAltRule());
					}
					set(
						$current,
						"block",
						lv_block_4_0,
						"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Block");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getAltAccess().getElseBlocksElseBlockParserRuleCall_5_0());
				}
				lv_elseBlocks_5_0=ruleElseBlock
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAltRule());
					}
					add(
						$current,
						"elseBlocks",
						lv_elseBlocks_5_0,
						"org.polarsys.capella.scenario.editor.dsl.TextualScenario.ElseBlock");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;

// Entry rule entryRuleElseBlock
entryRuleElseBlock returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getElseBlockRule()); }
	iv_ruleElseBlock=ruleElseBlock
	{ $current=$iv_ruleElseBlock.current; }
	EOF;

// Rule ElseBlock
ruleElseBlock returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='else'
		{
			newLeafNode(otherlv_0, grammarAccess.getElseBlockAccess().getElseKeyword_0());
		}
		(
			(
				lv_condition_1_0=RULE_STRING
				{
					newLeafNode(lv_condition_1_0, grammarAccess.getElseBlockAccess().getConditionSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getElseBlockRule());
					}
					setWithLastConsumed(
						$current,
						"condition",
						lv_condition_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getElseBlockAccess().getBlockBlockParserRuleCall_2_0());
				}
				lv_block_2_0=ruleBlock
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getElseBlockRule());
					}
					set(
						$current,
						"block",
						lv_block_2_0,
						"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Block");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleBlock
entryRuleBlock returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBlockRule()); }
	iv_ruleBlock=ruleBlock
	{ $current=$iv_ruleBlock.current; }
	EOF;

// Rule Block
ruleBlock returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_begin_0_0='{'
				{
					newLeafNode(lv_begin_0_0, grammarAccess.getBlockAccess().getBeginLeftCurlyBracketKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getBlockRule());
					}
					setWithLastConsumed($current, "begin", lv_begin_0_0, "{");
				}
			)
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getBlockAccess().getMessagesMessageParserRuleCall_1_0_0());
					}
					lv_messages_1_0=ruleMessage
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getBlockRule());
						}
						add(
							$current,
							"messages",
							lv_messages_1_0,
							"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Message");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getBlockAccess().getReferencesReferenceParserRuleCall_1_1_0());
					}
					lv_references_2_0=ruleReference
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getBlockRule());
						}
						add(
							$current,
							"references",
							lv_references_2_0,
							"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Reference");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getBlockAccess().getConditionsAltParserRuleCall_1_2_0());
					}
					lv_conditions_3_0=ruleAlt
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getBlockRule());
						}
						add(
							$current,
							"conditions",
							lv_conditions_3_0,
							"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Alt");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		(
			(
				lv_end_4_0='}'
				{
					newLeafNode(lv_end_4_0, grammarAccess.getBlockAccess().getEndRightCurlyBracketKeyword_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getBlockRule());
					}
					setWithLastConsumed($current, "end", lv_end_4_0, "}");
				}
			)
		)
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
