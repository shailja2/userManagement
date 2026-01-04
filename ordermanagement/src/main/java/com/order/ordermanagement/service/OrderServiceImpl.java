package com.order.ordermanagement.service;

import com.order.ordermanagement.dao.OrderDAO;
import com.order.ordermanagement.dto.OrderDTO;
import com.order.ordermanagement.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    private OrderEntity toEntity(OrderDTO dto) {
        return new OrderEntity(dto.getId(), dto.getProductName(), dto.getQuantity(), dto.getPrice());
    }

    private OrderDTO toDTO(OrderEntity entity) {
        return new OrderDTO(entity.getId(), entity.getProductName(), entity.getQuantity(), entity.getPrice());
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        OrderEntity saved = orderDAO.save(toEntity(orderDTO));
        return toDTO(saved);
    }

    @Override
    public Optional<OrderDTO> getOrder(Long id) {
        return orderDAO.findById(id).map(this::toDTO);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderDAO.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteOrder(Long id) {
        orderDAO.deleteById(id);
    }
}
