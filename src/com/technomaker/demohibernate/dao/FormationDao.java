package com.technomaker.demohibernate.dao;

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
	
	
}
