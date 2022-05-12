package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Professor;

public interface IProfRepo extends CrudRepository<Professor, Integer>{

}
