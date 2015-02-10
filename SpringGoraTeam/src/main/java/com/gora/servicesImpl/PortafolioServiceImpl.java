package com.gora.servicesImpl;

import com.gora.dao.PortafolioDao;
import com.gora.dominio.Portafolio;
import com.gora.services.PortafolioService;

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
public class PortafolioServiceImpl implements PortafolioService {

    @Inject
    private PortafolioDao portafolioDao;

    @Override
    public void save(Portafolio portafolio) {
        portafolioDao.save(portafolio);
    }

    @Override
    public void update(Portafolio portafolio) {
        portafolioDao.update(portafolio);
    }

    @Override
    public List<Portafolio> findAll() {
        List<Portafolio> tmp = portafolioDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Portafolio findById(Long id) {
        Portafolio tmp = portafolioDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

}
