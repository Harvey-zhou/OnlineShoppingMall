package Servlet;

import DAO.customerDAO;
import DAO.merchantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String userType = request.getParameter("userType");

        HttpSession session = request.getSession();
        //customer
        if(userType.equals("0")){
            customerDAO cd = new customerDAO();
            if(cd.login(userName, userPwd)){
                session.setAttribute("username", userName);
                session.setAttribute("userpwd", userPwd);
                response.sendRedirect("Customer.jsp");
            }
            else
                response.sendRedirect("Error.jsp");
        }
        //merchant
        else if(userType.equals("1")){
            merchantDAO md = new merchantDAO();
            if (md.login(userName, userPwd)){
                session.setAttribute("username", userName);
                session.setAttribute("userpwd", userPwd);
                response.sendRedirect("Merchant.jsp");
            }
            else
                response.sendRedirect("Error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
