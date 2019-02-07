package com.example.NissesFirrar.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="org_nbr")
    private Long ordNbr;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Products> products;

    public Company(){
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrdNbr() {
        return ordNbr;
    }

    public void setOrdNbr(Long ordNbr) {
        this.ordNbr = ordNbr;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

}
