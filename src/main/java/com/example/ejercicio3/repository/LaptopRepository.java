package com.example.ejercicio3.repository;

import com.example.ejercicio3.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
