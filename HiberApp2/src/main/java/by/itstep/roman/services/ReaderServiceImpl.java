package by.itstep.roman.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.itstep.roman.dao.ReaderDao;
import by.itstep.roman.model.Reader;

@Service
@Transactional(readOnly = true)
public class ReaderServiceImpl implements ReaderService{

	@Autowired
	   private ReaderDao readerDao;
	@Override
	public int save(Reader reader) {
		return readerDao.save(reader);
	}

	@Override
	public Reader get(int id) {
		return readerDao.get(id);
	}

	@Override
	public List<Reader> list() {
		return readerDao.list();
	}
@Transactional
	@Override
	public void update(int id, Reader reader) {
		readerDao.update(id, reader);
		
	}
@Transactional
	@Override
	public void delete(int id) {
		readerDao.delete(id);
		
	}

}
