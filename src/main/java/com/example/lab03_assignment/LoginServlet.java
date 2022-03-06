package com.example.lab03_assignment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    String username = "user";
    String password = "1234";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (!(username.equals(this.username) && password.equals(this.password))) {
            request.setAttribute("errorMessage", "Invalid Credentials");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        else {
            request.getSession().setAttribute("user", username);
            request.getSession().setAttribute("cart", new CartBean());
            response.sendRedirect("homepage.jsp");
        }
    }
}