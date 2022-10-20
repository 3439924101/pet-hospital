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
    <link rel="stylesheet" type="text/css" href="/_war_exploded/查询界面/查询界面.css">
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
                xhr.open('POST',"/_war_exploded/SelectServlet",true)
                xhr.send()
            }

            document.getElementById("btn1").onclick=function () {
                var xhr=new XMLHttpRequest();
                xhr.onreadystatechange=function () {
                    if(xhr.readyState===4){
                        if(this.status===404){
                            alert("对不起，你访问的资源不存在，请检查路径")
                        }else if(this.status===500){
                            alert("服务器发生了严重的内部错误")
                        }
                        else if(this.status===200){
                            document.getElementById("res1").innerHTML=this.responseText
                        }
                    }
                }
                xhr.open('POST',"/_war_exploded/SelectServlet1",true)
                xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
                var ID=document.getElementById("ID").value;
                xhr.send("ID="+ID)
            }


        }

    </script>
</head>
<body>
<div align="center">请确认！<br/>
    <button id="btn">查询全部宠物信息!</button><br/>
    <div id="res"></div>

    <p>根据ID查询宠物:</p>
    <table>
    <tr><td>ID：</td><td> <input type="text" id="ID"></td></tr>
    </table>
    <tr><td><button id="btn1">确定</button></td><tr>
    <div id="res1"></div>

    <button onclick="javascript:history.back(-1);">返回</button>
</div>
</body>
</html>
