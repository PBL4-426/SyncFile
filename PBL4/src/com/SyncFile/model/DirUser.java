package com.SyncFile.model;

import java.io.Serializable;

public class DirUser implements Serializable{
	private String Email;
	private String DirectoryID;

	public DirUser(String email, String directoryID) {
		super();
		Email = email;
		DirectoryID = directoryID;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDirectoryID() {
		return DirectoryID;
	}

	public void setDirectoryID(String directoryID) {
		DirectoryID = directoryID;
	}
}
