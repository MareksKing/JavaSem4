package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer>{

}
