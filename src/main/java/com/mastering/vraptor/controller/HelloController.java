package com.mastering.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

@Controller
public class HelloController {

	@Inject
	private MyLogger logger;
	
	@Path("/index")
	public String index() {
		logger.log("VRaptor is working manolo!");
		
		return "index";
	}
	
}
