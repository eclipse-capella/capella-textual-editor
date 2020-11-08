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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'scenario'", "'{'", "'}'", "'actor'", "'component'", "'configuration_item'", "'function'", "'activity'", "'entity'", "'role'", "'->'", "'withExecution'", "'withReturn'", "':'", "'->+'", "'->x'", "'->>'", "'->o'", "'o->'", "'deactivate'", "'alt'", "'loop'", "'par'", "'assert'", "'critical'", "'ignore'", "'neg'", "'opt'", "'seq'", "'strict'", "'unset'", "'over'", "'else'", "'on'", "'state'", "'mode'", "'ref'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=5;
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
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

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
    // InternalTextualScenario.g:71:1: ruleModel returns [EObject current=null] : (otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant ) )* ( (lv_elements_3_0= ruleElement ) )* ( (lv_end_4_0= '}' ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_begin_1_0=null;
        Token lv_end_4_0=null;
        EObject lv_participants_2_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:77:2: ( (otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant ) )* ( (lv_elements_3_0= ruleElement ) )* ( (lv_end_4_0= '}' ) ) ) )
            // InternalTextualScenario.g:78:2: (otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant ) )* ( (lv_elements_3_0= ruleElement ) )* ( (lv_end_4_0= '}' ) ) )
            {
            // InternalTextualScenario.g:78:2: (otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant ) )* ( (lv_elements_3_0= ruleElement ) )* ( (lv_end_4_0= '}' ) ) )
            // InternalTextualScenario.g:79:3: otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant ) )* ( (lv_elements_3_0= ruleElement ) )* ( (lv_end_4_0= '}' ) )
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

                if ( ((LA1_0>=14 && LA1_0<=20)) ) {
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

            // InternalTextualScenario.g:116:3: ( (lv_elements_3_0= ruleElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_STRING||LA2_0==27||(LA2_0>=29 && LA2_0<=41)||LA2_0==44||LA2_0==47) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalTextualScenario.g:117:4: (lv_elements_3_0= ruleElement )
            	    {
            	    // InternalTextualScenario.g:117:4: (lv_elements_3_0= ruleElement )
            	    // InternalTextualScenario.g:118:5: lv_elements_3_0= ruleElement
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getElementsElementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_elements_3_0=ruleElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_3_0,
            	    						"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Element");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalTextualScenario.g:135:3: ( (lv_end_4_0= '}' ) )
            // InternalTextualScenario.g:136:4: (lv_end_4_0= '}' )
            {
            // InternalTextualScenario.g:136:4: (lv_end_4_0= '}' )
            // InternalTextualScenario.g:137:5: lv_end_4_0= '}'
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
    // InternalTextualScenario.g:153:1: entryRuleParticipant returns [EObject current=null] : iv_ruleParticipant= ruleParticipant EOF ;
    public final EObject entryRuleParticipant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParticipant = null;


        try {
            // InternalTextualScenario.g:153:52: (iv_ruleParticipant= ruleParticipant EOF )
            // InternalTextualScenario.g:154:2: iv_ruleParticipant= ruleParticipant EOF
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
    // InternalTextualScenario.g:160:1: ruleParticipant returns [EObject current=null] : (this_GenericComponent_0= ruleGenericComponent | this_GenericFunction_1= ruleGenericFunction ) ;
    public final EObject ruleParticipant() throws RecognitionException {
        EObject current = null;

        EObject this_GenericComponent_0 = null;

        EObject this_GenericFunction_1 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:166:2: ( (this_GenericComponent_0= ruleGenericComponent | this_GenericFunction_1= ruleGenericFunction ) )
            // InternalTextualScenario.g:167:2: (this_GenericComponent_0= ruleGenericComponent | this_GenericFunction_1= ruleGenericFunction )
            {
            // InternalTextualScenario.g:167:2: (this_GenericComponent_0= ruleGenericComponent | this_GenericFunction_1= ruleGenericFunction )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=14 && LA3_0<=16)||(LA3_0>=19 && LA3_0<=20)) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=17 && LA3_0<=18)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalTextualScenario.g:168:3: this_GenericComponent_0= ruleGenericComponent
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
                    // InternalTextualScenario.g:177:3: this_GenericFunction_1= ruleGenericFunction
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
    // InternalTextualScenario.g:189:1: entryRuleGenericComponent returns [EObject current=null] : iv_ruleGenericComponent= ruleGenericComponent EOF ;
    public final EObject entryRuleGenericComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenericComponent = null;


        try {
            // InternalTextualScenario.g:189:57: (iv_ruleGenericComponent= ruleGenericComponent EOF )
            // InternalTextualScenario.g:190:2: iv_ruleGenericComponent= ruleGenericComponent EOF
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
    // InternalTextualScenario.g:196:1: ruleGenericComponent returns [EObject current=null] : (this_Entity_0= ruleEntity | this_Actor_1= ruleActor | this_Component_2= ruleComponent | this_ConfigurationItem_3= ruleConfigurationItem | this_Role_4= ruleRole ) ;
    public final EObject ruleGenericComponent() throws RecognitionException {
        EObject current = null;

        EObject this_Entity_0 = null;

        EObject this_Actor_1 = null;

        EObject this_Component_2 = null;

        EObject this_ConfigurationItem_3 = null;

        EObject this_Role_4 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:202:2: ( (this_Entity_0= ruleEntity | this_Actor_1= ruleActor | this_Component_2= ruleComponent | this_ConfigurationItem_3= ruleConfigurationItem | this_Role_4= ruleRole ) )
            // InternalTextualScenario.g:203:2: (this_Entity_0= ruleEntity | this_Actor_1= ruleActor | this_Component_2= ruleComponent | this_ConfigurationItem_3= ruleConfigurationItem | this_Role_4= ruleRole )
            {
            // InternalTextualScenario.g:203:2: (this_Entity_0= ruleEntity | this_Actor_1= ruleActor | this_Component_2= ruleComponent | this_ConfigurationItem_3= ruleConfigurationItem | this_Role_4= ruleRole )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt4=1;
                }
                break;
            case 14:
                {
                alt4=2;
                }
                break;
            case 15:
                {
                alt4=3;
                }
                break;
            case 16:
                {
                alt4=4;
                }
                break;
            case 20:
                {
                alt4=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalTextualScenario.g:204:3: this_Entity_0= ruleEntity
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
                    // InternalTextualScenario.g:213:3: this_Actor_1= ruleActor
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
                    // InternalTextualScenario.g:222:3: this_Component_2= ruleComponent
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
                    // InternalTextualScenario.g:231:3: this_ConfigurationItem_3= ruleConfigurationItem
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
                    // InternalTextualScenario.g:240:3: this_Role_4= ruleRole
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
    // InternalTextualScenario.g:252:1: entryRuleGenericFunction returns [EObject current=null] : iv_ruleGenericFunction= ruleGenericFunction EOF ;
    public final EObject entryRuleGenericFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenericFunction = null;


        try {
            // InternalTextualScenario.g:252:56: (iv_ruleGenericFunction= ruleGenericFunction EOF )
            // InternalTextualScenario.g:253:2: iv_ruleGenericFunction= ruleGenericFunction EOF
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
    // InternalTextualScenario.g:259:1: ruleGenericFunction returns [EObject current=null] : (this_Function_0= ruleFunction | this_Activity_1= ruleActivity ) ;
    public final EObject ruleGenericFunction() throws RecognitionException {
        EObject current = null;

        EObject this_Function_0 = null;

        EObject this_Activity_1 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:265:2: ( (this_Function_0= ruleFunction | this_Activity_1= ruleActivity ) )
            // InternalTextualScenario.g:266:2: (this_Function_0= ruleFunction | this_Activity_1= ruleActivity )
            {
            // InternalTextualScenario.g:266:2: (this_Function_0= ruleFunction | this_Activity_1= ruleActivity )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            else if ( (LA5_0==18) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalTextualScenario.g:267:3: this_Function_0= ruleFunction
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
                    // InternalTextualScenario.g:276:3: this_Activity_1= ruleActivity
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


    // $ANTLR start "entryRuleElement"
    // InternalTextualScenario.g:288:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalTextualScenario.g:288:48: (iv_ruleElement= ruleElement EOF )
            // InternalTextualScenario.g:289:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalTextualScenario.g:295:1: ruleElement returns [EObject current=null] : (this_Message_0= ruleMessage | this_CombinedFragment_1= ruleCombinedFragment | this_StateFragment_2= ruleStateFragment | this_Reference_3= ruleReference ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        EObject this_Message_0 = null;

        EObject this_CombinedFragment_1 = null;

        EObject this_StateFragment_2 = null;

        EObject this_Reference_3 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:301:2: ( (this_Message_0= ruleMessage | this_CombinedFragment_1= ruleCombinedFragment | this_StateFragment_2= ruleStateFragment | this_Reference_3= ruleReference ) )
            // InternalTextualScenario.g:302:2: (this_Message_0= ruleMessage | this_CombinedFragment_1= ruleCombinedFragment | this_StateFragment_2= ruleStateFragment | this_Reference_3= ruleReference )
            {
            // InternalTextualScenario.g:302:2: (this_Message_0= ruleMessage | this_CombinedFragment_1= ruleCombinedFragment | this_StateFragment_2= ruleStateFragment | this_Reference_3= ruleReference )
            int alt6=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case 27:
            case 29:
            case 30:
                {
                alt6=1;
                }
                break;
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
                {
                alt6=2;
                }
                break;
            case 44:
                {
                alt6=3;
                }
                break;
            case 47:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalTextualScenario.g:303:3: this_Message_0= ruleMessage
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getMessageParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Message_0=ruleMessage();

                    state._fsp--;


                    			current = this_Message_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:312:3: this_CombinedFragment_1= ruleCombinedFragment
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getCombinedFragmentParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_CombinedFragment_1=ruleCombinedFragment();

                    state._fsp--;


                    			current = this_CombinedFragment_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:321:3: this_StateFragment_2= ruleStateFragment
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getStateFragmentParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_StateFragment_2=ruleStateFragment();

                    state._fsp--;


                    			current = this_StateFragment_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalTextualScenario.g:330:3: this_Reference_3= ruleReference
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getReferenceParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Reference_3=ruleReference();

                    state._fsp--;


                    			current = this_Reference_3;
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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleActor"
    // InternalTextualScenario.g:342:1: entryRuleActor returns [EObject current=null] : iv_ruleActor= ruleActor EOF ;
    public final EObject entryRuleActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActor = null;


        try {
            // InternalTextualScenario.g:342:46: (iv_ruleActor= ruleActor EOF )
            // InternalTextualScenario.g:343:2: iv_ruleActor= ruleActor EOF
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
    // InternalTextualScenario.g:349:1: ruleActor returns [EObject current=null] : ( ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleActor() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:355:2: ( ( ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:356:2: ( ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:356:2: ( ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:357:3: ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:357:3: ( (lv_keyword_0_0= 'actor' ) )
            // InternalTextualScenario.g:358:4: (lv_keyword_0_0= 'actor' )
            {
            // InternalTextualScenario.g:358:4: (lv_keyword_0_0= 'actor' )
            // InternalTextualScenario.g:359:5: lv_keyword_0_0= 'actor'
            {
            lv_keyword_0_0=(Token)match(input,14,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getActorAccess().getKeywordActorKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActorRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "actor");
            				

            }


            }

            // InternalTextualScenario.g:371:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:372:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:372:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:373:5: lv_name_1_0= RULE_STRING
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
    // InternalTextualScenario.g:393:1: entryRuleComponent returns [EObject current=null] : iv_ruleComponent= ruleComponent EOF ;
    public final EObject entryRuleComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponent = null;


        try {
            // InternalTextualScenario.g:393:50: (iv_ruleComponent= ruleComponent EOF )
            // InternalTextualScenario.g:394:2: iv_ruleComponent= ruleComponent EOF
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
    // InternalTextualScenario.g:400:1: ruleComponent returns [EObject current=null] : ( ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleComponent() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:406:2: ( ( ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:407:2: ( ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:407:2: ( ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:408:3: ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:408:3: ( (lv_keyword_0_0= 'component' ) )
            // InternalTextualScenario.g:409:4: (lv_keyword_0_0= 'component' )
            {
            // InternalTextualScenario.g:409:4: (lv_keyword_0_0= 'component' )
            // InternalTextualScenario.g:410:5: lv_keyword_0_0= 'component'
            {
            lv_keyword_0_0=(Token)match(input,15,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "component");
            				

            }


            }

            // InternalTextualScenario.g:422:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:423:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:423:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:424:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

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
    // InternalTextualScenario.g:444:1: entryRuleConfigurationItem returns [EObject current=null] : iv_ruleConfigurationItem= ruleConfigurationItem EOF ;
    public final EObject entryRuleConfigurationItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigurationItem = null;


        try {
            // InternalTextualScenario.g:444:58: (iv_ruleConfigurationItem= ruleConfigurationItem EOF )
            // InternalTextualScenario.g:445:2: iv_ruleConfigurationItem= ruleConfigurationItem EOF
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
    // InternalTextualScenario.g:451:1: ruleConfigurationItem returns [EObject current=null] : ( ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleConfigurationItem() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:457:2: ( ( ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:458:2: ( ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:458:2: ( ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:459:3: ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:459:3: ( (lv_keyword_0_0= 'configuration_item' ) )
            // InternalTextualScenario.g:460:4: (lv_keyword_0_0= 'configuration_item' )
            {
            // InternalTextualScenario.g:460:4: (lv_keyword_0_0= 'configuration_item' )
            // InternalTextualScenario.g:461:5: lv_keyword_0_0= 'configuration_item'
            {
            lv_keyword_0_0=(Token)match(input,16,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConfigurationItemRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "configuration_item");
            				

            }


            }

            // InternalTextualScenario.g:473:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:474:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:474:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:475:5: lv_name_1_0= RULE_STRING
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
    // InternalTextualScenario.g:495:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalTextualScenario.g:495:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalTextualScenario.g:496:2: iv_ruleFunction= ruleFunction EOF
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
    // InternalTextualScenario.g:502:1: ruleFunction returns [EObject current=null] : ( ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:508:2: ( ( ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:509:2: ( ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:509:2: ( ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:510:3: ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:510:3: ( (lv_keyword_0_0= 'function' ) )
            // InternalTextualScenario.g:511:4: (lv_keyword_0_0= 'function' )
            {
            // InternalTextualScenario.g:511:4: (lv_keyword_0_0= 'function' )
            // InternalTextualScenario.g:512:5: lv_keyword_0_0= 'function'
            {
            lv_keyword_0_0=(Token)match(input,17,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "function");
            				

            }


            }

            // InternalTextualScenario.g:524:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:525:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:525:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:526:5: lv_name_1_0= RULE_STRING
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
    // InternalTextualScenario.g:546:1: entryRuleActivity returns [EObject current=null] : iv_ruleActivity= ruleActivity EOF ;
    public final EObject entryRuleActivity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActivity = null;


        try {
            // InternalTextualScenario.g:546:49: (iv_ruleActivity= ruleActivity EOF )
            // InternalTextualScenario.g:547:2: iv_ruleActivity= ruleActivity EOF
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
    // InternalTextualScenario.g:553:1: ruleActivity returns [EObject current=null] : ( ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleActivity() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:559:2: ( ( ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:560:2: ( ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:560:2: ( ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:561:3: ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:561:3: ( (lv_keyword_0_0= 'activity' ) )
            // InternalTextualScenario.g:562:4: (lv_keyword_0_0= 'activity' )
            {
            // InternalTextualScenario.g:562:4: (lv_keyword_0_0= 'activity' )
            // InternalTextualScenario.g:563:5: lv_keyword_0_0= 'activity'
            {
            lv_keyword_0_0=(Token)match(input,18,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActivityRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "activity");
            				

            }


            }

            // InternalTextualScenario.g:575:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:576:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:576:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:577:5: lv_name_1_0= RULE_STRING
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
    // InternalTextualScenario.g:597:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalTextualScenario.g:597:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalTextualScenario.g:598:2: iv_ruleEntity= ruleEntity EOF
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
    // InternalTextualScenario.g:604:1: ruleEntity returns [EObject current=null] : ( ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:610:2: ( ( ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:611:2: ( ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:611:2: ( ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:612:3: ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:612:3: ( (lv_keyword_0_0= 'entity' ) )
            // InternalTextualScenario.g:613:4: (lv_keyword_0_0= 'entity' )
            {
            // InternalTextualScenario.g:613:4: (lv_keyword_0_0= 'entity' )
            // InternalTextualScenario.g:614:5: lv_keyword_0_0= 'entity'
            {
            lv_keyword_0_0=(Token)match(input,19,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "entity");
            				

            }


            }

            // InternalTextualScenario.g:626:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:627:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:627:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:628:5: lv_name_1_0= RULE_STRING
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
    // InternalTextualScenario.g:648:1: entryRuleRole returns [EObject current=null] : iv_ruleRole= ruleRole EOF ;
    public final EObject entryRuleRole() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRole = null;


        try {
            // InternalTextualScenario.g:648:45: (iv_ruleRole= ruleRole EOF )
            // InternalTextualScenario.g:649:2: iv_ruleRole= ruleRole EOF
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
    // InternalTextualScenario.g:655:1: ruleRole returns [EObject current=null] : ( ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleRole() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:661:2: ( ( ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:662:2: ( ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:662:2: ( ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:663:3: ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:663:3: ( (lv_keyword_0_0= 'role' ) )
            // InternalTextualScenario.g:664:4: (lv_keyword_0_0= 'role' )
            {
            // InternalTextualScenario.g:664:4: (lv_keyword_0_0= 'role' )
            // InternalTextualScenario.g:665:5: lv_keyword_0_0= 'role'
            {
            lv_keyword_0_0=(Token)match(input,20,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRoleRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "role");
            				

            }


            }

            // InternalTextualScenario.g:677:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:678:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:678:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:679:5: lv_name_1_0= RULE_STRING
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
    // InternalTextualScenario.g:699:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // InternalTextualScenario.g:699:48: (iv_ruleMessage= ruleMessage EOF )
            // InternalTextualScenario.g:700:2: iv_ruleMessage= ruleMessage EOF
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
    // InternalTextualScenario.g:706:1: ruleMessage returns [EObject current=null] : (this_SequenceMessageType_0= ruleSequenceMessageType | this_ArmTimerMessage_1= ruleArmTimerMessage | this_ParticipantDeactivation_2= ruleParticipantDeactivation | this_LostFoundMessage_3= ruleLostFoundMessage ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        EObject this_SequenceMessageType_0 = null;

        EObject this_ArmTimerMessage_1 = null;

        EObject this_ParticipantDeactivation_2 = null;

        EObject this_LostFoundMessage_3 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:712:2: ( (this_SequenceMessageType_0= ruleSequenceMessageType | this_ArmTimerMessage_1= ruleArmTimerMessage | this_ParticipantDeactivation_2= ruleParticipantDeactivation | this_LostFoundMessage_3= ruleLostFoundMessage ) )
            // InternalTextualScenario.g:713:2: (this_SequenceMessageType_0= ruleSequenceMessageType | this_ArmTimerMessage_1= ruleArmTimerMessage | this_ParticipantDeactivation_2= ruleParticipantDeactivation | this_LostFoundMessage_3= ruleLostFoundMessage )
            {
            // InternalTextualScenario.g:713:2: (this_SequenceMessageType_0= ruleSequenceMessageType | this_ArmTimerMessage_1= ruleArmTimerMessage | this_ParticipantDeactivation_2= ruleParticipantDeactivation | this_LostFoundMessage_3= ruleLostFoundMessage )
            int alt7=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==21||(LA7_1>=25 && LA7_1<=26)) ) {
                    alt7=1;
                }
                else if ( (LA7_1==28) ) {
                    alt7=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
                }
                break;
            case 27:
                {
                alt7=2;
                }
                break;
            case 30:
                {
                alt7=3;
                }
                break;
            case 29:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalTextualScenario.g:714:3: this_SequenceMessageType_0= ruleSequenceMessageType
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
                    // InternalTextualScenario.g:723:3: this_ArmTimerMessage_1= ruleArmTimerMessage
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
                    // InternalTextualScenario.g:732:3: this_ParticipantDeactivation_2= ruleParticipantDeactivation
                    {

                    			newCompositeNode(grammarAccess.getMessageAccess().getParticipantDeactivationParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParticipantDeactivation_2=ruleParticipantDeactivation();

                    state._fsp--;


                    			current = this_ParticipantDeactivation_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalTextualScenario.g:741:3: this_LostFoundMessage_3= ruleLostFoundMessage
                    {

                    			newCompositeNode(grammarAccess.getMessageAccess().getLostFoundMessageParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_LostFoundMessage_3=ruleLostFoundMessage();

                    state._fsp--;


                    			current = this_LostFoundMessage_3;
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
    // InternalTextualScenario.g:753:1: entryRuleSequenceMessageType returns [EObject current=null] : iv_ruleSequenceMessageType= ruleSequenceMessageType EOF ;
    public final EObject entryRuleSequenceMessageType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceMessageType = null;


        try {
            // InternalTextualScenario.g:753:60: (iv_ruleSequenceMessageType= ruleSequenceMessageType EOF )
            // InternalTextualScenario.g:754:2: iv_ruleSequenceMessageType= ruleSequenceMessageType EOF
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
    // InternalTextualScenario.g:760:1: ruleSequenceMessageType returns [EObject current=null] : (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage | this_DeleteMessage_2= ruleDeleteMessage ) ;
    public final EObject ruleSequenceMessageType() throws RecognitionException {
        EObject current = null;

        EObject this_SequenceMessage_0 = null;

        EObject this_CreateMessage_1 = null;

        EObject this_DeleteMessage_2 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:766:2: ( (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage | this_DeleteMessage_2= ruleDeleteMessage ) )
            // InternalTextualScenario.g:767:2: (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage | this_DeleteMessage_2= ruleDeleteMessage )
            {
            // InternalTextualScenario.g:767:2: (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage | this_DeleteMessage_2= ruleDeleteMessage )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_STRING) ) {
                switch ( input.LA(2) ) {
                case 26:
                    {
                    alt8=3;
                    }
                    break;
                case 25:
                    {
                    alt8=2;
                    }
                    break;
                case 21:
                    {
                    alt8=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalTextualScenario.g:768:3: this_SequenceMessage_0= ruleSequenceMessage
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
                    // InternalTextualScenario.g:777:3: this_CreateMessage_1= ruleCreateMessage
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
                    // InternalTextualScenario.g:786:3: this_DeleteMessage_2= ruleDeleteMessage
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
    // InternalTextualScenario.g:798:1: entryRuleSequenceMessage returns [EObject current=null] : iv_ruleSequenceMessage= ruleSequenceMessage EOF ;
    public final EObject entryRuleSequenceMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceMessage = null;


        try {
            // InternalTextualScenario.g:798:56: (iv_ruleSequenceMessage= ruleSequenceMessage EOF )
            // InternalTextualScenario.g:799:2: iv_ruleSequenceMessage= ruleSequenceMessage EOF
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
    // InternalTextualScenario.g:805:1: ruleSequenceMessage returns [EObject current=null] : ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_execution_3_0= 'withExecution' ) )? ( (lv_return_4_0= 'withReturn' ) )? ( (lv_doubleDot_5_0= ':' ) ) ( (lv_name_6_0= RULE_STRING ) ) ) ;
    public final EObject ruleSequenceMessage() throws RecognitionException {
        EObject current = null;

        Token lv_source_0_0=null;
        Token lv_arrow_1_0=null;
        Token lv_target_2_0=null;
        Token lv_execution_3_0=null;
        Token lv_return_4_0=null;
        Token lv_doubleDot_5_0=null;
        Token lv_name_6_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:811:2: ( ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_execution_3_0= 'withExecution' ) )? ( (lv_return_4_0= 'withReturn' ) )? ( (lv_doubleDot_5_0= ':' ) ) ( (lv_name_6_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:812:2: ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_execution_3_0= 'withExecution' ) )? ( (lv_return_4_0= 'withReturn' ) )? ( (lv_doubleDot_5_0= ':' ) ) ( (lv_name_6_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:812:2: ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_execution_3_0= 'withExecution' ) )? ( (lv_return_4_0= 'withReturn' ) )? ( (lv_doubleDot_5_0= ':' ) ) ( (lv_name_6_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:813:3: ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_execution_3_0= 'withExecution' ) )? ( (lv_return_4_0= 'withReturn' ) )? ( (lv_doubleDot_5_0= ':' ) ) ( (lv_name_6_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:813:3: ( (lv_source_0_0= RULE_STRING ) )
            // InternalTextualScenario.g:814:4: (lv_source_0_0= RULE_STRING )
            {
            // InternalTextualScenario.g:814:4: (lv_source_0_0= RULE_STRING )
            // InternalTextualScenario.g:815:5: lv_source_0_0= RULE_STRING
            {
            lv_source_0_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

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

            // InternalTextualScenario.g:831:3: ( (lv_arrow_1_0= '->' ) )
            // InternalTextualScenario.g:832:4: (lv_arrow_1_0= '->' )
            {
            // InternalTextualScenario.g:832:4: (lv_arrow_1_0= '->' )
            // InternalTextualScenario.g:833:5: lv_arrow_1_0= '->'
            {
            lv_arrow_1_0=(Token)match(input,21,FOLLOW_6); 

            					newLeafNode(lv_arrow_1_0, grammarAccess.getSequenceMessageAccess().getArrowHyphenMinusGreaterThanSignKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSequenceMessageRule());
            					}
            					setWithLastConsumed(current, "arrow", lv_arrow_1_0, "->");
            				

            }


            }

            // InternalTextualScenario.g:845:3: ( (lv_target_2_0= RULE_STRING ) )
            // InternalTextualScenario.g:846:4: (lv_target_2_0= RULE_STRING )
            {
            // InternalTextualScenario.g:846:4: (lv_target_2_0= RULE_STRING )
            // InternalTextualScenario.g:847:5: lv_target_2_0= RULE_STRING
            {
            lv_target_2_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

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

            // InternalTextualScenario.g:863:3: ( (lv_execution_3_0= 'withExecution' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalTextualScenario.g:864:4: (lv_execution_3_0= 'withExecution' )
                    {
                    // InternalTextualScenario.g:864:4: (lv_execution_3_0= 'withExecution' )
                    // InternalTextualScenario.g:865:5: lv_execution_3_0= 'withExecution'
                    {
                    lv_execution_3_0=(Token)match(input,22,FOLLOW_9); 

                    					newLeafNode(lv_execution_3_0, grammarAccess.getSequenceMessageAccess().getExecutionWithExecutionKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSequenceMessageRule());
                    					}
                    					setWithLastConsumed(current, "execution", lv_execution_3_0, "withExecution");
                    				

                    }


                    }
                    break;

            }

            // InternalTextualScenario.g:877:3: ( (lv_return_4_0= 'withReturn' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalTextualScenario.g:878:4: (lv_return_4_0= 'withReturn' )
                    {
                    // InternalTextualScenario.g:878:4: (lv_return_4_0= 'withReturn' )
                    // InternalTextualScenario.g:879:5: lv_return_4_0= 'withReturn'
                    {
                    lv_return_4_0=(Token)match(input,23,FOLLOW_10); 

                    					newLeafNode(lv_return_4_0, grammarAccess.getSequenceMessageAccess().getReturnWithReturnKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSequenceMessageRule());
                    					}
                    					setWithLastConsumed(current, "return", lv_return_4_0, "withReturn");
                    				

                    }


                    }
                    break;

            }

            // InternalTextualScenario.g:891:3: ( (lv_doubleDot_5_0= ':' ) )
            // InternalTextualScenario.g:892:4: (lv_doubleDot_5_0= ':' )
            {
            // InternalTextualScenario.g:892:4: (lv_doubleDot_5_0= ':' )
            // InternalTextualScenario.g:893:5: lv_doubleDot_5_0= ':'
            {
            lv_doubleDot_5_0=(Token)match(input,24,FOLLOW_6); 

            					newLeafNode(lv_doubleDot_5_0, grammarAccess.getSequenceMessageAccess().getDoubleDotColonKeyword_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSequenceMessageRule());
            					}
            					setWithLastConsumed(current, "doubleDot", lv_doubleDot_5_0, ":");
            				

            }


            }

            // InternalTextualScenario.g:905:3: ( (lv_name_6_0= RULE_STRING ) )
            // InternalTextualScenario.g:906:4: (lv_name_6_0= RULE_STRING )
            {
            // InternalTextualScenario.g:906:4: (lv_name_6_0= RULE_STRING )
            // InternalTextualScenario.g:907:5: lv_name_6_0= RULE_STRING
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
    // InternalTextualScenario.g:927:1: entryRuleCreateMessage returns [EObject current=null] : iv_ruleCreateMessage= ruleCreateMessage EOF ;
    public final EObject entryRuleCreateMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreateMessage = null;


        try {
            // InternalTextualScenario.g:927:54: (iv_ruleCreateMessage= ruleCreateMessage EOF )
            // InternalTextualScenario.g:928:2: iv_ruleCreateMessage= ruleCreateMessage EOF
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
    // InternalTextualScenario.g:934:1: ruleCreateMessage returns [EObject current=null] : ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->+' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleCreateMessage() throws RecognitionException {
        EObject current = null;

        Token lv_source_0_0=null;
        Token lv_arrow_1_0=null;
        Token lv_target_2_0=null;
        Token lv_doubleDot_3_0=null;
        Token lv_name_4_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:940:2: ( ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->+' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:941:2: ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->+' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:941:2: ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->+' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:942:3: ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->+' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:942:3: ( (lv_source_0_0= RULE_STRING ) )
            // InternalTextualScenario.g:943:4: (lv_source_0_0= RULE_STRING )
            {
            // InternalTextualScenario.g:943:4: (lv_source_0_0= RULE_STRING )
            // InternalTextualScenario.g:944:5: lv_source_0_0= RULE_STRING
            {
            lv_source_0_0=(Token)match(input,RULE_STRING,FOLLOW_11); 

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

            // InternalTextualScenario.g:960:3: ( (lv_arrow_1_0= '->+' ) )
            // InternalTextualScenario.g:961:4: (lv_arrow_1_0= '->+' )
            {
            // InternalTextualScenario.g:961:4: (lv_arrow_1_0= '->+' )
            // InternalTextualScenario.g:962:5: lv_arrow_1_0= '->+'
            {
            lv_arrow_1_0=(Token)match(input,25,FOLLOW_6); 

            					newLeafNode(lv_arrow_1_0, grammarAccess.getCreateMessageAccess().getArrowHyphenMinusGreaterThanSignPlusSignKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCreateMessageRule());
            					}
            					setWithLastConsumed(current, "arrow", lv_arrow_1_0, "->+");
            				

            }


            }

            // InternalTextualScenario.g:974:3: ( (lv_target_2_0= RULE_STRING ) )
            // InternalTextualScenario.g:975:4: (lv_target_2_0= RULE_STRING )
            {
            // InternalTextualScenario.g:975:4: (lv_target_2_0= RULE_STRING )
            // InternalTextualScenario.g:976:5: lv_target_2_0= RULE_STRING
            {
            lv_target_2_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

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

            // InternalTextualScenario.g:992:3: ( (lv_doubleDot_3_0= ':' ) )
            // InternalTextualScenario.g:993:4: (lv_doubleDot_3_0= ':' )
            {
            // InternalTextualScenario.g:993:4: (lv_doubleDot_3_0= ':' )
            // InternalTextualScenario.g:994:5: lv_doubleDot_3_0= ':'
            {
            lv_doubleDot_3_0=(Token)match(input,24,FOLLOW_6); 

            					newLeafNode(lv_doubleDot_3_0, grammarAccess.getCreateMessageAccess().getDoubleDotColonKeyword_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCreateMessageRule());
            					}
            					setWithLastConsumed(current, "doubleDot", lv_doubleDot_3_0, ":");
            				

            }


            }

            // InternalTextualScenario.g:1006:3: ( (lv_name_4_0= RULE_STRING ) )
            // InternalTextualScenario.g:1007:4: (lv_name_4_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1007:4: (lv_name_4_0= RULE_STRING )
            // InternalTextualScenario.g:1008:5: lv_name_4_0= RULE_STRING
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
    // InternalTextualScenario.g:1028:1: entryRuleDeleteMessage returns [EObject current=null] : iv_ruleDeleteMessage= ruleDeleteMessage EOF ;
    public final EObject entryRuleDeleteMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeleteMessage = null;


        try {
            // InternalTextualScenario.g:1028:54: (iv_ruleDeleteMessage= ruleDeleteMessage EOF )
            // InternalTextualScenario.g:1029:2: iv_ruleDeleteMessage= ruleDeleteMessage EOF
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
    // InternalTextualScenario.g:1035:1: ruleDeleteMessage returns [EObject current=null] : ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->x' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleDeleteMessage() throws RecognitionException {
        EObject current = null;

        Token lv_source_0_0=null;
        Token lv_arrow_1_0=null;
        Token lv_target_2_0=null;
        Token lv_doubleDot_3_0=null;
        Token lv_name_4_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:1041:2: ( ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->x' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:1042:2: ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->x' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:1042:2: ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->x' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:1043:3: ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->x' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:1043:3: ( (lv_source_0_0= RULE_STRING ) )
            // InternalTextualScenario.g:1044:4: (lv_source_0_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1044:4: (lv_source_0_0= RULE_STRING )
            // InternalTextualScenario.g:1045:5: lv_source_0_0= RULE_STRING
            {
            lv_source_0_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

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

            // InternalTextualScenario.g:1061:3: ( (lv_arrow_1_0= '->x' ) )
            // InternalTextualScenario.g:1062:4: (lv_arrow_1_0= '->x' )
            {
            // InternalTextualScenario.g:1062:4: (lv_arrow_1_0= '->x' )
            // InternalTextualScenario.g:1063:5: lv_arrow_1_0= '->x'
            {
            lv_arrow_1_0=(Token)match(input,26,FOLLOW_6); 

            					newLeafNode(lv_arrow_1_0, grammarAccess.getDeleteMessageAccess().getArrowXKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeleteMessageRule());
            					}
            					setWithLastConsumed(current, "arrow", lv_arrow_1_0, "->x");
            				

            }


            }

            // InternalTextualScenario.g:1075:3: ( (lv_target_2_0= RULE_STRING ) )
            // InternalTextualScenario.g:1076:4: (lv_target_2_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1076:4: (lv_target_2_0= RULE_STRING )
            // InternalTextualScenario.g:1077:5: lv_target_2_0= RULE_STRING
            {
            lv_target_2_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

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

            // InternalTextualScenario.g:1093:3: ( (lv_doubleDot_3_0= ':' ) )
            // InternalTextualScenario.g:1094:4: (lv_doubleDot_3_0= ':' )
            {
            // InternalTextualScenario.g:1094:4: (lv_doubleDot_3_0= ':' )
            // InternalTextualScenario.g:1095:5: lv_doubleDot_3_0= ':'
            {
            lv_doubleDot_3_0=(Token)match(input,24,FOLLOW_6); 

            					newLeafNode(lv_doubleDot_3_0, grammarAccess.getDeleteMessageAccess().getDoubleDotColonKeyword_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeleteMessageRule());
            					}
            					setWithLastConsumed(current, "doubleDot", lv_doubleDot_3_0, ":");
            				

            }


            }

            // InternalTextualScenario.g:1107:3: ( (lv_name_4_0= RULE_STRING ) )
            // InternalTextualScenario.g:1108:4: (lv_name_4_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1108:4: (lv_name_4_0= RULE_STRING )
            // InternalTextualScenario.g:1109:5: lv_name_4_0= RULE_STRING
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
    // InternalTextualScenario.g:1129:1: entryRuleArmTimerMessage returns [EObject current=null] : iv_ruleArmTimerMessage= ruleArmTimerMessage EOF ;
    public final EObject entryRuleArmTimerMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArmTimerMessage = null;


        try {
            // InternalTextualScenario.g:1129:56: (iv_ruleArmTimerMessage= ruleArmTimerMessage EOF )
            // InternalTextualScenario.g:1130:2: iv_ruleArmTimerMessage= ruleArmTimerMessage EOF
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
    // InternalTextualScenario.g:1136:1: ruleArmTimerMessage returns [EObject current=null] : ( ( (lv_arrow_0_0= '->>' ) ) ( (lv_participant_1_0= RULE_STRING ) ) ( (lv_execution_2_0= 'withExecution' ) )? ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleArmTimerMessage() throws RecognitionException {
        EObject current = null;

        Token lv_arrow_0_0=null;
        Token lv_participant_1_0=null;
        Token lv_execution_2_0=null;
        Token lv_doubleDot_3_0=null;
        Token lv_name_4_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:1142:2: ( ( ( (lv_arrow_0_0= '->>' ) ) ( (lv_participant_1_0= RULE_STRING ) ) ( (lv_execution_2_0= 'withExecution' ) )? ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:1143:2: ( ( (lv_arrow_0_0= '->>' ) ) ( (lv_participant_1_0= RULE_STRING ) ) ( (lv_execution_2_0= 'withExecution' ) )? ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:1143:2: ( ( (lv_arrow_0_0= '->>' ) ) ( (lv_participant_1_0= RULE_STRING ) ) ( (lv_execution_2_0= 'withExecution' ) )? ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:1144:3: ( (lv_arrow_0_0= '->>' ) ) ( (lv_participant_1_0= RULE_STRING ) ) ( (lv_execution_2_0= 'withExecution' ) )? ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:1144:3: ( (lv_arrow_0_0= '->>' ) )
            // InternalTextualScenario.g:1145:4: (lv_arrow_0_0= '->>' )
            {
            // InternalTextualScenario.g:1145:4: (lv_arrow_0_0= '->>' )
            // InternalTextualScenario.g:1146:5: lv_arrow_0_0= '->>'
            {
            lv_arrow_0_0=(Token)match(input,27,FOLLOW_6); 

            					newLeafNode(lv_arrow_0_0, grammarAccess.getArmTimerMessageAccess().getArrowHyphenMinusGreaterThanSignGreaterThanSignKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArmTimerMessageRule());
            					}
            					setWithLastConsumed(current, "arrow", lv_arrow_0_0, "->>");
            				

            }


            }

            // InternalTextualScenario.g:1158:3: ( (lv_participant_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:1159:4: (lv_participant_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1159:4: (lv_participant_1_0= RULE_STRING )
            // InternalTextualScenario.g:1160:5: lv_participant_1_0= RULE_STRING
            {
            lv_participant_1_0=(Token)match(input,RULE_STRING,FOLLOW_13); 

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

            // InternalTextualScenario.g:1176:3: ( (lv_execution_2_0= 'withExecution' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTextualScenario.g:1177:4: (lv_execution_2_0= 'withExecution' )
                    {
                    // InternalTextualScenario.g:1177:4: (lv_execution_2_0= 'withExecution' )
                    // InternalTextualScenario.g:1178:5: lv_execution_2_0= 'withExecution'
                    {
                    lv_execution_2_0=(Token)match(input,22,FOLLOW_10); 

                    					newLeafNode(lv_execution_2_0, grammarAccess.getArmTimerMessageAccess().getExecutionWithExecutionKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getArmTimerMessageRule());
                    					}
                    					setWithLastConsumed(current, "execution", lv_execution_2_0, "withExecution");
                    				

                    }


                    }
                    break;

            }

            // InternalTextualScenario.g:1190:3: ( (lv_doubleDot_3_0= ':' ) )
            // InternalTextualScenario.g:1191:4: (lv_doubleDot_3_0= ':' )
            {
            // InternalTextualScenario.g:1191:4: (lv_doubleDot_3_0= ':' )
            // InternalTextualScenario.g:1192:5: lv_doubleDot_3_0= ':'
            {
            lv_doubleDot_3_0=(Token)match(input,24,FOLLOW_6); 

            					newLeafNode(lv_doubleDot_3_0, grammarAccess.getArmTimerMessageAccess().getDoubleDotColonKeyword_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArmTimerMessageRule());
            					}
            					setWithLastConsumed(current, "doubleDot", lv_doubleDot_3_0, ":");
            				

            }


            }

            // InternalTextualScenario.g:1204:3: ( (lv_name_4_0= RULE_STRING ) )
            // InternalTextualScenario.g:1205:4: (lv_name_4_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1205:4: (lv_name_4_0= RULE_STRING )
            // InternalTextualScenario.g:1206:5: lv_name_4_0= RULE_STRING
            {
            lv_name_4_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_4_0, grammarAccess.getArmTimerMessageAccess().getNameSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArmTimerMessageRule());
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
    // $ANTLR end "ruleArmTimerMessage"


    // $ANTLR start "entryRuleLostFoundMessage"
    // InternalTextualScenario.g:1226:1: entryRuleLostFoundMessage returns [EObject current=null] : iv_ruleLostFoundMessage= ruleLostFoundMessage EOF ;
    public final EObject entryRuleLostFoundMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLostFoundMessage = null;


        try {
            // InternalTextualScenario.g:1226:57: (iv_ruleLostFoundMessage= ruleLostFoundMessage EOF )
            // InternalTextualScenario.g:1227:2: iv_ruleLostFoundMessage= ruleLostFoundMessage EOF
            {
             newCompositeNode(grammarAccess.getLostFoundMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLostFoundMessage=ruleLostFoundMessage();

            state._fsp--;

             current =iv_ruleLostFoundMessage; 
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
    // $ANTLR end "entryRuleLostFoundMessage"


    // $ANTLR start "ruleLostFoundMessage"
    // InternalTextualScenario.g:1233:1: ruleLostFoundMessage returns [EObject current=null] : (this_LostMessage_0= ruleLostMessage | this_FoundMessage_1= ruleFoundMessage ) ;
    public final EObject ruleLostFoundMessage() throws RecognitionException {
        EObject current = null;

        EObject this_LostMessage_0 = null;

        EObject this_FoundMessage_1 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:1239:2: ( (this_LostMessage_0= ruleLostMessage | this_FoundMessage_1= ruleFoundMessage ) )
            // InternalTextualScenario.g:1240:2: (this_LostMessage_0= ruleLostMessage | this_FoundMessage_1= ruleFoundMessage )
            {
            // InternalTextualScenario.g:1240:2: (this_LostMessage_0= ruleLostMessage | this_FoundMessage_1= ruleFoundMessage )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_STRING) ) {
                alt12=1;
            }
            else if ( (LA12_0==29) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalTextualScenario.g:1241:3: this_LostMessage_0= ruleLostMessage
                    {

                    			newCompositeNode(grammarAccess.getLostFoundMessageAccess().getLostMessageParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_LostMessage_0=ruleLostMessage();

                    state._fsp--;


                    			current = this_LostMessage_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:1250:3: this_FoundMessage_1= ruleFoundMessage
                    {

                    			newCompositeNode(grammarAccess.getLostFoundMessageAccess().getFoundMessageParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_FoundMessage_1=ruleFoundMessage();

                    state._fsp--;


                    			current = this_FoundMessage_1;
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
    // $ANTLR end "ruleLostFoundMessage"


    // $ANTLR start "entryRuleLostMessage"
    // InternalTextualScenario.g:1262:1: entryRuleLostMessage returns [EObject current=null] : iv_ruleLostMessage= ruleLostMessage EOF ;
    public final EObject entryRuleLostMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLostMessage = null;


        try {
            // InternalTextualScenario.g:1262:52: (iv_ruleLostMessage= ruleLostMessage EOF )
            // InternalTextualScenario.g:1263:2: iv_ruleLostMessage= ruleLostMessage EOF
            {
             newCompositeNode(grammarAccess.getLostMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLostMessage=ruleLostMessage();

            state._fsp--;

             current =iv_ruleLostMessage; 
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
    // $ANTLR end "entryRuleLostMessage"


    // $ANTLR start "ruleLostMessage"
    // InternalTextualScenario.g:1269:1: ruleLostMessage returns [EObject current=null] : ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->o' ) ) ( (lv_doubleDot_2_0= ':' ) ) ( (lv_name_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleLostMessage() throws RecognitionException {
        EObject current = null;

        Token lv_source_0_0=null;
        Token lv_arrow_1_0=null;
        Token lv_doubleDot_2_0=null;
        Token lv_name_3_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:1275:2: ( ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->o' ) ) ( (lv_doubleDot_2_0= ':' ) ) ( (lv_name_3_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:1276:2: ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->o' ) ) ( (lv_doubleDot_2_0= ':' ) ) ( (lv_name_3_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:1276:2: ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->o' ) ) ( (lv_doubleDot_2_0= ':' ) ) ( (lv_name_3_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:1277:3: ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->o' ) ) ( (lv_doubleDot_2_0= ':' ) ) ( (lv_name_3_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:1277:3: ( (lv_source_0_0= RULE_STRING ) )
            // InternalTextualScenario.g:1278:4: (lv_source_0_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1278:4: (lv_source_0_0= RULE_STRING )
            // InternalTextualScenario.g:1279:5: lv_source_0_0= RULE_STRING
            {
            lv_source_0_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

            					newLeafNode(lv_source_0_0, grammarAccess.getLostMessageAccess().getSourceSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLostMessageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"source",
            						lv_source_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalTextualScenario.g:1295:3: ( (lv_arrow_1_0= '->o' ) )
            // InternalTextualScenario.g:1296:4: (lv_arrow_1_0= '->o' )
            {
            // InternalTextualScenario.g:1296:4: (lv_arrow_1_0= '->o' )
            // InternalTextualScenario.g:1297:5: lv_arrow_1_0= '->o'
            {
            lv_arrow_1_0=(Token)match(input,28,FOLLOW_10); 

            					newLeafNode(lv_arrow_1_0, grammarAccess.getLostMessageAccess().getArrowOKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLostMessageRule());
            					}
            					setWithLastConsumed(current, "arrow", lv_arrow_1_0, "->o");
            				

            }


            }

            // InternalTextualScenario.g:1309:3: ( (lv_doubleDot_2_0= ':' ) )
            // InternalTextualScenario.g:1310:4: (lv_doubleDot_2_0= ':' )
            {
            // InternalTextualScenario.g:1310:4: (lv_doubleDot_2_0= ':' )
            // InternalTextualScenario.g:1311:5: lv_doubleDot_2_0= ':'
            {
            lv_doubleDot_2_0=(Token)match(input,24,FOLLOW_6); 

            					newLeafNode(lv_doubleDot_2_0, grammarAccess.getLostMessageAccess().getDoubleDotColonKeyword_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLostMessageRule());
            					}
            					setWithLastConsumed(current, "doubleDot", lv_doubleDot_2_0, ":");
            				

            }


            }

            // InternalTextualScenario.g:1323:3: ( (lv_name_3_0= RULE_STRING ) )
            // InternalTextualScenario.g:1324:4: (lv_name_3_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1324:4: (lv_name_3_0= RULE_STRING )
            // InternalTextualScenario.g:1325:5: lv_name_3_0= RULE_STRING
            {
            lv_name_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_3_0, grammarAccess.getLostMessageAccess().getNameSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLostMessageRule());
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
    // $ANTLR end "ruleLostMessage"


    // $ANTLR start "entryRuleFoundMessage"
    // InternalTextualScenario.g:1345:1: entryRuleFoundMessage returns [EObject current=null] : iv_ruleFoundMessage= ruleFoundMessage EOF ;
    public final EObject entryRuleFoundMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFoundMessage = null;


        try {
            // InternalTextualScenario.g:1345:53: (iv_ruleFoundMessage= ruleFoundMessage EOF )
            // InternalTextualScenario.g:1346:2: iv_ruleFoundMessage= ruleFoundMessage EOF
            {
             newCompositeNode(grammarAccess.getFoundMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFoundMessage=ruleFoundMessage();

            state._fsp--;

             current =iv_ruleFoundMessage; 
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
    // $ANTLR end "entryRuleFoundMessage"


    // $ANTLR start "ruleFoundMessage"
    // InternalTextualScenario.g:1352:1: ruleFoundMessage returns [EObject current=null] : ( ( (lv_arrow_0_0= 'o->' ) ) ( (lv_target_1_0= RULE_STRING ) ) ( (lv_doubleDot_2_0= ':' ) ) ( (lv_name_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleFoundMessage() throws RecognitionException {
        EObject current = null;

        Token lv_arrow_0_0=null;
        Token lv_target_1_0=null;
        Token lv_doubleDot_2_0=null;
        Token lv_name_3_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:1358:2: ( ( ( (lv_arrow_0_0= 'o->' ) ) ( (lv_target_1_0= RULE_STRING ) ) ( (lv_doubleDot_2_0= ':' ) ) ( (lv_name_3_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:1359:2: ( ( (lv_arrow_0_0= 'o->' ) ) ( (lv_target_1_0= RULE_STRING ) ) ( (lv_doubleDot_2_0= ':' ) ) ( (lv_name_3_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:1359:2: ( ( (lv_arrow_0_0= 'o->' ) ) ( (lv_target_1_0= RULE_STRING ) ) ( (lv_doubleDot_2_0= ':' ) ) ( (lv_name_3_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:1360:3: ( (lv_arrow_0_0= 'o->' ) ) ( (lv_target_1_0= RULE_STRING ) ) ( (lv_doubleDot_2_0= ':' ) ) ( (lv_name_3_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:1360:3: ( (lv_arrow_0_0= 'o->' ) )
            // InternalTextualScenario.g:1361:4: (lv_arrow_0_0= 'o->' )
            {
            // InternalTextualScenario.g:1361:4: (lv_arrow_0_0= 'o->' )
            // InternalTextualScenario.g:1362:5: lv_arrow_0_0= 'o->'
            {
            lv_arrow_0_0=(Token)match(input,29,FOLLOW_6); 

            					newLeafNode(lv_arrow_0_0, grammarAccess.getFoundMessageAccess().getArrowOKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFoundMessageRule());
            					}
            					setWithLastConsumed(current, "arrow", lv_arrow_0_0, "o->");
            				

            }


            }

            // InternalTextualScenario.g:1374:3: ( (lv_target_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:1375:4: (lv_target_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1375:4: (lv_target_1_0= RULE_STRING )
            // InternalTextualScenario.g:1376:5: lv_target_1_0= RULE_STRING
            {
            lv_target_1_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            					newLeafNode(lv_target_1_0, grammarAccess.getFoundMessageAccess().getTargetSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFoundMessageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"target",
            						lv_target_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalTextualScenario.g:1392:3: ( (lv_doubleDot_2_0= ':' ) )
            // InternalTextualScenario.g:1393:4: (lv_doubleDot_2_0= ':' )
            {
            // InternalTextualScenario.g:1393:4: (lv_doubleDot_2_0= ':' )
            // InternalTextualScenario.g:1394:5: lv_doubleDot_2_0= ':'
            {
            lv_doubleDot_2_0=(Token)match(input,24,FOLLOW_6); 

            					newLeafNode(lv_doubleDot_2_0, grammarAccess.getFoundMessageAccess().getDoubleDotColonKeyword_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFoundMessageRule());
            					}
            					setWithLastConsumed(current, "doubleDot", lv_doubleDot_2_0, ":");
            				

            }


            }

            // InternalTextualScenario.g:1406:3: ( (lv_name_3_0= RULE_STRING ) )
            // InternalTextualScenario.g:1407:4: (lv_name_3_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1407:4: (lv_name_3_0= RULE_STRING )
            // InternalTextualScenario.g:1408:5: lv_name_3_0= RULE_STRING
            {
            lv_name_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_3_0, grammarAccess.getFoundMessageAccess().getNameSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFoundMessageRule());
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
    // $ANTLR end "ruleFoundMessage"


    // $ANTLR start "entryRuleParticipantDeactivation"
    // InternalTextualScenario.g:1428:1: entryRuleParticipantDeactivation returns [EObject current=null] : iv_ruleParticipantDeactivation= ruleParticipantDeactivation EOF ;
    public final EObject entryRuleParticipantDeactivation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParticipantDeactivation = null;


        try {
            // InternalTextualScenario.g:1428:64: (iv_ruleParticipantDeactivation= ruleParticipantDeactivation EOF )
            // InternalTextualScenario.g:1429:2: iv_ruleParticipantDeactivation= ruleParticipantDeactivation EOF
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
    // InternalTextualScenario.g:1435:1: ruleParticipantDeactivation returns [EObject current=null] : ( ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleParticipantDeactivation() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:1441:2: ( ( ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:1442:2: ( ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:1442:2: ( ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:1443:3: ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:1443:3: ( (lv_keyword_0_0= 'deactivate' ) )
            // InternalTextualScenario.g:1444:4: (lv_keyword_0_0= 'deactivate' )
            {
            // InternalTextualScenario.g:1444:4: (lv_keyword_0_0= 'deactivate' )
            // InternalTextualScenario.g:1445:5: lv_keyword_0_0= 'deactivate'
            {
            lv_keyword_0_0=(Token)match(input,30,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParticipantDeactivationRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "deactivate");
            				

            }


            }

            // InternalTextualScenario.g:1457:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:1458:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1458:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:1459:5: lv_name_1_0= RULE_STRING
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


    // $ANTLR start "entryRuleCombinedFragment"
    // InternalTextualScenario.g:1479:1: entryRuleCombinedFragment returns [EObject current=null] : iv_ruleCombinedFragment= ruleCombinedFragment EOF ;
    public final EObject entryRuleCombinedFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombinedFragment = null;


        try {
            // InternalTextualScenario.g:1479:57: (iv_ruleCombinedFragment= ruleCombinedFragment EOF )
            // InternalTextualScenario.g:1480:2: iv_ruleCombinedFragment= ruleCombinedFragment EOF
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
    // InternalTextualScenario.g:1486:1: ruleCombinedFragment returns [EObject current=null] : ( ( ( (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' | lv_keyword_0_11= 'unset' ) ) ) ( (lv_expression_1_0= RULE_STRING ) )? ( (lv_over_2_0= 'over' ) ) ( (lv_timelines_3_0= RULE_STRING ) )+ ( (lv_block_4_0= ruleBlock ) ) ( (lv_operands_5_0= ruleOperand ) )* ) ;
    public final EObject ruleCombinedFragment() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_1=null;
        Token lv_keyword_0_2=null;
        Token lv_keyword_0_3=null;
        Token lv_keyword_0_4=null;
        Token lv_keyword_0_5=null;
        Token lv_keyword_0_6=null;
        Token lv_keyword_0_7=null;
        Token lv_keyword_0_8=null;
        Token lv_keyword_0_9=null;
        Token lv_keyword_0_10=null;
        Token lv_keyword_0_11=null;
        Token lv_expression_1_0=null;
        Token lv_over_2_0=null;
        Token lv_timelines_3_0=null;
        EObject lv_block_4_0 = null;

        EObject lv_operands_5_0 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:1492:2: ( ( ( ( (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' | lv_keyword_0_11= 'unset' ) ) ) ( (lv_expression_1_0= RULE_STRING ) )? ( (lv_over_2_0= 'over' ) ) ( (lv_timelines_3_0= RULE_STRING ) )+ ( (lv_block_4_0= ruleBlock ) ) ( (lv_operands_5_0= ruleOperand ) )* ) )
            // InternalTextualScenario.g:1493:2: ( ( ( (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' | lv_keyword_0_11= 'unset' ) ) ) ( (lv_expression_1_0= RULE_STRING ) )? ( (lv_over_2_0= 'over' ) ) ( (lv_timelines_3_0= RULE_STRING ) )+ ( (lv_block_4_0= ruleBlock ) ) ( (lv_operands_5_0= ruleOperand ) )* )
            {
            // InternalTextualScenario.g:1493:2: ( ( ( (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' | lv_keyword_0_11= 'unset' ) ) ) ( (lv_expression_1_0= RULE_STRING ) )? ( (lv_over_2_0= 'over' ) ) ( (lv_timelines_3_0= RULE_STRING ) )+ ( (lv_block_4_0= ruleBlock ) ) ( (lv_operands_5_0= ruleOperand ) )* )
            // InternalTextualScenario.g:1494:3: ( ( (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' | lv_keyword_0_11= 'unset' ) ) ) ( (lv_expression_1_0= RULE_STRING ) )? ( (lv_over_2_0= 'over' ) ) ( (lv_timelines_3_0= RULE_STRING ) )+ ( (lv_block_4_0= ruleBlock ) ) ( (lv_operands_5_0= ruleOperand ) )*
            {
            // InternalTextualScenario.g:1494:3: ( ( (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' | lv_keyword_0_11= 'unset' ) ) )
            // InternalTextualScenario.g:1495:4: ( (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' | lv_keyword_0_11= 'unset' ) )
            {
            // InternalTextualScenario.g:1495:4: ( (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' | lv_keyword_0_11= 'unset' ) )
            // InternalTextualScenario.g:1496:5: (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' | lv_keyword_0_11= 'unset' )
            {
            // InternalTextualScenario.g:1496:5: (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' | lv_keyword_0_11= 'unset' )
            int alt13=11;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt13=1;
                }
                break;
            case 32:
                {
                alt13=2;
                }
                break;
            case 33:
                {
                alt13=3;
                }
                break;
            case 34:
                {
                alt13=4;
                }
                break;
            case 35:
                {
                alt13=5;
                }
                break;
            case 36:
                {
                alt13=6;
                }
                break;
            case 37:
                {
                alt13=7;
                }
                break;
            case 38:
                {
                alt13=8;
                }
                break;
            case 39:
                {
                alt13=9;
                }
                break;
            case 40:
                {
                alt13=10;
                }
                break;
            case 41:
                {
                alt13=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalTextualScenario.g:1497:6: lv_keyword_0_1= 'alt'
                    {
                    lv_keyword_0_1=(Token)match(input,31,FOLLOW_15); 

                    						newLeafNode(lv_keyword_0_1, grammarAccess.getCombinedFragmentAccess().getKeywordAltKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                    						}
                    						setWithLastConsumed(current, "keyword", lv_keyword_0_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:1508:6: lv_keyword_0_2= 'loop'
                    {
                    lv_keyword_0_2=(Token)match(input,32,FOLLOW_15); 

                    						newLeafNode(lv_keyword_0_2, grammarAccess.getCombinedFragmentAccess().getKeywordLoopKeyword_0_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                    						}
                    						setWithLastConsumed(current, "keyword", lv_keyword_0_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:1519:6: lv_keyword_0_3= 'par'
                    {
                    lv_keyword_0_3=(Token)match(input,33,FOLLOW_15); 

                    						newLeafNode(lv_keyword_0_3, grammarAccess.getCombinedFragmentAccess().getKeywordParKeyword_0_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                    						}
                    						setWithLastConsumed(current, "keyword", lv_keyword_0_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalTextualScenario.g:1530:6: lv_keyword_0_4= 'assert'
                    {
                    lv_keyword_0_4=(Token)match(input,34,FOLLOW_15); 

                    						newLeafNode(lv_keyword_0_4, grammarAccess.getCombinedFragmentAccess().getKeywordAssertKeyword_0_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                    						}
                    						setWithLastConsumed(current, "keyword", lv_keyword_0_4, null);
                    					

                    }
                    break;
                case 5 :
                    // InternalTextualScenario.g:1541:6: lv_keyword_0_5= 'critical'
                    {
                    lv_keyword_0_5=(Token)match(input,35,FOLLOW_15); 

                    						newLeafNode(lv_keyword_0_5, grammarAccess.getCombinedFragmentAccess().getKeywordCriticalKeyword_0_0_4());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                    						}
                    						setWithLastConsumed(current, "keyword", lv_keyword_0_5, null);
                    					

                    }
                    break;
                case 6 :
                    // InternalTextualScenario.g:1552:6: lv_keyword_0_6= 'ignore'
                    {
                    lv_keyword_0_6=(Token)match(input,36,FOLLOW_15); 

                    						newLeafNode(lv_keyword_0_6, grammarAccess.getCombinedFragmentAccess().getKeywordIgnoreKeyword_0_0_5());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                    						}
                    						setWithLastConsumed(current, "keyword", lv_keyword_0_6, null);
                    					

                    }
                    break;
                case 7 :
                    // InternalTextualScenario.g:1563:6: lv_keyword_0_7= 'neg'
                    {
                    lv_keyword_0_7=(Token)match(input,37,FOLLOW_15); 

                    						newLeafNode(lv_keyword_0_7, grammarAccess.getCombinedFragmentAccess().getKeywordNegKeyword_0_0_6());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                    						}
                    						setWithLastConsumed(current, "keyword", lv_keyword_0_7, null);
                    					

                    }
                    break;
                case 8 :
                    // InternalTextualScenario.g:1574:6: lv_keyword_0_8= 'opt'
                    {
                    lv_keyword_0_8=(Token)match(input,38,FOLLOW_15); 

                    						newLeafNode(lv_keyword_0_8, grammarAccess.getCombinedFragmentAccess().getKeywordOptKeyword_0_0_7());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                    						}
                    						setWithLastConsumed(current, "keyword", lv_keyword_0_8, null);
                    					

                    }
                    break;
                case 9 :
                    // InternalTextualScenario.g:1585:6: lv_keyword_0_9= 'seq'
                    {
                    lv_keyword_0_9=(Token)match(input,39,FOLLOW_15); 

                    						newLeafNode(lv_keyword_0_9, grammarAccess.getCombinedFragmentAccess().getKeywordSeqKeyword_0_0_8());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                    						}
                    						setWithLastConsumed(current, "keyword", lv_keyword_0_9, null);
                    					

                    }
                    break;
                case 10 :
                    // InternalTextualScenario.g:1596:6: lv_keyword_0_10= 'strict'
                    {
                    lv_keyword_0_10=(Token)match(input,40,FOLLOW_15); 

                    						newLeafNode(lv_keyword_0_10, grammarAccess.getCombinedFragmentAccess().getKeywordStrictKeyword_0_0_9());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                    						}
                    						setWithLastConsumed(current, "keyword", lv_keyword_0_10, null);
                    					

                    }
                    break;
                case 11 :
                    // InternalTextualScenario.g:1607:6: lv_keyword_0_11= 'unset'
                    {
                    lv_keyword_0_11=(Token)match(input,41,FOLLOW_15); 

                    						newLeafNode(lv_keyword_0_11, grammarAccess.getCombinedFragmentAccess().getKeywordUnsetKeyword_0_0_10());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                    						}
                    						setWithLastConsumed(current, "keyword", lv_keyword_0_11, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalTextualScenario.g:1620:3: ( (lv_expression_1_0= RULE_STRING ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_STRING) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalTextualScenario.g:1621:4: (lv_expression_1_0= RULE_STRING )
                    {
                    // InternalTextualScenario.g:1621:4: (lv_expression_1_0= RULE_STRING )
                    // InternalTextualScenario.g:1622:5: lv_expression_1_0= RULE_STRING
                    {
                    lv_expression_1_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

                    					newLeafNode(lv_expression_1_0, grammarAccess.getCombinedFragmentAccess().getExpressionSTRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCombinedFragmentRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"expression",
                    						lv_expression_1_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }
                    break;

            }

            // InternalTextualScenario.g:1638:3: ( (lv_over_2_0= 'over' ) )
            // InternalTextualScenario.g:1639:4: (lv_over_2_0= 'over' )
            {
            // InternalTextualScenario.g:1639:4: (lv_over_2_0= 'over' )
            // InternalTextualScenario.g:1640:5: lv_over_2_0= 'over'
            {
            lv_over_2_0=(Token)match(input,42,FOLLOW_6); 

            					newLeafNode(lv_over_2_0, grammarAccess.getCombinedFragmentAccess().getOverOverKeyword_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCombinedFragmentRule());
            					}
            					setWithLastConsumed(current, "over", lv_over_2_0, "over");
            				

            }


            }

            // InternalTextualScenario.g:1652:3: ( (lv_timelines_3_0= RULE_STRING ) )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_STRING) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalTextualScenario.g:1653:4: (lv_timelines_3_0= RULE_STRING )
            	    {
            	    // InternalTextualScenario.g:1653:4: (lv_timelines_3_0= RULE_STRING )
            	    // InternalTextualScenario.g:1654:5: lv_timelines_3_0= RULE_STRING
            	    {
            	    lv_timelines_3_0=(Token)match(input,RULE_STRING,FOLLOW_17); 

            	    					newLeafNode(lv_timelines_3_0, grammarAccess.getCombinedFragmentAccess().getTimelinesSTRINGTerminalRuleCall_3_0());
            	    				

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getCombinedFragmentRule());
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
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            // InternalTextualScenario.g:1670:3: ( (lv_block_4_0= ruleBlock ) )
            // InternalTextualScenario.g:1671:4: (lv_block_4_0= ruleBlock )
            {
            // InternalTextualScenario.g:1671:4: (lv_block_4_0= ruleBlock )
            // InternalTextualScenario.g:1672:5: lv_block_4_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getCombinedFragmentAccess().getBlockBlockParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_18);
            lv_block_4_0=ruleBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCombinedFragmentRule());
            					}
            					set(
            						current,
            						"block",
            						lv_block_4_0,
            						"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Block");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTextualScenario.g:1689:3: ( (lv_operands_5_0= ruleOperand ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_STRING) ) {
                    int LA16_2 = input.LA(2);

                    if ( (LA16_2==12) ) {
                        alt16=1;
                    }


                }
                else if ( (LA16_0==12||LA16_0==43) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalTextualScenario.g:1690:4: (lv_operands_5_0= ruleOperand )
            	    {
            	    // InternalTextualScenario.g:1690:4: (lv_operands_5_0= ruleOperand )
            	    // InternalTextualScenario.g:1691:5: lv_operands_5_0= ruleOperand
            	    {

            	    					newCompositeNode(grammarAccess.getCombinedFragmentAccess().getOperandsOperandParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_operands_5_0=ruleOperand();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCombinedFragmentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"operands",
            	    						lv_operands_5_0,
            	    						"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Operand");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // $ANTLR end "ruleCombinedFragment"


    // $ANTLR start "entryRuleOperand"
    // InternalTextualScenario.g:1712:1: entryRuleOperand returns [EObject current=null] : iv_ruleOperand= ruleOperand EOF ;
    public final EObject entryRuleOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperand = null;


        try {
            // InternalTextualScenario.g:1712:48: (iv_ruleOperand= ruleOperand EOF )
            // InternalTextualScenario.g:1713:2: iv_ruleOperand= ruleOperand EOF
            {
             newCompositeNode(grammarAccess.getOperandRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperand=ruleOperand();

            state._fsp--;

             current =iv_ruleOperand; 
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
    // $ANTLR end "entryRuleOperand"


    // $ANTLR start "ruleOperand"
    // InternalTextualScenario.g:1719:1: ruleOperand returns [EObject current=null] : ( ( (lv_keyword_0_0= 'else' ) )? ( (lv_expression_1_0= RULE_STRING ) )? ( (lv_block_2_0= ruleBlock ) ) ) ;
    public final EObject ruleOperand() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_expression_1_0=null;
        EObject lv_block_2_0 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:1725:2: ( ( ( (lv_keyword_0_0= 'else' ) )? ( (lv_expression_1_0= RULE_STRING ) )? ( (lv_block_2_0= ruleBlock ) ) ) )
            // InternalTextualScenario.g:1726:2: ( ( (lv_keyword_0_0= 'else' ) )? ( (lv_expression_1_0= RULE_STRING ) )? ( (lv_block_2_0= ruleBlock ) ) )
            {
            // InternalTextualScenario.g:1726:2: ( ( (lv_keyword_0_0= 'else' ) )? ( (lv_expression_1_0= RULE_STRING ) )? ( (lv_block_2_0= ruleBlock ) ) )
            // InternalTextualScenario.g:1727:3: ( (lv_keyword_0_0= 'else' ) )? ( (lv_expression_1_0= RULE_STRING ) )? ( (lv_block_2_0= ruleBlock ) )
            {
            // InternalTextualScenario.g:1727:3: ( (lv_keyword_0_0= 'else' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==43) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalTextualScenario.g:1728:4: (lv_keyword_0_0= 'else' )
                    {
                    // InternalTextualScenario.g:1728:4: (lv_keyword_0_0= 'else' )
                    // InternalTextualScenario.g:1729:5: lv_keyword_0_0= 'else'
                    {
                    lv_keyword_0_0=(Token)match(input,43,FOLLOW_17); 

                    					newLeafNode(lv_keyword_0_0, grammarAccess.getOperandAccess().getKeywordElseKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperandRule());
                    					}
                    					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "else");
                    				

                    }


                    }
                    break;

            }

            // InternalTextualScenario.g:1741:3: ( (lv_expression_1_0= RULE_STRING ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_STRING) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalTextualScenario.g:1742:4: (lv_expression_1_0= RULE_STRING )
                    {
                    // InternalTextualScenario.g:1742:4: (lv_expression_1_0= RULE_STRING )
                    // InternalTextualScenario.g:1743:5: lv_expression_1_0= RULE_STRING
                    {
                    lv_expression_1_0=(Token)match(input,RULE_STRING,FOLLOW_3); 

                    					newLeafNode(lv_expression_1_0, grammarAccess.getOperandAccess().getExpressionSTRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperandRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"expression",
                    						lv_expression_1_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }
                    break;

            }

            // InternalTextualScenario.g:1759:3: ( (lv_block_2_0= ruleBlock ) )
            // InternalTextualScenario.g:1760:4: (lv_block_2_0= ruleBlock )
            {
            // InternalTextualScenario.g:1760:4: (lv_block_2_0= ruleBlock )
            // InternalTextualScenario.g:1761:5: lv_block_2_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getOperandAccess().getBlockBlockParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_block_2_0=ruleBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOperandRule());
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
    // $ANTLR end "ruleOperand"


    // $ANTLR start "entryRuleBlock"
    // InternalTextualScenario.g:1782:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // InternalTextualScenario.g:1782:46: (iv_ruleBlock= ruleBlock EOF )
            // InternalTextualScenario.g:1783:2: iv_ruleBlock= ruleBlock EOF
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
    // InternalTextualScenario.g:1789:1: ruleBlock returns [EObject current=null] : ( ( (lv_begin_0_0= '{' ) ) ( (lv_blockElements_1_0= ruleElement ) )* ( (lv_end_2_0= '}' ) ) ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token lv_begin_0_0=null;
        Token lv_end_2_0=null;
        EObject lv_blockElements_1_0 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:1795:2: ( ( ( (lv_begin_0_0= '{' ) ) ( (lv_blockElements_1_0= ruleElement ) )* ( (lv_end_2_0= '}' ) ) ) )
            // InternalTextualScenario.g:1796:2: ( ( (lv_begin_0_0= '{' ) ) ( (lv_blockElements_1_0= ruleElement ) )* ( (lv_end_2_0= '}' ) ) )
            {
            // InternalTextualScenario.g:1796:2: ( ( (lv_begin_0_0= '{' ) ) ( (lv_blockElements_1_0= ruleElement ) )* ( (lv_end_2_0= '}' ) ) )
            // InternalTextualScenario.g:1797:3: ( (lv_begin_0_0= '{' ) ) ( (lv_blockElements_1_0= ruleElement ) )* ( (lv_end_2_0= '}' ) )
            {
            // InternalTextualScenario.g:1797:3: ( (lv_begin_0_0= '{' ) )
            // InternalTextualScenario.g:1798:4: (lv_begin_0_0= '{' )
            {
            // InternalTextualScenario.g:1798:4: (lv_begin_0_0= '{' )
            // InternalTextualScenario.g:1799:5: lv_begin_0_0= '{'
            {
            lv_begin_0_0=(Token)match(input,12,FOLLOW_5); 

            					newLeafNode(lv_begin_0_0, grammarAccess.getBlockAccess().getBeginLeftCurlyBracketKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBlockRule());
            					}
            					setWithLastConsumed(current, "begin", lv_begin_0_0, "{");
            				

            }


            }

            // InternalTextualScenario.g:1811:3: ( (lv_blockElements_1_0= ruleElement ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_STRING||LA19_0==27||(LA19_0>=29 && LA19_0<=41)||LA19_0==44||LA19_0==47) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalTextualScenario.g:1812:4: (lv_blockElements_1_0= ruleElement )
            	    {
            	    // InternalTextualScenario.g:1812:4: (lv_blockElements_1_0= ruleElement )
            	    // InternalTextualScenario.g:1813:5: lv_blockElements_1_0= ruleElement
            	    {

            	    					newCompositeNode(grammarAccess.getBlockAccess().getBlockElementsElementParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_blockElements_1_0=ruleElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBlockRule());
            	    					}
            	    					add(
            	    						current,
            	    						"blockElements",
            	    						lv_blockElements_1_0,
            	    						"org.polarsys.capella.scenario.editor.dsl.TextualScenario.Element");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            // InternalTextualScenario.g:1830:3: ( (lv_end_2_0= '}' ) )
            // InternalTextualScenario.g:1831:4: (lv_end_2_0= '}' )
            {
            // InternalTextualScenario.g:1831:4: (lv_end_2_0= '}' )
            // InternalTextualScenario.g:1832:5: lv_end_2_0= '}'
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


    // $ANTLR start "entryRuleStateFragment"
    // InternalTextualScenario.g:1848:1: entryRuleStateFragment returns [EObject current=null] : iv_ruleStateFragment= ruleStateFragment EOF ;
    public final EObject entryRuleStateFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateFragment = null;


        try {
            // InternalTextualScenario.g:1848:54: (iv_ruleStateFragment= ruleStateFragment EOF )
            // InternalTextualScenario.g:1849:2: iv_ruleStateFragment= ruleStateFragment EOF
            {
             newCompositeNode(grammarAccess.getStateFragmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStateFragment=ruleStateFragment();

            state._fsp--;

             current =iv_ruleStateFragment; 
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
    // $ANTLR end "entryRuleStateFragment"


    // $ANTLR start "ruleStateFragment"
    // InternalTextualScenario.g:1855:1: ruleStateFragment returns [EObject current=null] : ( ( (lv_on_0_0= 'on' ) ) ( (lv_timeline_1_0= RULE_STRING ) ) ( ( (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' ) ) ) ( (lv_name_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleStateFragment() throws RecognitionException {
        EObject current = null;

        Token lv_on_0_0=null;
        Token lv_timeline_1_0=null;
        Token lv_keyword_2_1=null;
        Token lv_keyword_2_2=null;
        Token lv_keyword_2_3=null;
        Token lv_name_3_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:1861:2: ( ( ( (lv_on_0_0= 'on' ) ) ( (lv_timeline_1_0= RULE_STRING ) ) ( ( (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' ) ) ) ( (lv_name_3_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:1862:2: ( ( (lv_on_0_0= 'on' ) ) ( (lv_timeline_1_0= RULE_STRING ) ) ( ( (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' ) ) ) ( (lv_name_3_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:1862:2: ( ( (lv_on_0_0= 'on' ) ) ( (lv_timeline_1_0= RULE_STRING ) ) ( ( (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' ) ) ) ( (lv_name_3_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:1863:3: ( (lv_on_0_0= 'on' ) ) ( (lv_timeline_1_0= RULE_STRING ) ) ( ( (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' ) ) ) ( (lv_name_3_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:1863:3: ( (lv_on_0_0= 'on' ) )
            // InternalTextualScenario.g:1864:4: (lv_on_0_0= 'on' )
            {
            // InternalTextualScenario.g:1864:4: (lv_on_0_0= 'on' )
            // InternalTextualScenario.g:1865:5: lv_on_0_0= 'on'
            {
            lv_on_0_0=(Token)match(input,44,FOLLOW_6); 

            					newLeafNode(lv_on_0_0, grammarAccess.getStateFragmentAccess().getOnOnKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateFragmentRule());
            					}
            					setWithLastConsumed(current, "on", lv_on_0_0, "on");
            				

            }


            }

            // InternalTextualScenario.g:1877:3: ( (lv_timeline_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:1878:4: (lv_timeline_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1878:4: (lv_timeline_1_0= RULE_STRING )
            // InternalTextualScenario.g:1879:5: lv_timeline_1_0= RULE_STRING
            {
            lv_timeline_1_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

            					newLeafNode(lv_timeline_1_0, grammarAccess.getStateFragmentAccess().getTimelineSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateFragmentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"timeline",
            						lv_timeline_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalTextualScenario.g:1895:3: ( ( (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' ) ) )
            // InternalTextualScenario.g:1896:4: ( (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' ) )
            {
            // InternalTextualScenario.g:1896:4: ( (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' ) )
            // InternalTextualScenario.g:1897:5: (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' )
            {
            // InternalTextualScenario.g:1897:5: (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt20=1;
                }
                break;
            case 46:
                {
                alt20=2;
                }
                break;
            case 17:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalTextualScenario.g:1898:6: lv_keyword_2_1= 'state'
                    {
                    lv_keyword_2_1=(Token)match(input,45,FOLLOW_6); 

                    						newLeafNode(lv_keyword_2_1, grammarAccess.getStateFragmentAccess().getKeywordStateKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStateFragmentRule());
                    						}
                    						setWithLastConsumed(current, "keyword", lv_keyword_2_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:1909:6: lv_keyword_2_2= 'mode'
                    {
                    lv_keyword_2_2=(Token)match(input,46,FOLLOW_6); 

                    						newLeafNode(lv_keyword_2_2, grammarAccess.getStateFragmentAccess().getKeywordModeKeyword_2_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStateFragmentRule());
                    						}
                    						setWithLastConsumed(current, "keyword", lv_keyword_2_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:1920:6: lv_keyword_2_3= 'function'
                    {
                    lv_keyword_2_3=(Token)match(input,17,FOLLOW_6); 

                    						newLeafNode(lv_keyword_2_3, grammarAccess.getStateFragmentAccess().getKeywordFunctionKeyword_2_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStateFragmentRule());
                    						}
                    						setWithLastConsumed(current, "keyword", lv_keyword_2_3, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalTextualScenario.g:1933:3: ( (lv_name_3_0= RULE_STRING ) )
            // InternalTextualScenario.g:1934:4: (lv_name_3_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1934:4: (lv_name_3_0= RULE_STRING )
            // InternalTextualScenario.g:1935:5: lv_name_3_0= RULE_STRING
            {
            lv_name_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_3_0, grammarAccess.getStateFragmentAccess().getNameSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateFragmentRule());
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
    // $ANTLR end "ruleStateFragment"


    // $ANTLR start "entryRuleReference"
    // InternalTextualScenario.g:1955:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // InternalTextualScenario.g:1955:50: (iv_ruleReference= ruleReference EOF )
            // InternalTextualScenario.g:1956:2: iv_ruleReference= ruleReference EOF
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
    // InternalTextualScenario.g:1962:1: ruleReference returns [EObject current=null] : ( ( (lv_keyword_0_0= 'ref' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( (lv_over_2_0= 'over' ) ) ( (lv_timelines_3_0= RULE_STRING ) )+ ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;
        Token lv_over_2_0=null;
        Token lv_timelines_3_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:1968:2: ( ( ( (lv_keyword_0_0= 'ref' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( (lv_over_2_0= 'over' ) ) ( (lv_timelines_3_0= RULE_STRING ) )+ ) )
            // InternalTextualScenario.g:1969:2: ( ( (lv_keyword_0_0= 'ref' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( (lv_over_2_0= 'over' ) ) ( (lv_timelines_3_0= RULE_STRING ) )+ )
            {
            // InternalTextualScenario.g:1969:2: ( ( (lv_keyword_0_0= 'ref' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( (lv_over_2_0= 'over' ) ) ( (lv_timelines_3_0= RULE_STRING ) )+ )
            // InternalTextualScenario.g:1970:3: ( (lv_keyword_0_0= 'ref' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( (lv_over_2_0= 'over' ) ) ( (lv_timelines_3_0= RULE_STRING ) )+
            {
            // InternalTextualScenario.g:1970:3: ( (lv_keyword_0_0= 'ref' ) )
            // InternalTextualScenario.g:1971:4: (lv_keyword_0_0= 'ref' )
            {
            // InternalTextualScenario.g:1971:4: (lv_keyword_0_0= 'ref' )
            // InternalTextualScenario.g:1972:5: lv_keyword_0_0= 'ref'
            {
            lv_keyword_0_0=(Token)match(input,47,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferenceRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "ref");
            				

            }


            }

            // InternalTextualScenario.g:1984:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:1985:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1985:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:1986:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

            					newLeafNode(lv_name_1_0, grammarAccess.getReferenceAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferenceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalTextualScenario.g:2002:3: ( (lv_over_2_0= 'over' ) )
            // InternalTextualScenario.g:2003:4: (lv_over_2_0= 'over' )
            {
            // InternalTextualScenario.g:2003:4: (lv_over_2_0= 'over' )
            // InternalTextualScenario.g:2004:5: lv_over_2_0= 'over'
            {
            lv_over_2_0=(Token)match(input,42,FOLLOW_6); 

            					newLeafNode(lv_over_2_0, grammarAccess.getReferenceAccess().getOverOverKeyword_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferenceRule());
            					}
            					setWithLastConsumed(current, "over", lv_over_2_0, "over");
            				

            }


            }

            // InternalTextualScenario.g:2016:3: ( (lv_timelines_3_0= RULE_STRING ) )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_STRING) ) {
                    int LA21_2 = input.LA(2);

                    if ( (LA21_2==EOF||LA21_2==RULE_STRING||LA21_2==13||LA21_2==27||(LA21_2>=29 && LA21_2<=41)||LA21_2==44||LA21_2==47) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // InternalTextualScenario.g:2017:4: (lv_timelines_3_0= RULE_STRING )
            	    {
            	    // InternalTextualScenario.g:2017:4: (lv_timelines_3_0= RULE_STRING )
            	    // InternalTextualScenario.g:2018:5: lv_timelines_3_0= RULE_STRING
            	    {
            	    lv_timelines_3_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            	    					newLeafNode(lv_timelines_3_0, grammarAccess.getReferenceAccess().getTimelinesSTRINGTerminalRuleCall_3_0());
            	    				

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getReferenceRule());
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
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
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
    // $ANTLR end "ruleReference"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000093FFE81FE010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000093FFE8002010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000001C00000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000080000001012L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000600000020000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000012L});

}
