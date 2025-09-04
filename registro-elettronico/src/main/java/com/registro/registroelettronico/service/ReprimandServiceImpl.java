package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.ReprimandRequestDTO;
import com.registro.registroelettronico.dto.ReprimandResponseDTO;
import com.registro.registroelettronico.entity.Reprimand;
import com.registro.registroelettronico.entity.StudentInfo;
import com.registro.registroelettronico.entity.SubjectClass;
import com.registro.registroelettronico.exception.StudentNotFoundException;
import com.registro.registroelettronico.exception.SubjectNotFoundException;
import com.registro.registroelettronico.mapper.ReprimandMapper;
import com.registro.registroelettronico.repository.ReprimandRepository;
import com.registro.registroelettronico.repository.StudentInfoRepository;
import com.registro.registroelettronico.repository.SubjectClassRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReprimandServiceImpl implements  ReprimandService{

    private final ReprimandRepository reprimandRepository;
    private final ReprimandMapper reprimandMapper;
    private final StudentInfoRepository studentInfoRepository;
    private final SubjectClassRepository subjectClassRepository;


    @Override
    public List<ReprimandResponseDTO> getAllReprimandsByStudentId(UUID studentId) {
        StudentInfo student = studentInfoRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
        List<ReprimandResponseDTO> reprimands = reprimandRepository.findAllByStudent(student)
                .stream()
                .map(reprimandMapper::toDTO)
                .toList();
        return reprimands;
    }

    @Override
    public void createReprimand(ReprimandRequestDTO request) {
        StudentInfo student = studentInfoRepository.findById(request.getStudentId())
                .orElseThrow(() -> new StudentNotFoundException(request.getStudentId()));
        SubjectClass subjectClass = subjectClassRepository.findById(request.getSubjectClassId())
                .orElseThrow(() -> new SubjectNotFoundException(request.getSubjectClassId()));
        Reprimand reprimand = reprimandMapper.toEntity(request, student, subjectClass);
        reprimandRepository.save(reprimand);
    }
}
