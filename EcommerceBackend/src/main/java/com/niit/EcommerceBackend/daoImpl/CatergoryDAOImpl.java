package com.niit.EcommerceBackend.daoImpl;


import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.EcommerceBackend.dao.CategoryDAO;
import com.niit.EcommerceBackend.model.Category;


@Repository("categoryDAO")
@Transactional
public class CatergoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> lists() {
		String listCategory="FROM Category where active =:active";
		Query query= sessionFactory.getCurrentSession().createQuery(listCategory);
		query.setParameter("active", true);
		
		
		return query.getResultList();
	}



	@Override
	public Category get(int id) {
		
		
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}



	@Override
	public boolean add(Category category) {
		
		
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
		
	}



	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
	}



	@Override
	public boolean delete(Category category) {
		try {
			category.setActive(false);
			return this.update(category);
		}
		catch(Exception e){
			e.printStackTrace();
			
			
		}
		return false;
	}
	
	
	
	
}
