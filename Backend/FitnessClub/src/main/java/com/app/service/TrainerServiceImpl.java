package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Branch;
import com.app.pojos.Manager;
import com.app.pojos.Trainer;
import com.app.pojos.User;
import com.app.repository.BranchRepository;
import com.app.repository.TrainerRepository;
import com.app.repository.UserRepository;


@Service
@Transactional
public class TrainerServiceImpl implements ITrainerService 
{

	@Autowired
	BranchRepository brpo;
	
	@Autowired
	TrainerRepository tr;
	
	@Autowired
	UserRepository urpo;

	@Override
	public Trainer registerTrainer(Trainer t,long id) 
	{
		Trainer tt = tr.save(t);
		Branch bb = brpo.findById(id).orElseThrow();
		tt.setBranch(bb);
		List<Trainer> tlist = bb.getTrainers();
		tlist.add(tt);
		bb.setTrainers(tlist);
		User u = new User(tt.getEmail(),tt.getPassword(),tt.getRole());
		u = urpo.save(u);
		u.setTrainer(tt);
		tt.setUser(u);
		return tt;
	}

	@Override
	public Trainer findByUserId(User uid)
	{
//		User u = urpo.findById(uid.getId()).get();
		Trainer man = tr.findByUser(uid);
		return man;
	}
}
