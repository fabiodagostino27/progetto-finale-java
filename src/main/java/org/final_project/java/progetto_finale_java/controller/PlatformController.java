package org.final_project.java.progetto_finale_java.controller;

import org.final_project.java.progetto_finale_java.model.Platform;
import org.final_project.java.progetto_finale_java.service.PlatformService;
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
@RequestMapping("/platforms")
public class PlatformController {
    @Autowired
    private PlatformService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("platforms", service.getAll());
        return "platforms/index";
    }
    
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("platform", new Platform());
        return "platforms/create-edit";
    }
    
    @PostMapping("/create")
    public String store(@Valid @ModelAttribute Platform platform, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "platforms/create-edit";
        }
        
        service.create(platform);
        return "redirect:/platforms";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        boolean edit = true;
        model.addAttribute("platform", service.getById(id).get());
        model.addAttribute("edit", edit);
        return "platforms/create-edit";
    }
    
    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute Platform platform, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "platforms/create-edit";
        }
        
        service.update(platform);
        return "redirect:/platforms";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteById(id);
        return "redirect:/platforms";
    }
    
    
}
