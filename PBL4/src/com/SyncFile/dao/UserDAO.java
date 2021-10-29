package com.SyncFile.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.SyncFile.model.User;

public class UserDAO {
	// Gọi DBHelper
	// Hàm thêm, sửa, xóa
	// Singleton
	public UserDAO() {
		
	}
	
	public List<User> getAllUsers() throws ClassNotFoundException, SQLException{
		List<User> users = new ArrayList<User>();
		DBHelper.getConnection();
		String query = "";
		ResultSet rs = DBHelper.getRecords(query);
		while(rs.next()) {
			// code
		}
		return users;
	}
}
