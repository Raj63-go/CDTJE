package com.niit.EcommerceBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcommerceBackend.dao.ProductDAO;

import com.niit.EcommerceBackend.model.Product;



public class ProductTest {
	
	private static AnnotationConfigApplicationContext ct;
	
	private static ProductDAO productDAO;
	
	private static Product product;
	
	@BeforeClass
	public static void init() {
		
		ct= new AnnotationConfigApplicationContext();
		ct.scan("com.niit.EcommerceBackend");
		ct.refresh();
		
		productDAO =(ProductDAO) ct.getBean("productDAO");
		
	}
	
	@Test
	public void testAddProduct() {
		product = new Product();
		
		
		product.setName("Boat headphone");
		product.setBrand("Boat");
		product.setActive(true);
		product.setQuantity(1);
		product.setCategoryId(3);
		product.setDescription("It's a brand new headphone");
		product.setUnitPrice("2000");
		product.setSupplierId(2);
		
		
		
		
		assertEquals("product added successfully",true,productDAO.add(product));
	}
	@Ignore
	@Test
	public void testGetProduct() {
		product= productDAO.get(2);
		
		assertEquals("product successfully retrieved","Xiomi Redmi",product.getName());

		
	}
	@Ignore
	@Test
	public void testListProduct() {
		product= productDAO.get(2);
		
		assertEquals("data retrieved",2,productDAO.list().size());

		
	}
	@Ignore
	@Test
	public void testUpdateProduct() {
		product= productDAO.get(2);
		
		
		
		product.setName("Acer Laptop");
		product.setBrand("Acer");
		product.setActive(true);
		product.setQuantity(3);
		
		product.setDescription("It's a brand new laptop");
		product.setUnitPrice("200000");
		
		
		
		assertEquals("product updated successfully",true,productDAO.update(product));
		
		
	}
	@Ignore
	@Test
	public void testDeleteCategory() {
		product= productDAO.get(3);
		
		
		
		assertEquals("product deleted successfully",true,productDAO.delete(product));
		
		
	}
	
	@Ignore
	@Test
	public void testlistActiveProducts() {
		
		assertEquals("active product fetched successfully",5,productDAO.listActiveProducts().size());
		
	}
	
	@Ignore
	@Test
	public void testlistActiveProductsByCategory() {
		
		assertEquals("active products by category retrieved",4,productDAO.listActiveProductsByCategory(3).size());
	}
	
	@Ignore
	@Test
	public void testgetLatestProducts() {
		assertEquals("latest products",1,productDAO.getLatestProducts(1).size());
	}
	
	


}
