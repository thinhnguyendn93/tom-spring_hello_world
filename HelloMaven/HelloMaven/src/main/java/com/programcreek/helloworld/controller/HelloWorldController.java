package com.programcreek.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	String message = "Welcome to Spring MVC!";
	@RequestMapping(value = "/hello")
	public ModelAndView showMessage(@RequestParam(value = "name",required = false, defaultValue = "World") String name)
	{
		System.out.println("in Controller");
		ModelAndView md = new ModelAndView("hello");
		md.addObject("message", message);
		md.addObject("name", name);
		return md;
	}
}
