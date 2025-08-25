package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.AuthRequest;
import com.registro.registroelettronico.dto.AuthResponse;
import com.registro.registroelettronico.dto.RegisterRequest;
import com.registro.registroelettronico.entity.*;
import com.registro.registroelettronico.enums.UserRole;
import com.registro.registroelettronico.repository.*;
import com.registro.registroelettronico.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Service responsible for registering new users and authenticating
 * existing ones. It delegates token generation to {@link JwtService}
 * and persists domain specific information based on the user's role.
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final StudentInfoRepository studentInfoRepository;
    private final ParentInfoRepository parentInfoRepository;
    private final TeacherInfoRepository teacherInfoRepository;
    private final SecretaryInfoRepository secretaryInfoRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new IllegalArgumentException("A user with the given username already exists");
        }
        // Build the user entity
        Set<UserRole> roles = new HashSet<>();
        roles.add(request.getRole());
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();
        userRepository.save(user);

        // Create domain specific info based on the role
        switch (request.getRole()) {
            case STUDENT -> {
                StudentInfo student = StudentInfo.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                        .cardId(request.getCardId())
                        .build();
                studentInfoRepository.save(student);
            }
            case PARENT -> {
                ParentInfo parent = ParentInfo.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                        .cardId(request.getCardId())
                        .build();
                parentInfoRepository.save(parent);
            }
            case TEACHER -> {
                TeacherInfo teacher = TeacherInfo.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                        .cardId(request.getCardId())
                        .build();
                teacherInfoRepository.save(teacher);
            }
            case SECRETARY -> {
                SecretaryInfo secretary = SecretaryInfo.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                        .cardId(request.getCardId())
                        .build();
                secretaryInfoRepository.save(secretary);
            }
            default -> {
                // ADMIN registration does not create a domain entity
            }
        }
        String jwt = jwtService.generateToken(user);
        return new AuthResponse(jwt);
    }

    public AuthResponse authenticate(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        String jwt = jwtService.generateToken(user);
        return new AuthResponse(jwt);
    }
}