package by.itstep.roman.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.itstep.roman.dao.BookDao;
import by.itstep.roman.model.Book;



@Service
@Transactional(readOnly = true)
public class BookServiceImp implements BookService {
	 @Autowired
	   private BookDao bookDao;
	public int save(Book book) {
		return bookDao.save(book);
	}

	public Book get(int id) {
		return bookDao.get(id);
	}

	public List<Book> list() {
		return bookDao.list();
	}
	@Transactional
	public void update(int id, Book book) {
		bookDao.update(id, book);
		
	}
	@Transactional
	public void delete(int id) {
		bookDao.delete(id);
		
	}

}
