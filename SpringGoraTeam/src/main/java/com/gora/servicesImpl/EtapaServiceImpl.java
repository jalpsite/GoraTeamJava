package com.gora.servicesImpl;

import com.gora.dao.EtapaDao;
import com.gora.dominio.Etapa;
import com.gora.services.EtapaService;

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
public class EtapaServiceImpl implements EtapaService {

    @Inject
    private EtapaDao etapaDao;

    @Override
    public void save(Etapa etapa) {
        etapaDao.save(etapa);
    }

    @Override
    public void update(Etapa etapa) {
    	etapaDao.update(etapa);
    }

    @Override
    public List<Etapa> findAll() {
        List<Etapa> tmp = etapaDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Etapa findById(Long id) {
    	Etapa tmp = etapaDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

}
