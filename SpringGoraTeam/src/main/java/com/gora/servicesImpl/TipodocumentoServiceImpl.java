package com.gora.servicesImpl;

import com.gora.dao.TipodocumentoDao;
import com.gora.dominio.Tipodocumento;
import com.gora.services.TipodocumentoService;

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
public class TipodocumentoServiceImpl implements TipodocumentoService {

    @Inject
    private TipodocumentoDao tipodocumentoDao;

    @Override    
    public void save(Tipodocumento tipodocumento) {
    	tipodocumentoDao.save(tipodocumento);
    }

    @Override    
    public void update(Tipodocumento tipodocumento) {
    	tipodocumentoDao.update(tipodocumento);
    }

    @Override    
    public List<Tipodocumento> findAll() {
        List<Tipodocumento> tmp = tipodocumentoDao.findAll();
        //for (Tipodocumento order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        // }
        return tmp;
    }

    @Override
    public Tipodocumento findById(Long id) {
    	Tipodocumento tmp = tipodocumentoDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

}
