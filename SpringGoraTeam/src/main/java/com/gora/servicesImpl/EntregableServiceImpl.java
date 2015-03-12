package com.gora.servicesImpl;


import com.gora.dao.EntregableDao;
import com.gora.dominio.Entregable;
import com.gora.services.EntregableService;
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
public class EntregableServiceImpl implements EntregableService {

    @Inject
    private EntregableDao entregableDao;

    @Override
    public void save(Entregable cargo) {
    	entregableDao.save(cargo);
    }

    @Override
    public void update(Entregable cargo) {
    	entregableDao.update(cargo);
    }

    @Override
    public List<Entregable> findAll() {
        List<Entregable> tmp = entregableDao.findAll();       
        return tmp;
    }

    @Override
    public Entregable findById(Long id) {
    	Entregable tmp = entregableDao.findById(id);        
        return tmp;
    }

}
