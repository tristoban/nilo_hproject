package com.api.rest.keycloacspringboot.repository;

import com.api.rest.keycloacspringboot.entity.UserEntity;
import com.api.rest.keycloacspringboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
