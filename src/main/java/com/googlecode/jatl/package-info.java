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

/**
 * For quickstart documentation: <a href="http://jatl.googlecode.com/">http://jatl.googlecode.com/</a> and {@link com.googlecode.jatl.MarkupBuilder}.
 * <p>
 * <strong>Example</strong>
 * </p>
 * <pre>
	StringWriter sw = new StringWriter();
	new Html(sw) {{
		div().title("first");
			span().id("hello").end();
			div().title("second");
				text("Second");
				start("custom1").attr("data", "value").end();
				start("custom2").text("hello").end();
			end();
		end();
	}};
	String result = sw.getBuffer().toString();
	String expected = "\n" + 
			"&lt;div title=\"first\"&gt;\n" + 
			"	&lt;span id=\"hello\"/&gt;\n" + 
			"	&lt;div title=\"second\"&gt;Second\n" + 
			"		&lt;custom1 data=\"value\"/&gt;\n" + 
			"		&lt;custom2&gt;hello\n" + 
			"		&lt;/custom2&gt;\n" + 
			"	&lt;/div&gt;\n" + 
			"&lt;/div&gt;";
	assertEquals(expected, result);
 * </pre>
 * <p>
 * See {@link com.googlecode.jatl.MarkupBuilder} for creating your own markup builders.
 * </p>
 */
package com.googlecode.jatl;

