package com.gora.services;
import com.gora.dominio.Cliente;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:02 PM
 * com.gora.dominio
 */

public interface ClientService {

    public void save(Cliente client);

    public void update(Cliente client);

    public Cliente findById(Long id);

    public List<Cliente> findAll();

}
