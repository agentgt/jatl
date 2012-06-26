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

import org.junit.Test;

public class XmlWriterTest {

	XmlWriter xml;
	
	@Test
	public void testWriter() throws Exception {
		//Do not write yet.
		xml = new XmlWriter() {
			@Override
			protected void build() {
				start("element").attr("attribute", "first").indent(indentOff).end();
				indent(indentOn);
				start("element").attr("attribute", "second").end();
				done();
			}
		};
		//Now write.
		String actual = xml.toString();
		String expected = "<element attribute=\"first\"/>\n" + 
				"<element attribute=\"second\"/>";
		assertEquals(expected, actual);

	}
}
