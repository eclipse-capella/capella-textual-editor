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
package org.polarsys.capella.scenario.editor.embeddededitor.views;

import javax.inject.Inject;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.polarsys.capella.scenario.editor.EmbeddedEditorInstance;
import org.polarsys.capella.scenario.editor.dslscenario.ui.internal.DslscenarioActivator;
import org.polarsys.capella.scenario.editor.dslscenario.ui.provider.DslscenarioProvider;
import org.polarsys.capella.scenario.editor.embeddededitor.actions.XtextEditorActionFactory;

import com.google.inject.Injector;

/*
 * EmbeddedEditorView will embed the xtext editor of the scenario
 */
public class EmbeddedEditorView extends ViewPart {

  /**
   * The ID of the view as specified by the extension.
   */
  public static final String ID = "org.eclipse.xtext.example.domainmodel.embeddededitor.views.EmbeddedEditorView";

  @Inject
  IWorkbench workbench;

  DslscenarioProvider provider;

  class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
    @Override
    public String getColumnText(Object obj, int index) {
      return getText(obj);
    }

    @Override
    public Image getColumnImage(Object obj, int index) {
      return getImage(obj);
    }

    @Override
    public Image getImage(Object obj) {
      return workbench.getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
    }
  }

  @Override
  public void createPartControl(Composite parent) {
    makeActions();

    Composite top = new Composite(parent, SWT.NONE);
    top.setLayout(new GridLayout());

    DslscenarioActivator activator = DslscenarioActivator.getInstance();
    Injector injector = activator
        .getInjector(DslscenarioActivator.ORG_POLARSYS_CAPELLA_SCENARIO_EDITOR_DSLSCENARIO_DSL);

    provider = injector.getInstance(DslscenarioProvider.class);
    EmbeddedEditorFactory factory = injector.getInstance(EmbeddedEditorFactory.class);

    EmbeddedEditor editor = factory.newEditor(provider).withParent(top);
    editor.createPartialEditor();
    EmbeddedEditorInstance.seteEditor(editor);
  }

  public DslscenarioProvider getProvider() {
    return provider;
  }

  private void makeActions() {
    XtextEditorActionFactory actionsFactory = new XtextEditorActionFactory();
    actionsFactory.createRefreshAction(this);
    actionsFactory.createSaveAction(this);
  }

  @Override
  public void setFocus() {
  }
}
