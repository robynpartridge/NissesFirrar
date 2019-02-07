package com.example.NissesFirrar.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_nbr")
    private String serialNbr;
    @Column(name = "dop")
    private Date dop;
    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToMany(mappedBy = "products")
    private Set<Company> company;

    public Products() { }

    public Products(String serialNbr) {
        this.serialNbr=serialNbr;
    }

    public String getSerialNbr() { return serialNbr; }

    public void setSerialNbr(String serialNbr) { this.serialNbr = serialNbr; }

    public Products(Date dop) {
        this.dop=dop;
    }

    public void setDop(Date dop) {
        this.dop=dop;
    }

    public Date getDop() { return dop; }

    public Products(Boolean status) { this.status=status; }

    public void setStatus(Boolean status) {
        this.status=status;
    }

    public Boolean getStatus() {
        return status;
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id=id;
    }
}
