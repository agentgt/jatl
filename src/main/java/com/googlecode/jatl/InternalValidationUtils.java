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
