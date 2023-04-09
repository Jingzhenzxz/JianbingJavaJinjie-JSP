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

        int id = currentUser.getId();
        String newUsername = request.getParameter("username");
        String newPassword = request.getParameter("password");
        String newEmail = request.getParameter("email");
        User newUser = new User(id, newUsername, newPassword, newEmail);

        UserDAO userDao = new UserDAO();
        boolean success = userDao.updateUser(newUser);

        if (success) {
            currentUser.setUsername(newUsername);
            currentUser.setPassword(newPassword);
            currentUser.setEmail(newEmail);
            request.setAttribute("successMessage", "Profile updated successfully.");
        } else {
            request.setAttribute("errorMessage", "Error occurred while updating profile. Please try again.");
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
