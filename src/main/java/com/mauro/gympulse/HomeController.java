package com.mauro.gympulse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.List;

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
    public String home(Model model) {
        List<Solicitacao> solicitacoes = buscarSolicitacoes();

        model.addAttribute("solicitacoes", solicitacoes);
        model.addAttribute("totalSolicitacoes", solicitacoes.size());

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

    private List<Solicitacao> buscarSolicitacoes() {
        // Dados de exemplo. Depois dá para trocar por um banco de dados.
        return List.of(
            new Solicitacao(1L,"Mauro", "P001")
        );
    }
}