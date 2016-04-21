package com.mastering.vraptor.logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.mastering.vraptor.jpa.infra.EntityManagerProducer;
import com.mastering.vraptor.logger.MyCustomLogger;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

@Controller
public class HelloController {

	@Inject
	private MyCustomLogger logger;
	
	@Path("/index")
	public String index() {
		EntityManager manager = new EntityManagerProducer().getInstance();
		manager.close();
		logger.log("VRaptor is working with JPA configured!");
		
		return "index";
	}
	
}
