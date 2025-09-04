package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.ReprimandRequestDTO;
import com.registro.registroelettronico.dto.ReprimandResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ReprimandService {

    public List<ReprimandResponseDTO> getAllReprimandsByStudentId(UUID studentId);
    public void createReprimand(ReprimandRequestDTO request);

}
