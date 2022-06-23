package edu.school.cinema.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "logoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cookie cookie = new Cookie("user_id", "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        session.invalidate();
        resp.sendRedirect("/signIn");
    }
}
