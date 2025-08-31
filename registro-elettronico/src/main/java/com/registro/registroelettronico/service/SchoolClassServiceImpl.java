package com.registro.registroelettronico.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.registro.registroelettronico.dto.SchoolClassResponseDTO;
import com.registro.registroelettronico.entity.SchoolClass;
import com.registro.registroelettronico.enums.SchoolClassLabel;
import com.registro.registroelettronico.exception.SchoolClassNotFoundException;
import com.registro.registroelettronico.exception.SchoolClassesAlreadyExistException;
import com.registro.registroelettronico.mapper.SchoolClassMapper;
import com.registro.registroelettronico.repository.SchoolClassRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolClassServiceImpl implements SchoolClassService{
	private final SchoolClassMapper schoolClassMapper;
	private final SchoolClassRepository schoolClassRepository;
	
	
	@Override
	public List<SchoolClassResponseDTO> getAllSchoolClasses() {
		List<SchoolClassResponseDTO> classes = schoolClassRepository.findAll()
				.stream()
				.map(schoolClassMapper::toDTO)
				.toList();
		return classes;
	}

	@Override
	public SchoolClassResponseDTO getSchoolClassById(UUID id) {
		SchoolClass schoolClass = schoolClassRepository.findById(id)
				.orElseThrow(() -> new SchoolClassNotFoundException(id));
		
		return schoolClassMapper.toDTO(schoolClass);
	}

	@Override
	public void createSchoolClasses() {
		LocalDate today = LocalDate.now();
		int year = (today.getMonthValue() > 7) ? today.getYear() : today.getYear() - 1;
		LocalDate yearStart = LocalDate.of(year, 9, 1);
		LocalDate yearEnd = LocalDate.of(year + 1, 6, 30);
		
		if (schoolClassRepository.existsByYearStart(yearStart)) {
			throw new SchoolClassesAlreadyExistException(year);
		}
		List<SchoolClass> schoolClasses = Arrays.stream(SchoolClassLabel.values()).map(schoolClassLabel -> {
			return SchoolClass.builder()
					.name(schoolClassLabel)
					.yearStart(yearStart)
					.yearEnd(yearEnd)
					.build();
		}).toList();
		
		schoolClassRepository.saveAll(schoolClasses);
	}

}
