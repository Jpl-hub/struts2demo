package com.demo.dao;

import com.demo.model.Message;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
    private String url = "jdbc:mysql://localhost:3306/struts2demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private String usr = "root";
    private String pwd = "abc123";

    public void addMessage(String username, String content) {
        try (Connection conn = DriverManager.getConnection(url, usr, pwd)) {
            String sql = "INSERT INTO message(username, content) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, content);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Message> getMessages(String order) {
        List<Message> list = new ArrayList<>();
        String sql = "SELECT * FROM message ORDER BY create_time " + ("asc".equals(order) ? "ASC" : "DESC");
        try (Connection conn = DriverManager.getConnection(url, usr, pwd)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Message m = new Message();
                m.setId(rs.getInt("id"));
                m.setUsername(rs.getString("username"));
                m.setContent(rs.getString("content"));
                m.setCreateTime(rs.getTimestamp("create_time"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
} 