package com.example.wj.interceptor;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor  implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //放行options 请求，否则无法让前端带上自定义的 header 信息，导致 sessionID 改变， shiro 验证失败
        if (HttpMethod.OPTIONS.toString().equals(httpServletRequest.getMethod())){
            httpServletResponse.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }
        Subject subject = SecurityUtils.getSubject();
        System.out.println("登录拦截器这里"+subject.getPrincipals().toString());

        //使用 shiro 验证
        System.out.println(subject.isRemembered());
        System.out.println(subject.isAuthenticated());
        if(!subject.isAuthenticated() && !subject.isRemembered()){
            return false;
        }
        return true;

//        HttpSession session = httpServletRequest.getSession();
//        String contextPath = session.getServletContext().getContextPath();
//        String[] requireAuthPages = new String[]{
//                "index",
//        };
//
//        String uri = httpServletRequest.getRequestURI();
//
//        uri = StringUtils.remove(uri, contextPath + "/");
//        String page = uri;
//
//        if (begingWith(page, requireAuthPages)) {
//            User user = (User) session.getAttribute("user");
//            if (user == null) {
//                httpServletResponse.sendRedirect("login");
//                return false;
//            }
//        }
//        return true;
    }

    private boolean begingWith(String page, String[] requiredAuthPages) {
        boolean result = false;
        for (String requiredAuthPage : requiredAuthPages) {
            if (StringUtils.startsWith(page, requiredAuthPage)) {
                result = true;
                break;
            }
        }
        return result;
    }
}