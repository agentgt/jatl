/**
 * Copyright (C) 2012 the original author or authors.
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

/**
 * Most of the XHTML tags and attributes are available as methods.
 * A rule of thumb is that most tags are zero parameter methods and attribute
 * methods are single parameter.
 * 
 * @author adamgent
 *
 * @param <T> See {@link MarkupBuilder} for how this should be parameterized.
 */
public abstract class HtmlBuilder<T> extends GeneratedHtmlBuilder<T> {

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
	
	
	public T option(String name, String value, boolean selected) {
		option();
		value(value);
		if (selected)
			selected("selected");
		text(name);
		end();
		return getSelf();
	}

}
