package Servlet;

import DAO.goodsDAO;
import JavaBean.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "InventoryServlet")
public class InventoryServlet extends HttpServlet {
    private static ArrayList<Goods> goodsList = new ArrayList<Goods>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try{
            goodsDAO gd = new goodsDAO();
            ResultSet rs = gd.SelectAllGoods();
            while (rs.next())
            {
                //commodity javabean
                Goods goods = new Goods();
                goods.setId(rs.getInt("id"));
                goods.setName(rs.getString("goodsName"));
                goods.setNum(rs.getInt("quantity"));
                goods.setPrice(rs.getInt("price"));
                goodsList.add(goods);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("goodsList", goodsList);
        response.sendRedirect("Inventory.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
