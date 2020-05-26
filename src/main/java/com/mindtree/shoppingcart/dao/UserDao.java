package com.mindtree.shoppingcart.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcart.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {

	User getUserByEmailAndPassword(String email, String password);

}
