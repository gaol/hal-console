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
package org.jboss.hal.core.finder;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import elemental.client.Browser;
import elemental.dom.Element;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.HasElements;
import org.jboss.hal.ballroom.LabelBuilder;
import org.jboss.hal.dmr.ModelNode;
import org.jboss.hal.resources.CSS;
import org.jboss.hal.resources.Constants;
import org.jboss.hal.resources.Ids;
import org.jboss.hal.resources.Names;
import org.jboss.hal.resources.UIConstants;

import static org.jboss.hal.resources.CSS.key;
import static org.jboss.hal.resources.CSS.listGroup;
import static org.jboss.hal.resources.CSS.listGroupItem;

/**
 * Element to show the basic attributes of a resource inside the preview pane.
 *
 * @author Harald Pehl
 */
public class PreviewAttributes<T extends ModelNode> implements HasElements {

    public static class PreviewAttribute {

        final String label;
        final String value;
        final SafeHtml htmlValue;
        final String href;
        final Element element;
        final Iterable<Element> elements;

        public PreviewAttribute(final String label, final String value) {
            this(label, value, null, null, null, null);
        }

        public PreviewAttribute(final String label, final String value, final String href) {
            this(label, value, null, href, null, null);
        }

        public PreviewAttribute(final String label, final SafeHtml value) {
            this(label, null, value, null, null, null);
        }

        public PreviewAttribute(final String label, final SafeHtml value, final String href) {
            this(label, null, value, href, null, null);
        }

        public PreviewAttribute(final String label, final Iterable<Element> elements) {
            this(label, null, null, null, elements, null);
        }

        public PreviewAttribute(final String label, final Element element) {
            this(label, null, null, null, null, element);
        }

        private PreviewAttribute(final String label, final String value, final SafeHtml htmlValue, final String href,
                final Iterable<Element> elements, final Element element) {
            this.label = label;
            this.value = value;
            this.htmlValue = htmlValue;
            this.href = href;
            this.element = element;
            this.elements = elements;
        }

        private boolean isUndefined() {
            return value == null && htmlValue == null;
        }
    }


    @FunctionalInterface
    public interface PreviewAttributeFunction<T> {

        PreviewAttribute labelValue(T model);
    }


    private static final String DESCRIPTION = "description";
    private static final String LABEL = "label";
    private static final String VALUE = "value";
    private static final Constants CONSTANTS = GWT.create(Constants.class);

    private final T model;
    private final Element description;
    private final LabelBuilder labelBuilder;
    private final Elements.Builder builder;
    private final Map<String, PreviewAttributeFunction<T>> functions;
    private final Map<String, Element> attributeElements;
    private Element lastAttributeGroupItem;

    public PreviewAttributes(final T model) {
        this(model, CONSTANTS.mainAttributes(), null, Collections.emptyList());
    }

    public PreviewAttributes(final T model, final String header) {
        this(model, header, null, Collections.emptyList());
    }

    public PreviewAttributes(final T model, final List<String> attributes) {
        this(model, CONSTANTS.mainAttributes(), null, attributes);
    }

    public PreviewAttributes(final T model, final String header, final List<String> attributes) {
        this(model, header, null, attributes);
    }

    public PreviewAttributes(final T model, final String header, final String description,
            final List<String> attributes) {
        this.model = model;
        this.labelBuilder = new LabelBuilder();
        this.functions = new HashMap<>();
        this.attributeElements = new HashMap<>();
        this.builder = new Elements.Builder().h(2).textContent(header).end().p().rememberAs(DESCRIPTION).end();

        this.description = builder.referenceFor(DESCRIPTION);
        if (description != null) {
            this.description.setTextContent(description);
        } else {
            Elements.setVisible(this.description, false);
        }

        this.builder.ul().css(listGroup);
        attributes.forEach(this::append);
    }

    public PreviewAttributes<T> append(final String attribute) {
        append(model -> new PreviewAttribute(labelBuilder.label(attribute),
                model.hasDefined(attribute) ? model.get(attribute).asString() : ""));
        attributeElements.put(attribute, lastAttributeGroupItem);
        return this;
    }

    public PreviewAttributes<T> append(final String attribute, String href) {
        append(model -> new PreviewAttribute(labelBuilder.label(attribute),
                model.hasDefined(attribute) ? model.get(attribute).asString() : "",
                href));
        attributeElements.put(attribute, lastAttributeGroupItem);
        return this;
    }

