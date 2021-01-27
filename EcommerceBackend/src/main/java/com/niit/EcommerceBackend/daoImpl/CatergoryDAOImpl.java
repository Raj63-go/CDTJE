package com.niit.EcommerceBackend.daoImpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.EcommerceBackend.model.Category;
import com.niit.EcommerceBackend.dao.CategoryDAO;


@Repository("categoryDAO")
public class CatergoryDAOImpl implements CategoryDAO{
	
	
	
	
	
	private static List<Category> categories= new ArrayList<>();
	
	static {
	Category cat= new Category();
	cat.setId(1);
	cat.setName("Watches");
	cat.setDescription("time is good");
	cat.setImageURL("one.jpg");
	categories.add(cat);
	
	cat=new Category();
	cat.setId(2);
	cat.setName("Cameras");
	cat.setDescription("nice pic");
	cat.setImageURL("two.jpg");
	categories.add(cat);
	
	cat=new Category();
	cat.setId(3);
	cat.setName("Shoes");
	cat.setDescription("good swag");
	cat.setImageURL("third.jpg");
	categories.add(cat);
	
	
	}
	
	

	@Override
	public List<Category> lists() {
		// TODO Auto-generated method stub
		return categories;
	}



	@Override
	public Category get(int id) {
		
		for(Category category:categories) {
			if(category.getId()==id){
				return category;
			}
		}
		
		return null;
	}
	
	
	
	
}
