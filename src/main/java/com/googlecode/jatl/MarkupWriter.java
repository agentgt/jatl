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
 * 
 * Wrap builders for deferred writing.
 * <p>
 * This is useful when you want to define the markup but do not
 * have the {@link Writer} yet. This is often the case with
 * Spring MVC or any MVC framework where the writer is not available
 * till rendering time.
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
