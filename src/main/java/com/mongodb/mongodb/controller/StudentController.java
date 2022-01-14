package com.mongodb.mongodb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.mongodb.exception.StudentNotFoundException;
import com.mongodb.mongodb.model.Student;
import com.mongodb.mongodb.model.StudentResponse;
import com.mongodb.mongodb.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/listAll")
	public ResponseEntity<StudentResponse<List<Student>>> retrieveAllStudents(){
		List<Student> studentList = studentService.retrieveAllStudents();
		return new ResponseEntity<StudentResponse<List<Student>>>(new StudentResponse<List<Student>>(HttpStatus.OK, HttpStatus.OK.value(), studentList, null),HttpStatus.OK);
		
	}
	
	@GetMapping("/find/{studentId}")
	public ResponseEntity<StudentResponse<Student>> findStudentById(@PathVariable("studentId") long studentId){
		Student student = studentService.findStudentById(studentId);
		return new ResponseEntity<StudentResponse<Student>>(new StudentResponse<Student>(HttpStatus.OK, HttpStatus.OK.value(), student, null),HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<StudentResponse<Student>> saveStudentDetails(@Valid @RequestBody Student student){
		Student savedStudent = studentService.saveStudentDetails(student);
		StudentResponse<Student> response = new StudentResponse<Student>(HttpStatus.CREATED,HttpStatus.CREATED.value(), savedStudent, null);
		return new ResponseEntity<StudentResponse<Student>>(response, response.getHttpStatus());
	}
	
	@PostMapping("/saveMany")
	public ResponseEntity<StudentResponse<List<Student>>> saveAllStudentDetails(@Valid @RequestBody List<Student> studentList){
		List<Student> savedStudentList = studentService.saveAllStudentDetails(studentList);
		StudentResponse<List<Student>> response = new StudentResponse<List<Student>>(HttpStatus.CREATED,HttpStatus.CREATED.value(), savedStudentList, null);
		return new ResponseEntity<StudentResponse<List<Student>>>(response, response.getHttpStatus());
	}
	
	@PostMapping("/update")
	public ResponseEntity<StudentResponse<Student>> updateStudentDetails(@Valid @RequestBody Student student) throws StudentNotFoundException{
		Student updatedStudent = studentService.updateStudentDetails(student);
		StudentResponse<Student> response = new StudentResponse<Student>(HttpStatus.OK,HttpStatus.OK.value(), updatedStudent, null);
		return new ResponseEntity<StudentResponse<Student>>(response, response.getHttpStatus());
	}
	
	@GetMapping("/findBy/division/{division}")
	public ResponseEntity<StudentResponse<List<Student>>> findStudentByDivision(@PathVariable("division") String division){
		List<Student> studentList = studentService.findStudentByDivision(division);
		return new ResponseEntity<StudentResponse<List<Student>>>(new StudentResponse<List<Student>>(HttpStatus.OK, HttpStatus.OK.value(), studentList, null),HttpStatus.OK);
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<StudentResponse<String>> deleteStudentById( @PathVariable long id) throws StudentNotFoundException{
		studentService.deleteStudentById(id);
		StudentResponse<String> response = new StudentResponse<String>(HttpStatus.OK,HttpStatus.OK.value(), "Student " + id + " deleted Successfully", null);
		return new ResponseEntity<StudentResponse<String>>(response, response.getHttpStatus());
	}
	
	@PostMapping("/deleteAllByIds")
	public ResponseEntity<StudentResponse<List<Long>>> deleteAllByIds( @RequestBody List<Long> ids){
		studentService.deleteAllByIds(ids);
		StudentResponse<List<Long>> response = new StudentResponse<List<Long>>(HttpStatus.OK,HttpStatus.OK.value(), ids, null);
		return new ResponseEntity<StudentResponse<List<Long>>>(response, response.getHttpStatus());
	}
	
	
}
