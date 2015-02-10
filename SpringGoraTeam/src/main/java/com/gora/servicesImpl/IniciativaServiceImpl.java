package com.gora.servicesImpl;

import com.gora.dao.IniciativaDao;
import com.gora.dominio.Iniciativa;
import com.gora.services.IniciativaService;

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
public class IniciativaServiceImpl implements IniciativaService {

    @Inject
    private IniciativaDao iniciativaDao;

    @Override
    public void save(Iniciativa iniciativa) {
        iniciativaDao.save(iniciativa);
    }

    @Override
    public void update(Iniciativa iniciativa) {
        iniciativaDao.update(iniciativa);
    }

    @Override
    public List<Iniciativa> findAll() {
        List<Iniciativa> tmp = iniciativaDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Iniciativa findById(Long id) {
        Iniciativa tmp = iniciativaDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

}
