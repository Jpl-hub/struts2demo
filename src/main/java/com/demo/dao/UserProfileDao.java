package com.demo.dao;

import com.demo.javabean.DBAccess;
import com.demo.model.UserProfile;

public class UserProfileDao {
    
    public UserProfile getUserProfile(String username) {
        UserProfile profile = null;
        DBAccess db = new DBAccess();
        if (db.createConn()) {
            String sql = "SELECT * FROM user_profile WHERE username='" + username + "'";
            db.query(sql);
            if (db.next()) {
                profile = new UserProfile();
                profile.setId(Integer.parseInt(db.getValue("id")));
                profile.setUsername(db.getValue("username"));
                profile.setRealName(db.getValue("real_name"));
                profile.setPhone(db.getValue("phone"));
                profile.setAddress(db.getValue("address"));
                profile.setAvatar(db.getValue("avatar"));
                profile.setCreateTime(db.getTimestamp("create_time"));
                profile.setUpdateTime(db.getTimestamp("update_time"));
            }
            db.closeRs();
            db.closeStm();
            db.closeConn();
        }
        return profile;
    }
    
    public boolean saveUserProfile(UserProfile profile) {
        boolean success = false;
        DBAccess db = new DBAccess();
        if (db.createConn()) {
            // 先检查是否已存在
            String checkSql = "SELECT id FROM user_profile WHERE username='" + profile.getUsername() + "'";
            db.query(checkSql);
            boolean exists = db.next();
            db.closeRs();
            db.closeStm();
            
            String sql;
            if (exists) {
                // 更新
                sql = "UPDATE user_profile SET real_name='" + profile.getRealName() + 
                      "', phone='" + profile.getPhone() + 
                      "', address='" + profile.getAddress() + 
                      "', avatar='" + (profile.getAvatar() != null ? profile.getAvatar() : "") + 
                      "' WHERE username='" + profile.getUsername() + "'";
            } else {
                // 插入
                sql = "INSERT INTO user_profile(username, real_name, phone, address, avatar) VALUES('" + 
                      profile.getUsername() + "','" + 
                      profile.getRealName() + "','" + 
                      profile.getPhone() + "','" + 
                      profile.getAddress() + "','" + 
                      (profile.getAvatar() != null ? profile.getAvatar() : "") + "')";
            }
            success = db.update(sql);
            db.closeStm();
            db.closeConn();
        }
        return success;
    }
} 