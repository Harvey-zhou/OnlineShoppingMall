<%@ page import="java.util.ArrayList" %>
<%@ page import="JavaBean.Message" %><%--
  Created by IntelliJ IDEA.
  User: 69430
  Date: 2020/5/28
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Message> messageList = (ArrayList<Message>) session.getAttribute("messageList"); %>
<html>
<head>
    <title>Messages Display Page</title>
</head>
<body>
<jsp:useBean id="time" class="java.util.Date"/>
<%
    int currentPage=1, start, pageSize=3, rowCounts;
    if(messageList == null)
        out.print("No message left!");
    else
    {
        int i;
        Message message;
        rowCounts = messageList.size();
        //pageCounts = (rowCounts - 1)/pageSize + 1;
        currentPage = Integer.parseInt(request.getParameter("currentPage"));
        start = (currentPage - 1) * pageSize;

        //get ip address
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        int end = start + pageSize;
        for(i=start; i<end && i < rowCounts; i++)
        {
            message = messageList.get(i);
            out.print("Name：" + message.getAuthor());
            out.print("<br>Title：" + message.getTitle());
            out.print("<br>Content：" + message.getContent());
            out.print("<br>Date：" + time);
            out.print("<br>Ip address：" + ip);
            out.print("<hr>");
        }
    }
%>
<br>CurrentPage: Page <%=currentPage%>
<br>
<a href="DisplayMessage.jsp?currentPage=<%=currentPage - 1%>">Last Page</a>
<a href="DisplayMessage.jsp?currentPage=<%=currentPage + 1%>">Next Page</a>
<br>
<br>
<a href="MessageBoard.jsp">Go back to leave message page</a>
</body>
</html>
