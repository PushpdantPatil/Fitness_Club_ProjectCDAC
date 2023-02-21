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
import com.app.service.IManagerService;
import com.app.service.IUserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/manager")
public class ManagerController 
{
  @Autowired
  private IManagerService imas;
  
  @Autowired
  private IUserService us;
  
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
  
  @PostMapping("/members/{id}")
	public ResponseDTO<?> getAllMembers(@PathVariable long id) 
     {
		System.out.println("in get all Members");
		return new ResponseDTO<>(HttpStatus.OK,"Users Found ",imas.getAllMembers(id));
	}
  
  @PostMapping("/trainers/{id}")
	public ResponseDTO<?> getAllTrainers(@PathVariable long id) 
   {
		System.out.println("in get all Trainers");
		return new ResponseDTO<>(HttpStatus.OK,"Users Found ",imas.getAllTrainers(id));
	}
  
  @DeleteMapping("/delete/manager/{id}")
	public ResponseDTO<?> deleteUser(@PathVariable long id)
   {
		System.out.println("in delete user " + id);
		Manager deleteUser = imas.deleteManager(id);
		String user = us.deleteUserByEmail(deleteUser.getEmail());
		return new ResponseDTO<>(HttpStatus.OK, "User deleted successfully", deleteUser);
	}
  
 
  
}
