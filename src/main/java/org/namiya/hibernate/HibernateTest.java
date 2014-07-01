package org.namiya.hibernate;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.namiya.dto.Address;
import org.namiya.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user= new UserDetails();
		user.setUserName("First User");
		user.setJoinedDate(new Date());
		user.setDescription("Description for the user goes here.");

		Address addr = new Address();
		addr.setStreet("Home Street Name");
		addr.setCity("Home City Name");
		
		Address addr2 = new Address();
		addr2.setStreet("Office Street Name");
		addr2.setCity("Office City Name");
		
		user.setHomeAddress(addr);
		user.setOfficeAddress(addr2);
		
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
	    session.close();
	    
	}

}
