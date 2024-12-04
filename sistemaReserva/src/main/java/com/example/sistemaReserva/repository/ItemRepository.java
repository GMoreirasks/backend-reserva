package com.example.sistemaReserva.repository;

import com.example.sistemaReserva.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByNome(String nome); // Método existente, ajuste se necessário.
    List<Item> findByNomeContainingIgnoreCase(String nome); // Exemplo de método adicional para busca parcial.
}
