package com.tp1.rest.model;

public class Person {
	
	private String name;
	
	
	public Person(String unNom){
		this.name = unNom;
	}
	
	public Person(){
		this.name = "inconnu";
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String unNom){
		this.name = unNom;
	}

}

