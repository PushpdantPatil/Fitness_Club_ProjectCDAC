package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Manager;
import com.app.service.IManagerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/manager")
public class ManagerController 
{
  @Autowired
  private IManagerService imas;
  
  @PostMapping("/add/{branch_id}")
  public Manager addManager(@RequestBody Manager m,@PathVariable long branch_id)
  {
	  System.out.println("Manager is "+m);
	  Manager m1 = imas.registerManager(m,branch_id);
	  System.out.println(m1);
	  if(m1!=null)
	  return m1;
	  return null;
  }
}
