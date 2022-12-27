package com.example.homeassignmentapi.repository;

import java.util.Optional;

import com.example.homeassignmentapi.entity.Role;
import com.example.homeassignmentapi.entity.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}