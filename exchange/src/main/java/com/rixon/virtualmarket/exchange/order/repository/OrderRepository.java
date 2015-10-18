package com.rixon.virtualmarket.exchange.order.repository;

import com.rixon.virtualmarket.exchange.order.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * This class represents the Order repository
 * User: rixon
 * Date: 20/8/13
 * Time: 10:33 AM
 */
public interface OrderRepository extends CrudRepository<Order,String> {
    List<Order> findByTradeDate(Date tradeDate);
}
