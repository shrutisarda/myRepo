package com.mindtree.shoppingcart.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author M1039449
 *
 */
@Entity
@DiscriminatorValue("Apparel")
public class Apparel extends Product{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6433502788779692447L;

	@Column(name = "Type", length = 100)
	private String type;
	
	@Column(name = "Brand", length = 100)
	private String brand;
	
	@Column(name = "Design", length = 200)
	private String design;

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

	@Override
	public String toString() {
		return "Apprel [type=" + type + ", brand=" + brand + ", design=" + design + "]";
	}
	
	
}
