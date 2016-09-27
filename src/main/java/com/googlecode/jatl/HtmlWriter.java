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

import java.io.StringWriter;
import java.io.Writer;

/**
 * Writes HTML using an {@link HtmlBuilder}
 * by calling {@link #write(Writer)}.
 * <p>
 * <strong>Example:</strong>
 * </p>
 * <pre>
	html = new HtmlWriter() {
		protected void build() {
			html().head().end().body();
			text("Hello");
			done();
		}
	};
	//Now write.
	String actual = html.write(writer).getBuffer().toString();
 * </pre>
 * @author agent
 * @see MarkupWriter
 *
 */
public abstract class HtmlWriter extends HtmlBuilder<HtmlWriter> implements MarkupBuilderWriter {

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
	 * Uses a StringWriter to write the HTML created in {@link #build()}. 
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return write(new StringWriter()).getBuffer().toString();
	}
	
	/**
	 * Should build the markup and is called by {@link #write(Writer)}.
	 * This method should describe the markup that should be built and is the entry point to the JATL DSL.
	 * If you are making your own custom {@link HtmlWriter} do not override this method
	 * as it is the method used by anonymous classes to describe the markup.
	 * @see MarkupBuilder
	 */
	protected abstract void build();
	
}
