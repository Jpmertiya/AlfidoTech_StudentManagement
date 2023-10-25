package com.Student.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Teacher_Id")
    private Integer id;
    @Column(name = "teacher_name")
    private String teacherName;
    @Column(name = "subject")
    private String subject;
    @Column(name = "gender")
    private String gender;
    @Column(name = "phone")
    private String phone;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(Integer id, String teacherName, String subject, String gender, String phone) {
		super();
		this.id = id;
		this.teacherName = teacherName;
		this.subject = subject;
		this.gender = gender;
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teacherName=" + teacherName + ", subject=" + subject + ", gender=" + gender
				+ ", phone=" + phone + "]";
	}
    
}
