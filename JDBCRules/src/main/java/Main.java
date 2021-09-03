import db.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection conn = DB.getConn();
        DB.CloseConnection();
    }
}
