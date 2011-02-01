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
			// TODO Auto-generated constructor stub
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
