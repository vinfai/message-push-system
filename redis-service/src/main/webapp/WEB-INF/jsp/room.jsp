<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Room</title>
    <meta charset="utf-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <style media="screen">
        * {
            margin: 0;
            padding: 0;
        }

        header {
            padding: 1em 0;
            text-align: center;
            background-color: #4a4;
            color: #fff;
            font-size: 300%;
        }

        header span {
            font-size: 50%;
            margin-left: 1em;
            color: #eee;
        }

        footer {
            position: absolute;
            bottom: 0;
            padding: 2em 0;
            text-align: center;
            background-color: #4a4;
            color: #fff;
            width: 100%;
            clear: both;
        }

        .content {
            width: 75%;
            overflow: auto;
            float: right;
            min-height: 600px;
        }

        ul {
            list-style-type: none;
            margin-top: 1em;
        }

        li a {
            display: block;
            color: #000;
            padding: 8px 0 8px 16px;
            text-decoration: none;
        }

        li a:hover {
            background-color: #4a4;
            color: white;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin:2em auto;
        }

        th, td {
            padding: 8px;
        }

        html, body {
            width: 100%;
            height: 100%;
        }

        div.wrap {
            width: 100%;
            height: 100%;
            position: relative;
        }

        .form {
            position: absolute;
            top: 80%;
            left: 50%;
            tranform: translate(-50%, -50%);
        }

    </style>

</head>
<%
    String appid = request.getParameter("appid");
    String requestCode = request.getParameter("requestCode");
    String pushAddress = request.getParameter("pushAddress");
    String jsonarr = (String) request.getAttribute("message");
%>
<script type="text/javascript">
    var jsonarray = <%=jsonarr%>;
    window.onload = function () {
        var table = document.getElementById("table");
        for (var i = 0; i < jsonarray.length; i++) {
            switch (jsonarray[i].type) {
                case 1:
                    table.innerHTML = table.innerHTML + "<tr><td>Admin说：" + jsonarray[i].text + "      time=" + jsonarray[i].time + "</td></tr>";
                    break;
                case 2:
                    table.innerHTML = table.innerHTML + "<tr><td bgcolor='#f2f200' align='right'>用户说：" + jsonarray[i].text + "      time=" + jsonarray[i].time + "</td></tr>";
                    break;
            }
        }
    }
</script>
<body>
<div class='wrap'>
    <header>
        <div style="float:right;font-size:18px;"></div>
        <span>回复</span>
    </header>

    <div class="content">
        <table>
            <tbody id="table">
            <tr>
                <th>内容</th>
            </tr>
            </tbody>
        </table>

        <br/>


    </div>

    <div class="form">
        <form action="/pubsub/reply" METHOD="post">

            <input type="hidden" name="appid" value="<%=appid%>"/>
            <input type="hidden" name="requestCode" value="<%=requestCode%>"/>
            <input type="hidden" name="pushAddress" value="<%=pushAddress%>"/>
            <input type="text" name="replyText" placeholder="请输入reply" style="width:300px"/>
            <input type="submit" value="回复"/>
        </form>
    </div>

    <footer>Copyright (c) 2017 CVTE All Rights Reserved.</footer>
</div>
</body>
</html>