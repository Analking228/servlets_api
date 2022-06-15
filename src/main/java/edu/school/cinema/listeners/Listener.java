package edu.school.cinema.listeners;

import edu.school.cinema.config.ApplicationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    /* This method is called when the servlet context is initialized(when the Web application is deployed). */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Servlet listener started");
        sce.getServletContext()
                .setAttribute("springContext", new AnnotationConfigApplicationContext(ApplicationConfig.class));
    }
}
