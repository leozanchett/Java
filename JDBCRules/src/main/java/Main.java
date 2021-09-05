import db.DB;
import db.DBExceptions;
import db.DBIntegrityException;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection conn = DB.getConn();

        //InsertValues(conn);
        //ConsultarDados(conn);
        DeletarDados(conn);
    }

    private static void DeletarDados(Connection conn){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(
                    "DELETE FROM department "+
                        "where " +
                        "Id = ?");
            ps.setInt(1, 2);
            int rowsaffected = ps.executeUpdate();
            System.out.println("Rows afected "+ rowsaffected);
        } catch (SQLException e) {
            throw new DBIntegrityException(e.getMessage());
        }


    }

    private static void InsertValues(Connection conn){
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        PreparedStatement ps = null;
        try {
            /*ps = conn.prepareStatement(
                    "INSERT INTO seller " +
                        "(Name, Email, BirthDate, BaseSalary, DepartmentId) "+
                        "values "+
                        "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "The Sellersperson");
            ps.setString(2, "seller@gmail.com");
            ps.setDate(3, new java.sql.Date(sdf.parse("22/04/1865").getTime()));
            ps.setDouble(4, 3000.00);
            ps.setInt(5, 4);*/

            ps = conn.prepareStatement("INSERT INTO department (Name) values ('D1'), ('D2')", Statement.RETURN_GENERATED_KEYS); // insere dois registros.

            int rowsAffected =  ps.executeUpdate();

            if(rowsAffected > 0){
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()){
                    System.out.println("Done Id = "+rs.getInt(1));
                }
            }else {
                System.out.println("No rows affected");
            }
        } catch (SQLException e) {
            throw new DBExceptions(e.getMessage());
        /*}catch (ParseException e){
            throw new DBExceptions(e.getMessage());*/
        }finally {
            DB.closePrepareStatement(ps);
            DB.CloseConnection();
        }
    }

    private static void ConsultarDados(Connection conn) {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs =  st.executeQuery("select * from department");
            while (rs.next()){
                System.out.println(rs.getInt("Id") + " "+ rs.getString("Name"));
            }
        } catch (SQLException e) {
            throw new DBExceptions(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            DB.CloseConnection();
        }
    }
}
