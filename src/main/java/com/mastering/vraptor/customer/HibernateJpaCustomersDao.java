package com.mastering.vraptor.customer;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class HibernateJpaCustomersDao implements Customers {

	@Inject
	private EntityManager manager;
	
	public HibernateJpaCustomersDao() {
	}
	
	public HibernateJpaCustomersDao(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void saveNew(Customer customer) {
		manager.persist(customer);
	}

}
