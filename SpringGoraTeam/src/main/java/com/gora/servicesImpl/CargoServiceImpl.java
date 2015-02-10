package com.gora.servicesImpl;

import com.gora.dao.CargoDao;
import com.gora.dominio.Cargo;
import com.gora.services.CargoService;

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
public class CargoServiceImpl implements CargoService {

    @Inject
    private CargoDao cargoDao;

    @Override
    public void save(Cargo cargo) {
        cargoDao.save(cargo);
    }

    @Override
    public void update(Cargo cargo) {
        cargoDao.update(cargo);
    }

    @Override
    public List<Cargo> findAll() {
        List<Cargo> tmp = cargoDao.findAll();
        //for (Client order : tmp) {
        //    Hibernate.initialize(order.getOrders());
        //}
        return tmp;
    }

    @Override
    public Cargo findById(Long id) {
        Cargo tmp = cargoDao.findById(id);
        //Hibernate.initialize(tmp.getOrders());
        return tmp;
    }

}
