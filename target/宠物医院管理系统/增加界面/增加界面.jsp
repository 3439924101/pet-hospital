<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2022/10/15
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>增加界面</title>
    <link rel="stylesheet" type="text/css" href="/_war_exploded/增加界面/增加界面.css">
</head>
<script type="text/javascript">
    window.onload=function () {
        document.getElementById("btn").onclick=function () {
            var xhr=new XMLHttpRequest();
            xhr.onreadystatechange=function () {
                if(xhr.readyState===4){
                    if(this.status===404){
                        alert("对不起，你访问的资源不存在，请检查路径")
                    }else if(this.status===500){
                        alert("服务器发生了严重的内部错误")
                    }
                    else if(this.status===200){
                        document.getElementById("res").innerHTML=this.responseText
                    }
                }
            }
            xhr.open('POST',"/_war_exploded/AddServlet",true)
            xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
            var ID=document.getElementById("ID").value;
            var name=document.getElementById("name").value;
            var kind=document.getElementById("kind").value;
            var status=document.getElementById("status").value;
            var photo_url=document.getElementById("photo_url").value;
            xhr.send("ID="+ID+"&name="+name+"&kind="+kind+"&status="+status+"&photo_url="+photo_url)
        }
    }

</script>
<body>
<div align="center" id="div">请输入要增加宠物的信息
    <table>
        <tr><td>ID：</td><td><input type="text" id="ID"></td></tr>
        <tr><td>宠物名称：</td><td><input type="text" id="name"></td></tr>
        <tr><td>宠物种类：</td><td><input type="text" id="kind"></td></tr>
        <tr><td>铲屎官：</td><td><input type="text" id="status"></td></tr>
        <tr><td>病情：</td><td><input type="text" id="photo_url"></td></tr>
        <tr><td><button id="btn">增加</button></td><td><button onclick="javascript:history.back(-1);">返回</button></td>
    </table>
    <div id="res"></div>
</div>

</body>
</html>

