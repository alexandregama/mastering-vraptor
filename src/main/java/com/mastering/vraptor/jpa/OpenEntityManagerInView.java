package com.mastering.vraptor.jpa;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Transactional
public class OpenEntityManagerInView {

	@Inject
	private EntityManager manager;
	
	@AroundInvoke
	public Object transactionInterceptor(InvocationContext ic) throws Exception {
		manager.getTransaction().begin();
		
		Object objectResulted = ic.proceed();
		
		manager.getTransaction().commit();
		
		return objectResulted;
	}
	
}
