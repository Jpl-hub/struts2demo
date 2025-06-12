package com.demo.action;

import com.demo.javabean.DBAccess;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpSession;
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
        if (isValid) {
            // 登录成功，保存session
            HttpSession session = ServletActionContext.getRequest().getSession();
            session.setAttribute("username", username);
            return SUCCESS;
        } else {
            addFieldError("username", "用户名或密码错误");
            return INPUT;
        }
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
} 