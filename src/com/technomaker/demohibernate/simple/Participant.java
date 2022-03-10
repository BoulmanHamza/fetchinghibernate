package com.technomaker.demohibernate.simple;

public class Participant {
	private int id;
	private String nom;
	private Formation formation;
	
	public Participant() {
		super();
	}
	public Participant(String nom, Formation formation) {
		super();
		this.nom = nom;
		this.formation = formation;
	}
	
	public Participant(String nom) {
		super();
		this.nom = nom;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
	
	
	
}
