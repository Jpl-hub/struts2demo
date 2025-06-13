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
            width: 500px;
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
            margin-top: 20px;
        }
        .logout-btn:hover {
            background: #c23616;
        }
        .nav-link {
            display: inline-block;
            margin: 8px 10px;
            padding: 8px 16px;
            background: #273c75;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background 0.3s;
            font-size: 14px;
        }
        .nav-link:hover {
            background: #4078c0;
            color: #fff;
        }
        .nav-section {
            margin: 25px 0;
        }
        .section-title {
            color: #273c75;
            font-size: 16px;
            margin-bottom: 15px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="main-container">
    <h2>欢迎你，<%=username%>！</h2>
    
    <div class="nav-section">
        <div class="section-title">个人中心</div>
        <a href="profile.action" class="nav-link">个人资料</a>
        <a href="login-history.action" class="nav-link">登录历史</a>
    </div>
    
    <div class="nav-section">
        <div class="section-title">功能模块</div>
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