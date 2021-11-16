package com.SyncFile.controller;

import java.util.List;

import com.SyncFile.dao.UserDAO;
import com.SyncFile.model.User;

public class UserController {
	public static List<User> getAllUsers() {
		return UserDAO.getAllUsers();
	}

	public static User getUser(String email, String passWord) {
		return UserDAO.getUser(email, passWord);
	}

	public static boolean checkLogin(String email, String passWord) {
		if (UserDAO.getUser(email, passWord) != null)
			return true;
		return false;
	}

	public static void main(String[] args) {
		String email = "phat@gmail.com";
		String passWord = "123456";
		try {
			if (checkLogin(email, passWord)) {
				System.out.println(getUser(email, passWord).toString());
			} else {
				System.out.println("None");
			}
		} catch (Exception e) {

		}

	}
}
