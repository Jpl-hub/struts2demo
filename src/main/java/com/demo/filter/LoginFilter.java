package com.demo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) {}
    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String uri = req.getRequestURI();
        // 只拦截welcome.jsp
        if (uri.contains("welcome.jsp")) {
            if (session == null || session.getAttribute("username") == null) {
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
                return;
            }
        }
        chain.doFilter(request, response);
    }
} 