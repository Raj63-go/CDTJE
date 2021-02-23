package com.niit.EcommerceBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcommerceBackend.dao.CategoryDAO;
import com.niit.EcommerceBackend.model.Category;

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
		
		category.setName("Tablets");
		category.setDescription("see things in bigger view");
		category.setImageURL("one.jpg");
		
		assertEquals("category added successfully",true,categoryDAO.add(category));
		
		
	}
	@Ignore
	@Test
	public void testGetCategory() {
		category= categoryDAO.get(3);
		
		assertEquals("category successfully retrieved","Headphone",category.getName());

		
	}
	@Ignore
	@Test
	public void testListCategory() {
		category= categoryDAO.get(2);
		
		assertEquals("data retrieved",5,categoryDAO.lists().size());

		
	}
	@Ignore
	@Test
	public void testUpdateCategory() {
		category= categoryDAO.get(5);
		
		//category =new Category();
		//category.setId(1);
		category.setName("Camera");
		//category.setDescription("time is good camera");
		
		
		assertEquals("category updated successfully",true,categoryDAO.update(category));
		
		
	}
	@Ignore
	@Test
	public void testDeleteCategory() {
		category= categoryDAO.get(3);
		
		
		
		assertEquals("category deleted successfully",true,categoryDAO.delete(category));
		
		
	}

}
