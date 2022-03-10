package com.technomaker.demohibernate.dao;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.technomaker.demohibernate.simple.Formation;
import com.technomaker.demohibernate.simple.Participant;
import com.technomaker.demohibernate.simple.util.HibernateUtil;

public class ParticipantDao {
	public void createParticipant(Participant participant) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.save(participant);
		tx.commit();
		session.close();
	}
	
	
}
