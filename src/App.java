import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Properties;

public class App {

    public static void main(String[] args) throws Exception {
        Chat chat = new Chat();
        chat.showAll();
        chat.say("pirogok", "hello");
        chat.showAll();
        chat.closeConn();
    }
}
