package com.hitchsavan.testapp.repository;

import java.util.Optional;

import com.hitchsavan.testapp.models.ERole;
import com.hitchsavan.testapp.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
