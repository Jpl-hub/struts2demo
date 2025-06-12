package com.demo.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.dispatcher.HttpParameters;
import java.util.Arrays;
import java.util.List;

public class BlacklistInterceptor extends AbstractInterceptor {
    // 假设黑名单用户名列表
    private static final List<String> BLACKLIST = Arrays.asList("baduser", "testblack");

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        HttpParameters params = (HttpParameters) ActionContext.getContext().getParameters();
        String username = null;
        if (params.contains("username")) {
            username = params.get("username").getValue();
        }
        if (username != null && BLACKLIST.contains(username)) {
            ActionContext.getContext().put("blacklistMsg", "该用户已被列入黑名单，禁止登录。");
            return "blacklist";
        }
        return invocation.invoke();
    }
} 