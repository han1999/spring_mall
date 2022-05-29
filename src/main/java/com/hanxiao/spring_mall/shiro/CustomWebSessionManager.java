package com.hanxiao.spring_mall.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/29
 **/
@Component
public class CustomWebSessionManager extends DefaultWebSessionManager {

    private static final String TOKEN = "X-CskaoyanMarket-Admin-Token";
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String sessionId = httpServletRequest.getHeader(TOKEN);
        if (!StringUtils.isEmpty(sessionId)) {
            return sessionId;
        }
        return super.getSessionId(request, response);
    }
}
