package com.tatastrive.erp.JAM.Enterprises.Service.ServiceImplementation;

import com.tatastrive.erp.JAM.Enterprises.Entity.AppUser;
import com.tatastrive.erp.JAM.Enterprises.Repository.AppUserRepository;
import com.tatastrive.erp.JAM.Enterprises.config.JwtService;
import com.tatastrive.erp.JAM.Enterprises.dto.AuthResponse;
import com.tatastrive.erp.JAM.Enterprises.dto.LoginRequest;
import com.tatastrive.erp.JAM.Enterprises.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImplementation {



        @Autowired
        private AppUserRepository appUserRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        private JwtService jwtService;

        public AuthResponse register(RegisterRequest request) {

            AppUser user = new AppUser();


            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setRole(request.getRole());

            AppUser savedUser = appUserRepository.save(user);

            String token = jwtService.generateToken(savedUser.getEmail());

            return new AuthResponse(token, savedUser.getRole().name());
        }

        public AuthResponse login(LoginRequest request) {

            AppUser user = appUserRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("Invalid Email"));

            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                throw new RuntimeException("Invalid Password");
            }

            String token = jwtService.generateToken(request.getEmail());

            return new AuthResponse(token, user.getRole().name());
        }
    }

