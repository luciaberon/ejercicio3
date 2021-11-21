package com.example.ejercicio3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String model;

    public Laptop() {}
    public Laptop(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }


}
