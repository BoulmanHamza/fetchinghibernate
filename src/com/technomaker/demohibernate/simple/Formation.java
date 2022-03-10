package com.technomaker.demohibernate.simple;

import java.util.Set;

public class Formation {
	private Long id;
	private String titre;
	private Set<Participant> participants;
	public Formation() {
		super();
	}
	public Formation(String titre, Set<Participant> participants) {
		super();
		this.titre = titre;
		this.participants = participants;
	}
	
	public Formation(String titre) {
		super();
		this.titre = titre;
	}
	
	@Override
	public String toString() {
		return "Formation [id=" + id + ", titre=" + titre + ", participants=" + participants + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Set<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}
	
	
	
	
		
}
	

