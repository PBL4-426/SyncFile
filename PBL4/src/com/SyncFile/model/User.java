package com.SyncFile.model;

import java.io.Serializable;

public class User implements Serializable {
	private String Email;
	private String passWord;

	public User(String email, String passWord) {
		super();
		Email = email;
		this.passWord = passWord;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
