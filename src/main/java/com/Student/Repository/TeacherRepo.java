package com.Student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student.Entity.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Integer>{

}
