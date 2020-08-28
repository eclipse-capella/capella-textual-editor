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
package org.polarsys.capella.scenario.editor.dslscenario.parser.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.polarsys.capella.scenario.editor.dslscenario.services.DslGrammarAccess;

@SuppressWarnings("all")
public class InternalDslParser extends AbstractInternalAntlrParser {
  public static final String[] tokenNames = new String[] { "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING",
      "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'scenario'", "'{'",
      "'}'", "'actor'", "'component'", "'unset'", "'behavior'", "'node'", "'configuration_item'", "'function'",
      "'activity'", "'entity'", "'role'", "'->'", "':'", "'->+'", "'->x'", "'<--'", "'->>'", "'deactivate'", "'ref'",
      "'over'" };
  public static final int RULE_STRING = 4;
  public static final int RULE_SL_COMMENT = 8;
  public static final int T__19 = 19;
  public static final int T__15 = 15;
  public static final int T__16 = 16;
  public static final int T__17 = 17;
  public static final int T__18 = 18;
  public static final int T__11 = 11;
  public static final int T__12 = 12;
  public static final int T__13 = 13;
  public static final int T__14 = 14;
  public static final int EOF = -1;
  public static final int T__30 = 30;
  public static final int T__31 = 31;
  public static final int T__32 = 32;
  public static final int RULE_ID = 5;
  public static final int RULE_WS = 9;
  public static final int RULE_ANY_OTHER = 10;
  public static final int T__26 = 26;
  public static final int T__27 = 27;
  public static final int T__28 = 28;
  public static final int RULE_INT = 6;
  public static final int T__29 = 29;
  public static final int T__22 = 22;
  public static final int RULE_ML_COMMENT = 7;
  public static final int T__23 = 23;
  public static final int T__24 = 24;
  public static final int T__25 = 25;
  public static final int T__20 = 20;
  public static final int T__21 = 21;

  // delegates
  // delegators

  public InternalDslParser(TokenStream input) {
    this(input, new RecognizerSharedState());
  }

  public InternalDslParser(TokenStream input, RecognizerSharedState state) {
    super(input, state);

  }

  @Override
  public String[] getTokenNames() {
    return InternalDslParser.tokenNames;
  }

  @Override
  public String getGrammarFileName() {
    return "InternalDsl.g";
  }

  private DslGrammarAccess grammarAccess;

  public InternalDslParser(TokenStream input, DslGrammarAccess grammarAccess) {
    this(input);
    this.grammarAccess = grammarAccess;
    registerRules(grammarAccess.getGrammar());
  }

  @Override
  protected String getFirstRuleName() {
    return "Model";
  }

  @Override
  protected DslGrammarAccess getGrammarAccess() {
    return grammarAccess;
  }

  // $ANTLR start "entryRuleModel"
  // InternalDsl.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
  public final EObject entryRuleModel() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleModel = null;

