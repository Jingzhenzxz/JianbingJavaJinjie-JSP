package com.wuan.servlet;

import com.wuan.dao.UserDAO;
import com.wuan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        User currentUser = (User) request.getSession().getAttribute("currentUser");
        int id = currentUser.getId();

        UserDAO userDao = new UserDAO();
        boolean success = userDao.deleteUser(id);
        if (success) {
            // invalidate() 方法使当前会话无效，并解除与该会话绑定的任何对象。
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            request.setAttribute("errorMessage", "Error occurred while deleting. Please try again.");
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        }
    }
}