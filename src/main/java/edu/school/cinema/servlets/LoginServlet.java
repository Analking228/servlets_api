package edu.school.cinema.servlets;

import edu.school.cinema.config.ApplicationConfig;
import edu.school.cinema.models.User;
import edu.school.cinema.repositories.UserRepositoryImpl;
import edu.school.cinema.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet(name = "loginServlet", value = "/signIn")
public class LoginServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(
                ApplicationConfig.class
        );
        this.userService = springContext.getBean("userService", UserService.class);
    }

    @Override
    protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("signIn.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter printWriter = resp.getWriter()){
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            if (userService.passwordMatch(password, email)) {
                resp.sendRedirect("home.html");
            }
            else {
                printWriter.write("wrong email or password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
