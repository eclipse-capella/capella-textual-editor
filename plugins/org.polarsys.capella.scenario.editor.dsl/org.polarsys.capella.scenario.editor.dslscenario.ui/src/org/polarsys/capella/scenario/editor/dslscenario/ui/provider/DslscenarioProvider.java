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
package org.polarsys.capella.scenario.editor.dslscenario.ui.provider;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

public class DslscenarioProvider implements IEditedResourceProvider {
  @Inject
  private IResourceSetProvider resourceSetProvider;
  @Inject
  private FileExtensionProvider ext;
  private XtextResource resource;

  /*
   * create a temporary resource for the xtext editor
   */
  @Override
  public XtextResource createResource() {
    ResourceSet resourceSet = resourceSetProvider.get(null);
    URI uri = URI.createURI("synthetic:/dslscenario." + ext.getPrimaryFileExtension());
    resource = (XtextResource) resourceSet.createResource(uri);
    resourceSet.getResources().add(resource);
    return resource;
  }

  public XtextResource getResource() {
    return resource;
  }
}
