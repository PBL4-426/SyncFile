package com.SyncFile.model;

import java.io.Serializable;

public class User implements Serializable {
	private int user_id;
	private String email;
	private String password;
	private String user_roll;

	public User(int user_id, String email, String password, String user_roll) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.password = password;
		this.user_roll = user_roll;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_roll() {
		return user_roll;
	}

	public void setUser_roll(String user_roll) {
		this.user_roll = user_roll;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", user_roll=" + user_roll + "]";
	}

}
