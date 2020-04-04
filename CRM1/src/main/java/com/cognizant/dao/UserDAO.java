package com.cognizant.dao;

import com.cognizant.entity.Login;

public interface UserDAO {


	boolean validateUser(String username, String password);

	void saveUser(Login login);

}
