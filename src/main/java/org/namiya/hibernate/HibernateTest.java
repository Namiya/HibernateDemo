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
	    
	    //String minUserId = "5";
	    //Query query = session.getNamedQuery("UserDetails.byId");
	    Query query = session.getNamedQuery("UserDetails.byName");
	    query.setString(0, "nine");
	    
	    List<UserDetails> users = (List<UserDetails>) query.list();
	    
		session.getTransaction().commit();
	    session.close();
	    
	    for (UserDetails u: users)
	    	System.out.println(u.getUserName());
	    
	    
	}

}
