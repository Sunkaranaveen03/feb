package com.example.springboothibernet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan({"com.example.springboothibernet,com.example.springboot.Controller"})

public class Springboothibernet3Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboothibernet3Application.class, args);
	}

}
