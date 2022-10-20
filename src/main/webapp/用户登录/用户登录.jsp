<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2022/10/20
  Time: 0:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <link rel="stylesheet" type="text/css" href="/_war_exploded/用户登录/用户登录.css">
</head>
<body>
<div id="log" >
    <div id="log1"><h3 id="h3">用户登录</h3>
        <form name="form1" method="post" action="/_war_exploded/Log_in_Servlet">
            <table>
                <tr>
                    <td>用户：</td>
                    <td><input required placeholder="请输入用户名" type="text" name="user" style="width:200px" /></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input required placeholder="请输入密码" type="password" name="password" style="width:200px"/></td>
                </tr>
                <!-- 以下是提交、取消按钮 -->
                <tr>
                    <td>您的身份是:</td>
                    <td><input type="radio" name="identify" value="doctor">医生
                        <input type="radio" name="identify" value="host">铲屎官</td>
                </tr>
                <tr>
                    <td id="1">
                        <input type="submit" value="登录" />
                    </td>
                    <td id="2">
                        <input type="reset" value="重置" />
                    </td>
                </tr>
            </table>
        </form>
        <a href="/_war_exploded/用户注册/用户注册.jsp">
            <button>注册</button>
        </a>
    </div>


</div>
</body>
</html>
