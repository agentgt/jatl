package com.googlecode.jatl;

import java.io.Writer;

/**
 * Writes using HTML using an {@link HtmlBuilder}.
 * 
 * @author agent
 *
 */
public abstract class HtmlWriter extends HtmlBuilder<HtmlWriter> implements MarkupWriter {

	public HtmlWriter() {
		super();
	}

	@Override
	protected HtmlWriter getSelf() {
		return this;
	}
	
	public <W extends Writer> W write(W writer) {
		setWriter(writer);
		build();
		return writer;
	}
	
	protected abstract void build();
	
}
