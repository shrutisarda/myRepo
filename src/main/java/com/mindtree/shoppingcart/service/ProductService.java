package com.mindtree.shoppingcart.service;

import java.util.List;

import com.mindtree.shoppingcart.entity.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product findProduct(int productId);

	List<Product> findProductByCategory(String value);

}
