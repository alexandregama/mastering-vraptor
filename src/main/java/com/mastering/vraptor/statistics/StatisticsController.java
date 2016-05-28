package com.mastering.vraptor.statistics;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class StatisticsController {

	@Inject
	private Result result;
	
	@Inject
	private EntityManager manager;
	
	public StatisticsController() {
	}
	
	public StatisticsController(Result result, EntityManager manager) {
		this.result = result;
		this.manager = manager;
	}

	@Get("/statistics/show")
	public void show() {
		Session session = manager.unwrap(Session.class);
		SessionFactory factory = session.getSessionFactory();
		Statistics statistics = factory.getStatistics();
		
		result.include("statistic", statistics);
	}
	
}
