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
package org.polarsys.capella.scenario.editor.dslscenario.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.polarsys.capella.scenario.editor.dslscenario.ui.AbstractDslUiModule;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class DslUiModule extends AbstractDslUiModule {
  public DslUiModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
}
