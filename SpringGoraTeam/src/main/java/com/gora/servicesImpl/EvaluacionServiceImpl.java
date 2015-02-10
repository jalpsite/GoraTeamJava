package com.gora.servicesImpl;

import com.gora.dao.EvaluacionDao;
import com.gora.dominio.Evaluacion;
import com.gora.services.EvaluacionService;

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
public class EvaluacionServiceImpl implements EvaluacionService {

    @Inject
    private EvaluacionDao evaluacionDao;

    @Override
    public void save(Evaluacion evaluacion) {
        evaluacionDao.save(evaluacion);
    }

    @Override
    public void update(Evaluacion evaluacion) {
        evaluacionDao.update(evaluacion);
    }

    @Override
    public List<Evaluacion> findAll() {
        List<Evaluacion> tmp = evaluacionDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Evaluacion findById(Long id) {
        Evaluacion tmp = evaluacionDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

}
