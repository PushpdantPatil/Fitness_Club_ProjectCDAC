package com.app.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Branch;
import com.app.pojos.Manager;
import com.app.pojos.User;
import com.app.repository.BranchRepository;
import com.app.repository.ManagerRepository;
import com.app.repository.UserRepository;


@Service
@Transactional
public class ManagerService implements IManagerService
{
	@Autowired
	ManagerRepository mr;
	
	@Autowired
	BranchRepository brpo;
	
	@Autowired
	UserRepository urpo;

	@Override
	public Manager registerManager(Manager m,long id) 
	{
		Manager mm = mr.save(m);
		Branch bb = brpo.findById(id).orElseThrow();
		mm.setBranch(bb);
		bb.setManager(mm);
		User u = new User(mm.getEmail(),mm.getPassword(),mm.getRole());
		u = urpo.save(u);
		u.setManager(mm);
		mm.setUser(u);
		return mm;
	}

	@Override
	public Manager findByUserId(User uid)
	{
//		User u = urpo.findById(uid.getId()).get();
		Manager man = mr.findByUser(uid);
		return man;
	}
	
	
  
}
