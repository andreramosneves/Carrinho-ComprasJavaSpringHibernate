package org.com.br.dao;

import java.util.List;

public interface IDao<E> {


	    public void save(E objeto);

	    public void delete(E objeto);

	    public List<E> list();
	    
	    public E find(int Id);
	    
}

