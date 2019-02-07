package com.example.NissesFirrar.services;

import com.example.NissesFirrar.exceptions.ResourceNotFoundException;
import com.example.NissesFirrar.models.Products;
import com.example.NissesFirrar.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service

public class ProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }
    public List<Products> all() { return productRepository.findAll(); }
    public Optional<Products> getById(Long id) { return productRepository.findById(id); }
    public List<Products> getBySerialNbr(String serialNbr) { return productRepository.findBySerialNbr(serialNbr); }
    public List<Products> getByDop(Date dop) {
        return productRepository.findByDop(dop);
    }
    public List<Products> getByStatus(Boolean status) {
        return productRepository.findByStatus(status);
    }

    public Products create(Products products) {
        return save(products);
    }
    public Products update(Products products, Long id) {
        return productRepository.findById(id)
                .map(p->{
                    p.setSerialNbr(products.getSerialNbr());
                    return save(p);
                        }
                ).orElseThrow(ResourceNotFoundException::new);
    }
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
    private Products save(Products productsToSave) {
        return productRepository.save(productsToSave);
    }

}
