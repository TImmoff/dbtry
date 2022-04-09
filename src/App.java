
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Properties;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner ott = new Scanner(System.in);
        String usname, mes;
        usname = ott.nextLine();
        mes = ott.nextLine();
        ott.close();
        Chat chat = new Chat();
        chat.showAll();
        chat.say(usname, mes);
        chat.showAll();
        chat.closeConn();

    }
}
