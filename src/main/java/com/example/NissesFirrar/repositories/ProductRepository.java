package com.example.NissesFirrar.repositories;

import com.example.NissesFirrar.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    List<Products> findBySerialNbr(String serialNbr);
    List<Products> findByDop(Date dop);
    List<Products> findByStatus(Boolean status);
}
