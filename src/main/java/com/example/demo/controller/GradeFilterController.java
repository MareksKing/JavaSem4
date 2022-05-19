package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Grade;
import com.example.demo.services.IGradeFilter;

@Controller
@RequestMapping("/grade/filter")
public class GradeFilterController {

	@Autowired
	private IGradeFilter gradeFilter;
	
	@GetMapping("/student/{id}")
	public String getGradesByStudent(@PathVariable(name = "id") int id, Model model) {
		try {
		ArrayList<Grade> resultArrayList = gradeFilter.filterStudentGrades(id);
		model.addAttribute("package", resultArrayList);
		return "grades-all-page";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/student")
	public String getGradesByStudentName(@RequestParam(name = "vards") String name, Model model) {
		try {
			ArrayList<Grade> resultArrayList = gradeFilter.filterGradesByStudentName(name);
			model.addAttribute("package", resultArrayList);
			return "grades-all-page";
			}catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("errorMSG", e.getMessage());
				return "error-page";
			}
	}
	
	
}
