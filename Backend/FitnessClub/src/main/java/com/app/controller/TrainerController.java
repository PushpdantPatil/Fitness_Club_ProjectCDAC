package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ResponseDTO;
import com.app.pojos.Manager;
import com.app.pojos.Member;
import com.app.pojos.Trainer;
import com.app.service.ITrainerService;
import com.app.service.IUserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/trainer")
public class TrainerController 
{

	@Autowired
	  private ITrainerService imas;
	
	@Autowired
	  private IUserService us;
	
	  
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
	  
	  @DeleteMapping("/delete/trainer/{id}")
		public ResponseDTO<?> deleteUser(@PathVariable long id) {
			System.out.println("in delete user " + id);
			Trainer nullMember = imas.setMembersNull(id);
			Trainer deleteUser = imas.deleteTrainer(nullMember.getId());
			String user = us.deleteUserByEmail(deleteUser.getEmail());
			return new ResponseDTO<>(HttpStatus.OK, "User deleted successfully", deleteUser);
		}
}
