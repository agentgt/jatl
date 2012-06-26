package com.googlecode.jatl;

import java.io.StringWriter;
import java.io.Writer;


public abstract class XmlBuilderWriter<T> extends MarkupBuilder<T> implements MarkupBuilderWriter {

	public XmlBuilderWriter() {
		super();
	}
	
	public <W extends Writer> W write(W writer) {
		setWriter(writer);
		build();
		done();
		return writer;
	}
	
	public <W extends Writer> W write(W writer, int depth) {
		setWriter(writer);
		setDepth(depth);
		build();
		done();
		return writer;
	}
	
	/**
	 * Uses a StringWriter to write the XML created in {@link #build()}. 
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return write(new StringWriter()).getBuffer().toString();
	}
	
	/**
	 * Should build the markup and is called by {@link #write(Writer)}.
	 * @see MarkupBuilder
	 */
	protected abstract void build();

}
