package dz.delivery.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    public static Connection get_conn() {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "username";
        String password = "password";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Oracle database!");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
