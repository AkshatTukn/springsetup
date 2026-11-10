package org.git.springsetup.controller;

import lombok.RequiredArgsConstructor;
import org.git.springsetup.model.Item;
import org.git.springsetup.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<Item> getAll() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable Long id) {
        return ResponseEntity.of(itemService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item create(@RequestBody Item item) {
        return itemService.create(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Long id, @RequestBody Item item) {
        return ResponseEntity.of(itemService.update(id, item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return itemService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
