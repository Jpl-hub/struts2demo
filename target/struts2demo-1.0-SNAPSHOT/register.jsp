<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>注册</title>
    <style>
        body {
            background: #f5f6fa;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .register-container {
            width: 370px;
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
        .login-link {
            display: block;
            text-align: right;
            margin-top: 10px;
            color: #718093;
            text-decoration: none;
        }
        .login-link:hover {
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
<div class="register-container">
    <h2>用户注册</h2>
    <s:form action="register" method="post" theme="simple">
        <label class="s-label" for="username">用户名</label>
        <s:textfield name="username" id="username" cssClass="s-textfield"/>
        <label class="s-label" for="password1">密码</label>
        <s:password name="password1" id="password1" cssClass="s-password"/>
        <label class="s-label" for="password2">确认密码</label>
        <s:password name="password2" id="password2" cssClass="s-password"/>
        <label class="s-label" for="email">Email</label>
        <s:textfield name="email" id="email" cssClass="s-textfield"/>
        <s:submit value="注册" cssClass="s-submit"/>
    </s:form>
    <s:fielderror cssClass="error"/>
    <a class="login-link" href="login.jsp">已有账号？去登录</a>
</div>
</body>
</html> 