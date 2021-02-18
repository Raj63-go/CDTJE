package com.niit.EcommerceBackend.dao;

import java.util.List;

import com.niit.EcommerceBackend.model.Category;

public interface CategoryDAO {
	
	//method
	
	List<Category> lists();
	
	Category get(int id);
	
	boolean add(Category category);
	
	boolean update(Category category);
	
	boolean delete(Category category);

}
