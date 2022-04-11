package com.softwarechaser.springboot.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class controller {
@GetMapping("/")	
public String helloworld()
{
	return "welcome to spring boot aa";
}
}
