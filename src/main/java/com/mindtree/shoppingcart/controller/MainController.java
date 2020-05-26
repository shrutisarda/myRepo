package com.mindtree.shoppingcart.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.shoppingcart.entity.Product;
import com.mindtree.shoppingcart.model.CartInfo;
import com.mindtree.shoppingcart.model.ProductInfo;
import com.mindtree.shoppingcart.service.CartServiceImpl;
import com.mindtree.shoppingcart.service.ProductService;
import com.mindtree.shoppingcart.util.Util;
/**
 * @author M1039449
 *
 */
@Controller
public class MainController {
	private static final Logger LOGGER=LoggerFactory.getLogger(MainController.class);
	@Autowired
	ProductService productService;
	
	@Autowired
	CartServiceImpl cartService;
	

	 // Product List
	   @RequestMapping({ "/products" })
	   public String listProductHandler(Model model) {
	 
	      Iterable<Product> result = productService.getAllProducts();
	      model.addAttribute("products", result);
	      return "products";
	   }
	   
	//search product according to category/ID/Name
	  @RequestMapping({ "/searchProduct" }) public String searchProduct(Model
	  model, @RequestParam(value = "search") String value) {
	  
		Iterable<Product> result = productService.findProductByCategory(value);
		if(!result.iterator().hasNext())
		{
			LOGGER.info("No products found with searched type");
			model.addAttribute("noProductsMessage", "No Product(s) found!!!");
		}
	    model.addAttribute("products", result); 
	    return "products"; 
	    }
	 
	   //Buy product
	   @RequestMapping({ "/buyProduct" })
	   public String listProductHandler(HttpServletRequest request, Model model, //
	         @RequestParam(value = "productId") int productId) {
	 
	      Product product = null;
	      if (productId > 0) {
	         product = productService.findProduct(productId);
	      }
	      if (product != null) {
	 
	         CartInfo cartInfo = Util.getCartInSession(request);
	 
	         ProductInfo productInfo = new ProductInfo(product);
	 
	         cartInfo.addProduct(productInfo, 1);
	      }
	 
	      return "redirect:/shoppingCart";
	   }
	   
	// POST: Update quantity for product in cart
	   @RequestMapping(value = { "/shoppingCart" }, method = RequestMethod.POST)
	   public String shoppingCartUpdateQty(HttpServletRequest request, //
	         Model model, //
	         @ModelAttribute("cartForm") CartInfo cartForm) {
	 
	      CartInfo cartInfo = Util.getCartInSession(request);
	      cartInfo.updateQuantity(cartForm);
	 
	      return "redirect:/shoppingCart";
	   }
	 
	   // GET: Show cart.
	   @RequestMapping(value = { "/shoppingCart" }, method = RequestMethod.GET)
	   public String shoppingCartHandler(HttpServletRequest request, Model model) {
	      CartInfo myCart = Util.getCartInSession(request);
	 
	      model.addAttribute("cartForm", myCart);
	      return "shoppingCart";
	   }
	   
	   @RequestMapping({ "/shoppingCartRemoveProduct" })
	   public String removeProductHandler(HttpServletRequest request, Model model, //
	         @RequestParam(value = "productId") int code) {
	      Product product = null;
	      if (code > 0) {
	         product = productService.findProduct(code);
	      }
	      if (product != null) {
	 
	         CartInfo cartInfo = Util.getCartInSession(request);
	 
	         ProductInfo productInfo = new ProductInfo(product);
	 
	         cartInfo.removeProduct(productInfo);
	 
	      }
	 
	      return "redirect:/shoppingCart";
	   }
	   
	   @RequestMapping(value = { "/shoppingCartConfirmation" }, method = RequestMethod.GET)
	   public String shoppingCartConfirmationReview(HttpServletRequest request, Model model) {
	      CartInfo cartInfo = Util.getCartInSession(request);
	 
	      if (cartInfo == null || cartInfo.isEmpty()) {
	 
	         return "redirect:/shoppingCart";
	      }
	      model.addAttribute("myCart", cartInfo);
	 
	      return "shoppingCartConfirmation";
	   }
	   
	   // POST: Submit Cart (Save)
	   @RequestMapping(value = { "/shoppingCartConfirmation" }, method = RequestMethod.POST)
	 
	   public String shoppingCartConfirmationSave(HttpServletRequest request, Model model) {
	      CartInfo cartInfo = Util.getCartInSession(request);
	 
	      if (cartInfo.isEmpty()) {
	 
	         return "redirect:/shoppingCart";
	      }
	      try {
	    	  LOGGER.info("order placed successfully");
	         cartService.saveOrder(cartInfo);
	      } catch (Exception e) {
	         return "shoppingCartConfirmation";
	      }
	 
	      // Remove Cart from Session.
	      Util.removeCartInSession(request);
	 
	      // Store last cart.
	      Util.storeLastOrderedCartInSession(request, cartInfo);
	 
	      return "redirect:/shoppingCartFinal";
	   }
	 
	   @RequestMapping(value = { "/shoppingCartFinal" }, method = RequestMethod.GET)
	   public String shoppingCartFinalize(HttpServletRequest request, Model model) {
	 
	      CartInfo lastOrderedCart = Util.getLastOrderedCartInSession(request);
	 
	      if (lastOrderedCart == null) {
	         return "redirect:/shoppingCart";
	      }
	      model.addAttribute("lastOrderedCart", lastOrderedCart);
	      return "shoppingCartSuccess";
	   }
}
