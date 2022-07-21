package com.hitchsavan.testapp.repository;

import com.hitchsavan.testapp.models.Tag;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
        
}
