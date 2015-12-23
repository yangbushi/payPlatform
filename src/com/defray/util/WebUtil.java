package com.defray.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

public class WebUtil {

    public static HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    /**
     * @Title: setSessionAttr
     * @Description: 设置seession
     * @param key
     * @param val
     * @return void
     * @throws：
     */

    public static void setSessionAttr(String key, Object val) {
        getRequest().getSession().setAttribute(key, val);
    }

    /**
     * 获取客户端IP
     * @param request
     * @return
     */
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if(StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
