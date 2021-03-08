package com.niit.ecommercefrontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.EcommerceBackend.dao.CategoryDAO;
import com.niit.EcommerceBackend.dao.ProductDAO;
import com.niit.EcommerceBackend.model.Category;
import com.niit.EcommerceBackend.model.Product;

@Controller
public class PageController {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	
	
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
	
	@RequestMapping("/show/all/product")
	public ModelAndView products() {
		
		ModelAndView mav= new ModelAndView("page");
		mav.addObject("title", "Products");
		mav.addObject("categories", categoryDAO.lists());
		mav.addObject("userClickProduct",true);
		return mav;
		
		
	}
	
	@RequestMapping("/show/category/{id}/products")
	public ModelAndView showCategory(@PathVariable("id")int id) {
		
		Category category=null;
		
		category= categoryDAO.get(id);
		
		ModelAndView mav= new ModelAndView("page");
		mav.addObject("title", "category");
		mav.addObject("categories", categoryDAO.lists());
		mav.addObject("category",category);
		mav.addObject("userCategoryProduct",true);
		return mav;
		
		
	}
	
	@RequestMapping("/show/{id}/products")
	public ModelAndView showSingleProducts(@PathVariable("id")int id) {
		
		ModelAndView mav= new ModelAndView("page");
		
		Product product=productDAO.get(id);
		product.setViews(product.getViews()+1);
		
		productDAO.update(product);
		
		mav.addObject("title",product.getName());
		mav.addObject("product",product);
		mav.addObject("userClickSingleProducts");
		
		
		return mav;
		
	}


	
}
