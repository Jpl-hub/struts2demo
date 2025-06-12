<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>黑名单提示</title>
    <style>
        body {
            background: #f5f6fa;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .blacklist-container {
            width: 350px;
            margin: 100px auto;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 12px rgba(0,0,0,0.08);
            padding: 40px 30px 30px 30px;
            text-align: center;
        }
        .msg {
            color: #e84118;
            font-size: 18px;
            margin-bottom: 20px;
        }
        .back-link {
            color: #273c75;
            text-decoration: none;
            font-size: 16px;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="blacklist-container">
    <div class="msg">
        <%= request.getAttribute("blacklistMsg") != null ? request.getAttribute("blacklistMsg") : "该用户已被列入黑名单，禁止登录。" %>
    </div>
    <a class="back-link" href="login.jsp">返回登录</a>
</div>
</body>
</html> 