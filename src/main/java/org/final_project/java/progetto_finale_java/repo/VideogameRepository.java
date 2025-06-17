package org.final_project.java.progetto_finale_java.repo;

import org.final_project.java.progetto_finale_java.model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideogameRepository extends JpaRepository<Videogame, Integer>{
    
}
