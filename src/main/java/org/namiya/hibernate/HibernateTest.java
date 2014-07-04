package org.namiya.hibernate;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
	    
	    UserDetails exampleUser = new UserDetails();
	    exampleUser.setUserId(5);
	    exampleUser.setUserName("five user");
	    Example example = Example.create(exampleUser).excludeProperty("userName");
/*	    Criteria criteria = session.createCriteria(UserDetails.class)
	    						   .setProjection(Projections.property("UserId"));*/  						  
	    Criteria criteria = session.createCriteria(UserDetails.class)
				   					.add(example);

	    List<UserDetails> users = (List<UserDetails>) criteria.list();
	    
		session.getTransaction().commit();
	    session.close();
	    
	    for (UserDetails u: users)
	    	System.out.println(u.getUserName());
	    
	    
	}

}
