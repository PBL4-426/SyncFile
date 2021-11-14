
public class User {
	private int user_id;
	private String email;
	private String pass;
	private String user_roll;
	
	public User() {
	}

	public User(int user_id, String email, String pass, String user_roll) {
		this.user_id = user_id;
		this.email = email;
		this.pass = pass;
		this.user_roll = user_roll;
	}
	

	public User(String email, String pass, String user_roll) {
		super();
		this.email = email;
		this.pass = pass;
		this.user_roll = user_roll;
	}
	

	public User(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUser_roll() {
		return user_roll;
	}

	public void setUser_roll(String user_roll) {
		this.user_roll = user_roll;
	}

	@Override
	public String toString() {
		return user_id + ", " + email + ", " + pass + ", " + user_roll;
	}
	
	
}
