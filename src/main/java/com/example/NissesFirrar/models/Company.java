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
    private Long orgNbr;
    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "company")
    private List<Products> products;

    public Company(){ }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public Long getOrgNbr() {
        return orgNbr;
    }

    public void setOrgNbr(Long orgNbr) {
        this.orgNbr = orgNbr;
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
