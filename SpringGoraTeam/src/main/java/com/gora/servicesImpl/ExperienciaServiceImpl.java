package com.gora.servicesImpl;

import com.gora.dao.ExperienciaDao;
import com.gora.dominio.Experiencia;
import com.gora.services.ExperienciaService;

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
public class ExperienciaServiceImpl implements ExperienciaService {

    @Inject
    private ExperienciaDao experienciaDao;

    @Override
    public void save(Experiencia experiencia) {
        experienciaDao.save(experiencia);
    }

    @Override
    public void update(Experiencia experiencia) {
        experienciaDao.update(experiencia);
    }

    @Override
    public List<Experiencia> findAll() {
        List<Experiencia> tmp = experienciaDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Experiencia findById(Long id) {
        Experiencia tmp = experienciaDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

	@Override
	public List<Experiencia> getExperienciasPersona(Long idPersona) {
		return experienciaDao.getExperienciasPersona(idPersona);
	}

}
