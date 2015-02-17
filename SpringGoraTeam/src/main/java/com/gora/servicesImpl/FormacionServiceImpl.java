package com.gora.servicesImpl;

import com.gora.dao.FormacionDao;
import com.gora.dominio.Formacion;
import com.gora.services.FormacionService;

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
public class FormacionServiceImpl implements FormacionService {

    @Inject
    private FormacionDao formacionDao;

    @Override
    public void save(Formacion formacion) {
    	formacionDao.save(formacion);
    }

    @Override
    public void update(Formacion formacion) {
    	formacionDao.update(formacion);
    }

    @Override
    public List<Formacion> findAll() {
        List<Formacion> tmp = formacionDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Formacion findById(Long id) {
        Formacion tmp = formacionDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

	@Override
	public List<Formacion> getFormacionPersona(Long idPersona) {
		return formacionDao.getFormacionPersona(idPersona);
	}

	@Override
	public void eliminarFormacion(Long idFormacion) {
		formacionDao.eliminarFormacion(idFormacion);
	}

}
