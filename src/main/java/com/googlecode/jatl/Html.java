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
 * <p>
 * <strong>Example:</strong>
 * <pre>
 * new Html(writer) {{
 * 	html().head();
 * 	title().text("Hello").end();
 *	h1().id("title").text("World").end();
 * 	done();
 * }};
 * </pre>
 * <p>
 * If you would like to extend an HTML builder <em>DO NOT INHERIT FROM THIS CLASS</em>.
 * <p>
 *  Instead inherit from {@link HtmlBuilder} and parameterize with the name of your custom builder.
 *  <p>
 * @author adamgent
 */
public class Html extends HtmlBuilder<Html> {


	/**
	 * See {@link MarkupBuilder#MarkupBuilder(Writer)}
	 * @param writer never <code>null</code>.
	 */
	public Html(Writer writer) {
		super(writer);
	}
	
	/**
	 * See {@link MarkupBuilder#MarkupBuilder(MarkupBuilder)}
	 * @param builder never <code>null</code>.
	 */
	public Html(MarkupBuilder<?> builder) {
		super(builder);
	}
	
	

	/**
	 * See {@link MarkupBuilder#MarkupBuilder(MarkupBuilder, boolean)}
	 * @param builder never <code>null</code>.
	 * @param nested never <code>null</code>.
	 */
	public Html(MarkupBuilder<?> builder, boolean nested) {
		super(builder, nested);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Html getSelf() {
		return this;
	}	
	
}