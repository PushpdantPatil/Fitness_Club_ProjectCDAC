package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Manager;
import com.app.pojos.Trainer;
import com.app.service.ITrainerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/trainer")
public class TrainerController 
{

	@Autowired
	  private ITrainerService imas;
	  
	  @PostMapping("/add/{branch_id}")
	  public Trainer addTrainer(@RequestBody Trainer m,@PathVariable long branch_id)
	  {
		  System.out.println("Trainer is "+m);
		  Trainer m1 = imas.registerTrainer(m,branch_id);
		  System.out.println(m1);
		  if(m1!=null)
		  return m1;
		  return null;
	  }
}
