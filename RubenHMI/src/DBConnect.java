import java.sql.*;

public class DBConnect {
    final String DRIVER = "com.mysql.jdbc.Driver";
    final String DB_PATH = "jdbc:mysql://localhost:3306/Skittle";
    String userName = "root";
    String password = "";
    Connection conn = null;
    Statement stmt = null;

    public DBConnect(String name, String pass) {
        userName = name;
        password = pass;
    }

    public void connect() throws SQLException, Exception {
        Class.forName(DRIVER);
        System.out.println("Connecting...");
        conn = DriverManager.getConnection(DB_PATH, userName, password);
        stmt = conn.createStatement();
    }

    public void closeConnection() throws SQLException, Exception {
        stmt.close();
        conn.close();
    }

    public Statement getStatement(){
        return stmt;
    }

    public Connection getConnection() {
        return conn;
    }
}
