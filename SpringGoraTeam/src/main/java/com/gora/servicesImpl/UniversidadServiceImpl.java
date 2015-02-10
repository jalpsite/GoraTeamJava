package com.gora.servicesImpl;

import com.gora.dao.UniversidadDao;
import com.gora.dominio.Universidad;
import com.gora.services.UniversidadService;

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
public class UniversidadServiceImpl implements UniversidadService {

    @Inject
    private UniversidadDao universidadDao;

    @Override
    public void save(Universidad universidad) {
    	universidadDao.save(universidad);
    }

    @Override
    public void update(Universidad universidad) {
    	universidadDao.update(universidad);
    }

    @Override
    public List<Universidad> findAll() {
        List<Universidad> tmp = universidadDao.findAll();
        //for (Proyecto order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Universidad findById(Long id) {
    	Universidad tmp = universidadDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

}