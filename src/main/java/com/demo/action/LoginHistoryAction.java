package com.demo.action;

import com.demo.dao.UserLoginLogDao;
import com.demo.model.UserLoginLog;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginHistoryAction extends ActionSupport {
    private List<UserLoginLog> loginLogs;
    private UserLoginLogDao loginLogDao = new UserLoginLogDao();

    public String execute() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        String username = (String) session.getAttribute("username");
        
        if (username == null) {
            return "login";
        }
        
        // 获取当前用户的登录历史
        loginLogs = loginLogDao.getLoginLogs(username);
        
        return SUCCESS;
    }

    public List<UserLoginLog> getLoginLogs() {
        return loginLogs;
    }

    public void setLoginLogs(List<UserLoginLog> loginLogs) {
        this.loginLogs = loginLogs;
    }
} 