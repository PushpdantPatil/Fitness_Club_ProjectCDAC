package com.app.service;

import com.app.pojos.Member;
import com.app.pojos.User;

public interface IMemberService 
{
	 public Member registerMember(Member t,long id);
	   
	   public Member findByUserId(User uid);
	   
		public Member deleteMember(long id);

		public Member addTrainer(Member m, long trainerId);
}
