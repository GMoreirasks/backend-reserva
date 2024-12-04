package com.example.sistemaReserva.repository;

import com.example.sistemaReserva.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    // Método para buscar reservas pelo nome do item
    List<Reserva> findByItemNome(String nome);
}