    try {
      // InternalDsl.g:64:46: (iv_ruleModel= ruleModel EOF )
      // InternalDsl.g:65:2: iv_ruleModel= ruleModel EOF
      {
        newCompositeNode(grammarAccess.getModelRule());
        pushFollow(FOLLOW_1);
        iv_ruleModel = ruleModel();

        state._fsp--;

        current = iv_ruleModel;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleModel"

  // $ANTLR start "ruleModel"
  // InternalDsl.g:71:1: ruleModel returns [EObject current=null] : (otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) (
  // (lv_participants_2_0= ruleParticipant ) )* ( ( (lv_messagesOrReferences_3_1= ruleMessage |
  // lv_messagesOrReferences_3_2= ruleReference ) ) )* ( (lv_end_4_0= '}' ) ) ) ;
  public final EObject ruleModel() throws RecognitionException {
    EObject current = null;

    Token otherlv_0 = null;
    Token lv_begin_1_0 = null;
    Token lv_end_4_0 = null;
    EObject lv_participants_2_0 = null;

    EObject lv_messagesOrReferences_3_1 = null;

    EObject lv_messagesOrReferences_3_2 = null;

    enterRule();

    try {
      // InternalDsl.g:77:2: ( (otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant )
      // )* ( ( (lv_messagesOrReferences_3_1= ruleMessage | lv_messagesOrReferences_3_2= ruleReference ) ) )* (
      // (lv_end_4_0= '}' ) ) ) )
      // InternalDsl.g:78:2: (otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant )
      // )* ( ( (lv_messagesOrReferences_3_1= ruleMessage | lv_messagesOrReferences_3_2= ruleReference ) ) )* (
      // (lv_end_4_0= '}' ) ) )
      {
        // InternalDsl.g:78:2: (otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant )
        // )* ( ( (lv_messagesOrReferences_3_1= ruleMessage | lv_messagesOrReferences_3_2= ruleReference ) ) )* (
        // (lv_end_4_0= '}' ) ) )
        // InternalDsl.g:79:3: otherlv_0= 'scenario' ( (lv_begin_1_0= '{' ) ) ( (lv_participants_2_0= ruleParticipant )
        // )* ( ( (lv_messagesOrReferences_3_1= ruleMessage | lv_messagesOrReferences_3_2= ruleReference ) ) )* (
        // (lv_end_4_0= '}' ) )
        {
          otherlv_0 = (Token) match(input, 11, FOLLOW_3);

          newLeafNode(otherlv_0, grammarAccess.getModelAccess().getScenarioKeyword_0());

          // InternalDsl.g:83:3: ( (lv_begin_1_0= '{' ) )
          // InternalDsl.g:84:4: (lv_begin_1_0= '{' )
          {
            // InternalDsl.g:84:4: (lv_begin_1_0= '{' )
            // InternalDsl.g:85:5: lv_begin_1_0= '{'
            {
              lv_begin_1_0 = (Token) match(input, 12, FOLLOW_4);

              newLeafNode(lv_begin_1_0, grammarAccess.getModelAccess().getBeginLeftCurlyBracketKeyword_1_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getModelRule());
              }
              setWithLastConsumed(current, "begin", lv_begin_1_0, "{");

            }

          }

          // InternalDsl.g:97:3: ( (lv_participants_2_0= ruleParticipant ) )*
          loop1: do {
            int alt1 = 2;
            int LA1_0 = input.LA(1);

            if (((LA1_0 >= 14 && LA1_0 <= 15) || (LA1_0 >= 19 && LA1_0 <= 23))) {
              alt1 = 1;
            }

            switch (alt1) {
            case 1:
            // InternalDsl.g:98:4: (lv_participants_2_0= ruleParticipant )
            {
              // InternalDsl.g:98:4: (lv_participants_2_0= ruleParticipant )
              // InternalDsl.g:99:5: lv_participants_2_0= ruleParticipant
              {

                newCompositeNode(grammarAccess.getModelAccess().getParticipantsParticipantParserRuleCall_2_0());

                pushFollow(FOLLOW_4);
                lv_participants_2_0 = ruleParticipant();

                state._fsp--;

                if (current == null) {
                  current = createModelElementForParent(grammarAccess.getModelRule());
                }
                add(current, "participants", lv_participants_2_0,
                    "org.polarsys.capella.scenario.editor.dslscenario.Dsl.Participant");
                afterParserOrEnumRuleCall();

              }

            }
              break;

            default:
              break loop1;
            }
          } while (true);

          // InternalDsl.g:116:3: ( ( (lv_messagesOrReferences_3_1= ruleMessage | lv_messagesOrReferences_3_2=
          // ruleReference ) ) )*
          loop3: do {
            int alt3 = 2;
            int LA3_0 = input.LA(1);

            if ((LA3_0 == RULE_STRING || (LA3_0 >= 29 && LA3_0 <= 31))) {
              alt3 = 1;
            }

            switch (alt3) {
            case 1:
            // InternalDsl.g:117:4: ( (lv_messagesOrReferences_3_1= ruleMessage | lv_messagesOrReferences_3_2=
            // ruleReference ) )
            {
              // InternalDsl.g:117:4: ( (lv_messagesOrReferences_3_1= ruleMessage | lv_messagesOrReferences_3_2=
              // ruleReference ) )
              // InternalDsl.g:118:5: (lv_messagesOrReferences_3_1= ruleMessage | lv_messagesOrReferences_3_2=
              // ruleReference )
              {
                // InternalDsl.g:118:5: (lv_messagesOrReferences_3_1= ruleMessage | lv_messagesOrReferences_3_2=
                // ruleReference )
                int alt2 = 2;
                int LA2_0 = input.LA(1);

                if ((LA2_0 == RULE_STRING || (LA2_0 >= 29 && LA2_0 <= 30))) {
                  alt2 = 1;
                } else if ((LA2_0 == 31)) {
                  alt2 = 2;
                } else {
                  NoViableAltException nvae = new NoViableAltException("", 2, 0, input);

                  throw nvae;
                }
                switch (alt2) {
                case 1:
                // InternalDsl.g:119:6: lv_messagesOrReferences_3_1= ruleMessage
                {

                  newCompositeNode(grammarAccess.getModelAccess().getMessagesOrReferencesMessageParserRuleCall_3_0_0());

                  pushFollow(FOLLOW_5);
                  lv_messagesOrReferences_3_1 = ruleMessage();

                  state._fsp--;

                  if (current == null) {
                    current = createModelElementForParent(grammarAccess.getModelRule());
                  }
                  add(current, "messagesOrReferences", lv_messagesOrReferences_3_1,
                      "org.polarsys.capella.scenario.editor.dslscenario.Dsl.Message");
                  afterParserOrEnumRuleCall();

                }
                  break;
                case 2:
                // InternalDsl.g:135:6: lv_messagesOrReferences_3_2= ruleReference
                {

                  newCompositeNode(
                      grammarAccess.getModelAccess().getMessagesOrReferencesReferenceParserRuleCall_3_0_1());

                  pushFollow(FOLLOW_5);
                  lv_messagesOrReferences_3_2 = ruleReference();

                  state._fsp--;

                  if (current == null) {
                    current = createModelElementForParent(grammarAccess.getModelRule());
                  }
                  add(current, "messagesOrReferences", lv_messagesOrReferences_3_2,
                      "org.polarsys.capella.scenario.editor.dslscenario.Dsl.Reference");
                  afterParserOrEnumRuleCall();

                }
                  break;

                }

              }

            }
              break;

            default:
              break loop3;
            }
          } while (true);

          // InternalDsl.g:153:3: ( (lv_end_4_0= '}' ) )
          // InternalDsl.g:154:4: (lv_end_4_0= '}' )
          {
            // InternalDsl.g:154:4: (lv_end_4_0= '}' )
            // InternalDsl.g:155:5: lv_end_4_0= '}'
            {
              lv_end_4_0 = (Token) match(input, 13, FOLLOW_2);

              newLeafNode(lv_end_4_0, grammarAccess.getModelAccess().getEndRightCurlyBracketKeyword_4_0());

              if (current == null) {
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
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleModel"

  // $ANTLR start "entryRuleParticipant"
  // InternalDsl.g:171:1: entryRuleParticipant returns [EObject current=null] : iv_ruleParticipant= ruleParticipant EOF
  // ;
  public final EObject entryRuleParticipant() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleParticipant = null;

    try {
      // InternalDsl.g:171:52: (iv_ruleParticipant= ruleParticipant EOF )
      // InternalDsl.g:172:2: iv_ruleParticipant= ruleParticipant EOF
      {
        newCompositeNode(grammarAccess.getParticipantRule());
        pushFollow(FOLLOW_1);
        iv_ruleParticipant = ruleParticipant();

        state._fsp--;

        current = iv_ruleParticipant;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleParticipant"

  // $ANTLR start "ruleParticipant"
  // InternalDsl.g:178:1: ruleParticipant returns [EObject current=null] : (this_GenericComponent_0=
  // ruleGenericComponent | this_GenericFunction_1= ruleGenericFunction ) ;
  public final EObject ruleParticipant() throws RecognitionException {
    EObject current = null;

    EObject this_GenericComponent_0 = null;

    EObject this_GenericFunction_1 = null;

    enterRule();

    try {
      // InternalDsl.g:184:2: ( (this_GenericComponent_0= ruleGenericComponent | this_GenericFunction_1=
      // ruleGenericFunction ) )
      // InternalDsl.g:185:2: (this_GenericComponent_0= ruleGenericComponent | this_GenericFunction_1=
      // ruleGenericFunction )
      {
        // InternalDsl.g:185:2: (this_GenericComponent_0= ruleGenericComponent | this_GenericFunction_1=
        // ruleGenericFunction )
        int alt4 = 2;
        int LA4_0 = input.LA(1);

        if (((LA4_0 >= 14 && LA4_0 <= 15) || LA4_0 == 19 || (LA4_0 >= 22 && LA4_0 <= 23))) {
          alt4 = 1;
        } else if (((LA4_0 >= 20 && LA4_0 <= 21))) {
          alt4 = 2;
        } else {
          NoViableAltException nvae = new NoViableAltException("", 4, 0, input);

          throw nvae;
        }
        switch (alt4) {
        case 1:
        // InternalDsl.g:186:3: this_GenericComponent_0= ruleGenericComponent
        {

          newCompositeNode(grammarAccess.getParticipantAccess().getGenericComponentParserRuleCall_0());

          pushFollow(FOLLOW_2);
          this_GenericComponent_0 = ruleGenericComponent();

          state._fsp--;

          current = this_GenericComponent_0;
          afterParserOrEnumRuleCall();

        }
          break;
        case 2:
        // InternalDsl.g:195:3: this_GenericFunction_1= ruleGenericFunction
        {

          newCompositeNode(grammarAccess.getParticipantAccess().getGenericFunctionParserRuleCall_1());

          pushFollow(FOLLOW_2);
          this_GenericFunction_1 = ruleGenericFunction();

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
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleParticipant"

  // $ANTLR start "entryRuleGenericComponent"
  // InternalDsl.g:207:1: entryRuleGenericComponent returns [EObject current=null] : iv_ruleGenericComponent=
  // ruleGenericComponent EOF ;
  public final EObject entryRuleGenericComponent() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleGenericComponent = null;

    try {
      // InternalDsl.g:207:57: (iv_ruleGenericComponent= ruleGenericComponent EOF )
      // InternalDsl.g:208:2: iv_ruleGenericComponent= ruleGenericComponent EOF
      {
        newCompositeNode(grammarAccess.getGenericComponentRule());
        pushFollow(FOLLOW_1);
        iv_ruleGenericComponent = ruleGenericComponent();

        state._fsp--;

        current = iv_ruleGenericComponent;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleGenericComponent"

  // $ANTLR start "ruleGenericComponent"
  // InternalDsl.g:214:1: ruleGenericComponent returns [EObject current=null] : (this_Entity_0= ruleEntity |
  // this_Actor_1= ruleActor | this_Component_2= ruleComponent | this_ConfigurationItem_3= ruleConfigurationItem |
  // this_Role_4= ruleRole ) ;
  public final EObject ruleGenericComponent() throws RecognitionException {
    EObject current = null;

    EObject this_Entity_0 = null;

    EObject this_Actor_1 = null;

    EObject this_Component_2 = null;

    EObject this_ConfigurationItem_3 = null;

    EObject this_Role_4 = null;

    enterRule();

    try {
      // InternalDsl.g:220:2: ( (this_Entity_0= ruleEntity | this_Actor_1= ruleActor | this_Component_2= ruleComponent |
      // this_ConfigurationItem_3= ruleConfigurationItem | this_Role_4= ruleRole ) )
      // InternalDsl.g:221:2: (this_Entity_0= ruleEntity | this_Actor_1= ruleActor | this_Component_2= ruleComponent |
      // this_ConfigurationItem_3= ruleConfigurationItem | this_Role_4= ruleRole )
      {
        // InternalDsl.g:221:2: (this_Entity_0= ruleEntity | this_Actor_1= ruleActor | this_Component_2= ruleComponent |
        // this_ConfigurationItem_3= ruleConfigurationItem | this_Role_4= ruleRole )
        int alt5 = 5;
        switch (input.LA(1)) {
        case 22: {
          alt5 = 1;
        }
          break;
        case 14: {
          alt5 = 2;
        }
          break;
        case 15: {
          alt5 = 3;
        }
          break;
        case 19: {
          alt5 = 4;
        }
          break;
        case 23: {
          alt5 = 5;
        }
          break;
        default:
          NoViableAltException nvae = new NoViableAltException("", 5, 0, input);

          throw nvae;
        }

        switch (alt5) {
        case 1:
        // InternalDsl.g:222:3: this_Entity_0= ruleEntity
        {

          newCompositeNode(grammarAccess.getGenericComponentAccess().getEntityParserRuleCall_0());

          pushFollow(FOLLOW_2);
          this_Entity_0 = ruleEntity();

          state._fsp--;

          current = this_Entity_0;
          afterParserOrEnumRuleCall();

        }
          break;
        case 2:
        // InternalDsl.g:231:3: this_Actor_1= ruleActor
        {

          newCompositeNode(grammarAccess.getGenericComponentAccess().getActorParserRuleCall_1());

          pushFollow(FOLLOW_2);
          this_Actor_1 = ruleActor();

          state._fsp--;

          current = this_Actor_1;
          afterParserOrEnumRuleCall();

        }
          break;
        case 3:
        // InternalDsl.g:240:3: this_Component_2= ruleComponent
        {

          newCompositeNode(grammarAccess.getGenericComponentAccess().getComponentParserRuleCall_2());

          pushFollow(FOLLOW_2);
          this_Component_2 = ruleComponent();

          state._fsp--;

          current = this_Component_2;
          afterParserOrEnumRuleCall();

        }
          break;
        case 4:
        // InternalDsl.g:249:3: this_ConfigurationItem_3= ruleConfigurationItem
        {

          newCompositeNode(grammarAccess.getGenericComponentAccess().getConfigurationItemParserRuleCall_3());

          pushFollow(FOLLOW_2);
          this_ConfigurationItem_3 = ruleConfigurationItem();

          state._fsp--;

          current = this_ConfigurationItem_3;
          afterParserOrEnumRuleCall();

        }
          break;
        case 5:
        // InternalDsl.g:258:3: this_Role_4= ruleRole
        {

          newCompositeNode(grammarAccess.getGenericComponentAccess().getRoleParserRuleCall_4());

          pushFollow(FOLLOW_2);
          this_Role_4 = ruleRole();

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
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleGenericComponent"

  // $ANTLR start "entryRuleGenericFunction"
  // InternalDsl.g:270:1: entryRuleGenericFunction returns [EObject current=null] : iv_ruleGenericFunction=
  // ruleGenericFunction EOF ;
  public final EObject entryRuleGenericFunction() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleGenericFunction = null;

    try {
      // InternalDsl.g:270:56: (iv_ruleGenericFunction= ruleGenericFunction EOF )
      // InternalDsl.g:271:2: iv_ruleGenericFunction= ruleGenericFunction EOF
      {
        newCompositeNode(grammarAccess.getGenericFunctionRule());
        pushFollow(FOLLOW_1);
        iv_ruleGenericFunction = ruleGenericFunction();

        state._fsp--;

        current = iv_ruleGenericFunction;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleGenericFunction"

  // $ANTLR start "ruleGenericFunction"
  // InternalDsl.g:277:1: ruleGenericFunction returns [EObject current=null] : (this_Function_0= ruleFunction |
  // this_Activity_1= ruleActivity ) ;
  public final EObject ruleGenericFunction() throws RecognitionException {
    EObject current = null;

    EObject this_Function_0 = null;

    EObject this_Activity_1 = null;

    enterRule();

    try {
      // InternalDsl.g:283:2: ( (this_Function_0= ruleFunction | this_Activity_1= ruleActivity ) )
      // InternalDsl.g:284:2: (this_Function_0= ruleFunction | this_Activity_1= ruleActivity )
      {
        // InternalDsl.g:284:2: (this_Function_0= ruleFunction | this_Activity_1= ruleActivity )
        int alt6 = 2;
        int LA6_0 = input.LA(1);

        if ((LA6_0 == 20)) {
          alt6 = 1;
        } else if ((LA6_0 == 21)) {
          alt6 = 2;
        } else {
          NoViableAltException nvae = new NoViableAltException("", 6, 0, input);

          throw nvae;
        }
        switch (alt6) {
        case 1:
        // InternalDsl.g:285:3: this_Function_0= ruleFunction
        {

          newCompositeNode(grammarAccess.getGenericFunctionAccess().getFunctionParserRuleCall_0());

          pushFollow(FOLLOW_2);
          this_Function_0 = ruleFunction();

          state._fsp--;

          current = this_Function_0;
          afterParserOrEnumRuleCall();

        }
          break;
        case 2:
        // InternalDsl.g:294:3: this_Activity_1= ruleActivity
        {

          newCompositeNode(grammarAccess.getGenericFunctionAccess().getActivityParserRuleCall_1());

          pushFollow(FOLLOW_2);
          this_Activity_1 = ruleActivity();

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
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleGenericFunction"

  // $ANTLR start "entryRuleActor"
  // InternalDsl.g:306:1: entryRuleActor returns [EObject current=null] : iv_ruleActor= ruleActor EOF ;
  public final EObject entryRuleActor() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleActor = null;

    try {
      // InternalDsl.g:306:46: (iv_ruleActor= ruleActor EOF )
      // InternalDsl.g:307:2: iv_ruleActor= ruleActor EOF
      {
        newCompositeNode(grammarAccess.getActorRule());
        pushFollow(FOLLOW_1);
        iv_ruleActor = ruleActor();

        state._fsp--;

        current = iv_ruleActor;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleActor"

  // $ANTLR start "ruleActor"
  // InternalDsl.g:313:1: ruleActor returns [EObject current=null] : ( ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0=
  // RULE_STRING ) ) ) ;
  public final EObject ruleActor() throws RecognitionException {
    EObject current = null;

    Token lv_keyword_0_0 = null;
    Token lv_name_1_0 = null;

    enterRule();

    try {
      // InternalDsl.g:319:2: ( ( ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
      // InternalDsl.g:320:2: ( ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
      {
        // InternalDsl.g:320:2: ( ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
        // InternalDsl.g:321:3: ( (lv_keyword_0_0= 'actor' ) ) ( (lv_name_1_0= RULE_STRING ) )
        {
          // InternalDsl.g:321:3: ( (lv_keyword_0_0= 'actor' ) )
          // InternalDsl.g:322:4: (lv_keyword_0_0= 'actor' )
          {
            // InternalDsl.g:322:4: (lv_keyword_0_0= 'actor' )
            // InternalDsl.g:323:5: lv_keyword_0_0= 'actor'
            {
              lv_keyword_0_0 = (Token) match(input, 14, FOLLOW_6);

              newLeafNode(lv_keyword_0_0, grammarAccess.getActorAccess().getKeywordActorKeyword_0_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getActorRule());
              }
              setWithLastConsumed(current, "keyword", lv_keyword_0_0, "actor");

            }

          }

          // InternalDsl.g:335:3: ( (lv_name_1_0= RULE_STRING ) )
          // InternalDsl.g:336:4: (lv_name_1_0= RULE_STRING )
          {
            // InternalDsl.g:336:4: (lv_name_1_0= RULE_STRING )
            // InternalDsl.g:337:5: lv_name_1_0= RULE_STRING
            {
              lv_name_1_0 = (Token) match(input, RULE_STRING, FOLLOW_2);

              newLeafNode(lv_name_1_0, grammarAccess.getActorAccess().getNameSTRINGTerminalRuleCall_1_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getActorRule());
              }
              setWithLastConsumed(current, "name", lv_name_1_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

        }

      }

      leaveRule();

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleActor"

  // $ANTLR start "entryRuleComponent"
  // InternalDsl.g:357:1: entryRuleComponent returns [EObject current=null] : iv_ruleComponent= ruleComponent EOF ;
  public final EObject entryRuleComponent() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleComponent = null;

    try {
      // InternalDsl.g:357:50: (iv_ruleComponent= ruleComponent EOF )
      // InternalDsl.g:358:2: iv_ruleComponent= ruleComponent EOF
      {
        newCompositeNode(grammarAccess.getComponentRule());
        pushFollow(FOLLOW_1);
        iv_ruleComponent = ruleComponent();

        state._fsp--;

        current = iv_ruleComponent;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleComponent"

  // $ANTLR start "ruleComponent"
  // InternalDsl.g:364:1: ruleComponent returns [EObject current=null] : ( ( (lv_keyword_0_0= 'component' ) ) (
  // (lv_name_1_0= RULE_STRING ) ) ( ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) )
  // )? ) ;
  public final EObject ruleComponent() throws RecognitionException {
    EObject current = null;

    Token lv_keyword_0_0 = null;
    Token lv_name_1_0 = null;
    Token lv_nature_2_1 = null;
    Token lv_nature_2_2 = null;
    Token lv_nature_2_3 = null;

    enterRule();

    try {
      // InternalDsl.g:370:2: ( ( ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( ( (lv_nature_2_1=
      // 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )? ) )
      // InternalDsl.g:371:2: ( ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( ( (lv_nature_2_1=
      // 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )? )
      {
        // InternalDsl.g:371:2: ( ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( ( (lv_nature_2_1=
        // 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )? )
        // InternalDsl.g:372:3: ( (lv_keyword_0_0= 'component' ) ) ( (lv_name_1_0= RULE_STRING ) ) ( ( (lv_nature_2_1=
        // 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )?
        {
          // InternalDsl.g:372:3: ( (lv_keyword_0_0= 'component' ) )
          // InternalDsl.g:373:4: (lv_keyword_0_0= 'component' )
          {
            // InternalDsl.g:373:4: (lv_keyword_0_0= 'component' )
            // InternalDsl.g:374:5: lv_keyword_0_0= 'component'
            {
              lv_keyword_0_0 = (Token) match(input, 15, FOLLOW_6);

              newLeafNode(lv_keyword_0_0, grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getComponentRule());
              }
              setWithLastConsumed(current, "keyword", lv_keyword_0_0, "component");

            }

          }

          // InternalDsl.g:386:3: ( (lv_name_1_0= RULE_STRING ) )
          // InternalDsl.g:387:4: (lv_name_1_0= RULE_STRING )
          {
            // InternalDsl.g:387:4: (lv_name_1_0= RULE_STRING )
            // InternalDsl.g:388:5: lv_name_1_0= RULE_STRING
            {
              lv_name_1_0 = (Token) match(input, RULE_STRING, FOLLOW_7);

              newLeafNode(lv_name_1_0, grammarAccess.getComponentAccess().getNameSTRINGTerminalRuleCall_1_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getComponentRule());
              }
              setWithLastConsumed(current, "name", lv_name_1_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

          // InternalDsl.g:404:3: ( ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) ) )?
          int alt8 = 2;
          int LA8_0 = input.LA(1);

          if (((LA8_0 >= 16 && LA8_0 <= 18))) {
            alt8 = 1;
          }
          switch (alt8) {
          case 1:
          // InternalDsl.g:405:4: ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) )
          {
            // InternalDsl.g:405:4: ( (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' ) )
            // InternalDsl.g:406:5: (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' )
            {
              // InternalDsl.g:406:5: (lv_nature_2_1= 'unset' | lv_nature_2_2= 'behavior' | lv_nature_2_3= 'node' )
              int alt7 = 3;
              switch (input.LA(1)) {
              case 16: {
                alt7 = 1;
              }
                break;
              case 17: {
                alt7 = 2;
              }
                break;
              case 18: {
                alt7 = 3;
              }
                break;
              default:
                NoViableAltException nvae = new NoViableAltException("", 7, 0, input);

                throw nvae;
              }

              switch (alt7) {
              case 1:
              // InternalDsl.g:407:6: lv_nature_2_1= 'unset'
              {
                lv_nature_2_1 = (Token) match(input, 16, FOLLOW_2);

                newLeafNode(lv_nature_2_1, grammarAccess.getComponentAccess().getNatureUnsetKeyword_2_0_0());

                if (current == null) {
                  current = createModelElement(grammarAccess.getComponentRule());
                }
                setWithLastConsumed(current, "nature", lv_nature_2_1, null);

              }
                break;
              case 2:
              // InternalDsl.g:418:6: lv_nature_2_2= 'behavior'
              {
                lv_nature_2_2 = (Token) match(input, 17, FOLLOW_2);

                newLeafNode(lv_nature_2_2, grammarAccess.getComponentAccess().getNatureBehaviorKeyword_2_0_1());

                if (current == null) {
                  current = createModelElement(grammarAccess.getComponentRule());
                }
                setWithLastConsumed(current, "nature", lv_nature_2_2, null);

              }
                break;
              case 3:
              // InternalDsl.g:429:6: lv_nature_2_3= 'node'
              {
                lv_nature_2_3 = (Token) match(input, 18, FOLLOW_2);

                newLeafNode(lv_nature_2_3, grammarAccess.getComponentAccess().getNatureNodeKeyword_2_0_2());

                if (current == null) {
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
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleComponent"

  // $ANTLR start "entryRuleConfigurationItem"
  // InternalDsl.g:446:1: entryRuleConfigurationItem returns [EObject current=null] : iv_ruleConfigurationItem=
  // ruleConfigurationItem EOF ;
  public final EObject entryRuleConfigurationItem() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleConfigurationItem = null;

    try {
      // InternalDsl.g:446:58: (iv_ruleConfigurationItem= ruleConfigurationItem EOF )
      // InternalDsl.g:447:2: iv_ruleConfigurationItem= ruleConfigurationItem EOF
      {
        newCompositeNode(grammarAccess.getConfigurationItemRule());
        pushFollow(FOLLOW_1);
        iv_ruleConfigurationItem = ruleConfigurationItem();

        state._fsp--;

        current = iv_ruleConfigurationItem;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleConfigurationItem"

  // $ANTLR start "ruleConfigurationItem"
  // InternalDsl.g:453:1: ruleConfigurationItem returns [EObject current=null] : ( ( (lv_keyword_0_0=
  // 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
  public final EObject ruleConfigurationItem() throws RecognitionException {
    EObject current = null;

    Token lv_keyword_0_0 = null;
    Token lv_name_1_0 = null;

    enterRule();

    try {
      // InternalDsl.g:459:2: ( ( ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
      // InternalDsl.g:460:2: ( ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
      {
        // InternalDsl.g:460:2: ( ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
        // InternalDsl.g:461:3: ( (lv_keyword_0_0= 'configuration_item' ) ) ( (lv_name_1_0= RULE_STRING ) )
        {
          // InternalDsl.g:461:3: ( (lv_keyword_0_0= 'configuration_item' ) )
          // InternalDsl.g:462:4: (lv_keyword_0_0= 'configuration_item' )
          {
            // InternalDsl.g:462:4: (lv_keyword_0_0= 'configuration_item' )
            // InternalDsl.g:463:5: lv_keyword_0_0= 'configuration_item'
            {
              lv_keyword_0_0 = (Token) match(input, 19, FOLLOW_6);

              newLeafNode(lv_keyword_0_0,
                  grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getConfigurationItemRule());
              }
              setWithLastConsumed(current, "keyword", lv_keyword_0_0, "configuration_item");

            }

          }

          // InternalDsl.g:475:3: ( (lv_name_1_0= RULE_STRING ) )
          // InternalDsl.g:476:4: (lv_name_1_0= RULE_STRING )
          {
            // InternalDsl.g:476:4: (lv_name_1_0= RULE_STRING )
            // InternalDsl.g:477:5: lv_name_1_0= RULE_STRING
            {
              lv_name_1_0 = (Token) match(input, RULE_STRING, FOLLOW_2);

              newLeafNode(lv_name_1_0, grammarAccess.getConfigurationItemAccess().getNameSTRINGTerminalRuleCall_1_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getConfigurationItemRule());
              }
              setWithLastConsumed(current, "name", lv_name_1_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

        }

      }

      leaveRule();

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleConfigurationItem"

  // $ANTLR start "entryRuleFunction"
  // InternalDsl.g:497:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
  public final EObject entryRuleFunction() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleFunction = null;

    try {
      // InternalDsl.g:497:49: (iv_ruleFunction= ruleFunction EOF )
      // InternalDsl.g:498:2: iv_ruleFunction= ruleFunction EOF
      {
        newCompositeNode(grammarAccess.getFunctionRule());
        pushFollow(FOLLOW_1);
        iv_ruleFunction = ruleFunction();

        state._fsp--;

        current = iv_ruleFunction;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleFunction"

  // $ANTLR start "ruleFunction"
  // InternalDsl.g:504:1: ruleFunction returns [EObject current=null] : ( ( (lv_keyword_0_0= 'function' ) ) (
  // (lv_name_1_0= RULE_STRING ) ) ) ;
  public final EObject ruleFunction() throws RecognitionException {
    EObject current = null;

    Token lv_keyword_0_0 = null;
    Token lv_name_1_0 = null;

    enterRule();

    try {
      // InternalDsl.g:510:2: ( ( ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
      // InternalDsl.g:511:2: ( ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
      {
        // InternalDsl.g:511:2: ( ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
        // InternalDsl.g:512:3: ( (lv_keyword_0_0= 'function' ) ) ( (lv_name_1_0= RULE_STRING ) )
        {
          // InternalDsl.g:512:3: ( (lv_keyword_0_0= 'function' ) )
          // InternalDsl.g:513:4: (lv_keyword_0_0= 'function' )
          {
            // InternalDsl.g:513:4: (lv_keyword_0_0= 'function' )
            // InternalDsl.g:514:5: lv_keyword_0_0= 'function'
            {
              lv_keyword_0_0 = (Token) match(input, 20, FOLLOW_6);

              newLeafNode(lv_keyword_0_0, grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getFunctionRule());
              }
              setWithLastConsumed(current, "keyword", lv_keyword_0_0, "function");

            }

          }

          // InternalDsl.g:526:3: ( (lv_name_1_0= RULE_STRING ) )
          // InternalDsl.g:527:4: (lv_name_1_0= RULE_STRING )
          {
            // InternalDsl.g:527:4: (lv_name_1_0= RULE_STRING )
            // InternalDsl.g:528:5: lv_name_1_0= RULE_STRING
            {
              lv_name_1_0 = (Token) match(input, RULE_STRING, FOLLOW_2);

              newLeafNode(lv_name_1_0, grammarAccess.getFunctionAccess().getNameSTRINGTerminalRuleCall_1_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getFunctionRule());
              }
              setWithLastConsumed(current, "name", lv_name_1_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

        }

      }

      leaveRule();

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleFunction"

  // $ANTLR start "entryRuleActivity"
  // InternalDsl.g:548:1: entryRuleActivity returns [EObject current=null] : iv_ruleActivity= ruleActivity EOF ;
  public final EObject entryRuleActivity() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleActivity = null;

    try {
      // InternalDsl.g:548:49: (iv_ruleActivity= ruleActivity EOF )
      // InternalDsl.g:549:2: iv_ruleActivity= ruleActivity EOF
      {
        newCompositeNode(grammarAccess.getActivityRule());
        pushFollow(FOLLOW_1);
        iv_ruleActivity = ruleActivity();

        state._fsp--;

        current = iv_ruleActivity;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleActivity"

  // $ANTLR start "ruleActivity"
  // InternalDsl.g:555:1: ruleActivity returns [EObject current=null] : ( ( (lv_keyword_0_0= 'activity' ) ) (
  // (lv_name_1_0= RULE_STRING ) ) ) ;
  public final EObject ruleActivity() throws RecognitionException {
    EObject current = null;

    Token lv_keyword_0_0 = null;
    Token lv_name_1_0 = null;

    enterRule();

    try {
      // InternalDsl.g:561:2: ( ( ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
      // InternalDsl.g:562:2: ( ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
      {
        // InternalDsl.g:562:2: ( ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
        // InternalDsl.g:563:3: ( (lv_keyword_0_0= 'activity' ) ) ( (lv_name_1_0= RULE_STRING ) )
        {
          // InternalDsl.g:563:3: ( (lv_keyword_0_0= 'activity' ) )
          // InternalDsl.g:564:4: (lv_keyword_0_0= 'activity' )
          {
            // InternalDsl.g:564:4: (lv_keyword_0_0= 'activity' )
            // InternalDsl.g:565:5: lv_keyword_0_0= 'activity'
            {
              lv_keyword_0_0 = (Token) match(input, 21, FOLLOW_6);

              newLeafNode(lv_keyword_0_0, grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getActivityRule());
              }
              setWithLastConsumed(current, "keyword", lv_keyword_0_0, "activity");

            }

          }

          // InternalDsl.g:577:3: ( (lv_name_1_0= RULE_STRING ) )
          // InternalDsl.g:578:4: (lv_name_1_0= RULE_STRING )
          {
            // InternalDsl.g:578:4: (lv_name_1_0= RULE_STRING )
            // InternalDsl.g:579:5: lv_name_1_0= RULE_STRING
            {
              lv_name_1_0 = (Token) match(input, RULE_STRING, FOLLOW_2);

              newLeafNode(lv_name_1_0, grammarAccess.getActivityAccess().getNameSTRINGTerminalRuleCall_1_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getActivityRule());
              }
              setWithLastConsumed(current, "name", lv_name_1_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

        }

      }

      leaveRule();

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleActivity"

  // $ANTLR start "entryRuleEntity"
  // InternalDsl.g:599:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
  public final EObject entryRuleEntity() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleEntity = null;

    try {
      // InternalDsl.g:599:47: (iv_ruleEntity= ruleEntity EOF )
      // InternalDsl.g:600:2: iv_ruleEntity= ruleEntity EOF
      {
        newCompositeNode(grammarAccess.getEntityRule());
        pushFollow(FOLLOW_1);
        iv_ruleEntity = ruleEntity();

        state._fsp--;

        current = iv_ruleEntity;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleEntity"

  // $ANTLR start "ruleEntity"
  // InternalDsl.g:606:1: ruleEntity returns [EObject current=null] : ( ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0=
  // RULE_STRING ) ) ) ;
  public final EObject ruleEntity() throws RecognitionException {
    EObject current = null;

    Token lv_keyword_0_0 = null;
    Token lv_name_1_0 = null;

    enterRule();

    try {
      // InternalDsl.g:612:2: ( ( ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
      // InternalDsl.g:613:2: ( ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
      {
        // InternalDsl.g:613:2: ( ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
        // InternalDsl.g:614:3: ( (lv_keyword_0_0= 'entity' ) ) ( (lv_name_1_0= RULE_STRING ) )
        {
          // InternalDsl.g:614:3: ( (lv_keyword_0_0= 'entity' ) )
          // InternalDsl.g:615:4: (lv_keyword_0_0= 'entity' )
          {
            // InternalDsl.g:615:4: (lv_keyword_0_0= 'entity' )
            // InternalDsl.g:616:5: lv_keyword_0_0= 'entity'
            {
              lv_keyword_0_0 = (Token) match(input, 22, FOLLOW_6);

              newLeafNode(lv_keyword_0_0, grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getEntityRule());
              }
              setWithLastConsumed(current, "keyword", lv_keyword_0_0, "entity");

            }

          }

          // InternalDsl.g:628:3: ( (lv_name_1_0= RULE_STRING ) )
          // InternalDsl.g:629:4: (lv_name_1_0= RULE_STRING )
          {
            // InternalDsl.g:629:4: (lv_name_1_0= RULE_STRING )
            // InternalDsl.g:630:5: lv_name_1_0= RULE_STRING
            {
              lv_name_1_0 = (Token) match(input, RULE_STRING, FOLLOW_2);

              newLeafNode(lv_name_1_0, grammarAccess.getEntityAccess().getNameSTRINGTerminalRuleCall_1_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getEntityRule());
              }
              setWithLastConsumed(current, "name", lv_name_1_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

        }

      }

      leaveRule();

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleEntity"

  // $ANTLR start "entryRuleRole"
  // InternalDsl.g:650:1: entryRuleRole returns [EObject current=null] : iv_ruleRole= ruleRole EOF ;
  public final EObject entryRuleRole() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleRole = null;

    try {
      // InternalDsl.g:650:45: (iv_ruleRole= ruleRole EOF )
      // InternalDsl.g:651:2: iv_ruleRole= ruleRole EOF
      {
        newCompositeNode(grammarAccess.getRoleRule());
        pushFollow(FOLLOW_1);
        iv_ruleRole = ruleRole();

        state._fsp--;

        current = iv_ruleRole;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleRole"

  // $ANTLR start "ruleRole"
  // InternalDsl.g:657:1: ruleRole returns [EObject current=null] : ( ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0=
  // RULE_STRING ) ) ) ;
  public final EObject ruleRole() throws RecognitionException {
    EObject current = null;

    Token lv_keyword_0_0 = null;
    Token lv_name_1_0 = null;

    enterRule();

    try {
      // InternalDsl.g:663:2: ( ( ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
      // InternalDsl.g:664:2: ( ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
      {
        // InternalDsl.g:664:2: ( ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
        // InternalDsl.g:665:3: ( (lv_keyword_0_0= 'role' ) ) ( (lv_name_1_0= RULE_STRING ) )
        {
          // InternalDsl.g:665:3: ( (lv_keyword_0_0= 'role' ) )
          // InternalDsl.g:666:4: (lv_keyword_0_0= 'role' )
          {
            // InternalDsl.g:666:4: (lv_keyword_0_0= 'role' )
            // InternalDsl.g:667:5: lv_keyword_0_0= 'role'
            {
              lv_keyword_0_0 = (Token) match(input, 23, FOLLOW_6);

              newLeafNode(lv_keyword_0_0, grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getRoleRule());
              }
              setWithLastConsumed(current, "keyword", lv_keyword_0_0, "role");

            }

          }

          // InternalDsl.g:679:3: ( (lv_name_1_0= RULE_STRING ) )
          // InternalDsl.g:680:4: (lv_name_1_0= RULE_STRING )
          {
            // InternalDsl.g:680:4: (lv_name_1_0= RULE_STRING )
            // InternalDsl.g:681:5: lv_name_1_0= RULE_STRING
            {
              lv_name_1_0 = (Token) match(input, RULE_STRING, FOLLOW_2);

              newLeafNode(lv_name_1_0, grammarAccess.getRoleAccess().getNameSTRINGTerminalRuleCall_1_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getRoleRule());
              }
              setWithLastConsumed(current, "name", lv_name_1_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

        }

      }

      leaveRule();

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleRole"

  // $ANTLR start "entryRuleMessage"
  // InternalDsl.g:701:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
  public final EObject entryRuleMessage() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleMessage = null;

    try {
      // InternalDsl.g:701:48: (iv_ruleMessage= ruleMessage EOF )
      // InternalDsl.g:702:2: iv_ruleMessage= ruleMessage EOF
      {
        newCompositeNode(grammarAccess.getMessageRule());
        pushFollow(FOLLOW_1);
        iv_ruleMessage = ruleMessage();

        state._fsp--;

        current = iv_ruleMessage;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleMessage"

  // $ANTLR start "ruleMessage"
  // InternalDsl.g:708:1: ruleMessage returns [EObject current=null] : (this_SequenceMessageType_0=
  // ruleSequenceMessageType | this_ArmTimerMessage_1= ruleArmTimerMessage | this_ParticipantDeactivation_2=
  // ruleParticipantDeactivation ) ;
  public final EObject ruleMessage() throws RecognitionException {
    EObject current = null;

    EObject this_SequenceMessageType_0 = null;

    EObject this_ArmTimerMessage_1 = null;

    EObject this_ParticipantDeactivation_2 = null;

    enterRule();

    try {
      // InternalDsl.g:714:2: ( (this_SequenceMessageType_0= ruleSequenceMessageType | this_ArmTimerMessage_1=
      // ruleArmTimerMessage | this_ParticipantDeactivation_2= ruleParticipantDeactivation ) )
      // InternalDsl.g:715:2: (this_SequenceMessageType_0= ruleSequenceMessageType | this_ArmTimerMessage_1=
      // ruleArmTimerMessage | this_ParticipantDeactivation_2= ruleParticipantDeactivation )
      {
        // InternalDsl.g:715:2: (this_SequenceMessageType_0= ruleSequenceMessageType | this_ArmTimerMessage_1=
        // ruleArmTimerMessage | this_ParticipantDeactivation_2= ruleParticipantDeactivation )
        int alt9 = 3;
        switch (input.LA(1)) {
        case RULE_STRING: {
          alt9 = 1;
        }
          break;
        case 29: {
          alt9 = 2;
        }
          break;
        case 30: {
          alt9 = 3;
        }
          break;
        default:
          NoViableAltException nvae = new NoViableAltException("", 9, 0, input);

          throw nvae;
        }

        switch (alt9) {
        case 1:
        // InternalDsl.g:716:3: this_SequenceMessageType_0= ruleSequenceMessageType
        {

          newCompositeNode(grammarAccess.getMessageAccess().getSequenceMessageTypeParserRuleCall_0());

          pushFollow(FOLLOW_2);
          this_SequenceMessageType_0 = ruleSequenceMessageType();

          state._fsp--;

          current = this_SequenceMessageType_0;
          afterParserOrEnumRuleCall();

        }
          break;
        case 2:
        // InternalDsl.g:725:3: this_ArmTimerMessage_1= ruleArmTimerMessage
        {

          newCompositeNode(grammarAccess.getMessageAccess().getArmTimerMessageParserRuleCall_1());

          pushFollow(FOLLOW_2);
          this_ArmTimerMessage_1 = ruleArmTimerMessage();

          state._fsp--;

          current = this_ArmTimerMessage_1;
          afterParserOrEnumRuleCall();

        }
          break;
        case 3:
        // InternalDsl.g:734:3: this_ParticipantDeactivation_2= ruleParticipantDeactivation
        {

          newCompositeNode(grammarAccess.getMessageAccess().getParticipantDeactivationParserRuleCall_2());

          pushFollow(FOLLOW_2);
          this_ParticipantDeactivation_2 = ruleParticipantDeactivation();

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
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleMessage"

  // $ANTLR start "entryRuleSequenceMessageType"
  // InternalDsl.g:746:1: entryRuleSequenceMessageType returns [EObject current=null] : iv_ruleSequenceMessageType=
  // ruleSequenceMessageType EOF ;
  public final EObject entryRuleSequenceMessageType() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleSequenceMessageType = null;

    try {
      // InternalDsl.g:746:60: (iv_ruleSequenceMessageType= ruleSequenceMessageType EOF )
      // InternalDsl.g:747:2: iv_ruleSequenceMessageType= ruleSequenceMessageType EOF
      {
        newCompositeNode(grammarAccess.getSequenceMessageTypeRule());
        pushFollow(FOLLOW_1);
        iv_ruleSequenceMessageType = ruleSequenceMessageType();

        state._fsp--;

        current = iv_ruleSequenceMessageType;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleSequenceMessageType"

  // $ANTLR start "ruleSequenceMessageType"
  // InternalDsl.g:753:1: ruleSequenceMessageType returns [EObject current=null] : ( (this_SequenceMessage_0=
  // ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage | this_DeleteMessage_2= ruleDeleteMessage ) (
  // (lv_return_3_0= ruleReturnMessage ) )? ) ;
  public final EObject ruleSequenceMessageType() throws RecognitionException {
    EObject current = null;

    EObject this_SequenceMessage_0 = null;

    EObject this_CreateMessage_1 = null;

    EObject this_DeleteMessage_2 = null;

    EObject lv_return_3_0 = null;

    enterRule();

    try {
      // InternalDsl.g:759:2: ( ( (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage
      // | this_DeleteMessage_2= ruleDeleteMessage ) ( (lv_return_3_0= ruleReturnMessage ) )? ) )
      // InternalDsl.g:760:2: ( (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage |
      // this_DeleteMessage_2= ruleDeleteMessage ) ( (lv_return_3_0= ruleReturnMessage ) )? )
      {
        // InternalDsl.g:760:2: ( (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage
        // | this_DeleteMessage_2= ruleDeleteMessage ) ( (lv_return_3_0= ruleReturnMessage ) )? )
        // InternalDsl.g:761:3: (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage |
        // this_DeleteMessage_2= ruleDeleteMessage ) ( (lv_return_3_0= ruleReturnMessage ) )?
        {
          // InternalDsl.g:761:3: (this_SequenceMessage_0= ruleSequenceMessage | this_CreateMessage_1= ruleCreateMessage
          // | this_DeleteMessage_2= ruleDeleteMessage )
          int alt10 = 3;
          int LA10_0 = input.LA(1);

          if ((LA10_0 == RULE_STRING)) {
            switch (input.LA(2)) {
            case 24: {
              alt10 = 1;
            }
              break;
            case 26: {
              alt10 = 2;
            }
              break;
            case 27: {
              alt10 = 3;
            }
              break;
            default:
              NoViableAltException nvae = new NoViableAltException("", 10, 1, input);

              throw nvae;
            }

          } else {
            NoViableAltException nvae = new NoViableAltException("", 10, 0, input);

            throw nvae;
          }
          switch (alt10) {
          case 1:
          // InternalDsl.g:762:4: this_SequenceMessage_0= ruleSequenceMessage
          {

            newCompositeNode(grammarAccess.getSequenceMessageTypeAccess().getSequenceMessageParserRuleCall_0_0());

            pushFollow(FOLLOW_8);
            this_SequenceMessage_0 = ruleSequenceMessage();

            state._fsp--;

            current = this_SequenceMessage_0;
            afterParserOrEnumRuleCall();

          }
            break;
          case 2:
          // InternalDsl.g:771:4: this_CreateMessage_1= ruleCreateMessage
          {

            newCompositeNode(grammarAccess.getSequenceMessageTypeAccess().getCreateMessageParserRuleCall_0_1());

            pushFollow(FOLLOW_8);
            this_CreateMessage_1 = ruleCreateMessage();

            state._fsp--;

            current = this_CreateMessage_1;
            afterParserOrEnumRuleCall();

          }
            break;
          case 3:
          // InternalDsl.g:780:4: this_DeleteMessage_2= ruleDeleteMessage
          {

            newCompositeNode(grammarAccess.getSequenceMessageTypeAccess().getDeleteMessageParserRuleCall_0_2());

            pushFollow(FOLLOW_8);
            this_DeleteMessage_2 = ruleDeleteMessage();

            state._fsp--;

            current = this_DeleteMessage_2;
            afterParserOrEnumRuleCall();

          }
            break;

          }

          // InternalDsl.g:789:3: ( (lv_return_3_0= ruleReturnMessage ) )?
          int alt11 = 2;
          int LA11_0 = input.LA(1);

          if ((LA11_0 == RULE_STRING)) {
            int LA11_1 = input.LA(2);

            if ((LA11_1 == 28)) {
              alt11 = 1;
            }
          }
          switch (alt11) {
          case 1:
          // InternalDsl.g:790:4: (lv_return_3_0= ruleReturnMessage )
          {
            // InternalDsl.g:790:4: (lv_return_3_0= ruleReturnMessage )
            // InternalDsl.g:791:5: lv_return_3_0= ruleReturnMessage
            {

              newCompositeNode(grammarAccess.getSequenceMessageTypeAccess().getReturnReturnMessageParserRuleCall_1_0());

              pushFollow(FOLLOW_2);
              lv_return_3_0 = ruleReturnMessage();

              state._fsp--;

              if (current == null) {
                current = createModelElementForParent(grammarAccess.getSequenceMessageTypeRule());
              }
              set(current, "return", lv_return_3_0,
                  "org.polarsys.capella.scenario.editor.dslscenario.Dsl.ReturnMessage");
              afterParserOrEnumRuleCall();

            }

          }
            break;

          }

        }

      }

      leaveRule();

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleSequenceMessageType"

  // $ANTLR start "entryRuleSequenceMessage"
  // InternalDsl.g:812:1: entryRuleSequenceMessage returns [EObject current=null] : iv_ruleSequenceMessage=
  // ruleSequenceMessage EOF ;
  public final EObject entryRuleSequenceMessage() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleSequenceMessage = null;

    try {
      // InternalDsl.g:812:56: (iv_ruleSequenceMessage= ruleSequenceMessage EOF )
      // InternalDsl.g:813:2: iv_ruleSequenceMessage= ruleSequenceMessage EOF
      {
        newCompositeNode(grammarAccess.getSequenceMessageRule());
        pushFollow(FOLLOW_1);
        iv_ruleSequenceMessage = ruleSequenceMessage();

        state._fsp--;

        current = iv_ruleSequenceMessage;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleSequenceMessage"

  // $ANTLR start "ruleSequenceMessage"
  // InternalDsl.g:819:1: ruleSequenceMessage returns [EObject current=null] : ( ( (lv_source_0_0= RULE_STRING ) )
  // otherlv_1= '->' ( (lv_target_2_0= RULE_STRING ) ) otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) ) ;
  public final EObject ruleSequenceMessage() throws RecognitionException {
    EObject current = null;

    Token lv_source_0_0 = null;
    Token otherlv_1 = null;
    Token lv_target_2_0 = null;
    Token otherlv_3 = null;
    Token lv_name_4_0 = null;

    enterRule();

    try {
      // InternalDsl.g:825:2: ( ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->' ( (lv_target_2_0= RULE_STRING ) )
      // otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) ) )
      // InternalDsl.g:826:2: ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->' ( (lv_target_2_0= RULE_STRING ) )
      // otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) )
      {
        // InternalDsl.g:826:2: ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->' ( (lv_target_2_0= RULE_STRING ) )
        // otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) )
        // InternalDsl.g:827:3: ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->' ( (lv_target_2_0= RULE_STRING ) )
        // otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) )
        {
          // InternalDsl.g:827:3: ( (lv_source_0_0= RULE_STRING ) )
          // InternalDsl.g:828:4: (lv_source_0_0= RULE_STRING )
          {
            // InternalDsl.g:828:4: (lv_source_0_0= RULE_STRING )
            // InternalDsl.g:829:5: lv_source_0_0= RULE_STRING
            {
              lv_source_0_0 = (Token) match(input, RULE_STRING, FOLLOW_9);

              newLeafNode(lv_source_0_0,
                  grammarAccess.getSequenceMessageAccess().getSourceSTRINGTerminalRuleCall_0_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getSequenceMessageRule());
              }
              setWithLastConsumed(current, "source", lv_source_0_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

          otherlv_1 = (Token) match(input, 24, FOLLOW_6);

          newLeafNode(otherlv_1, grammarAccess.getSequenceMessageAccess().getHyphenMinusGreaterThanSignKeyword_1());

          // InternalDsl.g:849:3: ( (lv_target_2_0= RULE_STRING ) )
          // InternalDsl.g:850:4: (lv_target_2_0= RULE_STRING )
          {
            // InternalDsl.g:850:4: (lv_target_2_0= RULE_STRING )
            // InternalDsl.g:851:5: lv_target_2_0= RULE_STRING
            {
              lv_target_2_0 = (Token) match(input, RULE_STRING, FOLLOW_10);

              newLeafNode(lv_target_2_0,
                  grammarAccess.getSequenceMessageAccess().getTargetSTRINGTerminalRuleCall_2_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getSequenceMessageRule());
              }
              setWithLastConsumed(current, "target", lv_target_2_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

          otherlv_3 = (Token) match(input, 25, FOLLOW_6);

          newLeafNode(otherlv_3, grammarAccess.getSequenceMessageAccess().getColonKeyword_3());

          // InternalDsl.g:871:3: ( (lv_name_4_0= RULE_STRING ) )
          // InternalDsl.g:872:4: (lv_name_4_0= RULE_STRING )
          {
            // InternalDsl.g:872:4: (lv_name_4_0= RULE_STRING )
            // InternalDsl.g:873:5: lv_name_4_0= RULE_STRING
            {
              lv_name_4_0 = (Token) match(input, RULE_STRING, FOLLOW_2);

              newLeafNode(lv_name_4_0, grammarAccess.getSequenceMessageAccess().getNameSTRINGTerminalRuleCall_4_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getSequenceMessageRule());
              }
              setWithLastConsumed(current, "name", lv_name_4_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

        }

      }

      leaveRule();

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleSequenceMessage"

  // $ANTLR start "entryRuleCreateMessage"
  // InternalDsl.g:893:1: entryRuleCreateMessage returns [EObject current=null] : iv_ruleCreateMessage=
  // ruleCreateMessage EOF ;
  public final EObject entryRuleCreateMessage() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleCreateMessage = null;

    try {
      // InternalDsl.g:893:54: (iv_ruleCreateMessage= ruleCreateMessage EOF )
      // InternalDsl.g:894:2: iv_ruleCreateMessage= ruleCreateMessage EOF
      {
        newCompositeNode(grammarAccess.getCreateMessageRule());
        pushFollow(FOLLOW_1);
        iv_ruleCreateMessage = ruleCreateMessage();

        state._fsp--;

        current = iv_ruleCreateMessage;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleCreateMessage"

  // $ANTLR start "ruleCreateMessage"
  // InternalDsl.g:900:1: ruleCreateMessage returns [EObject current=null] : ( ( (lv_source_0_0= RULE_STRING ) )
  // otherlv_1= '->+' ( (lv_target_2_0= RULE_STRING ) ) otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) ) ;
  public final EObject ruleCreateMessage() throws RecognitionException {
    EObject current = null;

    Token lv_source_0_0 = null;
    Token otherlv_1 = null;
    Token lv_target_2_0 = null;
    Token otherlv_3 = null;
    Token lv_name_4_0 = null;

    enterRule();

    try {
      // InternalDsl.g:906:2: ( ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->+' ( (lv_target_2_0= RULE_STRING ) )
      // otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) ) )
      // InternalDsl.g:907:2: ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->+' ( (lv_target_2_0= RULE_STRING ) )
      // otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) )
      {
        // InternalDsl.g:907:2: ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->+' ( (lv_target_2_0= RULE_STRING ) )
        // otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) )
        // InternalDsl.g:908:3: ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->+' ( (lv_target_2_0= RULE_STRING ) )
        // otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) )
        {
          // InternalDsl.g:908:3: ( (lv_source_0_0= RULE_STRING ) )
          // InternalDsl.g:909:4: (lv_source_0_0= RULE_STRING )
          {
            // InternalDsl.g:909:4: (lv_source_0_0= RULE_STRING )
            // InternalDsl.g:910:5: lv_source_0_0= RULE_STRING
            {
              lv_source_0_0 = (Token) match(input, RULE_STRING, FOLLOW_11);

              newLeafNode(lv_source_0_0, grammarAccess.getCreateMessageAccess().getSourceSTRINGTerminalRuleCall_0_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getCreateMessageRule());
              }
              setWithLastConsumed(current, "source", lv_source_0_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

          otherlv_1 = (Token) match(input, 26, FOLLOW_6);

          newLeafNode(otherlv_1,
              grammarAccess.getCreateMessageAccess().getHyphenMinusGreaterThanSignPlusSignKeyword_1());

          // InternalDsl.g:930:3: ( (lv_target_2_0= RULE_STRING ) )
          // InternalDsl.g:931:4: (lv_target_2_0= RULE_STRING )
          {
            // InternalDsl.g:931:4: (lv_target_2_0= RULE_STRING )
            // InternalDsl.g:932:5: lv_target_2_0= RULE_STRING
            {
              lv_target_2_0 = (Token) match(input, RULE_STRING, FOLLOW_10);

              newLeafNode(lv_target_2_0, grammarAccess.getCreateMessageAccess().getTargetSTRINGTerminalRuleCall_2_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getCreateMessageRule());
              }
              setWithLastConsumed(current, "target", lv_target_2_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

          otherlv_3 = (Token) match(input, 25, FOLLOW_6);

          newLeafNode(otherlv_3, grammarAccess.getCreateMessageAccess().getColonKeyword_3());

          // InternalDsl.g:952:3: ( (lv_name_4_0= RULE_STRING ) )
          // InternalDsl.g:953:4: (lv_name_4_0= RULE_STRING )
          {
            // InternalDsl.g:953:4: (lv_name_4_0= RULE_STRING )
            // InternalDsl.g:954:5: lv_name_4_0= RULE_STRING
            {
              lv_name_4_0 = (Token) match(input, RULE_STRING, FOLLOW_2);

              newLeafNode(lv_name_4_0, grammarAccess.getCreateMessageAccess().getNameSTRINGTerminalRuleCall_4_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getCreateMessageRule());
              }
              setWithLastConsumed(current, "name", lv_name_4_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

        }

      }

      leaveRule();

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleCreateMessage"

  // $ANTLR start "entryRuleDeleteMessage"
  // InternalDsl.g:974:1: entryRuleDeleteMessage returns [EObject current=null] : iv_ruleDeleteMessage=
  // ruleDeleteMessage EOF ;
  public final EObject entryRuleDeleteMessage() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleDeleteMessage = null;

    try {
      // InternalDsl.g:974:54: (iv_ruleDeleteMessage= ruleDeleteMessage EOF )
      // InternalDsl.g:975:2: iv_ruleDeleteMessage= ruleDeleteMessage EOF
      {
        newCompositeNode(grammarAccess.getDeleteMessageRule());
        pushFollow(FOLLOW_1);
        iv_ruleDeleteMessage = ruleDeleteMessage();

        state._fsp--;

        current = iv_ruleDeleteMessage;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleDeleteMessage"

  // $ANTLR start "ruleDeleteMessage"
  // InternalDsl.g:981:1: ruleDeleteMessage returns [EObject current=null] : ( ( (lv_source_0_0= RULE_STRING ) )
  // otherlv_1= '->x' ( (lv_target_2_0= RULE_STRING ) ) otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) ) ;
  public final EObject ruleDeleteMessage() throws RecognitionException {
    EObject current = null;

    Token lv_source_0_0 = null;
    Token otherlv_1 = null;
    Token lv_target_2_0 = null;
    Token otherlv_3 = null;
    Token lv_name_4_0 = null;

    enterRule();

    try {
      // InternalDsl.g:987:2: ( ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->x' ( (lv_target_2_0= RULE_STRING ) )
      // otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) ) )
      // InternalDsl.g:988:2: ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->x' ( (lv_target_2_0= RULE_STRING ) )
      // otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) )
      {
        // InternalDsl.g:988:2: ( ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->x' ( (lv_target_2_0= RULE_STRING ) )
        // otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) )
        // InternalDsl.g:989:3: ( (lv_source_0_0= RULE_STRING ) ) otherlv_1= '->x' ( (lv_target_2_0= RULE_STRING ) )
        // otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) )
        {
          // InternalDsl.g:989:3: ( (lv_source_0_0= RULE_STRING ) )
          // InternalDsl.g:990:4: (lv_source_0_0= RULE_STRING )
          {
            // InternalDsl.g:990:4: (lv_source_0_0= RULE_STRING )
            // InternalDsl.g:991:5: lv_source_0_0= RULE_STRING
            {
              lv_source_0_0 = (Token) match(input, RULE_STRING, FOLLOW_12);

              newLeafNode(lv_source_0_0, grammarAccess.getDeleteMessageAccess().getSourceSTRINGTerminalRuleCall_0_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getDeleteMessageRule());
              }
              setWithLastConsumed(current, "source", lv_source_0_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

          otherlv_1 = (Token) match(input, 27, FOLLOW_6);

          newLeafNode(otherlv_1, grammarAccess.getDeleteMessageAccess().getXKeyword_1());

          // InternalDsl.g:1011:3: ( (lv_target_2_0= RULE_STRING ) )
          // InternalDsl.g:1012:4: (lv_target_2_0= RULE_STRING )
          {
            // InternalDsl.g:1012:4: (lv_target_2_0= RULE_STRING )
            // InternalDsl.g:1013:5: lv_target_2_0= RULE_STRING
            {
              lv_target_2_0 = (Token) match(input, RULE_STRING, FOLLOW_10);

              newLeafNode(lv_target_2_0, grammarAccess.getDeleteMessageAccess().getTargetSTRINGTerminalRuleCall_2_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getDeleteMessageRule());
              }
              setWithLastConsumed(current, "target", lv_target_2_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

          otherlv_3 = (Token) match(input, 25, FOLLOW_6);

          newLeafNode(otherlv_3, grammarAccess.getDeleteMessageAccess().getColonKeyword_3());

          // InternalDsl.g:1033:3: ( (lv_name_4_0= RULE_STRING ) )
          // InternalDsl.g:1034:4: (lv_name_4_0= RULE_STRING )
          {
            // InternalDsl.g:1034:4: (lv_name_4_0= RULE_STRING )
            // InternalDsl.g:1035:5: lv_name_4_0= RULE_STRING
            {
              lv_name_4_0 = (Token) match(input, RULE_STRING, FOLLOW_2);

              newLeafNode(lv_name_4_0, grammarAccess.getDeleteMessageAccess().getNameSTRINGTerminalRuleCall_4_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getDeleteMessageRule());
              }
              setWithLastConsumed(current, "name", lv_name_4_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

        }

      }

      leaveRule();

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleDeleteMessage"

  // $ANTLR start "entryRuleReturnMessage"
  // InternalDsl.g:1055:1: entryRuleReturnMessage returns [EObject current=null] : iv_ruleReturnMessage=
  // ruleReturnMessage EOF ;
  public final EObject entryRuleReturnMessage() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleReturnMessage = null;

    try {
      // InternalDsl.g:1055:54: (iv_ruleReturnMessage= ruleReturnMessage EOF )
      // InternalDsl.g:1056:2: iv_ruleReturnMessage= ruleReturnMessage EOF
      {
        newCompositeNode(grammarAccess.getReturnMessageRule());
        pushFollow(FOLLOW_1);
        iv_ruleReturnMessage = ruleReturnMessage();

        state._fsp--;

        current = iv_ruleReturnMessage;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleReturnMessage"

  // $ANTLR start "ruleReturnMessage"
  // InternalDsl.g:1062:1: ruleReturnMessage returns [EObject current=null] : ( ( (lv_target_0_0= RULE_STRING ) )
  // otherlv_1= '<--' ( (lv_source_2_0= RULE_STRING ) ) otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) ) ;
  public final EObject ruleReturnMessage() throws RecognitionException {
    EObject current = null;

    Token lv_target_0_0 = null;
    Token otherlv_1 = null;
    Token lv_source_2_0 = null;
    Token otherlv_3 = null;
    Token lv_name_4_0 = null;

    enterRule();

    try {
      // InternalDsl.g:1068:2: ( ( ( (lv_target_0_0= RULE_STRING ) ) otherlv_1= '<--' ( (lv_source_2_0= RULE_STRING ) )
      // otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) ) )
      // InternalDsl.g:1069:2: ( ( (lv_target_0_0= RULE_STRING ) ) otherlv_1= '<--' ( (lv_source_2_0= RULE_STRING ) )
      // otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) )
      {
        // InternalDsl.g:1069:2: ( ( (lv_target_0_0= RULE_STRING ) ) otherlv_1= '<--' ( (lv_source_2_0= RULE_STRING ) )
        // otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) ) )
        // InternalDsl.g:1070:3: ( (lv_target_0_0= RULE_STRING ) ) otherlv_1= '<--' ( (lv_source_2_0= RULE_STRING ) )
        // otherlv_3= ':' ( (lv_name_4_0= RULE_STRING ) )
        {
          // InternalDsl.g:1070:3: ( (lv_target_0_0= RULE_STRING ) )
          // InternalDsl.g:1071:4: (lv_target_0_0= RULE_STRING )
          {
            // InternalDsl.g:1071:4: (lv_target_0_0= RULE_STRING )
            // InternalDsl.g:1072:5: lv_target_0_0= RULE_STRING
            {
              lv_target_0_0 = (Token) match(input, RULE_STRING, FOLLOW_13);

              newLeafNode(lv_target_0_0, grammarAccess.getReturnMessageAccess().getTargetSTRINGTerminalRuleCall_0_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getReturnMessageRule());
              }
              setWithLastConsumed(current, "target", lv_target_0_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

          otherlv_1 = (Token) match(input, 28, FOLLOW_6);

          newLeafNode(otherlv_1,
              grammarAccess.getReturnMessageAccess().getLessThanSignHyphenMinusHyphenMinusKeyword_1());

          // InternalDsl.g:1092:3: ( (lv_source_2_0= RULE_STRING ) )
          // InternalDsl.g:1093:4: (lv_source_2_0= RULE_STRING )
          {
            // InternalDsl.g:1093:4: (lv_source_2_0= RULE_STRING )
            // InternalDsl.g:1094:5: lv_source_2_0= RULE_STRING
            {
              lv_source_2_0 = (Token) match(input, RULE_STRING, FOLLOW_10);

              newLeafNode(lv_source_2_0, grammarAccess.getReturnMessageAccess().getSourceSTRINGTerminalRuleCall_2_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getReturnMessageRule());
              }
              setWithLastConsumed(current, "source", lv_source_2_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

          otherlv_3 = (Token) match(input, 25, FOLLOW_6);

          newLeafNode(otherlv_3, grammarAccess.getReturnMessageAccess().getColonKeyword_3());

          // InternalDsl.g:1114:3: ( (lv_name_4_0= RULE_STRING ) )
          // InternalDsl.g:1115:4: (lv_name_4_0= RULE_STRING )
          {
            // InternalDsl.g:1115:4: (lv_name_4_0= RULE_STRING )
            // InternalDsl.g:1116:5: lv_name_4_0= RULE_STRING
            {
              lv_name_4_0 = (Token) match(input, RULE_STRING, FOLLOW_2);

              newLeafNode(lv_name_4_0, grammarAccess.getReturnMessageAccess().getNameSTRINGTerminalRuleCall_4_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getReturnMessageRule());
              }
              setWithLastConsumed(current, "name", lv_name_4_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

        }

      }

      leaveRule();

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleReturnMessage"

  // $ANTLR start "entryRuleArmTimerMessage"
  // InternalDsl.g:1136:1: entryRuleArmTimerMessage returns [EObject current=null] : iv_ruleArmTimerMessage=
  // ruleArmTimerMessage EOF ;
  public final EObject entryRuleArmTimerMessage() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleArmTimerMessage = null;

    try {
      // InternalDsl.g:1136:56: (iv_ruleArmTimerMessage= ruleArmTimerMessage EOF )
      // InternalDsl.g:1137:2: iv_ruleArmTimerMessage= ruleArmTimerMessage EOF
      {
        newCompositeNode(grammarAccess.getArmTimerMessageRule());
        pushFollow(FOLLOW_1);
        iv_ruleArmTimerMessage = ruleArmTimerMessage();

        state._fsp--;

        current = iv_ruleArmTimerMessage;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleArmTimerMessage"

  // $ANTLR start "ruleArmTimerMessage"
  // InternalDsl.g:1143:1: ruleArmTimerMessage returns [EObject current=null] : (otherlv_0= '->>' ( (lv_participant_1_0=
  // RULE_STRING ) ) otherlv_2= ':' ( (lv_name_3_0= RULE_STRING ) ) ) ;
  public final EObject ruleArmTimerMessage() throws RecognitionException {
    EObject current = null;

    Token otherlv_0 = null;
    Token lv_participant_1_0 = null;
    Token otherlv_2 = null;
    Token lv_name_3_0 = null;

    enterRule();

    try {
      // InternalDsl.g:1149:2: ( (otherlv_0= '->>' ( (lv_participant_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_name_3_0=
      // RULE_STRING ) ) ) )
      // InternalDsl.g:1150:2: (otherlv_0= '->>' ( (lv_participant_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_name_3_0=
      // RULE_STRING ) ) )
      {
        // InternalDsl.g:1150:2: (otherlv_0= '->>' ( (lv_participant_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_name_3_0=
        // RULE_STRING ) ) )
        // InternalDsl.g:1151:3: otherlv_0= '->>' ( (lv_participant_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_name_3_0=
        // RULE_STRING ) )
        {
          otherlv_0 = (Token) match(input, 29, FOLLOW_6);

          newLeafNode(otherlv_0,
              grammarAccess.getArmTimerMessageAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_0());

          // InternalDsl.g:1155:3: ( (lv_participant_1_0= RULE_STRING ) )
          // InternalDsl.g:1156:4: (lv_participant_1_0= RULE_STRING )
          {
            // InternalDsl.g:1156:4: (lv_participant_1_0= RULE_STRING )
            // InternalDsl.g:1157:5: lv_participant_1_0= RULE_STRING
            {
              lv_participant_1_0 = (Token) match(input, RULE_STRING, FOLLOW_10);

              newLeafNode(lv_participant_1_0,
                  grammarAccess.getArmTimerMessageAccess().getParticipantSTRINGTerminalRuleCall_1_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getArmTimerMessageRule());
              }
              setWithLastConsumed(current, "participant", lv_participant_1_0,
                  "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

          otherlv_2 = (Token) match(input, 25, FOLLOW_6);

          newLeafNode(otherlv_2, grammarAccess.getArmTimerMessageAccess().getColonKeyword_2());

          // InternalDsl.g:1177:3: ( (lv_name_3_0= RULE_STRING ) )
          // InternalDsl.g:1178:4: (lv_name_3_0= RULE_STRING )
          {
            // InternalDsl.g:1178:4: (lv_name_3_0= RULE_STRING )
            // InternalDsl.g:1179:5: lv_name_3_0= RULE_STRING
            {
              lv_name_3_0 = (Token) match(input, RULE_STRING, FOLLOW_2);

              newLeafNode(lv_name_3_0, grammarAccess.getArmTimerMessageAccess().getNameSTRINGTerminalRuleCall_3_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getArmTimerMessageRule());
              }
              setWithLastConsumed(current, "name", lv_name_3_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

        }

      }

      leaveRule();

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleArmTimerMessage"

  // $ANTLR start "entryRuleParticipantDeactivation"
  // InternalDsl.g:1199:1: entryRuleParticipantDeactivation returns [EObject current=null] :
  // iv_ruleParticipantDeactivation= ruleParticipantDeactivation EOF ;
  public final EObject entryRuleParticipantDeactivation() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleParticipantDeactivation = null;

    try {
      // InternalDsl.g:1199:64: (iv_ruleParticipantDeactivation= ruleParticipantDeactivation EOF )
      // InternalDsl.g:1200:2: iv_ruleParticipantDeactivation= ruleParticipantDeactivation EOF
      {
        newCompositeNode(grammarAccess.getParticipantDeactivationRule());
        pushFollow(FOLLOW_1);
        iv_ruleParticipantDeactivation = ruleParticipantDeactivation();

        state._fsp--;

        current = iv_ruleParticipantDeactivation;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleParticipantDeactivation"

  // $ANTLR start "ruleParticipantDeactivation"
  // InternalDsl.g:1206:1: ruleParticipantDeactivation returns [EObject current=null] : ( ( (lv_keyword_0_0=
  // 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) ;
  public final EObject ruleParticipantDeactivation() throws RecognitionException {
    EObject current = null;

    Token lv_keyword_0_0 = null;
    Token lv_name_1_0 = null;

    enterRule();

    try {
      // InternalDsl.g:1212:2: ( ( ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) ) ) )
      // InternalDsl.g:1213:2: ( ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
      {
        // InternalDsl.g:1213:2: ( ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) ) )
        // InternalDsl.g:1214:3: ( (lv_keyword_0_0= 'deactivate' ) ) ( (lv_name_1_0= RULE_STRING ) )
        {
          // InternalDsl.g:1214:3: ( (lv_keyword_0_0= 'deactivate' ) )
          // InternalDsl.g:1215:4: (lv_keyword_0_0= 'deactivate' )
          {
            // InternalDsl.g:1215:4: (lv_keyword_0_0= 'deactivate' )
            // InternalDsl.g:1216:5: lv_keyword_0_0= 'deactivate'
            {
              lv_keyword_0_0 = (Token) match(input, 30, FOLLOW_6);

              newLeafNode(lv_keyword_0_0,
                  grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getParticipantDeactivationRule());
              }
              setWithLastConsumed(current, "keyword", lv_keyword_0_0, "deactivate");

            }

          }

          // InternalDsl.g:1228:3: ( (lv_name_1_0= RULE_STRING ) )
          // InternalDsl.g:1229:4: (lv_name_1_0= RULE_STRING )
          {
            // InternalDsl.g:1229:4: (lv_name_1_0= RULE_STRING )
            // InternalDsl.g:1230:5: lv_name_1_0= RULE_STRING
            {
              lv_name_1_0 = (Token) match(input, RULE_STRING, FOLLOW_2);

              newLeafNode(lv_name_1_0,
                  grammarAccess.getParticipantDeactivationAccess().getNameSTRINGTerminalRuleCall_1_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getParticipantDeactivationRule());
              }
              setWithLastConsumed(current, "name", lv_name_1_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

        }

      }

      leaveRule();

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleParticipantDeactivation"

  // $ANTLR start "entryRuleReference"
  // InternalDsl.g:1250:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
  public final EObject entryRuleReference() throws RecognitionException {
    EObject current = null;

    EObject iv_ruleReference = null;

    try {
      // InternalDsl.g:1250:50: (iv_ruleReference= ruleReference EOF )
      // InternalDsl.g:1251:2: iv_ruleReference= ruleReference EOF
      {
        newCompositeNode(grammarAccess.getReferenceRule());
        pushFollow(FOLLOW_1);
        iv_ruleReference = ruleReference();

        state._fsp--;

        current = iv_ruleReference;
        match(input, EOF, FOLLOW_2);

      }

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "entryRuleReference"

  // $ANTLR start "ruleReference"
  // InternalDsl.g:1257:1: ruleReference returns [EObject current=null] : ( ( (lv_keyword_0_0= 'ref' ) ) otherlv_1=
  // 'over' ( (lv_timelines_2_0= RULE_STRING ) )+ ( (lv_name_3_0= RULE_STRING ) ) ) ;
  public final EObject ruleReference() throws RecognitionException {
    EObject current = null;

    Token lv_keyword_0_0 = null;
    Token otherlv_1 = null;
    Token lv_timelines_2_0 = null;
    Token lv_name_3_0 = null;

    enterRule();

    try {
      // InternalDsl.g:1263:2: ( ( ( (lv_keyword_0_0= 'ref' ) ) otherlv_1= 'over' ( (lv_timelines_2_0= RULE_STRING ) )+
      // ( (lv_name_3_0= RULE_STRING ) ) ) )
      // InternalDsl.g:1264:2: ( ( (lv_keyword_0_0= 'ref' ) ) otherlv_1= 'over' ( (lv_timelines_2_0= RULE_STRING ) )+ (
      // (lv_name_3_0= RULE_STRING ) ) )
      {
        // InternalDsl.g:1264:2: ( ( (lv_keyword_0_0= 'ref' ) ) otherlv_1= 'over' ( (lv_timelines_2_0= RULE_STRING ) )+
        // ( (lv_name_3_0= RULE_STRING ) ) )
        // InternalDsl.g:1265:3: ( (lv_keyword_0_0= 'ref' ) ) otherlv_1= 'over' ( (lv_timelines_2_0= RULE_STRING ) )+ (
        // (lv_name_3_0= RULE_STRING ) )
        {
          // InternalDsl.g:1265:3: ( (lv_keyword_0_0= 'ref' ) )
          // InternalDsl.g:1266:4: (lv_keyword_0_0= 'ref' )
          {
            // InternalDsl.g:1266:4: (lv_keyword_0_0= 'ref' )
            // InternalDsl.g:1267:5: lv_keyword_0_0= 'ref'
            {
              lv_keyword_0_0 = (Token) match(input, 31, FOLLOW_14);

              newLeafNode(lv_keyword_0_0, grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getReferenceRule());
              }
              setWithLastConsumed(current, "keyword", lv_keyword_0_0, "ref");

            }

          }

          otherlv_1 = (Token) match(input, 32, FOLLOW_6);

          newLeafNode(otherlv_1, grammarAccess.getReferenceAccess().getOverKeyword_1());

          // InternalDsl.g:1283:3: ( (lv_timelines_2_0= RULE_STRING ) )+
          int cnt12 = 0;
          loop12: do {
            int alt12 = 2;
            int LA12_0 = input.LA(1);

            if ((LA12_0 == RULE_STRING)) {
              int LA12_1 = input.LA(2);

              if ((LA12_1 == RULE_STRING)) {
                int LA12_2 = input.LA(3);

                if ((LA12_2 == EOF || LA12_2 == RULE_STRING || LA12_2 == 13 || (LA12_2 >= 29 && LA12_2 <= 31))) {
                  alt12 = 1;
                }

              }

            }

            switch (alt12) {
            case 1:
            // InternalDsl.g:1284:4: (lv_timelines_2_0= RULE_STRING )
            {
              // InternalDsl.g:1284:4: (lv_timelines_2_0= RULE_STRING )
              // InternalDsl.g:1285:5: lv_timelines_2_0= RULE_STRING
              {
                lv_timelines_2_0 = (Token) match(input, RULE_STRING, FOLLOW_6);

                newLeafNode(lv_timelines_2_0,
                    grammarAccess.getReferenceAccess().getTimelinesSTRINGTerminalRuleCall_2_0());

                if (current == null) {
                  current = createModelElement(grammarAccess.getReferenceRule());
                }
                addWithLastConsumed(current, "timelines", lv_timelines_2_0,
                    "org.eclipse.xtext.common.Terminals.STRING");

              }

            }
              break;

            default:
              if (cnt12 >= 1)
                break loop12;
              EarlyExitException eee = new EarlyExitException(12, input);
              throw eee;
            }
            cnt12++;
          } while (true);

          // InternalDsl.g:1301:3: ( (lv_name_3_0= RULE_STRING ) )
          // InternalDsl.g:1302:4: (lv_name_3_0= RULE_STRING )
          {
            // InternalDsl.g:1302:4: (lv_name_3_0= RULE_STRING )
            // InternalDsl.g:1303:5: lv_name_3_0= RULE_STRING
            {
              lv_name_3_0 = (Token) match(input, RULE_STRING, FOLLOW_2);

              newLeafNode(lv_name_3_0, grammarAccess.getReferenceAccess().getNameSTRINGTerminalRuleCall_3_0());

              if (current == null) {
                current = createModelElement(grammarAccess.getReferenceRule());
              }
              setWithLastConsumed(current, "name", lv_name_3_0, "org.eclipse.xtext.common.Terminals.STRING");

            }

          }

        }

      }

      leaveRule();

    }

    catch (RecognitionException re) {
      recover(input, re);
      appendSkippedTokens();
    } finally {
    }
    return current;
  }
  // $ANTLR end "ruleReference"

  // Delegated rules

  public static final BitSet FOLLOW_1 = new BitSet(new long[] { 0x0000000000000000L });
  public static final BitSet FOLLOW_2 = new BitSet(new long[] { 0x0000000000000002L });
  public static final BitSet FOLLOW_3 = new BitSet(new long[] { 0x0000000000001000L });
  public static final BitSet FOLLOW_4 = new BitSet(new long[] { 0x00000000E0F8E010L });
  public static final BitSet FOLLOW_5 = new BitSet(new long[] { 0x00000000E0002010L });
  public static final BitSet FOLLOW_6 = new BitSet(new long[] { 0x0000000000000010L });
  public static final BitSet FOLLOW_7 = new BitSet(new long[] { 0x0000000000070002L });
  public static final BitSet FOLLOW_8 = new BitSet(new long[] { 0x0000000000000012L });
  public static final BitSet FOLLOW_9 = new BitSet(new long[] { 0x0000000001000000L });
  public static final BitSet FOLLOW_10 = new BitSet(new long[] { 0x0000000002000000L });
  public static final BitSet FOLLOW_11 = new BitSet(new long[] { 0x0000000004000000L });
  public static final BitSet FOLLOW_12 = new BitSet(new long[] { 0x0000000008000000L });
  public static final BitSet FOLLOW_13 = new BitSet(new long[] { 0x0000000010000000L });
  public static final BitSet FOLLOW_14 = new BitSet(new long[] { 0x0000000100000000L });

}