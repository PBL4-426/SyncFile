package com.SyncFile.model;

import java.io.Serializable;

public class Profile implements Serializable {
	private int ID;
	private String nameProfile;
	private String Email;
	private String RemotePath;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNameProfile() {
		return nameProfile;
	}

	public void setNameProfile(String nameProfile) {
		this.nameProfile = nameProfile;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getRemotePath() {
		return RemotePath;
	}

	public void setRemotePath(String remotePath) {
		RemotePath = remotePath;
	}

	public Profile(int iD, String nameProfile, String email, String remotePath) {
		super();
		ID = iD;
		this.nameProfile = nameProfile;
		Email = email;
		RemotePath = remotePath;
	}

}
