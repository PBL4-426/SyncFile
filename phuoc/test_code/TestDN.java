import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDN {
	private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";
    private static final String HOST = "localhost";
    private static final String DATABASE = "dong_bo_du_lieu";
    private static final String PORT = "3306";
    static Scanner scanner = new Scanner(System.in);
    
    private static final String SELECT_USER_BY_USER = "SELECT email,pass FROM users WHERE email = ? AND pass = ?";

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
		new TestDN();
  	}
    
    public TestDN() {
    	List<User> users = new ArrayList<>();
    	System.out.println("Nhap username: ");
    	String user_name = scanner.nextLine();
    	System.out.println("Nhap password: ");
    	String pass_word = scanner.nextLine();
    	Connection con;
		try {
			con = getConnection();
			PreparedStatement statement;
			statement = con.prepareStatement(SELECT_USER_BY_USER);
			statement.setString(1, user_name);
			statement.setString(2, pass_word);

			ResultSet set = statement.executeQuery();
//			while (set.next()) {
//                String email = set.getString("email");
//                String pass = set.getString("pass");
//                users.add(new User(email, pass));
//                System.out.println("Dang nhap thanh cong");
//            }
			if(set.next()) {
				System.out.println("Dang nhap thanh cong");
			} else {
				System.out.println("Dang nhap that bai");
			}
//			for (User user : users) {
//	            System.out.println(user.toString());
//	        }
			
			statement.close();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
