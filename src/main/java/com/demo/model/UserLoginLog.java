package com.demo.model;

import java.sql.Timestamp;

public class UserLoginLog {
    private int id;
    private String username;
    private Timestamp loginTime;
    private String loginIp;
    private String loginDevice;
    private String status;

    public UserLoginLog() {}

    public UserLoginLog(String username, String loginIp, String loginDevice, String status) {
        this.username = username;
        this.loginIp = loginIp;
        this.loginDevice = loginDevice;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginDevice() {
        return loginDevice;
    }

    public void setLoginDevice(String loginDevice) {
        this.loginDevice = loginDevice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
} 