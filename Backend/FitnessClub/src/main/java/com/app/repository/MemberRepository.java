package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Member;
import com.app.pojos.Member;
import com.app.pojos.User;

public interface MemberRepository extends JpaRepository<Member, Long>
{
	@Query("select t from Member t where t.user=:id")
	Member findByUser(@Param("id")User u);
}
