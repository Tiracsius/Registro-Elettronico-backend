package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.*;
import com.registro.registroelettronico.entity.*;
import com.registro.registroelettronico.mapper.ParentMapper;
import com.registro.registroelettronico.mapper.SecretaryMapper;
import com.registro.registroelettronico.mapper.StudentMapper;
import com.registro.registroelettronico.mapper.TeacherMapper;
import com.registro.registroelettronico.repository.*;
import com.registro.registroelettronico.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parent;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * Service responsible for registering new users and authenticating
 * existing ones. It delegates token generation to {@link JwtService}
 * and persists domain specific information based on the user's role.
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final ParentMapper parentMapper;
    private final StudentMapper studentMapper;
    private final TeacherMapper teacherMapper;
    private final SecretaryMapper secretaryMapper;


    private final CredentialGeneratorServiceImpl credentialGeneratorService;
    private final CredentialRepository credentialRepository;
    private final StudentInfoRepository studentInfoRepository;
    private final ParentInfoRepository parentInfoRepository;
    private final TeacherInfoRepository teacherInfoRepository;
    private final SecretaryInfoRepository secretaryInfoRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Transactional
    @Override
    public void register(UserRequestDTO request) {
        // Check if email already exists
        if (studentInfoRepository.existsByEmail(request.getEmail()) || teacherInfoRepository.existsByEmail(request.getEmail()) ||
                parentInfoRepository.existsByEmail(request.getEmail()) ||
                secretaryInfoRepository.existsByEmail(request.getEmail())) {

            // throw new EmailAlreadyExistsException
            throw new RuntimeException("Email already exists");
        }

        // Create Credential Object based on the User information
        Credential credential = credentialGeneratorService.generateNewCredential(request);
        credential = credentialRepository.save(credential);

        // Create the Correct User Object based on the role
        switch(request.getRole()) {
            case STUDENT -> {
                if (!(request instanceof StudentRequestDTO student)) {
                    throw new IllegalArgumentException("Invalid request type for STUDENT role");
                }
                ParentInfo parentInfo = parentInfoRepository.findById(student.getParentId())
                        .orElseThrow(() -> new RuntimeException("Parent not found"));
                SchoolClass schoolClass = schoolClassRepository.findById(student.getClassId())
                        .orElseThrow(() -> new RuntimeException("Class not found"));
                StudentInfo studentInfo = studentMapper.toEntity(student, parentInfo, schoolClass);
                studentInfo.setCredential(credential);
                studentInfoRepository.save(studentInfo);
            }
            case PARENT -> {
                if (!(request instanceof ParentRequestDTO parent)) {
                    throw new IllegalArgumentException("Invalid request type for PARENT role");
                }

                ParentInfo parentInfo = parentMapper.toEntity(parent);
                parentInfo.setCredential(credential);
                parentInfoRepository.save(parentInfo);
            }
            case TEACHER -> {
                if (!(request instanceof TeacherRequestDTO teacher)) {
                    throw new IllegalArgumentException("Invalid request type for TEACHER role");
                }

                TeacherInfo teacherInfo = teacherMapper.toEntity(teacher);
                teacherInfo.setCredential(credential);
                teacherInfoRepository.save(teacherInfo);
            }
            case SECRETARY -> {
                if (!(request instanceof SecretaryRequestDTO secretary)) {
                    throw new IllegalArgumentException("Invalid request type for SECRETARY role");
                }

                SecretaryInfo secretaryInfo = secretaryMapper.toEntity(secretary);
                secretaryInfo.setCredential(credential);
                secretaryInfoRepository.save(secretaryInfo);
            }
        }
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