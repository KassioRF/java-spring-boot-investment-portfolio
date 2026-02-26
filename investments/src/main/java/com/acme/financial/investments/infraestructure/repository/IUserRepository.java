package com.acme.financial.investments.infraestructure.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.financial.investments.infraestructure.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findById(UUID userId);

    Optional<UserEntity> findByName(String name);
}
