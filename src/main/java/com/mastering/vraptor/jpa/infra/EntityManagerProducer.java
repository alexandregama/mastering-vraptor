package com.mastering.vraptor.jpa.infra;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerProducer {

	@Inject
	private EntityManagerFactory factory;

	@Produces @RequestScoped
	public EntityManager getInstance() {
		EntityManager manager = factory.createEntityManager();
		System.out.println(String.format("Creating a EntityManager: %s", manager.toString()));
		return manager;
	}
	
	public void close(@Disposes EntityManager manager) {
		System.out.println(String.format("Closing a EntityManager: %s", manager.toString()));
		manager.close();
	}
	
}
