package com.googlecode.jatl;

import java.io.StringWriter;
import java.io.Writer;

/**
 * For generic XML creation subclass this class for a custom XML writer or use {@link XmlWriter}.
 * When subclassing make the child class <code>abstract</code> and do not implement {@link #build()}. 
 * The {@link #toString()} on this class will do what you expect: generate the XML as a string.
 * @author agent
 *
 * @param <T> generally itself for fluent style
 */
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
	 * This method should describe the markup that should be built and is the entry point to the JATL DSL.
	 * If you are making your own custom {@link XmlWriter} do not override this method
	 * as it is the method used by anonymous classes to describe the markup.
	 * @see MarkupBuilder
	 */
	protected abstract void build();

}
