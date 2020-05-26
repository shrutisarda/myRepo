package com.mindtree.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.shoppingcart.dao.ProductDao;
import com.mindtree.shoppingcart.entity.Product;
import com.mindtree.shoppingcart.exceptions.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductDao productDao;
	

	@Override
	@Transactional(readOnly = true)
	public List<Product> getAllProducts() {
	
		return (List<Product>) productDao.findAll();
	}

	@Override
	@Transactional
	public Product findProduct(int productId) {
		return productDao.findById(productId).get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findProductByCategory(String value) {
		List<Product> products= new ArrayList<Product>();
		try {
		products=productDao.findByCategory(value);
		if(products.isEmpty()) 
			throw new ProductNotFoundException("Product with value "+value);
		
		}
		catch(Exception e)
		{
			LOGGER.info("Product not found");
		}
		return products;
	}
	
	
	
	

}
