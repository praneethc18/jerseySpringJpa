package com.jersey.spring.rest.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.jersey.spring.config.AppSpringConfig;

public abstract class AbstractServletInitializer implements WebApplicationInitializer {

	protected static final String ENV_KEY = "env";
	protected static final String LOG4J_CONFIG_PROP_KEY = "log4j.configurationFile";
	protected static final String DEFAULT_LOG4J_XML_LOCATION = "log4j2.xml";

	public void onStartup(ServletContext servletContext) throws ServletException {

		setLog4jConfigLocation();
		AnnotationConfigWebApplicationContext springContect = new AnnotationConfigWebApplicationContext();
		// Adding Spring configuration to framework
		springContect.register(AppSpringConfig.class);
		// Below two statements can be validated to remove
		springContect.setServletContext(servletContext);
		servletContext.setInitParameter("contextConfigLocation", "");
		// Spring configuration
		servletContext.addListener(new ContextLoaderListener(springContect));
		// Jersey Servlet configuration
		ServletRegistration.Dynamic jerseyServlet = servletContext.addServlet("JerseyServlet", new ServletContainer());
		jerseyServlet.setInitParameter("javax.ws.rs.Application", RestApplicationConfig.class.getName());
		jerseyServlet.setLoadOnStartup(1);
		jerseyServlet.addMapping("/*");
		jerseyServlet.setAsyncSupported(true);

	}

	protected void setLog4jConfigLocation() {
		String log4jConfigLocation = DEFAULT_LOG4J_XML_LOCATION;
		if (StringUtils.isNotBlank(log4jConfigLocation)) {
			System.out.println("Resolved Log4j Config classpath location ===> " + log4jConfigLocation);
			System.setProperty(LOG4J_CONFIG_PROP_KEY, log4jConfigLocation);
		} else {
			System.out.println("Log4j Config location is empty !! ===> " + log4jConfigLocation);
		}
	}
}
