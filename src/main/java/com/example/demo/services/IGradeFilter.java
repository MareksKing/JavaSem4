package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.model.Grade;


public interface IGradeFilter {

	public abstract ArrayList<Grade> filterStudentGrades(int id) throws Exception;
	public abstract ArrayList<Grade> filterGradesByCourse(int id) throws Exception;
	public abstract ArrayList<Grade> filterGradesByStudentName(String name) throws Exception;
	public abstract ArrayList<Grade> filterNonPassingGradesAndStudents();
	public abstract float calcAverageOfCourse(int id) throws Exception;
	public abstract float calcAverageOfStudent(int id) throws Exception;
	public abstract ArrayList<Grade> filterNonPassingGradesByCourseID(int id) throws Exception;
	
}
