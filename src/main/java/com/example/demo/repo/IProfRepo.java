package com.example.demo.repo;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Professor;

public interface IProfRepo extends CrudRepository<Professor, Integer>{

}
