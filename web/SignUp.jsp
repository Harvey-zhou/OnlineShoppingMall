<%--
  Created by IntelliJ IDEA.
  User: 69430
  Date: 2020/5/29
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up page</title>
    <script language="JavaScript">
        //check username and userpwd input status
        function check(userName,userPwd) {
            if (userName.length < 1) {
                alert("User Name can not be empty");
                document.form1.userName.focus();
                return false;
            } else if (userPwd.length < 1) {
                alert("User Password can not be empty");
                document.form1.userPwd.focus();
                return false;
            }
        }
    </script>
</head>
<body>
<div align="center">
    <br>
    <h1>Please input information to sign up!</h1>
    <form name="form1" action="SignUpServlet" method="post" onsubmit="return check(userName.value, userPwd.value);">
        <table width="100%">
            <tr>
                <td width="50%" height="30" align="right">Your Username:</td>
                <td width="50%" height="30" align="left"> <input type="text" name="userName"></td>
            </tr>
            <tr>
                <td width="50%" height="30" align="right">Enter Password:</td>
                <td width="50%" height="30" align="left"> <input type="password" name="userPwd"></td>
            </tr>
            <tr>
                <td width="50%" height="30" align="right">Select Your Account Type:</td>
                <td width="50%" height="30" align="left">
                    <select name="userType" id="type">
                        <option value="0">customer</option>
                        <option value="1">merchant</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td width="100%" height="40" align="center" colspan="2">
                    <input type="submit" name="submit" value="Sign up">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
