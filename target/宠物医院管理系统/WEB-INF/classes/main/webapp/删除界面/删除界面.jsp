<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2022/10/15
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除界面</title>
</head>
<body>
<div align="center">请输入要删除的宠物ID
    <form name="form1" method="post" action="http://localhost:8080/_war_exploded/DeleteServlet">
        <table>
            <tr>
                <td>ID：</td>
                <td><input type="text" name="ID" style="width:200px" /></td>
            </tr>

            <!-- 以下是提交、取消按钮 -->
            <tr>
                <td>
                    <input type="submit" value="提交" />
                </td>
                <td>
                    <input type="reset" value="取消" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
