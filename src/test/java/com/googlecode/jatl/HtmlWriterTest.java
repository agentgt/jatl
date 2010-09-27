package com.googlecode.jatl;


import static org.junit.Assert.assertEquals;

import java.io.StringWriter;

import org.junit.Test;

public class HtmlWriterTest {

	StringWriter sw = new StringWriter();
	StringWriter writer = sw;
	HtmlWriter hw;
	
	@Test
	public void testWriter() throws Exception {
		hw = new HtmlWriter() {
			@Override
			protected void build() {
				html().head().end().body();
				text("Hello");
				done();
			}
		};
		String actual = hw.write(sw).getBuffer().toString();
		String expected = "\n" + 
				"<html>\n" + 
				"	<head>\n" + 
				"	</head>\n" + 
				"	<body>Hello\n" + 
				"	</body>\n" + 
				"</html>";
		assertEquals(expected, actual);
		
	}
}
