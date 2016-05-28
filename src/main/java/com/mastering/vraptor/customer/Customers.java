package com.mastering.vraptor.customer;

import java.util.List;

public interface Customers {

	void saveNew(Customer customer);

	List<Customer> list();
	
}
