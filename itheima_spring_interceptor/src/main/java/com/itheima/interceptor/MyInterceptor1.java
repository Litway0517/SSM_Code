package com.itheima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1 implements HandlerInterceptor {

    // 目标方法执行之前 执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle......");
        String param = request.getParameter("param");
        if (param != null && param.equals("yes")) {
            return true;
        } else {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return false;
        }

        // 返回的false表示后面的请求都资源都不给予访问权限. 即, 后面的流程都不进行流转. true: 表示放行请求.
        // return false;
    }


    // 在目标方法执行之后 视图对象返回之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle......");

        // 修改结果
        assert modelAndView != null;
        modelAndView.addObject("name", "itheima");
    }

    // 在整个流程都执行完毕后 执行 视图返回之后
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion.....");
    }
}
