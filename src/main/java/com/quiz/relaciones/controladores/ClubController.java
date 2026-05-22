package com.quiz.relaciones.controladores;

import com.quiz.relaciones.entidades.Club;
import com.quiz.relaciones.repositorios.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clubes")
public class ClubController {

    private final ClubRepository clubRepository;
    private final EntrenadorRepository entrenadorRepository;
    private final AsociacionRepository asociacionRepository;

    public ClubController(ClubRepository clubRepository,
                          EntrenadorRepository entrenadorRepository,
                          AsociacionRepository asociacionRepository) {
        this.clubRepository = clubRepository;
        this.entrenadorRepository = entrenadorRepository;
        this.asociacionRepository = asociacionRepository;
    }

    // Lista todos los clubes
    @GetMapping
    public String lista(Model model) {
        model.addAttribute("clubes", clubRepository.findAll());
        return "clubes/lista";
    }

    // Detalle de un club (muestra todas sus relaciones)
    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Club no encontrado: " + id));
        model.addAttribute("club", club);
        return "clubes/detalle";
    }

    // Formulario nuevo club
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("club", new Club());
        model.addAttribute("entrenadores", entrenadorRepository.findAll());
        model.addAttribute("asociaciones", asociacionRepository.findAll());
        return "clubes/form";
    }

    // Guardar nuevo club
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Club club) {
        clubRepository.save(club);
        return "redirect:/clubes";
    }

    // Eliminar club
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        clubRepository.deleteById(id);
        return "redirect:/clubes";
    }
}
