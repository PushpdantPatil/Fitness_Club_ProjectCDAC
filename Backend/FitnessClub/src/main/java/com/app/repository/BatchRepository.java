package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Batch;

public interface BatchRepository extends JpaRepository<Batch, Long> {

}
