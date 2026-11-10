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

    private record Conta(String email, String senha, String tipo) {}

    private final List<Conta> contas = new CopyOnWriteArrayList<>(List.of(
        new Conta("aluno@gympulse.com", "123456", "aluno"),
        new Conta("personal@gympulse.com", "123456", "personal")
    ));

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

        for (Conta conta : contas) {
            if (conta.email().equalsIgnoreCase(email.trim()) && conta.senha().equals(senha)) {
                return conta.tipo().equals("personal") ? "redirect:/personal/home" : "redirect:/home";
            }
        }

        model.addAttribute("erro", "E-mail ou senha incorretos.");
        return "login";
    }

    @PostMapping("/cadastro")
    public String realizarCadastro(
            @RequestParam String email,
            @RequestParam String senha,
            @RequestParam String confirmarSenha,
            @RequestParam String tipo,
            Model model) {
        if (!tipo.equals("aluno") && !tipo.equals("personal")) {
            model.addAttribute("erro", "Selecione Aluno ou Personal.");
            return "cadastro";
        }
        if (email.isBlank() || senha.isBlank() || !senha.equals(confirmarSenha)) {
            model.addAttribute("erro", "Preencha o e-mail e confirme a mesma senha.");
            return "cadastro";
        }
        if (contas.stream().anyMatch(conta -> conta.email().equalsIgnoreCase(email.trim()))) {
            model.addAttribute("erro", "Este e-mail já está cadastrado.");
            return "cadastro";
        }
        contas.add(new Conta(email.trim(), senha, tipo));
        return "redirect:/login";
    }

    @GetMapping("/personal/home")
    public String personalHome() {
        return "personal_home";
    }

    @GetMapping("/personal/solicitacoes")
    public String personalSolicitacoes() {
        return "personal_solicitacoes";
    }

    @GetMapping("/personal/treino")
    public String personalTreino() {
        return "personal_treino";
    }

    @GetMapping("/personal/avaliacao")
    public String personalAvaliacao() {
        return "personal_avaliacao";
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
