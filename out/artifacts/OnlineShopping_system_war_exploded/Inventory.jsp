<%--
  Created by IntelliJ IDEA.
  User: 69430
  Date: 2020/5/26
  Time: 8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>
<%@ page import="JavaBean.Goods" %>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<Goods> goodsList = (ArrayList<Goods>) session.getAttribute("goodsList"); %>
<html>
<head>
    <title>Commodity Inventory</title>
</head>
<body>
<div>
    <table border="1" width="100%" rules="none" cellspacing="0" cellpadding="0">
        <tr height="50"><td colspan="5" align="center">Goods List:</td></tr>
        <tr align="center" height="30" bgcolor="lightgrey">
            <td width="25%">Name</td>
            <td width="25%">Prize(rmb/kilogram)</td>
            <td width="25%">Storage</td>
            <td width="25%">Add to Shopping Cart</td>
        </tr>
        <%  if(goodsList == null || goodsList.size() == 0){ %>
        <tr height="100"><td colspan="3" align="center">No Commodity Now！</td></tr>
        <%
        }
        else{
            for(int i=0; i < goodsList.size(); i++){
                Goods single = goodsList.get(i);
        %>
        <tr height="50" align="center">
            <td><%=single.getName()%></td>
            <td><%=single.getPrice()%></td>
            <td><%=single.getNum()%></td>
            <td><a href="BuyServlet?action=buy&id=<%=single.getId()%>">Add</a></td>
        </tr>
        <%
                }
            }
        %>
        <tr height="50">
            <td align="center" colspan="3"><a href="ShoppingCart.jsp">Go to Shopping Cart</a></td>
        </tr>
        <tr height="50">
            <td align="center" colspan="3"><a href="Customer.jsp">Go Back to Main Page</a></td>
        </tr>

    </table>
</div>
</body>
</html>
