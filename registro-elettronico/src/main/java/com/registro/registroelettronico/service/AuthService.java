package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.AuthRequest;
import com.registro.registroelettronico.dto.AuthResponse;
import com.registro.registroelettronico.dto.RegisterRequest;
import com.registro.registroelettronico.entity.*;
import com.registro.registroelettronico.repository.*;
import com.registro.registroelettronico.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

/**
 * Service responsible for registering new users and authenticating
 * existing ones. It delegates token generation to {@link JwtService}
 * and persists domain specific information based on the user's role.
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final CredentialRepository credentialRepository;
    private final StudentInfoRepository studentInfoRepository;
    private final ParentInfoRepository parentInfoRepository;
    private final TeacherInfoRepository teacherInfoRepository;
    private final SecretaryInfoRepository secretaryInfoRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        // Check for existing credentials with the same username
        if (credentialRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new IllegalArgumentException("A user with the given username already exists");
        }
        // Create the credential for authentication
        Credential credential = Credential.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        credentialRepository.save(credential);

        // Create domain-specific entity based on the requested role
        switch (request.getRole()) {
            case STUDENT -> {
                ParentInfo parent = null;
                if (request.getParentId() != null) {
                    parent = parentInfoRepository.findById(request.getParentId())
                            .orElseThrow(() -> new IllegalArgumentException("Parent not found with id " + request.getParentId()));
                }
                SchoolClass schoolClass = null;
                if (request.getClassId() != null) {
                    schoolClass = schoolClassRepository.findById(request.getClassId())
                            .orElseThrow(() -> new IllegalArgumentException("Class not found with id " + request.getClassId()));
                }
                StudentInfo student = StudentInfo.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                        .parent(parent)
                        .schoolClass(schoolClass)
                        .enrollmentDate(LocalDate.now())
                        .build();
                studentInfoRepository.save(student);
            }
            case PARENT -> {
                ParentInfo parent = ParentInfo.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                        .build();
                // Assign credential to parent
                parent.setCredential(credential);
                parentInfoRepository.save(parent);
            }
            case TEACHER -> {
                TeacherInfo teacher = TeacherInfo.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                        .build();
                teacher.setCredential(credential);
                teacherInfoRepository.save(teacher);
            }
            case SECRETARY -> {
                SecretaryInfo secretary = SecretaryInfo.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                        .build();
                secretary.setCredential(credential);
                secretaryInfoRepository.save(secretary);
            }
            case ADMIN -> {
                // No domain entity is created for administrators
            }
        }

        // Generate JWT using the newly created credential
        String jwt = jwtService.generateToken(credential);
        return new AuthResponse(jwt);
    }

    public AuthResponse authenticate(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        Credential credential = (Credential) authentication.getPrincipal();
        String jwt = jwtService.generateToken(credential);
        return new AuthResponse(jwt);
    }
}