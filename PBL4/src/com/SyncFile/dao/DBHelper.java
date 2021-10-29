package com.SyncFile.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	// Mô hình Singleton
	// Hàm giống C#
	public DBHelper() {
		
	}
	private static Connection cnn = null;
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if(cnn == null) {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String cnnString = "jdbc:sqlserver://LAPTOP-9Q4S4J6D;databaseName=Java;integratedSecurity=true;";
			cnn  = DriverManager.getConnection(cnnString);
		}
		return cnn;
	}
	
	public static void closeConnection() throws SQLException {
		if(cnn != null) {
			cnn.close();
		}
	}

	public static ResultSet getRecords(String query) throws SQLException {
		Statement state = cnn.createStatement(); 
		ResultSet res = state.executeQuery(query);
		return res;	
	}
	public static void Excute(String query) throws SQLException {
		PreparedStatement preparedStatement = cnn.prepareStatement(query);
		preparedStatement.execute();
	}
}