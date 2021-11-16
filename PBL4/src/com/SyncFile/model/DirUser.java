package com.SyncFile.model;

import java.io.Serializable;

public class DirUser implements Serializable {
	
	private int directory_user_id;
	private int user_id;
	private int directory_id;

	public DirUser(int directory_user_id, int user_id, int directory_id) {
		super();
		this.directory_user_id = directory_user_id;
		this.user_id = user_id;
		this.directory_id = directory_id;
	}

	public int getDirectory_user_id() {
		return directory_user_id;
	}

	public void setDirectory_user_id(int directory_user_id) {
		this.directory_user_id = directory_user_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getDirectory_id() {
		return directory_id;
	}

	public void setDirectory_id(int directory_id) {
		this.directory_id = directory_id;
	}

}
