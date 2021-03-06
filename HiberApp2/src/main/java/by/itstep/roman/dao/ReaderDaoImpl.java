package by.itstep.roman.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;

import by.itstep.roman.model.Reader;

public class ReaderDaoImpl implements ReaderDao {
	@Autowired
	   private SessionFactory sessionFactory;

	public int save(Reader reader) {
		sessionFactory.getCurrentSession().save(reader);
	      return reader.getReaderId();
	}

	public Reader get(int id) {
		return sessionFactory.getCurrentSession().get(Reader.class,id);
	}

	public List<Reader> list() {
		Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Reader> cq = cb.createQuery(Reader.class);
	      Root<Reader> root = cq.from(Reader.class);
	      cq.select(root);
	      Query<Reader> query = session.createQuery(cq);
	      return query.getResultList();
	}

	public void update(int id, Reader reader) {
		Session session = sessionFactory.getCurrentSession();
	      Reader reader2 = session.byId(Reader.class).load(id);
	      reader2.setReaderName(reader.getReaderName());
	      reader2.setReaderAge(reader.getReaderAge());;
	      reader2.setReaderBooks(reader.getReaderBooks());
	      session.flush();
		
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
	      Reader reader = session.byId(Reader.class).load(id);
	      session.delete(reader);
		
	}

	


}
