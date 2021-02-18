package com.niit.ecommercefrontend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.EcommerceBackend.dao.ProductDAO;
import com.niit.EcommerceBackend.model.Product;

@Controller
@RequestMapping("/json/data")
public class JsonController {
	
	@Autowired
	public ProductDAO productDAO;
	
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		
		
		return productDAO.listActiveProducts();
		
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getAllProductsByCategory(@PathVariable int id){
		
		
		return productDAO.listActiveProductsByCategory(id);
		
	}

}
