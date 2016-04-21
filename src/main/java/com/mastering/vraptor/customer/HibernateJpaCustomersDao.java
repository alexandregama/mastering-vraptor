package com.mastering.vraptor.customer;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@RequestScoped
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

	@Override
	public List<Customer> list() {
		List<Customer> list = manager.createQuery("select c from Customer c", Customer.class).getResultList();
		
		return list;
	}

}
