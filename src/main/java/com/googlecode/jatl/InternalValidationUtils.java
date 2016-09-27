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

class InternalValidationUtils {
	public static boolean isBlank(
			String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}
	public static void isTrue(boolean b, String message) {
		if (!b) throw new IllegalArgumentException(message);
	}
	public static void notEmpty(
			String string,
			String message) {
		if (string == null || string.length() == 0) {
			throw new IllegalArgumentException(message);
		}
	}
	public static void notNull(Object o, String message) {
		if (o == null) throw new IllegalArgumentException(message);
	}
}
