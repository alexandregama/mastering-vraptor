package com.mastering.vraptor.employee;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class HibernateJpaEmployeesDao implements Employees {

	@Inject
	private EntityManager manager;

	@Deprecated //CDI eyes only
	HibernateJpaEmployeesDao() {
	}
	
	public HibernateJpaEmployeesDao(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void saveNew(Employee employee) {
		manager.persist(employee);
	}

}
