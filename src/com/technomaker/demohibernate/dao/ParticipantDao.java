package com.technomaker.demohibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.technomaker.demohibernate.simple.Formation;
import com.technomaker.demohibernate.simple.Participant;
import com.technomaker.demohibernate.simple.util.HibernateUtil;

public class ParticipantDao {
	public int createParticipant(Participant participant) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		int n=(int) session.save(participant);
		tx.commit();
		session.close();
		return n;
	}
	
	public List<Participant> getAllParticipants(){
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		String hql = "FROM Participant";
		Query query = session.createQuery(hql);
		List<Participant> results = query.list();
		tx.commit();
		session.close();
		return results;
	}
	
	public Participant getParticipantById(int participantId){
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		String hql = "FROM Participant p where p.id = :participantId";
		Query query = session.createQuery(hql);
		query.setParameter("participantId", participantId);
		List<Participant> results = query.list();
		tx.commit();
		session.close();
		return results.get(0);
	}
	
	
	
	
	public void deleteParticipantById(int participantId) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		String hql = "DELETE FROM Participant WHERE id = :participantId";
		Query query = session.createQuery(hql);
		query.setParameter("participantId", participantId);
		query.executeUpdate();
		tx.commit();
		session.close();
	}
	
	
	public void updateParticipantById(int participantId,String nouveauNom) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		String hql = "Update Participant set nom=:nomParticipant WHERE id = :participantId";
		Query query = session.createQuery(hql);
		query.setParameter("nomParticipant", nouveauNom);
		query.setParameter("participantId", participantId);
		query.executeUpdate();
		tx.commit();
		session.close();
	}
	
	
	
	
	
}
