package com.technomaker.demohibernate.simple.util;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {
	 private static SessionFactory sessionFactory;
	    static {
	        try {
				sessionFactory=new Configuration().configure().buildSessionFactory();
			} catch (Throwable e) {
				System.err.println("echec de creation de la sessionFactory : "+e);
			}
	    }
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }    

}
