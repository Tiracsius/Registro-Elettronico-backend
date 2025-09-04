package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.JustificationRequestDTO;
import com.registro.registroelettronico.dto.JustificationResponseDTO;

import java.util.UUID;

public interface JustificationService {

    public void createJustification(JustificationRequestDTO request);
    public JustificationResponseDTO getJustificationByPresenceRecordId(UUID presenceRecordId);

}
