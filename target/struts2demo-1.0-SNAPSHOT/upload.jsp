<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>文件上传</title>
    <style>
        body { background: #f5f6fa; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }
        .upload-container {
            width: 400px; margin: 80px auto; background: #fff; border-radius: 10px;
            box-shadow: 0 2px 12px rgba(0,0,0,0.08); padding: 40px 30px 30px 30px;
        }
        h2 { text-align: center; color: #273c75; margin-bottom: 30px; }
        .s-label { font-weight: bold; color: #353b48; display: block; margin-bottom: 5px; }
        .s-file { width: 100%; margin: 8px 0 18px 0; }
        .s-submit {
            width: 100%; background: #273c75; color: #fff; border: none; padding: 10px;
            border-radius: 5px; font-size: 16px; cursor: pointer; margin-bottom: 10px;
        }
        .s-submit:hover { background: #4078c0; }
        .msg { color: #44bd32; text-align: center; margin-bottom: 10px; }
        .error { color: #e84118; text-align: center; margin-bottom: 10px; }
    </style>
</head>
<body>
<div class="upload-container">
    <h2>文件上传</h2>
    <s:form action="upload" method="post" enctype="multipart/form-data" theme="simple">
        <label class="s-label" for="file">选择文件</label>
        <s:file name="file" id="file" cssClass="s-file"/>
        <s:submit value="上传" cssClass="s-submit"/>
    </s:form>
    <s:actionmessage cssClass="msg"/>
    <s:fielderror cssClass="error"/>
    <a href="welcome.jsp" style="float:right;color:#718093;">返回主页</a>
</div>
</body>
</html> 