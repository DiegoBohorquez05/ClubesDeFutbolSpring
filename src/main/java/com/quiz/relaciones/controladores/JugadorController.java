package com.quiz.relaciones.controladores;

import com.quiz.relaciones.entidades.Jugador;
import com.quiz.relaciones.repositorios.ClubRepository;
import com.quiz.relaciones.repositorios.JugadorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    private final JugadorRepository jugadorRepository;
    private final ClubRepository clubRepository; // Inyectamos el repo de clubes

    // Añadimos ClubRepository al constructor para la inyección de dependencias
    public JugadorController(JugadorRepository jugadorRepository, ClubRepository clubRepository) {
        this.jugadorRepository = jugadorRepository;
        this.clubRepository = clubRepository;
    }

    @GetMapping
    public String lista(Model model) {
        model.addAttribute("jugadores", jugadorRepository.findAll());
        return "jugadores/lista";
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        model.addAttribute("jugador", jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado: " + id)));
        return "jugadores/detalle";
    }

    // 1. Método para mostrar el formulario de "Nuevo Jugador"
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("jugador", new Jugador()); // Objeto vacío para el formulario
        model.addAttribute("listaClubes", clubRepository.findAll()); // Lista para el <select>
        return "jugadores/formulario"; // Asegúrate de que tu HTML del formulario esté en esta ruta
    }

    // 2. Método para procesar el envío del formulario y guardar en la base de datos
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("jugador") Jugador jugador) {
        jugadorRepository.save(jugador);
        return "redirect:/jugadores"; // Redirecciona de vuelta a la lista de jugadores
    }
}