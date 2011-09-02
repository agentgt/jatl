package com.googlecode.jatl;

import java.io.IOException;

public class SimpleIndenter implements Indenter {

	private String startTagNewLine =  "\n";
	private String startTagIndent = "\t";
	private String endTagNewLine = "\n";
	private String endTagIndent = "\t";
	
	public SimpleIndenter(String startTagNewLine, String startTagIndent, String endTagNewLine, String endTagIndent) {
		super();
		this.startTagNewLine = startTagNewLine;
		this.startTagIndent = startTagIndent;
		this.endTagNewLine = endTagNewLine;
		this.endTagIndent = endTagIndent;
	}

	public void indentTag(Appendable a, int innerDepth, int outerDepth, TagIndentSpot spot, String tag,
			MarkupBuilder.TagClosingPolicy p, boolean empty) throws IOException {
		int depth = innerDepth + outerDepth;
		if (spot == TagIndentSpot.BEFORE_START_TAG ) {
			if (startTagNewLine != null)
				a.append(startTagNewLine);
			if (startTagIndent != null) {
				for (int i = 0; i < depth; i++) {
					a.append(startTagIndent);
				}
			}
		}
		if (spot == TagIndentSpot.BEFORE_END_TAG ) {
			if (endTagNewLine != null)
				a.append(endTagNewLine);
			if (endTagIndent != null) {
				for (int i = 0; i < depth; i++) {
					a.append(endTagIndent);
				}
			}
		}			
	}

}