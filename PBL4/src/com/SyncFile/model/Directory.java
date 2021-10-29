package com.SyncFile.model;

import java.io.Serializable;

public class Directory implements Serializable {
	private int ID;
	private String dirName;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	public Directory(int iD, String dirName) {
		super();
		ID = iD;
		this.dirName = dirName;
	}

}
