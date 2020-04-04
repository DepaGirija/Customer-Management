package com.cognizant.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Login;

@Repository
public class UserDaoImpl implements UserDAO {

	@Autowired
	SessionFactory factory;
	@Override
	public boolean validateUser(String username, String password) 
	{
		Session session=factory.getCurrentSession();
		String sql="from Login where username='"+username+"' and password='"+password+"'";
		Query<Login> query=session.createQuery(sql,Login.class);
		List<Login> list=query.getResultList();
		if(list.isEmpty())
			return false;
		return true;
	}
	@Override
	public void saveUser(Login login) 
	{
		Session session=factory.getCurrentSession();
		session.save(login);
	}
}
