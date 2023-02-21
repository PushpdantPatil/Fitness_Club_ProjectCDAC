package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Packages;

public interface PackageRepository extends JpaRepository<Packages, Long> {

}
