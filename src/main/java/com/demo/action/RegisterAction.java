package com.demo.action;

import com.demo.javabean.UserBean;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
    private String username;
    private String password1;
    private String password2;
    private String email;

    public String execute() {
        if (!password1.equals(password2)) {
            addFieldError("password2", "两次密码不一致");
            return INPUT;
        }
        UserBean userBean = new UserBean();
        if (userBean.isExist(username)) {
            addFieldError("username", "用户名已存在");
            return INPUT;
        }
        userBean.add(username, password1, email);
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (username == null || username.trim().isEmpty()) {
            addFieldError("username", "用户名不能为空");
        }
        if (password1 == null || password1.trim().isEmpty()) {
            addFieldError("password1", "密码不能为空");
        }
        if (password2 == null || password2.trim().isEmpty()) {
            addFieldError("password2", "确认密码不能为空");
        }
        if (email == null || email.trim().isEmpty()) {
            addFieldError("email", "Email不能为空");
        } else if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            addFieldError("email", "Email格式不正确");
        }
        if (password1 != null && password2 != null && !password1.equals(password2)) {
            addFieldError("password2", "两次密码不一致");
        }
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword1() { return password1; }
    public void setPassword1(String password1) { this.password1 = password1; }
    public String getPassword2() { return password2; }
    public void setPassword2(String password2) { this.password2 = password2; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
} 