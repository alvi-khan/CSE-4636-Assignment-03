package com.example.lab03_assignment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartBean cartBean = (CartBean) request.getSession().getAttribute("cart");
        if (request.getParameter("+") != null) {
            int itemID = Integer.parseInt(request.getParameter("+"));
            Item item = Database.getItem(itemID);
            cartBean.addItem(item);
        }
        else {
            int itemID = Integer.parseInt(request.getParameter("-"));
            Item item = Database.getItem(itemID);
            cartBean.removeItem(item);
        }
        response.sendRedirect(request.getHeader("referer"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
