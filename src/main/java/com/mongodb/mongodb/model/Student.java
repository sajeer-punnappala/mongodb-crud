package com.mongodb.mongodb.model;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Document(collection = "student")
public class Student {
	
	@Transient
    public static final String SEQUENCE_NAME = "student_sequence";
	
	@Id
	private long id;
	
	@NotNull
	@NotBlank(message = "First Name is mandatory")
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate dob; 
	
	private String division;
	
	private double totalMarksObtained;
	
	private String grade;
	
	private Address address;
	
	private List<SubjectWiseMarkDetails> markDetailList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public double getTotalMarksObtained() {
		return totalMarksObtained;
	}

	public void setTotalMarksObtained(double totalMarksObtained) {
		this.totalMarksObtained = totalMarksObtained;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<SubjectWiseMarkDetails> getMarkDetailList() {
		return markDetailList;
	}

	public void setMarkDetailList(List<SubjectWiseMarkDetails> markDetailList) {
		this.markDetailList = markDetailList;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id=").append(id).append(", firstName=").append(firstName).append(", lastName=")
				.append(lastName).append(", age=").append(age).append(", dob=").append(dob).append(", division=")
				.append(division).append(", totalMarksObtained=").append(totalMarksObtained).append(", grade=")
				.append(grade).append(", address=").append(address).append(", markDetailList=").append(markDetailList)
				.append("]");
		return builder.toString();
	}
	
	

}
