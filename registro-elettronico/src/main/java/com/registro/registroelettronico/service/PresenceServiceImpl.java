package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.PresenceRecordRequestDTO;
import com.registro.registroelettronico.dto.PresenceRecordResponseDTO;
import com.registro.registroelettronico.entity.PresenceRecord;
import com.registro.registroelettronico.entity.StudentInfo;
import com.registro.registroelettronico.enums.PresenceStatus;
import com.registro.registroelettronico.exception.PresenceRecordNotFoundException;
import com.registro.registroelettronico.exception.SchoolClassNotFoundException;
import com.registro.registroelettronico.exception.StudentNotFoundException;
import com.registro.registroelettronico.mapper.PresenceRecordMapper;
import com.registro.registroelettronico.repository.PresenceRecordRepository;
import com.registro.registroelettronico.repository.SchoolClassRepository;
import com.registro.registroelettronico.repository.StudentInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PresenceServiceImpl implements PresenceService{

    private final PresenceRecordRepository presenceRecordRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final StudentInfoRepository studentInfoRepository;
    private final PresenceRecordMapper presenceRecordMapper;

    @Override
    public List<PresenceRecordResponseDTO> getAllPresenceRecordsByClassId(UUID classId) {
        if (!schoolClassRepository.existsById(classId)) {
            throw new SchoolClassNotFoundException(classId);
        }

        List<PresenceRecordResponseDTO> presenceRecords = presenceRecordRepository.findByStudent_SchoolClass_IdAndCreatedAt(classId, LocalDate.now())
                .stream()
                .map(presenceRecordMapper::toDTO)
                .toList();
        return presenceRecords;
    }

    @Override
    public List<PresenceRecordResponseDTO> getAllPresenceRecordByStudentId(UUID studentId) {
        StudentInfo student = studentInfoRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));

        List<PresenceRecordResponseDTO> presenceRecords = presenceRecordRepository.findAllByStudent(student)
                .stream()
                .map(presenceRecordMapper::toDTO)
                .toList();

        return presenceRecords;
    }

    @Transactional
    @Override
    public void createPresenceRecord(List<PresenceRecordRequestDTO> request) {
        List<UUID> studentsIds = request
                .stream()
                .map(PresenceRecordRequestDTO::getStudentId)
                .toList();
        List<StudentInfo> students = studentInfoRepository.findAllById(studentsIds);
        Map<UUID, StudentInfo> studentsMap = students.stream()
                        .collect(Collectors.toMap(StudentInfo::getId, studentInfo -> studentInfo));
        List<PresenceRecord> presenceRecords = request.stream()
                        .map(presenceRecord -> {
                            StudentInfo student = studentsMap.get(presenceRecord.getStudentId());
                            if (student == null) {
                                throw new StudentNotFoundException(presenceRecord.getStudentId());
                            }
                            return presenceRecordMapper.toEntity(presenceRecord, student);
                        })
                        .toList();
        presenceRecordRepository.saveAll(presenceRecords);
    }


    @Override
    public void updatePresenceRecord(UUID presenceRecordId, PresenceStatus status) {
        PresenceRecord presenceRecord = presenceRecordRepository.findById(presenceRecordId)
                .orElseThrow(() -> new PresenceRecordNotFoundException(presenceRecordId));
        presenceRecord.setStatus(status);
        presenceRecordRepository.save(presenceRecord);
    }
}
