package Servlet;

import DAO.goodsDAO;
import DAO.orderDAO;
import JavaBean.Goods;
import JavaBean.ShoppingCart;

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
import java.util.List;

@WebServlet(name = "BuyServlet")
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "buy":
                buy(request, response);
                break;
            case "remove":
                remove(request, response);
                break;
            case "clear":
                try {
                    clear(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "check":
                try {
                    check(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                action = "";
                break;
        }
    }
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String strId = request.getParameter("id");
        int id = Integer.parseInt(strId);
        List<Goods> goodsList = (ArrayList<Goods>) session.getAttribute("goodsList");
        Goods single = goodsList.get(id);
        if (single.getNum() <= 0) {
            throw new ServletException("Out of stock！");
        }
        single.setNum(single.getNum() - 1);

        List<Goods> buyList = (ArrayList<Goods>) session.getAttribute("buyList");
        if (null == buyList) {
            buyList = new ArrayList<>();
        }

        ShoppingCart myCar = new ShoppingCart();
        myCar.setBuyList(buyList);
        myCar.addItem(single);

        session.setAttribute("buyList", buyList);
        response.sendRedirect("Inventory.jsp");
    }

    protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException{
        HttpSession session = request.getSession();
        List<Goods> buyList = (ArrayList<Goods>) session.getAttribute("buyList");
        List<Goods> goodsList = (ArrayList<Goods>) session.getAttribute("goodsList");

        String name = request.getParameter("name");
        Goods item = null;

        ShoppingCart myCar = new ShoppingCart();
        for (Goods good : goodsList) {
            if (good.getName().equals(name)) {
                good.setNum(good.getNum() + 1);
            }
        }
        myCar.setBuyList(buyList);
        myCar.removeItem(name);
        response.sendRedirect("ShoppingCart.jsp");
    }

    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        //String name = request.getParameter("name");
        ArrayList<Goods> buyList = (ArrayList<Goods>) session.getAttribute("buyList");
        List<Goods> goodsList = (ArrayList<Goods>) session.getAttribute("goodsList");
        goodsDAO gd = new goodsDAO();
        for(Goods goods : goodsList)
        {
            ResultSet rs = gd.SelectGoods(goods.getId());
            while(rs.next())
                goods.setNum(rs.getInt("quantity"));
        }
        buyList.clear();
        session.setAttribute("goodsList", goodsList);
        response.sendRedirect("ShoppingCart.jsp");
    }

    //check to decrease inventory and add order to order list
    protected void check(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession();
        goodsDAO gd = new goodsDAO();
        orderDAO od = new orderDAO();
        List<Goods> buyList = (ArrayList<Goods>) session.getAttribute("buyList");
        List<Goods> goodsList = (ArrayList<Goods>) session.getAttribute("goodsList");
        for(Goods goodsBuy : buyList)
        {
            for(Goods goods : goodsList)
            {
                if(goodsBuy.getId() == goods.getId())
                    if(gd.Check(goodsBuy.getName(), goods.getNum() - goodsBuy.getNum()))
                        od.InsertOrder(goodsBuy.getName(), goodsBuy.getNum(), goodsBuy.getPrice() * goodsBuy.getNum());
            }
        }
        buyList.clear();
//        session.setAttribute("goodsList", goodsList);
        response.sendRedirect("Inventory.jsp");
    }
}
