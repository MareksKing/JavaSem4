package com.example.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Grade;
import com.example.demo.repo.IGradeRepo;
import com.example.demo.services.IGradeFilter;

@Service
public class GradeFilterImplementation implements IGradeFilter {

	@Autowired
	private IGradeRepo gradeRepo;
	@Override
	public ArrayList<Grade> filterStudentGrades(int id) {
		ArrayList<Grade> studGrades = gradeRepo.findByStudentIdSt(id);
		return studGrades;
	}

	@Override
	public ArrayList<Grade> filterGradesByCourse(int id) {
		ArrayList<Grade> courseGrades = gradeRepo.findByCourseIdC(id);
		return courseGrades;
	}

	@Override
	public ArrayList<Grade> filterGradesByStudentName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Grade> filterNonPassingGradesAndStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float calcAverageOfCourse(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float calcAverageOfStudent(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
