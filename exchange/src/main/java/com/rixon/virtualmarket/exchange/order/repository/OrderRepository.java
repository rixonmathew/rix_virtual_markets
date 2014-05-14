package com.rixon.virtualmarket.exchange.order.repository;

import com.rixon.virtualmarket.exchange.order.domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * This class represents the Order repository
 * User: rixon
 * Date: 20/8/13
 * Time: 10:33 AM
 */
public interface OrderRepository extends CrudRepository<Order,String> {
}
