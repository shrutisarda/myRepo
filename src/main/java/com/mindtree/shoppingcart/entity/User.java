package com.mindtree.shoppingcart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * @author M1039449
 *
 */
@Entity
@NamedQuery(name="User.getUserByEmailAndPassword",
query="Select u FROM User u where u.email=:email and u.password=:password")
@Table(name="Users")
public class User implements Comparable<User>{
	@Id
	@Column(name = "Email", length = 100, nullable = false)
	private String email;
	
	@Column(name = "User_Name", length = 100, nullable = false)
	private String userName;
	
	@Column(name = "Password", length = 100, nullable = false)
	private String password;
	
	@Column(name = "Phone", length = 10, nullable = false)
	private String phone;
	
	@Column(name = "Address", length = 300, nullable = false)
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cart_id",referencedColumnName="cart_id")
	private Cart cart;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", userName=" + userName + ", password=" + password + ", phone=" + phone
				+ ", address=" + address + "]";
	}

	@Override
	public int compareTo(User user) {
		return  this.getEmail().compareTo(user.getEmail());
	}
	
	
}
