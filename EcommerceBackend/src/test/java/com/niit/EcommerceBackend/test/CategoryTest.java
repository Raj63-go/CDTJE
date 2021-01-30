package com.niit.EcommerceBackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.EcommerceBackend.model.Category;
import com.niit.EcommerceBackend.dao.CategoryDAO;

public class CategoryTest {
	
	private static AnnotationConfigApplicationContext ctx;
	private static CategoryDAO categoryDAO;
	private static Category category;
	
	@BeforeClass
	public static void init() {
		
		ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.EcommerceBackend");
		ctx.refresh();
		
		categoryDAO = (CategoryDAO) ctx.getBean("categoryDAO");
		
		
	}
	@Test
	public void testAddCategory() {
		category =new Category();
		category.setId(1);
		category.setName("Watches");
		category.setDescription("time is good");
		category.setImageURL("one.jpg");
		
		
	}

}
