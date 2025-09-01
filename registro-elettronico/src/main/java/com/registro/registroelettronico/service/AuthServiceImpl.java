package com.registro.registroelettronico.service;

import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.registro.registroelettronico.dto.AuthRequest;
import com.registro.registroelettronico.dto.AuthResponse;
import com.registro.registroelettronico.dto.ParentRequestDTO;
import com.registro.registroelettronico.dto.SecretaryRequestDTO;
import com.registro.registroelettronico.dto.StudentRequestDTO;
import com.registro.registroelettronico.dto.TeacherRequestDTO;
import com.registro.registroelettronico.dto.UserRequestDTO;
import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.entity.Credential;
import com.registro.registroelettronico.entity.ParentInfo;
import com.registro.registroelettronico.entity.SchoolClass;
import com.registro.registroelettronico.entity.SecretaryInfo;
import com.registro.registroelettronico.entity.StudentInfo;
import com.registro.registroelettronico.entity.TeacherInfo;
import com.registro.registroelettronico.enums.UserRole;
import com.registro.registroelettronico.exception.EmailAlreadyExistsException;
import com.registro.registroelettronico.exception.ParentNotFoundException;
import com.registro.registroelettronico.exception.SchoolClassNotFoundException;
import com.registro.registroelettronico.exception.SecretaryNotFoundException;
import com.registro.registroelettronico.exception.StudentNotFoundException;
import com.registro.registroelettronico.exception.TeacherNotFoundException;
import com.registro.registroelettronico.mapper.ParentMapper;
import com.registro.registroelettronico.mapper.SecretaryMapper;
import com.registro.registroelettronico.mapper.StudentMapper;
import com.registro.registroelettronico.mapper.TeacherMapper;
import com.registro.registroelettronico.repository.CredentialRepository;
import com.registro.registroelettronico.repository.ParentInfoRepository;
import com.registro.registroelettronico.repository.SchoolClassRepository;
import com.registro.registroelettronico.repository.SecretaryInfoRepository;
import com.registro.registroelettronico.repository.StudentInfoRepository;
import com.registro.registroelettronico.repository.TeacherInfoRepository;
import com.registro.registroelettronico.security.JwtService;

import lombok.RequiredArgsConstructor;

/**
 * Service responsible for registering new users and authenticating
 * existing ones. It delegates token generation to {@link JwtService}
 * and persists domain specific information based on the user's role.
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final TeacherMapper teacherMapper;
    private final SecretaryMapper secretaryMapper;

    private final ParentService parentService;
    private final StudentService studentService;

    private final CredentialGeneratorService credentialGeneratorService;
    private final CredentialRepository credentialRepository;
    private final StudentInfoRepository studentInfoRepository;
    private final ParentInfoRepository parentInfoRepository;
    private final TeacherInfoRepository teacherInfoRepository;
    private final SecretaryInfoRepository secretaryInfoRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Transactional
    @Override
    public void register(UserRequestDTO request) {
        // Check if email already exists
        if (studentInfoRepository.existsByEmail(request.getEmail()) || teacherInfoRepository.existsByEmail(request.getEmail()) ||
                parentInfoRepository.existsByEmail(request.getEmail()) ||
                secretaryInfoRepository.existsByEmail(request.getEmail())) {

            throw new EmailAlreadyExistsException(request.getEmail());
        }

        // Create Credential Object based on the User information
        Credential credential = credentialGeneratorService.generateNewCredential(request);
        credential = credentialRepository.save(credential);

        // Create the Correct User Object based on the role
        switch(credential.getRole()) {
            case STUDENT -> {
            	StudentRequestDTO student = (StudentRequestDTO) request;
                studentService.createStudent(student, credential);
            }
            case PARENT -> {
            	ParentRequestDTO parent = (ParentRequestDTO) request;
                parentService.createParent(parent, credential);
            }
            case TEACHER -> {
                TeacherRequestDTO teacher = (TeacherRequestDTO) request;
                TeacherInfo teacherInfo = teacherMapper.toEntity(teacher);
                teacherInfo.setCredential(credential);
                teacherInfoRepository.save(teacherInfo);
            }
            case SECRETARY -> {
            	SecretaryRequestDTO secretary = (SecretaryRequestDTO) request;
                SecretaryInfo secretaryInfo = secretaryMapper.toEntity(secretary);
                secretaryInfo.setCredential(credential);
                secretaryInfoRepository.save(secretaryInfo);
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
		case STUDENT -> studentService.getStudentByCredentialId(id);
		case PARENT -> parentService.getParentByCredentialId(id);

		case SECRETARY -> {
			SecretaryInfo secretary = secretaryInfoRepository.findByCredentialId(id)
					.orElseThrow(() -> new SecretaryNotFoundException(id));
			yield secretaryMapper.toUserResponse(secretary);
		}
		case TEACHER -> {
			TeacherInfo teacher = teacherInfoRepository.findByCredentialId(id)
					.orElseThrow(() -> new TeacherNotFoundException(id));
			yield teacherMapper.toUserResponse(teacher);
		}
		};
	}
}