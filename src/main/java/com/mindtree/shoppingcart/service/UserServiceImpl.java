package com.mindtree.shoppingcart.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.shoppingcart.dao.UserDao;
import com.mindtree.shoppingcart.entity.User;
/**
 * @author M1039449
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UserServiceImpl.class);
	 @Autowired
	 UserDao userDao;
	 
	 @Override
	 @Transactional
	 public User getUserByEmailAndPassword(String email, String password)
	 {
		 User user = null;
		 try {
			user=userDao.getUserByEmailAndPassword(email, password);
		 }
		 catch(Exception e)
		 {
			 LOGGER.info("User not found!");
		 }
		
		return user;	
		
	 }
}
