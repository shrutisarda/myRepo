package com.mindtree.shoppingcart.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mindtree.shoppingcart.entity.Product;

@Transactional
public interface ProductDao extends CrudRepository<Product, Integer>{


	Product findProductByIdOrName(int productId, String producName);

	@Query(
			  value = "SELECT * FROM products p  WHERE p.category = ?1 or p.name= ?1 or p.id= ?1", 
			  nativeQuery = true)
	List<Product> findByCategory(String value);


}
