package com.demo.javabean;

import java.sql.*;

public class DBAccess {
    private String drv = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/struts2demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private String usr = "root";
    private String pwd = "abc123";
    private Connection conn = null;
    private Statement stm = null;
    private ResultSet rs = null;

    public boolean createConn() {
        boolean b = false;
        try {
            Class.forName(drv);
            conn = DriverManager.getConnection(url, usr, pwd);
            b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public boolean update(String sql) {
        boolean b = false;
        try {
            stm = conn.createStatement();
            stm.execute(sql);
            b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public void query(String sql) {
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean next() {
        boolean b = false;
        try {
            if (rs.next()) b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public String getValue(String field) {
        String value = null;
        try {
            if (rs != null) value = rs.getString(field);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public void closeConn() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeStm() {
        try {
            if (stm != null) stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeRs() {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
} 