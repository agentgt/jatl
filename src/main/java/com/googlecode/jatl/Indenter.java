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

import java.io.IOException;

import com.googlecode.jatl.MarkupBuilder.TagClosingPolicy;

/**
 * A strategy to indent or in other words pretty print
 * the markup.
 * <p>
 * <b>EXPERIMENTAL MAY CHANGE</b>
 * @author agent
 * @see MarkupBuilder#indent(Indenter)
 * @since 0.2.0
 */
public interface Indenter {
	
	/**
	 * Called by the builder to provide whitespace decoration.
	 * The arguments provides context of what tag, kind of tag and closing policy etc.
	 * <p>
	 * <b>EXPERIMENTAL MAY CHANGE</b>
	 * @param a writer like object where indenting decoration is to be applied.
	 * @param innerDepth current indent depth inside the current builder.
	 * @param outerDepth starting depth based on the outside builder if there is one. Usually this is zero.
	 * @param spot current position that white space is to be applied.
	 * @param tag the tag to be indented, not <code>null</code>.
	 * @param p closing policy for the tag to be indented.
	 * @param empty if the tag is empty.
	 * @see MarkupBuilder#indent(Indenter)
	 * @throws IOException pass through from orginal writer. 
	 */
	public void indentTag(
			Appendable a,
			int innerDepth, 
			int outerDepth, 
			TagIndentSpot spot, 
			String tag, TagClosingPolicy p, boolean empty) throws IOException;
	
	/**
	 * Indicates the current position (cursor) of where whitespace is to be applied.
	 * <p>
	 * <b>EXPERIMENTAL MAY CHANGE</b>
	 * @author agent
	 *
	 */
	public static enum TagIndentSpot {
		/**
		 * Indicates position is before &lt;tag&gt;
		 */
		BEFORE_START_TAG,
		/**
		 * Indicates position is after &lt;tag&gt;
		 */
		AFTER_START_TAG,
		/**
		 * Indicates position is before &lt;/tag&gt;
		 */
		BEFORE_END_TAG,
		/**
		 * Indicates position is after &lt;/tag&gt;
		 */
		AFTER_END_TAG
	}
}
