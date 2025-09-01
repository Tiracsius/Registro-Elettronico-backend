package com.registro.registroelettronico.service;

import java.util.List;
import java.util.UUID;

import com.registro.registroelettronico.dto.TeacherRequestDTO;
import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.entity.Credential;

public interface TeacherService {
	
	public List<UserResponseDTO> getAllTeacher();
	public UserResponseDTO getTeacherById(UUID id);
	public UserResponseDTO getTeacherByCredentialId(UUID credentialId);
	public UserResponseDTO createTeacher(TeacherRequestDTO teacher, Credential credential);
	
}