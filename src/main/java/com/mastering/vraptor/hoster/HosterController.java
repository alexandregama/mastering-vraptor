package com.mastering.vraptor.hoster;

import javax.inject.Inject;

import com.mastering.vraptor.jpa.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;

@Controller
public class HosterController {

	@Inject
	private Hosters hosters;
	
	@Get
	@Path("/hosters/show")
	public String show() {
		return "show";
	}
	
	@Transactional
	@Post
	@Path("/hosters")
	public void save(Hoster hoster) {
		hosters.saveNew(hoster);
	}
	
}
