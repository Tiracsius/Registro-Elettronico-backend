package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.UserRequestDTO;
import com.registro.registroelettronico.entity.Credential;
import com.registro.registroelettronico.repository.CredentialRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CredentialGeneratorServiceImpl implements CredentialGeneratorService {

    private final PasswordEncoder passwordEncoder;
    private final CredentialRepository credentialRepository;


    @Override
    public Credential generateNewCredential(UserRequestDTO request) {
        long count = credentialRepository.count(); // Ensures uniqueness

        String base = String.format(
                "%s%s%s",
                request.getRole().name().toLowerCase(),
                request.getFirstName().toLowerCase(),
                request.getLastName().toLowerCase()
        );

        String username = base + (count + 1) + "@school.com";
        String password = base + (count + 1);

        return Credential.builder().username(username).password(passwordEncoder.encode(password)).role(request.getRole()).build();

    }
}
