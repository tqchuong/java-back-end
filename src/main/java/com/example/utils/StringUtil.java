package com.example.utils;

public class StringUtil {
	public static boolean checkString(String data) {
		if (data != null && !data.equals("")) {
			return true;
		} else
			return false;
	}

}
