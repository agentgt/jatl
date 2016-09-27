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
