package com.mastering.vraptor.controller;

import javax.inject.Inject;

import com.mastering.vraptor.customer.Customer;
import com.mastering.vraptor.customer.Customers;
import com.mastering.vraptor.jpa.infra.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;

@Controller
public class CustomerController {

	@Inject
	private Customers customers;
	
	@Path("/customers/show")
	public String show() {
		return "show";
	}
	
	@Transactional
	@Post
	@Path("/customers")
	public void save(Customer customer) {
		customers.saveNew(customer);
	}
	
}
