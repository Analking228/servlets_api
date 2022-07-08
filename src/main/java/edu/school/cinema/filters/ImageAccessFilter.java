package edu.school.cinema.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/image"})
public class ImageAccessFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        int index = req.getRequestURI().indexOf("/", 1);
        String method = req.getMethod();
        if (index == -1 && method.equals("GET")) {resp.sendRedirect("/profile");}
        else {filterChain.doFilter(servletRequest, servletResponse);}
    }
}
