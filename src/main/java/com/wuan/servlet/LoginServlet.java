package com.wuan.servlet;

import com.wuan.dao.UserDAO;
import com.wuan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // request.getParameter() 方法返回请求参数的值，如果请求中没有该参数，则返回 null。
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 实例化 UserDAO 对象，用于访问数据库。
        UserDAO userDao = new UserDAO();
        // findUserByUsername() 方法返回指定用户名的用户，如果没有找到该用户，则返回 null。
        User user = userDao.findUserByUsername(username);

        // 如果用户存在且密码正确，则将用户信息设置到 session 中，并重定向到用户个人主页。
        if (user != null && user.getPassword().equals(password)) {
            // getSession() 方法返回当前会话，如果当前会话不存在，则创建一个新会话。
            request.getSession().setAttribute("currentUser", user);
            request.setAttribute("successMessage", "Login successfully.");
            // getContextPath() 方法返回当前 Web 应用的上下文路径，即 /wuan。
            response.sendRedirect(request.getContextPath() + "/profile");
        } else {
            // 如果用户不存在或密码错误，则将错误信息设置到 request 中，并转发到登录页面。
            request.setAttribute("errorMessage", "Invalid username or password.");
            // forward() 方法将请求和响应从当前 Servlet 转发到 login.jsp 文件。
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
