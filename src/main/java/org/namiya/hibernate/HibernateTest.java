package org.namiya.hibernate;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.namiya.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		//for In Hibernate 4.3
		SessionFactory sessionFactory;
		ServiceRegistry serviceRegistry;
		Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    
	    Query query = session.createQuery("select userName from UserDetails");
	    query.setFirstResult(5);
	    query.setMaxResults(4);
	    List<String> userNames = (List<String>) query.list();
	    
		session.getTransaction().commit();
	    session.close();
	    
	    for (String u: userNames)
	    	System.out.println(u);
	    
	    
	}

}
