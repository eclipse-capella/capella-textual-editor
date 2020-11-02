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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'alt'", "'loop'", "'par'", "'assert'", "'critical'", "'ignore'", "'neg'", "'opt'", "'seq'", "'strict'", "'unset'", "'state'", "'mode'", "'function'", "'scenario'", "'{'", "'}'", "'actor'", "'component'", "'configuration_item'", "'activity'", "'entity'", "'role'", "'->'", "'withExecution'", "'withReturn'", "':'", "'->+'", "'->x'", "'->>'", "'deactivate'", "'over'", "'else'", "'on'"
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


    // $ANTLR start "entryRuleParticipantDeactivation"
    // InternalTextualScenario.g:503:1: entryRuleParticipantDeactivation : ruleParticipantDeactivation EOF ;
    public final void entryRuleParticipantDeactivation() throws RecognitionException {
        try {
            // InternalTextualScenario.g:504:1: ( ruleParticipantDeactivation EOF )
            // InternalTextualScenario.g:505:1: ruleParticipantDeactivation EOF
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
    // InternalTextualScenario.g:512:1: ruleParticipantDeactivation : ( ( rule__ParticipantDeactivation__Group__0 ) ) ;
    public final void ruleParticipantDeactivation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:516:2: ( ( ( rule__ParticipantDeactivation__Group__0 ) ) )
            // InternalTextualScenario.g:517:2: ( ( rule__ParticipantDeactivation__Group__0 ) )
            {
            // InternalTextualScenario.g:517:2: ( ( rule__ParticipantDeactivation__Group__0 ) )
            // InternalTextualScenario.g:518:3: ( rule__ParticipantDeactivation__Group__0 )
            {
             before(grammarAccess.getParticipantDeactivationAccess().getGroup()); 
            // InternalTextualScenario.g:519:3: ( rule__ParticipantDeactivation__Group__0 )
            // InternalTextualScenario.g:519:4: rule__ParticipantDeactivation__Group__0
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


    // $ANTLR start "rule__Participant__Alternatives"
    // InternalTextualScenario.g:627:1: rule__Participant__Alternatives : ( ( ruleGenericComponent ) | ( ruleGenericFunction ) );
    public final void rule__Participant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:631:1: ( ( ruleGenericComponent ) | ( ruleGenericFunction ) )
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
                    // InternalTextualScenario.g:632:2: ( ruleGenericComponent )
                    {
                    // InternalTextualScenario.g:632:2: ( ruleGenericComponent )
                    // InternalTextualScenario.g:633:3: ruleGenericComponent
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
                    // InternalTextualScenario.g:638:2: ( ruleGenericFunction )
                    {
                    // InternalTextualScenario.g:638:2: ( ruleGenericFunction )
                    // InternalTextualScenario.g:639:3: ruleGenericFunction
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
    // InternalTextualScenario.g:648:1: rule__GenericComponent__Alternatives : ( ( ruleEntity ) | ( ruleActor ) | ( ruleComponent ) | ( ruleConfigurationItem ) | ( ruleRole ) );
    public final void rule__GenericComponent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:652:1: ( ( ruleEntity ) | ( ruleActor ) | ( ruleComponent ) | ( ruleConfigurationItem ) | ( ruleRole ) )
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
                    // InternalTextualScenario.g:653:2: ( ruleEntity )
                    {
                    // InternalTextualScenario.g:653:2: ( ruleEntity )
                    // InternalTextualScenario.g:654:3: ruleEntity
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
                    // InternalTextualScenario.g:659:2: ( ruleActor )
                    {
                    // InternalTextualScenario.g:659:2: ( ruleActor )
                    // InternalTextualScenario.g:660:3: ruleActor
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
                    // InternalTextualScenario.g:665:2: ( ruleComponent )
                    {
                    // InternalTextualScenario.g:665:2: ( ruleComponent )
                    // InternalTextualScenario.g:666:3: ruleComponent
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
                    // InternalTextualScenario.g:671:2: ( ruleConfigurationItem )
                    {
                    // InternalTextualScenario.g:671:2: ( ruleConfigurationItem )
                    // InternalTextualScenario.g:672:3: ruleConfigurationItem
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
                    // InternalTextualScenario.g:677:2: ( ruleRole )
                    {
                    // InternalTextualScenario.g:677:2: ( ruleRole )
                    // InternalTextualScenario.g:678:3: ruleRole
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
    // InternalTextualScenario.g:687:1: rule__GenericFunction__Alternatives : ( ( ruleFunction ) | ( ruleActivity ) );
    public final void rule__GenericFunction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:691:1: ( ( ruleFunction ) | ( ruleActivity ) )
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
                    // InternalTextualScenario.g:692:2: ( ruleFunction )
                    {
                    // InternalTextualScenario.g:692:2: ( ruleFunction )
                    // InternalTextualScenario.g:693:3: ruleFunction
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
                    // InternalTextualScenario.g:698:2: ( ruleActivity )
                    {
                    // InternalTextualScenario.g:698:2: ( ruleActivity )
                    // InternalTextualScenario.g:699:3: ruleActivity
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
    // InternalTextualScenario.g:708:1: rule__Element__Alternatives : ( ( ruleMessage ) | ( ruleCombinedFragment ) | ( ruleStateFragment ) );
    public final void rule__Element__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:712:1: ( ( ruleMessage ) | ( ruleCombinedFragment ) | ( ruleStateFragment ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case 40:
            case 41:
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
            case 44:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalTextualScenario.g:713:2: ( ruleMessage )
                    {
                    // InternalTextualScenario.g:713:2: ( ruleMessage )
                    // InternalTextualScenario.g:714:3: ruleMessage
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
                    // InternalTextualScenario.g:719:2: ( ruleCombinedFragment )
                    {
                    // InternalTextualScenario.g:719:2: ( ruleCombinedFragment )
                    // InternalTextualScenario.g:720:3: ruleCombinedFragment
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
                    // InternalTextualScenario.g:725:2: ( ruleStateFragment )
                    {
                    // InternalTextualScenario.g:725:2: ( ruleStateFragment )
                    // InternalTextualScenario.g:726:3: ruleStateFragment
                    {
                     before(grammarAccess.getElementAccess().getStateFragmentParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleStateFragment();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getStateFragmentParserRuleCall_2()); 

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
    // InternalTextualScenario.g:735:1: rule__Message__Alternatives : ( ( ruleSequenceMessageType ) | ( ruleArmTimerMessage ) | ( ruleParticipantDeactivation ) );
    public final void rule__Message__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:739:1: ( ( ruleSequenceMessageType ) | ( ruleArmTimerMessage ) | ( ruleParticipantDeactivation ) )
            int alt5=3;
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
            case 41:
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
                    // InternalTextualScenario.g:740:2: ( ruleSequenceMessageType )
                    {
                    // InternalTextualScenario.g:740:2: ( ruleSequenceMessageType )
                    // InternalTextualScenario.g:741:3: ruleSequenceMessageType
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
                    // InternalTextualScenario.g:746:2: ( ruleArmTimerMessage )
                    {
                    // InternalTextualScenario.g:746:2: ( ruleArmTimerMessage )
                    // InternalTextualScenario.g:747:3: ruleArmTimerMessage
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
                    // InternalTextualScenario.g:752:2: ( ruleParticipantDeactivation )
                    {
                    // InternalTextualScenario.g:752:2: ( ruleParticipantDeactivation )
                    // InternalTextualScenario.g:753:3: ruleParticipantDeactivation
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
    // InternalTextualScenario.g:762:1: rule__SequenceMessageType__Alternatives : ( ( ruleSequenceMessage ) | ( ruleCreateMessage ) | ( ruleDeleteMessage ) );
    public final void rule__SequenceMessageType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:766:1: ( ( ruleSequenceMessage ) | ( ruleCreateMessage ) | ( ruleDeleteMessage ) )
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
                    // InternalTextualScenario.g:767:2: ( ruleSequenceMessage )
                    {
                    // InternalTextualScenario.g:767:2: ( ruleSequenceMessage )
                    // InternalTextualScenario.g:768:3: ruleSequenceMessage
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
                    // InternalTextualScenario.g:773:2: ( ruleCreateMessage )
                    {
                    // InternalTextualScenario.g:773:2: ( ruleCreateMessage )
                    // InternalTextualScenario.g:774:3: ruleCreateMessage
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
                    // InternalTextualScenario.g:779:2: ( ruleDeleteMessage )
                    {
                    // InternalTextualScenario.g:779:2: ( ruleDeleteMessage )
                    // InternalTextualScenario.g:780:3: ruleDeleteMessage
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
    // InternalTextualScenario.g:789:1: rule__CombinedFragment__KeywordAlternatives_0_0 : ( ( 'alt' ) | ( 'loop' ) | ( 'par' ) | ( 'assert' ) | ( 'critical' ) | ( 'ignore' ) | ( 'neg' ) | ( 'opt' ) | ( 'seq' ) | ( 'strict' ) | ( 'unset' ) );
    public final void rule__CombinedFragment__KeywordAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:793:1: ( ( 'alt' ) | ( 'loop' ) | ( 'par' ) | ( 'assert' ) | ( 'critical' ) | ( 'ignore' ) | ( 'neg' ) | ( 'opt' ) | ( 'seq' ) | ( 'strict' ) | ( 'unset' ) )
            int alt7=11;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt7=1;
                }
                break;
            case 12:
                {
                alt7=2;
                }
                break;
            case 13:
                {
                alt7=3;
                }
                break;
            case 14:
                {
                alt7=4;
                }
                break;
            case 15:
                {
                alt7=5;
                }
                break;
            case 16:
                {
                alt7=6;
                }
                break;
            case 17:
                {
                alt7=7;
                }
                break;
            case 18:
                {
                alt7=8;
                }
                break;
            case 19:
                {
                alt7=9;
                }
                break;
            case 20:
                {
                alt7=10;
                }
                break;
            case 21:
                {
                alt7=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalTextualScenario.g:794:2: ( 'alt' )
                    {
                    // InternalTextualScenario.g:794:2: ( 'alt' )
                    // InternalTextualScenario.g:795:3: 'alt'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordAltKeyword_0_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordAltKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:800:2: ( 'loop' )
                    {
                    // InternalTextualScenario.g:800:2: ( 'loop' )
                    // InternalTextualScenario.g:801:3: 'loop'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordLoopKeyword_0_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordLoopKeyword_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:806:2: ( 'par' )
                    {
                    // InternalTextualScenario.g:806:2: ( 'par' )
                    // InternalTextualScenario.g:807:3: 'par'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordParKeyword_0_0_2()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordParKeyword_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTextualScenario.g:812:2: ( 'assert' )
                    {
                    // InternalTextualScenario.g:812:2: ( 'assert' )
                    // InternalTextualScenario.g:813:3: 'assert'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordAssertKeyword_0_0_3()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordAssertKeyword_0_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalTextualScenario.g:818:2: ( 'critical' )
                    {
                    // InternalTextualScenario.g:818:2: ( 'critical' )
                    // InternalTextualScenario.g:819:3: 'critical'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordCriticalKeyword_0_0_4()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordCriticalKeyword_0_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalTextualScenario.g:824:2: ( 'ignore' )
                    {
                    // InternalTextualScenario.g:824:2: ( 'ignore' )
                    // InternalTextualScenario.g:825:3: 'ignore'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordIgnoreKeyword_0_0_5()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordIgnoreKeyword_0_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalTextualScenario.g:830:2: ( 'neg' )
                    {
                    // InternalTextualScenario.g:830:2: ( 'neg' )
                    // InternalTextualScenario.g:831:3: 'neg'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordNegKeyword_0_0_6()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordNegKeyword_0_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalTextualScenario.g:836:2: ( 'opt' )
                    {
                    // InternalTextualScenario.g:836:2: ( 'opt' )
                    // InternalTextualScenario.g:837:3: 'opt'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordOptKeyword_0_0_7()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordOptKeyword_0_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalTextualScenario.g:842:2: ( 'seq' )
                    {
                    // InternalTextualScenario.g:842:2: ( 'seq' )
                    // InternalTextualScenario.g:843:3: 'seq'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordSeqKeyword_0_0_8()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordSeqKeyword_0_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalTextualScenario.g:848:2: ( 'strict' )
                    {
                    // InternalTextualScenario.g:848:2: ( 'strict' )
                    // InternalTextualScenario.g:849:3: 'strict'
                    {
                     before(grammarAccess.getCombinedFragmentAccess().getKeywordStrictKeyword_0_0_9()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getCombinedFragmentAccess().getKeywordStrictKeyword_0_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalTextualScenario.g:854:2: ( 'unset' )
                    {
                    // InternalTextualScenario.g:854:2: ( 'unset' )
                    // InternalTextualScenario.g:855:3: 'unset'
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
    // InternalTextualScenario.g:864:1: rule__StateFragment__KeywordAlternatives_2_0 : ( ( 'state' ) | ( 'mode' ) | ( 'function' ) );
    public final void rule__StateFragment__KeywordAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:868:1: ( ( 'state' ) | ( 'mode' ) | ( 'function' ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt8=1;
                }
                break;
            case 23:
                {
                alt8=2;
                }
                break;
            case 24:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalTextualScenario.g:869:2: ( 'state' )
                    {
                    // InternalTextualScenario.g:869:2: ( 'state' )
                    // InternalTextualScenario.g:870:3: 'state'
                    {
                     before(grammarAccess.getStateFragmentAccess().getKeywordStateKeyword_2_0_0()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getStateFragmentAccess().getKeywordStateKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTextualScenario.g:875:2: ( 'mode' )
                    {
                    // InternalTextualScenario.g:875:2: ( 'mode' )
                    // InternalTextualScenario.g:876:3: 'mode'
                    {
                     before(grammarAccess.getStateFragmentAccess().getKeywordModeKeyword_2_0_1()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getStateFragmentAccess().getKeywordModeKeyword_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTextualScenario.g:881:2: ( 'function' )
                    {
                    // InternalTextualScenario.g:881:2: ( 'function' )
                    // InternalTextualScenario.g:882:3: 'function'
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
    // InternalTextualScenario.g:891:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:895:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalTextualScenario.g:896:2: rule__Model__Group__0__Impl rule__Model__Group__1
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
    // InternalTextualScenario.g:903:1: rule__Model__Group__0__Impl : ( 'scenario' ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:907:1: ( ( 'scenario' ) )
            // InternalTextualScenario.g:908:1: ( 'scenario' )
            {
            // InternalTextualScenario.g:908:1: ( 'scenario' )
            // InternalTextualScenario.g:909:2: 'scenario'
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
    // InternalTextualScenario.g:918:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:922:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalTextualScenario.g:923:2: rule__Model__Group__1__Impl rule__Model__Group__2
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
    // InternalTextualScenario.g:930:1: rule__Model__Group__1__Impl : ( ( rule__Model__BeginAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:934:1: ( ( ( rule__Model__BeginAssignment_1 ) ) )
            // InternalTextualScenario.g:935:1: ( ( rule__Model__BeginAssignment_1 ) )
            {
            // InternalTextualScenario.g:935:1: ( ( rule__Model__BeginAssignment_1 ) )
            // InternalTextualScenario.g:936:2: ( rule__Model__BeginAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getBeginAssignment_1()); 
            // InternalTextualScenario.g:937:2: ( rule__Model__BeginAssignment_1 )
            // InternalTextualScenario.g:937:3: rule__Model__BeginAssignment_1
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
    // InternalTextualScenario.g:945:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:949:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalTextualScenario.g:950:2: rule__Model__Group__2__Impl rule__Model__Group__3
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
    // InternalTextualScenario.g:957:1: rule__Model__Group__2__Impl : ( ( rule__Model__ParticipantsAssignment_2 )* ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:961:1: ( ( ( rule__Model__ParticipantsAssignment_2 )* ) )
            // InternalTextualScenario.g:962:1: ( ( rule__Model__ParticipantsAssignment_2 )* )
            {
            // InternalTextualScenario.g:962:1: ( ( rule__Model__ParticipantsAssignment_2 )* )
            // InternalTextualScenario.g:963:2: ( rule__Model__ParticipantsAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getParticipantsAssignment_2()); 
            // InternalTextualScenario.g:964:2: ( rule__Model__ParticipantsAssignment_2 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==24||(LA9_0>=28 && LA9_0<=33)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalTextualScenario.g:964:3: rule__Model__ParticipantsAssignment_2
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Model__ParticipantsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // InternalTextualScenario.g:972:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:976:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // InternalTextualScenario.g:977:2: rule__Model__Group__3__Impl rule__Model__Group__4
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
    // InternalTextualScenario.g:984:1: rule__Model__Group__3__Impl : ( ( rule__Model__ElementsAssignment_3 )* ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:988:1: ( ( ( rule__Model__ElementsAssignment_3 )* ) )
            // InternalTextualScenario.g:989:1: ( ( rule__Model__ElementsAssignment_3 )* )
            {
            // InternalTextualScenario.g:989:1: ( ( rule__Model__ElementsAssignment_3 )* )
            // InternalTextualScenario.g:990:2: ( rule__Model__ElementsAssignment_3 )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment_3()); 
            // InternalTextualScenario.g:991:2: ( rule__Model__ElementsAssignment_3 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_STRING||(LA10_0>=11 && LA10_0<=21)||(LA10_0>=40 && LA10_0<=41)||LA10_0==44) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalTextualScenario.g:991:3: rule__Model__ElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Model__ElementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // InternalTextualScenario.g:999:1: rule__Model__Group__4 : rule__Model__Group__4__Impl ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1003:1: ( rule__Model__Group__4__Impl )
            // InternalTextualScenario.g:1004:2: rule__Model__Group__4__Impl
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
    // InternalTextualScenario.g:1010:1: rule__Model__Group__4__Impl : ( ( rule__Model__EndAssignment_4 ) ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1014:1: ( ( ( rule__Model__EndAssignment_4 ) ) )
            // InternalTextualScenario.g:1015:1: ( ( rule__Model__EndAssignment_4 ) )
            {
            // InternalTextualScenario.g:1015:1: ( ( rule__Model__EndAssignment_4 ) )
            // InternalTextualScenario.g:1016:2: ( rule__Model__EndAssignment_4 )
            {
             before(grammarAccess.getModelAccess().getEndAssignment_4()); 
            // InternalTextualScenario.g:1017:2: ( rule__Model__EndAssignment_4 )
            // InternalTextualScenario.g:1017:3: rule__Model__EndAssignment_4
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
    // InternalTextualScenario.g:1026:1: rule__Actor__Group__0 : rule__Actor__Group__0__Impl rule__Actor__Group__1 ;
    public final void rule__Actor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1030:1: ( rule__Actor__Group__0__Impl rule__Actor__Group__1 )
            // InternalTextualScenario.g:1031:2: rule__Actor__Group__0__Impl rule__Actor__Group__1
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
    // InternalTextualScenario.g:1038:1: rule__Actor__Group__0__Impl : ( ( rule__Actor__KeywordAssignment_0 ) ) ;
    public final void rule__Actor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1042:1: ( ( ( rule__Actor__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1043:1: ( ( rule__Actor__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1043:1: ( ( rule__Actor__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1044:2: ( rule__Actor__KeywordAssignment_0 )
            {
             before(grammarAccess.getActorAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1045:2: ( rule__Actor__KeywordAssignment_0 )
            // InternalTextualScenario.g:1045:3: rule__Actor__KeywordAssignment_0
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
    // InternalTextualScenario.g:1053:1: rule__Actor__Group__1 : rule__Actor__Group__1__Impl ;
    public final void rule__Actor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1057:1: ( rule__Actor__Group__1__Impl )
            // InternalTextualScenario.g:1058:2: rule__Actor__Group__1__Impl
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
    // InternalTextualScenario.g:1064:1: rule__Actor__Group__1__Impl : ( ( rule__Actor__NameAssignment_1 ) ) ;
    public final void rule__Actor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1068:1: ( ( ( rule__Actor__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1069:1: ( ( rule__Actor__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1069:1: ( ( rule__Actor__NameAssignment_1 ) )
            // InternalTextualScenario.g:1070:2: ( rule__Actor__NameAssignment_1 )
            {
             before(grammarAccess.getActorAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1071:2: ( rule__Actor__NameAssignment_1 )
            // InternalTextualScenario.g:1071:3: rule__Actor__NameAssignment_1
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
    // InternalTextualScenario.g:1080:1: rule__Component__Group__0 : rule__Component__Group__0__Impl rule__Component__Group__1 ;
    public final void rule__Component__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1084:1: ( rule__Component__Group__0__Impl rule__Component__Group__1 )
            // InternalTextualScenario.g:1085:2: rule__Component__Group__0__Impl rule__Component__Group__1
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
    // InternalTextualScenario.g:1092:1: rule__Component__Group__0__Impl : ( ( rule__Component__KeywordAssignment_0 ) ) ;
    public final void rule__Component__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1096:1: ( ( ( rule__Component__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1097:1: ( ( rule__Component__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1097:1: ( ( rule__Component__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1098:2: ( rule__Component__KeywordAssignment_0 )
            {
             before(grammarAccess.getComponentAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1099:2: ( rule__Component__KeywordAssignment_0 )
            // InternalTextualScenario.g:1099:3: rule__Component__KeywordAssignment_0
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
    // InternalTextualScenario.g:1107:1: rule__Component__Group__1 : rule__Component__Group__1__Impl ;
    public final void rule__Component__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1111:1: ( rule__Component__Group__1__Impl )
            // InternalTextualScenario.g:1112:2: rule__Component__Group__1__Impl
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
    // InternalTextualScenario.g:1118:1: rule__Component__Group__1__Impl : ( ( rule__Component__NameAssignment_1 ) ) ;
    public final void rule__Component__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1122:1: ( ( ( rule__Component__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1123:1: ( ( rule__Component__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1123:1: ( ( rule__Component__NameAssignment_1 ) )
            // InternalTextualScenario.g:1124:2: ( rule__Component__NameAssignment_1 )
            {
             before(grammarAccess.getComponentAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1125:2: ( rule__Component__NameAssignment_1 )
            // InternalTextualScenario.g:1125:3: rule__Component__NameAssignment_1
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
    // InternalTextualScenario.g:1134:1: rule__ConfigurationItem__Group__0 : rule__ConfigurationItem__Group__0__Impl rule__ConfigurationItem__Group__1 ;
    public final void rule__ConfigurationItem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1138:1: ( rule__ConfigurationItem__Group__0__Impl rule__ConfigurationItem__Group__1 )
            // InternalTextualScenario.g:1139:2: rule__ConfigurationItem__Group__0__Impl rule__ConfigurationItem__Group__1
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
    // InternalTextualScenario.g:1146:1: rule__ConfigurationItem__Group__0__Impl : ( ( rule__ConfigurationItem__KeywordAssignment_0 ) ) ;
    public final void rule__ConfigurationItem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1150:1: ( ( ( rule__ConfigurationItem__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1151:1: ( ( rule__ConfigurationItem__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1151:1: ( ( rule__ConfigurationItem__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1152:2: ( rule__ConfigurationItem__KeywordAssignment_0 )
            {
             before(grammarAccess.getConfigurationItemAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1153:2: ( rule__ConfigurationItem__KeywordAssignment_0 )
            // InternalTextualScenario.g:1153:3: rule__ConfigurationItem__KeywordAssignment_0
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
    // InternalTextualScenario.g:1161:1: rule__ConfigurationItem__Group__1 : rule__ConfigurationItem__Group__1__Impl ;
    public final void rule__ConfigurationItem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1165:1: ( rule__ConfigurationItem__Group__1__Impl )
            // InternalTextualScenario.g:1166:2: rule__ConfigurationItem__Group__1__Impl
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
    // InternalTextualScenario.g:1172:1: rule__ConfigurationItem__Group__1__Impl : ( ( rule__ConfigurationItem__NameAssignment_1 ) ) ;
    public final void rule__ConfigurationItem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1176:1: ( ( ( rule__ConfigurationItem__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1177:1: ( ( rule__ConfigurationItem__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1177:1: ( ( rule__ConfigurationItem__NameAssignment_1 ) )
            // InternalTextualScenario.g:1178:2: ( rule__ConfigurationItem__NameAssignment_1 )
            {
             before(grammarAccess.getConfigurationItemAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1179:2: ( rule__ConfigurationItem__NameAssignment_1 )
            // InternalTextualScenario.g:1179:3: rule__ConfigurationItem__NameAssignment_1
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
    // InternalTextualScenario.g:1188:1: rule__Function__Group__0 : rule__Function__Group__0__Impl rule__Function__Group__1 ;
    public final void rule__Function__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1192:1: ( rule__Function__Group__0__Impl rule__Function__Group__1 )
            // InternalTextualScenario.g:1193:2: rule__Function__Group__0__Impl rule__Function__Group__1
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
    // InternalTextualScenario.g:1200:1: rule__Function__Group__0__Impl : ( ( rule__Function__KeywordAssignment_0 ) ) ;
    public final void rule__Function__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1204:1: ( ( ( rule__Function__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1205:1: ( ( rule__Function__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1205:1: ( ( rule__Function__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1206:2: ( rule__Function__KeywordAssignment_0 )
            {
             before(grammarAccess.getFunctionAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1207:2: ( rule__Function__KeywordAssignment_0 )
            // InternalTextualScenario.g:1207:3: rule__Function__KeywordAssignment_0
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
    // InternalTextualScenario.g:1215:1: rule__Function__Group__1 : rule__Function__Group__1__Impl ;
    public final void rule__Function__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1219:1: ( rule__Function__Group__1__Impl )
            // InternalTextualScenario.g:1220:2: rule__Function__Group__1__Impl
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
    // InternalTextualScenario.g:1226:1: rule__Function__Group__1__Impl : ( ( rule__Function__NameAssignment_1 ) ) ;
    public final void rule__Function__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1230:1: ( ( ( rule__Function__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1231:1: ( ( rule__Function__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1231:1: ( ( rule__Function__NameAssignment_1 ) )
            // InternalTextualScenario.g:1232:2: ( rule__Function__NameAssignment_1 )
            {
             before(grammarAccess.getFunctionAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1233:2: ( rule__Function__NameAssignment_1 )
            // InternalTextualScenario.g:1233:3: rule__Function__NameAssignment_1
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
    // InternalTextualScenario.g:1242:1: rule__Activity__Group__0 : rule__Activity__Group__0__Impl rule__Activity__Group__1 ;
    public final void rule__Activity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1246:1: ( rule__Activity__Group__0__Impl rule__Activity__Group__1 )
            // InternalTextualScenario.g:1247:2: rule__Activity__Group__0__Impl rule__Activity__Group__1
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
    // InternalTextualScenario.g:1254:1: rule__Activity__Group__0__Impl : ( ( rule__Activity__KeywordAssignment_0 ) ) ;
    public final void rule__Activity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1258:1: ( ( ( rule__Activity__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1259:1: ( ( rule__Activity__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1259:1: ( ( rule__Activity__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1260:2: ( rule__Activity__KeywordAssignment_0 )
            {
             before(grammarAccess.getActivityAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1261:2: ( rule__Activity__KeywordAssignment_0 )
            // InternalTextualScenario.g:1261:3: rule__Activity__KeywordAssignment_0
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
    // InternalTextualScenario.g:1269:1: rule__Activity__Group__1 : rule__Activity__Group__1__Impl ;
    public final void rule__Activity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1273:1: ( rule__Activity__Group__1__Impl )
            // InternalTextualScenario.g:1274:2: rule__Activity__Group__1__Impl
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
    // InternalTextualScenario.g:1280:1: rule__Activity__Group__1__Impl : ( ( rule__Activity__NameAssignment_1 ) ) ;
    public final void rule__Activity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1284:1: ( ( ( rule__Activity__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1285:1: ( ( rule__Activity__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1285:1: ( ( rule__Activity__NameAssignment_1 ) )
            // InternalTextualScenario.g:1286:2: ( rule__Activity__NameAssignment_1 )
            {
             before(grammarAccess.getActivityAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1287:2: ( rule__Activity__NameAssignment_1 )
            // InternalTextualScenario.g:1287:3: rule__Activity__NameAssignment_1
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
    // InternalTextualScenario.g:1296:1: rule__Entity__Group__0 : rule__Entity__Group__0__Impl rule__Entity__Group__1 ;
    public final void rule__Entity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1300:1: ( rule__Entity__Group__0__Impl rule__Entity__Group__1 )
            // InternalTextualScenario.g:1301:2: rule__Entity__Group__0__Impl rule__Entity__Group__1
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
    // InternalTextualScenario.g:1308:1: rule__Entity__Group__0__Impl : ( ( rule__Entity__KeywordAssignment_0 ) ) ;
    public final void rule__Entity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1312:1: ( ( ( rule__Entity__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1313:1: ( ( rule__Entity__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1313:1: ( ( rule__Entity__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1314:2: ( rule__Entity__KeywordAssignment_0 )
            {
             before(grammarAccess.getEntityAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1315:2: ( rule__Entity__KeywordAssignment_0 )
            // InternalTextualScenario.g:1315:3: rule__Entity__KeywordAssignment_0
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
    // InternalTextualScenario.g:1323:1: rule__Entity__Group__1 : rule__Entity__Group__1__Impl ;
    public final void rule__Entity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1327:1: ( rule__Entity__Group__1__Impl )
            // InternalTextualScenario.g:1328:2: rule__Entity__Group__1__Impl
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
    // InternalTextualScenario.g:1334:1: rule__Entity__Group__1__Impl : ( ( rule__Entity__NameAssignment_1 ) ) ;
    public final void rule__Entity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1338:1: ( ( ( rule__Entity__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1339:1: ( ( rule__Entity__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1339:1: ( ( rule__Entity__NameAssignment_1 ) )
            // InternalTextualScenario.g:1340:2: ( rule__Entity__NameAssignment_1 )
            {
             before(grammarAccess.getEntityAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1341:2: ( rule__Entity__NameAssignment_1 )
            // InternalTextualScenario.g:1341:3: rule__Entity__NameAssignment_1
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
    // InternalTextualScenario.g:1350:1: rule__Role__Group__0 : rule__Role__Group__0__Impl rule__Role__Group__1 ;
    public final void rule__Role__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1354:1: ( rule__Role__Group__0__Impl rule__Role__Group__1 )
            // InternalTextualScenario.g:1355:2: rule__Role__Group__0__Impl rule__Role__Group__1
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
    // InternalTextualScenario.g:1362:1: rule__Role__Group__0__Impl : ( ( rule__Role__KeywordAssignment_0 ) ) ;
    public final void rule__Role__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1366:1: ( ( ( rule__Role__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:1367:1: ( ( rule__Role__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:1367:1: ( ( rule__Role__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:1368:2: ( rule__Role__KeywordAssignment_0 )
            {
             before(grammarAccess.getRoleAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:1369:2: ( rule__Role__KeywordAssignment_0 )
            // InternalTextualScenario.g:1369:3: rule__Role__KeywordAssignment_0
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
    // InternalTextualScenario.g:1377:1: rule__Role__Group__1 : rule__Role__Group__1__Impl ;
    public final void rule__Role__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1381:1: ( rule__Role__Group__1__Impl )
            // InternalTextualScenario.g:1382:2: rule__Role__Group__1__Impl
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
    // InternalTextualScenario.g:1388:1: rule__Role__Group__1__Impl : ( ( rule__Role__NameAssignment_1 ) ) ;
    public final void rule__Role__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1392:1: ( ( ( rule__Role__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:1393:1: ( ( rule__Role__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:1393:1: ( ( rule__Role__NameAssignment_1 ) )
            // InternalTextualScenario.g:1394:2: ( rule__Role__NameAssignment_1 )
            {
             before(grammarAccess.getRoleAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:1395:2: ( rule__Role__NameAssignment_1 )
            // InternalTextualScenario.g:1395:3: rule__Role__NameAssignment_1
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
    // InternalTextualScenario.g:1404:1: rule__SequenceMessage__Group__0 : rule__SequenceMessage__Group__0__Impl rule__SequenceMessage__Group__1 ;
    public final void rule__SequenceMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1408:1: ( rule__SequenceMessage__Group__0__Impl rule__SequenceMessage__Group__1 )
            // InternalTextualScenario.g:1409:2: rule__SequenceMessage__Group__0__Impl rule__SequenceMessage__Group__1
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
    // InternalTextualScenario.g:1416:1: rule__SequenceMessage__Group__0__Impl : ( ( rule__SequenceMessage__SourceAssignment_0 ) ) ;
    public final void rule__SequenceMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1420:1: ( ( ( rule__SequenceMessage__SourceAssignment_0 ) ) )
            // InternalTextualScenario.g:1421:1: ( ( rule__SequenceMessage__SourceAssignment_0 ) )
            {
            // InternalTextualScenario.g:1421:1: ( ( rule__SequenceMessage__SourceAssignment_0 ) )
            // InternalTextualScenario.g:1422:2: ( rule__SequenceMessage__SourceAssignment_0 )
            {
             before(grammarAccess.getSequenceMessageAccess().getSourceAssignment_0()); 
            // InternalTextualScenario.g:1423:2: ( rule__SequenceMessage__SourceAssignment_0 )
            // InternalTextualScenario.g:1423:3: rule__SequenceMessage__SourceAssignment_0
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
    // InternalTextualScenario.g:1431:1: rule__SequenceMessage__Group__1 : rule__SequenceMessage__Group__1__Impl rule__SequenceMessage__Group__2 ;
    public final void rule__SequenceMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1435:1: ( rule__SequenceMessage__Group__1__Impl rule__SequenceMessage__Group__2 )
            // InternalTextualScenario.g:1436:2: rule__SequenceMessage__Group__1__Impl rule__SequenceMessage__Group__2
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
    // InternalTextualScenario.g:1443:1: rule__SequenceMessage__Group__1__Impl : ( ( rule__SequenceMessage__ArrowAssignment_1 ) ) ;
    public final void rule__SequenceMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1447:1: ( ( ( rule__SequenceMessage__ArrowAssignment_1 ) ) )
            // InternalTextualScenario.g:1448:1: ( ( rule__SequenceMessage__ArrowAssignment_1 ) )
            {
            // InternalTextualScenario.g:1448:1: ( ( rule__SequenceMessage__ArrowAssignment_1 ) )
            // InternalTextualScenario.g:1449:2: ( rule__SequenceMessage__ArrowAssignment_1 )
            {
             before(grammarAccess.getSequenceMessageAccess().getArrowAssignment_1()); 
            // InternalTextualScenario.g:1450:2: ( rule__SequenceMessage__ArrowAssignment_1 )
            // InternalTextualScenario.g:1450:3: rule__SequenceMessage__ArrowAssignment_1
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
    // InternalTextualScenario.g:1458:1: rule__SequenceMessage__Group__2 : rule__SequenceMessage__Group__2__Impl rule__SequenceMessage__Group__3 ;
    public final void rule__SequenceMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1462:1: ( rule__SequenceMessage__Group__2__Impl rule__SequenceMessage__Group__3 )
            // InternalTextualScenario.g:1463:2: rule__SequenceMessage__Group__2__Impl rule__SequenceMessage__Group__3
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
    // InternalTextualScenario.g:1470:1: rule__SequenceMessage__Group__2__Impl : ( ( rule__SequenceMessage__TargetAssignment_2 ) ) ;
    public final void rule__SequenceMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1474:1: ( ( ( rule__SequenceMessage__TargetAssignment_2 ) ) )
            // InternalTextualScenario.g:1475:1: ( ( rule__SequenceMessage__TargetAssignment_2 ) )
            {
            // InternalTextualScenario.g:1475:1: ( ( rule__SequenceMessage__TargetAssignment_2 ) )
            // InternalTextualScenario.g:1476:2: ( rule__SequenceMessage__TargetAssignment_2 )
            {
             before(grammarAccess.getSequenceMessageAccess().getTargetAssignment_2()); 
            // InternalTextualScenario.g:1477:2: ( rule__SequenceMessage__TargetAssignment_2 )
            // InternalTextualScenario.g:1477:3: rule__SequenceMessage__TargetAssignment_2
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
    // InternalTextualScenario.g:1485:1: rule__SequenceMessage__Group__3 : rule__SequenceMessage__Group__3__Impl rule__SequenceMessage__Group__4 ;
    public final void rule__SequenceMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1489:1: ( rule__SequenceMessage__Group__3__Impl rule__SequenceMessage__Group__4 )
            // InternalTextualScenario.g:1490:2: rule__SequenceMessage__Group__3__Impl rule__SequenceMessage__Group__4
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
    // InternalTextualScenario.g:1497:1: rule__SequenceMessage__Group__3__Impl : ( ( rule__SequenceMessage__ExecutionAssignment_3 )? ) ;
    public final void rule__SequenceMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1501:1: ( ( ( rule__SequenceMessage__ExecutionAssignment_3 )? ) )
            // InternalTextualScenario.g:1502:1: ( ( rule__SequenceMessage__ExecutionAssignment_3 )? )
            {
            // InternalTextualScenario.g:1502:1: ( ( rule__SequenceMessage__ExecutionAssignment_3 )? )
            // InternalTextualScenario.g:1503:2: ( rule__SequenceMessage__ExecutionAssignment_3 )?
            {
             before(grammarAccess.getSequenceMessageAccess().getExecutionAssignment_3()); 
            // InternalTextualScenario.g:1504:2: ( rule__SequenceMessage__ExecutionAssignment_3 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==35) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTextualScenario.g:1504:3: rule__SequenceMessage__ExecutionAssignment_3
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
    // InternalTextualScenario.g:1512:1: rule__SequenceMessage__Group__4 : rule__SequenceMessage__Group__4__Impl rule__SequenceMessage__Group__5 ;
    public final void rule__SequenceMessage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1516:1: ( rule__SequenceMessage__Group__4__Impl rule__SequenceMessage__Group__5 )
            // InternalTextualScenario.g:1517:2: rule__SequenceMessage__Group__4__Impl rule__SequenceMessage__Group__5
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
    // InternalTextualScenario.g:1524:1: rule__SequenceMessage__Group__4__Impl : ( ( rule__SequenceMessage__ReturnAssignment_4 )? ) ;
    public final void rule__SequenceMessage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1528:1: ( ( ( rule__SequenceMessage__ReturnAssignment_4 )? ) )
            // InternalTextualScenario.g:1529:1: ( ( rule__SequenceMessage__ReturnAssignment_4 )? )
            {
            // InternalTextualScenario.g:1529:1: ( ( rule__SequenceMessage__ReturnAssignment_4 )? )
            // InternalTextualScenario.g:1530:2: ( rule__SequenceMessage__ReturnAssignment_4 )?
            {
             before(grammarAccess.getSequenceMessageAccess().getReturnAssignment_4()); 
            // InternalTextualScenario.g:1531:2: ( rule__SequenceMessage__ReturnAssignment_4 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==36) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalTextualScenario.g:1531:3: rule__SequenceMessage__ReturnAssignment_4
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
    // InternalTextualScenario.g:1539:1: rule__SequenceMessage__Group__5 : rule__SequenceMessage__Group__5__Impl rule__SequenceMessage__Group__6 ;
    public final void rule__SequenceMessage__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1543:1: ( rule__SequenceMessage__Group__5__Impl rule__SequenceMessage__Group__6 )
            // InternalTextualScenario.g:1544:2: rule__SequenceMessage__Group__5__Impl rule__SequenceMessage__Group__6
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
    // InternalTextualScenario.g:1551:1: rule__SequenceMessage__Group__5__Impl : ( ( rule__SequenceMessage__DoubleDotAssignment_5 ) ) ;
    public final void rule__SequenceMessage__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1555:1: ( ( ( rule__SequenceMessage__DoubleDotAssignment_5 ) ) )
            // InternalTextualScenario.g:1556:1: ( ( rule__SequenceMessage__DoubleDotAssignment_5 ) )
            {
            // InternalTextualScenario.g:1556:1: ( ( rule__SequenceMessage__DoubleDotAssignment_5 ) )
            // InternalTextualScenario.g:1557:2: ( rule__SequenceMessage__DoubleDotAssignment_5 )
            {
             before(grammarAccess.getSequenceMessageAccess().getDoubleDotAssignment_5()); 
            // InternalTextualScenario.g:1558:2: ( rule__SequenceMessage__DoubleDotAssignment_5 )
            // InternalTextualScenario.g:1558:3: rule__SequenceMessage__DoubleDotAssignment_5
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
    // InternalTextualScenario.g:1566:1: rule__SequenceMessage__Group__6 : rule__SequenceMessage__Group__6__Impl ;
    public final void rule__SequenceMessage__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1570:1: ( rule__SequenceMessage__Group__6__Impl )
            // InternalTextualScenario.g:1571:2: rule__SequenceMessage__Group__6__Impl
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
    // InternalTextualScenario.g:1577:1: rule__SequenceMessage__Group__6__Impl : ( ( rule__SequenceMessage__NameAssignment_6 ) ) ;
    public final void rule__SequenceMessage__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1581:1: ( ( ( rule__SequenceMessage__NameAssignment_6 ) ) )
            // InternalTextualScenario.g:1582:1: ( ( rule__SequenceMessage__NameAssignment_6 ) )
            {
            // InternalTextualScenario.g:1582:1: ( ( rule__SequenceMessage__NameAssignment_6 ) )
            // InternalTextualScenario.g:1583:2: ( rule__SequenceMessage__NameAssignment_6 )
            {
             before(grammarAccess.getSequenceMessageAccess().getNameAssignment_6()); 
            // InternalTextualScenario.g:1584:2: ( rule__SequenceMessage__NameAssignment_6 )
            // InternalTextualScenario.g:1584:3: rule__SequenceMessage__NameAssignment_6
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
    // InternalTextualScenario.g:1593:1: rule__CreateMessage__Group__0 : rule__CreateMessage__Group__0__Impl rule__CreateMessage__Group__1 ;
    public final void rule__CreateMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1597:1: ( rule__CreateMessage__Group__0__Impl rule__CreateMessage__Group__1 )
            // InternalTextualScenario.g:1598:2: rule__CreateMessage__Group__0__Impl rule__CreateMessage__Group__1
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
    // InternalTextualScenario.g:1605:1: rule__CreateMessage__Group__0__Impl : ( ( rule__CreateMessage__SourceAssignment_0 ) ) ;
    public final void rule__CreateMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1609:1: ( ( ( rule__CreateMessage__SourceAssignment_0 ) ) )
            // InternalTextualScenario.g:1610:1: ( ( rule__CreateMessage__SourceAssignment_0 ) )
            {
            // InternalTextualScenario.g:1610:1: ( ( rule__CreateMessage__SourceAssignment_0 ) )
            // InternalTextualScenario.g:1611:2: ( rule__CreateMessage__SourceAssignment_0 )
            {
             before(grammarAccess.getCreateMessageAccess().getSourceAssignment_0()); 
            // InternalTextualScenario.g:1612:2: ( rule__CreateMessage__SourceAssignment_0 )
            // InternalTextualScenario.g:1612:3: rule__CreateMessage__SourceAssignment_0
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
    // InternalTextualScenario.g:1620:1: rule__CreateMessage__Group__1 : rule__CreateMessage__Group__1__Impl rule__CreateMessage__Group__2 ;
    public final void rule__CreateMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1624:1: ( rule__CreateMessage__Group__1__Impl rule__CreateMessage__Group__2 )
            // InternalTextualScenario.g:1625:2: rule__CreateMessage__Group__1__Impl rule__CreateMessage__Group__2
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
    // InternalTextualScenario.g:1632:1: rule__CreateMessage__Group__1__Impl : ( ( rule__CreateMessage__ArrowAssignment_1 ) ) ;
    public final void rule__CreateMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1636:1: ( ( ( rule__CreateMessage__ArrowAssignment_1 ) ) )
            // InternalTextualScenario.g:1637:1: ( ( rule__CreateMessage__ArrowAssignment_1 ) )
            {
            // InternalTextualScenario.g:1637:1: ( ( rule__CreateMessage__ArrowAssignment_1 ) )
            // InternalTextualScenario.g:1638:2: ( rule__CreateMessage__ArrowAssignment_1 )
            {
             before(grammarAccess.getCreateMessageAccess().getArrowAssignment_1()); 
            // InternalTextualScenario.g:1639:2: ( rule__CreateMessage__ArrowAssignment_1 )
            // InternalTextualScenario.g:1639:3: rule__CreateMessage__ArrowAssignment_1
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
    // InternalTextualScenario.g:1647:1: rule__CreateMessage__Group__2 : rule__CreateMessage__Group__2__Impl rule__CreateMessage__Group__3 ;
    public final void rule__CreateMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1651:1: ( rule__CreateMessage__Group__2__Impl rule__CreateMessage__Group__3 )
            // InternalTextualScenario.g:1652:2: rule__CreateMessage__Group__2__Impl rule__CreateMessage__Group__3
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
    // InternalTextualScenario.g:1659:1: rule__CreateMessage__Group__2__Impl : ( ( rule__CreateMessage__TargetAssignment_2 ) ) ;
    public final void rule__CreateMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1663:1: ( ( ( rule__CreateMessage__TargetAssignment_2 ) ) )
            // InternalTextualScenario.g:1664:1: ( ( rule__CreateMessage__TargetAssignment_2 ) )
            {
            // InternalTextualScenario.g:1664:1: ( ( rule__CreateMessage__TargetAssignment_2 ) )
            // InternalTextualScenario.g:1665:2: ( rule__CreateMessage__TargetAssignment_2 )
            {
             before(grammarAccess.getCreateMessageAccess().getTargetAssignment_2()); 
            // InternalTextualScenario.g:1666:2: ( rule__CreateMessage__TargetAssignment_2 )
            // InternalTextualScenario.g:1666:3: rule__CreateMessage__TargetAssignment_2
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
    // InternalTextualScenario.g:1674:1: rule__CreateMessage__Group__3 : rule__CreateMessage__Group__3__Impl rule__CreateMessage__Group__4 ;
    public final void rule__CreateMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1678:1: ( rule__CreateMessage__Group__3__Impl rule__CreateMessage__Group__4 )
            // InternalTextualScenario.g:1679:2: rule__CreateMessage__Group__3__Impl rule__CreateMessage__Group__4
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
    // InternalTextualScenario.g:1686:1: rule__CreateMessage__Group__3__Impl : ( ( rule__CreateMessage__DoubleDotAssignment_3 ) ) ;
    public final void rule__CreateMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1690:1: ( ( ( rule__CreateMessage__DoubleDotAssignment_3 ) ) )
            // InternalTextualScenario.g:1691:1: ( ( rule__CreateMessage__DoubleDotAssignment_3 ) )
            {
            // InternalTextualScenario.g:1691:1: ( ( rule__CreateMessage__DoubleDotAssignment_3 ) )
            // InternalTextualScenario.g:1692:2: ( rule__CreateMessage__DoubleDotAssignment_3 )
            {
             before(grammarAccess.getCreateMessageAccess().getDoubleDotAssignment_3()); 
            // InternalTextualScenario.g:1693:2: ( rule__CreateMessage__DoubleDotAssignment_3 )
            // InternalTextualScenario.g:1693:3: rule__CreateMessage__DoubleDotAssignment_3
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
    // InternalTextualScenario.g:1701:1: rule__CreateMessage__Group__4 : rule__CreateMessage__Group__4__Impl ;
    public final void rule__CreateMessage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1705:1: ( rule__CreateMessage__Group__4__Impl )
            // InternalTextualScenario.g:1706:2: rule__CreateMessage__Group__4__Impl
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
    // InternalTextualScenario.g:1712:1: rule__CreateMessage__Group__4__Impl : ( ( rule__CreateMessage__NameAssignment_4 ) ) ;
    public final void rule__CreateMessage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1716:1: ( ( ( rule__CreateMessage__NameAssignment_4 ) ) )
            // InternalTextualScenario.g:1717:1: ( ( rule__CreateMessage__NameAssignment_4 ) )
            {
            // InternalTextualScenario.g:1717:1: ( ( rule__CreateMessage__NameAssignment_4 ) )
            // InternalTextualScenario.g:1718:2: ( rule__CreateMessage__NameAssignment_4 )
            {
             before(grammarAccess.getCreateMessageAccess().getNameAssignment_4()); 
            // InternalTextualScenario.g:1719:2: ( rule__CreateMessage__NameAssignment_4 )
            // InternalTextualScenario.g:1719:3: rule__CreateMessage__NameAssignment_4
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
    // InternalTextualScenario.g:1728:1: rule__DeleteMessage__Group__0 : rule__DeleteMessage__Group__0__Impl rule__DeleteMessage__Group__1 ;
    public final void rule__DeleteMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1732:1: ( rule__DeleteMessage__Group__0__Impl rule__DeleteMessage__Group__1 )
            // InternalTextualScenario.g:1733:2: rule__DeleteMessage__Group__0__Impl rule__DeleteMessage__Group__1
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
    // InternalTextualScenario.g:1740:1: rule__DeleteMessage__Group__0__Impl : ( ( rule__DeleteMessage__SourceAssignment_0 ) ) ;
    public final void rule__DeleteMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1744:1: ( ( ( rule__DeleteMessage__SourceAssignment_0 ) ) )
            // InternalTextualScenario.g:1745:1: ( ( rule__DeleteMessage__SourceAssignment_0 ) )
            {
            // InternalTextualScenario.g:1745:1: ( ( rule__DeleteMessage__SourceAssignment_0 ) )
            // InternalTextualScenario.g:1746:2: ( rule__DeleteMessage__SourceAssignment_0 )
            {
             before(grammarAccess.getDeleteMessageAccess().getSourceAssignment_0()); 
            // InternalTextualScenario.g:1747:2: ( rule__DeleteMessage__SourceAssignment_0 )
            // InternalTextualScenario.g:1747:3: rule__DeleteMessage__SourceAssignment_0
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
    // InternalTextualScenario.g:1755:1: rule__DeleteMessage__Group__1 : rule__DeleteMessage__Group__1__Impl rule__DeleteMessage__Group__2 ;
    public final void rule__DeleteMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1759:1: ( rule__DeleteMessage__Group__1__Impl rule__DeleteMessage__Group__2 )
            // InternalTextualScenario.g:1760:2: rule__DeleteMessage__Group__1__Impl rule__DeleteMessage__Group__2
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
    // InternalTextualScenario.g:1767:1: rule__DeleteMessage__Group__1__Impl : ( ( rule__DeleteMessage__ArrowAssignment_1 ) ) ;
    public final void rule__DeleteMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1771:1: ( ( ( rule__DeleteMessage__ArrowAssignment_1 ) ) )
            // InternalTextualScenario.g:1772:1: ( ( rule__DeleteMessage__ArrowAssignment_1 ) )
            {
            // InternalTextualScenario.g:1772:1: ( ( rule__DeleteMessage__ArrowAssignment_1 ) )
            // InternalTextualScenario.g:1773:2: ( rule__DeleteMessage__ArrowAssignment_1 )
            {
             before(grammarAccess.getDeleteMessageAccess().getArrowAssignment_1()); 
            // InternalTextualScenario.g:1774:2: ( rule__DeleteMessage__ArrowAssignment_1 )
            // InternalTextualScenario.g:1774:3: rule__DeleteMessage__ArrowAssignment_1
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
    // InternalTextualScenario.g:1782:1: rule__DeleteMessage__Group__2 : rule__DeleteMessage__Group__2__Impl rule__DeleteMessage__Group__3 ;
    public final void rule__DeleteMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1786:1: ( rule__DeleteMessage__Group__2__Impl rule__DeleteMessage__Group__3 )
            // InternalTextualScenario.g:1787:2: rule__DeleteMessage__Group__2__Impl rule__DeleteMessage__Group__3
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
    // InternalTextualScenario.g:1794:1: rule__DeleteMessage__Group__2__Impl : ( ( rule__DeleteMessage__TargetAssignment_2 ) ) ;
    public final void rule__DeleteMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1798:1: ( ( ( rule__DeleteMessage__TargetAssignment_2 ) ) )
            // InternalTextualScenario.g:1799:1: ( ( rule__DeleteMessage__TargetAssignment_2 ) )
            {
            // InternalTextualScenario.g:1799:1: ( ( rule__DeleteMessage__TargetAssignment_2 ) )
            // InternalTextualScenario.g:1800:2: ( rule__DeleteMessage__TargetAssignment_2 )
            {
             before(grammarAccess.getDeleteMessageAccess().getTargetAssignment_2()); 
            // InternalTextualScenario.g:1801:2: ( rule__DeleteMessage__TargetAssignment_2 )
            // InternalTextualScenario.g:1801:3: rule__DeleteMessage__TargetAssignment_2
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
    // InternalTextualScenario.g:1809:1: rule__DeleteMessage__Group__3 : rule__DeleteMessage__Group__3__Impl rule__DeleteMessage__Group__4 ;
    public final void rule__DeleteMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1813:1: ( rule__DeleteMessage__Group__3__Impl rule__DeleteMessage__Group__4 )
            // InternalTextualScenario.g:1814:2: rule__DeleteMessage__Group__3__Impl rule__DeleteMessage__Group__4
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
    // InternalTextualScenario.g:1821:1: rule__DeleteMessage__Group__3__Impl : ( ( rule__DeleteMessage__DoubleDotAssignment_3 ) ) ;
    public final void rule__DeleteMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1825:1: ( ( ( rule__DeleteMessage__DoubleDotAssignment_3 ) ) )
            // InternalTextualScenario.g:1826:1: ( ( rule__DeleteMessage__DoubleDotAssignment_3 ) )
            {
            // InternalTextualScenario.g:1826:1: ( ( rule__DeleteMessage__DoubleDotAssignment_3 ) )
            // InternalTextualScenario.g:1827:2: ( rule__DeleteMessage__DoubleDotAssignment_3 )
            {
             before(grammarAccess.getDeleteMessageAccess().getDoubleDotAssignment_3()); 
            // InternalTextualScenario.g:1828:2: ( rule__DeleteMessage__DoubleDotAssignment_3 )
            // InternalTextualScenario.g:1828:3: rule__DeleteMessage__DoubleDotAssignment_3
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
    // InternalTextualScenario.g:1836:1: rule__DeleteMessage__Group__4 : rule__DeleteMessage__Group__4__Impl ;
    public final void rule__DeleteMessage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1840:1: ( rule__DeleteMessage__Group__4__Impl )
            // InternalTextualScenario.g:1841:2: rule__DeleteMessage__Group__4__Impl
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
    // InternalTextualScenario.g:1847:1: rule__DeleteMessage__Group__4__Impl : ( ( rule__DeleteMessage__NameAssignment_4 ) ) ;
    public final void rule__DeleteMessage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1851:1: ( ( ( rule__DeleteMessage__NameAssignment_4 ) ) )
            // InternalTextualScenario.g:1852:1: ( ( rule__DeleteMessage__NameAssignment_4 ) )
            {
            // InternalTextualScenario.g:1852:1: ( ( rule__DeleteMessage__NameAssignment_4 ) )
            // InternalTextualScenario.g:1853:2: ( rule__DeleteMessage__NameAssignment_4 )
            {
             before(grammarAccess.getDeleteMessageAccess().getNameAssignment_4()); 
            // InternalTextualScenario.g:1854:2: ( rule__DeleteMessage__NameAssignment_4 )
            // InternalTextualScenario.g:1854:3: rule__DeleteMessage__NameAssignment_4
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
    // InternalTextualScenario.g:1863:1: rule__ArmTimerMessage__Group__0 : rule__ArmTimerMessage__Group__0__Impl rule__ArmTimerMessage__Group__1 ;
    public final void rule__ArmTimerMessage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1867:1: ( rule__ArmTimerMessage__Group__0__Impl rule__ArmTimerMessage__Group__1 )
            // InternalTextualScenario.g:1868:2: rule__ArmTimerMessage__Group__0__Impl rule__ArmTimerMessage__Group__1
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
    // InternalTextualScenario.g:1875:1: rule__ArmTimerMessage__Group__0__Impl : ( ( rule__ArmTimerMessage__ArrowAssignment_0 ) ) ;
    public final void rule__ArmTimerMessage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1879:1: ( ( ( rule__ArmTimerMessage__ArrowAssignment_0 ) ) )
            // InternalTextualScenario.g:1880:1: ( ( rule__ArmTimerMessage__ArrowAssignment_0 ) )
            {
            // InternalTextualScenario.g:1880:1: ( ( rule__ArmTimerMessage__ArrowAssignment_0 ) )
            // InternalTextualScenario.g:1881:2: ( rule__ArmTimerMessage__ArrowAssignment_0 )
            {
             before(grammarAccess.getArmTimerMessageAccess().getArrowAssignment_0()); 
            // InternalTextualScenario.g:1882:2: ( rule__ArmTimerMessage__ArrowAssignment_0 )
            // InternalTextualScenario.g:1882:3: rule__ArmTimerMessage__ArrowAssignment_0
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
    // InternalTextualScenario.g:1890:1: rule__ArmTimerMessage__Group__1 : rule__ArmTimerMessage__Group__1__Impl rule__ArmTimerMessage__Group__2 ;
    public final void rule__ArmTimerMessage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1894:1: ( rule__ArmTimerMessage__Group__1__Impl rule__ArmTimerMessage__Group__2 )
            // InternalTextualScenario.g:1895:2: rule__ArmTimerMessage__Group__1__Impl rule__ArmTimerMessage__Group__2
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
    // InternalTextualScenario.g:1902:1: rule__ArmTimerMessage__Group__1__Impl : ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) ) ;
    public final void rule__ArmTimerMessage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1906:1: ( ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) ) )
            // InternalTextualScenario.g:1907:1: ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) )
            {
            // InternalTextualScenario.g:1907:1: ( ( rule__ArmTimerMessage__ParticipantAssignment_1 ) )
            // InternalTextualScenario.g:1908:2: ( rule__ArmTimerMessage__ParticipantAssignment_1 )
            {
             before(grammarAccess.getArmTimerMessageAccess().getParticipantAssignment_1()); 
            // InternalTextualScenario.g:1909:2: ( rule__ArmTimerMessage__ParticipantAssignment_1 )
            // InternalTextualScenario.g:1909:3: rule__ArmTimerMessage__ParticipantAssignment_1
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
    // InternalTextualScenario.g:1917:1: rule__ArmTimerMessage__Group__2 : rule__ArmTimerMessage__Group__2__Impl rule__ArmTimerMessage__Group__3 ;
    public final void rule__ArmTimerMessage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1921:1: ( rule__ArmTimerMessage__Group__2__Impl rule__ArmTimerMessage__Group__3 )
            // InternalTextualScenario.g:1922:2: rule__ArmTimerMessage__Group__2__Impl rule__ArmTimerMessage__Group__3
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
    // InternalTextualScenario.g:1929:1: rule__ArmTimerMessage__Group__2__Impl : ( ( rule__ArmTimerMessage__ExecutionAssignment_2 )? ) ;
    public final void rule__ArmTimerMessage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1933:1: ( ( ( rule__ArmTimerMessage__ExecutionAssignment_2 )? ) )
            // InternalTextualScenario.g:1934:1: ( ( rule__ArmTimerMessage__ExecutionAssignment_2 )? )
            {
            // InternalTextualScenario.g:1934:1: ( ( rule__ArmTimerMessage__ExecutionAssignment_2 )? )
            // InternalTextualScenario.g:1935:2: ( rule__ArmTimerMessage__ExecutionAssignment_2 )?
            {
             before(grammarAccess.getArmTimerMessageAccess().getExecutionAssignment_2()); 
            // InternalTextualScenario.g:1936:2: ( rule__ArmTimerMessage__ExecutionAssignment_2 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==35) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTextualScenario.g:1936:3: rule__ArmTimerMessage__ExecutionAssignment_2
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
    // InternalTextualScenario.g:1944:1: rule__ArmTimerMessage__Group__3 : rule__ArmTimerMessage__Group__3__Impl rule__ArmTimerMessage__Group__4 ;
    public final void rule__ArmTimerMessage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1948:1: ( rule__ArmTimerMessage__Group__3__Impl rule__ArmTimerMessage__Group__4 )
            // InternalTextualScenario.g:1949:2: rule__ArmTimerMessage__Group__3__Impl rule__ArmTimerMessage__Group__4
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
    // InternalTextualScenario.g:1956:1: rule__ArmTimerMessage__Group__3__Impl : ( ( rule__ArmTimerMessage__DoubleDotAssignment_3 ) ) ;
    public final void rule__ArmTimerMessage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1960:1: ( ( ( rule__ArmTimerMessage__DoubleDotAssignment_3 ) ) )
            // InternalTextualScenario.g:1961:1: ( ( rule__ArmTimerMessage__DoubleDotAssignment_3 ) )
            {
            // InternalTextualScenario.g:1961:1: ( ( rule__ArmTimerMessage__DoubleDotAssignment_3 ) )
            // InternalTextualScenario.g:1962:2: ( rule__ArmTimerMessage__DoubleDotAssignment_3 )
            {
             before(grammarAccess.getArmTimerMessageAccess().getDoubleDotAssignment_3()); 
            // InternalTextualScenario.g:1963:2: ( rule__ArmTimerMessage__DoubleDotAssignment_3 )
            // InternalTextualScenario.g:1963:3: rule__ArmTimerMessage__DoubleDotAssignment_3
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
    // InternalTextualScenario.g:1971:1: rule__ArmTimerMessage__Group__4 : rule__ArmTimerMessage__Group__4__Impl ;
    public final void rule__ArmTimerMessage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1975:1: ( rule__ArmTimerMessage__Group__4__Impl )
            // InternalTextualScenario.g:1976:2: rule__ArmTimerMessage__Group__4__Impl
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
    // InternalTextualScenario.g:1982:1: rule__ArmTimerMessage__Group__4__Impl : ( ( rule__ArmTimerMessage__NameAssignment_4 ) ) ;
    public final void rule__ArmTimerMessage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:1986:1: ( ( ( rule__ArmTimerMessage__NameAssignment_4 ) ) )
            // InternalTextualScenario.g:1987:1: ( ( rule__ArmTimerMessage__NameAssignment_4 ) )
            {
            // InternalTextualScenario.g:1987:1: ( ( rule__ArmTimerMessage__NameAssignment_4 ) )
            // InternalTextualScenario.g:1988:2: ( rule__ArmTimerMessage__NameAssignment_4 )
            {
             before(grammarAccess.getArmTimerMessageAccess().getNameAssignment_4()); 
            // InternalTextualScenario.g:1989:2: ( rule__ArmTimerMessage__NameAssignment_4 )
            // InternalTextualScenario.g:1989:3: rule__ArmTimerMessage__NameAssignment_4
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


    // $ANTLR start "rule__ParticipantDeactivation__Group__0"
    // InternalTextualScenario.g:1998:1: rule__ParticipantDeactivation__Group__0 : rule__ParticipantDeactivation__Group__0__Impl rule__ParticipantDeactivation__Group__1 ;
    public final void rule__ParticipantDeactivation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2002:1: ( rule__ParticipantDeactivation__Group__0__Impl rule__ParticipantDeactivation__Group__1 )
            // InternalTextualScenario.g:2003:2: rule__ParticipantDeactivation__Group__0__Impl rule__ParticipantDeactivation__Group__1
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
    // InternalTextualScenario.g:2010:1: rule__ParticipantDeactivation__Group__0__Impl : ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) ) ;
    public final void rule__ParticipantDeactivation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2014:1: ( ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:2015:1: ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:2015:1: ( ( rule__ParticipantDeactivation__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:2016:2: ( rule__ParticipantDeactivation__KeywordAssignment_0 )
            {
             before(grammarAccess.getParticipantDeactivationAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:2017:2: ( rule__ParticipantDeactivation__KeywordAssignment_0 )
            // InternalTextualScenario.g:2017:3: rule__ParticipantDeactivation__KeywordAssignment_0
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
    // InternalTextualScenario.g:2025:1: rule__ParticipantDeactivation__Group__1 : rule__ParticipantDeactivation__Group__1__Impl ;
    public final void rule__ParticipantDeactivation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2029:1: ( rule__ParticipantDeactivation__Group__1__Impl )
            // InternalTextualScenario.g:2030:2: rule__ParticipantDeactivation__Group__1__Impl
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
    // InternalTextualScenario.g:2036:1: rule__ParticipantDeactivation__Group__1__Impl : ( ( rule__ParticipantDeactivation__NameAssignment_1 ) ) ;
    public final void rule__ParticipantDeactivation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2040:1: ( ( ( rule__ParticipantDeactivation__NameAssignment_1 ) ) )
            // InternalTextualScenario.g:2041:1: ( ( rule__ParticipantDeactivation__NameAssignment_1 ) )
            {
            // InternalTextualScenario.g:2041:1: ( ( rule__ParticipantDeactivation__NameAssignment_1 ) )
            // InternalTextualScenario.g:2042:2: ( rule__ParticipantDeactivation__NameAssignment_1 )
            {
             before(grammarAccess.getParticipantDeactivationAccess().getNameAssignment_1()); 
            // InternalTextualScenario.g:2043:2: ( rule__ParticipantDeactivation__NameAssignment_1 )
            // InternalTextualScenario.g:2043:3: rule__ParticipantDeactivation__NameAssignment_1
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
    // InternalTextualScenario.g:2052:1: rule__CombinedFragment__Group__0 : rule__CombinedFragment__Group__0__Impl rule__CombinedFragment__Group__1 ;
    public final void rule__CombinedFragment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2056:1: ( rule__CombinedFragment__Group__0__Impl rule__CombinedFragment__Group__1 )
            // InternalTextualScenario.g:2057:2: rule__CombinedFragment__Group__0__Impl rule__CombinedFragment__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalTextualScenario.g:2064:1: rule__CombinedFragment__Group__0__Impl : ( ( rule__CombinedFragment__KeywordAssignment_0 ) ) ;
    public final void rule__CombinedFragment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2068:1: ( ( ( rule__CombinedFragment__KeywordAssignment_0 ) ) )
            // InternalTextualScenario.g:2069:1: ( ( rule__CombinedFragment__KeywordAssignment_0 ) )
            {
            // InternalTextualScenario.g:2069:1: ( ( rule__CombinedFragment__KeywordAssignment_0 ) )
            // InternalTextualScenario.g:2070:2: ( rule__CombinedFragment__KeywordAssignment_0 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:2071:2: ( rule__CombinedFragment__KeywordAssignment_0 )
            // InternalTextualScenario.g:2071:3: rule__CombinedFragment__KeywordAssignment_0
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
    // InternalTextualScenario.g:2079:1: rule__CombinedFragment__Group__1 : rule__CombinedFragment__Group__1__Impl rule__CombinedFragment__Group__2 ;
    public final void rule__CombinedFragment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2083:1: ( rule__CombinedFragment__Group__1__Impl rule__CombinedFragment__Group__2 )
            // InternalTextualScenario.g:2084:2: rule__CombinedFragment__Group__1__Impl rule__CombinedFragment__Group__2
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
    // InternalTextualScenario.g:2091:1: rule__CombinedFragment__Group__1__Impl : ( ( rule__CombinedFragment__ExpressionAssignment_1 ) ) ;
    public final void rule__CombinedFragment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2095:1: ( ( ( rule__CombinedFragment__ExpressionAssignment_1 ) ) )
            // InternalTextualScenario.g:2096:1: ( ( rule__CombinedFragment__ExpressionAssignment_1 ) )
            {
            // InternalTextualScenario.g:2096:1: ( ( rule__CombinedFragment__ExpressionAssignment_1 ) )
            // InternalTextualScenario.g:2097:2: ( rule__CombinedFragment__ExpressionAssignment_1 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getExpressionAssignment_1()); 
            // InternalTextualScenario.g:2098:2: ( rule__CombinedFragment__ExpressionAssignment_1 )
            // InternalTextualScenario.g:2098:3: rule__CombinedFragment__ExpressionAssignment_1
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
    // InternalTextualScenario.g:2106:1: rule__CombinedFragment__Group__2 : rule__CombinedFragment__Group__2__Impl rule__CombinedFragment__Group__3 ;
    public final void rule__CombinedFragment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2110:1: ( rule__CombinedFragment__Group__2__Impl rule__CombinedFragment__Group__3 )
            // InternalTextualScenario.g:2111:2: rule__CombinedFragment__Group__2__Impl rule__CombinedFragment__Group__3
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
    // InternalTextualScenario.g:2118:1: rule__CombinedFragment__Group__2__Impl : ( ( rule__CombinedFragment__OverAssignment_2 ) ) ;
    public final void rule__CombinedFragment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2122:1: ( ( ( rule__CombinedFragment__OverAssignment_2 ) ) )
            // InternalTextualScenario.g:2123:1: ( ( rule__CombinedFragment__OverAssignment_2 ) )
            {
            // InternalTextualScenario.g:2123:1: ( ( rule__CombinedFragment__OverAssignment_2 ) )
            // InternalTextualScenario.g:2124:2: ( rule__CombinedFragment__OverAssignment_2 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getOverAssignment_2()); 
            // InternalTextualScenario.g:2125:2: ( rule__CombinedFragment__OverAssignment_2 )
            // InternalTextualScenario.g:2125:3: rule__CombinedFragment__OverAssignment_2
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
    // InternalTextualScenario.g:2133:1: rule__CombinedFragment__Group__3 : rule__CombinedFragment__Group__3__Impl rule__CombinedFragment__Group__4 ;
    public final void rule__CombinedFragment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2137:1: ( rule__CombinedFragment__Group__3__Impl rule__CombinedFragment__Group__4 )
            // InternalTextualScenario.g:2138:2: rule__CombinedFragment__Group__3__Impl rule__CombinedFragment__Group__4
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
    // InternalTextualScenario.g:2145:1: rule__CombinedFragment__Group__3__Impl : ( ( ( rule__CombinedFragment__TimelinesAssignment_3 ) ) ( ( rule__CombinedFragment__TimelinesAssignment_3 )* ) ) ;
    public final void rule__CombinedFragment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2149:1: ( ( ( ( rule__CombinedFragment__TimelinesAssignment_3 ) ) ( ( rule__CombinedFragment__TimelinesAssignment_3 )* ) ) )
            // InternalTextualScenario.g:2150:1: ( ( ( rule__CombinedFragment__TimelinesAssignment_3 ) ) ( ( rule__CombinedFragment__TimelinesAssignment_3 )* ) )
            {
            // InternalTextualScenario.g:2150:1: ( ( ( rule__CombinedFragment__TimelinesAssignment_3 ) ) ( ( rule__CombinedFragment__TimelinesAssignment_3 )* ) )
            // InternalTextualScenario.g:2151:2: ( ( rule__CombinedFragment__TimelinesAssignment_3 ) ) ( ( rule__CombinedFragment__TimelinesAssignment_3 )* )
            {
            // InternalTextualScenario.g:2151:2: ( ( rule__CombinedFragment__TimelinesAssignment_3 ) )
            // InternalTextualScenario.g:2152:3: ( rule__CombinedFragment__TimelinesAssignment_3 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getTimelinesAssignment_3()); 
            // InternalTextualScenario.g:2153:3: ( rule__CombinedFragment__TimelinesAssignment_3 )
            // InternalTextualScenario.g:2153:4: rule__CombinedFragment__TimelinesAssignment_3
            {
            pushFollow(FOLLOW_15);
            rule__CombinedFragment__TimelinesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCombinedFragmentAccess().getTimelinesAssignment_3()); 

            }

            // InternalTextualScenario.g:2156:2: ( ( rule__CombinedFragment__TimelinesAssignment_3 )* )
            // InternalTextualScenario.g:2157:3: ( rule__CombinedFragment__TimelinesAssignment_3 )*
            {
             before(grammarAccess.getCombinedFragmentAccess().getTimelinesAssignment_3()); 
            // InternalTextualScenario.g:2158:3: ( rule__CombinedFragment__TimelinesAssignment_3 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_STRING) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalTextualScenario.g:2158:4: rule__CombinedFragment__TimelinesAssignment_3
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__CombinedFragment__TimelinesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // InternalTextualScenario.g:2167:1: rule__CombinedFragment__Group__4 : rule__CombinedFragment__Group__4__Impl rule__CombinedFragment__Group__5 ;
    public final void rule__CombinedFragment__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2171:1: ( rule__CombinedFragment__Group__4__Impl rule__CombinedFragment__Group__5 )
            // InternalTextualScenario.g:2172:2: rule__CombinedFragment__Group__4__Impl rule__CombinedFragment__Group__5
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
    // InternalTextualScenario.g:2179:1: rule__CombinedFragment__Group__4__Impl : ( ( rule__CombinedFragment__BlockAssignment_4 ) ) ;
    public final void rule__CombinedFragment__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2183:1: ( ( ( rule__CombinedFragment__BlockAssignment_4 ) ) )
            // InternalTextualScenario.g:2184:1: ( ( rule__CombinedFragment__BlockAssignment_4 ) )
            {
            // InternalTextualScenario.g:2184:1: ( ( rule__CombinedFragment__BlockAssignment_4 ) )
            // InternalTextualScenario.g:2185:2: ( rule__CombinedFragment__BlockAssignment_4 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getBlockAssignment_4()); 
            // InternalTextualScenario.g:2186:2: ( rule__CombinedFragment__BlockAssignment_4 )
            // InternalTextualScenario.g:2186:3: rule__CombinedFragment__BlockAssignment_4
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
    // InternalTextualScenario.g:2194:1: rule__CombinedFragment__Group__5 : rule__CombinedFragment__Group__5__Impl ;
    public final void rule__CombinedFragment__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2198:1: ( rule__CombinedFragment__Group__5__Impl )
            // InternalTextualScenario.g:2199:2: rule__CombinedFragment__Group__5__Impl
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
    // InternalTextualScenario.g:2205:1: rule__CombinedFragment__Group__5__Impl : ( ( rule__CombinedFragment__OperandsAssignment_5 )* ) ;
    public final void rule__CombinedFragment__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2209:1: ( ( ( rule__CombinedFragment__OperandsAssignment_5 )* ) )
            // InternalTextualScenario.g:2210:1: ( ( rule__CombinedFragment__OperandsAssignment_5 )* )
            {
            // InternalTextualScenario.g:2210:1: ( ( rule__CombinedFragment__OperandsAssignment_5 )* )
            // InternalTextualScenario.g:2211:2: ( rule__CombinedFragment__OperandsAssignment_5 )*
            {
             before(grammarAccess.getCombinedFragmentAccess().getOperandsAssignment_5()); 
            // InternalTextualScenario.g:2212:2: ( rule__CombinedFragment__OperandsAssignment_5 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_STRING) ) {
                    int LA15_2 = input.LA(2);

                    if ( (LA15_2==26) ) {
                        alt15=1;
                    }


                }
                else if ( (LA15_0==43) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalTextualScenario.g:2212:3: rule__CombinedFragment__OperandsAssignment_5
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__CombinedFragment__OperandsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalTextualScenario.g:2221:1: rule__Operand__Group__0 : rule__Operand__Group__0__Impl rule__Operand__Group__1 ;
    public final void rule__Operand__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2225:1: ( rule__Operand__Group__0__Impl rule__Operand__Group__1 )
            // InternalTextualScenario.g:2226:2: rule__Operand__Group__0__Impl rule__Operand__Group__1
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
    // InternalTextualScenario.g:2233:1: rule__Operand__Group__0__Impl : ( ( rule__Operand__KeywordAssignment_0 )? ) ;
    public final void rule__Operand__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2237:1: ( ( ( rule__Operand__KeywordAssignment_0 )? ) )
            // InternalTextualScenario.g:2238:1: ( ( rule__Operand__KeywordAssignment_0 )? )
            {
            // InternalTextualScenario.g:2238:1: ( ( rule__Operand__KeywordAssignment_0 )? )
            // InternalTextualScenario.g:2239:2: ( rule__Operand__KeywordAssignment_0 )?
            {
             before(grammarAccess.getOperandAccess().getKeywordAssignment_0()); 
            // InternalTextualScenario.g:2240:2: ( rule__Operand__KeywordAssignment_0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==43) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalTextualScenario.g:2240:3: rule__Operand__KeywordAssignment_0
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
    // InternalTextualScenario.g:2248:1: rule__Operand__Group__1 : rule__Operand__Group__1__Impl rule__Operand__Group__2 ;
    public final void rule__Operand__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2252:1: ( rule__Operand__Group__1__Impl rule__Operand__Group__2 )
            // InternalTextualScenario.g:2253:2: rule__Operand__Group__1__Impl rule__Operand__Group__2
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
    // InternalTextualScenario.g:2260:1: rule__Operand__Group__1__Impl : ( ( rule__Operand__ExpressionAssignment_1 ) ) ;
    public final void rule__Operand__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2264:1: ( ( ( rule__Operand__ExpressionAssignment_1 ) ) )
            // InternalTextualScenario.g:2265:1: ( ( rule__Operand__ExpressionAssignment_1 ) )
            {
            // InternalTextualScenario.g:2265:1: ( ( rule__Operand__ExpressionAssignment_1 ) )
            // InternalTextualScenario.g:2266:2: ( rule__Operand__ExpressionAssignment_1 )
            {
             before(grammarAccess.getOperandAccess().getExpressionAssignment_1()); 
            // InternalTextualScenario.g:2267:2: ( rule__Operand__ExpressionAssignment_1 )
            // InternalTextualScenario.g:2267:3: rule__Operand__ExpressionAssignment_1
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
    // InternalTextualScenario.g:2275:1: rule__Operand__Group__2 : rule__Operand__Group__2__Impl ;
    public final void rule__Operand__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2279:1: ( rule__Operand__Group__2__Impl )
            // InternalTextualScenario.g:2280:2: rule__Operand__Group__2__Impl
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
    // InternalTextualScenario.g:2286:1: rule__Operand__Group__2__Impl : ( ( rule__Operand__BlockAssignment_2 ) ) ;
    public final void rule__Operand__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2290:1: ( ( ( rule__Operand__BlockAssignment_2 ) ) )
            // InternalTextualScenario.g:2291:1: ( ( rule__Operand__BlockAssignment_2 ) )
            {
            // InternalTextualScenario.g:2291:1: ( ( rule__Operand__BlockAssignment_2 ) )
            // InternalTextualScenario.g:2292:2: ( rule__Operand__BlockAssignment_2 )
            {
             before(grammarAccess.getOperandAccess().getBlockAssignment_2()); 
            // InternalTextualScenario.g:2293:2: ( rule__Operand__BlockAssignment_2 )
            // InternalTextualScenario.g:2293:3: rule__Operand__BlockAssignment_2
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
    // InternalTextualScenario.g:2302:1: rule__Block__Group__0 : rule__Block__Group__0__Impl rule__Block__Group__1 ;
    public final void rule__Block__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2306:1: ( rule__Block__Group__0__Impl rule__Block__Group__1 )
            // InternalTextualScenario.g:2307:2: rule__Block__Group__0__Impl rule__Block__Group__1
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
    // InternalTextualScenario.g:2314:1: rule__Block__Group__0__Impl : ( ( rule__Block__BeginAssignment_0 ) ) ;
    public final void rule__Block__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2318:1: ( ( ( rule__Block__BeginAssignment_0 ) ) )
            // InternalTextualScenario.g:2319:1: ( ( rule__Block__BeginAssignment_0 ) )
            {
            // InternalTextualScenario.g:2319:1: ( ( rule__Block__BeginAssignment_0 ) )
            // InternalTextualScenario.g:2320:2: ( rule__Block__BeginAssignment_0 )
            {
             before(grammarAccess.getBlockAccess().getBeginAssignment_0()); 
            // InternalTextualScenario.g:2321:2: ( rule__Block__BeginAssignment_0 )
            // InternalTextualScenario.g:2321:3: rule__Block__BeginAssignment_0
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
    // InternalTextualScenario.g:2329:1: rule__Block__Group__1 : rule__Block__Group__1__Impl rule__Block__Group__2 ;
    public final void rule__Block__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2333:1: ( rule__Block__Group__1__Impl rule__Block__Group__2 )
            // InternalTextualScenario.g:2334:2: rule__Block__Group__1__Impl rule__Block__Group__2
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
    // InternalTextualScenario.g:2341:1: rule__Block__Group__1__Impl : ( ( rule__Block__BlockElementsAssignment_1 )* ) ;
    public final void rule__Block__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2345:1: ( ( ( rule__Block__BlockElementsAssignment_1 )* ) )
            // InternalTextualScenario.g:2346:1: ( ( rule__Block__BlockElementsAssignment_1 )* )
            {
            // InternalTextualScenario.g:2346:1: ( ( rule__Block__BlockElementsAssignment_1 )* )
            // InternalTextualScenario.g:2347:2: ( rule__Block__BlockElementsAssignment_1 )*
            {
             before(grammarAccess.getBlockAccess().getBlockElementsAssignment_1()); 
            // InternalTextualScenario.g:2348:2: ( rule__Block__BlockElementsAssignment_1 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_STRING||(LA17_0>=11 && LA17_0<=21)||(LA17_0>=40 && LA17_0<=41)||LA17_0==44) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalTextualScenario.g:2348:3: rule__Block__BlockElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Block__BlockElementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalTextualScenario.g:2356:1: rule__Block__Group__2 : rule__Block__Group__2__Impl ;
    public final void rule__Block__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2360:1: ( rule__Block__Group__2__Impl )
            // InternalTextualScenario.g:2361:2: rule__Block__Group__2__Impl
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
    // InternalTextualScenario.g:2367:1: rule__Block__Group__2__Impl : ( ( rule__Block__EndAssignment_2 ) ) ;
    public final void rule__Block__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2371:1: ( ( ( rule__Block__EndAssignment_2 ) ) )
            // InternalTextualScenario.g:2372:1: ( ( rule__Block__EndAssignment_2 ) )
            {
            // InternalTextualScenario.g:2372:1: ( ( rule__Block__EndAssignment_2 ) )
            // InternalTextualScenario.g:2373:2: ( rule__Block__EndAssignment_2 )
            {
             before(grammarAccess.getBlockAccess().getEndAssignment_2()); 
            // InternalTextualScenario.g:2374:2: ( rule__Block__EndAssignment_2 )
            // InternalTextualScenario.g:2374:3: rule__Block__EndAssignment_2
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
    // InternalTextualScenario.g:2383:1: rule__StateFragment__Group__0 : rule__StateFragment__Group__0__Impl rule__StateFragment__Group__1 ;
    public final void rule__StateFragment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2387:1: ( rule__StateFragment__Group__0__Impl rule__StateFragment__Group__1 )
            // InternalTextualScenario.g:2388:2: rule__StateFragment__Group__0__Impl rule__StateFragment__Group__1
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
    // InternalTextualScenario.g:2395:1: rule__StateFragment__Group__0__Impl : ( ( rule__StateFragment__OnAssignment_0 ) ) ;
    public final void rule__StateFragment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2399:1: ( ( ( rule__StateFragment__OnAssignment_0 ) ) )
            // InternalTextualScenario.g:2400:1: ( ( rule__StateFragment__OnAssignment_0 ) )
            {
            // InternalTextualScenario.g:2400:1: ( ( rule__StateFragment__OnAssignment_0 ) )
            // InternalTextualScenario.g:2401:2: ( rule__StateFragment__OnAssignment_0 )
            {
             before(grammarAccess.getStateFragmentAccess().getOnAssignment_0()); 
            // InternalTextualScenario.g:2402:2: ( rule__StateFragment__OnAssignment_0 )
            // InternalTextualScenario.g:2402:3: rule__StateFragment__OnAssignment_0
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
    // InternalTextualScenario.g:2410:1: rule__StateFragment__Group__1 : rule__StateFragment__Group__1__Impl rule__StateFragment__Group__2 ;
    public final void rule__StateFragment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2414:1: ( rule__StateFragment__Group__1__Impl rule__StateFragment__Group__2 )
            // InternalTextualScenario.g:2415:2: rule__StateFragment__Group__1__Impl rule__StateFragment__Group__2
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
    // InternalTextualScenario.g:2422:1: rule__StateFragment__Group__1__Impl : ( ( rule__StateFragment__TimelineAssignment_1 ) ) ;
    public final void rule__StateFragment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2426:1: ( ( ( rule__StateFragment__TimelineAssignment_1 ) ) )
            // InternalTextualScenario.g:2427:1: ( ( rule__StateFragment__TimelineAssignment_1 ) )
            {
            // InternalTextualScenario.g:2427:1: ( ( rule__StateFragment__TimelineAssignment_1 ) )
            // InternalTextualScenario.g:2428:2: ( rule__StateFragment__TimelineAssignment_1 )
            {
             before(grammarAccess.getStateFragmentAccess().getTimelineAssignment_1()); 
            // InternalTextualScenario.g:2429:2: ( rule__StateFragment__TimelineAssignment_1 )
            // InternalTextualScenario.g:2429:3: rule__StateFragment__TimelineAssignment_1
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
    // InternalTextualScenario.g:2437:1: rule__StateFragment__Group__2 : rule__StateFragment__Group__2__Impl rule__StateFragment__Group__3 ;
    public final void rule__StateFragment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2441:1: ( rule__StateFragment__Group__2__Impl rule__StateFragment__Group__3 )
            // InternalTextualScenario.g:2442:2: rule__StateFragment__Group__2__Impl rule__StateFragment__Group__3
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
    // InternalTextualScenario.g:2449:1: rule__StateFragment__Group__2__Impl : ( ( rule__StateFragment__KeywordAssignment_2 ) ) ;
    public final void rule__StateFragment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2453:1: ( ( ( rule__StateFragment__KeywordAssignment_2 ) ) )
            // InternalTextualScenario.g:2454:1: ( ( rule__StateFragment__KeywordAssignment_2 ) )
            {
            // InternalTextualScenario.g:2454:1: ( ( rule__StateFragment__KeywordAssignment_2 ) )
            // InternalTextualScenario.g:2455:2: ( rule__StateFragment__KeywordAssignment_2 )
            {
             before(grammarAccess.getStateFragmentAccess().getKeywordAssignment_2()); 
            // InternalTextualScenario.g:2456:2: ( rule__StateFragment__KeywordAssignment_2 )
            // InternalTextualScenario.g:2456:3: rule__StateFragment__KeywordAssignment_2
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
    // InternalTextualScenario.g:2464:1: rule__StateFragment__Group__3 : rule__StateFragment__Group__3__Impl ;
    public final void rule__StateFragment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2468:1: ( rule__StateFragment__Group__3__Impl )
            // InternalTextualScenario.g:2469:2: rule__StateFragment__Group__3__Impl
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
    // InternalTextualScenario.g:2475:1: rule__StateFragment__Group__3__Impl : ( ( rule__StateFragment__NameAssignment_3 ) ) ;
    public final void rule__StateFragment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2479:1: ( ( ( rule__StateFragment__NameAssignment_3 ) ) )
            // InternalTextualScenario.g:2480:1: ( ( rule__StateFragment__NameAssignment_3 ) )
            {
            // InternalTextualScenario.g:2480:1: ( ( rule__StateFragment__NameAssignment_3 ) )
            // InternalTextualScenario.g:2481:2: ( rule__StateFragment__NameAssignment_3 )
            {
             before(grammarAccess.getStateFragmentAccess().getNameAssignment_3()); 
            // InternalTextualScenario.g:2482:2: ( rule__StateFragment__NameAssignment_3 )
            // InternalTextualScenario.g:2482:3: rule__StateFragment__NameAssignment_3
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
    // InternalTextualScenario.g:2491:1: rule__Model__BeginAssignment_1 : ( ( '{' ) ) ;
    public final void rule__Model__BeginAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2495:1: ( ( ( '{' ) ) )
            // InternalTextualScenario.g:2496:2: ( ( '{' ) )
            {
            // InternalTextualScenario.g:2496:2: ( ( '{' ) )
            // InternalTextualScenario.g:2497:3: ( '{' )
            {
             before(grammarAccess.getModelAccess().getBeginLeftCurlyBracketKeyword_1_0()); 
            // InternalTextualScenario.g:2498:3: ( '{' )
            // InternalTextualScenario.g:2499:4: '{'
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
    // InternalTextualScenario.g:2510:1: rule__Model__ParticipantsAssignment_2 : ( ruleParticipant ) ;
    public final void rule__Model__ParticipantsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2514:1: ( ( ruleParticipant ) )
            // InternalTextualScenario.g:2515:2: ( ruleParticipant )
            {
            // InternalTextualScenario.g:2515:2: ( ruleParticipant )
            // InternalTextualScenario.g:2516:3: ruleParticipant
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
    // InternalTextualScenario.g:2525:1: rule__Model__ElementsAssignment_3 : ( ruleElement ) ;
    public final void rule__Model__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2529:1: ( ( ruleElement ) )
            // InternalTextualScenario.g:2530:2: ( ruleElement )
            {
            // InternalTextualScenario.g:2530:2: ( ruleElement )
            // InternalTextualScenario.g:2531:3: ruleElement
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
    // InternalTextualScenario.g:2540:1: rule__Model__EndAssignment_4 : ( ( '}' ) ) ;
    public final void rule__Model__EndAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2544:1: ( ( ( '}' ) ) )
            // InternalTextualScenario.g:2545:2: ( ( '}' ) )
            {
            // InternalTextualScenario.g:2545:2: ( ( '}' ) )
            // InternalTextualScenario.g:2546:3: ( '}' )
            {
             before(grammarAccess.getModelAccess().getEndRightCurlyBracketKeyword_4_0()); 
            // InternalTextualScenario.g:2547:3: ( '}' )
            // InternalTextualScenario.g:2548:4: '}'
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
    // InternalTextualScenario.g:2559:1: rule__Actor__KeywordAssignment_0 : ( ( 'actor' ) ) ;
    public final void rule__Actor__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2563:1: ( ( ( 'actor' ) ) )
            // InternalTextualScenario.g:2564:2: ( ( 'actor' ) )
            {
            // InternalTextualScenario.g:2564:2: ( ( 'actor' ) )
            // InternalTextualScenario.g:2565:3: ( 'actor' )
            {
             before(grammarAccess.getActorAccess().getKeywordActorKeyword_0_0()); 
            // InternalTextualScenario.g:2566:3: ( 'actor' )
            // InternalTextualScenario.g:2567:4: 'actor'
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
    // InternalTextualScenario.g:2578:1: rule__Actor__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Actor__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2582:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2583:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2583:2: ( RULE_STRING )
            // InternalTextualScenario.g:2584:3: RULE_STRING
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
    // InternalTextualScenario.g:2593:1: rule__Component__KeywordAssignment_0 : ( ( 'component' ) ) ;
    public final void rule__Component__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2597:1: ( ( ( 'component' ) ) )
            // InternalTextualScenario.g:2598:2: ( ( 'component' ) )
            {
            // InternalTextualScenario.g:2598:2: ( ( 'component' ) )
            // InternalTextualScenario.g:2599:3: ( 'component' )
            {
             before(grammarAccess.getComponentAccess().getKeywordComponentKeyword_0_0()); 
            // InternalTextualScenario.g:2600:3: ( 'component' )
            // InternalTextualScenario.g:2601:4: 'component'
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
    // InternalTextualScenario.g:2612:1: rule__Component__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Component__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2616:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2617:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2617:2: ( RULE_STRING )
            // InternalTextualScenario.g:2618:3: RULE_STRING
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
    // InternalTextualScenario.g:2627:1: rule__ConfigurationItem__KeywordAssignment_0 : ( ( 'configuration_item' ) ) ;
    public final void rule__ConfigurationItem__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2631:1: ( ( ( 'configuration_item' ) ) )
            // InternalTextualScenario.g:2632:2: ( ( 'configuration_item' ) )
            {
            // InternalTextualScenario.g:2632:2: ( ( 'configuration_item' ) )
            // InternalTextualScenario.g:2633:3: ( 'configuration_item' )
            {
             before(grammarAccess.getConfigurationItemAccess().getKeywordConfiguration_itemKeyword_0_0()); 
            // InternalTextualScenario.g:2634:3: ( 'configuration_item' )
            // InternalTextualScenario.g:2635:4: 'configuration_item'
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
    // InternalTextualScenario.g:2646:1: rule__ConfigurationItem__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ConfigurationItem__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2650:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2651:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2651:2: ( RULE_STRING )
            // InternalTextualScenario.g:2652:3: RULE_STRING
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
    // InternalTextualScenario.g:2661:1: rule__Function__KeywordAssignment_0 : ( ( 'function' ) ) ;
    public final void rule__Function__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2665:1: ( ( ( 'function' ) ) )
            // InternalTextualScenario.g:2666:2: ( ( 'function' ) )
            {
            // InternalTextualScenario.g:2666:2: ( ( 'function' ) )
            // InternalTextualScenario.g:2667:3: ( 'function' )
            {
             before(grammarAccess.getFunctionAccess().getKeywordFunctionKeyword_0_0()); 
            // InternalTextualScenario.g:2668:3: ( 'function' )
            // InternalTextualScenario.g:2669:4: 'function'
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
    // InternalTextualScenario.g:2680:1: rule__Function__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Function__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2684:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2685:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2685:2: ( RULE_STRING )
            // InternalTextualScenario.g:2686:3: RULE_STRING
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
    // InternalTextualScenario.g:2695:1: rule__Activity__KeywordAssignment_0 : ( ( 'activity' ) ) ;
    public final void rule__Activity__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2699:1: ( ( ( 'activity' ) ) )
            // InternalTextualScenario.g:2700:2: ( ( 'activity' ) )
            {
            // InternalTextualScenario.g:2700:2: ( ( 'activity' ) )
            // InternalTextualScenario.g:2701:3: ( 'activity' )
            {
             before(grammarAccess.getActivityAccess().getKeywordActivityKeyword_0_0()); 
            // InternalTextualScenario.g:2702:3: ( 'activity' )
            // InternalTextualScenario.g:2703:4: 'activity'
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
    // InternalTextualScenario.g:2714:1: rule__Activity__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Activity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2718:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2719:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2719:2: ( RULE_STRING )
            // InternalTextualScenario.g:2720:3: RULE_STRING
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
    // InternalTextualScenario.g:2729:1: rule__Entity__KeywordAssignment_0 : ( ( 'entity' ) ) ;
    public final void rule__Entity__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2733:1: ( ( ( 'entity' ) ) )
            // InternalTextualScenario.g:2734:2: ( ( 'entity' ) )
            {
            // InternalTextualScenario.g:2734:2: ( ( 'entity' ) )
            // InternalTextualScenario.g:2735:3: ( 'entity' )
            {
             before(grammarAccess.getEntityAccess().getKeywordEntityKeyword_0_0()); 
            // InternalTextualScenario.g:2736:3: ( 'entity' )
            // InternalTextualScenario.g:2737:4: 'entity'
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
    // InternalTextualScenario.g:2748:1: rule__Entity__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Entity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2752:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2753:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2753:2: ( RULE_STRING )
            // InternalTextualScenario.g:2754:3: RULE_STRING
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
    // InternalTextualScenario.g:2763:1: rule__Role__KeywordAssignment_0 : ( ( 'role' ) ) ;
    public final void rule__Role__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2767:1: ( ( ( 'role' ) ) )
            // InternalTextualScenario.g:2768:2: ( ( 'role' ) )
            {
            // InternalTextualScenario.g:2768:2: ( ( 'role' ) )
            // InternalTextualScenario.g:2769:3: ( 'role' )
            {
             before(grammarAccess.getRoleAccess().getKeywordRoleKeyword_0_0()); 
            // InternalTextualScenario.g:2770:3: ( 'role' )
            // InternalTextualScenario.g:2771:4: 'role'
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
    // InternalTextualScenario.g:2782:1: rule__Role__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Role__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2786:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2787:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2787:2: ( RULE_STRING )
            // InternalTextualScenario.g:2788:3: RULE_STRING
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
    // InternalTextualScenario.g:2797:1: rule__SequenceMessage__SourceAssignment_0 : ( RULE_STRING ) ;
    public final void rule__SequenceMessage__SourceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2801:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2802:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2802:2: ( RULE_STRING )
            // InternalTextualScenario.g:2803:3: RULE_STRING
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
    // InternalTextualScenario.g:2812:1: rule__SequenceMessage__ArrowAssignment_1 : ( ( '->' ) ) ;
    public final void rule__SequenceMessage__ArrowAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2816:1: ( ( ( '->' ) ) )
            // InternalTextualScenario.g:2817:2: ( ( '->' ) )
            {
            // InternalTextualScenario.g:2817:2: ( ( '->' ) )
            // InternalTextualScenario.g:2818:3: ( '->' )
            {
             before(grammarAccess.getSequenceMessageAccess().getArrowHyphenMinusGreaterThanSignKeyword_1_0()); 
            // InternalTextualScenario.g:2819:3: ( '->' )
            // InternalTextualScenario.g:2820:4: '->'
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
    // InternalTextualScenario.g:2831:1: rule__SequenceMessage__TargetAssignment_2 : ( RULE_STRING ) ;
    public final void rule__SequenceMessage__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2835:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2836:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2836:2: ( RULE_STRING )
            // InternalTextualScenario.g:2837:3: RULE_STRING
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
    // InternalTextualScenario.g:2846:1: rule__SequenceMessage__ExecutionAssignment_3 : ( ( 'withExecution' ) ) ;
    public final void rule__SequenceMessage__ExecutionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2850:1: ( ( ( 'withExecution' ) ) )
            // InternalTextualScenario.g:2851:2: ( ( 'withExecution' ) )
            {
            // InternalTextualScenario.g:2851:2: ( ( 'withExecution' ) )
            // InternalTextualScenario.g:2852:3: ( 'withExecution' )
            {
             before(grammarAccess.getSequenceMessageAccess().getExecutionWithExecutionKeyword_3_0()); 
            // InternalTextualScenario.g:2853:3: ( 'withExecution' )
            // InternalTextualScenario.g:2854:4: 'withExecution'
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
    // InternalTextualScenario.g:2865:1: rule__SequenceMessage__ReturnAssignment_4 : ( ( 'withReturn' ) ) ;
    public final void rule__SequenceMessage__ReturnAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2869:1: ( ( ( 'withReturn' ) ) )
            // InternalTextualScenario.g:2870:2: ( ( 'withReturn' ) )
            {
            // InternalTextualScenario.g:2870:2: ( ( 'withReturn' ) )
            // InternalTextualScenario.g:2871:3: ( 'withReturn' )
            {
             before(grammarAccess.getSequenceMessageAccess().getReturnWithReturnKeyword_4_0()); 
            // InternalTextualScenario.g:2872:3: ( 'withReturn' )
            // InternalTextualScenario.g:2873:4: 'withReturn'
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
    // InternalTextualScenario.g:2884:1: rule__SequenceMessage__DoubleDotAssignment_5 : ( ( ':' ) ) ;
    public final void rule__SequenceMessage__DoubleDotAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2888:1: ( ( ( ':' ) ) )
            // InternalTextualScenario.g:2889:2: ( ( ':' ) )
            {
            // InternalTextualScenario.g:2889:2: ( ( ':' ) )
            // InternalTextualScenario.g:2890:3: ( ':' )
            {
             before(grammarAccess.getSequenceMessageAccess().getDoubleDotColonKeyword_5_0()); 
            // InternalTextualScenario.g:2891:3: ( ':' )
            // InternalTextualScenario.g:2892:4: ':'
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
    // InternalTextualScenario.g:2903:1: rule__SequenceMessage__NameAssignment_6 : ( RULE_STRING ) ;
    public final void rule__SequenceMessage__NameAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2907:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2908:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2908:2: ( RULE_STRING )
            // InternalTextualScenario.g:2909:3: RULE_STRING
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
    // InternalTextualScenario.g:2918:1: rule__CreateMessage__SourceAssignment_0 : ( RULE_STRING ) ;
    public final void rule__CreateMessage__SourceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2922:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2923:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2923:2: ( RULE_STRING )
            // InternalTextualScenario.g:2924:3: RULE_STRING
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
    // InternalTextualScenario.g:2933:1: rule__CreateMessage__ArrowAssignment_1 : ( ( '->+' ) ) ;
    public final void rule__CreateMessage__ArrowAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2937:1: ( ( ( '->+' ) ) )
            // InternalTextualScenario.g:2938:2: ( ( '->+' ) )
            {
            // InternalTextualScenario.g:2938:2: ( ( '->+' ) )
            // InternalTextualScenario.g:2939:3: ( '->+' )
            {
             before(grammarAccess.getCreateMessageAccess().getArrowHyphenMinusGreaterThanSignPlusSignKeyword_1_0()); 
            // InternalTextualScenario.g:2940:3: ( '->+' )
            // InternalTextualScenario.g:2941:4: '->+'
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
    // InternalTextualScenario.g:2952:1: rule__CreateMessage__TargetAssignment_2 : ( RULE_STRING ) ;
    public final void rule__CreateMessage__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2956:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2957:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2957:2: ( RULE_STRING )
            // InternalTextualScenario.g:2958:3: RULE_STRING
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
    // InternalTextualScenario.g:2967:1: rule__CreateMessage__DoubleDotAssignment_3 : ( ( ':' ) ) ;
    public final void rule__CreateMessage__DoubleDotAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2971:1: ( ( ( ':' ) ) )
            // InternalTextualScenario.g:2972:2: ( ( ':' ) )
            {
            // InternalTextualScenario.g:2972:2: ( ( ':' ) )
            // InternalTextualScenario.g:2973:3: ( ':' )
            {
             before(grammarAccess.getCreateMessageAccess().getDoubleDotColonKeyword_3_0()); 
            // InternalTextualScenario.g:2974:3: ( ':' )
            // InternalTextualScenario.g:2975:4: ':'
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
    // InternalTextualScenario.g:2986:1: rule__CreateMessage__NameAssignment_4 : ( RULE_STRING ) ;
    public final void rule__CreateMessage__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:2990:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:2991:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:2991:2: ( RULE_STRING )
            // InternalTextualScenario.g:2992:3: RULE_STRING
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
    // InternalTextualScenario.g:3001:1: rule__DeleteMessage__SourceAssignment_0 : ( RULE_STRING ) ;
    public final void rule__DeleteMessage__SourceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3005:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3006:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3006:2: ( RULE_STRING )
            // InternalTextualScenario.g:3007:3: RULE_STRING
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
    // InternalTextualScenario.g:3016:1: rule__DeleteMessage__ArrowAssignment_1 : ( ( '->x' ) ) ;
    public final void rule__DeleteMessage__ArrowAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3020:1: ( ( ( '->x' ) ) )
            // InternalTextualScenario.g:3021:2: ( ( '->x' ) )
            {
            // InternalTextualScenario.g:3021:2: ( ( '->x' ) )
            // InternalTextualScenario.g:3022:3: ( '->x' )
            {
             before(grammarAccess.getDeleteMessageAccess().getArrowXKeyword_1_0()); 
            // InternalTextualScenario.g:3023:3: ( '->x' )
            // InternalTextualScenario.g:3024:4: '->x'
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
    // InternalTextualScenario.g:3035:1: rule__DeleteMessage__TargetAssignment_2 : ( RULE_STRING ) ;
    public final void rule__DeleteMessage__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3039:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3040:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3040:2: ( RULE_STRING )
            // InternalTextualScenario.g:3041:3: RULE_STRING
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
    // InternalTextualScenario.g:3050:1: rule__DeleteMessage__DoubleDotAssignment_3 : ( ( ':' ) ) ;
    public final void rule__DeleteMessage__DoubleDotAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3054:1: ( ( ( ':' ) ) )
            // InternalTextualScenario.g:3055:2: ( ( ':' ) )
            {
            // InternalTextualScenario.g:3055:2: ( ( ':' ) )
            // InternalTextualScenario.g:3056:3: ( ':' )
            {
             before(grammarAccess.getDeleteMessageAccess().getDoubleDotColonKeyword_3_0()); 
            // InternalTextualScenario.g:3057:3: ( ':' )
            // InternalTextualScenario.g:3058:4: ':'
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
    // InternalTextualScenario.g:3069:1: rule__DeleteMessage__NameAssignment_4 : ( RULE_STRING ) ;
    public final void rule__DeleteMessage__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3073:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3074:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3074:2: ( RULE_STRING )
            // InternalTextualScenario.g:3075:3: RULE_STRING
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
    // InternalTextualScenario.g:3084:1: rule__ArmTimerMessage__ArrowAssignment_0 : ( ( '->>' ) ) ;
    public final void rule__ArmTimerMessage__ArrowAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3088:1: ( ( ( '->>' ) ) )
            // InternalTextualScenario.g:3089:2: ( ( '->>' ) )
            {
            // InternalTextualScenario.g:3089:2: ( ( '->>' ) )
            // InternalTextualScenario.g:3090:3: ( '->>' )
            {
             before(grammarAccess.getArmTimerMessageAccess().getArrowHyphenMinusGreaterThanSignGreaterThanSignKeyword_0_0()); 
            // InternalTextualScenario.g:3091:3: ( '->>' )
            // InternalTextualScenario.g:3092:4: '->>'
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
    // InternalTextualScenario.g:3103:1: rule__ArmTimerMessage__ParticipantAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ArmTimerMessage__ParticipantAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3107:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3108:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3108:2: ( RULE_STRING )
            // InternalTextualScenario.g:3109:3: RULE_STRING
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
    // InternalTextualScenario.g:3118:1: rule__ArmTimerMessage__ExecutionAssignment_2 : ( ( 'withExecution' ) ) ;
    public final void rule__ArmTimerMessage__ExecutionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3122:1: ( ( ( 'withExecution' ) ) )
            // InternalTextualScenario.g:3123:2: ( ( 'withExecution' ) )
            {
            // InternalTextualScenario.g:3123:2: ( ( 'withExecution' ) )
            // InternalTextualScenario.g:3124:3: ( 'withExecution' )
            {
             before(grammarAccess.getArmTimerMessageAccess().getExecutionWithExecutionKeyword_2_0()); 
            // InternalTextualScenario.g:3125:3: ( 'withExecution' )
            // InternalTextualScenario.g:3126:4: 'withExecution'
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
    // InternalTextualScenario.g:3137:1: rule__ArmTimerMessage__DoubleDotAssignment_3 : ( ( ':' ) ) ;
    public final void rule__ArmTimerMessage__DoubleDotAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3141:1: ( ( ( ':' ) ) )
            // InternalTextualScenario.g:3142:2: ( ( ':' ) )
            {
            // InternalTextualScenario.g:3142:2: ( ( ':' ) )
            // InternalTextualScenario.g:3143:3: ( ':' )
            {
             before(grammarAccess.getArmTimerMessageAccess().getDoubleDotColonKeyword_3_0()); 
            // InternalTextualScenario.g:3144:3: ( ':' )
            // InternalTextualScenario.g:3145:4: ':'
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
    // InternalTextualScenario.g:3156:1: rule__ArmTimerMessage__NameAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ArmTimerMessage__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3160:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3161:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3161:2: ( RULE_STRING )
            // InternalTextualScenario.g:3162:3: RULE_STRING
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


    // $ANTLR start "rule__ParticipantDeactivation__KeywordAssignment_0"
    // InternalTextualScenario.g:3171:1: rule__ParticipantDeactivation__KeywordAssignment_0 : ( ( 'deactivate' ) ) ;
    public final void rule__ParticipantDeactivation__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3175:1: ( ( ( 'deactivate' ) ) )
            // InternalTextualScenario.g:3176:2: ( ( 'deactivate' ) )
            {
            // InternalTextualScenario.g:3176:2: ( ( 'deactivate' ) )
            // InternalTextualScenario.g:3177:3: ( 'deactivate' )
            {
             before(grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0()); 
            // InternalTextualScenario.g:3178:3: ( 'deactivate' )
            // InternalTextualScenario.g:3179:4: 'deactivate'
            {
             before(grammarAccess.getParticipantDeactivationAccess().getKeywordDeactivateKeyword_0_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalTextualScenario.g:3190:1: rule__ParticipantDeactivation__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ParticipantDeactivation__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3194:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3195:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3195:2: ( RULE_STRING )
            // InternalTextualScenario.g:3196:3: RULE_STRING
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
    // InternalTextualScenario.g:3205:1: rule__CombinedFragment__KeywordAssignment_0 : ( ( rule__CombinedFragment__KeywordAlternatives_0_0 ) ) ;
    public final void rule__CombinedFragment__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3209:1: ( ( ( rule__CombinedFragment__KeywordAlternatives_0_0 ) ) )
            // InternalTextualScenario.g:3210:2: ( ( rule__CombinedFragment__KeywordAlternatives_0_0 ) )
            {
            // InternalTextualScenario.g:3210:2: ( ( rule__CombinedFragment__KeywordAlternatives_0_0 ) )
            // InternalTextualScenario.g:3211:3: ( rule__CombinedFragment__KeywordAlternatives_0_0 )
            {
             before(grammarAccess.getCombinedFragmentAccess().getKeywordAlternatives_0_0()); 
            // InternalTextualScenario.g:3212:3: ( rule__CombinedFragment__KeywordAlternatives_0_0 )
            // InternalTextualScenario.g:3212:4: rule__CombinedFragment__KeywordAlternatives_0_0
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
    // InternalTextualScenario.g:3220:1: rule__CombinedFragment__ExpressionAssignment_1 : ( RULE_STRING ) ;
    public final void rule__CombinedFragment__ExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3224:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3225:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3225:2: ( RULE_STRING )
            // InternalTextualScenario.g:3226:3: RULE_STRING
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
    // InternalTextualScenario.g:3235:1: rule__CombinedFragment__OverAssignment_2 : ( ( 'over' ) ) ;
    public final void rule__CombinedFragment__OverAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3239:1: ( ( ( 'over' ) ) )
            // InternalTextualScenario.g:3240:2: ( ( 'over' ) )
            {
            // InternalTextualScenario.g:3240:2: ( ( 'over' ) )
            // InternalTextualScenario.g:3241:3: ( 'over' )
            {
             before(grammarAccess.getCombinedFragmentAccess().getOverOverKeyword_2_0()); 
            // InternalTextualScenario.g:3242:3: ( 'over' )
            // InternalTextualScenario.g:3243:4: 'over'
            {
             before(grammarAccess.getCombinedFragmentAccess().getOverOverKeyword_2_0()); 
            match(input,42,FOLLOW_2); 
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
    // InternalTextualScenario.g:3254:1: rule__CombinedFragment__TimelinesAssignment_3 : ( RULE_STRING ) ;
    public final void rule__CombinedFragment__TimelinesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3258:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3259:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3259:2: ( RULE_STRING )
            // InternalTextualScenario.g:3260:3: RULE_STRING
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
    // InternalTextualScenario.g:3269:1: rule__CombinedFragment__BlockAssignment_4 : ( ruleBlock ) ;
    public final void rule__CombinedFragment__BlockAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3273:1: ( ( ruleBlock ) )
            // InternalTextualScenario.g:3274:2: ( ruleBlock )
            {
            // InternalTextualScenario.g:3274:2: ( ruleBlock )
            // InternalTextualScenario.g:3275:3: ruleBlock
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
    // InternalTextualScenario.g:3284:1: rule__CombinedFragment__OperandsAssignment_5 : ( ruleOperand ) ;
    public final void rule__CombinedFragment__OperandsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3288:1: ( ( ruleOperand ) )
            // InternalTextualScenario.g:3289:2: ( ruleOperand )
            {
            // InternalTextualScenario.g:3289:2: ( ruleOperand )
            // InternalTextualScenario.g:3290:3: ruleOperand
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
    // InternalTextualScenario.g:3299:1: rule__Operand__KeywordAssignment_0 : ( ( 'else' ) ) ;
    public final void rule__Operand__KeywordAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3303:1: ( ( ( 'else' ) ) )
            // InternalTextualScenario.g:3304:2: ( ( 'else' ) )
            {
            // InternalTextualScenario.g:3304:2: ( ( 'else' ) )
            // InternalTextualScenario.g:3305:3: ( 'else' )
            {
             before(grammarAccess.getOperandAccess().getKeywordElseKeyword_0_0()); 
            // InternalTextualScenario.g:3306:3: ( 'else' )
            // InternalTextualScenario.g:3307:4: 'else'
            {
             before(grammarAccess.getOperandAccess().getKeywordElseKeyword_0_0()); 
            match(input,43,FOLLOW_2); 
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
    // InternalTextualScenario.g:3318:1: rule__Operand__ExpressionAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Operand__ExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3322:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3323:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3323:2: ( RULE_STRING )
            // InternalTextualScenario.g:3324:3: RULE_STRING
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
    // InternalTextualScenario.g:3333:1: rule__Operand__BlockAssignment_2 : ( ruleBlock ) ;
    public final void rule__Operand__BlockAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3337:1: ( ( ruleBlock ) )
            // InternalTextualScenario.g:3338:2: ( ruleBlock )
            {
            // InternalTextualScenario.g:3338:2: ( ruleBlock )
            // InternalTextualScenario.g:3339:3: ruleBlock
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
    // InternalTextualScenario.g:3348:1: rule__Block__BeginAssignment_0 : ( ( '{' ) ) ;
    public final void rule__Block__BeginAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3352:1: ( ( ( '{' ) ) )
            // InternalTextualScenario.g:3353:2: ( ( '{' ) )
            {
            // InternalTextualScenario.g:3353:2: ( ( '{' ) )
            // InternalTextualScenario.g:3354:3: ( '{' )
            {
             before(grammarAccess.getBlockAccess().getBeginLeftCurlyBracketKeyword_0_0()); 
            // InternalTextualScenario.g:3355:3: ( '{' )
            // InternalTextualScenario.g:3356:4: '{'
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
    // InternalTextualScenario.g:3367:1: rule__Block__BlockElementsAssignment_1 : ( ruleElement ) ;
    public final void rule__Block__BlockElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3371:1: ( ( ruleElement ) )
            // InternalTextualScenario.g:3372:2: ( ruleElement )
            {
            // InternalTextualScenario.g:3372:2: ( ruleElement )
            // InternalTextualScenario.g:3373:3: ruleElement
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
    // InternalTextualScenario.g:3382:1: rule__Block__EndAssignment_2 : ( ( '}' ) ) ;
    public final void rule__Block__EndAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3386:1: ( ( ( '}' ) ) )
            // InternalTextualScenario.g:3387:2: ( ( '}' ) )
            {
            // InternalTextualScenario.g:3387:2: ( ( '}' ) )
            // InternalTextualScenario.g:3388:3: ( '}' )
            {
             before(grammarAccess.getBlockAccess().getEndRightCurlyBracketKeyword_2_0()); 
            // InternalTextualScenario.g:3389:3: ( '}' )
            // InternalTextualScenario.g:3390:4: '}'
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
    // InternalTextualScenario.g:3401:1: rule__StateFragment__OnAssignment_0 : ( ( 'on' ) ) ;
    public final void rule__StateFragment__OnAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3405:1: ( ( ( 'on' ) ) )
            // InternalTextualScenario.g:3406:2: ( ( 'on' ) )
            {
            // InternalTextualScenario.g:3406:2: ( ( 'on' ) )
            // InternalTextualScenario.g:3407:3: ( 'on' )
            {
             before(grammarAccess.getStateFragmentAccess().getOnOnKeyword_0_0()); 
            // InternalTextualScenario.g:3408:3: ( 'on' )
            // InternalTextualScenario.g:3409:4: 'on'
            {
             before(grammarAccess.getStateFragmentAccess().getOnOnKeyword_0_0()); 
            match(input,44,FOLLOW_2); 
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
    // InternalTextualScenario.g:3420:1: rule__StateFragment__TimelineAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StateFragment__TimelineAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3424:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3425:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3425:2: ( RULE_STRING )
            // InternalTextualScenario.g:3426:3: RULE_STRING
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
    // InternalTextualScenario.g:3435:1: rule__StateFragment__KeywordAssignment_2 : ( ( rule__StateFragment__KeywordAlternatives_2_0 ) ) ;
    public final void rule__StateFragment__KeywordAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3439:1: ( ( ( rule__StateFragment__KeywordAlternatives_2_0 ) ) )
            // InternalTextualScenario.g:3440:2: ( ( rule__StateFragment__KeywordAlternatives_2_0 ) )
            {
            // InternalTextualScenario.g:3440:2: ( ( rule__StateFragment__KeywordAlternatives_2_0 ) )
            // InternalTextualScenario.g:3441:3: ( rule__StateFragment__KeywordAlternatives_2_0 )
            {
             before(grammarAccess.getStateFragmentAccess().getKeywordAlternatives_2_0()); 
            // InternalTextualScenario.g:3442:3: ( rule__StateFragment__KeywordAlternatives_2_0 )
            // InternalTextualScenario.g:3442:4: rule__StateFragment__KeywordAlternatives_2_0
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
    // InternalTextualScenario.g:3450:1: rule__StateFragment__NameAssignment_3 : ( RULE_STRING ) ;
    public final void rule__StateFragment__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTextualScenario.g:3454:1: ( ( RULE_STRING ) )
            // InternalTextualScenario.g:3455:2: ( RULE_STRING )
            {
            // InternalTextualScenario.g:3455:2: ( RULE_STRING )
            // InternalTextualScenario.g:3456:3: RULE_STRING
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00001303F93FF810L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000003F1000002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00001300003FF812L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000003800000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000002800000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000080000000012L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00001300083FF810L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001C00000L});

}
