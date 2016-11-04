package com.student.entity;

public class Attendance {
	
	private String studentId;
	private String courseId;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	private String attenId;
	public String getAttenId() {
		return attenId;
	}
	public void setAttenId(String attenId) {
		this.attenId = attenId;
	}
	public String getAttenDate() {
		return attenDate;
	}
	public void setAttenDate(String attenDate) {
		this.attenDate = attenDate;
	}
	public String getAttenRecord() {
		return attenRecord;
	}
	public void setAttenRecord(String attenRecord) {
		this.attenRecord = attenRecord;
	}
	private String attenDate;
	private String attenRecord;

}
