package com.inventory.productinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventory.productinventory.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}