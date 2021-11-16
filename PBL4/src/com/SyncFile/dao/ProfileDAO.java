package com.SyncFile.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.SyncFile.model.Profile;

public class ProfileDAO {

	public static List<Profile> getAllProfiles() { // server
		List<Profile> profiles = new ArrayList<Profile>();
		String query = "select * from `profile`";
		try {
			PreparedStatement ps = DBHelper.getConnection().prepareStatement(query);
			ResultSet rs = DBHelper.getRecords(ps);
			while (rs.next()) {
				profiles.add(new Profile(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getTimestamp(8), rs.getTimestamp(9)));
			}
		} catch (Exception e) {
			return null;
		}
		return profiles;
	}

	public static List<Profile> getAllProfile(String email) { // client
		List<Profile> profiles = new ArrayList<Profile>();
		String query = "select profile_id, profile.user_id, proflie_name, remote_path_server, remote_path_client, directory_user_id, schedule_int  from profile\r\n"
				+ " inner join users on users.user_id = profile.user_id where email = 'phat@gmail.com'";
		try {
			PreparedStatement ps = DBHelper.getConnection().prepareStatement(query);
			ResultSet rs = DBHelper.getRecords(ps);
			while (rs.next()) {
				profiles.add(new Profile(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getTimestamp(8), rs.getTimestamp(9)));
			}
		} catch (Exception e) {
			return null;
		}
		return profiles;
	}

	public static Profile getProfile(int profile_id) {
		String query = "select * from `profile` where `profile_id` = ?";
		try {
			PreparedStatement ps = DBHelper.getConnection().prepareStatement(query);
			ps.setInt(1, profile_id);
			ResultSet rs = DBHelper.getRecords(ps);
			if (rs.next()) {
				return new Profile(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getTimestamp(8), rs.getTimestamp(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
