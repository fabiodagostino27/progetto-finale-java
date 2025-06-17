package org.final_project.java.progetto_finale_java.service;

import java.util.List;
import java.util.Optional;

import org.final_project.java.progetto_finale_java.model.Videogame;
import org.final_project.java.progetto_finale_java.repo.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideogameService {
    @Autowired
    private VideogameRepository repository;

    public List<Videogame> getAll() {
        return repository.findAll();
    }

    public Optional<Videogame> getById(Integer id) {
        return repository.findById(id);
    }

    public List<Videogame> getByTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }

    public Videogame create(Videogame videogame) {
        return repository.save(videogame);
    }

    public Videogame update(Videogame videogame) {
        return repository.save(videogame);
    }

    public void delete(Videogame videogame) {
        repository.delete(videogame);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
