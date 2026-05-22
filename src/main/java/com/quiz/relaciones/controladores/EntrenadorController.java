package com.quiz.relaciones.controladores;

import com.quiz.relaciones.repositorios.EntrenadorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/entrenadores")
public class EntrenadorController {

    private final EntrenadorRepository entrenadorRepository;

    public EntrenadorController(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    @GetMapping
    public String lista(Model model) {
        model.addAttribute("entrenadores", entrenadorRepository.findAll());
        return "entrenadores/lista";
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        model.addAttribute("entrenador", entrenadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado: " + id)));
        return "entrenadores/detalle";
    }
}
