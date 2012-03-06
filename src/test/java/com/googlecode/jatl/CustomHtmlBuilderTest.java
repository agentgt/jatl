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

import static org.junit.Assert.*;

import java.io.StringWriter;
import java.io.Writer;

import org.junit.Test;

public class CustomHtmlBuilderTest {
	
	/**
	 * My own custom HTML Builder.
	 * This is akin to making a JQuery plugin
	 * except that Java does not have mixins (Traits).
	 * 
	 * @author agent
	 *
	 */
	public abstract static class CustomBuilder<T> extends HtmlBuilder<T> {
		
		
		/*
		 * Put Custom methods here.
		 * This where you can do composition.
		 * A slight annoyance is that you cannot do dotted notation.
		 */
		
		public CustomBuilder(Writer writer) {
			super(writer);
		}

		public T list(String ... ss) {
			ul();
			for (String s : ss) {
				li(); text(s); end();
			}
			end();
			return getSelf();
		}
	}
	
	public static class Custom extends CustomBuilder<Custom> {
		
		
		public Custom(Writer writer) {
			super(writer);
		}

		@Override
		protected Custom getSelf() {
			return this;
		}
	
	}
	
	@Test
	public void testCustom() throws Exception {
		StringWriter sw = new StringWriter();
		new Custom(sw) {{
			div().list("Tom", "Dick", "Jane").endAll();
		}};
		assertEquals("\n" + 
				"<div>\n" + 
				"	<ul>\n" + 
				"		<li>Tom\n" + 
				"		</li>\n" + 
				"		<li>Dick\n" + 
				"		</li>\n" + 
				"		<li>Jane\n" + 
				"		</li>\n" + 
				"	</ul>\n" + 
				"</div>", sw.toString());
	}

}
