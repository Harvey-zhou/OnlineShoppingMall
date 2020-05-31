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
import java.io.PrintWriter;

@WebServlet(name = "SignUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String userType = request.getParameter("userType");

        HttpSession session = request.getSession();
        //customer
        if(userType.equals("0")){
            customerDAO cd = new customerDAO();
            if(cd.SignUp(userName, userPwd)){
                session.setAttribute("username", userName);
                session.setAttribute("userpwd", userPwd);
                response.sendRedirect("Login.jsp");

                //jump
//                response.setContentType("text/html;charset=utf-8");
//                PrintWriter out =response.getWriter();
//                out.print("<script language='javascript'>alert('Success, you may now Log in!');window.location.href='Login.jsp';</script>");
            }
            else

                response.sendRedirect("SignUp.jsp");
        }
        //merchant
        else if(userType.equals("1")){
            merchantDAO md = new merchantDAO();
            if (md.SignUp(userName, userPwd)){
                session.setAttribute("username", userName);
                session.setAttribute("userpwd", userPwd);
                response.sendRedirect("Login.jsp");
            }
            else
                response.sendRedirect("SignUp.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
