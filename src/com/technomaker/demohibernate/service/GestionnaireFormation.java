package com.technomaker.demohibernate.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.technomaker.demohibernate.dao.FormationDao;
import com.technomaker.demohibernate.dao.ParticipantDao;
import com.technomaker.demohibernate.simple.Formation;
import com.technomaker.demohibernate.simple.Participant;
import com.technomaker.demohibernate.simple.util.HibernateUtil;

public class GestionnaireFormation {
	FormationDao formationDAO=new FormationDao();
	ParticipantDao participantDAO=new ParticipantDao();
	public Long addFormation(Formation formation) {
		return formationDAO.createFormation(formation);
	}
	public int addParticipant(Participant partcicipant) {
		return participantDAO.createParticipant(partcicipant);
	}
//	public void affecterFormationaParticipant(Participant participant,Formation formation) {
//		participant.setFormation(formation);
//		participantDAO.createParticipant(participant);
////		formation.getParticipants().add(participant);
//	}
	
	public Formation getFormationByParticipant(int participantId){
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		String hql = "FROM Participant p where p.id = :participantId";
		Query query = session.createQuery(hql);
		query.setParameter("participantId", participantId);
		List<Participant> results = query.list();
		Formation formation=results.get(0).getFormation();
		tx.commit();
		session.close();
		return formation;
	}
	
	public void affectParticipantToFormation(int participantId,Long formationId) {
		Participant participant=participantDAO.getParticipantById(participantId);
		Formation formation=formationDAO.getFormationById(formationId);
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		String hql = "Update Participant set formation=:formation WHERE id = :participantId";
		Query query = session.createQuery(hql);
		query.setParameter("formation", formation);
		query.setParameter("participantId", participantId);
		query.executeUpdate();
		tx.commit();
		session.close();
		
	}
	
	public List<Participant> getAllParticipant(){
		return participantDAO.getAllParticipants();
	}
	
	public List<Formation> getAllFormation(){
		return formationDAO.getAllFormation();
	}
	
	public Participant getPartcicipantById(int participantId) {
		return participantDAO.getParticipantById(participantId);
	}
	public Formation getFormationById(Long formationId) {
		return formationDAO.getFormationById(formationId);
	}
	public void deleteParticipantById(int participantId) {
		participantDAO.deleteParticipantById(participantId);
	}
	
	public void updateParticipantById(int participantId,String nouveauNom) {
		participantDAO.updateParticipantById(participantId, nouveauNom);
	}
	
	public void deleteFormationById(Long formationId) {
		formationDAO.deleteFormationById(formationId);
	}
	public void updateFormationById(Long formationById,String titreFormation) {
		formationDAO.updateFormationbyId(formationById, titreFormation);
	}

}
