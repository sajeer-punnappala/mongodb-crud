package com.mongodb.mongodb.model;

public class SubjectWiseMarkDetails {

	private String subjectName;
	
	private double totalMark;
	
	private double marksObtained;
	
	private String grade;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public double getTotalMark() {
		return totalMark;
	}

	public void setTotalMark(double totalMark) {
		this.totalMark = totalMark;
	}

	public double getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(double marksObtained) {
		this.marksObtained = marksObtained;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubjectWiseMarkDetails [subjectName=").append(subjectName).append(", totalMark=")
				.append(totalMark).append(", marksObtained=").append(marksObtained).append(", grade=").append(grade)
				.append("]");
		return builder.toString();
	}
	
	
}
