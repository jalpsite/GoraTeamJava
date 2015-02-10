package com.gora.servicesImpl;

import com.gora.dao.GradoDao;
import com.gora.dominio.Grado;
import com.gora.services.GradoService;
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
public class GradoServiceImpl implements GradoService {

    @Inject
    private GradoDao gradoDao;

    @Override
    public void save(Grado grado) {
        gradoDao.save(grado);
    }

    @Override
    public void update(Grado grado) {
        gradoDao.update(grado);
    }

    @Override
    public List<Grado> findAll() {
        List<Grado> tmp = gradoDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Grado findById(Long id) {
        Grado tmp = gradoDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

}
