<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登录</title>
    <style>
        body {
            background: #f5f6fa;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .login-container {
            width: 350px;
            margin: 80px auto;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 12px rgba(0,0,0,0.08);
            padding: 40px 30px 30px 30px;
        }
        h2 {
            text-align: center;
            color: #273c75;
            margin-bottom: 30px;
        }
        .s-label {
            font-weight: bold;
            color: #353b48;
            display: block;
            margin-bottom: 5px;
        }
        .s-textfield, .s-password {
            width: 100%;
            padding: 8px 10px;
            margin: 8px 0 18px 0;
            border: 1px solid #dcdde1;
            border-radius: 5px;
            font-size: 15px;
        }
        .s-submit {
            width: 100%;
            background: #273c75;
            color: #fff;
            border: none;
            padding: 10px;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            margin-bottom: 10px;
        }
        .s-submit:hover {
            background: #4078c0;
        }
        .register-link {
            display: block;
            text-align: right;
            margin-top: 10px;
            color: #718093;
            text-decoration: none;
        }
        .register-link:hover {
            color: #273c75;
        }
        .error {
            color: #e84118;
            margin-bottom: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>用户登录</h2>
    <s:form action="login" method="post" theme="simple">
        <label class="s-label" for="username">用户名</label>
        <s:textfield name="username" id="username" cssClass="s-textfield"/>
        <label class="s-label" for="password">密码</label>
        <s:password name="password" id="password" cssClass="s-password"/>
        <s:submit value="登录" cssClass="s-submit"/>
    </s:form>
    <s:fielderror cssClass="error"/>
    <a class="register-link" href="register.jsp">没有账号？注册新用户</a>
</div>
</body>
</html> 