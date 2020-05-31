package DAO;

import Database.DBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;

public class customerDAO {
    //login, search account in database
    public boolean login(String username,String userpwd){
        DBConnect db = new DBConnect();
        String sqlstr = "select * from customer where username='" + username + "' and userpwd='"+ userpwd +"'";
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
        String sqlstr_select = "select username from customer where username='" + username + "'";
        ResultSet rs = db.executeQuery(sqlstr_select);
        try{
            if (!rs.next()){
                String sqlstr_insert = "insert into customer values('" + username + "', '" + userpwd + "')";
                db.executeUpdate(sqlstr_insert);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //select all customer
    public ResultSet SelectAllCustomer(){
        try{
            DBConnect db = new DBConnect();
            String sqlstr = "select * from customer";
            return db.executeQuery(sqlstr);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
