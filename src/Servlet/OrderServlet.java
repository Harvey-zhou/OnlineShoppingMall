package Servlet;

import DAO.orderDAO;
import JavaBean.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name = "OrderServlet")
public class OrderServlet extends HttpServlet {
    private static ArrayList<Order> orderList = new ArrayList<Order>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try{
            orderDAO od = new orderDAO();
            ResultSet rs = od.SelectAllOrders();
            while(rs.next())
            {
                Order order = new Order();
                order.setGoodsName(rs.getString("goodsName"));
                order.setQuantity(rs.getInt("quantity"));
                order.setTotalPrice(rs.getInt("totalPrice"));
                orderList.add(order);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        session.setAttribute("orderList", orderList);
        response.sendRedirect("Order.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
