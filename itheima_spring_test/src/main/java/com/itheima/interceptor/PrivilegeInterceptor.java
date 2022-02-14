package com.itheima.interceptor;

import com.itheima.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrivilegeInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        // 判断session域中是否存在用户
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            // 跳转到登陆界面
            resp.sendRedirect( req.getContextPath() + "/login.jsp");
            return false;
        }

        // 放行
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
