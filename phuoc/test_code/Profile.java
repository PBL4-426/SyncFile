import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Profile {
	private int profile_id;
	private int user_id;
	private String proflie_name;
	private String remote_path_server;
	private String remote_path_client;
	private int directory_user_id;
	private int schedule_int;
	private Timestamp start_time;
	private Timestamp end_time;
	
	public Timestamp  getStart_time() {
		return start_time;
	}

	public void setStart_time(Timestamp  start_time) {
		this.start_time = start_time;
	}

	public Timestamp  getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}

	public Profile() {
		super();
	}

	public Profile(int profile_id, int user_id, String proflie_name, String remote_path_server,
			String remote_path_client, int directory_user_id, int schedule_int) {
		super();
		this.profile_id = profile_id;
		this.user_id = user_id;
		this.proflie_name = proflie_name;
		this.remote_path_server = remote_path_server;
		this.remote_path_client = remote_path_client;
		this.directory_user_id = directory_user_id;
		this.schedule_int = schedule_int;
	}
	

	public Profile(int profile_id, int user_id, String proflie_name, String remote_path_server,
			String remote_path_client, int directory_user_id, int schedule_int, Timestamp  start_time,
			Timestamp  end_time) {
		super();
		this.profile_id = profile_id;
		this.user_id = user_id;
		this.proflie_name = proflie_name;
		this.remote_path_server = remote_path_server;
		this.remote_path_client = remote_path_client;
		this.directory_user_id = directory_user_id;
		this.schedule_int = schedule_int;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	
	

	public Profile(String proflie_name, Timestamp start_time, Timestamp end_time) {
		super();
		this.proflie_name = proflie_name;
		this.start_time = start_time;
		this.end_time = end_time;
	}

	public int getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getProflie_name() {
		return proflie_name;
	}

	public void setProflie_name(String proflie_name) {
		this.proflie_name = proflie_name;
	}

	public String getRemote_path_server() {
		return remote_path_server;
	}

	public void setRemote_path_server(String remote_path_server) {
		this.remote_path_server = remote_path_server;
	}

	public String getRemote_path_client() {
		return remote_path_client;
	}

	public void setRemote_path_client(String remote_path_client) {
		this.remote_path_client = remote_path_client;
	}

	public int getDirectory_user_id() {
		return directory_user_id;
	}

	public void setDirectory_user_id(int directory_user_id) {
		this.directory_user_id = directory_user_id;
	}

	public int getSchedule_int() {
		return schedule_int;
	}

	public void setSchedule_int(int schedule_int) {
		this.schedule_int = schedule_int;
	}

	@Override
	public String toString() {
		return proflie_name+ ", " + start_time + ", " + end_time;
	}
	
	
}
