package com.inventory.productinventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.inventory.productinventory.config.JwtUtil;
import com.inventory.productinventory.model.LoginRequest;
import com.inventory.productinventory.model.LoginResponse;
import com.inventory.productinventory.model.Register;
import com.inventory.productinventory.service.RegisterService;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtUtil jwtUtil;   

    @PostMapping("/save")
    public Register registerUser(@RequestBody Register register) {
        return registerService.registerUser(register);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        Register user = registerService.findByEmail(request.getEmail());

        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
        String token = jwtUtil.generateToken(user.getEmail());

        return new LoginResponse(token);
    }
}