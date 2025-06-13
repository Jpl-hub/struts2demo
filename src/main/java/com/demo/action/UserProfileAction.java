package com.demo.action;

import com.demo.dao.UserProfileDao;
import com.demo.model.UserProfile;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class UserProfileAction extends ActionSupport {
    private UserProfile userProfile;
    private String realName;
    private String phone;
    private String address;
    
    private UserProfileDao userProfileDao = new UserProfileDao();

    public String execute() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        String username = (String) session.getAttribute("username");
        
        if (username == null) {
            return "login";
        }
        
        // 获取用户详细信息
        userProfile = userProfileDao.getUserProfile(username);
        if (userProfile == null) {
            // 如果没有详细信息，创建一个空的对象用于显示表单
            userProfile = new UserProfile();
            userProfile.setUsername(username);
        }
        
        return SUCCESS;
    }
    
    public String save() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        String username = (String) session.getAttribute("username");
        
        if (username == null) {
            return "login";
        }
        
        // 验证输入
        if (realName == null || realName.trim().isEmpty()) {
            addFieldError("realName", "真实姓名不能为空");
            return INPUT;
        }
        
        // 保存用户详细信息
        UserProfile profile = new UserProfile();
        profile.setUsername(username);
        profile.setRealName(realName);
        profile.setPhone(phone);
        profile.setAddress(address);
        
        boolean success = userProfileDao.saveUserProfile(profile);
        if (success) {
            addActionMessage("个人资料保存成功！");
            // 重新获取最新数据
            userProfile = userProfileDao.getUserProfile(username);
        } else {
            addActionError("保存失败，请重试！");
        }
        
        return SUCCESS;
    }

    // Getters and Setters
    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
} 