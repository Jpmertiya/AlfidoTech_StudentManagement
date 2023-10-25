package com.Student.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.Student.Repository.MarksRepo;

@Configuration
public class MarksImpl {

	@Autowired
	private MarksRepo marksRepo;
	
	public boolean saveHindiMarks(Double marks,Long mid) {
		try {
			marksRepo.updateHindiMarks(marks, mid);
			return true;	
		}catch (Exception e) {
			System.out.println("probleam in marks impl");
		}
			
		return false;
	}
	
	public boolean saveEnglishMarks(Double marks,Long mid) {
		try {
			marksRepo.updateEnglishMarks(marks, mid);
			return true;	
		}catch (Exception e) {
			System.out.println("probleam in marks impl");
		}
			
		return false;
	}
	
	public boolean saveMathsMarks(Double marks,Long mid) {
		try {
			marksRepo.updateMathsMarks(marks, mid);
			return true;	
		}catch (Exception e) {
			System.out.println("probleam in marks impl");
		}
			
		return false;
	}
	
	public boolean saveScienceMarks(Double marks,Long mid) {
		try {
			marksRepo.updateScienceMarks(marks, mid);
			return true;	
		}catch (Exception e) {
			System.out.println("probleam in marks impl");
		}
			
		return false;
	}
	
	public boolean saveSStMarks(Double marks,Long mid) {
		try {
			marksRepo.updateSStMarks(marks, mid);
			return true;	
		}catch (Exception e) {
			System.out.println("probleam in marks impl");
		}
			
		return false;
	}
}
