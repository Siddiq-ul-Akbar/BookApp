package com.ust.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ust.exception.UserNotFoundException;
import com.ust.model.Book;
import com.ust.model.FavouriteBook;
import com.ust.model.Temp;
import com.ust.model.User;
import com.ust.repository.BookRepository;
import com.ust.repository.FavouriteRepository;
import com.ust.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repo;
	
	@Autowired
	FavouriteRepository favrepo;

	@Autowired
	BookRepository bookrepo;
	
	@Override
	public boolean userRegisteration(User user) {
		try {
			repo.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateUser(User user) {
		User status = repo.getByUserId(user.getUserId());
		if (status != null) {
			status.setUserName(user.getUserName());
			status.setPassword(user.getPassword());
			status.setMail(user.getMail());
			repo.save(status);
			return true;
		}
		return false;
	}

	@Override
	public boolean addtoFavourite(Temp temp) {
		if (temp != null) {
			Book b = bookrepo.getByBookId(temp.getBookId());
			FavouriteBook fav = new FavouriteBook();
			fav.setUserId(temp.getUserId());
			fav.setBookId(b.getBookId());
			fav.setBookName(b.getName());
			fav.setBookDetails(b.getDetails());
			fav.setBookPrice(b.getPrice());
			favrepo.save(fav);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeFavourite(int id) {
		FavouriteBook fav = favrepo.getByFavId(id);
		if (fav.getFavId() == id) {
			favrepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	public boolean validate(User user) throws UserNotFoundException {
		try {
			User c = repo.findByUserIdAndPassword(user.getUserId(), user.getPassword());
			if (c != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new UserNotFoundException("user not found");
		}
	}

}
