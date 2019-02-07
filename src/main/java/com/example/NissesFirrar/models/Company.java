package com.example.NissesFirrar.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name="products_company",
            joinColumns = { @JoinColumn(name = "products_id") },
            inverseJoinColumns = { @JoinColumn(name = "company_id") }
    )
    private Set<Products> products;

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

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
}
