package com.gora.servicesImpl;

import com.gora.dao.AtributosDao;
import com.gora.dominio.Atributos;
import com.gora.services.AtributosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
public class AtributosServiceImpl implements AtributosService {

    @Autowired
    private AtributosDao atributoDao;

    @Override
    public void save(Atributos atributo) {
    	atributoDao.save(atributo);
    }

    @Override
    public void update(Atributos atributo) {
    	atributoDao.update(atributo);
    }

    @Override
    public List<Atributos> findAll() {
        List<Atributos> tmp = atributoDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Atributos findById(Long id) {
    	Atributos tmp = atributoDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

	@Override
	public boolean eliminarXHabilidad(Long idHabilidad) {
		return atributoDao.eliminarXHabilidad(idHabilidad);
	}

	@Override
	public boolean eliminar(Long idAtributos) {
		return atributoDao.eliminar(idAtributos);
	}

	@Override
	public List<Atributos> getAtributosXPersona(Long idPersona) {
		return atributoDao.getAtributosXPersona(idPersona);
	}

}