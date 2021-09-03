import db.DB;
import db.DBExceptions;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DB.getConn();
            st = conn.createStatement();
            rs =  st.executeQuery("select * from department");
            while (rs.next()){
                System.out.println(rs.getInt("Id") + " "+rs.getString("Name"));
            }
        } catch (SQLException throwables) {
            new DBExceptions(throwables.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            DB.CloseConnection();
        }

    }
}
