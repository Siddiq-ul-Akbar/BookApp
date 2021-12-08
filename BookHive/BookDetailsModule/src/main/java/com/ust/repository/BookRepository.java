package com.ust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	Book getByBookId(int id);
}
