package com.example.controll;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.example"})
public class DemoApplication {
	
	protected static Logger logger=LoggerFactory.getLogger(DemoApplication.class);  
	  
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
