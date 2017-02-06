package com.jersey.spring.rest.async;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.jersey.spring.service.exception.BookNotFoundException;

@Provider
public class BookNotFoundMapper implements ExceptionMapper<BookNotFoundException> {
	
	public Response toResponse(BookNotFoundException e) {
		return Response.status(404).entity(e.getMessage()).type("text/plain").build();
	}
}
