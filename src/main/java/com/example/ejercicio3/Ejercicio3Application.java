package com.example.ejercicio3;

import com.example.ejercicio3.entity.Laptop;
import com.example.ejercicio3.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio3Application {

    public static void main(String[] args) {
        // call context
        ApplicationContext context = SpringApplication.run(Ejercicio3Application.class, args);

        Laptop laptop1 = new Laptop("laptop1");
        Laptop laptop2 = new Laptop("laptop2");

        LaptopRepository repo = context.getBean(LaptopRepository.class);

        repo.save(laptop1);
        repo.save(laptop2);
        System.out.println("hola");
        System.out.println(repo.findAll());
    }

}
