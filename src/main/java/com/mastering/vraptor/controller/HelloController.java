package com.mastering.vraptor.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.mastering.vraptor.jpa.infra.JPAUtil;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

@Controller
public class HelloController {

	@Inject
	private MyLogger logger;
	
	@Path("/index")
	public String index() {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.close();
		logger.log("VRaptor is working manolo!");
		
		return "index";
	}
	
}
