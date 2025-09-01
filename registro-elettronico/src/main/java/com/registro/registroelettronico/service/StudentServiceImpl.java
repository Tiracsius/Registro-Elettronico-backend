package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.StudentRequestDTO;
import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.entity.Credential;
import com.registro.registroelettronico.entity.ParentInfo;
import com.registro.registroelettronico.entity.SchoolClass;
import com.registro.registroelettronico.entity.StudentInfo;
import com.registro.registroelettronico.exception.ParentNotFoundException;
import com.registro.registroelettronico.exception.SchoolClassNotFoundException;
import com.registro.registroelettronico.exception.StudentNotFoundException;
import com.registro.registroelettronico.mapper.StudentMapper;
import com.registro.registroelettronico.repository.ParentInfoRepository;
import com.registro.registroelettronico.repository.SchoolClassRepository;
import com.registro.registroelettronico.repository.StudentInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentInfoRepository studentInfoRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final ParentInfoRepository parentInfoRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<UserResponseDTO> getAllStudents() {
        List<UserResponseDTO> students = studentInfoRepository.findAll()
                .stream()
                .map(studentMapper::toUserResponse)
                .toList();
        return students;
    }

    @Override
    public UserResponseDTO getStudentById(UUID id) {
        StudentInfo student = studentInfoRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        return studentMapper.toUserResponse(student);
    }

    @Override
    public UserResponseDTO getStudentByCredentialId(UUID credentialId) {
        StudentInfo student = studentInfoRepository.findByCredentialId(credentialId)
                .orElseThrow(() -> new StudentNotFoundException(credentialId));
        return studentMapper.toUserResponse(student);
    }

    @Override
    public UserResponseDTO createStudent(StudentRequestDTO student, Credential credential) {
        ParentInfo parentInfo = parentInfoRepository.findById(student.getParentId())
                .orElseThrow(() -> new ParentNotFoundException(student.getParentId()));
        SchoolClass schoolClass = schoolClassRepository.findById(student.getClassId())
                .orElseThrow(() -> new SchoolClassNotFoundException(student.getClassId()));
        StudentInfo studentInfo = studentMapper.toEntity(student, parentInfo, schoolClass);
        studentInfo.setCredential(credential);
        studentInfo = studentInfoRepository.save(studentInfo);
        return studentMapper.toUserResponse(studentInfo);
    }
}
