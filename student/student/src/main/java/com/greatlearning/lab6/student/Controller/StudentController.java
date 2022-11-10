package com.greatlearning.lab6.student.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.greatlearning.lab6.student.DAO.StudentDAO;
import com.greatlearning.lab6.student.Service.StudentDAOImpl;
import com.greatlearning.lab6.student.Model.Student;

@Controller
@RequestMapping("/Student")
public class StudentController {
	
	@Autowired
	StudentDAOImpl studentDAOimpl;

	@RequestMapping("/Home")
	public String Homepage() {
		return "Home";
	}

	@GetMapping("/Student-List")
	public String fetchAllStudents(Model model) {

		List<Student> studentList = studentDAOimpl.FetchAllStudents();

		model.addAttribute("students", studentList);
		return "Student_List";
	}

	@GetMapping("/Stduent-Form")
	public String AddStduent(Model model) {

		Student student2 = new Student();
		model.addAttribute("Student", student2);
		return "Student-Form";

	}

	@PostMapping("/save")
	public String saveStduent(Model model, @ModelAttribute("Student") Student student) {

		this.studentDAOimpl.Save(student);
		return "redirect:/Student/Student-List/";
	}

	@PutMapping("/{id}")
	public String UpdateStudent(@RequestParam("id") int id) {

		this.studentDAOimpl.SaveorUpdate(id);
		return "redirect:/student/List/";
	}

	@DeleteMapping("/{id}")
	public void DeleteStudent(@RequestParam("id") int id) {

		this.studentDAOimpl.deleteByid(id);
	}
}
