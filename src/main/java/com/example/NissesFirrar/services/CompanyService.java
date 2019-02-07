package com.example.NissesFirrar.services;

import com.example.NissesFirrar.exceptions.ResourceNotFoundException;
import com.example.NissesFirrar.models.Company;
import com.example.NissesFirrar.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;
    @Autowired
    public CompanyService(CompanyRepository companyRepository) { this.companyRepository=companyRepository; }
    public List<Company> all() { return companyRepository.findAll(); }
    public Optional<Company> getById(Long id) { return companyRepository.findById(id); }
    public List<Company> getByName(String name) { return companyRepository.findByName(name); }
    public List<Company> getByOrgNbr(Long orgNbr) { return companyRepository.findByOrgNbr(orgNbr); }
    public Company create(Company company) { return save(company); }
    public Company update(Company company, Long id) {
        return companyRepository.findById(id)
                .map(p-> {
                            p.setName(company.getName());
                            p.setOrgNbr(company.getOrgNbr());
                            return save(p);
                        }
                ).orElseThrow(ResourceNotFoundException::new);
    }
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }
    private Company save(Company companyToSave) {
        return companyRepository.save(companyToSave);
    }
}
