package com.feelfreetocode.authservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feelfreetocode.authservice.models.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
    Optional<Register> findByEmail(String email);

    Optional<Register> findByUsernameOrEmail(String username, String email);

    Optional<Register> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