    public PreviewAttributes<T> append(final PreviewAttributeFunction<T> function) {
        String id = Ids.uniqueId();
        String labelId = Ids.build(id, LABEL);
        String valueId = Ids.build(id, VALUE);
        functions.put(id, function);

        PreviewAttribute previewAttribute = function.labelValue(model);
        // @formatter:off
        builder.li().rememberAs(id).css(listGroupItem)
            .span().rememberAs(labelId).css(key).textContent(previewAttribute.label).end();
            if (previewAttribute.elements != null || previewAttribute.element != null) {
                builder.span().rememberAs(valueId).css(CSS.value);
                if (previewAttribute.elements != null) {
                    builder.addAll(previewAttribute.elements);
                } else {
                    builder.add(previewAttribute.element);
                }
                builder.end();
            } else {
                if (previewAttribute.href != null) {
                    builder.a(previewAttribute.href);
                }
                builder.span().rememberAs(valueId).css(CSS.value);
                if (previewAttribute.isUndefined()) {
                    builder.textContent(Names.NOT_AVAILABLE);
                }
                else if (previewAttribute.htmlValue != null) {
                    builder.innerHtml(previewAttribute.htmlValue);
                } else {
                    builder.textContent(previewAttribute.value);
                    if (previewAttribute.value.length() > 15) {
                        builder.title(previewAttribute.value);
                    }
                }
                builder.end(); // </span>
                if (previewAttribute.href != null) {
                    builder.end(); // </a>
                }
            }
        builder.end(); // </li>
        // @formatter:on

        lastAttributeGroupItem = builder.referenceFor(id);
        return this;
    }

    public PreviewAttributes<T> end() {
        builder.end();
        return this;
    }

    public void refresh(T model) {
        for (Map.Entry<String, PreviewAttributeFunction<T>> entry : functions.entrySet()) {
            String id = entry.getKey();
            String labelId = Ids.build(id, LABEL);
            String valueId = Ids.build(id, VALUE);

            PreviewAttributeFunction<T> function = entry.getValue();
            PreviewAttribute previewAttribute = function.labelValue(model);

            builder.referenceFor(labelId).setTextContent(previewAttribute.label);
            Element span = builder.referenceFor(valueId);
            if (previewAttribute.elements != null) {
                Elements.removeChildrenFrom(span);
                previewAttribute.elements.forEach(span::appendChild);
            } else if (previewAttribute.element != null) {
                Elements.removeChildrenFrom(span);
                span.appendChild(previewAttribute.element);
            } else if (previewAttribute.htmlValue != null || previewAttribute.value != null) {
                Element parent = span.getParentElement();
                if (previewAttribute.href != null) {
                    if ("a".equalsIgnoreCase(parent.getTagName())) { //NON-NLS
                        parent.setAttribute(UIConstants.HREF, previewAttribute.href);
                    } else {
                        Element a = Browser.getDocument().createElement("a");
                        a.setAttribute(UIConstants.HREF, previewAttribute.href);
                        parent.removeChild(span);
                        a.appendChild(span);
                        parent.appendChild(a);
                    }
                } else {
                    if ("a".equalsIgnoreCase(parent.getTagName())) { //NON-NLS
                        // no more href - remove a element again
                        Element grandParent = parent.getParentElement();
                        grandParent.removeChild(parent);
                        grandParent.appendChild(span);
                    }
                }
                if (previewAttribute.htmlValue != null) {
                    span.setInnerHTML(previewAttribute.htmlValue.asString());
                } else {
                    span.setTextContent(previewAttribute.value);
                }
            }
        }
    }

    public void setVisible(String attribute, boolean visible) {
        Elements.setVisible(attributeElements.get(attribute), visible);
    }

    public void setDescription(String description) {
        this.description.setTextContent(description);
        Elements.setVisible(this.description, true);
    }

    public void setDescription(SafeHtml description) {
        this.description.setInnerHTML(description.asString());
        Elements.setVisible(this.description, true);
    }

    public void setDescription(Element description) {
        Elements.removeChildrenFrom(description);
        this.description.appendChild(description);
        Elements.setVisible(this.description, true);
    }

    public void hideDescription() {
        Elements.setVisible(this.description, false);
    }

    @Override
    public Iterable<Element> asElements() {
        return builder.elements();
    }
}
