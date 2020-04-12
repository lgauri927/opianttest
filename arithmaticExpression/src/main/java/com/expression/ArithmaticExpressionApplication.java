package com.expression;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ArithmaticExpressionApplication extends SpringBootServletInitializer{ 
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ArithmaticExpressionApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ArithmaticExpressionApplication.class, args);
	}
	
}
