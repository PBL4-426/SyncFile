package com.SyncFile.model;

import java.io.Serializable;

public class Directory implements Serializable {

	private int directory_id;
	private String directory_path;
	private String folder_name;
	private boolean check_action;

	public Directory(int directory_id, String directory_path, String folder_name, boolean check_action) {
		super();
		this.directory_id = directory_id;
		this.directory_path = directory_path;
		this.folder_name = folder_name;
		this.check_action = check_action;
	}

	public int getDirectory_id() {
		return directory_id;
	}

	public void setDirectory_id(int directory_id) {
		this.directory_id = directory_id;
	}

	public String getDirectory_path() {
		return directory_path;
	}

	public void setDirectory_path(String directory_path) {
		this.directory_path = directory_path;
	}

	public String getFolder_name() {
		return folder_name;
	}

	public void setFolder_name(String folder_name) {
		this.folder_name = folder_name;
	}

	public boolean isCheck_action() {
		return check_action;
	}

	public void setCheck_action(boolean check_action) {
		this.check_action = check_action;
	}

}
