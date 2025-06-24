package org.final_project.java.progetto_finale_java.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.final_project.java.progetto_finale_java.model.Dlc;
import org.final_project.java.progetto_finale_java.model.Videogame;
import org.final_project.java.progetto_finale_java.repo.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideogameService {
    @Autowired
    private VideogameRepository repository;

    @Autowired
    private DlcService dlcService;

    public List<Videogame> getAll() {
        return repository.findAll();
    }

    public Optional<Videogame> getById(Integer id) {
        return repository.findById(id);
    }

    public List<Videogame> getByTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }

    public List<Videogame> getThreeRandom() {
        List<Videogame> videogames = repository.findAll();

        if (videogames.size() <= 3) {
            return videogames;
        }

        Collections.shuffle(videogames);
        List<Videogame> randomVideogames = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            randomVideogames.add(videogames.get(i));
        }

        return randomVideogames;
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
        for (Dlc dlc : repository.findById(id).get().getDlcs()) {
            dlcService.delete(dlc);
        }

        repository.deleteById(id);
    }
}
