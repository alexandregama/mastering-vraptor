package com.mastering.vraptor.employee;

import javax.inject.Inject;

import com.mastering.vraptor.customer.Customer;
import com.mastering.vraptor.customer.Customers;
import com.mastering.vraptor.jpa.infra.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;

@Controller
public class EmployeeController {
	
	@Inject
	private Employees employees;
	@Inject
	private Customers customers;

	EmployeeController() {
	}
	
	public EmployeeController(Employees employees, Customers customers) {
		this.employees = employees;
		this.customers = customers;
	}

	@Get("/employees/show")
	public String show() {
		return "show";
	}
	
	@Transactional
	@Post("/employees")
	public void save(Employee employee, Customer customer) {
		employees.saveNew(employee);
		customers.saveNew(customer);
	}
	
}
