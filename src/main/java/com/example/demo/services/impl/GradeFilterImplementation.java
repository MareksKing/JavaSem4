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
		ArrayList<Grade> studentGrades = gradeRepo.findByStudentName(name);
		return studentGrades;
	}

	@Override
	public ArrayList<Grade> filterNonPassingGradesAndStudents() {
		ArrayList<Grade> visiGrades = (ArrayList<Grade>) gradeRepo.findAll();
		ArrayList<Grade> nonPassingGrades = new ArrayList<>();
		for (Grade grade : visiGrades) {
			if(grade.getValue() < 4) {
				nonPassingGrades.add(grade);
			}
		}
		return nonPassingGrades;
	}

	@Override
	public float calcAverageOfCourse(int id) {
		float average = 0f;
		ArrayList<Grade> visiGrades = gradeRepo.findByCourseIdC(id);
		for (Grade grade : visiGrades) {
			average += grade.getValue();
		}
		average = average/visiGrades.size();
		return average;
	}

	@Override
	public float calcAverageOfStudent(int id) {
		float average = 0f;
		ArrayList<Grade> studentGrades = gradeRepo.findByStudentIdSt(id);
		for (Grade grade : studentGrades) {
			average += grade.getValue();
		}
		
		average = average/studentGrades.size();
		return average;
	}

	@Override
	public ArrayList<Grade> filterNonPassingGradesByCourseID(int id) {
		ArrayList<Grade> visiCourseGrades = gradeRepo.findByCourseIdC(id);
		ArrayList<Grade> nonPassingGrades = new ArrayList<Grade>();
		for (Grade grade : visiCourseGrades) {
			if(grade.getValue() < 4) {
				nonPassingGrades.add(grade);
			}
		}
		return nonPassingGrades;
	}

}
