package com.hitchsavan.testapp.repository;

import com.hitchsavan.testapp.models.Report;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long>{
}
