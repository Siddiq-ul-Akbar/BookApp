package com.ust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.model.FavouriteBook;

@Repository
public interface FavouriteRepository extends JpaRepository<FavouriteBook, Integer> {
	
	FavouriteBook getByFavId(int id);
}
