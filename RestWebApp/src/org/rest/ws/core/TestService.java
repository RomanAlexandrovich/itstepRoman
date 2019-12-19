package org.rest.ws.core;


import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.rest.ws.model.Person;
@Path("person")
public class TestService {
	
	@GET
	@Path("/{personId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson(@PathParam("personId") int id) {
		Person p = new Person();
		
		p.setName("Roman");
		p.setId(id);
		return p;
	}
	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Person updatePerson(Person personToUpdate) {
		personToUpdate.setName(personToUpdate.getName().toUpperCase());
		return personToUpdate;
	}
}
