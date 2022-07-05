package edu.school.cinema.filters;

import edu.school.cinema.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/image"})
public class ImageAccessFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        int index = req.getRequestURI().indexOf("/", 1);
        if (index == -1) {resp.sendRedirect("/profile");}
        else {filterChain.doFilter(servletRequest, servletResponse);}
    }
}
