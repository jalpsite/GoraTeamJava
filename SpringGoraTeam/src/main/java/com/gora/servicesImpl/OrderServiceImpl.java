package com.gora.servicesImpl;

import com.gora.dao.OrderDao;
import com.gora.dominio.Order;
import com.gora.services.OrderService;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 7:29 PM
 * com.gora.dominio
 */

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Inject
    private OrderDao orderDao;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public Order findId(Long id) {
        return orderDao.findById(id);
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = orderDao.findAll();
        return orders;
    }

}
