package com.Student.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	@Column(name = "lname")
	private String Lname;
	@Column(name = "fname")
	private String fname;
	@Column(name = "dob")
	private String dob;
	@Column(name = "class")
	private String clas;
	private String Section;

	@ManyToOne(cascade = CascadeType.ALL)
	private Subject subject;

	@OneToOne(cascade = CascadeType.ALL)
	private Marks marks;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String lname, String fname, String dOB, String clas, String section,
			Subject subject,Marks marks) {
		super();
		this.id = id;
		this.name = name;
		Lname = lname;
		this.fname = fname;
		dob = dOB;
		this.clas = clas;
		Section = section;
		this.subject = subject;
		this.marks=marks;
	}

	public Marks getMarks() {
		return marks;
	}

	public void setMarks(Marks marks) {
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getDOB() {
		return dob;
	}

	public void setDOB(String dOB) {
		dob = dOB;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public String getSection() {
		return Section;
	}

	public void setSection(String section) {
		Section = section;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", Lname=" + Lname + ", fname=" + fname + ", DOB=" + dob
				+ ", clas=" + clas + ", Section=" + Section + ", subject=" + subject + "]";
	}
	
	
}
