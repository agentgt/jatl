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

/**
 * XML Utils.
 * 
 * @author agent
 * 
 */
public final class MarkupUtils {

	private MarkupUtils() {
	}
	
	/**
	 * This will take the three pre-defined entities in XML 1.0 (used
	 * specifically in XML elements) and convert their character representation
	 * to the appropriate entity reference, suitable for XML element content.
	 * 
	 * @param str
	 *            <code>String</code> input to escape.
	 * @return <code>String</code> with escaped content.
	 * @author THIS CODE WAS INSPIRED FROM JDOM http://www.jdom.org/
	 */
	public static String escapeElementEntities(String str) {
		if (str == null) return null;
		StringBuffer buffer;
		char ch;
		String entity;

		buffer = null;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			switch (ch) {
				case '<':
					entity = "&lt;";
					break;
				case '>':
					entity = "&gt;";
					break;
				case '&':
					entity = "&amp;";
					break;
				case '\r':
					entity = "&#xD;";
					break;
				// case '\n' :
				// entity = currentFormat.lineSeparator;
				// break;
				default:
					entity = null;
					break;
			}
			if (buffer == null) {
				if (entity != null) {
					// An entity occurred, so we'll have to use StringBuffer
					// (allocate room for it plus a few more entities).
					buffer = new StringBuffer(str.length() + 20);
					// Copy previous skipped characters and fall through
					// to pickup current character
					buffer.append(str.substring(0, i));
					buffer.append(entity);
				}
			}
			else {
				if (entity == null) {
					buffer.append(ch);
				}
				else {
					buffer.append(entity);
				}
			}
		}

		// If there were any entities, return the escaped characters
		// that we put in the StringBuffer. Otherwise, just return
		// the unmodified input string.
		return (buffer == null) ? str : buffer.toString();
	}

	/**
	 * 
	 * This will take the pre-defined entities in XML 1.0 and convert their
	 * character representation to the appropriate entity reference, suitable
	 * for XML attributes. It does not convert the single quote (') because it's
	 * not necessary as the outputter writes attributes surrounded by
	 * double-quotes.
	 * 
	 * @param str
	 *            <code>String</code> input to escape.
	 * @return <code>String</code> with escaped content.
	 * @author THIS CODE WAS INSPIRED FROM JDOM http://www.jdom.org/
	 */
	public static String escapeAttributeEntities(String str) {
		if (str == null) return null;
		StringBuffer buffer;
		char ch;
		String entity;

		buffer = null;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			switch (ch) {
				case '<':
					entity = "&lt;";
					break;
				case '>':
					entity = "&gt;";
					break;
				case '\"':
					entity = "&quot;";
					break;
				case '&':
					entity = "&amp;";
					break;
				case '\r':
					entity = "&#xD;";
					break;
				case '\t':
					entity = "&#x9;";
					break;
				case '\n':
					entity = "&#xA;";
					break;
				default:
					entity = null;
					break;
			}
			if (buffer == null) {
				if (entity != null) {
					// An entity occurred, so we'll have to use StringBuffer
					// (allocate room for it plus a few more entities).
					buffer = new StringBuffer(str.length() + 20);
					// Copy previous skipped characters and fall through
					// to pickup current character
					buffer.append(str.substring(0, i));
					buffer.append(entity);
				}
			}
			else {
				if (entity == null) {
					buffer.append(ch);
				}
				else {
					buffer.append(entity);
				}
			}
		}

		// If there were any entities, return the escaped characters
		// that we put in the StringBuffer. Otherwise, just return
		// the unmodified input string.
		return (buffer == null) ? str : buffer.toString();
	}

}
