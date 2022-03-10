package com.technomaker.demohibernate.service;

import com.technomaker.demohibernate.dao.FormationDao;
import com.technomaker.demohibernate.dao.ParticipantDao;
import com.technomaker.demohibernate.simple.Formation;
import com.technomaker.demohibernate.simple.Participant;

public class GestionnaireFormation {
	FormationDao formationDAO=new FormationDao();
	ParticipantDao participantDAO=new ParticipantDao();
	public Long addFormation(Formation formation) {
		return formationDAO.createFormation(formation);
	}
	public void addParticipant(Participant partcicipant) {
		participantDAO.createParticipant(partcicipant);
	}
	public void affecterFormationaParticipant(Participant participant,Formation formation) {
		participant.setFormation(formation);
		participantDAO.createParticipant(participant);
	}
	

}
