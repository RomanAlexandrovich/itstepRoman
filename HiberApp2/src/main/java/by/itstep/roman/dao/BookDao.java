package by.itstep.roman.dao;

import java.util.List;

import by.itstep.roman.model.Book;

public interface BookDao{
	 
	int save(Book book);

	   Book get(int id);

	   List<Book> list();

	   void update(int id, Book book);

	   void delete(int id);
}
