package com.mindtree.shoppingcart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;         
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * @author M1039449
 *
 */
@Entity
@NamedQuery(name="Product.findProductByIdOrName", query="Select p FROM Product p where p.productId=?1 or p.productName=?2")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="products")
@DiscriminatorColumn(name="Category", discriminatorType = DiscriminatorType.STRING)
public class Product implements Serializable,Comparable<Product> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4055661724974268969L;
	
	@Id
	@Column(name = "ID", length = 20)
	private Integer productId;
	
	@Column(name = "Name", length = 200, nullable = false)
	private String productName;
	
	@Column(name = "Price", nullable = false)
	private float price;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	public Product() {
	}
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
		
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId != other.productId)
			return false;
		return true;
	}

	 @Override
	    public int compareTo(Product p) 
	    {
	        return this.getProductId()- p.getProductId();
	    }


}
