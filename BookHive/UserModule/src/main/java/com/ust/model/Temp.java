package com.ust.model;

public class Temp {

	private int userId;
	private int bookId;
	public Temp() {
		super();
	}
	public Temp(int userId, int bookId) {
		super();
		this.userId = userId;
		this.bookId = bookId;
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
	
}
