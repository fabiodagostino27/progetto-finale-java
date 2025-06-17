package org.final_project.java.progetto_finale_java.controller;

import java.util.List;
import java.util.Optional;

import org.final_project.java.progetto_finale_java.model.Videogame;
import org.final_project.java.progetto_finale_java.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/videogames")
public class VideogameController {
    @Autowired
    private VideogameService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("videogames", service.getAll());
        return "videogames/index";
    }
    
    @GetMapping("{id}")
    public String show(@PathVariable Integer id, Model model) {
        Optional<Videogame> videogameAttempt = service.getById(id);
        if (videogameAttempt.isEmpty()) {
            return "notFound";
        }

        model.addAttribute("videogame", videogameAttempt.get());
        return "videogames/show";
    }

    @GetMapping("/search")
    public String search(@RequestParam String title, Model model) {
        List<Videogame> videogames = service.getByTitle(title);
        model.addAttribute("videogames", videogames);
        return "videogames/index";
    }
    
    
}
