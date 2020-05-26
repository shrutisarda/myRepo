package com.mindtree.shoppingcart.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 * @author M1039449
 *
 */
@Entity
@DiscriminatorValue("Book")
public class Book extends Product{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2063433126156794463L;

	@Column(name = "Genre", length = 200)
	String genre;
	
	@Column(name = "Author", length = 200)
	String author;
	
	@Column(name = "Publications", length = 300)
	String publications;

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

	@Override
	public String toString() {
		return "Book [genre=" + genre + ", author=" + author + ", publications=" + publications + "]";
	}
	
	

}
