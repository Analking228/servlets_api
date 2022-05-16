import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/hello")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        Integer visitCounter = (Integer) session.getAttribute("visitCounter");
        visitCounter = (visitCounter == null) ? 1 : (visitCounter + 1);
        session.setAttribute("visitCounter", visitCounter);
        String username = req.getParameter("username");
        resp.setContentType("text/html");
        try (PrintWriter printWriter = resp.getWriter()) {
            if (username != null)
                printWriter.write("Hello Mr. " + username + "<br>");
            else
                printWriter.write("Hello Mr. Anonymous <br>");
            printWriter.write("Page was visited " + visitCounter + " times");
        }
    }
}
