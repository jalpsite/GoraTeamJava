package com.gora.servicesImpl;

import com.gora.dao.MatrizDao;
import com.gora.dominio.Matriz;
import com.gora.services.MatrizService;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:10 PM
 * com.gora.dominio
 */


@Service
@Transactional
public class MatrizServiceImpl implements MatrizService {

    @Inject
    private MatrizDao matrizDao;

    @Override
    public void save(Matriz matriz) {
        matrizDao.save(matriz);
    }

    @Override
    public void update(Matriz matriz) {
        matrizDao.update(matriz);
    }

    @Override
    public List<Matriz> findAll() {
        List<Matriz> tmp = matrizDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Matriz findById(Long id) {
        Matriz tmp = matrizDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

	@Override
	public void desactivarMatriz(Long idCompetencia) {		
		matrizDao.desactivarMatriz(idCompetencia);
	}

}
