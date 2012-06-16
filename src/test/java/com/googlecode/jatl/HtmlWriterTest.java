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


import static org.junit.Assert.assertEquals;

import java.io.StringWriter;

import org.junit.Test;

public class HtmlWriterTest {

	StringWriter writer = new StringWriter();
	HtmlWriter html;
	
	@Test
	public void testWriter() throws Exception {
		//Do not write yet.
		html = new HtmlWriter() {
			@Override
			protected void build() {
				html().head().end().body();
				text("Hello");
				done();
			}
		};
		//Now write.
		String actual = html.write(writer).getBuffer().toString();
		String expected = "\n" + 
				"<html>\n" + 
				"	<head>\n" + 
				"	</head>\n" + 
				"	<body>Hello\n" + 
				"	</body>\n" + 
				"</html>";
		assertEquals(expected, actual);
		
	}
	
	private HtmlWriter createInput(final String name, final String value) {
		return new HtmlWriter() {
			@Override
			protected void build() {
				input().name(name).value(value).end();
			}
		};
	}
	
	private HtmlWriter createForm(final HtmlWriter ... inputs) {
		return new HtmlWriter() {
			@Override
			protected void build() {
				form().write(inputs).end();
			}
		};
	}
	
	@Test
	public void testWriterMethod() throws Exception {

		
		final HtmlWriter input = createInput("test", "value");
		
		final HtmlWriter form = createForm(input);
		
		//Do not write yet.
		html = new HtmlWriter() {
			@Override
			protected void build() {
				html().head().end().body();
				text("Hello");
				write(form);
				done();
			}
		};
		
		//Now write.
		String actual = html.write(writer).getBuffer().toString();
		String expected = "\n" + 
				"<html>\n" + 
				"	<head>\n" + 
				"	</head>\n" + 
				"	<body>Hello\n" + 
				"		<form>\n" + 
				"			<input name=\"test\" value=\"value\"/>\n" + 
				"		</form>\n" + 
				"	</body>\n" + 
				"</html>";
		assertEquals(expected, actual);
		
	}
}
