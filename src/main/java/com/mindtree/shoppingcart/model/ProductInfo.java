package com.mindtree.shoppingcart.model;

import com.mindtree.shoppingcart.entity.Apparel;
import com.mindtree.shoppingcart.entity.Book;
import com.mindtree.shoppingcart.entity.Product;

public class ProductInfo {
	
	    private int id;
	    private String name;
	    private float price;
	
	    private String genre;
	    private String author;
	    private String publications;
	    
	    private String type;
	    private String brand;
	    private String design;
	 
	 
	    public ProductInfo() {
	    }
	    
	    public ProductInfo(Product product, Book book, Apparel apparel) {
	        this.id = product.getProductId();
	        this.name = product.getProductName();
	        this.price = product.getPrice();
		
		  this.author=book.getAuthor();
		  this.genre=book.getGenre();
		  this.publications=book.getPublications();
		  this.design=apparel.getDesign();
		  this.brand=apparel.getBrand();
		  this.type=apparel.getType();
		 
	      
	    }
	 
	    /*public ProductInfo(Product product) {
	        this.id = product.getProductId();
	        this.name = product.getProductName();
	        this.price = product.getPrice();
		
		 * this.author=product.getBook().getAuthor();
		 * this.genre=product.getBook().getGenre();
		 * this.publications=product.getBook().getPublications();
		 * this.design=product.getApparel().getDesign();
		 * this.brand=product.getApparel().getBrand();
		 * this.type=product.getApparel().getType();
		 */
	      
	    
	 
	    // Using in JPA/Hibernate query
	   
	 
	   
	    public ProductInfo(int id, String name, float price, String genre, String author, String publications,
				String type, String brand, String design) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.genre = genre;
			this.author = author;
			this.publications = publications;
			this.type = type;
			this.brand = brand;
			this.design = design;
		}
	    
	    public ProductInfo(Product product) {
	    	this.id = product.getProductId();
	        this.name = product.getProductName();
	        this.price = product.getPrice();
		}

		public int getId() {
	        return id;
	    }
	 

		public void setId(int id) {
	        this.id = id;
	    }
	 
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	 
	    public double getPrice() {
	        return price;
	    }
	 
	    public void setPrice(float price) {
	        this.price = price;
	    }

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getPublications() {
			return publications;
		}

		public void setPublications(String publications) {
			this.publications = publications;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getDesign() {
			return design;
		}

		public void setDesign(String design) {
			this.design = design;
		}
	 
}
