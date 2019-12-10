package org.itstep.dao;

import java.util.List;
import org.itstep.model.Book;

public interface BookDao{
	 
	int save(Book book);

	   Book get(int id);

	   List<Book> list();

	   void update(int id, Book book);

	   void delete(int id);
}
