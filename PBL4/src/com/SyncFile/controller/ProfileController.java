package com.SyncFile.controller;

public class ProfileController {
	// Gọi ProfileDAO
	// Hàm thêm, sửa, xóa
	// Singleton
	public void createProfile(String s) {
		System.out.println("createProfile");
	}

	public void checkProfile(String s) {
		System.out.println("checkProfile");
	}

	public void listProfile(String s) {
		System.out.println("listProfile");
	}

	public void deleteProfile(String s) {
		System.out.println("deleteProfile");
	}

	public void startProfile(String s) {
		// name 
		// ngay gio => chen vao Date
		// bat dau dong bo
		String src = "Client";
		String dest = "Server";
		
		System.out.println("startProfile");
	}

}
