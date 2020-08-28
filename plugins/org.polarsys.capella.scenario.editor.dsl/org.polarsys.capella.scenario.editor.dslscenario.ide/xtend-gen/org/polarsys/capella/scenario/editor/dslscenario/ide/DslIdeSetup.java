/**
 * -------------------------------------------------------------------------------
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
 * 
 *  This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License 2.0 which is available at
 *   http://www.eclipse.org/legal/epl-2.0
 * 
 *   SPDX-License-Identifier: EPL-2.0
 * 
 *   Contributors:
 *      Thales - initial API and implementation
 * -------------------------------------------------------------------------------
 */
package org.polarsys.capella.scenario.editor.dslscenario.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;
import org.polarsys.capella.scenario.editor.dslscenario.DslRuntimeModule;
import org.polarsys.capella.scenario.editor.dslscenario.DslStandaloneSetup;
import org.polarsys.capella.scenario.editor.dslscenario.ide.DslIdeModule;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class DslIdeSetup extends DslStandaloneSetup {
  @Override
  public Injector createInjector() {
    DslRuntimeModule _dslRuntimeModule = new DslRuntimeModule();
    DslIdeModule _dslIdeModule = new DslIdeModule();
    return Guice.createInjector(Modules2.mixin(_dslRuntimeModule, _dslIdeModule));
  }
}
