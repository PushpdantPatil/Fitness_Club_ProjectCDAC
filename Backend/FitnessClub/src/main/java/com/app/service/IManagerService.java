package com.app.service;

import com.app.pojos.Manager;
import com.app.pojos.User;

public interface IManagerService 
{
   public Manager registerManager(Manager m,long id);
   
   public Manager findByUserId(User uid);
   
   
}
