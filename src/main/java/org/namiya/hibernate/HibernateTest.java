package org.namiya.hibernate;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.namiya.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user= new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");
		user.setAddress("First User's address");
		user.setJoinedDate(new Date());
		user.setDescription("Description for the user goes here.");
		
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
	    session.save(user);
	    session.getTransaction().commit();
	    session.close();
	    
	    user = null;

	    session = sessionFactory.openSession();
	    session.beginTransaction();
	    user = (UserDetails) session.get(UserDetails.class, 1);
	    System.out.println("User name is: " + user.getUserName());
	    
	}

}
