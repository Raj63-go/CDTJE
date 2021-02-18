package com.niit.EcommerceBackend.dao;

import java.util.List;


import com.niit.EcommerceBackend.model.User;

public interface UserDAO {
	User get(int userId);
	
	List<User> lists();
	
	boolean add(User user);
	
	boolean update(User user);
	
	boolean delete(User user);

}
