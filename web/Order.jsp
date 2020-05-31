<%--
  Created by IntelliJ IDEA.
  User: 69430
  Date: 2020/5/29
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>
<%@ page import="JavaBean.Order" %>
<%@ page import="java.util.ArrayList" %>
<%
    ArrayList<Order> orderList = (ArrayList<Order>) session.getAttribute("orderList");
    int money = 0;
%>
<html>
<head>
    <title>Present purchase orders page</title>
</head>
<body>
<div>
    <table border="1" width="100%" rules="none" cellspacing="0" cellpadding="0">
        <tr height="50"><td colspan="5" align="center">Order List:</td></tr>
        <tr align="center" height="30" bgcolor="lightgrey">
            <td width="25%">Name</td>
            <td width="25%">Quantity</td>
            <td width="25%">Money</td>
            <td width="25%">Deal with this order</td>
        </tr>
        <%  if(orderList == null || orderList.size() == 0){ %>
        <tr height="100"><td colspan="3" align="center">No Order Now！</td></tr>
        <%
        }
        else{
            for(int i=0; i < orderList.size(); i++){
                Order single = orderList.get(i);
                money += single.getTotalPrice();
        %>
        <tr height="50" align="center">
            <td><%=single.getGoodsName()%></td>
            <td><%=single.getQuantity()%></td>
            <td><%=single.getTotalPrice()%></td>
            <td><a href="">Deal</a></td>
        </tr>
        <%
                }
            }
        %>
        <tr height="50" align="center"><td colspan="5">Total Income: <%=money%>rmb</td></tr>
        <tr height="50" align="center">
            <td colspan="5"><a href="Merchant.jsp">Go Back to Main Page</a></td>
        </tr>
    </table>
</div>
</body>
</html>
