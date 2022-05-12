package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Course;
import com.example.demo.model.Grade;
import com.example.demo.model.ProfDegree;
import com.example.demo.model.Professor;
import com.example.demo.model.Student;
import com.example.demo.repo.ICourseRepo;
import com.example.demo.repo.IGradeRepo;
import com.example.demo.repo.IProfRepo;
import com.example.demo.repo.IStudentRepo;

@SpringBootApplication
public class JavaSem4Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSem4Application.class, args);
	}

	@Bean //visur kur šī annotācija, tiks izsaukts automātiski
	public CommandLineRunner cmdLineRunner(IProfRepo profRepo, IStudentRepo studRepo, ICourseRepo courRepo, IGradeRepo gradRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Professor pr1 = new Professor("Karina", "Skirmante", ProfDegree.master);
				Professor pr2 = new Professor("Mareks", "Robalds", ProfDegree.bachelor);
				profRepo.save(pr1);
				profRepo.save(pr2);
				
				Student std1 = new Student("Emils", "Seflers");
				Student std2 = new Student("Daniels", "Fisers");
				studRepo.save(std1);
				studRepo.save(std2);
				
				Course c1 = new Course("Java programmesana", 2, Arrays.asList(pr1, pr2));
				Course c2 = new Course("Vacu valoda", 2, Arrays.asList(pr2));
				courRepo.save(c1);
				courRepo.save(c2);
				pr1.addNewCourse(c1);
				pr1.addNewCourse(c2);
				profRepo.save(pr1);
				
				pr2.addNewCourse(c2);
				profRepo.save(pr2);
				
				Grade g1 = new Grade(4, std2, c2);
				Grade g2 = new Grade(6, std1, c1);
				gradRepo.save(g1);
				gradRepo.save(g2);
				
			}
		};
	}
}
