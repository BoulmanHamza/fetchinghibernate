package com.technomaker.demohibernate;

import java.util.Set;

import com.technomaker.demohibernate.service.GestionnaireFormation;
import com.technomaker.demohibernate.simple.Formation;
import com.technomaker.demohibernate.simple.Participant;

public class DemoHibernate {

	public static void main(String[] args) {
		GestionnaireFormation gestio=new GestionnaireFormation();
//		Set<Participant> listparticipant = null;
//		gestio.addFormation(new Formation("JAVA"));
//		Formation formation =new Formation("JAVA");
//		gestio.addParticipant(new Participant("hamza",formation));
//		gestio.addParticipant(new Participant("ileas",new Formation("php")));
		Formation formationjava=new Formation("JAVA");
		Long formationjavaId=(Long) gestio.addFormation(formationjava);
		formationjava.setId(formationjavaId);
		Formation formationphp=new Formation("PHP");
		Long formationIdphp=(Long) gestio.addFormation(formationphp);
		formationphp.setId(formationIdphp);
		
		Participant participant1=new Participant("boulman");
		Participant participant2=new Participant("Hamza");
		Participant participant3=new Participant("ileas");
		Participant participant4=new Participant("mouhcin");
		
		
		gestio.affecterFormationaParticipant(participant1, formationjava);
		gestio.affecterFormationaParticipant(participant2, formationphp);
		gestio.affecterFormationaParticipant(participant3, formationphp);
		gestio.affecterFormationaParticipant(participant4, formationjava);
		
		
		
		
	}
}
