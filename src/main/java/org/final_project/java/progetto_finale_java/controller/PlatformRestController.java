package org.final_project.java.progetto_finale_java.controller;

import java.util.List;
import java.util.Optional;

import org.final_project.java.progetto_finale_java.dto.PlatformDTO;
import org.final_project.java.progetto_finale_java.model.Platform;
import org.final_project.java.progetto_finale_java.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin
@RequestMapping("/api/platforms")
public class PlatformRestController {
    @Autowired
    private PlatformService service;

    @GetMapping
    public List<PlatformDTO> index() {
        List<Platform> platforms = service.getAll();
        return PlatformDTO.fromEntityToList(platforms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatformDTO> show(@PathVariable Integer id) {
        Optional<Platform> platformAttempt = service.getById(id);

        if (platformAttempt.isEmpty()) {
            return new ResponseEntity<PlatformDTO>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<PlatformDTO>(new PlatformDTO(platformAttempt.get()), HttpStatus.OK);
    }
}
