package com.wuan.servlet;

import com.wuan.dao.UserDAO;
import com.wuan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateProfileServlet", urlPatterns = {"/updateProfile"})
public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User currentUser = (User) request.getSession().getAttribute("currentUser");

        if (currentUser == null) {
            request.setAttribute("errorMessage", "Please login first.");
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        int currentUserId = currentUser.getId();
        String currentUsername = currentUser.getUsername();
        String currentPassword = currentUser.getPassword();
        String currentEmail = currentUser.getEmail();
        String newUsername = request.getParameter("username");
        String newPassword = request.getParameter("password");
        String newEmail = request.getParameter("email");

        boolean unchanged = newUsername.equals(currentUsername) && newPassword.equals(currentPassword)
                && newEmail.equals(currentEmail);

        if (unchanged) {
            request.getSession().setAttribute("currentUser", currentUser);
            response.sendRedirect(request.getContextPath() + "/profile");
            // 这里不能写 request.getRequestDispatcher("/profile.jsp").forward(request, response);，因为那样会重定向到
            // profile.jsp 文件，而该文件的表单的 action 属性被设置为了 "updateProfile"，
            // 这意味着表单提交后会导航到 "/updateProfile" 这个 URL。
        } else {
            User newUser = new User(currentUserId, newUsername, newPassword, newEmail);
            UserDAO userDao = new UserDAO();
            boolean success = userDao.updateUser(newUser);
            if (success) {
                request.setAttribute("successMessage", "Profile updated successfully.");
                if (!newPassword.equals(currentPassword)) {
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                } else {
                    request.getSession().setAttribute("currentUser", newUser);
                    response.sendRedirect(request.getContextPath() + "/profile");
                    // 这里不能写 request.getRequestDispatcher("/profile.jsp").forward(request, response);，因为那样会重定向到
                    // profile.jsp 文件，而该文件的表单的 action 属性被设置为了 "updateProfile"，
                    // 这意味着表单提交后会导航到 "/updateProfile" 这个 URL。
                }
            } else {
                request.setAttribute("errorMessage", "Error occurred while updating profile. Please try again.");
                response.sendRedirect(request.getContextPath() + "/profile");
                // 这里不能写 request.getRequestDispatcher("/profile.jsp").forward(request, response);，因为那样会重定向到
                // profile.jsp 文件，而该文件的表单的 action 属性被设置为了 "updateProfile"，
                // 这意味着表单提交后会导航到 "/updateProfile" 这个 URL。
            }
        }
    }
}
