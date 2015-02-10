package com.gora.servicesImpl;

import com.gora.dao.CronogramaDao;
import com.gora.dominio.Cronograma;
import com.gora.services.CronogramaService;

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
public class CronogramaServiceImpl implements CronogramaService {

    @Inject
    private CronogramaDao cronogramaDao;

    @Override
    public void save(Cronograma cronograma) {
    	cronogramaDao.save(cronograma);
    }

    @Override
    public void update(Cronograma cronograma) {
    	cronogramaDao.update(cronograma);
    }

    @Override
    public List<Cronograma> findAll() {
        List<Cronograma> tmp = cronogramaDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Cronograma findById(Long id) {
    	Cronograma tmp = cronogramaDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

}
