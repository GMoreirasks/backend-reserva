package com.example.sistemaReserva.controller;

import com.example.sistemaReserva.model.Item;
import com.example.sistemaReserva.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    // Listar todos os itens
    @GetMapping("/itens")
    public List<Item> listarItens() {
        return itemRepository.findAll();
    }

    // Criar um novo item
    @PostMapping("/itens")
    public ResponseEntity<Item> criarItem(@RequestBody Item item) {
        Item itemSalvo = itemRepository.save(item);
        return ResponseEntity.ok(itemSalvo);
    }

    // Obter um item específico pelo ID
    @GetMapping("/itens/{id}")
    public ResponseEntity<Item> obterItem(@PathVariable Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar um item existente
    @PutMapping("/itens/{id}")
    public ResponseEntity<Item> atualizarItem(@PathVariable Long id, @RequestBody Item itemDetalhes) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setNome(itemDetalhes.getNome());
                    Item itemAtualizado = itemRepository.save(item);
                    return ResponseEntity.ok(itemAtualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Excluir um item pelo ID
    @DeleteMapping("/itens/{id}")
    public ResponseEntity<Object> excluirItem(@PathVariable Long id) {
        return itemRepository.findById(id)
                .map(item -> {
                    itemRepository.delete(item);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
