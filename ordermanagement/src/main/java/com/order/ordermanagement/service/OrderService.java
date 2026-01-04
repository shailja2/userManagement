package com.order.ordermanagement.service;

import com.order.ordermanagement.dto.OrderDTO;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDTO);
    Optional<OrderDTO> getOrder(Long id);
    List<OrderDTO> getAllOrders();
    void deleteOrder(Long id);
}
