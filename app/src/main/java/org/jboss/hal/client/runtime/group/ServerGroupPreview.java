/*
 * Copyright 2015-2016 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.hal.client.runtime.group;

import java.util.Arrays;

import org.jboss.hal.core.finder.PreviewAttributes;
import org.jboss.hal.core.finder.PreviewContent;
import org.jboss.hal.resources.Names;

/**
 * @author Harald Pehl
 */
class ServerGroupPreview extends PreviewContent<ServerGroup> {

    ServerGroupPreview(final ServerGroup serverGroup) {
        super(serverGroup.getName(), Names.PROFILE + " " + serverGroup.getProfile());

        //noinspection HardCodedStringLiteral
        PreviewAttributes<ServerGroup> attributes = new PreviewAttributes<>(serverGroup,
                Arrays.asList("profile", "socket-binding-group", "socket-binding-port-offset",
                        "socket-binding-default-interface"))
                .end();
        previewBuilder().addAll(attributes);
    }
}
