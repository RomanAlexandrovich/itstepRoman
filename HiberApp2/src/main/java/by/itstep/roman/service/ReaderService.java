package org.itstep.service;

import java.util.List;

import org.itstep.model.Reader;

public interface ReaderService {
	int save(Reader reader);
	Reader get(int id);
	   List<Reader> list();
	   void update(int id, Reader reader);
	   void delete(int id);

}
