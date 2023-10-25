package com.Student.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Student.Entity.Teacher;
import com.Student.Repository.TeacherRepo;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

@Component
public class TeacherImpl {

	@Autowired
	private TeacherRepo repo;
	
	public List<Teacher> getAllTeacher() {
		return repo.findAll();
	}
	
	public Teacher getTeacherById(int id){
		Optional<Teacher> t=repo.findById(id);
		Teacher t2=new Teacher();
		t.ifPresent(tea->{
			t2.setSubject(tea.getSubject());
			t2.setTeacherName(tea.getTeacherName());
			t2.setGender(tea.getGender());
			t2.setId(tea.getId());
			t2.setPhone(tea.getPhone());
		});
		return t2;
	}
	
	public Teacher saveTeacher(Teacher t) {
		return repo.save(t);
	}
	
	public void deleteTeacher(int id) {
		repo.deleteById(id);
	}
}
