package com.googlecode.jatl;

import java.io.Writer;

/**
 * 
 * Wrap builders for deferred writing.
 * 
 * @author agent
 * @see HtmlWriter
 */
public interface MarkupWriter {
	/**
	 * Writes using the given writer. 
	 * The writer should not be closed and will not be closed by implementations.
	 * Its up to the caller to close the writer.
	 * @param <W> writer type.
	 * @param writer not null.
	 * @return the writer used for fluent style.
	 */
	public <W extends Writer> W  write(W writer);
}
