package com.dcmomis.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DicUtils {
	public static String GetDicDescbyId(String dicValue, String dicType) {
		Connection conn = null;
		Statement stm = null;
		ResultSet result = null;
		String dicName = null;
		/*
		 * String queryString =
		 * "SELECT DIC_NAME FROM bd_dic_dcm_common WHERE  DIC_VALUE = '" +
		 * dicValue + "' AND DIC_TYPE = '" + dicType + "'";
		 */
		String queryString = "SELECT DIC_NAME FROM bd_dic_dcm_common WHERE DIC_VALUE = '" + dicValue
				+ "' AND DIC_TYPE = '" + dicType + "'";
		try {
			conn = DBUtils.getDBConnection();
			stm = conn.createStatement();
			result = stm.executeQuery(queryString);

			while (result.next()) {
				dicName = result.getString("DIC_NAME");
			}
			return dicName;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(stm, result, conn);
		}
		return null;
	}
}
