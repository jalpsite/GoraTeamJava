package com.gora.dao;

import java.util.List;

import com.gora.dominio.Matriz;

/**
 * Created by IntelliJ IDEA.
 * Author : Jose Alpiste  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

public interface MatrizDao extends GenericDao<Matriz> {	
	public boolean deshabilitarMatriz(Long idMatriz);
	public List<Matriz> getMatricesXPersona(Long idPersona);
	public Matriz getMatrizXPersona(Long idComp, Long idPersona);
}
