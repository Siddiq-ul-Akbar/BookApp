package com.ust.service;

import com.ust.exception.UserNotFoundException;
import com.ust.model.Temp;
import com.ust.model.User;

public interface UserService {

	public boolean userRegisteration(User user);
	
	public boolean updateUser(User user);

	public boolean addtoFavourite(Temp temp);

	public boolean removeFavourite(int id);
	
	public boolean validate(User user) throws UserNotFoundException;
}
