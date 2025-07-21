package org.final_project.java.progetto_finale_java.controller;

import java.util.List;
import java.util.Optional;

import org.final_project.java.progetto_finale_java.dto.VideogameDTO;
import org.final_project.java.progetto_finale_java.model.Videogame;
import org.final_project.java.progetto_finale_java.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
@RequestMapping("/api/videogames")
public class VideogameRestController {
    @Autowired
    private VideogameService service;

    @GetMapping
    public List<VideogameDTO> index() {
        List<Videogame> videogames = service.getAll();
        return VideogameDTO.fromEntityToList(videogames);
    }

    @GetMapping("/search")
    public List<VideogameDTO> search(@RequestParam String title) {
        List<Videogame> videogames = service.getByTitle(title.trim());
        return VideogameDTO.fromEntityToList(videogames);
    }

    @GetMapping("/random")
    public List<VideogameDTO> random() {
        List<Videogame> videogames = service.getThreeRandom();
        return VideogameDTO.fromEntityToList(videogames);
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<VideogameDTO> show(@PathVariable Integer id) {
        Optional<Videogame> videogameAttempt = service.getById(id);

        if (videogameAttempt.isEmpty()) {
            return new ResponseEntity<VideogameDTO>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<VideogameDTO>(new VideogameDTO(videogameAttempt.get()), HttpStatus.OK);
    }
}
