package com.niit.ecommercefrontend.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.multipart.MultipartFile;
import com.niit.EcommerceBackend.dao.CategoryDAO;
import com.niit.EcommerceBackend.dao.ProductDAO;
import com.niit.EcommerceBackend.model.Category;
import com.niit.EcommerceBackend.model.Product;
import com.niit.ecommercefrontend.util.FileUtil;

@Controller
@RequestMapping("/manage")
public class ManageController {

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;

	private static final Logger logger = LoggerFactory.getLogger(ManageController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView manageProducts(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Product Management");
		mav.addObject("userClickManageProducts", true);

		Product np = new Product();
		np.setSupplierId(1);
		np.setActive(true);

		mav.addObject("product", np);

		if (operation != null) {

			if (operation.equals("product")) {

				mav.addObject("message", "Product submitted succesfully!!");

			}
			else if(operation.equals("category")) {
				mav.addObject("message","Category Submitted Successfully!!");
			}

		}

		return mav;
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String transmissionProduct(@Valid @ModelAttribute("product") Product np, BindingResult results, Model model,
			HttpServletRequest request) {

		if (np.getId() == 0) {
			// new ProductValidator()
		}

		if (results.hasErrors()) {

			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Product Management");
			model.addAttribute("message", "Validation Failed");

			return "page";

		}
		
		if(np.getId()==0) {
			
			productDAO.add(np);
		}
		
		else {
			productDAO.update(np);
		}
		

		productDAO.add(np);

		if (!np.getFile().getOriginalFilename().equals("")) {
			FileUtil.uploadFile(request, np.getFile(), np.getCode());
		}
		//
		//

		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value="/{id}/products",method=RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable int id) {
		ModelAndView mav=new ModelAndView("page");
		mav.addObject("title","Product Management");
		mav.addObject("userClickManageProducts", true);
		Product np = productDAO.get(id);
		mav.addObject("product",productDAO.get(id));
		
		return mav;
		
	}

	
	
	@RequestMapping(value = "/products/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String ActivationProducts(@PathVariable int id) {
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		product.setActive(!product.isActive());
		productDAO.update(product);

		return (isActive) ? "Product Deactivated Successfully" : "Product activated Successfully";

	}

	@ModelAttribute("categories")
	public List<Category> modelCategories() {

		return categoryDAO.lists();
	}
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category)
	{
		categoryDAO.add(category);
		return "redirect:/manage/products?operation";
	}
}
