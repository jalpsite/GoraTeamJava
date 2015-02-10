package com.gora.servicesImpl;

import com.gora.dao.ClientDao;
import com.gora.dominio.Cliente;
import com.gora.services.ClientService;
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
public class ClientServiceImpl implements ClientService {

    @Inject
    private ClientDao clientDao;

    @Override
    public void save(Cliente client) {
        clientDao.save(client);
    }

    @Override
    public void update(Cliente client) {
        clientDao.update(client);
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> tmp = clientDao.findAll();
       
        return tmp;
    }

    @Override
    public Cliente findById(Long id) {
        Cliente tmp = clientDao.findById(id);
        return tmp;
    }

}
