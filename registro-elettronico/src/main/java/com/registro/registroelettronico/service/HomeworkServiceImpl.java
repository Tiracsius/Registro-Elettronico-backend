package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.HomeworkRequestDTO;
import com.registro.registroelettronico.dto.HomeworkResponseDTO;
import com.registro.registroelettronico.entity.Homework;
import com.registro.registroelettronico.entity.SubjectClass;
import com.registro.registroelettronico.exception.SubjectNotFoundException;
import com.registro.registroelettronico.mapper.HomeworkMapper;
import com.registro.registroelettronico.repository.HomeworkRepository;
import com.registro.registroelettronico.repository.SubjectClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HomeworkServiceImpl implements HomeworkService{

    private final HomeworkMapper homeworkMapper;
    private final SubjectClassRepository subjectClassRepository;
    private final HomeworkRepository homeworkRepository;

    @Override
    public void createHomework(HomeworkRequestDTO request) {
        SubjectClass subjectClass = subjectClassRepository.findById(request.getSubjectClassId())
                .orElseThrow(() -> new SubjectNotFoundException(request.getSubjectClassId()));
        Homework homework = homeworkMapper.toEntity(request, subjectClass);
        homeworkRepository.save(homework);
    }

    @Override
    public List<HomeworkResponseDTO> getAllHomeworkByDueDateAndClassId(LocalDate date, UUID classId) {
        List<HomeworkResponseDTO> homework = homeworkRepository.findAllByDueDateAndSubjectClass_SchoolClass_Id(date, classId)
                .stream()
                .map(homeworkMapper::toDTO)
                .toList();
        return homework;
    }

    @Override
    public HomeworkResponseDTO getHomeworkByDueDateAndSubjectClassId(LocalDate date, UUID subjectClassId) {
        return homeworkRepository.findFirstByDueDateAndSubjectClass_Id(date, subjectClassId)
                .map(homeworkMapper::toDTO)
                .orElse(null);
    }
}
