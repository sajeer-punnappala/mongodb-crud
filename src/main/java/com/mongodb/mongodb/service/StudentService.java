package com.mongodb.mongodb.service;

import java.util.List;

import com.mongodb.mongodb.exception.StudentNotFoundException;
import com.mongodb.mongodb.model.Student;

public interface StudentService {

	List<Student> retrieveAllStudents();

	Student saveStudentDetails(Student student);

	List<Student> saveAllStudentDetails(List<Student> studentList);

	Student findStudentById(long studentId);

	Student updateStudentDetails(Student student) throws StudentNotFoundException;

	List<Student> findStudentByDivision(String division);

	void deleteStudentById(long id);

	void deleteAllByIds(List<Long> ids);

}
