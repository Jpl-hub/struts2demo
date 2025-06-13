<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>个人资料</title>
    <style>
        body { background: #f5f6fa; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }
        .profile-container { width: 500px; margin: 40px auto; background: #fff; border-radius: 10px; box-shadow: 0 2px 12px rgba(0,0,0,0.08); padding: 30px; }
        h2 { text-align: center; color: #273c75; margin-bottom: 30px; }
        .form-group { margin-bottom: 20px; }
        .s-label { font-weight: bold; color: #353b48; display: block; margin-bottom: 5px; }
        .s-textfield { width: 100%; padding: 10px; border: 1px solid #dcdde1; border-radius: 5px; font-size: 15px; }
        .s-textarea { width: 100%; padding: 10px; border: 1px solid #dcdde1; border-radius: 5px; font-size: 15px; min-height: 80px; resize: vertical; }
        .s-submit { width: 100%; background: #273c75; color: #fff; border: none; padding: 12px; border-radius: 5px; font-size: 16px; cursor: pointer; margin-top: 10px; }
        .s-submit:hover { background: #4078c0; }
        .back-link { color: #718093; text-decoration: none; display: inline-block; margin-bottom: 20px; }
        .back-link:hover { color: #273c75; }
        .msg { color: #44bd32; text-align: center; margin-bottom: 15px; font-weight: bold; }
        .error { color: #e84118; text-align: center; margin-bottom: 15px; }
        .info-display { background: #f8f9fa; padding: 15px; border-radius: 5px; margin-bottom: 20px; }
        .info-item { margin-bottom: 10px; }
        .info-label { font-weight: bold; color: #273c75; display: inline-block; width: 80px; }
    </style>
</head>
<body>
<div class="profile-container">
    <a href="welcome.jsp" class="back-link">← 返回主页</a>
    <h2>个人资料</h2>
    
    <s:actionmessage cssClass="msg"/>
    <s:actionerror cssClass="error"/>
    <s:fielderror cssClass="error"/>
    
    <s:if test="userProfile != null && userProfile.realName != null">
        <div class="info-display">
            <h3 style="color: #273c75; margin-bottom: 15px;">当前资料</h3>
            <div class="info-item">
                <span class="info-label">用户名：</span>
                <s:property value="userProfile.username"/>
            </div>
            <div class="info-item">
                <span class="info-label">真实姓名：</span>
                <s:property value="userProfile.realName"/>
            </div>
            <div class="info-item">
                <span class="info-label">手机号码：</span>
                <s:property value="userProfile.phone"/>
            </div>
            <div class="info-item">
                <span class="info-label">地址：</span>
                <s:property value="userProfile.address"/>
            </div>
        </div>
    </s:if>
    
    <h3 style="color: #273c75; margin-bottom: 20px;">
        <s:if test="userProfile != null && userProfile.realName != null">
            修改资料
        </s:if>
        <s:else>
            完善资料
        </s:else>
    </h3>
    
    <s:form action="profile!save" method="post" theme="simple">
        <div class="form-group">
            <label class="s-label" for="realName">真实姓名 *</label>
            <s:textfield name="realName" id="realName" cssClass="s-textfield" 
                         value="%{userProfile.realName}" placeholder="请输入真实姓名"/>
        </div>
        
        <div class="form-group">
            <label class="s-label" for="phone">手机号码</label>
            <s:textfield name="phone" id="phone" cssClass="s-textfield" 
                         value="%{userProfile.phone}" placeholder="请输入手机号码"/>
        </div>
        
        <div class="form-group">
            <label class="s-label" for="address">地址</label>
            <s:textarea name="address" id="address" cssClass="s-textarea" 
                        value="%{userProfile.address}" placeholder="请输入详细地址"/>
        </div>
        
        <s:submit value="保存资料" cssClass="s-submit"/>
    </s:form>
</div>
</body>
</html>