package com.overone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
@ComponentScan
public class ApplicationContextConfiguration {

    @Bean
    @Scope("singleton")
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/user_product",
                    "root", "111QAZwsx");
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}
