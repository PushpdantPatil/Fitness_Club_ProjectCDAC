package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Manager;
import com.app.pojos.User;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
	
    @Query("select m from Manager m where m.user=:id")
	Manager findByUser(@Param("id")User u);

}
