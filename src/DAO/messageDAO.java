package DAO;

import Database.DBConnect;

import java.sql.ResultSet;

public class messageDAO {
    public void InsertMessage(String author, String titles, String content){
        try{
            DBConnect db = new DBConnect();
            String sqlstr = "insert into message values('" + author + "', '" + titles + "', '" + content + "')";
            db.executeUpdate(sqlstr);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet SelectAllMessages() {
        try {
            DBConnect db = new DBConnect();
            String sqlstr = "select * from message";
            return db.executeQuery(sqlstr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
