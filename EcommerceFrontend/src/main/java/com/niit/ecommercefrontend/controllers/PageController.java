package com.niit.ecommercefrontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView display() {
		
		ModelAndView mav= new ModelAndView("page");
		mav.addObject("Rajesh", "nyc to meet");
		return mav;
		
		
	}
	
	

	
}
