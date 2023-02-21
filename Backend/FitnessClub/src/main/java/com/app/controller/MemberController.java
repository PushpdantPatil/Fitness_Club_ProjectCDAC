package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ResponseDTO;
import com.app.pojos.Member;
import com.app.service.IMemberService;
import com.app.service.IUserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/member")
public class MemberController 
{
	@Autowired
	  private IMemberService imas;
	
	@Autowired
	  private IUserService us;
	  
	  @PostMapping("/add/{branch_id}")
	  public Member addMember(@RequestBody Member m,@PathVariable long branch_id)
	  {
		  System.out.println("Member is "+m);
		  Member m1 = imas.registerMember(m,branch_id);
		  System.out.println(m1);
		  if(m1!=null)
		  return m1;
		  return null;
	  }
	  
	  @DeleteMapping("/delete/member/{id}")
		public ResponseDTO<?> deleteUser(@PathVariable long id) {
			System.out.println("in delete user " + id);
			Member deleteUser = imas.deleteMember(id);
			String user = us.deleteUserByEmail(deleteUser.getEmail());
			return new ResponseDTO<>(HttpStatus.OK, "User deleted successfully", deleteUser);
		}
	  
	  @PutMapping("add/trainer/{trainerId}")
	  public ResponseDTO<?> addTrainer(@RequestBody Member m,@PathVariable long trainerId)
	  {
		  Member mem = imas.addTrainer(m,trainerId);
		  return new ResponseDTO<>(HttpStatus.OK, "Trainer updated successfully", mem);
	  }
	  
		
}
