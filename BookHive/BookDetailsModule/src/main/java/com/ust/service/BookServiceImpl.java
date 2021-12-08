package com.ust.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.exceptions.BookNotFoundException;
import com.ust.model.Book;
import com.ust.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository repo;
	
	@Override
	public boolean addBook(Book book) {
		try {
			repo.save(book);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public Book updateBook(Book book) throws BookNotFoundException {
		Book b=repo.getByBookId(book.getBookId());
		if (b !=null) {
			b.setName(book.getName());
			b.setCategory(book.getCategory());
			b.setPrice(book.getPrice());
			b.setDetails(book.getDetails());
			repo.save(b);
			return b;
		}
		throw new BookNotFoundException("Book Not Found");
	}

	@Override
	public boolean deleteBook(int id) {
		Book b = repo.getByBookId(id);
		if(b.getBookId()==id) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

}
