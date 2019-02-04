package com.example.NissesFirrar.controllers;

import com.example.NissesFirrar.exceptions.ResourceNotFoundException;
import com.example.NissesFirrar.models.Products;
import com.example.NissesFirrar.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;
import javax.validation.Valid;

@RestController
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController (ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path="/products")
    public List <Products> get(@RequestParam(value="serialNbr", required = false)String serialNbr) {
        return serialNbr == null ? productService.all(): productService.getBySerialNbr(serialNbr);
}

    @GetMapping(path="/productsDop")
    public List <Products> get(@RequestParam(value="dop", required = false) Date dop) {
        return dop == null ? productService.all(): productService.getByDop(dop);
    }

    @GetMapping(path="/productsStatus")
    public List <Products> get(@RequestParam(value="status", required = false)Boolean status) {
        return status == null ? productService.all(): productService.getByStatus(status);
    }
    @GetMapping(path = "/products/{id}")
    public Products getById(@PathVariable(name = "id") Long id) {
        return productService.getById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping(path = "/products")
    public ResponseEntity<Products> create(@RequestBody @Valid Products products) {
        Products createdProducts = productService.create(products);
        return new ResponseEntity<>(createdProducts, HttpStatus.CREATED);
    }

    @PutMapping(path = "/products/{id}")
    public ResponseEntity<Products> update(@PathVariable(name = "id") Long id,
                                         @RequestBody @Valid Products products) {
        Products updatedProducts = productService.update(products, id);
        return new ResponseEntity<>(updatedProducts, HttpStatus.OK);
    }

    @DeleteMapping(path = "/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") Long id) { productService.delete(id); }

}
