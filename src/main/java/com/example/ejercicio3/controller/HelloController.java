package com.example.ejercicio3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/saludo")
    public String Saludo() {
        return "Hola Mundo!";
    }

}
