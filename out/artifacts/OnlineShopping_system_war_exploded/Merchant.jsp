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
    <title>Merchant Page</title>
</head>
<body>
<div align="center">
    <br>
    <h1>Welcome to your store!</h1>
    <form action="CustomerServlet">
        <table>
            <tr>
                <td width="50%" height="30" align="right">Click to manage profile of vip: </td>
                <td width="50%" height="30" align="left"> <input type="submit" name="vipPage" value="VIP Page"></td>
            </tr>
        </table>
    </form>
    <form action="MessageBoard.jsp">
        <table>
            <tr>
                <td width="50%" height="30" align="right">Enter Message Board: </td>
                <td width="50%" height="30" align="left"> <input type="submit" name="messageBoard" value="Reply messages"></td>
            </tr>
        </table>
    </form>
    <form action="OrderServlet">
        <table>
            <tr>
                <td width="50%" height="30" align="right">Click to check purchase orders: </td>
                <td width="50%" height="30" align="left"> <input type="submit" name="order" value="Order Page"></td>
            </tr>
    </table>
    </form>
</div>
</body>
</html>
