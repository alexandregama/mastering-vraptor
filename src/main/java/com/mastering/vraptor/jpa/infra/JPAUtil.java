package com.mastering.vraptor.jpa.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("mastering-vraptor");

	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
}
