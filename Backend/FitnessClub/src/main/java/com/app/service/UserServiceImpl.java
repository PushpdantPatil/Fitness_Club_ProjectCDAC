package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.repository.ManagerRepository;
import com.app.repository.UserRepository;


@Service
@Transactional
public class UserServiceImpl implements IUserService 
{

	@Autowired
	UserRepository uu;
	

	@Override
	public User validate(User u) 
	{
		User valid = uu.findByEmailAndPassword(u.getEmail(),u.getPassword());
		return valid;
	}


	@Override
	public String deleteUserByEmail(String email) 
	{
		uu.deleteByEmail(email);
		return null;
	}
	
	
	
   
}
