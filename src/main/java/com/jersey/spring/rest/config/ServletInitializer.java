package com.jersey.spring.rest.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;


@Order(1)
public class ServletInitializer extends AbstractServletInitializer {

	static Logger logger = LogManager.getLogger();

	public ServletInitializer() {
		logger.info("Servlet Initializing.....");
	}

}
