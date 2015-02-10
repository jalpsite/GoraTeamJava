package com.gora.servicesImpl;

import com.gora.dao.CarreraDao;
import com.gora.dominio.Carrera;
import com.gora.services.CarreraService;

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
public class CarreraServiceImpl implements CarreraService {

    @Inject
    private CarreraDao carreraDao;

    @Override
    public void save(Carrera carrera) {
    	carreraDao.save(carrera);
    }

    @Override
    public void update(Carrera carrera) {
    	carreraDao.update(carrera);
    }

    @Override
    public List<Carrera> findAll() {
        List<Carrera> tmp = carreraDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Carrera findById(Long id) {
    	Carrera tmp = carreraDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

}
