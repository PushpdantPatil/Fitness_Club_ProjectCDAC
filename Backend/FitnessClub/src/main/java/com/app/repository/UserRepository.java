package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, Long> 
{
	@Query("select u from User u where u.email=:mail and u.password=:password")
	User findByEmailAndPassword(@Param("mail")String email,@Param("password")String password);
}
