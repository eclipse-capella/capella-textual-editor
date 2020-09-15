/**
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
 */
package org.polarsys.capella.scenario.editor.dsl;

import org.polarsys.capella.scenario.editor.dsl.TextualScenarioStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class TextualScenarioStandaloneSetup extends TextualScenarioStandaloneSetupGenerated {
  public static void doSetup() {
    new TextualScenarioStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}
