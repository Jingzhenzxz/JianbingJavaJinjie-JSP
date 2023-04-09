package com.wuan.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // getSession() 方法返回当前会话，如果当前会话不存在，则创建一个新的会话。
        // invalidate() 方法使会话无效，即注销会话。
        request.getSession().invalidate();
        // sendRedirect() 方法将请求和响应从当前 Servlet 重定向到 /login 页面。
        response.sendRedirect(request.getContextPath() + "/login");
    }
}
