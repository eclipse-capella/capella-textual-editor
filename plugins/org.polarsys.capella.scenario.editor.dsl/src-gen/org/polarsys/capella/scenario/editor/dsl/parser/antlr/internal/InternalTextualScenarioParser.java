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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTextualScenarioParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'scenario'", "'{'", "'}'", "'actor'", "'component'", "'unset'", "'behavior'", "'node'", "'configuration_item'", "'function'", "'activity'", "'entity'", "'role'", "'->'", "'withExecution'", "'withReturn'", "':'", "'->+'", "'->x'", "'->>'", "'deactivate'", "'ref'", "'over'", "'alt'", "'else'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalTextualScenarioParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTextualScenarioParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTextualScenarioParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTextualScenario.g"; }



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




    // $ANTLR start "entryRuleModel"
    // InternalTextualScenario.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalTextualScenario.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalTextualScenario.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalTextualScenario.g:71:1: ruleModel returns [EObject current=null] : (otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant ) )* ( ( (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment ) ) )* ( (lv_end_4_0= '}' ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_begin_1_0=null;
        Token lv_end_4_0=null;
        EObject lv_participants_2_0 = null;

        EObject lv_elements_3_1 = null;

        EObject lv_elements_3_2 = null;

        EObject lv_elements_3_3 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:77:2: ( (otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant ) )* ( ( (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment ) ) )* ( (lv_end_4_0= '}' ) ) ) )
            // InternalTextualScenario.g:78:2: (otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant ) )* ( ( (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment ) ) )* ( (lv_end_4_0= '}' ) ) )
            {
            // InternalTextualScenario.g:78:2: (otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant ) )* ( ( (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment ) ) )* ( (lv_end_4_0= '}' ) ) )
            // InternalTextualScenario.g:79:3: otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant ) )* ( ( (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment ) ) )* ( (lv_end_4_0= '}' ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getModelAccess().getScenarioKeyword_0());
            		
            // InternalTextualScenario.g:83:3: ( (lv_begin_1_0= '{' ) )
            // InternalTextualScenario.g:84:4: (lv_begin_1_0= '{' )
            {
            // InternalTextualScenario.g:84:4: (lv_begin_1_0= '{' )
            // InternalTextualScenario.g:85:5: lv_begin_1_0= '{'
            {
            lv_begin_1_0=(Token)match(input,12,FOLLOW_4); 

            					newLeafNode(lv_begin_1_0, grammarAccess.getModelAccess().getBeginLeftCurlyBracketKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(current, "begin", lv_begin_1_0, "{");
            				

            }


            }

            // InternalTextualScenario.g:97:3: ( (lv_participants_2_0= ruleParticipant ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=14 && LA1_0<=15)||(LA1_0>=19 && LA1_0<=23)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTextualScenario.g:98:4: (lv_participants_2_0= ruleParticipant )
            	    {
            	    // InternalTextualScenario.g:98:4: (lv_participants_2_0= ruleParticipant )
            	    // InternalTextualScenario.g:99:5: lv_participants_2_0= ruleParticipant
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getParticipantsParticipantParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_participants_2_0=ruleParticipant();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"participants",
            	    						lv_participants_2_0,
            	    						"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Participant");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalTextualScenario.g:116:3: ( ( (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_STRING||(LA3_0>=30 && LA3_0<=32)||LA3_0==34) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalTextualScenario.g:117:4: ( (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment ) )
            	    {
            	    // InternalTextualScenario.g:117:4: ( (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment ) )
            	    // InternalTextualScenario.g:118:5: (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment )
            	    {
            	    // InternalTextualScenario.g:118:5: (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment )
            	    int alt2=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_STRING:
            	    case 30:
            	    case 31:
            	        {
            	        alt2=1;
            	        }
            	        break;
            	    case 32:
            	        {
            	        alt2=2;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt2=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt2) {
            	        case 1 :
            	            // InternalTextualScenario.g:119:6: lv_elements_3_1= ruleMessage
            	            {

            	            						newCompositeNode(grammarAccess.getModelAccess().getElementsMessageParserRuleCall_3_0_0());
            	            					
            	            pushFollow(FOLLOW_5);
            	            lv_elements_3_1=ruleMessage();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getModelRule());
            	            						}
            	            						add(
            	            							current,
            	            							"elements",
            	            							lv_elements_3_1,
            	            							"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Message");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // InternalTextualScenario.g:135:6: lv_elements_3_2= ruleReference
            	            {

            	            						newCompositeNode(grammarAccess.getModelAccess().getElementsReferenceParserRuleCall_3_0_1());
            	            					
            	            pushFollow(FOLLOW_5);
            	            lv_elements_3_2=ruleReference();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getModelRule());
            	            						}
            	            						add(
            	            							current,
            	            							"elements",
            	            							lv_elements_3_2,
            	            							"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Reference");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;
            	        case 3 :
            	            // InternalTextualScenario.g:151:6: lv_elements_3_3= ruleCombinedFragment
            	            {

            	            						newCompositeNode(grammarAccess.getModelAccess().getElementsCombinedFragmentParserRuleCall_3_0_2());
            	            					
            	            pushFollow(FOLLOW_5);
            	            lv_elements_3_3=ruleCombinedFragment();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getModelRule());
            	            						}
            	            						add(
            	            							current,
            	            							"elements",
            	            							lv_elements_3_3,
            	            							"org.polarsys.capella.scenario.editor.dsl.TextualScenario.CombinedFragment");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalTextualScenario.g:169:3: ( (lv_end_4_0= '}' ) )
            // InternalTextualScenario.g:170:4: (lv_end_4_0= '}' )
            {
            // InternalTextualScenario.g:170:4: (lv_end_4_0= '}' )
            // InternalTextualScenario.g:171:5: lv_end_4_0= '}'
            {
            lv_end_4_0=(Token)match(input,13,FOLLOW_2); 

            					newLeafNode(lv_end_4_0, grammarAccess.getModelAccess().getEndRightCurlyBracketKeyword_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(current, "end", lv_end_4_0, "}");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleParticipant"
    // InternalTextualScenario.g:187:1: entryRuleParticipant returns [EObject current=null] : iv_ruleParticipant= ruleParticipant EOF ;
    public final EObject entryRuleParticipant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParticipant = null;


        try {
            // InternalTextualScenario.g:187:52: (iv_ruleParticipant= ruleParticipant EOF )
            // InternalTextualScenario.g:188:2: iv_ruleParticipant= ruleParticipant EOF
            {
             newCompositeNode(grammarAccess.getParticipantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParticipant=ruleParticipant();

            state._fsp--;

             current =iv_ruleParticipant; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParticipant"


    // $ANTLR start "ruleParticipant"
    // InternalTextualScenario.g:194:1: ruleParticipant returns [EObject current=null] : (this_GenericComponent_0= ruleGenericComponent | this_GenericFunction_1= ruleGenericFunction ) ;
    public final EObject ruleParticipant() throws RecognitionException {
        EObject current = null;

        EObject this_GenericComponent_0 = null;

        EObject this_GenericFunction_1 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:200:2: ( (this_GenericComponent_0= ruleGenericComponent | this_GenericFunction_1= ruleGenericFunction ) )
            // InternalTextualScenario.g:201:2: (this_GenericComponent_0= ruleGenericComponent | this_GenericFunction_1= ruleGenericFunction )
            {
            // InternalTextualScenario.g:201:2: (this_GenericComponent_0= ruleGenericComponent | this_GenericFunction_1= ruleGenericFunction )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=14 && LA4_0<=15)||LA4_0==19||(LA4_0>=22 && LA4_0<=23)) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=20 && LA4_0<=21)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalTextualScenario.g:202:3: this_GenericComponent_0= ruleGenericComponent
                    {

                    			newCompositeNode(grammarAccess.getParticipantAccess().getGenericComponentParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_GenericComponent_0=ruleGenericComponent();

                    state._fsp--;


                    			current = this_GenericComponent_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:211:3: this_GenericFunction_1= ruleGenericFunction
                    {

                    			newCompositeNode(grammarAccess.getParticipantAccess().getGenericFunctionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_GenericFunction_1=ruleGenericFunction();

                    state._fsp--;


                    			current = this_GenericFunction_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParticipant"


    // $ANTLR start "entryRuleGenericComponent"
    // InternalTextualScenario.g:223:1: entryRuleGenericComponent returns [EObject current=null] : iv_ruleGenericComponent= ruleGenericComponent EOF ;
    public final EObject entryRuleGenericComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenericComponent = null;


        try {
            // InternalTextualScenario.g:223:57: (iv_ruleGenericComponent= ruleGenericComponent EOF )
            // InternalTextualScenario.g:224:2: iv_ruleGenericComponent= ruleGenericComponent EOF
            {
             newCompositeNode(grammarAccess.getGenericComponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGenericComponent=ruleGenericComponent();

            state._fsp--;

             current =iv_ruleGenericComponent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGenericComponent"


    // $ANTLR start "ruleGenericComponent"
    // InternalTextualScenario.g:230:1: ruleGenericComponent returns [EObject current=null] : (this_Entity_0= ruleEntity | this_Actor_1= ruleActor | this_Component_2= ruleComponent | this_ConfigurationItem_3= ruleConfigurationItem | this_Role_4= ruleRole ) ;
    public final EObject ruleGenericComponent() throws RecognitionException {
        EObject current = null;

        EObject this_Entity_0 = null;

        EObject this_Actor_1 = null;

        EObject this_Component_2 = null;

        EObject this_ConfigurationItem_3 = null;

        EObject this_Role_4 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:236:2: ( (this_Entity_0= ruleEntity | this_Actor_1= ruleActor | this_Component_2= ruleComponent | this_ConfigurationItem_3= ruleConfigurationItem | this_Role_4= ruleRole ) )
            // InternalTextualScenario.g:237:2: (this_Entity_0= ruleEntity | this_Actor_1= ruleActor | this_Component_2= ruleComponent | this_ConfigurationItem_3= ruleConfigurationItem | this_Role_4= ruleRole )
            {
            // InternalTextualScenario.g:237:2: (this_Entity_0= ruleEntity | this_Actor_1= ruleActor | this_Component_2= ruleComponent | this_ConfigurationItem_3= ruleConfigurationItem | this_Role_4= ruleRole )
            int alt5=5;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt5=1;
                }
                break;
            case 14:
                {
                alt5=2;
                }
                break;
            case 15:
                {
                alt5=3;
                }
                break;
            case 19:
                {
                alt5=4;
                }
                break;
            case 23:
                {
                alt5=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalTextualScenario.g:238:3: this_Entity_0= ruleEntity
                    {

                    			newCompositeNode(grammarAccess.getGenericComponentAccess().getEntityParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Entity_0=ruleEntity();

                    state._fsp--;


                    			current = this_Entity_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:247:3: this_Actor_1= ruleActor
                    {

                    			newCompositeNode(grammarAccess.getGenericComponentAccess().getActorParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Actor_1=ruleActor();

                    state._fsp--;


                    			current = this_Actor_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:256:3: this_Component_2= ruleComponent
                    {

                    			newCompositeNode(grammarAccess.getGenericComponentAccess().getComponentParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Component_2=ruleComponent();

                    state._fsp--;


                    			current = this_Component_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalTextualScenario.g:265:3: this_ConfigurationItem_3= ruleConfigurationItem
                    {

                    			newCompositeNode(grammarAccess.getGenericComponentAccess().getConfigurationItemParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConfigurationItem_3=ruleConfigurationItem();

                    state._fsp--;


                    			current = this_ConfigurationItem_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalTextualScenario.g:274:3: this_Role_4= ruleRole
                    {

                    			newCompositeNode(grammarAccess.getGenericComponentAccess().getRoleParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Role_4=ruleRole();

                    state._fsp--;


                    			current = this_Role_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGenericComponent"


    // $ANTLR start "entryRuleGenericFunction"
    // InternalTextualScenario.g:286:1: entryRuleGenericFunction returns [EObject current=null] : iv_ruleGenericFunction= ruleGenericFunction EOF ;
    public final EObject entryRuleGenericFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenericFunction = null;


        try {
            // InternalTextualScenario.g:286:56: (iv_ruleGenericFunction= ruleGenericFunction EOF )
            // InternalTextualScenario.g:287:2: iv_ruleGenericFunction= ruleGenericFunction EOF
            {
             newCompositeNode(grammarAccess.getGenericFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGenericFunction=ruleGenericFunction();

            state._fsp--;

             current =iv_ruleGenericFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGenericFunction"


    // $ANTLR start "ruleGenericFunction"
    // InternalTextualScenario.g:293:1: ruleGenericFunction returns [EObject current=null] : (this_Function_0= ruleFunction | this_Activity_1= ruleActivity ) ;
    public final EObject ruleGenericFunction() throws RecognitionException {
        EObject current = null;

        EObject this_Function_0 = null;

        EObject this_Activity_1 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:299:2: ( (this_Function_0= ruleFunction | this_Activity_1= ruleActivity ) )
            // InternalTextualScenario.g:300:2: (this_Function_0= ruleFunction | this_Activity_1= ruleActivity )
            {
            // InternalTextualScenario.g:300:2: (this_Function_0= ruleFunction | this_Activity_1= ruleActivity )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            else if ( (LA6_0==21) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalTextualScenario.g:301:3: this_Function_0= ruleFunction
                    {

                    			newCompositeNode(grammarAccess.getGenericFunctionAccess().getFunctionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Function_0=ruleFunction();

                    state._fsp--;


                    			current = this_Function_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:310:3: this_Activity_1= ruleActivity
                    {

                    			newCompositeNode(grammarAccess.getGenericFunctionAccess().getActivityParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Activity_1=ruleActivity();

                    state._fsp--;


                    			current = this_Activity_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGenericFunction"


    // $ANTLR start "entryRuleActor"
    // InternalTextualScenario.g:322:1: entryRuleActor returns [EObject current=null] : iv_ruleActor= ruleActor EOF ;
    public final EObject entryRuleActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActor = null;


        try {
            // InternalTextualScenario.g:322:46: (iv_ruleActor= ruleActor EOF )
            // InternalTextualScenario.g:323:2: iv_ruleActor= ruleActor EOF
            {
             newCompositeNode(grammarAccess.getActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActor=ruleActor();

            state._fsp--;

             current =iv_ruleActor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActor"


    // $ANTLR start "ruleActor"
    // InternalTextualScenario.g:329:1: ruleActor returns [EObject current=null] : ( ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleActor() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:335:2: ( ( ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:336:2: ( ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:336:2: ( ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:337:3: ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:337:3: ( (lv_keyword_0_0= 'actor' ) )
            // InternalTextualScenario.g:338:4: (lv_keyword_0_0= 'actor' )
            {
            // InternalTextualScenario.g:338:4: (lv_keyword_0_0= 'actor' )
            // InternalTextualScenario.g:339:5: lv_keyword_0_0= 'actor'
            {
            lv_keyword_0_0=(Token)match(input,14,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getActorAccess().getKeywordActorKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActorRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "actor");
            				

            }


            }

            // InternalTextualScenario.g:351:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:352:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:352:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:353:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getActorAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActor"


    // $ANTLR start "entryRuleComponent"
    // InternalTextualScenario.g:373:1: entryRuleComponent returns [EObject current=null] : iv_ruleComponent= ruleComponent EOF ;
    public final EObject entryRuleComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponent = null;


        try {
            // InternalTextualScenario.g:373:50: (iv_ruleComponent= ruleComponent EOF )
            // InternalTextualScenario.g:374:2: iv_ruleComponent= ruleComponent EOF
            {
             newCompositeNode(grammarAccess.getComponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponent=ruleComponent();

            state._fsp--;

             current =iv_ruleComponent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponent"


    // $ANTLR start "ruleComponent"
    // InternalTextualScenario.g:380:1: ruleComponent returns [EObject current=null] : ( ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )? ) ;
    public final EObject ruleComponent() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;
        Token lv_nature_2_1=null;
        Token lv_nature_2_2=null;
        Token lv_nature_2_3=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:386:2: ( ( ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )? ) )
            // InternalTextualScenario.g:387:2: ( ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )? )
            {
            // InternalTextualScenario.g:387:2: ( ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )? )
            // InternalTextualScenario.g:388:3: ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )?
            {
            // InternalTextualScenario.g:388:3: ( (lv_keyword_0_0= 'component' ) )
            // InternalTextualScenario.g:389:4: (lv_keyword_0_0= 'component' )
            {
            // InternalTextualScenario.g:389:4: (lv_keyword_0_0= 'component' )
            // InternalTextualScenario.g:390:5: lv_keyword_0_0= 'component'
            {
            lv_keyword_0_0=(Token)match(input,15,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "component");
            				

            }


            }

            // InternalTextualScenario.g:402:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:403:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:403:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:404:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_name_1_0, grammarAccess.getComponentAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalTextualScenario.g:420:3: ( ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=16 && LA8_0<=18)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalTextualScenario.g:421:4: ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) )
                    {
                    // InternalTextualScenario.g:421:4: ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) )
                    // InternalTextualScenario.g:422:5: (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' )
                    {
                    // InternalTextualScenario.g:422:5: (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' )
                    int alt7=3;
                    switch ( input.LA(1) ) {
                    case 16:
                        {
                        alt7=1;
                        }
                        break;
                    case 17:
                        {
                        alt7=2;
                        }
                        break;
                    case 18:
                        {
                        alt7=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;
                    }

                    switch (alt7) {
                        case 1 :
                            // InternalTextualScenario.g:423:6: lv_nature_2_1= 'unset'
                            {
                            lv_nature_2_1=(Token)match(input,16,FOLLOW_2); 

                            						newLeafNode(lv_nature_2_1, grammarAccess.getComponentAccess().getNatureUnsetKeyword_2_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getComponentRule());
                            						}
                            						setWithLastConsumed(current, "nature", lv_nature_2_1, null);
                            					

                            }
                            break;
                        case 2 :
                            // InternalTextualScenario.g:434:6: lv_nature_2_2= 'behavior'
                            {
                            lv_nature_2_2=(Token)match(input,17,FOLLOW_2); 

                            						newLeafNode(lv_nature_2_2, grammarAccess.getComponentAccess().getNatureBehaviorKeyword_2_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getComponentRule());
                            						}
                            						setWithLastConsumed(current, "nature", lv_nature_2_2, null);
                            					

                            }
                            break;
                        case 3 :
                            // InternalTextualScenario.g:445:6: lv_nature_2_3= 'node'
                            {
                            lv_nature_2_3=(Token)match(input,18,FOLLOW_2); 

                            						newLeafNode(lv_nature_2_3, grammarAccess.getComponentAccess().getNatureNodeKeyword_2_0_2());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getComponentRule());
                            						}
                            						setWithLastConsumed(current, "nature", lv_nature_2_3, null);
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponent"


    // $ANTLR start "entryRuleConfigurationItem"
    // InternalTextualScenario.g:462:1: entryRuleConfigurationItem returns [EObject current=null] : iv_ruleConfigurationItem= ruleConfigurationItem EOF ;
    public final EObject entryRuleConfigurationItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigurationItem = null;


        try {
            // InternalTextualScenario.g:462:58: (iv_ruleConfigurationItem= ruleConfigurationItem EOF )
            // InternalTextualScenario.g:463:2: iv_ruleConfigurationItem= ruleConfigurationItem EOF
            {
             newCompositeNode(grammarAccess.getConfigurationItemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConfigurationItem=ruleConfigurationItem();

            state._fsp--;

             current =iv_ruleConfigurationItem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConfigurationItem"


    // $ANTLR start "ruleConfigurationItem"
    // InternalTextualScenario.g:469:1: ruleConfigurationItem returns [EObject current=null] : ( ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleConfigurationItem() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:475:2: ( ( ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:476:2: ( ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:476:2: ( ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:477:3: ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:477:3: ( (lv_keyword_0_0= 'configuration_item' ) )
            // InternalTextualScenario.g:478:4: (lv_keyword_0_0= 'configuration_item' )
            {
            // InternalTextualScenario.g:478:4: (lv_keyword_0_0= 'configuration_item' )
            // InternalTextualScenario.g:479:5: lv_keyword_0_0= 'configuration_item'
            {
            lv_keyword_0_0=(Token)match(input,19,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConfigurationItemRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "configuration_item");
            				

            }


            }

            // InternalTextualScenario.g:491:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:492:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:492:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:493:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getConfigurationItemAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConfigurationItemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConfigurationItem"


    // $ANTLR start "entryRuleFunction"
    // InternalTextualScenario.g:513:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalTextualScenario.g:513:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalTextualScenario.g:514:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalTextualScenario.g:520:1: ruleFunction returns [EObject current=null] : ( ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:526:2: ( ( ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:527:2: ( ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:527:2: ( ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:528:3: ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:528:3: ( (lv_keyword_0_0= 'function' ) )
            // InternalTextualScenario.g:529:4: (lv_keyword_0_0= 'function' )
            {
            // InternalTextualScenario.g:529:4: (lv_keyword_0_0= 'function' )
            // InternalTextualScenario.g:530:5: lv_keyword_0_0= 'function'
            {
            lv_keyword_0_0=(Token)match(input,20,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "function");
            				

            }


            }

            // InternalTextualScenario.g:542:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:543:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:543:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:544:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFunctionAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleActivity"
    // InternalTextualScenario.g:564:1: entryRuleActivity returns [EObject current=null] : iv_ruleActivity= ruleActivity EOF ;
    public final EObject entryRuleActivity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActivity = null;


        try {
            // InternalTextualScenario.g:564:49: (iv_ruleActivity= ruleActivity EOF )
            // InternalTextualScenario.g:565:2: iv_ruleActivity= ruleActivity EOF
            {
             newCompositeNode(grammarAccess.getActivityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActivity=ruleActivity();

            state._fsp--;

             current =iv_ruleActivity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActivity"


    // $ANTLR start "ruleActivity"
    // InternalTextualScenario.g:571:1: ruleActivity returns [EObject current=null] : ( ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleActivity() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:577:2: ( ( ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:578:2: ( ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:578:2: ( ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:579:3: ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:579:3: ( (lv_keyword_0_0= 'activity' ) )
            // InternalTextualScenario.g:580:4: (lv_keyword_0_0= 'activity' )
            {
            // InternalTextualScenario.g:580:4: (lv_keyword_0_0= 'activity' )
            // InternalTextualScenario.g:581:5: lv_keyword_0_0= 'activity'
            {
            lv_keyword_0_0=(Token)match(input,21,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActivityRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "activity");
            				

            }


            }

            // InternalTextualScenario.g:593:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:594:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:594:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:595:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getActivityAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActivityRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActivity"


    // $ANTLR start "entryRuleEntity"
    // InternalTextualScenario.g:615:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalTextualScenario.g:615:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalTextualScenario.g:616:2: iv_ruleEntity= ruleEntity EOF
            {
             newCompositeNode(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalTextualScenario.g:622:1: ruleEntity returns [EObject current=null] : ( ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:628:2: ( ( ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:629:2: ( ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:629:2: ( ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:630:3: ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:630:3: ( (lv_keyword_0_0= 'entity' ) )
            // InternalTextualScenario.g:631:4: (lv_keyword_0_0= 'entity' )
            {
            // InternalTextualScenario.g:631:4: (lv_keyword_0_0= 'entity' )
            // InternalTextualScenario.g:632:5: lv_keyword_0_0= 'entity'
            {
            lv_keyword_0_0=(Token)match(input,22,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "entity");
            				

            }


            }

            // InternalTextualScenario.g:644:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:645:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:645:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:646:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEntityAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleRole"
    // InternalTextualScenario.g:666:1: entryRuleRole returns [EObject current=null] : iv_ruleRole= ruleRole EOF ;
    public final EObject entryRuleRole() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRole = null;


        try {
            // InternalTextualScenario.g:666:45: (iv_ruleRole= ruleRole EOF )
            // InternalTextualScenario.g:667:2: iv_ruleRole= ruleRole EOF
            {
             newCompositeNode(grammarAccess.getRoleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRole=ruleRole();

            state._fsp--;

             current =iv_ruleRole; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRole"


    // $ANTLR start "ruleRole"
    // InternalTextualScenario.g:673:1: ruleRole returns [EObject current=null] : ( ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleRole() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:679:2: ( ( ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:680:2: ( ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:680:2: ( ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:681:3: ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:681:3: ( (lv_keyword_0_0= 'role' ) )
            // InternalTextualScenario.g:682:4: (lv_keyword_0_0= 'role' )
            {
            // InternalTextualScenario.g:682:4: (lv_keyword_0_0= 'role' )
            // InternalTextualScenario.g:683:5: lv_keyword_0_0= 'role'
            {
            lv_keyword_0_0=(Token)match(input,23,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRoleRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "role");
            				

            }


            }

            // InternalTextualScenario.g:695:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:696:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:696:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:697:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getRoleAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRoleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRole"


    // $ANTLR start "entryRuleMessage"
    // InternalTextualScenario.g:717:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // InternalTextualScenario.g:717:48: (iv_ruleMessage= ruleMessage EOF )
            // InternalTextualScenario.g:718:2: iv_ruleMessage= ruleMessage EOF
            {
             newCompositeNode(grammarAccess.getMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMessage=ruleMessage();

            state._fsp--;

             current =iv_ruleMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessage"


    // $ANTLR start "ruleMessage"
    // InternalTextualScenario.g:724:1: ruleMessage returns [EObject current=null] : (this_SequenceMessageType_0= ruleSequenceMessageType | this_ArmTimerMessage_1= ruleArmTimerMessage | this_ParticipantDeactivation_2= ruleParticipantDeactivation ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        EObject this_SequenceMessageType_0 = null;

        EObject this_ArmTimerMessage_1 = null;

        EObject this_ParticipantDeactivation_2 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:730:2: ( (this_SequenceMessageType_0= ruleSequenceMessageType | this_ArmTimerMessage_1= ruleArmTimerMessage | this_ParticipantDeactivation_2= ruleParticipantDeactivation ) )
            // InternalTextualScenario.g:731:2: (this_SequenceMessageType_0= ruleSequenceMessageType | this_ArmTimerMessage_1= ruleArmTimerMessage | this_ParticipantDeactivation_2= ruleParticipantDeactivation )
            {
            // InternalTextualScenario.g:731:2: (this_SequenceMessageType_0= ruleSequenceMessageType | this_ArmTimerMessage_1= ruleArmTimerMessage | this_ParticipantDeactivation_2= ruleParticipantDeactivation )
            int alt9=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt9=1;
                }
                break;
            case 30:
                {
                alt9=2;
                }
                break;
            case 31:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalTextualScenario.g:732:3: this_SequenceMessageType_0= ruleSequenceMessageType
                    {

                    			newCompositeNode(grammarAccess.getMessageAccess().getSequenceMessageTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SequenceMessageType_0=ruleSequenceMessageType();

                    state._fsp--;


                    			current = this_SequenceMessageType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:741:3: this_ArmTimerMessage_1= ruleArmTimerMessage
                    {

                    			newCompositeNode(grammarAccess.getMessageAccess().getArmTimerMessageParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArmTimerMessage_1=ruleArmTimerMessage();

                    state._fsp--;


                    			current = this_ArmTimerMessage_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:750:3: this_ParticipantDeactivation_2= ruleParticipantDeactivation
                    {

                    			newCompositeNode(grammarAccess.getMessageAccess().getParticipantDeactivationParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParticipantDeactivation_2=ruleParticipantDeactivation();

                    state._fsp--;


                    			current = this_ParticipantDeactivation_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessage"


    // $ANTLR start "entryRuleSequenceMessageType"
    // InternalTextualScenario.g:762:1: entryRuleSequenceMessageType returns [EObject current=null] : iv_ruleSequenceMessageType= ruleSequenceMessageType EOF ;
    public final EObject entryRuleSequenceMessageType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceMessageType = null;


        try {
            // InternalTextualScenario.g:762:60: (iv_ruleSequenceMessageType= ruleSequenceMessageType EOF )
            // InternalTextualScenario.g:763:2: iv_ruleSequenceMessageType= ruleSequenceMessageType EOF
            {
             newCompositeNode(grammarAccess.getSequenceMessageTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSequenceMessageType=ruleSequenceMessageType();

            state._fsp--;

             current =iv_ruleSequenceMessageType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequenceMessageType"


    // $ANTLR start "ruleSequenceMessageType"
    // InternalTextualScenario.g:769:1: ruleSequenceMessageType returns [EObject current=null] : (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage | this_DeleteMessage_2= ruleDeleteMessage ) ;
    public final EObject ruleSequenceMessageType() throws RecognitionException {
        EObject current = null;

        EObject this_SequenceMessage_0 = null;

        EObject this_CreateMessage_1 = null;

        EObject this_DeleteMessage_2 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:775:2: ( (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage | this_DeleteMessage_2= ruleDeleteMessage ) )
            // InternalTextualScenario.g:776:2: (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage | this_DeleteMessage_2= ruleDeleteMessage )
            {
            // InternalTextualScenario.g:776:2: (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage | this_DeleteMessage_2= ruleDeleteMessage )
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_STRING) ) {
                switch ( input.LA(2) ) {
                case 28:
                    {
                    alt10=2;
                    }
                    break;
                case 29:
                    {
                    alt10=3;
                    }
                    break;
                case 24:
                    {
                    alt10=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalTextualScenario.g:777:3: this_SequenceMessage_0= ruleSequenceMessage
                    {

                    			newCompositeNode(grammarAccess.getSequenceMessageTypeAccess().getSequenceMessageParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SequenceMessage_0=ruleSequenceMessage();

                    state._fsp--;


                    			current = this_SequenceMessage_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:786:3: this_CreateMessage_1= ruleCreateMessage
                    {

                    			newCompositeNode(grammarAccess.getSequenceMessageTypeAccess().getCreateMessageParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_CreateMessage_1=ruleCreateMessage();

                    state._fsp--;


                    			current = this_CreateMessage_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:795:3: this_DeleteMessage_2= ruleDeleteMessage
                    {

                    			newCompositeNode(grammarAccess.getSequenceMessageTypeAccess().getDeleteMessageParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_DeleteMessage_2=ruleDeleteMessage();

                    state._fsp--;


                    			current = this_DeleteMessage_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequenceMessageType"


    // $ANTLR start "entryRuleSequenceMessage"
    // InternalTextualScenario.g:807:1: entryRuleSequenceMessage returns [EObject current=null] : iv_ruleSequenceMessage= ruleSequenceMessage EOF ;
    public final EObject entryRuleSequenceMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceMessage = null;


        try {
            // InternalTextualScenario.g:807:56: (iv_ruleSequenceMessage= ruleSequenceMessage EOF )
            // InternalTextualScenario.g:808:2: iv_ruleSequenceMessage= ruleSequenceMessage EOF
            {
             newCompositeNode(grammarAccess.getSequenceMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSequenceMessage=ruleSequenceMessage();

            state._fsp--;

             current =iv_ruleSequenceMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequenceMessage"


    // $ANTLR start "ruleSequenceMessage"
    // InternalTextualScenario.g:814:1: ruleSequenceMessage returns [EObject current=null] : ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->' ( (lv_target_2_0= RULE_STRING ) ) ( (lv_execution_3_0= 'withExecution' ) )? ( (lv_return_4_0= 'withReturn' ) )? otherlv_5= ':' ( (lv_name_6_0= RULE_STRING ) ) ) ;
    public final EObject ruleSequenceMessage() throws RecognitionException {
        EObject current = null;

        Token lv_source_0_0=null;
        Token otherlv_1=null;
        Token lv_target_2_0=null;
        Token lv_execution_3_0=null;
        Token lv_return_4_0=null;
        Token otherlv_5=null;
        Token lv_name_6_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:820:2: ( ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->' ( (lv_target_2_0= RULE_STRING ) ) ( (lv_execution_3_0= 'withExecution' ) )? ( (lv_return_4_0= 'withReturn' ) )? otherlv_5= ':' ( (lv_name_6_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:821:2: ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->' ( (lv_target_2_0= RULE_STRING ) ) ( (lv_execution_3_0= 'withExecution' ) )? ( (lv_return_4_0= 'withReturn' ) )? otherlv_5= ':' ( (lv_name_6_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:821:2: ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->' ( (lv_target_2_0= RULE_STRING ) ) ( (lv_execution_3_0= 'withExecution' ) )? ( (lv_return_4_0= 'withReturn' ) )? otherlv_5= ':' ( (lv_name_6_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:822:3: ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->' ( (lv_target_2_0= RULE_STRING ) ) ( (lv_execution_3_0= 'withExecution' ) )? ( (lv_return_4_0= 'withReturn' ) )? otherlv_5= ':' ( (lv_name_6_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:822:3: ( (lv_source_0_0= RULE_STRING ) )
            // InternalTextualScenario.g:823:4: (lv_source_0_0= RULE_STRING )
            {
            // InternalTextualScenario.g:823:4: (lv_source_0_0= RULE_STRING )
            // InternalTextualScenario.g:824:5: lv_source_0_0= RULE_STRING
            {
            lv_source_0_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(lv_source_0_0, grammarAccess.getSequenceMessageAccess().getSourceSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSequenceMessageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"source",
            						lv_source_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getSequenceMessageAccess().getHyphenMinusGreaterThanSignKeyword_1());
            		
            // InternalTextualScenario.g:844:3: ( (lv_target_2_0= RULE_STRING ) )
            // InternalTextualScenario.g:845:4: (lv_target_2_0= RULE_STRING )
            {
            // InternalTextualScenario.g:845:4: (lv_target_2_0= RULE_STRING )
            // InternalTextualScenario.g:846:5: lv_target_2_0= RULE_STRING
            {
            lv_target_2_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

            					newLeafNode(lv_target_2_0, grammarAccess.getSequenceMessageAccess().getTargetSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSequenceMessageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"target",
            						lv_target_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalTextualScenario.g:862:3: ( (lv_execution_3_0= 'withExecution' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTextualScenario.g:863:4: (lv_execution_3_0= 'withExecution' )
                    {
                    // InternalTextualScenario.g:863:4: (lv_execution_3_0= 'withExecution' )
                    // InternalTextualScenario.g:864:5: lv_execution_3_0= 'withExecution'
                    {
                    lv_execution_3_0=(Token)match(input,25,FOLLOW_10); 

                    					newLeafNode(lv_execution_3_0, grammarAccess.getSequenceMessageAccess().getExecutionWithExecutionKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSequenceMessageRule());
                    					}
                    					setWithLastConsumed(current, "execution", lv_execution_3_0, "withExecution");
                    				

                    }


                    }
                    break;

            }

            // InternalTextualScenario.g:876:3: ( (lv_return_4_0= 'withReturn' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==26) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalTextualScenario.g:877:4: (lv_return_4_0= 'withReturn' )
                    {
                    // InternalTextualScenario.g:877:4: (lv_return_4_0= 'withReturn' )
                    // InternalTextualScenario.g:878:5: lv_return_4_0= 'withReturn'
                    {
                    lv_return_4_0=(Token)match(input,26,FOLLOW_11); 

                    					newLeafNode(lv_return_4_0, grammarAccess.getSequenceMessageAccess().getReturnWithReturnKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSequenceMessageRule());
                    					}
                    					setWithLastConsumed(current, "return", lv_return_4_0, "withReturn");
                    				

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,27,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getSequenceMessageAccess().getColonKeyword_5());
            		
            // InternalTextualScenario.g:894:3: ( (lv_name_6_0= RULE_STRING ) )
            // InternalTextualScenario.g:895:4: (lv_name_6_0= RULE_STRING )
            {
            // InternalTextualScenario.g:895:4: (lv_name_6_0= RULE_STRING )
            // InternalTextualScenario.g:896:5: lv_name_6_0= RULE_STRING
            {
            lv_name_6_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_6_0, grammarAccess.getSequenceMessageAccess().getNameSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSequenceMessageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequenceMessage"


    // $ANTLR start "entryRuleCreateMessage"
    // InternalTextualScenario.g:916:1: entryRuleCreateMessage returns [EObject current=null] : iv_ruleCreateMessage= ruleCreateMessage EOF ;
    public final EObject entryRuleCreateMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreateMessage = null;


        try {
            // InternalTextualScenario.g:916:54: (iv_ruleCreateMessage= ruleCreateMessage EOF )
            // InternalTextualScenario.g:917:2: iv_ruleCreateMessage= ruleCreateMessage EOF
            {
             newCompositeNode(grammarAccess.getCreateMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCreateMessage=ruleCreateMessage();

            state._fsp--;

             current =iv_ruleCreateMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCreateMessage"


    // $ANTLR start "ruleCreateMessage"
    // InternalTextualScenario.g:923:1: ruleCreateMessage returns [EObject current=null] : ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->+' ( (lv_target_2_0= RULE_STRING ) ) otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleCreateMessage() throws RecognitionException {
        EObject current = null;

        Token lv_source_0_0=null;
        Token otherlv_1=null;
        Token lv_target_2_0=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:929:2: ( ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->+' ( (lv_target_2_0= RULE_STRING ) ) otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:930:2: ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->+' ( (lv_target_2_0= RULE_STRING ) ) otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:930:2: ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->+' ( (lv_target_2_0= RULE_STRING ) ) otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:931:3: ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->+' ( (lv_target_2_0= RULE_STRING ) ) otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:931:3: ( (lv_source_0_0= RULE_STRING ) )
            // InternalTextualScenario.g:932:4: (lv_source_0_0= RULE_STRING )
            {
            // InternalTextualScenario.g:932:4: (lv_source_0_0= RULE_STRING )
            // InternalTextualScenario.g:933:5: lv_source_0_0= RULE_STRING
            {
            lv_source_0_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            					newLeafNode(lv_source_0_0, grammarAccess.getCreateMessageAccess().getSourceSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCreateMessageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"source",
            						lv_source_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getCreateMessageAccess().getHyphenMinusGreaterThanSignPlusSignKeyword_1());
            		
            // InternalTextualScenario.g:953:3: ( (lv_target_2_0= RULE_STRING ) )
            // InternalTextualScenario.g:954:4: (lv_target_2_0= RULE_STRING )
            {
            // InternalTextualScenario.g:954:4: (lv_target_2_0= RULE_STRING )
            // InternalTextualScenario.g:955:5: lv_target_2_0= RULE_STRING
            {
            lv_target_2_0=(Token)match(input,RULE_STRING,FOLLOW_11); 

            					newLeafNode(lv_target_2_0, grammarAccess.getCreateMessageAccess().getTargetSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCreateMessageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"target",
            						lv_target_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getCreateMessageAccess().getColonKeyword_3());
            		
            // InternalTextualScenario.g:975:3: ( (lv_name_4_0= RULE_STRING ) )
            // InternalTextualScenario.g:976:4: (lv_name_4_0= RULE_STRING )
            {
            // InternalTextualScenario.g:976:4: (lv_name_4_0= RULE_STRING )
            // InternalTextualScenario.g:977:5: lv_name_4_0= RULE_STRING
            {
            lv_name_4_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_4_0, grammarAccess.getCreateMessageAccess().getNameSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCreateMessageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCreateMessage"


    // $ANTLR start "entryRuleDeleteMessage"
    // InternalTextualScenario.g:997:1: entryRuleDeleteMessage returns [EObject current=null] : iv_ruleDeleteMessage= ruleDeleteMessage EOF ;
    public final EObject entryRuleDeleteMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeleteMessage = null;


        try {
            // InternalTextualScenario.g:997:54: (iv_ruleDeleteMessage= ruleDeleteMessage EOF )
            // InternalTextualScenario.g:998:2: iv_ruleDeleteMessage= ruleDeleteMessage EOF
            {
             newCompositeNode(grammarAccess.getDeleteMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeleteMessage=ruleDeleteMessage();

            state._fsp--;

             current =iv_ruleDeleteMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeleteMessage"


    // $ANTLR start "ruleDeleteMessage"
    // InternalTextualScenario.g:1004:1: ruleDeleteMessage returns [EObject current=null] : ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->x' ( (lv_target_2_0= RULE_STRING ) ) otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleDeleteMessage() throws RecognitionException {
        EObject current = null;

        Token lv_source_0_0=null;
        Token otherlv_1=null;
        Token lv_target_2_0=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:1010:2: ( ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->x' ( (lv_target_2_0= RULE_STRING ) ) otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:1011:2: ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->x' ( (lv_target_2_0= RULE_STRING ) ) otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:1011:2: ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->x' ( (lv_target_2_0= RULE_STRING ) ) otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:1012:3: ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->x' ( (lv_target_2_0= RULE_STRING ) ) otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:1012:3: ( (lv_source_0_0= RULE_STRING ) )
            // InternalTextualScenario.g:1013:4: (lv_source_0_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1013:4: (lv_source_0_0= RULE_STRING )
            // InternalTextualScenario.g:1014:5: lv_source_0_0= RULE_STRING
            {
            lv_source_0_0=(Token)match(input,RULE_STRING,FOLLOW_13); 

            					newLeafNode(lv_source_0_0, grammarAccess.getDeleteMessageAccess().getSourceSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeleteMessageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"source",
            						lv_source_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getDeleteMessageAccess().getXKeyword_1());
            		
            // InternalTextualScenario.g:1034:3: ( (lv_target_2_0= RULE_STRING ) )
            // InternalTextualScenario.g:1035:4: (lv_target_2_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1035:4: (lv_target_2_0= RULE_STRING )
            // InternalTextualScenario.g:1036:5: lv_target_2_0= RULE_STRING
            {
            lv_target_2_0=(Token)match(input,RULE_STRING,FOLLOW_11); 

            					newLeafNode(lv_target_2_0, grammarAccess.getDeleteMessageAccess().getTargetSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeleteMessageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"target",
            						lv_target_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getDeleteMessageAccess().getColonKeyword_3());
            		
            // InternalTextualScenario.g:1056:3: ( (lv_name_4_0= RULE_STRING ) )
            // InternalTextualScenario.g:1057:4: (lv_name_4_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1057:4: (lv_name_4_0= RULE_STRING )
            // InternalTextualScenario.g:1058:5: lv_name_4_0= RULE_STRING
            {
            lv_name_4_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_4_0, grammarAccess.getDeleteMessageAccess().getNameSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeleteMessageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeleteMessage"


    // $ANTLR start "entryRuleArmTimerMessage"
    // InternalTextualScenario.g:1078:1: entryRuleArmTimerMessage returns [EObject current=null] : iv_ruleArmTimerMessage= ruleArmTimerMessage EOF ;
    public final EObject entryRuleArmTimerMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArmTimerMessage = null;


        try {
            // InternalTextualScenario.g:1078:56: (iv_ruleArmTimerMessage= ruleArmTimerMessage EOF )
            // InternalTextualScenario.g:1079:2: iv_ruleArmTimerMessage= ruleArmTimerMessage EOF
            {
             newCompositeNode(grammarAccess.getArmTimerMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArmTimerMessage=ruleArmTimerMessage();

            state._fsp--;

             current =iv_ruleArmTimerMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArmTimerMessage"


    // $ANTLR start "ruleArmTimerMessage"
    // InternalTextualScenario.g:1085:1: ruleArmTimerMessage returns [EObject current=null] : (otherlv_0= '->>' ( (lv_participant_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_name_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleArmTimerMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_participant_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:1091:2: ( (otherlv_0= '->>' ( (lv_participant_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_name_3_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:1092:2: (otherlv_0= '->>' ( (lv_participant_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_name_3_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:1092:2: (otherlv_0= '->>' ( (lv_participant_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_name_3_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:1093:3: otherlv_0= '->>' ( (lv_participant_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_name_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getArmTimerMessageAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_0());
            		
            // InternalTextualScenario.g:1097:3: ( (lv_participant_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:1098:4: (lv_participant_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1098:4: (lv_participant_1_0= RULE_STRING )
            // InternalTextualScenario.g:1099:5: lv_participant_1_0= RULE_STRING
            {
            lv_participant_1_0=(Token)match(input,RULE_STRING,FOLLOW_11); 

            					newLeafNode(lv_participant_1_0, grammarAccess.getArmTimerMessageAccess().getParticipantSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArmTimerMessageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"participant",
            						lv_participant_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getArmTimerMessageAccess().getColonKeyword_2());
            		
            // InternalTextualScenario.g:1119:3: ( (lv_name_3_0= RULE_STRING ) )
            // InternalTextualScenario.g:1120:4: (lv_name_3_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1120:4: (lv_name_3_0= RULE_STRING )
            // InternalTextualScenario.g:1121:5: lv_name_3_0= RULE_STRING
            {
            lv_name_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_3_0, grammarAccess.getArmTimerMessageAccess().getNameSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArmTimerMessageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArmTimerMessage"


    // $ANTLR start "entryRuleParticipantDeactivation"
    // InternalTextualScenario.g:1141:1: entryRuleParticipantDeactivation returns [EObject current=null] : iv_ruleParticipantDeactivation= ruleParticipantDeactivation EOF ;
    public final EObject entryRuleParticipantDeactivation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParticipantDeactivation = null;


        try {
            // InternalTextualScenario.g:1141:64: (iv_ruleParticipantDeactivation= ruleParticipantDeactivation EOF )
            // InternalTextualScenario.g:1142:2: iv_ruleParticipantDeactivation= ruleParticipantDeactivation EOF
            {
             newCompositeNode(grammarAccess.getParticipantDeactivationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParticipantDeactivation=ruleParticipantDeactivation();

            state._fsp--;

             current =iv_ruleParticipantDeactivation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParticipantDeactivation"


    // $ANTLR start "ruleParticipantDeactivation"
    // InternalTextualScenario.g:1148:1: ruleParticipantDeactivation returns [EObject current=null] : ( ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleParticipantDeactivation() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:1154:2: ( ( ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:1155:2: ( ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:1155:2: ( ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:1156:3: ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:1156:3: ( (lv_keyword_0_0= 'deactivate' ) )
            // InternalTextualScenario.g:1157:4: (lv_keyword_0_0= 'deactivate' )
            {
            // InternalTextualScenario.g:1157:4: (lv_keyword_0_0= 'deactivate' )
            // InternalTextualScenario.g:1158:5: lv_keyword_0_0= 'deactivate'
            {
            lv_keyword_0_0=(Token)match(input,31,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParticipantDeactivationRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "deactivate");
            				

            }


            }

            // InternalTextualScenario.g:1170:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:1171:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1171:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:1172:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getParticipantDeactivationAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParticipantDeactivationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParticipantDeactivation"


    // $ANTLR start "entryRuleReference"
    // InternalTextualScenario.g:1192:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // InternalTextualScenario.g:1192:50: (iv_ruleReference= ruleReference EOF )
            // InternalTextualScenario.g:1193:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalTextualScenario.g:1199:1: ruleReference returns [EObject current=null] : ( ( (lv_keyword_0_0= 'ref' ) ) otherlv_1= 'over' ( (lv_timelines_2_0= RULE_STRING ) )+ ( (lv_name_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token otherlv_1=null;
        Token lv_timelines_2_0=null;
        Token lv_name_3_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:1205:2: ( ( ( (lv_keyword_0_0= 'ref' ) ) otherlv_1= 'over' ( (lv_timelines_2_0= RULE_STRING ) )+ ( (lv_name_3_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:1206:2: ( ( (lv_keyword_0_0= 'ref' ) ) otherlv_1= 'over' ( (lv_timelines_2_0= RULE_STRING ) )+ ( (lv_name_3_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:1206:2: ( ( (lv_keyword_0_0= 'ref' ) ) otherlv_1= 'over' ( (lv_timelines_2_0= RULE_STRING ) )+ ( (lv_name_3_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:1207:3: ( (lv_keyword_0_0= 'ref' ) ) otherlv_1= 'over' ( (lv_timelines_2_0= RULE_STRING ) )+ ( (lv_name_3_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:1207:3: ( (lv_keyword_0_0= 'ref' ) )
            // InternalTextualScenario.g:1208:4: (lv_keyword_0_0= 'ref' )
            {
            // InternalTextualScenario.g:1208:4: (lv_keyword_0_0= 'ref' )
            // InternalTextualScenario.g:1209:5: lv_keyword_0_0= 'ref'
            {
            lv_keyword_0_0=(Token)match(input,32,FOLLOW_14); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferenceRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "ref");
            				

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getReferenceAccess().getOverKeyword_1());
            		
            // InternalTextualScenario.g:1225:3: ( (lv_timelines_2_0= RULE_STRING ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_STRING) ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1==RULE_STRING) ) {
                        int LA13_2 = input.LA(3);

                        if ( (LA13_2==EOF||LA13_2==RULE_STRING||LA13_2==13||(LA13_2>=30 && LA13_2<=32)||LA13_2==34) ) {
                            alt13=1;
                        }


                    }


                }


                switch (alt13) {
            	case 1 :
            	    // InternalTextualScenario.g:1226:4: (lv_timelines_2_0= RULE_STRING )
            	    {
            	    // InternalTextualScenario.g:1226:4: (lv_timelines_2_0= RULE_STRING )
            	    // InternalTextualScenario.g:1227:5: lv_timelines_2_0= RULE_STRING
            	    {
            	    lv_timelines_2_0=(Token)match(input,RULE_STRING,FOLLOW_6); 

            	    					newLeafNode(lv_timelines_2_0, grammarAccess.getReferenceAccess().getTimelinesSTRINGTerminalRuleCall_2_0());
            	    				

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getReferenceRule());
            	    					}
            	    					addWithLastConsumed(
            	    						current,
            	    						"timelines",
            	    						lv_timelines_2_0,
            	    						"org.eclipse.xtext.common.Terminals.STRING");
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            // InternalTextualScenario.g:1243:3: ( (lv_name_3_0= RULE_STRING ) )
            // InternalTextualScenario.g:1244:4: (lv_name_3_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1244:4: (lv_name_3_0= RULE_STRING )
            // InternalTextualScenario.g:1245:5: lv_name_3_0= RULE_STRING
            {
            lv_name_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_3_0, grammarAccess.getReferenceAccess().getNameSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferenceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleCombinedFragment"
    // InternalTextualScenario.g:1265:1: entryRuleCombinedFragment returns [EObject current=null] : iv_ruleCombinedFragment= ruleCombinedFragment EOF ;
    public final EObject entryRuleCombinedFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombinedFragment = null;


        try {
            // InternalTextualScenario.g:1265:57: (iv_ruleCombinedFragment= ruleCombinedFragment EOF )
            // InternalTextualScenario.g:1266:2: iv_ruleCombinedFragment= ruleCombinedFragment EOF
            {
             newCompositeNode(grammarAccess.getCombinedFragmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCombinedFragment=ruleCombinedFragment();

            state._fsp--;

             current =iv_ruleCombinedFragment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCombinedFragment"


    // $ANTLR start "ruleCombinedFragment"
    // InternalTextualScenario.g:1272:1: ruleCombinedFragment returns [EObject current=null] : this_Alt_0= ruleAlt ;
    public final EObject ruleCombinedFragment() throws RecognitionException {
        EObject current = null;

        EObject this_Alt_0 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:1278:2: (this_Alt_0= ruleAlt )
            // InternalTextualScenario.g:1279:2: this_Alt_0= ruleAlt
            {

            		newCompositeNode(grammarAccess.getCombinedFragmentAccess().getAltParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Alt_0=ruleAlt();

            state._fsp--;


            		current = this_Alt_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCombinedFragment"


    // $ANTLR start "entryRuleAlt"
    // InternalTextualScenario.g:1290:1: entryRuleAlt returns [EObject current=null] : iv_ruleAlt= ruleAlt EOF ;
    public final EObject entryRuleAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlt = null;


        try {
            // InternalTextualScenario.g:1290:44: (iv_ruleAlt= ruleAlt EOF )
            // InternalTextualScenario.g:1291:2: iv_ruleAlt= ruleAlt EOF
            {
             newCompositeNode(grammarAccess.getAltRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlt=ruleAlt();

            state._fsp--;

             current =iv_ruleAlt; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlt"


    // $ANTLR start "ruleAlt"
    // InternalTextualScenario.g:1297:1: ruleAlt returns [EObject current=null] : ( ( (lv_keyword_0_0= 'alt' ) ) ( (lv_condition_1_0= RULE_STRING ) ) otherlv_2= 'over' ( (lv_timelines_3_0= RULE_STRING ) )+ ( (lv_block_4_0= ruleBlock ) ) ( (lv_elseBlocks_5_0= ruleElseBlock ) )* ) ;
    public final EObject ruleAlt() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_condition_1_0=null;
        Token otherlv_2=null;
        Token lv_timelines_3_0=null;
        EObject lv_block_4_0 = null;

        EObject lv_elseBlocks_5_0 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:1303:2: ( ( ( (lv_keyword_0_0= 'alt' ) ) ( (lv_condition_1_0= RULE_STRING ) ) otherlv_2= 'over' ( (lv_timelines_3_0= RULE_STRING ) )+ ( (lv_block_4_0= ruleBlock ) ) ( (lv_elseBlocks_5_0= ruleElseBlock ) )* ) )
            // InternalTextualScenario.g:1304:2: ( ( (lv_keyword_0_0= 'alt' ) ) ( (lv_condition_1_0= RULE_STRING ) ) otherlv_2= 'over' ( (lv_timelines_3_0= RULE_STRING ) )+ ( (lv_block_4_0= ruleBlock ) ) ( (lv_elseBlocks_5_0= ruleElseBlock ) )* )
            {
            // InternalTextualScenario.g:1304:2: ( ( (lv_keyword_0_0= 'alt' ) ) ( (lv_condition_1_0= RULE_STRING ) ) otherlv_2= 'over' ( (lv_timelines_3_0= RULE_STRING ) )+ ( (lv_block_4_0= ruleBlock ) ) ( (lv_elseBlocks_5_0= ruleElseBlock ) )* )
            // InternalTextualScenario.g:1305:3: ( (lv_keyword_0_0= 'alt' ) ) ( (lv_condition_1_0= RULE_STRING ) ) otherlv_2= 'over' ( (lv_timelines_3_0= RULE_STRING ) )+ ( (lv_block_4_0= ruleBlock ) ) ( (lv_elseBlocks_5_0= ruleElseBlock ) )*
            {
            // InternalTextualScenario.g:1305:3: ( (lv_keyword_0_0= 'alt' ) )
            // InternalTextualScenario.g:1306:4: (lv_keyword_0_0= 'alt' )
            {
            // InternalTextualScenario.g:1306:4: (lv_keyword_0_0= 'alt' )
            // InternalTextualScenario.g:1307:5: lv_keyword_0_0= 'alt'
            {
            lv_keyword_0_0=(Token)match(input,34,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getAltAccess().getKeywordAltKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAltRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "alt");
            				

            }


            }

            // InternalTextualScenario.g:1319:3: ( (lv_condition_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:1320:4: (lv_condition_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1320:4: (lv_condition_1_0= RULE_STRING )
            // InternalTextualScenario.g:1321:5: lv_condition_1_0= RULE_STRING
            {
            lv_condition_1_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

            					newLeafNode(lv_condition_1_0, grammarAccess.getAltAccess().getConditionSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAltRule());
            					}
            					setWithLastConsumed(
            						current,
            						"condition",
            						lv_condition_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,33,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getAltAccess().getOverKeyword_2());
            		
            // InternalTextualScenario.g:1341:3: ( (lv_timelines_3_0= RULE_STRING ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_STRING) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalTextualScenario.g:1342:4: (lv_timelines_3_0= RULE_STRING )
            	    {
            	    // InternalTextualScenario.g:1342:4: (lv_timelines_3_0= RULE_STRING )
            	    // InternalTextualScenario.g:1343:5: lv_timelines_3_0= RULE_STRING
            	    {
            	    lv_timelines_3_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

            	    					newLeafNode(lv_timelines_3_0, grammarAccess.getAltAccess().getTimelinesSTRINGTerminalRuleCall_3_0());
            	    				

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getAltRule());
            	    					}
            	    					addWithLastConsumed(
            	    						current,
            	    						"timelines",
            	    						lv_timelines_3_0,
            	    						"org.eclipse.xtext.common.Terminals.STRING");
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);

            // InternalTextualScenario.g:1359:3: ( (lv_block_4_0= ruleBlock ) )
            // InternalTextualScenario.g:1360:4: (lv_block_4_0= ruleBlock )
            {
            // InternalTextualScenario.g:1360:4: (lv_block_4_0= ruleBlock )
            // InternalTextualScenario.g:1361:5: lv_block_4_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getAltAccess().getBlockBlockParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_16);
            lv_block_4_0=ruleBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAltRule());
            					}
            					set(
            						current,
            						"block",
            						lv_block_4_0,
            						"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Block");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTextualScenario.g:1378:3: ( (lv_elseBlocks_5_0= ruleElseBlock ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==35) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalTextualScenario.g:1379:4: (lv_elseBlocks_5_0= ruleElseBlock )
            	    {
            	    // InternalTextualScenario.g:1379:4: (lv_elseBlocks_5_0= ruleElseBlock )
            	    // InternalTextualScenario.g:1380:5: lv_elseBlocks_5_0= ruleElseBlock
            	    {

            	    					newCompositeNode(grammarAccess.getAltAccess().getElseBlocksElseBlockParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_elseBlocks_5_0=ruleElseBlock();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAltRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elseBlocks",
            	    						lv_elseBlocks_5_0,
            	    						"org.polarsys.capella.scenario.editor.dsl.TextualScenario.ElseBlock");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlt"


    // $ANTLR start "entryRuleElseBlock"
    // InternalTextualScenario.g:1401:1: entryRuleElseBlock returns [EObject current=null] : iv_ruleElseBlock= ruleElseBlock EOF ;
    public final EObject entryRuleElseBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseBlock = null;


        try {
            // InternalTextualScenario.g:1401:50: (iv_ruleElseBlock= ruleElseBlock EOF )
            // InternalTextualScenario.g:1402:2: iv_ruleElseBlock= ruleElseBlock EOF
            {
             newCompositeNode(grammarAccess.getElseBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElseBlock=ruleElseBlock();

            state._fsp--;

             current =iv_ruleElseBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElseBlock"


    // $ANTLR start "ruleElseBlock"
    // InternalTextualScenario.g:1408:1: ruleElseBlock returns [EObject current=null] : (otherlv_0= 'else' ( (lv_condition_1_0= RULE_STRING ) ) ( (lv_block_2_0= ruleBlock ) ) ) ;
    public final EObject ruleElseBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_condition_1_0=null;
        EObject lv_block_2_0 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:1414:2: ( (otherlv_0= 'else' ( (lv_condition_1_0= RULE_STRING ) ) ( (lv_block_2_0= ruleBlock ) ) ) )
            // InternalTextualScenario.g:1415:2: (otherlv_0= 'else' ( (lv_condition_1_0= RULE_STRING ) ) ( (lv_block_2_0= ruleBlock ) ) )
            {
            // InternalTextualScenario.g:1415:2: (otherlv_0= 'else' ( (lv_condition_1_0= RULE_STRING ) ) ( (lv_block_2_0= ruleBlock ) ) )
            // InternalTextualScenario.g:1416:3: otherlv_0= 'else' ( (lv_condition_1_0= RULE_STRING ) ) ( (lv_block_2_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getElseBlockAccess().getElseKeyword_0());
            		
            // InternalTextualScenario.g:1420:3: ( (lv_condition_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:1421:4: (lv_condition_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1421:4: (lv_condition_1_0= RULE_STRING )
            // InternalTextualScenario.g:1422:5: lv_condition_1_0= RULE_STRING
            {
            lv_condition_1_0=(Token)match(input,RULE_STRING,FOLLOW_3); 

            					newLeafNode(lv_condition_1_0, grammarAccess.getElseBlockAccess().getConditionSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getElseBlockRule());
            					}
            					setWithLastConsumed(
            						current,
            						"condition",
            						lv_condition_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalTextualScenario.g:1438:3: ( (lv_block_2_0= ruleBlock ) )
            // InternalTextualScenario.g:1439:4: (lv_block_2_0= ruleBlock )
            {
            // InternalTextualScenario.g:1439:4: (lv_block_2_0= ruleBlock )
            // InternalTextualScenario.g:1440:5: lv_block_2_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getElseBlockAccess().getBlockBlockParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_block_2_0=ruleBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getElseBlockRule());
            					}
            					set(
            						current,
            						"block",
            						lv_block_2_0,
            						"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Block");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElseBlock"


    // $ANTLR start "entryRuleBlock"
    // InternalTextualScenario.g:1461:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // InternalTextualScenario.g:1461:46: (iv_ruleBlock= ruleBlock EOF )
            // InternalTextualScenario.g:1462:2: iv_ruleBlock= ruleBlock EOF
            {
             newCompositeNode(grammarAccess.getBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlock=ruleBlock();

            state._fsp--;

             current =iv_ruleBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // InternalTextualScenario.g:1468:1: ruleBlock returns [EObject current=null] : ( ( (lv_begin_0_0= '{' ) ) ( ( (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment ) ) )* ( (lv_end_2_0= '}' ) ) ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token lv_begin_0_0=null;
        Token lv_end_2_0=null;
        EObject lv_blockElements_1_1 = null;

        EObject lv_blockElements_1_2 = null;

        EObject lv_blockElements_1_3 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:1474:2: ( ( ( (lv_begin_0_0= '{' ) ) ( ( (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment ) ) )* ( (lv_end_2_0= '}' ) ) ) )
            // InternalTextualScenario.g:1475:2: ( ( (lv_begin_0_0= '{' ) ) ( ( (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment ) ) )* ( (lv_end_2_0= '}' ) ) )
            {
            // InternalTextualScenario.g:1475:2: ( ( (lv_begin_0_0= '{' ) ) ( ( (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment ) ) )* ( (lv_end_2_0= '}' ) ) )
            // InternalTextualScenario.g:1476:3: ( (lv_begin_0_0= '{' ) ) ( ( (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment ) ) )* ( (lv_end_2_0= '}' ) )
            {
            // InternalTextualScenario.g:1476:3: ( (lv_begin_0_0= '{' ) )
            // InternalTextualScenario.g:1477:4: (lv_begin_0_0= '{' )
            {
            // InternalTextualScenario.g:1477:4: (lv_begin_0_0= '{' )
            // InternalTextualScenario.g:1478:5: lv_begin_0_0= '{'
            {
            lv_begin_0_0=(Token)match(input,12,FOLLOW_5); 

            					newLeafNode(lv_begin_0_0, grammarAccess.getBlockAccess().getBeginLeftCurlyBracketKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBlockRule());
            					}
            					setWithLastConsumed(current, "begin", lv_begin_0_0, "{");
            				

            }


            }

            // InternalTextualScenario.g:1490:3: ( ( (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_STRING||(LA17_0>=30 && LA17_0<=32)||LA17_0==34) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalTextualScenario.g:1491:4: ( (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment ) )
            	    {
            	    // InternalTextualScenario.g:1491:4: ( (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment ) )
            	    // InternalTextualScenario.g:1492:5: (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment )
            	    {
            	    // InternalTextualScenario.g:1492:5: (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment )
            	    int alt16=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_STRING:
            	    case 30:
            	    case 31:
            	        {
            	        alt16=1;
            	        }
            	        break;
            	    case 32:
            	        {
            	        alt16=2;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt16=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 16, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt16) {
            	        case 1 :
            	            // InternalTextualScenario.g:1493:6: lv_blockElements_1_1= ruleMessage
            	            {

            	            						newCompositeNode(grammarAccess.getBlockAccess().getBlockElementsMessageParserRuleCall_1_0_0());
            	            					
            	            pushFollow(FOLLOW_5);
            	            lv_blockElements_1_1=ruleMessage();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getBlockRule());
            	            						}
            	            						add(
            	            							current,
            	            							"blockElements",
            	            							lv_blockElements_1_1,
            	            							"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Message");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // InternalTextualScenario.g:1509:6: lv_blockElements_1_2= ruleReference
            	            {

            	            						newCompositeNode(grammarAccess.getBlockAccess().getBlockElementsReferenceParserRuleCall_1_0_1());
            	            					
            	            pushFollow(FOLLOW_5);
            	            lv_blockElements_1_2=ruleReference();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getBlockRule());
            	            						}
            	            						add(
            	            							current,
            	            							"blockElements",
            	            							lv_blockElements_1_2,
            	            							"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Reference");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;
            	        case 3 :
            	            // InternalTextualScenario.g:1525:6: lv_blockElements_1_3= ruleCombinedFragment
            	            {

            	            						newCompositeNode(grammarAccess.getBlockAccess().getBlockElementsCombinedFragmentParserRuleCall_1_0_2());
            	            					
            	            pushFollow(FOLLOW_5);
            	            lv_blockElements_1_3=ruleCombinedFragment();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getBlockRule());
            	            						}
            	            						add(
            	            							current,
            	            							"blockElements",
            	            							lv_blockElements_1_3,
            	            							"org.polarsys.capella.scenario.editor.dsl.TextualScenario.CombinedFragment");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // InternalTextualScenario.g:1543:3: ( (lv_end_2_0= '}' ) )
            // InternalTextualScenario.g:1544:4: (lv_end_2_0= '}' )
            {
            // InternalTextualScenario.g:1544:4: (lv_end_2_0= '}' )
            // InternalTextualScenario.g:1545:5: lv_end_2_0= '}'
            {
            lv_end_2_0=(Token)match(input,13,FOLLOW_2); 

            					newLeafNode(lv_end_2_0, grammarAccess.getBlockAccess().getEndRightCurlyBracketKeyword_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBlockRule());
            					}
            					setWithLastConsumed(current, "end", lv_end_2_0, "}");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlock"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000005C0F8E010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000005C0002010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000070002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000800000002L});

}
