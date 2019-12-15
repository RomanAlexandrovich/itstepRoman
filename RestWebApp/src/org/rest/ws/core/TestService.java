package org.rest.ws.core;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.rest.ws.model.Book;
import org.rest.ws.model.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;





@Path("/book")
@RestController
public class TestService {

	
	@Autowired
	   private BookService bookService;
	
	@GET
	@GetMapping("/{id}")
	public ResponseEntity<Book> getMsg(@PathVariable("id") int id) {

		Book book = bookService.get(id);

		 return ResponseEntity.ok().body(book);

	}
}
