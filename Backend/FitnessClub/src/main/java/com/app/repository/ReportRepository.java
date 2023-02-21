package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {

}
