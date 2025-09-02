package com.registro.registroelettronico;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.registro.registroelettronico.entity.*;
import com.registro.registroelettronico.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.registro.registroelettronico.dto.ParentRequestDTO;
import com.registro.registroelettronico.dto.SecretaryRequestDTO;
import com.registro.registroelettronico.dto.StudentRequestDTO;
import com.registro.registroelettronico.dto.TeacherRequestDTO;
import com.registro.registroelettronico.dto.UserRequestDTO;
import com.registro.registroelettronico.enums.UserRole;
import com.registro.registroelettronico.service.AuthService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner{
	
	private final AuthService authService;
	private final SchoolClassRepository schoolClassRepository;
	private final ParentInfoRepository parentInfoRepository;
	private final TeacherInfoRepository teacherInfoRepository;
	private final SubjectRepository subjectRepository;
	private final SubjectClassRepository subjectClassRepository;
	private final StudentInfoRepository studentInfoRepository;
	private final VoteRecordRepository voteRecordRepository;
	@Override
	public void run(String... args) throws Exception {
	
		// Create Secretary
		UserRequestDTO secretary = SecretaryRequestDTO.builder()
				.role(UserRole.SECRETARY)
				.email("secretary1@gmail.com")
				.firstName("secretary1")
				.lastName("secretary1")
				.build();
		authService.register(secretary);
		// Create Parent
		UserRequestDTO parent1 = ParentRequestDTO.builder()
				.role(UserRole.PARENT)
				.email("parent1@gmail.com")
				.firstName("parent1")
				.lastName("parent1")
				.build();
		authService.register(parent1);
		
		UserRequestDTO parent2 = ParentRequestDTO.builder()
		        .role(UserRole.PARENT)
		        .email("parent2@gmail.com")
		        .firstName("parent2")
		        .lastName("parent2")
		        .build();
		authService.register(parent2);
		
		UserRequestDTO parent3 = ParentRequestDTO.builder()
		        .role(UserRole.PARENT)
		        .email("parent3@gmail.com")
		        .firstName("parent3")
		        .lastName("parent3")
		        .build();
		authService.register(parent3);
		
		// Create Teacher
		UserRequestDTO teacher1 = TeacherRequestDTO.builder()
				.role(UserRole.TEACHER)
				.email("teacher1@gmail.com")
				.firstName("teacher1")
				.lastName("teacher1")
				.build();
		authService.register(teacher1);
				
		UserRequestDTO teacher2 = TeacherRequestDTO.builder()
		        .role(UserRole.TEACHER)
		        .email("teacher2@gmail.com")
		        .firstName("teacher2")
		        .lastName("teacher2")
		        .build();
		authService.register(teacher2);

		UserRequestDTO teacher3 = TeacherRequestDTO.builder()
		        .role(UserRole.TEACHER)
		        .email("teacher3@gmail.com")
		        .firstName("teacher3")
		        .lastName("teacher3")
		        .build();
		authService.register(teacher3);
		List<TeacherInfo> teachers = teacherInfoRepository.findAll();
		// Create Student
		List<SchoolClass> classes = schoolClassRepository.findAll();
		List<ParentInfo> parents = parentInfoRepository.findAll();
		List<Subject> subjects = subjectRepository.findAll();
		AtomicInteger studentCounter = new AtomicInteger(1); 
		AtomicInteger parentIndex = new AtomicInteger(0);  

		classes.forEach(schoolClass -> {
			ParentInfo parent = parents.get(parentIndex.get() / 2 % parents.size());
			UserRequestDTO student = StudentRequestDTO.builder()
			            .role(UserRole.STUDENT)
			            .firstName("student" + studentCounter.get())
			            .lastName("student" + studentCounter.get())
			            .email("student" + studentCounter.getAndIncrement() + "@gmail.com")
			            .birthDate(LocalDate.of(2010, 1, studentCounter.get() % 28 + 1))
			            .parentId(parent.getId())
			            .classId(schoolClass.getId())
			            .build();
			  
			authService.register(student);
		    parentIndex.getAndIncrement();
		});
		
		
		// Create SubjectClass
		List<SubjectClass> subjectClassesRequest = classes.stream()
			    .flatMap(schoolClass ->
			        subjects.stream()
			            .flatMap(subject ->
			                teachers.stream()
			                        .map(teacher -> SubjectClass.builder()
			                            .teacher(teacher)
			                            .schoolClass(schoolClass)
			                            .subject(subject)
			                            .build()
			                        )
			            )
			    )
			    .collect(Collectors.toList());
		subjectClassRepository.saveAll(subjectClassesRequest);

		// Create VoteRecords
		List<SubjectClass> subjectClasses = subjectClassRepository.findAll();
		List<StudentInfo> students = studentInfoRepository.findAll();
		List<VoteRecord> voteRecordsRequest = students.stream()
				.flatMap(student ->
						subjectClasses.stream()
								.map(subjectClass -> VoteRecord.builder()
										.subjectClass(subjectClass)
										.createdAt(LocalDate.now())
										.student(student)
										.vote(Math.random() * 10.0)
										.build()
								)
				)
				.collect(Collectors.toList());
		voteRecordRepository.saveAll(voteRecordsRequest);

	}

}
