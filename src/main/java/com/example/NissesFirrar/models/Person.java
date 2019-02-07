package com.example.NissesFirrar.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "person")
    private List<Products> products;

    public Person() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Products> getProducts() { return products; }

    public void setProducts(List<Products> products) { this.products = products; }
}

