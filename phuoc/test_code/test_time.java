import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class test_time {
	private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";
    private static final String HOST = "localhost";
    private static final String DATABASE = "dong_bo_du_lieu";
    private static final String PORT = "3306";
    
    private static final String SELECT_USER_BY_SCHEDULE = "SELECT `profile`.`proflie_name`, `schedule`.start_time, `schedule`.end_time FROM `profile` inner join `schedule` on `schedule`.schedule_int = `profile`.schedule_int;";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager. getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
		new test_time();
	}
    
    public test_time() {
    	List<Profile> profiles = new ArrayList<>();
    	Connection con;
		try {
			con = getConnection();
			PreparedStatement statement;
			statement = con.prepareStatement(SELECT_USER_BY_SCHEDULE);

			ResultSet set = statement.executeQuery();
			while (set.next()) {
                String proflie_name = set.getString("proflie_name");
                Timestamp  start_time = set.getTimestamp("start_time");
                Timestamp  end_time = set.getTimestamp("end_time");
                profiles.add(new Profile(proflie_name, start_time, end_time));
                int second = start_time.getHours() + 1;
                System.out.println(second);
            }
			
			for (Profile profile : profiles) {
	            System.out.println(profile.toString());
	        }
			//cong them giay
			statement.close();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
