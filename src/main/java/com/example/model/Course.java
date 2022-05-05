package com.example.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class Course {
	
	@Column(name = "IdC")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value=AccessLevel.NONE)
	private int idC;
	
	@Column(name = "Title")
	@Size(min = 3, max = 30)
	@Pattern(regexp = "[A-Z]{1}[a-z\\s]+", message = "Doesn't corespond to the prefix")
	private String title;
	
	@Min(0)
	@Max(20)
	@Column(name = "CP")
	private int CP;
	
	/*
	//viens-pret-viens
	//join column uz otras klases no mainiga
	@OneToOne
	@JoinColumn(name="IdPr")
	private Professor professor;
	
	//vienam kursam-pret-viens professors
	//daudzi-pret-vienu
	@ManyToOne
	@JoinColumn(name="IdPr")
	private Professor professor2;
	
	
	//vienam kursam vairāki pasniedzeji
	//daudzi-pret-dauziem
	@ManyToMany
	@JoinTable(name="prof_course", joinColumns = @JoinColumn(name="IdPr"), inverseJoinColumns = @JoinColumn(name="IdC"))
	private Collection<Professor> professors;
	*/
	
	public Course(int idC, String title, int cP, int idP) {
		this.idC = idC;
		this.title = title;
		this.CP = cP;
	}
	
	
}
