﻿package com.littlemylyn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	private final static String URL = "jdbc:mysql://localhost:3306/mylyn";
	private final static String USER = "root";
	private final static String PASSWORD = "123456";
	
	public DBUtil() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 得到连接
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	// 关闭结果集、语句和连接
	public void close(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) { rs.close(); }
			if (st != null) { st.close(); }
			if (conn != null) { conn.close(); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
