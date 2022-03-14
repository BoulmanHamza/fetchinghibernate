package com.technomaker.demohibernate;

import java.util.Set;

import com.technomaker.demohibernate.service.GestionnaireFormation;
import com.technomaker.demohibernate.simple.Formation;
import com.technomaker.demohibernate.simple.Participant;

public class DemoHibernate {

	public static void main(String[] args) {
		GestionnaireFormation gestio=new GestionnaireFormation();
		//save formation
		Formation formationjava=new Formation("JAVA");
		Long formationjavaId=(Long) gestio.addFormation(formationjava);
		formationjava.setId(formationjavaId);
		Formation formationphp=new Formation("PHP");
		Long formationIdphp=(Long) gestio.addFormation(formationphp);
		formationphp.setId(formationIdphp);
		//save participant
		Participant participant1=new Participant("boulman");
		Participant participant2=new Participant("Hamza");
		Participant participant3=new Participant("ileas");
		Participant participant4=new Participant("mouhcin");
		int participantId1=(int) gestio.addParticipant(participant1);
		int participantId2=(int) gestio.addParticipant(participant2);
		int participantId3=(int) gestio.addParticipant(participant3);
		int participantId4=(int) gestio.addParticipant(participant4);
		//affecter participant to formation
		gestio.affectParticipantToFormation(participantId1, formationjavaId);
		gestio.affectParticipantToFormation(participantId2, formationIdphp);
		gestio.affectParticipantToFormation(participantId3, formationIdphp);
		gestio.affectParticipantToFormation(participantId4, formationIdphp);
		// Show All Formations
		for(Formation f:gestio.getAllFormation()) {
			System.out.println(f);
		}
	    //Show All Participants
		for(Participant p:gestio.getAllParticipant()) {
			System.out.println(p);
		}
		//search participant by Id
		System.out.println(gestio.getPartcicipantById(2));
		//search Formation by Id
		System.out.println(gestio.getFormationById(2L));
		//update formation
		gestio.updateFormationById(1L, "JPA");
		//update participants
		gestio.updateParticipantById(2, "hihi");
		//show formation By Participant
		System.out.println(gestio.getFormationByParticipant(participantId1));
		//Delete participant
		gestio.deleteParticipantById(1);
		//delete Formation
		
		gestio.deleteFormationById(2L);
		
		
		
	}
}
