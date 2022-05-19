package com.example.demo.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer>{

	public abstract ArrayList<Grade> findByStudentIdSt(int id);

	public abstract ArrayList<Grade> findByCourseIdC(int id);

	public abstract ArrayList<Grade> findByStudentName(String name);

	public abstract ArrayList<Grade> findByValueLessThan(int i);

	public abstract ArrayList<Grade> findByCourseIdCAndValueLessThan(int id, int i);

	@Query(value = "SELECT AVG(VALUE) FROM GRADE WHERE IDC = ?1", nativeQuery = true)
	public abstract float calculateAVGByCourseID(int id);

	@Query(value = "SELECT AVG(VALUE) FROM GRADE WHERE IDST = ?1", nativeQuery = true)
	public abstract float calculateAVGByStudentIdSt(int id);


}
