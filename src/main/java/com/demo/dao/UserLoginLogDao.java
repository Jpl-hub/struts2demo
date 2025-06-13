package com.demo.dao;

import com.demo.javabean.DBAccess;
import com.demo.model.UserLoginLog;
import java.util.ArrayList;
import java.util.List;

public class UserLoginLogDao {
    
    public boolean saveLoginLog(UserLoginLog log) {
        boolean success = false;
        DBAccess db = new DBAccess();
        if (db.createConn()) {
            String sql = "INSERT INTO user_login_log(username, login_ip, login_device, status) VALUES('" + 
                         log.getUsername() + "','" + 
                         log.getLoginIp() + "','" + 
                         log.getLoginDevice() + "','" + 
                         log.getStatus() + "')";
            success = db.update(sql);
            db.closeStm();
            db.closeConn();
        }
        return success;
    }
    
    public List<UserLoginLog> getLoginLogs(String username) {
        List<UserLoginLog> logs = new ArrayList<>();
        DBAccess db = new DBAccess();
        if (db.createConn()) {
            String sql = "SELECT * FROM user_login_log WHERE username='" + username + "' ORDER BY login_time DESC LIMIT 20";
            db.query(sql);
            while (db.next()) {
                UserLoginLog log = new UserLoginLog();
                log.setId(Integer.parseInt(db.getValue("id")));
                log.setUsername(db.getValue("username"));
                log.setLoginIp(db.getValue("login_ip"));
                log.setLoginDevice(db.getValue("login_device"));
                log.setStatus(db.getValue("status"));
                log.setLoginTime(db.getTimestamp("login_time"));
                logs.add(log);
            }
            db.closeRs();
            db.closeStm();
            db.closeConn();
        }
        return logs;
    }
    
    public List<UserLoginLog> getAllLoginLogs() {
        List<UserLoginLog> logs = new ArrayList<>();
        DBAccess db = new DBAccess();
        if (db.createConn()) {
            String sql = "SELECT * FROM user_login_log ORDER BY login_time DESC LIMIT 50";
            db.query(sql);
            while (db.next()) {
                UserLoginLog log = new UserLoginLog();
                log.setId(Integer.parseInt(db.getValue("id")));
                log.setUsername(db.getValue("username"));
                log.setLoginIp(db.getValue("login_ip"));
                log.setLoginDevice(db.getValue("login_device"));
                log.setStatus(db.getValue("status"));
                log.setLoginTime(db.getTimestamp("login_time"));
                logs.add(log);
            }
            db.closeRs();
            db.closeStm();
            db.closeConn();
        }
        return logs;
    }
} 