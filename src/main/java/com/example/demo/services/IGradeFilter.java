package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.model.Grade;


public interface IGradeFilter {

	public abstract ArrayList<Grade> filterStudentGrades(int id);
	public abstract ArrayList<Grade> filterGradesByCourse(int id);
	public abstract ArrayList<Grade> filterGradesByStudentName(String name);
	public abstract ArrayList<Grade> filterNonPassingGradesAndStudents();
	public abstract float calcAverageOfCourse(int id);
	public abstract float calcAverageOfStudent(int id);
	public abstract ArrayList<Grade> filterNonPassingGradesByCourseID(int id);
	
}
