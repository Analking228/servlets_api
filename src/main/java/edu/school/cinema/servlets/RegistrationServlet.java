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
import javax.servlet.http.HttpSession;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("html/text");
        HttpSession session = req.getSession();
        User    sessionUser = new User();
        try {
            String  firstName = req.getParameter("first_name");
            sessionUser.setFirstName(firstName);
            String  lastName = req.getParameter("last_name");
            sessionUser.setLastName(lastName);
            String  phoneNumber = req.getParameter("phone_number");
            sessionUser.setPhoneNumber(phoneNumber);
            String  email = req.getParameter("email");
            sessionUser.setEmail(email);
            String  password = req.getParameter("password");
            sessionUser.setPassword(password);
            userService.save(sessionUser);
            if (userService.passwordMatch(password, email)) {
                session.setAttribute("user", sessionUser);
                session.setAttribute("name", sessionUser.getFirstName());
                session.setAttribute("last_name", sessionUser.getLastName());
                session.setAttribute("email", sessionUser.getEmail());
            }
            resp.sendRedirect("/profile");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
