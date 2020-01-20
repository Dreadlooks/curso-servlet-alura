package br.com.alura.generator.models;

import java.util.Calendar;

public class Company {

	private Long id;
	private String name;
	private Calendar openingDate;
	
	public Company() {}
	
	public Company(String name, Calendar openingDate) {
		super();
		this.name = name;
		this.openingDate = openingDate;
	}
	
	public Company(Long id, String name, Calendar openingDate) {
		super();
		this.id = id;
		this.name = name;
		this.openingDate = openingDate;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Calendar getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Calendar openingDate) {
		this.openingDate = openingDate;
	}	
}
