
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Chat {
    Connection con = null;
    Statement stmt = null;

    public Chat() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/chat", "postgres", "vodolaz9");
            stmt = con.createStatement();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void say(String userName, String text) {
        try {
            ResultSet rs = stmt
                    .executeQuery("INSERT INTO messages( mess) VALUES ( \'" + userName + ":" + text + "\')");
        } catch (SQLException e) {
            System.out.println("e:" + e.getMessage());
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }
    }

    public void showAll() {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM messages");
            while (rs.next()) {

                System.out.println(rs.getMetaData().getColumnName(2) + "[" + rs.getString(1) + "]:"
                        + rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("e:" + e.getMessage());
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }
    }

    public void closeConn() throws SQLException {
        stmt.close();
        con.close();
    }
}
