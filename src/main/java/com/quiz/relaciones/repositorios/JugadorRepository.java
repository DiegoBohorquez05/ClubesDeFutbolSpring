package com.quiz.relaciones.repositorios;

import com.quiz.relaciones.entidades.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio para la entidad Jugador.
 */
@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    /** Busca un jugador por su numero de camiseta */
    Optional<Jugador> findByNumero(int numero);

    /** Busca jugadores por posicion */
    List<Jugador> findByPosicionIgnoreCase(String posicion);

    /** Busca jugadores por apellido */
    List<Jugador> findByApellidoIgnoreCase(String apellido);

    /** Verifica si ya existe un jugador con ese numero */
    boolean existsByNumero(int numero);
}
