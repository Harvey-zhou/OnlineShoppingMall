package DAO;

import Database.DBConnect;
import JavaBean.Goods;

import java.sql.ResultSet;

public class goodsDAO {
    public ResultSet SelectAllGoods() {
        try {
            DBConnect db = new DBConnect();
            String sqlstr = "select * from inventory ";
            return db.executeQuery(sqlstr);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //select particular goods inventory in database
    public ResultSet SelectGoods(int id){
        try{
            DBConnect db = new DBConnect();
            String sqlstr = "select quantity from inventory where id='" + id + "'";
            return db.executeQuery(sqlstr);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean Check(String goodsName, int quantity){
        try{
            DBConnect db = new DBConnect();
            String sqlstr = "update inventory set quantity='" + quantity + "' where goodsName='" + goodsName +"'";
            db.executeUpdate(sqlstr);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
