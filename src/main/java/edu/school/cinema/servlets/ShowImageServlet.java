package edu.school.cinema.servlets;

import edu.school.cinema.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.Properties;

@WebServlet(name = "showImageServlet", urlPatterns = {"/images", "/images/*"})
@MultipartConfig(maxFileSize = 1024*1024*5) // 5Mb
public class ShowImageServlet extends HttpServlet {

    private final String pathToProperties = "src/main/resources/application.properties";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String filename = req.getRequestURI().substring(req.getRequestURI().indexOf("/", 1) + 1);
        resp.setContentType("image/jpeg");
        FileInputStream fis = new FileInputStream(pathToProperties);
        Properties property = new Properties();
        property.load(fis);
        try(
                ServletOutputStream out = resp.getOutputStream();
                FileInputStream fin = new FileInputStream(property.getProperty("images.upload.path") + filename);
                BufferedInputStream bin = new BufferedInputStream(fin);
                BufferedOutputStream bout = new BufferedOutputStream(out)
        ) {
            int ch;
            while ((ch = bin.read()) != -1) {bout.write(ch);}
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");
        HttpSession session = req.getSession();
        User user  = (User)session.getAttribute("user");
        Part filePart = req.getPart("file");

        FileInputStream fis = new FileInputStream(pathToProperties);
        Properties property = new Properties();
        property.load(fis);
        File pathToPic = new File(property.getProperty("images.upload.path") + session.getAttribute("id"));

        String fileName = filePart.getSubmittedFileName();
        try{
            for (Part part : req.getParts()) {
                part.write(pathToPic + File.separator + fileName);
                session.setAttribute("defaultAvatar", session.getAttribute("id") + "/" + fileName);
            }
        } catch (Exception ignored){}
        req.getSession().setAttribute("pathImages", pathToPic);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/profile.jsp");
        dispatcher.forward(req, resp);
    }
}
