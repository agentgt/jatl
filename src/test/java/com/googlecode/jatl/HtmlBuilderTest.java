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

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

import java.io.StringWriter;
import java.io.Writer;

import org.junit.Before;
import org.junit.Test;

public class HtmlBuilderTest {
	StringWriter sw = new StringWriter();
	StringWriter writer = sw;
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
					start("custom1").attr("data", "value").end();
					start("custom2").text("hello").end();
				end();
			end();
		}};
		String result = sw.getBuffer().toString();
		String expected = "\n" + 
				"<div title=\"first\">\n" + 
				"	<span id=\"hello\"/>\n" + 
				"	<div title=\"second\">Second\n" + 
				"		<custom1 data=\"value\"/>\n" + 
				"		<custom2>hello\n" + 
				"		</custom2>\n" + 
				"	</div>\n" + 
				"</div>";
		assertEquals(expected, result);
	}
	
	@Test
	public void testExample() throws Exception {
		//From http://codemonkeyism.com/the-best-markup-builder-i-could-build-in-java/
		new Html(writer) {{
		    bind("id", "foo");
		    bind("coolName", "Awesomo");
			html();
				body();
    				h1().text("Name Games").end();
    				p().id("${id}").text("Hello ${coolName}, and hello").end();
    			makeList("Kyle","Stan", "Eric", "${coolName}");
    		endAll();
			done();
		}
			Html makeList(String ... names) {
				ul();
				for(String name : names) {
					li().text(name).end();
				}
				return end();
			}
		};
		String result = writer.getBuffer().toString();
		String expected = "\n" + 
				"<html>\n" + 
				"	<body>\n" + 
				"		<h1>Name Games\n" + 
				"		</h1>\n" + 
				"		<p id=\"foo\">Hello Awesomo, and hello\n" + 
				"		</p>\n" + 
				"		<ul>\n" + 
				"			<li>Kyle\n" + 
				"			</li>\n" + 
				"			<li>Stan\n" + 
				"			</li>\n" + 
				"			<li>Eric\n" + 
				"			</li>\n" + 
				"			<li>Awesomo\n" + 
				"			</li>\n" + 
				"		</ul>\n" + 
				"	</body>\n" + 
				"</html>";
		assertEquals(expected, result);
	}
	
	@Test
	public void testNestedBuilder() throws Exception {
		new Html(writer) {{
		    bind("id", "foo");
		    bind("coolName", "Awesomo");
			html();
				body();
    				h1().text("${coolName}").end();
    				new MyMarkup(this) {{
    					div().text("this ${coolName} should not be surround by a html div");
    					done();
    				}};
			done();
		}};
		String result = writer.getBuffer().toString();
		String expected = "\n" + 
				"<html>\n" + 
				"	<body>\n" + 
				"		<h1>Awesomo\n" + 
				"		</h1>\n" + 
				"		<divide>this Awesomo should not be surround by a html div\n" + 
				"		</divide>\n" + 
				"	</body>\n" + 
				"</html>";
		assertEquals(expected, result);
	}
	
	public static class MyMarkup extends MarkupBuilder<MyMarkup> {

		public MyMarkup(MarkupBuilder<?> builder) {
			super(builder);
		}

		@Override
		protected MyMarkup getSelf() {
			return this;
		}
		
		public MyMarkup div() {
			return start("divide");
		}
	}
	
	@Test
	public void testBuilderResuming() throws Exception {
		/*
		 * Builder resuming is kind of dangerous.
		 */
		Html page = new Html(writer);
		/*
		 * Do the header first.
		 */
		page = new Html(page, false) {{
			html().head().end();
			body();
		}};
		/*
		 * Body.
		 */
		page = new Html(page, false) {{
			h1().text("Hello World").end();
		}};
		/*
		 * Do the footer
		 */
		page = new Html(page, false) {{
			end();
			end();
		}};
		
		String result = writer.getBuffer().toString();
		String expected = "\n" + 
				"<html>\n" + 
				"	<head>\n" + 
				"	</head>\n" + 
				"	<body>\n" + 
				"		<h1>Hello World\n" + 
				"		</h1>\n" + 
				"	</body>\n" + 
				"</html>";
		assertEquals(expected, result);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setWriter() throws Exception {
		Html h = new Html(writer) {{
			div().text("hello").end();
			done();
		}};
		h.setWriter(null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidAttributes() throws Exception {
		new Html(writer) {{
			div().attr("data","stuff","cat");
		}};		
	}
	
	@Test
	public void testMultiAttributes() throws Exception {
		new Html(writer) {{
			div().attr("id", "top", "data", "{'a' : 'b>'}");
			done();
		}};
		String actual = writer.getBuffer().toString();
		String expected = "\n" + 
				"<div id=\"top\" data=\"{'a' : 'b&gt;'}\">\n" + 
				"</div>";
		assertEquals(expected, actual);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNullWriter() throws Exception {
		new Html((Writer)null) {{
		
		}};
	}
	
	@Test
	public void testRaw() throws Exception {
		new Html(writer) {{
			html().head().end().body().h1().text("hello").end();
			div().raw("<crap></crap>").end();
			endAll();
		}};
		String result = writer.getBuffer().toString();
		String expected = "\n" + 
				"<html>\n" + 
				"	<head>\n" + 
				"	</head>\n" + 
				"	<body>\n" + 
				"		<h1>hello\n" + 
				"		</h1>\n" + 
				"		<div><crap></crap>\n" + 
				"		</div>\n" + 
				"	</body>\n" + 
				"</html>";
		assertEquals(expected, result);
	}
	
	@Test
	public void testRawExpand() throws Exception {
		new Html(writer) {{
			bind("name", "Adam");
			html().head().end().body().h1().text("hello").end();
			div().raw("<crap>${name}</crap>", true).end();
			endAll();
		}};
		String result = writer.getBuffer().toString();
		String expected = "\n" + 
				"<html>\n" + 
				"	<head>\n" + 
				"	</head>\n" + 
				"	<body>\n" + 
				"		<h1>hello\n" + 
				"		</h1>\n" + 
				"		<div><crap>Adam</crap>\n" + 
				"		</div>\n" + 
				"	</body>\n" + 
				"</html>";
		assertEquals(expected, result);
	}
	
	@Test
	public void testEscapeText() throws Exception {
		new Html(writer) {{
			html().head().end().body().h1().text("hello").end();
			div().text("<crap></crap>").end();
			done();
		}};
		String result = writer.getBuffer().toString();
		String expected = "\n" + 
				"<html>\n" + 
				"	<head>\n" + 
				"	</head>\n" + 
				"	<body>\n" + 
				"		<h1>hello\n" + 
				"		</h1>\n" + 
				"		<div>&lt;crap&gt;&lt;/crap&gt;\n" + 
				"		</div>\n" + 
				"	</body>\n" + 
				"</html>";
		assertEquals(expected, result);
	}
	
	@Test
	public void testVariableBinding() throws Exception {
		new Html(writer) {{
			bind("first", "Adam").bind("last", "Gent");
			bind("full", "${first} ${last}");
			text("My name is ${full} but just call me ${first}."); 
		}};
		String result = writer.getBuffer().toString();
		String expected = "My name is Adam Gent but just call me Adam.";
		assertEquals(result, expected);
	}
	@Test
	public void testNamespace() throws Exception {
		new Html(writer) {{
			html()
				.xmlns("http://www.w3.org/1999/xhtml")
				.xmlns("http://www.w3.org/1999/XSL/Transform", "xsl")
				.attr("xml:lang", "en")
				.attr("lang","en");
			ns("xsl");
			start("template").attr("match", "body");
				text("blah");
				ns();
				//Should have xsl prefix
				span().end();
			end();
			start("xsl:template").attr("match", "title");
				text("blah");
			end();
			ns(null);
			div().text("no prefix");
			done();
		}};
		
		String result = writer.getBuffer().toString();
		String expected = "\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\" " +
				"xsl:xmlns=\"http://www.w3.org/1999/XSL/Transform\" xml:lang=\"en\" lang=\"en\">\n" + 
				"	<xsl:template match=\"body\">blah\n" + 
				"		<xsl:span/>\n" + 
				"	</xsl:template>\n" + 
				"	<xsl:template match=\"title\">blah\n" + 
				"	</xsl:template>\n" + 
				"	<div>no prefix\n" + 
				"	</div>\n" + 
				"</html>";
		assertEquals(expected, result);
	}
	
	@Test
	public void testTable() throws Exception {
		new Html(writer) {{
			table().width("100%").height("100%");
			thead().tr();
			for (String header : asList("A","B","C")) {
				th().text(header).end();
			}
			end().end();
			tbody();
			for (int i = 0; i < 3; i++) {
				tr();
				for(String cell : asList("a","b","c")) {
					td().text(cell).end();
				}
				end();
			}
			done();
		}};
		
		String result = writer.getBuffer().toString();
		String expected = "\n" + 
				"<table width=\"100%\" height=\"100%\">\n" + 
				"	<thead>\n" + 
				"		<tr>\n" + 
				"			<th>A\n" + 
				"			</th>\n" + 
				"			<th>B\n" + 
				"			</th>\n" + 
				"			<th>C\n" + 
				"			</th>\n" + 
				"		</tr>\n" + 
				"	</thead>\n" + 
				"	<tbody>\n" + 
				"		<tr>\n" + 
				"			<td>a\n" + 
				"			</td>\n" + 
				"			<td>b\n" + 
				"			</td>\n" + 
				"			<td>c\n" + 
				"			</td>\n" + 
				"		</tr>\n" + 
				"		<tr>\n" + 
				"			<td>a\n" + 
				"			</td>\n" + 
				"			<td>b\n" + 
				"			</td>\n" + 
				"			<td>c\n" + 
				"			</td>\n" + 
				"		</tr>\n" + 
				"		<tr>\n" + 
				"			<td>a\n" + 
				"			</td>\n" + 
				"			<td>b\n" + 
				"			</td>\n" + 
				"			<td>c\n" + 
				"			</td>\n" + 
				"		</tr>\n" + 
				"	</tbody>\n" + 
				"</table>";
		assertEquals(expected, result);
	}
	
	@Test
	public void testHeaders() throws Exception {
		new Html(writer) {{
			String title = "Header ";
			int i = 1;
			h1().text(title + i++ ).end();
			h2().text(title + i++).end();
			h3().text(title + i++).end();
			h4().text(title + i++).end();
			h5().text(title + i++).end();
			h6().text(title + i++).end();
		}};
		String result = writer.getBuffer().toString();
		String expected = "\n" + 
				"<h1>Header 1\n" + 
				"</h1>\n" + 
				"<h2>Header 2\n" + 
				"</h2>\n" + 
				"<h3>Header 3\n" + 
				"</h3>\n" + 
				"<h4>Header 4\n" + 
				"</h4>\n" + 
				"<h5>Header 5\n" + 
				"</h5>\n" + 
				"<h6>Header 6\n" + 
				"</h6>";
		assertEquals(expected, result);
	}
	
	@Test
	public void testHead() throws Exception {
		new Html(writer) {{
			head();
				title().text("Hello World").end();
				link().href("http://").media("screen").rel("stylesheet").type("text/css");
				meta().name("medium").content("blog");
				script().type("text/javascript").src("blah.js").end();
				style().type("text/css")
					.text("");
			done();
		}};
		String result = writer.getBuffer().toString();
		String expected = "\n" + 
				"<head>\n" + 
				"	<title>Hello World\n" + 
				"	</title>\n" + 
				"	<link href=\"http://\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\"/>\n" + 
				"	<meta name=\"medium\" content=\"blog\"/>\n" + 
				"	<script type=\"text/javascript\" src=\"blah.js\">\n" + 
				"	</script>\n" + 
				"	<style type=\"text/css\">\n" + 
				"	</style>\n" + 
				"</head>";
		assertEquals(expected, result);
	}
	
	@Test //http://code.google.com/p/jatl/issues/detail?id=3
	public void testIssue3() throws Exception {
		new Html(writer).div().textarea().cols("1").rows("1").end().text("Message:").end();
		String result = writer.getBuffer().toString();
		String expected ="\n" + 
				"<div>\n" + 
				"	<textarea cols=\"1\" rows=\"1\">\n" + 
				"	</textarea>Message:\n" + 
				"</div>";
		assertEquals(expected, result);
	}
	
	@Test
	public void testIndenter() throws Exception {
		new Html(writer) {{
			bind("name", "Adam");
			html().head().indent(indentSameLine).end().body().indent(indentOn).h1().indent(indentOff).text("hello").end();
			div().indent(indentOn).raw("<crap>${name}</crap>", true).end();
			endAll();
		}};
		String result = writer.getBuffer().toString();
		String expected = "\n" + 
				"<html>\n" + 
				"	<head></head>\n" + 
				"	<body><h1>hello</h1>\n" + 
				"		<div><crap>Adam</crap>\n" + 
				"		</div>\n" + 
				"	</body>\n" + 
				"</html>";
		assertEquals(expected, result);
	}
	
	@Test
	public void testCustomIndenter() throws Exception {
		final Indenter indenter = new SimpleIndenter("\n", "\t", "", "");
		new Html(writer) {{
			int i = 1;
			indent(indentOff).html().body().indent(indenter);
			table();
			tr();
				td().text("" + i++).end();
				td().text("" + i++).end();
			end();
			tr();
				td().text("" + i++).end();
			endAll();
		}};
		String result = writer.getBuffer().toString();
		String expected = "<html>\n" + 
				"	<body>\n" + 
				"		<table>\n" + 
				"			<tr>\n" + 
				"				<td>1</td>\n" + 
				"				<td>2</td></tr>\n" + 
				"			<tr>\n" + 
				"				<td>3</td></tr></table></body></html>";
		assertEquals(expected, result);
	}
	
	@Test
	public void testCustomIndenterIssue13() throws Exception {
		final Indenter indenter = new SimpleIndenter("\n", "\t", "", "");
		new Html(writer) {{
			int i = 1;
			indent(indentOff).html().body().indent(indenter);
			table();
			tr();
				td().text("" + i++).end();
				td().text("" + i++).end();
			end();
			tr();
				td().text("" + i++).end();
			endAll();
		}};
		String result = writer.getBuffer().toString();
		String expected = "<html>\n" + 
				"	<body>\n" + 
				"		<table>\n" + 
				"			<tr>\n" + 
				"				<td>1</td>\n" + 
				"				<td>2</td></tr>\n" + 
				"			<tr>\n" + 
				"				<td>3</td></tr></table></body></html>";
		assertEquals(expected, result);
	}
	
	@Test
	public void testAttributeWhitespaceEscaping() throws Exception {
		new Html(writer) {{
			html().head().end();
			input().value("hello\012world");
			input().value("hello\t\tworld");
			done();
		}};
		String result = writer.getBuffer().toString();
		String expected = "\n" + 
				"<html>\n" + 
				"	<head>\n" + 
				"	</head>\n" + 
				"	<input value=\"hello&#xA;world\"/>\n" + 
				"	<input value=\"hello&#x9;&#x9;world\"/>\n" + 
				"</html>";
		assertEquals(expected, result);		
	}
	
	@Test
	public void testIssue16Iframe() {
		new Html(writer) {{
			iframe().src("http://www.google.com").end();
			done();
		}};
		String result = writer.getBuffer().toString();
		String expected = "\n" + 
				"<iframe src=\"http://www.google.com\">\n" + 
				"</iframe>";
		assertEquals(expected, result);
	}
	
	@Test
	public void testIssue18TagClosingPairPolicyFailing() throws Exception {
		new Html(sw) {
			{
				div();
				hr().text("");
				end();
			}
		};
		String result = writer.getBuffer().toString();
		String expected = "\n" + 
				"<div>\n" + 
				"	<hr/>\n" +
				"</div>";
		assertEquals(expected, result);
	}

	@Test(expected=IllegalStateException.class)
	public void testIllegalAttributeOrder() throws Exception {
		new Html(sw) {
			{
				div();
				hr().text("");
				attr("id", "cat");
				div().end();
				end();
			}
		};
		writer.getBuffer().toString();
	}
	
	@Test(expected=IllegalStateException.class)
	public void testIllegalAttributesBeforeStartTag() throws Exception {
		new Html(sw) {
			{
				attr("id", "cat");
				div();
				end();
			}
		};
		writer.getBuffer().toString();
	}
	
}
