package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView printHello()
	{
		ModelAndView modelAndView = new ModelAndView("hi");
		modelAndView.addObject("msg", "Hello MVC");
		return modelAndView;
	}
}
