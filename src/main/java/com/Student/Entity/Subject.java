package com.Student.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subjectCode;

	private String subject1;
	private String subject2;
	private String subject3;
	private String subject4;
	private String subject5;

	private int teacher_ID;

	public int getTeacher_ID() {
		return teacher_ID;
	}

	public void setTeacher_ID(int teacher_ID) {
		this.teacher_ID = teacher_ID;
	}

	public Subject() {
		super();
	}

	public Subject(int subjectCode, String subject1, String subject2, String subject3, String subject4,
			String subject5) {
		super();
		this.subjectCode = subjectCode;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.subject4 = subject4;
		this.subject5 = subject5;
	}

	public int getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubject1() {
		return subject1;
	}

	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}

	public String getSubject2() {
		return subject2;
	}

	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}

	public String getSubject3() {
		return subject3;
	}

	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}

	public String getSubject4() {
		return subject4;
	}

	public void setSubject4(String subject4) {
		this.subject4 = subject4;
	}

	public String getSubject5() {
		return subject5;
	}

	public void setSubject5(String subject5) {
		this.subject5 = subject5;
	}

	@Override
	public String toString() {
		return "Subject [subjectCode=" + subjectCode + ", subject1=" + subject1 + ", subject2=" + subject2
				+ ", subject3=" + subject3 + ", subject4=" + subject4 + ", subject5=" + subject5 + ", teacher_ID="
				+ teacher_ID + "]";
	}

}
