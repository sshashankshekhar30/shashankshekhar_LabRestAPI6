package com.greatlearning.lab6.student.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.greatlearning.lab6.student.Model.Student;

@Repository
@EnableJpaRepositories
public interface StudentDAO extends JpaRepository<Student, Integer> {
	public void saveStudent(Student student);

	public void DeleteStudent(int id);

	public List<Student> findAll();

	public Student findbyid(int id);

}
