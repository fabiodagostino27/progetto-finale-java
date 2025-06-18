package org.final_project.java.progetto_finale_java.service;

import java.util.List;
import java.util.Optional;

import org.final_project.java.progetto_finale_java.model.Platform;
import org.final_project.java.progetto_finale_java.repo.PaltformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatformService {
    @Autowired
    private PaltformRepository repository;

    public List<Platform> getAll() {
        return repository.findAll();
    }

    public Optional<Platform> getById(Integer id) {
        return repository.findById(id);
    }

    public Platform create(Platform platform) {
        return repository.save(platform);
    }

    public Platform update(Platform platform) {
        return repository.save(platform);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
