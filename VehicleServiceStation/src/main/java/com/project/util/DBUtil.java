package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost:3306/vehicles_db";
	private static String USERNAME="root";
	private static String PASSWORD="root";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
			return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
}
