package Servlet;

import DAO.messageDAO;
import JavaBean.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name = "MessageServlet")
public class MessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        messageDAO md = new messageDAO();
        //insert message into Database
        try{
            String author = request.getParameter("author");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            md.InsertMessage(author, title, content);
        }catch (Exception e){
            e.printStackTrace();
        }

        //use ArrayList to save all messages
        ArrayList<Message> messageList = new ArrayList<Message>();
        HttpSession session = request.getSession();
        try{
            ResultSet rs = md.SelectAllMessages();
            while(rs.next())
            {
                Message message = new Message();
                message.setAuthor(rs.getString("author"));
                message.setTitle(rs.getString("title"));
                message.setContent(rs.getString("content"));
                messageList.add(message);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        session.setAttribute("messageList", messageList);
        response.sendRedirect("MessageBoard.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
