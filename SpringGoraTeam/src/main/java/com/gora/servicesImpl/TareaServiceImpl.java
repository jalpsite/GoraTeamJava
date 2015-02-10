package com.gora.servicesImpl;

import com.gora.dao.TareaDao;
import com.gora.dominio.Tarea;
import com.gora.services.TareaService;

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
public class TareaServiceImpl implements TareaService {

    @Inject
    private TareaDao tareaDao;

    @Override
    public void save(Tarea tarea) {
        tareaDao.save(tarea);
    }

    @Override
    public void update(Tarea tarea) {
        tareaDao.update(tarea);
    }

    @Override
    public List<Tarea> findAll() {
        List<Tarea> tmp = tareaDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Tarea findById(Long id) {
        Tarea tmp = tareaDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

}
