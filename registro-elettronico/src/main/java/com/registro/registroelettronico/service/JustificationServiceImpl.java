package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.JustificationRequestDTO;
import com.registro.registroelettronico.dto.JustificationResponseDTO;
import com.registro.registroelettronico.entity.Justification;
import com.registro.registroelettronico.entity.PresenceRecord;
import com.registro.registroelettronico.enums.PresenceStatus;
import com.registro.registroelettronico.exception.JustificationNotFoundException;
import com.registro.registroelettronico.exception.PresenceRecordNotFoundException;
import com.registro.registroelettronico.mapper.JustificationMapper;
import com.registro.registroelettronico.repository.JustificationRepository;
import com.registro.registroelettronico.repository.PresenceRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JustificationServiceImpl implements JustificationService{

    private final JustificationRepository justificationRepository;
    private final PresenceRecordRepository presenceRecordRepository;
    private final JustificationMapper justificationMapper;

    @Transactional
    @Override
    public void createJustification(JustificationRequestDTO request) {
        PresenceRecord presenceRecord = presenceRecordRepository.findById(request.getPresenceRecordId())
                .orElseThrow(() -> new PresenceRecordNotFoundException(request.getPresenceRecordId()));

        Justification justification = justificationMapper.toEntity(request, presenceRecord);
        justificationRepository.save(justification);
        presenceRecord.setStatus(PresenceStatus.EXCUSED);
        presenceRecordRepository.save(presenceRecord);
    }

    @Override
    public JustificationResponseDTO getJustificationByPresenceRecordId(UUID presenceRecordId) {
        PresenceRecord presenceRecord = presenceRecordRepository.findById(presenceRecordId)
                .orElseThrow(() -> new PresenceRecordNotFoundException(presenceRecordId));

        Justification justification = justificationRepository.findByPresenceRecord(presenceRecord)
                .orElseThrow(() -> new JustificationNotFoundException(presenceRecordId));
        return justificationMapper.toDTO(justification);
    }
}
