package com.example.ejercicio3.controller;

import com.example.ejercicio3.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ejercicio3.entity.Laptop;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

@RestController
public class LaptopController {
    private LaptopRepository repository;

    public LaptopController(LaptopRepository repository) {
        this.repository = repository;
    }

    @ApiOperation("Obtener todas las laptops.")
    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        return repository.findAll();
    }

    @ApiOperation("Agregar una laptop.")
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
        if (laptop.getId() != null) {
            //explicar
            System.out.println("laptop exists already");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = repository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @ApiIgnore
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll() {
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @ApiOperation("Buscar un libro por clave primaria id Long.")
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findById(@PathVariable Long id) {
        Optional<Laptop> laptop = repository.findById(id);

        if (laptop.isPresent()) {
            return ResponseEntity.ok(laptop.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiIgnore
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation("Actualizar laptop con id como parámetro.")
    @PutMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        if (laptop.getId() == null) {
            System.out.println("Trying to create nonexistent laptop");
            return ResponseEntity.badRequest().build();
        }
        if(!repository.existsById(laptop.getId())){
            return ResponseEntity.notFound().build();
        }
        Laptop result = repository.save(laptop);
        return ResponseEntity.ok(result);
    }




}

