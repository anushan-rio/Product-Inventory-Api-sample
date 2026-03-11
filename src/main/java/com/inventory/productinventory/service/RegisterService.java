package com.inventory.productinventory.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.inventory.productinventory.model.Register;
import com.inventory.productinventory.repository.RegisterRepository;

@Service
public class RegisterService {
	
	
	@Autowired
    private RegisterRepository registerRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;
	 
	
	 public Register registerUser(Register register) {
		 String encodedPassword = passwordEncoder.encode(register.getPassword());
		 register.setPassword(encodedPassword);

			return registerRepository.save(register);
	    }
	 	
	   public Register findByEmail(String email) {
	        return registerRepository.findByEmail(email);
	    }
}
	