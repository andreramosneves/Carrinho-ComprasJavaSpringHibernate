package org.com.br.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 
public class HibernateUtil {
	
	private static SessionFactory sessionFactory;

	public static SessionFactory createSessionFactory() {
		if(sessionFactory == null){
		   Configuration configuration = new Configuration();
		   configuration.configure();
		    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    	return sessionFactory;
		}else
			return sessionFactory;
	}
	
	public static void main(String[] args) {
		HibernateUtil.createSessionFactory();
	}
 
}