package com.mastering.vraptor.customer;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mastering.vraptor.jpa.infra.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Inject
	private Customers customers;
	
	@Inject
	private Result result;
	
	public CustomerController() {
	}
	
	public CustomerController(Customers customers, Result result) {
		this.customers = customers;
		this.result = result;
	}
	
	@Path("/customers/show")
	public String show() {
		LOGGER.info("Retrieving a list of Customers");
		result.include("customers", customers.list());
		return "show";
	}
	
	@Transactional
	@Post
	@Path("/customers")
	public void save(Customer customer) {
		customers.saveNew(customer);
	}
	
}
