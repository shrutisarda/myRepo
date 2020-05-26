package com.mindtree.shoppingcart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.shoppingcart.entity.User;
import com.mindtree.shoppingcart.model.CartInfo;
import com.mindtree.shoppingcart.service.UserService;
import com.mindtree.shoppingcart.util.Util;
/**
 * @author M1039449
 *
 */
@Controller
@Transactional
public class LoginController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserService userService;
	
	  // GET: Show Login Page
	   @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	   public String login(Model model) {
	 
	      return "login";
	   }
	 
	   @RequestMapping(value = { "/welcome" }, method = RequestMethod.POST)
	   public String welcome(HttpServletRequest request,Model model,  @ModelAttribute("user") User user) {
		  CartInfo cartInfo = Util.getCartInSession(request);
	      User userDetails =  userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
	      if(userDetails!=null)
	      {
	    	  LOGGER.info("Welcome.."+userDetails.getUserName());
	    	  cartInfo.setUser(userDetails);
	    	  model.addAttribute("userDetails", userDetails);
		      return "welcome";
	      }
	      else
	    	  model.addAttribute("message", "Incorrect Credentials!!!");
	      	  LOGGER.info("Incorrect Credentials");
	    	  return "login";
	 
	   }
	 

}
