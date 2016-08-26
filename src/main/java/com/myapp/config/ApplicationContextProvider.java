package com.myapp.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext context)
	        throws BeansException {
		this.applicationContext = context;

	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
