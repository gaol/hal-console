/*
 *  Copyright 2022 Red Hat
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.jboss.hal.client.accesscontrol;

import javax.inject.Inject;

import org.jboss.hal.ballroom.Alert;
import org.jboss.hal.ballroom.form.Form;
import org.jboss.hal.ballroom.form.TextBoxItem;
import org.jboss.hal.ballroom.form.URLItem;
import org.jboss.hal.config.Environment;
import org.jboss.hal.config.keycloak.Keycloak;
import org.jboss.hal.config.keycloak.KeycloakHolder;
import org.jboss.hal.core.accesscontrol.AccessControl;
import org.jboss.hal.core.mbui.form.ModelNodeForm;
import org.jboss.hal.core.mvp.HalViewImpl;
import org.jboss.hal.dmr.ModelNode;
import org.jboss.hal.meta.Metadata;
import org.jboss.hal.resources.Icons;
import org.jboss.hal.resources.Ids;
import org.jboss.hal.resources.Names;
import org.jboss.hal.resources.Resources;

import com.google.gwt.safehtml.shared.SafeHtml;

import elemental2.dom.HTMLElement;

import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.h;
import static org.jboss.elemento.Elements.p;
import static org.jboss.hal.ballroom.LayoutBuilder.column;
import static org.jboss.hal.ballroom.LayoutBuilder.row;
import static org.jboss.hal.config.AccessControlProvider.SIMPLE;
import static org.jboss.hal.dmr.ModelDescriptionConstants.KEYCLOAK;
import static org.jboss.hal.dmr.ModelDescriptionConstants.PROVIDER;
import static org.jboss.hal.dmr.ModelDescriptionConstants.PROVIDER_URL;
import static org.jboss.hal.dmr.ModelDescriptionConstants.USERNAME;
import static org.jboss.hal.resources.Ids.FORM;
import static org.jboss.hal.resources.Ids.USER;

public class AccessControlSsoView extends HalViewImpl implements AccessControlSsoPresenter.MyView {

    private Form<ModelNode> form;
    private AccessControlSsoPresenter presenter;

    @Inject
    public AccessControlSsoView(AccessControl accessControl, Environment environment, Resources resources,
            KeycloakHolder keycloakHolder) {
        HTMLElement layout;
        Keycloak keycloak = keycloakHolder.getKeycloak();
        if (keycloak != null) {
            SafeHtml providerText = environment.getAccessControlProvider() == SIMPLE
                    ? resources.messages().switchToRbacProvider()
                    : resources.messages().switchToSimpleProvider();
            Alert providerInfo = new Alert(Icons.INFO, providerText, resources.constants().switchProvider(),
                    event -> {
                        accessControl.switchProvider();
                        presenter.onReset();
                    });

            Keycloak.UserProfile userProfile = keycloakHolder.getKeycloak().userProfile;
            TextBoxItem user = new TextBoxItem(USER);
            if (userProfile.firstName != null) {
                String userValue = userProfile.firstName + " " + userProfile.lastName + " <" + userProfile.email + ">";
                user.setValue(userValue);
            }
            TextBoxItem userName = new TextBoxItem(USERNAME);
            userName.setValue(userProfile.username);
            URLItem authServerUrl = new URLItem(PROVIDER_URL);
            TextBoxItem realm = new TextBoxItem(PROVIDER);
            URLItem accountUrl = new URLItem("account-url");
            accountUrl.setValue(keycloakHolder.getKeycloak().createAccountUrl());

            form = new ModelNodeForm.Builder<>(Ids.build(KEYCLOAK, FORM), Metadata.empty())
                    .readOnly()
                    .unboundFormItem(userName)
                    .unboundFormItem(user)
                    .unboundFormItem(authServerUrl)
                    .unboundFormItem(accountUrl)
                    .unboundFormItem(realm)
                    .build();
            registerAttachable(form);

            layout = div()
                    .add(h(1).textContent(Names.ACCESS_CONTROL))
                    .add(p().textContent(resources.messages().accessControlSsoDescription()))
                    .add(providerInfo)
                    .add(form).element();
        } else {
            layout = div()
                    .add(h(1).textContent(Names.ACCESS_CONTROL))
                    .add(p().textContent(resources.messages().accessControlSsoDescription()))
                    .add(new Alert(Icons.DISABLED, resources.messages().noResource()))
                    .element();
        }

        initElement(row()
                .add(column()
                        .addAll(layout)));
    }

    @Override
    public void setPresenter(AccessControlSsoPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    @SuppressWarnings("HardCodedStringLiteral")
    public void update(ModelNode payload) {
        if (form != null) {
            form.getFormItem(PROVIDER_URL).setValue(payload.get(PROVIDER_URL).asString());
            form.getFormItem(PROVIDER).setValue(payload.get(PROVIDER).asString());
        }
    }
}
