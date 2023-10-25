package com.Student.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Student.Entity.Marks;
import com.Student.Entity.Result;
import com.Student.Entity.Student;
import com.Student.Entity.Subject;
import com.Student.Entity.Teacher;
import com.Student.Service.MarksImpl;
import com.Student.Service.StudentImpl;
import com.Student.Service.TeacherImpl;

@Controller
@RequestMapping("/api")
public class HomeController {

	@Autowired
	private StudentImpl impl;
	@Autowired
	private TeacherImpl impl2;
	@Autowired
	private MarksImpl impl3;

	private Long marksId;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/teacher")
	public String teachers() {
		return "teacher";
	}

	@PostMapping("/marks")
	public String setMarks(@RequestParam("marks") String marks, @RequestParam("stId") String id,
			@RequestParam("subject") String subject, @RequestParam("tid") String tid, Model model) {
		System.out.println(marks);
		System.out.println(id);
		System.out.println(subject);
		System.out.println(tid);
		Optional<Student> aa = impl.getStudentById(Integer.parseInt(id));
		aa.ifPresent(st -> {
			Marks m = st.getMarks();
			marksId = m.getMid();
		});

		switch (subject.toLowerCase()) {
		case "hindi":
			if (impl3.saveHindiMarks(Double.parseDouble(marks), Long.parseLong(id)))
				System.out.println("marks updated successfully");
			break;
		case "english":
			if (impl3.saveEnglishMarks(Double.parseDouble(marks), Long.parseLong(id)))
				System.out.println("marks updated successfully");
			break;
		case "maths":
			if (impl3.saveMathsMarks(Double.parseDouble(marks), Long.parseLong(id)))
				System.out.println("marks updated successfully");
			break;
		case "science":
			if (impl3.saveScienceMarks(Double.parseDouble(marks), Long.parseLong(id)))
				System.out.println("marks updated successfully");
			break;
		case "sst":
			if (impl3.saveSStMarks(Double.parseDouble(marks), Long.parseLong(id)))
				System.out.println("marks updated successfully");
			break;
		default:
			System.out.println("invalid Subject");
		}

		List<Teacher> list = impl2.getAllTeacher();
		model.addAttribute("loop", list);
		return "teacherLogin";
	}

	@GetMapping("/teacher/{id}")
	public String teacherById(@PathVariable("id") String id, Model model) {
		Teacher tea = impl2.getTeacherById(Integer.parseInt(id));
		System.out.println("subject of teacher is " + tea.getSubject());
		model.addAttribute("teacher", tea);

		List<Student> list = impl.studentBySub();
		model.addAttribute("student", list);
		return "/teach";
	}

	@GetMapping("/teachers")
	public String TeacherLogin(Model model) {
		List<Teacher> list = impl2.getAllTeacher();
		model.addAttribute("loop", list);
		return "teacherLogin";
	}

	@GetMapping("/result")
	public String results() {
		return "result";
	}

	@PostMapping("/result")
	public String res(@RequestParam("stid") String id, Model model) {
		Student student = new Student();
		Optional<Student> optional = impl.getStudentById(Integer.parseInt(id));
		optional.ifPresent(st -> {
			student.setId(st.getId());
			student.setName(st.getName());
			student.setLname(st.getLname());
			student.setFname(st.getFname());
			student.setDOB(st.getDOB());
			student.setClas(st.getClas());
			student.setMarks(st.getMarks());
			student.setSubject(st.getSubject());
			student.setSection(st.getSection());
		});
		Result r = new Result();
		r.setStudent_id(student.getId());
		r.setStudent_name(student.getName());
		r.setStudent_lname(student.getLname());
		r.setStudent_fname(student.getFname());
		r.setDob(student.getDOB());
		r.setClas(student.getClas());
		r.setSub1(student.getSubject().getSubject1());
		r.setSub2(student.getSubject().getSubject2());
		r.setSub3(student.getSubject().getSubject3());
		r.setSub4(student.getSubject().getSubject4());
		r.setSub5(student.getSubject().getSubject5());
		r.setM1(student.getMarks().getMaths());
		r.setM2(student.getMarks().getHindi());
		r.setM3(student.getMarks().getEnglish());
		r.setM4(student.getMarks().getScience());
		r.setM5(student.getMarks().getSSt());
		model.addAttribute("res", r);
		return "marksheet";
	}


	@PostMapping("/newstudent")
	public String saveNewStudent(@ModelAttribute Subject subject, @ModelAttribute Student student,
			@RequestParam("dob") String dob, Model model) {
		String clas = student.getClas();
		student.setSubject(subject);
		student.setDOB(dob);
		student.setSection("A");
		Marks m = new Marks("");
		student.setMarks(m);
		switch (clas) {
		case "8":
			student.getSubject().setTeacher_ID(1);
			break;
		case "9":
			student.getSubject().setTeacher_ID(2);
			break;
		case "10":
			student.getSubject().setTeacher_ID(3);
			break;
		case "11":
			student.getSubject().setTeacher_ID(4);
			break;
		case "12":
			student.getSubject().setTeacher_ID(5);
			break;
		default:
			student.getSubject().setTeacher_ID(4);
		}
		if (impl.saveStudent(student).getName() == student.getName()) {
			return "index";
		}
		model.addAttribute("msg", "Registered Successfully");
		return "index";
	}


	@PostMapping("/newTeacher")
	public String saveNewTeacher(@ModelAttribute Teacher t, Model model) {
		if (impl2.saveTeacher(t).getTeacherName() == t.getTeacherName()) {
			model.addAttribute("track", "Register successfully");
			return "/teacher";
		}
		return "teacher";
	}

	public Long getMarksId() {
		return marksId;
	}

	public void setMarksId(Long marksId) {
		this.marksId = marksId;
	}
}
