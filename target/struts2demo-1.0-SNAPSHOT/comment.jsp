<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>评价</title>
    <style>
        body { background: #f5f6fa; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }
        .cmt-container { width: 600px; margin: 40px auto; background: #fff; border-radius: 10px; box-shadow: 0 2px 12px rgba(0,0,0,0.08); padding: 30px 30px 20px 30px; }
        h2 { text-align: center; color: #273c75; margin-bottom: 20px; }
        .cmt-list { margin-bottom: 30px; }
        .cmt-item { border-bottom: 1px solid #eee; padding: 10px 0; }
        .cmt-username { color: #273c75; font-weight: bold; }
        .cmt-time { color: #aaa; font-size: 12px; margin-left: 10px; }
        .cmt-score { color: #e1b12c; font-weight: bold; margin-left: 10px; }
        .cmt-content { margin: 5px 0 0 0; }
        .cmt-form { margin-bottom: 20px; }
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
<div class="cmt-container">
    <h2>评价</h2>
    <div style="margin-bottom:15px;">
        <s:url var="descUrl" action="comment"><s:param name="order">desc</s:param></s:url>
        <s:url var="ascUrl" action="comment"><s:param name="order">asc</s:param></s:url>
        <a href="${descUrl}" class="sort-btn <s:if test='order=="desc"'>active</s:if>'">评分高优先</a>
        <a href="${ascUrl}" class="sort-btn <s:if test='order=="asc"'>active</s:if>'">评分低优先</a>
        <a class="back-link" href="welcome.jsp">返回主页</a>
    </div>
    <div class="cmt-list">
        <s:iterator value="comments">
            <div class="cmt-item">
                <span class="cmt-username"><s:property value="username"/></span>
                <span class="cmt-score">评分：<s:property value="score"/></span>
                <span class="cmt-time"><s:date name="createTime" format="yyyy-MM-dd HH:mm:ss"/></span>
                <div class="cmt-content"><s:property value="content"/></div>
            </div>
        </s:iterator>
    </div>
    <div class="cmt-form">
        <s:form action="comment!add" method="post" theme="simple">
            <label class="s-label" for="score">评分（1-5分）</label>
            <s:textfield name="score" id="score" cssClass="s-textfield"/>
            <label class="s-label" for="content">评价内容</label>
            <s:textfield name="content" id="content" cssClass="s-textfield"/>
            <s:submit value="评价" cssClass="s-submit"/>
            <s:hidden name="order" value="%{order}"/>
        </s:form>
        <s:actionmessage cssClass="msg"/>
        <s:fielderror cssClass="error"/>
    </div>
</div>
</body>
</html> 