package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.PresenceRecordRequestDTO;
import com.registro.registroelettronico.dto.PresenceRecordResponseDTO;
import com.registro.registroelettronico.enums.PresenceStatus;

import java.util.List;
import java.util.UUID;

public interface PresenceService {

    public List<PresenceRecordResponseDTO> getAllPresenceRecordsByClassId(UUID classId);
    public List<PresenceRecordResponseDTO> getAllPresenceRecordByStudentId(UUID studentId);
    public void createPresenceRecord(List<PresenceRecordRequestDTO> request);
    public void updatePresenceRecord(UUID presenceRecordId, PresenceStatus status);

}