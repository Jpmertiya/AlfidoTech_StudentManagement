package com.Student.Entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Marks {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mid;
	
	@ColumnDefault(value = "0")
	private Double English;
	@ColumnDefault(value = "0")
	private Double Hindi;
	@ColumnDefault(value = "0")
	private Double SSt;
	@ColumnDefault(value = "0")
	private Double Maths;
	@ColumnDefault(value = "0")
	private Double Science;
	
	private int st_id;

	public Marks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Marks(String e) {
		this.English=0.0;
	}
	public Marks( Double english, Double hindi, Double sSt, Double maths, Double science, int st_id) {
		super();
		English = english;
		Hindi = hindi;
		SSt = sSt;
		Maths = maths;
		Science = science;
		this.st_id = st_id;
	}

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public Double getEnglish() {
		return English;
	}

	public void setEnglish(Double english) {
		English = english;
	}

	public Double getHindi() {
		return Hindi;
	}

	public void setHindi(Double hindi) {
		Hindi = hindi;
	}

	public Double getSSt() {
		return SSt;
	}

	public void setSSt(Double sSt) {
		SSt = sSt;
	}

	public Double getMaths() {
		return Maths;
	}

	public void setMaths(Double maths) {
		Maths = maths;
	}

	public Double getScience() {
		return Science;
	}

	public void setScience(Double science) {
		Science = science;
	}

	public int getSt_id() {
		return st_id;
	}

	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	
	
	
}
