package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.model.Grade;
import com.example.demo.model.Student;

public interface IGradeFilter {

	public abstract ArrayList<Grade> filterStudentGrades(Student student);
	
}
