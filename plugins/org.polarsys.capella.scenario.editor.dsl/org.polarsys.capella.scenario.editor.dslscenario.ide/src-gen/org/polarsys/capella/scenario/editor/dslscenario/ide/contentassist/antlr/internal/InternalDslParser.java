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
package org.polarsys.capella.scenario.editor.dslscenario.ide.contentassist.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.polarsys.capella.scenario.editor.dslscenario.services.DslGrammarAccess;

@SuppressWarnings("all")
public class InternalDslParser extends AbstractInternalContentAssistParser {
  public static final String[] tokenNames = new String[] { "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING",
      "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'unset'", "'behavior'",
      "'node'", "'scenario'", "'->'", "':'", "'->+'", "'->x'", "'<--'", "'->>'", "'over'", "'{'", "'}'", "'actor'",
      "'component'", "'configuration_item'", "'function'", "'activity'", "'entity'", "'role'", "'deactivate'",
      "'ref'" };
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

  public void setGrammarAccess(DslGrammarAccess grammarAccess) {
    this.grammarAccess = grammarAccess;
  }

  @Override
  protected Grammar getGrammar() {
    return grammarAccess.getGrammar();
  }

  @Override
  protected String getValueForTokenName(String tokenName) {
    return tokenName;
  }

  // $ANTLR start "entryRuleModel"
  // InternalDsl.g:53:1: entryRuleModel : ruleModel EOF ;
  public final void entryRuleModel() throws RecognitionException {
    try {
      // InternalDsl.g:54:1: ( ruleModel EOF )
      // InternalDsl.g:55:1: ruleModel EOF
      {
        before(grammarAccess.getModelRule());
        pushFollow(FOLLOW_1);
        ruleModel();

        state._fsp--;

        after(grammarAccess.getModelRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleModel"

  // $ANTLR start "ruleModel"
  // InternalDsl.g:62:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
  public final void ruleModel() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:66:2: ( ( ( rule__Model__Group__0 ) ) )
      // InternalDsl.g:67:2: ( ( rule__Model__Group__0 ) )
      {
        // InternalDsl.g:67:2: ( ( rule__Model__Group__0 ) )
        // InternalDsl.g:68:3: ( rule__Model__Group__0 )
        {
          before(grammarAccess.getModelAccess().getGroup());
          // InternalDsl.g:69:3: ( rule__Model__Group__0 )
          // InternalDsl.g:69:4: rule__Model__Group__0
          {
            pushFollow(FOLLOW_2);
            rule__Model__Group__0();

            state._fsp--;

          }

          after(grammarAccess.getModelAccess().getGroup());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleModel"

  // $ANTLR start "entryRuleParticipant"
  // InternalDsl.g:78:1: entryRuleParticipant : ruleParticipant EOF ;
  public final void entryRuleParticipant() throws RecognitionException {
    try {
      // InternalDsl.g:79:1: ( ruleParticipant EOF )
      // InternalDsl.g:80:1: ruleParticipant EOF
      {
        before(grammarAccess.getParticipantRule());
        pushFollow(FOLLOW_1);
        ruleParticipant();

        state._fsp--;

        after(grammarAccess.getParticipantRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleParticipant"

  // $ANTLR start "ruleParticipant"
  // InternalDsl.g:87:1: ruleParticipant : ( ( rule__Participant__Alternatives ) ) ;
  public final void ruleParticipant() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:91:2: ( ( ( rule__Participant__Alternatives ) ) )
      // InternalDsl.g:92:2: ( ( rule__Participant__Alternatives ) )
      {
        // InternalDsl.g:92:2: ( ( rule__Participant__Alternatives ) )
        // InternalDsl.g:93:3: ( rule__Participant__Alternatives )
        {
          before(grammarAccess.getParticipantAccess().getAlternatives());
          // InternalDsl.g:94:3: ( rule__Participant__Alternatives )
          // InternalDsl.g:94:4: rule__Participant__Alternatives
          {
            pushFollow(FOLLOW_2);
            rule__Participant__Alternatives();

            state._fsp--;

          }

          after(grammarAccess.getParticipantAccess().getAlternatives());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleParticipant"

  // $ANTLR start "entryRuleGenericComponent"
  // InternalDsl.g:103:1: entryRuleGenericComponent : ruleGenericComponent EOF ;
  public final void entryRuleGenericComponent() throws RecognitionException {
    try {
      // InternalDsl.g:104:1: ( ruleGenericComponent EOF )
      // InternalDsl.g:105:1: ruleGenericComponent EOF
      {
        before(grammarAccess.getGenericComponentRule());
        pushFollow(FOLLOW_1);
        ruleGenericComponent();

        state._fsp--;

        after(grammarAccess.getGenericComponentRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleGenericComponent"

  // $ANTLR start "ruleGenericComponent"
  // InternalDsl.g:112:1: ruleGenericComponent : ( ( rule__GenericComponent__Alternatives ) ) ;
  public final void ruleGenericComponent() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:116:2: ( ( ( rule__GenericComponent__Alternatives ) ) )
      // InternalDsl.g:117:2: ( ( rule__GenericComponent__Alternatives ) )
      {
        // InternalDsl.g:117:2: ( ( rule__GenericComponent__Alternatives ) )
        // InternalDsl.g:118:3: ( rule__GenericComponent__Alternatives )
        {
          before(grammarAccess.getGenericComponentAccess().getAlternatives());
          // InternalDsl.g:119:3: ( rule__GenericComponent__Alternatives )
          // InternalDsl.g:119:4: rule__GenericComponent__Alternatives
          {
            pushFollow(FOLLOW_2);
            rule__GenericComponent__Alternatives();

            state._fsp--;

          }

          after(grammarAccess.getGenericComponentAccess().getAlternatives());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleGenericComponent"

  // $ANTLR start "entryRuleGenericFunction"
  // InternalDsl.g:128:1: entryRuleGenericFunction : ruleGenericFunction EOF ;
  public final void entryRuleGenericFunction() throws RecognitionException {
    try {
      // InternalDsl.g:129:1: ( ruleGenericFunction EOF )
      // InternalDsl.g:130:1: ruleGenericFunction EOF
      {
        before(grammarAccess.getGenericFunctionRule());
        pushFollow(FOLLOW_1);
        ruleGenericFunction();

        state._fsp--;

        after(grammarAccess.getGenericFunctionRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleGenericFunction"

  // $ANTLR start "ruleGenericFunction"
  // InternalDsl.g:137:1: ruleGenericFunction : ( ( rule__GenericFunction__Alternatives ) ) ;
  public final void ruleGenericFunction() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:141:2: ( ( ( rule__GenericFunction__Alternatives ) ) )
      // InternalDsl.g:142:2: ( ( rule__GenericFunction__Alternatives ) )
      {
        // InternalDsl.g:142:2: ( ( rule__GenericFunction__Alternatives ) )
        // InternalDsl.g:143:3: ( rule__GenericFunction__Alternatives )
        {
          before(grammarAccess.getGenericFunctionAccess().getAlternatives());
          // InternalDsl.g:144:3: ( rule__GenericFunction__Alternatives )
          // InternalDsl.g:144:4: rule__GenericFunction__Alternatives
          {
            pushFollow(FOLLOW_2);
            rule__GenericFunction__Alternatives();

            state._fsp--;

          }

          after(grammarAccess.getGenericFunctionAccess().getAlternatives());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleGenericFunction"

  // $ANTLR start "entryRuleActor"
  // InternalDsl.g:153:1: entryRuleActor : ruleActor EOF ;
  public final void entryRuleActor() throws RecognitionException {
    try {
      // InternalDsl.g:154:1: ( ruleActor EOF )
      // InternalDsl.g:155:1: ruleActor EOF
      {
        before(grammarAccess.getActorRule());
        pushFollow(FOLLOW_1);
        ruleActor();

        state._fsp--;

        after(grammarAccess.getActorRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleActor"

  // $ANTLR start "ruleActor"
  // InternalDsl.g:162:1: ruleActor : ( ( rule__Actor__Group__0 ) ) ;
  public final void ruleActor() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:166:2: ( ( ( rule__Actor__Group__0 ) ) )
      // InternalDsl.g:167:2: ( ( rule__Actor__Group__0 ) )
      {
        // InternalDsl.g:167:2: ( ( rule__Actor__Group__0 ) )
        // InternalDsl.g:168:3: ( rule__Actor__Group__0 )
        {
          before(grammarAccess.getActorAccess().getGroup());
          // InternalDsl.g:169:3: ( rule__Actor__Group__0 )
          // InternalDsl.g:169:4: rule__Actor__Group__0
          {
            pushFollow(FOLLOW_2);
            rule__Actor__Group__0();

            state._fsp--;

          }

          after(grammarAccess.getActorAccess().getGroup());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleActor"

  // $ANTLR start "entryRuleComponent"
  // InternalDsl.g:178:1: entryRuleComponent : ruleComponent EOF ;
  public final void entryRuleComponent() throws RecognitionException {
    try {
      // InternalDsl.g:179:1: ( ruleComponent EOF )
      // InternalDsl.g:180:1: ruleComponent EOF
      {
        before(grammarAccess.getComponentRule());
        pushFollow(FOLLOW_1);
        ruleComponent();

        state._fsp--;

        after(grammarAccess.getComponentRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleComponent"

  // $ANTLR start "ruleComponent"
  // InternalDsl.g:187:1: ruleComponent : ( ( rule__Component__Group__0 ) ) ;
  public final void ruleComponent() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:191:2: ( ( ( rule__Component__Group__0 ) ) )
      // InternalDsl.g:192:2: ( ( rule__Component__Group__0 ) )
      {
        // InternalDsl.g:192:2: ( ( rule__Component__Group__0 ) )
        // InternalDsl.g:193:3: ( rule__Component__Group__0 )
        {
          before(grammarAccess.getComponentAccess().getGroup());
          // InternalDsl.g:194:3: ( rule__Component__Group__0 )
          // InternalDsl.g:194:4: rule__Component__Group__0
          {
            pushFollow(FOLLOW_2);
            rule__Component__Group__0();

            state._fsp--;

          }

          after(grammarAccess.getComponentAccess().getGroup());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleComponent"

  // $ANTLR start "entryRuleConfigurationItem"
  // InternalDsl.g:203:1: entryRuleConfigurationItem : ruleConfigurationItem EOF ;
  public final void entryRuleConfigurationItem() throws RecognitionException {
    try {
      // InternalDsl.g:204:1: ( ruleConfigurationItem EOF )
      // InternalDsl.g:205:1: ruleConfigurationItem EOF
      {
        before(grammarAccess.getConfigurationItemRule());
        pushFollow(FOLLOW_1);
        ruleConfigurationItem();

        state._fsp--;

        after(grammarAccess.getConfigurationItemRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleConfigurationItem"

  // $ANTLR start "ruleConfigurationItem"
  // InternalDsl.g:212:1: ruleConfigurationItem : ( ( rule__ConfigurationItem__Group__0 ) ) ;
  public final void ruleConfigurationItem() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:216:2: ( ( ( rule__ConfigurationItem__Group__0 ) ) )
      // InternalDsl.g:217:2: ( ( rule__ConfigurationItem__Group__0 ) )
      {
        // InternalDsl.g:217:2: ( ( rule__ConfigurationItem__Group__0 ) )
        // InternalDsl.g:218:3: ( rule__ConfigurationItem__Group__0 )
        {
          before(grammarAccess.getConfigurationItemAccess().getGroup());
          // InternalDsl.g:219:3: ( rule__ConfigurationItem__Group__0 )
          // InternalDsl.g:219:4: rule__ConfigurationItem__Group__0
          {
            pushFollow(FOLLOW_2);
            rule__ConfigurationItem__Group__0();

            state._fsp--;

          }

          after(grammarAccess.getConfigurationItemAccess().getGroup());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleConfigurationItem"

  // $ANTLR start "entryRuleFunction"
  // InternalDsl.g:228:1: entryRuleFunction : ruleFunction EOF ;
  public final void entryRuleFunction() throws RecognitionException {
    try {
      // InternalDsl.g:229:1: ( ruleFunction EOF )
      // InternalDsl.g:230:1: ruleFunction EOF
      {
        before(grammarAccess.getFunctionRule());
        pushFollow(FOLLOW_1);
        ruleFunction();

        state._fsp--;

        after(grammarAccess.getFunctionRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleFunction"

  // $ANTLR start "ruleFunction"
  // InternalDsl.g:237:1: ruleFunction : ( ( rule__Function__Group__0 ) ) ;
  public final void ruleFunction() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:241:2: ( ( ( rule__Function__Group__0 ) ) )
      // InternalDsl.g:242:2: ( ( rule__Function__Group__0 ) )
      {
        // InternalDsl.g:242:2: ( ( rule__Function__Group__0 ) )
        // InternalDsl.g:243:3: ( rule__Function__Group__0 )
        {
          before(grammarAccess.getFunctionAccess().getGroup());
          // InternalDsl.g:244:3: ( rule__Function__Group__0 )
          // InternalDsl.g:244:4: rule__Function__Group__0
          {
            pushFollow(FOLLOW_2);
            rule__Function__Group__0();

            state._fsp--;

          }

          after(grammarAccess.getFunctionAccess().getGroup());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleFunction"

  // $ANTLR start "entryRuleActivity"
  // InternalDsl.g:253:1: entryRuleActivity : ruleActivity EOF ;
  public final void entryRuleActivity() throws RecognitionException {
    try {
      // InternalDsl.g:254:1: ( ruleActivity EOF )
      // InternalDsl.g:255:1: ruleActivity EOF
      {
        before(grammarAccess.getActivityRule());
        pushFollow(FOLLOW_1);
        ruleActivity();

        state._fsp--;

        after(grammarAccess.getActivityRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleActivity"

  // $ANTLR start "ruleActivity"
  // InternalDsl.g:262:1: ruleActivity : ( ( rule__Activity__Group__0 ) ) ;
  public final void ruleActivity() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:266:2: ( ( ( rule__Activity__Group__0 ) ) )
      // InternalDsl.g:267:2: ( ( rule__Activity__Group__0 ) )
      {
        // InternalDsl.g:267:2: ( ( rule__Activity__Group__0 ) )
        // InternalDsl.g:268:3: ( rule__Activity__Group__0 )
        {
          before(grammarAccess.getActivityAccess().getGroup());
          // InternalDsl.g:269:3: ( rule__Activity__Group__0 )
          // InternalDsl.g:269:4: rule__Activity__Group__0
          {
            pushFollow(FOLLOW_2);
            rule__Activity__Group__0();

            state._fsp--;

          }

          after(grammarAccess.getActivityAccess().getGroup());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleActivity"

  // $ANTLR start "entryRuleEntity"
  // InternalDsl.g:278:1: entryRuleEntity : ruleEntity EOF ;
  public final void entryRuleEntity() throws RecognitionException {
    try {
      // InternalDsl.g:279:1: ( ruleEntity EOF )
      // InternalDsl.g:280:1: ruleEntity EOF
      {
        before(grammarAccess.getEntityRule());
        pushFollow(FOLLOW_1);
        ruleEntity();

        state._fsp--;

        after(grammarAccess.getEntityRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleEntity"

  // $ANTLR start "ruleEntity"
  // InternalDsl.g:287:1: ruleEntity : ( ( rule__Entity__Group__0 ) ) ;
  public final void ruleEntity() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:291:2: ( ( ( rule__Entity__Group__0 ) ) )
      // InternalDsl.g:292:2: ( ( rule__Entity__Group__0 ) )
      {
        // InternalDsl.g:292:2: ( ( rule__Entity__Group__0 ) )
        // InternalDsl.g:293:3: ( rule__Entity__Group__0 )
        {
          before(grammarAccess.getEntityAccess().getGroup());
          // InternalDsl.g:294:3: ( rule__Entity__Group__0 )
          // InternalDsl.g:294:4: rule__Entity__Group__0
          {
            pushFollow(FOLLOW_2);
            rule__Entity__Group__0();

            state._fsp--;

          }

          after(grammarAccess.getEntityAccess().getGroup());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleEntity"

  // $ANTLR start "entryRuleRole"
  // InternalDsl.g:303:1: entryRuleRole : ruleRole EOF ;
  public final void entryRuleRole() throws RecognitionException {
    try {
      // InternalDsl.g:304:1: ( ruleRole EOF )
      // InternalDsl.g:305:1: ruleRole EOF
      {
        before(grammarAccess.getRoleRule());
        pushFollow(FOLLOW_1);
        ruleRole();

        state._fsp--;

        after(grammarAccess.getRoleRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleRole"

  // $ANTLR start "ruleRole"
  // InternalDsl.g:312:1: ruleRole : ( ( rule__Role__Group__0 ) ) ;
  public final void ruleRole() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:316:2: ( ( ( rule__Role__Group__0 ) ) )
      // InternalDsl.g:317:2: ( ( rule__Role__Group__0 ) )
      {
        // InternalDsl.g:317:2: ( ( rule__Role__Group__0 ) )
        // InternalDsl.g:318:3: ( rule__Role__Group__0 )
        {
          before(grammarAccess.getRoleAccess().getGroup());
          // InternalDsl.g:319:3: ( rule__Role__Group__0 )
          // InternalDsl.g:319:4: rule__Role__Group__0
          {
            pushFollow(FOLLOW_2);
            rule__Role__Group__0();

            state._fsp--;

          }

          after(grammarAccess.getRoleAccess().getGroup());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleRole"

  // $ANTLR start "entryRuleMessage"
  // InternalDsl.g:328:1: entryRuleMessage : ruleMessage EOF ;
  public final void entryRuleMessage() throws RecognitionException {
    try {
      // InternalDsl.g:329:1: ( ruleMessage EOF )
      // InternalDsl.g:330:1: ruleMessage EOF
      {
        before(grammarAccess.getMessageRule());
        pushFollow(FOLLOW_1);
        ruleMessage();

        state._fsp--;

        after(grammarAccess.getMessageRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleMessage"

  // $ANTLR start "ruleMessage"
  // InternalDsl.g:337:1: ruleMessage : ( ( rule__Message__Alternatives ) ) ;
  public final void ruleMessage() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:341:2: ( ( ( rule__Message__Alternatives ) ) )
      // InternalDsl.g:342:2: ( ( rule__Message__Alternatives ) )
      {
        // InternalDsl.g:342:2: ( ( rule__Message__Alternatives ) )
        // InternalDsl.g:343:3: ( rule__Message__Alternatives )
        {
          before(grammarAccess.getMessageAccess().getAlternatives());
          // InternalDsl.g:344:3: ( rule__Message__Alternatives )
          // InternalDsl.g:344:4: rule__Message__Alternatives
          {
            pushFollow(FOLLOW_2);
            rule__Message__Alternatives();

            state._fsp--;

          }

          after(grammarAccess.getMessageAccess().getAlternatives());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleMessage"

  // $ANTLR start "entryRuleSequenceMessageType"
  // InternalDsl.g:353:1: entryRuleSequenceMessageType : ruleSequenceMessageType EOF ;
  public final void entryRuleSequenceMessageType() throws RecognitionException {
    try {
      // InternalDsl.g:354:1: ( ruleSequenceMessageType EOF )
      // InternalDsl.g:355:1: ruleSequenceMessageType EOF
      {
        before(grammarAccess.getSequenceMessageTypeRule());
        pushFollow(FOLLOW_1);
        ruleSequenceMessageType();

        state._fsp--;

        after(grammarAccess.getSequenceMessageTypeRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleSequenceMessageType"

  // $ANTLR start "ruleSequenceMessageType"
  // InternalDsl.g:362:1: ruleSequenceMessageType : ( ( rule__SequenceMessageType__Group__0 ) ) ;
  public final void ruleSequenceMessageType() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:366:2: ( ( ( rule__SequenceMessageType__Group__0 ) ) )
      // InternalDsl.g:367:2: ( ( rule__SequenceMessageType__Group__0 ) )
      {
        // InternalDsl.g:367:2: ( ( rule__SequenceMessageType__Group__0 ) )
        // InternalDsl.g:368:3: ( rule__SequenceMessageType__Group__0 )
        {
          before(grammarAccess.getSequenceMessageTypeAccess().getGroup());
          // InternalDsl.g:369:3: ( rule__SequenceMessageType__Group__0 )
          // InternalDsl.g:369:4: rule__SequenceMessageType__Group__0
          {
            pushFollow(FOLLOW_2);
            rule__SequenceMessageType__Group__0();

            state._fsp--;

          }

          after(grammarAccess.getSequenceMessageTypeAccess().getGroup());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleSequenceMessageType"

  // $ANTLR start "entryRuleSequenceMessage"
  // InternalDsl.g:378:1: entryRuleSequenceMessage : ruleSequenceMessage EOF ;
  public final void entryRuleSequenceMessage() throws RecognitionException {
    try {
      // InternalDsl.g:379:1: ( ruleSequenceMessage EOF )
      // InternalDsl.g:380:1: ruleSequenceMessage EOF
      {
        before(grammarAccess.getSequenceMessageRule());
        pushFollow(FOLLOW_1);
        ruleSequenceMessage();

        state._fsp--;

        after(grammarAccess.getSequenceMessageRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleSequenceMessage"

  // $ANTLR start "ruleSequenceMessage"
  // InternalDsl.g:387:1: ruleSequenceMessage : ( ( rule__SequenceMessage__Group__0 ) ) ;
  public final void ruleSequenceMessage() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:391:2: ( ( ( rule__SequenceMessage__Group__0 ) ) )
      // InternalDsl.g:392:2: ( ( rule__SequenceMessage__Group__0 ) )
      {
        // InternalDsl.g:392:2: ( ( rule__SequenceMessage__Group__0 ) )
        // InternalDsl.g:393:3: ( rule__SequenceMessage__Group__0 )
        {
          before(grammarAccess.getSequenceMessageAccess().getGroup());
          // InternalDsl.g:394:3: ( rule__SequenceMessage__Group__0 )
          // InternalDsl.g:394:4: rule__SequenceMessage__Group__0
          {
            pushFollow(FOLLOW_2);
            rule__SequenceMessage__Group__0();

            state._fsp--;

          }

          after(grammarAccess.getSequenceMessageAccess().getGroup());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleSequenceMessage"

  // $ANTLR start "entryRuleCreateMessage"
  // InternalDsl.g:403:1: entryRuleCreateMessage : ruleCreateMessage EOF ;
  public final void entryRuleCreateMessage() throws RecognitionException {
    try {
      // InternalDsl.g:404:1: ( ruleCreateMessage EOF )
      // InternalDsl.g:405:1: ruleCreateMessage EOF
      {
        before(grammarAccess.getCreateMessageRule());
        pushFollow(FOLLOW_1);
        ruleCreateMessage();

        state._fsp--;

        after(grammarAccess.getCreateMessageRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleCreateMessage"

  // $ANTLR start "ruleCreateMessage"
  // InternalDsl.g:412:1: ruleCreateMessage : ( ( rule__CreateMessage__Group__0 ) ) ;
  public final void ruleCreateMessage() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:416:2: ( ( ( rule__CreateMessage__Group__0 ) ) )
      // InternalDsl.g:417:2: ( ( rule__CreateMessage__Group__0 ) )
      {
        // InternalDsl.g:417:2: ( ( rule__CreateMessage__Group__0 ) )
        // InternalDsl.g:418:3: ( rule__CreateMessage__Group__0 )
        {
          before(grammarAccess.getCreateMessageAccess().getGroup());
          // InternalDsl.g:419:3: ( rule__CreateMessage__Group__0 )
          // InternalDsl.g:419:4: rule__CreateMessage__Group__0
          {
            pushFollow(FOLLOW_2);
            rule__CreateMessage__Group__0();

            state._fsp--;

          }

          after(grammarAccess.getCreateMessageAccess().getGroup());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleCreateMessage"

  // $ANTLR start "entryRuleDeleteMessage"
  // InternalDsl.g:428:1: entryRuleDeleteMessage : ruleDeleteMessage EOF ;
  public final void entryRuleDeleteMessage() throws RecognitionException {
    try {
      // InternalDsl.g:429:1: ( ruleDeleteMessage EOF )
      // InternalDsl.g:430:1: ruleDeleteMessage EOF
      {
        before(grammarAccess.getDeleteMessageRule());
        pushFollow(FOLLOW_1);
        ruleDeleteMessage();

        state._fsp--;

        after(grammarAccess.getDeleteMessageRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleDeleteMessage"

  // $ANTLR start "ruleDeleteMessage"
  // InternalDsl.g:437:1: ruleDeleteMessage : ( ( rule__DeleteMessage__Group__0 ) ) ;
  public final void ruleDeleteMessage() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:441:2: ( ( ( rule__DeleteMessage__Group__0 ) ) )
      // InternalDsl.g:442:2: ( ( rule__DeleteMessage__Group__0 ) )
      {
        // InternalDsl.g:442:2: ( ( rule__DeleteMessage__Group__0 ) )
        // InternalDsl.g:443:3: ( rule__DeleteMessage__Group__0 )
        {
          before(grammarAccess.getDeleteMessageAccess().getGroup());
          // InternalDsl.g:444:3: ( rule__DeleteMessage__Group__0 )
          // InternalDsl.g:444:4: rule__DeleteMessage__Group__0
          {
            pushFollow(FOLLOW_2);
            rule__DeleteMessage__Group__0();

            state._fsp--;

          }

          after(grammarAccess.getDeleteMessageAccess().getGroup());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleDeleteMessage"

  // $ANTLR start "entryRuleReturnMessage"
  // InternalDsl.g:453:1: entryRuleReturnMessage : ruleReturnMessage EOF ;
  public final void entryRuleReturnMessage() throws RecognitionException {
    try {
      // InternalDsl.g:454:1: ( ruleReturnMessage EOF )
      // InternalDsl.g:455:1: ruleReturnMessage EOF
      {
        before(grammarAccess.getReturnMessageRule());
        pushFollow(FOLLOW_1);
        ruleReturnMessage();

        state._fsp--;

        after(grammarAccess.getReturnMessageRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleReturnMessage"

  // $ANTLR start "ruleReturnMessage"
  // InternalDsl.g:462:1: ruleReturnMessage : ( ( rule__ReturnMessage__Group__0 ) ) ;
  public final void ruleReturnMessage() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:466:2: ( ( ( rule__ReturnMessage__Group__0 ) ) )
      // InternalDsl.g:467:2: ( ( rule__ReturnMessage__Group__0 ) )
      {
        // InternalDsl.g:467:2: ( ( rule__ReturnMessage__Group__0 ) )
        // InternalDsl.g:468:3: ( rule__ReturnMessage__Group__0 )
        {
          before(grammarAccess.getReturnMessageAccess().getGroup());
          // InternalDsl.g:469:3: ( rule__ReturnMessage__Group__0 )
          // InternalDsl.g:469:4: rule__ReturnMessage__Group__0
          {
            pushFollow(FOLLOW_2);
            rule__ReturnMessage__Group__0();

            state._fsp--;

          }

          after(grammarAccess.getReturnMessageAccess().getGroup());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleReturnMessage"

  // $ANTLR start "entryRuleArmTimerMessage"
  // InternalDsl.g:478:1: entryRuleArmTimerMessage : ruleArmTimerMessage EOF ;
  public final void entryRuleArmTimerMessage() throws RecognitionException {
    try {
      // InternalDsl.g:479:1: ( ruleArmTimerMessage EOF )
      // InternalDsl.g:480:1: ruleArmTimerMessage EOF
      {
        before(grammarAccess.getArmTimerMessageRule());
        pushFollow(FOLLOW_1);
        ruleArmTimerMessage();

        state._fsp--;

        after(grammarAccess.getArmTimerMessageRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleArmTimerMessage"

  // $ANTLR start "ruleArmTimerMessage"
  // InternalDsl.g:487:1: ruleArmTimerMessage : ( ( rule__ArmTimerMessage__Group__0 ) ) ;
  public final void ruleArmTimerMessage() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:491:2: ( ( ( rule__ArmTimerMessage__Group__0 ) ) )
      // InternalDsl.g:492:2: ( ( rule__ArmTimerMessage__Group__0 ) )
      {
        // InternalDsl.g:492:2: ( ( rule__ArmTimerMessage__Group__0 ) )
        // InternalDsl.g:493:3: ( rule__ArmTimerMessage__Group__0 )
        {
          before(grammarAccess.getArmTimerMessageAccess().getGroup());
          // InternalDsl.g:494:3: ( rule__ArmTimerMessage__Group__0 )
          // InternalDsl.g:494:4: rule__ArmTimerMessage__Group__0
          {
            pushFollow(FOLLOW_2);
            rule__ArmTimerMessage__Group__0();

            state._fsp--;

          }

          after(grammarAccess.getArmTimerMessageAccess().getGroup());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleArmTimerMessage"

  // $ANTLR start "entryRuleParticipantDeactivation"
  // InternalDsl.g:503:1: entryRuleParticipantDeactivation : ruleParticipantDeactivation EOF ;
  public final void entryRuleParticipantDeactivation() throws RecognitionException {
    try {
      // InternalDsl.g:504:1: ( ruleParticipantDeactivation EOF )
      // InternalDsl.g:505:1: ruleParticipantDeactivation EOF
      {
        before(grammarAccess.getParticipantDeactivationRule());
        pushFollow(FOLLOW_1);
        ruleParticipantDeactivation();

        state._fsp--;

        after(grammarAccess.getParticipantDeactivationRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleParticipantDeactivation"

  // $ANTLR start "ruleParticipantDeactivation"
  // InternalDsl.g:512:1: ruleParticipantDeactivation : ( ( rule__ParticipantDeactivation__Group__0 ) ) ;
  public final void ruleParticipantDeactivation() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:516:2: ( ( ( rule__ParticipantDeactivation__Group__0 ) ) )
      // InternalDsl.g:517:2: ( ( rule__ParticipantDeactivation__Group__0 ) )
      {
        // InternalDsl.g:517:2: ( ( rule__ParticipantDeactivation__Group__0 ) )
        // InternalDsl.g:518:3: ( rule__ParticipantDeactivation__Group__0 )
        {
          before(grammarAccess.getParticipantDeactivationAccess().getGroup());
          // InternalDsl.g:519:3: ( rule__ParticipantDeactivation__Group__0 )
          // InternalDsl.g:519:4: rule__ParticipantDeactivation__Group__0
          {
            pushFollow(FOLLOW_2);
            rule__ParticipantDeactivation__Group__0();

            state._fsp--;

          }

          after(grammarAccess.getParticipantDeactivationAccess().getGroup());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleParticipantDeactivation"

  // $ANTLR start "entryRuleReference"
  // InternalDsl.g:528:1: entryRuleReference : ruleReference EOF ;
  public final void entryRuleReference() throws RecognitionException {
    try {
      // InternalDsl.g:529:1: ( ruleReference EOF )
      // InternalDsl.g:530:1: ruleReference EOF
      {
        before(grammarAccess.getReferenceRule());
        pushFollow(FOLLOW_1);
        ruleReference();

        state._fsp--;

        after(grammarAccess.getReferenceRule());
        match(input, EOF, FOLLOW_2);

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
    }
    return;
  }
  // $ANTLR end "entryRuleReference"

  // $ANTLR start "ruleReference"
  // InternalDsl.g:537:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
  public final void ruleReference() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:541:2: ( ( ( rule__Reference__Group__0 ) ) )
      // InternalDsl.g:542:2: ( ( rule__Reference__Group__0 ) )
      {
        // InternalDsl.g:542:2: ( ( rule__Reference__Group__0 ) )
        // InternalDsl.g:543:3: ( rule__Reference__Group__0 )
        {
          before(grammarAccess.getReferenceAccess().getGroup());
          // InternalDsl.g:544:3: ( rule__Reference__Group__0 )
          // InternalDsl.g:544:4: rule__Reference__Group__0
          {
            pushFollow(FOLLOW_2);
            rule__Reference__Group__0();

            state._fsp--;

          }

          after(grammarAccess.getReferenceAccess().getGroup());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "ruleReference"

  // $ANTLR start "rule__Model__MessagesOrReferencesAlternatives_3_0"
  // InternalDsl.g:552:1: rule__Model__MessagesOrReferencesAlternatives_3_0 : ( ( ruleMessage ) | ( ruleReference ) );
  public final void rule__Model__MessagesOrReferencesAlternatives_3_0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:556:1: ( ( ruleMessage ) | ( ruleReference ) )
      int alt1 = 2;
      int LA1_0 = input.LA(1);

      if ((LA1_0 == RULE_STRING || LA1_0 == 20 || LA1_0 == 31)) {
        alt1 = 1;
      } else if ((LA1_0 == 32)) {
        alt1 = 2;
      } else {
        NoViableAltException nvae = new NoViableAltException("", 1, 0, input);

        throw nvae;
      }
      switch (alt1) {
      case 1:
      // InternalDsl.g:557:2: ( ruleMessage )
      {
        // InternalDsl.g:557:2: ( ruleMessage )
        // InternalDsl.g:558:3: ruleMessage
        {
          before(grammarAccess.getModelAccess().getMessagesOrReferencesMessageParserRuleCall_3_0_0());
          pushFollow(FOLLOW_2);
          ruleMessage();

          state._fsp--;

          after(grammarAccess.getModelAccess().getMessagesOrReferencesMessageParserRuleCall_3_0_0());

        }

      }
        break;
      case 2:
      // InternalDsl.g:563:2: ( ruleReference )
      {
        // InternalDsl.g:563:2: ( ruleReference )
        // InternalDsl.g:564:3: ruleReference
        {
          before(grammarAccess.getModelAccess().getMessagesOrReferencesReferenceParserRuleCall_3_0_1());
          pushFollow(FOLLOW_2);
          ruleReference();

          state._fsp--;

          after(grammarAccess.getModelAccess().getMessagesOrReferencesReferenceParserRuleCall_3_0_1());

        }

      }
        break;

      }
    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Model__MessagesOrReferencesAlternatives_3_0"

  // $ANTLR start "rule__Participant__Alternatives"
  // InternalDsl.g:573:1: rule__Participant__Alternatives : ( ( ruleGenericComponent ) | ( ruleGenericFunction ) );
  public final void rule__Participant__Alternatives() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:577:1: ( ( ruleGenericComponent ) | ( ruleGenericFunction ) )
      int alt2 = 2;
      int LA2_0 = input.LA(1);

      if (((LA2_0 >= 24 && LA2_0 <= 26) || (LA2_0 >= 29 && LA2_0 <= 30))) {
        alt2 = 1;
      } else if (((LA2_0 >= 27 && LA2_0 <= 28))) {
        alt2 = 2;
      } else {
        NoViableAltException nvae = new NoViableAltException("", 2, 0, input);

        throw nvae;
      }
      switch (alt2) {
      case 1:
      // InternalDsl.g:578:2: ( ruleGenericComponent )
      {
        // InternalDsl.g:578:2: ( ruleGenericComponent )
        // InternalDsl.g:579:3: ruleGenericComponent
        {
          before(grammarAccess.getParticipantAccess().getGenericComponentParserRuleCall_0());
          pushFollow(FOLLOW_2);
          ruleGenericComponent();

          state._fsp--;

          after(grammarAccess.getParticipantAccess().getGenericComponentParserRuleCall_0());

        }

      }
        break;
      case 2:
      // InternalDsl.g:584:2: ( ruleGenericFunction )
      {
        // InternalDsl.g:584:2: ( ruleGenericFunction )
        // InternalDsl.g:585:3: ruleGenericFunction
        {
          before(grammarAccess.getParticipantAccess().getGenericFunctionParserRuleCall_1());
          pushFollow(FOLLOW_2);
          ruleGenericFunction();

          state._fsp--;

          after(grammarAccess.getParticipantAccess().getGenericFunctionParserRuleCall_1());

        }

      }
        break;

      }
    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Participant__Alternatives"

  // $ANTLR start "rule__GenericComponent__Alternatives"
  // InternalDsl.g:594:1: rule__GenericComponent__Alternatives : ( ( ruleEntity ) | ( ruleActor ) | ( ruleComponent ) |
  // ( ruleConfigurationItem ) | ( ruleRole ) );
  public final void rule__GenericComponent__Alternatives() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:598:1: ( ( ruleEntity ) | ( ruleActor ) | ( ruleComponent ) | ( ruleConfigurationItem ) | (
      // ruleRole ) )
      int alt3 = 5;
      switch (input.LA(1)) {
      case 29: {
        alt3 = 1;
      }
        break;
      case 24: {
        alt3 = 2;
      }
        break;
      case 25: {
        alt3 = 3;
      }
        break;
      case 26: {
        alt3 = 4;
      }
        break;
      case 30: {
        alt3 = 5;
      }
        break;
      default:
        NoViableAltException nvae = new NoViableAltException("", 3, 0, input);

        throw nvae;
      }

      switch (alt3) {
      case 1:
      // InternalDsl.g:599:2: ( ruleEntity )
      {
        // InternalDsl.g:599:2: ( ruleEntity )
        // InternalDsl.g:600:3: ruleEntity
        {
          before(grammarAccess.getGenericComponentAccess().getEntityParserRuleCall_0());
          pushFollow(FOLLOW_2);
          ruleEntity();

          state._fsp--;

          after(grammarAccess.getGenericComponentAccess().getEntityParserRuleCall_0());

        }

      }
        break;
      case 2:
      // InternalDsl.g:605:2: ( ruleActor )
      {
        // InternalDsl.g:605:2: ( ruleActor )
        // InternalDsl.g:606:3: ruleActor
        {
          before(grammarAccess.getGenericComponentAccess().getActorParserRuleCall_1());
          pushFollow(FOLLOW_2);
          ruleActor();

          state._fsp--;

          after(grammarAccess.getGenericComponentAccess().getActorParserRuleCall_1());

        }

      }
        break;
      case 3:
      // InternalDsl.g:611:2: ( ruleComponent )
      {
        // InternalDsl.g:611:2: ( ruleComponent )
        // InternalDsl.g:612:3: ruleComponent
        {
          before(grammarAccess.getGenericComponentAccess().getComponentParserRuleCall_2());
          pushFollow(FOLLOW_2);
          ruleComponent();

          state._fsp--;

          after(grammarAccess.getGenericComponentAccess().getComponentParserRuleCall_2());

        }

      }
        break;
      case 4:
      // InternalDsl.g:617:2: ( ruleConfigurationItem )
      {
        // InternalDsl.g:617:2: ( ruleConfigurationItem )
        // InternalDsl.g:618:3: ruleConfigurationItem
        {
          before(grammarAccess.getGenericComponentAccess().getConfigurationItemParserRuleCall_3());
          pushFollow(FOLLOW_2);
          ruleConfigurationItem();

          state._fsp--;

          after(grammarAccess.getGenericComponentAccess().getConfigurationItemParserRuleCall_3());

        }

      }
        break;
      case 5:
      // InternalDsl.g:623:2: ( ruleRole )
      {
        // InternalDsl.g:623:2: ( ruleRole )
        // InternalDsl.g:624:3: ruleRole
        {
          before(grammarAccess.getGenericComponentAccess().getRoleParserRuleCall_4());
          pushFollow(FOLLOW_2);
          ruleRole();

          state._fsp--;

          after(grammarAccess.getGenericComponentAccess().getRoleParserRuleCall_4());

        }

      }
        break;

      }
    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__GenericComponent__Alternatives"

  // $ANTLR start "rule__GenericFunction__Alternatives"
  // InternalDsl.g:633:1: rule__GenericFunction__Alternatives : ( ( ruleFunction ) | ( ruleActivity ) );
  public final void rule__GenericFunction__Alternatives() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:637:1: ( ( ruleFunction ) | ( ruleActivity ) )
      int alt4 = 2;
      int LA4_0 = input.LA(1);

      if ((LA4_0 == 27)) {
        alt4 = 1;
      } else if ((LA4_0 == 28)) {
        alt4 = 2;
      } else {
        NoViableAltException nvae = new NoViableAltException("", 4, 0, input);

        throw nvae;
      }
      switch (alt4) {
      case 1:
      // InternalDsl.g:638:2: ( ruleFunction )
      {
        // InternalDsl.g:638:2: ( ruleFunction )
        // InternalDsl.g:639:3: ruleFunction
        {
          before(grammarAccess.getGenericFunctionAccess().getFunctionParserRuleCall_0());
          pushFollow(FOLLOW_2);
          ruleFunction();

          state._fsp--;

          after(grammarAccess.getGenericFunctionAccess().getFunctionParserRuleCall_0());

        }

      }
        break;
      case 2:
      // InternalDsl.g:644:2: ( ruleActivity )
      {
        // InternalDsl.g:644:2: ( ruleActivity )
        // InternalDsl.g:645:3: ruleActivity
        {
          before(grammarAccess.getGenericFunctionAccess().getActivityParserRuleCall_1());
          pushFollow(FOLLOW_2);
          ruleActivity();

          state._fsp--;

          after(grammarAccess.getGenericFunctionAccess().getActivityParserRuleCall_1());

        }

      }
        break;

      }
    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__GenericFunction__Alternatives"

  // $ANTLR start "rule__Component__NatureAlternatives_2_0"
  // InternalDsl.g:654:1: rule__Component__NatureAlternatives_2_0 : ( ( 'unset' ) | ( 'behavior' ) | ( 'node' ) );
  public final void rule__Component__NatureAlternatives_2_0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:658:1: ( ( 'unset' ) | ( 'behavior' ) | ( 'node' ) )
      int alt5 = 3;
      switch (input.LA(1)) {
      case 11: {
        alt5 = 1;
      }
        break;
      case 12: {
        alt5 = 2;
      }
        break;
      case 13: {
        alt5 = 3;
      }
        break;
      default:
        NoViableAltException nvae = new NoViableAltException("", 5, 0, input);

        throw nvae;
      }

      switch (alt5) {
      case 1:
      // InternalDsl.g:659:2: ( 'unset' )
      {
        // InternalDsl.g:659:2: ( 'unset' )
        // InternalDsl.g:660:3: 'unset'
        {
          before(grammarAccess.getComponentAccess().getNatureUnsetKeyword_2_0_0());
          match(input, 11, FOLLOW_2);
          after(grammarAccess.getComponentAccess().getNatureUnsetKeyword_2_0_0());

        }

      }
        break;
      case 2:
      // InternalDsl.g:665:2: ( 'behavior' )
      {
        // InternalDsl.g:665:2: ( 'behavior' )
        // InternalDsl.g:666:3: 'behavior'
        {
          before(grammarAccess.getComponentAccess().getNatureBehaviorKeyword_2_0_1());
          match(input, 12, FOLLOW_2);
          after(grammarAccess.getComponentAccess().getNatureBehaviorKeyword_2_0_1());

        }

      }
        break;
      case 3:
      // InternalDsl.g:671:2: ( 'node' )
      {
        // InternalDsl.g:671:2: ( 'node' )
        // InternalDsl.g:672:3: 'node'
        {
          before(grammarAccess.getComponentAccess().getNatureNodeKeyword_2_0_2());
          match(input, 13, FOLLOW_2);
          after(grammarAccess.getComponentAccess().getNatureNodeKeyword_2_0_2());

        }

      }
        break;

      }
    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Component__NatureAlternatives_2_0"

  // $ANTLR start "rule__Message__Alternatives"
  // InternalDsl.g:681:1: rule__Message__Alternatives : ( ( ruleSequenceMessageType ) | ( ruleArmTimerMessage ) | (
  // ruleParticipantDeactivation ) );
  public final void rule__Message__Alternatives() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:685:1: ( ( ruleSequenceMessageType ) | ( ruleArmTimerMessage ) | ( ruleParticipantDeactivation )
      // )
      int alt6 = 3;
      switch (input.LA(1)) {
      case RULE_STRING: {
        alt6 = 1;
      }
        break;
      case 20: {
        alt6 = 2;
      }
        break;
      case 31: {
        alt6 = 3;
      }
        break;
      default:
        NoViableAltException nvae = new NoViableAltException("", 6, 0, input);

        throw nvae;
      }

      switch (alt6) {
      case 1:
      // InternalDsl.g:686:2: ( ruleSequenceMessageType )
      {
        // InternalDsl.g:686:2: ( ruleSequenceMessageType )
        // InternalDsl.g:687:3: ruleSequenceMessageType
        {
          before(grammarAccess.getMessageAccess().getSequenceMessageTypeParserRuleCall_0());
          pushFollow(FOLLOW_2);
          ruleSequenceMessageType();

          state._fsp--;

          after(grammarAccess.getMessageAccess().getSequenceMessageTypeParserRuleCall_0());

        }

      }
        break;
      case 2:
      // InternalDsl.g:692:2: ( ruleArmTimerMessage )
      {
        // InternalDsl.g:692:2: ( ruleArmTimerMessage )
        // InternalDsl.g:693:3: ruleArmTimerMessage
        {
          before(grammarAccess.getMessageAccess().getArmTimerMessageParserRuleCall_1());
          pushFollow(FOLLOW_2);
          ruleArmTimerMessage();

          state._fsp--;

          after(grammarAccess.getMessageAccess().getArmTimerMessageParserRuleCall_1());

        }

      }
        break;
      case 3:
      // InternalDsl.g:698:2: ( ruleParticipantDeactivation )
      {
        // InternalDsl.g:698:2: ( ruleParticipantDeactivation )
        // InternalDsl.g:699:3: ruleParticipantDeactivation
        {
          before(grammarAccess.getMessageAccess().getParticipantDeactivationParserRuleCall_2());
          pushFollow(FOLLOW_2);
          ruleParticipantDeactivation();

          state._fsp--;

          after(grammarAccess.getMessageAccess().getParticipantDeactivationParserRuleCall_2());

        }

      }
        break;

      }
    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Message__Alternatives"

  // $ANTLR start "rule__SequenceMessageType__Alternatives_0"
  // InternalDsl.g:708:1: rule__SequenceMessageType__Alternatives_0 : ( ( ruleSequenceMessage ) | ( ruleCreateMessage )
  // | ( ruleDeleteMessage ) );
  public final void rule__SequenceMessageType__Alternatives_0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:712:1: ( ( ruleSequenceMessage ) | ( ruleCreateMessage ) | ( ruleDeleteMessage ) )
      int alt7 = 3;
      int LA7_0 = input.LA(1);

      if ((LA7_0 == RULE_STRING)) {
        switch (input.LA(2)) {
        case 17: {
          alt7 = 2;
        }
          break;
        case 18: {
          alt7 = 3;
        }
          break;
        case 15: {
          alt7 = 1;
        }
          break;
        default:
          NoViableAltException nvae = new NoViableAltException("", 7, 1, input);

          throw nvae;
        }

      } else {
        NoViableAltException nvae = new NoViableAltException("", 7, 0, input);

        throw nvae;
      }
      switch (alt7) {
      case 1:
      // InternalDsl.g:713:2: ( ruleSequenceMessage )
      {
        // InternalDsl.g:713:2: ( ruleSequenceMessage )
        // InternalDsl.g:714:3: ruleSequenceMessage
        {
          before(grammarAccess.getSequenceMessageTypeAccess().getSequenceMessageParserRuleCall_0_0());
          pushFollow(FOLLOW_2);
          ruleSequenceMessage();

          state._fsp--;

          after(grammarAccess.getSequenceMessageTypeAccess().getSequenceMessageParserRuleCall_0_0());

        }

      }
        break;
      case 2:
      // InternalDsl.g:719:2: ( ruleCreateMessage )
      {
        // InternalDsl.g:719:2: ( ruleCreateMessage )
        // InternalDsl.g:720:3: ruleCreateMessage
        {
          before(grammarAccess.getSequenceMessageTypeAccess().getCreateMessageParserRuleCall_0_1());
          pushFollow(FOLLOW_2);
          ruleCreateMessage();

          state._fsp--;

          after(grammarAccess.getSequenceMessageTypeAccess().getCreateMessageParserRuleCall_0_1());

        }

      }
        break;
      case 3:
      // InternalDsl.g:725:2: ( ruleDeleteMessage )
      {
        // InternalDsl.g:725:2: ( ruleDeleteMessage )
        // InternalDsl.g:726:3: ruleDeleteMessage
        {
          before(grammarAccess.getSequenceMessageTypeAccess().getDeleteMessageParserRuleCall_0_2());
          pushFollow(FOLLOW_2);
          ruleDeleteMessage();

          state._fsp--;

          after(grammarAccess.getSequenceMessageTypeAccess().getDeleteMessageParserRuleCall_0_2());

        }

      }
        break;

      }
    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessageType__Alternatives_0"

  // $ANTLR start "rule__Model__Group__0"
  // InternalDsl.g:735:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
  public final void rule__Model__Group__0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:739:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
      // InternalDsl.g:740:2: rule__Model__Group__0__Impl rule__Model__Group__1
      {
        pushFollow(FOLLOW_3);
        rule__Model__Group__0__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__Model__Group__1();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Model__Group__0"

  // $ANTLR start "rule__Model__Group__0__Impl"
  // InternalDsl.g:747:1: rule__Model__Group__0__Impl : ( 'scenario' ) ;
  public final void rule__Model__Group__0__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:751:1: ( ( 'scenario' ) )
      // InternalDsl.g:752:1: ( 'scenario' )
      {
        // InternalDsl.g:752:1: ( 'scenario' )
        // InternalDsl.g:753:2: 'scenario'
        {
          before(grammarAccess.getModelAccess().getScenarioKeyword_0());
          match(input, 14, FOLLOW_2);
          after(grammarAccess.getModelAccess().getScenarioKeyword_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Model__Group__0__Impl"

  // $ANTLR start "rule__Model__Group__1"
  // InternalDsl.g:762:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
  public final void rule__Model__Group__1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:766:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
      // InternalDsl.g:767:2: rule__Model__Group__1__Impl rule__Model__Group__2
      {
        pushFollow(FOLLOW_4);
        rule__Model__Group__1__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__Model__Group__2();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Model__Group__1"

  // $ANTLR start "rule__Model__Group__1__Impl"
  // InternalDsl.g:774:1: rule__Model__Group__1__Impl : ( ( rule__Model__BeginAssignment_1 ) ) ;
  public final void rule__Model__Group__1__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:778:1: ( ( ( rule__Model__BeginAssignment_1 ) ) )
      // InternalDsl.g:779:1: ( ( rule__Model__BeginAssignment_1 ) )
      {
        // InternalDsl.g:779:1: ( ( rule__Model__BeginAssignment_1 ) )
        // InternalDsl.g:780:2: ( rule__Model__BeginAssignment_1 )
        {
          before(grammarAccess.getModelAccess().getBeginAssignment_1());
          // InternalDsl.g:781:2: ( rule__Model__BeginAssignment_1 )
          // InternalDsl.g:781:3: rule__Model__BeginAssignment_1
          {
            pushFollow(FOLLOW_2);
            rule__Model__BeginAssignment_1();

            state._fsp--;

          }

          after(grammarAccess.getModelAccess().getBeginAssignment_1());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Model__Group__1__Impl"

  // $ANTLR start "rule__Model__Group__2"
  // InternalDsl.g:789:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
  public final void rule__Model__Group__2() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:793:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
      // InternalDsl.g:794:2: rule__Model__Group__2__Impl rule__Model__Group__3
      {
        pushFollow(FOLLOW_4);
        rule__Model__Group__2__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__Model__Group__3();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Model__Group__2"

  // $ANTLR start "rule__Model__Group__2__Impl"
  // InternalDsl.g:801:1: rule__Model__Group__2__Impl : ( ( rule__Model__ParticipantsAssignment_2 )* ) ;
  public final void rule__Model__Group__2__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:805:1: ( ( ( rule__Model__ParticipantsAssignment_2 )* ) )
      // InternalDsl.g:806:1: ( ( rule__Model__ParticipantsAssignment_2 )* )
      {
        // InternalDsl.g:806:1: ( ( rule__Model__ParticipantsAssignment_2 )* )
        // InternalDsl.g:807:2: ( rule__Model__ParticipantsAssignment_2 )*
        {
          before(grammarAccess.getModelAccess().getParticipantsAssignment_2());
          // InternalDsl.g:808:2: ( rule__Model__ParticipantsAssignment_2 )*
          loop8: do {
            int alt8 = 2;
            int LA8_0 = input.LA(1);

            if (((LA8_0 >= 24 && LA8_0 <= 30))) {
              alt8 = 1;
            }

            switch (alt8) {
            case 1:
            // InternalDsl.g:808:3: rule__Model__ParticipantsAssignment_2
            {
              pushFollow(FOLLOW_5);
              rule__Model__ParticipantsAssignment_2();

              state._fsp--;

            }
              break;

            default:
              break loop8;
            }
          } while (true);

          after(grammarAccess.getModelAccess().getParticipantsAssignment_2());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Model__Group__2__Impl"

  // $ANTLR start "rule__Model__Group__3"
  // InternalDsl.g:816:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
  public final void rule__Model__Group__3() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:820:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
      // InternalDsl.g:821:2: rule__Model__Group__3__Impl rule__Model__Group__4
      {
        pushFollow(FOLLOW_4);
        rule__Model__Group__3__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__Model__Group__4();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Model__Group__3"

  // $ANTLR start "rule__Model__Group__3__Impl"
  // InternalDsl.g:828:1: rule__Model__Group__3__Impl : ( ( rule__Model__MessagesOrReferencesAssignment_3 )* ) ;
  public final void rule__Model__Group__3__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:832:1: ( ( ( rule__Model__MessagesOrReferencesAssignment_3 )* ) )
      // InternalDsl.g:833:1: ( ( rule__Model__MessagesOrReferencesAssignment_3 )* )
      {
        // InternalDsl.g:833:1: ( ( rule__Model__MessagesOrReferencesAssignment_3 )* )
        // InternalDsl.g:834:2: ( rule__Model__MessagesOrReferencesAssignment_3 )*
        {
          before(grammarAccess.getModelAccess().getMessagesOrReferencesAssignment_3());
          // InternalDsl.g:835:2: ( rule__Model__MessagesOrReferencesAssignment_3 )*
          loop9: do {
            int alt9 = 2;
            int LA9_0 = input.LA(1);

            if ((LA9_0 == RULE_STRING || LA9_0 == 20 || (LA9_0 >= 31 && LA9_0 <= 32))) {
              alt9 = 1;
            }

            switch (alt9) {
            case 1:
            // InternalDsl.g:835:3: rule__Model__MessagesOrReferencesAssignment_3
            {
              pushFollow(FOLLOW_6);
              rule__Model__MessagesOrReferencesAssignment_3();

              state._fsp--;

            }
              break;

            default:
              break loop9;
            }
          } while (true);

          after(grammarAccess.getModelAccess().getMessagesOrReferencesAssignment_3());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Model__Group__3__Impl"

  // $ANTLR start "rule__Model__Group__4"
  // InternalDsl.g:843:1: rule__Model__Group__4 : rule__Model__Group__4__Impl ;
  public final void rule__Model__Group__4() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:847:1: ( rule__Model__Group__4__Impl )
      // InternalDsl.g:848:2: rule__Model__Group__4__Impl
      {
        pushFollow(FOLLOW_2);
        rule__Model__Group__4__Impl();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Model__Group__4"

  // $ANTLR start "rule__Model__Group__4__Impl"
  // InternalDsl.g:854:1: rule__Model__Group__4__Impl : ( ( rule__Model__EndAssignment_4 ) ) ;
  public final void rule__Model__Group__4__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:858:1: ( ( ( rule__Model__EndAssignment_4 ) ) )
      // InternalDsl.g:859:1: ( ( rule__Model__EndAssignment_4 ) )
      {
        // InternalDsl.g:859:1: ( ( rule__Model__EndAssignment_4 ) )
        // InternalDsl.g:860:2: ( rule__Model__EndAssignment_4 )
        {
          before(grammarAccess.getModelAccess().getEndAssignment_4());
          // InternalDsl.g:861:2: ( rule__Model__EndAssignment_4 )
          // InternalDsl.g:861:3: rule__Model__EndAssignment_4
          {
            pushFollow(FOLLOW_2);
            rule__Model__EndAssignment_4();

            state._fsp--;

          }

          after(grammarAccess.getModelAccess().getEndAssignment_4());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Model__Group__4__Impl"

  // $ANTLR start "rule__Actor__Group__0"
  // InternalDsl.g:870:1: rule__Actor__Group__0 : rule__Actor__Group__0__Impl rule__Actor__Group__1 ;
  public final void rule__Actor__Group__0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:874:1: ( rule__Actor__Group__0__Impl rule__Actor__Group__1 )
      // InternalDsl.g:875:2: rule__Actor__Group__0__Impl rule__Actor__Group__1
      {
        pushFollow(FOLLOW_7);
        rule__Actor__Group__0__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__Actor__Group__1();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Actor__Group__0"

  // $ANTLR start "rule__Actor__Group__0__Impl"
  // InternalDsl.g:882:1: rule__Actor__Group__0__Impl : ( ( rule__Actor__KeywordAssignment_0 ) ) ;
  public final void rule__Actor__Group__0__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:886:1: ( ( ( rule__Actor__KeywordAssignment_0 ) ) )
      // InternalDsl.g:887:1: ( ( rule__Actor__KeywordAssignment_0 ) )
      {
        // InternalDsl.g:887:1: ( ( rule__Actor__KeywordAssignment_0 ) )
        // InternalDsl.g:888:2: ( rule__Actor__KeywordAssignment_0 )
        {
          before(grammarAccess.getActorAccess().getKeywordAssignment_0());
          // InternalDsl.g:889:2: ( rule__Actor__KeywordAssignment_0 )
          // InternalDsl.g:889:3: rule__Actor__KeywordAssignment_0
          {
            pushFollow(FOLLOW_2);
            rule__Actor__KeywordAssignment_0();

            state._fsp--;

          }

          after(grammarAccess.getActorAccess().getKeywordAssignment_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Actor__Group__0__Impl"

  // $ANTLR start "rule__Actor__Group__1"
  // InternalDsl.g:897:1: rule__Actor__Group__1 : rule__Actor__Group__1__Impl ;
  public final void rule__Actor__Group__1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:901:1: ( rule__Actor__Group__1__Impl )
      // InternalDsl.g:902:2: rule__Actor__Group__1__Impl
      {
        pushFollow(FOLLOW_2);
        rule__Actor__Group__1__Impl();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Actor__Group__1"

  // $ANTLR start "rule__Actor__Group__1__Impl"
  // InternalDsl.g:908:1: rule__Actor__Group__1__Impl : ( ( rule__Actor__NameAssignment_1 ) ) ;
  public final void rule__Actor__Group__1__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:912:1: ( ( ( rule__Actor__NameAssignment_1 ) ) )
      // InternalDsl.g:913:1: ( ( rule__Actor__NameAssignment_1 ) )
      {
        // InternalDsl.g:913:1: ( ( rule__Actor__NameAssignment_1 ) )
        // InternalDsl.g:914:2: ( rule__Actor__NameAssignment_1 )
        {
          before(grammarAccess.getActorAccess().getNameAssignment_1());
          // InternalDsl.g:915:2: ( rule__Actor__NameAssignment_1 )
          // InternalDsl.g:915:3: rule__Actor__NameAssignment_1
          {
            pushFollow(FOLLOW_2);
            rule__Actor__NameAssignment_1();

            state._fsp--;

          }

          after(grammarAccess.getActorAccess().getNameAssignment_1());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Actor__Group__1__Impl"

  // $ANTLR start "rule__Component__Group__0"
  // InternalDsl.g:924:1: rule__Component__Group__0 : rule__Component__Group__0__Impl rule__Component__Group__1 ;
  public final void rule__Component__Group__0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:928:1: ( rule__Component__Group__0__Impl rule__Component__Group__1 )
      // InternalDsl.g:929:2: rule__Component__Group__0__Impl rule__Component__Group__1
      {
        pushFollow(FOLLOW_7);
        rule__Component__Group__0__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__Component__Group__1();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Component__Group__0"

  // $ANTLR start "rule__Component__Group__0__Impl"
  // InternalDsl.g:936:1: rule__Component__Group__0__Impl : ( ( rule__Component__KeywordAssignment_0 ) ) ;
  public final void rule__Component__Group__0__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:940:1: ( ( ( rule__Component__KeywordAssignment_0 ) ) )
      // InternalDsl.g:941:1: ( ( rule__Component__KeywordAssignment_0 ) )
      {
        // InternalDsl.g:941:1: ( ( rule__Component__KeywordAssignment_0 ) )
        // InternalDsl.g:942:2: ( rule__Component__KeywordAssignment_0 )
        {
          before(grammarAccess.getComponentAccess().getKeywordAssignment_0());
          // InternalDsl.g:943:2: ( rule__Component__KeywordAssignment_0 )
          // InternalDsl.g:943:3: rule__Component__KeywordAssignment_0
          {
            pushFollow(FOLLOW_2);
            rule__Component__KeywordAssignment_0();

            state._fsp--;

          }

          after(grammarAccess.getComponentAccess().getKeywordAssignment_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Component__Group__0__Impl"

  // $ANTLR start "rule__Component__Group__1"
  // InternalDsl.g:951:1: rule__Component__Group__1 : rule__Component__Group__1__Impl rule__Component__Group__2 ;
  public final void rule__Component__Group__1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:955:1: ( rule__Component__Group__1__Impl rule__Component__Group__2 )
      // InternalDsl.g:956:2: rule__Component__Group__1__Impl rule__Component__Group__2
      {
        pushFollow(FOLLOW_8);
        rule__Component__Group__1__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__Component__Group__2();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Component__Group__1"

  // $ANTLR start "rule__Component__Group__1__Impl"
  // InternalDsl.g:963:1: rule__Component__Group__1__Impl : ( ( rule__Component__NameAssignment_1 ) ) ;
  public final void rule__Component__Group__1__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:967:1: ( ( ( rule__Component__NameAssignment_1 ) ) )
      // InternalDsl.g:968:1: ( ( rule__Component__NameAssignment_1 ) )
      {
        // InternalDsl.g:968:1: ( ( rule__Component__NameAssignment_1 ) )
        // InternalDsl.g:969:2: ( rule__Component__NameAssignment_1 )
        {
          before(grammarAccess.getComponentAccess().getNameAssignment_1());
          // InternalDsl.g:970:2: ( rule__Component__NameAssignment_1 )
          // InternalDsl.g:970:3: rule__Component__NameAssignment_1
          {
            pushFollow(FOLLOW_2);
            rule__Component__NameAssignment_1();

            state._fsp--;

          }

          after(grammarAccess.getComponentAccess().getNameAssignment_1());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Component__Group__1__Impl"

  // $ANTLR start "rule__Component__Group__2"
  // InternalDsl.g:978:1: rule__Component__Group__2 : rule__Component__Group__2__Impl ;
  public final void rule__Component__Group__2() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:982:1: ( rule__Component__Group__2__Impl )
      // InternalDsl.g:983:2: rule__Component__Group__2__Impl
      {
        pushFollow(FOLLOW_2);
        rule__Component__Group__2__Impl();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Component__Group__2"

  // $ANTLR start "rule__Component__Group__2__Impl"
  // InternalDsl.g:989:1: rule__Component__Group__2__Impl : ( ( rule__Component__NatureAssignment_2 )? ) ;
  public final void rule__Component__Group__2__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:993:1: ( ( ( rule__Component__NatureAssignment_2 )? ) )
      // InternalDsl.g:994:1: ( ( rule__Component__NatureAssignment_2 )? )
      {
        // InternalDsl.g:994:1: ( ( rule__Component__NatureAssignment_2 )? )
        // InternalDsl.g:995:2: ( rule__Component__NatureAssignment_2 )?
        {
          before(grammarAccess.getComponentAccess().getNatureAssignment_2());
          // InternalDsl.g:996:2: ( rule__Component__NatureAssignment_2 )?
          int alt10 = 2;
          int LA10_0 = input.LA(1);

          if (((LA10_0 >= 11 && LA10_0 <= 13))) {
            alt10 = 1;
          }
          switch (alt10) {
          case 1:
          // InternalDsl.g:996:3: rule__Component__NatureAssignment_2
          {
            pushFollow(FOLLOW_2);
            rule__Component__NatureAssignment_2();

            state._fsp--;

          }
            break;

          }

          after(grammarAccess.getComponentAccess().getNatureAssignment_2());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Component__Group__2__Impl"

  // $ANTLR start "rule__ConfigurationItem__Group__0"
  // InternalDsl.g:1005:1: rule__ConfigurationItem__Group__0 : rule__ConfigurationItem__Group__0__Impl
  // rule__ConfigurationItem__Group__1 ;
  public final void rule__ConfigurationItem__Group__0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1009:1: ( rule__ConfigurationItem__Group__0__Impl rule__ConfigurationItem__Group__1 )
      // InternalDsl.g:1010:2: rule__ConfigurationItem__Group__0__Impl rule__ConfigurationItem__Group__1
      {
        pushFollow(FOLLOW_7);
        rule__ConfigurationItem__Group__0__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__ConfigurationItem__Group__1();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ConfigurationItem__Group__0"

  // $ANTLR start "rule__ConfigurationItem__Group__0__Impl"
  // InternalDsl.g:1017:1: rule__ConfigurationItem__Group__0__Impl : ( ( rule__ConfigurationItem__KeywordAssignment_0 )
  // ) ;
  public final void rule__ConfigurationItem__Group__0__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1021:1: ( ( ( rule__ConfigurationItem__KeywordAssignment_0 ) ) )
      // InternalDsl.g:1022:1: ( ( rule__ConfigurationItem__KeywordAssignment_0 ) )
      {
        // InternalDsl.g:1022:1: ( ( rule__ConfigurationItem__KeywordAssignment_0 ) )
        // InternalDsl.g:1023:2: ( rule__ConfigurationItem__KeywordAssignment_0 )
        {
          before(grammarAccess.getConfigurationItemAccess().getKeywordAssignment_0());
          // InternalDsl.g:1024:2: ( rule__ConfigurationItem__KeywordAssignment_0 )
          // InternalDsl.g:1024:3: rule__ConfigurationItem__KeywordAssignment_0
          {
            pushFollow(FOLLOW_2);
            rule__ConfigurationItem__KeywordAssignment_0();

            state._fsp--;

          }

          after(grammarAccess.getConfigurationItemAccess().getKeywordAssignment_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ConfigurationItem__Group__0__Impl"

  // $ANTLR start "rule__ConfigurationItem__Group__1"
  // InternalDsl.g:1032:1: rule__ConfigurationItem__Group__1 : rule__ConfigurationItem__Group__1__Impl ;
  public final void rule__ConfigurationItem__Group__1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1036:1: ( rule__ConfigurationItem__Group__1__Impl )
      // InternalDsl.g:1037:2: rule__ConfigurationItem__Group__1__Impl
      {
        pushFollow(FOLLOW_2);
        rule__ConfigurationItem__Group__1__Impl();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ConfigurationItem__Group__1"

  // $ANTLR start "rule__ConfigurationItem__Group__1__Impl"
  // InternalDsl.g:1043:1: rule__ConfigurationItem__Group__1__Impl : ( ( rule__ConfigurationItem__NameAssignment_1 ) ) ;
  public final void rule__ConfigurationItem__Group__1__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1047:1: ( ( ( rule__ConfigurationItem__NameAssignment_1 ) ) )
      // InternalDsl.g:1048:1: ( ( rule__ConfigurationItem__NameAssignment_1 ) )
      {
        // InternalDsl.g:1048:1: ( ( rule__ConfigurationItem__NameAssignment_1 ) )
        // InternalDsl.g:1049:2: ( rule__ConfigurationItem__NameAssignment_1 )
        {
          before(grammarAccess.getConfigurationItemAccess().getNameAssignment_1());
          // InternalDsl.g:1050:2: ( rule__ConfigurationItem__NameAssignment_1 )
          // InternalDsl.g:1050:3: rule__ConfigurationItem__NameAssignment_1
          {
            pushFollow(FOLLOW_2);
            rule__ConfigurationItem__NameAssignment_1();

            state._fsp--;

          }

          after(grammarAccess.getConfigurationItemAccess().getNameAssignment_1());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ConfigurationItem__Group__1__Impl"

  // $ANTLR start "rule__Function__Group__0"
  // InternalDsl.g:1059:1: rule__Function__Group__0 : rule__Function__Group__0__Impl rule__Function__Group__1 ;
  public final void rule__Function__Group__0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1063:1: ( rule__Function__Group__0__Impl rule__Function__Group__1 )
      // InternalDsl.g:1064:2: rule__Function__Group__0__Impl rule__Function__Group__1
      {
        pushFollow(FOLLOW_7);
        rule__Function__Group__0__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__Function__Group__1();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Function__Group__0"

  // $ANTLR start "rule__Function__Group__0__Impl"
  // InternalDsl.g:1071:1: rule__Function__Group__0__Impl : ( ( rule__Function__KeywordAssignment_0 ) ) ;
  public final void rule__Function__Group__0__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1075:1: ( ( ( rule__Function__KeywordAssignment_0 ) ) )
      // InternalDsl.g:1076:1: ( ( rule__Function__KeywordAssignment_0 ) )
      {
        // InternalDsl.g:1076:1: ( ( rule__Function__KeywordAssignment_0 ) )
        // InternalDsl.g:1077:2: ( rule__Function__KeywordAssignment_0 )
        {
          before(grammarAccess.getFunctionAccess().getKeywordAssignment_0());
          // InternalDsl.g:1078:2: ( rule__Function__KeywordAssignment_0 )
          // InternalDsl.g:1078:3: rule__Function__KeywordAssignment_0
          {
            pushFollow(FOLLOW_2);
            rule__Function__KeywordAssignment_0();

            state._fsp--;

          }

          after(grammarAccess.getFunctionAccess().getKeywordAssignment_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Function__Group__0__Impl"

  // $ANTLR start "rule__Function__Group__1"
  // InternalDsl.g:1086:1: rule__Function__Group__1 : rule__Function__Group__1__Impl ;
  public final void rule__Function__Group__1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1090:1: ( rule__Function__Group__1__Impl )
      // InternalDsl.g:1091:2: rule__Function__Group__1__Impl
      {
        pushFollow(FOLLOW_2);
        rule__Function__Group__1__Impl();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Function__Group__1"

  // $ANTLR start "rule__Function__Group__1__Impl"
  // InternalDsl.g:1097:1: rule__Function__Group__1__Impl : ( ( rule__Function__NameAssignment_1 ) ) ;
  public final void rule__Function__Group__1__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1101:1: ( ( ( rule__Function__NameAssignment_1 ) ) )
      // InternalDsl.g:1102:1: ( ( rule__Function__NameAssignment_1 ) )
      {
        // InternalDsl.g:1102:1: ( ( rule__Function__NameAssignment_1 ) )
        // InternalDsl.g:1103:2: ( rule__Function__NameAssignment_1 )
        {
          before(grammarAccess.getFunctionAccess().getNameAssignment_1());
          // InternalDsl.g:1104:2: ( rule__Function__NameAssignment_1 )
          // InternalDsl.g:1104:3: rule__Function__NameAssignment_1
          {
            pushFollow(FOLLOW_2);
            rule__Function__NameAssignment_1();

            state._fsp--;

          }

          after(grammarAccess.getFunctionAccess().getNameAssignment_1());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Function__Group__1__Impl"

  // $ANTLR start "rule__Activity__Group__0"
  // InternalDsl.g:1113:1: rule__Activity__Group__0 : rule__Activity__Group__0__Impl rule__Activity__Group__1 ;
  public final void rule__Activity__Group__0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1117:1: ( rule__Activity__Group__0__Impl rule__Activity__Group__1 )
      // InternalDsl.g:1118:2: rule__Activity__Group__0__Impl rule__Activity__Group__1
      {
        pushFollow(FOLLOW_7);
        rule__Activity__Group__0__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__Activity__Group__1();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Activity__Group__0"

  // $ANTLR start "rule__Activity__Group__0__Impl"
  // InternalDsl.g:1125:1: rule__Activity__Group__0__Impl : ( ( rule__Activity__KeywordAssignment_0 ) ) ;
  public final void rule__Activity__Group__0__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1129:1: ( ( ( rule__Activity__KeywordAssignment_0 ) ) )
      // InternalDsl.g:1130:1: ( ( rule__Activity__KeywordAssignment_0 ) )
      {
        // InternalDsl.g:1130:1: ( ( rule__Activity__KeywordAssignment_0 ) )
        // InternalDsl.g:1131:2: ( rule__Activity__KeywordAssignment_0 )
        {
          before(grammarAccess.getActivityAccess().getKeywordAssignment_0());
          // InternalDsl.g:1132:2: ( rule__Activity__KeywordAssignment_0 )
          // InternalDsl.g:1132:3: rule__Activity__KeywordAssignment_0
          {
            pushFollow(FOLLOW_2);
            rule__Activity__KeywordAssignment_0();

            state._fsp--;

          }

          after(grammarAccess.getActivityAccess().getKeywordAssignment_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Activity__Group__0__Impl"

  // $ANTLR start "rule__Activity__Group__1"
  // InternalDsl.g:1140:1: rule__Activity__Group__1 : rule__Activity__Group__1__Impl ;
  public final void rule__Activity__Group__1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1144:1: ( rule__Activity__Group__1__Impl )
      // InternalDsl.g:1145:2: rule__Activity__Group__1__Impl
      {
        pushFollow(FOLLOW_2);
        rule__Activity__Group__1__Impl();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Activity__Group__1"

  // $ANTLR start "rule__Activity__Group__1__Impl"
  // InternalDsl.g:1151:1: rule__Activity__Group__1__Impl : ( ( rule__Activity__NameAssignment_1 ) ) ;
  public final void rule__Activity__Group__1__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1155:1: ( ( ( rule__Activity__NameAssignment_1 ) ) )
      // InternalDsl.g:1156:1: ( ( rule__Activity__NameAssignment_1 ) )
      {
        // InternalDsl.g:1156:1: ( ( rule__Activity__NameAssignment_1 ) )
        // InternalDsl.g:1157:2: ( rule__Activity__NameAssignment_1 )
        {
          before(grammarAccess.getActivityAccess().getNameAssignment_1());
          // InternalDsl.g:1158:2: ( rule__Activity__NameAssignment_1 )
          // InternalDsl.g:1158:3: rule__Activity__NameAssignment_1
          {
            pushFollow(FOLLOW_2);
            rule__Activity__NameAssignment_1();

            state._fsp--;

          }

          after(grammarAccess.getActivityAccess().getNameAssignment_1());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Activity__Group__1__Impl"

  // $ANTLR start "rule__Entity__Group__0"
  // InternalDsl.g:1167:1: rule__Entity__Group__0 : rule__Entity__Group__0__Impl rule__Entity__Group__1 ;
  public final void rule__Entity__Group__0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1171:1: ( rule__Entity__Group__0__Impl rule__Entity__Group__1 )
      // InternalDsl.g:1172:2: rule__Entity__Group__0__Impl rule__Entity__Group__1
      {
        pushFollow(FOLLOW_7);
        rule__Entity__Group__0__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__Entity__Group__1();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Entity__Group__0"

  // $ANTLR start "rule__Entity__Group__0__Impl"
  // InternalDsl.g:1179:1: rule__Entity__Group__0__Impl : ( ( rule__Entity__KeywordAssignment_0 ) ) ;
  public final void rule__Entity__Group__0__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1183:1: ( ( ( rule__Entity__KeywordAssignment_0 ) ) )
      // InternalDsl.g:1184:1: ( ( rule__Entity__KeywordAssignment_0 ) )
      {
        // InternalDsl.g:1184:1: ( ( rule__Entity__KeywordAssignment_0 ) )
        // InternalDsl.g:1185:2: ( rule__Entity__KeywordAssignment_0 )
        {
          before(grammarAccess.getEntityAccess().getKeywordAssignment_0());
          // InternalDsl.g:1186:2: ( rule__Entity__KeywordAssignment_0 )
          // InternalDsl.g:1186:3: rule__Entity__KeywordAssignment_0
          {
            pushFollow(FOLLOW_2);
            rule__Entity__KeywordAssignment_0();

            state._fsp--;

          }

          after(grammarAccess.getEntityAccess().getKeywordAssignment_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Entity__Group__0__Impl"

  // $ANTLR start "rule__Entity__Group__1"
  // InternalDsl.g:1194:1: rule__Entity__Group__1 : rule__Entity__Group__1__Impl ;
  public final void rule__Entity__Group__1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1198:1: ( rule__Entity__Group__1__Impl )
      // InternalDsl.g:1199:2: rule__Entity__Group__1__Impl
      {
        pushFollow(FOLLOW_2);
        rule__Entity__Group__1__Impl();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Entity__Group__1"

  // $ANTLR start "rule__Entity__Group__1__Impl"
  // InternalDsl.g:1205:1: rule__Entity__Group__1__Impl : ( ( rule__Entity__NameAssignment_1 ) ) ;
  public final void rule__Entity__Group__1__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1209:1: ( ( ( rule__Entity__NameAssignment_1 ) ) )
      // InternalDsl.g:1210:1: ( ( rule__Entity__NameAssignment_1 ) )
      {
        // InternalDsl.g:1210:1: ( ( rule__Entity__NameAssignment_1 ) )
        // InternalDsl.g:1211:2: ( rule__Entity__NameAssignment_1 )
        {
          before(grammarAccess.getEntityAccess().getNameAssignment_1());
          // InternalDsl.g:1212:2: ( rule__Entity__NameAssignment_1 )
          // InternalDsl.g:1212:3: rule__Entity__NameAssignment_1
          {
            pushFollow(FOLLOW_2);
            rule__Entity__NameAssignment_1();

            state._fsp--;

          }

          after(grammarAccess.getEntityAccess().getNameAssignment_1());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Entity__Group__1__Impl"

  // $ANTLR start "rule__Role__Group__0"
  // InternalDsl.g:1221:1: rule__Role__Group__0 : rule__Role__Group__0__Impl rule__Role__Group__1 ;
  public final void rule__Role__Group__0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1225:1: ( rule__Role__Group__0__Impl rule__Role__Group__1 )
      // InternalDsl.g:1226:2: rule__Role__Group__0__Impl rule__Role__Group__1
      {
        pushFollow(FOLLOW_7);
        rule__Role__Group__0__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__Role__Group__1();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Role__Group__0"

  // $ANTLR start "rule__Role__Group__0__Impl"
  // InternalDsl.g:1233:1: rule__Role__Group__0__Impl : ( ( rule__Role__KeywordAssignment_0 ) ) ;
  public final void rule__Role__Group__0__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1237:1: ( ( ( rule__Role__KeywordAssignment_0 ) ) )
      // InternalDsl.g:1238:1: ( ( rule__Role__KeywordAssignment_0 ) )
      {
        // InternalDsl.g:1238:1: ( ( rule__Role__KeywordAssignment_0 ) )
        // InternalDsl.g:1239:2: ( rule__Role__KeywordAssignment_0 )
        {
          before(grammarAccess.getRoleAccess().getKeywordAssignment_0());
          // InternalDsl.g:1240:2: ( rule__Role__KeywordAssignment_0 )
          // InternalDsl.g:1240:3: rule__Role__KeywordAssignment_0
          {
            pushFollow(FOLLOW_2);
            rule__Role__KeywordAssignment_0();

            state._fsp--;

          }

          after(grammarAccess.getRoleAccess().getKeywordAssignment_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Role__Group__0__Impl"

  // $ANTLR start "rule__Role__Group__1"
  // InternalDsl.g:1248:1: rule__Role__Group__1 : rule__Role__Group__1__Impl ;
  public final void rule__Role__Group__1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1252:1: ( rule__Role__Group__1__Impl )
      // InternalDsl.g:1253:2: rule__Role__Group__1__Impl
      {
        pushFollow(FOLLOW_2);
        rule__Role__Group__1__Impl();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Role__Group__1"

  // $ANTLR start "rule__Role__Group__1__Impl"
  // InternalDsl.g:1259:1: rule__Role__Group__1__Impl : ( ( rule__Role__NameAssignment_1 ) ) ;
  public final void rule__Role__Group__1__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1263:1: ( ( ( rule__Role__NameAssignment_1 ) ) )
      // InternalDsl.g:1264:1: ( ( rule__Role__NameAssignment_1 ) )
      {
        // InternalDsl.g:1264:1: ( ( rule__Role__NameAssignment_1 ) )
        // InternalDsl.g:1265:2: ( rule__Role__NameAssignment_1 )
        {
          before(grammarAccess.getRoleAccess().getNameAssignment_1());
          // InternalDsl.g:1266:2: ( rule__Role__NameAssignment_1 )
          // InternalDsl.g:1266:3: rule__Role__NameAssignment_1
          {
            pushFollow(FOLLOW_2);
            rule__Role__NameAssignment_1();

            state._fsp--;

          }

          after(grammarAccess.getRoleAccess().getNameAssignment_1());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Role__Group__1__Impl"

  // $ANTLR start "rule__SequenceMessageType__Group__0"
  // InternalDsl.g:1275:1: rule__SequenceMessageType__Group__0 : rule__SequenceMessageType__Group__0__Impl
  // rule__SequenceMessageType__Group__1 ;
  public final void rule__SequenceMessageType__Group__0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1279:1: ( rule__SequenceMessageType__Group__0__Impl rule__SequenceMessageType__Group__1 )
      // InternalDsl.g:1280:2: rule__SequenceMessageType__Group__0__Impl rule__SequenceMessageType__Group__1
      {
        pushFollow(FOLLOW_7);
        rule__SequenceMessageType__Group__0__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__SequenceMessageType__Group__1();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessageType__Group__0"

  // $ANTLR start "rule__SequenceMessageType__Group__0__Impl"
  // InternalDsl.g:1287:1: rule__SequenceMessageType__Group__0__Impl : ( ( rule__SequenceMessageType__Alternatives_0 ) )
  // ;
  public final void rule__SequenceMessageType__Group__0__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1291:1: ( ( ( rule__SequenceMessageType__Alternatives_0 ) ) )
      // InternalDsl.g:1292:1: ( ( rule__SequenceMessageType__Alternatives_0 ) )
      {
        // InternalDsl.g:1292:1: ( ( rule__SequenceMessageType__Alternatives_0 ) )
        // InternalDsl.g:1293:2: ( rule__SequenceMessageType__Alternatives_0 )
        {
          before(grammarAccess.getSequenceMessageTypeAccess().getAlternatives_0());
          // InternalDsl.g:1294:2: ( rule__SequenceMessageType__Alternatives_0 )
          // InternalDsl.g:1294:3: rule__SequenceMessageType__Alternatives_0
          {
            pushFollow(FOLLOW_2);
            rule__SequenceMessageType__Alternatives_0();

            state._fsp--;

          }

          after(grammarAccess.getSequenceMessageTypeAccess().getAlternatives_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessageType__Group__0__Impl"

  // $ANTLR start "rule__SequenceMessageType__Group__1"
  // InternalDsl.g:1302:1: rule__SequenceMessageType__Group__1 : rule__SequenceMessageType__Group__1__Impl ;
  public final void rule__SequenceMessageType__Group__1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1306:1: ( rule__SequenceMessageType__Group__1__Impl )
      // InternalDsl.g:1307:2: rule__SequenceMessageType__Group__1__Impl
      {
        pushFollow(FOLLOW_2);
        rule__SequenceMessageType__Group__1__Impl();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessageType__Group__1"

  // $ANTLR start "rule__SequenceMessageType__Group__1__Impl"
  // InternalDsl.g:1313:1: rule__SequenceMessageType__Group__1__Impl : ( ( rule__SequenceMessageType__ReturnAssignment_1
  // )? ) ;
  public final void rule__SequenceMessageType__Group__1__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1317:1: ( ( ( rule__SequenceMessageType__ReturnAssignment_1 )? ) )
      // InternalDsl.g:1318:1: ( ( rule__SequenceMessageType__ReturnAssignment_1 )? )
      {
        // InternalDsl.g:1318:1: ( ( rule__SequenceMessageType__ReturnAssignment_1 )? )
        // InternalDsl.g:1319:2: ( rule__SequenceMessageType__ReturnAssignment_1 )?
        {
          before(grammarAccess.getSequenceMessageTypeAccess().getReturnAssignment_1());
          // InternalDsl.g:1320:2: ( rule__SequenceMessageType__ReturnAssignment_1 )?
          int alt11 = 2;
          int LA11_0 = input.LA(1);

          if ((LA11_0 == RULE_STRING)) {
            int LA11_1 = input.LA(2);

            if ((LA11_1 == 19)) {
              alt11 = 1;
            }
          }
          switch (alt11) {
          case 1:
          // InternalDsl.g:1320:3: rule__SequenceMessageType__ReturnAssignment_1
          {
            pushFollow(FOLLOW_2);
            rule__SequenceMessageType__ReturnAssignment_1();

            state._fsp--;

          }
            break;

          }

          after(grammarAccess.getSequenceMessageTypeAccess().getReturnAssignment_1());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessageType__Group__1__Impl"

  // $ANTLR start "rule__SequenceMessage__Group__0"
  // InternalDsl.g:1329:1: rule__SequenceMessage__Group__0 : rule__SequenceMessage__Group__0__Impl
  // rule__SequenceMessage__Group__1 ;
  public final void rule__SequenceMessage__Group__0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1333:1: ( rule__SequenceMessage__Group__0__Impl rule__SequenceMessage__Group__1 )
      // InternalDsl.g:1334:2: rule__SequenceMessage__Group__0__Impl rule__SequenceMessage__Group__1
      {
        pushFollow(FOLLOW_9);
        rule__SequenceMessage__Group__0__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__SequenceMessage__Group__1();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessage__Group__0"

  // $ANTLR start "rule__SequenceMessage__Group__0__Impl"
  // InternalDsl.g:1341:1: rule__SequenceMessage__Group__0__Impl : ( ( rule__SequenceMessage__SourceAssignment_0 ) ) ;
  public final void rule__SequenceMessage__Group__0__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1345:1: ( ( ( rule__SequenceMessage__SourceAssignment_0 ) ) )
      // InternalDsl.g:1346:1: ( ( rule__SequenceMessage__SourceAssignment_0 ) )
      {
        // InternalDsl.g:1346:1: ( ( rule__SequenceMessage__SourceAssignment_0 ) )
        // InternalDsl.g:1347:2: ( rule__SequenceMessage__SourceAssignment_0 )
        {
          before(grammarAccess.getSequenceMessageAccess().getSourceAssignment_0());
          // InternalDsl.g:1348:2: ( rule__SequenceMessage__SourceAssignment_0 )
          // InternalDsl.g:1348:3: rule__SequenceMessage__SourceAssignment_0
          {
            pushFollow(FOLLOW_2);
            rule__SequenceMessage__SourceAssignment_0();

            state._fsp--;

          }

          after(grammarAccess.getSequenceMessageAccess().getSourceAssignment_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessage__Group__0__Impl"

  // $ANTLR start "rule__SequenceMessage__Group__1"
  // InternalDsl.g:1356:1: rule__SequenceMessage__Group__1 : rule__SequenceMessage__Group__1__Impl
  // rule__SequenceMessage__Group__2 ;
  public final void rule__SequenceMessage__Group__1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1360:1: ( rule__SequenceMessage__Group__1__Impl rule__SequenceMessage__Group__2 )
      // InternalDsl.g:1361:2: rule__SequenceMessage__Group__1__Impl rule__SequenceMessage__Group__2
      {
        pushFollow(FOLLOW_7);
        rule__SequenceMessage__Group__1__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__SequenceMessage__Group__2();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessage__Group__1"

  // $ANTLR start "rule__SequenceMessage__Group__1__Impl"
  // InternalDsl.g:1368:1: rule__SequenceMessage__Group__1__Impl : ( '->' ) ;
  public final void rule__SequenceMessage__Group__1__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1372:1: ( ( '->' ) )
      // InternalDsl.g:1373:1: ( '->' )
      {
        // InternalDsl.g:1373:1: ( '->' )
        // InternalDsl.g:1374:2: '->'
        {
          before(grammarAccess.getSequenceMessageAccess().getHyphenMinusGreaterThanSignKeyword_1());
          match(input, 15, FOLLOW_2);
          after(grammarAccess.getSequenceMessageAccess().getHyphenMinusGreaterThanSignKeyword_1());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessage__Group__1__Impl"

  // $ANTLR start "rule__SequenceMessage__Group__2"
  // InternalDsl.g:1383:1: rule__SequenceMessage__Group__2 : rule__SequenceMessage__Group__2__Impl
  // rule__SequenceMessage__Group__3 ;
  public final void rule__SequenceMessage__Group__2() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1387:1: ( rule__SequenceMessage__Group__2__Impl rule__SequenceMessage__Group__3 )
      // InternalDsl.g:1388:2: rule__SequenceMessage__Group__2__Impl rule__SequenceMessage__Group__3
      {
        pushFollow(FOLLOW_10);
        rule__SequenceMessage__Group__2__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__SequenceMessage__Group__3();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessage__Group__2"

  // $ANTLR start "rule__SequenceMessage__Group__2__Impl"
  // InternalDsl.g:1395:1: rule__SequenceMessage__Group__2__Impl : ( ( rule__SequenceMessage__TargetAssignment_2 ) ) ;
  public final void rule__SequenceMessage__Group__2__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1399:1: ( ( ( rule__SequenceMessage__TargetAssignment_2 ) ) )
      // InternalDsl.g:1400:1: ( ( rule__SequenceMessage__TargetAssignment_2 ) )
      {
        // InternalDsl.g:1400:1: ( ( rule__SequenceMessage__TargetAssignment_2 ) )
        // InternalDsl.g:1401:2: ( rule__SequenceMessage__TargetAssignment_2 )
        {
          before(grammarAccess.getSequenceMessageAccess().getTargetAssignment_2());
          // InternalDsl.g:1402:2: ( rule__SequenceMessage__TargetAssignment_2 )
          // InternalDsl.g:1402:3: rule__SequenceMessage__TargetAssignment_2
          {
            pushFollow(FOLLOW_2);
            rule__SequenceMessage__TargetAssignment_2();

            state._fsp--;

          }

          after(grammarAccess.getSequenceMessageAccess().getTargetAssignment_2());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessage__Group__2__Impl"

  // $ANTLR start "rule__SequenceMessage__Group__3"
  // InternalDsl.g:1410:1: rule__SequenceMessage__Group__3 : rule__SequenceMessage__Group__3__Impl
  // rule__SequenceMessage__Group__4 ;
  public final void rule__SequenceMessage__Group__3() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1414:1: ( rule__SequenceMessage__Group__3__Impl rule__SequenceMessage__Group__4 )
      // InternalDsl.g:1415:2: rule__SequenceMessage__Group__3__Impl rule__SequenceMessage__Group__4
      {
        pushFollow(FOLLOW_7);
        rule__SequenceMessage__Group__3__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__SequenceMessage__Group__4();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessage__Group__3"

  // $ANTLR start "rule__SequenceMessage__Group__3__Impl"
  // InternalDsl.g:1422:1: rule__SequenceMessage__Group__3__Impl : ( ':' ) ;
  public final void rule__SequenceMessage__Group__3__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1426:1: ( ( ':' ) )
      // InternalDsl.g:1427:1: ( ':' )
      {
        // InternalDsl.g:1427:1: ( ':' )
        // InternalDsl.g:1428:2: ':'
        {
          before(grammarAccess.getSequenceMessageAccess().getColonKeyword_3());
          match(input, 16, FOLLOW_2);
          after(grammarAccess.getSequenceMessageAccess().getColonKeyword_3());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessage__Group__3__Impl"

  // $ANTLR start "rule__SequenceMessage__Group__4"
  // InternalDsl.g:1437:1: rule__SequenceMessage__Group__4 : rule__SequenceMessage__Group__4__Impl ;
  public final void rule__SequenceMessage__Group__4() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1441:1: ( rule__SequenceMessage__Group__4__Impl )
      // InternalDsl.g:1442:2: rule__SequenceMessage__Group__4__Impl
      {
        pushFollow(FOLLOW_2);
        rule__SequenceMessage__Group__4__Impl();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessage__Group__4"

  // $ANTLR start "rule__SequenceMessage__Group__4__Impl"
  // InternalDsl.g:1448:1: rule__SequenceMessage__Group__4__Impl : ( ( rule__SequenceMessage__NameAssignment_4 ) ) ;
  public final void rule__SequenceMessage__Group__4__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1452:1: ( ( ( rule__SequenceMessage__NameAssignment_4 ) ) )
      // InternalDsl.g:1453:1: ( ( rule__SequenceMessage__NameAssignment_4 ) )
      {
        // InternalDsl.g:1453:1: ( ( rule__SequenceMessage__NameAssignment_4 ) )
        // InternalDsl.g:1454:2: ( rule__SequenceMessage__NameAssignment_4 )
        {
          before(grammarAccess.getSequenceMessageAccess().getNameAssignment_4());
          // InternalDsl.g:1455:2: ( rule__SequenceMessage__NameAssignment_4 )
          // InternalDsl.g:1455:3: rule__SequenceMessage__NameAssignment_4
          {
            pushFollow(FOLLOW_2);
            rule__SequenceMessage__NameAssignment_4();

            state._fsp--;

          }

          after(grammarAccess.getSequenceMessageAccess().getNameAssignment_4());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessage__Group__4__Impl"

  // $ANTLR start "rule__CreateMessage__Group__0"
  // InternalDsl.g:1464:1: rule__CreateMessage__Group__0 : rule__CreateMessage__Group__0__Impl
  // rule__CreateMessage__Group__1 ;
  public final void rule__CreateMessage__Group__0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1468:1: ( rule__CreateMessage__Group__0__Impl rule__CreateMessage__Group__1 )
      // InternalDsl.g:1469:2: rule__CreateMessage__Group__0__Impl rule__CreateMessage__Group__1
      {
        pushFollow(FOLLOW_11);
        rule__CreateMessage__Group__0__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__CreateMessage__Group__1();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__CreateMessage__Group__0"

  // $ANTLR start "rule__CreateMessage__Group__0__Impl"
  // InternalDsl.g:1476:1: rule__CreateMessage__Group__0__Impl : ( ( rule__CreateMessage__SourceAssignment_0 ) ) ;
  public final void rule__CreateMessage__Group__0__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1480:1: ( ( ( rule__CreateMessage__SourceAssignment_0 ) ) )
      // InternalDsl.g:1481:1: ( ( rule__CreateMessage__SourceAssignment_0 ) )
      {
        // InternalDsl.g:1481:1: ( ( rule__CreateMessage__SourceAssignment_0 ) )
        // InternalDsl.g:1482:2: ( rule__CreateMessage__SourceAssignment_0 )
        {
          before(grammarAccess.getCreateMessageAccess().getSourceAssignment_0());
          // InternalDsl.g:1483:2: ( rule__CreateMessage__SourceAssignment_0 )
          // InternalDsl.g:1483:3: rule__CreateMessage__SourceAssignment_0
          {
            pushFollow(FOLLOW_2);
            rule__CreateMessage__SourceAssignment_0();

            state._fsp--;

          }

          after(grammarAccess.getCreateMessageAccess().getSourceAssignment_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__CreateMessage__Group__0__Impl"

  // $ANTLR start "rule__CreateMessage__Group__1"
  // InternalDsl.g:1491:1: rule__CreateMessage__Group__1 : rule__CreateMessage__Group__1__Impl
  // rule__CreateMessage__Group__2 ;
  public final void rule__CreateMessage__Group__1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1495:1: ( rule__CreateMessage__Group__1__Impl rule__CreateMessage__Group__2 )
      // InternalDsl.g:1496:2: rule__CreateMessage__Group__1__Impl rule__CreateMessage__Group__2
      {
        pushFollow(FOLLOW_7);
        rule__CreateMessage__Group__1__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__CreateMessage__Group__2();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__CreateMessage__Group__1"

  // $ANTLR start "rule__CreateMessage__Group__1__Impl"
  // InternalDsl.g:1503:1: rule__CreateMessage__Group__1__Impl : ( '->+' ) ;
  public final void rule__CreateMessage__Group__1__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1507:1: ( ( '->+' ) )
      // InternalDsl.g:1508:1: ( '->+' )
      {
        // InternalDsl.g:1508:1: ( '->+' )
        // InternalDsl.g:1509:2: '->+'
        {
          before(grammarAccess.getCreateMessageAccess().getHyphenMinusGreaterThanSignPlusSignKeyword_1());
          match(input, 17, FOLLOW_2);
          after(grammarAccess.getCreateMessageAccess().getHyphenMinusGreaterThanSignPlusSignKeyword_1());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__CreateMessage__Group__1__Impl"

  // $ANTLR start "rule__CreateMessage__Group__2"
  // InternalDsl.g:1518:1: rule__CreateMessage__Group__2 : rule__CreateMessage__Group__2__Impl
  // rule__CreateMessage__Group__3 ;
  public final void rule__CreateMessage__Group__2() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1522:1: ( rule__CreateMessage__Group__2__Impl rule__CreateMessage__Group__3 )
      // InternalDsl.g:1523:2: rule__CreateMessage__Group__2__Impl rule__CreateMessage__Group__3
      {
        pushFollow(FOLLOW_10);
        rule__CreateMessage__Group__2__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__CreateMessage__Group__3();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__CreateMessage__Group__2"

  // $ANTLR start "rule__CreateMessage__Group__2__Impl"
  // InternalDsl.g:1530:1: rule__CreateMessage__Group__2__Impl : ( ( rule__CreateMessage__TargetAssignment_2 ) ) ;
  public final void rule__CreateMessage__Group__2__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1534:1: ( ( ( rule__CreateMessage__TargetAssignment_2 ) ) )
      // InternalDsl.g:1535:1: ( ( rule__CreateMessage__TargetAssignment_2 ) )
      {
        // InternalDsl.g:1535:1: ( ( rule__CreateMessage__TargetAssignment_2 ) )
        // InternalDsl.g:1536:2: ( rule__CreateMessage__TargetAssignment_2 )
        {
          before(grammarAccess.getCreateMessageAccess().getTargetAssignment_2());
          // InternalDsl.g:1537:2: ( rule__CreateMessage__TargetAssignment_2 )
          // InternalDsl.g:1537:3: rule__CreateMessage__TargetAssignment_2
          {
            pushFollow(FOLLOW_2);
            rule__CreateMessage__TargetAssignment_2();

            state._fsp--;

          }

          after(grammarAccess.getCreateMessageAccess().getTargetAssignment_2());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__CreateMessage__Group__2__Impl"

  // $ANTLR start "rule__CreateMessage__Group__3"
  // InternalDsl.g:1545:1: rule__CreateMessage__Group__3 : rule__CreateMessage__Group__3__Impl
  // rule__CreateMessage__Group__4 ;
  public final void rule__CreateMessage__Group__3() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1549:1: ( rule__CreateMessage__Group__3__Impl rule__CreateMessage__Group__4 )
      // InternalDsl.g:1550:2: rule__CreateMessage__Group__3__Impl rule__CreateMessage__Group__4
      {
        pushFollow(FOLLOW_7);
        rule__CreateMessage__Group__3__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__CreateMessage__Group__4();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__CreateMessage__Group__3"

  // $ANTLR start "rule__CreateMessage__Group__3__Impl"
  // InternalDsl.g:1557:1: rule__CreateMessage__Group__3__Impl : ( ':' ) ;
  public final void rule__CreateMessage__Group__3__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1561:1: ( ( ':' ) )
      // InternalDsl.g:1562:1: ( ':' )
      {
        // InternalDsl.g:1562:1: ( ':' )
        // InternalDsl.g:1563:2: ':'
        {
          before(grammarAccess.getCreateMessageAccess().getColonKeyword_3());
          match(input, 16, FOLLOW_2);
          after(grammarAccess.getCreateMessageAccess().getColonKeyword_3());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__CreateMessage__Group__3__Impl"

  // $ANTLR start "rule__CreateMessage__Group__4"
  // InternalDsl.g:1572:1: rule__CreateMessage__Group__4 : rule__CreateMessage__Group__4__Impl ;
  public final void rule__CreateMessage__Group__4() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1576:1: ( rule__CreateMessage__Group__4__Impl )
      // InternalDsl.g:1577:2: rule__CreateMessage__Group__4__Impl
      {
        pushFollow(FOLLOW_2);
        rule__CreateMessage__Group__4__Impl();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__CreateMessage__Group__4"

  // $ANTLR start "rule__CreateMessage__Group__4__Impl"
  // InternalDsl.g:1583:1: rule__CreateMessage__Group__4__Impl : ( ( rule__CreateMessage__NameAssignment_4 ) ) ;
  public final void rule__CreateMessage__Group__4__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1587:1: ( ( ( rule__CreateMessage__NameAssignment_4 ) ) )
      // InternalDsl.g:1588:1: ( ( rule__CreateMessage__NameAssignment_4 ) )
      {
        // InternalDsl.g:1588:1: ( ( rule__CreateMessage__NameAssignment_4 ) )
        // InternalDsl.g:1589:2: ( rule__CreateMessage__NameAssignment_4 )
        {
          before(grammarAccess.getCreateMessageAccess().getNameAssignment_4());
          // InternalDsl.g:1590:2: ( rule__CreateMessage__NameAssignment_4 )
          // InternalDsl.g:1590:3: rule__CreateMessage__NameAssignment_4
          {
            pushFollow(FOLLOW_2);
            rule__CreateMessage__NameAssignment_4();

            state._fsp--;

          }

          after(grammarAccess.getCreateMessageAccess().getNameAssignment_4());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__CreateMessage__Group__4__Impl"

  // $ANTLR start "rule__DeleteMessage__Group__0"
  // InternalDsl.g:1599:1: rule__DeleteMessage__Group__0 : rule__DeleteMessage__Group__0__Impl
  // rule__DeleteMessage__Group__1 ;
  public final void rule__DeleteMessage__Group__0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1603:1: ( rule__DeleteMessage__Group__0__Impl rule__DeleteMessage__Group__1 )
      // InternalDsl.g:1604:2: rule__DeleteMessage__Group__0__Impl rule__DeleteMessage__Group__1
      {
        pushFollow(FOLLOW_12);
        rule__DeleteMessage__Group__0__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__DeleteMessage__Group__1();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__DeleteMessage__Group__0"

  // $ANTLR start "rule__DeleteMessage__Group__0__Impl"
  // InternalDsl.g:1611:1: rule__DeleteMessage__Group__0__Impl : ( ( rule__DeleteMessage__SourceAssignment_0 ) ) ;
  public final void rule__DeleteMessage__Group__0__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1615:1: ( ( ( rule__DeleteMessage__SourceAssignment_0 ) ) )
      // InternalDsl.g:1616:1: ( ( rule__DeleteMessage__SourceAssignment_0 ) )
      {
        // InternalDsl.g:1616:1: ( ( rule__DeleteMessage__SourceAssignment_0 ) )
        // InternalDsl.g:1617:2: ( rule__DeleteMessage__SourceAssignment_0 )
        {
          before(grammarAccess.getDeleteMessageAccess().getSourceAssignment_0());
          // InternalDsl.g:1618:2: ( rule__DeleteMessage__SourceAssignment_0 )
          // InternalDsl.g:1618:3: rule__DeleteMessage__SourceAssignment_0
          {
            pushFollow(FOLLOW_2);
            rule__DeleteMessage__SourceAssignment_0();

            state._fsp--;

          }

          after(grammarAccess.getDeleteMessageAccess().getSourceAssignment_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__DeleteMessage__Group__0__Impl"

  // $ANTLR start "rule__DeleteMessage__Group__1"
  // InternalDsl.g:1626:1: rule__DeleteMessage__Group__1 : rule__DeleteMessage__Group__1__Impl
  // rule__DeleteMessage__Group__2 ;
  public final void rule__DeleteMessage__Group__1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1630:1: ( rule__DeleteMessage__Group__1__Impl rule__DeleteMessage__Group__2 )
      // InternalDsl.g:1631:2: rule__DeleteMessage__Group__1__Impl rule__DeleteMessage__Group__2
      {
        pushFollow(FOLLOW_7);
        rule__DeleteMessage__Group__1__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__DeleteMessage__Group__2();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__DeleteMessage__Group__1"

  // $ANTLR start "rule__DeleteMessage__Group__1__Impl"
  // InternalDsl.g:1638:1: rule__DeleteMessage__Group__1__Impl : ( '->x' ) ;
  public final void rule__DeleteMessage__Group__1__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1642:1: ( ( '->x' ) )
      // InternalDsl.g:1643:1: ( '->x' )
      {
        // InternalDsl.g:1643:1: ( '->x' )
        // InternalDsl.g:1644:2: '->x'
        {
          before(grammarAccess.getDeleteMessageAccess().getXKeyword_1());
          match(input, 18, FOLLOW_2);
          after(grammarAccess.getDeleteMessageAccess().getXKeyword_1());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__DeleteMessage__Group__1__Impl"

  // $ANTLR start "rule__DeleteMessage__Group__2"
  // InternalDsl.g:1653:1: rule__DeleteMessage__Group__2 : rule__DeleteMessage__Group__2__Impl
  // rule__DeleteMessage__Group__3 ;
  public final void rule__DeleteMessage__Group__2() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1657:1: ( rule__DeleteMessage__Group__2__Impl rule__DeleteMessage__Group__3 )
      // InternalDsl.g:1658:2: rule__DeleteMessage__Group__2__Impl rule__DeleteMessage__Group__3
      {
        pushFollow(FOLLOW_10);
        rule__DeleteMessage__Group__2__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__DeleteMessage__Group__3();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__DeleteMessage__Group__2"

  // $ANTLR start "rule__DeleteMessage__Group__2__Impl"
  // InternalDsl.g:1665:1: rule__DeleteMessage__Group__2__Impl : ( ( rule__DeleteMessage__TargetAssignment_2 ) ) ;
  public final void rule__DeleteMessage__Group__2__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1669:1: ( ( ( rule__DeleteMessage__TargetAssignment_2 ) ) )
      // InternalDsl.g:1670:1: ( ( rule__DeleteMessage__TargetAssignment_2 ) )
      {
        // InternalDsl.g:1670:1: ( ( rule__DeleteMessage__TargetAssignment_2 ) )
        // InternalDsl.g:1671:2: ( rule__DeleteMessage__TargetAssignment_2 )
        {
          before(grammarAccess.getDeleteMessageAccess().getTargetAssignment_2());
          // InternalDsl.g:1672:2: ( rule__DeleteMessage__TargetAssignment_2 )
          // InternalDsl.g:1672:3: rule__DeleteMessage__TargetAssignment_2
          {
            pushFollow(FOLLOW_2);
            rule__DeleteMessage__TargetAssignment_2();

            state._fsp--;

          }

          after(grammarAccess.getDeleteMessageAccess().getTargetAssignment_2());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__DeleteMessage__Group__2__Impl"

  // $ANTLR start "rule__DeleteMessage__Group__3"
  // InternalDsl.g:1680:1: rule__DeleteMessage__Group__3 : rule__DeleteMessage__Group__3__Impl
  // rule__DeleteMessage__Group__4 ;
  public final void rule__DeleteMessage__Group__3() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1684:1: ( rule__DeleteMessage__Group__3__Impl rule__DeleteMessage__Group__4 )
      // InternalDsl.g:1685:2: rule__DeleteMessage__Group__3__Impl rule__DeleteMessage__Group__4
      {
        pushFollow(FOLLOW_7);
        rule__DeleteMessage__Group__3__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__DeleteMessage__Group__4();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__DeleteMessage__Group__3"

  // $ANTLR start "rule__DeleteMessage__Group__3__Impl"
  // InternalDsl.g:1692:1: rule__DeleteMessage__Group__3__Impl : ( ':' ) ;
  public final void rule__DeleteMessage__Group__3__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1696:1: ( ( ':' ) )
      // InternalDsl.g:1697:1: ( ':' )
      {
        // InternalDsl.g:1697:1: ( ':' )
        // InternalDsl.g:1698:2: ':'
        {
          before(grammarAccess.getDeleteMessageAccess().getColonKeyword_3());
          match(input, 16, FOLLOW_2);
          after(grammarAccess.getDeleteMessageAccess().getColonKeyword_3());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__DeleteMessage__Group__3__Impl"

  // $ANTLR start "rule__DeleteMessage__Group__4"
  // InternalDsl.g:1707:1: rule__DeleteMessage__Group__4 : rule__DeleteMessage__Group__4__Impl ;
  public final void rule__DeleteMessage__Group__4() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1711:1: ( rule__DeleteMessage__Group__4__Impl )
      // InternalDsl.g:1712:2: rule__DeleteMessage__Group__4__Impl
      {
        pushFollow(FOLLOW_2);
        rule__DeleteMessage__Group__4__Impl();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__DeleteMessage__Group__4"

  // $ANTLR start "rule__DeleteMessage__Group__4__Impl"
  // InternalDsl.g:1718:1: rule__DeleteMessage__Group__4__Impl : ( ( rule__DeleteMessage__NameAssignment_4 ) ) ;
  public final void rule__DeleteMessage__Group__4__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1722:1: ( ( ( rule__DeleteMessage__NameAssignment_4 ) ) )
      // InternalDsl.g:1723:1: ( ( rule__DeleteMessage__NameAssignment_4 ) )
      {
        // InternalDsl.g:1723:1: ( ( rule__DeleteMessage__NameAssignment_4 ) )
        // InternalDsl.g:1724:2: ( rule__DeleteMessage__NameAssignment_4 )
        {
          before(grammarAccess.getDeleteMessageAccess().getNameAssignment_4());
          // InternalDsl.g:1725:2: ( rule__DeleteMessage__NameAssignment_4 )
          // InternalDsl.g:1725:3: rule__DeleteMessage__NameAssignment_4
          {
            pushFollow(FOLLOW_2);
            rule__DeleteMessage__NameAssignment_4();

            state._fsp--;

          }

          after(grammarAccess.getDeleteMessageAccess().getNameAssignment_4());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__DeleteMessage__Group__4__Impl"

  // $ANTLR start "rule__ReturnMessage__Group__0"
  // InternalDsl.g:1734:1: rule__ReturnMessage__Group__0 : rule__ReturnMessage__Group__0__Impl
  // rule__ReturnMessage__Group__1 ;
  public final void rule__ReturnMessage__Group__0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1738:1: ( rule__ReturnMessage__Group__0__Impl rule__ReturnMessage__Group__1 )
      // InternalDsl.g:1739:2: rule__ReturnMessage__Group__0__Impl rule__ReturnMessage__Group__1
      {
        pushFollow(FOLLOW_13);
        rule__ReturnMessage__Group__0__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__ReturnMessage__Group__1();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ReturnMessage__Group__0"

  // $ANTLR start "rule__ReturnMessage__Group__0__Impl"
  // InternalDsl.g:1746:1: rule__ReturnMessage__Group__0__Impl : ( ( rule__ReturnMessage__TargetAssignment_0 ) ) ;
  public final void rule__ReturnMessage__Group__0__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1750:1: ( ( ( rule__ReturnMessage__TargetAssignment_0 ) ) )
      // InternalDsl.g:1751:1: ( ( rule__ReturnMessage__TargetAssignment_0 ) )
      {
        // InternalDsl.g:1751:1: ( ( rule__ReturnMessage__TargetAssignment_0 ) )
        // InternalDsl.g:1752:2: ( rule__ReturnMessage__TargetAssignment_0 )
        {
          before(grammarAccess.getReturnMessageAccess().getTargetAssignment_0());
          // InternalDsl.g:1753:2: ( rule__ReturnMessage__TargetAssignment_0 )
          // InternalDsl.g:1753:3: rule__ReturnMessage__TargetAssignment_0
          {
            pushFollow(FOLLOW_2);
            rule__ReturnMessage__TargetAssignment_0();

            state._fsp--;

          }

          after(grammarAccess.getReturnMessageAccess().getTargetAssignment_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ReturnMessage__Group__0__Impl"

  // $ANTLR start "rule__ReturnMessage__Group__1"
  // InternalDsl.g:1761:1: rule__ReturnMessage__Group__1 : rule__ReturnMessage__Group__1__Impl
  // rule__ReturnMessage__Group__2 ;
  public final void rule__ReturnMessage__Group__1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1765:1: ( rule__ReturnMessage__Group__1__Impl rule__ReturnMessage__Group__2 )
      // InternalDsl.g:1766:2: rule__ReturnMessage__Group__1__Impl rule__ReturnMessage__Group__2
      {
        pushFollow(FOLLOW_7);
        rule__ReturnMessage__Group__1__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__ReturnMessage__Group__2();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ReturnMessage__Group__1"

  // $ANTLR start "rule__ReturnMessage__Group__1__Impl"
  // InternalDsl.g:1773:1: rule__ReturnMessage__Group__1__Impl : ( '<--' ) ;
  public final void rule__ReturnMessage__Group__1__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1777:1: ( ( '<--' ) )
      // InternalDsl.g:1778:1: ( '<--' )
      {
        // InternalDsl.g:1778:1: ( '<--' )
        // InternalDsl.g:1779:2: '<--'
        {
          before(grammarAccess.getReturnMessageAccess().getLessThanSignHyphenMinusHyphenMinusKeyword_1());
          match(input, 19, FOLLOW_2);
          after(grammarAccess.getReturnMessageAccess().getLessThanSignHyphenMinusHyphenMinusKeyword_1());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ReturnMessage__Group__1__Impl"

  // $ANTLR start "rule__ReturnMessage__Group__2"
  // InternalDsl.g:1788:1: rule__ReturnMessage__Group__2 : rule__ReturnMessage__Group__2__Impl
  // rule__ReturnMessage__Group__3 ;
  public final void rule__ReturnMessage__Group__2() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1792:1: ( rule__ReturnMessage__Group__2__Impl rule__ReturnMessage__Group__3 )
      // InternalDsl.g:1793:2: rule__ReturnMessage__Group__2__Impl rule__ReturnMessage__Group__3
      {
        pushFollow(FOLLOW_10);
        rule__ReturnMessage__Group__2__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__ReturnMessage__Group__3();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ReturnMessage__Group__2"

  // $ANTLR start "rule__ReturnMessage__Group__2__Impl"
  // InternalDsl.g:1800:1: rule__ReturnMessage__Group__2__Impl : ( ( rule__ReturnMessage__SourceAssignment_2 ) ) ;
  public final void rule__ReturnMessage__Group__2__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1804:1: ( ( ( rule__ReturnMessage__SourceAssignment_2 ) ) )
      // InternalDsl.g:1805:1: ( ( rule__ReturnMessage__SourceAssignment_2 ) )
      {
        // InternalDsl.g:1805:1: ( ( rule__ReturnMessage__SourceAssignment_2 ) )
        // InternalDsl.g:1806:2: ( rule__ReturnMessage__SourceAssignment_2 )
        {
          before(grammarAccess.getReturnMessageAccess().getSourceAssignment_2());
          // InternalDsl.g:1807:2: ( rule__ReturnMessage__SourceAssignment_2 )
          // InternalDsl.g:1807:3: rule__ReturnMessage__SourceAssignment_2
          {
            pushFollow(FOLLOW_2);
            rule__ReturnMessage__SourceAssignment_2();

            state._fsp--;

          }

          after(grammarAccess.getReturnMessageAccess().getSourceAssignment_2());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ReturnMessage__Group__2__Impl"

  // $ANTLR start "rule__ReturnMessage__Group__3"
  // InternalDsl.g:1815:1: rule__ReturnMessage__Group__3 : rule__ReturnMessage__Group__3__Impl
  // rule__ReturnMessage__Group__4 ;
  public final void rule__ReturnMessage__Group__3() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1819:1: ( rule__ReturnMessage__Group__3__Impl rule__ReturnMessage__Group__4 )
      // InternalDsl.g:1820:2: rule__ReturnMessage__Group__3__Impl rule__ReturnMessage__Group__4
      {
        pushFollow(FOLLOW_7);
        rule__ReturnMessage__Group__3__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__ReturnMessage__Group__4();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ReturnMessage__Group__3"

  // $ANTLR start "rule__ReturnMessage__Group__3__Impl"
  // InternalDsl.g:1827:1: rule__ReturnMessage__Group__3__Impl : ( ':' ) ;
  public final void rule__ReturnMessage__Group__3__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1831:1: ( ( ':' ) )
      // InternalDsl.g:1832:1: ( ':' )
      {
        // InternalDsl.g:1832:1: ( ':' )
        // InternalDsl.g:1833:2: ':'
        {
          before(grammarAccess.getReturnMessageAccess().getColonKeyword_3());
          match(input, 16, FOLLOW_2);
          after(grammarAccess.getReturnMessageAccess().getColonKeyword_3());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ReturnMessage__Group__3__Impl"

  // $ANTLR start "rule__ReturnMessage__Group__4"
  // InternalDsl.g:1842:1: rule__ReturnMessage__Group__4 : rule__ReturnMessage__Group__4__Impl ;
  public final void rule__ReturnMessage__Group__4() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1846:1: ( rule__ReturnMessage__Group__4__Impl )
      // InternalDsl.g:1847:2: rule__ReturnMessage__Group__4__Impl
      {
        pushFollow(FOLLOW_2);
        rule__ReturnMessage__Group__4__Impl();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ReturnMessage__Group__4"

  // $ANTLR start "rule__ReturnMessage__Group__4__Impl"
  // InternalDsl.g:1853:1: rule__ReturnMessage__Group__4__Impl : ( ( rule__ReturnMessage__NameAssignment_4 ) ) ;
  public final void rule__ReturnMessage__Group__4__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1857:1: ( ( ( rule__ReturnMessage__NameAssignment_4 ) ) )
      // InternalDsl.g:1858:1: ( ( rule__ReturnMessage__NameAssignment_4 ) )
      {
        // InternalDsl.g:1858:1: ( ( rule__ReturnMessage__NameAssignment_4 ) )
        // InternalDsl.g:1859:2: ( rule__ReturnMessage__NameAssignment_4 )
        {
          before(grammarAccess.getReturnMessageAccess().getNameAssignment_4());
          // InternalDsl.g:1860:2: ( rule__ReturnMessage__NameAssignment_4 )
          // InternalDsl.g:1860:3: rule__ReturnMessage__NameAssignment_4
          {
            pushFollow(FOLLOW_2);
            rule__ReturnMessage__NameAssignment_4();

            state._fsp--;

          }

          after(grammarAccess.getReturnMessageAccess().getNameAssignment_4());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ReturnMessage__Group__4__Impl"

  // $ANTLR start "rule__ArmTimerMessage__Group__0"
  // InternalDsl.g:1869:1: rule__ArmTimerMessage__Group__0 : rule__ArmTimerMessage__Group__0__Impl
  // rule__ArmTimerMessage__Group__1 ;
  public final void rule__ArmTimerMessage__Group__0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1873:1: ( rule__ArmTimerMessage__Group__0__Impl rule__ArmTimerMessage__Group__1 )
      // InternalDsl.g:1874:2: rule__ArmTimerMessage__Group__0__Impl rule__ArmTimerMessage__Group__1
      {
        pushFollow(FOLLOW_7);
        rule__ArmTimerMessage__Group__0__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__ArmTimerMessage__Group__1();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ArmTimerMessage__Group__0"

  // $ANTLR start "rule__ArmTimerMessage__Group__0__Impl"
  // InternalDsl.g:1881:1: rule__ArmTimerMessage__Group__0__Impl : ( '->>' ) ;
  public final void rule__ArmTimerMessage__Group__0__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1885:1: ( ( '->>' ) )
      // InternalDsl.g:1886:1: ( '->>' )
      {
        // InternalDsl.g:1886:1: ( '->>' )
        // InternalDsl.g:1887:2: '->>'
        {
          before(grammarAccess.getArmTimerMessageAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_0());
          match(input, 20, FOLLOW_2);
          after(grammarAccess.getArmTimerMessageAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ArmTimerMessage__Group__0__Impl"

  // $ANTLR start "rule__ArmTimerMessage__Group__1"
  // InternalDsl.g:1896:1: rule__ArmTimerMessage__Group__1 : rule__ArmTimerMessage__Group__1__Impl
  // rule__ArmTimerMessage__Group__2 ;
  public final void rule__ArmTimerMessage__Group__1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1900:1: ( rule__ArmTimerMessage__Group__1__Impl rule__ArmTimerMessage__Group__2 )
      // InternalDsl.g:1901:2: rule__ArmTimerMessage__Group__1__Impl rule__ArmTimerMessage__Group__2
      {
        pushFollow(FOLLOW_10);
        rule__ArmTimerMessage__Group__1__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__ArmTimerMessage__Group__2();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ArmTimerMessage__Group__1"

  // $ANTLR start "rule__ArmTimerMessage__Group__1__Impl"
  // InternalDsl.g:1908:1: rule__ArmTimerMessage__Group__1__Impl : ( ( rule__ArmTimerMessage__ParticipantAssignment_1 )
  // ) ;
  public final void rule__ArmTimerMessage__Group__1__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1912:1: ( ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) ) )
      // InternalDsl.g:1913:1: ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) )
      {
        // InternalDsl.g:1913:1: ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) )
        // InternalDsl.g:1914:2: ( rule__ArmTimerMessage__ParticipantAssignment_1 )
        {
          before(grammarAccess.getArmTimerMessageAccess().getParticipantAssignment_1());
          // InternalDsl.g:1915:2: ( rule__ArmTimerMessage__ParticipantAssignment_1 )
          // InternalDsl.g:1915:3: rule__ArmTimerMessage__ParticipantAssignment_1
          {
            pushFollow(FOLLOW_2);
            rule__ArmTimerMessage__ParticipantAssignment_1();

            state._fsp--;

          }

          after(grammarAccess.getArmTimerMessageAccess().getParticipantAssignment_1());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ArmTimerMessage__Group__1__Impl"

  // $ANTLR start "rule__ArmTimerMessage__Group__2"
  // InternalDsl.g:1923:1: rule__ArmTimerMessage__Group__2 : rule__ArmTimerMessage__Group__2__Impl
  // rule__ArmTimerMessage__Group__3 ;
  public final void rule__ArmTimerMessage__Group__2() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1927:1: ( rule__ArmTimerMessage__Group__2__Impl rule__ArmTimerMessage__Group__3 )
      // InternalDsl.g:1928:2: rule__ArmTimerMessage__Group__2__Impl rule__ArmTimerMessage__Group__3
      {
        pushFollow(FOLLOW_7);
        rule__ArmTimerMessage__Group__2__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__ArmTimerMessage__Group__3();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ArmTimerMessage__Group__2"

  // $ANTLR start "rule__ArmTimerMessage__Group__2__Impl"
  // InternalDsl.g:1935:1: rule__ArmTimerMessage__Group__2__Impl : ( ':' ) ;
  public final void rule__ArmTimerMessage__Group__2__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1939:1: ( ( ':' ) )
      // InternalDsl.g:1940:1: ( ':' )
      {
        // InternalDsl.g:1940:1: ( ':' )
        // InternalDsl.g:1941:2: ':'
        {
          before(grammarAccess.getArmTimerMessageAccess().getColonKeyword_2());
          match(input, 16, FOLLOW_2);
          after(grammarAccess.getArmTimerMessageAccess().getColonKeyword_2());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ArmTimerMessage__Group__2__Impl"

  // $ANTLR start "rule__ArmTimerMessage__Group__3"
  // InternalDsl.g:1950:1: rule__ArmTimerMessage__Group__3 : rule__ArmTimerMessage__Group__3__Impl ;
  public final void rule__ArmTimerMessage__Group__3() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1954:1: ( rule__ArmTimerMessage__Group__3__Impl )
      // InternalDsl.g:1955:2: rule__ArmTimerMessage__Group__3__Impl
      {
        pushFollow(FOLLOW_2);
        rule__ArmTimerMessage__Group__3__Impl();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ArmTimerMessage__Group__3"

  // $ANTLR start "rule__ArmTimerMessage__Group__3__Impl"
  // InternalDsl.g:1961:1: rule__ArmTimerMessage__Group__3__Impl : ( ( rule__ArmTimerMessage__NameAssignment_3 ) ) ;
  public final void rule__ArmTimerMessage__Group__3__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1965:1: ( ( ( rule__ArmTimerMessage__NameAssignment_3 ) ) )
      // InternalDsl.g:1966:1: ( ( rule__ArmTimerMessage__NameAssignment_3 ) )
      {
        // InternalDsl.g:1966:1: ( ( rule__ArmTimerMessage__NameAssignment_3 ) )
        // InternalDsl.g:1967:2: ( rule__ArmTimerMessage__NameAssignment_3 )
        {
          before(grammarAccess.getArmTimerMessageAccess().getNameAssignment_3());
          // InternalDsl.g:1968:2: ( rule__ArmTimerMessage__NameAssignment_3 )
          // InternalDsl.g:1968:3: rule__ArmTimerMessage__NameAssignment_3
          {
            pushFollow(FOLLOW_2);
            rule__ArmTimerMessage__NameAssignment_3();

            state._fsp--;

          }

          after(grammarAccess.getArmTimerMessageAccess().getNameAssignment_3());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ArmTimerMessage__Group__3__Impl"

  // $ANTLR start "rule__ParticipantDeactivation__Group__0"
  // InternalDsl.g:1977:1: rule__ParticipantDeactivation__Group__0 : rule__ParticipantDeactivation__Group__0__Impl
  // rule__ParticipantDeactivation__Group__1 ;
  public final void rule__ParticipantDeactivation__Group__0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1981:1: ( rule__ParticipantDeactivation__Group__0__Impl rule__ParticipantDeactivation__Group__1 )
      // InternalDsl.g:1982:2: rule__ParticipantDeactivation__Group__0__Impl rule__ParticipantDeactivation__Group__1
      {
        pushFollow(FOLLOW_7);
        rule__ParticipantDeactivation__Group__0__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__ParticipantDeactivation__Group__1();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ParticipantDeactivation__Group__0"

  // $ANTLR start "rule__ParticipantDeactivation__Group__0__Impl"
  // InternalDsl.g:1989:1: rule__ParticipantDeactivation__Group__0__Impl : ( (
  // rule__ParticipantDeactivation__KeywordAssignment_0 ) ) ;
  public final void rule__ParticipantDeactivation__Group__0__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:1993:1: ( ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) ) )
      // InternalDsl.g:1994:1: ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) )
      {
        // InternalDsl.g:1994:1: ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) )
        // InternalDsl.g:1995:2: ( rule__ParticipantDeactivation__KeywordAssignment_0 )
        {
          before(grammarAccess.getParticipantDeactivationAccess().getKeywordAssignment_0());
          // InternalDsl.g:1996:2: ( rule__ParticipantDeactivation__KeywordAssignment_0 )
          // InternalDsl.g:1996:3: rule__ParticipantDeactivation__KeywordAssignment_0
          {
            pushFollow(FOLLOW_2);
            rule__ParticipantDeactivation__KeywordAssignment_0();

            state._fsp--;

          }

          after(grammarAccess.getParticipantDeactivationAccess().getKeywordAssignment_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ParticipantDeactivation__Group__0__Impl"

  // $ANTLR start "rule__ParticipantDeactivation__Group__1"
  // InternalDsl.g:2004:1: rule__ParticipantDeactivation__Group__1 : rule__ParticipantDeactivation__Group__1__Impl ;
  public final void rule__ParticipantDeactivation__Group__1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2008:1: ( rule__ParticipantDeactivation__Group__1__Impl )
      // InternalDsl.g:2009:2: rule__ParticipantDeactivation__Group__1__Impl
      {
        pushFollow(FOLLOW_2);
        rule__ParticipantDeactivation__Group__1__Impl();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ParticipantDeactivation__Group__1"

  // $ANTLR start "rule__ParticipantDeactivation__Group__1__Impl"
  // InternalDsl.g:2015:1: rule__ParticipantDeactivation__Group__1__Impl : ( (
  // rule__ParticipantDeactivation__NameAssignment_1 ) ) ;
  public final void rule__ParticipantDeactivation__Group__1__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2019:1: ( ( ( rule__ParticipantDeactivation__NameAssignment_1 ) ) )
      // InternalDsl.g:2020:1: ( ( rule__ParticipantDeactivation__NameAssignment_1 ) )
      {
        // InternalDsl.g:2020:1: ( ( rule__ParticipantDeactivation__NameAssignment_1 ) )
        // InternalDsl.g:2021:2: ( rule__ParticipantDeactivation__NameAssignment_1 )
        {
          before(grammarAccess.getParticipantDeactivationAccess().getNameAssignment_1());
          // InternalDsl.g:2022:2: ( rule__ParticipantDeactivation__NameAssignment_1 )
          // InternalDsl.g:2022:3: rule__ParticipantDeactivation__NameAssignment_1
          {
            pushFollow(FOLLOW_2);
            rule__ParticipantDeactivation__NameAssignment_1();

            state._fsp--;

          }

          after(grammarAccess.getParticipantDeactivationAccess().getNameAssignment_1());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ParticipantDeactivation__Group__1__Impl"

  // $ANTLR start "rule__Reference__Group__0"
  // InternalDsl.g:2031:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
  public final void rule__Reference__Group__0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2035:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
      // InternalDsl.g:2036:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
      {
        pushFollow(FOLLOW_14);
        rule__Reference__Group__0__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__Reference__Group__1();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Reference__Group__0"

  // $ANTLR start "rule__Reference__Group__0__Impl"
  // InternalDsl.g:2043:1: rule__Reference__Group__0__Impl : ( ( rule__Reference__KeywordAssignment_0 ) ) ;
  public final void rule__Reference__Group__0__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2047:1: ( ( ( rule__Reference__KeywordAssignment_0 ) ) )
      // InternalDsl.g:2048:1: ( ( rule__Reference__KeywordAssignment_0 ) )
      {
        // InternalDsl.g:2048:1: ( ( rule__Reference__KeywordAssignment_0 ) )
        // InternalDsl.g:2049:2: ( rule__Reference__KeywordAssignment_0 )
        {
          before(grammarAccess.getReferenceAccess().getKeywordAssignment_0());
          // InternalDsl.g:2050:2: ( rule__Reference__KeywordAssignment_0 )
          // InternalDsl.g:2050:3: rule__Reference__KeywordAssignment_0
          {
            pushFollow(FOLLOW_2);
            rule__Reference__KeywordAssignment_0();

            state._fsp--;

          }

          after(grammarAccess.getReferenceAccess().getKeywordAssignment_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Reference__Group__0__Impl"

  // $ANTLR start "rule__Reference__Group__1"
  // InternalDsl.g:2058:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl rule__Reference__Group__2 ;
  public final void rule__Reference__Group__1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2062:1: ( rule__Reference__Group__1__Impl rule__Reference__Group__2 )
      // InternalDsl.g:2063:2: rule__Reference__Group__1__Impl rule__Reference__Group__2
      {
        pushFollow(FOLLOW_7);
        rule__Reference__Group__1__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__Reference__Group__2();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Reference__Group__1"

  // $ANTLR start "rule__Reference__Group__1__Impl"
  // InternalDsl.g:2070:1: rule__Reference__Group__1__Impl : ( 'over' ) ;
  public final void rule__Reference__Group__1__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2074:1: ( ( 'over' ) )
      // InternalDsl.g:2075:1: ( 'over' )
      {
        // InternalDsl.g:2075:1: ( 'over' )
        // InternalDsl.g:2076:2: 'over'
        {
          before(grammarAccess.getReferenceAccess().getOverKeyword_1());
          match(input, 21, FOLLOW_2);
          after(grammarAccess.getReferenceAccess().getOverKeyword_1());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Reference__Group__1__Impl"

  // $ANTLR start "rule__Reference__Group__2"
  // InternalDsl.g:2085:1: rule__Reference__Group__2 : rule__Reference__Group__2__Impl rule__Reference__Group__3 ;
  public final void rule__Reference__Group__2() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2089:1: ( rule__Reference__Group__2__Impl rule__Reference__Group__3 )
      // InternalDsl.g:2090:2: rule__Reference__Group__2__Impl rule__Reference__Group__3
      {
        pushFollow(FOLLOW_7);
        rule__Reference__Group__2__Impl();

        state._fsp--;

        pushFollow(FOLLOW_2);
        rule__Reference__Group__3();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Reference__Group__2"

  // $ANTLR start "rule__Reference__Group__2__Impl"
  // InternalDsl.g:2097:1: rule__Reference__Group__2__Impl : ( ( ( rule__Reference__TimelinesAssignment_2 ) ) ( (
  // rule__Reference__TimelinesAssignment_2 )* ) ) ;
  public final void rule__Reference__Group__2__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2101:1: ( ( ( ( rule__Reference__TimelinesAssignment_2 ) ) ( (
      // rule__Reference__TimelinesAssignment_2 )* ) ) )
      // InternalDsl.g:2102:1: ( ( ( rule__Reference__TimelinesAssignment_2 ) ) ( (
      // rule__Reference__TimelinesAssignment_2 )* ) )
      {
        // InternalDsl.g:2102:1: ( ( ( rule__Reference__TimelinesAssignment_2 ) ) ( (
        // rule__Reference__TimelinesAssignment_2 )* ) )
        // InternalDsl.g:2103:2: ( ( rule__Reference__TimelinesAssignment_2 ) ) ( (
        // rule__Reference__TimelinesAssignment_2 )* )
        {
          // InternalDsl.g:2103:2: ( ( rule__Reference__TimelinesAssignment_2 ) )
          // InternalDsl.g:2104:3: ( rule__Reference__TimelinesAssignment_2 )
          {
            before(grammarAccess.getReferenceAccess().getTimelinesAssignment_2());
            // InternalDsl.g:2105:3: ( rule__Reference__TimelinesAssignment_2 )
            // InternalDsl.g:2105:4: rule__Reference__TimelinesAssignment_2
            {
              pushFollow(FOLLOW_15);
              rule__Reference__TimelinesAssignment_2();

              state._fsp--;

            }

            after(grammarAccess.getReferenceAccess().getTimelinesAssignment_2());

          }

          // InternalDsl.g:2108:2: ( ( rule__Reference__TimelinesAssignment_2 )* )
          // InternalDsl.g:2109:3: ( rule__Reference__TimelinesAssignment_2 )*
          {
            before(grammarAccess.getReferenceAccess().getTimelinesAssignment_2());
            // InternalDsl.g:2110:3: ( rule__Reference__TimelinesAssignment_2 )*
            loop12: do {
              int alt12 = 2;
              int LA12_0 = input.LA(1);

              if ((LA12_0 == RULE_STRING)) {
                int LA12_1 = input.LA(2);

                if ((LA12_1 == RULE_STRING)) {
                  int LA12_3 = input.LA(3);

                  if ((LA12_3 == EOF || LA12_3 == RULE_STRING || LA12_3 == 20 || LA12_3 == 23
                      || (LA12_3 >= 31 && LA12_3 <= 32))) {
                    alt12 = 1;
                  }

                }

              }

              switch (alt12) {
              case 1:
              // InternalDsl.g:2110:4: rule__Reference__TimelinesAssignment_2
              {
                pushFollow(FOLLOW_15);
                rule__Reference__TimelinesAssignment_2();

                state._fsp--;

              }
                break;

              default:
                break loop12;
              }
            } while (true);

            after(grammarAccess.getReferenceAccess().getTimelinesAssignment_2());

          }

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Reference__Group__2__Impl"

  // $ANTLR start "rule__Reference__Group__3"
  // InternalDsl.g:2119:1: rule__Reference__Group__3 : rule__Reference__Group__3__Impl ;
  public final void rule__Reference__Group__3() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2123:1: ( rule__Reference__Group__3__Impl )
      // InternalDsl.g:2124:2: rule__Reference__Group__3__Impl
      {
        pushFollow(FOLLOW_2);
        rule__Reference__Group__3__Impl();

        state._fsp--;

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Reference__Group__3"

  // $ANTLR start "rule__Reference__Group__3__Impl"
  // InternalDsl.g:2130:1: rule__Reference__Group__3__Impl : ( ( rule__Reference__NameAssignment_3 ) ) ;
  public final void rule__Reference__Group__3__Impl() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2134:1: ( ( ( rule__Reference__NameAssignment_3 ) ) )
      // InternalDsl.g:2135:1: ( ( rule__Reference__NameAssignment_3 ) )
      {
        // InternalDsl.g:2135:1: ( ( rule__Reference__NameAssignment_3 ) )
        // InternalDsl.g:2136:2: ( rule__Reference__NameAssignment_3 )
        {
          before(grammarAccess.getReferenceAccess().getNameAssignment_3());
          // InternalDsl.g:2137:2: ( rule__Reference__NameAssignment_3 )
          // InternalDsl.g:2137:3: rule__Reference__NameAssignment_3
          {
            pushFollow(FOLLOW_2);
            rule__Reference__NameAssignment_3();

            state._fsp--;

          }

          after(grammarAccess.getReferenceAccess().getNameAssignment_3());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Reference__Group__3__Impl"

  // $ANTLR start "rule__Model__BeginAssignment_1"
  // InternalDsl.g:2146:1: rule__Model__BeginAssignment_1 : ( ( '{' ) ) ;
  public final void rule__Model__BeginAssignment_1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2150:1: ( ( ( '{' ) ) )
      // InternalDsl.g:2151:2: ( ( '{' ) )
      {
        // InternalDsl.g:2151:2: ( ( '{' ) )
        // InternalDsl.g:2152:3: ( '{' )
        {
          before(grammarAccess.getModelAccess().getBeginLeftCurlyBracketKeyword_1_0());
          // InternalDsl.g:2153:3: ( '{' )
          // InternalDsl.g:2154:4: '{'
          {
            before(grammarAccess.getModelAccess().getBeginLeftCurlyBracketKeyword_1_0());
            match(input, 22, FOLLOW_2);
            after(grammarAccess.getModelAccess().getBeginLeftCurlyBracketKeyword_1_0());

          }

          after(grammarAccess.getModelAccess().getBeginLeftCurlyBracketKeyword_1_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Model__BeginAssignment_1"

  // $ANTLR start "rule__Model__ParticipantsAssignment_2"
  // InternalDsl.g:2165:1: rule__Model__ParticipantsAssignment_2 : ( ruleParticipant ) ;
  public final void rule__Model__ParticipantsAssignment_2() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2169:1: ( ( ruleParticipant ) )
      // InternalDsl.g:2170:2: ( ruleParticipant )
      {
        // InternalDsl.g:2170:2: ( ruleParticipant )
        // InternalDsl.g:2171:3: ruleParticipant
        {
          before(grammarAccess.getModelAccess().getParticipantsParticipantParserRuleCall_2_0());
          pushFollow(FOLLOW_2);
          ruleParticipant();

          state._fsp--;

          after(grammarAccess.getModelAccess().getParticipantsParticipantParserRuleCall_2_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Model__ParticipantsAssignment_2"

  // $ANTLR start "rule__Model__MessagesOrReferencesAssignment_3"
  // InternalDsl.g:2180:1: rule__Model__MessagesOrReferencesAssignment_3 : ( (
  // rule__Model__MessagesOrReferencesAlternatives_3_0 ) ) ;
  public final void rule__Model__MessagesOrReferencesAssignment_3() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2184:1: ( ( ( rule__Model__MessagesOrReferencesAlternatives_3_0 ) ) )
      // InternalDsl.g:2185:2: ( ( rule__Model__MessagesOrReferencesAlternatives_3_0 ) )
      {
        // InternalDsl.g:2185:2: ( ( rule__Model__MessagesOrReferencesAlternatives_3_0 ) )
        // InternalDsl.g:2186:3: ( rule__Model__MessagesOrReferencesAlternatives_3_0 )
        {
          before(grammarAccess.getModelAccess().getMessagesOrReferencesAlternatives_3_0());
          // InternalDsl.g:2187:3: ( rule__Model__MessagesOrReferencesAlternatives_3_0 )
          // InternalDsl.g:2187:4: rule__Model__MessagesOrReferencesAlternatives_3_0
          {
            pushFollow(FOLLOW_2);
            rule__Model__MessagesOrReferencesAlternatives_3_0();

            state._fsp--;

          }

          after(grammarAccess.getModelAccess().getMessagesOrReferencesAlternatives_3_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Model__MessagesOrReferencesAssignment_3"

  // $ANTLR start "rule__Model__EndAssignment_4"
  // InternalDsl.g:2195:1: rule__Model__EndAssignment_4 : ( ( '}' ) ) ;
  public final void rule__Model__EndAssignment_4() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2199:1: ( ( ( '}' ) ) )
      // InternalDsl.g:2200:2: ( ( '}' ) )
      {
        // InternalDsl.g:2200:2: ( ( '}' ) )
        // InternalDsl.g:2201:3: ( '}' )
        {
          before(grammarAccess.getModelAccess().getEndRightCurlyBracketKeyword_4_0());
          // InternalDsl.g:2202:3: ( '}' )
          // InternalDsl.g:2203:4: '}'
          {
            before(grammarAccess.getModelAccess().getEndRightCurlyBracketKeyword_4_0());
            match(input, 23, FOLLOW_2);
            after(grammarAccess.getModelAccess().getEndRightCurlyBracketKeyword_4_0());

          }

          after(grammarAccess.getModelAccess().getEndRightCurlyBracketKeyword_4_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Model__EndAssignment_4"

  // $ANTLR start "rule__Actor__KeywordAssignment_0"
  // InternalDsl.g:2214:1: rule__Actor__KeywordAssignment_0 : ( ( 'actor' ) ) ;
  public final void rule__Actor__KeywordAssignment_0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2218:1: ( ( ( 'actor' ) ) )
      // InternalDsl.g:2219:2: ( ( 'actor' ) )
      {
        // InternalDsl.g:2219:2: ( ( 'actor' ) )
        // InternalDsl.g:2220:3: ( 'actor' )
        {
          before(grammarAccess.getActorAccess().getKeywordActorKeyword_0_0());
          // InternalDsl.g:2221:3: ( 'actor' )
          // InternalDsl.g:2222:4: 'actor'
          {
            before(grammarAccess.getActorAccess().getKeywordActorKeyword_0_0());
            match(input, 24, FOLLOW_2);
            after(grammarAccess.getActorAccess().getKeywordActorKeyword_0_0());

          }

          after(grammarAccess.getActorAccess().getKeywordActorKeyword_0_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Actor__KeywordAssignment_0"

  // $ANTLR start "rule__Actor__NameAssignment_1"
  // InternalDsl.g:2233:1: rule__Actor__NameAssignment_1 : ( RULE_STRING ) ;
  public final void rule__Actor__NameAssignment_1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2237:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2238:2: ( RULE_STRING )
      {
        // InternalDsl.g:2238:2: ( RULE_STRING )
        // InternalDsl.g:2239:3: RULE_STRING
        {
          before(grammarAccess.getActorAccess().getNameSTRINGTerminalRuleCall_1_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getActorAccess().getNameSTRINGTerminalRuleCall_1_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Actor__NameAssignment_1"

  // $ANTLR start "rule__Component__KeywordAssignment_0"
  // InternalDsl.g:2248:1: rule__Component__KeywordAssignment_0 : ( ( 'component' ) ) ;
  public final void rule__Component__KeywordAssignment_0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2252:1: ( ( ( 'component' ) ) )
      // InternalDsl.g:2253:2: ( ( 'component' ) )
      {
        // InternalDsl.g:2253:2: ( ( 'component' ) )
        // InternalDsl.g:2254:3: ( 'component' )
        {
          before(grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0());
          // InternalDsl.g:2255:3: ( 'component' )
          // InternalDsl.g:2256:4: 'component'
          {
            before(grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0());
            match(input, 25, FOLLOW_2);
            after(grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0());

          }

          after(grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Component__KeywordAssignment_0"

  // $ANTLR start "rule__Component__NameAssignment_1"
  // InternalDsl.g:2267:1: rule__Component__NameAssignment_1 : ( RULE_STRING ) ;
  public final void rule__Component__NameAssignment_1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2271:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2272:2: ( RULE_STRING )
      {
        // InternalDsl.g:2272:2: ( RULE_STRING )
        // InternalDsl.g:2273:3: RULE_STRING
        {
          before(grammarAccess.getComponentAccess().getNameSTRINGTerminalRuleCall_1_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getComponentAccess().getNameSTRINGTerminalRuleCall_1_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Component__NameAssignment_1"

  // $ANTLR start "rule__Component__NatureAssignment_2"
  // InternalDsl.g:2282:1: rule__Component__NatureAssignment_2 : ( ( rule__Component__NatureAlternatives_2_0 ) ) ;
  public final void rule__Component__NatureAssignment_2() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2286:1: ( ( ( rule__Component__NatureAlternatives_2_0 ) ) )
      // InternalDsl.g:2287:2: ( ( rule__Component__NatureAlternatives_2_0 ) )
      {
        // InternalDsl.g:2287:2: ( ( rule__Component__NatureAlternatives_2_0 ) )
        // InternalDsl.g:2288:3: ( rule__Component__NatureAlternatives_2_0 )
        {
          before(grammarAccess.getComponentAccess().getNatureAlternatives_2_0());
          // InternalDsl.g:2289:3: ( rule__Component__NatureAlternatives_2_0 )
          // InternalDsl.g:2289:4: rule__Component__NatureAlternatives_2_0
          {
            pushFollow(FOLLOW_2);
            rule__Component__NatureAlternatives_2_0();

            state._fsp--;

          }

          after(grammarAccess.getComponentAccess().getNatureAlternatives_2_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Component__NatureAssignment_2"

  // $ANTLR start "rule__ConfigurationItem__KeywordAssignment_0"
  // InternalDsl.g:2297:1: rule__ConfigurationItem__KeywordAssignment_0 : ( ( 'configuration_item' ) ) ;
  public final void rule__ConfigurationItem__KeywordAssignment_0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2301:1: ( ( ( 'configuration_item' ) ) )
      // InternalDsl.g:2302:2: ( ( 'configuration_item' ) )
      {
        // InternalDsl.g:2302:2: ( ( 'configuration_item' ) )
        // InternalDsl.g:2303:3: ( 'configuration_item' )
        {
          before(grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0());
          // InternalDsl.g:2304:3: ( 'configuration_item' )
          // InternalDsl.g:2305:4: 'configuration_item'
          {
            before(grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0());
            match(input, 26, FOLLOW_2);
            after(grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0());

          }

          after(grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ConfigurationItem__KeywordAssignment_0"

  // $ANTLR start "rule__ConfigurationItem__NameAssignment_1"
  // InternalDsl.g:2316:1: rule__ConfigurationItem__NameAssignment_1 : ( RULE_STRING ) ;
  public final void rule__ConfigurationItem__NameAssignment_1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2320:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2321:2: ( RULE_STRING )
      {
        // InternalDsl.g:2321:2: ( RULE_STRING )
        // InternalDsl.g:2322:3: RULE_STRING
        {
          before(grammarAccess.getConfigurationItemAccess().getNameSTRINGTerminalRuleCall_1_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getConfigurationItemAccess().getNameSTRINGTerminalRuleCall_1_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ConfigurationItem__NameAssignment_1"

  // $ANTLR start "rule__Function__KeywordAssignment_0"
  // InternalDsl.g:2331:1: rule__Function__KeywordAssignment_0 : ( ( 'function' ) ) ;
  public final void rule__Function__KeywordAssignment_0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2335:1: ( ( ( 'function' ) ) )
      // InternalDsl.g:2336:2: ( ( 'function' ) )
      {
        // InternalDsl.g:2336:2: ( ( 'function' ) )
        // InternalDsl.g:2337:3: ( 'function' )
        {
          before(grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0());
          // InternalDsl.g:2338:3: ( 'function' )
          // InternalDsl.g:2339:4: 'function'
          {
            before(grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0());
            match(input, 27, FOLLOW_2);
            after(grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0());

          }

          after(grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Function__KeywordAssignment_0"

  // $ANTLR start "rule__Function__NameAssignment_1"
  // InternalDsl.g:2350:1: rule__Function__NameAssignment_1 : ( RULE_STRING ) ;
  public final void rule__Function__NameAssignment_1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2354:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2355:2: ( RULE_STRING )
      {
        // InternalDsl.g:2355:2: ( RULE_STRING )
        // InternalDsl.g:2356:3: RULE_STRING
        {
          before(grammarAccess.getFunctionAccess().getNameSTRINGTerminalRuleCall_1_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getFunctionAccess().getNameSTRINGTerminalRuleCall_1_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Function__NameAssignment_1"

  // $ANTLR start "rule__Activity__KeywordAssignment_0"
  // InternalDsl.g:2365:1: rule__Activity__KeywordAssignment_0 : ( ( 'activity' ) ) ;
  public final void rule__Activity__KeywordAssignment_0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2369:1: ( ( ( 'activity' ) ) )
      // InternalDsl.g:2370:2: ( ( 'activity' ) )
      {
        // InternalDsl.g:2370:2: ( ( 'activity' ) )
        // InternalDsl.g:2371:3: ( 'activity' )
        {
          before(grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0());
          // InternalDsl.g:2372:3: ( 'activity' )
          // InternalDsl.g:2373:4: 'activity'
          {
            before(grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0());
            match(input, 28, FOLLOW_2);
            after(grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0());

          }

          after(grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Activity__KeywordAssignment_0"

  // $ANTLR start "rule__Activity__NameAssignment_1"
  // InternalDsl.g:2384:1: rule__Activity__NameAssignment_1 : ( RULE_STRING ) ;
  public final void rule__Activity__NameAssignment_1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2388:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2389:2: ( RULE_STRING )
      {
        // InternalDsl.g:2389:2: ( RULE_STRING )
        // InternalDsl.g:2390:3: RULE_STRING
        {
          before(grammarAccess.getActivityAccess().getNameSTRINGTerminalRuleCall_1_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getActivityAccess().getNameSTRINGTerminalRuleCall_1_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Activity__NameAssignment_1"

  // $ANTLR start "rule__Entity__KeywordAssignment_0"
  // InternalDsl.g:2399:1: rule__Entity__KeywordAssignment_0 : ( ( 'entity' ) ) ;
  public final void rule__Entity__KeywordAssignment_0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2403:1: ( ( ( 'entity' ) ) )
      // InternalDsl.g:2404:2: ( ( 'entity' ) )
      {
        // InternalDsl.g:2404:2: ( ( 'entity' ) )
        // InternalDsl.g:2405:3: ( 'entity' )
        {
          before(grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0());
          // InternalDsl.g:2406:3: ( 'entity' )
          // InternalDsl.g:2407:4: 'entity'
          {
            before(grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0());
            match(input, 29, FOLLOW_2);
            after(grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0());

          }

          after(grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Entity__KeywordAssignment_0"

  // $ANTLR start "rule__Entity__NameAssignment_1"
  // InternalDsl.g:2418:1: rule__Entity__NameAssignment_1 : ( RULE_STRING ) ;
  public final void rule__Entity__NameAssignment_1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2422:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2423:2: ( RULE_STRING )
      {
        // InternalDsl.g:2423:2: ( RULE_STRING )
        // InternalDsl.g:2424:3: RULE_STRING
        {
          before(grammarAccess.getEntityAccess().getNameSTRINGTerminalRuleCall_1_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getEntityAccess().getNameSTRINGTerminalRuleCall_1_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Entity__NameAssignment_1"

  // $ANTLR start "rule__Role__KeywordAssignment_0"
  // InternalDsl.g:2433:1: rule__Role__KeywordAssignment_0 : ( ( 'role' ) ) ;
  public final void rule__Role__KeywordAssignment_0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2437:1: ( ( ( 'role' ) ) )
      // InternalDsl.g:2438:2: ( ( 'role' ) )
      {
        // InternalDsl.g:2438:2: ( ( 'role' ) )
        // InternalDsl.g:2439:3: ( 'role' )
        {
          before(grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0());
          // InternalDsl.g:2440:3: ( 'role' )
          // InternalDsl.g:2441:4: 'role'
          {
            before(grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0());
            match(input, 30, FOLLOW_2);
            after(grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0());

          }

          after(grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Role__KeywordAssignment_0"

  // $ANTLR start "rule__Role__NameAssignment_1"
  // InternalDsl.g:2452:1: rule__Role__NameAssignment_1 : ( RULE_STRING ) ;
  public final void rule__Role__NameAssignment_1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2456:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2457:2: ( RULE_STRING )
      {
        // InternalDsl.g:2457:2: ( RULE_STRING )
        // InternalDsl.g:2458:3: RULE_STRING
        {
          before(grammarAccess.getRoleAccess().getNameSTRINGTerminalRuleCall_1_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getRoleAccess().getNameSTRINGTerminalRuleCall_1_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Role__NameAssignment_1"

  // $ANTLR start "rule__SequenceMessageType__ReturnAssignment_1"
  // InternalDsl.g:2467:1: rule__SequenceMessageType__ReturnAssignment_1 : ( ruleReturnMessage ) ;
  public final void rule__SequenceMessageType__ReturnAssignment_1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2471:1: ( ( ruleReturnMessage ) )
      // InternalDsl.g:2472:2: ( ruleReturnMessage )
      {
        // InternalDsl.g:2472:2: ( ruleReturnMessage )
        // InternalDsl.g:2473:3: ruleReturnMessage
        {
          before(grammarAccess.getSequenceMessageTypeAccess().getReturnReturnMessageParserRuleCall_1_0());
          pushFollow(FOLLOW_2);
          ruleReturnMessage();

          state._fsp--;

          after(grammarAccess.getSequenceMessageTypeAccess().getReturnReturnMessageParserRuleCall_1_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessageType__ReturnAssignment_1"

  // $ANTLR start "rule__SequenceMessage__SourceAssignment_0"
  // InternalDsl.g:2482:1: rule__SequenceMessage__SourceAssignment_0 : ( RULE_STRING ) ;
  public final void rule__SequenceMessage__SourceAssignment_0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2486:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2487:2: ( RULE_STRING )
      {
        // InternalDsl.g:2487:2: ( RULE_STRING )
        // InternalDsl.g:2488:3: RULE_STRING
        {
          before(grammarAccess.getSequenceMessageAccess().getSourceSTRINGTerminalRuleCall_0_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getSequenceMessageAccess().getSourceSTRINGTerminalRuleCall_0_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessage__SourceAssignment_0"

  // $ANTLR start "rule__SequenceMessage__TargetAssignment_2"
  // InternalDsl.g:2497:1: rule__SequenceMessage__TargetAssignment_2 : ( RULE_STRING ) ;
  public final void rule__SequenceMessage__TargetAssignment_2() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2501:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2502:2: ( RULE_STRING )
      {
        // InternalDsl.g:2502:2: ( RULE_STRING )
        // InternalDsl.g:2503:3: RULE_STRING
        {
          before(grammarAccess.getSequenceMessageAccess().getTargetSTRINGTerminalRuleCall_2_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getSequenceMessageAccess().getTargetSTRINGTerminalRuleCall_2_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessage__TargetAssignment_2"

  // $ANTLR start "rule__SequenceMessage__NameAssignment_4"
  // InternalDsl.g:2512:1: rule__SequenceMessage__NameAssignment_4 : ( RULE_STRING ) ;
  public final void rule__SequenceMessage__NameAssignment_4() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2516:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2517:2: ( RULE_STRING )
      {
        // InternalDsl.g:2517:2: ( RULE_STRING )
        // InternalDsl.g:2518:3: RULE_STRING
        {
          before(grammarAccess.getSequenceMessageAccess().getNameSTRINGTerminalRuleCall_4_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getSequenceMessageAccess().getNameSTRINGTerminalRuleCall_4_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__SequenceMessage__NameAssignment_4"

  // $ANTLR start "rule__CreateMessage__SourceAssignment_0"
  // InternalDsl.g:2527:1: rule__CreateMessage__SourceAssignment_0 : ( RULE_STRING ) ;
  public final void rule__CreateMessage__SourceAssignment_0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2531:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2532:2: ( RULE_STRING )
      {
        // InternalDsl.g:2532:2: ( RULE_STRING )
        // InternalDsl.g:2533:3: RULE_STRING
        {
          before(grammarAccess.getCreateMessageAccess().getSourceSTRINGTerminalRuleCall_0_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getCreateMessageAccess().getSourceSTRINGTerminalRuleCall_0_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__CreateMessage__SourceAssignment_0"

  // $ANTLR start "rule__CreateMessage__TargetAssignment_2"
  // InternalDsl.g:2542:1: rule__CreateMessage__TargetAssignment_2 : ( RULE_STRING ) ;
  public final void rule__CreateMessage__TargetAssignment_2() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2546:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2547:2: ( RULE_STRING )
      {
        // InternalDsl.g:2547:2: ( RULE_STRING )
        // InternalDsl.g:2548:3: RULE_STRING
        {
          before(grammarAccess.getCreateMessageAccess().getTargetSTRINGTerminalRuleCall_2_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getCreateMessageAccess().getTargetSTRINGTerminalRuleCall_2_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__CreateMessage__TargetAssignment_2"

  // $ANTLR start "rule__CreateMessage__NameAssignment_4"
  // InternalDsl.g:2557:1: rule__CreateMessage__NameAssignment_4 : ( RULE_STRING ) ;
  public final void rule__CreateMessage__NameAssignment_4() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2561:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2562:2: ( RULE_STRING )
      {
        // InternalDsl.g:2562:2: ( RULE_STRING )
        // InternalDsl.g:2563:3: RULE_STRING
        {
          before(grammarAccess.getCreateMessageAccess().getNameSTRINGTerminalRuleCall_4_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getCreateMessageAccess().getNameSTRINGTerminalRuleCall_4_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__CreateMessage__NameAssignment_4"

  // $ANTLR start "rule__DeleteMessage__SourceAssignment_0"
  // InternalDsl.g:2572:1: rule__DeleteMessage__SourceAssignment_0 : ( RULE_STRING ) ;
  public final void rule__DeleteMessage__SourceAssignment_0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2576:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2577:2: ( RULE_STRING )
      {
        // InternalDsl.g:2577:2: ( RULE_STRING )
        // InternalDsl.g:2578:3: RULE_STRING
        {
          before(grammarAccess.getDeleteMessageAccess().getSourceSTRINGTerminalRuleCall_0_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getDeleteMessageAccess().getSourceSTRINGTerminalRuleCall_0_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__DeleteMessage__SourceAssignment_0"

  // $ANTLR start "rule__DeleteMessage__TargetAssignment_2"
  // InternalDsl.g:2587:1: rule__DeleteMessage__TargetAssignment_2 : ( RULE_STRING ) ;
  public final void rule__DeleteMessage__TargetAssignment_2() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2591:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2592:2: ( RULE_STRING )
      {
        // InternalDsl.g:2592:2: ( RULE_STRING )
        // InternalDsl.g:2593:3: RULE_STRING
        {
          before(grammarAccess.getDeleteMessageAccess().getTargetSTRINGTerminalRuleCall_2_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getDeleteMessageAccess().getTargetSTRINGTerminalRuleCall_2_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__DeleteMessage__TargetAssignment_2"

  // $ANTLR start "rule__DeleteMessage__NameAssignment_4"
  // InternalDsl.g:2602:1: rule__DeleteMessage__NameAssignment_4 : ( RULE_STRING ) ;
  public final void rule__DeleteMessage__NameAssignment_4() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2606:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2607:2: ( RULE_STRING )
      {
        // InternalDsl.g:2607:2: ( RULE_STRING )
        // InternalDsl.g:2608:3: RULE_STRING
        {
          before(grammarAccess.getDeleteMessageAccess().getNameSTRINGTerminalRuleCall_4_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getDeleteMessageAccess().getNameSTRINGTerminalRuleCall_4_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__DeleteMessage__NameAssignment_4"

  // $ANTLR start "rule__ReturnMessage__TargetAssignment_0"
  // InternalDsl.g:2617:1: rule__ReturnMessage__TargetAssignment_0 : ( RULE_STRING ) ;
  public final void rule__ReturnMessage__TargetAssignment_0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2621:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2622:2: ( RULE_STRING )
      {
        // InternalDsl.g:2622:2: ( RULE_STRING )
        // InternalDsl.g:2623:3: RULE_STRING
        {
          before(grammarAccess.getReturnMessageAccess().getTargetSTRINGTerminalRuleCall_0_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getReturnMessageAccess().getTargetSTRINGTerminalRuleCall_0_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ReturnMessage__TargetAssignment_0"

  // $ANTLR start "rule__ReturnMessage__SourceAssignment_2"
  // InternalDsl.g:2632:1: rule__ReturnMessage__SourceAssignment_2 : ( RULE_STRING ) ;
  public final void rule__ReturnMessage__SourceAssignment_2() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2636:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2637:2: ( RULE_STRING )
      {
        // InternalDsl.g:2637:2: ( RULE_STRING )
        // InternalDsl.g:2638:3: RULE_STRING
        {
          before(grammarAccess.getReturnMessageAccess().getSourceSTRINGTerminalRuleCall_2_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getReturnMessageAccess().getSourceSTRINGTerminalRuleCall_2_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ReturnMessage__SourceAssignment_2"

  // $ANTLR start "rule__ReturnMessage__NameAssignment_4"
  // InternalDsl.g:2647:1: rule__ReturnMessage__NameAssignment_4 : ( RULE_STRING ) ;
  public final void rule__ReturnMessage__NameAssignment_4() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2651:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2652:2: ( RULE_STRING )
      {
        // InternalDsl.g:2652:2: ( RULE_STRING )
        // InternalDsl.g:2653:3: RULE_STRING
        {
          before(grammarAccess.getReturnMessageAccess().getNameSTRINGTerminalRuleCall_4_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getReturnMessageAccess().getNameSTRINGTerminalRuleCall_4_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ReturnMessage__NameAssignment_4"

  // $ANTLR start "rule__ArmTimerMessage__ParticipantAssignment_1"
  // InternalDsl.g:2662:1: rule__ArmTimerMessage__ParticipantAssignment_1 : ( RULE_STRING ) ;
  public final void rule__ArmTimerMessage__ParticipantAssignment_1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2666:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2667:2: ( RULE_STRING )
      {
        // InternalDsl.g:2667:2: ( RULE_STRING )
        // InternalDsl.g:2668:3: RULE_STRING
        {
          before(grammarAccess.getArmTimerMessageAccess().getParticipantSTRINGTerminalRuleCall_1_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getArmTimerMessageAccess().getParticipantSTRINGTerminalRuleCall_1_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ArmTimerMessage__ParticipantAssignment_1"

  // $ANTLR start "rule__ArmTimerMessage__NameAssignment_3"
  // InternalDsl.g:2677:1: rule__ArmTimerMessage__NameAssignment_3 : ( RULE_STRING ) ;
  public final void rule__ArmTimerMessage__NameAssignment_3() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2681:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2682:2: ( RULE_STRING )
      {
        // InternalDsl.g:2682:2: ( RULE_STRING )
        // InternalDsl.g:2683:3: RULE_STRING
        {
          before(grammarAccess.getArmTimerMessageAccess().getNameSTRINGTerminalRuleCall_3_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getArmTimerMessageAccess().getNameSTRINGTerminalRuleCall_3_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ArmTimerMessage__NameAssignment_3"

  // $ANTLR start "rule__ParticipantDeactivation__KeywordAssignment_0"
  // InternalDsl.g:2692:1: rule__ParticipantDeactivation__KeywordAssignment_0 : ( ( 'deactivate' ) ) ;
  public final void rule__ParticipantDeactivation__KeywordAssignment_0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2696:1: ( ( ( 'deactivate' ) ) )
      // InternalDsl.g:2697:2: ( ( 'deactivate' ) )
      {
        // InternalDsl.g:2697:2: ( ( 'deactivate' ) )
        // InternalDsl.g:2698:3: ( 'deactivate' )
        {
          before(grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0());
          // InternalDsl.g:2699:3: ( 'deactivate' )
          // InternalDsl.g:2700:4: 'deactivate'
          {
            before(grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0());
            match(input, 31, FOLLOW_2);
            after(grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0());

          }

          after(grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ParticipantDeactivation__KeywordAssignment_0"

  // $ANTLR start "rule__ParticipantDeactivation__NameAssignment_1"
  // InternalDsl.g:2711:1: rule__ParticipantDeactivation__NameAssignment_1 : ( RULE_STRING ) ;
  public final void rule__ParticipantDeactivation__NameAssignment_1() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2715:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2716:2: ( RULE_STRING )
      {
        // InternalDsl.g:2716:2: ( RULE_STRING )
        // InternalDsl.g:2717:3: RULE_STRING
        {
          before(grammarAccess.getParticipantDeactivationAccess().getNameSTRINGTerminalRuleCall_1_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getParticipantDeactivationAccess().getNameSTRINGTerminalRuleCall_1_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__ParticipantDeactivation__NameAssignment_1"

  // $ANTLR start "rule__Reference__KeywordAssignment_0"
  // InternalDsl.g:2726:1: rule__Reference__KeywordAssignment_0 : ( ( 'ref' ) ) ;
  public final void rule__Reference__KeywordAssignment_0() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2730:1: ( ( ( 'ref' ) ) )
      // InternalDsl.g:2731:2: ( ( 'ref' ) )
      {
        // InternalDsl.g:2731:2: ( ( 'ref' ) )
        // InternalDsl.g:2732:3: ( 'ref' )
        {
          before(grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0());
          // InternalDsl.g:2733:3: ( 'ref' )
          // InternalDsl.g:2734:4: 'ref'
          {
            before(grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0());
            match(input, 32, FOLLOW_2);
            after(grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0());

          }

          after(grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Reference__KeywordAssignment_0"

  // $ANTLR start "rule__Reference__TimelinesAssignment_2"
  // InternalDsl.g:2745:1: rule__Reference__TimelinesAssignment_2 : ( RULE_STRING ) ;
  public final void rule__Reference__TimelinesAssignment_2() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2749:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2750:2: ( RULE_STRING )
      {
        // InternalDsl.g:2750:2: ( RULE_STRING )
        // InternalDsl.g:2751:3: RULE_STRING
        {
          before(grammarAccess.getReferenceAccess().getTimelinesSTRINGTerminalRuleCall_2_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getReferenceAccess().getTimelinesSTRINGTerminalRuleCall_2_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Reference__TimelinesAssignment_2"

  // $ANTLR start "rule__Reference__NameAssignment_3"
  // InternalDsl.g:2760:1: rule__Reference__NameAssignment_3 : ( RULE_STRING ) ;
  public final void rule__Reference__NameAssignment_3() throws RecognitionException {

    int stackSize = keepStackSize();

    try {
      // InternalDsl.g:2764:1: ( ( RULE_STRING ) )
      // InternalDsl.g:2765:2: ( RULE_STRING )
      {
        // InternalDsl.g:2765:2: ( RULE_STRING )
        // InternalDsl.g:2766:3: RULE_STRING
        {
          before(grammarAccess.getReferenceAccess().getNameSTRINGTerminalRuleCall_3_0());
          match(input, RULE_STRING, FOLLOW_2);
          after(grammarAccess.getReferenceAccess().getNameSTRINGTerminalRuleCall_3_0());

        }

      }

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {

      restoreStackSize(stackSize);

    }
    return;
  }
  // $ANTLR end "rule__Reference__NameAssignment_3"

  // Delegated rules

  public static final BitSet FOLLOW_1 = new BitSet(new long[] { 0x0000000000000000L });
  public static final BitSet FOLLOW_2 = new BitSet(new long[] { 0x0000000000000002L });
  public static final BitSet FOLLOW_3 = new BitSet(new long[] { 0x0000000000400000L });
  public static final BitSet FOLLOW_4 = new BitSet(new long[] { 0x00000001FF900010L });
  public static final BitSet FOLLOW_5 = new BitSet(new long[] { 0x000000007F000002L });
  public static final BitSet FOLLOW_6 = new BitSet(new long[] { 0x0000000180100012L });
  public static final BitSet FOLLOW_7 = new BitSet(new long[] { 0x0000000000000010L });
  public static final BitSet FOLLOW_8 = new BitSet(new long[] { 0x0000000000003800L });
  public static final BitSet FOLLOW_9 = new BitSet(new long[] { 0x0000000000008000L });
  public static final BitSet FOLLOW_10 = new BitSet(new long[] { 0x0000000000010000L });
  public static final BitSet FOLLOW_11 = new BitSet(new long[] { 0x0000000000020000L });
  public static final BitSet FOLLOW_12 = new BitSet(new long[] { 0x0000000000040000L });
  public static final BitSet FOLLOW_13 = new BitSet(new long[] { 0x0000000000080000L });
  public static final BitSet FOLLOW_14 = new BitSet(new long[] { 0x0000000000200000L });
  public static final BitSet FOLLOW_15 = new BitSet(new long[] { 0x0000000000000012L });

}