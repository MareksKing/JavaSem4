package com.example.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class Professor {
	
	//1.mainigie
	@Setter(value=AccessLevel.NONE)
	private int idPr;
	private String name;
	private String surname;
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
