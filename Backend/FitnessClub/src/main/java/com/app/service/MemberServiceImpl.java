package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Branch;
import com.app.pojos.Member;
import com.app.pojos.User;
import com.app.repository.BranchRepository;
import com.app.repository.MemberRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class MemberServiceImpl implements IMemberService 
{
	@Autowired
	BranchRepository brpo;
	
	@Autowired
	MemberRepository tr;
	
	@Autowired
	UserRepository urpo;

	@Override
	public Member registerMember(Member t,long id) 
	{
		Member tt = tr.save(t);
		Branch bb = brpo.findById(id).orElseThrow();
		tt.setBranch(bb);
		List<Member> tlist = bb.getMembers();
		tlist.add(tt);
		bb.setMembers(tlist);
		User u = new User(tt.getEmail(),tt.getPassword(),tt.getRole());
		u = urpo.save(u);
		u.setMember(tt);
		tt.setUser(u);
		return tt;
	}

	@Override
	public Member findByUserId(User uid)
	{
//		User u = urpo.findById(uid.getId()).get();
		Member man = tr.findByUser(uid);
		return man;
	}
}
