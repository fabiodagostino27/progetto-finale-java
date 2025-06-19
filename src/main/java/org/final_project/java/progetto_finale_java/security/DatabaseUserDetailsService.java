package org.final_project.java.progetto_finale_java.security;

import java.util.Optional;

import org.final_project.java.progetto_finale_java.model.User;
import org.final_project.java.progetto_finale_java.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DatabaseUserDetailsService implements UserDetailsService  {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userAttempt = repository.findByUsername(username);

        if (userAttempt.isEmpty()) {
            throw new UsernameNotFoundException("No user found with this username" + username);
        }

        return new DatabaseUserDetails(userAttempt.get());
    }
    
}
