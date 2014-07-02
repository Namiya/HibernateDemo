package org.namiya.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.namiya.dto.FourWheeler;
import org.namiya.dto.TwoWheeler;
import org.namiya.dto.UserDetails;
import org.namiya.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user= new UserDetails();
		user.setUserName("First User");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
	
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porche");
		car.setStreeingWheel("Porche Steering Wheel");
		
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
	    session.save(vehicle);
	    session.save(bike);
	    session.save(car);
	    session.getTransaction().commit();
	    session.close();
	}

}
