package com.gora.dao;

import java.io.Serializable;
import java.util.List;





/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 6:35 PM
 * com.gora.dominio
 */

public interface GenericDao<E extends Serializable> {

	  List <E> findAll();
	    E findById(Long id);
	    void save(E e);
	    void update(E e);
	    void delete(E e);
	   
}
