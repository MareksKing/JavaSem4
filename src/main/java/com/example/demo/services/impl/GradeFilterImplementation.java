package com.example.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Grade;
import com.example.demo.repo.ICourseRepo;
import com.example.demo.repo.IGradeRepo;
import com.example.demo.repo.IStudentRepo;
import com.example.demo.services.IGradeFilter;

@Service
public class GradeFilterImplementation implements IGradeFilter {

	@Autowired
	private IGradeRepo gradeRepo;
	
	@Autowired
	private IStudentRepo studentRepo;
	
	@Autowired
	private ICourseRepo courseRepo;
	
	@Override
	public ArrayList<Grade> filterStudentGrades(int id) throws Exception {
		if(!studentRepo.existsById(id)) {throw new Exception("Studenta ID nepastāv");}
		ArrayList<Grade> studGrades = gradeRepo.findByStudentIdSt(id);
		return studGrades;
	}

	@Override
	public ArrayList<Grade> filterGradesByCourse(int id) throws Exception {
		if(!courseRepo.existsById(id)) {throw new Exception("Tads kurss nepastāv");}
		ArrayList<Grade> courseGrades = gradeRepo.findByCourseIdC(id);
		return courseGrades;
	}

	@Override
	public ArrayList<Grade> filterGradesByStudentName(String name) throws Exception {
		if(!studentRepo.existsByName(name)) {throw new Exception("Students ar tādu vārdu nepastāv");}
		ArrayList<Grade> studentGrades = gradeRepo.findByStudentName(name);
		return studentGrades;
	}

	@Override
	public ArrayList<Grade> filterNonPassingGradesAndStudents() {
		return gradeRepo.findByValueLessThan(4);
	}

	@Override
	public float calcAverageOfCourse(int id) throws Exception {
		if(!courseRepo.existsById(id)) {throw new Exception("Nav tads id");}
		return gradeRepo.calculateAVGByCourseID(id);
	}

	@Override
	public float calcAverageOfStudent(int id) throws Exception{
		if(!studentRepo.existsById(id)) {throw new Exception("Students ar tādu ID nepastāv");}
		return gradeRepo.calculateAVGByStudentIdSt(id);
		
	}

	@Override
	public ArrayList<Grade> filterNonPassingGradesByCourseID(int id) throws Exception {
		if(!courseRepo.existsById(id)) {throw new Exception("Tads kurss ar ID neeksistē");}
		return gradeRepo.findByCourseIdCAndValueLessThan(id, 4);
	}

}
