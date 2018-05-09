import java.sql.*;

public class Database {

private Connection con;

    public Connection getCon() {
        return con;
    }

    public void connectie() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://localhost/testkbs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC\n", "root", "");

        Statement st = con.createStatement();
        String sql = ("SELECT * FROM sorteerproces ORDER BY sorteerprocesID DESC LIMIT 1;");
        System.out.println("Connectie met database is gemaakt.");




    }

    public void connectieSluiten() throws SQLException {
        con.close();
        if (con.isClosed() == true){
            System.out.println("Database connectie, is gesloten");
        }
    }
}