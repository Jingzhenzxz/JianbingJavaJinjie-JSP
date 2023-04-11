package com.wuan.servlet;

import com.wuan.dao.UserDAO;
import com.wuan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = {"/register"})
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get 方法请求注册页面，直接转发到 register.jsp 页面。
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Post 方法提交注册表单，获取表单中的用户名、密码和邮箱。
        // request 中包含了客户端的所有请求信息，包括请求头和请求体。
        // request.getParameter() 方法返回请求参数的值，如果请求中没有该参数，则返回 null。
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // 实例化 UserDAO 对象，用于访问数据库。
        UserDAO userDao = new UserDAO();
        // findUserByUsername() 方法返回指定用户名的用户，如果没有找到该用户，则返回 null。
        User existingUser = userDao.findUserByUsername(username);

        // 如果用户已存在，则将错误信息设置到 request 中，并转发到注册页面。
        if (existingUser != null) {
            request.setAttribute("errorMessage", "Username already exists.");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } else {
            // 如果用户不存在，则创建新用户，并将用户信息设置到 session 中，并重定向到用户个人主页。
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);

            // createUser() 方法返回 true 表示创建成功，否则返回 false。
            boolean success = userDao.createUser(user);
            if (success) {
                // 如果成功，则将用户信息设置到 session 中，并重定向到用户个人主页。
                // request.getSession().setAttribute() 方法与 request.setAttribute() 方法类似，
                // 但是它将属性设置到当前会话中，而不是设置到请求中。
                // 会话属性更适合存储需要在整个会话中跟踪的信息，而请求属性适合存储仅在当前请求中需要的信息。
                request.getSession().setAttribute("currentUser", user);
                request.setAttribute("successMessage", "Registration successful.");
                response.sendRedirect(request.getContextPath() + "/profile");
//                request.getRequestDispatcher("/profile").forward(request, response);
//                这行代码会报错“此URL不支持Http方法POST”，因为这行代码在转发时会保持原来的请求方法，即Post方法，
//                但UserProfileServlet中不支持Post方法。使用sendRedirect时，浏览器会发起一个新的GET请求，因此不会出现错误。
            } else {
                // 如果失败，则将错误信息设置到 request 中，并转发到注册页面。
                request.setAttribute("errorMessage", "Error occurred while registering. Please try again.");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        }
    }
}
