package org.final_project.java.progetto_finale_java.controller;

import java.util.List;
import java.util.Optional;

import org.final_project.java.progetto_finale_java.model.Videogame;
import org.final_project.java.progetto_finale_java.service.PlatformService;
import org.final_project.java.progetto_finale_java.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;





@Controller
@RequestMapping("/videogames")
public class VideogameController {
    @Autowired
    private VideogameService videogameService;

    @Autowired
    private PlatformService platformService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("videogames", videogameService.getAll());
        return "videogames/index";
    }
    
    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Optional<Videogame> videogameAttempt = videogameService.getById(id);

        model.addAttribute("videogame", videogameAttempt.get());
        return "videogames/show";
    }

    @GetMapping("/search")
    public String search(@RequestParam String title, Model model) {
        List<Videogame> videogames = videogameService.getByTitle(title);
        model.addAttribute("videogames", videogames);
        return "videogames/index";
    }
    
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("videogame", new Videogame());
        model.addAttribute("platforms", platformService.getAll());
        return "videogames/create-edit";
    }
    
    @PostMapping("/create")
    public String store(@Valid @ModelAttribute Videogame videogame, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("platforms", platformService.getAll());
            return "videogames/create-edit";
        }

        videogameService.create(videogame);
        return "redirect:/videogames";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        boolean edit = true;
        model.addAttribute("edit", edit);
        model.addAttribute("platforms", platformService.getAll());
        model.addAttribute("videogame", videogameService.getById(id).get());
        return "videogames/create-edit";
    }
    
    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute Videogame videogame, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("platforms", platformService.getAll());
            return "videogames/create-edit";
        }

        videogameService.update(videogame);
        return "redirect:/videogames";
    }
    
    @PostMapping("/delete/{id}")
    public String postMethodName(@PathVariable Integer id) {
        videogameService.deleteById(id);
        return "redirect:/videogames";
    }
    
    
}
