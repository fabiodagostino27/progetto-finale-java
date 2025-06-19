package org.final_project.java.progetto_finale_java.repo;

import java.util.Optional;

import org.final_project.java.progetto_finale_java.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
