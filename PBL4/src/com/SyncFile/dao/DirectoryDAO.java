package com.SyncFile.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.SyncFile.model.Directory;

public class DirectoryDAO {

	public static List<Directory> getAllDirectory() { // server
		List<Directory> directories = new ArrayList<Directory>();
		String query = "select * from `directory`";
		try {
			PreparedStatement ps = DBHelper.getConnection().prepareStatement(query);
			ResultSet rs = DBHelper.getRecords(ps);
			while (rs.next()) {
				directories.add(new Directory(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
			}
		} catch (Exception e) {
			DBHelper.closeConnection();
			return null;
		}
		return directories;
	}

	public static List<Directory> getAllDirectory(String email) { // client
		List<Directory> directories = new ArrayList<Directory>();
		String query = "select * from `profile` where ";
		//
		try {
			PreparedStatement ps = DBHelper.getConnection().prepareStatement(query);
			ResultSet rs = DBHelper.getRecords(ps);
			while (rs.next()) {
				directories.add(new Directory(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
			}
		} catch (Exception e) {
			DBHelper.closeConnection();
			return null;
		}
		return directories;
	}
}
