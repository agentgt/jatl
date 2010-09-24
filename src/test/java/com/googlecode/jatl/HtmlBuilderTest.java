package com.googlecode.jatl;

import static org.junit.Assert.*;

import java.io.StringWriter;


import org.junit.Before;
import org.junit.Test;

import com.googlecode.jatl.Html;

public class HtmlBuilderTest {
	StringWriter sw = new StringWriter();
	Html html = new Html(sw);
	
	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void testFluentHtml() {
		html
			.div()
			.select().id("adam").name("adam")
			.option("Hello", "1", true)
			.option("Crap", "2", false)
			.br()
			.endAll();
		String result = sw.getBuffer().toString();
		String expected = 
				"\n" + 
				"<div>\n" + 
				"	<select id=\"adam\" name=\"adam\">\n" + 
				"		<option value=\"1\" selected=\"selected\">Hello\n" +
				"		</option>\n" +
				"		<option value=\"2\">Crap\n" + 
				"		</option>\n" + 
				"		<br/>\n" +
				"	</select>\n" + 
				"</div>";
		assertEquals(expected, result);
	}
	
	@Test
	public void testFluentHtmlEndWithArg() {
		html
			.div()
			.select().id("adam").name("adam")
			.option("Hello", "1", true)
			.end(3);
		
		String result = sw.getBuffer().toString();
		String expected = 
				"\n" + 
				"<div>\n" + 
				"	<select id=\"adam\" name=\"adam\">\n" + 
				"		<option value=\"1\" selected=\"selected\">Hello\n" +
				"		</option>\n" + 
				"	</select>\n" + 
				"</div>";
		assertEquals(expected, result);
	}
	
	@Test
	public void testFluentHtmlCheckbox() {
		html
			.div()
			.checkbox()
				.name("adam")
				.value("crap")
			.checkbox()
			.endAll();
		String result = sw.getBuffer().toString();
		String expected = "\n" + 
				"<div>\n" + 
				"	<input type=\"checkbox\" name=\"adam\" value=\"crap\"/>\n" + 
				"	<input type=\"checkbox\"/>\n" + 
				"</div>";
		assertEquals(expected, result);
	}
	
	@Test
	public void testAnonClassHtml() {
		new Html(sw) {{
			div().title("first");
				span().id("hello").end();
				div().title("second");
					text("Second");
				end();
			end();
		}};
		String result = sw.getBuffer().toString();
		String expected = "\n" +
				"<div title=\"first\">\n" + 
				"	<span id=\"hello\">\n" + 
				"	</span>\n" + 
				"	<div title=\"second\">Second\n" + 
				"	</div>\n" + 
				"</div>";
		assertEquals(expected, result);
	}
	
	

}
