<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2022/10/15
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新</title>
</head>
<body>
<div align="center">请输入更新后的宠物信息
    <form name="form1" method="post" action="http://localhost:8080/_war_exploded/UpdateServlet">
        <table>
            <tr>
                <td>ID：</td>
                <td><input type="text" name="ID" style="width:200px" /></td>
            </tr>
            <tr>
                <td>宠物名：</td>
                <td><input type="text" name="name" style="width:200px"/></td>
            </tr>
            <tr>
                <td>宠物类别：</td>
                <td><input type="text" name="kind" style="width:200px"/></td>
            </tr>
            <tr>
                <td>就诊状态：</td>
                <td><input type="text" name="status" style="width:200px"/></td>
            </tr>
            <tr>
                <td>宠物图片url：</td>
                <td><input type="text" name="photo_url" style="width:200px"/></td>
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
