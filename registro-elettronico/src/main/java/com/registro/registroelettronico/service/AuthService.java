package com.registro.registroelettronico.service;

import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.registro.registroelettronico.dto.AuthRequest;
import com.registro.registroelettronico.dto.AuthResponse;
import com.registro.registroelettronico.dto.RegisterRequest;
import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.entity.Credential;
import com.registro.registroelettronico.entity.ParentInfo;
import com.registro.registroelettronico.entity.SchoolClass;
import com.registro.registroelettronico.entity.SecretaryInfo;
import com.registro.registroelettronico.entity.StudentInfo;
import com.registro.registroelettronico.entity.TeacherInfo;
import com.registro.registroelettronico.enums.UserRole;
import com.registro.registroelettronico.repository.CredentialRepository;
import com.registro.registroelettronico.repository.ParentInfoRepository;
import com.registro.registroelettronico.repository.SchoolClassRepository;
import com.registro.registroelettronico.repository.SecretaryInfoRepository;
import com.registro.registroelettronico.repository.StudentInfoRepository;
import com.registro.registroelettronico.repository.TeacherInfoRepository;
import com.registro.registroelettronico.security.JwtService;

import lombok.RequiredArgsConstructor;

/**
 * Service responsible for registering new users and authenticating existing
 * ones. It delegates token generation to {@link JwtService} and persists domain
 * specific information based on the user's role.
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

	public void register(RegisterRequest request) {
		// Check for existing credentials with the same username
		if (credentialRepository.findByUsername(request.getUsername()).isPresent()) {
			throw new IllegalArgumentException("A user with the given username already exists");
		}
		// Create the credential for authentication
		Credential credential = Credential.builder().username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword())).role(request.getRole()).build();
		credentialRepository.save(credential);

		// Create domain-specific entity based on the requested role
		switch (request.getRole()) {
		case STUDENT -> {
			ParentInfo parent = null;
			if (request.getParentId() != null) {
				parent = parentInfoRepository.findById(request.getParentId()).orElseThrow(
						() -> new IllegalArgumentException("Parent not found with id " + request.getParentId()));
			}
			SchoolClass schoolClass = null;
			if (request.getClassId() != null) {
				schoolClass = schoolClassRepository.findById(request.getClassId()).orElseThrow(
						() -> new IllegalArgumentException("Class not found with id " + request.getClassId()));
			}
			StudentInfo student = StudentInfo.builder().firstName(request.getFirstName())
					.lastName(request.getLastName()).email(request.getEmail()).parent(parent).schoolClass(schoolClass)
					.birthDate(request.getBirthDate()).build();
			student.setCredential(credential);
			studentInfoRepository.save(student);
		}
		case PARENT -> {
			ParentInfo parent = ParentInfo.builder().firstName(request.getFirstName()).lastName(request.getLastName())
					.email(request.getEmail()).build();
			// Assign credential to parent
			parent.setCredential(credential);
			parentInfoRepository.save(parent);
		}
		case TEACHER -> {
			TeacherInfo teacher = TeacherInfo.builder().firstName(request.getFirstName())
					.lastName(request.getLastName()).email(request.getEmail()).build();
			teacher.setCredential(credential);
			teacherInfoRepository.save(teacher);
		}
		case SECRETARY -> {
			SecretaryInfo secretary = SecretaryInfo.builder().firstName(request.getFirstName())
					.lastName(request.getLastName()).email(request.getEmail()).build();
			secretary.setCredential(credential);
			secretaryInfoRepository.save(secretary);
		}
		}

	}

	public AuthResponse authenticate(AuthRequest request) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		Credential credential = (Credential) authentication.getPrincipal();

		String jwt = jwtService.generateToken(credential);
		UserResponseDTO response = getProfileDTOByRole(credential.getId(), credential.getRole());
		return AuthResponse.builder().token(jwt).user(response).build();
	}

	private UserResponseDTO getProfileDTOByRole(UUID id, UserRole role) {
		return switch (role) {
		case STUDENT -> {
			StudentInfo student = studentInfoRepository.findByCredentialId(id)
					.orElseThrow(() -> new RuntimeException("Student not found"));
			yield UserResponseDTO.builder().id(student.getId()).firstName(student.getFirstName())
					.lastName(student.getLastName()).role(UserRole.STUDENT).email(student.getEmail()).build();
		}
		case PARENT -> {
			ParentInfo parent = parentInfoRepository.findByCredentialId(id)
					.orElseThrow(() -> new RuntimeException("Parent not found"));
			yield UserResponseDTO.builder().id(parent.getId()).firstName(parent.getFirstName())
					.lastName(parent.getLastName()).role(UserRole.PARENT).email(parent.getEmail()).build();
		}
		case SECRETARY -> {
			SecretaryInfo secretary = secretaryInfoRepository.findByCredentialId(id)
					.orElseThrow(() -> new RuntimeException("Secretary not found"));
			yield UserResponseDTO.builder().id(secretary.getId()).firstName(secretary.getFirstName())
					.lastName(secretary.getLastName()).role(UserRole.SECRETARY).email(secretary.getEmail()).build();
		}
		case TEACHER -> {
			TeacherInfo teacher = teacherInfoRepository.findByCredentialId(id)
					.orElseThrow(() -> new RuntimeException("Teacher not found"));
			yield UserResponseDTO.builder().id(teacher.getId()).firstName(teacher.getFirstName())
					.lastName(teacher.getLastName()).role(UserRole.TEACHER).email(teacher.getEmail()).build();
		}
		};
	}

}