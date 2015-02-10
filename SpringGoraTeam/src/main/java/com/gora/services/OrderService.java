package com.gora.services;

import com.gora.dominio.Order;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:20 PM
 * com.gora.dominio
 */

public interface OrderService {

    public void save(Order order);

    public Order findId(Long id);

    public List<Order> findAll();
}
