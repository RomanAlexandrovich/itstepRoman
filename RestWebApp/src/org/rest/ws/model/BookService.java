package org.rest.ws.model;

import java.util.List;


public interface BookService {

   int save(Book book);
   Book get(int id);
   List<Book> list();
   void update(int id, Book book);
   void delete(int id);
}
