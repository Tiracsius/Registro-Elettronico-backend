package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.HomeworkRequestDTO;
import com.registro.registroelettronico.dto.HomeworkResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface HomeworkService {

    public void createHomework(HomeworkRequestDTO request);
    public List<HomeworkResponseDTO> getAllHomeworkByDueDateAndClassId(LocalDate date, UUID classId);
    public HomeworkResponseDTO getHomeworkByDueDateAndSubjectClassId(LocalDate date, UUID subjectClassId);

}
