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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'unset'", "'behavior'", "'node'", "'scenario'", "'->'", "':'", "'->+'", "'->x'", "'->>'", "'over'", "'else'", "'{'", "'}'", "'actor'", "'component'", "'configuration_item'", "'function'", "'activity'", "'entity'", "'role'", "'withExecution'", "'withReturn'", "'deactivate'", "'ref'", "'alt'"
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


    // $ANTLR start "entryRuleAlt"
    // InternalTextualScenario.g:528:1: entryRuleAlt : ruleAlt EOF ;
    public final void entryRuleAlt() throws RecognitionException {
        try {
            // InternalTextualScenario.g:529:1: ( ruleAlt EOF )
            // InternalTextualScenario.g:530:1: ruleAlt EOF
            {
             before(grammarAccess.getAltRule()); 
            pushFollow(FOLLOW_1);
            ruleAlt();

            state._fsp--;

             after(grammarAccess.getAltRule()); 
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
    // $ANTLR end "entryRuleAlt"


    // $ANTLR start "ruleAlt"
    // InternalTextualScenario.g:537:1: ruleAlt : ( ( rule__Alt__Group__0 ) ) ;
    public final void ruleAlt() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:541:2: ( ( ( rule__Alt__Group__0 ) ) )
            // InternalTextualScenario.g:542:2: ( ( rule__Alt__Group__0 ) )
            {
            // InternalTextualScenario.g:542:2: ( ( rule__Alt__Group__0 ) )
            // InternalTextualScenario.g:543:3: ( rule__Alt__Group__0 )
            {
             before(grammarAccess.getAltAccess().getGroup()); 
            // InternalTextualScenario.g:544:3: ( rule__Alt__Group__0 )
            // InternalTextualScenario.g:544:4: rule__Alt__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Alt__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAltAccess().getGroup()); 

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
    // $ANTLR end "ruleAlt"


    // $ANTLR start "entryRuleElseBlock"
    // InternalTextualScenario.g:553:1: entryRuleElseBlock : ruleElseBlock EOF ;
    public final void entryRuleElseBlock() throws RecognitionException {
        try {
            // InternalTextualScenario.g:554:1: ( ruleElseBlock EOF )
            // InternalTextualScenario.g:555:1: ruleElseBlock EOF
            {
             before(grammarAccess.getElseBlockRule()); 
            pushFollow(FOLLOW_1);
            ruleElseBlock();

            state._fsp--;

             after(grammarAccess.getElseBlockRule()); 
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
    // $ANTLR end "entryRuleElseBlock"


    // $ANTLR start "ruleElseBlock"
    // InternalTextualScenario.g:562:1: ruleElseBlock : ( ( rule__ElseBlock__Group__0 ) ) ;
    public final void ruleElseBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:566:2: ( ( ( rule__ElseBlock__Group__0 ) ) )
            // InternalTextualScenario.g:567:2: ( ( rule__ElseBlock__Group__0 ) )
            {
            // InternalTextualScenario.g:567:2: ( ( rule__ElseBlock__Group__0 ) )
            // InternalTextualScenario.g:568:3: ( rule__ElseBlock__Group__0 )
            {
             before(grammarAccess.getElseBlockAccess().getGroup()); 
            // InternalTextualScenario.g:569:3: ( rule__ElseBlock__Group__0 )
            // InternalTextualScenario.g:569:4: rule__ElseBlock__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ElseBlock__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getElseBlockAccess().getGroup()); 

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
    // $ANTLR end "ruleElseBlock"


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


    // $ANTLR start "rule__Model__Alternatives_3"
    // InternalTextualScenario.g:602:1: rule__Model__Alternatives_3 : ( ( ( rule__Model__MessagesOrReferencesAssignment_3_0 ) ) | ( ( rule__Model__ConditionsAssignment_3_1 ) ) );
    public final void rule__Model__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:606:1: ( ( ( rule__Model__MessagesOrReferencesAssignment_3_0 ) ) | ( ( rule__Model__ConditionsAssignment_3_1 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_STRING||LA1_0==19||(LA1_0>=33 && LA1_0<=34)) ) {
                alt1=1;
            }
            else if ( (LA1_0==35) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalTextualScenario.g:607:2: ( ( rule__Model__MessagesOrReferencesAssignment_3_0 ) )
                    {
                    // InternalTextualScenario.g:607:2: ( ( rule__Model__MessagesOrReferencesAssignment_3_0 ) )
                    // InternalTextualScenario.g:608:3: ( rule__Model__MessagesOrReferencesAssignment_3_0 )
                    {
                     before(grammarAccess.getModelAccess().getMessagesOrReferencesAssignment_3_0()); 
                    // InternalTextualScenario.g:609:3: ( rule__Model__MessagesOrReferencesAssignment_3_0 )
                    // InternalTextualScenario.g:609:4: rule__Model__MessagesOrReferencesAssignment_3_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__MessagesOrReferencesAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getMessagesOrReferencesAssignment_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:613:2: ( ( rule__Model__ConditionsAssignment_3_1 ) )
                    {
                    // InternalTextualScenario.g:613:2: ( ( rule__Model__ConditionsAssignment_3_1 ) )
                    // InternalTextualScenario.g:614:3: ( rule__Model__ConditionsAssignment_3_1 )
                    {
                     before(grammarAccess.getModelAccess().getConditionsAssignment_3_1()); 
                    // InternalTextualScenario.g:615:3: ( rule__Model__ConditionsAssignment_3_1 )
                    // InternalTextualScenario.g:615:4: rule__Model__ConditionsAssignment_3_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__ConditionsAssignment_3_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getConditionsAssignment_3_1()); 

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
    // $ANTLR end "rule__Model__Alternatives_3"


    // $ANTLR start "rule__Model__MessagesOrReferencesAlternatives_3_0_0"
    // InternalTextualScenario.g:623:1: rule__Model__MessagesOrReferencesAlternatives_3_0_0 : ( ( ruleMessage ) | ( ruleReference ) );
    public final void rule__Model__MessagesOrReferencesAlternatives_3_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:627:1: ( ( ruleMessage ) | ( ruleReference ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING||LA2_0==19||LA2_0==33) ) {
                alt2=1;
            }
            else if ( (LA2_0==34) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalTextualScenario.g:628:2: ( ruleMessage )
                    {
                    // InternalTextualScenario.g:628:2: ( ruleMessage )
                    // InternalTextualScenario.g:629:3: ruleMessage
                    {
                     before(grammarAccess.getModelAccess().getMessagesOrReferencesMessageParserRuleCall_3_0_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleMessage();

                    state._fsp--;

                     after(grammarAccess.getModelAccess().getMessagesOrReferencesMessageParserRuleCall_3_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:634:2: ( ruleReference )
                    {
                    // InternalTextualScenario.g:634:2: ( ruleReference )
                    // InternalTextualScenario.g:635:3: ruleReference
                    {
                     before(grammarAccess.getModelAccess().getMessagesOrReferencesReferenceParserRuleCall_3_0_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getModelAccess().getMessagesOrReferencesReferenceParserRuleCall_3_0_0_1()); 

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
    // $ANTLR end "rule__Model__MessagesOrReferencesAlternatives_3_0_0"


    // $ANTLR start "rule__Participant__Alternatives"
    // InternalTextualScenario.g:644:1: rule__Participant__Alternatives : ( ( ruleGenericComponent ) | ( ruleGenericFunction ) );
    public final void rule__Participant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:648:1: ( ( ruleGenericComponent ) | ( ruleGenericFunction ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=24 && LA3_0<=26)||(LA3_0>=29 && LA3_0<=30)) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=27 && LA3_0<=28)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalTextualScenario.g:649:2: ( ruleGenericComponent )
                    {
                    // InternalTextualScenario.g:649:2: ( ruleGenericComponent )
                    // InternalTextualScenario.g:650:3: ruleGenericComponent
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
                    // InternalTextualScenario.g:655:2: ( ruleGenericFunction )
                    {
                    // InternalTextualScenario.g:655:2: ( ruleGenericFunction )
                    // InternalTextualScenario.g:656:3: ruleGenericFunction
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
    // InternalTextualScenario.g:665:1: rule__GenericComponent__Alternatives : ( ( ruleEntity ) | ( ruleActor ) | ( ruleComponent ) | ( ruleConfigurationItem ) | ( ruleRole ) );
    public final void rule__GenericComponent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:669:1: ( ( ruleEntity ) | ( ruleActor ) | ( ruleComponent ) | ( ruleConfigurationItem ) | ( ruleRole ) )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt4=1;
                }
                break;
            case 24:
                {
                alt4=2;
                }
                break;
            case 25:
                {
                alt4=3;
                }
                break;
            case 26:
                {
                alt4=4;
                }
                break;
            case 30:
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
                    // InternalTextualScenario.g:670:2: ( ruleEntity )
                    {
                    // InternalTextualScenario.g:670:2: ( ruleEntity )
                    // InternalTextualScenario.g:671:3: ruleEntity
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
                    // InternalTextualScenario.g:676:2: ( ruleActor )
                    {
                    // InternalTextualScenario.g:676:2: ( ruleActor )
                    // InternalTextualScenario.g:677:3: ruleActor
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
                    // InternalTextualScenario.g:682:2: ( ruleComponent )
                    {
                    // InternalTextualScenario.g:682:2: ( ruleComponent )
                    // InternalTextualScenario.g:683:3: ruleComponent
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
                    // InternalTextualScenario.g:688:2: ( ruleConfigurationItem )
                    {
                    // InternalTextualScenario.g:688:2: ( ruleConfigurationItem )
                    // InternalTextualScenario.g:689:3: ruleConfigurationItem
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
                    // InternalTextualScenario.g:694:2: ( ruleRole )
                    {
                    // InternalTextualScenario.g:694:2: ( ruleRole )
                    // InternalTextualScenario.g:695:3: ruleRole
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
    // InternalTextualScenario.g:704:1: rule__GenericFunction__Alternatives : ( ( ruleFunction ) | ( ruleActivity ) );
    public final void rule__GenericFunction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:708:1: ( ( ruleFunction ) | ( ruleActivity ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==27) ) {
                alt5=1;
            }
            else if ( (LA5_0==28) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalTextualScenario.g:709:2: ( ruleFunction )
                    {
                    // InternalTextualScenario.g:709:2: ( ruleFunction )
                    // InternalTextualScenario.g:710:3: ruleFunction
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
                    // InternalTextualScenario.g:715:2: ( ruleActivity )
                    {
                    // InternalTextualScenario.g:715:2: ( ruleActivity )
                    // InternalTextualScenario.g:716:3: ruleActivity
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
    // InternalTextualScenario.g:725:1: rule__Component__NatureAlternatives_2_0 : ( ( 'unset' ) | ( 'behavior' ) | ( 'node' ) );
    public final void rule__Component__NatureAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:729:1: ( ( 'unset' ) | ( 'behavior' ) | ( 'node' ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt6=1;
                }
                break;
            case 12:
                {
                alt6=2;
                }
                break;
            case 13:
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
                    // InternalTextualScenario.g:730:2: ( 'unset' )
                    {
                    // InternalTextualScenario.g:730:2: ( 'unset' )
                    // InternalTextualScenario.g:731:3: 'unset'
                    {
                     before(grammarAccess.getComponentAccess().getNatureUnsetKeyword_2_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getComponentAccess().getNatureUnsetKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:736:2: ( 'behavior' )
                    {
                    // InternalTextualScenario.g:736:2: ( 'behavior' )
                    // InternalTextualScenario.g:737:3: 'behavior'
                    {
                     before(grammarAccess.getComponentAccess().getNatureBehaviorKeyword_2_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getComponentAccess().getNatureBehaviorKeyword_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:742:2: ( 'node' )
                    {
                    // InternalTextualScenario.g:742:2: ( 'node' )
                    // InternalTextualScenario.g:743:3: 'node'
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
    // InternalTextualScenario.g:752:1: rule__Message__Alternatives : ( ( ruleSequenceMessageType ) | ( ruleArmTimerMessage ) | ( ruleParticipantDeactivation ) );
    public final void rule__Message__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:756:1: ( ( ruleSequenceMessageType ) | ( ruleArmTimerMessage ) | ( ruleParticipantDeactivation ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt7=1;
                }
                break;
            case 19:
                {
                alt7=2;
                }
                break;
            case 33:
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
                    // InternalTextualScenario.g:757:2: ( ruleSequenceMessageType )
                    {
                    // InternalTextualScenario.g:757:2: ( ruleSequenceMessageType )
                    // InternalTextualScenario.g:758:3: ruleSequenceMessageType
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
                    // InternalTextualScenario.g:763:2: ( ruleArmTimerMessage )
                    {
                    // InternalTextualScenario.g:763:2: ( ruleArmTimerMessage )
                    // InternalTextualScenario.g:764:3: ruleArmTimerMessage
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
                    // InternalTextualScenario.g:769:2: ( ruleParticipantDeactivation )
                    {
                    // InternalTextualScenario.g:769:2: ( ruleParticipantDeactivation )
                    // InternalTextualScenario.g:770:3: ruleParticipantDeactivation
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
    // InternalTextualScenario.g:779:1: rule__SequenceMessageType__Alternatives : ( ( ruleSequenceMessage ) | ( ruleCreateMessage ) | ( ruleDeleteMessage ) );
    public final void rule__SequenceMessageType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:783:1: ( ( ruleSequenceMessage ) | ( ruleCreateMessage ) | ( ruleDeleteMessage ) )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_STRING) ) {
                switch ( input.LA(2) ) {
                case 18:
                    {
                    alt8=3;
                    }
                    break;
                case 15:
                    {
                    alt8=1;
                    }
                    break;
                case 17:
                    {
                    alt8=2;
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
                    // InternalTextualScenario.g:784:2: ( ruleSequenceMessage )
                    {
                    // InternalTextualScenario.g:784:2: ( ruleSequenceMessage )
                    // InternalTextualScenario.g:785:3: ruleSequenceMessage
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
                    // InternalTextualScenario.g:790:2: ( ruleCreateMessage )
                    {
                    // InternalTextualScenario.g:790:2: ( ruleCreateMessage )
                    // InternalTextualScenario.g:791:3: ruleCreateMessage
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
                    // InternalTextualScenario.g:796:2: ( ruleDeleteMessage )
                    {
                    // InternalTextualScenario.g:796:2: ( ruleDeleteMessage )
                    // InternalTextualScenario.g:797:3: ruleDeleteMessage
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


    // $ANTLR start "rule__Block__Alternatives_1"
    // InternalTextualScenario.g:806:1: rule__Block__Alternatives_1 : ( ( ( rule__Block__MessagesAssignment_1_0 ) ) | ( ( rule__Block__ReferencesAssignment_1_1 ) ) | ( ( rule__Block__ConditionsAssignment_1_2 ) ) );
    public final void rule__Block__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:810:1: ( ( ( rule__Block__MessagesAssignment_1_0 ) ) | ( ( rule__Block__ReferencesAssignment_1_1 ) ) | ( ( rule__Block__ConditionsAssignment_1_2 ) ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case 19:
            case 33:
                {
                alt9=1;
                }
                break;
            case 34:
                {
                alt9=2;
                }
                break;
            case 35:
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
                    // InternalTextualScenario.g:811:2: ( ( rule__Block__MessagesAssignment_1_0 ) )
                    {
                    // InternalTextualScenario.g:811:2: ( ( rule__Block__MessagesAssignment_1_0 ) )
                    // InternalTextualScenario.g:812:3: ( rule__Block__MessagesAssignment_1_0 )
                    {
                     before(grammarAccess.getBlockAccess().getMessagesAssignment_1_0()); 
                    // InternalTextualScenario.g:813:3: ( rule__Block__MessagesAssignment_1_0 )
                    // InternalTextualScenario.g:813:4: rule__Block__MessagesAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Block__MessagesAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBlockAccess().getMessagesAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:817:2: ( ( rule__Block__ReferencesAssignment_1_1 ) )
                    {
                    // InternalTextualScenario.g:817:2: ( ( rule__Block__ReferencesAssignment_1_1 ) )
                    // InternalTextualScenario.g:818:3: ( rule__Block__ReferencesAssignment_1_1 )
                    {
                     before(grammarAccess.getBlockAccess().getReferencesAssignment_1_1()); 
                    // InternalTextualScenario.g:819:3: ( rule__Block__ReferencesAssignment_1_1 )
                    // InternalTextualScenario.g:819:4: rule__Block__ReferencesAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Block__ReferencesAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getBlockAccess().getReferencesAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:823:2: ( ( rule__Block__ConditionsAssignment_1_2 ) )
                    {
                    // InternalTextualScenario.g:823:2: ( ( rule__Block__ConditionsAssignment_1_2 ) )
                    // InternalTextualScenario.g:824:3: ( rule__Block__ConditionsAssignment_1_2 )
                    {
                     before(grammarAccess.getBlockAccess().getConditionsAssignment_1_2()); 
                    // InternalTextualScenario.g:825:3: ( rule__Block__ConditionsAssignment_1_2 )
                    // InternalTextualScenario.g:825:4: rule__Block__ConditionsAssignment_1_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Block__ConditionsAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getBlockAccess().getConditionsAssignment_1_2()); 

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
    // $ANTLR end "rule__Block__Alternatives_1"


    // $ANTLR start "rule__Model__Group__0"
    // InternalTextualScenario.g:833:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:837:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalTextualScenario.g:838:2: rule__Model__Group__0__Impl rule__Model__Group__1
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
    // InternalTextualScenario.g:845:1: rule__Model__Group__0__Impl : ( 'scenario' ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:849:1: ( ( 'scenario' ) )
            // InternalTextualScenario.g:850:1: ( 'scenario' )
            {
            // InternalTextualScenario.g:850:1: ( 'scenario' )
            // InternalTextualScenario.g:851:2: 'scenario'
            {
             before(grammarAccess.getModelAccess().getScenarioKeyword_0()); 
            match(input,14,FOLLOW_2); 
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
    // InternalTextualScenario.g:860:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:864:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalTextualScenario.g:865:2: rule__Model__Group__1__Impl rule__Model__Group__2
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
    // InternalTextualScenario.g:872:1: rule__Model__Group__1__Impl : ( ( rule__Model__BeginAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:876:1: ( ( ( rule__Model__BeginAssignment_1 ) ) )
            // InternalTextualScenario.g:877:1: ( ( rule__Model__BeginAssignment_1 ) )
            {
            // InternalTextualScenario.g:877:1: ( ( rule__Model__BeginAssignment_1 ) )
            // InternalTextualScenario.g:878:2: ( rule__Model__BeginAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getBeginAssignment_1()); 
            // InternalTextualScenario.g:879:2: ( rule__Model__BeginAssignment_1 )
            // InternalTextualScenario.g:879:3: rule__Model__BeginAssignment_1
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
    // InternalTextualScenario.g:887:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:891:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalTextualScenario.g:892:2: rule__Model__Group__2__Impl rule__Model__Group__3
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
    // InternalTextualScenario.g:899:1: rule__Model__Group__2__Impl : ( ( rule__Model__ParticipantsAssignment_2 )* ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:903:1: ( ( ( rule__Model__ParticipantsAssignment_2 )* ) )
            // InternalTextualScenario.g:904:1: ( ( rule__Model__ParticipantsAssignment_2 )* )
            {
            // InternalTextualScenario.g:904:1: ( ( rule__Model__ParticipantsAssignment_2 )* )
            // InternalTextualScenario.g:905:2: ( rule__Model__ParticipantsAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getParticipantsAssignment_2()); 
            // InternalTextualScenario.g:906:2: ( rule__Model__ParticipantsAssignment_2 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=24 && LA10_0<=30)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalTextualScenario.g:906:3: rule__Model__ParticipantsAssignment_2
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Model__ParticipantsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // InternalTextualScenario.g:914:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:918:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // InternalTextualScenario.g:919:2: rule__Model__Group__3__Impl rule__Model__Group__4
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
    // InternalTextualScenario.g:926:1: rule__Model__Group__3__Impl : ( ( rule__Model__Alternatives_3 )* ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:930:1: ( ( ( rule__Model__Alternatives_3 )* ) )
            // InternalTextualScenario.g:931:1: ( ( rule__Model__Alternatives_3 )* )
            {
            // InternalTextualScenario.g:931:1: ( ( rule__Model__Alternatives_3 )* )
            // InternalTextualScenario.g:932:2: ( rule__Model__Alternatives_3 )*
            {
             before(grammarAccess.getModelAccess().getAlternatives_3()); 
            // InternalTextualScenario.g:933:2: ( rule__Model__Alternatives_3 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_STRING||LA11_0==19||(LA11_0>=33 && LA11_0<=35)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalTextualScenario.g:933:3: rule__Model__Alternatives_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Model__Alternatives_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getAlternatives_3()); 

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
    // InternalTextualScenario.g:941:1: rule__Model__Group__4 : rule__Model__Group__4__Impl ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:945:1: ( rule__Model__Group__4__Impl )
            // InternalTextualScenario.g:946:2: rule__Model__Group__4__Impl
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
    // InternalTextualScenario.g:952:1: rule__Model__Group__4__Impl : ( ( rule__Model__EndAssignment_4 ) ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:956:1: ( ( ( rule__Model__EndAssignment_4 ) ) )
            // InternalTextualScenario.g:957:1: ( ( rule__Model__EndAssignment_4 ) )
            {
            // InternalTextualScenario.g:957:1: ( ( rule__Model__EndAssignment_4 ) )
            // InternalTextualScenario.g:958:2: ( rule__Model__EndAssignment_4 )
            {
             before(grammarAccess.getModelAccess().getEndAssignment_4()); 
            // InternalTextualScenario.g:959:2: ( rule__Model__EndAssignment_4 )
            // InternalTextualScenario.g:959:3: rule__Model__EndAssignment_4
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
    // InternalTextualScenario.g:968:1: rule__Actor__Group__0 : rule__Actor__Group__0__Impl rule__Actor__Group__1 ;
    public final void rule__Actor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:972:1: ( rule__Actor__Group__0__Impl rule__Actor__Group__1 )
            // InternalTextualScenario.g:973:2: rule__Actor__Group__0__Impl rule__Actor__Group__1
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
    // InternalTextualScenario.g:980:1: rule__Actor__Group__0__Impl : ( ( rule__Actor__KeywordAssignment_0 ) ) ;
    public final void rule__Actor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:984:1: ( ( ( rule__Actor__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:985:1: ( ( rule__Actor__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:985:1: ( ( rule__Actor__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:986:2: ( rule__Actor__KeywordAssignment_0 )
            {
             before(grammarAccess.getActorAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:987:2: ( rule__Actor__KeywordAssignment_0 )
            // InternalTextualScenario.g:987:3: rule__Actor__KeywordAssignment_0
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
    // InternalTextualScenario.g:995:1: rule__Actor__Group__1 : rule__Actor__Group__1__Impl ;
    public final void rule__Actor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:999:1: ( rule__Actor__Group__1__Impl )
            // InternalTextualScenario.g:1000:2: rule__Actor__Group__1__Impl
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
    // InternalTextualScenario.g:1006:1: rule__Actor__Group__1__Impl : ( ( rule__Actor__NameAssignment_1 ) ) ;
    public final void rule__Actor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1010:1: ( ( ( rule__Actor__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1011:1: ( ( rule__Actor__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1011:1: ( ( rule__Actor__NameAssignment_1 ) )
            // InternalTextualScenario.g:1012:2: ( rule__Actor__NameAssignment_1 )
            {
             before(grammarAccess.getActorAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1013:2: ( rule__Actor__NameAssignment_1 )
            // InternalTextualScenario.g:1013:3: rule__Actor__NameAssignment_1
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
    // InternalTextualScenario.g:1022:1: rule__Component__Group__0 : rule__Component__Group__0__Impl rule__Component__Group__1 ;
    public final void rule__Component__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1026:1: ( rule__Component__Group__0__Impl rule__Component__Group__1 )
            // InternalTextualScenario.g:1027:2: rule__Component__Group__0__Impl rule__Component__Group__1
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
    // InternalTextualScenario.g:1034:1: rule__Component__Group__0__Impl : ( ( rule__Component__KeywordAssignment_0 ) ) ;
    public final void rule__Component__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1038:1: ( ( ( rule__Component__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1039:1: ( ( rule__Component__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1039:1: ( ( rule__Component__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1040:2: ( rule__Component__KeywordAssignment_0 )
            {
             before(grammarAccess.getComponentAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1041:2: ( rule__Component__KeywordAssignment_0 )
            // InternalTextualScenario.g:1041:3: rule__Component__KeywordAssignment_0
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
    // InternalTextualScenario.g:1049:1: rule__Component__Group__1 : rule__Component__Group__1__Impl rule__Component__Group__2 ;
    public final void rule__Component__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1053:1: ( rule__Component__Group__1__Impl rule__Component__Group__2 )
            // InternalTextualScenario.g:1054:2: rule__Component__Group__1__Impl rule__Component__Group__2
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
    // InternalTextualScenario.g:1061:1: rule__Component__Group__1__Impl : ( ( rule__Component__NameAssignment_1 ) ) ;
    public final void rule__Component__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1065:1: ( ( ( rule__Component__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1066:1: ( ( rule__Component__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1066:1: ( ( rule__Component__NameAssignment_1 ) )
            // InternalTextualScenario.g:1067:2: ( rule__Component__NameAssignment_1 )
            {
             before(grammarAccess.getComponentAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1068:2: ( rule__Component__NameAssignment_1 )
            // InternalTextualScenario.g:1068:3: rule__Component__NameAssignment_1
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
    // InternalTextualScenario.g:1076:1: rule__Component__Group__2 : rule__Component__Group__2__Impl ;
    public final void rule__Component__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1080:1: ( rule__Component__Group__2__Impl )
            // InternalTextualScenario.g:1081:2: rule__Component__Group__2__Impl
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
    // InternalTextualScenario.g:1087:1: rule__Component__Group__2__Impl : ( ( rule__Component__NatureAssignment_2 )? ) ;
    public final void rule__Component__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1091:1: ( ( ( rule__Component__NatureAssignment_2 )? ) )
            // InternalTextualScenario.g:1092:1: ( ( rule__Component__NatureAssignment_2 )? )
            {
            // InternalTextualScenario.g:1092:1: ( ( rule__Component__NatureAssignment_2 )? )
            // InternalTextualScenario.g:1093:2: ( rule__Component__NatureAssignment_2 )?
            {
             before(grammarAccess.getComponentAccess().getNatureAssignment_2()); 
            // InternalTextualScenario.g:1094:2: ( rule__Component__NatureAssignment_2 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=11 && LA12_0<=13)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalTextualScenario.g:1094:3: rule__Component__NatureAssignment_2
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
    // InternalTextualScenario.g:1103:1: rule__ConfigurationItem__Group__0 : rule__ConfigurationItem__Group__0__Impl rule__ConfigurationItem__Group__1 ;
    public final void rule__ConfigurationItem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1107:1: ( rule__ConfigurationItem__Group__0__Impl rule__ConfigurationItem__Group__1 )
            // InternalTextualScenario.g:1108:2: rule__ConfigurationItem__Group__0__Impl rule__ConfigurationItem__Group__1
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
    // InternalTextualScenario.g:1115:1: rule__ConfigurationItem__Group__0__Impl : ( ( rule__ConfigurationItem__KeywordAssignment_0 ) ) ;
    public final void rule__ConfigurationItem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1119:1: ( ( ( rule__ConfigurationItem__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1120:1: ( ( rule__ConfigurationItem__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1120:1: ( ( rule__ConfigurationItem__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1121:2: ( rule__ConfigurationItem__KeywordAssignment_0 )
            {
             before(grammarAccess.getConfigurationItemAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1122:2: ( rule__ConfigurationItem__KeywordAssignment_0 )
            // InternalTextualScenario.g:1122:3: rule__ConfigurationItem__KeywordAssignment_0
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
    // InternalTextualScenario.g:1130:1: rule__ConfigurationItem__Group__1 : rule__ConfigurationItem__Group__1__Impl ;
    public final void rule__ConfigurationItem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1134:1: ( rule__ConfigurationItem__Group__1__Impl )
            // InternalTextualScenario.g:1135:2: rule__ConfigurationItem__Group__1__Impl
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
    // InternalTextualScenario.g:1141:1: rule__ConfigurationItem__Group__1__Impl : ( ( rule__ConfigurationItem__NameAssignment_1 ) ) ;
    public final void rule__ConfigurationItem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1145:1: ( ( ( rule__ConfigurationItem__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1146:1: ( ( rule__ConfigurationItem__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1146:1: ( ( rule__ConfigurationItem__NameAssignment_1 ) )
            // InternalTextualScenario.g:1147:2: ( rule__ConfigurationItem__NameAssignment_1 )
            {
             before(grammarAccess.getConfigurationItemAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1148:2: ( rule__ConfigurationItem__NameAssignment_1 )
            // InternalTextualScenario.g:1148:3: rule__ConfigurationItem__NameAssignment_1
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
    // InternalTextualScenario.g:1157:1: rule__Function__Group__0 : rule__Function__Group__0__Impl rule__Function__Group__1 ;
    public final void rule__Function__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1161:1: ( rule__Function__Group__0__Impl rule__Function__Group__1 )
            // InternalTextualScenario.g:1162:2: rule__Function__Group__0__Impl rule__Function__Group__1
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
    // InternalTextualScenario.g:1169:1: rule__Function__Group__0__Impl : ( ( rule__Function__KeywordAssignment_0 ) ) ;
    public final void rule__Function__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1173:1: ( ( ( rule__Function__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1174:1: ( ( rule__Function__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1174:1: ( ( rule__Function__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1175:2: ( rule__Function__KeywordAssignment_0 )
            {
             before(grammarAccess.getFunctionAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1176:2: ( rule__Function__KeywordAssignment_0 )
            // InternalTextualScenario.g:1176:3: rule__Function__KeywordAssignment_0
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
    // InternalTextualScenario.g:1184:1: rule__Function__Group__1 : rule__Function__Group__1__Impl ;
    public final void rule__Function__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1188:1: ( rule__Function__Group__1__Impl )
            // InternalTextualScenario.g:1189:2: rule__Function__Group__1__Impl
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
    // InternalTextualScenario.g:1195:1: rule__Function__Group__1__Impl : ( ( rule__Function__NameAssignment_1 ) ) ;
    public final void rule__Function__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1199:1: ( ( ( rule__Function__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1200:1: ( ( rule__Function__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1200:1: ( ( rule__Function__NameAssignment_1 ) )
            // InternalTextualScenario.g:1201:2: ( rule__Function__NameAssignment_1 )
            {
             before(grammarAccess.getFunctionAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1202:2: ( rule__Function__NameAssignment_1 )
            // InternalTextualScenario.g:1202:3: rule__Function__NameAssignment_1
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
    // InternalTextualScenario.g:1211:1: rule__Activity__Group__0 : rule__Activity__Group__0__Impl rule__Activity__Group__1 ;
    public final void rule__Activity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1215:1: ( rule__Activity__Group__0__Impl rule__Activity__Group__1 )
            // InternalTextualScenario.g:1216:2: rule__Activity__Group__0__Impl rule__Activity__Group__1
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
    // InternalTextualScenario.g:1223:1: rule__Activity__Group__0__Impl : ( ( rule__Activity__KeywordAssignment_0 ) ) ;
    public final void rule__Activity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1227:1: ( ( ( rule__Activity__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1228:1: ( ( rule__Activity__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1228:1: ( ( rule__Activity__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1229:2: ( rule__Activity__KeywordAssignment_0 )
            {
             before(grammarAccess.getActivityAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1230:2: ( rule__Activity__KeywordAssignment_0 )
            // InternalTextualScenario.g:1230:3: rule__Activity__KeywordAssignment_0
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
    // InternalTextualScenario.g:1238:1: rule__Activity__Group__1 : rule__Activity__Group__1__Impl ;
    public final void rule__Activity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1242:1: ( rule__Activity__Group__1__Impl )
            // InternalTextualScenario.g:1243:2: rule__Activity__Group__1__Impl
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
    // InternalTextualScenario.g:1249:1: rule__Activity__Group__1__Impl : ( ( rule__Activity__NameAssignment_1 ) ) ;
    public final void rule__Activity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1253:1: ( ( ( rule__Activity__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1254:1: ( ( rule__Activity__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1254:1: ( ( rule__Activity__NameAssignment_1 ) )
            // InternalTextualScenario.g:1255:2: ( rule__Activity__NameAssignment_1 )
            {
             before(grammarAccess.getActivityAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1256:2: ( rule__Activity__NameAssignment_1 )
            // InternalTextualScenario.g:1256:3: rule__Activity__NameAssignment_1
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
    // InternalTextualScenario.g:1265:1: rule__Entity__Group__0 : rule__Entity__Group__0__Impl rule__Entity__Group__1 ;
    public final void rule__Entity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1269:1: ( rule__Entity__Group__0__Impl rule__Entity__Group__1 )
            // InternalTextualScenario.g:1270:2: rule__Entity__Group__0__Impl rule__Entity__Group__1
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
    // InternalTextualScenario.g:1277:1: rule__Entity__Group__0__Impl : ( ( rule__Entity__KeywordAssignment_0 ) ) ;
    public final void rule__Entity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1281:1: ( ( ( rule__Entity__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1282:1: ( ( rule__Entity__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1282:1: ( ( rule__Entity__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1283:2: ( rule__Entity__KeywordAssignment_0 )
            {
             before(grammarAccess.getEntityAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1284:2: ( rule__Entity__KeywordAssignment_0 )
            // InternalTextualScenario.g:1284:3: rule__Entity__KeywordAssignment_0
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
    // InternalTextualScenario.g:1292:1: rule__Entity__Group__1 : rule__Entity__Group__1__Impl ;
    public final void rule__Entity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1296:1: ( rule__Entity__Group__1__Impl )
            // InternalTextualScenario.g:1297:2: rule__Entity__Group__1__Impl
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
    // InternalTextualScenario.g:1303:1: rule__Entity__Group__1__Impl : ( ( rule__Entity__NameAssignment_1 ) ) ;
    public final void rule__Entity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1307:1: ( ( ( rule__Entity__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1308:1: ( ( rule__Entity__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1308:1: ( ( rule__Entity__NameAssignment_1 ) )
            // InternalTextualScenario.g:1309:2: ( rule__Entity__NameAssignment_1 )
            {
             before(grammarAccess.getEntityAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1310:2: ( rule__Entity__NameAssignment_1 )
            // InternalTextualScenario.g:1310:3: rule__Entity__NameAssignment_1
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
    // InternalTextualScenario.g:1319:1: rule__Role__Group__0 : rule__Role__Group__0__Impl rule__Role__Group__1 ;
    public final void rule__Role__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1323:1: ( rule__Role__Group__0__Impl rule__Role__Group__1 )
            // InternalTextualScenario.g:1324:2: rule__Role__Group__0__Impl rule__Role__Group__1
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
    // InternalTextualScenario.g:1331:1: rule__Role__Group__0__Impl : ( ( rule__Role__KeywordAssignment_0 ) ) ;
    public final void rule__Role__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1335:1: ( ( ( rule__Role__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1336:1: ( ( rule__Role__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1336:1: ( ( rule__Role__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1337:2: ( rule__Role__KeywordAssignment_0 )
            {
             before(grammarAccess.getRoleAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1338:2: ( rule__Role__KeywordAssignment_0 )
            // InternalTextualScenario.g:1338:3: rule__Role__KeywordAssignment_0
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
    // InternalTextualScenario.g:1346:1: rule__Role__Group__1 : rule__Role__Group__1__Impl ;
    public final void rule__Role__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1350:1: ( rule__Role__Group__1__Impl )
            // InternalTextualScenario.g:1351:2: rule__Role__Group__1__Impl
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
    // InternalTextualScenario.g:1357:1: rule__Role__Group__1__Impl : ( ( rule__Role__NameAssignment_1 ) ) ;
    public final void rule__Role__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1361:1: ( ( ( rule__Role__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1362:1: ( ( rule__Role__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1362:1: ( ( rule__Role__NameAssignment_1 ) )
            // InternalTextualScenario.g:1363:2: ( rule__Role__NameAssignment_1 )
            {
             before(grammarAccess.getRoleAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1364:2: ( rule__Role__NameAssignment_1 )
            // InternalTextualScenario.g:1364:3: rule__Role__NameAssignment_1
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
    // InternalTextualScenario.g:1373:1: rule__SequenceMessage__Group__0 : rule__SequenceMessage__Group__0__Impl rule__SequenceMessage__Group__1 ;
    public final void rule__SequenceMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1377:1: ( rule__SequenceMessage__Group__0__Impl rule__SequenceMessage__Group__1 )
            // InternalTextualScenario.g:1378:2: rule__SequenceMessage__Group__0__Impl rule__SequenceMessage__Group__1
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
    // InternalTextualScenario.g:1385:1: rule__SequenceMessage__Group__0__Impl : ( ( rule__SequenceMessage__SourceAssignment_0 ) ) ;
    public final void rule__SequenceMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1389:1: ( ( ( rule__SequenceMessage__SourceAssignment_0 ) ) )
            // InternalTextualScenario.g:1390:1: ( ( rule__SequenceMessage__SourceAssignment_0 ) )
            {
            // InternalTextualScenario.g:1390:1: ( ( rule__SequenceMessage__SourceAssignment_0 ) )
            // InternalTextualScenario.g:1391:2: ( rule__SequenceMessage__SourceAssignment_0 )
            {
             before(grammarAccess.getSequenceMessageAccess().getSourceAssignment_0()); 
            // InternalTextualScenario.g:1392:2: ( rule__SequenceMessage__SourceAssignment_0 )
            // InternalTextualScenario.g:1392:3: rule__SequenceMessage__SourceAssignment_0
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
    // InternalTextualScenario.g:1400:1: rule__SequenceMessage__Group__1 : rule__SequenceMessage__Group__1__Impl rule__SequenceMessage__Group__2 ;
    public final void rule__SequenceMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1404:1: ( rule__SequenceMessage__Group__1__Impl rule__SequenceMessage__Group__2 )
            // InternalTextualScenario.g:1405:2: rule__SequenceMessage__Group__1__Impl rule__SequenceMessage__Group__2
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
    // InternalTextualScenario.g:1412:1: rule__SequenceMessage__Group__1__Impl : ( '->' ) ;
    public final void rule__SequenceMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1416:1: ( ( '->' ) )
            // InternalTextualScenario.g:1417:1: ( '->' )
            {
            // InternalTextualScenario.g:1417:1: ( '->' )
            // InternalTextualScenario.g:1418:2: '->'
            {
             before(grammarAccess.getSequenceMessageAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getSequenceMessageAccess().getHyphenMinusGreaterThanSignKeyword_1()); 

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
    // InternalTextualScenario.g:1427:1: rule__SequenceMessage__Group__2 : rule__SequenceMessage__Group__2__Impl rule__SequenceMessage__Group__3 ;
    public final void rule__SequenceMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1431:1: ( rule__SequenceMessage__Group__2__Impl rule__SequenceMessage__Group__3 )
            // InternalTextualScenario.g:1432:2: rule__SequenceMessage__Group__2__Impl rule__SequenceMessage__Group__3
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
    // InternalTextualScenario.g:1439:1: rule__SequenceMessage__Group__2__Impl : ( ( rule__SequenceMessage__TargetAssignment_2 ) ) ;
    public final void rule__SequenceMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1443:1: ( ( ( rule__SequenceMessage__TargetAssignment_2 ) ) )
            // InternalTextualScenario.g:1444:1: ( ( rule__SequenceMessage__TargetAssignment_2 ) )
            {
            // InternalTextualScenario.g:1444:1: ( ( rule__SequenceMessage__TargetAssignment_2 ) )
            // InternalTextualScenario.g:1445:2: ( rule__SequenceMessage__TargetAssignment_2 )
            {
             before(grammarAccess.getSequenceMessageAccess().getTargetAssignment_2()); 
            // InternalTextualScenario.g:1446:2: ( rule__SequenceMessage__TargetAssignment_2 )
            // InternalTextualScenario.g:1446:3: rule__SequenceMessage__TargetAssignment_2
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
    // InternalTextualScenario.g:1454:1: rule__SequenceMessage__Group__3 : rule__SequenceMessage__Group__3__Impl rule__SequenceMessage__Group__4 ;
    public final void rule__SequenceMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1458:1: ( rule__SequenceMessage__Group__3__Impl rule__SequenceMessage__Group__4 )
            // InternalTextualScenario.g:1459:2: rule__SequenceMessage__Group__3__Impl rule__SequenceMessage__Group__4
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
    // InternalTextualScenario.g:1466:1: rule__SequenceMessage__Group__3__Impl : ( ( rule__SequenceMessage__ExecutionAssignment_3 )? ) ;
    public final void rule__SequenceMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1470:1: ( ( ( rule__SequenceMessage__ExecutionAssignment_3 )? ) )
            // InternalTextualScenario.g:1471:1: ( ( rule__SequenceMessage__ExecutionAssignment_3 )? )
            {
            // InternalTextualScenario.g:1471:1: ( ( rule__SequenceMessage__ExecutionAssignment_3 )? )
            // InternalTextualScenario.g:1472:2: ( rule__SequenceMessage__ExecutionAssignment_3 )?
            {
             before(grammarAccess.getSequenceMessageAccess().getExecutionAssignment_3()); 
            // InternalTextualScenario.g:1473:2: ( rule__SequenceMessage__ExecutionAssignment_3 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==31) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTextualScenario.g:1473:3: rule__SequenceMessage__ExecutionAssignment_3
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
    // InternalTextualScenario.g:1481:1: rule__SequenceMessage__Group__4 : rule__SequenceMessage__Group__4__Impl rule__SequenceMessage__Group__5 ;
    public final void rule__SequenceMessage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1485:1: ( rule__SequenceMessage__Group__4__Impl rule__SequenceMessage__Group__5 )
            // InternalTextualScenario.g:1486:2: rule__SequenceMessage__Group__4__Impl rule__SequenceMessage__Group__5
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
    // InternalTextualScenario.g:1493:1: rule__SequenceMessage__Group__4__Impl : ( ( rule__SequenceMessage__ReturnAssignment_4 )? ) ;
    public final void rule__SequenceMessage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1497:1: ( ( ( rule__SequenceMessage__ReturnAssignment_4 )? ) )
            // InternalTextualScenario.g:1498:1: ( ( rule__SequenceMessage__ReturnAssignment_4 )? )
            {
            // InternalTextualScenario.g:1498:1: ( ( rule__SequenceMessage__ReturnAssignment_4 )? )
            // InternalTextualScenario.g:1499:2: ( rule__SequenceMessage__ReturnAssignment_4 )?
            {
             before(grammarAccess.getSequenceMessageAccess().getReturnAssignment_4()); 
            // InternalTextualScenario.g:1500:2: ( rule__SequenceMessage__ReturnAssignment_4 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==32) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalTextualScenario.g:1500:3: rule__SequenceMessage__ReturnAssignment_4
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
    // InternalTextualScenario.g:1508:1: rule__SequenceMessage__Group__5 : rule__SequenceMessage__Group__5__Impl rule__SequenceMessage__Group__6 ;
    public final void rule__SequenceMessage__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1512:1: ( rule__SequenceMessage__Group__5__Impl rule__SequenceMessage__Group__6 )
            // InternalTextualScenario.g:1513:2: rule__SequenceMessage__Group__5__Impl rule__SequenceMessage__Group__6
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
    // InternalTextualScenario.g:1520:1: rule__SequenceMessage__Group__5__Impl : ( ':' ) ;
    public final void rule__SequenceMessage__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1524:1: ( ( ':' ) )
            // InternalTextualScenario.g:1525:1: ( ':' )
            {
            // InternalTextualScenario.g:1525:1: ( ':' )
            // InternalTextualScenario.g:1526:2: ':'
            {
             before(grammarAccess.getSequenceMessageAccess().getColonKeyword_5()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getSequenceMessageAccess().getColonKeyword_5()); 

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
    // InternalTextualScenario.g:1535:1: rule__SequenceMessage__Group__6 : rule__SequenceMessage__Group__6__Impl ;
    public final void rule__SequenceMessage__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1539:1: ( rule__SequenceMessage__Group__6__Impl )
            // InternalTextualScenario.g:1540:2: rule__SequenceMessage__Group__6__Impl
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
    // InternalTextualScenario.g:1546:1: rule__SequenceMessage__Group__6__Impl : ( ( rule__SequenceMessage__NameAssignment_6 ) ) ;
    public final void rule__SequenceMessage__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1550:1: ( ( ( rule__SequenceMessage__NameAssignment_6 ) ) )
            // InternalTextualScenario.g:1551:1: ( ( rule__SequenceMessage__NameAssignment_6 ) )
            {
            // InternalTextualScenario.g:1551:1: ( ( rule__SequenceMessage__NameAssignment_6 ) )
            // InternalTextualScenario.g:1552:2: ( rule__SequenceMessage__NameAssignment_6 )
            {
             before(grammarAccess.getSequenceMessageAccess().getNameAssignment_6()); 
            // InternalTextualScenario.g:1553:2: ( rule__SequenceMessage__NameAssignment_6 )
            // InternalTextualScenario.g:1553:3: rule__SequenceMessage__NameAssignment_6
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
    // InternalTextualScenario.g:1562:1: rule__CreateMessage__Group__0 : rule__CreateMessage__Group__0__Impl rule__CreateMessage__Group__1 ;
    public final void rule__CreateMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1566:1: ( rule__CreateMessage__Group__0__Impl rule__CreateMessage__Group__1 )
            // InternalTextualScenario.g:1567:2: rule__CreateMessage__Group__0__Impl rule__CreateMessage__Group__1
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
    // InternalTextualScenario.g:1574:1: rule__CreateMessage__Group__0__Impl : ( ( rule__CreateMessage__SourceAssignment_0 ) ) ;
    public final void rule__CreateMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1578:1: ( ( ( rule__CreateMessage__SourceAssignment_0 ) ) )
            // InternalTextualScenario.g:1579:1: ( ( rule__CreateMessage__SourceAssignment_0 ) )
            {
            // InternalTextualScenario.g:1579:1: ( ( rule__CreateMessage__SourceAssignment_0 ) )
            // InternalTextualScenario.g:1580:2: ( rule__CreateMessage__SourceAssignment_0 )
            {
             before(grammarAccess.getCreateMessageAccess().getSourceAssignment_0()); 
            // InternalTextualScenario.g:1581:2: ( rule__CreateMessage__SourceAssignment_0 )
            // InternalTextualScenario.g:1581:3: rule__CreateMessage__SourceAssignment_0
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
    // InternalTextualScenario.g:1589:1: rule__CreateMessage__Group__1 : rule__CreateMessage__Group__1__Impl rule__CreateMessage__Group__2 ;
    public final void rule__CreateMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1593:1: ( rule__CreateMessage__Group__1__Impl rule__CreateMessage__Group__2 )
            // InternalTextualScenario.g:1594:2: rule__CreateMessage__Group__1__Impl rule__CreateMessage__Group__2
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
    // InternalTextualScenario.g:1601:1: rule__CreateMessage__Group__1__Impl : ( '->+' ) ;
    public final void rule__CreateMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1605:1: ( ( '->+' ) )
            // InternalTextualScenario.g:1606:1: ( '->+' )
            {
            // InternalTextualScenario.g:1606:1: ( '->+' )
            // InternalTextualScenario.g:1607:2: '->+'
            {
             before(grammarAccess.getCreateMessageAccess().getHyphenMinusGreaterThanSignPlusSignKeyword_1()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getCreateMessageAccess().getHyphenMinusGreaterThanSignPlusSignKeyword_1()); 

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
    // InternalTextualScenario.g:1616:1: rule__CreateMessage__Group__2 : rule__CreateMessage__Group__2__Impl rule__CreateMessage__Group__3 ;
    public final void rule__CreateMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1620:1: ( rule__CreateMessage__Group__2__Impl rule__CreateMessage__Group__3 )
            // InternalTextualScenario.g:1621:2: rule__CreateMessage__Group__2__Impl rule__CreateMessage__Group__3
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
    // InternalTextualScenario.g:1628:1: rule__CreateMessage__Group__2__Impl : ( ( rule__CreateMessage__TargetAssignment_2 ) ) ;
    public final void rule__CreateMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1632:1: ( ( ( rule__CreateMessage__TargetAssignment_2 ) ) )
            // InternalTextualScenario.g:1633:1: ( ( rule__CreateMessage__TargetAssignment_2 ) )
            {
            // InternalTextualScenario.g:1633:1: ( ( rule__CreateMessage__TargetAssignment_2 ) )
            // InternalTextualScenario.g:1634:2: ( rule__CreateMessage__TargetAssignment_2 )
            {
             before(grammarAccess.getCreateMessageAccess().getTargetAssignment_2()); 
            // InternalTextualScenario.g:1635:2: ( rule__CreateMessage__TargetAssignment_2 )
            // InternalTextualScenario.g:1635:3: rule__CreateMessage__TargetAssignment_2
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
    // InternalTextualScenario.g:1643:1: rule__CreateMessage__Group__3 : rule__CreateMessage__Group__3__Impl rule__CreateMessage__Group__4 ;
    public final void rule__CreateMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1647:1: ( rule__CreateMessage__Group__3__Impl rule__CreateMessage__Group__4 )
            // InternalTextualScenario.g:1648:2: rule__CreateMessage__Group__3__Impl rule__CreateMessage__Group__4
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
    // InternalTextualScenario.g:1655:1: rule__CreateMessage__Group__3__Impl : ( ':' ) ;
    public final void rule__CreateMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1659:1: ( ( ':' ) )
            // InternalTextualScenario.g:1660:1: ( ':' )
            {
            // InternalTextualScenario.g:1660:1: ( ':' )
            // InternalTextualScenario.g:1661:2: ':'
            {
             before(grammarAccess.getCreateMessageAccess().getColonKeyword_3()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getCreateMessageAccess().getColonKeyword_3()); 

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
    // InternalTextualScenario.g:1670:1: rule__CreateMessage__Group__4 : rule__CreateMessage__Group__4__Impl ;
    public final void rule__CreateMessage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1674:1: ( rule__CreateMessage__Group__4__Impl )
            // InternalTextualScenario.g:1675:2: rule__CreateMessage__Group__4__Impl
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
    // InternalTextualScenario.g:1681:1: rule__CreateMessage__Group__4__Impl : ( ( rule__CreateMessage__NameAssignment_4 ) ) ;
    public final void rule__CreateMessage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1685:1: ( ( ( rule__CreateMessage__NameAssignment_4 ) ) )
            // InternalTextualScenario.g:1686:1: ( ( rule__CreateMessage__NameAssignment_4 ) )
            {
            // InternalTextualScenario.g:1686:1: ( ( rule__CreateMessage__NameAssignment_4 ) )
            // InternalTextualScenario.g:1687:2: ( rule__CreateMessage__NameAssignment_4 )
            {
             before(grammarAccess.getCreateMessageAccess().getNameAssignment_4()); 
            // InternalTextualScenario.g:1688:2: ( rule__CreateMessage__NameAssignment_4 )
            // InternalTextualScenario.g:1688:3: rule__CreateMessage__NameAssignment_4
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
    // InternalTextualScenario.g:1697:1: rule__DeleteMessage__Group__0 : rule__DeleteMessage__Group__0__Impl rule__DeleteMessage__Group__1 ;
    public final void rule__DeleteMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1701:1: ( rule__DeleteMessage__Group__0__Impl rule__DeleteMessage__Group__1 )
            // InternalTextualScenario.g:1702:2: rule__DeleteMessage__Group__0__Impl rule__DeleteMessage__Group__1
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
    // InternalTextualScenario.g:1709:1: rule__DeleteMessage__Group__0__Impl : ( ( rule__DeleteMessage__SourceAssignment_0 ) ) ;
    public final void rule__DeleteMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1713:1: ( ( ( rule__DeleteMessage__SourceAssignment_0 ) ) )
            // InternalTextualScenario.g:1714:1: ( ( rule__DeleteMessage__SourceAssignment_0 ) )
            {
            // InternalTextualScenario.g:1714:1: ( ( rule__DeleteMessage__SourceAssignment_0 ) )
            // InternalTextualScenario.g:1715:2: ( rule__DeleteMessage__SourceAssignment_0 )
            {
             before(grammarAccess.getDeleteMessageAccess().getSourceAssignment_0()); 
            // InternalTextualScenario.g:1716:2: ( rule__DeleteMessage__SourceAssignment_0 )
            // InternalTextualScenario.g:1716:3: rule__DeleteMessage__SourceAssignment_0
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
    // InternalTextualScenario.g:1724:1: rule__DeleteMessage__Group__1 : rule__DeleteMessage__Group__1__Impl rule__DeleteMessage__Group__2 ;
    public final void rule__DeleteMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1728:1: ( rule__DeleteMessage__Group__1__Impl rule__DeleteMessage__Group__2 )
            // InternalTextualScenario.g:1729:2: rule__DeleteMessage__Group__1__Impl rule__DeleteMessage__Group__2
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
    // InternalTextualScenario.g:1736:1: rule__DeleteMessage__Group__1__Impl : ( '->x' ) ;
    public final void rule__DeleteMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1740:1: ( ( '->x' ) )
            // InternalTextualScenario.g:1741:1: ( '->x' )
            {
            // InternalTextualScenario.g:1741:1: ( '->x' )
            // InternalTextualScenario.g:1742:2: '->x'
            {
             before(grammarAccess.getDeleteMessageAccess().getXKeyword_1()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getDeleteMessageAccess().getXKeyword_1()); 

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
    // InternalTextualScenario.g:1751:1: rule__DeleteMessage__Group__2 : rule__DeleteMessage__Group__2__Impl rule__DeleteMessage__Group__3 ;
    public final void rule__DeleteMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1755:1: ( rule__DeleteMessage__Group__2__Impl rule__DeleteMessage__Group__3 )
            // InternalTextualScenario.g:1756:2: rule__DeleteMessage__Group__2__Impl rule__DeleteMessage__Group__3
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
    // InternalTextualScenario.g:1763:1: rule__DeleteMessage__Group__2__Impl : ( ( rule__DeleteMessage__TargetAssignment_2 ) ) ;
    public final void rule__DeleteMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1767:1: ( ( ( rule__DeleteMessage__TargetAssignment_2 ) ) )
            // InternalTextualScenario.g:1768:1: ( ( rule__DeleteMessage__TargetAssignment_2 ) )
            {
            // InternalTextualScenario.g:1768:1: ( ( rule__DeleteMessage__TargetAssignment_2 ) )
            // InternalTextualScenario.g:1769:2: ( rule__DeleteMessage__TargetAssignment_2 )
            {
             before(grammarAccess.getDeleteMessageAccess().getTargetAssignment_2()); 
            // InternalTextualScenario.g:1770:2: ( rule__DeleteMessage__TargetAssignment_2 )
            // InternalTextualScenario.g:1770:3: rule__DeleteMessage__TargetAssignment_2
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
    // InternalTextualScenario.g:1778:1: rule__DeleteMessage__Group__3 : rule__DeleteMessage__Group__3__Impl rule__DeleteMessage__Group__4 ;
    public final void rule__DeleteMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1782:1: ( rule__DeleteMessage__Group__3__Impl rule__DeleteMessage__Group__4 )
            // InternalTextualScenario.g:1783:2: rule__DeleteMessage__Group__3__Impl rule__DeleteMessage__Group__4
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
    // InternalTextualScenario.g:1790:1: rule__DeleteMessage__Group__3__Impl : ( ':' ) ;
    public final void rule__DeleteMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1794:1: ( ( ':' ) )
            // InternalTextualScenario.g:1795:1: ( ':' )
            {
            // InternalTextualScenario.g:1795:1: ( ':' )
            // InternalTextualScenario.g:1796:2: ':'
            {
             before(grammarAccess.getDeleteMessageAccess().getColonKeyword_3()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getDeleteMessageAccess().getColonKeyword_3()); 

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
    // InternalTextualScenario.g:1805:1: rule__DeleteMessage__Group__4 : rule__DeleteMessage__Group__4__Impl ;
    public final void rule__DeleteMessage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1809:1: ( rule__DeleteMessage__Group__4__Impl )
            // InternalTextualScenario.g:1810:2: rule__DeleteMessage__Group__4__Impl
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
    // InternalTextualScenario.g:1816:1: rule__DeleteMessage__Group__4__Impl : ( ( rule__DeleteMessage__NameAssignment_4 ) ) ;
    public final void rule__DeleteMessage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1820:1: ( ( ( rule__DeleteMessage__NameAssignment_4 ) ) )
            // InternalTextualScenario.g:1821:1: ( ( rule__DeleteMessage__NameAssignment_4 ) )
            {
            // InternalTextualScenario.g:1821:1: ( ( rule__DeleteMessage__NameAssignment_4 ) )
            // InternalTextualScenario.g:1822:2: ( rule__DeleteMessage__NameAssignment_4 )
            {
             before(grammarAccess.getDeleteMessageAccess().getNameAssignment_4()); 
            // InternalTextualScenario.g:1823:2: ( rule__DeleteMessage__NameAssignment_4 )
            // InternalTextualScenario.g:1823:3: rule__DeleteMessage__NameAssignment_4
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
    // InternalTextualScenario.g:1832:1: rule__ArmTimerMessage__Group__0 : rule__ArmTimerMessage__Group__0__Impl rule__ArmTimerMessage__Group__1 ;
    public final void rule__ArmTimerMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1836:1: ( rule__ArmTimerMessage__Group__0__Impl rule__ArmTimerMessage__Group__1 )
            // InternalTextualScenario.g:1837:2: rule__ArmTimerMessage__Group__0__Impl rule__ArmTimerMessage__Group__1
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
    // InternalTextualScenario.g:1844:1: rule__ArmTimerMessage__Group__0__Impl : ( '->>' ) ;
    public final void rule__ArmTimerMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1848:1: ( ( '->>' ) )
            // InternalTextualScenario.g:1849:1: ( '->>' )
            {
            // InternalTextualScenario.g:1849:1: ( '->>' )
            // InternalTextualScenario.g:1850:2: '->>'
            {
             before(grammarAccess.getArmTimerMessageAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getArmTimerMessageAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_0()); 

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
    // InternalTextualScenario.g:1859:1: rule__ArmTimerMessage__Group__1 : rule__ArmTimerMessage__Group__1__Impl rule__ArmTimerMessage__Group__2 ;
    public final void rule__ArmTimerMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1863:1: ( rule__ArmTimerMessage__Group__1__Impl rule__ArmTimerMessage__Group__2 )
            // InternalTextualScenario.g:1864:2: rule__ArmTimerMessage__Group__1__Impl rule__ArmTimerMessage__Group__2
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
    // InternalTextualScenario.g:1871:1: rule__ArmTimerMessage__Group__1__Impl : ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) ) ;
    public final void rule__ArmTimerMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1875:1: ( ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) ) )
            // InternalTextualScenario.g:1876:1: ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) )
            {
            // InternalTextualScenario.g:1876:1: ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) )
            // InternalTextualScenario.g:1877:2: ( rule__ArmTimerMessage__ParticipantAssignment_1 )
            {
             before(grammarAccess.getArmTimerMessageAccess().getParticipantAssignment_1()); 
            // InternalTextualScenario.g:1878:2: ( rule__ArmTimerMessage__ParticipantAssignment_1 )
            // InternalTextualScenario.g:1878:3: rule__ArmTimerMessage__ParticipantAssignment_1
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
    // InternalTextualScenario.g:1886:1: rule__ArmTimerMessage__Group__2 : rule__ArmTimerMessage__Group__2__Impl rule__ArmTimerMessage__Group__3 ;
    public final void rule__ArmTimerMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1890:1: ( rule__ArmTimerMessage__Group__2__Impl rule__ArmTimerMessage__Group__3 )
            // InternalTextualScenario.g:1891:2: rule__ArmTimerMessage__Group__2__Impl rule__ArmTimerMessage__Group__3
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
    // InternalTextualScenario.g:1898:1: rule__ArmTimerMessage__Group__2__Impl : ( ':' ) ;
    public final void rule__ArmTimerMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1902:1: ( ( ':' ) )
            // InternalTextualScenario.g:1903:1: ( ':' )
            {
            // InternalTextualScenario.g:1903:1: ( ':' )
            // InternalTextualScenario.g:1904:2: ':'
            {
             before(grammarAccess.getArmTimerMessageAccess().getColonKeyword_2()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getArmTimerMessageAccess().getColonKeyword_2()); 

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
    // InternalTextualScenario.g:1913:1: rule__ArmTimerMessage__Group__3 : rule__ArmTimerMessage__Group__3__Impl ;
    public final void rule__ArmTimerMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1917:1: ( rule__ArmTimerMessage__Group__3__Impl )
            // InternalTextualScenario.g:1918:2: rule__ArmTimerMessage__Group__3__Impl
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
    // InternalTextualScenario.g:1924:1: rule__ArmTimerMessage__Group__3__Impl : ( ( rule__ArmTimerMessage__NameAssignment_3 ) ) ;
    public final void rule__ArmTimerMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1928:1: ( ( ( rule__ArmTimerMessage__NameAssignment_3 ) ) )
            // InternalTextualScenario.g:1929:1: ( ( rule__ArmTimerMessage__NameAssignment_3 ) )
            {
            // InternalTextualScenario.g:1929:1: ( ( rule__ArmTimerMessage__NameAssignment_3 ) )
            // InternalTextualScenario.g:1930:2: ( rule__ArmTimerMessage__NameAssignment_3 )
            {
             before(grammarAccess.getArmTimerMessageAccess().getNameAssignment_3()); 
            // InternalTextualScenario.g:1931:2: ( rule__ArmTimerMessage__NameAssignment_3 )
            // InternalTextualScenario.g:1931:3: rule__ArmTimerMessage__NameAssignment_3
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
    // InternalTextualScenario.g:1940:1: rule__ParticipantDeactivation__Group__0 : rule__ParticipantDeactivation__Group__0__Impl rule__ParticipantDeactivation__Group__1 ;
    public final void rule__ParticipantDeactivation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1944:1: ( rule__ParticipantDeactivation__Group__0__Impl rule__ParticipantDeactivation__Group__1 )
            // InternalTextualScenario.g:1945:2: rule__ParticipantDeactivation__Group__0__Impl rule__ParticipantDeactivation__Group__1
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
    // InternalTextualScenario.g:1952:1: rule__ParticipantDeactivation__Group__0__Impl : ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) ) ;
    public final void rule__ParticipantDeactivation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1956:1: ( ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1957:1: ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1957:1: ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1958:2: ( rule__ParticipantDeactivation__KeywordAssignment_0 )
            {
             before(grammarAccess.getParticipantDeactivationAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1959:2: ( rule__ParticipantDeactivation__KeywordAssignment_0 )
            // InternalTextualScenario.g:1959:3: rule__ParticipantDeactivation__KeywordAssignment_0
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
    // InternalTextualScenario.g:1967:1: rule__ParticipantDeactivation__Group__1 : rule__ParticipantDeactivation__Group__1__Impl ;
    public final void rule__ParticipantDeactivation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1971:1: ( rule__ParticipantDeactivation__Group__1__Impl )
            // InternalTextualScenario.g:1972:2: rule__ParticipantDeactivation__Group__1__Impl
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
    // InternalTextualScenario.g:1978:1: rule__ParticipantDeactivation__Group__1__Impl : ( ( rule__ParticipantDeactivation__NameAssignment_1 ) ) ;
    public final void rule__ParticipantDeactivation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1982:1: ( ( ( rule__ParticipantDeactivation__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1983:1: ( ( rule__ParticipantDeactivation__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1983:1: ( ( rule__ParticipantDeactivation__NameAssignment_1 ) )
            // InternalTextualScenario.g:1984:2: ( rule__ParticipantDeactivation__NameAssignment_1 )
            {
             before(grammarAccess.getParticipantDeactivationAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1985:2: ( rule__ParticipantDeactivation__NameAssignment_1 )
            // InternalTextualScenario.g:1985:3: rule__ParticipantDeactivation__NameAssignment_1
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
    // InternalTextualScenario.g:1994:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1998:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // InternalTextualScenario.g:1999:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
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
    // InternalTextualScenario.g:2006:1: rule__Reference__Group__0__Impl : ( ( rule__Reference__KeywordAssignment_0 ) ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2010:1: ( ( ( rule__Reference__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:2011:1: ( ( rule__Reference__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:2011:1: ( ( rule__Reference__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:2012:2: ( rule__Reference__KeywordAssignment_0 )
            {
             before(grammarAccess.getReferenceAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:2013:2: ( rule__Reference__KeywordAssignment_0 )
            // InternalTextualScenario.g:2013:3: rule__Reference__KeywordAssignment_0
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
    // InternalTextualScenario.g:2021:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2025:1: ( rule__Reference__Group__1__Impl rule__Reference__Group__2 )
            // InternalTextualScenario.g:2026:2: rule__Reference__Group__1__Impl rule__Reference__Group__2
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
    // InternalTextualScenario.g:2033:1: rule__Reference__Group__1__Impl : ( 'over' ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2037:1: ( ( 'over' ) )
            // InternalTextualScenario.g:2038:1: ( 'over' )
            {
            // InternalTextualScenario.g:2038:1: ( 'over' )
            // InternalTextualScenario.g:2039:2: 'over'
            {
             before(grammarAccess.getReferenceAccess().getOverKeyword_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getOverKeyword_1()); 

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
    // InternalTextualScenario.g:2048:1: rule__Reference__Group__2 : rule__Reference__Group__2__Impl rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2052:1: ( rule__Reference__Group__2__Impl rule__Reference__Group__3 )
            // InternalTextualScenario.g:2053:2: rule__Reference__Group__2__Impl rule__Reference__Group__3
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
    // InternalTextualScenario.g:2060:1: rule__Reference__Group__2__Impl : ( ( ( rule__Reference__TimelinesAssignment_2 ) ) ( ( rule__Reference__TimelinesAssignment_2 )* ) ) ;
    public final void rule__Reference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2064:1: ( ( ( ( rule__Reference__TimelinesAssignment_2 ) ) ( ( rule__Reference__TimelinesAssignment_2 )* ) ) )
            // InternalTextualScenario.g:2065:1: ( ( ( rule__Reference__TimelinesAssignment_2 ) ) ( ( rule__Reference__TimelinesAssignment_2 )* ) )
            {
            // InternalTextualScenario.g:2065:1: ( ( ( rule__Reference__TimelinesAssignment_2 ) ) ( ( rule__Reference__TimelinesAssignment_2 )* ) )
            // InternalTextualScenario.g:2066:2: ( ( rule__Reference__TimelinesAssignment_2 ) ) ( ( rule__Reference__TimelinesAssignment_2 )* )
            {
            // InternalTextualScenario.g:2066:2: ( ( rule__Reference__TimelinesAssignment_2 ) )
            // InternalTextualScenario.g:2067:3: ( rule__Reference__TimelinesAssignment_2 )
            {
             before(grammarAccess.getReferenceAccess().getTimelinesAssignment_2()); 
            // InternalTextualScenario.g:2068:3: ( rule__Reference__TimelinesAssignment_2 )
            // InternalTextualScenario.g:2068:4: rule__Reference__TimelinesAssignment_2
            {
            pushFollow(FOLLOW_15);
            rule__Reference__TimelinesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getTimelinesAssignment_2()); 

            }

            // InternalTextualScenario.g:2071:2: ( ( rule__Reference__TimelinesAssignment_2 )* )
            // InternalTextualScenario.g:2072:3: ( rule__Reference__TimelinesAssignment_2 )*
            {
             before(grammarAccess.getReferenceAccess().getTimelinesAssignment_2()); 
            // InternalTextualScenario.g:2073:3: ( rule__Reference__TimelinesAssignment_2 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_STRING) ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1==RULE_STRING) ) {
                        int LA15_3 = input.LA(3);

                        if ( (LA15_3==EOF||LA15_3==RULE_STRING||LA15_3==19||LA15_3==23||(LA15_3>=33 && LA15_3<=35)) ) {
                            alt15=1;
                        }


                    }


                }


                switch (alt15) {
            	case 1 :
            	    // InternalTextualScenario.g:2073:4: rule__Reference__TimelinesAssignment_2
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Reference__TimelinesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalTextualScenario.g:2082:1: rule__Reference__Group__3 : rule__Reference__Group__3__Impl ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2086:1: ( rule__Reference__Group__3__Impl )
            // InternalTextualScenario.g:2087:2: rule__Reference__Group__3__Impl
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
    // InternalTextualScenario.g:2093:1: rule__Reference__Group__3__Impl : ( ( rule__Reference__NameAssignment_3 ) ) ;
    public final void rule__Reference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2097:1: ( ( ( rule__Reference__NameAssignment_3 ) ) )
            // InternalTextualScenario.g:2098:1: ( ( rule__Reference__NameAssignment_3 ) )
            {
            // InternalTextualScenario.g:2098:1: ( ( rule__Reference__NameAssignment_3 ) )
            // InternalTextualScenario.g:2099:2: ( rule__Reference__NameAssignment_3 )
            {
             before(grammarAccess.getReferenceAccess().getNameAssignment_3()); 
            // InternalTextualScenario.g:2100:2: ( rule__Reference__NameAssignment_3 )
            // InternalTextualScenario.g:2100:3: rule__Reference__NameAssignment_3
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


    // $ANTLR start "rule__Alt__Group__0"
    // InternalTextualScenario.g:2109:1: rule__Alt__Group__0 : rule__Alt__Group__0__Impl rule__Alt__Group__1 ;
    public final void rule__Alt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2113:1: ( rule__Alt__Group__0__Impl rule__Alt__Group__1 )
            // InternalTextualScenario.g:2114:2: rule__Alt__Group__0__Impl rule__Alt__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Alt__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Alt__Group__1();

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
    // $ANTLR end "rule__Alt__Group__0"


    // $ANTLR start "rule__Alt__Group__0__Impl"
    // InternalTextualScenario.g:2121:1: rule__Alt__Group__0__Impl : ( ( rule__Alt__KeywordAssignment_0 ) ) ;
    public final void rule__Alt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2125:1: ( ( ( rule__Alt__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:2126:1: ( ( rule__Alt__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:2126:1: ( ( rule__Alt__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:2127:2: ( rule__Alt__KeywordAssignment_0 )
            {
             before(grammarAccess.getAltAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:2128:2: ( rule__Alt__KeywordAssignment_0 )
            // InternalTextualScenario.g:2128:3: rule__Alt__KeywordAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Alt__KeywordAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAltAccess().getKeywordAssignment_0()); 

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
    // $ANTLR end "rule__Alt__Group__0__Impl"


    // $ANTLR start "rule__Alt__Group__1"
    // InternalTextualScenario.g:2136:1: rule__Alt__Group__1 : rule__Alt__Group__1__Impl rule__Alt__Group__2 ;
    public final void rule__Alt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2140:1: ( rule__Alt__Group__1__Impl rule__Alt__Group__2 )
            // InternalTextualScenario.g:2141:2: rule__Alt__Group__1__Impl rule__Alt__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__Alt__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Alt__Group__2();

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
    // $ANTLR end "rule__Alt__Group__1"


    // $ANTLR start "rule__Alt__Group__1__Impl"
    // InternalTextualScenario.g:2148:1: rule__Alt__Group__1__Impl : ( ( rule__Alt__ConditionAssignment_1 ) ) ;
    public final void rule__Alt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2152:1: ( ( ( rule__Alt__ConditionAssignment_1 ) ) )
            // InternalTextualScenario.g:2153:1: ( ( rule__Alt__ConditionAssignment_1 ) )
            {
            // InternalTextualScenario.g:2153:1: ( ( rule__Alt__ConditionAssignment_1 ) )
            // InternalTextualScenario.g:2154:2: ( rule__Alt__ConditionAssignment_1 )
            {
             before(grammarAccess.getAltAccess().getConditionAssignment_1()); 
            // InternalTextualScenario.g:2155:2: ( rule__Alt__ConditionAssignment_1 )
            // InternalTextualScenario.g:2155:3: rule__Alt__ConditionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Alt__ConditionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAltAccess().getConditionAssignment_1()); 

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
    // $ANTLR end "rule__Alt__Group__1__Impl"


    // $ANTLR start "rule__Alt__Group__2"
    // InternalTextualScenario.g:2163:1: rule__Alt__Group__2 : rule__Alt__Group__2__Impl rule__Alt__Group__3 ;
    public final void rule__Alt__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2167:1: ( rule__Alt__Group__2__Impl rule__Alt__Group__3 )
            // InternalTextualScenario.g:2168:2: rule__Alt__Group__2__Impl rule__Alt__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Alt__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Alt__Group__3();

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
    // $ANTLR end "rule__Alt__Group__2"


    // $ANTLR start "rule__Alt__Group__2__Impl"
    // InternalTextualScenario.g:2175:1: rule__Alt__Group__2__Impl : ( 'over' ) ;
    public final void rule__Alt__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2179:1: ( ( 'over' ) )
            // InternalTextualScenario.g:2180:1: ( 'over' )
            {
            // InternalTextualScenario.g:2180:1: ( 'over' )
            // InternalTextualScenario.g:2181:2: 'over'
            {
             before(grammarAccess.getAltAccess().getOverKeyword_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getAltAccess().getOverKeyword_2()); 

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
    // $ANTLR end "rule__Alt__Group__2__Impl"


    // $ANTLR start "rule__Alt__Group__3"
    // InternalTextualScenario.g:2190:1: rule__Alt__Group__3 : rule__Alt__Group__3__Impl rule__Alt__Group__4 ;
    public final void rule__Alt__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2194:1: ( rule__Alt__Group__3__Impl rule__Alt__Group__4 )
            // InternalTextualScenario.g:2195:2: rule__Alt__Group__3__Impl rule__Alt__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__Alt__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Alt__Group__4();

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
    // $ANTLR end "rule__Alt__Group__3"


    // $ANTLR start "rule__Alt__Group__3__Impl"
    // InternalTextualScenario.g:2202:1: rule__Alt__Group__3__Impl : ( ( ( rule__Alt__TimelinesAssignment_3 ) ) ( ( rule__Alt__TimelinesAssignment_3 )* ) ) ;
    public final void rule__Alt__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2206:1: ( ( ( ( rule__Alt__TimelinesAssignment_3 ) ) ( ( rule__Alt__TimelinesAssignment_3 )* ) ) )
            // InternalTextualScenario.g:2207:1: ( ( ( rule__Alt__TimelinesAssignment_3 ) ) ( ( rule__Alt__TimelinesAssignment_3 )* ) )
            {
            // InternalTextualScenario.g:2207:1: ( ( ( rule__Alt__TimelinesAssignment_3 ) ) ( ( rule__Alt__TimelinesAssignment_3 )* ) )
            // InternalTextualScenario.g:2208:2: ( ( rule__Alt__TimelinesAssignment_3 ) ) ( ( rule__Alt__TimelinesAssignment_3 )* )
            {
            // InternalTextualScenario.g:2208:2: ( ( rule__Alt__TimelinesAssignment_3 ) )
            // InternalTextualScenario.g:2209:3: ( rule__Alt__TimelinesAssignment_3 )
            {
             before(grammarAccess.getAltAccess().getTimelinesAssignment_3()); 
            // InternalTextualScenario.g:2210:3: ( rule__Alt__TimelinesAssignment_3 )
            // InternalTextualScenario.g:2210:4: rule__Alt__TimelinesAssignment_3
            {
            pushFollow(FOLLOW_15);
            rule__Alt__TimelinesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAltAccess().getTimelinesAssignment_3()); 

            }

            // InternalTextualScenario.g:2213:2: ( ( rule__Alt__TimelinesAssignment_3 )* )
            // InternalTextualScenario.g:2214:3: ( rule__Alt__TimelinesAssignment_3 )*
            {
             before(grammarAccess.getAltAccess().getTimelinesAssignment_3()); 
            // InternalTextualScenario.g:2215:3: ( rule__Alt__TimelinesAssignment_3 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_STRING) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalTextualScenario.g:2215:4: rule__Alt__TimelinesAssignment_3
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Alt__TimelinesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getAltAccess().getTimelinesAssignment_3()); 

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
    // $ANTLR end "rule__Alt__Group__3__Impl"


    // $ANTLR start "rule__Alt__Group__4"
    // InternalTextualScenario.g:2224:1: rule__Alt__Group__4 : rule__Alt__Group__4__Impl rule__Alt__Group__5 ;
    public final void rule__Alt__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2228:1: ( rule__Alt__Group__4__Impl rule__Alt__Group__5 )
            // InternalTextualScenario.g:2229:2: rule__Alt__Group__4__Impl rule__Alt__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__Alt__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Alt__Group__5();

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
    // $ANTLR end "rule__Alt__Group__4"


    // $ANTLR start "rule__Alt__Group__4__Impl"
    // InternalTextualScenario.g:2236:1: rule__Alt__Group__4__Impl : ( ( rule__Alt__BlockAssignment_4 ) ) ;
    public final void rule__Alt__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2240:1: ( ( ( rule__Alt__BlockAssignment_4 ) ) )
            // InternalTextualScenario.g:2241:1: ( ( rule__Alt__BlockAssignment_4 ) )
            {
            // InternalTextualScenario.g:2241:1: ( ( rule__Alt__BlockAssignment_4 ) )
            // InternalTextualScenario.g:2242:2: ( rule__Alt__BlockAssignment_4 )
            {
             before(grammarAccess.getAltAccess().getBlockAssignment_4()); 
            // InternalTextualScenario.g:2243:2: ( rule__Alt__BlockAssignment_4 )
            // InternalTextualScenario.g:2243:3: rule__Alt__BlockAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Alt__BlockAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getAltAccess().getBlockAssignment_4()); 

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
    // $ANTLR end "rule__Alt__Group__4__Impl"


    // $ANTLR start "rule__Alt__Group__5"
    // InternalTextualScenario.g:2251:1: rule__Alt__Group__5 : rule__Alt__Group__5__Impl ;
    public final void rule__Alt__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2255:1: ( rule__Alt__Group__5__Impl )
            // InternalTextualScenario.g:2256:2: rule__Alt__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Alt__Group__5__Impl();

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
    // $ANTLR end "rule__Alt__Group__5"


    // $ANTLR start "rule__Alt__Group__5__Impl"
    // InternalTextualScenario.g:2262:1: rule__Alt__Group__5__Impl : ( ( rule__Alt__ElseBlocksAssignment_5 )* ) ;
    public final void rule__Alt__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2266:1: ( ( ( rule__Alt__ElseBlocksAssignment_5 )* ) )
            // InternalTextualScenario.g:2267:1: ( ( rule__Alt__ElseBlocksAssignment_5 )* )
            {
            // InternalTextualScenario.g:2267:1: ( ( rule__Alt__ElseBlocksAssignment_5 )* )
            // InternalTextualScenario.g:2268:2: ( rule__Alt__ElseBlocksAssignment_5 )*
            {
             before(grammarAccess.getAltAccess().getElseBlocksAssignment_5()); 
            // InternalTextualScenario.g:2269:2: ( rule__Alt__ElseBlocksAssignment_5 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==21) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalTextualScenario.g:2269:3: rule__Alt__ElseBlocksAssignment_5
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__Alt__ElseBlocksAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getAltAccess().getElseBlocksAssignment_5()); 

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
    // $ANTLR end "rule__Alt__Group__5__Impl"


    // $ANTLR start "rule__ElseBlock__Group__0"
    // InternalTextualScenario.g:2278:1: rule__ElseBlock__Group__0 : rule__ElseBlock__Group__0__Impl rule__ElseBlock__Group__1 ;
    public final void rule__ElseBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2282:1: ( rule__ElseBlock__Group__0__Impl rule__ElseBlock__Group__1 )
            // InternalTextualScenario.g:2283:2: rule__ElseBlock__Group__0__Impl rule__ElseBlock__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__ElseBlock__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ElseBlock__Group__1();

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
    // $ANTLR end "rule__ElseBlock__Group__0"


    // $ANTLR start "rule__ElseBlock__Group__0__Impl"
    // InternalTextualScenario.g:2290:1: rule__ElseBlock__Group__0__Impl : ( 'else' ) ;
    public final void rule__ElseBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2294:1: ( ( 'else' ) )
            // InternalTextualScenario.g:2295:1: ( 'else' )
            {
            // InternalTextualScenario.g:2295:1: ( 'else' )
            // InternalTextualScenario.g:2296:2: 'else'
            {
             before(grammarAccess.getElseBlockAccess().getElseKeyword_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getElseBlockAccess().getElseKeyword_0()); 

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
    // $ANTLR end "rule__ElseBlock__Group__0__Impl"


    // $ANTLR start "rule__ElseBlock__Group__1"
    // InternalTextualScenario.g:2305:1: rule__ElseBlock__Group__1 : rule__ElseBlock__Group__1__Impl rule__ElseBlock__Group__2 ;
    public final void rule__ElseBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2309:1: ( rule__ElseBlock__Group__1__Impl rule__ElseBlock__Group__2 )
            // InternalTextualScenario.g:2310:2: rule__ElseBlock__Group__1__Impl rule__ElseBlock__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__ElseBlock__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ElseBlock__Group__2();

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
    // $ANTLR end "rule__ElseBlock__Group__1"


    // $ANTLR start "rule__ElseBlock__Group__1__Impl"
    // InternalTextualScenario.g:2317:1: rule__ElseBlock__Group__1__Impl : ( ( rule__ElseBlock__ConditionAssignment_1 ) ) ;
    public final void rule__ElseBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2321:1: ( ( ( rule__ElseBlock__ConditionAssignment_1 ) ) )
            // InternalTextualScenario.g:2322:1: ( ( rule__ElseBlock__ConditionAssignment_1 ) )
            {
            // InternalTextualScenario.g:2322:1: ( ( rule__ElseBlock__ConditionAssignment_1 ) )
            // InternalTextualScenario.g:2323:2: ( rule__ElseBlock__ConditionAssignment_1 )
            {
             before(grammarAccess.getElseBlockAccess().getConditionAssignment_1()); 
            // InternalTextualScenario.g:2324:2: ( rule__ElseBlock__ConditionAssignment_1 )
            // InternalTextualScenario.g:2324:3: rule__ElseBlock__ConditionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ElseBlock__ConditionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getElseBlockAccess().getConditionAssignment_1()); 

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
    // $ANTLR end "rule__ElseBlock__Group__1__Impl"


    // $ANTLR start "rule__ElseBlock__Group__2"
    // InternalTextualScenario.g:2332:1: rule__ElseBlock__Group__2 : rule__ElseBlock__Group__2__Impl ;
    public final void rule__ElseBlock__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2336:1: ( rule__ElseBlock__Group__2__Impl )
            // InternalTextualScenario.g:2337:2: rule__ElseBlock__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ElseBlock__Group__2__Impl();

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
    // $ANTLR end "rule__ElseBlock__Group__2"


    // $ANTLR start "rule__ElseBlock__Group__2__Impl"
    // InternalTextualScenario.g:2343:1: rule__ElseBlock__Group__2__Impl : ( ( rule__ElseBlock__BlockAssignment_2 ) ) ;
    public final void rule__ElseBlock__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2347:1: ( ( ( rule__ElseBlock__BlockAssignment_2 ) ) )
            // InternalTextualScenario.g:2348:1: ( ( rule__ElseBlock__BlockAssignment_2 ) )
            {
            // InternalTextualScenario.g:2348:1: ( ( rule__ElseBlock__BlockAssignment_2 ) )
            // InternalTextualScenario.g:2349:2: ( rule__ElseBlock__BlockAssignment_2 )
            {
             before(grammarAccess.getElseBlockAccess().getBlockAssignment_2()); 
            // InternalTextualScenario.g:2350:2: ( rule__ElseBlock__BlockAssignment_2 )
            // InternalTextualScenario.g:2350:3: rule__ElseBlock__BlockAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ElseBlock__BlockAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getElseBlockAccess().getBlockAssignment_2()); 

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
    // $ANTLR end "rule__ElseBlock__Group__2__Impl"


    // $ANTLR start "rule__Block__Group__0"
    // InternalTextualScenario.g:2359:1: rule__Block__Group__0 : rule__Block__Group__0__Impl rule__Block__Group__1 ;
    public final void rule__Block__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2363:1: ( rule__Block__Group__0__Impl rule__Block__Group__1 )
            // InternalTextualScenario.g:2364:2: rule__Block__Group__0__Impl rule__Block__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalTextualScenario.g:2371:1: rule__Block__Group__0__Impl : ( ( rule__Block__BeginAssignment_0 ) ) ;
    public final void rule__Block__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2375:1: ( ( ( rule__Block__BeginAssignment_0 ) ) )
            // InternalTextualScenario.g:2376:1: ( ( rule__Block__BeginAssignment_0 ) )
            {
            // InternalTextualScenario.g:2376:1: ( ( rule__Block__BeginAssignment_0 ) )
            // InternalTextualScenario.g:2377:2: ( rule__Block__BeginAssignment_0 )
            {
             before(grammarAccess.getBlockAccess().getBeginAssignment_0()); 
            // InternalTextualScenario.g:2378:2: ( rule__Block__BeginAssignment_0 )
            // InternalTextualScenario.g:2378:3: rule__Block__BeginAssignment_0
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
    // InternalTextualScenario.g:2386:1: rule__Block__Group__1 : rule__Block__Group__1__Impl rule__Block__Group__2 ;
    public final void rule__Block__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2390:1: ( rule__Block__Group__1__Impl rule__Block__Group__2 )
            // InternalTextualScenario.g:2391:2: rule__Block__Group__1__Impl rule__Block__Group__2
            {
            pushFollow(FOLLOW_18);
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
    // InternalTextualScenario.g:2398:1: rule__Block__Group__1__Impl : ( ( rule__Block__Alternatives_1 )* ) ;
    public final void rule__Block__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2402:1: ( ( ( rule__Block__Alternatives_1 )* ) )
            // InternalTextualScenario.g:2403:1: ( ( rule__Block__Alternatives_1 )* )
            {
            // InternalTextualScenario.g:2403:1: ( ( rule__Block__Alternatives_1 )* )
            // InternalTextualScenario.g:2404:2: ( rule__Block__Alternatives_1 )*
            {
             before(grammarAccess.getBlockAccess().getAlternatives_1()); 
            // InternalTextualScenario.g:2405:2: ( rule__Block__Alternatives_1 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_STRING||LA18_0==19||(LA18_0>=33 && LA18_0<=35)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalTextualScenario.g:2405:3: rule__Block__Alternatives_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Block__Alternatives_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getBlockAccess().getAlternatives_1()); 

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
    // InternalTextualScenario.g:2413:1: rule__Block__Group__2 : rule__Block__Group__2__Impl ;
    public final void rule__Block__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2417:1: ( rule__Block__Group__2__Impl )
            // InternalTextualScenario.g:2418:2: rule__Block__Group__2__Impl
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
    // InternalTextualScenario.g:2424:1: rule__Block__Group__2__Impl : ( ( rule__Block__EndAssignment_2 ) ) ;
    public final void rule__Block__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2428:1: ( ( ( rule__Block__EndAssignment_2 ) ) )
            // InternalTextualScenario.g:2429:1: ( ( rule__Block__EndAssignment_2 ) )
            {
            // InternalTextualScenario.g:2429:1: ( ( rule__Block__EndAssignment_2 ) )
            // InternalTextualScenario.g:2430:2: ( rule__Block__EndAssignment_2 )
            {
             before(grammarAccess.getBlockAccess().getEndAssignment_2()); 
            // InternalTextualScenario.g:2431:2: ( rule__Block__EndAssignment_2 )
            // InternalTextualScenario.g:2431:3: rule__Block__EndAssignment_2
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


    // $ANTLR start "rule__Model__BeginAssignment_1"
    // InternalTextualScenario.g:2440:1: rule__Model__BeginAssignment_1 : ( ( '{' ) ) ;
    public final void rule__Model__BeginAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2444:1: ( ( ( '{' ) ) )
            // InternalTextualScenario.g:2445:2: ( ( '{' ) )
            {
            // InternalTextualScenario.g:2445:2: ( ( '{' ) )
            // InternalTextualScenario.g:2446:3: ( '{' )
            {
             before(grammarAccess.getModelAccess().getBeginLeftCurlyBracketKeyword_1_0()); 
            // InternalTextualScenario.g:2447:3: ( '{' )
            // InternalTextualScenario.g:2448:4: '{'
            {
             before(grammarAccess.getModelAccess().getBeginLeftCurlyBracketKeyword_1_0()); 
            match(input,22,FOLLOW_2); 
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
    // InternalTextualScenario.g:2459:1: rule__Model__ParticipantsAssignment_2 : ( ruleParticipant ) ;
    public final void rule__Model__ParticipantsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2463:1: ( ( ruleParticipant ) )
            // InternalTextualScenario.g:2464:2: ( ruleParticipant )
            {
            // InternalTextualScenario.g:2464:2: ( ruleParticipant )
            // InternalTextualScenario.g:2465:3: ruleParticipant
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


    // $ANTLR start "rule__Model__MessagesOrReferencesAssignment_3_0"
    // InternalTextualScenario.g:2474:1: rule__Model__MessagesOrReferencesAssignment_3_0 : ( ( rule__Model__MessagesOrReferencesAlternatives_3_0_0 ) ) ;
    public final void rule__Model__MessagesOrReferencesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2478:1: ( ( ( rule__Model__MessagesOrReferencesAlternatives_3_0_0 ) ) )
            // InternalTextualScenario.g:2479:2: ( ( rule__Model__MessagesOrReferencesAlternatives_3_0_0 ) )
            {
            // InternalTextualScenario.g:2479:2: ( ( rule__Model__MessagesOrReferencesAlternatives_3_0_0 ) )
            // InternalTextualScenario.g:2480:3: ( rule__Model__MessagesOrReferencesAlternatives_3_0_0 )
            {
             before(grammarAccess.getModelAccess().getMessagesOrReferencesAlternatives_3_0_0()); 
            // InternalTextualScenario.g:2481:3: ( rule__Model__MessagesOrReferencesAlternatives_3_0_0 )
            // InternalTextualScenario.g:2481:4: rule__Model__MessagesOrReferencesAlternatives_3_0_0
            {
            pushFollow(FOLLOW_2);
            rule__Model__MessagesOrReferencesAlternatives_3_0_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getMessagesOrReferencesAlternatives_3_0_0()); 

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
    // $ANTLR end "rule__Model__MessagesOrReferencesAssignment_3_0"


    // $ANTLR start "rule__Model__ConditionsAssignment_3_1"
    // InternalTextualScenario.g:2489:1: rule__Model__ConditionsAssignment_3_1 : ( ruleAlt ) ;
    public final void rule__Model__ConditionsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2493:1: ( ( ruleAlt ) )
            // InternalTextualScenario.g:2494:2: ( ruleAlt )
            {
            // InternalTextualScenario.g:2494:2: ( ruleAlt )
            // InternalTextualScenario.g:2495:3: ruleAlt
            {
             before(grammarAccess.getModelAccess().getConditionsAltParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAlt();

            state._fsp--;

             after(grammarAccess.getModelAccess().getConditionsAltParserRuleCall_3_1_0()); 

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
    // $ANTLR end "rule__Model__ConditionsAssignment_3_1"


    // $ANTLR start "rule__Model__EndAssignment_4"
    // InternalTextualScenario.g:2504:1: rule__Model__EndAssignment_4 : ( ( '}' ) ) ;
    public final void rule__Model__EndAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2508:1: ( ( ( '}' ) ) )
            // InternalTextualScenario.g:2509:2: ( ( '}' ) )
            {
            // InternalTextualScenario.g:2509:2: ( ( '}' ) )
            // InternalTextualScenario.g:2510:3: ( '}' )
            {
             before(grammarAccess.getModelAccess().getEndRightCurlyBracketKeyword_4_0()); 
            // InternalTextualScenario.g:2511:3: ( '}' )
            // InternalTextualScenario.g:2512:4: '}'
            {
             before(grammarAccess.getModelAccess().getEndRightCurlyBracketKeyword_4_0()); 
            match(input,23,FOLLOW_2); 
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
    // InternalTextualScenario.g:2523:1: rule__Actor__KeywordAssignment_0 : ( ( 'actor' ) ) ;
    public final void rule__Actor__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2527:1: ( ( ( 'actor' ) ) )
            // InternalTextualScenario.g:2528:2: ( ( 'actor' ) )
            {
            // InternalTextualScenario.g:2528:2: ( ( 'actor' ) )
            // InternalTextualScenario.g:2529:3: ( 'actor' )
            {
             before(grammarAccess.getActorAccess().getKeywordActorKeyword_0_0()); 
            // InternalTextualScenario.g:2530:3: ( 'actor' )
            // InternalTextualScenario.g:2531:4: 'actor'
            {
             before(grammarAccess.getActorAccess().getKeywordActorKeyword_0_0()); 
            match(input,24,FOLLOW_2); 
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
    // InternalTextualScenario.g:2542:1: rule__Actor__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Actor__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2546:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2547:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2547:2: ( RULE_STRING )
            // InternalTextualScenario.g:2548:3: RULE_STRING
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
    // InternalTextualScenario.g:2557:1: rule__Component__KeywordAssignment_0 : ( ( 'component' ) ) ;
    public final void rule__Component__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2561:1: ( ( ( 'component' ) ) )
            // InternalTextualScenario.g:2562:2: ( ( 'component' ) )
            {
            // InternalTextualScenario.g:2562:2: ( ( 'component' ) )
            // InternalTextualScenario.g:2563:3: ( 'component' )
            {
             before(grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0()); 
            // InternalTextualScenario.g:2564:3: ( 'component' )
            // InternalTextualScenario.g:2565:4: 'component'
            {
             before(grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0()); 
            match(input,25,FOLLOW_2); 
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
    // InternalTextualScenario.g:2576:1: rule__Component__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Component__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2580:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2581:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2581:2: ( RULE_STRING )
            // InternalTextualScenario.g:2582:3: RULE_STRING
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
    // InternalTextualScenario.g:2591:1: rule__Component__NatureAssignment_2 : ( ( rule__Component__NatureAlternatives_2_0 ) ) ;
    public final void rule__Component__NatureAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2595:1: ( ( ( rule__Component__NatureAlternatives_2_0 ) ) )
            // InternalTextualScenario.g:2596:2: ( ( rule__Component__NatureAlternatives_2_0 ) )
            {
            // InternalTextualScenario.g:2596:2: ( ( rule__Component__NatureAlternatives_2_0 ) )
            // InternalTextualScenario.g:2597:3: ( rule__Component__NatureAlternatives_2_0 )
            {
             before(grammarAccess.getComponentAccess().getNatureAlternatives_2_0()); 
            // InternalTextualScenario.g:2598:3: ( rule__Component__NatureAlternatives_2_0 )
            // InternalTextualScenario.g:2598:4: rule__Component__NatureAlternatives_2_0
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
    // InternalTextualScenario.g:2606:1: rule__ConfigurationItem__KeywordAssignment_0 : ( ( 'configuration_item' ) ) ;
    public final void rule__ConfigurationItem__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2610:1: ( ( ( 'configuration_item' ) ) )
            // InternalTextualScenario.g:2611:2: ( ( 'configuration_item' ) )
            {
            // InternalTextualScenario.g:2611:2: ( ( 'configuration_item' ) )
            // InternalTextualScenario.g:2612:3: ( 'configuration_item' )
            {
             before(grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0()); 
            // InternalTextualScenario.g:2613:3: ( 'configuration_item' )
            // InternalTextualScenario.g:2614:4: 'configuration_item'
            {
             before(grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalTextualScenario.g:2625:1: rule__ConfigurationItem__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ConfigurationItem__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2629:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2630:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2630:2: ( RULE_STRING )
            // InternalTextualScenario.g:2631:3: RULE_STRING
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
    // InternalTextualScenario.g:2640:1: rule__Function__KeywordAssignment_0 : ( ( 'function' ) ) ;
    public final void rule__Function__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2644:1: ( ( ( 'function' ) ) )
            // InternalTextualScenario.g:2645:2: ( ( 'function' ) )
            {
            // InternalTextualScenario.g:2645:2: ( ( 'function' ) )
            // InternalTextualScenario.g:2646:3: ( 'function' )
            {
             before(grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0()); 
            // InternalTextualScenario.g:2647:3: ( 'function' )
            // InternalTextualScenario.g:2648:4: 'function'
            {
             before(grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0()); 
            match(input,27,FOLLOW_2); 
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
    // InternalTextualScenario.g:2659:1: rule__Function__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Function__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2663:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2664:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2664:2: ( RULE_STRING )
            // InternalTextualScenario.g:2665:3: RULE_STRING
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
    // InternalTextualScenario.g:2674:1: rule__Activity__KeywordAssignment_0 : ( ( 'activity' ) ) ;
    public final void rule__Activity__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2678:1: ( ( ( 'activity' ) ) )
            // InternalTextualScenario.g:2679:2: ( ( 'activity' ) )
            {
            // InternalTextualScenario.g:2679:2: ( ( 'activity' ) )
            // InternalTextualScenario.g:2680:3: ( 'activity' )
            {
             before(grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0()); 
            // InternalTextualScenario.g:2681:3: ( 'activity' )
            // InternalTextualScenario.g:2682:4: 'activity'
            {
             before(grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalTextualScenario.g:2693:1: rule__Activity__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Activity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2697:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2698:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2698:2: ( RULE_STRING )
            // InternalTextualScenario.g:2699:3: RULE_STRING
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
    // InternalTextualScenario.g:2708:1: rule__Entity__KeywordAssignment_0 : ( ( 'entity' ) ) ;
    public final void rule__Entity__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2712:1: ( ( ( 'entity' ) ) )
            // InternalTextualScenario.g:2713:2: ( ( 'entity' ) )
            {
            // InternalTextualScenario.g:2713:2: ( ( 'entity' ) )
            // InternalTextualScenario.g:2714:3: ( 'entity' )
            {
             before(grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0()); 
            // InternalTextualScenario.g:2715:3: ( 'entity' )
            // InternalTextualScenario.g:2716:4: 'entity'
            {
             before(grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0()); 
            match(input,29,FOLLOW_2); 
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
    // InternalTextualScenario.g:2727:1: rule__Entity__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Entity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2731:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2732:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2732:2: ( RULE_STRING )
            // InternalTextualScenario.g:2733:3: RULE_STRING
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
    // InternalTextualScenario.g:2742:1: rule__Role__KeywordAssignment_0 : ( ( 'role' ) ) ;
    public final void rule__Role__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2746:1: ( ( ( 'role' ) ) )
            // InternalTextualScenario.g:2747:2: ( ( 'role' ) )
            {
            // InternalTextualScenario.g:2747:2: ( ( 'role' ) )
            // InternalTextualScenario.g:2748:3: ( 'role' )
            {
             before(grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0()); 
            // InternalTextualScenario.g:2749:3: ( 'role' )
            // InternalTextualScenario.g:2750:4: 'role'
            {
             before(grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTextualScenario.g:2761:1: rule__Role__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Role__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2765:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2766:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2766:2: ( RULE_STRING )
            // InternalTextualScenario.g:2767:3: RULE_STRING
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
    // InternalTextualScenario.g:2776:1: rule__SequenceMessage__SourceAssignment_0 : ( RULE_STRING ) ;
    public final void rule__SequenceMessage__SourceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2780:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2781:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2781:2: ( RULE_STRING )
            // InternalTextualScenario.g:2782:3: RULE_STRING
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


    // $ANTLR start "rule__SequenceMessage__TargetAssignment_2"
    // InternalTextualScenario.g:2791:1: rule__SequenceMessage__TargetAssignment_2 : ( RULE_STRING ) ;
    public final void rule__SequenceMessage__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2795:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2796:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2796:2: ( RULE_STRING )
            // InternalTextualScenario.g:2797:3: RULE_STRING
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
    // InternalTextualScenario.g:2806:1: rule__SequenceMessage__ExecutionAssignment_3 : ( ( 'withExecution' ) ) ;
    public final void rule__SequenceMessage__ExecutionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2810:1: ( ( ( 'withExecution' ) ) )
            // InternalTextualScenario.g:2811:2: ( ( 'withExecution' ) )
            {
            // InternalTextualScenario.g:2811:2: ( ( 'withExecution' ) )
            // InternalTextualScenario.g:2812:3: ( 'withExecution' )
            {
             before(grammarAccess.getSequenceMessageAccess().getExecutionWithExecutionKeyword_3_0()); 
            // InternalTextualScenario.g:2813:3: ( 'withExecution' )
            // InternalTextualScenario.g:2814:4: 'withExecution'
            {
             before(grammarAccess.getSequenceMessageAccess().getExecutionWithExecutionKeyword_3_0()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTextualScenario.g:2825:1: rule__SequenceMessage__ReturnAssignment_4 : ( ( 'withReturn' ) ) ;
    public final void rule__SequenceMessage__ReturnAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2829:1: ( ( ( 'withReturn' ) ) )
            // InternalTextualScenario.g:2830:2: ( ( 'withReturn' ) )
            {
            // InternalTextualScenario.g:2830:2: ( ( 'withReturn' ) )
            // InternalTextualScenario.g:2831:3: ( 'withReturn' )
            {
             before(grammarAccess.getSequenceMessageAccess().getReturnWithReturnKeyword_4_0()); 
            // InternalTextualScenario.g:2832:3: ( 'withReturn' )
            // InternalTextualScenario.g:2833:4: 'withReturn'
            {
             before(grammarAccess.getSequenceMessageAccess().getReturnWithReturnKeyword_4_0()); 
            match(input,32,FOLLOW_2); 
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


    // $ANTLR start "rule__SequenceMessage__NameAssignment_6"
    // InternalTextualScenario.g:2844:1: rule__SequenceMessage__NameAssignment_6 : ( RULE_STRING ) ;
    public final void rule__SequenceMessage__NameAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2848:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2849:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2849:2: ( RULE_STRING )
            // InternalTextualScenario.g:2850:3: RULE_STRING
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
    // InternalTextualScenario.g:2859:1: rule__CreateMessage__SourceAssignment_0 : ( RULE_STRING ) ;
    public final void rule__CreateMessage__SourceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2863:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2864:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2864:2: ( RULE_STRING )
            // InternalTextualScenario.g:2865:3: RULE_STRING
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


    // $ANTLR start "rule__CreateMessage__TargetAssignment_2"
    // InternalTextualScenario.g:2874:1: rule__CreateMessage__TargetAssignment_2 : ( RULE_STRING ) ;
    public final void rule__CreateMessage__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2878:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2879:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2879:2: ( RULE_STRING )
            // InternalTextualScenario.g:2880:3: RULE_STRING
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


    // $ANTLR start "rule__CreateMessage__NameAssignment_4"
    // InternalTextualScenario.g:2889:1: rule__CreateMessage__NameAssignment_4 : ( RULE_STRING ) ;
    public final void rule__CreateMessage__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2893:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2894:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2894:2: ( RULE_STRING )
            // InternalTextualScenario.g:2895:3: RULE_STRING
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
    // InternalTextualScenario.g:2904:1: rule__DeleteMessage__SourceAssignment_0 : ( RULE_STRING ) ;
    public final void rule__DeleteMessage__SourceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2908:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2909:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2909:2: ( RULE_STRING )
            // InternalTextualScenario.g:2910:3: RULE_STRING
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


    // $ANTLR start "rule__DeleteMessage__TargetAssignment_2"
    // InternalTextualScenario.g:2919:1: rule__DeleteMessage__TargetAssignment_2 : ( RULE_STRING ) ;
    public final void rule__DeleteMessage__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2923:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2924:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2924:2: ( RULE_STRING )
            // InternalTextualScenario.g:2925:3: RULE_STRING
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


    // $ANTLR start "rule__DeleteMessage__NameAssignment_4"
    // InternalTextualScenario.g:2934:1: rule__DeleteMessage__NameAssignment_4 : ( RULE_STRING ) ;
    public final void rule__DeleteMessage__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2938:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2939:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2939:2: ( RULE_STRING )
            // InternalTextualScenario.g:2940:3: RULE_STRING
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


    // $ANTLR start "rule__ArmTimerMessage__ParticipantAssignment_1"
    // InternalTextualScenario.g:2949:1: rule__ArmTimerMessage__ParticipantAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ArmTimerMessage__ParticipantAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2953:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2954:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2954:2: ( RULE_STRING )
            // InternalTextualScenario.g:2955:3: RULE_STRING
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


    // $ANTLR start "rule__ArmTimerMessage__NameAssignment_3"
    // InternalTextualScenario.g:2964:1: rule__ArmTimerMessage__NameAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ArmTimerMessage__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2968:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2969:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2969:2: ( RULE_STRING )
            // InternalTextualScenario.g:2970:3: RULE_STRING
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
    // InternalTextualScenario.g:2979:1: rule__ParticipantDeactivation__KeywordAssignment_0 : ( ( 'deactivate' ) ) ;
    public final void rule__ParticipantDeactivation__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2983:1: ( ( ( 'deactivate' ) ) )
            // InternalTextualScenario.g:2984:2: ( ( 'deactivate' ) )
            {
            // InternalTextualScenario.g:2984:2: ( ( 'deactivate' ) )
            // InternalTextualScenario.g:2985:3: ( 'deactivate' )
            {
             before(grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0()); 
            // InternalTextualScenario.g:2986:3: ( 'deactivate' )
            // InternalTextualScenario.g:2987:4: 'deactivate'
            {
             before(grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0()); 
            match(input,33,FOLLOW_2); 
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
    // InternalTextualScenario.g:2998:1: rule__ParticipantDeactivation__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ParticipantDeactivation__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3002:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3003:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3003:2: ( RULE_STRING )
            // InternalTextualScenario.g:3004:3: RULE_STRING
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
    // InternalTextualScenario.g:3013:1: rule__Reference__KeywordAssignment_0 : ( ( 'ref' ) ) ;
    public final void rule__Reference__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3017:1: ( ( ( 'ref' ) ) )
            // InternalTextualScenario.g:3018:2: ( ( 'ref' ) )
            {
            // InternalTextualScenario.g:3018:2: ( ( 'ref' ) )
            // InternalTextualScenario.g:3019:3: ( 'ref' )
            {
             before(grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0()); 
            // InternalTextualScenario.g:3020:3: ( 'ref' )
            // InternalTextualScenario.g:3021:4: 'ref'
            {
             before(grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0()); 
            match(input,34,FOLLOW_2); 
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


    // $ANTLR start "rule__Reference__TimelinesAssignment_2"
    // InternalTextualScenario.g:3032:1: rule__Reference__TimelinesAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Reference__TimelinesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3036:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3037:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3037:2: ( RULE_STRING )
            // InternalTextualScenario.g:3038:3: RULE_STRING
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
    // InternalTextualScenario.g:3047:1: rule__Reference__NameAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Reference__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3051:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3052:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3052:2: ( RULE_STRING )
            // InternalTextualScenario.g:3053:3: RULE_STRING
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


    // $ANTLR start "rule__Alt__KeywordAssignment_0"
    // InternalTextualScenario.g:3062:1: rule__Alt__KeywordAssignment_0 : ( ( 'alt' ) ) ;
    public final void rule__Alt__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3066:1: ( ( ( 'alt' ) ) )
            // InternalTextualScenario.g:3067:2: ( ( 'alt' ) )
            {
            // InternalTextualScenario.g:3067:2: ( ( 'alt' ) )
            // InternalTextualScenario.g:3068:3: ( 'alt' )
            {
             before(grammarAccess.getAltAccess().getKeywordAltKeyword_0_0()); 
            // InternalTextualScenario.g:3069:3: ( 'alt' )
            // InternalTextualScenario.g:3070:4: 'alt'
            {
             before(grammarAccess.getAltAccess().getKeywordAltKeyword_0_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getAltAccess().getKeywordAltKeyword_0_0()); 

            }

             after(grammarAccess.getAltAccess().getKeywordAltKeyword_0_0()); 

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
    // $ANTLR end "rule__Alt__KeywordAssignment_0"


    // $ANTLR start "rule__Alt__ConditionAssignment_1"
    // InternalTextualScenario.g:3081:1: rule__Alt__ConditionAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Alt__ConditionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3085:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3086:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3086:2: ( RULE_STRING )
            // InternalTextualScenario.g:3087:3: RULE_STRING
            {
             before(grammarAccess.getAltAccess().getConditionSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getAltAccess().getConditionSTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Alt__ConditionAssignment_1"


    // $ANTLR start "rule__Alt__TimelinesAssignment_3"
    // InternalTextualScenario.g:3096:1: rule__Alt__TimelinesAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Alt__TimelinesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3100:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3101:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3101:2: ( RULE_STRING )
            // InternalTextualScenario.g:3102:3: RULE_STRING
            {
             before(grammarAccess.getAltAccess().getTimelinesSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getAltAccess().getTimelinesSTRINGTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__Alt__TimelinesAssignment_3"


    // $ANTLR start "rule__Alt__BlockAssignment_4"
    // InternalTextualScenario.g:3111:1: rule__Alt__BlockAssignment_4 : ( ruleBlock ) ;
    public final void rule__Alt__BlockAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3115:1: ( ( ruleBlock ) )
            // InternalTextualScenario.g:3116:2: ( ruleBlock )
            {
            // InternalTextualScenario.g:3116:2: ( ruleBlock )
            // InternalTextualScenario.g:3117:3: ruleBlock
            {
             before(grammarAccess.getAltAccess().getBlockBlockParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getAltAccess().getBlockBlockParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__Alt__BlockAssignment_4"


    // $ANTLR start "rule__Alt__ElseBlocksAssignment_5"
    // InternalTextualScenario.g:3126:1: rule__Alt__ElseBlocksAssignment_5 : ( ruleElseBlock ) ;
    public final void rule__Alt__ElseBlocksAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3130:1: ( ( ruleElseBlock ) )
            // InternalTextualScenario.g:3131:2: ( ruleElseBlock )
            {
            // InternalTextualScenario.g:3131:2: ( ruleElseBlock )
            // InternalTextualScenario.g:3132:3: ruleElseBlock
            {
             before(grammarAccess.getAltAccess().getElseBlocksElseBlockParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleElseBlock();

            state._fsp--;

             after(grammarAccess.getAltAccess().getElseBlocksElseBlockParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__Alt__ElseBlocksAssignment_5"


    // $ANTLR start "rule__ElseBlock__ConditionAssignment_1"
    // InternalTextualScenario.g:3141:1: rule__ElseBlock__ConditionAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ElseBlock__ConditionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3145:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3146:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3146:2: ( RULE_STRING )
            // InternalTextualScenario.g:3147:3: RULE_STRING
            {
             before(grammarAccess.getElseBlockAccess().getConditionSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getElseBlockAccess().getConditionSTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__ElseBlock__ConditionAssignment_1"


    // $ANTLR start "rule__ElseBlock__BlockAssignment_2"
    // InternalTextualScenario.g:3156:1: rule__ElseBlock__BlockAssignment_2 : ( ruleBlock ) ;
    public final void rule__ElseBlock__BlockAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3160:1: ( ( ruleBlock ) )
            // InternalTextualScenario.g:3161:2: ( ruleBlock )
            {
            // InternalTextualScenario.g:3161:2: ( ruleBlock )
            // InternalTextualScenario.g:3162:3: ruleBlock
            {
             before(grammarAccess.getElseBlockAccess().getBlockBlockParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getElseBlockAccess().getBlockBlockParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__ElseBlock__BlockAssignment_2"


    // $ANTLR start "rule__Block__BeginAssignment_0"
    // InternalTextualScenario.g:3171:1: rule__Block__BeginAssignment_0 : ( ( '{' ) ) ;
    public final void rule__Block__BeginAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3175:1: ( ( ( '{' ) ) )
            // InternalTextualScenario.g:3176:2: ( ( '{' ) )
            {
            // InternalTextualScenario.g:3176:2: ( ( '{' ) )
            // InternalTextualScenario.g:3177:3: ( '{' )
            {
             before(grammarAccess.getBlockAccess().getBeginLeftCurlyBracketKeyword_0_0()); 
            // InternalTextualScenario.g:3178:3: ( '{' )
            // InternalTextualScenario.g:3179:4: '{'
            {
             before(grammarAccess.getBlockAccess().getBeginLeftCurlyBracketKeyword_0_0()); 
            match(input,22,FOLLOW_2); 
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


    // $ANTLR start "rule__Block__MessagesAssignment_1_0"
    // InternalTextualScenario.g:3190:1: rule__Block__MessagesAssignment_1_0 : ( ruleMessage ) ;
    public final void rule__Block__MessagesAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3194:1: ( ( ruleMessage ) )
            // InternalTextualScenario.g:3195:2: ( ruleMessage )
            {
            // InternalTextualScenario.g:3195:2: ( ruleMessage )
            // InternalTextualScenario.g:3196:3: ruleMessage
            {
             before(grammarAccess.getBlockAccess().getMessagesMessageParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMessage();

            state._fsp--;

             after(grammarAccess.getBlockAccess().getMessagesMessageParserRuleCall_1_0_0()); 

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
    // $ANTLR end "rule__Block__MessagesAssignment_1_0"


    // $ANTLR start "rule__Block__ReferencesAssignment_1_1"
    // InternalTextualScenario.g:3205:1: rule__Block__ReferencesAssignment_1_1 : ( ruleReference ) ;
    public final void rule__Block__ReferencesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3209:1: ( ( ruleReference ) )
            // InternalTextualScenario.g:3210:2: ( ruleReference )
            {
            // InternalTextualScenario.g:3210:2: ( ruleReference )
            // InternalTextualScenario.g:3211:3: ruleReference
            {
             before(grammarAccess.getBlockAccess().getReferencesReferenceParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getBlockAccess().getReferencesReferenceParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__Block__ReferencesAssignment_1_1"


    // $ANTLR start "rule__Block__ConditionsAssignment_1_2"
    // InternalTextualScenario.g:3220:1: rule__Block__ConditionsAssignment_1_2 : ( ruleAlt ) ;
    public final void rule__Block__ConditionsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3224:1: ( ( ruleAlt ) )
            // InternalTextualScenario.g:3225:2: ( ruleAlt )
            {
            // InternalTextualScenario.g:3225:2: ( ruleAlt )
            // InternalTextualScenario.g:3226:3: ruleAlt
            {
             before(grammarAccess.getBlockAccess().getConditionsAltParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAlt();

            state._fsp--;

             after(grammarAccess.getBlockAccess().getConditionsAltParserRuleCall_1_2_0()); 

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
    // $ANTLR end "rule__Block__ConditionsAssignment_1_2"


    // $ANTLR start "rule__Block__EndAssignment_2"
    // InternalTextualScenario.g:3235:1: rule__Block__EndAssignment_2 : ( ( '}' ) ) ;
    public final void rule__Block__EndAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3239:1: ( ( ( '}' ) ) )
            // InternalTextualScenario.g:3240:2: ( ( '}' ) )
            {
            // InternalTextualScenario.g:3240:2: ( ( '}' ) )
            // InternalTextualScenario.g:3241:3: ( '}' )
            {
             before(grammarAccess.getBlockAccess().getEndRightCurlyBracketKeyword_2_0()); 
            // InternalTextualScenario.g:3242:3: ( '}' )
            // InternalTextualScenario.g:3243:4: '}'
            {
             before(grammarAccess.getBlockAccess().getEndRightCurlyBracketKeyword_2_0()); 
            match(input,23,FOLLOW_2); 
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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000E7F880010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000007F000002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000E00080012L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000180010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000E00880010L});

}
