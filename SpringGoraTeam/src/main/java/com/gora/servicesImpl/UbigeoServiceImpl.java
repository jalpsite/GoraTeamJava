package com.gora.servicesImpl;

import com.gora.dao.UbigeoDao;
import com.gora.dominio.Ubigeo;
import com.gora.services.UbigeoService;

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
public class UbigeoServiceImpl implements UbigeoService {

    @Inject
    private UbigeoDao ubigeoDao;

    @Override
    public void save(Ubigeo ubigeo) {
        ubigeoDao.save(ubigeo);
    }

    @Override
    public void update(Ubigeo ubigeo) {
        ubigeoDao.update(ubigeo);
    }

    @Override
    public List<Ubigeo> findAll() {
        List<Ubigeo> tmp = ubigeoDao.findAll();
        //for (Ubigeo order : tmp) {
        //    Hibernate.initialize(order.getOrders());
       // }
        return tmp;
    }

    @Override
    public Ubigeo findById(Long id) {
        Ubigeo tmp = ubigeoDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

}
