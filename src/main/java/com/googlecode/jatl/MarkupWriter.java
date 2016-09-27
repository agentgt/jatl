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

import java.io.Writer;

/**
 * 
 * Wrap builders for deferred writing.
 * <p>
 * This is useful when you want to define the markup but do not
 * have the {@link Writer} yet. 
 * </p> Often this is the case when:
 * <ul>
 * <li>MVC framework (such as Spring MVC) where the writer is not available
 * till rendering time. </li>
 * <li>Composition of builders.</li>
 * </ul>
 * <p>
 * You can achieve <strong>functional composition</strong> of markup builders by creating methods that return {@link MarkupWriter}s.
 * </p>
 * <pre>
	private static HtmlWriter createInput(final String name, final String value) {
		return new HtmlWriter() {
			protected void build() {
				input().name(name).value(value).end();
			}
		};
	}
	
	private static HtmlWriter createForm(final HtmlWriter ... inputs) {
		return new HtmlWriter() {
			protected void build() {
				form().write(inputs).end();
			}
		};
	}
 * </pre>
 * <em>Notice that the above methods are static as they are used as functions and do not mutate their containing class.</em>
 * <p>
 * See {@link MarkupBuilder#write(MarkupWriter...)}
 * </p>
 * @author agent
 * @see HtmlWriter
 * @see MarkupBuilder#write(MarkupWriter...)
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
