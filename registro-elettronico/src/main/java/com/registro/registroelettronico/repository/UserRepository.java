package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for accessing User entities. Provides a method to find
 * users by username for authentication purposes.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}