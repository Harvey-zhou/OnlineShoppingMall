package DAO;

import Database.DBConnect;

import javax.xml.transform.Result;
import java.sql.ResultSet;

public class orderDAO {
    public void InsertOrder(String goodsName, int quantity, int totalPrice){
        try{
            DBConnect db = new DBConnect();
            String sqlstr = "insert into purchase(goodsName, quantity, totalPrice) " +
                    "values('" + goodsName + "', '" + quantity + "', '" + totalPrice + "')";
            db.executeUpdate(sqlstr);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //present all orders to merchant
    public ResultSet SelectAllOrders(){
        try{
            DBConnect db = new DBConnect();
            String sqlstr = "select * from purchase";
            return db.executeQuery(sqlstr);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
