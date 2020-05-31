<%--
  Created by IntelliJ IDEA.
  User: 69430
  Date: 2020/5/25
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Page</title>

</head>
<body>
<div align="center">
    <br>
    <h1>Welcome to Online Shopping Mall!</h1>
    <form action="InventoryServlet">
        <table>
            <tr>
                <td width="50%" height="30" align="right">Click to browse commodities: </td>
                <td width="50%" height="30" align="left"> <input type="submit" name="commodity" value="Commodity Page"></a> </td>
            </tr>
        </table>
    </form>

<%--    <form action="ShoppingCart.jsp">--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <td width="50%" height="30" align="right">Click to enter your Shopping Cart: </td>--%>
<%--                <td width="50%" height="30" align="left"> <input type="submit" name="shoppingCart" value="Shopping Cart"/></td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form>--%>

    <form action="MessageBoard.jsp">
        <table>
            <tr>
                <td width="50%" height="30" align="right">Click to enter Message Board: </td>
                <td width="50%" height="30" align="left"> <input type="submit" name="MessageBoard" value="Message Board"/></td>
            </tr>
        </table>
    </form>

    <form action="">
        <table>
            <tr>
                <td width="50%" height="30" align="right">Click to manage your information: </td>
                <td width="50%" height="30" align="left"> <input type="submit" name="Profile" value="Manage Profile"></td>
            </tr>
       </table>
    </form>

</div>
</body>
</html>
