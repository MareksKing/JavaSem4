package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Table
@Entity

public class Professor {
	
	//1.mainigie
	@Column(name = "IdPr")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value=AccessLevel.NONE)
	private int idPr;
	
	@Column(name = "Name")
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[A-Z]{1}[a-z]+", message = "Doesn't corespond to the prefix")
	private String name;
	
	@Column(name = "Surname")
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[A-Z]{1}[a-z]+", message = "Doesn't corespond to the prefix")
	private String surname;
	
	@Column(name = "Degree")
	private ProfDegree degree;
	
	//2.get/set no lombox
	
	//3.konstrutors no lombok
	
	//3.2. konstruktors
	public Professor(int idPr, String name, String surname, ProfDegree degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}
	//4.toString()
	
	
}
