package com.example.NissesFirrar.controllers;

import com.example.NissesFirrar.exceptions.ResourceNotFoundException;
import com.example.NissesFirrar.models.Company;
import com.example.NissesFirrar.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController (CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(path="/company")
    public List<Company> get(@RequestParam(value="name", required = false)String name) {
        return name == null ? CompanyService.all(): companyService.getByName(name);
    }
    @GetMapping(path = "/company/{id}")
    public Company getById(@PathVariable(name = "id") Long id) {
        return companyService.getById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
    @PostMapping(path = "/company")
    public ResponseEntity<Company> create(@RequestBody @Valid Company company) {
        Company createdCompany = companyService.create(company);
        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }

    @PutMapping(path = "/company/{id}")
    public ResponseEntity<Company> update(@PathVariable(name = "id") Long id,
                                         @RequestBody @Valid Company company) {
        Company updatedCompany = companyService.update(company, id);
        return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
    }

    @DeleteMapping(path = "/company/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") Long id) { companyService.delete(id); }

}