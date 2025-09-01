package com.registro.registroelettronico.service;


import com.registro.registroelettronico.dto.StudentRequestDTO;
import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.entity.Credential;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    public List<UserResponseDTO> getAllStudents();
    public UserResponseDTO getStudentById(UUID id);
    public UserResponseDTO getStudentByCredentialId(UUID credentialId);
    public UserResponseDTO createStudent(StudentRequestDTO student, Credential credential);

}