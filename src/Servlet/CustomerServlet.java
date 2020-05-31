package Servlet;

import DAO.customerDAO;
import JavaBean.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name = "customerServlet")
public class CustomerServlet extends HttpServlet {
    private static ArrayList<Customer> customerList = new ArrayList<Customer>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try{
            customerDAO cd = new customerDAO();
            ResultSet rs = cd.SelectAllCustomer();
            while(rs.next())
            {
                Customer customer = new Customer();
                customer.setUsername(rs.getString("username"));
                customerList.add(customer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        session.setAttribute("customerList", customerList);
        response.sendRedirect("ManageVIP.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
