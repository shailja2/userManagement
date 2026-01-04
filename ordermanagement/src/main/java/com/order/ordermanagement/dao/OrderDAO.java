package com.order.ordermanagement.dao;

import com.order.ordermanagement.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderDAO {
    OrderEntity save(OrderEntity order);
    Optional<OrderEntity> findById(Long id);
    List<OrderEntity> findAll();
    void deleteById(Long id);
}
