<%--
  Created by IntelliJ IDEA.
  User: 69430
  Date: 2020/5/26
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message Board Page</title>
</head>
<body>
<div align="center">
    <form action="MessageServlet">
        <table width="100%">
            <tr>
                <td width="50%" height="30" align="right">Your name: </td>
                <td width="50%" height="30" align="left"><input type="text" name="author"/></td>
            </tr>
            <tr>
                <td width="50%" height="30" align="right">Title: </td>
                <td width="50%" height="30" align="left"><input type="text" name="title"/></td>
            </tr>
            <tr>
                <td width="50%" height="30" align="right">Content: </td>
                <td width="50%" height="30" align="left"><textarea name="content" rows="6" cols="20"></textarea></td>
            </tr>
            <tr>
                <td width="100%" height="50" align="center" colspan="2"><input type="submit" value="leave message"/></td>
            </tr>
            <tr>
                <td width="100%" height="50" align="center" colspan="2">
                    <a href="DisplayMessage.jsp?currentPage=1">Go to message board</a>
                </td>
            </tr>
            <tr>
                <td width="100%" height="50" align="center" colspan="2">
                    <a href="Merchant.jsp">Go back to Main Page</a>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
