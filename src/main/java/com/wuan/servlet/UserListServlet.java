package com.wuan.servlet;

import com.wuan.dao.UserDAO;
import com.wuan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserListServlet", urlPatterns = {"/userlist"})
public class UserListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDao = new UserDAO();
        List<User> users = userDao.getAllUsers();

        request.setAttribute("userList", users);
        request.getRequestDispatcher("/userlist.jsp").forward(request, response);
    }
}
