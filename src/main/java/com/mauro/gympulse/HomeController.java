package com.mauro.gympulse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @GetMapping("/")
    public String inicio() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String entrar(
            @RequestParam String email,
            @RequestParam String senha,
            Model model) {

        return "redirect:/home";
    }

    @PostMapping("/cadastro")
    public String realizarCadastro() {

        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @GetMapping("/avaliacao")
    public String avaliacao() {
        return "avaliacao";
    }

    @GetMapping("/solicitacoes")
    public String solicitacoes() {
        return "solicitacoes";
    }
}