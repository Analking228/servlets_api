package edu.school.cinema.servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "showImageServlet", value = "/image/*")
public class ShowImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String filename = req.getRequestURI().substring(req.getRequestURI().indexOf("/", 1) + 1);
        resp.setContentType("image/jpeg");
        FileInputStream fis = new FileInputStream("/Users/penetrator3000/Documents/42coding/Java/Spring/Cinema/src/main/resources/application.properties");
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
}
