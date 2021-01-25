package com.feelfreetocode.authservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feelfreetocode.authservice.models.Role;
import com.feelfreetocode.authservice.models.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);
}