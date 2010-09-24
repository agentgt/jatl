package com.googlecode.jatl;

import java.io.Writer;

public class Html extends HtmlBuilder<Html> {

	public Html(Writer writer) {
		super(writer);
	}

	@Override
	protected Html getSelf() {
		return this;
	}

	@Override
	protected String indent(int depth, String tag) {
		StringBuffer sb = new StringBuffer(depth + 1);
		sb.append("\n");
		for (int i = 0; i < depth; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
	
	
	
}