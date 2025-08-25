package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.TeacherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for TeacherInfo entities.
 */
@Repository
public interface TeacherInfoRepository extends JpaRepository<TeacherInfo, Long> {
}