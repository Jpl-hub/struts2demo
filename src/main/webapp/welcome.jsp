<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>主页</title>
    <style>
        body {
            background: #f5f6fa;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .main-container {
            width: 400px;
            margin: 100px auto;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 12px rgba(0,0,0,0.08);
            padding: 40px 30px 30px 30px;
            text-align: center;
        }
        h2 {
            color: #273c75;
            margin-bottom: 30px;
        }
        .logout-btn {
            background: #e84118;
            color: #fff;
            border: none;
            padding: 10px 30px;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        .logout-btn:hover {
            background: #c23616;
        }
        .nav-link {
            display: inline-block;
            margin: 10px 15px;
            padding: 8px 20px;
            background: #273c75;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background 0.3s;
        }
        .nav-link:hover {
            background: #4078c0;
            color: #fff;
        }
    </style>
</head>
<body>
<div class="main-container">
    <h2>欢迎你，<%=username%>！</h2>
    <div style="margin: 30px 0;">
        <a href="upload.jsp" class="nav-link">文件上传</a>
        <a href="message.action" class="nav-link">留言板</a>
        <a href="comment.action" class="nav-link">评价</a>
    </div>
    <form action="logout.action" method="post">
        <input type="submit" value="退出登录" class="logout-btn"/>
    </form>
</div>
</body>
</html> 