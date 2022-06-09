package edu.school.cinema.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("edu.school.cinema")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
}
