/**
 * Copyright (C) 2010 the original author or authors.
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

import java.io.Writer;

/**
 * Writes HTML using an {@link HtmlBuilder}
 * by calling {@link #write(Writer)}.
 * <p>
 * <strong>Example:</strong><p>
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
		done();
		return writer;
	}
	
	/**
	 * Should build the markup and is called by {@link #write(Writer)}.
	 * @see MarkupBuilder
	 */
	protected abstract void build();
	
}
