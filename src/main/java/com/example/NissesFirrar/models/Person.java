package com.example.NissesFirrar.models;

import javax.persistence.*;

@Entity
@Table(name="person")
public class Person {
    @Id
    @Column(name = "person_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

 /**   @OneToMany
    @JoinColumn(name = "product_id")
    private Products products;**/


    public Person() {
    }

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
}

