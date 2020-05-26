package com.mindtree.shoppingcart.dao;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.shoppingcart.entity.Cart;

public interface CartDao extends CrudRepository<Cart, Integer>{

}
