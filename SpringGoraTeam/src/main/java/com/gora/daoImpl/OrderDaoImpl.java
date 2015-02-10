package com.gora.daoImpl;

import com.gora.dao.OrderDao;
import com.gora.dominio.Order;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 6:41 PM
 * com.gora.dominio
 */

@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {

	protected OrderDaoImpl() {
		super(Order.class);
		// TODO Auto-generated constructor stub
	}

}
