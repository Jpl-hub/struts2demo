package com.demo.action;

import com.demo.dao.CommentDao;
import com.demo.model.Comment;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommentAction extends ActionSupport {
    private int score;
    private String content;
    private String order = "desc";
    private List<Comment> comments;

    public String execute() {
        CommentDao dao = new CommentDao();
        comments = dao.getComments(order);
        return SUCCESS;
    }

    public String add() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            addActionError("请先登录！");
            return INPUT;
        }
        if (score < 1 || score > 5) {
            addFieldError("score", "评分必须在1-5之间");
            return INPUT;
        }
        CommentDao dao = new CommentDao();
        dao.addComment(username, score, content);
        addActionMessage("评价成功！");
        comments = dao.getComments(order);
        content = "";
        score = 0;
        return SUCCESS;
    }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getOrder() { return order; }
    public void setOrder(String order) { this.order = order; }
    public List<Comment> getComments() { return comments; }
    public void setComments(List<Comment> comments) { this.comments = comments; }
} 