package com.algoriant.sms.dao;

import com.algoriant.sms.model.Student;
import java.util.List;

public interface StudentDAO{
	
	boolean createStudent(Student student);
	int modifyStudent(Student student,int op);
	int removeStudent(Student student);
	Student getStudent(Student student,int id);
	List<Student> getAllStudent(Student student);
	Student getStudentId(Student student);
}