package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaticController {
	
	@RequestMapping(value ="/index1", method = RequestMethod.GET)
	public String index1()
	{
		return "index1";
	}
	
	@RequestMapping(value = "/staticPage", method = RequestMethod.GET)
	public String redirect()
	{
		return "redirect:/pages/final.html";
	}
}
