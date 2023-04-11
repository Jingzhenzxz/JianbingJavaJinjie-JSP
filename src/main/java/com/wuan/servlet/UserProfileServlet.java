package com.wuan.servlet;

import com.wuan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserProfileServlet", urlPatterns = {"/profile"})
public class UserProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         /*
            request 中包含了客户端的所有请求信息，包括请求头和请求体。
            getSession() 方法返回当前会话，如果当前会话不存在，则创建一个新的会话。
            getAttribute() 方法返回指定名称的属性值，如果没有找到该属性，则返回 null。
         */
        User currentUser = (User) request.getSession().getAttribute("currentUser");

        if (currentUser != null) {
            // 如果用户已登录，则将用户信息设置到 request 中，并转发到 profile.jsp 页面。
            request.setAttribute("user", currentUser);

            // getRequestDispatcher() 方法返回一个 RequestDispatcher 对象，表示在 Web 应用程序中的特定资源，即 /profile.jsp。
            // RequestDispatcher 对象的 forward() 方法将请求和响应从当前 Servlet 转发到 profile.jsp 文件。
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        } else {
            // 如果用户未登录，则重定向到登录页面。
            // getContextPath() 方法返回当前 Web 应用的上下文路径，即 /wuan。
            request.setAttribute("errorMessage", "Please login first.");
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
