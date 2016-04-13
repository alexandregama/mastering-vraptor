package com.mastering.vraptor.hoster;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class HibernateJpaHostersDao implements Hosters {

	@Inject
	private EntityManager manager;

	HibernateJpaHostersDao() {
	}
	
	public HibernateJpaHostersDao(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void saveNew(Hoster hoster) {
		manager.persist(hoster);
	}

}
