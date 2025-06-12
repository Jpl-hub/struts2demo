package com.demo.action;

import com.demo.dao.MessageDao;
import com.demo.model.Message;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpSession;
import java.util.List;

public class MessageAction extends ActionSupport {
    private String content;
    private String order = "desc";
    private List<Message> messages;

    public String execute() {
        MessageDao dao = new MessageDao();
        messages = dao.getMessages(order);
        return SUCCESS;
    }

    public String add() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            addActionError("请先登录！");
            return INPUT;
        }
        if (content == null || content.trim().isEmpty()) {
            addFieldError("content", "留言内容不能为空");
            return INPUT;
        }
        MessageDao dao = new MessageDao();
        dao.addMessage(username, content);
        addActionMessage("留言成功！");
        messages = dao.getMessages(order);
        content = "";
        return SUCCESS;
    }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getOrder() { return order; }
    public void setOrder(String order) { this.order = order; }
    public List<Message> getMessages() { return messages; }
    public void setMessages(List<Message> messages) { this.messages = messages; }
} 