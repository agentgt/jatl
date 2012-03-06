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

/**
 * 
 * A simple indenter that takes a String for 
 * before and after on the opening and closing tag.
 * <p>
 * <b>EXPERIMENTAL MAY CHANGE</b>
 * 
 * @author agent
 *
 */
public class SimpleIndenter implements Indenter {

	private String startTagNewLine =  "\n";
	private String startTagIndent = "\t";
	private String endTagNewLine = "\n";
	private String endTagIndent = "\t";
	
	/**
	 * 
	 * <b>EXPERIMENTAL MAY CHANGE</b>
	 * 
	 * @param startTagNewLine null not recommended.
	 * @param startTagIndent null not recommended.
	 * @param endTagNewLine null not recommended.
	 * @param endTagIndent null not recommended.
	 */
	public SimpleIndenter(String startTagNewLine, String startTagIndent, String endTagNewLine, String endTagIndent) {
		super();
		this.startTagNewLine = startTagNewLine;
		this.startTagIndent = startTagIndent;
		this.endTagNewLine = endTagNewLine;
		this.endTagIndent = endTagIndent;
	}

	/**
	 * {@inheritDoc}
	 */
	public void indentTag(Appendable a, int innerDepth, int outerDepth, TagIndentSpot spot, String tag,
			MarkupBuilder.TagClosingPolicy p, boolean empty) throws IOException {
		int depth = innerDepth + outerDepth;
		if (spot == TagIndentSpot.BEFORE_START_TAG ) {
			if (startTagNewLine != null)
				a.append(startTagNewLine);
			if (startTagIndent != null) {
				for (int i = 0; i < depth; i++) {
					a.append(startTagIndent);
				}
			}
		}
		if (spot == TagIndentSpot.BEFORE_END_TAG ) {
			if (endTagNewLine != null)
				a.append(endTagNewLine);
			if (endTagIndent != null) {
				for (int i = 0; i < depth; i++) {
					a.append(endTagIndent);
				}
			}
		}			
	}

}