package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.VoteRecordRequestDTO;
import com.registro.registroelettronico.dto.VoteRecordResponseDTO;

import java.util.List;
import java.util.UUID;

public interface VoteRecordService {

    public void createVoteRecord(VoteRecordRequestDTO request);
    public List<VoteRecordResponseDTO> getAllVoteRecordByStudentIdAndSubjectClassId(UUID studentId, UUID subjectClassId);
    public List<VoteRecordResponseDTO> getAllVoteRecordByStudentId(UUID studentId);

}
