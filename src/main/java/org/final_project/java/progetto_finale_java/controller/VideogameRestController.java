package org.final_project.java.progetto_finale_java.controller;

import java.util.List;
import java.util.Optional;

import org.final_project.java.progetto_finale_java.model.Videogame;
import org.final_project.java.progetto_finale_java.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/videogames")
public class VideogameRestController {
    @Autowired
    private VideogameService service;

    @GetMapping
    public List<Videogame> index() {
        return service.getAll();
    }

    @GetMapping("/search")
    public List<Videogame> search(@RequestParam String title) {
        return service.getByTitle(title);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Videogame> show(@PathVariable Integer id) {
        Optional<Videogame> videogameAttempt = service.getById(id);

        if (videogameAttempt.isEmpty()) {
            return new ResponseEntity<Videogame>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Videogame>(videogameAttempt.get(), HttpStatus.OK);
    }
}
