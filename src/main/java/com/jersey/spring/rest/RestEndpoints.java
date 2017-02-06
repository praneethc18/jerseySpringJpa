package com.jersey.spring.rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jersey.spring.dao.UserDAOImpl;

@Path("/rest")
public class RestEndpoints {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(RestEndpoints.class);

	@Autowired
	UserDAOImpl userDAO;

	
	@GET
	@Produces("text/plain")
	@Path("/ping")
	public Response healthCheck() {
		userDAO.getUsers();
		log.debug("Getting Reference Data Services Health Check ");
		return Response.status(Status.OK).entity("Success : " + new Date()).build();
	}
}