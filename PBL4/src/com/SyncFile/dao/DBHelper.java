package com.SyncFile.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {

	private static Connection cnn = null;

	public static Connection getConnection() {
		if (cnn == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dong_bo_du_lieu", "root", "kikikenZ123");
			} catch (Exception e) {

			}
		}
		return cnn;
	}

	public static void closeConnection() {
		if (cnn != null) {
			try {
				cnn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static ResultSet getRecords(PreparedStatement preparedStatement) throws SQLException {
		ResultSet res = preparedStatement.executeQuery();
		return res;
	}

	public static void excute(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.execute();
	}
}
