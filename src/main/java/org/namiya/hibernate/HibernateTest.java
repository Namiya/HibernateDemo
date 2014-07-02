package org.namiya.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.namiya.dto.UserDetails;
import org.namiya.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user= new UserDetails();
		user.setUserName("First User");

		Vehicle vehicle = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		vehicle.setVehicleName("Car");
		vehicle2.setVehicleName("Jeep");
		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle2);
		vehicle.setUser(user);
		vehicle2.setUser(user);
		
		
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
	    session.save(vehicle);
	    session.save(vehicle2);
	    session.getTransaction().commit();
	    session.close();
	    
	}

}
