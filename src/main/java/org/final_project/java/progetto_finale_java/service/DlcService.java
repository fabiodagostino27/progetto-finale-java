package org.final_project.java.progetto_finale_java.service;

import org.final_project.java.progetto_finale_java.model.Dlc;
import org.final_project.java.progetto_finale_java.repo.DlcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DlcService {
    @Autowired
    private DlcRepository repository;

    public Dlc create(Dlc dlc) {
        return repository.save(dlc);
    }

    public Dlc update(Dlc dlc) {
        return repository.save(dlc);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public void delete(Dlc dlc) {
        repository.delete(dlc);
    }
}
