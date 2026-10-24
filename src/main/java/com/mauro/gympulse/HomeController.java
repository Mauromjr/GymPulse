package com.mauro.gympulse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("mensagem", "Olá, Spring Boot!");
        return "index";
    }
}