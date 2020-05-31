<%--
  Created by IntelliJ IDEA.
  User: 69430
  Date: 2020/5/26
  Time: 8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="JavaBean.Goods" %>
<html>
<head>
    <title>Shopping Cart Page</title>
    <script language="JavaScript">
        function purchase() {
            alert("Successfully purchased! Back to inventory page!");
        }
    </script>
</head>
<body>
    <%
        ArrayList<Goods> buyList = (ArrayList<Goods>) session.getAttribute("buyList");
        int total = 0;
        int money = 0;
    %>

    <table border="1" width="100%" rules="none" cellspacing="0" cellpadding="0">
        <tr height="50"><td colspan="5" align="center">Commodities in your shopping cart：</td></tr>
        <tr align="center" height="30" bgcolor="lightgrey">
            <td width="25%">Name</td>
            <td>Price</td>
            <td>Quantity</td>
            <td>Total Price</td>
            <td>Remove(-1)</td>
        </tr>
        <%	if(buyList==null||buyList.size()==0){ %>
        <tr height="100"><td colspan="5" align="center">Your shopping cart is empty！</td></tr>
        <%
        }
        else{
            for(int i=0; i<buyList.size(); i++){
                Goods single = buyList.get(i);
                String name = single.getName();			//name
                int price = single.getPrice();			//price
                int num = single.getNum();				//quantity
                //Calculate total price
                money = price * num;
                total += price * num;
        %>
        <tr align="center" height="50">
            <td><%=name%></td>
            <td><%=price%></td>
            <td><%=num%></td>
            <td><%=money%></td>
            <td><a href="BuyServlet?action=remove&name=<%=single.getName() %>">Remove</a></td>
        </tr>
        <%
                }
            }
        %>
        <tr height="50" align="center"><td colspan="5">All commodities Total price: <%=total%>rmb</td></tr>
        <tr height="50" align="center">
            <td colspan="1"><a href="Inventory.jsp">Back to commodity page</a></td>
            <td colspan="2"><a href="BuyServlet?action=clear">Clear shopping cart</a></td>
            <td colspan="3"><a href="BuyServlet?action=check&" onclick="purchase">Click here to Check</a></td>
        </tr>
    </table>
</body>
</html>
