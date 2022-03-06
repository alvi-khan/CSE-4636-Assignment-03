package com.example.lab03_assignment;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(urlPatterns = "/homepage.jsp", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class HomepageFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setAttribute("items", Database.getItems());
        chain.doFilter(request, response);
    }
}
