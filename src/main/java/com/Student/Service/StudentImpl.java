package com.Student.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Student.Entity.Student;
import com.Student.Repository.StudentRepo;

@Component
public class StudentImpl {

	@Autowired
	private StudentRepo repo;
	
	public Student saveStudent(Student s) {
		return repo.save(s);
	}
	
	public List<Student> getAllStudent(){
		return repo.findAll();
	}
	
	public Optional<Student> getStudentById(int id){
		return repo.findById(id);
	}
	
	public void deleteStudent(int id) {
		repo.deleteById(id);
	}
	
	public List<Student> studentBySub(){
		List<Student> findStudentsWithHindiSubject = repo.findStudentsWithHindiSubject();
		return findStudentsWithHindiSubject;
	}
	
}
