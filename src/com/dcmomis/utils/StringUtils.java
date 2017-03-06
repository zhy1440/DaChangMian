package com.dcmomis.utils;

import net.sf.json.JSONArray;

public class StringUtils {
	public static String listToJson(String root, Object obj) {
		String strJson = null;
		JSONArray jsonArray = JSONArray.fromObject(obj);
		strJson = "{" + root + ":" + jsonArray.toString() + "}";
		return strJson;
	}

	public static String listToJson(Object obj, boolean needBrackets) {
		String strJson = null;
		JSONArray jsonArray = JSONArray.fromObject(obj);
		strJson = jsonArray.toString();
		if (needBrackets) {
			return strJson;
		} else {
			return strJson.substring(1, strJson.length() - 1);
		}
	}

	public static String listToJson(Object obj) {
		String strJson = null;
		JSONArray jsonArray = JSONArray.fromObject(obj);
		strJson = jsonArray.toString();
		return strJson;
	}
}
