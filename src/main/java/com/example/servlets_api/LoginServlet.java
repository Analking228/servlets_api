package com.example.servlets_api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter printWriter = resp.getWriter()){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if (username.equals("loler228") && password.equals("aye1337")) {
                resp.sendRedirect("home.html");
            }
            else {
                printWriter.write("wrong username or password");
            }
        }
    }
}
