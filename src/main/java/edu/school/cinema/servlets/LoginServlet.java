package edu.school.cinema.servlets;

import edu.school.cinema.models.User;
import edu.school.cinema.services.UserService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "loginServlet", value = "/signIn")
public class LoginServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.userService = springContext.getBean("userService", UserService.class);
    }

    @Override
    protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User    sessionUser = (User) session.getAttribute("user");
        if (sessionUser != null) resp.sendRedirect("profile.jsp");
        else req.getRequestDispatcher("signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User sessionUser = (User) req.getAttribute("user");
        if (sessionUser == null || sessionUser.getEmail().equals(req.getParameter("email"))) {
            try {
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                if (userService.findByEmail(email)) {
                    User user = userService.findObjByEmail(email);
                    if (userService.passwordMatch(password, email)) {
                        session.setAttribute("user", user);
                        Cookie userName = new Cookie("user_name", user.getFirstName());
                        session.setAttribute("name", user.getFirstName());
                        session.setAttribute("last_name", user.getLastName());
                        session.setAttribute("email", user.getEmail());
                        resp.addCookie(userName);
                        resp.sendRedirect("profile.jsp");
                    } else {
                        resp.sendRedirect(req.getContextPath() + "signIn");
                    }
                } else {
                    resp.sendRedirect(req.getContextPath() + "signIn");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
