<%--
  Created by IntelliJ IDEA.
  User: 69430
  Date: 2020/5/31
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>
<%@ page import="JavaBean.Order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="JavaBean.Customer" %>
<%
    ArrayList<Customer> customerList = (ArrayList<Customer>) session.getAttribute("customerList");
    int totalCustomer = 0;
%>
<html>
<head>
    <title>Present customer profile page</title>
</head>
<body>
<div>
    <table border="1" width="100%" rules="none" cellspacing="0" cellpadding="0">
        <tr height="50"><td colspan="5" align="center">Customer List:</td></tr>
        <tr align="center" height="30" bgcolor="lightgrey">
            <td width="25%">Customer user name</td>
            <td width="25%">Delete this customer</td>
        </tr>
        <%  if(customerList == null || customerList.size() == 0){ %>
        <tr height="100"><td colspan="3" align="center">No Customer profile!</td></tr>
        <%
        }
        else{
            for(int i=0; i < customerList.size(); i++){
                Customer single = customerList.get(i);
                totalCustomer ++;
        %>
        <tr height="50" align="center">
            <td><%=single.getUsername()%></td>
            <td><a href="">Delete</a></td>
        </tr>
        <%
                }
            }
        %>
        <tr height="50" align="center"><td colspan="5">Total Customer: <%=totalCustomer%></td></tr>
        <tr height="50" align="center">
            <td colspan="5"><a href="Merchant.jsp">Go Back to Main Page</a></td>
        </tr>
    </table>
</div>
</body>
</html>
