package com.demo.javabean;

public class UserBean {
    public boolean isExist(String username) {
        boolean isExist = false;
        DBAccess db = new DBAccess();
        if (db.createConn()) {
            String sql = "select * from user where username='" + username + "'";
            db.query(sql);
            if (db.next()) {
                isExist = true;
            }
            db.closeRs();
            db.closeStm();
            db.closeConn();
        }
        return isExist;
    }

    public void add(String username, String password, String email) {
        DBAccess db = new DBAccess();
        if (db.createConn()) {
            String sql = "insert into user(username,password,email) values('" + username + "','" + password + "','" + email + "')";
            db.update(sql);
            db.closeStm();
            db.closeConn();
        }
    }
} 