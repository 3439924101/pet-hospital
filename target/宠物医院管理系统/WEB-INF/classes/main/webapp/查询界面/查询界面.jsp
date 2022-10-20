<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2022/10/15
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询界面</title>
</head>
<body>
<div align="center">请确认!
    <form name="form1" method="post" action="http://localhost:8080/_war_exploded/SelectServlet">
        <table>
            <!-- 以下是提交、取消按钮 -->
            <tr>
                <td>
                    <input type="submit" value="查询" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
