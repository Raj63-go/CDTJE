package com.niit.ecommercefrontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView display() {
		
		ModelAndView mav= new ModelAndView("page");
		mav.addObject("title", "Home");
		mav.addObject("userClickHome",true);
		return mav;
		
		
	}
	
	@RequestMapping("/about")
	public ModelAndView about() {
		
		ModelAndView mav= new ModelAndView("page");
		mav.addObject("title", "About Us");
		mav.addObject("userClickAbout",true);
		return mav;
		
		
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact() {
		
		ModelAndView mav= new ModelAndView("page");
		mav.addObject("title", "Contact");
		mav.addObject("userClickContact",true);
		return mav;
		
		
	}
	
	@RequestMapping("/register")
	public ModelAndView register() {
		
		ModelAndView mav= new ModelAndView("page");
		mav.addObject("title", "Register");
		mav.addObject("userClickRegister",true);
		return mav;
		
		
	}

	
}
