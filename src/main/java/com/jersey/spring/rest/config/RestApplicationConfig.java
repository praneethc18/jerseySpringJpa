package com.jersey.spring.rest.config;

import javax.annotation.Priority;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;


@Priority(value = 1)
public class RestApplicationConfig extends ResourceConfig{
	
	public RestApplicationConfig()
	{
		packages("com.jersey.spring.rest");
		register(MultiPartFeature.class);
	}
}
