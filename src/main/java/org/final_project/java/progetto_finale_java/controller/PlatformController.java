package org.final_project.java.progetto_finale_java.controller;

import org.final_project.java.progetto_finale_java.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    
}
