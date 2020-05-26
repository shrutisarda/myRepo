package com.mindtree.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.shoppingcart.dao.CartDao;
import com.mindtree.shoppingcart.dao.UserDao;
import com.mindtree.shoppingcart.entity.Cart;
import com.mindtree.shoppingcart.entity.Product;
import com.mindtree.shoppingcart.entity.User;
import com.mindtree.shoppingcart.model.CartInfo;
import com.mindtree.shoppingcart.model.CartLineInfo;

@Service
public class CartServiceImpl implements CartService{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CartServiceImpl.class);

	@Autowired
	CartDao cartDao;
	
	@Autowired 
	ProductService productService;
	
	@Autowired
	UserDao userDao;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveOrder(CartInfo cartInfo) {
		
		try {		
		Cart cart = new Cart();
		User user= cartInfo.getUser();
		user.setCart(cart);
		cart.setUserDetails(user);
		cart.setAmount(cartInfo.getAmountTotal());
        List<CartLineInfo> lines = cartInfo.getCartLines();
        List<Product> productList= new ArrayList<Product>();
        for (CartLineInfo line : lines) {
			int id = line.getProductInfo().getId();
			Product product = this.productService.findProduct(id);
			product.setQuantity(line.getQuantity());
			productList.add(product);
			cart.setProduct(productList);
			LOGGER.info("products adding!!!");
				
	}
        cartDao.save(cart);
        userDao.save(user);
	
	}catch(Exception e)
	{
		LOGGER.info("Problem while saving product to cart.");
	}
	
	}
}
