<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登录历史</title>
    <style>
        body { background: #f5f6fa; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }
        .history-container { width: 800px; margin: 40px auto; background: #fff; border-radius: 10px; box-shadow: 0 2px 12px rgba(0,0,0,0.08); padding: 30px; }
        h2 { text-align: center; color: #273c75; margin-bottom: 30px; }
        .back-link { color: #718093; text-decoration: none; display: inline-block; margin-bottom: 20px; }
        .back-link:hover { color: #273c75; }
        .history-table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        .history-table th, .history-table td { padding: 12px; text-align: left; border-bottom: 1px solid #eee; }
        .history-table th { background: #f8f9fa; color: #273c75; font-weight: bold; }
        .history-table tr:hover { background: #f8f9fa; }
        .status-success { color: #44bd32; font-weight: bold; }
        .status-failed { color: #e84118; font-weight: bold; }
        .no-data { text-align: center; color: #718093; padding: 40px; }
        .device-info { max-width: 200px; word-break: break-all; font-size: 12px; color: #666; }
    </style>
</head>
<body>
<div class="history-container">
    <a href="welcome.jsp" class="back-link">← 返回主页</a>
    <h2>登录历史</h2>
    
    <s:if test="loginLogs != null && loginLogs.size() > 0">
        <table class="history-table">
            <thead>
                <tr>
                    <th>序号</th>
                    <th>登录时间</th>
                    <th>IP地址</th>
                    <th>设备信息</th>
                    <th>状态</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="loginLogs" status="status">
                    <tr>
                        <td><s:property value="#status.count"/></td>
                        <td><s:property value="loginTime"/></td>
                        <td><s:property value="loginIp"/></td>
                        <td class="device-info"><s:property value="loginDevice"/></td>
                        <td>
                            <s:if test="status == 'SUCCESS'">
                                <span class="status-success">成功</span>
                            </s:if>
                            <s:else>
                                <span class="status-failed">失败</span>
                            </s:else>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </s:if>
    <s:else>
        <div class="no-data">
            暂无登录记录
        </div>
    </s:else>
</div>
</body>
</html> 