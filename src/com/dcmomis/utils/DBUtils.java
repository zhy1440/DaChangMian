package com.dcmomis.utils;

import java.sql.*;

public class DBUtils {
	static String CLASSFORNAME = "com.mysql.jdbc.Driver";
	static String SERVANDDB = "jdbc:mysql://localhost:3306/dcmoms?characterEncoding=utf-8";
	static String USER = "dcm";
	static String PWD = "dcm";

	public static Connection getDBConnection() {
		Connection con = null;
		try {
			Class.forName(CLASSFORNAME);// 动态加载mysql驱动
			// 一个Connection代表一个数据库连接
			con = DriverManager.getConnection(SERVANDDB, USER, PWD);
			//System.out.println("成功getConnection");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void release(Statement pstm, ResultSet rs, Connection conn) {
		if (pstm != null)
			try {
				if(!pstm.isClosed())
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		if (rs != null)
			try {
				if (!rs.isClosed())
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		if (conn != null)
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
				//System.out.println("成功release Connection");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
