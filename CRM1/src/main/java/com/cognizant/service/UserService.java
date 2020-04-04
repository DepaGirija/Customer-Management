package com.cognizant.service;

import com.cognizant.entity.Login;

public interface UserService 
{

	boolean validateUser(String username, String password);

	void saveUser(Login login);	
}
