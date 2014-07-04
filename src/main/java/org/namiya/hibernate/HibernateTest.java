package org.namiya.hibernate;


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
	    
	    UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
	    session.getTransaction().commit();
	    session.close();
	    
	    session = sessionFactory.openSession();
	    session.beginTransaction();
	    UserDetails user2 = (UserDetails) session.get(UserDetails.class, 1);
	
	    
		session.getTransaction().commit();
	    session.close();
	    

	}

}
