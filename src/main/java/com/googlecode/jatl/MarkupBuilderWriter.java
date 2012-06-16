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
 * The methods in this class will be merged with {@link MarkupWriter} in 0.3.0.
 * <p>
 * Thus this interface will be deprecated in the next release.
 * @author agent
 * @since 0.2.2
 *
 */
public interface MarkupBuilderWriter extends MarkupWriter {
	/**
	 * Writes using the given writer at the given depth.
	 * The writer should not be closed and will not be closed by implementations.
	 * Its up to the caller to close the writer.
	 * @param <W> writer type.
	 * @param depth the indent depth to start at.
	 * @param writer not null.
	 * @return the writer used for fluent style.
	 * @since 0.2.2
	 * @see MarkupBuilder#write(MarkupWriter...)
	 */
	public <W extends Writer> W  write(W writer, int depth);
}
