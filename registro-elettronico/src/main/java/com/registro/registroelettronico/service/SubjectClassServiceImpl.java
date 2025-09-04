package com.registro.registroelettronico.service;

import java.util.List;
import java.util.UUID;

import com.registro.registroelettronico.entity.SubjectClass;
import com.registro.registroelettronico.entity.TeacherInfo;
import com.registro.registroelettronico.exception.SubjectNotFoundException;
import com.registro.registroelettronico.exception.TeacherNotFoundException;
import com.registro.registroelettronico.repository.TeacherInfoRepository;
import org.springframework.stereotype.Service;

import com.registro.registroelettronico.dto.SubjectClassResponseDTO;
import com.registro.registroelettronico.mapper.SubjectClassMapper;
import com.registro.registroelettronico.repository.SubjectClassRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class 	SubjectClassServiceImpl implements SubjectClassService{
	
	private final SubjectClassRepository subjectClassRepository;
	private final SubjectClassMapper subjectClassMapper;
	private final TeacherInfoRepository teacherInfoRepository;
	
	@Override
	public List<SubjectClassResponseDTO> getAllSubjectClassByTeacherId(UUID teacherId) {
		List<SubjectClassResponseDTO> subjectClasses = subjectClassRepository.findAllByTeacherId(teacherId)
				.stream()
				.map(subjectClassMapper::toDTO)
				.toList();
		return subjectClasses;
	}

	@Override
	public List<SubjectClassResponseDTO> getAllSubjectClassByClassId(UUID classId) {
		List<SubjectClassResponseDTO> subjectClasses = subjectClassRepository.findAllBySchoolClassId(classId)
				.stream()
				.map(subjectClassMapper::toDTO)
				.toList();

		return subjectClasses;
	}

	@Override
	public void updateSubjectClassById(UUID id, UUID teacherId) {
		TeacherInfo teacher = teacherInfoRepository.findById(teacherId)
				.orElseThrow(() -> new TeacherNotFoundException(teacherId));
		SubjectClass subjectClass = subjectClassRepository.findById(id)
				.orElseThrow(() -> new SubjectNotFoundException(id));

		subjectClass.setTeacher(teacher);
		subjectClassRepository.save(subjectClass);
	}

}
