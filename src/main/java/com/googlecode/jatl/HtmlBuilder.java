/**
 * Copyright (C) 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.googlecode.jatl;

import java.io.Writer;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Most of the XHTML tags and attributes are available as methods.
 * A rule of thumb is that most tags are no parameter methods and attribute
 * methods are single parameter.
 * 
 * @author adamgent
 *
 * @param <T> See {@link MarkupBuilder} for how this should be parameterized.
 */
public abstract class HtmlBuilder<T> extends MarkupBuilder<T> {

	public HtmlBuilder(Writer writer) {
		super(writer);
	}
	
	public HtmlBuilder(MarkupBuilder<?> builder) {
		super(builder);
	}

	public HtmlBuilder(MarkupBuilder<?> builder, boolean nested) {
		super(builder, nested);
	}
	
	protected HtmlBuilder() {
		super();
	}

	public T html() {
		return start("html", TagClosingPolicy.PAIR); 
	}
	
	public T head() {
		return start("head", TagClosingPolicy.PAIR);
	}
	
	public T body() {
		return start("body", TagClosingPolicy.PAIR); 
	}
	
	public T h1() {
		return start("h1", TagClosingPolicy.PAIR);
	}
	
	public T h2() {
		return start("h2", TagClosingPolicy.PAIR);
	}
	
	public T h3() {
		return start("h3", TagClosingPolicy.PAIR);
	}
	
	public T p() {
		return start("p", TagClosingPolicy.PAIR);
	}
	
	public T ul() {
		return start("ul", TagClosingPolicy.PAIR); 
	}
	
	public T ol() {
		return start("ol", TagClosingPolicy.PAIR); 
	}
	
	public T li() {
		return start("li", TagClosingPolicy.NORMAL); 
	}
	
	public T div() {
		return start("div", TagClosingPolicy.PAIR);
	}
	
	public T br() {
		start("br", TagClosingPolicy.SELF);
		return end();
	}
	
	public T span() {
		return start("span", TagClosingPolicy.PAIR);
	}
	
	public T form() {
		return start("form");
	}
	public T input() {
		return start("input", TagClosingPolicy.SELF);
	}
	public T value(String value) {
		return attr("value", value);
	}
	public T checkbox() {
		return checkbox(false);
	}
	
	public T checkbox(boolean checked) {
		input();
		attr("type", "checkbox");
		if (checked)
			attr("checked", "checked");
		return getSelf();
	}
	
	public T select() {
		return start("select");
	}
	
	public T option() {
		return start("option");
	}
	
	public T script() {
		return start("script", TagClosingPolicy.PAIR);
	}
	
	public T option(String name, String value, boolean selected) {
		start("option", TagClosingPolicy.PAIR);
		attr("value", value);
		if (selected)
			attr("selected", "selected");
		text(name);
		end();
		return getSelf();
	}
	
	public T clazz (String clazz) {
		return attr("class", clazz);
	}
	
	public T style(String style) {
		return attr("style", style);
	}
	
	/**
	 * Title attribute.
	 * 
	 * @param title maybe <code>null</code>.
	 * @return never <code>null</code>.
	 */
	public T title(String title) {
		return attr("title", title);
	}
	
	/**
	 * This is for the title tag that goes in html head.
	 * Not to be confused with the title attribute {@link #title(String)}.
	 * @return never <code>null</code>.
	 */
	public T title() {
	    return start("title", TagClosingPolicy.PAIR);
	}
	
	public T id(String id) {
		return attr("id", id);
	}
	public T name(String name) {
		return attr("name", name);
	}

	@Override
	protected String escapeMarkup(String raw) {
		return StringEscapeUtils.escapeHtml(raw);
	}

}
