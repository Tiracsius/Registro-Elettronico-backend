package com.registro.registroelettronico.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.registro.registroelettronico.dto.TeacherRequestDTO;
import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.entity.Credential;
import com.registro.registroelettronico.entity.TeacherInfo;
import com.registro.registroelettronico.exception.TeacherNotFoundException;
import com.registro.registroelettronico.mapper.TeacherMapper;
import com.registro.registroelettronico.repository.TeacherInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{
	
	private final TeacherInfoRepository teacherInfoRepository;
	private final TeacherMapper teacherMapper;
	
	@Override
	public List<UserResponseDTO> getAllTeacher() {
		List<UserResponseDTO> teachers = teacherInfoRepository.findAll()
				.stream()
				.map(teacherMapper::toUserResponse)
				.toList();
		return teachers;
	}

	@Override
	public UserResponseDTO getTeacherById(UUID id) {
		TeacherInfo teacher = teacherInfoRepository.findById(id)
				.orElseThrow(() -> new TeacherNotFoundException(id));
		return teacherMapper.toUserResponse(teacher);
	}

	
	@Override
	public UserResponseDTO getTeacherByCredentialId(UUID credentialId) {
		TeacherInfo teacher = teacherInfoRepository.findByCredentialId(credentialId)
				.orElseThrow(() -> new TeacherNotFoundException(credentialId));
		return teacherMapper.toUserResponse(teacher);
	}
	
	@Override
	public UserResponseDTO createTeacher(TeacherRequestDTO teacher, Credential credential) {
        TeacherInfo teacherInfo = teacherMapper.toEntity(teacher);
        teacherInfo.setCredential(credential);
        teacherInfo = teacherInfoRepository.save(teacherInfo);
		return teacherMapper.toUserResponse(teacherInfo);
	}

}
