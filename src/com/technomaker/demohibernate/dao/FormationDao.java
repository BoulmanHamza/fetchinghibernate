package com.technomaker.demohibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.technomaker.demohibernate.simple.Formation;
import com.technomaker.demohibernate.simple.Participant;
import com.technomaker.demohibernate.simple.util.HibernateUtil;

public class FormationDao {

	public Long createFormation(Formation formation) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Long n=(Long)session.save(formation);
		tx.commit();
		session.close();
		return n;
	}
	
	public Formation getFormationById(Long formationId) {
			Session session=HibernateUtil.getSessionFactory().openSession();
			Transaction tx=session.beginTransaction();
			String hql = "FROM Formation f where f.id = :formationId";
			Query query = session.createQuery(hql);
			query.setParameter("formationId", formationId);
			List<Formation> results = query.list();
			tx.commit();
			session.close();
			return results.get(0);
	}
	
	public List<Formation> getAllFormation(){
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		String hql = "FROM Formation";
		Query query = session.createQuery(hql);
		List<Formation> results = query.list();
		tx.commit();
		session.close();
		return results;
	}
	
	public void deleteFormationById(Long formationId) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		getFormationById(formationId).getParticipants().forEach(
			  p	-> {
				  Transaction tx=session.beginTransaction();
				  String hql = "DELETE FROM Participant WHERE id = :participantId";
				  Query query = session.createQuery(hql);
				  query.setParameter("participantId", p.getId());
				  query.executeUpdate();
				  tx.commit();
				});
		
		Transaction tx=session.beginTransaction();
		String hql = "DELETE FROM Formation WHERE id = :formationId";
		Query query = session.createQuery(hql);
		query.setParameter("formationId", formationId);
		query.executeUpdate();
		tx.commit();
		session.close();
		
//		Session session=HibernateUtil.getSessionFactory().openSession();
//		Formation formation=getFormationById(formationId);
//		for(Participant p: formation.getParticipants()) {
//			Transaction tx=session.beginTransaction();
//			String hql = "DELETE FROM Participant WHERE id = :participantId";
//			Query query = session.createQuery(hql);
//			query.setParameter("participantId", p.getId());
//			query.executeUpdate();
//			tx.commit();
//		}
//		Transaction tx=session.beginTransaction();
//		String hql = "DELETE FROM Formation WHERE id = :formationId";
//		Query query = session.createQuery(hql);
//		query.setParameter("formationId", formationId);
//		query.executeUpdate();
//		tx.commit();
//		session.close();
	}
	
	public void updateFormationbyId(Long formationId,String titreFormation) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		String hql = "Update Formation set titre=:titreformation WHERE id = :formationId";
		Query query = session.createQuery(hql);
		query.setParameter("titreformation", titreFormation);
		query.setParameter("formationId", formationId);
		query.executeUpdate();
		tx.commit();
		session.close();
	}
	
}
