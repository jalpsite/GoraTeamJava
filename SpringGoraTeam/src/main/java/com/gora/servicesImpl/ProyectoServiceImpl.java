package com.gora.servicesImpl;

import com.gora.dao.ProyectoDao;
import com.gora.dominio.Proyecto;
import com.gora.services.ProyectoService;

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
public class ProyectoServiceImpl implements ProyectoService {

    @Inject
    private ProyectoDao proyectoDao;

    @Override
    public void save(Proyecto proyecto) {
        proyectoDao.save(proyecto);
    }

    @Override
    public void update(Proyecto proyecto) {
        proyectoDao.update(proyecto);
    }

    @Override
    public List<Proyecto> findAll() {
        List<Proyecto> tmp = proyectoDao.findAll();
        //for (Proyecto order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Proyecto findById(Long id) {
        Proyecto tmp = proyectoDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

	@Override
	public List<Proyecto> buscarProyecto(String busqueda) {
		return proyectoDao.buscarProyecto(busqueda);
	}

}