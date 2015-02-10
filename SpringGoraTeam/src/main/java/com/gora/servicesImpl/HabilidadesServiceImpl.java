package com.gora.servicesImpl;

import com.gora.dao.HabilidadesDao;
import com.gora.dominio.Habilidades;
import com.gora.services.HabilidadesService;

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
public class HabilidadesServiceImpl implements HabilidadesService {

    @Inject
    private HabilidadesDao habilidadDao;

    @Override
    public void save(Habilidades habilidad) {
        habilidadDao.save(habilidad);
    }

    @Override
    public void update(Habilidades habilidad) {
        habilidadDao.update(habilidad);
    }

    @Override
    public List<Habilidades> findAll() {
        List<Habilidades> tmp = habilidadDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Habilidades findById(Long id) {
        Habilidades tmp = habilidadDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

	

}
