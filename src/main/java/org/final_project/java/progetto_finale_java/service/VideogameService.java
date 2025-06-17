package org.final_project.java.progetto_finale_java.service;

import org.final_project.java.progetto_finale_java.repo.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideogameService {
    @Autowired
    private VideogameRepository repository;
}
