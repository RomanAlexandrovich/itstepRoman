package by.itstep.roman.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.itstep.roman.model.Book;




@Repository
public class BookDaoImpl implements BookDao{
	
	@Autowired
	   private SessionFactory sessionFactory;
		@Override
	   public int save(Book book) {
	      sessionFactory.getCurrentSession().save(book);
	      return book.getBookId();
	   }

		@Override
	   public Book get(int id) {
	      return sessionFactory.getCurrentSession().get(Book.class,id);
	   }
		@Override
	   public List<Book> list() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Book> cq = cb.createQuery(Book.class);
	      Root<Book> root = cq.from(Book.class);
	      cq.select(root);
	      Query<Book> query = session.createQuery(cq);
	      return query.getResultList();
	   }
		@Override
	   public void update(int id, Book book) {
	      Session session = sessionFactory.getCurrentSession();
	      Book book2 = session.byId(Book.class).load(id);
	      book2.setTitle(book.getTitle());
	      book2.setAuthor(book.getAuthor());
	      book2.setCategory(book.getCategory());
	      book2.setPrice(book.getPrice());
	      session.flush();
	   }

		@Override
	   public void delete(int id) {
	      Session session = sessionFactory.getCurrentSession();
	      Book book = session.byId(Book.class).load(id);
	      session.delete(book);
	   }


	

}
