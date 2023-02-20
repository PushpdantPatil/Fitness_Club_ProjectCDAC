package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Member;
import com.app.service.IMemberService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/member")
public class MemberController 
{
	@Autowired
	  private IMemberService imas;
	  
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
}
