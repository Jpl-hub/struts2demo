package com.demo.dao;

import com.demo.model.Comment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    private String url = "jdbc:mysql://localhost:3306/struts2demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private String usr = "root";
    private String pwd = "abc123";

    public void addComment(String username, int score, String content) {
        try (Connection conn = DriverManager.getConnection(url, usr, pwd)) {
            String sql = "INSERT INTO comment(username, score, content) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setInt(2, score);
            ps.setString(3, content);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Comment> getComments(String order) {
        List<Comment> list = new ArrayList<>();
        String sql = "SELECT * FROM comment ORDER BY score " + ("asc".equals(order) ? "ASC" : "DESC");
        try (Connection conn = DriverManager.getConnection(url, usr, pwd)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Comment c = new Comment();
                c.setId(rs.getInt("id"));
                c.setUsername(rs.getString("username"));
                c.setScore(rs.getInt("score"));
                c.setContent(rs.getString("content"));
                c.setCreateTime(rs.getTimestamp("create_time"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
} 