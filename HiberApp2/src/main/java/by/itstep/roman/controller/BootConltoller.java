package by.itstep.roman.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //Это что???
public class BootConltoller {
	
	@Autowired
	   private BookService bookService;
	@Autowired
	   private ReaderService readerService;
	
	/*---Add new book---*/
	   @PostMapping("/book")
	   public ResponseEntity<?> saveBook(@RequestBody Book book) {
	      long id = bookService.save(book);
	      return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
	   }

	   /*---Get a book by id---*/
	   @GetMapping("/book/{id}")
	   public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
	      Book book = bookService.get(id);
	      return ResponseEntity.ok().body(book);
	   }

	   /*---get all books---*/
	   @GetMapping("/book")
	   public ResponseEntity<List<Book>> listBook() {
	      List<Book> books = bookService.list();
	      return ResponseEntity.ok().body(books);
	   }

	   /*---Update a book by id---*/
	   @PutMapping("/book/{id}")
	   public ResponseEntity<?> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
	      bookService.update(id, book);
	      return ResponseEntity.ok().body("Book has been updated successfully.");
	   }

	   /*---Delete a book by id---*/
	   @DeleteMapping("/book/{id}")
	   public ResponseEntity<?> deleteBook(@PathVariable("id") int id) {
	      bookService.delete(id);
	      return ResponseEntity.ok().body("Book has been deleted successfully.");
	   }
	   
	   /*---Add new reader---*/
	   @PostMapping("/reader")
	   public ResponseEntity<?> saveReader(@RequestBody Reader reader) {
	      int id = readerService.save(reader);
	      return ResponseEntity.ok().body("New Reader has been saved with ID:" + id);
	   }

	   /*---Get a reader by id---*/
	   @GetMapping("/reader/{id}")
	   public ResponseEntity<Reader> getReader(@PathVariable("id") int id) {
		   Reader reader = readerService.get(id);
	      return ResponseEntity.ok().body(reader);
	   }

	   /*---get all books---*/
	   @GetMapping("/reader")
	   public ResponseEntity<List<Reader>> listReader() {
	      List<Reader> readers = readerService.list();
	      return ResponseEntity.ok().body(readers);
	   }

	   /*---Update a book by id---*/
	   @PutMapping("/reader/{id}")
	   public ResponseEntity<?> updateReader(@PathVariable("id") int id, @RequestBody Reader reader) {
	      readerService.update(id, reader);
	      return ResponseEntity.ok().body("Book has been updated successfully.");
	   }

	   /*---Delete a book by id---*/
	   @DeleteMapping("/reader/{id}")
	   public ResponseEntity<?> deleteReader(@PathVariable("id") int id) {
	      bookService.delete(id);
	      return ResponseEntity.ok().body("Book has been deleted successfully.");
	   }
}
