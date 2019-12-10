package by.itstep.roman.dao;

import java.util.List;

import by.itstep.roman.model.Reader;




public interface ReaderDao {
	int save(Reader reader);

	Reader get(int id);

	   List<Reader> list();

	   void update(int id, Reader reader);

	   void delete(int id);

}
