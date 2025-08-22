package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
		public static Connection con;
		private static String user="root";
		private static String password="pass123";
		private static String url="jdbc:mysql://localhost:3306/food";
		

public static Connection getConnection() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, password);
        System.out.println("✅ DB Connection established");
    } catch (ClassNotFoundException e) {
        System.out.println("❌ JDBC Driver not found");
        e.printStackTrace();
    } catch (SQLException e) {
        System.out.println("❌ SQL Exception while connecting to DB");
        e.printStackTrace();
    }
    return con;
}
}
