package com.hitchsavan.testapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hitchsavan.testapp.models.Test;

public interface TestRepository extends JpaRepository<Test, Long> {  
    
}
