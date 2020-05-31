package DAO;

import Database.DBConnect;

import java.sql.ResultSet;
import java.sql.SQLException;

public class merchantDAO {
    public boolean login(String username,String userpwd){
        DBConnect db = new DBConnect();
        String sqlstr = "select * from merchant where username='" + username + "' and userpwd='"+ userpwd +"'";
        ResultSet rs = db.executeQuery(sqlstr);
        try {
            if (rs != null && rs.next()) {
                return true;
            }
        } catch (SQLException ex){
            ex.getErrorCode();
        }
        return false;
    }

    //Sign up, insert account into database
    public boolean SignUp(String username, String userpwd){
        DBConnect db = new DBConnect();
        String sqlstr_select = "select username from merchant where username='" + username + "'";
        ResultSet rs = db.executeQuery(sqlstr_select);
        try{
            if (!rs.next()){
                String sqlstr_insert = "insert into merchant values('" + username + "', '" + userpwd + "')";
                db.executeUpdate(sqlstr_insert);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
