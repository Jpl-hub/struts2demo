<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>留言板</title>
    <style>
        body { background: #f5f6fa; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }
        .msg-container { width: 600px; margin: 40px auto; background: #fff; border-radius: 10px; box-shadow: 0 2px 12px rgba(0,0,0,0.08); padding: 30px 30px 20px 30px; }
        h2 { text-align: center; color: #273c75; margin-bottom: 20px; }
        .msg-list { margin-bottom: 30px; }
        .msg-item { border-bottom: 1px solid #eee; padding: 10px 0; }
        .msg-username { color: #273c75; font-weight: bold; }
        .msg-time { color: #aaa; font-size: 12px; margin-left: 10px; }
        .msg-content { margin: 5px 0 0 0; }
        .msg-form { margin-bottom: 20px; }
        .s-label { font-weight: bold; color: #353b48; display: block; margin-bottom: 5px; }
        .s-textfield { width: 100%; padding: 8px 10px; margin: 8px 0 18px 0; border: 1px solid #dcdde1; border-radius: 5px; font-size: 15px; }
        .s-submit { width: 100%; background: #273c75; color: #fff; border: none; padding: 10px; border-radius: 5px; font-size: 16px; cursor: pointer; margin-bottom: 10px; }
        .s-submit:hover { background: #4078c0; }
        .msg { color: #44bd32; text-align: center; margin-bottom: 10px; }
        .error { color: #e84118; text-align: center; margin-bottom: 10px; }
        .sort-btn { background: #dcdde1; color: #273c75; border: none; border-radius: 5px; padding: 5px 12px; margin-right: 10px; cursor: pointer; }
        .sort-btn.active { background: #273c75; color: #fff; }
        .back-link { color: #718093; text-decoration: none; float: right; }
        .back-link:hover { color: #273c75; }
    </style>
</head>
<body>
<div class="msg-container">
    <h2>留言板</h2>
    <div style="margin-bottom:15px;">
        <s:url var="descUrl" action="message"><s:param name="order">desc</s:param></s:url>
        <s:url var="ascUrl" action="message"><s:param name="order">asc</s:param></s:url>
        <a href="${descUrl}" class="sort-btn <s:if test='order=="desc"'>active</s:if>'">最新优先</a>
        <a href="${ascUrl}" class="sort-btn <s:if test='order=="asc"'>active</s:if>'">最早优先</a>
        <a class="back-link" href="welcome.jsp">返回主页</a>
    </div>
    <div class="msg-list">
        <s:iterator value="messages">
            <div class="msg-item">
                <span class="msg-username"><s:property value="username"/></span>
                <span class="msg-time"><s:date name="createTime" format="yyyy-MM-dd HH:mm:ss"/></span>
                <div class="msg-content"><s:property value="content"/></div>
            </div>
        </s:iterator>
    </div>
    <div class="msg-form">
        <s:form action="message!add" method="post" theme="simple">
            <label class="s-label" for="content">留言内容</label>
            <s:textfield name="content" id="content" cssClass="s-textfield"/>
            <s:submit value="留言" cssClass="s-submit"/>
            <s:hidden name="order" value="%{order}"/>
        </s:form>
        <s:actionmessage cssClass="msg"/>
        <s:fielderror cssClass="error"/>
    </div>
</div>
</body>
</html> 