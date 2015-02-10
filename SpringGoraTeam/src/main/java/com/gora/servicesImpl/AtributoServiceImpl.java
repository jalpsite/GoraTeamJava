package com.gora.servicesImpl;

import com.gora.dao.AtributoDao;
import com.gora.dominio.Atributo;
import com.gora.services.AtributoService;

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
public class AtributoServiceImpl implements AtributoService {

    @Autowired
    private AtributoDao atributoDao;

    @Override
    public void save(Atributo atributo) {
    	atributoDao.save(atributo);
    }

    @Override
    public void update(Atributo atributo) {
    	atributoDao.update(atributo);
    }

    @Override
    public List<Atributo> findAll() {
        List<Atributo> tmp = atributoDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Atributo findById(Long id) {
    	Atributo tmp = atributoDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

}