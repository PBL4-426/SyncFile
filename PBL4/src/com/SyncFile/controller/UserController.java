package com.SyncFile.controller;

import java.sql.SQLException;
import java.util.List;

import com.SyncFile.dao.UserDAO;
import com.SyncFile.model.User;

public class UserController {
	// Gọi UserDAO
	// Hàm thêm, sửa, xóa
	// Singleton
	UserDAO userDAO;
	
	public UserController() {
		userDAO = new UserDAO();
	}
	
	public List<User> getAllUsers() throws ClassNotFoundException, SQLException{
		return userDAO.getAllUsers();
	}
}
