package com.codejava.todoapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codejava.todoapp.entity.HelloWorld;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {
	
	@GetMapping("/hello-world")
	public String getHelloWorld() {
		return "Hello-World";
	}

	@GetMapping("/hello-world-bean")
	public HelloWorld getHelloWorldBean() {
	//throw new RuntimeException("Some Error is happened Please Contact to support team");
		return new HelloWorld("Hello-World-from-Hello-World-Bean");
	}
	@GetMapping("/helo-world/path-variable/{name}")
	public HelloWorld gethelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorld(String.format("Hello World, %s", name));
	}
	
}
