package com.Student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Student.Entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	@Query(value = "SELECT * FROM student s WHERE s.subject_subject_code IN (SELECT subject_code FROM subject WHERE subject1 = 'Hindi' OR subject2 = 'Hindi' OR subject3 = 'Hindi' OR subject4 = 'Hindi' OR subject5 = 'Hindi')", nativeQuery = true)
	List<Student> findStudentsWithHindiSubject();
}
