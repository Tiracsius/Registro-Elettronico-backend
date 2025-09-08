package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.Homework;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**s
 * Repository for Homework entities.
 */
@Repository
public interface HomeworkRepository extends JpaRepository<Homework, UUID> {
    @EntityGraph(attributePaths = {"subjectClass"})
    Optional<Homework> findFirstByDueDateAndSubjectClass_Id(LocalDate date, UUID subjectClassId);
    @EntityGraph(attributePaths = {"subjectClass", "subjectClass.schoolClass"})
    List<Homework> findAllByDueDateAndSubjectClass_SchoolClass_Id(LocalDate date, UUID classId);
}