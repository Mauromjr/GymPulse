package com.mauro.gympulse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class HomeController {

    private final List<Solicitacao> solicitacoes = new CopyOnWriteArrayList<>(List.of(
        new Solicitacao(1L, "Mauro", "P001")
    ));

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

        model.addAttribute("solicitacoes", solicitacoes);
        model.addAttribute("totalSolicitacoes", solicitacoes.size());

        return "home";
    }

    @PostMapping("/solicitacoes/{id}/aceitar")
    public String aceitar(@PathVariable Long id) {

        solicitacoes.removeIf(s -> s.getId().equals(id));

        return "redirect:/home";
    }

    @PostMapping("/solicitacoes/{id}/recusar")
    public String recusar(@PathVariable Long id) {

        solicitacoes.removeIf(s -> s.getId().equals(id));

        return "redirect:/home";
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
