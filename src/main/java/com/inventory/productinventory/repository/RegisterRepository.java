package com.inventory.productinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.productinventory.model.Register;

public interface RegisterRepository extends JpaRepository<Register, Long> {
	Register findByEmail(String email);

}