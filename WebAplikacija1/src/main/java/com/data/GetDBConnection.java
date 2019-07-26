package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class GetDBConnection {
	public Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/WebAppValute?serverTimezone=" + TimeZone.getDefault().getID();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, "root", "password");
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}
