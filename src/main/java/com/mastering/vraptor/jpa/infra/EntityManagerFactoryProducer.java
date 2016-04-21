package com.mastering.vraptor.jpa.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProducer {

	@Produces
	@ApplicationScoped
	public EntityManagerFactory getInstance() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mastering-vraptor");
		System.out.println(String.format("Creating a EntityManagerFactory: %s", factory.toString()));
		
		return factory;
	}
	
	public void destroy(@Disposes EntityManagerFactory factory) {
		System.out.println(String.format("Closing a EntityManagerFactory: %s", factory.toString()));
		factory.close();
	}
	
}
