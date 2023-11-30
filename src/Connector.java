

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public Connection conn;

    public Connection main() {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "system";
        String password = "11062001";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Oracle database!");
            return this.conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close_conn() throws SQLException {
        this.conn.close();
    }
}
