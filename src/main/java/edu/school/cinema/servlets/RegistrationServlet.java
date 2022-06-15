package edu.school.cinema.servlets;

import edu.school.cinema.models.User;
import edu.school.cinema.services.UserService;
import org.springframework.context.ApplicationContext;

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

@WebServlet(name = "registrationServlet", value = "/signUp")
public class RegistrationServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.userService = springContext.getBean("userService", UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("signUp.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("html/text");
        User    user = User.getUser();
        try(PrintWriter printWriter = resp.getWriter()) {
            String  firstName = req.getParameter("first_name");
            user.setFirstName(firstName);
            String  lastName = req.getParameter("last_name");
            user.setLastName(lastName);
            String  phoneNumber = req.getParameter("phone_number");
            user.setPhoneNumber(phoneNumber);
            String  email = req.getParameter("email");
            user.setEmail(email);
            String  password = req.getParameter("password");
            user.setPassword(password);
            userService.save(user);
            if (userService.passwordMatch(password, email))
                resp.sendRedirect("home.html");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
