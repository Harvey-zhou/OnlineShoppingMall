package Database;

import java.sql.*;

public class DBConnect {
    Connection conn = null;
    PreparedStatement ps = null;
    Statement stmt=null;
    ResultSet rs = null;

    public DBConnect(){
        try{
            //Register jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //mysql database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineShopping_system?serverTimezone=UTC" ,"root","1234");
            //execute query search
            stmt=conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //connection status test
    public Connection getConnection() {
        return conn;
    }

    //precompile and execute sql statement
    public PreparedStatement getPS(String sql) throws SQLException {
        ps=conn.prepareStatement(sql);

        // conn.commit();
        return ps;
    }

    //search query in database
    public ResultSet executeQuery(String sql) {
        try {
            rs=stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            System.out.println("DBConnect.executeQuery()ERROR:"+e.getMessage());
        }
        return rs;
    }

    //execute sql statement
    public int executeUpdate(String sql) {
        int i = 0;
        try {
            i=stmt.executeUpdate(sql);
            return i;
        } catch (SQLException e) {
            System.out.println("DBConnect.executeUpdate()ERROR:"+e.getMessage());
        }
        return i;
    }


    //disconnect
    public void free() {

        try {
            if(rs!=null) rs.close();
            if(stmt!=null)stmt.close();
            if(conn!=null)conn.close();
        } catch (SQLException e) {
            System.out.println("DBConnect.free():ERROR"+e.getMessage());
        }
    }
}
