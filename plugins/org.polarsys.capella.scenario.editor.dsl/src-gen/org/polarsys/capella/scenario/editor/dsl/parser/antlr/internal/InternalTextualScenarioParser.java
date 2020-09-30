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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'scenario'", "'{'", "'}'", "'actor'", "'component'", "'unset'", "'behavior'", "'node'", "'configuration_item'", "'function'", "'activity'", "'entity'", "'role'", "'->'", "'withExecution'", "'withReturn'", "':'", "'->+'", "'->x'", "'->>'", "'deactivate'", "'ref'", "'over'", "'alt'", "'loop'", "'par'", "'assert'", "'critical'", "'ignore'", "'neg'", "'opt'", "'seq'", "'strict'", "'else'", "'on'", "'state'", "'mode'"
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
    // InternalTextualScenario.g:71:1: ruleModel returns [EObject current=null] : (otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant ) )* ( ( (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment | lv_elements_3_4= ruleStateFragment ) ) )* ( (lv_end_4_0= '}' ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_begin_1_0=null;
        Token lv_end_4_0=null;
        EObject lv_participants_2_0 = null;

        EObject lv_elements_3_1 = null;

        EObject lv_elements_3_2 = null;

        EObject lv_elements_3_3 = null;

        EObject lv_elements_3_4 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:77:2: ( (otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant ) )* ( ( (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment | lv_elements_3_4= ruleStateFragment ) ) )* ( (lv_end_4_0= '}' ) ) ) )
            // InternalTextualScenario.g:78:2: (otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant ) )* ( ( (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment | lv_elements_3_4= ruleStateFragment ) ) )* ( (lv_end_4_0= '}' ) ) )
            {
            // InternalTextualScenario.g:78:2: (otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant ) )* ( ( (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment | lv_elements_3_4= ruleStateFragment ) ) )* ( (lv_end_4_0= '}' ) ) )
            // InternalTextualScenario.g:79:3: otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant ) )* ( ( (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment | lv_elements_3_4= ruleStateFragment ) ) )* ( (lv_end_4_0= '}' ) )
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

            // InternalTextualScenario.g:116:3: ( ( (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment | lv_elements_3_4= ruleStateFragment ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_STRING||(LA3_0>=30 && LA3_0<=32)||(LA3_0>=34 && LA3_0<=43)||LA3_0==45) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalTextualScenario.g:117:4: ( (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment | lv_elements_3_4= ruleStateFragment ) )
            	    {
            	    // InternalTextualScenario.g:117:4: ( (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment | lv_elements_3_4= ruleStateFragment ) )
            	    // InternalTextualScenario.g:118:5: (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment | lv_elements_3_4= ruleStateFragment )
            	    {
            	    // InternalTextualScenario.g:118:5: (lv_elements_3_1= ruleMessage | lv_elements_3_2= ruleReference | lv_elements_3_3= ruleCombinedFragment | lv_elements_3_4= ruleStateFragment )
            	    int alt2=4;
            	    switch ( input.LA(1) ) {
            	    case RULE_STRING:
            	        {
            	        int LA2_1 = input.LA(2);

            	        if ( (LA2_1==33) ) {
            	            alt2=3;
            	        }
            	        else if ( (LA2_1==24||(LA2_1>=28 && LA2_1<=29)) ) {
            	            alt2=1;
            	        }
            	        else {
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 2, 1, input);

            	            throw nvae;
            	        }
            	        }
            	        break;
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
            	    case 35:
            	    case 36:
            	    case 37:
            	    case 38:
            	    case 39:
            	    case 40:
            	    case 41:
            	    case 42:
            	    case 43:
            	        {
            	        alt2=3;
            	        }
            	        break;
            	    case 45:
            	        {
            	        alt2=4;
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
            	        case 4 :
            	            // InternalTextualScenario.g:167:6: lv_elements_3_4= ruleStateFragment
            	            {

            	            						newCompositeNode(grammarAccess.getModelAccess().getElementsStateFragmentParserRuleCall_3_0_3());
            	            					
            	            pushFollow(FOLLOW_5);
            	            lv_elements_3_4=ruleStateFragment();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getModelRule());
            	            						}
            	            						add(
            	            							current,
            	            							"elements",
            	            							lv_elements_3_4,
            	            							"org.polarsys.capella.scenario.editor.dsl.TextualScenario.StateFragment");
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

            // InternalTextualScenario.g:185:3: ( (lv_end_4_0= '}' ) )
            // InternalTextualScenario.g:186:4: (lv_end_4_0= '}' )
            {
            // InternalTextualScenario.g:186:4: (lv_end_4_0= '}' )
            // InternalTextualScenario.g:187:5: lv_end_4_0= '}'
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
    // InternalTextualScenario.g:203:1: entryRuleParticipant returns [EObject current=null] : iv_ruleParticipant= ruleParticipant EOF ;
    public final EObject entryRuleParticipant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParticipant = null;


        try {
            // InternalTextualScenario.g:203:52: (iv_ruleParticipant= ruleParticipant EOF )
            // InternalTextualScenario.g:204:2: iv_ruleParticipant= ruleParticipant EOF
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
    // InternalTextualScenario.g:210:1: ruleParticipant returns [EObject current=null] : (this_GenericComponent_0= ruleGenericComponent | this_GenericFunction_1= ruleGenericFunction ) ;
    public final EObject ruleParticipant() throws RecognitionException {
        EObject current = null;

        EObject this_GenericComponent_0 = null;

        EObject this_GenericFunction_1 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:216:2: ( (this_GenericComponent_0= ruleGenericComponent | this_GenericFunction_1= ruleGenericFunction ) )
            // InternalTextualScenario.g:217:2: (this_GenericComponent_0= ruleGenericComponent | this_GenericFunction_1= ruleGenericFunction )
            {
            // InternalTextualScenario.g:217:2: (this_GenericComponent_0= ruleGenericComponent | this_GenericFunction_1= ruleGenericFunction )
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
                    // InternalTextualScenario.g:218:3: this_GenericComponent_0= ruleGenericComponent
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
                    // InternalTextualScenario.g:227:3: this_GenericFunction_1= ruleGenericFunction
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
    // InternalTextualScenario.g:239:1: entryRuleGenericComponent returns [EObject current=null] : iv_ruleGenericComponent= ruleGenericComponent EOF ;
    public final EObject entryRuleGenericComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenericComponent = null;


        try {
            // InternalTextualScenario.g:239:57: (iv_ruleGenericComponent= ruleGenericComponent EOF )
            // InternalTextualScenario.g:240:2: iv_ruleGenericComponent= ruleGenericComponent EOF
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
    // InternalTextualScenario.g:246:1: ruleGenericComponent returns [EObject current=null] : (this_Entity_0= ruleEntity | this_Actor_1= ruleActor | this_Component_2= ruleComponent | this_ConfigurationItem_3= ruleConfigurationItem | this_Role_4= ruleRole ) ;
    public final EObject ruleGenericComponent() throws RecognitionException {
        EObject current = null;

        EObject this_Entity_0 = null;

        EObject this_Actor_1 = null;

        EObject this_Component_2 = null;

        EObject this_ConfigurationItem_3 = null;

        EObject this_Role_4 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:252:2: ( (this_Entity_0= ruleEntity | this_Actor_1= ruleActor | this_Component_2= ruleComponent | this_ConfigurationItem_3= ruleConfigurationItem | this_Role_4= ruleRole ) )
            // InternalTextualScenario.g:253:2: (this_Entity_0= ruleEntity | this_Actor_1= ruleActor | this_Component_2= ruleComponent | this_ConfigurationItem_3= ruleConfigurationItem | this_Role_4= ruleRole )
            {
            // InternalTextualScenario.g:253:2: (this_Entity_0= ruleEntity | this_Actor_1= ruleActor | this_Component_2= ruleComponent | this_ConfigurationItem_3= ruleConfigurationItem | this_Role_4= ruleRole )
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
                    // InternalTextualScenario.g:254:3: this_Entity_0= ruleEntity
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
                    // InternalTextualScenario.g:263:3: this_Actor_1= ruleActor
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
                    // InternalTextualScenario.g:272:3: this_Component_2= ruleComponent
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
                    // InternalTextualScenario.g:281:3: this_ConfigurationItem_3= ruleConfigurationItem
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
                    // InternalTextualScenario.g:290:3: this_Role_4= ruleRole
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
    // InternalTextualScenario.g:302:1: entryRuleGenericFunction returns [EObject current=null] : iv_ruleGenericFunction= ruleGenericFunction EOF ;
    public final EObject entryRuleGenericFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenericFunction = null;


        try {
            // InternalTextualScenario.g:302:56: (iv_ruleGenericFunction= ruleGenericFunction EOF )
            // InternalTextualScenario.g:303:2: iv_ruleGenericFunction= ruleGenericFunction EOF
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
    // InternalTextualScenario.g:309:1: ruleGenericFunction returns [EObject current=null] : (this_Function_0= ruleFunction | this_Activity_1= ruleActivity ) ;
    public final EObject ruleGenericFunction() throws RecognitionException {
        EObject current = null;

        EObject this_Function_0 = null;

        EObject this_Activity_1 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:315:2: ( (this_Function_0= ruleFunction | this_Activity_1= ruleActivity ) )
            // InternalTextualScenario.g:316:2: (this_Function_0= ruleFunction | this_Activity_1= ruleActivity )
            {
            // InternalTextualScenario.g:316:2: (this_Function_0= ruleFunction | this_Activity_1= ruleActivity )
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
                    // InternalTextualScenario.g:317:3: this_Function_0= ruleFunction
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
                    // InternalTextualScenario.g:326:3: this_Activity_1= ruleActivity
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
    // InternalTextualScenario.g:338:1: entryRuleActor returns [EObject current=null] : iv_ruleActor= ruleActor EOF ;
    public final EObject entryRuleActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActor = null;


        try {
            // InternalTextualScenario.g:338:46: (iv_ruleActor= ruleActor EOF )
            // InternalTextualScenario.g:339:2: iv_ruleActor= ruleActor EOF
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
    // InternalTextualScenario.g:345:1: ruleActor returns [EObject current=null] : ( ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleActor() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:351:2: ( ( ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:352:2: ( ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:352:2: ( ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:353:3: ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:353:3: ( (lv_keyword_0_0= 'actor' ) )
            // InternalTextualScenario.g:354:4: (lv_keyword_0_0= 'actor' )
            {
            // InternalTextualScenario.g:354:4: (lv_keyword_0_0= 'actor' )
            // InternalTextualScenario.g:355:5: lv_keyword_0_0= 'actor'
            {
            lv_keyword_0_0=(Token)match(input,14,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getActorAccess().getKeywordActorKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActorRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "actor");
            				

            }


            }

            // InternalTextualScenario.g:367:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:368:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:368:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:369:5: lv_name_1_0= RULE_STRING
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
    // InternalTextualScenario.g:389:1: entryRuleComponent returns [EObject current=null] : iv_ruleComponent= ruleComponent EOF ;
    public final EObject entryRuleComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponent = null;


        try {
            // InternalTextualScenario.g:389:50: (iv_ruleComponent= ruleComponent EOF )
            // InternalTextualScenario.g:390:2: iv_ruleComponent= ruleComponent EOF
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
    // InternalTextualScenario.g:396:1: ruleComponent returns [EObject current=null] : ( ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )? ) ;
    public final EObject ruleComponent() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;
        Token lv_nature_2_1=null;
        Token lv_nature_2_2=null;
        Token lv_nature_2_3=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:402:2: ( ( ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )? ) )
            // InternalTextualScenario.g:403:2: ( ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )? )
            {
            // InternalTextualScenario.g:403:2: ( ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )? )
            // InternalTextualScenario.g:404:3: ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )?
            {
            // InternalTextualScenario.g:404:3: ( (lv_keyword_0_0= 'component' ) )
            // InternalTextualScenario.g:405:4: (lv_keyword_0_0= 'component' )
            {
            // InternalTextualScenario.g:405:4: (lv_keyword_0_0= 'component' )
            // InternalTextualScenario.g:406:5: lv_keyword_0_0= 'component'
            {
            lv_keyword_0_0=(Token)match(input,15,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "component");
            				

            }


            }

            // InternalTextualScenario.g:418:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:419:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:419:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:420:5: lv_name_1_0= RULE_STRING
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

            // InternalTextualScenario.g:436:3: ( ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=16 && LA8_0<=18)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalTextualScenario.g:437:4: ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) )
                    {
                    // InternalTextualScenario.g:437:4: ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) )
                    // InternalTextualScenario.g:438:5: (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' )
                    {
                    // InternalTextualScenario.g:438:5: (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' )
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
                            // InternalTextualScenario.g:439:6: lv_nature_2_1= 'unset'
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
                            // InternalTextualScenario.g:450:6: lv_nature_2_2= 'behavior'
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
                            // InternalTextualScenario.g:461:6: lv_nature_2_3= 'node'
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
    // InternalTextualScenario.g:478:1: entryRuleConfigurationItem returns [EObject current=null] : iv_ruleConfigurationItem= ruleConfigurationItem EOF ;
    public final EObject entryRuleConfigurationItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigurationItem = null;


        try {
            // InternalTextualScenario.g:478:58: (iv_ruleConfigurationItem= ruleConfigurationItem EOF )
            // InternalTextualScenario.g:479:2: iv_ruleConfigurationItem= ruleConfigurationItem EOF
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
    // InternalTextualScenario.g:485:1: ruleConfigurationItem returns [EObject current=null] : ( ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleConfigurationItem() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:491:2: ( ( ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:492:2: ( ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:492:2: ( ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:493:3: ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:493:3: ( (lv_keyword_0_0= 'configuration_item' ) )
            // InternalTextualScenario.g:494:4: (lv_keyword_0_0= 'configuration_item' )
            {
            // InternalTextualScenario.g:494:4: (lv_keyword_0_0= 'configuration_item' )
            // InternalTextualScenario.g:495:5: lv_keyword_0_0= 'configuration_item'
            {
            lv_keyword_0_0=(Token)match(input,19,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConfigurationItemRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "configuration_item");
            				

            }


            }

            // InternalTextualScenario.g:507:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:508:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:508:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:509:5: lv_name_1_0= RULE_STRING
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
    // InternalTextualScenario.g:529:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalTextualScenario.g:529:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalTextualScenario.g:530:2: iv_ruleFunction= ruleFunction EOF
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
    // InternalTextualScenario.g:536:1: ruleFunction returns [EObject current=null] : ( ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:542:2: ( ( ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:543:2: ( ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:543:2: ( ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:544:3: ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:544:3: ( (lv_keyword_0_0= 'function' ) )
            // InternalTextualScenario.g:545:4: (lv_keyword_0_0= 'function' )
            {
            // InternalTextualScenario.g:545:4: (lv_keyword_0_0= 'function' )
            // InternalTextualScenario.g:546:5: lv_keyword_0_0= 'function'
            {
            lv_keyword_0_0=(Token)match(input,20,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "function");
            				

            }


            }

            // InternalTextualScenario.g:558:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:559:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:559:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:560:5: lv_name_1_0= RULE_STRING
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
    // InternalTextualScenario.g:580:1: entryRuleActivity returns [EObject current=null] : iv_ruleActivity= ruleActivity EOF ;
    public final EObject entryRuleActivity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActivity = null;


        try {
            // InternalTextualScenario.g:580:49: (iv_ruleActivity= ruleActivity EOF )
            // InternalTextualScenario.g:581:2: iv_ruleActivity= ruleActivity EOF
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
    // InternalTextualScenario.g:587:1: ruleActivity returns [EObject current=null] : ( ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleActivity() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:593:2: ( ( ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:594:2: ( ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:594:2: ( ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:595:3: ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:595:3: ( (lv_keyword_0_0= 'activity' ) )
            // InternalTextualScenario.g:596:4: (lv_keyword_0_0= 'activity' )
            {
            // InternalTextualScenario.g:596:4: (lv_keyword_0_0= 'activity' )
            // InternalTextualScenario.g:597:5: lv_keyword_0_0= 'activity'
            {
            lv_keyword_0_0=(Token)match(input,21,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActivityRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "activity");
            				

            }


            }

            // InternalTextualScenario.g:609:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:610:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:610:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:611:5: lv_name_1_0= RULE_STRING
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
    // InternalTextualScenario.g:631:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalTextualScenario.g:631:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalTextualScenario.g:632:2: iv_ruleEntity= ruleEntity EOF
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
    // InternalTextualScenario.g:638:1: ruleEntity returns [EObject current=null] : ( ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:644:2: ( ( ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:645:2: ( ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:645:2: ( ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:646:3: ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:646:3: ( (lv_keyword_0_0= 'entity' ) )
            // InternalTextualScenario.g:647:4: (lv_keyword_0_0= 'entity' )
            {
            // InternalTextualScenario.g:647:4: (lv_keyword_0_0= 'entity' )
            // InternalTextualScenario.g:648:5: lv_keyword_0_0= 'entity'
            {
            lv_keyword_0_0=(Token)match(input,22,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "entity");
            				

            }


            }

            // InternalTextualScenario.g:660:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:661:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:661:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:662:5: lv_name_1_0= RULE_STRING
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
    // InternalTextualScenario.g:682:1: entryRuleRole returns [EObject current=null] : iv_ruleRole= ruleRole EOF ;
    public final EObject entryRuleRole() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRole = null;


        try {
            // InternalTextualScenario.g:682:45: (iv_ruleRole= ruleRole EOF )
            // InternalTextualScenario.g:683:2: iv_ruleRole= ruleRole EOF
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
    // InternalTextualScenario.g:689:1: ruleRole returns [EObject current=null] : ( ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleRole() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:695:2: ( ( ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:696:2: ( ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:696:2: ( ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:697:3: ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:697:3: ( (lv_keyword_0_0= 'role' ) )
            // InternalTextualScenario.g:698:4: (lv_keyword_0_0= 'role' )
            {
            // InternalTextualScenario.g:698:4: (lv_keyword_0_0= 'role' )
            // InternalTextualScenario.g:699:5: lv_keyword_0_0= 'role'
            {
            lv_keyword_0_0=(Token)match(input,23,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRoleRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "role");
            				

            }


            }

            // InternalTextualScenario.g:711:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:712:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:712:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:713:5: lv_name_1_0= RULE_STRING
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
    // InternalTextualScenario.g:733:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // InternalTextualScenario.g:733:48: (iv_ruleMessage= ruleMessage EOF )
            // InternalTextualScenario.g:734:2: iv_ruleMessage= ruleMessage EOF
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
    // InternalTextualScenario.g:740:1: ruleMessage returns [EObject current=null] : (this_SequenceMessageType_0= ruleSequenceMessageType | this_ArmTimerMessage_1= ruleArmTimerMessage | this_ParticipantDeactivation_2= ruleParticipantDeactivation ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        EObject this_SequenceMessageType_0 = null;

        EObject this_ArmTimerMessage_1 = null;

        EObject this_ParticipantDeactivation_2 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:746:2: ( (this_SequenceMessageType_0= ruleSequenceMessageType | this_ArmTimerMessage_1= ruleArmTimerMessage | this_ParticipantDeactivation_2= ruleParticipantDeactivation ) )
            // InternalTextualScenario.g:747:2: (this_SequenceMessageType_0= ruleSequenceMessageType | this_ArmTimerMessage_1= ruleArmTimerMessage | this_ParticipantDeactivation_2= ruleParticipantDeactivation )
            {
            // InternalTextualScenario.g:747:2: (this_SequenceMessageType_0= ruleSequenceMessageType | this_ArmTimerMessage_1= ruleArmTimerMessage | this_ParticipantDeactivation_2= ruleParticipantDeactivation )
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
                    // InternalTextualScenario.g:748:3: this_SequenceMessageType_0= ruleSequenceMessageType
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
                    // InternalTextualScenario.g:757:3: this_ArmTimerMessage_1= ruleArmTimerMessage
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
                    // InternalTextualScenario.g:766:3: this_ParticipantDeactivation_2= ruleParticipantDeactivation
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
    // InternalTextualScenario.g:778:1: entryRuleSequenceMessageType returns [EObject current=null] : iv_ruleSequenceMessageType= ruleSequenceMessageType EOF ;
    public final EObject entryRuleSequenceMessageType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceMessageType = null;


        try {
            // InternalTextualScenario.g:778:60: (iv_ruleSequenceMessageType= ruleSequenceMessageType EOF )
            // InternalTextualScenario.g:779:2: iv_ruleSequenceMessageType= ruleSequenceMessageType EOF
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
    // InternalTextualScenario.g:785:1: ruleSequenceMessageType returns [EObject current=null] : (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage | this_DeleteMessage_2= ruleDeleteMessage ) ;
    public final EObject ruleSequenceMessageType() throws RecognitionException {
        EObject current = null;

        EObject this_SequenceMessage_0 = null;

        EObject this_CreateMessage_1 = null;

        EObject this_DeleteMessage_2 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:791:2: ( (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage | this_DeleteMessage_2= ruleDeleteMessage ) )
            // InternalTextualScenario.g:792:2: (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage | this_DeleteMessage_2= ruleDeleteMessage )
            {
            // InternalTextualScenario.g:792:2: (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage | this_DeleteMessage_2= ruleDeleteMessage )
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_STRING) ) {
                switch ( input.LA(2) ) {
                case 29:
                    {
                    alt10=3;
                    }
                    break;
                case 28:
                    {
                    alt10=2;
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
                    // InternalTextualScenario.g:793:3: this_SequenceMessage_0= ruleSequenceMessage
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
                    // InternalTextualScenario.g:802:3: this_CreateMessage_1= ruleCreateMessage
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
                    // InternalTextualScenario.g:811:3: this_DeleteMessage_2= ruleDeleteMessage
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
    // InternalTextualScenario.g:823:1: entryRuleSequenceMessage returns [EObject current=null] : iv_ruleSequenceMessage= ruleSequenceMessage EOF ;
    public final EObject entryRuleSequenceMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceMessage = null;


        try {
            // InternalTextualScenario.g:823:56: (iv_ruleSequenceMessage= ruleSequenceMessage EOF )
            // InternalTextualScenario.g:824:2: iv_ruleSequenceMessage= ruleSequenceMessage EOF
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
    // InternalTextualScenario.g:830:1: ruleSequenceMessage returns [EObject current=null] : ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_execution_3_0= 'withExecution' ) )? ( (lv_return_4_0= 'withReturn' ) )? ( (lv_doubleDot_5_0= ':' ) ) ( (lv_name_6_0= RULE_STRING ) ) ) ;
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
            // InternalTextualScenario.g:836:2: ( ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_execution_3_0= 'withExecution' ) )? ( (lv_return_4_0= 'withReturn' ) )? ( (lv_doubleDot_5_0= ':' ) ) ( (lv_name_6_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:837:2: ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_execution_3_0= 'withExecution' ) )? ( (lv_return_4_0= 'withReturn' ) )? ( (lv_doubleDot_5_0= ':' ) ) ( (lv_name_6_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:837:2: ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_execution_3_0= 'withExecution' ) )? ( (lv_return_4_0= 'withReturn' ) )? ( (lv_doubleDot_5_0= ':' ) ) ( (lv_name_6_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:838:3: ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_execution_3_0= 'withExecution' ) )? ( (lv_return_4_0= 'withReturn' ) )? ( (lv_doubleDot_5_0= ':' ) ) ( (lv_name_6_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:838:3: ( (lv_source_0_0= RULE_STRING ) )
            // InternalTextualScenario.g:839:4: (lv_source_0_0= RULE_STRING )
            {
            // InternalTextualScenario.g:839:4: (lv_source_0_0= RULE_STRING )
            // InternalTextualScenario.g:840:5: lv_source_0_0= RULE_STRING
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

            // InternalTextualScenario.g:856:3: ( (lv_arrow_1_0= '->' ) )
            // InternalTextualScenario.g:857:4: (lv_arrow_1_0= '->' )
            {
            // InternalTextualScenario.g:857:4: (lv_arrow_1_0= '->' )
            // InternalTextualScenario.g:858:5: lv_arrow_1_0= '->'
            {
            lv_arrow_1_0=(Token)match(input,24,FOLLOW_6); 

            					newLeafNode(lv_arrow_1_0, grammarAccess.getSequenceMessageAccess().getArrowHyphenMinusGreaterThanSignKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSequenceMessageRule());
            					}
            					setWithLastConsumed(current, "arrow", lv_arrow_1_0, "->");
            				

            }


            }

            // InternalTextualScenario.g:870:3: ( (lv_target_2_0= RULE_STRING ) )
            // InternalTextualScenario.g:871:4: (lv_target_2_0= RULE_STRING )
            {
            // InternalTextualScenario.g:871:4: (lv_target_2_0= RULE_STRING )
            // InternalTextualScenario.g:872:5: lv_target_2_0= RULE_STRING
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

            // InternalTextualScenario.g:888:3: ( (lv_execution_3_0= 'withExecution' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTextualScenario.g:889:4: (lv_execution_3_0= 'withExecution' )
                    {
                    // InternalTextualScenario.g:889:4: (lv_execution_3_0= 'withExecution' )
                    // InternalTextualScenario.g:890:5: lv_execution_3_0= 'withExecution'
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

            // InternalTextualScenario.g:902:3: ( (lv_return_4_0= 'withReturn' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==26) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalTextualScenario.g:903:4: (lv_return_4_0= 'withReturn' )
                    {
                    // InternalTextualScenario.g:903:4: (lv_return_4_0= 'withReturn' )
                    // InternalTextualScenario.g:904:5: lv_return_4_0= 'withReturn'
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

            // InternalTextualScenario.g:916:3: ( (lv_doubleDot_5_0= ':' ) )
            // InternalTextualScenario.g:917:4: (lv_doubleDot_5_0= ':' )
            {
            // InternalTextualScenario.g:917:4: (lv_doubleDot_5_0= ':' )
            // InternalTextualScenario.g:918:5: lv_doubleDot_5_0= ':'
            {
            lv_doubleDot_5_0=(Token)match(input,27,FOLLOW_6); 

            					newLeafNode(lv_doubleDot_5_0, grammarAccess.getSequenceMessageAccess().getDoubleDotColonKeyword_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSequenceMessageRule());
            					}
            					setWithLastConsumed(current, "doubleDot", lv_doubleDot_5_0, ":");
            				

            }


            }

            // InternalTextualScenario.g:930:3: ( (lv_name_6_0= RULE_STRING ) )
            // InternalTextualScenario.g:931:4: (lv_name_6_0= RULE_STRING )
            {
            // InternalTextualScenario.g:931:4: (lv_name_6_0= RULE_STRING )
            // InternalTextualScenario.g:932:5: lv_name_6_0= RULE_STRING
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
    // InternalTextualScenario.g:952:1: entryRuleCreateMessage returns [EObject current=null] : iv_ruleCreateMessage= ruleCreateMessage EOF ;
    public final EObject entryRuleCreateMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreateMessage = null;


        try {
            // InternalTextualScenario.g:952:54: (iv_ruleCreateMessage= ruleCreateMessage EOF )
            // InternalTextualScenario.g:953:2: iv_ruleCreateMessage= ruleCreateMessage EOF
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
    // InternalTextualScenario.g:959:1: ruleCreateMessage returns [EObject current=null] : ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->+' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleCreateMessage() throws RecognitionException {
        EObject current = null;

        Token lv_source_0_0=null;
        Token lv_arrow_1_0=null;
        Token lv_target_2_0=null;
        Token lv_doubleDot_3_0=null;
        Token lv_name_4_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:965:2: ( ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->+' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:966:2: ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->+' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:966:2: ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->+' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:967:3: ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->+' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:967:3: ( (lv_source_0_0= RULE_STRING ) )
            // InternalTextualScenario.g:968:4: (lv_source_0_0= RULE_STRING )
            {
            // InternalTextualScenario.g:968:4: (lv_source_0_0= RULE_STRING )
            // InternalTextualScenario.g:969:5: lv_source_0_0= RULE_STRING
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

            // InternalTextualScenario.g:985:3: ( (lv_arrow_1_0= '->+' ) )
            // InternalTextualScenario.g:986:4: (lv_arrow_1_0= '->+' )
            {
            // InternalTextualScenario.g:986:4: (lv_arrow_1_0= '->+' )
            // InternalTextualScenario.g:987:5: lv_arrow_1_0= '->+'
            {
            lv_arrow_1_0=(Token)match(input,28,FOLLOW_6); 

            					newLeafNode(lv_arrow_1_0, grammarAccess.getCreateMessageAccess().getArrowHyphenMinusGreaterThanSignPlusSignKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCreateMessageRule());
            					}
            					setWithLastConsumed(current, "arrow", lv_arrow_1_0, "->+");
            				

            }


            }

            // InternalTextualScenario.g:999:3: ( (lv_target_2_0= RULE_STRING ) )
            // InternalTextualScenario.g:1000:4: (lv_target_2_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1000:4: (lv_target_2_0= RULE_STRING )
            // InternalTextualScenario.g:1001:5: lv_target_2_0= RULE_STRING
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

            // InternalTextualScenario.g:1017:3: ( (lv_doubleDot_3_0= ':' ) )
            // InternalTextualScenario.g:1018:4: (lv_doubleDot_3_0= ':' )
            {
            // InternalTextualScenario.g:1018:4: (lv_doubleDot_3_0= ':' )
            // InternalTextualScenario.g:1019:5: lv_doubleDot_3_0= ':'
            {
            lv_doubleDot_3_0=(Token)match(input,27,FOLLOW_6); 

            					newLeafNode(lv_doubleDot_3_0, grammarAccess.getCreateMessageAccess().getDoubleDotColonKeyword_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCreateMessageRule());
            					}
            					setWithLastConsumed(current, "doubleDot", lv_doubleDot_3_0, ":");
            				

            }


            }

            // InternalTextualScenario.g:1031:3: ( (lv_name_4_0= RULE_STRING ) )
            // InternalTextualScenario.g:1032:4: (lv_name_4_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1032:4: (lv_name_4_0= RULE_STRING )
            // InternalTextualScenario.g:1033:5: lv_name_4_0= RULE_STRING
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
    // InternalTextualScenario.g:1053:1: entryRuleDeleteMessage returns [EObject current=null] : iv_ruleDeleteMessage= ruleDeleteMessage EOF ;
    public final EObject entryRuleDeleteMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeleteMessage = null;


        try {
            // InternalTextualScenario.g:1053:54: (iv_ruleDeleteMessage= ruleDeleteMessage EOF )
            // InternalTextualScenario.g:1054:2: iv_ruleDeleteMessage= ruleDeleteMessage EOF
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
    // InternalTextualScenario.g:1060:1: ruleDeleteMessage returns [EObject current=null] : ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->x' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleDeleteMessage() throws RecognitionException {
        EObject current = null;

        Token lv_source_0_0=null;
        Token lv_arrow_1_0=null;
        Token lv_target_2_0=null;
        Token lv_doubleDot_3_0=null;
        Token lv_name_4_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:1066:2: ( ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->x' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:1067:2: ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->x' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:1067:2: ( ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->x' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:1068:3: ( (lv_source_0_0= RULE_STRING ) ) ( (lv_arrow_1_0= '->x' ) ) ( (lv_target_2_0= RULE_STRING ) ) ( (lv_doubleDot_3_0= ':' ) ) ( (lv_name_4_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:1068:3: ( (lv_source_0_0= RULE_STRING ) )
            // InternalTextualScenario.g:1069:4: (lv_source_0_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1069:4: (lv_source_0_0= RULE_STRING )
            // InternalTextualScenario.g:1070:5: lv_source_0_0= RULE_STRING
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

            // InternalTextualScenario.g:1086:3: ( (lv_arrow_1_0= '->x' ) )
            // InternalTextualScenario.g:1087:4: (lv_arrow_1_0= '->x' )
            {
            // InternalTextualScenario.g:1087:4: (lv_arrow_1_0= '->x' )
            // InternalTextualScenario.g:1088:5: lv_arrow_1_0= '->x'
            {
            lv_arrow_1_0=(Token)match(input,29,FOLLOW_6); 

            					newLeafNode(lv_arrow_1_0, grammarAccess.getDeleteMessageAccess().getArrowXKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeleteMessageRule());
            					}
            					setWithLastConsumed(current, "arrow", lv_arrow_1_0, "->x");
            				

            }


            }

            // InternalTextualScenario.g:1100:3: ( (lv_target_2_0= RULE_STRING ) )
            // InternalTextualScenario.g:1101:4: (lv_target_2_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1101:4: (lv_target_2_0= RULE_STRING )
            // InternalTextualScenario.g:1102:5: lv_target_2_0= RULE_STRING
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

            // InternalTextualScenario.g:1118:3: ( (lv_doubleDot_3_0= ':' ) )
            // InternalTextualScenario.g:1119:4: (lv_doubleDot_3_0= ':' )
            {
            // InternalTextualScenario.g:1119:4: (lv_doubleDot_3_0= ':' )
            // InternalTextualScenario.g:1120:5: lv_doubleDot_3_0= ':'
            {
            lv_doubleDot_3_0=(Token)match(input,27,FOLLOW_6); 

            					newLeafNode(lv_doubleDot_3_0, grammarAccess.getDeleteMessageAccess().getDoubleDotColonKeyword_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeleteMessageRule());
            					}
            					setWithLastConsumed(current, "doubleDot", lv_doubleDot_3_0, ":");
            				

            }


            }

            // InternalTextualScenario.g:1132:3: ( (lv_name_4_0= RULE_STRING ) )
            // InternalTextualScenario.g:1133:4: (lv_name_4_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1133:4: (lv_name_4_0= RULE_STRING )
            // InternalTextualScenario.g:1134:5: lv_name_4_0= RULE_STRING
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
    // InternalTextualScenario.g:1154:1: entryRuleArmTimerMessage returns [EObject current=null] : iv_ruleArmTimerMessage= ruleArmTimerMessage EOF ;
    public final EObject entryRuleArmTimerMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArmTimerMessage = null;


        try {
            // InternalTextualScenario.g:1154:56: (iv_ruleArmTimerMessage= ruleArmTimerMessage EOF )
            // InternalTextualScenario.g:1155:2: iv_ruleArmTimerMessage= ruleArmTimerMessage EOF
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
    // InternalTextualScenario.g:1161:1: ruleArmTimerMessage returns [EObject current=null] : ( ( (lv_arrow_0_0= '->>' ) ) ( (lv_participant_1_0= RULE_STRING ) ) ( (lv_doubleDot_2_0= ':' ) ) ( (lv_name_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleArmTimerMessage() throws RecognitionException {
        EObject current = null;

        Token lv_arrow_0_0=null;
        Token lv_participant_1_0=null;
        Token lv_doubleDot_2_0=null;
        Token lv_name_3_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:1167:2: ( ( ( (lv_arrow_0_0= '->>' ) ) ( (lv_participant_1_0= RULE_STRING ) ) ( (lv_doubleDot_2_0= ':' ) ) ( (lv_name_3_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:1168:2: ( ( (lv_arrow_0_0= '->>' ) ) ( (lv_participant_1_0= RULE_STRING ) ) ( (lv_doubleDot_2_0= ':' ) ) ( (lv_name_3_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:1168:2: ( ( (lv_arrow_0_0= '->>' ) ) ( (lv_participant_1_0= RULE_STRING ) ) ( (lv_doubleDot_2_0= ':' ) ) ( (lv_name_3_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:1169:3: ( (lv_arrow_0_0= '->>' ) ) ( (lv_participant_1_0= RULE_STRING ) ) ( (lv_doubleDot_2_0= ':' ) ) ( (lv_name_3_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:1169:3: ( (lv_arrow_0_0= '->>' ) )
            // InternalTextualScenario.g:1170:4: (lv_arrow_0_0= '->>' )
            {
            // InternalTextualScenario.g:1170:4: (lv_arrow_0_0= '->>' )
            // InternalTextualScenario.g:1171:5: lv_arrow_0_0= '->>'
            {
            lv_arrow_0_0=(Token)match(input,30,FOLLOW_6); 

            					newLeafNode(lv_arrow_0_0, grammarAccess.getArmTimerMessageAccess().getArrowHyphenMinusGreaterThanSignGreaterThanSignKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArmTimerMessageRule());
            					}
            					setWithLastConsumed(current, "arrow", lv_arrow_0_0, "->>");
            				

            }


            }

            // InternalTextualScenario.g:1183:3: ( (lv_participant_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:1184:4: (lv_participant_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1184:4: (lv_participant_1_0= RULE_STRING )
            // InternalTextualScenario.g:1185:5: lv_participant_1_0= RULE_STRING
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

            // InternalTextualScenario.g:1201:3: ( (lv_doubleDot_2_0= ':' ) )
            // InternalTextualScenario.g:1202:4: (lv_doubleDot_2_0= ':' )
            {
            // InternalTextualScenario.g:1202:4: (lv_doubleDot_2_0= ':' )
            // InternalTextualScenario.g:1203:5: lv_doubleDot_2_0= ':'
            {
            lv_doubleDot_2_0=(Token)match(input,27,FOLLOW_6); 

            					newLeafNode(lv_doubleDot_2_0, grammarAccess.getArmTimerMessageAccess().getDoubleDotColonKeyword_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArmTimerMessageRule());
            					}
            					setWithLastConsumed(current, "doubleDot", lv_doubleDot_2_0, ":");
            				

            }


            }

            // InternalTextualScenario.g:1215:3: ( (lv_name_3_0= RULE_STRING ) )
            // InternalTextualScenario.g:1216:4: (lv_name_3_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1216:4: (lv_name_3_0= RULE_STRING )
            // InternalTextualScenario.g:1217:5: lv_name_3_0= RULE_STRING
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
    // InternalTextualScenario.g:1237:1: entryRuleParticipantDeactivation returns [EObject current=null] : iv_ruleParticipantDeactivation= ruleParticipantDeactivation EOF ;
    public final EObject entryRuleParticipantDeactivation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParticipantDeactivation = null;


        try {
            // InternalTextualScenario.g:1237:64: (iv_ruleParticipantDeactivation= ruleParticipantDeactivation EOF )
            // InternalTextualScenario.g:1238:2: iv_ruleParticipantDeactivation= ruleParticipantDeactivation EOF
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
    // InternalTextualScenario.g:1244:1: ruleParticipantDeactivation returns [EObject current=null] : ( ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleParticipantDeactivation() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:1250:2: ( ( ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:1251:2: ( ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:1251:2: ( ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:1252:3: ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:1252:3: ( (lv_keyword_0_0= 'deactivate' ) )
            // InternalTextualScenario.g:1253:4: (lv_keyword_0_0= 'deactivate' )
            {
            // InternalTextualScenario.g:1253:4: (lv_keyword_0_0= 'deactivate' )
            // InternalTextualScenario.g:1254:5: lv_keyword_0_0= 'deactivate'
            {
            lv_keyword_0_0=(Token)match(input,31,FOLLOW_6); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParticipantDeactivationRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "deactivate");
            				

            }


            }

            // InternalTextualScenario.g:1266:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:1267:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1267:4: (lv_name_1_0= RULE_STRING )
            // InternalTextualScenario.g:1268:5: lv_name_1_0= RULE_STRING
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
    // InternalTextualScenario.g:1288:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // InternalTextualScenario.g:1288:50: (iv_ruleReference= ruleReference EOF )
            // InternalTextualScenario.g:1289:2: iv_ruleReference= ruleReference EOF
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
    // InternalTextualScenario.g:1295:1: ruleReference returns [EObject current=null] : ( ( (lv_keyword_0_0= 'ref' ) ) ( (lv_over_1_0= 'over' ) ) ( (lv_timelines_2_0= RULE_STRING ) )+ ( (lv_name_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_over_1_0=null;
        Token lv_timelines_2_0=null;
        Token lv_name_3_0=null;


        	enterRule();

        try {
            // InternalTextualScenario.g:1301:2: ( ( ( (lv_keyword_0_0= 'ref' ) ) ( (lv_over_1_0= 'over' ) ) ( (lv_timelines_2_0= RULE_STRING ) )+ ( (lv_name_3_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:1302:2: ( ( (lv_keyword_0_0= 'ref' ) ) ( (lv_over_1_0= 'over' ) ) ( (lv_timelines_2_0= RULE_STRING ) )+ ( (lv_name_3_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:1302:2: ( ( (lv_keyword_0_0= 'ref' ) ) ( (lv_over_1_0= 'over' ) ) ( (lv_timelines_2_0= RULE_STRING ) )+ ( (lv_name_3_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:1303:3: ( (lv_keyword_0_0= 'ref' ) ) ( (lv_over_1_0= 'over' ) ) ( (lv_timelines_2_0= RULE_STRING ) )+ ( (lv_name_3_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:1303:3: ( (lv_keyword_0_0= 'ref' ) )
            // InternalTextualScenario.g:1304:4: (lv_keyword_0_0= 'ref' )
            {
            // InternalTextualScenario.g:1304:4: (lv_keyword_0_0= 'ref' )
            // InternalTextualScenario.g:1305:5: lv_keyword_0_0= 'ref'
            {
            lv_keyword_0_0=(Token)match(input,32,FOLLOW_14); 

            					newLeafNode(lv_keyword_0_0, grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferenceRule());
            					}
            					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "ref");
            				

            }


            }

            // InternalTextualScenario.g:1317:3: ( (lv_over_1_0= 'over' ) )
            // InternalTextualScenario.g:1318:4: (lv_over_1_0= 'over' )
            {
            // InternalTextualScenario.g:1318:4: (lv_over_1_0= 'over' )
            // InternalTextualScenario.g:1319:5: lv_over_1_0= 'over'
            {
            lv_over_1_0=(Token)match(input,33,FOLLOW_6); 

            					newLeafNode(lv_over_1_0, grammarAccess.getReferenceAccess().getOverOverKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferenceRule());
            					}
            					setWithLastConsumed(current, "over", lv_over_1_0, "over");
            				

            }


            }

            // InternalTextualScenario.g:1331:3: ( (lv_timelines_2_0= RULE_STRING ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_STRING) ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1==RULE_STRING) ) {
                        int LA13_3 = input.LA(3);

                        if ( (LA13_3==EOF||LA13_3==RULE_STRING||LA13_3==13||(LA13_3>=30 && LA13_3<=32)||(LA13_3>=34 && LA13_3<=43)||LA13_3==45) ) {
                            alt13=1;
                        }


                    }


                }


                switch (alt13) {
            	case 1 :
            	    // InternalTextualScenario.g:1332:4: (lv_timelines_2_0= RULE_STRING )
            	    {
            	    // InternalTextualScenario.g:1332:4: (lv_timelines_2_0= RULE_STRING )
            	    // InternalTextualScenario.g:1333:5: lv_timelines_2_0= RULE_STRING
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

            // InternalTextualScenario.g:1349:3: ( (lv_name_3_0= RULE_STRING ) )
            // InternalTextualScenario.g:1350:4: (lv_name_3_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1350:4: (lv_name_3_0= RULE_STRING )
            // InternalTextualScenario.g:1351:5: lv_name_3_0= RULE_STRING
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
    // InternalTextualScenario.g:1371:1: entryRuleCombinedFragment returns [EObject current=null] : iv_ruleCombinedFragment= ruleCombinedFragment EOF ;
    public final EObject entryRuleCombinedFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombinedFragment = null;


        try {
            // InternalTextualScenario.g:1371:57: (iv_ruleCombinedFragment= ruleCombinedFragment EOF )
            // InternalTextualScenario.g:1372:2: iv_ruleCombinedFragment= ruleCombinedFragment EOF
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
    // InternalTextualScenario.g:1378:1: ruleCombinedFragment returns [EObject current=null] : ( ( ( (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' ) ) )? ( (lv_expression_1_0= RULE_STRING ) ) ( (lv_over_2_0= 'over' ) ) ( (lv_timelines_3_0= RULE_STRING ) )+ ( (lv_block_4_0= ruleBlock ) ) ( (lv_operands_5_0= ruleOperand ) )* ) ;
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
        Token lv_expression_1_0=null;
        Token lv_over_2_0=null;
        Token lv_timelines_3_0=null;
        EObject lv_block_4_0 = null;

        EObject lv_operands_5_0 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:1384:2: ( ( ( ( (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' ) ) )? ( (lv_expression_1_0= RULE_STRING ) ) ( (lv_over_2_0= 'over' ) ) ( (lv_timelines_3_0= RULE_STRING ) )+ ( (lv_block_4_0= ruleBlock ) ) ( (lv_operands_5_0= ruleOperand ) )* ) )
            // InternalTextualScenario.g:1385:2: ( ( ( (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' ) ) )? ( (lv_expression_1_0= RULE_STRING ) ) ( (lv_over_2_0= 'over' ) ) ( (lv_timelines_3_0= RULE_STRING ) )+ ( (lv_block_4_0= ruleBlock ) ) ( (lv_operands_5_0= ruleOperand ) )* )
            {
            // InternalTextualScenario.g:1385:2: ( ( ( (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' ) ) )? ( (lv_expression_1_0= RULE_STRING ) ) ( (lv_over_2_0= 'over' ) ) ( (lv_timelines_3_0= RULE_STRING ) )+ ( (lv_block_4_0= ruleBlock ) ) ( (lv_operands_5_0= ruleOperand ) )* )
            // InternalTextualScenario.g:1386:3: ( ( (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' ) ) )? ( (lv_expression_1_0= RULE_STRING ) ) ( (lv_over_2_0= 'over' ) ) ( (lv_timelines_3_0= RULE_STRING ) )+ ( (lv_block_4_0= ruleBlock ) ) ( (lv_operands_5_0= ruleOperand ) )*
            {
            // InternalTextualScenario.g:1386:3: ( ( (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=34 && LA15_0<=43)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalTextualScenario.g:1387:4: ( (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' ) )
                    {
                    // InternalTextualScenario.g:1387:4: ( (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' ) )
                    // InternalTextualScenario.g:1388:5: (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' )
                    {
                    // InternalTextualScenario.g:1388:5: (lv_keyword_0_1= 'alt' | lv_keyword_0_2= 'loop' | lv_keyword_0_3= 'par' | lv_keyword_0_4= 'assert' | lv_keyword_0_5= 'critical' | lv_keyword_0_6= 'ignore' | lv_keyword_0_7= 'neg' | lv_keyword_0_8= 'opt' | lv_keyword_0_9= 'seq' | lv_keyword_0_10= 'strict' )
                    int alt14=10;
                    switch ( input.LA(1) ) {
                    case 34:
                        {
                        alt14=1;
                        }
                        break;
                    case 35:
                        {
                        alt14=2;
                        }
                        break;
                    case 36:
                        {
                        alt14=3;
                        }
                        break;
                    case 37:
                        {
                        alt14=4;
                        }
                        break;
                    case 38:
                        {
                        alt14=5;
                        }
                        break;
                    case 39:
                        {
                        alt14=6;
                        }
                        break;
                    case 40:
                        {
                        alt14=7;
                        }
                        break;
                    case 41:
                        {
                        alt14=8;
                        }
                        break;
                    case 42:
                        {
                        alt14=9;
                        }
                        break;
                    case 43:
                        {
                        alt14=10;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }

                    switch (alt14) {
                        case 1 :
                            // InternalTextualScenario.g:1389:6: lv_keyword_0_1= 'alt'
                            {
                            lv_keyword_0_1=(Token)match(input,34,FOLLOW_6); 

                            						newLeafNode(lv_keyword_0_1, grammarAccess.getCombinedFragmentAccess().getKeywordAltKeyword_0_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                            						}
                            						setWithLastConsumed(current, "keyword", lv_keyword_0_1, null);
                            					

                            }
                            break;
                        case 2 :
                            // InternalTextualScenario.g:1400:6: lv_keyword_0_2= 'loop'
                            {
                            lv_keyword_0_2=(Token)match(input,35,FOLLOW_6); 

                            						newLeafNode(lv_keyword_0_2, grammarAccess.getCombinedFragmentAccess().getKeywordLoopKeyword_0_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                            						}
                            						setWithLastConsumed(current, "keyword", lv_keyword_0_2, null);
                            					

                            }
                            break;
                        case 3 :
                            // InternalTextualScenario.g:1411:6: lv_keyword_0_3= 'par'
                            {
                            lv_keyword_0_3=(Token)match(input,36,FOLLOW_6); 

                            						newLeafNode(lv_keyword_0_3, grammarAccess.getCombinedFragmentAccess().getKeywordParKeyword_0_0_2());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                            						}
                            						setWithLastConsumed(current, "keyword", lv_keyword_0_3, null);
                            					

                            }
                            break;
                        case 4 :
                            // InternalTextualScenario.g:1422:6: lv_keyword_0_4= 'assert'
                            {
                            lv_keyword_0_4=(Token)match(input,37,FOLLOW_6); 

                            						newLeafNode(lv_keyword_0_4, grammarAccess.getCombinedFragmentAccess().getKeywordAssertKeyword_0_0_3());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                            						}
                            						setWithLastConsumed(current, "keyword", lv_keyword_0_4, null);
                            					

                            }
                            break;
                        case 5 :
                            // InternalTextualScenario.g:1433:6: lv_keyword_0_5= 'critical'
                            {
                            lv_keyword_0_5=(Token)match(input,38,FOLLOW_6); 

                            						newLeafNode(lv_keyword_0_5, grammarAccess.getCombinedFragmentAccess().getKeywordCriticalKeyword_0_0_4());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                            						}
                            						setWithLastConsumed(current, "keyword", lv_keyword_0_5, null);
                            					

                            }
                            break;
                        case 6 :
                            // InternalTextualScenario.g:1444:6: lv_keyword_0_6= 'ignore'
                            {
                            lv_keyword_0_6=(Token)match(input,39,FOLLOW_6); 

                            						newLeafNode(lv_keyword_0_6, grammarAccess.getCombinedFragmentAccess().getKeywordIgnoreKeyword_0_0_5());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                            						}
                            						setWithLastConsumed(current, "keyword", lv_keyword_0_6, null);
                            					

                            }
                            break;
                        case 7 :
                            // InternalTextualScenario.g:1455:6: lv_keyword_0_7= 'neg'
                            {
                            lv_keyword_0_7=(Token)match(input,40,FOLLOW_6); 

                            						newLeafNode(lv_keyword_0_7, grammarAccess.getCombinedFragmentAccess().getKeywordNegKeyword_0_0_6());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                            						}
                            						setWithLastConsumed(current, "keyword", lv_keyword_0_7, null);
                            					

                            }
                            break;
                        case 8 :
                            // InternalTextualScenario.g:1466:6: lv_keyword_0_8= 'opt'
                            {
                            lv_keyword_0_8=(Token)match(input,41,FOLLOW_6); 

                            						newLeafNode(lv_keyword_0_8, grammarAccess.getCombinedFragmentAccess().getKeywordOptKeyword_0_0_7());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                            						}
                            						setWithLastConsumed(current, "keyword", lv_keyword_0_8, null);
                            					

                            }
                            break;
                        case 9 :
                            // InternalTextualScenario.g:1477:6: lv_keyword_0_9= 'seq'
                            {
                            lv_keyword_0_9=(Token)match(input,42,FOLLOW_6); 

                            						newLeafNode(lv_keyword_0_9, grammarAccess.getCombinedFragmentAccess().getKeywordSeqKeyword_0_0_8());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                            						}
                            						setWithLastConsumed(current, "keyword", lv_keyword_0_9, null);
                            					

                            }
                            break;
                        case 10 :
                            // InternalTextualScenario.g:1488:6: lv_keyword_0_10= 'strict'
                            {
                            lv_keyword_0_10=(Token)match(input,43,FOLLOW_6); 

                            						newLeafNode(lv_keyword_0_10, grammarAccess.getCombinedFragmentAccess().getKeywordStrictKeyword_0_0_9());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getCombinedFragmentRule());
                            						}
                            						setWithLastConsumed(current, "keyword", lv_keyword_0_10, null);
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalTextualScenario.g:1501:3: ( (lv_expression_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:1502:4: (lv_expression_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1502:4: (lv_expression_1_0= RULE_STRING )
            // InternalTextualScenario.g:1503:5: lv_expression_1_0= RULE_STRING
            {
            lv_expression_1_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

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

            // InternalTextualScenario.g:1519:3: ( (lv_over_2_0= 'over' ) )
            // InternalTextualScenario.g:1520:4: (lv_over_2_0= 'over' )
            {
            // InternalTextualScenario.g:1520:4: (lv_over_2_0= 'over' )
            // InternalTextualScenario.g:1521:5: lv_over_2_0= 'over'
            {
            lv_over_2_0=(Token)match(input,33,FOLLOW_6); 

            					newLeafNode(lv_over_2_0, grammarAccess.getCombinedFragmentAccess().getOverOverKeyword_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCombinedFragmentRule());
            					}
            					setWithLastConsumed(current, "over", lv_over_2_0, "over");
            				

            }


            }

            // InternalTextualScenario.g:1533:3: ( (lv_timelines_3_0= RULE_STRING ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_STRING) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalTextualScenario.g:1534:4: (lv_timelines_3_0= RULE_STRING )
            	    {
            	    // InternalTextualScenario.g:1534:4: (lv_timelines_3_0= RULE_STRING )
            	    // InternalTextualScenario.g:1535:5: lv_timelines_3_0= RULE_STRING
            	    {
            	    lv_timelines_3_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

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
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            // InternalTextualScenario.g:1551:3: ( (lv_block_4_0= ruleBlock ) )
            // InternalTextualScenario.g:1552:4: (lv_block_4_0= ruleBlock )
            {
            // InternalTextualScenario.g:1552:4: (lv_block_4_0= ruleBlock )
            // InternalTextualScenario.g:1553:5: lv_block_4_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getCombinedFragmentAccess().getBlockBlockParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_16);
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

            // InternalTextualScenario.g:1570:3: ( (lv_operands_5_0= ruleOperand ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_STRING) ) {
                    int LA17_2 = input.LA(2);

                    if ( (LA17_2==12) ) {
                        alt17=1;
                    }


                }
                else if ( (LA17_0==44) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalTextualScenario.g:1571:4: (lv_operands_5_0= ruleOperand )
            	    {
            	    // InternalTextualScenario.g:1571:4: (lv_operands_5_0= ruleOperand )
            	    // InternalTextualScenario.g:1572:5: lv_operands_5_0= ruleOperand
            	    {

            	    					newCompositeNode(grammarAccess.getCombinedFragmentAccess().getOperandsOperandParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_16);
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
            	    break loop17;
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
    // InternalTextualScenario.g:1593:1: entryRuleOperand returns [EObject current=null] : iv_ruleOperand= ruleOperand EOF ;
    public final EObject entryRuleOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperand = null;


        try {
            // InternalTextualScenario.g:1593:48: (iv_ruleOperand= ruleOperand EOF )
            // InternalTextualScenario.g:1594:2: iv_ruleOperand= ruleOperand EOF
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
    // InternalTextualScenario.g:1600:1: ruleOperand returns [EObject current=null] : ( ( (lv_keyword_0_0= 'else' ) )? ( (lv_expression_1_0= RULE_STRING ) ) ( (lv_block_2_0= ruleBlock ) ) ) ;
    public final EObject ruleOperand() throws RecognitionException {
        EObject current = null;

        Token lv_keyword_0_0=null;
        Token lv_expression_1_0=null;
        EObject lv_block_2_0 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:1606:2: ( ( ( (lv_keyword_0_0= 'else' ) )? ( (lv_expression_1_0= RULE_STRING ) ) ( (lv_block_2_0= ruleBlock ) ) ) )
            // InternalTextualScenario.g:1607:2: ( ( (lv_keyword_0_0= 'else' ) )? ( (lv_expression_1_0= RULE_STRING ) ) ( (lv_block_2_0= ruleBlock ) ) )
            {
            // InternalTextualScenario.g:1607:2: ( ( (lv_keyword_0_0= 'else' ) )? ( (lv_expression_1_0= RULE_STRING ) ) ( (lv_block_2_0= ruleBlock ) ) )
            // InternalTextualScenario.g:1608:3: ( (lv_keyword_0_0= 'else' ) )? ( (lv_expression_1_0= RULE_STRING ) ) ( (lv_block_2_0= ruleBlock ) )
            {
            // InternalTextualScenario.g:1608:3: ( (lv_keyword_0_0= 'else' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==44) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalTextualScenario.g:1609:4: (lv_keyword_0_0= 'else' )
                    {
                    // InternalTextualScenario.g:1609:4: (lv_keyword_0_0= 'else' )
                    // InternalTextualScenario.g:1610:5: lv_keyword_0_0= 'else'
                    {
                    lv_keyword_0_0=(Token)match(input,44,FOLLOW_6); 

                    					newLeafNode(lv_keyword_0_0, grammarAccess.getOperandAccess().getKeywordElseKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperandRule());
                    					}
                    					setWithLastConsumed(current, "keyword", lv_keyword_0_0, "else");
                    				

                    }


                    }
                    break;

            }

            // InternalTextualScenario.g:1622:3: ( (lv_expression_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:1623:4: (lv_expression_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1623:4: (lv_expression_1_0= RULE_STRING )
            // InternalTextualScenario.g:1624:5: lv_expression_1_0= RULE_STRING
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

            // InternalTextualScenario.g:1640:3: ( (lv_block_2_0= ruleBlock ) )
            // InternalTextualScenario.g:1641:4: (lv_block_2_0= ruleBlock )
            {
            // InternalTextualScenario.g:1641:4: (lv_block_2_0= ruleBlock )
            // InternalTextualScenario.g:1642:5: lv_block_2_0= ruleBlock
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
    // InternalTextualScenario.g:1663:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // InternalTextualScenario.g:1663:46: (iv_ruleBlock= ruleBlock EOF )
            // InternalTextualScenario.g:1664:2: iv_ruleBlock= ruleBlock EOF
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
    // InternalTextualScenario.g:1670:1: ruleBlock returns [EObject current=null] : ( ( (lv_begin_0_0= '{' ) ) ( ( (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment | lv_blockElements_1_4= ruleStateFragment ) ) )* ( (lv_end_2_0= '}' ) ) ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token lv_begin_0_0=null;
        Token lv_end_2_0=null;
        EObject lv_blockElements_1_1 = null;

        EObject lv_blockElements_1_2 = null;

        EObject lv_blockElements_1_3 = null;

        EObject lv_blockElements_1_4 = null;



        	enterRule();

        try {
            // InternalTextualScenario.g:1676:2: ( ( ( (lv_begin_0_0= '{' ) ) ( ( (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment | lv_blockElements_1_4= ruleStateFragment ) ) )* ( (lv_end_2_0= '}' ) ) ) )
            // InternalTextualScenario.g:1677:2: ( ( (lv_begin_0_0= '{' ) ) ( ( (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment | lv_blockElements_1_4= ruleStateFragment ) ) )* ( (lv_end_2_0= '}' ) ) )
            {
            // InternalTextualScenario.g:1677:2: ( ( (lv_begin_0_0= '{' ) ) ( ( (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment | lv_blockElements_1_4= ruleStateFragment ) ) )* ( (lv_end_2_0= '}' ) ) )
            // InternalTextualScenario.g:1678:3: ( (lv_begin_0_0= '{' ) ) ( ( (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment | lv_blockElements_1_4= ruleStateFragment ) ) )* ( (lv_end_2_0= '}' ) )
            {
            // InternalTextualScenario.g:1678:3: ( (lv_begin_0_0= '{' ) )
            // InternalTextualScenario.g:1679:4: (lv_begin_0_0= '{' )
            {
            // InternalTextualScenario.g:1679:4: (lv_begin_0_0= '{' )
            // InternalTextualScenario.g:1680:5: lv_begin_0_0= '{'
            {
            lv_begin_0_0=(Token)match(input,12,FOLLOW_5); 

            					newLeafNode(lv_begin_0_0, grammarAccess.getBlockAccess().getBeginLeftCurlyBracketKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBlockRule());
            					}
            					setWithLastConsumed(current, "begin", lv_begin_0_0, "{");
            				

            }


            }

            // InternalTextualScenario.g:1692:3: ( ( (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment | lv_blockElements_1_4= ruleStateFragment ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_STRING||(LA20_0>=30 && LA20_0<=32)||(LA20_0>=34 && LA20_0<=43)||LA20_0==45) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalTextualScenario.g:1693:4: ( (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment | lv_blockElements_1_4= ruleStateFragment ) )
            	    {
            	    // InternalTextualScenario.g:1693:4: ( (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment | lv_blockElements_1_4= ruleStateFragment ) )
            	    // InternalTextualScenario.g:1694:5: (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment | lv_blockElements_1_4= ruleStateFragment )
            	    {
            	    // InternalTextualScenario.g:1694:5: (lv_blockElements_1_1= ruleMessage | lv_blockElements_1_2= ruleReference | lv_blockElements_1_3= ruleCombinedFragment | lv_blockElements_1_4= ruleStateFragment )
            	    int alt19=4;
            	    switch ( input.LA(1) ) {
            	    case RULE_STRING:
            	        {
            	        int LA19_1 = input.LA(2);

            	        if ( (LA19_1==24||(LA19_1>=28 && LA19_1<=29)) ) {
            	            alt19=1;
            	        }
            	        else if ( (LA19_1==33) ) {
            	            alt19=3;
            	        }
            	        else {
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 19, 1, input);

            	            throw nvae;
            	        }
            	        }
            	        break;
            	    case 30:
            	    case 31:
            	        {
            	        alt19=1;
            	        }
            	        break;
            	    case 32:
            	        {
            	        alt19=2;
            	        }
            	        break;
            	    case 34:
            	    case 35:
            	    case 36:
            	    case 37:
            	    case 38:
            	    case 39:
            	    case 40:
            	    case 41:
            	    case 42:
            	    case 43:
            	        {
            	        alt19=3;
            	        }
            	        break;
            	    case 45:
            	        {
            	        alt19=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 19, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt19) {
            	        case 1 :
            	            // InternalTextualScenario.g:1695:6: lv_blockElements_1_1= ruleMessage
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
            	            // InternalTextualScenario.g:1711:6: lv_blockElements_1_2= ruleReference
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
            	            // InternalTextualScenario.g:1727:6: lv_blockElements_1_3= ruleCombinedFragment
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
            	        case 4 :
            	            // InternalTextualScenario.g:1743:6: lv_blockElements_1_4= ruleStateFragment
            	            {

            	            						newCompositeNode(grammarAccess.getBlockAccess().getBlockElementsStateFragmentParserRuleCall_1_0_3());
            	            					
            	            pushFollow(FOLLOW_5);
            	            lv_blockElements_1_4=ruleStateFragment();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getBlockRule());
            	            						}
            	            						add(
            	            							current,
            	            							"blockElements",
            	            							lv_blockElements_1_4,
            	            							"org.polarsys.capella.scenario.editor.dsl.TextualScenario.StateFragment");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // InternalTextualScenario.g:1761:3: ( (lv_end_2_0= '}' ) )
            // InternalTextualScenario.g:1762:4: (lv_end_2_0= '}' )
            {
            // InternalTextualScenario.g:1762:4: (lv_end_2_0= '}' )
            // InternalTextualScenario.g:1763:5: lv_end_2_0= '}'
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
    // InternalTextualScenario.g:1779:1: entryRuleStateFragment returns [EObject current=null] : iv_ruleStateFragment= ruleStateFragment EOF ;
    public final EObject entryRuleStateFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateFragment = null;


        try {
            // InternalTextualScenario.g:1779:54: (iv_ruleStateFragment= ruleStateFragment EOF )
            // InternalTextualScenario.g:1780:2: iv_ruleStateFragment= ruleStateFragment EOF
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
    // InternalTextualScenario.g:1786:1: ruleStateFragment returns [EObject current=null] : ( ( (lv_on_0_0= 'on' ) ) ( (lv_timeline_1_0= RULE_STRING ) ) ( ( (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' ) ) ) ( (lv_name_3_0= RULE_STRING ) ) ) ;
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
            // InternalTextualScenario.g:1792:2: ( ( ( (lv_on_0_0= 'on' ) ) ( (lv_timeline_1_0= RULE_STRING ) ) ( ( (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' ) ) ) ( (lv_name_3_0= RULE_STRING ) ) ) )
            // InternalTextualScenario.g:1793:2: ( ( (lv_on_0_0= 'on' ) ) ( (lv_timeline_1_0= RULE_STRING ) ) ( ( (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' ) ) ) ( (lv_name_3_0= RULE_STRING ) ) )
            {
            // InternalTextualScenario.g:1793:2: ( ( (lv_on_0_0= 'on' ) ) ( (lv_timeline_1_0= RULE_STRING ) ) ( ( (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' ) ) ) ( (lv_name_3_0= RULE_STRING ) ) )
            // InternalTextualScenario.g:1794:3: ( (lv_on_0_0= 'on' ) ) ( (lv_timeline_1_0= RULE_STRING ) ) ( ( (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' ) ) ) ( (lv_name_3_0= RULE_STRING ) )
            {
            // InternalTextualScenario.g:1794:3: ( (lv_on_0_0= 'on' ) )
            // InternalTextualScenario.g:1795:4: (lv_on_0_0= 'on' )
            {
            // InternalTextualScenario.g:1795:4: (lv_on_0_0= 'on' )
            // InternalTextualScenario.g:1796:5: lv_on_0_0= 'on'
            {
            lv_on_0_0=(Token)match(input,45,FOLLOW_6); 

            					newLeafNode(lv_on_0_0, grammarAccess.getStateFragmentAccess().getOnOnKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateFragmentRule());
            					}
            					setWithLastConsumed(current, "on", lv_on_0_0, "on");
            				

            }


            }

            // InternalTextualScenario.g:1808:3: ( (lv_timeline_1_0= RULE_STRING ) )
            // InternalTextualScenario.g:1809:4: (lv_timeline_1_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1809:4: (lv_timeline_1_0= RULE_STRING )
            // InternalTextualScenario.g:1810:5: lv_timeline_1_0= RULE_STRING
            {
            lv_timeline_1_0=(Token)match(input,RULE_STRING,FOLLOW_17); 

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

            // InternalTextualScenario.g:1826:3: ( ( (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' ) ) )
            // InternalTextualScenario.g:1827:4: ( (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' ) )
            {
            // InternalTextualScenario.g:1827:4: ( (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' ) )
            // InternalTextualScenario.g:1828:5: (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' )
            {
            // InternalTextualScenario.g:1828:5: (lv_keyword_2_1= 'state' | lv_keyword_2_2= 'mode' | lv_keyword_2_3= 'function' )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt21=1;
                }
                break;
            case 47:
                {
                alt21=2;
                }
                break;
            case 20:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalTextualScenario.g:1829:6: lv_keyword_2_1= 'state'
                    {
                    lv_keyword_2_1=(Token)match(input,46,FOLLOW_6); 

                    						newLeafNode(lv_keyword_2_1, grammarAccess.getStateFragmentAccess().getKeywordStateKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStateFragmentRule());
                    						}
                    						setWithLastConsumed(current, "keyword", lv_keyword_2_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:1840:6: lv_keyword_2_2= 'mode'
                    {
                    lv_keyword_2_2=(Token)match(input,47,FOLLOW_6); 

                    						newLeafNode(lv_keyword_2_2, grammarAccess.getStateFragmentAccess().getKeywordModeKeyword_2_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStateFragmentRule());
                    						}
                    						setWithLastConsumed(current, "keyword", lv_keyword_2_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:1851:6: lv_keyword_2_3= 'function'
                    {
                    lv_keyword_2_3=(Token)match(input,20,FOLLOW_6); 

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

            // InternalTextualScenario.g:1864:3: ( (lv_name_3_0= RULE_STRING ) )
            // InternalTextualScenario.g:1865:4: (lv_name_3_0= RULE_STRING )
            {
            // InternalTextualScenario.g:1865:4: (lv_name_3_0= RULE_STRING )
            // InternalTextualScenario.g:1866:5: lv_name_3_0= RULE_STRING
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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00002FFDC0F8E010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00002FFDC0002010L});
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
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000100000000012L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000C00000100000L});

}
