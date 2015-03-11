package com.gora.servicesImpl;

import com.gora.dao.HabilidadDao;
import com.gora.dominio.Atributo;
import com.gora.dominio.Habilidad;
import com.gora.dominio.Habilidades;
import com.gora.services.HabilidadService;

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
public class HabilidadServiceImpl implements HabilidadService {

    @Inject
    private HabilidadDao habilidadDao;

    @Override
    public void save(Habilidad habilidad) {
        habilidadDao.save(habilidad);
    }

    @Override
    public void update(Habilidad habilidad) {
        habilidadDao.update(habilidad);
    }

    @Override
    public List<Habilidad> findAll() {
        List<Habilidad> tmp = habilidadDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Habilidad findById(Long id) {
        Habilidad tmp = habilidadDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }	
    
    @Override
	public List<Atributo> getAtributos(Long id) {
		return habilidadDao.getAtributos(id);
	}

	

	@Override
	public List<Habilidades> getHabilidadesExtracto(Long idPersona,
			Long idCompetencia) {
		return habilidadDao.getHabilidadesExtracto(idPersona, idCompetencia);
	}

	@Override
	public List<Habilidad> getHabilidadXMatriz(Long idMatriz) {
		return habilidadDao.getHabilidadXMatriz(idMatriz);
	}

	@Override
	public boolean eliminarXMatriz(Long idMatriz) {
		return habilidadDao.eliminarXMatriz(idMatriz);
	}

	@Override
	public boolean eliminar(Long idHabilidad) {
		return habilidadDao.eliminar(idHabilidad);
	}

	@Override
	public List<Habilidad> getHabilidadXPersona(Long idPersona) {
		return habilidadDao.getHabilidadXPersona(idPersona);
	}


}
