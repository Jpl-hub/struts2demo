package com.demo.action;

import com.demo.javabean.DBAccess;
import com.demo.dao.UserLoginLogDao;
import com.demo.model.UserLoginLog;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;

    public String execute() {
        boolean isValid = false;
        DBAccess db = new DBAccess();
        if (db.createConn()) {
            String sql = "select * from user where username='" + username + "' and password='" + password + "'";
            db.query(sql);
            if (db.next()) {
                isValid = true;
            }
            db.closeRs();
            db.closeStm();
            db.closeConn();
        }
        
        HttpServletRequest request = ServletActionContext.getRequest();
        
        if (isValid) {
            // 登录成功，保存session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            
            // 记录登录日志
            UserLoginLogDao logDao = new UserLoginLogDao();
            UserLoginLog log = new UserLoginLog();
            log.setUsername(username);
            log.setLoginIp(getClientIpAddress(request));
            log.setLoginDevice(request.getHeader("User-Agent"));
            log.setStatus("SUCCESS");
            logDao.saveLoginLog(log);
            
            return SUCCESS;
        } else {
            // 记录登录失败日志
            UserLoginLogDao logDao = new UserLoginLogDao();
            UserLoginLog log = new UserLoginLog();
            log.setUsername(username != null ? username : "unknown");
            log.setLoginIp(getClientIpAddress(request));
            log.setLoginDevice(request.getHeader("User-Agent"));
            log.setStatus("FAILED");
            logDao.saveLoginLog(log);
            
            addFieldError("username", "用户名或密码错误");
            return INPUT;
        }
    }
    
    private String getClientIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
} 