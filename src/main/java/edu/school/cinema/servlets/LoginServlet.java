package edu.school.cinema.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "loginServlet", value = "/loginIn")
public class LoginServlet extends HttpServlet {

    @Override
    protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("jsp/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter printWriter = resp.getWriter()){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if (username.equals("loler228") && password.equals("aye1337")) {
                resp.sendRedirect("html/home.html");
            }
            else {
                printWriter.write("wrong username or password");
            }
        }
    }
}
