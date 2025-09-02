package com.registro.registroelettronico.service;


import com.registro.registroelettronico.dto.VoteRecordRequestDTO;
import com.registro.registroelettronico.dto.VoteRecordResponseDTO;
import com.registro.registroelettronico.entity.StudentInfo;
import com.registro.registroelettronico.entity.SubjectClass;
import com.registro.registroelettronico.entity.VoteRecord;
import com.registro.registroelettronico.exception.StudentNotFoundException;
import com.registro.registroelettronico.exception.SubjectNotFoundException;
import com.registro.registroelettronico.mapper.VoteRecordMapper;
import com.registro.registroelettronico.repository.StudentInfoRepository;
import com.registro.registroelettronico.repository.SubjectClassRepository;
import com.registro.registroelettronico.repository.VoteRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VoteRecordServiceImpl implements VoteRecordService{

    private final VoteRecordRepository voteRecordRepository;
    private final StudentInfoRepository studentInfoRepository;
    private final SubjectClassRepository subjectClassRepository;
    private final VoteRecordMapper voteRecordMapper;

    @Override
    public void createVoteRecord(VoteRecordRequestDTO request) {
        StudentInfo student = studentInfoRepository.findById(request.getStudentId())
                .orElseThrow(() -> new StudentNotFoundException(request.getStudentId()));
        SubjectClass subjectClass = subjectClassRepository.findById(request.getSubjectClassId())
                .orElseThrow(() -> new SubjectNotFoundException(request.getSubjectClassId()));

        VoteRecord voteRecord = voteRecordMapper.toEntity(request, student, subjectClass);
        voteRecordRepository.save(voteRecord);
    }

    @Override
    public List<VoteRecordResponseDTO> getAllVoteRecordByStudentIdAndSubjectClassId(UUID studentId, UUID subjectClassId) {
        List<VoteRecordResponseDTO> voteRecords = voteRecordRepository.findAllByStudentIdAndSubjectClassId(studentId, subjectClassId)
                .stream()
                .map(voteRecordMapper::toDTO)
                .toList();
        return voteRecords;
    }

    @Override
    public List<VoteRecordResponseDTO> getAllVoteRecordByStudentId(UUID studentId) {
        List<VoteRecordResponseDTO> voteRecords = voteRecordRepository.findAllByStudentId(studentId)
                .stream()
                .map(voteRecordMapper::toDTO)
                .toList();
        return voteRecords;
    }
}
