package com.rahulsharma.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rahulsharma.rest.bean.Student;

@RestController
public class StudentController {

	@GetMapping("student")
	public Student getStudent() {
		Student student = new Student(1, "rahul", "sharma");
		return student;

	}

	@GetMapping("students")
	public List<Student> getStudents() {

		List<Student> students = new ArrayList<>();

		students.add(new Student(1, "Rahul", "kumar"));
		students.add(new Student(2, "ram", "sharma"));
		students.add(new Student(3, "shyam", "sahi"));
		students.add(new Student(4, "mrunal", "pandit"));
		return students;
	}

//pathvariable
	// {id}- URI template variable
	@GetMapping("students/{id}/{first-name}/{last-name}")
	public Student studentpathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName,
			@PathVariable("last-name") String lastName) {
		return new Student(studentId, firstName, lastName);
	}
	// @RequestParam

	// http:/localhost:8080/students/query?id=1&firstName=rahul&lastName=sharma
	@GetMapping("students/query")
	public Student studentParam(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
		return new Student(id, firstName, lastName);
	}

	// @postMapping and @RequestBody
	@PostMapping("students/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}

	@PutMapping("students/{id}/update")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	@DeleteMapping("student/{id}")
	String deleteStudent(@PathVariable ("id") int studentId) {
		return "deletede ";
		
		
		
	}

}
