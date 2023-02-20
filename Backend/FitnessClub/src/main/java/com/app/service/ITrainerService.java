package com.app.service;

import com.app.pojos.Manager;
import com.app.pojos.Trainer;
import com.app.pojos.User;

public interface ITrainerService 
{
	 public Trainer registerTrainer(Trainer t,long id);
	   
	   public Trainer findByUserId(User uid);
}
