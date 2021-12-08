package com.ust.service;

import com.ust.exceptions.BookNotFoundException;
import com.ust.model.Book;

public interface BookService {

	boolean addBook(Book book);
	
	Book updateBook(Book book) throws BookNotFoundException;
	
	boolean deleteBook(int id);
} 
