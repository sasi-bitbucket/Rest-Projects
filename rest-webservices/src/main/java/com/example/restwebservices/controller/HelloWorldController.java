package com.example.restwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.restwebservices.bean.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello-world")
	public String getString() {
		return "Hello World";
	}

	@GetMapping("/hello-world-bean")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping("/hello-world-bean/{name}")
	public HelloWorldBean getPathVariable(@PathVariable("name") String name) {
		return new HelloWorldBean("Hello "+ name);
	}
}
