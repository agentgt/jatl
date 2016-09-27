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

import java.util.Map;

class InternalStrSubstitutor {

	private Map<String, ?> map;

	public InternalStrSubstitutor(Map<String, ?> map) {
	        this.map = map;
	    }

	public String replace(
			String str) {
		if (str == null) return null;
		StringBuilder sb = new StringBuilder();
		char[] strArray = str.toCharArray();
		int i = 0;
		while (i < strArray.length - 1) {
			if (strArray.length > 2 && strArray[i] == '$' && strArray[i + 1] == '$') {
				sb.append(strArray[i]);
				i+=2;
			}
			else if (strArray.length > 2 && strArray[i] == '$' && strArray[i + 1] == '{') {
				final int o = i;
				i = i + 2;
				int begin = i;
				while (i < strArray.length && (strArray[i] != '}')) {
					++i;
				}
				if (i >= strArray.length) {
					sb.append(str.substring(o,strArray.length));
					break;
				}
				String key  = str.substring(begin, i++);
				final Object value;
				if (key.contains(":-")) {
					String[] s = key.split(":-");
					key = s[0];
					if (map.containsKey(key)) {
						value = map.get(key);
					}
					else {
						value = s[1];
					}
				}
				else {
					value = map.get(key);	
				}
				final boolean hasKey = map.containsKey(key);
				
				if (value != null) {
					sb.append(toString(value));	
				}
				else if (value == null && hasKey) {
					sb.append("${}");
				}
				else {
					sb.append("${").append(key).append("}");
				}
				
			}
			else {
				sb.append(strArray[i]);
				++i;
			}
		}
		if (i < strArray.length)
			sb.append(strArray[i]);
		return sb.toString();
	}

	private static String toString(Object o) {
		return o.toString();
	}

}
