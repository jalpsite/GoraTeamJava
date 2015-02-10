package com.gora.servicesImpl;

import com.gora.dao.TipoproyectoDao;
import com.gora.dominio.Tipoproyecto;
import com.gora.services.TipoproyectoService;

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
public class TipoproyectoServiceImpl implements TipoproyectoService {

    @Inject
    private TipoproyectoDao tipoproyectoDao;

    @Override
    public void save(Tipoproyecto tipoproyecto) {
        tipoproyectoDao.save(tipoproyecto);
    }

    @Override
    public void update(Tipoproyecto tipoproyecto) {
        tipoproyectoDao.update(tipoproyecto);
    }

    @Override
    public List<Tipoproyecto> findAll() {
        List<Tipoproyecto> tmp = tipoproyectoDao.findAll();
        //for (Tipoproyecto order : tmp) {
        //    Hibernate.initialize(order.getOrders());
       // }
        return tmp;
    }

    @Override
    public Tipoproyecto findById(Long id) {
        Tipoproyecto tmp = tipoproyectoDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

}
