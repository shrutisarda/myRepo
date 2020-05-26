package com.mindtree.shoppingcart.service;


import com.mindtree.shoppingcart.entity.User;

public interface UserService {
	User getUserByEmailAndPassword(String email, String password);

}
