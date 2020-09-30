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
package org.polarsys.capella.scenario.editor.dsl.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.polarsys.capella.scenario.editor.dsl.services.TextualScenarioGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTextualScenarioParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'unset'", "'behavior'", "'node'", "'alt'", "'loop'", "'par'", "'assert'", "'critical'", "'ignore'", "'neg'", "'opt'", "'seq'", "'strict'", "'state'", "'mode'", "'function'", "'scenario'", "'{'", "'}'", "'actor'", "'component'", "'configuration_item'", "'activity'", "'entity'", "'role'", "'->'", "'withExecution'", "'withReturn'", "':'", "'->+'", "'->x'", "'->>'", "'deactivate'", "'ref'", "'over'", "'else'", "'on'"
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

    	public void setGrammarAccess(TextualScenarioGrammarAccess grammarAccess) {
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
    // InternalTextualScenario.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalTextualScenario.g:54:1: ( ruleModel EOF )
            // InternalTextualScenario.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalTextualScenario.g:62:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:66:2: ( ( ( rule__Model__Group__0 ) ) )
            // InternalTextualScenario.g:67:2: ( ( rule__Model__Group__0 ) )
            {
            // InternalTextualScenario.g:67:2: ( ( rule__Model__Group__0 ) )
            // InternalTextualScenario.g:68:3: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalTextualScenario.g:69:3: ( rule__Model__Group__0 )
            // InternalTextualScenario.g:69:4: rule__Model__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleParticipant"
    // InternalTextualScenario.g:78:1: entryRuleParticipant : ruleParticipant EOF ;
    public final void entryRuleParticipant() throws RecognitionException {
        try {
            // InternalTextualScenario.g:79:1: ( ruleParticipant EOF )
            // InternalTextualScenario.g:80:1: ruleParticipant EOF
            {
             before(grammarAccess.getParticipantRule()); 
            pushFollow(FOLLOW_1);
            ruleParticipant();

            state._fsp--;

             after(grammarAccess.getParticipantRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParticipant"


    // $ANTLR start "ruleParticipant"
    // InternalTextualScenario.g:87:1: ruleParticipant : ( ( rule__Participant__Alternatives ) ) ;
    public final void ruleParticipant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:91:2: ( ( ( rule__Participant__Alternatives ) ) )
            // InternalTextualScenario.g:92:2: ( ( rule__Participant__Alternatives ) )
            {
            // InternalTextualScenario.g:92:2: ( ( rule__Participant__Alternatives ) )
            // InternalTextualScenario.g:93:3: ( rule__Participant__Alternatives )
            {
             before(grammarAccess.getParticipantAccess().getAlternatives()); 
            // InternalTextualScenario.g:94:3: ( rule__Participant__Alternatives )
            // InternalTextualScenario.g:94:4: rule__Participant__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Participant__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getParticipantAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParticipant"


    // $ANTLR start "entryRuleGenericComponent"
    // InternalTextualScenario.g:103:1: entryRuleGenericComponent : ruleGenericComponent EOF ;
    public final void entryRuleGenericComponent() throws RecognitionException {
        try {
            // InternalTextualScenario.g:104:1: ( ruleGenericComponent EOF )
            // InternalTextualScenario.g:105:1: ruleGenericComponent EOF
            {
             before(grammarAccess.getGenericComponentRule()); 
            pushFollow(FOLLOW_1);
            ruleGenericComponent();

            state._fsp--;

             after(grammarAccess.getGenericComponentRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGenericComponent"


    // $ANTLR start "ruleGenericComponent"
    // InternalTextualScenario.g:112:1: ruleGenericComponent : ( ( rule__GenericComponent__Alternatives ) ) ;
    public final void ruleGenericComponent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:116:2: ( ( ( rule__GenericComponent__Alternatives ) ) )
            // InternalTextualScenario.g:117:2: ( ( rule__GenericComponent__Alternatives ) )
            {
            // InternalTextualScenario.g:117:2: ( ( rule__GenericComponent__Alternatives ) )
            // InternalTextualScenario.g:118:3: ( rule__GenericComponent__Alternatives )
            {
             before(grammarAccess.getGenericComponentAccess().getAlternatives()); 
            // InternalTextualScenario.g:119:3: ( rule__GenericComponent__Alternatives )
            // InternalTextualScenario.g:119:4: rule__GenericComponent__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__GenericComponent__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getGenericComponentAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGenericComponent"


    // $ANTLR start "entryRuleGenericFunction"
    // InternalTextualScenario.g:128:1: entryRuleGenericFunction : ruleGenericFunction EOF ;
    public final void entryRuleGenericFunction() throws RecognitionException {
        try {
            // InternalTextualScenario.g:129:1: ( ruleGenericFunction EOF )
            // InternalTextualScenario.g:130:1: ruleGenericFunction EOF
            {
             before(grammarAccess.getGenericFunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleGenericFunction();

            state._fsp--;

             after(grammarAccess.getGenericFunctionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGenericFunction"


    // $ANTLR start "ruleGenericFunction"
    // InternalTextualScenario.g:137:1: ruleGenericFunction : ( ( rule__GenericFunction__Alternatives ) ) ;
    public final void ruleGenericFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:141:2: ( ( ( rule__GenericFunction__Alternatives ) ) )
            // InternalTextualScenario.g:142:2: ( ( rule__GenericFunction__Alternatives ) )
            {
            // InternalTextualScenario.g:142:2: ( ( rule__GenericFunction__Alternatives ) )
            // InternalTextualScenario.g:143:3: ( rule__GenericFunction__Alternatives )
            {
             before(grammarAccess.getGenericFunctionAccess().getAlternatives()); 
            // InternalTextualScenario.g:144:3: ( rule__GenericFunction__Alternatives )
            // InternalTextualScenario.g:144:4: rule__GenericFunction__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__GenericFunction__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getGenericFunctionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGenericFunction"


    // $ANTLR start "entryRuleActor"
    // InternalTextualScenario.g:153:1: entryRuleActor : ruleActor EOF ;
    public final void entryRuleActor() throws RecognitionException {
        try {
            // InternalTextualScenario.g:154:1: ( ruleActor EOF )
            // InternalTextualScenario.g:155:1: ruleActor EOF
            {
             before(grammarAccess.getActorRule()); 
            pushFollow(FOLLOW_1);
            ruleActor();

            state._fsp--;

             after(grammarAccess.getActorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleActor"


    // $ANTLR start "ruleActor"
    // InternalTextualScenario.g:162:1: ruleActor : ( ( rule__Actor__Group__0 ) ) ;
    public final void ruleActor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:166:2: ( ( ( rule__Actor__Group__0 ) ) )
            // InternalTextualScenario.g:167:2: ( ( rule__Actor__Group__0 ) )
            {
            // InternalTextualScenario.g:167:2: ( ( rule__Actor__Group__0 ) )
            // InternalTextualScenario.g:168:3: ( rule__Actor__Group__0 )
            {
             before(grammarAccess.getActorAccess().getGroup()); 
            // InternalTextualScenario.g:169:3: ( rule__Actor__Group__0 )
            // InternalTextualScenario.g:169:4: rule__Actor__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Actor__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getActorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleActor"


    // $ANTLR start "entryRuleComponent"
    // InternalTextualScenario.g:178:1: entryRuleComponent : ruleComponent EOF ;
    public final void entryRuleComponent() throws RecognitionException {
        try {
            // InternalTextualScenario.g:179:1: ( ruleComponent EOF )
            // InternalTextualScenario.g:180:1: ruleComponent EOF
            {
             before(grammarAccess.getComponentRule()); 
            pushFollow(FOLLOW_1);
            ruleComponent();

            state._fsp--;

             after(grammarAccess.getComponentRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComponent"


    // $ANTLR start "ruleComponent"
    // InternalTextualScenario.g:187:1: ruleComponent : ( ( rule__Component__Group__0 ) ) ;
    public final void ruleComponent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:191:2: ( ( ( rule__Component__Group__0 ) ) )
            // InternalTextualScenario.g:192:2: ( ( rule__Component__Group__0 ) )
            {
            // InternalTextualScenario.g:192:2: ( ( rule__Component__Group__0 ) )
            // InternalTextualScenario.g:193:3: ( rule__Component__Group__0 )
            {
             before(grammarAccess.getComponentAccess().getGroup()); 
            // InternalTextualScenario.g:194:3: ( rule__Component__Group__0 )
            // InternalTextualScenario.g:194:4: rule__Component__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Component__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComponentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComponent"


    // $ANTLR start "entryRuleConfigurationItem"
    // InternalTextualScenario.g:203:1: entryRuleConfigurationItem : ruleConfigurationItem EOF ;
    public final void entryRuleConfigurationItem() throws RecognitionException {
        try {
            // InternalTextualScenario.g:204:1: ( ruleConfigurationItem EOF )
            // InternalTextualScenario.g:205:1: ruleConfigurationItem EOF
            {
             before(grammarAccess.getConfigurationItemRule()); 
            pushFollow(FOLLOW_1);
            ruleConfigurationItem();

            state._fsp--;

             after(grammarAccess.getConfigurationItemRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConfigurationItem"


    // $ANTLR start "ruleConfigurationItem"
    // InternalTextualScenario.g:212:1: ruleConfigurationItem : ( ( rule__ConfigurationItem__Group__0 ) ) ;
    public final void ruleConfigurationItem() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:216:2: ( ( ( rule__ConfigurationItem__Group__0 ) ) )
            // InternalTextualScenario.g:217:2: ( ( rule__ConfigurationItem__Group__0 ) )
            {
            // InternalTextualScenario.g:217:2: ( ( rule__ConfigurationItem__Group__0 ) )
            // InternalTextualScenario.g:218:3: ( rule__ConfigurationItem__Group__0 )
            {
             before(grammarAccess.getConfigurationItemAccess().getGroup()); 
            // InternalTextualScenario.g:219:3: ( rule__ConfigurationItem__Group__0 )
            // InternalTextualScenario.g:219:4: rule__ConfigurationItem__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ConfigurationItem__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConfigurationItemAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConfigurationItem"


    // $ANTLR start "entryRuleFunction"
    // InternalTextualScenario.g:228:1: entryRuleFunction : ruleFunction EOF ;
    public final void entryRuleFunction() throws RecognitionException {
        try {
            // InternalTextualScenario.g:229:1: ( ruleFunction EOF )
            // InternalTextualScenario.g:230:1: ruleFunction EOF
            {
             before(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleFunction();

            state._fsp--;

             after(grammarAccess.getFunctionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalTextualScenario.g:237:1: ruleFunction : ( ( rule__Function__Group__0 ) ) ;
    public final void ruleFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:241:2: ( ( ( rule__Function__Group__0 ) ) )
            // InternalTextualScenario.g:242:2: ( ( rule__Function__Group__0 ) )
            {
            // InternalTextualScenario.g:242:2: ( ( rule__Function__Group__0 ) )
            // InternalTextualScenario.g:243:3: ( rule__Function__Group__0 )
            {
             before(grammarAccess.getFunctionAccess().getGroup()); 
            // InternalTextualScenario.g:244:3: ( rule__Function__Group__0 )
            // InternalTextualScenario.g:244:4: rule__Function__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Function__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleActivity"
    // InternalTextualScenario.g:253:1: entryRuleActivity : ruleActivity EOF ;
    public final void entryRuleActivity() throws RecognitionException {
        try {
            // InternalTextualScenario.g:254:1: ( ruleActivity EOF )
            // InternalTextualScenario.g:255:1: ruleActivity EOF
            {
             before(grammarAccess.getActivityRule()); 
            pushFollow(FOLLOW_1);
            ruleActivity();

            state._fsp--;

             after(grammarAccess.getActivityRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleActivity"


    // $ANTLR start "ruleActivity"
    // InternalTextualScenario.g:262:1: ruleActivity : ( ( rule__Activity__Group__0 ) ) ;
    public final void ruleActivity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:266:2: ( ( ( rule__Activity__Group__0 ) ) )
            // InternalTextualScenario.g:267:2: ( ( rule__Activity__Group__0 ) )
            {
            // InternalTextualScenario.g:267:2: ( ( rule__Activity__Group__0 ) )
            // InternalTextualScenario.g:268:3: ( rule__Activity__Group__0 )
            {
             before(grammarAccess.getActivityAccess().getGroup()); 
            // InternalTextualScenario.g:269:3: ( rule__Activity__Group__0 )
            // InternalTextualScenario.g:269:4: rule__Activity__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Activity__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getActivityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleActivity"


    // $ANTLR start "entryRuleEntity"
    // InternalTextualScenario.g:278:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // InternalTextualScenario.g:279:1: ( ruleEntity EOF )
            // InternalTextualScenario.g:280:1: ruleEntity EOF
            {
             before(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getEntityRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalTextualScenario.g:287:1: ruleEntity : ( ( rule__Entity__Group__0 ) ) ;
    public final void ruleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:291:2: ( ( ( rule__Entity__Group__0 ) ) )
            // InternalTextualScenario.g:292:2: ( ( rule__Entity__Group__0 ) )
            {
            // InternalTextualScenario.g:292:2: ( ( rule__Entity__Group__0 ) )
            // InternalTextualScenario.g:293:3: ( rule__Entity__Group__0 )
            {
             before(grammarAccess.getEntityAccess().getGroup()); 
            // InternalTextualScenario.g:294:3: ( rule__Entity__Group__0 )
            // InternalTextualScenario.g:294:4: rule__Entity__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Entity__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleRole"
    // InternalTextualScenario.g:303:1: entryRuleRole : ruleRole EOF ;
    public final void entryRuleRole() throws RecognitionException {
        try {
            // InternalTextualScenario.g:304:1: ( ruleRole EOF )
            // InternalTextualScenario.g:305:1: ruleRole EOF
            {
             before(grammarAccess.getRoleRule()); 
            pushFollow(FOLLOW_1);
            ruleRole();

            state._fsp--;

             after(grammarAccess.getRoleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRole"


    // $ANTLR start "ruleRole"
    // InternalTextualScenario.g:312:1: ruleRole : ( ( rule__Role__Group__0 ) ) ;
    public final void ruleRole() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:316:2: ( ( ( rule__Role__Group__0 ) ) )
            // InternalTextualScenario.g:317:2: ( ( rule__Role__Group__0 ) )
            {
            // InternalTextualScenario.g:317:2: ( ( rule__Role__Group__0 ) )
            // InternalTextualScenario.g:318:3: ( rule__Role__Group__0 )
            {
             before(grammarAccess.getRoleAccess().getGroup()); 
            // InternalTextualScenario.g:319:3: ( rule__Role__Group__0 )
            // InternalTextualScenario.g:319:4: rule__Role__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Role__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRoleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRole"


    // $ANTLR start "entryRuleMessage"
    // InternalTextualScenario.g:328:1: entryRuleMessage : ruleMessage EOF ;
    public final void entryRuleMessage() throws RecognitionException {
        try {
            // InternalTextualScenario.g:329:1: ( ruleMessage EOF )
            // InternalTextualScenario.g:330:1: ruleMessage EOF
            {
             before(grammarAccess.getMessageRule()); 
            pushFollow(FOLLOW_1);
            ruleMessage();

            state._fsp--;

             after(grammarAccess.getMessageRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMessage"


    // $ANTLR start "ruleMessage"
    // InternalTextualScenario.g:337:1: ruleMessage : ( ( rule__Message__Alternatives ) ) ;
    public final void ruleMessage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:341:2: ( ( ( rule__Message__Alternatives ) ) )
            // InternalTextualScenario.g:342:2: ( ( rule__Message__Alternatives ) )
            {
            // InternalTextualScenario.g:342:2: ( ( rule__Message__Alternatives ) )
            // InternalTextualScenario.g:343:3: ( rule__Message__Alternatives )
            {
             before(grammarAccess.getMessageAccess().getAlternatives()); 
            // InternalTextualScenario.g:344:3: ( rule__Message__Alternatives )
            // InternalTextualScenario.g:344:4: rule__Message__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Message__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMessageAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMessage"


    // $ANTLR start "entryRuleSequenceMessageType"
    // InternalTextualScenario.g:353:1: entryRuleSequenceMessageType : ruleSequenceMessageType EOF ;
    public final void entryRuleSequenceMessageType() throws RecognitionException {
        try {
            // InternalTextualScenario.g:354:1: ( ruleSequenceMessageType EOF )
            // InternalTextualScenario.g:355:1: ruleSequenceMessageType EOF
            {
             before(grammarAccess.getSequenceMessageTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleSequenceMessageType();

            state._fsp--;

             after(grammarAccess.getSequenceMessageTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSequenceMessageType"


    // $ANTLR start "ruleSequenceMessageType"
    // InternalTextualScenario.g:362:1: ruleSequenceMessageType : ( ( rule__SequenceMessageType__Alternatives ) ) ;
    public final void ruleSequenceMessageType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:366:2: ( ( ( rule__SequenceMessageType__Alternatives ) ) )
            // InternalTextualScenario.g:367:2: ( ( rule__SequenceMessageType__Alternatives ) )
            {
            // InternalTextualScenario.g:367:2: ( ( rule__SequenceMessageType__Alternatives ) )
            // InternalTextualScenario.g:368:3: ( rule__SequenceMessageType__Alternatives )
            {
             before(grammarAccess.getSequenceMessageTypeAccess().getAlternatives()); 
            // InternalTextualScenario.g:369:3: ( rule__SequenceMessageType__Alternatives )
            // InternalTextualScenario.g:369:4: rule__SequenceMessageType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__SequenceMessageType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSequenceMessageTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSequenceMessageType"


    // $ANTLR start "entryRuleSequenceMessage"
    // InternalTextualScenario.g:378:1: entryRuleSequenceMessage : ruleSequenceMessage EOF ;
    public final void entryRuleSequenceMessage() throws RecognitionException {
        try {
            // InternalTextualScenario.g:379:1: ( ruleSequenceMessage EOF )
            // InternalTextualScenario.g:380:1: ruleSequenceMessage EOF
            {
             before(grammarAccess.getSequenceMessageRule()); 
            pushFollow(FOLLOW_1);
            ruleSequenceMessage();

            state._fsp--;

             after(grammarAccess.getSequenceMessageRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSequenceMessage"


    // $ANTLR start "ruleSequenceMessage"
    // InternalTextualScenario.g:387:1: ruleSequenceMessage : ( ( rule__SequenceMessage__Group__0 ) ) ;
    public final void ruleSequenceMessage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:391:2: ( ( ( rule__SequenceMessage__Group__0 ) ) )
            // InternalTextualScenario.g:392:2: ( ( rule__SequenceMessage__Group__0 ) )
            {
            // InternalTextualScenario.g:392:2: ( ( rule__SequenceMessage__Group__0 ) )
            // InternalTextualScenario.g:393:3: ( rule__SequenceMessage__Group__0 )
            {
             before(grammarAccess.getSequenceMessageAccess().getGroup()); 
            // InternalTextualScenario.g:394:3: ( rule__SequenceMessage__Group__0 )
            // InternalTextualScenario.g:394:4: rule__SequenceMessage__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SequenceMessage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSequenceMessageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSequenceMessage"


    // $ANTLR start "entryRuleCreateMessage"
    // InternalTextualScenario.g:403:1: entryRuleCreateMessage : ruleCreateMessage EOF ;
    public final void entryRuleCreateMessage() throws RecognitionException {
        try {
            // InternalTextualScenario.g:404:1: ( ruleCreateMessage EOF )
            // InternalTextualScenario.g:405:1: ruleCreateMessage EOF
            {
             before(grammarAccess.getCreateMessageRule()); 
            pushFollow(FOLLOW_1);
            ruleCreateMessage();

            state._fsp--;

             after(grammarAccess.getCreateMessageRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCreateMessage"


    // $ANTLR start "ruleCreateMessage"
    // InternalTextualScenario.g:412:1: ruleCreateMessage : ( ( rule__CreateMessage__Group__0 ) ) ;
    public final void ruleCreateMessage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:416:2: ( ( ( rule__CreateMessage__Group__0 ) ) )
            // InternalTextualScenario.g:417:2: ( ( rule__CreateMessage__Group__0 ) )
            {
            // InternalTextualScenario.g:417:2: ( ( rule__CreateMessage__Group__0 ) )
            // InternalTextualScenario.g:418:3: ( rule__CreateMessage__Group__0 )
            {
             before(grammarAccess.getCreateMessageAccess().getGroup()); 
            // InternalTextualScenario.g:419:3: ( rule__CreateMessage__Group__0 )
            // InternalTextualScenario.g:419:4: rule__CreateMessage__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CreateMessage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCreateMessageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCreateMessage"


    // $ANTLR start "entryRuleDeleteMessage"
    // InternalTextualScenario.g:428:1: entryRuleDeleteMessage : ruleDeleteMessage EOF ;
    public final void entryRuleDeleteMessage() throws RecognitionException {
        try {
            // InternalTextualScenario.g:429:1: ( ruleDeleteMessage EOF )
            // InternalTextualScenario.g:430:1: ruleDeleteMessage EOF
            {
             before(grammarAccess.getDeleteMessageRule()); 
            pushFollow(FOLLOW_1);
            ruleDeleteMessage();

            state._fsp--;

             after(grammarAccess.getDeleteMessageRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDeleteMessage"


    // $ANTLR start "ruleDeleteMessage"
    // InternalTextualScenario.g:437:1: ruleDeleteMessage : ( ( rule__DeleteMessage__Group__0 ) ) ;
    public final void ruleDeleteMessage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:441:2: ( ( ( rule__DeleteMessage__Group__0 ) ) )
            // InternalTextualScenario.g:442:2: ( ( rule__DeleteMessage__Group__0 ) )
            {
            // InternalTextualScenario.g:442:2: ( ( rule__DeleteMessage__Group__0 ) )
            // InternalTextualScenario.g:443:3: ( rule__DeleteMessage__Group__0 )
            {
             before(grammarAccess.getDeleteMessageAccess().getGroup()); 
            // InternalTextualScenario.g:444:3: ( rule__DeleteMessage__Group__0 )
            // InternalTextualScenario.g:444:4: rule__DeleteMessage__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DeleteMessage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDeleteMessageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeleteMessage"


    // $ANTLR start "entryRuleArmTimerMessage"
    // InternalTextualScenario.g:453:1: entryRuleArmTimerMessage : ruleArmTimerMessage EOF ;
    public final void entryRuleArmTimerMessage() throws RecognitionException {
        try {
            // InternalTextualScenario.g:454:1: ( ruleArmTimerMessage EOF )
            // InternalTextualScenario.g:455:1: ruleArmTimerMessage EOF
            {
             before(grammarAccess.getArmTimerMessageRule()); 
            pushFollow(FOLLOW_1);
            ruleArmTimerMessage();

            state._fsp--;

             after(grammarAccess.getArmTimerMessageRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleArmTimerMessage"


    // $ANTLR start "ruleArmTimerMessage"
    // InternalTextualScenario.g:462:1: ruleArmTimerMessage : ( ( rule__ArmTimerMessage__Group__0 ) ) ;
    public final void ruleArmTimerMessage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:466:2: ( ( ( rule__ArmTimerMessage__Group__0 ) ) )
            // InternalTextualScenario.g:467:2: ( ( rule__ArmTimerMessage__Group__0 ) )
            {
            // InternalTextualScenario.g:467:2: ( ( rule__ArmTimerMessage__Group__0 ) )
            // InternalTextualScenario.g:468:3: ( rule__ArmTimerMessage__Group__0 )
            {
             before(grammarAccess.getArmTimerMessageAccess().getGroup()); 
            // InternalTextualScenario.g:469:3: ( rule__ArmTimerMessage__Group__0 )
            // InternalTextualScenario.g:469:4: rule__ArmTimerMessage__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ArmTimerMessage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getArmTimerMessageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArmTimerMessage"


    // $ANTLR start "entryRuleParticipantDeactivation"
    // InternalTextualScenario.g:478:1: entryRuleParticipantDeactivation : ruleParticipantDeactivation EOF ;
    public final void entryRuleParticipantDeactivation() throws RecognitionException {
        try {
            // InternalTextualScenario.g:479:1: ( ruleParticipantDeactivation EOF )
            // InternalTextualScenario.g:480:1: ruleParticipantDeactivation EOF
            {
             before(grammarAccess.getParticipantDeactivationRule()); 
            pushFollow(FOLLOW_1);
            ruleParticipantDeactivation();

            state._fsp--;

             after(grammarAccess.getParticipantDeactivationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParticipantDeactivation"


    // $ANTLR start "ruleParticipantDeactivation"
    // InternalTextualScenario.g:487:1: ruleParticipantDeactivation : ( ( rule__ParticipantDeactivation__Group__0 ) ) ;
    public final void ruleParticipantDeactivation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:491:2: ( ( ( rule__ParticipantDeactivation__Group__0 ) ) )
            // InternalTextualScenario.g:492:2: ( ( rule__ParticipantDeactivation__Group__0 ) )
            {
            // InternalTextualScenario.g:492:2: ( ( rule__ParticipantDeactivation__Group__0 ) )
            // InternalTextualScenario.g:493:3: ( rule__ParticipantDeactivation__Group__0 )
            {
             before(grammarAccess.getParticipantDeactivationAccess().getGroup()); 
            // InternalTextualScenario.g:494:3: ( rule__ParticipantDeactivation__Group__0 )
            // InternalTextualScenario.g:494:4: rule__ParticipantDeactivation__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParticipantDeactivation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParticipantDeactivationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParticipantDeactivation"


    // $ANTLR start "entryRuleReference"
    // InternalTextualScenario.g:503:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // InternalTextualScenario.g:504:1: ( ruleReference EOF )
            // InternalTextualScenario.g:505:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_1);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalTextualScenario.g:512:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:516:2: ( ( ( rule__Reference__Group__0 ) ) )
            // InternalTextualScenario.g:517:2: ( ( rule__Reference__Group__0 ) )
            {
            // InternalTextualScenario.g:517:2: ( ( rule__Reference__Group__0 ) )
            // InternalTextualScenario.g:518:3: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // InternalTextualScenario.g:519:3: ( rule__Reference__Group__0 )
            // InternalTextualScenario.g:519:4: rule__Reference__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Reference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleCombinedFragment"
    // InternalTextualScenario.g:528:1: entryRuleCombinedFragment : ruleCombinedFragment EOF ;
    public final void entryRuleCombinedFragment() throws RecognitionException {
        try {
            // InternalTextualScenario.g:529:1: ( ruleCombinedFragment EOF )
            // InternalTextualScenario.g:530:1: ruleCombinedFragment EOF
            {
             before(grammarAccess.getCombinedFragmentRule()); 
            pushFollow(FOLLOW_1);
            ruleCombinedFragment();

            state._fsp--;

             after(grammarAccess.getCombinedFragmentRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCombinedFragment"


    // $ANTLR start "ruleCombinedFragment"
    // InternalTextualScenario.g:537:1: ruleCombinedFragment : ( ( rule__CombinedFragment__Group__0 ) ) ;
    public final void ruleCombinedFragment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:541:2: ( ( ( rule__CombinedFragment__Group__0 ) ) )
            // InternalTextualScenario.g:542:2: ( ( rule__CombinedFragment__Group__0 ) )
            {
            // InternalTextualScenario.g:542:2: ( ( rule__CombinedFragment__Group__0 ) )
            // InternalTextualScenario.g:543:3: ( rule__CombinedFragment__Group__0 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getGroup()); 
            // InternalTextualScenario.g:544:3: ( rule__CombinedFragment__Group__0 )
            // InternalTextualScenario.g:544:4: rule__CombinedFragment__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CombinedFragment__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCombinedFragmentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCombinedFragment"


    // $ANTLR start "entryRuleOperand"
    // InternalTextualScenario.g:553:1: entryRuleOperand : ruleOperand EOF ;
    public final void entryRuleOperand() throws RecognitionException {
        try {
            // InternalTextualScenario.g:554:1: ( ruleOperand EOF )
            // InternalTextualScenario.g:555:1: ruleOperand EOF
            {
             before(grammarAccess.getOperandRule()); 
            pushFollow(FOLLOW_1);
            ruleOperand();

            state._fsp--;

             after(grammarAccess.getOperandRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOperand"


    // $ANTLR start "ruleOperand"
    // InternalTextualScenario.g:562:1: ruleOperand : ( ( rule__Operand__Group__0 ) ) ;
    public final void ruleOperand() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:566:2: ( ( ( rule__Operand__Group__0 ) ) )
            // InternalTextualScenario.g:567:2: ( ( rule__Operand__Group__0 ) )
            {
            // InternalTextualScenario.g:567:2: ( ( rule__Operand__Group__0 ) )
            // InternalTextualScenario.g:568:3: ( rule__Operand__Group__0 )
            {
             before(grammarAccess.getOperandAccess().getGroup()); 
            // InternalTextualScenario.g:569:3: ( rule__Operand__Group__0 )
            // InternalTextualScenario.g:569:4: rule__Operand__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Operand__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOperandAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperand"


    // $ANTLR start "entryRuleBlock"
    // InternalTextualScenario.g:578:1: entryRuleBlock : ruleBlock EOF ;
    public final void entryRuleBlock() throws RecognitionException {
        try {
            // InternalTextualScenario.g:579:1: ( ruleBlock EOF )
            // InternalTextualScenario.g:580:1: ruleBlock EOF
            {
             before(grammarAccess.getBlockRule()); 
            pushFollow(FOLLOW_1);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getBlockRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // InternalTextualScenario.g:587:1: ruleBlock : ( ( rule__Block__Group__0 ) ) ;
    public final void ruleBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:591:2: ( ( ( rule__Block__Group__0 ) ) )
            // InternalTextualScenario.g:592:2: ( ( rule__Block__Group__0 ) )
            {
            // InternalTextualScenario.g:592:2: ( ( rule__Block__Group__0 ) )
            // InternalTextualScenario.g:593:3: ( rule__Block__Group__0 )
            {
             before(grammarAccess.getBlockAccess().getGroup()); 
            // InternalTextualScenario.g:594:3: ( rule__Block__Group__0 )
            // InternalTextualScenario.g:594:4: rule__Block__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Block__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBlockAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleStateFragment"
    // InternalTextualScenario.g:603:1: entryRuleStateFragment : ruleStateFragment EOF ;
    public final void entryRuleStateFragment() throws RecognitionException {
        try {
            // InternalTextualScenario.g:604:1: ( ruleStateFragment EOF )
            // InternalTextualScenario.g:605:1: ruleStateFragment EOF
            {
             before(grammarAccess.getStateFragmentRule()); 
            pushFollow(FOLLOW_1);
            ruleStateFragment();

            state._fsp--;

             after(grammarAccess.getStateFragmentRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStateFragment"


    // $ANTLR start "ruleStateFragment"
    // InternalTextualScenario.g:612:1: ruleStateFragment : ( ( rule__StateFragment__Group__0 ) ) ;
    public final void ruleStateFragment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:616:2: ( ( ( rule__StateFragment__Group__0 ) ) )
            // InternalTextualScenario.g:617:2: ( ( rule__StateFragment__Group__0 ) )
            {
            // InternalTextualScenario.g:617:2: ( ( rule__StateFragment__Group__0 ) )
            // InternalTextualScenario.g:618:3: ( rule__StateFragment__Group__0 )
            {
             before(grammarAccess.getStateFragmentAccess().getGroup()); 
            // InternalTextualScenario.g:619:3: ( rule__StateFragment__Group__0 )
            // InternalTextualScenario.g:619:4: rule__StateFragment__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StateFragment__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStateFragmentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStateFragment"


    // $ANTLR start "rule__Model__ElementsAlternatives_3_0"
    // InternalTextualScenario.g:627:1: rule__Model__ElementsAlternatives_3_0 : ( ( ruleMessage ) | ( ruleReference ) | ( ruleCombinedFragment ) | ( ruleStateFragment ) );
    public final void rule__Model__ElementsAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:631:1: ( ( ruleMessage ) | ( ruleReference ) | ( ruleCombinedFragment ) | ( ruleStateFragment ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==45) ) {
                    alt1=3;
                }
                else if ( (LA1_1==36||(LA1_1>=40 && LA1_1<=41)) ) {
                    alt1=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
                }
                break;
            case 42:
            case 43:
                {
                alt1=1;
                }
                break;
            case 44:
                {
                alt1=2;
                }
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                {
                alt1=3;
                }
                break;
            case 47:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalTextualScenario.g:632:2: ( ruleMessage )
                    {
                    // InternalTextualScenario.g:632:2: ( ruleMessage )
                    // InternalTextualScenario.g:633:3: ruleMessage
                    {
                     before(grammarAccess.getModelAccess().getElementsMessageParserRuleCall_3_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleMessage();

                    state._fsp--;

                     after(grammarAccess.getModelAccess().getElementsMessageParserRuleCall_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:638:2: ( ruleReference )
                    {
                    // InternalTextualScenario.g:638:2: ( ruleReference )
                    // InternalTextualScenario.g:639:3: ruleReference
                    {
                     before(grammarAccess.getModelAccess().getElementsReferenceParserRuleCall_3_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getModelAccess().getElementsReferenceParserRuleCall_3_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:644:2: ( ruleCombinedFragment )
                    {
                    // InternalTextualScenario.g:644:2: ( ruleCombinedFragment )
                    // InternalTextualScenario.g:645:3: ruleCombinedFragment
                    {
                     before(grammarAccess.getModelAccess().getElementsCombinedFragmentParserRuleCall_3_0_2()); 
                    pushFollow(FOLLOW_2);
                    ruleCombinedFragment();

                    state._fsp--;

                     after(grammarAccess.getModelAccess().getElementsCombinedFragmentParserRuleCall_3_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTextualScenario.g:650:2: ( ruleStateFragment )
                    {
                    // InternalTextualScenario.g:650:2: ( ruleStateFragment )
                    // InternalTextualScenario.g:651:3: ruleStateFragment
                    {
                     before(grammarAccess.getModelAccess().getElementsStateFragmentParserRuleCall_3_0_3()); 
                    pushFollow(FOLLOW_2);
                    ruleStateFragment();

                    state._fsp--;

                     after(grammarAccess.getModelAccess().getElementsStateFragmentParserRuleCall_3_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ElementsAlternatives_3_0"


    // $ANTLR start "rule__Participant__Alternatives"
    // InternalTextualScenario.g:660:1: rule__Participant__Alternatives : ( ( ruleGenericComponent ) | ( ruleGenericFunction ) );
    public final void rule__Participant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:664:1: ( ( ruleGenericComponent ) | ( ruleGenericFunction ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=30 && LA2_0<=32)||(LA2_0>=34 && LA2_0<=35)) ) {
                alt2=1;
            }
            else if ( (LA2_0==26||LA2_0==33) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalTextualScenario.g:665:2: ( ruleGenericComponent )
                    {
                    // InternalTextualScenario.g:665:2: ( ruleGenericComponent )
                    // InternalTextualScenario.g:666:3: ruleGenericComponent
                    {
                     before(grammarAccess.getParticipantAccess().getGenericComponentParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleGenericComponent();

                    state._fsp--;

                     after(grammarAccess.getParticipantAccess().getGenericComponentParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:671:2: ( ruleGenericFunction )
                    {
                    // InternalTextualScenario.g:671:2: ( ruleGenericFunction )
                    // InternalTextualScenario.g:672:3: ruleGenericFunction
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
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Participant__Alternatives"


    // $ANTLR start "rule__GenericComponent__Alternatives"
    // InternalTextualScenario.g:681:1: rule__GenericComponent__Alternatives : ( ( ruleEntity ) | ( ruleActor ) | ( ruleComponent ) | ( ruleConfigurationItem ) | ( ruleRole ) );
    public final void rule__GenericComponent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:685:1: ( ( ruleEntity ) | ( ruleActor ) | ( ruleComponent ) | ( ruleConfigurationItem ) | ( ruleRole ) )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt3=1;
                }
                break;
            case 30:
                {
                alt3=2;
                }
                break;
            case 31:
                {
                alt3=3;
                }
                break;
            case 32:
                {
                alt3=4;
                }
                break;
            case 35:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalTextualScenario.g:686:2: ( ruleEntity )
                    {
                    // InternalTextualScenario.g:686:2: ( ruleEntity )
                    // InternalTextualScenario.g:687:3: ruleEntity
                    {
                     before(grammarAccess.getGenericComponentAccess().getEntityParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleEntity();

                    state._fsp--;

                     after(grammarAccess.getGenericComponentAccess().getEntityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:692:2: ( ruleActor )
                    {
                    // InternalTextualScenario.g:692:2: ( ruleActor )
                    // InternalTextualScenario.g:693:3: ruleActor
                    {
                     before(grammarAccess.getGenericComponentAccess().getActorParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleActor();

                    state._fsp--;

                     after(grammarAccess.getGenericComponentAccess().getActorParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:698:2: ( ruleComponent )
                    {
                    // InternalTextualScenario.g:698:2: ( ruleComponent )
                    // InternalTextualScenario.g:699:3: ruleComponent
                    {
                     before(grammarAccess.getGenericComponentAccess().getComponentParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleComponent();

                    state._fsp--;

                     after(grammarAccess.getGenericComponentAccess().getComponentParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTextualScenario.g:704:2: ( ruleConfigurationItem )
                    {
                    // InternalTextualScenario.g:704:2: ( ruleConfigurationItem )
                    // InternalTextualScenario.g:705:3: ruleConfigurationItem
                    {
                     before(grammarAccess.getGenericComponentAccess().getConfigurationItemParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleConfigurationItem();

                    state._fsp--;

                     after(grammarAccess.getGenericComponentAccess().getConfigurationItemParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalTextualScenario.g:710:2: ( ruleRole )
                    {
                    // InternalTextualScenario.g:710:2: ( ruleRole )
                    // InternalTextualScenario.g:711:3: ruleRole
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
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericComponent__Alternatives"


    // $ANTLR start "rule__GenericFunction__Alternatives"
    // InternalTextualScenario.g:720:1: rule__GenericFunction__Alternatives : ( ( ruleFunction ) | ( ruleActivity ) );
    public final void rule__GenericFunction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:724:1: ( ( ruleFunction ) | ( ruleActivity ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==26) ) {
                alt4=1;
            }
            else if ( (LA4_0==33) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalTextualScenario.g:725:2: ( ruleFunction )
                    {
                    // InternalTextualScenario.g:725:2: ( ruleFunction )
                    // InternalTextualScenario.g:726:3: ruleFunction
                    {
                     before(grammarAccess.getGenericFunctionAccess().getFunctionParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleFunction();

                    state._fsp--;

                     after(grammarAccess.getGenericFunctionAccess().getFunctionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:731:2: ( ruleActivity )
                    {
                    // InternalTextualScenario.g:731:2: ( ruleActivity )
                    // InternalTextualScenario.g:732:3: ruleActivity
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
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericFunction__Alternatives"


    // $ANTLR start "rule__Component__NatureAlternatives_2_0"
    // InternalTextualScenario.g:741:1: rule__Component__NatureAlternatives_2_0 : ( ( 'unset' ) | ( 'behavior' ) | ( 'node' ) );
    public final void rule__Component__NatureAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:745:1: ( ( 'unset' ) | ( 'behavior' ) | ( 'node' ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt5=1;
                }
                break;
            case 12:
                {
                alt5=2;
                }
                break;
            case 13:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalTextualScenario.g:746:2: ( 'unset' )
                    {
                    // InternalTextualScenario.g:746:2: ( 'unset' )
                    // InternalTextualScenario.g:747:3: 'unset'
                    {
                     before(grammarAccess.getComponentAccess().getNatureUnsetKeyword_2_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getComponentAccess().getNatureUnsetKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:752:2: ( 'behavior' )
                    {
                    // InternalTextualScenario.g:752:2: ( 'behavior' )
                    // InternalTextualScenario.g:753:3: 'behavior'
                    {
                     before(grammarAccess.getComponentAccess().getNatureBehaviorKeyword_2_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getComponentAccess().getNatureBehaviorKeyword_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:758:2: ( 'node' )
                    {
                    // InternalTextualScenario.g:758:2: ( 'node' )
                    // InternalTextualScenario.g:759:3: 'node'
                    {
                     before(grammarAccess.getComponentAccess().getNatureNodeKeyword_2_0_2()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getComponentAccess().getNatureNodeKeyword_2_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__NatureAlternatives_2_0"


    // $ANTLR start "rule__Message__Alternatives"
    // InternalTextualScenario.g:768:1: rule__Message__Alternatives : ( ( ruleSequenceMessageType ) | ( ruleArmTimerMessage ) | ( ruleParticipantDeactivation ) );
    public final void rule__Message__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:772:1: ( ( ruleSequenceMessageType ) | ( ruleArmTimerMessage ) | ( ruleParticipantDeactivation ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt6=1;
                }
                break;
            case 42:
                {
                alt6=2;
                }
                break;
            case 43:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalTextualScenario.g:773:2: ( ruleSequenceMessageType )
                    {
                    // InternalTextualScenario.g:773:2: ( ruleSequenceMessageType )
                    // InternalTextualScenario.g:774:3: ruleSequenceMessageType
                    {
                     before(grammarAccess.getMessageAccess().getSequenceMessageTypeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleSequenceMessageType();

                    state._fsp--;

                     after(grammarAccess.getMessageAccess().getSequenceMessageTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:779:2: ( ruleArmTimerMessage )
                    {
                    // InternalTextualScenario.g:779:2: ( ruleArmTimerMessage )
                    // InternalTextualScenario.g:780:3: ruleArmTimerMessage
                    {
                     before(grammarAccess.getMessageAccess().getArmTimerMessageParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleArmTimerMessage();

                    state._fsp--;

                     after(grammarAccess.getMessageAccess().getArmTimerMessageParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:785:2: ( ruleParticipantDeactivation )
                    {
                    // InternalTextualScenario.g:785:2: ( ruleParticipantDeactivation )
                    // InternalTextualScenario.g:786:3: ruleParticipantDeactivation
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
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Message__Alternatives"


    // $ANTLR start "rule__SequenceMessageType__Alternatives"
    // InternalTextualScenario.g:795:1: rule__SequenceMessageType__Alternatives : ( ( ruleSequenceMessage ) | ( ruleCreateMessage ) | ( ruleDeleteMessage ) );
    public final void rule__SequenceMessageType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:799:1: ( ( ruleSequenceMessage ) | ( ruleCreateMessage ) | ( ruleDeleteMessage ) )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                switch ( input.LA(2) ) {
                case 40:
                    {
                    alt7=2;
                    }
                    break;
                case 36:
                    {
                    alt7=1;
                    }
                    break;
                case 41:
                    {
                    alt7=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalTextualScenario.g:800:2: ( ruleSequenceMessage )
                    {
                    // InternalTextualScenario.g:800:2: ( ruleSequenceMessage )
                    // InternalTextualScenario.g:801:3: ruleSequenceMessage
                    {
                     before(grammarAccess.getSequenceMessageTypeAccess().getSequenceMessageParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleSequenceMessage();

                    state._fsp--;

                     after(grammarAccess.getSequenceMessageTypeAccess().getSequenceMessageParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:806:2: ( ruleCreateMessage )
                    {
                    // InternalTextualScenario.g:806:2: ( ruleCreateMessage )
                    // InternalTextualScenario.g:807:3: ruleCreateMessage
                    {
                     before(grammarAccess.getSequenceMessageTypeAccess().getCreateMessageParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleCreateMessage();

                    state._fsp--;

                     after(grammarAccess.getSequenceMessageTypeAccess().getCreateMessageParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:812:2: ( ruleDeleteMessage )
                    {
                    // InternalTextualScenario.g:812:2: ( ruleDeleteMessage )
                    // InternalTextualScenario.g:813:3: ruleDeleteMessage
                    {
                     before(grammarAccess.getSequenceMessageTypeAccess().getDeleteMessageParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleDeleteMessage();

                    state._fsp--;

                     after(grammarAccess.getSequenceMessageTypeAccess().getDeleteMessageParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessageType__Alternatives"


    // $ANTLR start "rule__CombinedFragment__KeywordAlternatives_0_0"
    // InternalTextualScenario.g:822:1: rule__CombinedFragment__KeywordAlternatives_0_0 : ( ( 'alt' ) | ( 'loop' ) | ( 'par' ) | ( 'assert' ) | ( 'critical' ) | ( 'ignore' ) | ( 'neg' ) | ( 'opt' ) | ( 'seq' ) | ( 'strict' ) );
    public final void rule__CombinedFragment__KeywordAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:826:1: ( ( 'alt' ) | ( 'loop' ) | ( 'par' ) | ( 'assert' ) | ( 'critical' ) | ( 'ignore' ) | ( 'neg' ) | ( 'opt' ) | ( 'seq' ) | ( 'strict' ) )
            int alt8=10;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt8=1;
                }
                break;
            case 15:
                {
                alt8=2;
                }
                break;
            case 16:
                {
                alt8=3;
                }
                break;
            case 17:
                {
                alt8=4;
                }
                break;
            case 18:
                {
                alt8=5;
                }
                break;
            case 19:
                {
                alt8=6;
                }
                break;
            case 20:
                {
                alt8=7;
                }
                break;
            case 21:
                {
                alt8=8;
                }
                break;
            case 22:
                {
                alt8=9;
                }
                break;
            case 23:
                {
                alt8=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalTextualScenario.g:827:2: ( 'alt' )
                    {
                    // InternalTextualScenario.g:827:2: ( 'alt' )
                    // InternalTextualScenario.g:828:3: 'alt'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordAltKeyword_0_0_0()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordAltKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:833:2: ( 'loop' )
                    {
                    // InternalTextualScenario.g:833:2: ( 'loop' )
                    // InternalTextualScenario.g:834:3: 'loop'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordLoopKeyword_0_0_1()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordLoopKeyword_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:839:2: ( 'par' )
                    {
                    // InternalTextualScenario.g:839:2: ( 'par' )
                    // InternalTextualScenario.g:840:3: 'par'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordParKeyword_0_0_2()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordParKeyword_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTextualScenario.g:845:2: ( 'assert' )
                    {
                    // InternalTextualScenario.g:845:2: ( 'assert' )
                    // InternalTextualScenario.g:846:3: 'assert'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordAssertKeyword_0_0_3()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordAssertKeyword_0_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalTextualScenario.g:851:2: ( 'critical' )
                    {
                    // InternalTextualScenario.g:851:2: ( 'critical' )
                    // InternalTextualScenario.g:852:3: 'critical'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordCriticalKeyword_0_0_4()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordCriticalKeyword_0_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalTextualScenario.g:857:2: ( 'ignore' )
                    {
                    // InternalTextualScenario.g:857:2: ( 'ignore' )
                    // InternalTextualScenario.g:858:3: 'ignore'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordIgnoreKeyword_0_0_5()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordIgnoreKeyword_0_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalTextualScenario.g:863:2: ( 'neg' )
                    {
                    // InternalTextualScenario.g:863:2: ( 'neg' )
                    // InternalTextualScenario.g:864:3: 'neg'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordNegKeyword_0_0_6()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordNegKeyword_0_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalTextualScenario.g:869:2: ( 'opt' )
                    {
                    // InternalTextualScenario.g:869:2: ( 'opt' )
                    // InternalTextualScenario.g:870:3: 'opt'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordOptKeyword_0_0_7()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordOptKeyword_0_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalTextualScenario.g:875:2: ( 'seq' )
                    {
                    // InternalTextualScenario.g:875:2: ( 'seq' )
                    // InternalTextualScenario.g:876:3: 'seq'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordSeqKeyword_0_0_8()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordSeqKeyword_0_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalTextualScenario.g:881:2: ( 'strict' )
                    {
                    // InternalTextualScenario.g:881:2: ( 'strict' )
                    // InternalTextualScenario.g:882:3: 'strict'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordStrictKeyword_0_0_9()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordStrictKeyword_0_0_9()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__KeywordAlternatives_0_0"


    // $ANTLR start "rule__Block__BlockElementsAlternatives_1_0"
    // InternalTextualScenario.g:891:1: rule__Block__BlockElementsAlternatives_1_0 : ( ( ruleMessage ) | ( ruleReference ) | ( ruleCombinedFragment ) | ( ruleStateFragment ) );
    public final void rule__Block__BlockElementsAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:895:1: ( ( ruleMessage ) | ( ruleReference ) | ( ruleCombinedFragment ) | ( ruleStateFragment ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==45) ) {
                    alt9=3;
                }
                else if ( (LA9_1==36||(LA9_1>=40 && LA9_1<=41)) ) {
                    alt9=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
                }
                break;
            case 42:
            case 43:
                {
                alt9=1;
                }
                break;
            case 44:
                {
                alt9=2;
                }
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                {
                alt9=3;
                }
                break;
            case 47:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalTextualScenario.g:896:2: ( ruleMessage )
                    {
                    // InternalTextualScenario.g:896:2: ( ruleMessage )
                    // InternalTextualScenario.g:897:3: ruleMessage
                    {
                     before(grammarAccess.getBlockAccess().getBlockElementsMessageParserRuleCall_1_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleMessage();

                    state._fsp--;

                     after(grammarAccess.getBlockAccess().getBlockElementsMessageParserRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:902:2: ( ruleReference )
                    {
                    // InternalTextualScenario.g:902:2: ( ruleReference )
                    // InternalTextualScenario.g:903:3: ruleReference
                    {
                     before(grammarAccess.getBlockAccess().getBlockElementsReferenceParserRuleCall_1_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getBlockAccess().getBlockElementsReferenceParserRuleCall_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:908:2: ( ruleCombinedFragment )
                    {
                    // InternalTextualScenario.g:908:2: ( ruleCombinedFragment )
                    // InternalTextualScenario.g:909:3: ruleCombinedFragment
                    {
                     before(grammarAccess.getBlockAccess().getBlockElementsCombinedFragmentParserRuleCall_1_0_2()); 
                    pushFollow(FOLLOW_2);
                    ruleCombinedFragment();

                    state._fsp--;

                     after(grammarAccess.getBlockAccess().getBlockElementsCombinedFragmentParserRuleCall_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTextualScenario.g:914:2: ( ruleStateFragment )
                    {
                    // InternalTextualScenario.g:914:2: ( ruleStateFragment )
                    // InternalTextualScenario.g:915:3: ruleStateFragment
                    {
                     before(grammarAccess.getBlockAccess().getBlockElementsStateFragmentParserRuleCall_1_0_3()); 
                    pushFollow(FOLLOW_2);
                    ruleStateFragment();

                    state._fsp--;

                     after(grammarAccess.getBlockAccess().getBlockElementsStateFragmentParserRuleCall_1_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__BlockElementsAlternatives_1_0"


    // $ANTLR start "rule__StateFragment__KeywordAlternatives_2_0"
    // InternalTextualScenario.g:924:1: rule__StateFragment__KeywordAlternatives_2_0 : ( ( 'state' ) | ( 'mode' ) | ( 'function' ) );
    public final void rule__StateFragment__KeywordAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:928:1: ( ( 'state' ) | ( 'mode' ) | ( 'function' ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt10=1;
                }
                break;
            case 25:
                {
                alt10=2;
                }
                break;
            case 26:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalTextualScenario.g:929:2: ( 'state' )
                    {
                    // InternalTextualScenario.g:929:2: ( 'state' )
                    // InternalTextualScenario.g:930:3: 'state'
                    {
                     before(grammarAccess.getStateFragmentAccess().getKeywordStateKeyword_2_0_0()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getStateFragmentAccess().getKeywordStateKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:935:2: ( 'mode' )
                    {
                    // InternalTextualScenario.g:935:2: ( 'mode' )
                    // InternalTextualScenario.g:936:3: 'mode'
                    {
                     before(grammarAccess.getStateFragmentAccess().getKeywordModeKeyword_2_0_1()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getStateFragmentAccess().getKeywordModeKeyword_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:941:2: ( 'function' )
                    {
                    // InternalTextualScenario.g:941:2: ( 'function' )
                    // InternalTextualScenario.g:942:3: 'function'
                    {
                     before(grammarAccess.getStateFragmentAccess().getKeywordFunctionKeyword_2_0_2()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getStateFragmentAccess().getKeywordFunctionKeyword_2_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateFragment__KeywordAlternatives_2_0"


    // $ANTLR start "rule__Model__Group__0"
    // InternalTextualScenario.g:951:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:955:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalTextualScenario.g:956:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // InternalTextualScenario.g:963:1: rule__Model__Group__0__Impl : ( 'scenario' ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:967:1: ( ( 'scenario' ) )
            // InternalTextualScenario.g:968:1: ( 'scenario' )
            {
            // InternalTextualScenario.g:968:1: ( 'scenario' )
            // InternalTextualScenario.g:969:2: 'scenario'
            {
             before(grammarAccess.getModelAccess().getScenarioKeyword_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getScenarioKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // InternalTextualScenario.g:978:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:982:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalTextualScenario.g:983:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // InternalTextualScenario.g:990:1: rule__Model__Group__1__Impl : ( ( rule__Model__BeginAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:994:1: ( ( ( rule__Model__BeginAssignment_1 ) ) )
            // InternalTextualScenario.g:995:1: ( ( rule__Model__BeginAssignment_1 ) )
            {
            // InternalTextualScenario.g:995:1: ( ( rule__Model__BeginAssignment_1 ) )
            // InternalTextualScenario.g:996:2: ( rule__Model__BeginAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getBeginAssignment_1()); 
            // InternalTextualScenario.g:997:2: ( rule__Model__BeginAssignment_1 )
            // InternalTextualScenario.g:997:3: rule__Model__BeginAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Model__BeginAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getBeginAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // InternalTextualScenario.g:1005:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1009:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalTextualScenario.g:1010:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // InternalTextualScenario.g:1017:1: rule__Model__Group__2__Impl : ( ( rule__Model__ParticipantsAssignment_2 )* ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1021:1: ( ( ( rule__Model__ParticipantsAssignment_2 )* ) )
            // InternalTextualScenario.g:1022:1: ( ( rule__Model__ParticipantsAssignment_2 )* )
            {
            // InternalTextualScenario.g:1022:1: ( ( rule__Model__ParticipantsAssignment_2 )* )
            // InternalTextualScenario.g:1023:2: ( rule__Model__ParticipantsAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getParticipantsAssignment_2()); 
            // InternalTextualScenario.g:1024:2: ( rule__Model__ParticipantsAssignment_2 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==26||(LA11_0>=30 && LA11_0<=35)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalTextualScenario.g:1024:3: rule__Model__ParticipantsAssignment_2
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Model__ParticipantsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getParticipantsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__Model__Group__3"
    // InternalTextualScenario.g:1032:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1036:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // InternalTextualScenario.g:1037:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__Model__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3"


    // $ANTLR start "rule__Model__Group__3__Impl"
    // InternalTextualScenario.g:1044:1: rule__Model__Group__3__Impl : ( ( rule__Model__ElementsAssignment_3 )* ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1048:1: ( ( ( rule__Model__ElementsAssignment_3 )* ) )
            // InternalTextualScenario.g:1049:1: ( ( rule__Model__ElementsAssignment_3 )* )
            {
            // InternalTextualScenario.g:1049:1: ( ( rule__Model__ElementsAssignment_3 )* )
            // InternalTextualScenario.g:1050:2: ( rule__Model__ElementsAssignment_3 )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment_3()); 
            // InternalTextualScenario.g:1051:2: ( rule__Model__ElementsAssignment_3 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_STRING||(LA12_0>=14 && LA12_0<=23)||(LA12_0>=42 && LA12_0<=44)||LA12_0==47) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalTextualScenario.g:1051:3: rule__Model__ElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Model__ElementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getElementsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3__Impl"


    // $ANTLR start "rule__Model__Group__4"
    // InternalTextualScenario.g:1059:1: rule__Model__Group__4 : rule__Model__Group__4__Impl ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1063:1: ( rule__Model__Group__4__Impl )
            // InternalTextualScenario.g:1064:2: rule__Model__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4"


    // $ANTLR start "rule__Model__Group__4__Impl"
    // InternalTextualScenario.g:1070:1: rule__Model__Group__4__Impl : ( ( rule__Model__EndAssignment_4 ) ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1074:1: ( ( ( rule__Model__EndAssignment_4 ) ) )
            // InternalTextualScenario.g:1075:1: ( ( rule__Model__EndAssignment_4 ) )
            {
            // InternalTextualScenario.g:1075:1: ( ( rule__Model__EndAssignment_4 ) )
            // InternalTextualScenario.g:1076:2: ( rule__Model__EndAssignment_4 )
            {
             before(grammarAccess.getModelAccess().getEndAssignment_4()); 
            // InternalTextualScenario.g:1077:2: ( rule__Model__EndAssignment_4 )
            // InternalTextualScenario.g:1077:3: rule__Model__EndAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Model__EndAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getEndAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4__Impl"


    // $ANTLR start "rule__Actor__Group__0"
    // InternalTextualScenario.g:1086:1: rule__Actor__Group__0 : rule__Actor__Group__0__Impl rule__Actor__Group__1 ;
    public final void rule__Actor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1090:1: ( rule__Actor__Group__0__Impl rule__Actor__Group__1 )
            // InternalTextualScenario.g:1091:2: rule__Actor__Group__0__Impl rule__Actor__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Actor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Actor__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__0"


    // $ANTLR start "rule__Actor__Group__0__Impl"
    // InternalTextualScenario.g:1098:1: rule__Actor__Group__0__Impl : ( ( rule__Actor__KeywordAssignment_0 ) ) ;
    public final void rule__Actor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1102:1: ( ( ( rule__Actor__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1103:1: ( ( rule__Actor__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1103:1: ( ( rule__Actor__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1104:2: ( rule__Actor__KeywordAssignment_0 )
            {
             before(grammarAccess.getActorAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1105:2: ( rule__Actor__KeywordAssignment_0 )
            // InternalTextualScenario.g:1105:3: rule__Actor__KeywordAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Actor__KeywordAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getActorAccess().getKeywordAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__0__Impl"


    // $ANTLR start "rule__Actor__Group__1"
    // InternalTextualScenario.g:1113:1: rule__Actor__Group__1 : rule__Actor__Group__1__Impl ;
    public final void rule__Actor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1117:1: ( rule__Actor__Group__1__Impl )
            // InternalTextualScenario.g:1118:2: rule__Actor__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Actor__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__1"


    // $ANTLR start "rule__Actor__Group__1__Impl"
    // InternalTextualScenario.g:1124:1: rule__Actor__Group__1__Impl : ( ( rule__Actor__NameAssignment_1 ) ) ;
    public final void rule__Actor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1128:1: ( ( ( rule__Actor__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1129:1: ( ( rule__Actor__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1129:1: ( ( rule__Actor__NameAssignment_1 ) )
            // InternalTextualScenario.g:1130:2: ( rule__Actor__NameAssignment_1 )
            {
             before(grammarAccess.getActorAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1131:2: ( rule__Actor__NameAssignment_1 )
            // InternalTextualScenario.g:1131:3: rule__Actor__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Actor__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getActorAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__1__Impl"


    // $ANTLR start "rule__Component__Group__0"
    // InternalTextualScenario.g:1140:1: rule__Component__Group__0 : rule__Component__Group__0__Impl rule__Component__Group__1 ;
    public final void rule__Component__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1144:1: ( rule__Component__Group__0__Impl rule__Component__Group__1 )
            // InternalTextualScenario.g:1145:2: rule__Component__Group__0__Impl rule__Component__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Component__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__0"


    // $ANTLR start "rule__Component__Group__0__Impl"
    // InternalTextualScenario.g:1152:1: rule__Component__Group__0__Impl : ( ( rule__Component__KeywordAssignment_0 ) ) ;
    public final void rule__Component__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1156:1: ( ( ( rule__Component__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1157:1: ( ( rule__Component__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1157:1: ( ( rule__Component__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1158:2: ( rule__Component__KeywordAssignment_0 )
            {
             before(grammarAccess.getComponentAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1159:2: ( rule__Component__KeywordAssignment_0 )
            // InternalTextualScenario.g:1159:3: rule__Component__KeywordAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Component__KeywordAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getComponentAccess().getKeywordAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__0__Impl"


    // $ANTLR start "rule__Component__Group__1"
    // InternalTextualScenario.g:1167:1: rule__Component__Group__1 : rule__Component__Group__1__Impl rule__Component__Group__2 ;
    public final void rule__Component__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1171:1: ( rule__Component__Group__1__Impl rule__Component__Group__2 )
            // InternalTextualScenario.g:1172:2: rule__Component__Group__1__Impl rule__Component__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Component__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__1"


    // $ANTLR start "rule__Component__Group__1__Impl"
    // InternalTextualScenario.g:1179:1: rule__Component__Group__1__Impl : ( ( rule__Component__NameAssignment_1 ) ) ;
    public final void rule__Component__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1183:1: ( ( ( rule__Component__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1184:1: ( ( rule__Component__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1184:1: ( ( rule__Component__NameAssignment_1 ) )
            // InternalTextualScenario.g:1185:2: ( rule__Component__NameAssignment_1 )
            {
             before(grammarAccess.getComponentAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1186:2: ( rule__Component__NameAssignment_1 )
            // InternalTextualScenario.g:1186:3: rule__Component__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Component__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getComponentAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__1__Impl"


    // $ANTLR start "rule__Component__Group__2"
    // InternalTextualScenario.g:1194:1: rule__Component__Group__2 : rule__Component__Group__2__Impl ;
    public final void rule__Component__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1198:1: ( rule__Component__Group__2__Impl )
            // InternalTextualScenario.g:1199:2: rule__Component__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Component__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__2"


    // $ANTLR start "rule__Component__Group__2__Impl"
    // InternalTextualScenario.g:1205:1: rule__Component__Group__2__Impl : ( ( rule__Component__NatureAssignment_2 )? ) ;
    public final void rule__Component__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1209:1: ( ( ( rule__Component__NatureAssignment_2 )? ) )
            // InternalTextualScenario.g:1210:1: ( ( rule__Component__NatureAssignment_2 )? )
            {
            // InternalTextualScenario.g:1210:1: ( ( rule__Component__NatureAssignment_2 )? )
            // InternalTextualScenario.g:1211:2: ( rule__Component__NatureAssignment_2 )?
            {
             before(grammarAccess.getComponentAccess().getNatureAssignment_2()); 
            // InternalTextualScenario.g:1212:2: ( rule__Component__NatureAssignment_2 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=11 && LA13_0<=13)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTextualScenario.g:1212:3: rule__Component__NatureAssignment_2
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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__2__Impl"


    // $ANTLR start "rule__ConfigurationItem__Group__0"
    // InternalTextualScenario.g:1221:1: rule__ConfigurationItem__Group__0 : rule__ConfigurationItem__Group__0__Impl rule__ConfigurationItem__Group__1 ;
    public final void rule__ConfigurationItem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1225:1: ( rule__ConfigurationItem__Group__0__Impl rule__ConfigurationItem__Group__1 )
            // InternalTextualScenario.g:1226:2: rule__ConfigurationItem__Group__0__Impl rule__ConfigurationItem__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__ConfigurationItem__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConfigurationItem__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigurationItem__Group__0"


    // $ANTLR start "rule__ConfigurationItem__Group__0__Impl"
    // InternalTextualScenario.g:1233:1: rule__ConfigurationItem__Group__0__Impl : ( ( rule__ConfigurationItem__KeywordAssignment_0 ) ) ;
    public final void rule__ConfigurationItem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1237:1: ( ( ( rule__ConfigurationItem__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1238:1: ( ( rule__ConfigurationItem__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1238:1: ( ( rule__ConfigurationItem__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1239:2: ( rule__ConfigurationItem__KeywordAssignment_0 )
            {
             before(grammarAccess.getConfigurationItemAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1240:2: ( rule__ConfigurationItem__KeywordAssignment_0 )
            // InternalTextualScenario.g:1240:3: rule__ConfigurationItem__KeywordAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ConfigurationItem__KeywordAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getConfigurationItemAccess().getKeywordAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigurationItem__Group__0__Impl"


    // $ANTLR start "rule__ConfigurationItem__Group__1"
    // InternalTextualScenario.g:1248:1: rule__ConfigurationItem__Group__1 : rule__ConfigurationItem__Group__1__Impl ;
    public final void rule__ConfigurationItem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1252:1: ( rule__ConfigurationItem__Group__1__Impl )
            // InternalTextualScenario.g:1253:2: rule__ConfigurationItem__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConfigurationItem__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigurationItem__Group__1"


    // $ANTLR start "rule__ConfigurationItem__Group__1__Impl"
    // InternalTextualScenario.g:1259:1: rule__ConfigurationItem__Group__1__Impl : ( ( rule__ConfigurationItem__NameAssignment_1 ) ) ;
    public final void rule__ConfigurationItem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1263:1: ( ( ( rule__ConfigurationItem__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1264:1: ( ( rule__ConfigurationItem__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1264:1: ( ( rule__ConfigurationItem__NameAssignment_1 ) )
            // InternalTextualScenario.g:1265:2: ( rule__ConfigurationItem__NameAssignment_1 )
            {
             before(grammarAccess.getConfigurationItemAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1266:2: ( rule__ConfigurationItem__NameAssignment_1 )
            // InternalTextualScenario.g:1266:3: rule__ConfigurationItem__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ConfigurationItem__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConfigurationItemAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigurationItem__Group__1__Impl"


    // $ANTLR start "rule__Function__Group__0"
    // InternalTextualScenario.g:1275:1: rule__Function__Group__0 : rule__Function__Group__0__Impl rule__Function__Group__1 ;
    public final void rule__Function__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1279:1: ( rule__Function__Group__0__Impl rule__Function__Group__1 )
            // InternalTextualScenario.g:1280:2: rule__Function__Group__0__Impl rule__Function__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Function__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Function__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__0"


    // $ANTLR start "rule__Function__Group__0__Impl"
    // InternalTextualScenario.g:1287:1: rule__Function__Group__0__Impl : ( ( rule__Function__KeywordAssignment_0 ) ) ;
    public final void rule__Function__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1291:1: ( ( ( rule__Function__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1292:1: ( ( rule__Function__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1292:1: ( ( rule__Function__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1293:2: ( rule__Function__KeywordAssignment_0 )
            {
             before(grammarAccess.getFunctionAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1294:2: ( rule__Function__KeywordAssignment_0 )
            // InternalTextualScenario.g:1294:3: rule__Function__KeywordAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Function__KeywordAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFunctionAccess().getKeywordAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__0__Impl"


    // $ANTLR start "rule__Function__Group__1"
    // InternalTextualScenario.g:1302:1: rule__Function__Group__1 : rule__Function__Group__1__Impl ;
    public final void rule__Function__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1306:1: ( rule__Function__Group__1__Impl )
            // InternalTextualScenario.g:1307:2: rule__Function__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Function__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__1"


    // $ANTLR start "rule__Function__Group__1__Impl"
    // InternalTextualScenario.g:1313:1: rule__Function__Group__1__Impl : ( ( rule__Function__NameAssignment_1 ) ) ;
    public final void rule__Function__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1317:1: ( ( ( rule__Function__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1318:1: ( ( rule__Function__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1318:1: ( ( rule__Function__NameAssignment_1 ) )
            // InternalTextualScenario.g:1319:2: ( rule__Function__NameAssignment_1 )
            {
             before(grammarAccess.getFunctionAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1320:2: ( rule__Function__NameAssignment_1 )
            // InternalTextualScenario.g:1320:3: rule__Function__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Function__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFunctionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__1__Impl"


    // $ANTLR start "rule__Activity__Group__0"
    // InternalTextualScenario.g:1329:1: rule__Activity__Group__0 : rule__Activity__Group__0__Impl rule__Activity__Group__1 ;
    public final void rule__Activity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1333:1: ( rule__Activity__Group__0__Impl rule__Activity__Group__1 )
            // InternalTextualScenario.g:1334:2: rule__Activity__Group__0__Impl rule__Activity__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Activity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Activity__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activity__Group__0"


    // $ANTLR start "rule__Activity__Group__0__Impl"
    // InternalTextualScenario.g:1341:1: rule__Activity__Group__0__Impl : ( ( rule__Activity__KeywordAssignment_0 ) ) ;
    public final void rule__Activity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1345:1: ( ( ( rule__Activity__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1346:1: ( ( rule__Activity__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1346:1: ( ( rule__Activity__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1347:2: ( rule__Activity__KeywordAssignment_0 )
            {
             before(grammarAccess.getActivityAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1348:2: ( rule__Activity__KeywordAssignment_0 )
            // InternalTextualScenario.g:1348:3: rule__Activity__KeywordAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Activity__KeywordAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getActivityAccess().getKeywordAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activity__Group__0__Impl"


    // $ANTLR start "rule__Activity__Group__1"
    // InternalTextualScenario.g:1356:1: rule__Activity__Group__1 : rule__Activity__Group__1__Impl ;
    public final void rule__Activity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1360:1: ( rule__Activity__Group__1__Impl )
            // InternalTextualScenario.g:1361:2: rule__Activity__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Activity__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activity__Group__1"


    // $ANTLR start "rule__Activity__Group__1__Impl"
    // InternalTextualScenario.g:1367:1: rule__Activity__Group__1__Impl : ( ( rule__Activity__NameAssignment_1 ) ) ;
    public final void rule__Activity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1371:1: ( ( ( rule__Activity__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1372:1: ( ( rule__Activity__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1372:1: ( ( rule__Activity__NameAssignment_1 ) )
            // InternalTextualScenario.g:1373:2: ( rule__Activity__NameAssignment_1 )
            {
             before(grammarAccess.getActivityAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1374:2: ( rule__Activity__NameAssignment_1 )
            // InternalTextualScenario.g:1374:3: rule__Activity__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Activity__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getActivityAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activity__Group__1__Impl"


    // $ANTLR start "rule__Entity__Group__0"
    // InternalTextualScenario.g:1383:1: rule__Entity__Group__0 : rule__Entity__Group__0__Impl rule__Entity__Group__1 ;
    public final void rule__Entity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1387:1: ( rule__Entity__Group__0__Impl rule__Entity__Group__1 )
            // InternalTextualScenario.g:1388:2: rule__Entity__Group__0__Impl rule__Entity__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Entity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__0"


    // $ANTLR start "rule__Entity__Group__0__Impl"
    // InternalTextualScenario.g:1395:1: rule__Entity__Group__0__Impl : ( ( rule__Entity__KeywordAssignment_0 ) ) ;
    public final void rule__Entity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1399:1: ( ( ( rule__Entity__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1400:1: ( ( rule__Entity__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1400:1: ( ( rule__Entity__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1401:2: ( rule__Entity__KeywordAssignment_0 )
            {
             before(grammarAccess.getEntityAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1402:2: ( rule__Entity__KeywordAssignment_0 )
            // InternalTextualScenario.g:1402:3: rule__Entity__KeywordAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Entity__KeywordAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getKeywordAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__0__Impl"


    // $ANTLR start "rule__Entity__Group__1"
    // InternalTextualScenario.g:1410:1: rule__Entity__Group__1 : rule__Entity__Group__1__Impl ;
    public final void rule__Entity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1414:1: ( rule__Entity__Group__1__Impl )
            // InternalTextualScenario.g:1415:2: rule__Entity__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Entity__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__1"


    // $ANTLR start "rule__Entity__Group__1__Impl"
    // InternalTextualScenario.g:1421:1: rule__Entity__Group__1__Impl : ( ( rule__Entity__NameAssignment_1 ) ) ;
    public final void rule__Entity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1425:1: ( ( ( rule__Entity__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1426:1: ( ( rule__Entity__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1426:1: ( ( rule__Entity__NameAssignment_1 ) )
            // InternalTextualScenario.g:1427:2: ( rule__Entity__NameAssignment_1 )
            {
             before(grammarAccess.getEntityAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1428:2: ( rule__Entity__NameAssignment_1 )
            // InternalTextualScenario.g:1428:3: rule__Entity__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Entity__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__1__Impl"


    // $ANTLR start "rule__Role__Group__0"
    // InternalTextualScenario.g:1437:1: rule__Role__Group__0 : rule__Role__Group__0__Impl rule__Role__Group__1 ;
    public final void rule__Role__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1441:1: ( rule__Role__Group__0__Impl rule__Role__Group__1 )
            // InternalTextualScenario.g:1442:2: rule__Role__Group__0__Impl rule__Role__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Role__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Role__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Role__Group__0"


    // $ANTLR start "rule__Role__Group__0__Impl"
    // InternalTextualScenario.g:1449:1: rule__Role__Group__0__Impl : ( ( rule__Role__KeywordAssignment_0 ) ) ;
    public final void rule__Role__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1453:1: ( ( ( rule__Role__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1454:1: ( ( rule__Role__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1454:1: ( ( rule__Role__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1455:2: ( rule__Role__KeywordAssignment_0 )
            {
             before(grammarAccess.getRoleAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1456:2: ( rule__Role__KeywordAssignment_0 )
            // InternalTextualScenario.g:1456:3: rule__Role__KeywordAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Role__KeywordAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRoleAccess().getKeywordAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Role__Group__0__Impl"


    // $ANTLR start "rule__Role__Group__1"
    // InternalTextualScenario.g:1464:1: rule__Role__Group__1 : rule__Role__Group__1__Impl ;
    public final void rule__Role__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1468:1: ( rule__Role__Group__1__Impl )
            // InternalTextualScenario.g:1469:2: rule__Role__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Role__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Role__Group__1"


    // $ANTLR start "rule__Role__Group__1__Impl"
    // InternalTextualScenario.g:1475:1: rule__Role__Group__1__Impl : ( ( rule__Role__NameAssignment_1 ) ) ;
    public final void rule__Role__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1479:1: ( ( ( rule__Role__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1480:1: ( ( rule__Role__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1480:1: ( ( rule__Role__NameAssignment_1 ) )
            // InternalTextualScenario.g:1481:2: ( rule__Role__NameAssignment_1 )
            {
             before(grammarAccess.getRoleAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1482:2: ( rule__Role__NameAssignment_1 )
            // InternalTextualScenario.g:1482:3: rule__Role__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Role__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRoleAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Role__Group__1__Impl"


    // $ANTLR start "rule__SequenceMessage__Group__0"
    // InternalTextualScenario.g:1491:1: rule__SequenceMessage__Group__0 : rule__SequenceMessage__Group__0__Impl rule__SequenceMessage__Group__1 ;
    public final void rule__SequenceMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1495:1: ( rule__SequenceMessage__Group__0__Impl rule__SequenceMessage__Group__1 )
            // InternalTextualScenario.g:1496:2: rule__SequenceMessage__Group__0__Impl rule__SequenceMessage__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__SequenceMessage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SequenceMessage__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__Group__0"


    // $ANTLR start "rule__SequenceMessage__Group__0__Impl"
    // InternalTextualScenario.g:1503:1: rule__SequenceMessage__Group__0__Impl : ( ( rule__SequenceMessage__SourceAssignment_0 ) ) ;
    public final void rule__SequenceMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1507:1: ( ( ( rule__SequenceMessage__SourceAssignment_0 ) ) )
            // InternalTextualScenario.g:1508:1: ( ( rule__SequenceMessage__SourceAssignment_0 ) )
            {
            // InternalTextualScenario.g:1508:1: ( ( rule__SequenceMessage__SourceAssignment_0 ) )
            // InternalTextualScenario.g:1509:2: ( rule__SequenceMessage__SourceAssignment_0 )
            {
             before(grammarAccess.getSequenceMessageAccess().getSourceAssignment_0()); 
            // InternalTextualScenario.g:1510:2: ( rule__SequenceMessage__SourceAssignment_0 )
            // InternalTextualScenario.g:1510:3: rule__SequenceMessage__SourceAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__SequenceMessage__SourceAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSequenceMessageAccess().getSourceAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__Group__0__Impl"


    // $ANTLR start "rule__SequenceMessage__Group__1"
    // InternalTextualScenario.g:1518:1: rule__SequenceMessage__Group__1 : rule__SequenceMessage__Group__1__Impl rule__SequenceMessage__Group__2 ;
    public final void rule__SequenceMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1522:1: ( rule__SequenceMessage__Group__1__Impl rule__SequenceMessage__Group__2 )
            // InternalTextualScenario.g:1523:2: rule__SequenceMessage__Group__1__Impl rule__SequenceMessage__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__SequenceMessage__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SequenceMessage__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__Group__1"


    // $ANTLR start "rule__SequenceMessage__Group__1__Impl"
    // InternalTextualScenario.g:1530:1: rule__SequenceMessage__Group__1__Impl : ( ( rule__SequenceMessage__ArrowAssignment_1 ) ) ;
    public final void rule__SequenceMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1534:1: ( ( ( rule__SequenceMessage__ArrowAssignment_1 ) ) )
            // InternalTextualScenario.g:1535:1: ( ( rule__SequenceMessage__ArrowAssignment_1 ) )
            {
            // InternalTextualScenario.g:1535:1: ( ( rule__SequenceMessage__ArrowAssignment_1 ) )
            // InternalTextualScenario.g:1536:2: ( rule__SequenceMessage__ArrowAssignment_1 )
            {
             before(grammarAccess.getSequenceMessageAccess().getArrowAssignment_1()); 
            // InternalTextualScenario.g:1537:2: ( rule__SequenceMessage__ArrowAssignment_1 )
            // InternalTextualScenario.g:1537:3: rule__SequenceMessage__ArrowAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__SequenceMessage__ArrowAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSequenceMessageAccess().getArrowAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__Group__1__Impl"


    // $ANTLR start "rule__SequenceMessage__Group__2"
    // InternalTextualScenario.g:1545:1: rule__SequenceMessage__Group__2 : rule__SequenceMessage__Group__2__Impl rule__SequenceMessage__Group__3 ;
    public final void rule__SequenceMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1549:1: ( rule__SequenceMessage__Group__2__Impl rule__SequenceMessage__Group__3 )
            // InternalTextualScenario.g:1550:2: rule__SequenceMessage__Group__2__Impl rule__SequenceMessage__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__SequenceMessage__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SequenceMessage__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__Group__2"


    // $ANTLR start "rule__SequenceMessage__Group__2__Impl"
    // InternalTextualScenario.g:1557:1: rule__SequenceMessage__Group__2__Impl : ( ( rule__SequenceMessage__TargetAssignment_2 ) ) ;
    public final void rule__SequenceMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1561:1: ( ( ( rule__SequenceMessage__TargetAssignment_2 ) ) )
            // InternalTextualScenario.g:1562:1: ( ( rule__SequenceMessage__TargetAssignment_2 ) )
            {
            // InternalTextualScenario.g:1562:1: ( ( rule__SequenceMessage__TargetAssignment_2 ) )
            // InternalTextualScenario.g:1563:2: ( rule__SequenceMessage__TargetAssignment_2 )
            {
             before(grammarAccess.getSequenceMessageAccess().getTargetAssignment_2()); 
            // InternalTextualScenario.g:1564:2: ( rule__SequenceMessage__TargetAssignment_2 )
            // InternalTextualScenario.g:1564:3: rule__SequenceMessage__TargetAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__SequenceMessage__TargetAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSequenceMessageAccess().getTargetAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__Group__2__Impl"


    // $ANTLR start "rule__SequenceMessage__Group__3"
    // InternalTextualScenario.g:1572:1: rule__SequenceMessage__Group__3 : rule__SequenceMessage__Group__3__Impl rule__SequenceMessage__Group__4 ;
    public final void rule__SequenceMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1576:1: ( rule__SequenceMessage__Group__3__Impl rule__SequenceMessage__Group__4 )
            // InternalTextualScenario.g:1577:2: rule__SequenceMessage__Group__3__Impl rule__SequenceMessage__Group__4
            {
            pushFollow(FOLLOW_10);
            rule__SequenceMessage__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SequenceMessage__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__Group__3"


    // $ANTLR start "rule__SequenceMessage__Group__3__Impl"
    // InternalTextualScenario.g:1584:1: rule__SequenceMessage__Group__3__Impl : ( ( rule__SequenceMessage__ExecutionAssignment_3 )? ) ;
    public final void rule__SequenceMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1588:1: ( ( ( rule__SequenceMessage__ExecutionAssignment_3 )? ) )
            // InternalTextualScenario.g:1589:1: ( ( rule__SequenceMessage__ExecutionAssignment_3 )? )
            {
            // InternalTextualScenario.g:1589:1: ( ( rule__SequenceMessage__ExecutionAssignment_3 )? )
            // InternalTextualScenario.g:1590:2: ( rule__SequenceMessage__ExecutionAssignment_3 )?
            {
             before(grammarAccess.getSequenceMessageAccess().getExecutionAssignment_3()); 
            // InternalTextualScenario.g:1591:2: ( rule__SequenceMessage__ExecutionAssignment_3 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==37) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalTextualScenario.g:1591:3: rule__SequenceMessage__ExecutionAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__SequenceMessage__ExecutionAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSequenceMessageAccess().getExecutionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__Group__3__Impl"


    // $ANTLR start "rule__SequenceMessage__Group__4"
    // InternalTextualScenario.g:1599:1: rule__SequenceMessage__Group__4 : rule__SequenceMessage__Group__4__Impl rule__SequenceMessage__Group__5 ;
    public final void rule__SequenceMessage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1603:1: ( rule__SequenceMessage__Group__4__Impl rule__SequenceMessage__Group__5 )
            // InternalTextualScenario.g:1604:2: rule__SequenceMessage__Group__4__Impl rule__SequenceMessage__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__SequenceMessage__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SequenceMessage__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__Group__4"


    // $ANTLR start "rule__SequenceMessage__Group__4__Impl"
    // InternalTextualScenario.g:1611:1: rule__SequenceMessage__Group__4__Impl : ( ( rule__SequenceMessage__ReturnAssignment_4 )? ) ;
    public final void rule__SequenceMessage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1615:1: ( ( ( rule__SequenceMessage__ReturnAssignment_4 )? ) )
            // InternalTextualScenario.g:1616:1: ( ( rule__SequenceMessage__ReturnAssignment_4 )? )
            {
            // InternalTextualScenario.g:1616:1: ( ( rule__SequenceMessage__ReturnAssignment_4 )? )
            // InternalTextualScenario.g:1617:2: ( rule__SequenceMessage__ReturnAssignment_4 )?
            {
             before(grammarAccess.getSequenceMessageAccess().getReturnAssignment_4()); 
            // InternalTextualScenario.g:1618:2: ( rule__SequenceMessage__ReturnAssignment_4 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==38) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalTextualScenario.g:1618:3: rule__SequenceMessage__ReturnAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__SequenceMessage__ReturnAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSequenceMessageAccess().getReturnAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__Group__4__Impl"


    // $ANTLR start "rule__SequenceMessage__Group__5"
    // InternalTextualScenario.g:1626:1: rule__SequenceMessage__Group__5 : rule__SequenceMessage__Group__5__Impl rule__SequenceMessage__Group__6 ;
    public final void rule__SequenceMessage__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1630:1: ( rule__SequenceMessage__Group__5__Impl rule__SequenceMessage__Group__6 )
            // InternalTextualScenario.g:1631:2: rule__SequenceMessage__Group__5__Impl rule__SequenceMessage__Group__6
            {
            pushFollow(FOLLOW_7);
            rule__SequenceMessage__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SequenceMessage__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__Group__5"


    // $ANTLR start "rule__SequenceMessage__Group__5__Impl"
    // InternalTextualScenario.g:1638:1: rule__SequenceMessage__Group__5__Impl : ( ( rule__SequenceMessage__DoubleDotAssignment_5 ) ) ;
    public final void rule__SequenceMessage__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1642:1: ( ( ( rule__SequenceMessage__DoubleDotAssignment_5 ) ) )
            // InternalTextualScenario.g:1643:1: ( ( rule__SequenceMessage__DoubleDotAssignment_5 ) )
            {
            // InternalTextualScenario.g:1643:1: ( ( rule__SequenceMessage__DoubleDotAssignment_5 ) )
            // InternalTextualScenario.g:1644:2: ( rule__SequenceMessage__DoubleDotAssignment_5 )
            {
             before(grammarAccess.getSequenceMessageAccess().getDoubleDotAssignment_5()); 
            // InternalTextualScenario.g:1645:2: ( rule__SequenceMessage__DoubleDotAssignment_5 )
            // InternalTextualScenario.g:1645:3: rule__SequenceMessage__DoubleDotAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__SequenceMessage__DoubleDotAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getSequenceMessageAccess().getDoubleDotAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__Group__5__Impl"


    // $ANTLR start "rule__SequenceMessage__Group__6"
    // InternalTextualScenario.g:1653:1: rule__SequenceMessage__Group__6 : rule__SequenceMessage__Group__6__Impl ;
    public final void rule__SequenceMessage__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1657:1: ( rule__SequenceMessage__Group__6__Impl )
            // InternalTextualScenario.g:1658:2: rule__SequenceMessage__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SequenceMessage__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__Group__6"


    // $ANTLR start "rule__SequenceMessage__Group__6__Impl"
    // InternalTextualScenario.g:1664:1: rule__SequenceMessage__Group__6__Impl : ( ( rule__SequenceMessage__NameAssignment_6 ) ) ;
    public final void rule__SequenceMessage__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1668:1: ( ( ( rule__SequenceMessage__NameAssignment_6 ) ) )
            // InternalTextualScenario.g:1669:1: ( ( rule__SequenceMessage__NameAssignment_6 ) )
            {
            // InternalTextualScenario.g:1669:1: ( ( rule__SequenceMessage__NameAssignment_6 ) )
            // InternalTextualScenario.g:1670:2: ( rule__SequenceMessage__NameAssignment_6 )
            {
             before(grammarAccess.getSequenceMessageAccess().getNameAssignment_6()); 
            // InternalTextualScenario.g:1671:2: ( rule__SequenceMessage__NameAssignment_6 )
            // InternalTextualScenario.g:1671:3: rule__SequenceMessage__NameAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__SequenceMessage__NameAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getSequenceMessageAccess().getNameAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__Group__6__Impl"


    // $ANTLR start "rule__CreateMessage__Group__0"
    // InternalTextualScenario.g:1680:1: rule__CreateMessage__Group__0 : rule__CreateMessage__Group__0__Impl rule__CreateMessage__Group__1 ;
    public final void rule__CreateMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1684:1: ( rule__CreateMessage__Group__0__Impl rule__CreateMessage__Group__1 )
            // InternalTextualScenario.g:1685:2: rule__CreateMessage__Group__0__Impl rule__CreateMessage__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__CreateMessage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CreateMessage__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateMessage__Group__0"


    // $ANTLR start "rule__CreateMessage__Group__0__Impl"
    // InternalTextualScenario.g:1692:1: rule__CreateMessage__Group__0__Impl : ( ( rule__CreateMessage__SourceAssignment_0 ) ) ;
    public final void rule__CreateMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1696:1: ( ( ( rule__CreateMessage__SourceAssignment_0 ) ) )
            // InternalTextualScenario.g:1697:1: ( ( rule__CreateMessage__SourceAssignment_0 ) )
            {
            // InternalTextualScenario.g:1697:1: ( ( rule__CreateMessage__SourceAssignment_0 ) )
            // InternalTextualScenario.g:1698:2: ( rule__CreateMessage__SourceAssignment_0 )
            {
             before(grammarAccess.getCreateMessageAccess().getSourceAssignment_0()); 
            // InternalTextualScenario.g:1699:2: ( rule__CreateMessage__SourceAssignment_0 )
            // InternalTextualScenario.g:1699:3: rule__CreateMessage__SourceAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__CreateMessage__SourceAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCreateMessageAccess().getSourceAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateMessage__Group__0__Impl"


    // $ANTLR start "rule__CreateMessage__Group__1"
    // InternalTextualScenario.g:1707:1: rule__CreateMessage__Group__1 : rule__CreateMessage__Group__1__Impl rule__CreateMessage__Group__2 ;
    public final void rule__CreateMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1711:1: ( rule__CreateMessage__Group__1__Impl rule__CreateMessage__Group__2 )
            // InternalTextualScenario.g:1712:2: rule__CreateMessage__Group__1__Impl rule__CreateMessage__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__CreateMessage__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CreateMessage__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateMessage__Group__1"


    // $ANTLR start "rule__CreateMessage__Group__1__Impl"
    // InternalTextualScenario.g:1719:1: rule__CreateMessage__Group__1__Impl : ( ( rule__CreateMessage__ArrowAssignment_1 ) ) ;
    public final void rule__CreateMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1723:1: ( ( ( rule__CreateMessage__ArrowAssignment_1 ) ) )
            // InternalTextualScenario.g:1724:1: ( ( rule__CreateMessage__ArrowAssignment_1 ) )
            {
            // InternalTextualScenario.g:1724:1: ( ( rule__CreateMessage__ArrowAssignment_1 ) )
            // InternalTextualScenario.g:1725:2: ( rule__CreateMessage__ArrowAssignment_1 )
            {
             before(grammarAccess.getCreateMessageAccess().getArrowAssignment_1()); 
            // InternalTextualScenario.g:1726:2: ( rule__CreateMessage__ArrowAssignment_1 )
            // InternalTextualScenario.g:1726:3: rule__CreateMessage__ArrowAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__CreateMessage__ArrowAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCreateMessageAccess().getArrowAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateMessage__Group__1__Impl"


    // $ANTLR start "rule__CreateMessage__Group__2"
    // InternalTextualScenario.g:1734:1: rule__CreateMessage__Group__2 : rule__CreateMessage__Group__2__Impl rule__CreateMessage__Group__3 ;
    public final void rule__CreateMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1738:1: ( rule__CreateMessage__Group__2__Impl rule__CreateMessage__Group__3 )
            // InternalTextualScenario.g:1739:2: rule__CreateMessage__Group__2__Impl rule__CreateMessage__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__CreateMessage__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CreateMessage__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateMessage__Group__2"


    // $ANTLR start "rule__CreateMessage__Group__2__Impl"
    // InternalTextualScenario.g:1746:1: rule__CreateMessage__Group__2__Impl : ( ( rule__CreateMessage__TargetAssignment_2 ) ) ;
    public final void rule__CreateMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1750:1: ( ( ( rule__CreateMessage__TargetAssignment_2 ) ) )
            // InternalTextualScenario.g:1751:1: ( ( rule__CreateMessage__TargetAssignment_2 ) )
            {
            // InternalTextualScenario.g:1751:1: ( ( rule__CreateMessage__TargetAssignment_2 ) )
            // InternalTextualScenario.g:1752:2: ( rule__CreateMessage__TargetAssignment_2 )
            {
             before(grammarAccess.getCreateMessageAccess().getTargetAssignment_2()); 
            // InternalTextualScenario.g:1753:2: ( rule__CreateMessage__TargetAssignment_2 )
            // InternalTextualScenario.g:1753:3: rule__CreateMessage__TargetAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__CreateMessage__TargetAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCreateMessageAccess().getTargetAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateMessage__Group__2__Impl"


    // $ANTLR start "rule__CreateMessage__Group__3"
    // InternalTextualScenario.g:1761:1: rule__CreateMessage__Group__3 : rule__CreateMessage__Group__3__Impl rule__CreateMessage__Group__4 ;
    public final void rule__CreateMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1765:1: ( rule__CreateMessage__Group__3__Impl rule__CreateMessage__Group__4 )
            // InternalTextualScenario.g:1766:2: rule__CreateMessage__Group__3__Impl rule__CreateMessage__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__CreateMessage__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CreateMessage__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateMessage__Group__3"


    // $ANTLR start "rule__CreateMessage__Group__3__Impl"
    // InternalTextualScenario.g:1773:1: rule__CreateMessage__Group__3__Impl : ( ( rule__CreateMessage__DoubleDotAssignment_3 ) ) ;
    public final void rule__CreateMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1777:1: ( ( ( rule__CreateMessage__DoubleDotAssignment_3 ) ) )
            // InternalTextualScenario.g:1778:1: ( ( rule__CreateMessage__DoubleDotAssignment_3 ) )
            {
            // InternalTextualScenario.g:1778:1: ( ( rule__CreateMessage__DoubleDotAssignment_3 ) )
            // InternalTextualScenario.g:1779:2: ( rule__CreateMessage__DoubleDotAssignment_3 )
            {
             before(grammarAccess.getCreateMessageAccess().getDoubleDotAssignment_3()); 
            // InternalTextualScenario.g:1780:2: ( rule__CreateMessage__DoubleDotAssignment_3 )
            // InternalTextualScenario.g:1780:3: rule__CreateMessage__DoubleDotAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__CreateMessage__DoubleDotAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCreateMessageAccess().getDoubleDotAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateMessage__Group__3__Impl"


    // $ANTLR start "rule__CreateMessage__Group__4"
    // InternalTextualScenario.g:1788:1: rule__CreateMessage__Group__4 : rule__CreateMessage__Group__4__Impl ;
    public final void rule__CreateMessage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1792:1: ( rule__CreateMessage__Group__4__Impl )
            // InternalTextualScenario.g:1793:2: rule__CreateMessage__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CreateMessage__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateMessage__Group__4"


    // $ANTLR start "rule__CreateMessage__Group__4__Impl"
    // InternalTextualScenario.g:1799:1: rule__CreateMessage__Group__4__Impl : ( ( rule__CreateMessage__NameAssignment_4 ) ) ;
    public final void rule__CreateMessage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1803:1: ( ( ( rule__CreateMessage__NameAssignment_4 ) ) )
            // InternalTextualScenario.g:1804:1: ( ( rule__CreateMessage__NameAssignment_4 ) )
            {
            // InternalTextualScenario.g:1804:1: ( ( rule__CreateMessage__NameAssignment_4 ) )
            // InternalTextualScenario.g:1805:2: ( rule__CreateMessage__NameAssignment_4 )
            {
             before(grammarAccess.getCreateMessageAccess().getNameAssignment_4()); 
            // InternalTextualScenario.g:1806:2: ( rule__CreateMessage__NameAssignment_4 )
            // InternalTextualScenario.g:1806:3: rule__CreateMessage__NameAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__CreateMessage__NameAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getCreateMessageAccess().getNameAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateMessage__Group__4__Impl"


    // $ANTLR start "rule__DeleteMessage__Group__0"
    // InternalTextualScenario.g:1815:1: rule__DeleteMessage__Group__0 : rule__DeleteMessage__Group__0__Impl rule__DeleteMessage__Group__1 ;
    public final void rule__DeleteMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1819:1: ( rule__DeleteMessage__Group__0__Impl rule__DeleteMessage__Group__1 )
            // InternalTextualScenario.g:1820:2: rule__DeleteMessage__Group__0__Impl rule__DeleteMessage__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__DeleteMessage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeleteMessage__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeleteMessage__Group__0"


    // $ANTLR start "rule__DeleteMessage__Group__0__Impl"
    // InternalTextualScenario.g:1827:1: rule__DeleteMessage__Group__0__Impl : ( ( rule__DeleteMessage__SourceAssignment_0 ) ) ;
    public final void rule__DeleteMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1831:1: ( ( ( rule__DeleteMessage__SourceAssignment_0 ) ) )
            // InternalTextualScenario.g:1832:1: ( ( rule__DeleteMessage__SourceAssignment_0 ) )
            {
            // InternalTextualScenario.g:1832:1: ( ( rule__DeleteMessage__SourceAssignment_0 ) )
            // InternalTextualScenario.g:1833:2: ( rule__DeleteMessage__SourceAssignment_0 )
            {
             before(grammarAccess.getDeleteMessageAccess().getSourceAssignment_0()); 
            // InternalTextualScenario.g:1834:2: ( rule__DeleteMessage__SourceAssignment_0 )
            // InternalTextualScenario.g:1834:3: rule__DeleteMessage__SourceAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__DeleteMessage__SourceAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDeleteMessageAccess().getSourceAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeleteMessage__Group__0__Impl"


    // $ANTLR start "rule__DeleteMessage__Group__1"
    // InternalTextualScenario.g:1842:1: rule__DeleteMessage__Group__1 : rule__DeleteMessage__Group__1__Impl rule__DeleteMessage__Group__2 ;
    public final void rule__DeleteMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1846:1: ( rule__DeleteMessage__Group__1__Impl rule__DeleteMessage__Group__2 )
            // InternalTextualScenario.g:1847:2: rule__DeleteMessage__Group__1__Impl rule__DeleteMessage__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__DeleteMessage__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeleteMessage__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeleteMessage__Group__1"


    // $ANTLR start "rule__DeleteMessage__Group__1__Impl"
    // InternalTextualScenario.g:1854:1: rule__DeleteMessage__Group__1__Impl : ( ( rule__DeleteMessage__ArrowAssignment_1 ) ) ;
    public final void rule__DeleteMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1858:1: ( ( ( rule__DeleteMessage__ArrowAssignment_1 ) ) )
            // InternalTextualScenario.g:1859:1: ( ( rule__DeleteMessage__ArrowAssignment_1 ) )
            {
            // InternalTextualScenario.g:1859:1: ( ( rule__DeleteMessage__ArrowAssignment_1 ) )
            // InternalTextualScenario.g:1860:2: ( rule__DeleteMessage__ArrowAssignment_1 )
            {
             before(grammarAccess.getDeleteMessageAccess().getArrowAssignment_1()); 
            // InternalTextualScenario.g:1861:2: ( rule__DeleteMessage__ArrowAssignment_1 )
            // InternalTextualScenario.g:1861:3: rule__DeleteMessage__ArrowAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DeleteMessage__ArrowAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDeleteMessageAccess().getArrowAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeleteMessage__Group__1__Impl"


    // $ANTLR start "rule__DeleteMessage__Group__2"
    // InternalTextualScenario.g:1869:1: rule__DeleteMessage__Group__2 : rule__DeleteMessage__Group__2__Impl rule__DeleteMessage__Group__3 ;
    public final void rule__DeleteMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1873:1: ( rule__DeleteMessage__Group__2__Impl rule__DeleteMessage__Group__3 )
            // InternalTextualScenario.g:1874:2: rule__DeleteMessage__Group__2__Impl rule__DeleteMessage__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__DeleteMessage__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeleteMessage__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeleteMessage__Group__2"


    // $ANTLR start "rule__DeleteMessage__Group__2__Impl"
    // InternalTextualScenario.g:1881:1: rule__DeleteMessage__Group__2__Impl : ( ( rule__DeleteMessage__TargetAssignment_2 ) ) ;
    public final void rule__DeleteMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1885:1: ( ( ( rule__DeleteMessage__TargetAssignment_2 ) ) )
            // InternalTextualScenario.g:1886:1: ( ( rule__DeleteMessage__TargetAssignment_2 ) )
            {
            // InternalTextualScenario.g:1886:1: ( ( rule__DeleteMessage__TargetAssignment_2 ) )
            // InternalTextualScenario.g:1887:2: ( rule__DeleteMessage__TargetAssignment_2 )
            {
             before(grammarAccess.getDeleteMessageAccess().getTargetAssignment_2()); 
            // InternalTextualScenario.g:1888:2: ( rule__DeleteMessage__TargetAssignment_2 )
            // InternalTextualScenario.g:1888:3: rule__DeleteMessage__TargetAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DeleteMessage__TargetAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDeleteMessageAccess().getTargetAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeleteMessage__Group__2__Impl"


    // $ANTLR start "rule__DeleteMessage__Group__3"
    // InternalTextualScenario.g:1896:1: rule__DeleteMessage__Group__3 : rule__DeleteMessage__Group__3__Impl rule__DeleteMessage__Group__4 ;
    public final void rule__DeleteMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1900:1: ( rule__DeleteMessage__Group__3__Impl rule__DeleteMessage__Group__4 )
            // InternalTextualScenario.g:1901:2: rule__DeleteMessage__Group__3__Impl rule__DeleteMessage__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__DeleteMessage__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeleteMessage__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeleteMessage__Group__3"


    // $ANTLR start "rule__DeleteMessage__Group__3__Impl"
    // InternalTextualScenario.g:1908:1: rule__DeleteMessage__Group__3__Impl : ( ( rule__DeleteMessage__DoubleDotAssignment_3 ) ) ;
    public final void rule__DeleteMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1912:1: ( ( ( rule__DeleteMessage__DoubleDotAssignment_3 ) ) )
            // InternalTextualScenario.g:1913:1: ( ( rule__DeleteMessage__DoubleDotAssignment_3 ) )
            {
            // InternalTextualScenario.g:1913:1: ( ( rule__DeleteMessage__DoubleDotAssignment_3 ) )
            // InternalTextualScenario.g:1914:2: ( rule__DeleteMessage__DoubleDotAssignment_3 )
            {
             before(grammarAccess.getDeleteMessageAccess().getDoubleDotAssignment_3()); 
            // InternalTextualScenario.g:1915:2: ( rule__DeleteMessage__DoubleDotAssignment_3 )
            // InternalTextualScenario.g:1915:3: rule__DeleteMessage__DoubleDotAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__DeleteMessage__DoubleDotAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getDeleteMessageAccess().getDoubleDotAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeleteMessage__Group__3__Impl"


    // $ANTLR start "rule__DeleteMessage__Group__4"
    // InternalTextualScenario.g:1923:1: rule__DeleteMessage__Group__4 : rule__DeleteMessage__Group__4__Impl ;
    public final void rule__DeleteMessage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1927:1: ( rule__DeleteMessage__Group__4__Impl )
            // InternalTextualScenario.g:1928:2: rule__DeleteMessage__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DeleteMessage__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeleteMessage__Group__4"


    // $ANTLR start "rule__DeleteMessage__Group__4__Impl"
    // InternalTextualScenario.g:1934:1: rule__DeleteMessage__Group__4__Impl : ( ( rule__DeleteMessage__NameAssignment_4 ) ) ;
    public final void rule__DeleteMessage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1938:1: ( ( ( rule__DeleteMessage__NameAssignment_4 ) ) )
            // InternalTextualScenario.g:1939:1: ( ( rule__DeleteMessage__NameAssignment_4 ) )
            {
            // InternalTextualScenario.g:1939:1: ( ( rule__DeleteMessage__NameAssignment_4 ) )
            // InternalTextualScenario.g:1940:2: ( rule__DeleteMessage__NameAssignment_4 )
            {
             before(grammarAccess.getDeleteMessageAccess().getNameAssignment_4()); 
            // InternalTextualScenario.g:1941:2: ( rule__DeleteMessage__NameAssignment_4 )
            // InternalTextualScenario.g:1941:3: rule__DeleteMessage__NameAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__DeleteMessage__NameAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDeleteMessageAccess().getNameAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeleteMessage__Group__4__Impl"


    // $ANTLR start "rule__ArmTimerMessage__Group__0"
    // InternalTextualScenario.g:1950:1: rule__ArmTimerMessage__Group__0 : rule__ArmTimerMessage__Group__0__Impl rule__ArmTimerMessage__Group__1 ;
    public final void rule__ArmTimerMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1954:1: ( rule__ArmTimerMessage__Group__0__Impl rule__ArmTimerMessage__Group__1 )
            // InternalTextualScenario.g:1955:2: rule__ArmTimerMessage__Group__0__Impl rule__ArmTimerMessage__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__ArmTimerMessage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArmTimerMessage__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArmTimerMessage__Group__0"


    // $ANTLR start "rule__ArmTimerMessage__Group__0__Impl"
    // InternalTextualScenario.g:1962:1: rule__ArmTimerMessage__Group__0__Impl : ( ( rule__ArmTimerMessage__ArrowAssignment_0 ) ) ;
    public final void rule__ArmTimerMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1966:1: ( ( ( rule__ArmTimerMessage__ArrowAssignment_0 ) ) )
            // InternalTextualScenario.g:1967:1: ( ( rule__ArmTimerMessage__ArrowAssignment_0 ) )
            {
            // InternalTextualScenario.g:1967:1: ( ( rule__ArmTimerMessage__ArrowAssignment_0 ) )
            // InternalTextualScenario.g:1968:2: ( rule__ArmTimerMessage__ArrowAssignment_0 )
            {
             before(grammarAccess.getArmTimerMessageAccess().getArrowAssignment_0()); 
            // InternalTextualScenario.g:1969:2: ( rule__ArmTimerMessage__ArrowAssignment_0 )
            // InternalTextualScenario.g:1969:3: rule__ArmTimerMessage__ArrowAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ArmTimerMessage__ArrowAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getArmTimerMessageAccess().getArrowAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArmTimerMessage__Group__0__Impl"


    // $ANTLR start "rule__ArmTimerMessage__Group__1"
    // InternalTextualScenario.g:1977:1: rule__ArmTimerMessage__Group__1 : rule__ArmTimerMessage__Group__1__Impl rule__ArmTimerMessage__Group__2 ;
    public final void rule__ArmTimerMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1981:1: ( rule__ArmTimerMessage__Group__1__Impl rule__ArmTimerMessage__Group__2 )
            // InternalTextualScenario.g:1982:2: rule__ArmTimerMessage__Group__1__Impl rule__ArmTimerMessage__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__ArmTimerMessage__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArmTimerMessage__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArmTimerMessage__Group__1"


    // $ANTLR start "rule__ArmTimerMessage__Group__1__Impl"
    // InternalTextualScenario.g:1989:1: rule__ArmTimerMessage__Group__1__Impl : ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) ) ;
    public final void rule__ArmTimerMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1993:1: ( ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) ) )
            // InternalTextualScenario.g:1994:1: ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) )
            {
            // InternalTextualScenario.g:1994:1: ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) )
            // InternalTextualScenario.g:1995:2: ( rule__ArmTimerMessage__ParticipantAssignment_1 )
            {
             before(grammarAccess.getArmTimerMessageAccess().getParticipantAssignment_1()); 
            // InternalTextualScenario.g:1996:2: ( rule__ArmTimerMessage__ParticipantAssignment_1 )
            // InternalTextualScenario.g:1996:3: rule__ArmTimerMessage__ParticipantAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ArmTimerMessage__ParticipantAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getArmTimerMessageAccess().getParticipantAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArmTimerMessage__Group__1__Impl"


    // $ANTLR start "rule__ArmTimerMessage__Group__2"
    // InternalTextualScenario.g:2004:1: rule__ArmTimerMessage__Group__2 : rule__ArmTimerMessage__Group__2__Impl rule__ArmTimerMessage__Group__3 ;
    public final void rule__ArmTimerMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2008:1: ( rule__ArmTimerMessage__Group__2__Impl rule__ArmTimerMessage__Group__3 )
            // InternalTextualScenario.g:2009:2: rule__ArmTimerMessage__Group__2__Impl rule__ArmTimerMessage__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__ArmTimerMessage__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArmTimerMessage__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArmTimerMessage__Group__2"


    // $ANTLR start "rule__ArmTimerMessage__Group__2__Impl"
    // InternalTextualScenario.g:2016:1: rule__ArmTimerMessage__Group__2__Impl : ( ( rule__ArmTimerMessage__DoubleDotAssignment_2 ) ) ;
    public final void rule__ArmTimerMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2020:1: ( ( ( rule__ArmTimerMessage__DoubleDotAssignment_2 ) ) )
            // InternalTextualScenario.g:2021:1: ( ( rule__ArmTimerMessage__DoubleDotAssignment_2 ) )
            {
            // InternalTextualScenario.g:2021:1: ( ( rule__ArmTimerMessage__DoubleDotAssignment_2 ) )
            // InternalTextualScenario.g:2022:2: ( rule__ArmTimerMessage__DoubleDotAssignment_2 )
            {
             before(grammarAccess.getArmTimerMessageAccess().getDoubleDotAssignment_2()); 
            // InternalTextualScenario.g:2023:2: ( rule__ArmTimerMessage__DoubleDotAssignment_2 )
            // InternalTextualScenario.g:2023:3: rule__ArmTimerMessage__DoubleDotAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ArmTimerMessage__DoubleDotAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getArmTimerMessageAccess().getDoubleDotAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArmTimerMessage__Group__2__Impl"


    // $ANTLR start "rule__ArmTimerMessage__Group__3"
    // InternalTextualScenario.g:2031:1: rule__ArmTimerMessage__Group__3 : rule__ArmTimerMessage__Group__3__Impl ;
    public final void rule__ArmTimerMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2035:1: ( rule__ArmTimerMessage__Group__3__Impl )
            // InternalTextualScenario.g:2036:2: rule__ArmTimerMessage__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArmTimerMessage__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArmTimerMessage__Group__3"


    // $ANTLR start "rule__ArmTimerMessage__Group__3__Impl"
    // InternalTextualScenario.g:2042:1: rule__ArmTimerMessage__Group__3__Impl : ( ( rule__ArmTimerMessage__NameAssignment_3 ) ) ;
    public final void rule__ArmTimerMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2046:1: ( ( ( rule__ArmTimerMessage__NameAssignment_3 ) ) )
            // InternalTextualScenario.g:2047:1: ( ( rule__ArmTimerMessage__NameAssignment_3 ) )
            {
            // InternalTextualScenario.g:2047:1: ( ( rule__ArmTimerMessage__NameAssignment_3 ) )
            // InternalTextualScenario.g:2048:2: ( rule__ArmTimerMessage__NameAssignment_3 )
            {
             before(grammarAccess.getArmTimerMessageAccess().getNameAssignment_3()); 
            // InternalTextualScenario.g:2049:2: ( rule__ArmTimerMessage__NameAssignment_3 )
            // InternalTextualScenario.g:2049:3: rule__ArmTimerMessage__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ArmTimerMessage__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getArmTimerMessageAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArmTimerMessage__Group__3__Impl"


    // $ANTLR start "rule__ParticipantDeactivation__Group__0"
    // InternalTextualScenario.g:2058:1: rule__ParticipantDeactivation__Group__0 : rule__ParticipantDeactivation__Group__0__Impl rule__ParticipantDeactivation__Group__1 ;
    public final void rule__ParticipantDeactivation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2062:1: ( rule__ParticipantDeactivation__Group__0__Impl rule__ParticipantDeactivation__Group__1 )
            // InternalTextualScenario.g:2063:2: rule__ParticipantDeactivation__Group__0__Impl rule__ParticipantDeactivation__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__ParticipantDeactivation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParticipantDeactivation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParticipantDeactivation__Group__0"


    // $ANTLR start "rule__ParticipantDeactivation__Group__0__Impl"
    // InternalTextualScenario.g:2070:1: rule__ParticipantDeactivation__Group__0__Impl : ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) ) ;
    public final void rule__ParticipantDeactivation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2074:1: ( ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:2075:1: ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:2075:1: ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:2076:2: ( rule__ParticipantDeactivation__KeywordAssignment_0 )
            {
             before(grammarAccess.getParticipantDeactivationAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:2077:2: ( rule__ParticipantDeactivation__KeywordAssignment_0 )
            // InternalTextualScenario.g:2077:3: rule__ParticipantDeactivation__KeywordAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ParticipantDeactivation__KeywordAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getParticipantDeactivationAccess().getKeywordAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParticipantDeactivation__Group__0__Impl"


    // $ANTLR start "rule__ParticipantDeactivation__Group__1"
    // InternalTextualScenario.g:2085:1: rule__ParticipantDeactivation__Group__1 : rule__ParticipantDeactivation__Group__1__Impl ;
    public final void rule__ParticipantDeactivation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2089:1: ( rule__ParticipantDeactivation__Group__1__Impl )
            // InternalTextualScenario.g:2090:2: rule__ParticipantDeactivation__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParticipantDeactivation__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParticipantDeactivation__Group__1"


    // $ANTLR start "rule__ParticipantDeactivation__Group__1__Impl"
    // InternalTextualScenario.g:2096:1: rule__ParticipantDeactivation__Group__1__Impl : ( ( rule__ParticipantDeactivation__NameAssignment_1 ) ) ;
    public final void rule__ParticipantDeactivation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2100:1: ( ( ( rule__ParticipantDeactivation__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:2101:1: ( ( rule__ParticipantDeactivation__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:2101:1: ( ( rule__ParticipantDeactivation__NameAssignment_1 ) )
            // InternalTextualScenario.g:2102:2: ( rule__ParticipantDeactivation__NameAssignment_1 )
            {
             before(grammarAccess.getParticipantDeactivationAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:2103:2: ( rule__ParticipantDeactivation__NameAssignment_1 )
            // InternalTextualScenario.g:2103:3: rule__ParticipantDeactivation__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ParticipantDeactivation__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParticipantDeactivationAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParticipantDeactivation__Group__1__Impl"


    // $ANTLR start "rule__Reference__Group__0"
    // InternalTextualScenario.g:2112:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2116:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // InternalTextualScenario.g:2117:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__Reference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Reference__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__0"


    // $ANTLR start "rule__Reference__Group__0__Impl"
    // InternalTextualScenario.g:2124:1: rule__Reference__Group__0__Impl : ( ( rule__Reference__KeywordAssignment_0 ) ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2128:1: ( ( ( rule__Reference__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:2129:1: ( ( rule__Reference__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:2129:1: ( ( rule__Reference__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:2130:2: ( rule__Reference__KeywordAssignment_0 )
            {
             before(grammarAccess.getReferenceAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:2131:2: ( rule__Reference__KeywordAssignment_0 )
            // InternalTextualScenario.g:2131:3: rule__Reference__KeywordAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Reference__KeywordAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getKeywordAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__0__Impl"


    // $ANTLR start "rule__Reference__Group__1"
    // InternalTextualScenario.g:2139:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2143:1: ( rule__Reference__Group__1__Impl rule__Reference__Group__2 )
            // InternalTextualScenario.g:2144:2: rule__Reference__Group__1__Impl rule__Reference__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Reference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Reference__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__1"


    // $ANTLR start "rule__Reference__Group__1__Impl"
    // InternalTextualScenario.g:2151:1: rule__Reference__Group__1__Impl : ( ( rule__Reference__OverAssignment_1 ) ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2155:1: ( ( ( rule__Reference__OverAssignment_1 ) ) )
            // InternalTextualScenario.g:2156:1: ( ( rule__Reference__OverAssignment_1 ) )
            {
            // InternalTextualScenario.g:2156:1: ( ( rule__Reference__OverAssignment_1 ) )
            // InternalTextualScenario.g:2157:2: ( rule__Reference__OverAssignment_1 )
            {
             before(grammarAccess.getReferenceAccess().getOverAssignment_1()); 
            // InternalTextualScenario.g:2158:2: ( rule__Reference__OverAssignment_1 )
            // InternalTextualScenario.g:2158:3: rule__Reference__OverAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Reference__OverAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getOverAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__1__Impl"


    // $ANTLR start "rule__Reference__Group__2"
    // InternalTextualScenario.g:2166:1: rule__Reference__Group__2 : rule__Reference__Group__2__Impl rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2170:1: ( rule__Reference__Group__2__Impl rule__Reference__Group__3 )
            // InternalTextualScenario.g:2171:2: rule__Reference__Group__2__Impl rule__Reference__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Reference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Reference__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__2"


    // $ANTLR start "rule__Reference__Group__2__Impl"
    // InternalTextualScenario.g:2178:1: rule__Reference__Group__2__Impl : ( ( ( rule__Reference__TimelinesAssignment_2 ) ) ( ( rule__Reference__TimelinesAssignment_2 )* ) ) ;
    public final void rule__Reference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2182:1: ( ( ( ( rule__Reference__TimelinesAssignment_2 ) ) ( ( rule__Reference__TimelinesAssignment_2 )* ) ) )
            // InternalTextualScenario.g:2183:1: ( ( ( rule__Reference__TimelinesAssignment_2 ) ) ( ( rule__Reference__TimelinesAssignment_2 )* ) )
            {
            // InternalTextualScenario.g:2183:1: ( ( ( rule__Reference__TimelinesAssignment_2 ) ) ( ( rule__Reference__TimelinesAssignment_2 )* ) )
            // InternalTextualScenario.g:2184:2: ( ( rule__Reference__TimelinesAssignment_2 ) ) ( ( rule__Reference__TimelinesAssignment_2 )* )
            {
            // InternalTextualScenario.g:2184:2: ( ( rule__Reference__TimelinesAssignment_2 ) )
            // InternalTextualScenario.g:2185:3: ( rule__Reference__TimelinesAssignment_2 )
            {
             before(grammarAccess.getReferenceAccess().getTimelinesAssignment_2()); 
            // InternalTextualScenario.g:2186:3: ( rule__Reference__TimelinesAssignment_2 )
            // InternalTextualScenario.g:2186:4: rule__Reference__TimelinesAssignment_2
            {
            pushFollow(FOLLOW_15);
            rule__Reference__TimelinesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getTimelinesAssignment_2()); 

            }

            // InternalTextualScenario.g:2189:2: ( ( rule__Reference__TimelinesAssignment_2 )* )
            // InternalTextualScenario.g:2190:3: ( rule__Reference__TimelinesAssignment_2 )*
            {
             before(grammarAccess.getReferenceAccess().getTimelinesAssignment_2()); 
            // InternalTextualScenario.g:2191:3: ( rule__Reference__TimelinesAssignment_2 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_STRING) ) {
                    int LA16_1 = input.LA(2);

                    if ( (LA16_1==RULE_STRING) ) {
                        int LA16_2 = input.LA(3);

                        if ( (LA16_2==EOF||LA16_2==RULE_STRING||(LA16_2>=14 && LA16_2<=23)||LA16_2==29||(LA16_2>=42 && LA16_2<=44)||LA16_2==47) ) {
                            alt16=1;
                        }


                    }


                }


                switch (alt16) {
            	case 1 :
            	    // InternalTextualScenario.g:2191:4: rule__Reference__TimelinesAssignment_2
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Reference__TimelinesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getReferenceAccess().getTimelinesAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__2__Impl"


    // $ANTLR start "rule__Reference__Group__3"
    // InternalTextualScenario.g:2200:1: rule__Reference__Group__3 : rule__Reference__Group__3__Impl ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2204:1: ( rule__Reference__Group__3__Impl )
            // InternalTextualScenario.g:2205:2: rule__Reference__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Reference__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__3"


    // $ANTLR start "rule__Reference__Group__3__Impl"
    // InternalTextualScenario.g:2211:1: rule__Reference__Group__3__Impl : ( ( rule__Reference__NameAssignment_3 ) ) ;
    public final void rule__Reference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2215:1: ( ( ( rule__Reference__NameAssignment_3 ) ) )
            // InternalTextualScenario.g:2216:1: ( ( rule__Reference__NameAssignment_3 ) )
            {
            // InternalTextualScenario.g:2216:1: ( ( rule__Reference__NameAssignment_3 ) )
            // InternalTextualScenario.g:2217:2: ( rule__Reference__NameAssignment_3 )
            {
             before(grammarAccess.getReferenceAccess().getNameAssignment_3()); 
            // InternalTextualScenario.g:2218:2: ( rule__Reference__NameAssignment_3 )
            // InternalTextualScenario.g:2218:3: rule__Reference__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Reference__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__3__Impl"


    // $ANTLR start "rule__CombinedFragment__Group__0"
    // InternalTextualScenario.g:2227:1: rule__CombinedFragment__Group__0 : rule__CombinedFragment__Group__0__Impl rule__CombinedFragment__Group__1 ;
    public final void rule__CombinedFragment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2231:1: ( rule__CombinedFragment__Group__0__Impl rule__CombinedFragment__Group__1 )
            // InternalTextualScenario.g:2232:2: rule__CombinedFragment__Group__0__Impl rule__CombinedFragment__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__CombinedFragment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CombinedFragment__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__Group__0"


    // $ANTLR start "rule__CombinedFragment__Group__0__Impl"
    // InternalTextualScenario.g:2239:1: rule__CombinedFragment__Group__0__Impl : ( ( rule__CombinedFragment__KeywordAssignment_0 )? ) ;
    public final void rule__CombinedFragment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2243:1: ( ( ( rule__CombinedFragment__KeywordAssignment_0 )? ) )
            // InternalTextualScenario.g:2244:1: ( ( rule__CombinedFragment__KeywordAssignment_0 )? )
            {
            // InternalTextualScenario.g:2244:1: ( ( rule__CombinedFragment__KeywordAssignment_0 )? )
            // InternalTextualScenario.g:2245:2: ( rule__CombinedFragment__KeywordAssignment_0 )?
            {
             before(grammarAccess.getCombinedFragmentAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:2246:2: ( rule__CombinedFragment__KeywordAssignment_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=14 && LA17_0<=23)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalTextualScenario.g:2246:3: rule__CombinedFragment__KeywordAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CombinedFragment__KeywordAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCombinedFragmentAccess().getKeywordAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__Group__0__Impl"


    // $ANTLR start "rule__CombinedFragment__Group__1"
    // InternalTextualScenario.g:2254:1: rule__CombinedFragment__Group__1 : rule__CombinedFragment__Group__1__Impl rule__CombinedFragment__Group__2 ;
    public final void rule__CombinedFragment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2258:1: ( rule__CombinedFragment__Group__1__Impl rule__CombinedFragment__Group__2 )
            // InternalTextualScenario.g:2259:2: rule__CombinedFragment__Group__1__Impl rule__CombinedFragment__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__CombinedFragment__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CombinedFragment__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__Group__1"


    // $ANTLR start "rule__CombinedFragment__Group__1__Impl"
    // InternalTextualScenario.g:2266:1: rule__CombinedFragment__Group__1__Impl : ( ( rule__CombinedFragment__ExpressionAssignment_1 ) ) ;
    public final void rule__CombinedFragment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2270:1: ( ( ( rule__CombinedFragment__ExpressionAssignment_1 ) ) )
            // InternalTextualScenario.g:2271:1: ( ( rule__CombinedFragment__ExpressionAssignment_1 ) )
            {
            // InternalTextualScenario.g:2271:1: ( ( rule__CombinedFragment__ExpressionAssignment_1 ) )
            // InternalTextualScenario.g:2272:2: ( rule__CombinedFragment__ExpressionAssignment_1 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getExpressionAssignment_1()); 
            // InternalTextualScenario.g:2273:2: ( rule__CombinedFragment__ExpressionAssignment_1 )
            // InternalTextualScenario.g:2273:3: rule__CombinedFragment__ExpressionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__CombinedFragment__ExpressionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCombinedFragmentAccess().getExpressionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__Group__1__Impl"


    // $ANTLR start "rule__CombinedFragment__Group__2"
    // InternalTextualScenario.g:2281:1: rule__CombinedFragment__Group__2 : rule__CombinedFragment__Group__2__Impl rule__CombinedFragment__Group__3 ;
    public final void rule__CombinedFragment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2285:1: ( rule__CombinedFragment__Group__2__Impl rule__CombinedFragment__Group__3 )
            // InternalTextualScenario.g:2286:2: rule__CombinedFragment__Group__2__Impl rule__CombinedFragment__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__CombinedFragment__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CombinedFragment__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__Group__2"


    // $ANTLR start "rule__CombinedFragment__Group__2__Impl"
    // InternalTextualScenario.g:2293:1: rule__CombinedFragment__Group__2__Impl : ( ( rule__CombinedFragment__OverAssignment_2 ) ) ;
    public final void rule__CombinedFragment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2297:1: ( ( ( rule__CombinedFragment__OverAssignment_2 ) ) )
            // InternalTextualScenario.g:2298:1: ( ( rule__CombinedFragment__OverAssignment_2 ) )
            {
            // InternalTextualScenario.g:2298:1: ( ( rule__CombinedFragment__OverAssignment_2 ) )
            // InternalTextualScenario.g:2299:2: ( rule__CombinedFragment__OverAssignment_2 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getOverAssignment_2()); 
            // InternalTextualScenario.g:2300:2: ( rule__CombinedFragment__OverAssignment_2 )
            // InternalTextualScenario.g:2300:3: rule__CombinedFragment__OverAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__CombinedFragment__OverAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCombinedFragmentAccess().getOverAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__Group__2__Impl"


    // $ANTLR start "rule__CombinedFragment__Group__3"
    // InternalTextualScenario.g:2308:1: rule__CombinedFragment__Group__3 : rule__CombinedFragment__Group__3__Impl rule__CombinedFragment__Group__4 ;
    public final void rule__CombinedFragment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2312:1: ( rule__CombinedFragment__Group__3__Impl rule__CombinedFragment__Group__4 )
            // InternalTextualScenario.g:2313:2: rule__CombinedFragment__Group__3__Impl rule__CombinedFragment__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__CombinedFragment__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CombinedFragment__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__Group__3"


    // $ANTLR start "rule__CombinedFragment__Group__3__Impl"
    // InternalTextualScenario.g:2320:1: rule__CombinedFragment__Group__3__Impl : ( ( ( rule__CombinedFragment__TimelinesAssignment_3 ) ) ( ( rule__CombinedFragment__TimelinesAssignment_3 )* ) ) ;
    public final void rule__CombinedFragment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2324:1: ( ( ( ( rule__CombinedFragment__TimelinesAssignment_3 ) ) ( ( rule__CombinedFragment__TimelinesAssignment_3 )* ) ) )
            // InternalTextualScenario.g:2325:1: ( ( ( rule__CombinedFragment__TimelinesAssignment_3 ) ) ( ( rule__CombinedFragment__TimelinesAssignment_3 )* ) )
            {
            // InternalTextualScenario.g:2325:1: ( ( ( rule__CombinedFragment__TimelinesAssignment_3 ) ) ( ( rule__CombinedFragment__TimelinesAssignment_3 )* ) )
            // InternalTextualScenario.g:2326:2: ( ( rule__CombinedFragment__TimelinesAssignment_3 ) ) ( ( rule__CombinedFragment__TimelinesAssignment_3 )* )
            {
            // InternalTextualScenario.g:2326:2: ( ( rule__CombinedFragment__TimelinesAssignment_3 ) )
            // InternalTextualScenario.g:2327:3: ( rule__CombinedFragment__TimelinesAssignment_3 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getTimelinesAssignment_3()); 
            // InternalTextualScenario.g:2328:3: ( rule__CombinedFragment__TimelinesAssignment_3 )
            // InternalTextualScenario.g:2328:4: rule__CombinedFragment__TimelinesAssignment_3
            {
            pushFollow(FOLLOW_15);
            rule__CombinedFragment__TimelinesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCombinedFragmentAccess().getTimelinesAssignment_3()); 

            }

            // InternalTextualScenario.g:2331:2: ( ( rule__CombinedFragment__TimelinesAssignment_3 )* )
            // InternalTextualScenario.g:2332:3: ( rule__CombinedFragment__TimelinesAssignment_3 )*
            {
             before(grammarAccess.getCombinedFragmentAccess().getTimelinesAssignment_3()); 
            // InternalTextualScenario.g:2333:3: ( rule__CombinedFragment__TimelinesAssignment_3 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_STRING) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalTextualScenario.g:2333:4: rule__CombinedFragment__TimelinesAssignment_3
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__CombinedFragment__TimelinesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getCombinedFragmentAccess().getTimelinesAssignment_3()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__Group__3__Impl"


    // $ANTLR start "rule__CombinedFragment__Group__4"
    // InternalTextualScenario.g:2342:1: rule__CombinedFragment__Group__4 : rule__CombinedFragment__Group__4__Impl rule__CombinedFragment__Group__5 ;
    public final void rule__CombinedFragment__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2346:1: ( rule__CombinedFragment__Group__4__Impl rule__CombinedFragment__Group__5 )
            // InternalTextualScenario.g:2347:2: rule__CombinedFragment__Group__4__Impl rule__CombinedFragment__Group__5
            {
            pushFollow(FOLLOW_17);
            rule__CombinedFragment__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CombinedFragment__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__Group__4"


    // $ANTLR start "rule__CombinedFragment__Group__4__Impl"
    // InternalTextualScenario.g:2354:1: rule__CombinedFragment__Group__4__Impl : ( ( rule__CombinedFragment__BlockAssignment_4 ) ) ;
    public final void rule__CombinedFragment__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2358:1: ( ( ( rule__CombinedFragment__BlockAssignment_4 ) ) )
            // InternalTextualScenario.g:2359:1: ( ( rule__CombinedFragment__BlockAssignment_4 ) )
            {
            // InternalTextualScenario.g:2359:1: ( ( rule__CombinedFragment__BlockAssignment_4 ) )
            // InternalTextualScenario.g:2360:2: ( rule__CombinedFragment__BlockAssignment_4 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getBlockAssignment_4()); 
            // InternalTextualScenario.g:2361:2: ( rule__CombinedFragment__BlockAssignment_4 )
            // InternalTextualScenario.g:2361:3: rule__CombinedFragment__BlockAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__CombinedFragment__BlockAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getCombinedFragmentAccess().getBlockAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__Group__4__Impl"


    // $ANTLR start "rule__CombinedFragment__Group__5"
    // InternalTextualScenario.g:2369:1: rule__CombinedFragment__Group__5 : rule__CombinedFragment__Group__5__Impl ;
    public final void rule__CombinedFragment__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2373:1: ( rule__CombinedFragment__Group__5__Impl )
            // InternalTextualScenario.g:2374:2: rule__CombinedFragment__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CombinedFragment__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__Group__5"


    // $ANTLR start "rule__CombinedFragment__Group__5__Impl"
    // InternalTextualScenario.g:2380:1: rule__CombinedFragment__Group__5__Impl : ( ( rule__CombinedFragment__OperandsAssignment_5 )* ) ;
    public final void rule__CombinedFragment__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2384:1: ( ( ( rule__CombinedFragment__OperandsAssignment_5 )* ) )
            // InternalTextualScenario.g:2385:1: ( ( rule__CombinedFragment__OperandsAssignment_5 )* )
            {
            // InternalTextualScenario.g:2385:1: ( ( rule__CombinedFragment__OperandsAssignment_5 )* )
            // InternalTextualScenario.g:2386:2: ( rule__CombinedFragment__OperandsAssignment_5 )*
            {
             before(grammarAccess.getCombinedFragmentAccess().getOperandsAssignment_5()); 
            // InternalTextualScenario.g:2387:2: ( rule__CombinedFragment__OperandsAssignment_5 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_STRING) ) {
                    int LA19_2 = input.LA(2);

                    if ( (LA19_2==28) ) {
                        alt19=1;
                    }


                }
                else if ( (LA19_0==46) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalTextualScenario.g:2387:3: rule__CombinedFragment__OperandsAssignment_5
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__CombinedFragment__OperandsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getCombinedFragmentAccess().getOperandsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__Group__5__Impl"


    // $ANTLR start "rule__Operand__Group__0"
    // InternalTextualScenario.g:2396:1: rule__Operand__Group__0 : rule__Operand__Group__0__Impl rule__Operand__Group__1 ;
    public final void rule__Operand__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2400:1: ( rule__Operand__Group__0__Impl rule__Operand__Group__1 )
            // InternalTextualScenario.g:2401:2: rule__Operand__Group__0__Impl rule__Operand__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__Operand__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operand__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operand__Group__0"


    // $ANTLR start "rule__Operand__Group__0__Impl"
    // InternalTextualScenario.g:2408:1: rule__Operand__Group__0__Impl : ( ( rule__Operand__KeywordAssignment_0 )? ) ;
    public final void rule__Operand__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2412:1: ( ( ( rule__Operand__KeywordAssignment_0 )? ) )
            // InternalTextualScenario.g:2413:1: ( ( rule__Operand__KeywordAssignment_0 )? )
            {
            // InternalTextualScenario.g:2413:1: ( ( rule__Operand__KeywordAssignment_0 )? )
            // InternalTextualScenario.g:2414:2: ( rule__Operand__KeywordAssignment_0 )?
            {
             before(grammarAccess.getOperandAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:2415:2: ( rule__Operand__KeywordAssignment_0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==46) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTextualScenario.g:2415:3: rule__Operand__KeywordAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Operand__KeywordAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOperandAccess().getKeywordAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operand__Group__0__Impl"


    // $ANTLR start "rule__Operand__Group__1"
    // InternalTextualScenario.g:2423:1: rule__Operand__Group__1 : rule__Operand__Group__1__Impl rule__Operand__Group__2 ;
    public final void rule__Operand__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2427:1: ( rule__Operand__Group__1__Impl rule__Operand__Group__2 )
            // InternalTextualScenario.g:2428:2: rule__Operand__Group__1__Impl rule__Operand__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__Operand__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operand__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operand__Group__1"


    // $ANTLR start "rule__Operand__Group__1__Impl"
    // InternalTextualScenario.g:2435:1: rule__Operand__Group__1__Impl : ( ( rule__Operand__ExpressionAssignment_1 ) ) ;
    public final void rule__Operand__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2439:1: ( ( ( rule__Operand__ExpressionAssignment_1 ) ) )
            // InternalTextualScenario.g:2440:1: ( ( rule__Operand__ExpressionAssignment_1 ) )
            {
            // InternalTextualScenario.g:2440:1: ( ( rule__Operand__ExpressionAssignment_1 ) )
            // InternalTextualScenario.g:2441:2: ( rule__Operand__ExpressionAssignment_1 )
            {
             before(grammarAccess.getOperandAccess().getExpressionAssignment_1()); 
            // InternalTextualScenario.g:2442:2: ( rule__Operand__ExpressionAssignment_1 )
            // InternalTextualScenario.g:2442:3: rule__Operand__ExpressionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Operand__ExpressionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOperandAccess().getExpressionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operand__Group__1__Impl"


    // $ANTLR start "rule__Operand__Group__2"
    // InternalTextualScenario.g:2450:1: rule__Operand__Group__2 : rule__Operand__Group__2__Impl ;
    public final void rule__Operand__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2454:1: ( rule__Operand__Group__2__Impl )
            // InternalTextualScenario.g:2455:2: rule__Operand__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Operand__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operand__Group__2"


    // $ANTLR start "rule__Operand__Group__2__Impl"
    // InternalTextualScenario.g:2461:1: rule__Operand__Group__2__Impl : ( ( rule__Operand__BlockAssignment_2 ) ) ;
    public final void rule__Operand__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2465:1: ( ( ( rule__Operand__BlockAssignment_2 ) ) )
            // InternalTextualScenario.g:2466:1: ( ( rule__Operand__BlockAssignment_2 ) )
            {
            // InternalTextualScenario.g:2466:1: ( ( rule__Operand__BlockAssignment_2 ) )
            // InternalTextualScenario.g:2467:2: ( rule__Operand__BlockAssignment_2 )
            {
             before(grammarAccess.getOperandAccess().getBlockAssignment_2()); 
            // InternalTextualScenario.g:2468:2: ( rule__Operand__BlockAssignment_2 )
            // InternalTextualScenario.g:2468:3: rule__Operand__BlockAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Operand__BlockAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOperandAccess().getBlockAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operand__Group__2__Impl"


    // $ANTLR start "rule__Block__Group__0"
    // InternalTextualScenario.g:2477:1: rule__Block__Group__0 : rule__Block__Group__0__Impl rule__Block__Group__1 ;
    public final void rule__Block__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2481:1: ( rule__Block__Group__0__Impl rule__Block__Group__1 )
            // InternalTextualScenario.g:2482:2: rule__Block__Group__0__Impl rule__Block__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__Block__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Block__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__0"


    // $ANTLR start "rule__Block__Group__0__Impl"
    // InternalTextualScenario.g:2489:1: rule__Block__Group__0__Impl : ( ( rule__Block__BeginAssignment_0 ) ) ;
    public final void rule__Block__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2493:1: ( ( ( rule__Block__BeginAssignment_0 ) ) )
            // InternalTextualScenario.g:2494:1: ( ( rule__Block__BeginAssignment_0 ) )
            {
            // InternalTextualScenario.g:2494:1: ( ( rule__Block__BeginAssignment_0 ) )
            // InternalTextualScenario.g:2495:2: ( rule__Block__BeginAssignment_0 )
            {
             before(grammarAccess.getBlockAccess().getBeginAssignment_0()); 
            // InternalTextualScenario.g:2496:2: ( rule__Block__BeginAssignment_0 )
            // InternalTextualScenario.g:2496:3: rule__Block__BeginAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Block__BeginAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getBlockAccess().getBeginAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__0__Impl"


    // $ANTLR start "rule__Block__Group__1"
    // InternalTextualScenario.g:2504:1: rule__Block__Group__1 : rule__Block__Group__1__Impl rule__Block__Group__2 ;
    public final void rule__Block__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2508:1: ( rule__Block__Group__1__Impl rule__Block__Group__2 )
            // InternalTextualScenario.g:2509:2: rule__Block__Group__1__Impl rule__Block__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__Block__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Block__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__1"


    // $ANTLR start "rule__Block__Group__1__Impl"
    // InternalTextualScenario.g:2516:1: rule__Block__Group__1__Impl : ( ( rule__Block__BlockElementsAssignment_1 )* ) ;
    public final void rule__Block__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2520:1: ( ( ( rule__Block__BlockElementsAssignment_1 )* ) )
            // InternalTextualScenario.g:2521:1: ( ( rule__Block__BlockElementsAssignment_1 )* )
            {
            // InternalTextualScenario.g:2521:1: ( ( rule__Block__BlockElementsAssignment_1 )* )
            // InternalTextualScenario.g:2522:2: ( rule__Block__BlockElementsAssignment_1 )*
            {
             before(grammarAccess.getBlockAccess().getBlockElementsAssignment_1()); 
            // InternalTextualScenario.g:2523:2: ( rule__Block__BlockElementsAssignment_1 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_STRING||(LA21_0>=14 && LA21_0<=23)||(LA21_0>=42 && LA21_0<=44)||LA21_0==47) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalTextualScenario.g:2523:3: rule__Block__BlockElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Block__BlockElementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getBlockAccess().getBlockElementsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__1__Impl"


    // $ANTLR start "rule__Block__Group__2"
    // InternalTextualScenario.g:2531:1: rule__Block__Group__2 : rule__Block__Group__2__Impl ;
    public final void rule__Block__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2535:1: ( rule__Block__Group__2__Impl )
            // InternalTextualScenario.g:2536:2: rule__Block__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Block__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__2"


    // $ANTLR start "rule__Block__Group__2__Impl"
    // InternalTextualScenario.g:2542:1: rule__Block__Group__2__Impl : ( ( rule__Block__EndAssignment_2 ) ) ;
    public final void rule__Block__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2546:1: ( ( ( rule__Block__EndAssignment_2 ) ) )
            // InternalTextualScenario.g:2547:1: ( ( rule__Block__EndAssignment_2 ) )
            {
            // InternalTextualScenario.g:2547:1: ( ( rule__Block__EndAssignment_2 ) )
            // InternalTextualScenario.g:2548:2: ( rule__Block__EndAssignment_2 )
            {
             before(grammarAccess.getBlockAccess().getEndAssignment_2()); 
            // InternalTextualScenario.g:2549:2: ( rule__Block__EndAssignment_2 )
            // InternalTextualScenario.g:2549:3: rule__Block__EndAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Block__EndAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBlockAccess().getEndAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__2__Impl"


    // $ANTLR start "rule__StateFragment__Group__0"
    // InternalTextualScenario.g:2558:1: rule__StateFragment__Group__0 : rule__StateFragment__Group__0__Impl rule__StateFragment__Group__1 ;
    public final void rule__StateFragment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2562:1: ( rule__StateFragment__Group__0__Impl rule__StateFragment__Group__1 )
            // InternalTextualScenario.g:2563:2: rule__StateFragment__Group__0__Impl rule__StateFragment__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__StateFragment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StateFragment__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateFragment__Group__0"


    // $ANTLR start "rule__StateFragment__Group__0__Impl"
    // InternalTextualScenario.g:2570:1: rule__StateFragment__Group__0__Impl : ( ( rule__StateFragment__OnAssignment_0 ) ) ;
    public final void rule__StateFragment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2574:1: ( ( ( rule__StateFragment__OnAssignment_0 ) ) )
            // InternalTextualScenario.g:2575:1: ( ( rule__StateFragment__OnAssignment_0 ) )
            {
            // InternalTextualScenario.g:2575:1: ( ( rule__StateFragment__OnAssignment_0 ) )
            // InternalTextualScenario.g:2576:2: ( rule__StateFragment__OnAssignment_0 )
            {
             before(grammarAccess.getStateFragmentAccess().getOnAssignment_0()); 
            // InternalTextualScenario.g:2577:2: ( rule__StateFragment__OnAssignment_0 )
            // InternalTextualScenario.g:2577:3: rule__StateFragment__OnAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__StateFragment__OnAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getStateFragmentAccess().getOnAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateFragment__Group__0__Impl"


    // $ANTLR start "rule__StateFragment__Group__1"
    // InternalTextualScenario.g:2585:1: rule__StateFragment__Group__1 : rule__StateFragment__Group__1__Impl rule__StateFragment__Group__2 ;
    public final void rule__StateFragment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2589:1: ( rule__StateFragment__Group__1__Impl rule__StateFragment__Group__2 )
            // InternalTextualScenario.g:2590:2: rule__StateFragment__Group__1__Impl rule__StateFragment__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__StateFragment__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StateFragment__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateFragment__Group__1"


    // $ANTLR start "rule__StateFragment__Group__1__Impl"
    // InternalTextualScenario.g:2597:1: rule__StateFragment__Group__1__Impl : ( ( rule__StateFragment__TimelineAssignment_1 ) ) ;
    public final void rule__StateFragment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2601:1: ( ( ( rule__StateFragment__TimelineAssignment_1 ) ) )
            // InternalTextualScenario.g:2602:1: ( ( rule__StateFragment__TimelineAssignment_1 ) )
            {
            // InternalTextualScenario.g:2602:1: ( ( rule__StateFragment__TimelineAssignment_1 ) )
            // InternalTextualScenario.g:2603:2: ( rule__StateFragment__TimelineAssignment_1 )
            {
             before(grammarAccess.getStateFragmentAccess().getTimelineAssignment_1()); 
            // InternalTextualScenario.g:2604:2: ( rule__StateFragment__TimelineAssignment_1 )
            // InternalTextualScenario.g:2604:3: rule__StateFragment__TimelineAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__StateFragment__TimelineAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getStateFragmentAccess().getTimelineAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateFragment__Group__1__Impl"


    // $ANTLR start "rule__StateFragment__Group__2"
    // InternalTextualScenario.g:2612:1: rule__StateFragment__Group__2 : rule__StateFragment__Group__2__Impl rule__StateFragment__Group__3 ;
    public final void rule__StateFragment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2616:1: ( rule__StateFragment__Group__2__Impl rule__StateFragment__Group__3 )
            // InternalTextualScenario.g:2617:2: rule__StateFragment__Group__2__Impl rule__StateFragment__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__StateFragment__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StateFragment__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateFragment__Group__2"


    // $ANTLR start "rule__StateFragment__Group__2__Impl"
    // InternalTextualScenario.g:2624:1: rule__StateFragment__Group__2__Impl : ( ( rule__StateFragment__KeywordAssignment_2 ) ) ;
    public final void rule__StateFragment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2628:1: ( ( ( rule__StateFragment__KeywordAssignment_2 ) ) )
            // InternalTextualScenario.g:2629:1: ( ( rule__StateFragment__KeywordAssignment_2 ) )
            {
            // InternalTextualScenario.g:2629:1: ( ( rule__StateFragment__KeywordAssignment_2 ) )
            // InternalTextualScenario.g:2630:2: ( rule__StateFragment__KeywordAssignment_2 )
            {
             before(grammarAccess.getStateFragmentAccess().getKeywordAssignment_2()); 
            // InternalTextualScenario.g:2631:2: ( rule__StateFragment__KeywordAssignment_2 )
            // InternalTextualScenario.g:2631:3: rule__StateFragment__KeywordAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__StateFragment__KeywordAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getStateFragmentAccess().getKeywordAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateFragment__Group__2__Impl"


    // $ANTLR start "rule__StateFragment__Group__3"
    // InternalTextualScenario.g:2639:1: rule__StateFragment__Group__3 : rule__StateFragment__Group__3__Impl ;
    public final void rule__StateFragment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2643:1: ( rule__StateFragment__Group__3__Impl )
            // InternalTextualScenario.g:2644:2: rule__StateFragment__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StateFragment__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateFragment__Group__3"


    // $ANTLR start "rule__StateFragment__Group__3__Impl"
    // InternalTextualScenario.g:2650:1: rule__StateFragment__Group__3__Impl : ( ( rule__StateFragment__NameAssignment_3 ) ) ;
    public final void rule__StateFragment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2654:1: ( ( ( rule__StateFragment__NameAssignment_3 ) ) )
            // InternalTextualScenario.g:2655:1: ( ( rule__StateFragment__NameAssignment_3 ) )
            {
            // InternalTextualScenario.g:2655:1: ( ( rule__StateFragment__NameAssignment_3 ) )
            // InternalTextualScenario.g:2656:2: ( rule__StateFragment__NameAssignment_3 )
            {
             before(grammarAccess.getStateFragmentAccess().getNameAssignment_3()); 
            // InternalTextualScenario.g:2657:2: ( rule__StateFragment__NameAssignment_3 )
            // InternalTextualScenario.g:2657:3: rule__StateFragment__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__StateFragment__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getStateFragmentAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateFragment__Group__3__Impl"


    // $ANTLR start "rule__Model__BeginAssignment_1"
    // InternalTextualScenario.g:2666:1: rule__Model__BeginAssignment_1 : ( ( '{' ) ) ;
    public final void rule__Model__BeginAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2670:1: ( ( ( '{' ) ) )
            // InternalTextualScenario.g:2671:2: ( ( '{' ) )
            {
            // InternalTextualScenario.g:2671:2: ( ( '{' ) )
            // InternalTextualScenario.g:2672:3: ( '{' )
            {
             before(grammarAccess.getModelAccess().getBeginLeftCurlyBracketKeyword_1_0()); 
            // InternalTextualScenario.g:2673:3: ( '{' )
            // InternalTextualScenario.g:2674:4: '{'
            {
             before(grammarAccess.getModelAccess().getBeginLeftCurlyBracketKeyword_1_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getBeginLeftCurlyBracketKeyword_1_0()); 

            }

             after(grammarAccess.getModelAccess().getBeginLeftCurlyBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__BeginAssignment_1"


    // $ANTLR start "rule__Model__ParticipantsAssignment_2"
    // InternalTextualScenario.g:2685:1: rule__Model__ParticipantsAssignment_2 : ( ruleParticipant ) ;
    public final void rule__Model__ParticipantsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2689:1: ( ( ruleParticipant ) )
            // InternalTextualScenario.g:2690:2: ( ruleParticipant )
            {
            // InternalTextualScenario.g:2690:2: ( ruleParticipant )
            // InternalTextualScenario.g:2691:3: ruleParticipant
            {
             before(grammarAccess.getModelAccess().getParticipantsParticipantParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleParticipant();

            state._fsp--;

             after(grammarAccess.getModelAccess().getParticipantsParticipantParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ParticipantsAssignment_2"


    // $ANTLR start "rule__Model__ElementsAssignment_3"
    // InternalTextualScenario.g:2700:1: rule__Model__ElementsAssignment_3 : ( ( rule__Model__ElementsAlternatives_3_0 ) ) ;
    public final void rule__Model__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2704:1: ( ( ( rule__Model__ElementsAlternatives_3_0 ) ) )
            // InternalTextualScenario.g:2705:2: ( ( rule__Model__ElementsAlternatives_3_0 ) )
            {
            // InternalTextualScenario.g:2705:2: ( ( rule__Model__ElementsAlternatives_3_0 ) )
            // InternalTextualScenario.g:2706:3: ( rule__Model__ElementsAlternatives_3_0 )
            {
             before(grammarAccess.getModelAccess().getElementsAlternatives_3_0()); 
            // InternalTextualScenario.g:2707:3: ( rule__Model__ElementsAlternatives_3_0 )
            // InternalTextualScenario.g:2707:4: rule__Model__ElementsAlternatives_3_0
            {
            pushFollow(FOLLOW_2);
            rule__Model__ElementsAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getElementsAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ElementsAssignment_3"


    // $ANTLR start "rule__Model__EndAssignment_4"
    // InternalTextualScenario.g:2715:1: rule__Model__EndAssignment_4 : ( ( '}' ) ) ;
    public final void rule__Model__EndAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2719:1: ( ( ( '}' ) ) )
            // InternalTextualScenario.g:2720:2: ( ( '}' ) )
            {
            // InternalTextualScenario.g:2720:2: ( ( '}' ) )
            // InternalTextualScenario.g:2721:3: ( '}' )
            {
             before(grammarAccess.getModelAccess().getEndRightCurlyBracketKeyword_4_0()); 
            // InternalTextualScenario.g:2722:3: ( '}' )
            // InternalTextualScenario.g:2723:4: '}'
            {
             before(grammarAccess.getModelAccess().getEndRightCurlyBracketKeyword_4_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getEndRightCurlyBracketKeyword_4_0()); 

            }

             after(grammarAccess.getModelAccess().getEndRightCurlyBracketKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__EndAssignment_4"


    // $ANTLR start "rule__Actor__KeywordAssignment_0"
    // InternalTextualScenario.g:2734:1: rule__Actor__KeywordAssignment_0 : ( ( 'actor' ) ) ;
    public final void rule__Actor__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2738:1: ( ( ( 'actor' ) ) )
            // InternalTextualScenario.g:2739:2: ( ( 'actor' ) )
            {
            // InternalTextualScenario.g:2739:2: ( ( 'actor' ) )
            // InternalTextualScenario.g:2740:3: ( 'actor' )
            {
             before(grammarAccess.getActorAccess().getKeywordActorKeyword_0_0()); 
            // InternalTextualScenario.g:2741:3: ( 'actor' )
            // InternalTextualScenario.g:2742:4: 'actor'
            {
             before(grammarAccess.getActorAccess().getKeywordActorKeyword_0_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getActorAccess().getKeywordActorKeyword_0_0()); 

            }

             after(grammarAccess.getActorAccess().getKeywordActorKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__KeywordAssignment_0"


    // $ANTLR start "rule__Actor__NameAssignment_1"
    // InternalTextualScenario.g:2753:1: rule__Actor__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Actor__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2757:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2758:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2758:2: ( RULE_STRING )
            // InternalTextualScenario.g:2759:3: RULE_STRING
            {
             before(grammarAccess.getActorAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getActorAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__NameAssignment_1"


    // $ANTLR start "rule__Component__KeywordAssignment_0"
    // InternalTextualScenario.g:2768:1: rule__Component__KeywordAssignment_0 : ( ( 'component' ) ) ;
    public final void rule__Component__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2772:1: ( ( ( 'component' ) ) )
            // InternalTextualScenario.g:2773:2: ( ( 'component' ) )
            {
            // InternalTextualScenario.g:2773:2: ( ( 'component' ) )
            // InternalTextualScenario.g:2774:3: ( 'component' )
            {
             before(grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0()); 
            // InternalTextualScenario.g:2775:3: ( 'component' )
            // InternalTextualScenario.g:2776:4: 'component'
            {
             before(grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0()); 

            }

             after(grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__KeywordAssignment_0"


    // $ANTLR start "rule__Component__NameAssignment_1"
    // InternalTextualScenario.g:2787:1: rule__Component__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Component__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2791:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2792:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2792:2: ( RULE_STRING )
            // InternalTextualScenario.g:2793:3: RULE_STRING
            {
             before(grammarAccess.getComponentAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__NameAssignment_1"


    // $ANTLR start "rule__Component__NatureAssignment_2"
    // InternalTextualScenario.g:2802:1: rule__Component__NatureAssignment_2 : ( ( rule__Component__NatureAlternatives_2_0 ) ) ;
    public final void rule__Component__NatureAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2806:1: ( ( ( rule__Component__NatureAlternatives_2_0 ) ) )
            // InternalTextualScenario.g:2807:2: ( ( rule__Component__NatureAlternatives_2_0 ) )
            {
            // InternalTextualScenario.g:2807:2: ( ( rule__Component__NatureAlternatives_2_0 ) )
            // InternalTextualScenario.g:2808:3: ( rule__Component__NatureAlternatives_2_0 )
            {
             before(grammarAccess.getComponentAccess().getNatureAlternatives_2_0()); 
            // InternalTextualScenario.g:2809:3: ( rule__Component__NatureAlternatives_2_0 )
            // InternalTextualScenario.g:2809:4: rule__Component__NatureAlternatives_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Component__NatureAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getComponentAccess().getNatureAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__NatureAssignment_2"


    // $ANTLR start "rule__ConfigurationItem__KeywordAssignment_0"
    // InternalTextualScenario.g:2817:1: rule__ConfigurationItem__KeywordAssignment_0 : ( ( 'configuration_item' ) ) ;
    public final void rule__ConfigurationItem__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2821:1: ( ( ( 'configuration_item' ) ) )
            // InternalTextualScenario.g:2822:2: ( ( 'configuration_item' ) )
            {
            // InternalTextualScenario.g:2822:2: ( ( 'configuration_item' ) )
            // InternalTextualScenario.g:2823:3: ( 'configuration_item' )
            {
             before(grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0()); 
            // InternalTextualScenario.g:2824:3: ( 'configuration_item' )
            // InternalTextualScenario.g:2825:4: 'configuration_item'
            {
             before(grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0()); 

            }

             after(grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigurationItem__KeywordAssignment_0"


    // $ANTLR start "rule__ConfigurationItem__NameAssignment_1"
    // InternalTextualScenario.g:2836:1: rule__ConfigurationItem__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ConfigurationItem__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2840:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2841:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2841:2: ( RULE_STRING )
            // InternalTextualScenario.g:2842:3: RULE_STRING
            {
             before(grammarAccess.getConfigurationItemAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getConfigurationItemAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigurationItem__NameAssignment_1"


    // $ANTLR start "rule__Function__KeywordAssignment_0"
    // InternalTextualScenario.g:2851:1: rule__Function__KeywordAssignment_0 : ( ( 'function' ) ) ;
    public final void rule__Function__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2855:1: ( ( ( 'function' ) ) )
            // InternalTextualScenario.g:2856:2: ( ( 'function' ) )
            {
            // InternalTextualScenario.g:2856:2: ( ( 'function' ) )
            // InternalTextualScenario.g:2857:3: ( 'function' )
            {
             before(grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0()); 
            // InternalTextualScenario.g:2858:3: ( 'function' )
            // InternalTextualScenario.g:2859:4: 'function'
            {
             before(grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0()); 

            }

             after(grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__KeywordAssignment_0"


    // $ANTLR start "rule__Function__NameAssignment_1"
    // InternalTextualScenario.g:2870:1: rule__Function__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Function__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2874:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2875:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2875:2: ( RULE_STRING )
            // InternalTextualScenario.g:2876:3: RULE_STRING
            {
             before(grammarAccess.getFunctionAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getFunctionAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__NameAssignment_1"


    // $ANTLR start "rule__Activity__KeywordAssignment_0"
    // InternalTextualScenario.g:2885:1: rule__Activity__KeywordAssignment_0 : ( ( 'activity' ) ) ;
    public final void rule__Activity__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2889:1: ( ( ( 'activity' ) ) )
            // InternalTextualScenario.g:2890:2: ( ( 'activity' ) )
            {
            // InternalTextualScenario.g:2890:2: ( ( 'activity' ) )
            // InternalTextualScenario.g:2891:3: ( 'activity' )
            {
             before(grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0()); 
            // InternalTextualScenario.g:2892:3: ( 'activity' )
            // InternalTextualScenario.g:2893:4: 'activity'
            {
             before(grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0()); 

            }

             after(grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activity__KeywordAssignment_0"


    // $ANTLR start "rule__Activity__NameAssignment_1"
    // InternalTextualScenario.g:2904:1: rule__Activity__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Activity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2908:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2909:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2909:2: ( RULE_STRING )
            // InternalTextualScenario.g:2910:3: RULE_STRING
            {
             before(grammarAccess.getActivityAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getActivityAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activity__NameAssignment_1"


    // $ANTLR start "rule__Entity__KeywordAssignment_0"
    // InternalTextualScenario.g:2919:1: rule__Entity__KeywordAssignment_0 : ( ( 'entity' ) ) ;
    public final void rule__Entity__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2923:1: ( ( ( 'entity' ) ) )
            // InternalTextualScenario.g:2924:2: ( ( 'entity' ) )
            {
            // InternalTextualScenario.g:2924:2: ( ( 'entity' ) )
            // InternalTextualScenario.g:2925:3: ( 'entity' )
            {
             before(grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0()); 
            // InternalTextualScenario.g:2926:3: ( 'entity' )
            // InternalTextualScenario.g:2927:4: 'entity'
            {
             before(grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0()); 

            }

             after(grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__KeywordAssignment_0"


    // $ANTLR start "rule__Entity__NameAssignment_1"
    // InternalTextualScenario.g:2938:1: rule__Entity__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Entity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2942:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2943:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2943:2: ( RULE_STRING )
            // InternalTextualScenario.g:2944:3: RULE_STRING
            {
             before(grammarAccess.getEntityAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__NameAssignment_1"


    // $ANTLR start "rule__Role__KeywordAssignment_0"
    // InternalTextualScenario.g:2953:1: rule__Role__KeywordAssignment_0 : ( ( 'role' ) ) ;
    public final void rule__Role__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2957:1: ( ( ( 'role' ) ) )
            // InternalTextualScenario.g:2958:2: ( ( 'role' ) )
            {
            // InternalTextualScenario.g:2958:2: ( ( 'role' ) )
            // InternalTextualScenario.g:2959:3: ( 'role' )
            {
             before(grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0()); 
            // InternalTextualScenario.g:2960:3: ( 'role' )
            // InternalTextualScenario.g:2961:4: 'role'
            {
             before(grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0()); 

            }

             after(grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Role__KeywordAssignment_0"


    // $ANTLR start "rule__Role__NameAssignment_1"
    // InternalTextualScenario.g:2972:1: rule__Role__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Role__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2976:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2977:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2977:2: ( RULE_STRING )
            // InternalTextualScenario.g:2978:3: RULE_STRING
            {
             before(grammarAccess.getRoleAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getRoleAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Role__NameAssignment_1"


    // $ANTLR start "rule__SequenceMessage__SourceAssignment_0"
    // InternalTextualScenario.g:2987:1: rule__SequenceMessage__SourceAssignment_0 : ( RULE_STRING ) ;
    public final void rule__SequenceMessage__SourceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2991:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2992:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2992:2: ( RULE_STRING )
            // InternalTextualScenario.g:2993:3: RULE_STRING
            {
             before(grammarAccess.getSequenceMessageAccess().getSourceSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getSequenceMessageAccess().getSourceSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__SourceAssignment_0"


    // $ANTLR start "rule__SequenceMessage__ArrowAssignment_1"
    // InternalTextualScenario.g:3002:1: rule__SequenceMessage__ArrowAssignment_1 : ( ( '->' ) ) ;
    public final void rule__SequenceMessage__ArrowAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3006:1: ( ( ( '->' ) ) )
            // InternalTextualScenario.g:3007:2: ( ( '->' ) )
            {
            // InternalTextualScenario.g:3007:2: ( ( '->' ) )
            // InternalTextualScenario.g:3008:3: ( '->' )
            {
             before(grammarAccess.getSequenceMessageAccess().getArrowHyphenMinusGreaterThanSignKeyword_1_0()); 
            // InternalTextualScenario.g:3009:3: ( '->' )
            // InternalTextualScenario.g:3010:4: '->'
            {
             before(grammarAccess.getSequenceMessageAccess().getArrowHyphenMinusGreaterThanSignKeyword_1_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getSequenceMessageAccess().getArrowHyphenMinusGreaterThanSignKeyword_1_0()); 

            }

             after(grammarAccess.getSequenceMessageAccess().getArrowHyphenMinusGreaterThanSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__ArrowAssignment_1"


    // $ANTLR start "rule__SequenceMessage__TargetAssignment_2"
    // InternalTextualScenario.g:3021:1: rule__SequenceMessage__TargetAssignment_2 : ( RULE_STRING ) ;
    public final void rule__SequenceMessage__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3025:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3026:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3026:2: ( RULE_STRING )
            // InternalTextualScenario.g:3027:3: RULE_STRING
            {
             before(grammarAccess.getSequenceMessageAccess().getTargetSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getSequenceMessageAccess().getTargetSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__TargetAssignment_2"


    // $ANTLR start "rule__SequenceMessage__ExecutionAssignment_3"
    // InternalTextualScenario.g:3036:1: rule__SequenceMessage__ExecutionAssignment_3 : ( ( 'withExecution' ) ) ;
    public final void rule__SequenceMessage__ExecutionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3040:1: ( ( ( 'withExecution' ) ) )
            // InternalTextualScenario.g:3041:2: ( ( 'withExecution' ) )
            {
            // InternalTextualScenario.g:3041:2: ( ( 'withExecution' ) )
            // InternalTextualScenario.g:3042:3: ( 'withExecution' )
            {
             before(grammarAccess.getSequenceMessageAccess().getExecutionWithExecutionKeyword_3_0()); 
            // InternalTextualScenario.g:3043:3: ( 'withExecution' )
            // InternalTextualScenario.g:3044:4: 'withExecution'
            {
             before(grammarAccess.getSequenceMessageAccess().getExecutionWithExecutionKeyword_3_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getSequenceMessageAccess().getExecutionWithExecutionKeyword_3_0()); 

            }

             after(grammarAccess.getSequenceMessageAccess().getExecutionWithExecutionKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__ExecutionAssignment_3"


    // $ANTLR start "rule__SequenceMessage__ReturnAssignment_4"
    // InternalTextualScenario.g:3055:1: rule__SequenceMessage__ReturnAssignment_4 : ( ( 'withReturn' ) ) ;
    public final void rule__SequenceMessage__ReturnAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3059:1: ( ( ( 'withReturn' ) ) )
            // InternalTextualScenario.g:3060:2: ( ( 'withReturn' ) )
            {
            // InternalTextualScenario.g:3060:2: ( ( 'withReturn' ) )
            // InternalTextualScenario.g:3061:3: ( 'withReturn' )
            {
             before(grammarAccess.getSequenceMessageAccess().getReturnWithReturnKeyword_4_0()); 
            // InternalTextualScenario.g:3062:3: ( 'withReturn' )
            // InternalTextualScenario.g:3063:4: 'withReturn'
            {
             before(grammarAccess.getSequenceMessageAccess().getReturnWithReturnKeyword_4_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getSequenceMessageAccess().getReturnWithReturnKeyword_4_0()); 

            }

             after(grammarAccess.getSequenceMessageAccess().getReturnWithReturnKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__ReturnAssignment_4"


    // $ANTLR start "rule__SequenceMessage__DoubleDotAssignment_5"
    // InternalTextualScenario.g:3074:1: rule__SequenceMessage__DoubleDotAssignment_5 : ( ( ':' ) ) ;
    public final void rule__SequenceMessage__DoubleDotAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3078:1: ( ( ( ':' ) ) )
            // InternalTextualScenario.g:3079:2: ( ( ':' ) )
            {
            // InternalTextualScenario.g:3079:2: ( ( ':' ) )
            // InternalTextualScenario.g:3080:3: ( ':' )
            {
             before(grammarAccess.getSequenceMessageAccess().getDoubleDotColonKeyword_5_0()); 
            // InternalTextualScenario.g:3081:3: ( ':' )
            // InternalTextualScenario.g:3082:4: ':'
            {
             before(grammarAccess.getSequenceMessageAccess().getDoubleDotColonKeyword_5_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getSequenceMessageAccess().getDoubleDotColonKeyword_5_0()); 

            }

             after(grammarAccess.getSequenceMessageAccess().getDoubleDotColonKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__DoubleDotAssignment_5"


    // $ANTLR start "rule__SequenceMessage__NameAssignment_6"
    // InternalTextualScenario.g:3093:1: rule__SequenceMessage__NameAssignment_6 : ( RULE_STRING ) ;
    public final void rule__SequenceMessage__NameAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3097:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3098:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3098:2: ( RULE_STRING )
            // InternalTextualScenario.g:3099:3: RULE_STRING
            {
             before(grammarAccess.getSequenceMessageAccess().getNameSTRINGTerminalRuleCall_6_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getSequenceMessageAccess().getNameSTRINGTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceMessage__NameAssignment_6"


    // $ANTLR start "rule__CreateMessage__SourceAssignment_0"
    // InternalTextualScenario.g:3108:1: rule__CreateMessage__SourceAssignment_0 : ( RULE_STRING ) ;
    public final void rule__CreateMessage__SourceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3112:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3113:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3113:2: ( RULE_STRING )
            // InternalTextualScenario.g:3114:3: RULE_STRING
            {
             before(grammarAccess.getCreateMessageAccess().getSourceSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getCreateMessageAccess().getSourceSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateMessage__SourceAssignment_0"


    // $ANTLR start "rule__CreateMessage__ArrowAssignment_1"
    // InternalTextualScenario.g:3123:1: rule__CreateMessage__ArrowAssignment_1 : ( ( '->+' ) ) ;
    public final void rule__CreateMessage__ArrowAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3127:1: ( ( ( '->+' ) ) )
            // InternalTextualScenario.g:3128:2: ( ( '->+' ) )
            {
            // InternalTextualScenario.g:3128:2: ( ( '->+' ) )
            // InternalTextualScenario.g:3129:3: ( '->+' )
            {
             before(grammarAccess.getCreateMessageAccess().getArrowHyphenMinusGreaterThanSignPlusSignKeyword_1_0()); 
            // InternalTextualScenario.g:3130:3: ( '->+' )
            // InternalTextualScenario.g:3131:4: '->+'
            {
             before(grammarAccess.getCreateMessageAccess().getArrowHyphenMinusGreaterThanSignPlusSignKeyword_1_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getCreateMessageAccess().getArrowHyphenMinusGreaterThanSignPlusSignKeyword_1_0()); 

            }

             after(grammarAccess.getCreateMessageAccess().getArrowHyphenMinusGreaterThanSignPlusSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateMessage__ArrowAssignment_1"


    // $ANTLR start "rule__CreateMessage__TargetAssignment_2"
    // InternalTextualScenario.g:3142:1: rule__CreateMessage__TargetAssignment_2 : ( RULE_STRING ) ;
    public final void rule__CreateMessage__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3146:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3147:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3147:2: ( RULE_STRING )
            // InternalTextualScenario.g:3148:3: RULE_STRING
            {
             before(grammarAccess.getCreateMessageAccess().getTargetSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getCreateMessageAccess().getTargetSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateMessage__TargetAssignment_2"


    // $ANTLR start "rule__CreateMessage__DoubleDotAssignment_3"
    // InternalTextualScenario.g:3157:1: rule__CreateMessage__DoubleDotAssignment_3 : ( ( ':' ) ) ;
    public final void rule__CreateMessage__DoubleDotAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3161:1: ( ( ( ':' ) ) )
            // InternalTextualScenario.g:3162:2: ( ( ':' ) )
            {
            // InternalTextualScenario.g:3162:2: ( ( ':' ) )
            // InternalTextualScenario.g:3163:3: ( ':' )
            {
             before(grammarAccess.getCreateMessageAccess().getDoubleDotColonKeyword_3_0()); 
            // InternalTextualScenario.g:3164:3: ( ':' )
            // InternalTextualScenario.g:3165:4: ':'
            {
             before(grammarAccess.getCreateMessageAccess().getDoubleDotColonKeyword_3_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getCreateMessageAccess().getDoubleDotColonKeyword_3_0()); 

            }

             after(grammarAccess.getCreateMessageAccess().getDoubleDotColonKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateMessage__DoubleDotAssignment_3"


    // $ANTLR start "rule__CreateMessage__NameAssignment_4"
    // InternalTextualScenario.g:3176:1: rule__CreateMessage__NameAssignment_4 : ( RULE_STRING ) ;
    public final void rule__CreateMessage__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3180:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3181:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3181:2: ( RULE_STRING )
            // InternalTextualScenario.g:3182:3: RULE_STRING
            {
             before(grammarAccess.getCreateMessageAccess().getNameSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getCreateMessageAccess().getNameSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CreateMessage__NameAssignment_4"


    // $ANTLR start "rule__DeleteMessage__SourceAssignment_0"
    // InternalTextualScenario.g:3191:1: rule__DeleteMessage__SourceAssignment_0 : ( RULE_STRING ) ;
    public final void rule__DeleteMessage__SourceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3195:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3196:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3196:2: ( RULE_STRING )
            // InternalTextualScenario.g:3197:3: RULE_STRING
            {
             before(grammarAccess.getDeleteMessageAccess().getSourceSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getDeleteMessageAccess().getSourceSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeleteMessage__SourceAssignment_0"


    // $ANTLR start "rule__DeleteMessage__ArrowAssignment_1"
    // InternalTextualScenario.g:3206:1: rule__DeleteMessage__ArrowAssignment_1 : ( ( '->x' ) ) ;
    public final void rule__DeleteMessage__ArrowAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3210:1: ( ( ( '->x' ) ) )
            // InternalTextualScenario.g:3211:2: ( ( '->x' ) )
            {
            // InternalTextualScenario.g:3211:2: ( ( '->x' ) )
            // InternalTextualScenario.g:3212:3: ( '->x' )
            {
             before(grammarAccess.getDeleteMessageAccess().getArrowXKeyword_1_0()); 
            // InternalTextualScenario.g:3213:3: ( '->x' )
            // InternalTextualScenario.g:3214:4: '->x'
            {
             before(grammarAccess.getDeleteMessageAccess().getArrowXKeyword_1_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getDeleteMessageAccess().getArrowXKeyword_1_0()); 

            }

             after(grammarAccess.getDeleteMessageAccess().getArrowXKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeleteMessage__ArrowAssignment_1"


    // $ANTLR start "rule__DeleteMessage__TargetAssignment_2"
    // InternalTextualScenario.g:3225:1: rule__DeleteMessage__TargetAssignment_2 : ( RULE_STRING ) ;
    public final void rule__DeleteMessage__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3229:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3230:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3230:2: ( RULE_STRING )
            // InternalTextualScenario.g:3231:3: RULE_STRING
            {
             before(grammarAccess.getDeleteMessageAccess().getTargetSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getDeleteMessageAccess().getTargetSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeleteMessage__TargetAssignment_2"


    // $ANTLR start "rule__DeleteMessage__DoubleDotAssignment_3"
    // InternalTextualScenario.g:3240:1: rule__DeleteMessage__DoubleDotAssignment_3 : ( ( ':' ) ) ;
    public final void rule__DeleteMessage__DoubleDotAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3244:1: ( ( ( ':' ) ) )
            // InternalTextualScenario.g:3245:2: ( ( ':' ) )
            {
            // InternalTextualScenario.g:3245:2: ( ( ':' ) )
            // InternalTextualScenario.g:3246:3: ( ':' )
            {
             before(grammarAccess.getDeleteMessageAccess().getDoubleDotColonKeyword_3_0()); 
            // InternalTextualScenario.g:3247:3: ( ':' )
            // InternalTextualScenario.g:3248:4: ':'
            {
             before(grammarAccess.getDeleteMessageAccess().getDoubleDotColonKeyword_3_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getDeleteMessageAccess().getDoubleDotColonKeyword_3_0()); 

            }

             after(grammarAccess.getDeleteMessageAccess().getDoubleDotColonKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeleteMessage__DoubleDotAssignment_3"


    // $ANTLR start "rule__DeleteMessage__NameAssignment_4"
    // InternalTextualScenario.g:3259:1: rule__DeleteMessage__NameAssignment_4 : ( RULE_STRING ) ;
    public final void rule__DeleteMessage__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3263:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3264:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3264:2: ( RULE_STRING )
            // InternalTextualScenario.g:3265:3: RULE_STRING
            {
             before(grammarAccess.getDeleteMessageAccess().getNameSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getDeleteMessageAccess().getNameSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeleteMessage__NameAssignment_4"


    // $ANTLR start "rule__ArmTimerMessage__ArrowAssignment_0"
    // InternalTextualScenario.g:3274:1: rule__ArmTimerMessage__ArrowAssignment_0 : ( ( '->>' ) ) ;
    public final void rule__ArmTimerMessage__ArrowAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3278:1: ( ( ( '->>' ) ) )
            // InternalTextualScenario.g:3279:2: ( ( '->>' ) )
            {
            // InternalTextualScenario.g:3279:2: ( ( '->>' ) )
            // InternalTextualScenario.g:3280:3: ( '->>' )
            {
             before(grammarAccess.getArmTimerMessageAccess().getArrowHyphenMinusGreaterThanSignGreaterThanSignKeyword_0_0()); 
            // InternalTextualScenario.g:3281:3: ( '->>' )
            // InternalTextualScenario.g:3282:4: '->>'
            {
             before(grammarAccess.getArmTimerMessageAccess().getArrowHyphenMinusGreaterThanSignGreaterThanSignKeyword_0_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getArmTimerMessageAccess().getArrowHyphenMinusGreaterThanSignGreaterThanSignKeyword_0_0()); 

            }

             after(grammarAccess.getArmTimerMessageAccess().getArrowHyphenMinusGreaterThanSignGreaterThanSignKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArmTimerMessage__ArrowAssignment_0"


    // $ANTLR start "rule__ArmTimerMessage__ParticipantAssignment_1"
    // InternalTextualScenario.g:3293:1: rule__ArmTimerMessage__ParticipantAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ArmTimerMessage__ParticipantAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3297:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3298:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3298:2: ( RULE_STRING )
            // InternalTextualScenario.g:3299:3: RULE_STRING
            {
             before(grammarAccess.getArmTimerMessageAccess().getParticipantSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getArmTimerMessageAccess().getParticipantSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArmTimerMessage__ParticipantAssignment_1"


    // $ANTLR start "rule__ArmTimerMessage__DoubleDotAssignment_2"
    // InternalTextualScenario.g:3308:1: rule__ArmTimerMessage__DoubleDotAssignment_2 : ( ( ':' ) ) ;
    public final void rule__ArmTimerMessage__DoubleDotAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3312:1: ( ( ( ':' ) ) )
            // InternalTextualScenario.g:3313:2: ( ( ':' ) )
            {
            // InternalTextualScenario.g:3313:2: ( ( ':' ) )
            // InternalTextualScenario.g:3314:3: ( ':' )
            {
             before(grammarAccess.getArmTimerMessageAccess().getDoubleDotColonKeyword_2_0()); 
            // InternalTextualScenario.g:3315:3: ( ':' )
            // InternalTextualScenario.g:3316:4: ':'
            {
             before(grammarAccess.getArmTimerMessageAccess().getDoubleDotColonKeyword_2_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getArmTimerMessageAccess().getDoubleDotColonKeyword_2_0()); 

            }

             after(grammarAccess.getArmTimerMessageAccess().getDoubleDotColonKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArmTimerMessage__DoubleDotAssignment_2"


    // $ANTLR start "rule__ArmTimerMessage__NameAssignment_3"
    // InternalTextualScenario.g:3327:1: rule__ArmTimerMessage__NameAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ArmTimerMessage__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3331:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3332:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3332:2: ( RULE_STRING )
            // InternalTextualScenario.g:3333:3: RULE_STRING
            {
             before(grammarAccess.getArmTimerMessageAccess().getNameSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getArmTimerMessageAccess().getNameSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArmTimerMessage__NameAssignment_3"


    // $ANTLR start "rule__ParticipantDeactivation__KeywordAssignment_0"
    // InternalTextualScenario.g:3342:1: rule__ParticipantDeactivation__KeywordAssignment_0 : ( ( 'deactivate' ) ) ;
    public final void rule__ParticipantDeactivation__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3346:1: ( ( ( 'deactivate' ) ) )
            // InternalTextualScenario.g:3347:2: ( ( 'deactivate' ) )
            {
            // InternalTextualScenario.g:3347:2: ( ( 'deactivate' ) )
            // InternalTextualScenario.g:3348:3: ( 'deactivate' )
            {
             before(grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0()); 
            // InternalTextualScenario.g:3349:3: ( 'deactivate' )
            // InternalTextualScenario.g:3350:4: 'deactivate'
            {
             before(grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0()); 

            }

             after(grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParticipantDeactivation__KeywordAssignment_0"


    // $ANTLR start "rule__ParticipantDeactivation__NameAssignment_1"
    // InternalTextualScenario.g:3361:1: rule__ParticipantDeactivation__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ParticipantDeactivation__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3365:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3366:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3366:2: ( RULE_STRING )
            // InternalTextualScenario.g:3367:3: RULE_STRING
            {
             before(grammarAccess.getParticipantDeactivationAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getParticipantDeactivationAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParticipantDeactivation__NameAssignment_1"


    // $ANTLR start "rule__Reference__KeywordAssignment_0"
    // InternalTextualScenario.g:3376:1: rule__Reference__KeywordAssignment_0 : ( ( 'ref' ) ) ;
    public final void rule__Reference__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3380:1: ( ( ( 'ref' ) ) )
            // InternalTextualScenario.g:3381:2: ( ( 'ref' ) )
            {
            // InternalTextualScenario.g:3381:2: ( ( 'ref' ) )
            // InternalTextualScenario.g:3382:3: ( 'ref' )
            {
             before(grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0()); 
            // InternalTextualScenario.g:3383:3: ( 'ref' )
            // InternalTextualScenario.g:3384:4: 'ref'
            {
             before(grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0()); 

            }

             after(grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__KeywordAssignment_0"


    // $ANTLR start "rule__Reference__OverAssignment_1"
    // InternalTextualScenario.g:3395:1: rule__Reference__OverAssignment_1 : ( ( 'over' ) ) ;
    public final void rule__Reference__OverAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3399:1: ( ( ( 'over' ) ) )
            // InternalTextualScenario.g:3400:2: ( ( 'over' ) )
            {
            // InternalTextualScenario.g:3400:2: ( ( 'over' ) )
            // InternalTextualScenario.g:3401:3: ( 'over' )
            {
             before(grammarAccess.getReferenceAccess().getOverOverKeyword_1_0()); 
            // InternalTextualScenario.g:3402:3: ( 'over' )
            // InternalTextualScenario.g:3403:4: 'over'
            {
             before(grammarAccess.getReferenceAccess().getOverOverKeyword_1_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getOverOverKeyword_1_0()); 

            }

             after(grammarAccess.getReferenceAccess().getOverOverKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__OverAssignment_1"


    // $ANTLR start "rule__Reference__TimelinesAssignment_2"
    // InternalTextualScenario.g:3414:1: rule__Reference__TimelinesAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Reference__TimelinesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3418:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3419:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3419:2: ( RULE_STRING )
            // InternalTextualScenario.g:3420:3: RULE_STRING
            {
             before(grammarAccess.getReferenceAccess().getTimelinesSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getTimelinesSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__TimelinesAssignment_2"


    // $ANTLR start "rule__Reference__NameAssignment_3"
    // InternalTextualScenario.g:3429:1: rule__Reference__NameAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Reference__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3433:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3434:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3434:2: ( RULE_STRING )
            // InternalTextualScenario.g:3435:3: RULE_STRING
            {
             before(grammarAccess.getReferenceAccess().getNameSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getNameSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__NameAssignment_3"


    // $ANTLR start "rule__CombinedFragment__KeywordAssignment_0"
    // InternalTextualScenario.g:3444:1: rule__CombinedFragment__KeywordAssignment_0 : ( ( rule__CombinedFragment__KeywordAlternatives_0_0 ) ) ;
    public final void rule__CombinedFragment__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3448:1: ( ( ( rule__CombinedFragment__KeywordAlternatives_0_0 ) ) )
            // InternalTextualScenario.g:3449:2: ( ( rule__CombinedFragment__KeywordAlternatives_0_0 ) )
            {
            // InternalTextualScenario.g:3449:2: ( ( rule__CombinedFragment__KeywordAlternatives_0_0 ) )
            // InternalTextualScenario.g:3450:3: ( rule__CombinedFragment__KeywordAlternatives_0_0 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getKeywordAlternatives_0_0()); 
            // InternalTextualScenario.g:3451:3: ( rule__CombinedFragment__KeywordAlternatives_0_0 )
            // InternalTextualScenario.g:3451:4: rule__CombinedFragment__KeywordAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__CombinedFragment__KeywordAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getCombinedFragmentAccess().getKeywordAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__KeywordAssignment_0"


    // $ANTLR start "rule__CombinedFragment__ExpressionAssignment_1"
    // InternalTextualScenario.g:3459:1: rule__CombinedFragment__ExpressionAssignment_1 : ( RULE_STRING ) ;
    public final void rule__CombinedFragment__ExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3463:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3464:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3464:2: ( RULE_STRING )
            // InternalTextualScenario.g:3465:3: RULE_STRING
            {
             before(grammarAccess.getCombinedFragmentAccess().getExpressionSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getCombinedFragmentAccess().getExpressionSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__ExpressionAssignment_1"


    // $ANTLR start "rule__CombinedFragment__OverAssignment_2"
    // InternalTextualScenario.g:3474:1: rule__CombinedFragment__OverAssignment_2 : ( ( 'over' ) ) ;
    public final void rule__CombinedFragment__OverAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3478:1: ( ( ( 'over' ) ) )
            // InternalTextualScenario.g:3479:2: ( ( 'over' ) )
            {
            // InternalTextualScenario.g:3479:2: ( ( 'over' ) )
            // InternalTextualScenario.g:3480:3: ( 'over' )
            {
             before(grammarAccess.getCombinedFragmentAccess().getOverOverKeyword_2_0()); 
            // InternalTextualScenario.g:3481:3: ( 'over' )
            // InternalTextualScenario.g:3482:4: 'over'
            {
             before(grammarAccess.getCombinedFragmentAccess().getOverOverKeyword_2_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getCombinedFragmentAccess().getOverOverKeyword_2_0()); 

            }

             after(grammarAccess.getCombinedFragmentAccess().getOverOverKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__OverAssignment_2"


    // $ANTLR start "rule__CombinedFragment__TimelinesAssignment_3"
    // InternalTextualScenario.g:3493:1: rule__CombinedFragment__TimelinesAssignment_3 : ( RULE_STRING ) ;
    public final void rule__CombinedFragment__TimelinesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3497:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3498:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3498:2: ( RULE_STRING )
            // InternalTextualScenario.g:3499:3: RULE_STRING
            {
             before(grammarAccess.getCombinedFragmentAccess().getTimelinesSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getCombinedFragmentAccess().getTimelinesSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__TimelinesAssignment_3"


    // $ANTLR start "rule__CombinedFragment__BlockAssignment_4"
    // InternalTextualScenario.g:3508:1: rule__CombinedFragment__BlockAssignment_4 : ( ruleBlock ) ;
    public final void rule__CombinedFragment__BlockAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3512:1: ( ( ruleBlock ) )
            // InternalTextualScenario.g:3513:2: ( ruleBlock )
            {
            // InternalTextualScenario.g:3513:2: ( ruleBlock )
            // InternalTextualScenario.g:3514:3: ruleBlock
            {
             before(grammarAccess.getCombinedFragmentAccess().getBlockBlockParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getCombinedFragmentAccess().getBlockBlockParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__BlockAssignment_4"


    // $ANTLR start "rule__CombinedFragment__OperandsAssignment_5"
    // InternalTextualScenario.g:3523:1: rule__CombinedFragment__OperandsAssignment_5 : ( ruleOperand ) ;
    public final void rule__CombinedFragment__OperandsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3527:1: ( ( ruleOperand ) )
            // InternalTextualScenario.g:3528:2: ( ruleOperand )
            {
            // InternalTextualScenario.g:3528:2: ( ruleOperand )
            // InternalTextualScenario.g:3529:3: ruleOperand
            {
             before(grammarAccess.getCombinedFragmentAccess().getOperandsOperandParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleOperand();

            state._fsp--;

             after(grammarAccess.getCombinedFragmentAccess().getOperandsOperandParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CombinedFragment__OperandsAssignment_5"


    // $ANTLR start "rule__Operand__KeywordAssignment_0"
    // InternalTextualScenario.g:3538:1: rule__Operand__KeywordAssignment_0 : ( ( 'else' ) ) ;
    public final void rule__Operand__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3542:1: ( ( ( 'else' ) ) )
            // InternalTextualScenario.g:3543:2: ( ( 'else' ) )
            {
            // InternalTextualScenario.g:3543:2: ( ( 'else' ) )
            // InternalTextualScenario.g:3544:3: ( 'else' )
            {
             before(grammarAccess.getOperandAccess().getKeywordElseKeyword_0_0()); 
            // InternalTextualScenario.g:3545:3: ( 'else' )
            // InternalTextualScenario.g:3546:4: 'else'
            {
             before(grammarAccess.getOperandAccess().getKeywordElseKeyword_0_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getOperandAccess().getKeywordElseKeyword_0_0()); 

            }

             after(grammarAccess.getOperandAccess().getKeywordElseKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operand__KeywordAssignment_0"


    // $ANTLR start "rule__Operand__ExpressionAssignment_1"
    // InternalTextualScenario.g:3557:1: rule__Operand__ExpressionAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Operand__ExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3561:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3562:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3562:2: ( RULE_STRING )
            // InternalTextualScenario.g:3563:3: RULE_STRING
            {
             before(grammarAccess.getOperandAccess().getExpressionSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getOperandAccess().getExpressionSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operand__ExpressionAssignment_1"


    // $ANTLR start "rule__Operand__BlockAssignment_2"
    // InternalTextualScenario.g:3572:1: rule__Operand__BlockAssignment_2 : ( ruleBlock ) ;
    public final void rule__Operand__BlockAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3576:1: ( ( ruleBlock ) )
            // InternalTextualScenario.g:3577:2: ( ruleBlock )
            {
            // InternalTextualScenario.g:3577:2: ( ruleBlock )
            // InternalTextualScenario.g:3578:3: ruleBlock
            {
             before(grammarAccess.getOperandAccess().getBlockBlockParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getOperandAccess().getBlockBlockParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operand__BlockAssignment_2"


    // $ANTLR start "rule__Block__BeginAssignment_0"
    // InternalTextualScenario.g:3587:1: rule__Block__BeginAssignment_0 : ( ( '{' ) ) ;
    public final void rule__Block__BeginAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3591:1: ( ( ( '{' ) ) )
            // InternalTextualScenario.g:3592:2: ( ( '{' ) )
            {
            // InternalTextualScenario.g:3592:2: ( ( '{' ) )
            // InternalTextualScenario.g:3593:3: ( '{' )
            {
             before(grammarAccess.getBlockAccess().getBeginLeftCurlyBracketKeyword_0_0()); 
            // InternalTextualScenario.g:3594:3: ( '{' )
            // InternalTextualScenario.g:3595:4: '{'
            {
             before(grammarAccess.getBlockAccess().getBeginLeftCurlyBracketKeyword_0_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getBlockAccess().getBeginLeftCurlyBracketKeyword_0_0()); 

            }

             after(grammarAccess.getBlockAccess().getBeginLeftCurlyBracketKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__BeginAssignment_0"


    // $ANTLR start "rule__Block__BlockElementsAssignment_1"
    // InternalTextualScenario.g:3606:1: rule__Block__BlockElementsAssignment_1 : ( ( rule__Block__BlockElementsAlternatives_1_0 ) ) ;
    public final void rule__Block__BlockElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3610:1: ( ( ( rule__Block__BlockElementsAlternatives_1_0 ) ) )
            // InternalTextualScenario.g:3611:2: ( ( rule__Block__BlockElementsAlternatives_1_0 ) )
            {
            // InternalTextualScenario.g:3611:2: ( ( rule__Block__BlockElementsAlternatives_1_0 ) )
            // InternalTextualScenario.g:3612:3: ( rule__Block__BlockElementsAlternatives_1_0 )
            {
             before(grammarAccess.getBlockAccess().getBlockElementsAlternatives_1_0()); 
            // InternalTextualScenario.g:3613:3: ( rule__Block__BlockElementsAlternatives_1_0 )
            // InternalTextualScenario.g:3613:4: rule__Block__BlockElementsAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Block__BlockElementsAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getBlockAccess().getBlockElementsAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__BlockElementsAssignment_1"


    // $ANTLR start "rule__Block__EndAssignment_2"
    // InternalTextualScenario.g:3621:1: rule__Block__EndAssignment_2 : ( ( '}' ) ) ;
    public final void rule__Block__EndAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3625:1: ( ( ( '}' ) ) )
            // InternalTextualScenario.g:3626:2: ( ( '}' ) )
            {
            // InternalTextualScenario.g:3626:2: ( ( '}' ) )
            // InternalTextualScenario.g:3627:3: ( '}' )
            {
             before(grammarAccess.getBlockAccess().getEndRightCurlyBracketKeyword_2_0()); 
            // InternalTextualScenario.g:3628:3: ( '}' )
            // InternalTextualScenario.g:3629:4: '}'
            {
             before(grammarAccess.getBlockAccess().getEndRightCurlyBracketKeyword_2_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getBlockAccess().getEndRightCurlyBracketKeyword_2_0()); 

            }

             after(grammarAccess.getBlockAccess().getEndRightCurlyBracketKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__EndAssignment_2"


    // $ANTLR start "rule__StateFragment__OnAssignment_0"
    // InternalTextualScenario.g:3640:1: rule__StateFragment__OnAssignment_0 : ( ( 'on' ) ) ;
    public final void rule__StateFragment__OnAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3644:1: ( ( ( 'on' ) ) )
            // InternalTextualScenario.g:3645:2: ( ( 'on' ) )
            {
            // InternalTextualScenario.g:3645:2: ( ( 'on' ) )
            // InternalTextualScenario.g:3646:3: ( 'on' )
            {
             before(grammarAccess.getStateFragmentAccess().getOnOnKeyword_0_0()); 
            // InternalTextualScenario.g:3647:3: ( 'on' )
            // InternalTextualScenario.g:3648:4: 'on'
            {
             before(grammarAccess.getStateFragmentAccess().getOnOnKeyword_0_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getStateFragmentAccess().getOnOnKeyword_0_0()); 

            }

             after(grammarAccess.getStateFragmentAccess().getOnOnKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateFragment__OnAssignment_0"


    // $ANTLR start "rule__StateFragment__TimelineAssignment_1"
    // InternalTextualScenario.g:3659:1: rule__StateFragment__TimelineAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StateFragment__TimelineAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3663:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3664:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3664:2: ( RULE_STRING )
            // InternalTextualScenario.g:3665:3: RULE_STRING
            {
             before(grammarAccess.getStateFragmentAccess().getTimelineSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getStateFragmentAccess().getTimelineSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateFragment__TimelineAssignment_1"


    // $ANTLR start "rule__StateFragment__KeywordAssignment_2"
    // InternalTextualScenario.g:3674:1: rule__StateFragment__KeywordAssignment_2 : ( ( rule__StateFragment__KeywordAlternatives_2_0 ) ) ;
    public final void rule__StateFragment__KeywordAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3678:1: ( ( ( rule__StateFragment__KeywordAlternatives_2_0 ) ) )
            // InternalTextualScenario.g:3679:2: ( ( rule__StateFragment__KeywordAlternatives_2_0 ) )
            {
            // InternalTextualScenario.g:3679:2: ( ( rule__StateFragment__KeywordAlternatives_2_0 ) )
            // InternalTextualScenario.g:3680:3: ( rule__StateFragment__KeywordAlternatives_2_0 )
            {
             before(grammarAccess.getStateFragmentAccess().getKeywordAlternatives_2_0()); 
            // InternalTextualScenario.g:3681:3: ( rule__StateFragment__KeywordAlternatives_2_0 )
            // InternalTextualScenario.g:3681:4: rule__StateFragment__KeywordAlternatives_2_0
            {
            pushFollow(FOLLOW_2);
            rule__StateFragment__KeywordAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getStateFragmentAccess().getKeywordAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateFragment__KeywordAssignment_2"


    // $ANTLR start "rule__StateFragment__NameAssignment_3"
    // InternalTextualScenario.g:3689:1: rule__StateFragment__NameAssignment_3 : ( RULE_STRING ) ;
    public final void rule__StateFragment__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3693:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3694:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3694:2: ( RULE_STRING )
            // InternalTextualScenario.g:3695:3: RULE_STRING
            {
             before(grammarAccess.getStateFragmentAccess().getNameSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getStateFragmentAccess().getNameSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateFragment__NameAssignment_3"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00009C0FE4FFC010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000FC4000002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00009C0000FFC012L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x000000E000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000FFC010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000400000000010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000400000000012L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00009C0020FFC010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000007000000L});

}
