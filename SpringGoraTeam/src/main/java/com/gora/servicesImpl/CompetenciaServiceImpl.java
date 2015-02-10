package com.gora.servicesImpl;

import com.gora.dao.CompetenciaDao;
import com.gora.dominio.Competencia;
import com.gora.dominio.Habilidad;
import com.gora.services.CompetenciaService;

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
public class CompetenciaServiceImpl implements CompetenciaService {

    @Inject
    private CompetenciaDao competenciaDao;

    @Override
    public void save(Competencia tarea) {
    	competenciaDao.save(tarea);
    }

    @Override
    public void update(Competencia tarea) {
    	competenciaDao.update(tarea);
    }

    @Override
    public List<Competencia> findAll() {
        List<Competencia> tmp = competenciaDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Competencia findById(Long id) {
    	Competencia tmp = competenciaDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

	@Override
	public List<Habilidad> getHabilidades(Long id) {
		return competenciaDao.getHabilidades(id);
	}

}
