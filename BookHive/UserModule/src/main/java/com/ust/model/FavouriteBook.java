package com.ust.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class FavouriteBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int favId;
	@NotNull
	private int userId;
	@NotNull
	private int bookId;
	@NotNull
	private String bookName;
	@NotNull
	private String bookPrice;
	@NotNull
	private String bookDetails;
	
	public FavouriteBook() {
		super();
	}

	public FavouriteBook(int favId, int userId, int bookId, String bookName, String bookPrice, String bookDetails) {
		super();
		this.favId = favId;
		this.userId = userId;
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookDetails = bookDetails;
	}

	public int getFavId() {
		return favId;
	}

	public void setFavId(int favId) {
		this.favId = favId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(String bookDetails) {
		this.bookDetails = bookDetails;
	}

}
