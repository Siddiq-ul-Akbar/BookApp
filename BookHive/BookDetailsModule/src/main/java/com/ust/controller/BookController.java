package com.ust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

import com.ust.model.Book;
import com.ust.service.BookService;

@Api
@RestController
public class BookController {

	@Autowired
	BookService service;
	
	@PostMapping("book/add")
	public ResponseEntity<?> addBook(@RequestBody Book book){
		try {
			service.addBook(book);
			return new ResponseEntity<String>("Added Sucessfully!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed to add Book", HttpStatus.CONFLICT);
		}
	}
	@PutMapping("book/update")
	public ResponseEntity<?> updateBook(@RequestBody Book book) {
		try {
			return new ResponseEntity<Book>(service.updateBook(book), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed to update Book", HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("book/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable int id) {
		try {
			service.deleteBook(id);
			return new ResponseEntity<String>("Book with id :" + id + " deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed to delete Book", HttpStatus.CONFLICT);
		}
	}
}
