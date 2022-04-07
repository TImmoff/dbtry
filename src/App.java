import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/chat", "postgres", "vodolaz9");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM messages");
            while (rs.next()) {
                System.out.println(rs.getLong(1) + ":" + rs.getString(2));
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("e:" + e.getMessage());
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }
    }
}
