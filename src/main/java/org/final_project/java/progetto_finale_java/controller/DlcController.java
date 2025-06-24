package org.final_project.java.progetto_finale_java.controller;

import org.final_project.java.progetto_finale_java.model.Dlc;
import org.final_project.java.progetto_finale_java.service.DlcService;
import org.final_project.java.progetto_finale_java.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/dlcs")
public class DlcController {
    @Autowired
    private DlcService dlcService;
    
    @Autowired
    private VideogameService videogameService;

    @GetMapping("/create/{id}")
    public String create(@PathVariable Integer id, Model model) {
        Dlc dlc = new Dlc();
        dlc.setVideogame(videogameService.getById(id).get());
        model.addAttribute("dlc", dlc);
        return "dlcs/create-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute Dlc dlc, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "dlcs/create-edit";
        }
        dlcService.create(dlc);
        return "redirect:/videogames/" + dlc.getVideogame().getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        boolean edit = true;
        model.addAttribute("edit", edit);
        model.addAttribute("dlc", dlcService.getById(id).get());
        return "dlcs/create-edit";
    }
    
    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute Dlc dlc, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "dlcs/create-edit";
        }
        dlcService.update(dlc);
        return "redirect:/videogames/" + dlc.getVideogame().getId();
    }
    
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Integer videogameId = dlcService.getById(id).get().getVideogame().getId();
        dlcService.deleteById(id);

        return "redirect:/videogames/" + videogameId;
    }
    
}
