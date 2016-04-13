package com.mastering.vraptor.jpa.infra;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("mastering-vraptor");

	@Produces @RequestScoped
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public void close(@Disposes EntityManager manager) {
		manager.close();
	}
	
}
