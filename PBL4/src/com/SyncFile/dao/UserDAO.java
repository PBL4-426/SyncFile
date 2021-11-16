package com.SyncFile.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.SyncFile.model.User;

public class UserDAO {

	public static List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		String query = "select * from `users`";
		try {
			PreparedStatement ps = DBHelper.getConnection().prepareStatement(query);
			ResultSet rs = DBHelper.getRecords(ps);
			while (rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (Exception e) {
			DBHelper.closeConnection();
			return null;
		}
		return users;
	}
	public static User getUser(String email, String passWord) {
		String query = "select * from `users` where `email` = ? and `password` = ?";
		try {
			PreparedStatement ps = DBHelper.getConnection().prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, passWord);
			ResultSet rs = DBHelper.getRecords(ps);
			if (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (Exception e) {
			DBHelper.closeConnection();
			e.printStackTrace();
		}
		return null;
	}
}
