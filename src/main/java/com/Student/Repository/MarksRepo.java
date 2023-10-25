package com.Student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Student.Entity.Marks;

import jakarta.transaction.Transactional;

public interface MarksRepo extends JpaRepository<Marks, Long> {

	@Modifying
	@Transactional
	@Query(value = "UPDATE marks SET hindi = :newMarks WHERE mid = :mid", nativeQuery = true)
	void updateHindiMarks(@Param("newMarks") Double newMarks, @Param("mid") Long mid);

	@Modifying
	@Transactional
	@Query(value = "UPDATE marks SET english = :newMarks WHERE mid = :mid", nativeQuery = true)
	void updateEnglishMarks(@Param("newMarks") Double newMarks, @Param("mid") Long mid);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE marks SET maths = :newMarks WHERE mid = :mid", nativeQuery = true)
	void updateMathsMarks(@Param("newMarks") Double newMarks, @Param("mid") Long mid);

	@Modifying
	@Transactional
	@Query(value = "UPDATE marks SET sst = :newMarks WHERE mid = :mid", nativeQuery = true)
	void updateSStMarks(@Param("newMarks") Double newMarks, @Param("mid") Long mid);

	@Modifying
	@Transactional
	@Query(value = "UPDATE marks SET science = :newMarks WHERE mid = :mid", nativeQuery = true)
	void updateScienceMarks(@Param("newMarks") Double newMarks, @Param("mid") Long mid);






}
