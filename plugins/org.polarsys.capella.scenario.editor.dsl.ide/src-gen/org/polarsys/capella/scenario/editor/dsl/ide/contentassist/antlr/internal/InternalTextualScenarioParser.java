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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'alt'", "'loop'", "'par'", "'assert'", "'critical'", "'ignore'", "'neg'", "'opt'", "'seq'", "'strict'", "'unset'", "'state'", "'mode'", "'function'", "'scenario'", "'{'", "'}'", "'actor'", "'component'", "'configuration_item'", "'activity'", "'entity'", "'role'", "'->'", "'withExecution'", "'withReturn'", "':'", "'->+'", "'->x'", "'->>'", "'->o'", "'o->'", "'deactivate'", "'over'", "'else'", "'on'", "'ref'"
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


    // $ANTLR start "entryRuleElement"
    // InternalTextualScenario.g:153:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalTextualScenario.g:154:1: ( ruleElement EOF )
            // InternalTextualScenario.g:155:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalTextualScenario.g:162:1: ruleElement : ( ( rule__Element__Alternatives ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:166:2: ( ( ( rule__Element__Alternatives ) ) )
            // InternalTextualScenario.g:167:2: ( ( rule__Element__Alternatives ) )
            {
            // InternalTextualScenario.g:167:2: ( ( rule__Element__Alternatives ) )
            // InternalTextualScenario.g:168:3: ( rule__Element__Alternatives )
            {
             before(grammarAccess.getElementAccess().getAlternatives()); 
            // InternalTextualScenario.g:169:3: ( rule__Element__Alternatives )
            // InternalTextualScenario.g:169:4: rule__Element__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Element__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleActor"
    // InternalTextualScenario.g:178:1: entryRuleActor : ruleActor EOF ;
    public final void entryRuleActor() throws RecognitionException {
        try {
            // InternalTextualScenario.g:179:1: ( ruleActor EOF )
            // InternalTextualScenario.g:180:1: ruleActor EOF
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
    // InternalTextualScenario.g:187:1: ruleActor : ( ( rule__Actor__Group__0 ) ) ;
    public final void ruleActor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:191:2: ( ( ( rule__Actor__Group__0 ) ) )
            // InternalTextualScenario.g:192:2: ( ( rule__Actor__Group__0 ) )
            {
            // InternalTextualScenario.g:192:2: ( ( rule__Actor__Group__0 ) )
            // InternalTextualScenario.g:193:3: ( rule__Actor__Group__0 )
            {
             before(grammarAccess.getActorAccess().getGroup()); 
            // InternalTextualScenario.g:194:3: ( rule__Actor__Group__0 )
            // InternalTextualScenario.g:194:4: rule__Actor__Group__0
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
    // InternalTextualScenario.g:203:1: entryRuleComponent : ruleComponent EOF ;
    public final void entryRuleComponent() throws RecognitionException {
        try {
            // InternalTextualScenario.g:204:1: ( ruleComponent EOF )
            // InternalTextualScenario.g:205:1: ruleComponent EOF
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
    // InternalTextualScenario.g:212:1: ruleComponent : ( ( rule__Component__Group__0 ) ) ;
    public final void ruleComponent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:216:2: ( ( ( rule__Component__Group__0 ) ) )
            // InternalTextualScenario.g:217:2: ( ( rule__Component__Group__0 ) )
            {
            // InternalTextualScenario.g:217:2: ( ( rule__Component__Group__0 ) )
            // InternalTextualScenario.g:218:3: ( rule__Component__Group__0 )
            {
             before(grammarAccess.getComponentAccess().getGroup()); 
            // InternalTextualScenario.g:219:3: ( rule__Component__Group__0 )
            // InternalTextualScenario.g:219:4: rule__Component__Group__0
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
    // InternalTextualScenario.g:228:1: entryRuleConfigurationItem : ruleConfigurationItem EOF ;
    public final void entryRuleConfigurationItem() throws RecognitionException {
        try {
            // InternalTextualScenario.g:229:1: ( ruleConfigurationItem EOF )
            // InternalTextualScenario.g:230:1: ruleConfigurationItem EOF
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
    // InternalTextualScenario.g:237:1: ruleConfigurationItem : ( ( rule__ConfigurationItem__Group__0 ) ) ;
    public final void ruleConfigurationItem() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:241:2: ( ( ( rule__ConfigurationItem__Group__0 ) ) )
            // InternalTextualScenario.g:242:2: ( ( rule__ConfigurationItem__Group__0 ) )
            {
            // InternalTextualScenario.g:242:2: ( ( rule__ConfigurationItem__Group__0 ) )
            // InternalTextualScenario.g:243:3: ( rule__ConfigurationItem__Group__0 )
            {
             before(grammarAccess.getConfigurationItemAccess().getGroup()); 
            // InternalTextualScenario.g:244:3: ( rule__ConfigurationItem__Group__0 )
            // InternalTextualScenario.g:244:4: rule__ConfigurationItem__Group__0
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
    // InternalTextualScenario.g:253:1: entryRuleFunction : ruleFunction EOF ;
    public final void entryRuleFunction() throws RecognitionException {
        try {
            // InternalTextualScenario.g:254:1: ( ruleFunction EOF )
            // InternalTextualScenario.g:255:1: ruleFunction EOF
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
    // InternalTextualScenario.g:262:1: ruleFunction : ( ( rule__Function__Group__0 ) ) ;
    public final void ruleFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:266:2: ( ( ( rule__Function__Group__0 ) ) )
            // InternalTextualScenario.g:267:2: ( ( rule__Function__Group__0 ) )
            {
            // InternalTextualScenario.g:267:2: ( ( rule__Function__Group__0 ) )
            // InternalTextualScenario.g:268:3: ( rule__Function__Group__0 )
            {
             before(grammarAccess.getFunctionAccess().getGroup()); 
            // InternalTextualScenario.g:269:3: ( rule__Function__Group__0 )
            // InternalTextualScenario.g:269:4: rule__Function__Group__0
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
    // InternalTextualScenario.g:278:1: entryRuleActivity : ruleActivity EOF ;
    public final void entryRuleActivity() throws RecognitionException {
        try {
            // InternalTextualScenario.g:279:1: ( ruleActivity EOF )
            // InternalTextualScenario.g:280:1: ruleActivity EOF
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
    // InternalTextualScenario.g:287:1: ruleActivity : ( ( rule__Activity__Group__0 ) ) ;
    public final void ruleActivity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:291:2: ( ( ( rule__Activity__Group__0 ) ) )
            // InternalTextualScenario.g:292:2: ( ( rule__Activity__Group__0 ) )
            {
            // InternalTextualScenario.g:292:2: ( ( rule__Activity__Group__0 ) )
            // InternalTextualScenario.g:293:3: ( rule__Activity__Group__0 )
            {
             before(grammarAccess.getActivityAccess().getGroup()); 
            // InternalTextualScenario.g:294:3: ( rule__Activity__Group__0 )
            // InternalTextualScenario.g:294:4: rule__Activity__Group__0
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
    // InternalTextualScenario.g:303:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // InternalTextualScenario.g:304:1: ( ruleEntity EOF )
            // InternalTextualScenario.g:305:1: ruleEntity EOF
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
    // InternalTextualScenario.g:312:1: ruleEntity : ( ( rule__Entity__Group__0 ) ) ;
    public final void ruleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:316:2: ( ( ( rule__Entity__Group__0 ) ) )
            // InternalTextualScenario.g:317:2: ( ( rule__Entity__Group__0 ) )
            {
            // InternalTextualScenario.g:317:2: ( ( rule__Entity__Group__0 ) )
            // InternalTextualScenario.g:318:3: ( rule__Entity__Group__0 )
            {
             before(grammarAccess.getEntityAccess().getGroup()); 
            // InternalTextualScenario.g:319:3: ( rule__Entity__Group__0 )
            // InternalTextualScenario.g:319:4: rule__Entity__Group__0
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
    // InternalTextualScenario.g:328:1: entryRuleRole : ruleRole EOF ;
    public final void entryRuleRole() throws RecognitionException {
        try {
            // InternalTextualScenario.g:329:1: ( ruleRole EOF )
            // InternalTextualScenario.g:330:1: ruleRole EOF
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
    // InternalTextualScenario.g:337:1: ruleRole : ( ( rule__Role__Group__0 ) ) ;
    public final void ruleRole() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:341:2: ( ( ( rule__Role__Group__0 ) ) )
            // InternalTextualScenario.g:342:2: ( ( rule__Role__Group__0 ) )
            {
            // InternalTextualScenario.g:342:2: ( ( rule__Role__Group__0 ) )
            // InternalTextualScenario.g:343:3: ( rule__Role__Group__0 )
            {
             before(grammarAccess.getRoleAccess().getGroup()); 
            // InternalTextualScenario.g:344:3: ( rule__Role__Group__0 )
            // InternalTextualScenario.g:344:4: rule__Role__Group__0
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
    // InternalTextualScenario.g:353:1: entryRuleMessage : ruleMessage EOF ;
    public final void entryRuleMessage() throws RecognitionException {
        try {
            // InternalTextualScenario.g:354:1: ( ruleMessage EOF )
            // InternalTextualScenario.g:355:1: ruleMessage EOF
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
    // InternalTextualScenario.g:362:1: ruleMessage : ( ( rule__Message__Alternatives ) ) ;
    public final void ruleMessage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:366:2: ( ( ( rule__Message__Alternatives ) ) )
            // InternalTextualScenario.g:367:2: ( ( rule__Message__Alternatives ) )
            {
            // InternalTextualScenario.g:367:2: ( ( rule__Message__Alternatives ) )
            // InternalTextualScenario.g:368:3: ( rule__Message__Alternatives )
            {
             before(grammarAccess.getMessageAccess().getAlternatives()); 
            // InternalTextualScenario.g:369:3: ( rule__Message__Alternatives )
            // InternalTextualScenario.g:369:4: rule__Message__Alternatives
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
    // InternalTextualScenario.g:378:1: entryRuleSequenceMessageType : ruleSequenceMessageType EOF ;
    public final void entryRuleSequenceMessageType() throws RecognitionException {
        try {
            // InternalTextualScenario.g:379:1: ( ruleSequenceMessageType EOF )
            // InternalTextualScenario.g:380:1: ruleSequenceMessageType EOF
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
    // InternalTextualScenario.g:387:1: ruleSequenceMessageType : ( ( rule__SequenceMessageType__Alternatives ) ) ;
    public final void ruleSequenceMessageType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:391:2: ( ( ( rule__SequenceMessageType__Alternatives ) ) )
            // InternalTextualScenario.g:392:2: ( ( rule__SequenceMessageType__Alternatives ) )
            {
            // InternalTextualScenario.g:392:2: ( ( rule__SequenceMessageType__Alternatives ) )
            // InternalTextualScenario.g:393:3: ( rule__SequenceMessageType__Alternatives )
            {
             before(grammarAccess.getSequenceMessageTypeAccess().getAlternatives()); 
            // InternalTextualScenario.g:394:3: ( rule__SequenceMessageType__Alternatives )
            // InternalTextualScenario.g:394:4: rule__SequenceMessageType__Alternatives
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
    // InternalTextualScenario.g:403:1: entryRuleSequenceMessage : ruleSequenceMessage EOF ;
    public final void entryRuleSequenceMessage() throws RecognitionException {
        try {
            // InternalTextualScenario.g:404:1: ( ruleSequenceMessage EOF )
            // InternalTextualScenario.g:405:1: ruleSequenceMessage EOF
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
    // InternalTextualScenario.g:412:1: ruleSequenceMessage : ( ( rule__SequenceMessage__Group__0 ) ) ;
    public final void ruleSequenceMessage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:416:2: ( ( ( rule__SequenceMessage__Group__0 ) ) )
            // InternalTextualScenario.g:417:2: ( ( rule__SequenceMessage__Group__0 ) )
            {
            // InternalTextualScenario.g:417:2: ( ( rule__SequenceMessage__Group__0 ) )
            // InternalTextualScenario.g:418:3: ( rule__SequenceMessage__Group__0 )
            {
             before(grammarAccess.getSequenceMessageAccess().getGroup()); 
            // InternalTextualScenario.g:419:3: ( rule__SequenceMessage__Group__0 )
            // InternalTextualScenario.g:419:4: rule__SequenceMessage__Group__0
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
    // InternalTextualScenario.g:428:1: entryRuleCreateMessage : ruleCreateMessage EOF ;
    public final void entryRuleCreateMessage() throws RecognitionException {
        try {
            // InternalTextualScenario.g:429:1: ( ruleCreateMessage EOF )
            // InternalTextualScenario.g:430:1: ruleCreateMessage EOF
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
    // InternalTextualScenario.g:437:1: ruleCreateMessage : ( ( rule__CreateMessage__Group__0 ) ) ;
    public final void ruleCreateMessage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:441:2: ( ( ( rule__CreateMessage__Group__0 ) ) )
            // InternalTextualScenario.g:442:2: ( ( rule__CreateMessage__Group__0 ) )
            {
            // InternalTextualScenario.g:442:2: ( ( rule__CreateMessage__Group__0 ) )
            // InternalTextualScenario.g:443:3: ( rule__CreateMessage__Group__0 )
            {
             before(grammarAccess.getCreateMessageAccess().getGroup()); 
            // InternalTextualScenario.g:444:3: ( rule__CreateMessage__Group__0 )
            // InternalTextualScenario.g:444:4: rule__CreateMessage__Group__0
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
    // InternalTextualScenario.g:453:1: entryRuleDeleteMessage : ruleDeleteMessage EOF ;
    public final void entryRuleDeleteMessage() throws RecognitionException {
        try {
            // InternalTextualScenario.g:454:1: ( ruleDeleteMessage EOF )
            // InternalTextualScenario.g:455:1: ruleDeleteMessage EOF
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
    // InternalTextualScenario.g:462:1: ruleDeleteMessage : ( ( rule__DeleteMessage__Group__0 ) ) ;
    public final void ruleDeleteMessage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:466:2: ( ( ( rule__DeleteMessage__Group__0 ) ) )
            // InternalTextualScenario.g:467:2: ( ( rule__DeleteMessage__Group__0 ) )
            {
            // InternalTextualScenario.g:467:2: ( ( rule__DeleteMessage__Group__0 ) )
            // InternalTextualScenario.g:468:3: ( rule__DeleteMessage__Group__0 )
            {
             before(grammarAccess.getDeleteMessageAccess().getGroup()); 
            // InternalTextualScenario.g:469:3: ( rule__DeleteMessage__Group__0 )
            // InternalTextualScenario.g:469:4: rule__DeleteMessage__Group__0
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
    // InternalTextualScenario.g:478:1: entryRuleArmTimerMessage : ruleArmTimerMessage EOF ;
    public final void entryRuleArmTimerMessage() throws RecognitionException {
        try {
            // InternalTextualScenario.g:479:1: ( ruleArmTimerMessage EOF )
            // InternalTextualScenario.g:480:1: ruleArmTimerMessage EOF
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
    // InternalTextualScenario.g:487:1: ruleArmTimerMessage : ( ( rule__ArmTimerMessage__Group__0 ) ) ;
    public final void ruleArmTimerMessage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:491:2: ( ( ( rule__ArmTimerMessage__Group__0 ) ) )
            // InternalTextualScenario.g:492:2: ( ( rule__ArmTimerMessage__Group__0 ) )
            {
            // InternalTextualScenario.g:492:2: ( ( rule__ArmTimerMessage__Group__0 ) )
            // InternalTextualScenario.g:493:3: ( rule__ArmTimerMessage__Group__0 )
            {
             before(grammarAccess.getArmTimerMessageAccess().getGroup()); 
            // InternalTextualScenario.g:494:3: ( rule__ArmTimerMessage__Group__0 )
            // InternalTextualScenario.g:494:4: rule__ArmTimerMessage__Group__0
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


    // $ANTLR start "entryRuleLostFoundMessage"
    // InternalTextualScenario.g:503:1: entryRuleLostFoundMessage : ruleLostFoundMessage EOF ;
    public final void entryRuleLostFoundMessage() throws RecognitionException {
        try {
            // InternalTextualScenario.g:504:1: ( ruleLostFoundMessage EOF )
            // InternalTextualScenario.g:505:1: ruleLostFoundMessage EOF
            {
             before(grammarAccess.getLostFoundMessageRule()); 
            pushFollow(FOLLOW_1);
            ruleLostFoundMessage();

            state._fsp--;

             after(grammarAccess.getLostFoundMessageRule()); 
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
    // $ANTLR end "entryRuleLostFoundMessage"


    // $ANTLR start "ruleLostFoundMessage"
    // InternalTextualScenario.g:512:1: ruleLostFoundMessage : ( ( rule__LostFoundMessage__Alternatives ) ) ;
    public final void ruleLostFoundMessage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:516:2: ( ( ( rule__LostFoundMessage__Alternatives ) ) )
            // InternalTextualScenario.g:517:2: ( ( rule__LostFoundMessage__Alternatives ) )
            {
            // InternalTextualScenario.g:517:2: ( ( rule__LostFoundMessage__Alternatives ) )
            // InternalTextualScenario.g:518:3: ( rule__LostFoundMessage__Alternatives )
            {
             before(grammarAccess.getLostFoundMessageAccess().getAlternatives()); 
            // InternalTextualScenario.g:519:3: ( rule__LostFoundMessage__Alternatives )
            // InternalTextualScenario.g:519:4: rule__LostFoundMessage__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__LostFoundMessage__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLostFoundMessageAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLostFoundMessage"


    // $ANTLR start "entryRuleLostMessage"
    // InternalTextualScenario.g:528:1: entryRuleLostMessage : ruleLostMessage EOF ;
    public final void entryRuleLostMessage() throws RecognitionException {
        try {
            // InternalTextualScenario.g:529:1: ( ruleLostMessage EOF )
            // InternalTextualScenario.g:530:1: ruleLostMessage EOF
            {
             before(grammarAccess.getLostMessageRule()); 
            pushFollow(FOLLOW_1);
            ruleLostMessage();

            state._fsp--;

             after(grammarAccess.getLostMessageRule()); 
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
    // $ANTLR end "entryRuleLostMessage"


    // $ANTLR start "ruleLostMessage"
    // InternalTextualScenario.g:537:1: ruleLostMessage : ( ( rule__LostMessage__Group__0 ) ) ;
    public final void ruleLostMessage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:541:2: ( ( ( rule__LostMessage__Group__0 ) ) )
            // InternalTextualScenario.g:542:2: ( ( rule__LostMessage__Group__0 ) )
            {
            // InternalTextualScenario.g:542:2: ( ( rule__LostMessage__Group__0 ) )
            // InternalTextualScenario.g:543:3: ( rule__LostMessage__Group__0 )
            {
             before(grammarAccess.getLostMessageAccess().getGroup()); 
            // InternalTextualScenario.g:544:3: ( rule__LostMessage__Group__0 )
            // InternalTextualScenario.g:544:4: rule__LostMessage__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LostMessage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLostMessageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLostMessage"


    // $ANTLR start "entryRuleFoundMessage"
    // InternalTextualScenario.g:553:1: entryRuleFoundMessage : ruleFoundMessage EOF ;
    public final void entryRuleFoundMessage() throws RecognitionException {
        try {
            // InternalTextualScenario.g:554:1: ( ruleFoundMessage EOF )
            // InternalTextualScenario.g:555:1: ruleFoundMessage EOF
            {
             before(grammarAccess.getFoundMessageRule()); 
            pushFollow(FOLLOW_1);
            ruleFoundMessage();

            state._fsp--;

             after(grammarAccess.getFoundMessageRule()); 
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
    // $ANTLR end "entryRuleFoundMessage"


    // $ANTLR start "ruleFoundMessage"
    // InternalTextualScenario.g:562:1: ruleFoundMessage : ( ( rule__FoundMessage__Group__0 ) ) ;
    public final void ruleFoundMessage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:566:2: ( ( ( rule__FoundMessage__Group__0 ) ) )
            // InternalTextualScenario.g:567:2: ( ( rule__FoundMessage__Group__0 ) )
            {
            // InternalTextualScenario.g:567:2: ( ( rule__FoundMessage__Group__0 ) )
            // InternalTextualScenario.g:568:3: ( rule__FoundMessage__Group__0 )
            {
             before(grammarAccess.getFoundMessageAccess().getGroup()); 
            // InternalTextualScenario.g:569:3: ( rule__FoundMessage__Group__0 )
            // InternalTextualScenario.g:569:4: rule__FoundMessage__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FoundMessage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFoundMessageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFoundMessage"


    // $ANTLR start "entryRuleParticipantDeactivation"
    // InternalTextualScenario.g:578:1: entryRuleParticipantDeactivation : ruleParticipantDeactivation EOF ;
    public final void entryRuleParticipantDeactivation() throws RecognitionException {
        try {
            // InternalTextualScenario.g:579:1: ( ruleParticipantDeactivation EOF )
            // InternalTextualScenario.g:580:1: ruleParticipantDeactivation EOF
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
    // InternalTextualScenario.g:587:1: ruleParticipantDeactivation : ( ( rule__ParticipantDeactivation__Group__0 ) ) ;
    public final void ruleParticipantDeactivation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:591:2: ( ( ( rule__ParticipantDeactivation__Group__0 ) ) )
            // InternalTextualScenario.g:592:2: ( ( rule__ParticipantDeactivation__Group__0 ) )
            {
            // InternalTextualScenario.g:592:2: ( ( rule__ParticipantDeactivation__Group__0 ) )
            // InternalTextualScenario.g:593:3: ( rule__ParticipantDeactivation__Group__0 )
            {
             before(grammarAccess.getParticipantDeactivationAccess().getGroup()); 
            // InternalTextualScenario.g:594:3: ( rule__ParticipantDeactivation__Group__0 )
            // InternalTextualScenario.g:594:4: rule__ParticipantDeactivation__Group__0
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


    // $ANTLR start "entryRuleCombinedFragment"
    // InternalTextualScenario.g:603:1: entryRuleCombinedFragment : ruleCombinedFragment EOF ;
    public final void entryRuleCombinedFragment() throws RecognitionException {
        try {
            // InternalTextualScenario.g:604:1: ( ruleCombinedFragment EOF )
            // InternalTextualScenario.g:605:1: ruleCombinedFragment EOF
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
    // InternalTextualScenario.g:612:1: ruleCombinedFragment : ( ( rule__CombinedFragment__Group__0 ) ) ;
    public final void ruleCombinedFragment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:616:2: ( ( ( rule__CombinedFragment__Group__0 ) ) )
            // InternalTextualScenario.g:617:2: ( ( rule__CombinedFragment__Group__0 ) )
            {
            // InternalTextualScenario.g:617:2: ( ( rule__CombinedFragment__Group__0 ) )
            // InternalTextualScenario.g:618:3: ( rule__CombinedFragment__Group__0 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getGroup()); 
            // InternalTextualScenario.g:619:3: ( rule__CombinedFragment__Group__0 )
            // InternalTextualScenario.g:619:4: rule__CombinedFragment__Group__0
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
    // InternalTextualScenario.g:628:1: entryRuleOperand : ruleOperand EOF ;
    public final void entryRuleOperand() throws RecognitionException {
        try {
            // InternalTextualScenario.g:629:1: ( ruleOperand EOF )
            // InternalTextualScenario.g:630:1: ruleOperand EOF
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
    // InternalTextualScenario.g:637:1: ruleOperand : ( ( rule__Operand__Group__0 ) ) ;
    public final void ruleOperand() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:641:2: ( ( ( rule__Operand__Group__0 ) ) )
            // InternalTextualScenario.g:642:2: ( ( rule__Operand__Group__0 ) )
            {
            // InternalTextualScenario.g:642:2: ( ( rule__Operand__Group__0 ) )
            // InternalTextualScenario.g:643:3: ( rule__Operand__Group__0 )
            {
             before(grammarAccess.getOperandAccess().getGroup()); 
            // InternalTextualScenario.g:644:3: ( rule__Operand__Group__0 )
            // InternalTextualScenario.g:644:4: rule__Operand__Group__0
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
    // InternalTextualScenario.g:653:1: entryRuleBlock : ruleBlock EOF ;
    public final void entryRuleBlock() throws RecognitionException {
        try {
            // InternalTextualScenario.g:654:1: ( ruleBlock EOF )
            // InternalTextualScenario.g:655:1: ruleBlock EOF
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
    // InternalTextualScenario.g:662:1: ruleBlock : ( ( rule__Block__Group__0 ) ) ;
    public final void ruleBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:666:2: ( ( ( rule__Block__Group__0 ) ) )
            // InternalTextualScenario.g:667:2: ( ( rule__Block__Group__0 ) )
            {
            // InternalTextualScenario.g:667:2: ( ( rule__Block__Group__0 ) )
            // InternalTextualScenario.g:668:3: ( rule__Block__Group__0 )
            {
             before(grammarAccess.getBlockAccess().getGroup()); 
            // InternalTextualScenario.g:669:3: ( rule__Block__Group__0 )
            // InternalTextualScenario.g:669:4: rule__Block__Group__0
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
    // InternalTextualScenario.g:678:1: entryRuleStateFragment : ruleStateFragment EOF ;
    public final void entryRuleStateFragment() throws RecognitionException {
        try {
            // InternalTextualScenario.g:679:1: ( ruleStateFragment EOF )
            // InternalTextualScenario.g:680:1: ruleStateFragment EOF
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
    // InternalTextualScenario.g:687:1: ruleStateFragment : ( ( rule__StateFragment__Group__0 ) ) ;
    public final void ruleStateFragment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:691:2: ( ( ( rule__StateFragment__Group__0 ) ) )
            // InternalTextualScenario.g:692:2: ( ( rule__StateFragment__Group__0 ) )
            {
            // InternalTextualScenario.g:692:2: ( ( rule__StateFragment__Group__0 ) )
            // InternalTextualScenario.g:693:3: ( rule__StateFragment__Group__0 )
            {
             before(grammarAccess.getStateFragmentAccess().getGroup()); 
            // InternalTextualScenario.g:694:3: ( rule__StateFragment__Group__0 )
            // InternalTextualScenario.g:694:4: rule__StateFragment__Group__0
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


    // $ANTLR start "entryRuleReference"
    // InternalTextualScenario.g:703:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // InternalTextualScenario.g:704:1: ( ruleReference EOF )
            // InternalTextualScenario.g:705:1: ruleReference EOF
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
    // InternalTextualScenario.g:712:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:716:2: ( ( ( rule__Reference__Group__0 ) ) )
            // InternalTextualScenario.g:717:2: ( ( rule__Reference__Group__0 ) )
            {
            // InternalTextualScenario.g:717:2: ( ( rule__Reference__Group__0 ) )
            // InternalTextualScenario.g:718:3: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // InternalTextualScenario.g:719:3: ( rule__Reference__Group__0 )
            // InternalTextualScenario.g:719:4: rule__Reference__Group__0
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


    // $ANTLR start "rule__Participant__Alternatives"
    // InternalTextualScenario.g:727:1: rule__Participant__Alternatives : ( ( ruleGenericComponent ) | ( ruleGenericFunction ) );
    public final void rule__Participant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:731:1: ( ( ruleGenericComponent ) | ( ruleGenericFunction ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=28 && LA1_0<=30)||(LA1_0>=32 && LA1_0<=33)) ) {
                alt1=1;
            }
            else if ( (LA1_0==24||LA1_0==31) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalTextualScenario.g:732:2: ( ruleGenericComponent )
                    {
                    // InternalTextualScenario.g:732:2: ( ruleGenericComponent )
                    // InternalTextualScenario.g:733:3: ruleGenericComponent
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
                    // InternalTextualScenario.g:738:2: ( ruleGenericFunction )
                    {
                    // InternalTextualScenario.g:738:2: ( ruleGenericFunction )
                    // InternalTextualScenario.g:739:3: ruleGenericFunction
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
    // InternalTextualScenario.g:748:1: rule__GenericComponent__Alternatives : ( ( ruleEntity ) | ( ruleActor ) | ( ruleComponent ) | ( ruleConfigurationItem ) | ( ruleRole ) );
    public final void rule__GenericComponent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:752:1: ( ( ruleEntity ) | ( ruleActor ) | ( ruleComponent ) | ( ruleConfigurationItem ) | ( ruleRole ) )
            int alt2=5;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt2=1;
                }
                break;
            case 28:
                {
                alt2=2;
                }
                break;
            case 29:
                {
                alt2=3;
                }
                break;
            case 30:
                {
                alt2=4;
                }
                break;
            case 33:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalTextualScenario.g:753:2: ( ruleEntity )
                    {
                    // InternalTextualScenario.g:753:2: ( ruleEntity )
                    // InternalTextualScenario.g:754:3: ruleEntity
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
                    // InternalTextualScenario.g:759:2: ( ruleActor )
                    {
                    // InternalTextualScenario.g:759:2: ( ruleActor )
                    // InternalTextualScenario.g:760:3: ruleActor
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
                    // InternalTextualScenario.g:765:2: ( ruleComponent )
                    {
                    // InternalTextualScenario.g:765:2: ( ruleComponent )
                    // InternalTextualScenario.g:766:3: ruleComponent
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
                    // InternalTextualScenario.g:771:2: ( ruleConfigurationItem )
                    {
                    // InternalTextualScenario.g:771:2: ( ruleConfigurationItem )
                    // InternalTextualScenario.g:772:3: ruleConfigurationItem
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
                    // InternalTextualScenario.g:777:2: ( ruleRole )
                    {
                    // InternalTextualScenario.g:777:2: ( ruleRole )
                    // InternalTextualScenario.g:778:3: ruleRole
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
    // InternalTextualScenario.g:787:1: rule__GenericFunction__Alternatives : ( ( ruleFunction ) | ( ruleActivity ) );
    public final void rule__GenericFunction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:791:1: ( ( ruleFunction ) | ( ruleActivity ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==24) ) {
                alt3=1;
            }
            else if ( (LA3_0==31) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalTextualScenario.g:792:2: ( ruleFunction )
                    {
                    // InternalTextualScenario.g:792:2: ( ruleFunction )
                    // InternalTextualScenario.g:793:3: ruleFunction
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
                    // InternalTextualScenario.g:798:2: ( ruleActivity )
                    {
                    // InternalTextualScenario.g:798:2: ( ruleActivity )
                    // InternalTextualScenario.g:799:3: ruleActivity
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


    // $ANTLR start "rule__Element__Alternatives"
    // InternalTextualScenario.g:808:1: rule__Element__Alternatives : ( ( ruleMessage ) | ( ruleCombinedFragment ) | ( ruleStateFragment ) | ( ruleReference ) );
    public final void rule__Element__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:812:1: ( ( ruleMessage ) | ( ruleCombinedFragment ) | ( ruleStateFragment ) | ( ruleReference ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case 40:
            case 41:
            case 42:
            case 43:
                {
                alt4=1;
                }
                break;
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                {
                alt4=2;
                }
                break;
            case 46:
                {
                alt4=3;
                }
                break;
            case 47:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalTextualScenario.g:813:2: ( ruleMessage )
                    {
                    // InternalTextualScenario.g:813:2: ( ruleMessage )
                    // InternalTextualScenario.g:814:3: ruleMessage
                    {
                     before(grammarAccess.getElementAccess().getMessageParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleMessage();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getMessageParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:819:2: ( ruleCombinedFragment )
                    {
                    // InternalTextualScenario.g:819:2: ( ruleCombinedFragment )
                    // InternalTextualScenario.g:820:3: ruleCombinedFragment
                    {
                     before(grammarAccess.getElementAccess().getCombinedFragmentParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleCombinedFragment();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getCombinedFragmentParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:825:2: ( ruleStateFragment )
                    {
                    // InternalTextualScenario.g:825:2: ( ruleStateFragment )
                    // InternalTextualScenario.g:826:3: ruleStateFragment
                    {
                     before(grammarAccess.getElementAccess().getStateFragmentParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleStateFragment();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getStateFragmentParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTextualScenario.g:831:2: ( ruleReference )
                    {
                    // InternalTextualScenario.g:831:2: ( ruleReference )
                    // InternalTextualScenario.g:832:3: ruleReference
                    {
                     before(grammarAccess.getElementAccess().getReferenceParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getReferenceParserRuleCall_3()); 

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
    // $ANTLR end "rule__Element__Alternatives"


    // $ANTLR start "rule__Message__Alternatives"
    // InternalTextualScenario.g:841:1: rule__Message__Alternatives : ( ( ruleSequenceMessageType ) | ( ruleArmTimerMessage ) | ( ruleParticipantDeactivation ) | ( ruleLostFoundMessage ) );
    public final void rule__Message__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:845:1: ( ( ruleSequenceMessageType ) | ( ruleArmTimerMessage ) | ( ruleParticipantDeactivation ) | ( ruleLostFoundMessage ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt5=1;
                }
                break;
            case 40:
                {
                alt5=2;
                }
                break;
            case 43:
                {
                alt5=3;
                }
                break;
            case 41:
            case 42:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalTextualScenario.g:846:2: ( ruleSequenceMessageType )
                    {
                    // InternalTextualScenario.g:846:2: ( ruleSequenceMessageType )
                    // InternalTextualScenario.g:847:3: ruleSequenceMessageType
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
                    // InternalTextualScenario.g:852:2: ( ruleArmTimerMessage )
                    {
                    // InternalTextualScenario.g:852:2: ( ruleArmTimerMessage )
                    // InternalTextualScenario.g:853:3: ruleArmTimerMessage
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
                    // InternalTextualScenario.g:858:2: ( ruleParticipantDeactivation )
                    {
                    // InternalTextualScenario.g:858:2: ( ruleParticipantDeactivation )
                    // InternalTextualScenario.g:859:3: ruleParticipantDeactivation
                    {
                     before(grammarAccess.getMessageAccess().getParticipantDeactivationParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleParticipantDeactivation();

                    state._fsp--;

                     after(grammarAccess.getMessageAccess().getParticipantDeactivationParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTextualScenario.g:864:2: ( ruleLostFoundMessage )
                    {
                    // InternalTextualScenario.g:864:2: ( ruleLostFoundMessage )
                    // InternalTextualScenario.g:865:3: ruleLostFoundMessage
                    {
                     before(grammarAccess.getMessageAccess().getLostFoundMessageParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleLostFoundMessage();

                    state._fsp--;

                     after(grammarAccess.getMessageAccess().getLostFoundMessageParserRuleCall_3()); 

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
    // InternalTextualScenario.g:874:1: rule__SequenceMessageType__Alternatives : ( ( ruleSequenceMessage ) | ( ruleCreateMessage ) | ( ruleDeleteMessage ) );
    public final void rule__SequenceMessageType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:878:1: ( ( ruleSequenceMessage ) | ( ruleCreateMessage ) | ( ruleDeleteMessage ) )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                switch ( input.LA(2) ) {
                case 38:
                    {
                    alt6=2;
                    }
                    break;
                case 34:
                    {
                    alt6=1;
                    }
                    break;
                case 39:
                    {
                    alt6=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalTextualScenario.g:879:2: ( ruleSequenceMessage )
                    {
                    // InternalTextualScenario.g:879:2: ( ruleSequenceMessage )
                    // InternalTextualScenario.g:880:3: ruleSequenceMessage
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
                    // InternalTextualScenario.g:885:2: ( ruleCreateMessage )
                    {
                    // InternalTextualScenario.g:885:2: ( ruleCreateMessage )
                    // InternalTextualScenario.g:886:3: ruleCreateMessage
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
                    // InternalTextualScenario.g:891:2: ( ruleDeleteMessage )
                    {
                    // InternalTextualScenario.g:891:2: ( ruleDeleteMessage )
                    // InternalTextualScenario.g:892:3: ruleDeleteMessage
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


    // $ANTLR start "rule__LostFoundMessage__Alternatives"
    // InternalTextualScenario.g:901:1: rule__LostFoundMessage__Alternatives : ( ( ruleLostMessage ) | ( ruleFoundMessage ) );
    public final void rule__LostFoundMessage__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:905:1: ( ( ruleLostMessage ) | ( ruleFoundMessage ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==41) ) {
                alt7=1;
            }
            else if ( (LA7_0==42) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalTextualScenario.g:906:2: ( ruleLostMessage )
                    {
                    // InternalTextualScenario.g:906:2: ( ruleLostMessage )
                    // InternalTextualScenario.g:907:3: ruleLostMessage
                    {
                     before(grammarAccess.getLostFoundMessageAccess().getLostMessageParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleLostMessage();

                    state._fsp--;

                     after(grammarAccess.getLostFoundMessageAccess().getLostMessageParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:912:2: ( ruleFoundMessage )
                    {
                    // InternalTextualScenario.g:912:2: ( ruleFoundMessage )
                    // InternalTextualScenario.g:913:3: ruleFoundMessage
                    {
                     before(grammarAccess.getLostFoundMessageAccess().getFoundMessageParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleFoundMessage();

                    state._fsp--;

                     after(grammarAccess.getLostFoundMessageAccess().getFoundMessageParserRuleCall_1()); 

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
    // $ANTLR end "rule__LostFoundMessage__Alternatives"


    // $ANTLR start "rule__CombinedFragment__KeywordAlternatives_0_0"
    // InternalTextualScenario.g:922:1: rule__CombinedFragment__KeywordAlternatives_0_0 : ( ( 'alt' ) | ( 'loop' ) | ( 'par' ) | ( 'assert' ) | ( 'critical' ) | ( 'ignore' ) | ( 'neg' ) | ( 'opt' ) | ( 'seq' ) | ( 'strict' ) | ( 'unset' ) );
    public final void rule__CombinedFragment__KeywordAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:926:1: ( ( 'alt' ) | ( 'loop' ) | ( 'par' ) | ( 'assert' ) | ( 'critical' ) | ( 'ignore' ) | ( 'neg' ) | ( 'opt' ) | ( 'seq' ) | ( 'strict' ) | ( 'unset' ) )
            int alt8=11;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt8=1;
                }
                break;
            case 12:
                {
                alt8=2;
                }
                break;
            case 13:
                {
                alt8=3;
                }
                break;
            case 14:
                {
                alt8=4;
                }
                break;
            case 15:
                {
                alt8=5;
                }
                break;
            case 16:
                {
                alt8=6;
                }
                break;
            case 17:
                {
                alt8=7;
                }
                break;
            case 18:
                {
                alt8=8;
                }
                break;
            case 19:
                {
                alt8=9;
                }
                break;
            case 20:
                {
                alt8=10;
                }
                break;
            case 21:
                {
                alt8=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalTextualScenario.g:927:2: ( 'alt' )
                    {
                    // InternalTextualScenario.g:927:2: ( 'alt' )
                    // InternalTextualScenario.g:928:3: 'alt'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordAltKeyword_0_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordAltKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:933:2: ( 'loop' )
                    {
                    // InternalTextualScenario.g:933:2: ( 'loop' )
                    // InternalTextualScenario.g:934:3: 'loop'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordLoopKeyword_0_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordLoopKeyword_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:939:2: ( 'par' )
                    {
                    // InternalTextualScenario.g:939:2: ( 'par' )
                    // InternalTextualScenario.g:940:3: 'par'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordParKeyword_0_0_2()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordParKeyword_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTextualScenario.g:945:2: ( 'assert' )
                    {
                    // InternalTextualScenario.g:945:2: ( 'assert' )
                    // InternalTextualScenario.g:946:3: 'assert'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordAssertKeyword_0_0_3()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordAssertKeyword_0_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalTextualScenario.g:951:2: ( 'critical' )
                    {
                    // InternalTextualScenario.g:951:2: ( 'critical' )
                    // InternalTextualScenario.g:952:3: 'critical'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordCriticalKeyword_0_0_4()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordCriticalKeyword_0_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalTextualScenario.g:957:2: ( 'ignore' )
                    {
                    // InternalTextualScenario.g:957:2: ( 'ignore' )
                    // InternalTextualScenario.g:958:3: 'ignore'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordIgnoreKeyword_0_0_5()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordIgnoreKeyword_0_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalTextualScenario.g:963:2: ( 'neg' )
                    {
                    // InternalTextualScenario.g:963:2: ( 'neg' )
                    // InternalTextualScenario.g:964:3: 'neg'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordNegKeyword_0_0_6()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordNegKeyword_0_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalTextualScenario.g:969:2: ( 'opt' )
                    {
                    // InternalTextualScenario.g:969:2: ( 'opt' )
                    // InternalTextualScenario.g:970:3: 'opt'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordOptKeyword_0_0_7()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordOptKeyword_0_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalTextualScenario.g:975:2: ( 'seq' )
                    {
                    // InternalTextualScenario.g:975:2: ( 'seq' )
                    // InternalTextualScenario.g:976:3: 'seq'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordSeqKeyword_0_0_8()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordSeqKeyword_0_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalTextualScenario.g:981:2: ( 'strict' )
                    {
                    // InternalTextualScenario.g:981:2: ( 'strict' )
                    // InternalTextualScenario.g:982:3: 'strict'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordStrictKeyword_0_0_9()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordStrictKeyword_0_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalTextualScenario.g:987:2: ( 'unset' )
                    {
                    // InternalTextualScenario.g:987:2: ( 'unset' )
                    // InternalTextualScenario.g:988:3: 'unset'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordUnsetKeyword_0_0_10()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordUnsetKeyword_0_0_10()); 

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


    // $ANTLR start "rule__StateFragment__KeywordAlternatives_2_0"
    // InternalTextualScenario.g:997:1: rule__StateFragment__KeywordAlternatives_2_0 : ( ( 'state' ) | ( 'mode' ) | ( 'function' ) );
    public final void rule__StateFragment__KeywordAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1001:1: ( ( 'state' ) | ( 'mode' ) | ( 'function' ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt9=1;
                }
                break;
            case 23:
                {
                alt9=2;
                }
                break;
            case 24:
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
                    // InternalTextualScenario.g:1002:2: ( 'state' )
                    {
                    // InternalTextualScenario.g:1002:2: ( 'state' )
                    // InternalTextualScenario.g:1003:3: 'state'
                    {
                     before(grammarAccess.getStateFragmentAccess().getKeywordStateKeyword_2_0_0()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getStateFragmentAccess().getKeywordStateKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:1008:2: ( 'mode' )
                    {
                    // InternalTextualScenario.g:1008:2: ( 'mode' )
                    // InternalTextualScenario.g:1009:3: 'mode'
                    {
                     before(grammarAccess.getStateFragmentAccess().getKeywordModeKeyword_2_0_1()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getStateFragmentAccess().getKeywordModeKeyword_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:1014:2: ( 'function' )
                    {
                    // InternalTextualScenario.g:1014:2: ( 'function' )
                    // InternalTextualScenario.g:1015:3: 'function'
                    {
                     before(grammarAccess.getStateFragmentAccess().getKeywordFunctionKeyword_2_0_2()); 
                    match(input,24,FOLLOW_2); 
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
    // InternalTextualScenario.g:1024:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1028:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalTextualScenario.g:1029:2: rule__Model__Group__0__Impl rule__Model__Group__1
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
    // InternalTextualScenario.g:1036:1: rule__Model__Group__0__Impl : ( 'scenario' ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1040:1: ( ( 'scenario' ) )
            // InternalTextualScenario.g:1041:1: ( 'scenario' )
            {
            // InternalTextualScenario.g:1041:1: ( 'scenario' )
            // InternalTextualScenario.g:1042:2: 'scenario'
            {
             before(grammarAccess.getModelAccess().getScenarioKeyword_0()); 
            match(input,25,FOLLOW_2); 
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
    // InternalTextualScenario.g:1051:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1055:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalTextualScenario.g:1056:2: rule__Model__Group__1__Impl rule__Model__Group__2
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
    // InternalTextualScenario.g:1063:1: rule__Model__Group__1__Impl : ( ( rule__Model__BeginAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1067:1: ( ( ( rule__Model__BeginAssignment_1 ) ) )
            // InternalTextualScenario.g:1068:1: ( ( rule__Model__BeginAssignment_1 ) )
            {
            // InternalTextualScenario.g:1068:1: ( ( rule__Model__BeginAssignment_1 ) )
            // InternalTextualScenario.g:1069:2: ( rule__Model__BeginAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getBeginAssignment_1()); 
            // InternalTextualScenario.g:1070:2: ( rule__Model__BeginAssignment_1 )
            // InternalTextualScenario.g:1070:3: rule__Model__BeginAssignment_1
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
    // InternalTextualScenario.g:1078:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1082:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalTextualScenario.g:1083:2: rule__Model__Group__2__Impl rule__Model__Group__3
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
    // InternalTextualScenario.g:1090:1: rule__Model__Group__2__Impl : ( ( rule__Model__ParticipantsAssignment_2 )* ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1094:1: ( ( ( rule__Model__ParticipantsAssignment_2 )* ) )
            // InternalTextualScenario.g:1095:1: ( ( rule__Model__ParticipantsAssignment_2 )* )
            {
            // InternalTextualScenario.g:1095:1: ( ( rule__Model__ParticipantsAssignment_2 )* )
            // InternalTextualScenario.g:1096:2: ( rule__Model__ParticipantsAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getParticipantsAssignment_2()); 
            // InternalTextualScenario.g:1097:2: ( rule__Model__ParticipantsAssignment_2 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==24||(LA10_0>=28 && LA10_0<=33)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalTextualScenario.g:1097:3: rule__Model__ParticipantsAssignment_2
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
    // InternalTextualScenario.g:1105:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1109:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // InternalTextualScenario.g:1110:2: rule__Model__Group__3__Impl rule__Model__Group__4
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
    // InternalTextualScenario.g:1117:1: rule__Model__Group__3__Impl : ( ( rule__Model__ElementsAssignment_3 )* ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1121:1: ( ( ( rule__Model__ElementsAssignment_3 )* ) )
            // InternalTextualScenario.g:1122:1: ( ( rule__Model__ElementsAssignment_3 )* )
            {
            // InternalTextualScenario.g:1122:1: ( ( rule__Model__ElementsAssignment_3 )* )
            // InternalTextualScenario.g:1123:2: ( rule__Model__ElementsAssignment_3 )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment_3()); 
            // InternalTextualScenario.g:1124:2: ( rule__Model__ElementsAssignment_3 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_STRING||(LA11_0>=11 && LA11_0<=21)||(LA11_0>=40 && LA11_0<=43)||(LA11_0>=46 && LA11_0<=47)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalTextualScenario.g:1124:3: rule__Model__ElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Model__ElementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // InternalTextualScenario.g:1132:1: rule__Model__Group__4 : rule__Model__Group__4__Impl ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1136:1: ( rule__Model__Group__4__Impl )
            // InternalTextualScenario.g:1137:2: rule__Model__Group__4__Impl
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
    // InternalTextualScenario.g:1143:1: rule__Model__Group__4__Impl : ( ( rule__Model__EndAssignment_4 ) ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1147:1: ( ( ( rule__Model__EndAssignment_4 ) ) )
            // InternalTextualScenario.g:1148:1: ( ( rule__Model__EndAssignment_4 ) )
            {
            // InternalTextualScenario.g:1148:1: ( ( rule__Model__EndAssignment_4 ) )
            // InternalTextualScenario.g:1149:2: ( rule__Model__EndAssignment_4 )
            {
             before(grammarAccess.getModelAccess().getEndAssignment_4()); 
            // InternalTextualScenario.g:1150:2: ( rule__Model__EndAssignment_4 )
            // InternalTextualScenario.g:1150:3: rule__Model__EndAssignment_4
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
    // InternalTextualScenario.g:1159:1: rule__Actor__Group__0 : rule__Actor__Group__0__Impl rule__Actor__Group__1 ;
    public final void rule__Actor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1163:1: ( rule__Actor__Group__0__Impl rule__Actor__Group__1 )
            // InternalTextualScenario.g:1164:2: rule__Actor__Group__0__Impl rule__Actor__Group__1
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
    // InternalTextualScenario.g:1171:1: rule__Actor__Group__0__Impl : ( ( rule__Actor__KeywordAssignment_0 ) ) ;
    public final void rule__Actor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1175:1: ( ( ( rule__Actor__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1176:1: ( ( rule__Actor__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1176:1: ( ( rule__Actor__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1177:2: ( rule__Actor__KeywordAssignment_0 )
            {
             before(grammarAccess.getActorAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1178:2: ( rule__Actor__KeywordAssignment_0 )
            // InternalTextualScenario.g:1178:3: rule__Actor__KeywordAssignment_0
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
    // InternalTextualScenario.g:1186:1: rule__Actor__Group__1 : rule__Actor__Group__1__Impl ;
    public final void rule__Actor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1190:1: ( rule__Actor__Group__1__Impl )
            // InternalTextualScenario.g:1191:2: rule__Actor__Group__1__Impl
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
    // InternalTextualScenario.g:1197:1: rule__Actor__Group__1__Impl : ( ( rule__Actor__NameAssignment_1 ) ) ;
    public final void rule__Actor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1201:1: ( ( ( rule__Actor__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1202:1: ( ( rule__Actor__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1202:1: ( ( rule__Actor__NameAssignment_1 ) )
            // InternalTextualScenario.g:1203:2: ( rule__Actor__NameAssignment_1 )
            {
             before(grammarAccess.getActorAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1204:2: ( rule__Actor__NameAssignment_1 )
            // InternalTextualScenario.g:1204:3: rule__Actor__NameAssignment_1
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
    // InternalTextualScenario.g:1213:1: rule__Component__Group__0 : rule__Component__Group__0__Impl rule__Component__Group__1 ;
    public final void rule__Component__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1217:1: ( rule__Component__Group__0__Impl rule__Component__Group__1 )
            // InternalTextualScenario.g:1218:2: rule__Component__Group__0__Impl rule__Component__Group__1
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
    // InternalTextualScenario.g:1225:1: rule__Component__Group__0__Impl : ( ( rule__Component__KeywordAssignment_0 ) ) ;
    public final void rule__Component__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1229:1: ( ( ( rule__Component__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1230:1: ( ( rule__Component__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1230:1: ( ( rule__Component__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1231:2: ( rule__Component__KeywordAssignment_0 )
            {
             before(grammarAccess.getComponentAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1232:2: ( rule__Component__KeywordAssignment_0 )
            // InternalTextualScenario.g:1232:3: rule__Component__KeywordAssignment_0
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
    // InternalTextualScenario.g:1240:1: rule__Component__Group__1 : rule__Component__Group__1__Impl ;
    public final void rule__Component__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1244:1: ( rule__Component__Group__1__Impl )
            // InternalTextualScenario.g:1245:2: rule__Component__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Component__Group__1__Impl();

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
    // InternalTextualScenario.g:1251:1: rule__Component__Group__1__Impl : ( ( rule__Component__NameAssignment_1 ) ) ;
    public final void rule__Component__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1255:1: ( ( ( rule__Component__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1256:1: ( ( rule__Component__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1256:1: ( ( rule__Component__NameAssignment_1 ) )
            // InternalTextualScenario.g:1257:2: ( rule__Component__NameAssignment_1 )
            {
             before(grammarAccess.getComponentAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1258:2: ( rule__Component__NameAssignment_1 )
            // InternalTextualScenario.g:1258:3: rule__Component__NameAssignment_1
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


    // $ANTLR start "rule__ConfigurationItem__Group__0"
    // InternalTextualScenario.g:1267:1: rule__ConfigurationItem__Group__0 : rule__ConfigurationItem__Group__0__Impl rule__ConfigurationItem__Group__1 ;
    public final void rule__ConfigurationItem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1271:1: ( rule__ConfigurationItem__Group__0__Impl rule__ConfigurationItem__Group__1 )
            // InternalTextualScenario.g:1272:2: rule__ConfigurationItem__Group__0__Impl rule__ConfigurationItem__Group__1
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
    // InternalTextualScenario.g:1279:1: rule__ConfigurationItem__Group__0__Impl : ( ( rule__ConfigurationItem__KeywordAssignment_0 ) ) ;
    public final void rule__ConfigurationItem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1283:1: ( ( ( rule__ConfigurationItem__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1284:1: ( ( rule__ConfigurationItem__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1284:1: ( ( rule__ConfigurationItem__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1285:2: ( rule__ConfigurationItem__KeywordAssignment_0 )
            {
             before(grammarAccess.getConfigurationItemAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1286:2: ( rule__ConfigurationItem__KeywordAssignment_0 )
            // InternalTextualScenario.g:1286:3: rule__ConfigurationItem__KeywordAssignment_0
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
    // InternalTextualScenario.g:1294:1: rule__ConfigurationItem__Group__1 : rule__ConfigurationItem__Group__1__Impl ;
    public final void rule__ConfigurationItem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1298:1: ( rule__ConfigurationItem__Group__1__Impl )
            // InternalTextualScenario.g:1299:2: rule__ConfigurationItem__Group__1__Impl
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
    // InternalTextualScenario.g:1305:1: rule__ConfigurationItem__Group__1__Impl : ( ( rule__ConfigurationItem__NameAssignment_1 ) ) ;
    public final void rule__ConfigurationItem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1309:1: ( ( ( rule__ConfigurationItem__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1310:1: ( ( rule__ConfigurationItem__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1310:1: ( ( rule__ConfigurationItem__NameAssignment_1 ) )
            // InternalTextualScenario.g:1311:2: ( rule__ConfigurationItem__NameAssignment_1 )
            {
             before(grammarAccess.getConfigurationItemAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1312:2: ( rule__ConfigurationItem__NameAssignment_1 )
            // InternalTextualScenario.g:1312:3: rule__ConfigurationItem__NameAssignment_1
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
    // InternalTextualScenario.g:1321:1: rule__Function__Group__0 : rule__Function__Group__0__Impl rule__Function__Group__1 ;
    public final void rule__Function__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1325:1: ( rule__Function__Group__0__Impl rule__Function__Group__1 )
            // InternalTextualScenario.g:1326:2: rule__Function__Group__0__Impl rule__Function__Group__1
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
    // InternalTextualScenario.g:1333:1: rule__Function__Group__0__Impl : ( ( rule__Function__KeywordAssignment_0 ) ) ;
    public final void rule__Function__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1337:1: ( ( ( rule__Function__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1338:1: ( ( rule__Function__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1338:1: ( ( rule__Function__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1339:2: ( rule__Function__KeywordAssignment_0 )
            {
             before(grammarAccess.getFunctionAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1340:2: ( rule__Function__KeywordAssignment_0 )
            // InternalTextualScenario.g:1340:3: rule__Function__KeywordAssignment_0
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
    // InternalTextualScenario.g:1348:1: rule__Function__Group__1 : rule__Function__Group__1__Impl ;
    public final void rule__Function__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1352:1: ( rule__Function__Group__1__Impl )
            // InternalTextualScenario.g:1353:2: rule__Function__Group__1__Impl
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
    // InternalTextualScenario.g:1359:1: rule__Function__Group__1__Impl : ( ( rule__Function__NameAssignment_1 ) ) ;
    public final void rule__Function__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1363:1: ( ( ( rule__Function__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1364:1: ( ( rule__Function__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1364:1: ( ( rule__Function__NameAssignment_1 ) )
            // InternalTextualScenario.g:1365:2: ( rule__Function__NameAssignment_1 )
            {
             before(grammarAccess.getFunctionAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1366:2: ( rule__Function__NameAssignment_1 )
            // InternalTextualScenario.g:1366:3: rule__Function__NameAssignment_1
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
    // InternalTextualScenario.g:1375:1: rule__Activity__Group__0 : rule__Activity__Group__0__Impl rule__Activity__Group__1 ;
    public final void rule__Activity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1379:1: ( rule__Activity__Group__0__Impl rule__Activity__Group__1 )
            // InternalTextualScenario.g:1380:2: rule__Activity__Group__0__Impl rule__Activity__Group__1
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
    // InternalTextualScenario.g:1387:1: rule__Activity__Group__0__Impl : ( ( rule__Activity__KeywordAssignment_0 ) ) ;
    public final void rule__Activity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1391:1: ( ( ( rule__Activity__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1392:1: ( ( rule__Activity__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1392:1: ( ( rule__Activity__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1393:2: ( rule__Activity__KeywordAssignment_0 )
            {
             before(grammarAccess.getActivityAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1394:2: ( rule__Activity__KeywordAssignment_0 )
            // InternalTextualScenario.g:1394:3: rule__Activity__KeywordAssignment_0
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
    // InternalTextualScenario.g:1402:1: rule__Activity__Group__1 : rule__Activity__Group__1__Impl ;
    public final void rule__Activity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1406:1: ( rule__Activity__Group__1__Impl )
            // InternalTextualScenario.g:1407:2: rule__Activity__Group__1__Impl
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
    // InternalTextualScenario.g:1413:1: rule__Activity__Group__1__Impl : ( ( rule__Activity__NameAssignment_1 ) ) ;
    public final void rule__Activity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1417:1: ( ( ( rule__Activity__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1418:1: ( ( rule__Activity__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1418:1: ( ( rule__Activity__NameAssignment_1 ) )
            // InternalTextualScenario.g:1419:2: ( rule__Activity__NameAssignment_1 )
            {
             before(grammarAccess.getActivityAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1420:2: ( rule__Activity__NameAssignment_1 )
            // InternalTextualScenario.g:1420:3: rule__Activity__NameAssignment_1
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
    // InternalTextualScenario.g:1429:1: rule__Entity__Group__0 : rule__Entity__Group__0__Impl rule__Entity__Group__1 ;
    public final void rule__Entity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1433:1: ( rule__Entity__Group__0__Impl rule__Entity__Group__1 )
            // InternalTextualScenario.g:1434:2: rule__Entity__Group__0__Impl rule__Entity__Group__1
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
    // InternalTextualScenario.g:1441:1: rule__Entity__Group__0__Impl : ( ( rule__Entity__KeywordAssignment_0 ) ) ;
    public final void rule__Entity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1445:1: ( ( ( rule__Entity__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1446:1: ( ( rule__Entity__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1446:1: ( ( rule__Entity__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1447:2: ( rule__Entity__KeywordAssignment_0 )
            {
             before(grammarAccess.getEntityAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1448:2: ( rule__Entity__KeywordAssignment_0 )
            // InternalTextualScenario.g:1448:3: rule__Entity__KeywordAssignment_0
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
    // InternalTextualScenario.g:1456:1: rule__Entity__Group__1 : rule__Entity__Group__1__Impl ;
    public final void rule__Entity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1460:1: ( rule__Entity__Group__1__Impl )
            // InternalTextualScenario.g:1461:2: rule__Entity__Group__1__Impl
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
    // InternalTextualScenario.g:1467:1: rule__Entity__Group__1__Impl : ( ( rule__Entity__NameAssignment_1 ) ) ;
    public final void rule__Entity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1471:1: ( ( ( rule__Entity__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1472:1: ( ( rule__Entity__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1472:1: ( ( rule__Entity__NameAssignment_1 ) )
            // InternalTextualScenario.g:1473:2: ( rule__Entity__NameAssignment_1 )
            {
             before(grammarAccess.getEntityAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1474:2: ( rule__Entity__NameAssignment_1 )
            // InternalTextualScenario.g:1474:3: rule__Entity__NameAssignment_1
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
    // InternalTextualScenario.g:1483:1: rule__Role__Group__0 : rule__Role__Group__0__Impl rule__Role__Group__1 ;
    public final void rule__Role__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1487:1: ( rule__Role__Group__0__Impl rule__Role__Group__1 )
            // InternalTextualScenario.g:1488:2: rule__Role__Group__0__Impl rule__Role__Group__1
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
    // InternalTextualScenario.g:1495:1: rule__Role__Group__0__Impl : ( ( rule__Role__KeywordAssignment_0 ) ) ;
    public final void rule__Role__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1499:1: ( ( ( rule__Role__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1500:1: ( ( rule__Role__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1500:1: ( ( rule__Role__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1501:2: ( rule__Role__KeywordAssignment_0 )
            {
             before(grammarAccess.getRoleAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1502:2: ( rule__Role__KeywordAssignment_0 )
            // InternalTextualScenario.g:1502:3: rule__Role__KeywordAssignment_0
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
    // InternalTextualScenario.g:1510:1: rule__Role__Group__1 : rule__Role__Group__1__Impl ;
    public final void rule__Role__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1514:1: ( rule__Role__Group__1__Impl )
            // InternalTextualScenario.g:1515:2: rule__Role__Group__1__Impl
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
    // InternalTextualScenario.g:1521:1: rule__Role__Group__1__Impl : ( ( rule__Role__NameAssignment_1 ) ) ;
    public final void rule__Role__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1525:1: ( ( ( rule__Role__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1526:1: ( ( rule__Role__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1526:1: ( ( rule__Role__NameAssignment_1 ) )
            // InternalTextualScenario.g:1527:2: ( rule__Role__NameAssignment_1 )
            {
             before(grammarAccess.getRoleAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1528:2: ( rule__Role__NameAssignment_1 )
            // InternalTextualScenario.g:1528:3: rule__Role__NameAssignment_1
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
    // InternalTextualScenario.g:1537:1: rule__SequenceMessage__Group__0 : rule__SequenceMessage__Group__0__Impl rule__SequenceMessage__Group__1 ;
    public final void rule__SequenceMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1541:1: ( rule__SequenceMessage__Group__0__Impl rule__SequenceMessage__Group__1 )
            // InternalTextualScenario.g:1542:2: rule__SequenceMessage__Group__0__Impl rule__SequenceMessage__Group__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalTextualScenario.g:1549:1: rule__SequenceMessage__Group__0__Impl : ( ( rule__SequenceMessage__SourceAssignment_0 ) ) ;
    public final void rule__SequenceMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1553:1: ( ( ( rule__SequenceMessage__SourceAssignment_0 ) ) )
            // InternalTextualScenario.g:1554:1: ( ( rule__SequenceMessage__SourceAssignment_0 ) )
            {
            // InternalTextualScenario.g:1554:1: ( ( rule__SequenceMessage__SourceAssignment_0 ) )
            // InternalTextualScenario.g:1555:2: ( rule__SequenceMessage__SourceAssignment_0 )
            {
             before(grammarAccess.getSequenceMessageAccess().getSourceAssignment_0()); 
            // InternalTextualScenario.g:1556:2: ( rule__SequenceMessage__SourceAssignment_0 )
            // InternalTextualScenario.g:1556:3: rule__SequenceMessage__SourceAssignment_0
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
    // InternalTextualScenario.g:1564:1: rule__SequenceMessage__Group__1 : rule__SequenceMessage__Group__1__Impl rule__SequenceMessage__Group__2 ;
    public final void rule__SequenceMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1568:1: ( rule__SequenceMessage__Group__1__Impl rule__SequenceMessage__Group__2 )
            // InternalTextualScenario.g:1569:2: rule__SequenceMessage__Group__1__Impl rule__SequenceMessage__Group__2
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
    // InternalTextualScenario.g:1576:1: rule__SequenceMessage__Group__1__Impl : ( ( rule__SequenceMessage__ArrowAssignment_1 ) ) ;
    public final void rule__SequenceMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1580:1: ( ( ( rule__SequenceMessage__ArrowAssignment_1 ) ) )
            // InternalTextualScenario.g:1581:1: ( ( rule__SequenceMessage__ArrowAssignment_1 ) )
            {
            // InternalTextualScenario.g:1581:1: ( ( rule__SequenceMessage__ArrowAssignment_1 ) )
            // InternalTextualScenario.g:1582:2: ( rule__SequenceMessage__ArrowAssignment_1 )
            {
             before(grammarAccess.getSequenceMessageAccess().getArrowAssignment_1()); 
            // InternalTextualScenario.g:1583:2: ( rule__SequenceMessage__ArrowAssignment_1 )
            // InternalTextualScenario.g:1583:3: rule__SequenceMessage__ArrowAssignment_1
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
    // InternalTextualScenario.g:1591:1: rule__SequenceMessage__Group__2 : rule__SequenceMessage__Group__2__Impl rule__SequenceMessage__Group__3 ;
    public final void rule__SequenceMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1595:1: ( rule__SequenceMessage__Group__2__Impl rule__SequenceMessage__Group__3 )
            // InternalTextualScenario.g:1596:2: rule__SequenceMessage__Group__2__Impl rule__SequenceMessage__Group__3
            {
            pushFollow(FOLLOW_9);
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
    // InternalTextualScenario.g:1603:1: rule__SequenceMessage__Group__2__Impl : ( ( rule__SequenceMessage__TargetAssignment_2 ) ) ;
    public final void rule__SequenceMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1607:1: ( ( ( rule__SequenceMessage__TargetAssignment_2 ) ) )
            // InternalTextualScenario.g:1608:1: ( ( rule__SequenceMessage__TargetAssignment_2 ) )
            {
            // InternalTextualScenario.g:1608:1: ( ( rule__SequenceMessage__TargetAssignment_2 ) )
            // InternalTextualScenario.g:1609:2: ( rule__SequenceMessage__TargetAssignment_2 )
            {
             before(grammarAccess.getSequenceMessageAccess().getTargetAssignment_2()); 
            // InternalTextualScenario.g:1610:2: ( rule__SequenceMessage__TargetAssignment_2 )
            // InternalTextualScenario.g:1610:3: rule__SequenceMessage__TargetAssignment_2
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
    // InternalTextualScenario.g:1618:1: rule__SequenceMessage__Group__3 : rule__SequenceMessage__Group__3__Impl rule__SequenceMessage__Group__4 ;
    public final void rule__SequenceMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1622:1: ( rule__SequenceMessage__Group__3__Impl rule__SequenceMessage__Group__4 )
            // InternalTextualScenario.g:1623:2: rule__SequenceMessage__Group__3__Impl rule__SequenceMessage__Group__4
            {
            pushFollow(FOLLOW_9);
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
    // InternalTextualScenario.g:1630:1: rule__SequenceMessage__Group__3__Impl : ( ( rule__SequenceMessage__ExecutionAssignment_3 )? ) ;
    public final void rule__SequenceMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1634:1: ( ( ( rule__SequenceMessage__ExecutionAssignment_3 )? ) )
            // InternalTextualScenario.g:1635:1: ( ( rule__SequenceMessage__ExecutionAssignment_3 )? )
            {
            // InternalTextualScenario.g:1635:1: ( ( rule__SequenceMessage__ExecutionAssignment_3 )? )
            // InternalTextualScenario.g:1636:2: ( rule__SequenceMessage__ExecutionAssignment_3 )?
            {
             before(grammarAccess.getSequenceMessageAccess().getExecutionAssignment_3()); 
            // InternalTextualScenario.g:1637:2: ( rule__SequenceMessage__ExecutionAssignment_3 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==35) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalTextualScenario.g:1637:3: rule__SequenceMessage__ExecutionAssignment_3
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
    // InternalTextualScenario.g:1645:1: rule__SequenceMessage__Group__4 : rule__SequenceMessage__Group__4__Impl rule__SequenceMessage__Group__5 ;
    public final void rule__SequenceMessage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1649:1: ( rule__SequenceMessage__Group__4__Impl rule__SequenceMessage__Group__5 )
            // InternalTextualScenario.g:1650:2: rule__SequenceMessage__Group__4__Impl rule__SequenceMessage__Group__5
            {
            pushFollow(FOLLOW_9);
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
    // InternalTextualScenario.g:1657:1: rule__SequenceMessage__Group__4__Impl : ( ( rule__SequenceMessage__ReturnAssignment_4 )? ) ;
    public final void rule__SequenceMessage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1661:1: ( ( ( rule__SequenceMessage__ReturnAssignment_4 )? ) )
            // InternalTextualScenario.g:1662:1: ( ( rule__SequenceMessage__ReturnAssignment_4 )? )
            {
            // InternalTextualScenario.g:1662:1: ( ( rule__SequenceMessage__ReturnAssignment_4 )? )
            // InternalTextualScenario.g:1663:2: ( rule__SequenceMessage__ReturnAssignment_4 )?
            {
             before(grammarAccess.getSequenceMessageAccess().getReturnAssignment_4()); 
            // InternalTextualScenario.g:1664:2: ( rule__SequenceMessage__ReturnAssignment_4 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==36) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTextualScenario.g:1664:3: rule__SequenceMessage__ReturnAssignment_4
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
    // InternalTextualScenario.g:1672:1: rule__SequenceMessage__Group__5 : rule__SequenceMessage__Group__5__Impl rule__SequenceMessage__Group__6 ;
    public final void rule__SequenceMessage__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1676:1: ( rule__SequenceMessage__Group__5__Impl rule__SequenceMessage__Group__6 )
            // InternalTextualScenario.g:1677:2: rule__SequenceMessage__Group__5__Impl rule__SequenceMessage__Group__6
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
    // InternalTextualScenario.g:1684:1: rule__SequenceMessage__Group__5__Impl : ( ( rule__SequenceMessage__DoubleDotAssignment_5 ) ) ;
    public final void rule__SequenceMessage__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1688:1: ( ( ( rule__SequenceMessage__DoubleDotAssignment_5 ) ) )
            // InternalTextualScenario.g:1689:1: ( ( rule__SequenceMessage__DoubleDotAssignment_5 ) )
            {
            // InternalTextualScenario.g:1689:1: ( ( rule__SequenceMessage__DoubleDotAssignment_5 ) )
            // InternalTextualScenario.g:1690:2: ( rule__SequenceMessage__DoubleDotAssignment_5 )
            {
             before(grammarAccess.getSequenceMessageAccess().getDoubleDotAssignment_5()); 
            // InternalTextualScenario.g:1691:2: ( rule__SequenceMessage__DoubleDotAssignment_5 )
            // InternalTextualScenario.g:1691:3: rule__SequenceMessage__DoubleDotAssignment_5
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
    // InternalTextualScenario.g:1699:1: rule__SequenceMessage__Group__6 : rule__SequenceMessage__Group__6__Impl ;
    public final void rule__SequenceMessage__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1703:1: ( rule__SequenceMessage__Group__6__Impl )
            // InternalTextualScenario.g:1704:2: rule__SequenceMessage__Group__6__Impl
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
    // InternalTextualScenario.g:1710:1: rule__SequenceMessage__Group__6__Impl : ( ( rule__SequenceMessage__NameAssignment_6 ) ) ;
    public final void rule__SequenceMessage__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1714:1: ( ( ( rule__SequenceMessage__NameAssignment_6 ) ) )
            // InternalTextualScenario.g:1715:1: ( ( rule__SequenceMessage__NameAssignment_6 ) )
            {
            // InternalTextualScenario.g:1715:1: ( ( rule__SequenceMessage__NameAssignment_6 ) )
            // InternalTextualScenario.g:1716:2: ( rule__SequenceMessage__NameAssignment_6 )
            {
             before(grammarAccess.getSequenceMessageAccess().getNameAssignment_6()); 
            // InternalTextualScenario.g:1717:2: ( rule__SequenceMessage__NameAssignment_6 )
            // InternalTextualScenario.g:1717:3: rule__SequenceMessage__NameAssignment_6
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
    // InternalTextualScenario.g:1726:1: rule__CreateMessage__Group__0 : rule__CreateMessage__Group__0__Impl rule__CreateMessage__Group__1 ;
    public final void rule__CreateMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1730:1: ( rule__CreateMessage__Group__0__Impl rule__CreateMessage__Group__1 )
            // InternalTextualScenario.g:1731:2: rule__CreateMessage__Group__0__Impl rule__CreateMessage__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalTextualScenario.g:1738:1: rule__CreateMessage__Group__0__Impl : ( ( rule__CreateMessage__SourceAssignment_0 ) ) ;
    public final void rule__CreateMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1742:1: ( ( ( rule__CreateMessage__SourceAssignment_0 ) ) )
            // InternalTextualScenario.g:1743:1: ( ( rule__CreateMessage__SourceAssignment_0 ) )
            {
            // InternalTextualScenario.g:1743:1: ( ( rule__CreateMessage__SourceAssignment_0 ) )
            // InternalTextualScenario.g:1744:2: ( rule__CreateMessage__SourceAssignment_0 )
            {
             before(grammarAccess.getCreateMessageAccess().getSourceAssignment_0()); 
            // InternalTextualScenario.g:1745:2: ( rule__CreateMessage__SourceAssignment_0 )
            // InternalTextualScenario.g:1745:3: rule__CreateMessage__SourceAssignment_0
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
    // InternalTextualScenario.g:1753:1: rule__CreateMessage__Group__1 : rule__CreateMessage__Group__1__Impl rule__CreateMessage__Group__2 ;
    public final void rule__CreateMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1757:1: ( rule__CreateMessage__Group__1__Impl rule__CreateMessage__Group__2 )
            // InternalTextualScenario.g:1758:2: rule__CreateMessage__Group__1__Impl rule__CreateMessage__Group__2
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
    // InternalTextualScenario.g:1765:1: rule__CreateMessage__Group__1__Impl : ( ( rule__CreateMessage__ArrowAssignment_1 ) ) ;
    public final void rule__CreateMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1769:1: ( ( ( rule__CreateMessage__ArrowAssignment_1 ) ) )
            // InternalTextualScenario.g:1770:1: ( ( rule__CreateMessage__ArrowAssignment_1 ) )
            {
            // InternalTextualScenario.g:1770:1: ( ( rule__CreateMessage__ArrowAssignment_1 ) )
            // InternalTextualScenario.g:1771:2: ( rule__CreateMessage__ArrowAssignment_1 )
            {
             before(grammarAccess.getCreateMessageAccess().getArrowAssignment_1()); 
            // InternalTextualScenario.g:1772:2: ( rule__CreateMessage__ArrowAssignment_1 )
            // InternalTextualScenario.g:1772:3: rule__CreateMessage__ArrowAssignment_1
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
    // InternalTextualScenario.g:1780:1: rule__CreateMessage__Group__2 : rule__CreateMessage__Group__2__Impl rule__CreateMessage__Group__3 ;
    public final void rule__CreateMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1784:1: ( rule__CreateMessage__Group__2__Impl rule__CreateMessage__Group__3 )
            // InternalTextualScenario.g:1785:2: rule__CreateMessage__Group__2__Impl rule__CreateMessage__Group__3
            {
            pushFollow(FOLLOW_11);
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
    // InternalTextualScenario.g:1792:1: rule__CreateMessage__Group__2__Impl : ( ( rule__CreateMessage__TargetAssignment_2 ) ) ;
    public final void rule__CreateMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1796:1: ( ( ( rule__CreateMessage__TargetAssignment_2 ) ) )
            // InternalTextualScenario.g:1797:1: ( ( rule__CreateMessage__TargetAssignment_2 ) )
            {
            // InternalTextualScenario.g:1797:1: ( ( rule__CreateMessage__TargetAssignment_2 ) )
            // InternalTextualScenario.g:1798:2: ( rule__CreateMessage__TargetAssignment_2 )
            {
             before(grammarAccess.getCreateMessageAccess().getTargetAssignment_2()); 
            // InternalTextualScenario.g:1799:2: ( rule__CreateMessage__TargetAssignment_2 )
            // InternalTextualScenario.g:1799:3: rule__CreateMessage__TargetAssignment_2
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
    // InternalTextualScenario.g:1807:1: rule__CreateMessage__Group__3 : rule__CreateMessage__Group__3__Impl rule__CreateMessage__Group__4 ;
    public final void rule__CreateMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1811:1: ( rule__CreateMessage__Group__3__Impl rule__CreateMessage__Group__4 )
            // InternalTextualScenario.g:1812:2: rule__CreateMessage__Group__3__Impl rule__CreateMessage__Group__4
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
    // InternalTextualScenario.g:1819:1: rule__CreateMessage__Group__3__Impl : ( ( rule__CreateMessage__DoubleDotAssignment_3 ) ) ;
    public final void rule__CreateMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1823:1: ( ( ( rule__CreateMessage__DoubleDotAssignment_3 ) ) )
            // InternalTextualScenario.g:1824:1: ( ( rule__CreateMessage__DoubleDotAssignment_3 ) )
            {
            // InternalTextualScenario.g:1824:1: ( ( rule__CreateMessage__DoubleDotAssignment_3 ) )
            // InternalTextualScenario.g:1825:2: ( rule__CreateMessage__DoubleDotAssignment_3 )
            {
             before(grammarAccess.getCreateMessageAccess().getDoubleDotAssignment_3()); 
            // InternalTextualScenario.g:1826:2: ( rule__CreateMessage__DoubleDotAssignment_3 )
            // InternalTextualScenario.g:1826:3: rule__CreateMessage__DoubleDotAssignment_3
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
    // InternalTextualScenario.g:1834:1: rule__CreateMessage__Group__4 : rule__CreateMessage__Group__4__Impl ;
    public final void rule__CreateMessage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1838:1: ( rule__CreateMessage__Group__4__Impl )
            // InternalTextualScenario.g:1839:2: rule__CreateMessage__Group__4__Impl
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
    // InternalTextualScenario.g:1845:1: rule__CreateMessage__Group__4__Impl : ( ( rule__CreateMessage__NameAssignment_4 ) ) ;
    public final void rule__CreateMessage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1849:1: ( ( ( rule__CreateMessage__NameAssignment_4 ) ) )
            // InternalTextualScenario.g:1850:1: ( ( rule__CreateMessage__NameAssignment_4 ) )
            {
            // InternalTextualScenario.g:1850:1: ( ( rule__CreateMessage__NameAssignment_4 ) )
            // InternalTextualScenario.g:1851:2: ( rule__CreateMessage__NameAssignment_4 )
            {
             before(grammarAccess.getCreateMessageAccess().getNameAssignment_4()); 
            // InternalTextualScenario.g:1852:2: ( rule__CreateMessage__NameAssignment_4 )
            // InternalTextualScenario.g:1852:3: rule__CreateMessage__NameAssignment_4
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
    // InternalTextualScenario.g:1861:1: rule__DeleteMessage__Group__0 : rule__DeleteMessage__Group__0__Impl rule__DeleteMessage__Group__1 ;
    public final void rule__DeleteMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1865:1: ( rule__DeleteMessage__Group__0__Impl rule__DeleteMessage__Group__1 )
            // InternalTextualScenario.g:1866:2: rule__DeleteMessage__Group__0__Impl rule__DeleteMessage__Group__1
            {
            pushFollow(FOLLOW_12);
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
    // InternalTextualScenario.g:1873:1: rule__DeleteMessage__Group__0__Impl : ( ( rule__DeleteMessage__SourceAssignment_0 ) ) ;
    public final void rule__DeleteMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1877:1: ( ( ( rule__DeleteMessage__SourceAssignment_0 ) ) )
            // InternalTextualScenario.g:1878:1: ( ( rule__DeleteMessage__SourceAssignment_0 ) )
            {
            // InternalTextualScenario.g:1878:1: ( ( rule__DeleteMessage__SourceAssignment_0 ) )
            // InternalTextualScenario.g:1879:2: ( rule__DeleteMessage__SourceAssignment_0 )
            {
             before(grammarAccess.getDeleteMessageAccess().getSourceAssignment_0()); 
            // InternalTextualScenario.g:1880:2: ( rule__DeleteMessage__SourceAssignment_0 )
            // InternalTextualScenario.g:1880:3: rule__DeleteMessage__SourceAssignment_0
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
    // InternalTextualScenario.g:1888:1: rule__DeleteMessage__Group__1 : rule__DeleteMessage__Group__1__Impl rule__DeleteMessage__Group__2 ;
    public final void rule__DeleteMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1892:1: ( rule__DeleteMessage__Group__1__Impl rule__DeleteMessage__Group__2 )
            // InternalTextualScenario.g:1893:2: rule__DeleteMessage__Group__1__Impl rule__DeleteMessage__Group__2
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
    // InternalTextualScenario.g:1900:1: rule__DeleteMessage__Group__1__Impl : ( ( rule__DeleteMessage__ArrowAssignment_1 ) ) ;
    public final void rule__DeleteMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1904:1: ( ( ( rule__DeleteMessage__ArrowAssignment_1 ) ) )
            // InternalTextualScenario.g:1905:1: ( ( rule__DeleteMessage__ArrowAssignment_1 ) )
            {
            // InternalTextualScenario.g:1905:1: ( ( rule__DeleteMessage__ArrowAssignment_1 ) )
            // InternalTextualScenario.g:1906:2: ( rule__DeleteMessage__ArrowAssignment_1 )
            {
             before(grammarAccess.getDeleteMessageAccess().getArrowAssignment_1()); 
            // InternalTextualScenario.g:1907:2: ( rule__DeleteMessage__ArrowAssignment_1 )
            // InternalTextualScenario.g:1907:3: rule__DeleteMessage__ArrowAssignment_1
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
    // InternalTextualScenario.g:1915:1: rule__DeleteMessage__Group__2 : rule__DeleteMessage__Group__2__Impl rule__DeleteMessage__Group__3 ;
    public final void rule__DeleteMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1919:1: ( rule__DeleteMessage__Group__2__Impl rule__DeleteMessage__Group__3 )
            // InternalTextualScenario.g:1920:2: rule__DeleteMessage__Group__2__Impl rule__DeleteMessage__Group__3
            {
            pushFollow(FOLLOW_11);
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
    // InternalTextualScenario.g:1927:1: rule__DeleteMessage__Group__2__Impl : ( ( rule__DeleteMessage__TargetAssignment_2 ) ) ;
    public final void rule__DeleteMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1931:1: ( ( ( rule__DeleteMessage__TargetAssignment_2 ) ) )
            // InternalTextualScenario.g:1932:1: ( ( rule__DeleteMessage__TargetAssignment_2 ) )
            {
            // InternalTextualScenario.g:1932:1: ( ( rule__DeleteMessage__TargetAssignment_2 ) )
            // InternalTextualScenario.g:1933:2: ( rule__DeleteMessage__TargetAssignment_2 )
            {
             before(grammarAccess.getDeleteMessageAccess().getTargetAssignment_2()); 
            // InternalTextualScenario.g:1934:2: ( rule__DeleteMessage__TargetAssignment_2 )
            // InternalTextualScenario.g:1934:3: rule__DeleteMessage__TargetAssignment_2
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
    // InternalTextualScenario.g:1942:1: rule__DeleteMessage__Group__3 : rule__DeleteMessage__Group__3__Impl rule__DeleteMessage__Group__4 ;
    public final void rule__DeleteMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1946:1: ( rule__DeleteMessage__Group__3__Impl rule__DeleteMessage__Group__4 )
            // InternalTextualScenario.g:1947:2: rule__DeleteMessage__Group__3__Impl rule__DeleteMessage__Group__4
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
    // InternalTextualScenario.g:1954:1: rule__DeleteMessage__Group__3__Impl : ( ( rule__DeleteMessage__DoubleDotAssignment_3 ) ) ;
    public final void rule__DeleteMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1958:1: ( ( ( rule__DeleteMessage__DoubleDotAssignment_3 ) ) )
            // InternalTextualScenario.g:1959:1: ( ( rule__DeleteMessage__DoubleDotAssignment_3 ) )
            {
            // InternalTextualScenario.g:1959:1: ( ( rule__DeleteMessage__DoubleDotAssignment_3 ) )
            // InternalTextualScenario.g:1960:2: ( rule__DeleteMessage__DoubleDotAssignment_3 )
            {
             before(grammarAccess.getDeleteMessageAccess().getDoubleDotAssignment_3()); 
            // InternalTextualScenario.g:1961:2: ( rule__DeleteMessage__DoubleDotAssignment_3 )
            // InternalTextualScenario.g:1961:3: rule__DeleteMessage__DoubleDotAssignment_3
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
    // InternalTextualScenario.g:1969:1: rule__DeleteMessage__Group__4 : rule__DeleteMessage__Group__4__Impl ;
    public final void rule__DeleteMessage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1973:1: ( rule__DeleteMessage__Group__4__Impl )
            // InternalTextualScenario.g:1974:2: rule__DeleteMessage__Group__4__Impl
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
    // InternalTextualScenario.g:1980:1: rule__DeleteMessage__Group__4__Impl : ( ( rule__DeleteMessage__NameAssignment_4 ) ) ;
    public final void rule__DeleteMessage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1984:1: ( ( ( rule__DeleteMessage__NameAssignment_4 ) ) )
            // InternalTextualScenario.g:1985:1: ( ( rule__DeleteMessage__NameAssignment_4 ) )
            {
            // InternalTextualScenario.g:1985:1: ( ( rule__DeleteMessage__NameAssignment_4 ) )
            // InternalTextualScenario.g:1986:2: ( rule__DeleteMessage__NameAssignment_4 )
            {
             before(grammarAccess.getDeleteMessageAccess().getNameAssignment_4()); 
            // InternalTextualScenario.g:1987:2: ( rule__DeleteMessage__NameAssignment_4 )
            // InternalTextualScenario.g:1987:3: rule__DeleteMessage__NameAssignment_4
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
    // InternalTextualScenario.g:1996:1: rule__ArmTimerMessage__Group__0 : rule__ArmTimerMessage__Group__0__Impl rule__ArmTimerMessage__Group__1 ;
    public final void rule__ArmTimerMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2000:1: ( rule__ArmTimerMessage__Group__0__Impl rule__ArmTimerMessage__Group__1 )
            // InternalTextualScenario.g:2001:2: rule__ArmTimerMessage__Group__0__Impl rule__ArmTimerMessage__Group__1
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
    // InternalTextualScenario.g:2008:1: rule__ArmTimerMessage__Group__0__Impl : ( ( rule__ArmTimerMessage__ArrowAssignment_0 ) ) ;
    public final void rule__ArmTimerMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2012:1: ( ( ( rule__ArmTimerMessage__ArrowAssignment_0 ) ) )
            // InternalTextualScenario.g:2013:1: ( ( rule__ArmTimerMessage__ArrowAssignment_0 ) )
            {
            // InternalTextualScenario.g:2013:1: ( ( rule__ArmTimerMessage__ArrowAssignment_0 ) )
            // InternalTextualScenario.g:2014:2: ( rule__ArmTimerMessage__ArrowAssignment_0 )
            {
             before(grammarAccess.getArmTimerMessageAccess().getArrowAssignment_0()); 
            // InternalTextualScenario.g:2015:2: ( rule__ArmTimerMessage__ArrowAssignment_0 )
            // InternalTextualScenario.g:2015:3: rule__ArmTimerMessage__ArrowAssignment_0
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
    // InternalTextualScenario.g:2023:1: rule__ArmTimerMessage__Group__1 : rule__ArmTimerMessage__Group__1__Impl rule__ArmTimerMessage__Group__2 ;
    public final void rule__ArmTimerMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2027:1: ( rule__ArmTimerMessage__Group__1__Impl rule__ArmTimerMessage__Group__2 )
            // InternalTextualScenario.g:2028:2: rule__ArmTimerMessage__Group__1__Impl rule__ArmTimerMessage__Group__2
            {
            pushFollow(FOLLOW_13);
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
    // InternalTextualScenario.g:2035:1: rule__ArmTimerMessage__Group__1__Impl : ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) ) ;
    public final void rule__ArmTimerMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2039:1: ( ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) ) )
            // InternalTextualScenario.g:2040:1: ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) )
            {
            // InternalTextualScenario.g:2040:1: ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) )
            // InternalTextualScenario.g:2041:2: ( rule__ArmTimerMessage__ParticipantAssignment_1 )
            {
             before(grammarAccess.getArmTimerMessageAccess().getParticipantAssignment_1()); 
            // InternalTextualScenario.g:2042:2: ( rule__ArmTimerMessage__ParticipantAssignment_1 )
            // InternalTextualScenario.g:2042:3: rule__ArmTimerMessage__ParticipantAssignment_1
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
    // InternalTextualScenario.g:2050:1: rule__ArmTimerMessage__Group__2 : rule__ArmTimerMessage__Group__2__Impl rule__ArmTimerMessage__Group__3 ;
    public final void rule__ArmTimerMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2054:1: ( rule__ArmTimerMessage__Group__2__Impl rule__ArmTimerMessage__Group__3 )
            // InternalTextualScenario.g:2055:2: rule__ArmTimerMessage__Group__2__Impl rule__ArmTimerMessage__Group__3
            {
            pushFollow(FOLLOW_13);
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
    // InternalTextualScenario.g:2062:1: rule__ArmTimerMessage__Group__2__Impl : ( ( rule__ArmTimerMessage__ExecutionAssignment_2 )? ) ;
    public final void rule__ArmTimerMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2066:1: ( ( ( rule__ArmTimerMessage__ExecutionAssignment_2 )? ) )
            // InternalTextualScenario.g:2067:1: ( ( rule__ArmTimerMessage__ExecutionAssignment_2 )? )
            {
            // InternalTextualScenario.g:2067:1: ( ( rule__ArmTimerMessage__ExecutionAssignment_2 )? )
            // InternalTextualScenario.g:2068:2: ( rule__ArmTimerMessage__ExecutionAssignment_2 )?
            {
             before(grammarAccess.getArmTimerMessageAccess().getExecutionAssignment_2()); 
            // InternalTextualScenario.g:2069:2: ( rule__ArmTimerMessage__ExecutionAssignment_2 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==35) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalTextualScenario.g:2069:3: rule__ArmTimerMessage__ExecutionAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__ArmTimerMessage__ExecutionAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getArmTimerMessageAccess().getExecutionAssignment_2()); 

            }


            }

        }
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
    // InternalTextualScenario.g:2077:1: rule__ArmTimerMessage__Group__3 : rule__ArmTimerMessage__Group__3__Impl rule__ArmTimerMessage__Group__4 ;
    public final void rule__ArmTimerMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2081:1: ( rule__ArmTimerMessage__Group__3__Impl rule__ArmTimerMessage__Group__4 )
            // InternalTextualScenario.g:2082:2: rule__ArmTimerMessage__Group__3__Impl rule__ArmTimerMessage__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__ArmTimerMessage__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArmTimerMessage__Group__4();

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
    // InternalTextualScenario.g:2089:1: rule__ArmTimerMessage__Group__3__Impl : ( ( rule__ArmTimerMessage__DoubleDotAssignment_3 ) ) ;
    public final void rule__ArmTimerMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2093:1: ( ( ( rule__ArmTimerMessage__DoubleDotAssignment_3 ) ) )
            // InternalTextualScenario.g:2094:1: ( ( rule__ArmTimerMessage__DoubleDotAssignment_3 ) )
            {
            // InternalTextualScenario.g:2094:1: ( ( rule__ArmTimerMessage__DoubleDotAssignment_3 ) )
            // InternalTextualScenario.g:2095:2: ( rule__ArmTimerMessage__DoubleDotAssignment_3 )
            {
             before(grammarAccess.getArmTimerMessageAccess().getDoubleDotAssignment_3()); 
            // InternalTextualScenario.g:2096:2: ( rule__ArmTimerMessage__DoubleDotAssignment_3 )
            // InternalTextualScenario.g:2096:3: rule__ArmTimerMessage__DoubleDotAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ArmTimerMessage__DoubleDotAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getArmTimerMessageAccess().getDoubleDotAssignment_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__ArmTimerMessage__Group__4"
    // InternalTextualScenario.g:2104:1: rule__ArmTimerMessage__Group__4 : rule__ArmTimerMessage__Group__4__Impl ;
    public final void rule__ArmTimerMessage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2108:1: ( rule__ArmTimerMessage__Group__4__Impl )
            // InternalTextualScenario.g:2109:2: rule__ArmTimerMessage__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArmTimerMessage__Group__4__Impl();

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
    // $ANTLR end "rule__ArmTimerMessage__Group__4"


    // $ANTLR start "rule__ArmTimerMessage__Group__4__Impl"
    // InternalTextualScenario.g:2115:1: rule__ArmTimerMessage__Group__4__Impl : ( ( rule__ArmTimerMessage__NameAssignment_4 ) ) ;
    public final void rule__ArmTimerMessage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2119:1: ( ( ( rule__ArmTimerMessage__NameAssignment_4 ) ) )
            // InternalTextualScenario.g:2120:1: ( ( rule__ArmTimerMessage__NameAssignment_4 ) )
            {
            // InternalTextualScenario.g:2120:1: ( ( rule__ArmTimerMessage__NameAssignment_4 ) )
            // InternalTextualScenario.g:2121:2: ( rule__ArmTimerMessage__NameAssignment_4 )
            {
             before(grammarAccess.getArmTimerMessageAccess().getNameAssignment_4()); 
            // InternalTextualScenario.g:2122:2: ( rule__ArmTimerMessage__NameAssignment_4 )
            // InternalTextualScenario.g:2122:3: rule__ArmTimerMessage__NameAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ArmTimerMessage__NameAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getArmTimerMessageAccess().getNameAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArmTimerMessage__Group__4__Impl"


    // $ANTLR start "rule__LostMessage__Group__0"
    // InternalTextualScenario.g:2131:1: rule__LostMessage__Group__0 : rule__LostMessage__Group__0__Impl rule__LostMessage__Group__1 ;
    public final void rule__LostMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2135:1: ( rule__LostMessage__Group__0__Impl rule__LostMessage__Group__1 )
            // InternalTextualScenario.g:2136:2: rule__LostMessage__Group__0__Impl rule__LostMessage__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__LostMessage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LostMessage__Group__1();

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
    // $ANTLR end "rule__LostMessage__Group__0"


    // $ANTLR start "rule__LostMessage__Group__0__Impl"
    // InternalTextualScenario.g:2143:1: rule__LostMessage__Group__0__Impl : ( ( rule__LostMessage__ArrowAssignment_0 ) ) ;
    public final void rule__LostMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2147:1: ( ( ( rule__LostMessage__ArrowAssignment_0 ) ) )
            // InternalTextualScenario.g:2148:1: ( ( rule__LostMessage__ArrowAssignment_0 ) )
            {
            // InternalTextualScenario.g:2148:1: ( ( rule__LostMessage__ArrowAssignment_0 ) )
            // InternalTextualScenario.g:2149:2: ( rule__LostMessage__ArrowAssignment_0 )
            {
             before(grammarAccess.getLostMessageAccess().getArrowAssignment_0()); 
            // InternalTextualScenario.g:2150:2: ( rule__LostMessage__ArrowAssignment_0 )
            // InternalTextualScenario.g:2150:3: rule__LostMessage__ArrowAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__LostMessage__ArrowAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getLostMessageAccess().getArrowAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LostMessage__Group__0__Impl"


    // $ANTLR start "rule__LostMessage__Group__1"
    // InternalTextualScenario.g:2158:1: rule__LostMessage__Group__1 : rule__LostMessage__Group__1__Impl rule__LostMessage__Group__2 ;
    public final void rule__LostMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2162:1: ( rule__LostMessage__Group__1__Impl rule__LostMessage__Group__2 )
            // InternalTextualScenario.g:2163:2: rule__LostMessage__Group__1__Impl rule__LostMessage__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__LostMessage__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LostMessage__Group__2();

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
    // $ANTLR end "rule__LostMessage__Group__1"


    // $ANTLR start "rule__LostMessage__Group__1__Impl"
    // InternalTextualScenario.g:2170:1: rule__LostMessage__Group__1__Impl : ( ( rule__LostMessage__ParticipantAssignment_1 ) ) ;
    public final void rule__LostMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2174:1: ( ( ( rule__LostMessage__ParticipantAssignment_1 ) ) )
            // InternalTextualScenario.g:2175:1: ( ( rule__LostMessage__ParticipantAssignment_1 ) )
            {
            // InternalTextualScenario.g:2175:1: ( ( rule__LostMessage__ParticipantAssignment_1 ) )
            // InternalTextualScenario.g:2176:2: ( rule__LostMessage__ParticipantAssignment_1 )
            {
             before(grammarAccess.getLostMessageAccess().getParticipantAssignment_1()); 
            // InternalTextualScenario.g:2177:2: ( rule__LostMessage__ParticipantAssignment_1 )
            // InternalTextualScenario.g:2177:3: rule__LostMessage__ParticipantAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__LostMessage__ParticipantAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLostMessageAccess().getParticipantAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LostMessage__Group__1__Impl"


    // $ANTLR start "rule__LostMessage__Group__2"
    // InternalTextualScenario.g:2185:1: rule__LostMessage__Group__2 : rule__LostMessage__Group__2__Impl rule__LostMessage__Group__3 ;
    public final void rule__LostMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2189:1: ( rule__LostMessage__Group__2__Impl rule__LostMessage__Group__3 )
            // InternalTextualScenario.g:2190:2: rule__LostMessage__Group__2__Impl rule__LostMessage__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__LostMessage__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LostMessage__Group__3();

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
    // $ANTLR end "rule__LostMessage__Group__2"


    // $ANTLR start "rule__LostMessage__Group__2__Impl"
    // InternalTextualScenario.g:2197:1: rule__LostMessage__Group__2__Impl : ( ( rule__LostMessage__DoubleDotAssignment_2 ) ) ;
    public final void rule__LostMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2201:1: ( ( ( rule__LostMessage__DoubleDotAssignment_2 ) ) )
            // InternalTextualScenario.g:2202:1: ( ( rule__LostMessage__DoubleDotAssignment_2 ) )
            {
            // InternalTextualScenario.g:2202:1: ( ( rule__LostMessage__DoubleDotAssignment_2 ) )
            // InternalTextualScenario.g:2203:2: ( rule__LostMessage__DoubleDotAssignment_2 )
            {
             before(grammarAccess.getLostMessageAccess().getDoubleDotAssignment_2()); 
            // InternalTextualScenario.g:2204:2: ( rule__LostMessage__DoubleDotAssignment_2 )
            // InternalTextualScenario.g:2204:3: rule__LostMessage__DoubleDotAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__LostMessage__DoubleDotAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLostMessageAccess().getDoubleDotAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LostMessage__Group__2__Impl"


    // $ANTLR start "rule__LostMessage__Group__3"
    // InternalTextualScenario.g:2212:1: rule__LostMessage__Group__3 : rule__LostMessage__Group__3__Impl ;
    public final void rule__LostMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2216:1: ( rule__LostMessage__Group__3__Impl )
            // InternalTextualScenario.g:2217:2: rule__LostMessage__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LostMessage__Group__3__Impl();

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
    // $ANTLR end "rule__LostMessage__Group__3"


    // $ANTLR start "rule__LostMessage__Group__3__Impl"
    // InternalTextualScenario.g:2223:1: rule__LostMessage__Group__3__Impl : ( ( rule__LostMessage__NameAssignment_3 ) ) ;
    public final void rule__LostMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2227:1: ( ( ( rule__LostMessage__NameAssignment_3 ) ) )
            // InternalTextualScenario.g:2228:1: ( ( rule__LostMessage__NameAssignment_3 ) )
            {
            // InternalTextualScenario.g:2228:1: ( ( rule__LostMessage__NameAssignment_3 ) )
            // InternalTextualScenario.g:2229:2: ( rule__LostMessage__NameAssignment_3 )
            {
             before(grammarAccess.getLostMessageAccess().getNameAssignment_3()); 
            // InternalTextualScenario.g:2230:2: ( rule__LostMessage__NameAssignment_3 )
            // InternalTextualScenario.g:2230:3: rule__LostMessage__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__LostMessage__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getLostMessageAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LostMessage__Group__3__Impl"


    // $ANTLR start "rule__FoundMessage__Group__0"
    // InternalTextualScenario.g:2239:1: rule__FoundMessage__Group__0 : rule__FoundMessage__Group__0__Impl rule__FoundMessage__Group__1 ;
    public final void rule__FoundMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2243:1: ( rule__FoundMessage__Group__0__Impl rule__FoundMessage__Group__1 )
            // InternalTextualScenario.g:2244:2: rule__FoundMessage__Group__0__Impl rule__FoundMessage__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__FoundMessage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FoundMessage__Group__1();

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
    // $ANTLR end "rule__FoundMessage__Group__0"


    // $ANTLR start "rule__FoundMessage__Group__0__Impl"
    // InternalTextualScenario.g:2251:1: rule__FoundMessage__Group__0__Impl : ( ( rule__FoundMessage__ArrowAssignment_0 ) ) ;
    public final void rule__FoundMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2255:1: ( ( ( rule__FoundMessage__ArrowAssignment_0 ) ) )
            // InternalTextualScenario.g:2256:1: ( ( rule__FoundMessage__ArrowAssignment_0 ) )
            {
            // InternalTextualScenario.g:2256:1: ( ( rule__FoundMessage__ArrowAssignment_0 ) )
            // InternalTextualScenario.g:2257:2: ( rule__FoundMessage__ArrowAssignment_0 )
            {
             before(grammarAccess.getFoundMessageAccess().getArrowAssignment_0()); 
            // InternalTextualScenario.g:2258:2: ( rule__FoundMessage__ArrowAssignment_0 )
            // InternalTextualScenario.g:2258:3: rule__FoundMessage__ArrowAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__FoundMessage__ArrowAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFoundMessageAccess().getArrowAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FoundMessage__Group__0__Impl"


    // $ANTLR start "rule__FoundMessage__Group__1"
    // InternalTextualScenario.g:2266:1: rule__FoundMessage__Group__1 : rule__FoundMessage__Group__1__Impl rule__FoundMessage__Group__2 ;
    public final void rule__FoundMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2270:1: ( rule__FoundMessage__Group__1__Impl rule__FoundMessage__Group__2 )
            // InternalTextualScenario.g:2271:2: rule__FoundMessage__Group__1__Impl rule__FoundMessage__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__FoundMessage__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FoundMessage__Group__2();

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
    // $ANTLR end "rule__FoundMessage__Group__1"


    // $ANTLR start "rule__FoundMessage__Group__1__Impl"
    // InternalTextualScenario.g:2278:1: rule__FoundMessage__Group__1__Impl : ( ( rule__FoundMessage__ParticipantAssignment_1 ) ) ;
    public final void rule__FoundMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2282:1: ( ( ( rule__FoundMessage__ParticipantAssignment_1 ) ) )
            // InternalTextualScenario.g:2283:1: ( ( rule__FoundMessage__ParticipantAssignment_1 ) )
            {
            // InternalTextualScenario.g:2283:1: ( ( rule__FoundMessage__ParticipantAssignment_1 ) )
            // InternalTextualScenario.g:2284:2: ( rule__FoundMessage__ParticipantAssignment_1 )
            {
             before(grammarAccess.getFoundMessageAccess().getParticipantAssignment_1()); 
            // InternalTextualScenario.g:2285:2: ( rule__FoundMessage__ParticipantAssignment_1 )
            // InternalTextualScenario.g:2285:3: rule__FoundMessage__ParticipantAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FoundMessage__ParticipantAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFoundMessageAccess().getParticipantAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FoundMessage__Group__1__Impl"


    // $ANTLR start "rule__FoundMessage__Group__2"
    // InternalTextualScenario.g:2293:1: rule__FoundMessage__Group__2 : rule__FoundMessage__Group__2__Impl rule__FoundMessage__Group__3 ;
    public final void rule__FoundMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2297:1: ( rule__FoundMessage__Group__2__Impl rule__FoundMessage__Group__3 )
            // InternalTextualScenario.g:2298:2: rule__FoundMessage__Group__2__Impl rule__FoundMessage__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__FoundMessage__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FoundMessage__Group__3();

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
    // $ANTLR end "rule__FoundMessage__Group__2"


    // $ANTLR start "rule__FoundMessage__Group__2__Impl"
    // InternalTextualScenario.g:2305:1: rule__FoundMessage__Group__2__Impl : ( ( rule__FoundMessage__DoubleDotAssignment_2 ) ) ;
    public final void rule__FoundMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2309:1: ( ( ( rule__FoundMessage__DoubleDotAssignment_2 ) ) )
            // InternalTextualScenario.g:2310:1: ( ( rule__FoundMessage__DoubleDotAssignment_2 ) )
            {
            // InternalTextualScenario.g:2310:1: ( ( rule__FoundMessage__DoubleDotAssignment_2 ) )
            // InternalTextualScenario.g:2311:2: ( rule__FoundMessage__DoubleDotAssignment_2 )
            {
             before(grammarAccess.getFoundMessageAccess().getDoubleDotAssignment_2()); 
            // InternalTextualScenario.g:2312:2: ( rule__FoundMessage__DoubleDotAssignment_2 )
            // InternalTextualScenario.g:2312:3: rule__FoundMessage__DoubleDotAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__FoundMessage__DoubleDotAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFoundMessageAccess().getDoubleDotAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FoundMessage__Group__2__Impl"


    // $ANTLR start "rule__FoundMessage__Group__3"
    // InternalTextualScenario.g:2320:1: rule__FoundMessage__Group__3 : rule__FoundMessage__Group__3__Impl ;
    public final void rule__FoundMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2324:1: ( rule__FoundMessage__Group__3__Impl )
            // InternalTextualScenario.g:2325:2: rule__FoundMessage__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FoundMessage__Group__3__Impl();

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
    // $ANTLR end "rule__FoundMessage__Group__3"


    // $ANTLR start "rule__FoundMessage__Group__3__Impl"
    // InternalTextualScenario.g:2331:1: rule__FoundMessage__Group__3__Impl : ( ( rule__FoundMessage__NameAssignment_3 ) ) ;
    public final void rule__FoundMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2335:1: ( ( ( rule__FoundMessage__NameAssignment_3 ) ) )
            // InternalTextualScenario.g:2336:1: ( ( rule__FoundMessage__NameAssignment_3 ) )
            {
            // InternalTextualScenario.g:2336:1: ( ( rule__FoundMessage__NameAssignment_3 ) )
            // InternalTextualScenario.g:2337:2: ( rule__FoundMessage__NameAssignment_3 )
            {
             before(grammarAccess.getFoundMessageAccess().getNameAssignment_3()); 
            // InternalTextualScenario.g:2338:2: ( rule__FoundMessage__NameAssignment_3 )
            // InternalTextualScenario.g:2338:3: rule__FoundMessage__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__FoundMessage__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getFoundMessageAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FoundMessage__Group__3__Impl"


    // $ANTLR start "rule__ParticipantDeactivation__Group__0"
    // InternalTextualScenario.g:2347:1: rule__ParticipantDeactivation__Group__0 : rule__ParticipantDeactivation__Group__0__Impl rule__ParticipantDeactivation__Group__1 ;
    public final void rule__ParticipantDeactivation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2351:1: ( rule__ParticipantDeactivation__Group__0__Impl rule__ParticipantDeactivation__Group__1 )
            // InternalTextualScenario.g:2352:2: rule__ParticipantDeactivation__Group__0__Impl rule__ParticipantDeactivation__Group__1
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
    // InternalTextualScenario.g:2359:1: rule__ParticipantDeactivation__Group__0__Impl : ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) ) ;
    public final void rule__ParticipantDeactivation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2363:1: ( ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:2364:1: ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:2364:1: ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:2365:2: ( rule__ParticipantDeactivation__KeywordAssignment_0 )
            {
             before(grammarAccess.getParticipantDeactivationAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:2366:2: ( rule__ParticipantDeactivation__KeywordAssignment_0 )
            // InternalTextualScenario.g:2366:3: rule__ParticipantDeactivation__KeywordAssignment_0
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
    // InternalTextualScenario.g:2374:1: rule__ParticipantDeactivation__Group__1 : rule__ParticipantDeactivation__Group__1__Impl ;
    public final void rule__ParticipantDeactivation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2378:1: ( rule__ParticipantDeactivation__Group__1__Impl )
            // InternalTextualScenario.g:2379:2: rule__ParticipantDeactivation__Group__1__Impl
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
    // InternalTextualScenario.g:2385:1: rule__ParticipantDeactivation__Group__1__Impl : ( ( rule__ParticipantDeactivation__NameAssignment_1 ) ) ;
    public final void rule__ParticipantDeactivation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2389:1: ( ( ( rule__ParticipantDeactivation__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:2390:1: ( ( rule__ParticipantDeactivation__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:2390:1: ( ( rule__ParticipantDeactivation__NameAssignment_1 ) )
            // InternalTextualScenario.g:2391:2: ( rule__ParticipantDeactivation__NameAssignment_1 )
            {
             before(grammarAccess.getParticipantDeactivationAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:2392:2: ( rule__ParticipantDeactivation__NameAssignment_1 )
            // InternalTextualScenario.g:2392:3: rule__ParticipantDeactivation__NameAssignment_1
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


    // $ANTLR start "rule__CombinedFragment__Group__0"
    // InternalTextualScenario.g:2401:1: rule__CombinedFragment__Group__0 : rule__CombinedFragment__Group__0__Impl rule__CombinedFragment__Group__1 ;
    public final void rule__CombinedFragment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2405:1: ( rule__CombinedFragment__Group__0__Impl rule__CombinedFragment__Group__1 )
            // InternalTextualScenario.g:2406:2: rule__CombinedFragment__Group__0__Impl rule__CombinedFragment__Group__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalTextualScenario.g:2413:1: rule__CombinedFragment__Group__0__Impl : ( ( rule__CombinedFragment__KeywordAssignment_0 ) ) ;
    public final void rule__CombinedFragment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2417:1: ( ( ( rule__CombinedFragment__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:2418:1: ( ( rule__CombinedFragment__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:2418:1: ( ( rule__CombinedFragment__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:2419:2: ( rule__CombinedFragment__KeywordAssignment_0 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:2420:2: ( rule__CombinedFragment__KeywordAssignment_0 )
            // InternalTextualScenario.g:2420:3: rule__CombinedFragment__KeywordAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__CombinedFragment__KeywordAssignment_0();

            state._fsp--;


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
    // InternalTextualScenario.g:2428:1: rule__CombinedFragment__Group__1 : rule__CombinedFragment__Group__1__Impl rule__CombinedFragment__Group__2 ;
    public final void rule__CombinedFragment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2432:1: ( rule__CombinedFragment__Group__1__Impl rule__CombinedFragment__Group__2 )
            // InternalTextualScenario.g:2433:2: rule__CombinedFragment__Group__1__Impl rule__CombinedFragment__Group__2
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
    // InternalTextualScenario.g:2440:1: rule__CombinedFragment__Group__1__Impl : ( ( rule__CombinedFragment__ExpressionAssignment_1 )? ) ;
    public final void rule__CombinedFragment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2444:1: ( ( ( rule__CombinedFragment__ExpressionAssignment_1 )? ) )
            // InternalTextualScenario.g:2445:1: ( ( rule__CombinedFragment__ExpressionAssignment_1 )? )
            {
            // InternalTextualScenario.g:2445:1: ( ( rule__CombinedFragment__ExpressionAssignment_1 )? )
            // InternalTextualScenario.g:2446:2: ( rule__CombinedFragment__ExpressionAssignment_1 )?
            {
             before(grammarAccess.getCombinedFragmentAccess().getExpressionAssignment_1()); 
            // InternalTextualScenario.g:2447:2: ( rule__CombinedFragment__ExpressionAssignment_1 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_STRING) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalTextualScenario.g:2447:3: rule__CombinedFragment__ExpressionAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__CombinedFragment__ExpressionAssignment_1();

                    state._fsp--;


                    }
                    break;

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
    // InternalTextualScenario.g:2455:1: rule__CombinedFragment__Group__2 : rule__CombinedFragment__Group__2__Impl rule__CombinedFragment__Group__3 ;
    public final void rule__CombinedFragment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2459:1: ( rule__CombinedFragment__Group__2__Impl rule__CombinedFragment__Group__3 )
            // InternalTextualScenario.g:2460:2: rule__CombinedFragment__Group__2__Impl rule__CombinedFragment__Group__3
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
    // InternalTextualScenario.g:2467:1: rule__CombinedFragment__Group__2__Impl : ( ( rule__CombinedFragment__OverAssignment_2 ) ) ;
    public final void rule__CombinedFragment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2471:1: ( ( ( rule__CombinedFragment__OverAssignment_2 ) ) )
            // InternalTextualScenario.g:2472:1: ( ( rule__CombinedFragment__OverAssignment_2 ) )
            {
            // InternalTextualScenario.g:2472:1: ( ( rule__CombinedFragment__OverAssignment_2 ) )
            // InternalTextualScenario.g:2473:2: ( rule__CombinedFragment__OverAssignment_2 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getOverAssignment_2()); 
            // InternalTextualScenario.g:2474:2: ( rule__CombinedFragment__OverAssignment_2 )
            // InternalTextualScenario.g:2474:3: rule__CombinedFragment__OverAssignment_2
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
    // InternalTextualScenario.g:2482:1: rule__CombinedFragment__Group__3 : rule__CombinedFragment__Group__3__Impl rule__CombinedFragment__Group__4 ;
    public final void rule__CombinedFragment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2486:1: ( rule__CombinedFragment__Group__3__Impl rule__CombinedFragment__Group__4 )
            // InternalTextualScenario.g:2487:2: rule__CombinedFragment__Group__3__Impl rule__CombinedFragment__Group__4
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
    // InternalTextualScenario.g:2494:1: rule__CombinedFragment__Group__3__Impl : ( ( ( rule__CombinedFragment__TimelinesAssignment_3 ) ) ( ( rule__CombinedFragment__TimelinesAssignment_3 )* ) ) ;
    public final void rule__CombinedFragment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2498:1: ( ( ( ( rule__CombinedFragment__TimelinesAssignment_3 ) ) ( ( rule__CombinedFragment__TimelinesAssignment_3 )* ) ) )
            // InternalTextualScenario.g:2499:1: ( ( ( rule__CombinedFragment__TimelinesAssignment_3 ) ) ( ( rule__CombinedFragment__TimelinesAssignment_3 )* ) )
            {
            // InternalTextualScenario.g:2499:1: ( ( ( rule__CombinedFragment__TimelinesAssignment_3 ) ) ( ( rule__CombinedFragment__TimelinesAssignment_3 )* ) )
            // InternalTextualScenario.g:2500:2: ( ( rule__CombinedFragment__TimelinesAssignment_3 ) ) ( ( rule__CombinedFragment__TimelinesAssignment_3 )* )
            {
            // InternalTextualScenario.g:2500:2: ( ( rule__CombinedFragment__TimelinesAssignment_3 ) )
            // InternalTextualScenario.g:2501:3: ( rule__CombinedFragment__TimelinesAssignment_3 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getTimelinesAssignment_3()); 
            // InternalTextualScenario.g:2502:3: ( rule__CombinedFragment__TimelinesAssignment_3 )
            // InternalTextualScenario.g:2502:4: rule__CombinedFragment__TimelinesAssignment_3
            {
            pushFollow(FOLLOW_15);
            rule__CombinedFragment__TimelinesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCombinedFragmentAccess().getTimelinesAssignment_3()); 

            }

            // InternalTextualScenario.g:2505:2: ( ( rule__CombinedFragment__TimelinesAssignment_3 )* )
            // InternalTextualScenario.g:2506:3: ( rule__CombinedFragment__TimelinesAssignment_3 )*
            {
             before(grammarAccess.getCombinedFragmentAccess().getTimelinesAssignment_3()); 
            // InternalTextualScenario.g:2507:3: ( rule__CombinedFragment__TimelinesAssignment_3 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_STRING) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalTextualScenario.g:2507:4: rule__CombinedFragment__TimelinesAssignment_3
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__CombinedFragment__TimelinesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalTextualScenario.g:2516:1: rule__CombinedFragment__Group__4 : rule__CombinedFragment__Group__4__Impl rule__CombinedFragment__Group__5 ;
    public final void rule__CombinedFragment__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2520:1: ( rule__CombinedFragment__Group__4__Impl rule__CombinedFragment__Group__5 )
            // InternalTextualScenario.g:2521:2: rule__CombinedFragment__Group__4__Impl rule__CombinedFragment__Group__5
            {
            pushFollow(FOLLOW_16);
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
    // InternalTextualScenario.g:2528:1: rule__CombinedFragment__Group__4__Impl : ( ( rule__CombinedFragment__BlockAssignment_4 ) ) ;
    public final void rule__CombinedFragment__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2532:1: ( ( ( rule__CombinedFragment__BlockAssignment_4 ) ) )
            // InternalTextualScenario.g:2533:1: ( ( rule__CombinedFragment__BlockAssignment_4 ) )
            {
            // InternalTextualScenario.g:2533:1: ( ( rule__CombinedFragment__BlockAssignment_4 ) )
            // InternalTextualScenario.g:2534:2: ( rule__CombinedFragment__BlockAssignment_4 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getBlockAssignment_4()); 
            // InternalTextualScenario.g:2535:2: ( rule__CombinedFragment__BlockAssignment_4 )
            // InternalTextualScenario.g:2535:3: rule__CombinedFragment__BlockAssignment_4
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
    // InternalTextualScenario.g:2543:1: rule__CombinedFragment__Group__5 : rule__CombinedFragment__Group__5__Impl ;
    public final void rule__CombinedFragment__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2547:1: ( rule__CombinedFragment__Group__5__Impl )
            // InternalTextualScenario.g:2548:2: rule__CombinedFragment__Group__5__Impl
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
    // InternalTextualScenario.g:2554:1: rule__CombinedFragment__Group__5__Impl : ( ( rule__CombinedFragment__OperandsAssignment_5 )* ) ;
    public final void rule__CombinedFragment__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2558:1: ( ( ( rule__CombinedFragment__OperandsAssignment_5 )* ) )
            // InternalTextualScenario.g:2559:1: ( ( rule__CombinedFragment__OperandsAssignment_5 )* )
            {
            // InternalTextualScenario.g:2559:1: ( ( rule__CombinedFragment__OperandsAssignment_5 )* )
            // InternalTextualScenario.g:2560:2: ( rule__CombinedFragment__OperandsAssignment_5 )*
            {
             before(grammarAccess.getCombinedFragmentAccess().getOperandsAssignment_5()); 
            // InternalTextualScenario.g:2561:2: ( rule__CombinedFragment__OperandsAssignment_5 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_STRING) ) {
                    int LA17_2 = input.LA(2);

                    if ( (LA17_2==26) ) {
                        alt17=1;
                    }


                }
                else if ( (LA17_0==26||LA17_0==45) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalTextualScenario.g:2561:3: rule__CombinedFragment__OperandsAssignment_5
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__CombinedFragment__OperandsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalTextualScenario.g:2570:1: rule__Operand__Group__0 : rule__Operand__Group__0__Impl rule__Operand__Group__1 ;
    public final void rule__Operand__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2574:1: ( rule__Operand__Group__0__Impl rule__Operand__Group__1 )
            // InternalTextualScenario.g:2575:2: rule__Operand__Group__0__Impl rule__Operand__Group__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalTextualScenario.g:2582:1: rule__Operand__Group__0__Impl : ( ( rule__Operand__KeywordAssignment_0 )? ) ;
    public final void rule__Operand__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2586:1: ( ( ( rule__Operand__KeywordAssignment_0 )? ) )
            // InternalTextualScenario.g:2587:1: ( ( rule__Operand__KeywordAssignment_0 )? )
            {
            // InternalTextualScenario.g:2587:1: ( ( rule__Operand__KeywordAssignment_0 )? )
            // InternalTextualScenario.g:2588:2: ( rule__Operand__KeywordAssignment_0 )?
            {
             before(grammarAccess.getOperandAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:2589:2: ( rule__Operand__KeywordAssignment_0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==45) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalTextualScenario.g:2589:3: rule__Operand__KeywordAssignment_0
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
    // InternalTextualScenario.g:2597:1: rule__Operand__Group__1 : rule__Operand__Group__1__Impl rule__Operand__Group__2 ;
    public final void rule__Operand__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2601:1: ( rule__Operand__Group__1__Impl rule__Operand__Group__2 )
            // InternalTextualScenario.g:2602:2: rule__Operand__Group__1__Impl rule__Operand__Group__2
            {
            pushFollow(FOLLOW_16);
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
    // InternalTextualScenario.g:2609:1: rule__Operand__Group__1__Impl : ( ( rule__Operand__ExpressionAssignment_1 )? ) ;
    public final void rule__Operand__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2613:1: ( ( ( rule__Operand__ExpressionAssignment_1 )? ) )
            // InternalTextualScenario.g:2614:1: ( ( rule__Operand__ExpressionAssignment_1 )? )
            {
            // InternalTextualScenario.g:2614:1: ( ( rule__Operand__ExpressionAssignment_1 )? )
            // InternalTextualScenario.g:2615:2: ( rule__Operand__ExpressionAssignment_1 )?
            {
             before(grammarAccess.getOperandAccess().getExpressionAssignment_1()); 
            // InternalTextualScenario.g:2616:2: ( rule__Operand__ExpressionAssignment_1 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_STRING) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalTextualScenario.g:2616:3: rule__Operand__ExpressionAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Operand__ExpressionAssignment_1();

                    state._fsp--;


                    }
                    break;

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
    // InternalTextualScenario.g:2624:1: rule__Operand__Group__2 : rule__Operand__Group__2__Impl ;
    public final void rule__Operand__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2628:1: ( rule__Operand__Group__2__Impl )
            // InternalTextualScenario.g:2629:2: rule__Operand__Group__2__Impl
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
    // InternalTextualScenario.g:2635:1: rule__Operand__Group__2__Impl : ( ( rule__Operand__BlockAssignment_2 ) ) ;
    public final void rule__Operand__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2639:1: ( ( ( rule__Operand__BlockAssignment_2 ) ) )
            // InternalTextualScenario.g:2640:1: ( ( rule__Operand__BlockAssignment_2 ) )
            {
            // InternalTextualScenario.g:2640:1: ( ( rule__Operand__BlockAssignment_2 ) )
            // InternalTextualScenario.g:2641:2: ( rule__Operand__BlockAssignment_2 )
            {
             before(grammarAccess.getOperandAccess().getBlockAssignment_2()); 
            // InternalTextualScenario.g:2642:2: ( rule__Operand__BlockAssignment_2 )
            // InternalTextualScenario.g:2642:3: rule__Operand__BlockAssignment_2
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
    // InternalTextualScenario.g:2651:1: rule__Block__Group__0 : rule__Block__Group__0__Impl rule__Block__Group__1 ;
    public final void rule__Block__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2655:1: ( rule__Block__Group__0__Impl rule__Block__Group__1 )
            // InternalTextualScenario.g:2656:2: rule__Block__Group__0__Impl rule__Block__Group__1
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
    // InternalTextualScenario.g:2663:1: rule__Block__Group__0__Impl : ( ( rule__Block__BeginAssignment_0 ) ) ;
    public final void rule__Block__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2667:1: ( ( ( rule__Block__BeginAssignment_0 ) ) )
            // InternalTextualScenario.g:2668:1: ( ( rule__Block__BeginAssignment_0 ) )
            {
            // InternalTextualScenario.g:2668:1: ( ( rule__Block__BeginAssignment_0 ) )
            // InternalTextualScenario.g:2669:2: ( rule__Block__BeginAssignment_0 )
            {
             before(grammarAccess.getBlockAccess().getBeginAssignment_0()); 
            // InternalTextualScenario.g:2670:2: ( rule__Block__BeginAssignment_0 )
            // InternalTextualScenario.g:2670:3: rule__Block__BeginAssignment_0
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
    // InternalTextualScenario.g:2678:1: rule__Block__Group__1 : rule__Block__Group__1__Impl rule__Block__Group__2 ;
    public final void rule__Block__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2682:1: ( rule__Block__Group__1__Impl rule__Block__Group__2 )
            // InternalTextualScenario.g:2683:2: rule__Block__Group__1__Impl rule__Block__Group__2
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
    // InternalTextualScenario.g:2690:1: rule__Block__Group__1__Impl : ( ( rule__Block__BlockElementsAssignment_1 )* ) ;
    public final void rule__Block__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2694:1: ( ( ( rule__Block__BlockElementsAssignment_1 )* ) )
            // InternalTextualScenario.g:2695:1: ( ( rule__Block__BlockElementsAssignment_1 )* )
            {
            // InternalTextualScenario.g:2695:1: ( ( rule__Block__BlockElementsAssignment_1 )* )
            // InternalTextualScenario.g:2696:2: ( rule__Block__BlockElementsAssignment_1 )*
            {
             before(grammarAccess.getBlockAccess().getBlockElementsAssignment_1()); 
            // InternalTextualScenario.g:2697:2: ( rule__Block__BlockElementsAssignment_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_STRING||(LA20_0>=11 && LA20_0<=21)||(LA20_0>=40 && LA20_0<=43)||(LA20_0>=46 && LA20_0<=47)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalTextualScenario.g:2697:3: rule__Block__BlockElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Block__BlockElementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalTextualScenario.g:2705:1: rule__Block__Group__2 : rule__Block__Group__2__Impl ;
    public final void rule__Block__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2709:1: ( rule__Block__Group__2__Impl )
            // InternalTextualScenario.g:2710:2: rule__Block__Group__2__Impl
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
    // InternalTextualScenario.g:2716:1: rule__Block__Group__2__Impl : ( ( rule__Block__EndAssignment_2 ) ) ;
    public final void rule__Block__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2720:1: ( ( ( rule__Block__EndAssignment_2 ) ) )
            // InternalTextualScenario.g:2721:1: ( ( rule__Block__EndAssignment_2 ) )
            {
            // InternalTextualScenario.g:2721:1: ( ( rule__Block__EndAssignment_2 ) )
            // InternalTextualScenario.g:2722:2: ( rule__Block__EndAssignment_2 )
            {
             before(grammarAccess.getBlockAccess().getEndAssignment_2()); 
            // InternalTextualScenario.g:2723:2: ( rule__Block__EndAssignment_2 )
            // InternalTextualScenario.g:2723:3: rule__Block__EndAssignment_2
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
    // InternalTextualScenario.g:2732:1: rule__StateFragment__Group__0 : rule__StateFragment__Group__0__Impl rule__StateFragment__Group__1 ;
    public final void rule__StateFragment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2736:1: ( rule__StateFragment__Group__0__Impl rule__StateFragment__Group__1 )
            // InternalTextualScenario.g:2737:2: rule__StateFragment__Group__0__Impl rule__StateFragment__Group__1
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
    // InternalTextualScenario.g:2744:1: rule__StateFragment__Group__0__Impl : ( ( rule__StateFragment__OnAssignment_0 ) ) ;
    public final void rule__StateFragment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2748:1: ( ( ( rule__StateFragment__OnAssignment_0 ) ) )
            // InternalTextualScenario.g:2749:1: ( ( rule__StateFragment__OnAssignment_0 ) )
            {
            // InternalTextualScenario.g:2749:1: ( ( rule__StateFragment__OnAssignment_0 ) )
            // InternalTextualScenario.g:2750:2: ( rule__StateFragment__OnAssignment_0 )
            {
             before(grammarAccess.getStateFragmentAccess().getOnAssignment_0()); 
            // InternalTextualScenario.g:2751:2: ( rule__StateFragment__OnAssignment_0 )
            // InternalTextualScenario.g:2751:3: rule__StateFragment__OnAssignment_0
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
    // InternalTextualScenario.g:2759:1: rule__StateFragment__Group__1 : rule__StateFragment__Group__1__Impl rule__StateFragment__Group__2 ;
    public final void rule__StateFragment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2763:1: ( rule__StateFragment__Group__1__Impl rule__StateFragment__Group__2 )
            // InternalTextualScenario.g:2764:2: rule__StateFragment__Group__1__Impl rule__StateFragment__Group__2
            {
            pushFollow(FOLLOW_19);
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
    // InternalTextualScenario.g:2771:1: rule__StateFragment__Group__1__Impl : ( ( rule__StateFragment__TimelineAssignment_1 ) ) ;
    public final void rule__StateFragment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2775:1: ( ( ( rule__StateFragment__TimelineAssignment_1 ) ) )
            // InternalTextualScenario.g:2776:1: ( ( rule__StateFragment__TimelineAssignment_1 ) )
            {
            // InternalTextualScenario.g:2776:1: ( ( rule__StateFragment__TimelineAssignment_1 ) )
            // InternalTextualScenario.g:2777:2: ( rule__StateFragment__TimelineAssignment_1 )
            {
             before(grammarAccess.getStateFragmentAccess().getTimelineAssignment_1()); 
            // InternalTextualScenario.g:2778:2: ( rule__StateFragment__TimelineAssignment_1 )
            // InternalTextualScenario.g:2778:3: rule__StateFragment__TimelineAssignment_1
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
    // InternalTextualScenario.g:2786:1: rule__StateFragment__Group__2 : rule__StateFragment__Group__2__Impl rule__StateFragment__Group__3 ;
    public final void rule__StateFragment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2790:1: ( rule__StateFragment__Group__2__Impl rule__StateFragment__Group__3 )
            // InternalTextualScenario.g:2791:2: rule__StateFragment__Group__2__Impl rule__StateFragment__Group__3
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
    // InternalTextualScenario.g:2798:1: rule__StateFragment__Group__2__Impl : ( ( rule__StateFragment__KeywordAssignment_2 ) ) ;
    public final void rule__StateFragment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2802:1: ( ( ( rule__StateFragment__KeywordAssignment_2 ) ) )
            // InternalTextualScenario.g:2803:1: ( ( rule__StateFragment__KeywordAssignment_2 ) )
            {
            // InternalTextualScenario.g:2803:1: ( ( rule__StateFragment__KeywordAssignment_2 ) )
            // InternalTextualScenario.g:2804:2: ( rule__StateFragment__KeywordAssignment_2 )
            {
             before(grammarAccess.getStateFragmentAccess().getKeywordAssignment_2()); 
            // InternalTextualScenario.g:2805:2: ( rule__StateFragment__KeywordAssignment_2 )
            // InternalTextualScenario.g:2805:3: rule__StateFragment__KeywordAssignment_2
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
    // InternalTextualScenario.g:2813:1: rule__StateFragment__Group__3 : rule__StateFragment__Group__3__Impl ;
    public final void rule__StateFragment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2817:1: ( rule__StateFragment__Group__3__Impl )
            // InternalTextualScenario.g:2818:2: rule__StateFragment__Group__3__Impl
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
    // InternalTextualScenario.g:2824:1: rule__StateFragment__Group__3__Impl : ( ( rule__StateFragment__NameAssignment_3 ) ) ;
    public final void rule__StateFragment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2828:1: ( ( ( rule__StateFragment__NameAssignment_3 ) ) )
            // InternalTextualScenario.g:2829:1: ( ( rule__StateFragment__NameAssignment_3 ) )
            {
            // InternalTextualScenario.g:2829:1: ( ( rule__StateFragment__NameAssignment_3 ) )
            // InternalTextualScenario.g:2830:2: ( rule__StateFragment__NameAssignment_3 )
            {
             before(grammarAccess.getStateFragmentAccess().getNameAssignment_3()); 
            // InternalTextualScenario.g:2831:2: ( rule__StateFragment__NameAssignment_3 )
            // InternalTextualScenario.g:2831:3: rule__StateFragment__NameAssignment_3
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


    // $ANTLR start "rule__Reference__Group__0"
    // InternalTextualScenario.g:2840:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2844:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // InternalTextualScenario.g:2845:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalTextualScenario.g:2852:1: rule__Reference__Group__0__Impl : ( ( rule__Reference__KeywordAssignment_0 ) ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2856:1: ( ( ( rule__Reference__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:2857:1: ( ( rule__Reference__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:2857:1: ( ( rule__Reference__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:2858:2: ( rule__Reference__KeywordAssignment_0 )
            {
             before(grammarAccess.getReferenceAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:2859:2: ( rule__Reference__KeywordAssignment_0 )
            // InternalTextualScenario.g:2859:3: rule__Reference__KeywordAssignment_0
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
    // InternalTextualScenario.g:2867:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2871:1: ( rule__Reference__Group__1__Impl rule__Reference__Group__2 )
            // InternalTextualScenario.g:2872:2: rule__Reference__Group__1__Impl rule__Reference__Group__2
            {
            pushFollow(FOLLOW_20);
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
    // InternalTextualScenario.g:2879:1: rule__Reference__Group__1__Impl : ( ( rule__Reference__NameAssignment_1 ) ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2883:1: ( ( ( rule__Reference__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:2884:1: ( ( rule__Reference__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:2884:1: ( ( rule__Reference__NameAssignment_1 ) )
            // InternalTextualScenario.g:2885:2: ( rule__Reference__NameAssignment_1 )
            {
             before(grammarAccess.getReferenceAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:2886:2: ( rule__Reference__NameAssignment_1 )
            // InternalTextualScenario.g:2886:3: rule__Reference__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Reference__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getNameAssignment_1()); 

            }


            }

        }
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
    // InternalTextualScenario.g:2894:1: rule__Reference__Group__2 : rule__Reference__Group__2__Impl rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2898:1: ( rule__Reference__Group__2__Impl rule__Reference__Group__3 )
            // InternalTextualScenario.g:2899:2: rule__Reference__Group__2__Impl rule__Reference__Group__3
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
    // InternalTextualScenario.g:2906:1: rule__Reference__Group__2__Impl : ( ( rule__Reference__OverAssignment_2 ) ) ;
    public final void rule__Reference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2910:1: ( ( ( rule__Reference__OverAssignment_2 ) ) )
            // InternalTextualScenario.g:2911:1: ( ( rule__Reference__OverAssignment_2 ) )
            {
            // InternalTextualScenario.g:2911:1: ( ( rule__Reference__OverAssignment_2 ) )
            // InternalTextualScenario.g:2912:2: ( rule__Reference__OverAssignment_2 )
            {
             before(grammarAccess.getReferenceAccess().getOverAssignment_2()); 
            // InternalTextualScenario.g:2913:2: ( rule__Reference__OverAssignment_2 )
            // InternalTextualScenario.g:2913:3: rule__Reference__OverAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Reference__OverAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getOverAssignment_2()); 

            }


            }

        }
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
    // InternalTextualScenario.g:2921:1: rule__Reference__Group__3 : rule__Reference__Group__3__Impl ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2925:1: ( rule__Reference__Group__3__Impl )
            // InternalTextualScenario.g:2926:2: rule__Reference__Group__3__Impl
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
    // InternalTextualScenario.g:2932:1: rule__Reference__Group__3__Impl : ( ( ( rule__Reference__TimelinesAssignment_3 ) ) ( ( rule__Reference__TimelinesAssignment_3 )* ) ) ;
    public final void rule__Reference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2936:1: ( ( ( ( rule__Reference__TimelinesAssignment_3 ) ) ( ( rule__Reference__TimelinesAssignment_3 )* ) ) )
            // InternalTextualScenario.g:2937:1: ( ( ( rule__Reference__TimelinesAssignment_3 ) ) ( ( rule__Reference__TimelinesAssignment_3 )* ) )
            {
            // InternalTextualScenario.g:2937:1: ( ( ( rule__Reference__TimelinesAssignment_3 ) ) ( ( rule__Reference__TimelinesAssignment_3 )* ) )
            // InternalTextualScenario.g:2938:2: ( ( rule__Reference__TimelinesAssignment_3 ) ) ( ( rule__Reference__TimelinesAssignment_3 )* )
            {
            // InternalTextualScenario.g:2938:2: ( ( rule__Reference__TimelinesAssignment_3 ) )
            // InternalTextualScenario.g:2939:3: ( rule__Reference__TimelinesAssignment_3 )
            {
             before(grammarAccess.getReferenceAccess().getTimelinesAssignment_3()); 
            // InternalTextualScenario.g:2940:3: ( rule__Reference__TimelinesAssignment_3 )
            // InternalTextualScenario.g:2940:4: rule__Reference__TimelinesAssignment_3
            {
            pushFollow(FOLLOW_15);
            rule__Reference__TimelinesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getTimelinesAssignment_3()); 

            }

            // InternalTextualScenario.g:2943:2: ( ( rule__Reference__TimelinesAssignment_3 )* )
            // InternalTextualScenario.g:2944:3: ( rule__Reference__TimelinesAssignment_3 )*
            {
             before(grammarAccess.getReferenceAccess().getTimelinesAssignment_3()); 
            // InternalTextualScenario.g:2945:3: ( rule__Reference__TimelinesAssignment_3 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_STRING) ) {
                    int LA21_2 = input.LA(2);

                    if ( (LA21_2==EOF||LA21_2==RULE_STRING||(LA21_2>=11 && LA21_2<=21)||LA21_2==27||(LA21_2>=40 && LA21_2<=43)||(LA21_2>=46 && LA21_2<=47)) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // InternalTextualScenario.g:2945:4: rule__Reference__TimelinesAssignment_3
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Reference__TimelinesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getReferenceAccess().getTimelinesAssignment_3()); 

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
    // $ANTLR end "rule__Reference__Group__3__Impl"


    // $ANTLR start "rule__Model__BeginAssignment_1"
    // InternalTextualScenario.g:2955:1: rule__Model__BeginAssignment_1 : ( ( '{' ) ) ;
    public final void rule__Model__BeginAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2959:1: ( ( ( '{' ) ) )
            // InternalTextualScenario.g:2960:2: ( ( '{' ) )
            {
            // InternalTextualScenario.g:2960:2: ( ( '{' ) )
            // InternalTextualScenario.g:2961:3: ( '{' )
            {
             before(grammarAccess.getModelAccess().getBeginLeftCurlyBracketKeyword_1_0()); 
            // InternalTextualScenario.g:2962:3: ( '{' )
            // InternalTextualScenario.g:2963:4: '{'
            {
             before(grammarAccess.getModelAccess().getBeginLeftCurlyBracketKeyword_1_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalTextualScenario.g:2974:1: rule__Model__ParticipantsAssignment_2 : ( ruleParticipant ) ;
    public final void rule__Model__ParticipantsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2978:1: ( ( ruleParticipant ) )
            // InternalTextualScenario.g:2979:2: ( ruleParticipant )
            {
            // InternalTextualScenario.g:2979:2: ( ruleParticipant )
            // InternalTextualScenario.g:2980:3: ruleParticipant
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
    // InternalTextualScenario.g:2989:1: rule__Model__ElementsAssignment_3 : ( ruleElement ) ;
    public final void rule__Model__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2993:1: ( ( ruleElement ) )
            // InternalTextualScenario.g:2994:2: ( ruleElement )
            {
            // InternalTextualScenario.g:2994:2: ( ruleElement )
            // InternalTextualScenario.g:2995:3: ruleElement
            {
             before(grammarAccess.getModelAccess().getElementsElementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElementsElementParserRuleCall_3_0()); 

            }


            }

        }
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
    // InternalTextualScenario.g:3004:1: rule__Model__EndAssignment_4 : ( ( '}' ) ) ;
    public final void rule__Model__EndAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3008:1: ( ( ( '}' ) ) )
            // InternalTextualScenario.g:3009:2: ( ( '}' ) )
            {
            // InternalTextualScenario.g:3009:2: ( ( '}' ) )
            // InternalTextualScenario.g:3010:3: ( '}' )
            {
             before(grammarAccess.getModelAccess().getEndRightCurlyBracketKeyword_4_0()); 
            // InternalTextualScenario.g:3011:3: ( '}' )
            // InternalTextualScenario.g:3012:4: '}'
            {
             before(grammarAccess.getModelAccess().getEndRightCurlyBracketKeyword_4_0()); 
            match(input,27,FOLLOW_2); 
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
    // InternalTextualScenario.g:3023:1: rule__Actor__KeywordAssignment_0 : ( ( 'actor' ) ) ;
    public final void rule__Actor__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3027:1: ( ( ( 'actor' ) ) )
            // InternalTextualScenario.g:3028:2: ( ( 'actor' ) )
            {
            // InternalTextualScenario.g:3028:2: ( ( 'actor' ) )
            // InternalTextualScenario.g:3029:3: ( 'actor' )
            {
             before(grammarAccess.getActorAccess().getKeywordActorKeyword_0_0()); 
            // InternalTextualScenario.g:3030:3: ( 'actor' )
            // InternalTextualScenario.g:3031:4: 'actor'
            {
             before(grammarAccess.getActorAccess().getKeywordActorKeyword_0_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalTextualScenario.g:3042:1: rule__Actor__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Actor__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3046:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3047:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3047:2: ( RULE_STRING )
            // InternalTextualScenario.g:3048:3: RULE_STRING
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
    // InternalTextualScenario.g:3057:1: rule__Component__KeywordAssignment_0 : ( ( 'component' ) ) ;
    public final void rule__Component__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3061:1: ( ( ( 'component' ) ) )
            // InternalTextualScenario.g:3062:2: ( ( 'component' ) )
            {
            // InternalTextualScenario.g:3062:2: ( ( 'component' ) )
            // InternalTextualScenario.g:3063:3: ( 'component' )
            {
             before(grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0()); 
            // InternalTextualScenario.g:3064:3: ( 'component' )
            // InternalTextualScenario.g:3065:4: 'component'
            {
             before(grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0()); 
            match(input,29,FOLLOW_2); 
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
    // InternalTextualScenario.g:3076:1: rule__Component__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Component__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3080:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3081:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3081:2: ( RULE_STRING )
            // InternalTextualScenario.g:3082:3: RULE_STRING
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


    // $ANTLR start "rule__ConfigurationItem__KeywordAssignment_0"
    // InternalTextualScenario.g:3091:1: rule__ConfigurationItem__KeywordAssignment_0 : ( ( 'configuration_item' ) ) ;
    public final void rule__ConfigurationItem__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3095:1: ( ( ( 'configuration_item' ) ) )
            // InternalTextualScenario.g:3096:2: ( ( 'configuration_item' ) )
            {
            // InternalTextualScenario.g:3096:2: ( ( 'configuration_item' ) )
            // InternalTextualScenario.g:3097:3: ( 'configuration_item' )
            {
             before(grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0()); 
            // InternalTextualScenario.g:3098:3: ( 'configuration_item' )
            // InternalTextualScenario.g:3099:4: 'configuration_item'
            {
             before(grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTextualScenario.g:3110:1: rule__ConfigurationItem__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ConfigurationItem__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3114:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3115:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3115:2: ( RULE_STRING )
            // InternalTextualScenario.g:3116:3: RULE_STRING
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
    // InternalTextualScenario.g:3125:1: rule__Function__KeywordAssignment_0 : ( ( 'function' ) ) ;
    public final void rule__Function__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3129:1: ( ( ( 'function' ) ) )
            // InternalTextualScenario.g:3130:2: ( ( 'function' ) )
            {
            // InternalTextualScenario.g:3130:2: ( ( 'function' ) )
            // InternalTextualScenario.g:3131:3: ( 'function' )
            {
             before(grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0()); 
            // InternalTextualScenario.g:3132:3: ( 'function' )
            // InternalTextualScenario.g:3133:4: 'function'
            {
             before(grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0()); 
            match(input,24,FOLLOW_2); 
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
    // InternalTextualScenario.g:3144:1: rule__Function__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Function__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3148:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3149:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3149:2: ( RULE_STRING )
            // InternalTextualScenario.g:3150:3: RULE_STRING
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
    // InternalTextualScenario.g:3159:1: rule__Activity__KeywordAssignment_0 : ( ( 'activity' ) ) ;
    public final void rule__Activity__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3163:1: ( ( ( 'activity' ) ) )
            // InternalTextualScenario.g:3164:2: ( ( 'activity' ) )
            {
            // InternalTextualScenario.g:3164:2: ( ( 'activity' ) )
            // InternalTextualScenario.g:3165:3: ( 'activity' )
            {
             before(grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0()); 
            // InternalTextualScenario.g:3166:3: ( 'activity' )
            // InternalTextualScenario.g:3167:4: 'activity'
            {
             before(grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTextualScenario.g:3178:1: rule__Activity__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Activity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3182:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3183:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3183:2: ( RULE_STRING )
            // InternalTextualScenario.g:3184:3: RULE_STRING
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
    // InternalTextualScenario.g:3193:1: rule__Entity__KeywordAssignment_0 : ( ( 'entity' ) ) ;
    public final void rule__Entity__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3197:1: ( ( ( 'entity' ) ) )
            // InternalTextualScenario.g:3198:2: ( ( 'entity' ) )
            {
            // InternalTextualScenario.g:3198:2: ( ( 'entity' ) )
            // InternalTextualScenario.g:3199:3: ( 'entity' )
            {
             before(grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0()); 
            // InternalTextualScenario.g:3200:3: ( 'entity' )
            // InternalTextualScenario.g:3201:4: 'entity'
            {
             before(grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0()); 
            match(input,32,FOLLOW_2); 
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
    // InternalTextualScenario.g:3212:1: rule__Entity__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Entity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3216:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3217:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3217:2: ( RULE_STRING )
            // InternalTextualScenario.g:3218:3: RULE_STRING
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
    // InternalTextualScenario.g:3227:1: rule__Role__KeywordAssignment_0 : ( ( 'role' ) ) ;
    public final void rule__Role__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3231:1: ( ( ( 'role' ) ) )
            // InternalTextualScenario.g:3232:2: ( ( 'role' ) )
            {
            // InternalTextualScenario.g:3232:2: ( ( 'role' ) )
            // InternalTextualScenario.g:3233:3: ( 'role' )
            {
             before(grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0()); 
            // InternalTextualScenario.g:3234:3: ( 'role' )
            // InternalTextualScenario.g:3235:4: 'role'
            {
             before(grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0()); 
            match(input,33,FOLLOW_2); 
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
    // InternalTextualScenario.g:3246:1: rule__Role__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Role__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3250:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3251:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3251:2: ( RULE_STRING )
            // InternalTextualScenario.g:3252:3: RULE_STRING
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
    // InternalTextualScenario.g:3261:1: rule__SequenceMessage__SourceAssignment_0 : ( RULE_STRING ) ;
    public final void rule__SequenceMessage__SourceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3265:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3266:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3266:2: ( RULE_STRING )
            // InternalTextualScenario.g:3267:3: RULE_STRING
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
    // InternalTextualScenario.g:3276:1: rule__SequenceMessage__ArrowAssignment_1 : ( ( '->' ) ) ;
    public final void rule__SequenceMessage__ArrowAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3280:1: ( ( ( '->' ) ) )
            // InternalTextualScenario.g:3281:2: ( ( '->' ) )
            {
            // InternalTextualScenario.g:3281:2: ( ( '->' ) )
            // InternalTextualScenario.g:3282:3: ( '->' )
            {
             before(grammarAccess.getSequenceMessageAccess().getArrowHyphenMinusGreaterThanSignKeyword_1_0()); 
            // InternalTextualScenario.g:3283:3: ( '->' )
            // InternalTextualScenario.g:3284:4: '->'
            {
             before(grammarAccess.getSequenceMessageAccess().getArrowHyphenMinusGreaterThanSignKeyword_1_0()); 
            match(input,34,FOLLOW_2); 
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
    // InternalTextualScenario.g:3295:1: rule__SequenceMessage__TargetAssignment_2 : ( RULE_STRING ) ;
    public final void rule__SequenceMessage__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3299:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3300:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3300:2: ( RULE_STRING )
            // InternalTextualScenario.g:3301:3: RULE_STRING
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
    // InternalTextualScenario.g:3310:1: rule__SequenceMessage__ExecutionAssignment_3 : ( ( 'withExecution' ) ) ;
    public final void rule__SequenceMessage__ExecutionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3314:1: ( ( ( 'withExecution' ) ) )
            // InternalTextualScenario.g:3315:2: ( ( 'withExecution' ) )
            {
            // InternalTextualScenario.g:3315:2: ( ( 'withExecution' ) )
            // InternalTextualScenario.g:3316:3: ( 'withExecution' )
            {
             before(grammarAccess.getSequenceMessageAccess().getExecutionWithExecutionKeyword_3_0()); 
            // InternalTextualScenario.g:3317:3: ( 'withExecution' )
            // InternalTextualScenario.g:3318:4: 'withExecution'
            {
             before(grammarAccess.getSequenceMessageAccess().getExecutionWithExecutionKeyword_3_0()); 
            match(input,35,FOLLOW_2); 
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
    // InternalTextualScenario.g:3329:1: rule__SequenceMessage__ReturnAssignment_4 : ( ( 'withReturn' ) ) ;
    public final void rule__SequenceMessage__ReturnAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3333:1: ( ( ( 'withReturn' ) ) )
            // InternalTextualScenario.g:3334:2: ( ( 'withReturn' ) )
            {
            // InternalTextualScenario.g:3334:2: ( ( 'withReturn' ) )
            // InternalTextualScenario.g:3335:3: ( 'withReturn' )
            {
             before(grammarAccess.getSequenceMessageAccess().getReturnWithReturnKeyword_4_0()); 
            // InternalTextualScenario.g:3336:3: ( 'withReturn' )
            // InternalTextualScenario.g:3337:4: 'withReturn'
            {
             before(grammarAccess.getSequenceMessageAccess().getReturnWithReturnKeyword_4_0()); 
            match(input,36,FOLLOW_2); 
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
    // InternalTextualScenario.g:3348:1: rule__SequenceMessage__DoubleDotAssignment_5 : ( ( ':' ) ) ;
    public final void rule__SequenceMessage__DoubleDotAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3352:1: ( ( ( ':' ) ) )
            // InternalTextualScenario.g:3353:2: ( ( ':' ) )
            {
            // InternalTextualScenario.g:3353:2: ( ( ':' ) )
            // InternalTextualScenario.g:3354:3: ( ':' )
            {
             before(grammarAccess.getSequenceMessageAccess().getDoubleDotColonKeyword_5_0()); 
            // InternalTextualScenario.g:3355:3: ( ':' )
            // InternalTextualScenario.g:3356:4: ':'
            {
             before(grammarAccess.getSequenceMessageAccess().getDoubleDotColonKeyword_5_0()); 
            match(input,37,FOLLOW_2); 
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
    // InternalTextualScenario.g:3367:1: rule__SequenceMessage__NameAssignment_6 : ( RULE_STRING ) ;
    public final void rule__SequenceMessage__NameAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3371:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3372:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3372:2: ( RULE_STRING )
            // InternalTextualScenario.g:3373:3: RULE_STRING
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
    // InternalTextualScenario.g:3382:1: rule__CreateMessage__SourceAssignment_0 : ( RULE_STRING ) ;
    public final void rule__CreateMessage__SourceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3386:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3387:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3387:2: ( RULE_STRING )
            // InternalTextualScenario.g:3388:3: RULE_STRING
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
    // InternalTextualScenario.g:3397:1: rule__CreateMessage__ArrowAssignment_1 : ( ( '->+' ) ) ;
    public final void rule__CreateMessage__ArrowAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3401:1: ( ( ( '->+' ) ) )
            // InternalTextualScenario.g:3402:2: ( ( '->+' ) )
            {
            // InternalTextualScenario.g:3402:2: ( ( '->+' ) )
            // InternalTextualScenario.g:3403:3: ( '->+' )
            {
             before(grammarAccess.getCreateMessageAccess().getArrowHyphenMinusGreaterThanSignPlusSignKeyword_1_0()); 
            // InternalTextualScenario.g:3404:3: ( '->+' )
            // InternalTextualScenario.g:3405:4: '->+'
            {
             before(grammarAccess.getCreateMessageAccess().getArrowHyphenMinusGreaterThanSignPlusSignKeyword_1_0()); 
            match(input,38,FOLLOW_2); 
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
    // InternalTextualScenario.g:3416:1: rule__CreateMessage__TargetAssignment_2 : ( RULE_STRING ) ;
    public final void rule__CreateMessage__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3420:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3421:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3421:2: ( RULE_STRING )
            // InternalTextualScenario.g:3422:3: RULE_STRING
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
    // InternalTextualScenario.g:3431:1: rule__CreateMessage__DoubleDotAssignment_3 : ( ( ':' ) ) ;
    public final void rule__CreateMessage__DoubleDotAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3435:1: ( ( ( ':' ) ) )
            // InternalTextualScenario.g:3436:2: ( ( ':' ) )
            {
            // InternalTextualScenario.g:3436:2: ( ( ':' ) )
            // InternalTextualScenario.g:3437:3: ( ':' )
            {
             before(grammarAccess.getCreateMessageAccess().getDoubleDotColonKeyword_3_0()); 
            // InternalTextualScenario.g:3438:3: ( ':' )
            // InternalTextualScenario.g:3439:4: ':'
            {
             before(grammarAccess.getCreateMessageAccess().getDoubleDotColonKeyword_3_0()); 
            match(input,37,FOLLOW_2); 
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
    // InternalTextualScenario.g:3450:1: rule__CreateMessage__NameAssignment_4 : ( RULE_STRING ) ;
    public final void rule__CreateMessage__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3454:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3455:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3455:2: ( RULE_STRING )
            // InternalTextualScenario.g:3456:3: RULE_STRING
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
    // InternalTextualScenario.g:3465:1: rule__DeleteMessage__SourceAssignment_0 : ( RULE_STRING ) ;
    public final void rule__DeleteMessage__SourceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3469:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3470:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3470:2: ( RULE_STRING )
            // InternalTextualScenario.g:3471:3: RULE_STRING
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
    // InternalTextualScenario.g:3480:1: rule__DeleteMessage__ArrowAssignment_1 : ( ( '->x' ) ) ;
    public final void rule__DeleteMessage__ArrowAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3484:1: ( ( ( '->x' ) ) )
            // InternalTextualScenario.g:3485:2: ( ( '->x' ) )
            {
            // InternalTextualScenario.g:3485:2: ( ( '->x' ) )
            // InternalTextualScenario.g:3486:3: ( '->x' )
            {
             before(grammarAccess.getDeleteMessageAccess().getArrowXKeyword_1_0()); 
            // InternalTextualScenario.g:3487:3: ( '->x' )
            // InternalTextualScenario.g:3488:4: '->x'
            {
             before(grammarAccess.getDeleteMessageAccess().getArrowXKeyword_1_0()); 
            match(input,39,FOLLOW_2); 
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
    // InternalTextualScenario.g:3499:1: rule__DeleteMessage__TargetAssignment_2 : ( RULE_STRING ) ;
    public final void rule__DeleteMessage__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3503:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3504:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3504:2: ( RULE_STRING )
            // InternalTextualScenario.g:3505:3: RULE_STRING
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
    // InternalTextualScenario.g:3514:1: rule__DeleteMessage__DoubleDotAssignment_3 : ( ( ':' ) ) ;
    public final void rule__DeleteMessage__DoubleDotAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3518:1: ( ( ( ':' ) ) )
            // InternalTextualScenario.g:3519:2: ( ( ':' ) )
            {
            // InternalTextualScenario.g:3519:2: ( ( ':' ) )
            // InternalTextualScenario.g:3520:3: ( ':' )
            {
             before(grammarAccess.getDeleteMessageAccess().getDoubleDotColonKeyword_3_0()); 
            // InternalTextualScenario.g:3521:3: ( ':' )
            // InternalTextualScenario.g:3522:4: ':'
            {
             before(grammarAccess.getDeleteMessageAccess().getDoubleDotColonKeyword_3_0()); 
            match(input,37,FOLLOW_2); 
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
    // InternalTextualScenario.g:3533:1: rule__DeleteMessage__NameAssignment_4 : ( RULE_STRING ) ;
    public final void rule__DeleteMessage__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3537:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3538:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3538:2: ( RULE_STRING )
            // InternalTextualScenario.g:3539:3: RULE_STRING
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
    // InternalTextualScenario.g:3548:1: rule__ArmTimerMessage__ArrowAssignment_0 : ( ( '->>' ) ) ;
    public final void rule__ArmTimerMessage__ArrowAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3552:1: ( ( ( '->>' ) ) )
            // InternalTextualScenario.g:3553:2: ( ( '->>' ) )
            {
            // InternalTextualScenario.g:3553:2: ( ( '->>' ) )
            // InternalTextualScenario.g:3554:3: ( '->>' )
            {
             before(grammarAccess.getArmTimerMessageAccess().getArrowHyphenMinusGreaterThanSignGreaterThanSignKeyword_0_0()); 
            // InternalTextualScenario.g:3555:3: ( '->>' )
            // InternalTextualScenario.g:3556:4: '->>'
            {
             before(grammarAccess.getArmTimerMessageAccess().getArrowHyphenMinusGreaterThanSignGreaterThanSignKeyword_0_0()); 
            match(input,40,FOLLOW_2); 
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
    // InternalTextualScenario.g:3567:1: rule__ArmTimerMessage__ParticipantAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ArmTimerMessage__ParticipantAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3571:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3572:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3572:2: ( RULE_STRING )
            // InternalTextualScenario.g:3573:3: RULE_STRING
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


    // $ANTLR start "rule__ArmTimerMessage__ExecutionAssignment_2"
    // InternalTextualScenario.g:3582:1: rule__ArmTimerMessage__ExecutionAssignment_2 : ( ( 'withExecution' ) ) ;
    public final void rule__ArmTimerMessage__ExecutionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3586:1: ( ( ( 'withExecution' ) ) )
            // InternalTextualScenario.g:3587:2: ( ( 'withExecution' ) )
            {
            // InternalTextualScenario.g:3587:2: ( ( 'withExecution' ) )
            // InternalTextualScenario.g:3588:3: ( 'withExecution' )
            {
             before(grammarAccess.getArmTimerMessageAccess().getExecutionWithExecutionKeyword_2_0()); 
            // InternalTextualScenario.g:3589:3: ( 'withExecution' )
            // InternalTextualScenario.g:3590:4: 'withExecution'
            {
             before(grammarAccess.getArmTimerMessageAccess().getExecutionWithExecutionKeyword_2_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getArmTimerMessageAccess().getExecutionWithExecutionKeyword_2_0()); 

            }

             after(grammarAccess.getArmTimerMessageAccess().getExecutionWithExecutionKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArmTimerMessage__ExecutionAssignment_2"


    // $ANTLR start "rule__ArmTimerMessage__DoubleDotAssignment_3"
    // InternalTextualScenario.g:3601:1: rule__ArmTimerMessage__DoubleDotAssignment_3 : ( ( ':' ) ) ;
    public final void rule__ArmTimerMessage__DoubleDotAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3605:1: ( ( ( ':' ) ) )
            // InternalTextualScenario.g:3606:2: ( ( ':' ) )
            {
            // InternalTextualScenario.g:3606:2: ( ( ':' ) )
            // InternalTextualScenario.g:3607:3: ( ':' )
            {
             before(grammarAccess.getArmTimerMessageAccess().getDoubleDotColonKeyword_3_0()); 
            // InternalTextualScenario.g:3608:3: ( ':' )
            // InternalTextualScenario.g:3609:4: ':'
            {
             before(grammarAccess.getArmTimerMessageAccess().getDoubleDotColonKeyword_3_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getArmTimerMessageAccess().getDoubleDotColonKeyword_3_0()); 

            }

             after(grammarAccess.getArmTimerMessageAccess().getDoubleDotColonKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArmTimerMessage__DoubleDotAssignment_3"


    // $ANTLR start "rule__ArmTimerMessage__NameAssignment_4"
    // InternalTextualScenario.g:3620:1: rule__ArmTimerMessage__NameAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ArmTimerMessage__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3624:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3625:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3625:2: ( RULE_STRING )
            // InternalTextualScenario.g:3626:3: RULE_STRING
            {
             before(grammarAccess.getArmTimerMessageAccess().getNameSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getArmTimerMessageAccess().getNameSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArmTimerMessage__NameAssignment_4"


    // $ANTLR start "rule__LostMessage__ArrowAssignment_0"
    // InternalTextualScenario.g:3635:1: rule__LostMessage__ArrowAssignment_0 : ( ( '->o' ) ) ;
    public final void rule__LostMessage__ArrowAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3639:1: ( ( ( '->o' ) ) )
            // InternalTextualScenario.g:3640:2: ( ( '->o' ) )
            {
            // InternalTextualScenario.g:3640:2: ( ( '->o' ) )
            // InternalTextualScenario.g:3641:3: ( '->o' )
            {
             before(grammarAccess.getLostMessageAccess().getArrowOKeyword_0_0()); 
            // InternalTextualScenario.g:3642:3: ( '->o' )
            // InternalTextualScenario.g:3643:4: '->o'
            {
             before(grammarAccess.getLostMessageAccess().getArrowOKeyword_0_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getLostMessageAccess().getArrowOKeyword_0_0()); 

            }

             after(grammarAccess.getLostMessageAccess().getArrowOKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LostMessage__ArrowAssignment_0"


    // $ANTLR start "rule__LostMessage__ParticipantAssignment_1"
    // InternalTextualScenario.g:3654:1: rule__LostMessage__ParticipantAssignment_1 : ( RULE_STRING ) ;
    public final void rule__LostMessage__ParticipantAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3658:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3659:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3659:2: ( RULE_STRING )
            // InternalTextualScenario.g:3660:3: RULE_STRING
            {
             before(grammarAccess.getLostMessageAccess().getParticipantSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getLostMessageAccess().getParticipantSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LostMessage__ParticipantAssignment_1"


    // $ANTLR start "rule__LostMessage__DoubleDotAssignment_2"
    // InternalTextualScenario.g:3669:1: rule__LostMessage__DoubleDotAssignment_2 : ( ( ':' ) ) ;
    public final void rule__LostMessage__DoubleDotAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3673:1: ( ( ( ':' ) ) )
            // InternalTextualScenario.g:3674:2: ( ( ':' ) )
            {
            // InternalTextualScenario.g:3674:2: ( ( ':' ) )
            // InternalTextualScenario.g:3675:3: ( ':' )
            {
             before(grammarAccess.getLostMessageAccess().getDoubleDotColonKeyword_2_0()); 
            // InternalTextualScenario.g:3676:3: ( ':' )
            // InternalTextualScenario.g:3677:4: ':'
            {
             before(grammarAccess.getLostMessageAccess().getDoubleDotColonKeyword_2_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getLostMessageAccess().getDoubleDotColonKeyword_2_0()); 

            }

             after(grammarAccess.getLostMessageAccess().getDoubleDotColonKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LostMessage__DoubleDotAssignment_2"


    // $ANTLR start "rule__LostMessage__NameAssignment_3"
    // InternalTextualScenario.g:3688:1: rule__LostMessage__NameAssignment_3 : ( RULE_STRING ) ;
    public final void rule__LostMessage__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3692:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3693:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3693:2: ( RULE_STRING )
            // InternalTextualScenario.g:3694:3: RULE_STRING
            {
             before(grammarAccess.getLostMessageAccess().getNameSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getLostMessageAccess().getNameSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LostMessage__NameAssignment_3"


    // $ANTLR start "rule__FoundMessage__ArrowAssignment_0"
    // InternalTextualScenario.g:3703:1: rule__FoundMessage__ArrowAssignment_0 : ( ( 'o->' ) ) ;
    public final void rule__FoundMessage__ArrowAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3707:1: ( ( ( 'o->' ) ) )
            // InternalTextualScenario.g:3708:2: ( ( 'o->' ) )
            {
            // InternalTextualScenario.g:3708:2: ( ( 'o->' ) )
            // InternalTextualScenario.g:3709:3: ( 'o->' )
            {
             before(grammarAccess.getFoundMessageAccess().getArrowOKeyword_0_0()); 
            // InternalTextualScenario.g:3710:3: ( 'o->' )
            // InternalTextualScenario.g:3711:4: 'o->'
            {
             before(grammarAccess.getFoundMessageAccess().getArrowOKeyword_0_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getFoundMessageAccess().getArrowOKeyword_0_0()); 

            }

             after(grammarAccess.getFoundMessageAccess().getArrowOKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FoundMessage__ArrowAssignment_0"


    // $ANTLR start "rule__FoundMessage__ParticipantAssignment_1"
    // InternalTextualScenario.g:3722:1: rule__FoundMessage__ParticipantAssignment_1 : ( RULE_STRING ) ;
    public final void rule__FoundMessage__ParticipantAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3726:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3727:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3727:2: ( RULE_STRING )
            // InternalTextualScenario.g:3728:3: RULE_STRING
            {
             before(grammarAccess.getFoundMessageAccess().getParticipantSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getFoundMessageAccess().getParticipantSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FoundMessage__ParticipantAssignment_1"


    // $ANTLR start "rule__FoundMessage__DoubleDotAssignment_2"
    // InternalTextualScenario.g:3737:1: rule__FoundMessage__DoubleDotAssignment_2 : ( ( ':' ) ) ;
    public final void rule__FoundMessage__DoubleDotAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3741:1: ( ( ( ':' ) ) )
            // InternalTextualScenario.g:3742:2: ( ( ':' ) )
            {
            // InternalTextualScenario.g:3742:2: ( ( ':' ) )
            // InternalTextualScenario.g:3743:3: ( ':' )
            {
             before(grammarAccess.getFoundMessageAccess().getDoubleDotColonKeyword_2_0()); 
            // InternalTextualScenario.g:3744:3: ( ':' )
            // InternalTextualScenario.g:3745:4: ':'
            {
             before(grammarAccess.getFoundMessageAccess().getDoubleDotColonKeyword_2_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getFoundMessageAccess().getDoubleDotColonKeyword_2_0()); 

            }

             after(grammarAccess.getFoundMessageAccess().getDoubleDotColonKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FoundMessage__DoubleDotAssignment_2"


    // $ANTLR start "rule__FoundMessage__NameAssignment_3"
    // InternalTextualScenario.g:3756:1: rule__FoundMessage__NameAssignment_3 : ( RULE_STRING ) ;
    public final void rule__FoundMessage__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3760:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3761:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3761:2: ( RULE_STRING )
            // InternalTextualScenario.g:3762:3: RULE_STRING
            {
             before(grammarAccess.getFoundMessageAccess().getNameSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getFoundMessageAccess().getNameSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FoundMessage__NameAssignment_3"


    // $ANTLR start "rule__ParticipantDeactivation__KeywordAssignment_0"
    // InternalTextualScenario.g:3771:1: rule__ParticipantDeactivation__KeywordAssignment_0 : ( ( 'deactivate' ) ) ;
    public final void rule__ParticipantDeactivation__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3775:1: ( ( ( 'deactivate' ) ) )
            // InternalTextualScenario.g:3776:2: ( ( 'deactivate' ) )
            {
            // InternalTextualScenario.g:3776:2: ( ( 'deactivate' ) )
            // InternalTextualScenario.g:3777:3: ( 'deactivate' )
            {
             before(grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0()); 
            // InternalTextualScenario.g:3778:3: ( 'deactivate' )
            // InternalTextualScenario.g:3779:4: 'deactivate'
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
    // InternalTextualScenario.g:3790:1: rule__ParticipantDeactivation__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ParticipantDeactivation__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3794:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3795:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3795:2: ( RULE_STRING )
            // InternalTextualScenario.g:3796:3: RULE_STRING
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


    // $ANTLR start "rule__CombinedFragment__KeywordAssignment_0"
    // InternalTextualScenario.g:3805:1: rule__CombinedFragment__KeywordAssignment_0 : ( ( rule__CombinedFragment__KeywordAlternatives_0_0 ) ) ;
    public final void rule__CombinedFragment__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3809:1: ( ( ( rule__CombinedFragment__KeywordAlternatives_0_0 ) ) )
            // InternalTextualScenario.g:3810:2: ( ( rule__CombinedFragment__KeywordAlternatives_0_0 ) )
            {
            // InternalTextualScenario.g:3810:2: ( ( rule__CombinedFragment__KeywordAlternatives_0_0 ) )
            // InternalTextualScenario.g:3811:3: ( rule__CombinedFragment__KeywordAlternatives_0_0 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getKeywordAlternatives_0_0()); 
            // InternalTextualScenario.g:3812:3: ( rule__CombinedFragment__KeywordAlternatives_0_0 )
            // InternalTextualScenario.g:3812:4: rule__CombinedFragment__KeywordAlternatives_0_0
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
    // InternalTextualScenario.g:3820:1: rule__CombinedFragment__ExpressionAssignment_1 : ( RULE_STRING ) ;
    public final void rule__CombinedFragment__ExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3824:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3825:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3825:2: ( RULE_STRING )
            // InternalTextualScenario.g:3826:3: RULE_STRING
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
    // InternalTextualScenario.g:3835:1: rule__CombinedFragment__OverAssignment_2 : ( ( 'over' ) ) ;
    public final void rule__CombinedFragment__OverAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3839:1: ( ( ( 'over' ) ) )
            // InternalTextualScenario.g:3840:2: ( ( 'over' ) )
            {
            // InternalTextualScenario.g:3840:2: ( ( 'over' ) )
            // InternalTextualScenario.g:3841:3: ( 'over' )
            {
             before(grammarAccess.getCombinedFragmentAccess().getOverOverKeyword_2_0()); 
            // InternalTextualScenario.g:3842:3: ( 'over' )
            // InternalTextualScenario.g:3843:4: 'over'
            {
             before(grammarAccess.getCombinedFragmentAccess().getOverOverKeyword_2_0()); 
            match(input,44,FOLLOW_2); 
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
    // InternalTextualScenario.g:3854:1: rule__CombinedFragment__TimelinesAssignment_3 : ( RULE_STRING ) ;
    public final void rule__CombinedFragment__TimelinesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3858:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3859:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3859:2: ( RULE_STRING )
            // InternalTextualScenario.g:3860:3: RULE_STRING
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
    // InternalTextualScenario.g:3869:1: rule__CombinedFragment__BlockAssignment_4 : ( ruleBlock ) ;
    public final void rule__CombinedFragment__BlockAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3873:1: ( ( ruleBlock ) )
            // InternalTextualScenario.g:3874:2: ( ruleBlock )
            {
            // InternalTextualScenario.g:3874:2: ( ruleBlock )
            // InternalTextualScenario.g:3875:3: ruleBlock
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
    // InternalTextualScenario.g:3884:1: rule__CombinedFragment__OperandsAssignment_5 : ( ruleOperand ) ;
    public final void rule__CombinedFragment__OperandsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3888:1: ( ( ruleOperand ) )
            // InternalTextualScenario.g:3889:2: ( ruleOperand )
            {
            // InternalTextualScenario.g:3889:2: ( ruleOperand )
            // InternalTextualScenario.g:3890:3: ruleOperand
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
    // InternalTextualScenario.g:3899:1: rule__Operand__KeywordAssignment_0 : ( ( 'else' ) ) ;
    public final void rule__Operand__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3903:1: ( ( ( 'else' ) ) )
            // InternalTextualScenario.g:3904:2: ( ( 'else' ) )
            {
            // InternalTextualScenario.g:3904:2: ( ( 'else' ) )
            // InternalTextualScenario.g:3905:3: ( 'else' )
            {
             before(grammarAccess.getOperandAccess().getKeywordElseKeyword_0_0()); 
            // InternalTextualScenario.g:3906:3: ( 'else' )
            // InternalTextualScenario.g:3907:4: 'else'
            {
             before(grammarAccess.getOperandAccess().getKeywordElseKeyword_0_0()); 
            match(input,45,FOLLOW_2); 
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
    // InternalTextualScenario.g:3918:1: rule__Operand__ExpressionAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Operand__ExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3922:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3923:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3923:2: ( RULE_STRING )
            // InternalTextualScenario.g:3924:3: RULE_STRING
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
    // InternalTextualScenario.g:3933:1: rule__Operand__BlockAssignment_2 : ( ruleBlock ) ;
    public final void rule__Operand__BlockAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3937:1: ( ( ruleBlock ) )
            // InternalTextualScenario.g:3938:2: ( ruleBlock )
            {
            // InternalTextualScenario.g:3938:2: ( ruleBlock )
            // InternalTextualScenario.g:3939:3: ruleBlock
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
    // InternalTextualScenario.g:3948:1: rule__Block__BeginAssignment_0 : ( ( '{' ) ) ;
    public final void rule__Block__BeginAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3952:1: ( ( ( '{' ) ) )
            // InternalTextualScenario.g:3953:2: ( ( '{' ) )
            {
            // InternalTextualScenario.g:3953:2: ( ( '{' ) )
            // InternalTextualScenario.g:3954:3: ( '{' )
            {
             before(grammarAccess.getBlockAccess().getBeginLeftCurlyBracketKeyword_0_0()); 
            // InternalTextualScenario.g:3955:3: ( '{' )
            // InternalTextualScenario.g:3956:4: '{'
            {
             before(grammarAccess.getBlockAccess().getBeginLeftCurlyBracketKeyword_0_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalTextualScenario.g:3967:1: rule__Block__BlockElementsAssignment_1 : ( ruleElement ) ;
    public final void rule__Block__BlockElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3971:1: ( ( ruleElement ) )
            // InternalTextualScenario.g:3972:2: ( ruleElement )
            {
            // InternalTextualScenario.g:3972:2: ( ruleElement )
            // InternalTextualScenario.g:3973:3: ruleElement
            {
             before(grammarAccess.getBlockAccess().getBlockElementsElementParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getBlockAccess().getBlockElementsElementParserRuleCall_1_0()); 

            }


            }

        }
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
    // InternalTextualScenario.g:3982:1: rule__Block__EndAssignment_2 : ( ( '}' ) ) ;
    public final void rule__Block__EndAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3986:1: ( ( ( '}' ) ) )
            // InternalTextualScenario.g:3987:2: ( ( '}' ) )
            {
            // InternalTextualScenario.g:3987:2: ( ( '}' ) )
            // InternalTextualScenario.g:3988:3: ( '}' )
            {
             before(grammarAccess.getBlockAccess().getEndRightCurlyBracketKeyword_2_0()); 
            // InternalTextualScenario.g:3989:3: ( '}' )
            // InternalTextualScenario.g:3990:4: '}'
            {
             before(grammarAccess.getBlockAccess().getEndRightCurlyBracketKeyword_2_0()); 
            match(input,27,FOLLOW_2); 
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
    // InternalTextualScenario.g:4001:1: rule__StateFragment__OnAssignment_0 : ( ( 'on' ) ) ;
    public final void rule__StateFragment__OnAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:4005:1: ( ( ( 'on' ) ) )
            // InternalTextualScenario.g:4006:2: ( ( 'on' ) )
            {
            // InternalTextualScenario.g:4006:2: ( ( 'on' ) )
            // InternalTextualScenario.g:4007:3: ( 'on' )
            {
             before(grammarAccess.getStateFragmentAccess().getOnOnKeyword_0_0()); 
            // InternalTextualScenario.g:4008:3: ( 'on' )
            // InternalTextualScenario.g:4009:4: 'on'
            {
             before(grammarAccess.getStateFragmentAccess().getOnOnKeyword_0_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalTextualScenario.g:4020:1: rule__StateFragment__TimelineAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StateFragment__TimelineAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:4024:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:4025:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:4025:2: ( RULE_STRING )
            // InternalTextualScenario.g:4026:3: RULE_STRING
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
    // InternalTextualScenario.g:4035:1: rule__StateFragment__KeywordAssignment_2 : ( ( rule__StateFragment__KeywordAlternatives_2_0 ) ) ;
    public final void rule__StateFragment__KeywordAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:4039:1: ( ( ( rule__StateFragment__KeywordAlternatives_2_0 ) ) )
            // InternalTextualScenario.g:4040:2: ( ( rule__StateFragment__KeywordAlternatives_2_0 ) )
            {
            // InternalTextualScenario.g:4040:2: ( ( rule__StateFragment__KeywordAlternatives_2_0 ) )
            // InternalTextualScenario.g:4041:3: ( rule__StateFragment__KeywordAlternatives_2_0 )
            {
             before(grammarAccess.getStateFragmentAccess().getKeywordAlternatives_2_0()); 
            // InternalTextualScenario.g:4042:3: ( rule__StateFragment__KeywordAlternatives_2_0 )
            // InternalTextualScenario.g:4042:4: rule__StateFragment__KeywordAlternatives_2_0
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
    // InternalTextualScenario.g:4050:1: rule__StateFragment__NameAssignment_3 : ( RULE_STRING ) ;
    public final void rule__StateFragment__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:4054:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:4055:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:4055:2: ( RULE_STRING )
            // InternalTextualScenario.g:4056:3: RULE_STRING
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


    // $ANTLR start "rule__Reference__KeywordAssignment_0"
    // InternalTextualScenario.g:4065:1: rule__Reference__KeywordAssignment_0 : ( ( 'ref' ) ) ;
    public final void rule__Reference__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:4069:1: ( ( ( 'ref' ) ) )
            // InternalTextualScenario.g:4070:2: ( ( 'ref' ) )
            {
            // InternalTextualScenario.g:4070:2: ( ( 'ref' ) )
            // InternalTextualScenario.g:4071:3: ( 'ref' )
            {
             before(grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0()); 
            // InternalTextualScenario.g:4072:3: ( 'ref' )
            // InternalTextualScenario.g:4073:4: 'ref'
            {
             before(grammarAccess.getReferenceAccess().getKeywordRefKeyword_0_0()); 
            match(input,47,FOLLOW_2); 
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


    // $ANTLR start "rule__Reference__NameAssignment_1"
    // InternalTextualScenario.g:4084:1: rule__Reference__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Reference__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:4088:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:4089:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:4089:2: ( RULE_STRING )
            // InternalTextualScenario.g:4090:3: RULE_STRING
            {
             before(grammarAccess.getReferenceAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__NameAssignment_1"


    // $ANTLR start "rule__Reference__OverAssignment_2"
    // InternalTextualScenario.g:4099:1: rule__Reference__OverAssignment_2 : ( ( 'over' ) ) ;
    public final void rule__Reference__OverAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:4103:1: ( ( ( 'over' ) ) )
            // InternalTextualScenario.g:4104:2: ( ( 'over' ) )
            {
            // InternalTextualScenario.g:4104:2: ( ( 'over' ) )
            // InternalTextualScenario.g:4105:3: ( 'over' )
            {
             before(grammarAccess.getReferenceAccess().getOverOverKeyword_2_0()); 
            // InternalTextualScenario.g:4106:3: ( 'over' )
            // InternalTextualScenario.g:4107:4: 'over'
            {
             before(grammarAccess.getReferenceAccess().getOverOverKeyword_2_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getOverOverKeyword_2_0()); 

            }

             after(grammarAccess.getReferenceAccess().getOverOverKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__OverAssignment_2"


    // $ANTLR start "rule__Reference__TimelinesAssignment_3"
    // InternalTextualScenario.g:4118:1: rule__Reference__TimelinesAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Reference__TimelinesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:4122:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:4123:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:4123:2: ( RULE_STRING )
            // InternalTextualScenario.g:4124:3: RULE_STRING
            {
             before(grammarAccess.getReferenceAccess().getTimelinesSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getTimelinesSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__TimelinesAssignment_3"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000CF03F93FF810L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000003F1000002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000CF00003FF812L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000003800000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000002800000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000100000000010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000200004000010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000200004000012L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000CF00083FF810L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001C00000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000100000000000L});

}
