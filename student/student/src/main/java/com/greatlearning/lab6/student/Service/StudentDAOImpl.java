package com.greatlearning.lab6.student.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.lab6.student.DAO.StudentDAO;
import com.greatlearning.lab6.student.Model.Student;

@Service
public class StudentDAOImpl {

	@Autowired
	StudentDAO sd;
	
	public List<Student> FetchAllStudents() {

		return this.sd.findAll();
	}

	public Student Save(Student student) {
		return this.sd.save(student);
	}

	public Student SaveorUpdate(int id) {

		Optional<Student> studentOptional = sd.findById(id);

		if (studentOptional.isPresent()) {
			return studentOptional.get();
		} else {
			throw new IllegalArgumentException("Invalid Id is entered. You are requested to please enter the correct id");
		}

	}

	public void deleteByid(int id) {

		Optional<Student> studentOptional = sd.findById(id);

		if (studentOptional.isPresent()) {

			this.sd.deleteById(id);
		} else {
			throw new IllegalArgumentException("Invalid Id entered. You are requested to please enter the correct id ");
		}
	}
	
	

}
